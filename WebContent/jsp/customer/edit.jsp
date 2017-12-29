<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>编辑客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css rel=stylesheet>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="${pageContext.request.contextPath }/customer/editCustomer.action" method=post>
		<input type="hidden" name="custId" value="${customer.custId}">
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
								<TD class=manageHead>当前位置：客户管理 &gt; 编辑客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<TR>
								<td>客户名称：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="customer.custName" value="${customer.custName}">
								</td>
								<td>所属行业 ：</td>
								
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="customer.custIndustry" value="${customer.custIndustry}">
								</td>
							</TR>							
							<TR>	
								<td>信息来源 ：</td>
								<td>
									<select name="dictId" class=textbox id=sChannel2 style="WIDTH: 180px">
										<option value="non">---请选择---</option>
										<option value="6" ${customer.baseDict.dictId=="6"?"selected":""}>电话营销</option>
										<option value="7" ${customer.baseDict.dictId=="7"?"selected":""}>网络营销</option>
									</select>
								</td>
								<td>客户级别：</td>
								<td>
									<select name="customer.custLevel" class=textbox id=sChannel2 style="WIDTH: 180px">
										<option value="non">---请选择---</option>
										<option value="22" ${customer.custLevel=="22"?"selected":""}>普通客户</option>
										<option value="23" ${customer.custLevel=="23"?"selected":""}>VIP客户</option>
									</select>								
								</td>
							</TR>
							<TR>
								<td>联系地址 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="customer.custAddress" value="${customer.custAddress}">
								</td>
								<td>邮政编码 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="customer.custZip" value="${customer.custZip}">
								</td>
							</TR>
							<TR>
								<td>联系电话 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="customer.custPhone" value="${customer.custPhone}">
								</td>
								<td>客户传真 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="customer.custFax" value="${customer.custFax}">
								</td>
							</TR>
							<TR>
								<td>客户网址 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="customer.custWebsite" value="${customer.custWebsite}">
								</td>
								<td>企业法人 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="customer.custCorporation" value="${customer.custCorporation}">
								</td>
							</TR>
							<TR>
								<td>客户描述 ：</td>
								<td colspan="2">
									<textarea rows="5" cols="30" class=textbox id=sChannel2 style="WIDTH: 180px"  name="customer.custMemo">
										${customer.custMemo}
									</textarea>
								</td>
							</TR>
							<tr>
								<td rowspan=2>
									<INPUT class=button id=sButton2 type=submit value=" 保存 " name=sButton2>
								</td>
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
</BODY>
</HTML>
