<%@ page language="java" contentType="text/html; 
    charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="../css/logination_style.css" rel="stylesheet" type="text/css">
<div class="login">
  <h1>Login</h1>
    <form name="loginForm" method="post" action="Controller" autocomplete="off">
      <input type="hidden" name="command" value="logination" />
      <input type="text" name="login" placeholder="Username*" required="required" />
        <input type="password" name="password" placeholder="Password*" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Give me my coffee!</button>
    </form>
  <div class = "message">
    <%--<c:set var="test" value="nosuchuser"/>--%>
    <%--<c:if test="${test==param.message}">--%>
      <%--<br><p id = "error">There is no such user.</p>--%>
    <%--</c:if>--%>
      <br><p id = "error">${param.message}</p>
  </div>
</div>

