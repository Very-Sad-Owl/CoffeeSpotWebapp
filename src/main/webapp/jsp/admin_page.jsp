<%--
  Created by IntelliJ IDEA.
  User: Xiaomi
  Date: 15.03.2021
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel='stylesheet' href='../css/admin_page_style.css' type='text/css' media='all'/>
<script type="text/javascript" src="../js/ingredient_management.js"></script>

<fmt:setLocale value = "${sessionScope.locale == null ? 'en' : sessionScope.locale}"/>
<fmt:setBundle basename="locale" var="loc"/>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin</title>
</head>
<body>

<div class="menu">
    <div id = "manage_orders">
        <fmt:message bundle="${loc}" key="locale.manage.orders"/>
    </div>
    <div id = "manage_menu">
        <fmt:message bundle="${loc}" key="locale.manage.menu"/>
    </div>
    <div id = "manage_users">
        <fmt:message bundle="${loc}" key="locale.manage.users"/>
    </div>
    <div id = "manage_ingredients"><a href="Controller?command=gotomanageingredientspage">
        <fmt:message bundle="${loc}" key="locale.manage.ingredients"/></a>
    </div>
</div>

</body>
</html>
