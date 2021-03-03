<%@ page language="java" contentType="text/html; 
    charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<link href="../../css/logination_style.css" rel="stylesheet" type="text/css">
<body>

<!-- <div class="fullscreen-bg"> -->
    <!-- <video width="100%" height="auto" playsinline autoplay muted loop poster="../../resources/image/auth_bak.jpg" id="bgvid"> -->
			<!-- <source src="../../resources/video/auth.webm" type="video/webm"> -->
			<!-- <source src="../../resources/video/auth.mp4" type="video/mp4"> -->
	<!-- </video> -->
<!-- </div> -->

<div class="login">
  <h1>Login</h1>
    <form method="post">
        <input type="hidden" name="command" value="registration" />
        <input type="text" name="login" placeholder="username*" required="required" />
        <input type="password" name="password" placeholder="password*" required="required" />
		<input type="email" name="email" placeholder="email" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Give me my coffee!</button>
    </form>
</div>
</body>


