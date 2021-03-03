<%@ page language="java" contentType="text/html; 
    charset=utf-8"
	pageEncoding="utf-8"%>

<link href="../../css/logination_style.css" rel="stylesheet" type="text/css">
<div class="login">
  <h1>Login</h1>
    <form name="loginForm" method="post" action="Controller" autocomplete="off">
      <input type="hidden" name="command" value="logination" />
      <input type="text" name="login" placeholder="Username*" required="required" />
        <input type="password" name="password" placeholder="Password*" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Give me my coffee!</button>
    </form>
</div>

