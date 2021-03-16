<%--
  Created by IntelliJ IDEA.
  User: Xiaomi
  Date: 15.03.2021
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header id="masthead" class="site-header">
    <%--<div class="site-branding">--%>
        <%--<h1 class="site-title">--%>
            <%--<a href="Controller?command=gotoindexpage" rel="home">--%>
                <%--<img alt="Logo" src="../resources/image/logo.png"--%>
                     <%--height="10%" width="auto">--%>
            <%--</a>--%>
        <%--</h1>--%>
        <%--<!-- <h2 class="site-description">Good coffee is never far away!</h2> -->--%>
    <%--</div>--%>
        <jsp:include page="logo.jsp"/>
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
