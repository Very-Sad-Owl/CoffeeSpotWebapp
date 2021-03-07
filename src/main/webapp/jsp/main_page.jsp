<%@ page language="java" contentType="text/html;
    charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en-US">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>GoDot</title>
<script src="../js/popup.js"></script>
<jsp:include page="order.jsp" />
<link rel='stylesheet' href='../css/main_style.css' type='text/css' media='all'/>
<link rel='stylesheet' href='../css/order_style.css' type='text/css' media='all'/>
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Oswald:400,500,700%7CRoboto:400,500,700%7CHerr+Von+Muellerhoff:400,500,700%7CQuattrocento+Sans:400,500,700' type='text/css' media='all'/>
<!-- <link rel='stylesheet' href='css/easy-responsive-shortcodes.css' type='text/css' media='all'/> -->
</head>
<body class="home page page-template page-template-template-portfolio page-template-template-portfolio-php">
<div id="page">
	<div class="container">
		<header id="masthead" class="site-header">
		<div class="site-branding">
			<h1 class="site-title">
				<a href="Controller?command=gotoindexpage" rel="home">
					<img alt="Logo" src="../resources/image/logo.png"
					width="20%" height="20%">
				</a>
			</h1>
			<!-- <h2 class="site-description">Good coffee is never far away!</h2> -->
		</div>
		<nav id="site-navigation" class="main-navigation">
		<button class="menu-toggle">Menu</button>
		<a class="skip-link screen-reader-text" href="#content">Skip to content</a>
		<div class="menu-menu-1-container">
			<ul id="menu-menu-1" class="menu">
				<li><a href="Controller?command=gotoindexpage">Home</a></li>
				<li><a href="coming soon ..">About</a></li>
				<li><a href="coming soon ..">Shop</a></li>
				<li><a href="coming soon ..">Blog</a></li>
				<li><a href="coming soon ..">Elements</a></li>
				<li><a href="#">Account</a>
				<ul class="sub-menu">
					<c:if test="${sessionScope.auth == true}">
						<li><a href="Controller?command=logout">Logout</a></li>
						<li><a href="coming soon ..">Account</a></li>
					</c:if>
					<c:if test="${sessionScope.auth == false || sessionScope.auth == null}">
						<li><a href="Controller?command=gotologinationpage">Login</a></li>
						<li><a href="Controller?command=gotoregistrationpage">Register</a></li>
					</c:if>

				</ul>
				</li>
				<li><a href="coming soon ..">Contact</a></li>
			</ul>
		</div>
		</nav>
		</header>

		<div class = "coffee_list">
			<div class="coffee_type_el">
				<c:forEach var="n" items="${requestScope.coffee}" varStatus="loop">

					<section class="coffee_element" id = "${loop.index}">
						<a class="open-button" onclick="openForm('${n.type}')">
						<img src="${'../'}${n.imgPath}" alt="${n.type}"
						style="width:100px;height:100px;">
						<header>
							<p><c:out value="${n.type}${' - '}${n.coast}" /></p>
						</header>
						</a>
					</section>

					<%--</a>--%>
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- .container -->
	<footer id="colophon" class="site-footer">
	<div class="container">
		<div class="site-info">
			<h1 style="font-family: 'Herr Von Muellerhoff';color: #ccc;font-weight:300;text-align: center;margin-bottom:0;margin-top:0;line-height:1.4;font-size: 46px;">Moschino</h1>
			 <a target="blank" href="https://www.wowthemes.net/">&copy; Good coffee is never far away!</a>
		</div>
	</div>	
	</footer>
	<a href="#top" class="smoothup" title="Back to top"><span class="genericon genericon-collapse"></span></a>
</div>
<!-- #page -->
<script src='../js/jquery.js'></script>
<script src='../js/plugins.js'></script>
<script src='../js/scripts.js'></script>
<script src='../js/masonry.pkgd.min.js'></script>
</body>
</html>