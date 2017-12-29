package com.crm.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.crm.constant.LogType;
import com.crm.constant.OperateType;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLogMark {

	/*
	 * 描述
	 */
	public String remark() default "";
	/*
	 * 操作类型
	 */
	public OperateType operType() default OperateType.OTHER;
	/*
	 * 日志类型
	 */
	public LogType logType() default LogType.BUSINESS;
}
