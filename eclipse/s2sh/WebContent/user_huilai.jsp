<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 

<title>Insert title here</title>
</head>
<body>
 <form action="/s2sh/userAction_findLeave">
<input type="submit" value="查询">
</form>

<table width="242" height="256" border="1" cellpadding="1"
                           cellspacing="1">
                           
                         <tr>
                          <th>
                                 姓名
                              </th>
                             <th>
                                  学号
                              </th>
                              <th>
                                  行李
                              </th>
                              <th>
                                 原因
                              </th>
         
                              <th>
                                离校时间
                              </th>
                              <th>
                               操作
                              </th>
                          </tr>
                         <s:iterator var="u" value="list">
                             <%--
          <s:iterator  id="別名"  value="要遍历的集合">
         users:对应后台Action类的List<UserEntity> users;
          --%>
                              <tr>
                                 <%--<td><s:property value="#別名.实体类属性名" /></td>--%>
                                  <td>
                                      <s:property value="#u.name" />
                                  </td>
                                  <td>
                                     <s:property value="#u.number" />
                                  </td>
                                  <td>
                                      <s:property value="#u.package_" />
                                  </td>
                                  <td>
                                      <s:property value="#u.reason" />
                                  </td>
                                  <td>
                                      <s:property value="#u.leaveDate" />
                                  </td>
                                  <td>
                                  <form action="/s2sh/userAction_delLeave" method="post">
                                  <input type="hidden" name="leave.id" value="<s:property value="#u.id" />">
                                  <input type="submit" value="返校">
                                  </form>
                                       
                                  </td>
                                   
                              </tr>
                          </s:iterator>
                    </table>
</body>
</html>