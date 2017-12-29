<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户拜访</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css rel=stylesheet>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/locale/easyui-lang-zh_CN.js"></script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="${pageContext.request.contextPath}/salevisit/addSaleVisit.action" method=post>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg" border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg" height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_022.jpg">
						<IMG src="${pageContext.request.contextPath }/images/new_022.jpg" border=0>
					</TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户拜访管理 &gt; 添加拜访记录 </TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>						
						<table cellpadding="5">
						  	<tr>
						  		<td>客户:</td>
						  		<td>
							  		<s:select id="custId" list="cstCustomers" name="saleVisit.cstCustomer.custId" listKey="custId" listValue="custName" headerKey="" headerValue="-请选择-"></s:select>	
						  		</td>
						  		<td>业务员:</td>
						  		<td>
						  			<s:select id="userId" list="sysUsers" name="saleVisit.sysUser.userId" listKey="userId" listValue="userName" headerKey="" headerValue="-请选择-"></s:select>	
						  		</td>
						  	</tr>
						  	<tr>
						  		<td>被拜访人:</td>
						  		<td><input id="visitedPerson" name="saleVisit.visitInterviewee" style="width:150px;"/></td>
						  		<td>拜访时间:</td>
						  		<td><input name="saleVisit.visitTime" class="easyui-datetimebox" style="width:150px;"/></td>
						  	</tr>
						  	<tr>
						  		<td>拜访地址:</td>
						  		<td colspan="3"><input name="saleVisit.visitAddr" style="width:400px;"/></td>
						  	</tr>
						  	<tr>
						  		<td>内容:</td>
						  		<td colspan="3"><input name="saleVisit.visitDetail" style="width:400px;"/></td>
						  	</tr>
						  		<tr>
						  		<td>下次拜访时间:</td>
						  		<td colspan="3"><input name="saleVisit.visitNexttime" class="easyui-datetimebox" style="width:150px;"/></td>
						  	</tr>
						  	<tr>
						  		<td colspan="4"><button id="customerBtn" type="submit" >保存</button></td>
						  	</tr>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
						<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg" border=0></TD>
					<TD align="center" width="100%" background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"	border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
	<script type="text/javascript">
		$(function(){
			$("#customerBtn").on("click",function(){
				// 客户
				var cust = $("#custId option:selected").val();
				if(null == cust || cust==""){
					alert("客户不能为空！");
					return false;
				}
				//业务员
				var user = $("#userId option:selected").val();
				if(null == user || user == ""){
					alert("业务员不能为空！");
					return false;
				}
				//
				var visited = $("#visitedPerson").val();
				if(null == visited || visited == ""){
					alert("被拜访人不能为空！");
					return false;
				}
				$("#form1").submit();
			});
		})
	</script>
</BODY>
</HTML>
