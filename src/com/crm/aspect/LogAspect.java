package com.crm.aspect;

import java.beans.PropertyEditorSupport;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.crm.domain.SysLog;
import com.crm.domain.SysUser;
import com.crm.service.LogService;
import com.crm.utils.SystemLogMark;

/**
 * 定义一个实现日志记录的切面
 * @author zhang
 *
 */
public class LogAspect {
	/**
	 * Logger For This Class
	 */
	private static final Logger log = Logger.getLogger(LogAspect.class);
	
	@Autowired
	private LogService logService;
	
	// 初始化记录
	public LogAspect() {
		if(log.isInfoEnabled()){
			log.info("LogAspect拦截记录日志信息=========");
		}
	}

	// 定义切点
	@Pointcut("@annotation(com.crm.utils.SystemLogMark)")
	public void serviceMethod(){};
	
	@After("serviceMethod()")
	public void doAfter(JoinPoint joinPoint) {
		try {
			// 创建日志记录对象
			SysLog log = new SysLog();
			// 获取request对象
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			// 获取当前登录对象
			SysUser sysUser = (SysUser)request.getSession().getAttribute("loginedUser");
			// 用户信息：用户ID、用户名
			if(sysUser == null) {
				log.setUserId("");
				log.setRealName("匿名用户");
			}else {
				log.setUserId(sysUser.getUserId().toString());
				log.setRealName(sysUser.getUserName());
			}
			// 请求IP地址
			log.setLoginIP(getIpAddr(request));
			// 设置其他日志信息
			setAnnoedMethodInfo(joinPoint, log);
			// 保存日志
			logService.addLog(log);
		} catch(Exception e) {
			e.printStackTrace();
			log.error("日志记录失败",e);
		}
	}
	
	// 根据JoinPoint来获取注解方法的信息
	public static void setAnnoedMethodInfo(JoinPoint point, SysLog log) throws ClassNotFoundException {
		// 目标类名
		String targetName = point.getTarget().getClass().getName();
		// 目标方法签名
		String methodName = point.getSignature().getName();
		// 代理类
		String packages = point.getThis().getClass().getName();
		// 获取类路径
		if(packages.indexOf("$$EnhancerBySpringCGLIB$$")>0) { // 是否为CGLIB实现的动态代理
			packages = packages.substring(0, packages.indexOf("$$"));
		}
		packages = packages.substring(0,packages.indexOf("@"));
		// 获取请求参数
		Object[] args = point.getArgs();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < args.length; i++) {
			buffer.append("参数"+i+":"+args[i]+" ");
		}
		log.setArgs(buffer.toString());
		log.setOperateMethod(packages+" "+methodName);
		// 获取目标方法对象
		Class<?> clazz = Class.forName(targetName);
		for(Method method : clazz.getMethods()){
			if(methodName.equals(method.getName())){
				if(method.getParameterTypes().length == args.length){
					SystemLogMark anno = method.getAnnotation(SystemLogMark.class);
					if(anno!=null) {
						log.setRemark(anno.remark());
						log.setLogType(anno.logType());
						log.setOperType(anno.operType());
					}
				}
			}
		}
	}
	
	// 获取IP地址
	public static String getIpAddr(HttpServletRequest request) {
		String ipAddress = null;
		// ipAddress = request.getRemoteAddr();
		ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				if (inet != null)
					ipAddress = inet.getHostAddress();
			}

		}

		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
															// = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}
}
