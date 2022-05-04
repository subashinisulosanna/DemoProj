<%--
  Created by IntelliJ IDEA.
  User: Subashini
  Date: 5/1/2022
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form action="success">
    <s:textfield label="Enter your email " name="email" />
    <s:textfield label="Enter your password " name="password" />
    <s:submit />
</s:form>
</body>
</html>
