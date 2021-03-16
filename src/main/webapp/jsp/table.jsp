<%--
  Created by IntelliJ IDEA.
  User: Xiaomi
  Date: 15.03.2021
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%--<script type="text/javascript" src="../js/ingredient_management.js"></script>--%>

<fmt:setLocale value = "${sessionScope.locale == null ? 'en' : sessionScope.locale}"/>
<fmt:setBundle basename="locale" var="loc"/>

<table class="styled-table">
    <thead>
    <tr>
        <c:forEach var="n" items="${requestScope.ingredient_columns}">
            <th>${n}</th>
        </c:forEach>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="n" items="${requestScope.ingredient_list}" varStatus="loop">
        <tr>
            <td>${n.title}</td>
            <td>${n.ingredientType}</td>
            <td>${n.seasonType}</td>
            <td>${n.price}</td>
            <td>${n.quantity}</td>
            <td>
                <img src="${'../'}${n.imgSource}" alt="${n.title}"/>
            </td>
            <th>
                <div >
                    <%--<button type="button" class="edit_ingr" onclick="openForm({--%>
                            <%--'title':'${n.title}',--%>
                            <%--'ingredientType':'${n.ingredientType}',--%>
                            <%--'seasonType':'${n.seasonType}',--%>
                            <%--'price':'${n.price}',--%>
                            <%--'quantity':'${n.quantity}'--%>
                            <%--})--%>
                            <button type="button" class="edit_ingr"
                             onclick="openEditForm('${n.title}','${n.ingredientType}','${n.seasonType}','${n.quantity}','${n.price}')">
                                <fmt:message bundle="${loc}" key="locale.edit.btn"/>
                            </button>
                    <button type="button" class="delete_ingr" onclick="deleteIngredient('${n.id}')">
                        <fmt:message bundle="${loc}" key="locale.delete.btn"/>
                    </button>
                </div>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
