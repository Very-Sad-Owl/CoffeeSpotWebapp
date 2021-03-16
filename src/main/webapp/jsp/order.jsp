<%@ page language="java" contentType="text/html;
    charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<link rel='stylesheet' href='../css/order_style.css' type='text/css' media='all'/>

<%--<fmt:setLocale value = "${sessionScope.locale}"/>--%>
<fmt:setBundle basename="locale" var="loc"/>

<div class="form-popup" id="orderForm">
  <form class="form-container">
    <h1>Order</h1>
    <h2 id = "coffee_title">${requestScope.chosen.type}</h2>

    <input type="hidden" id="coffee_id" name="coffee_id">

    <div class = "decorator_list">
      <div class="decoration_el">
        <c:forEach var="n" items="${requestScope.decoration}" varStatus="loop">

          <c:if test="${n.title == 'sugar'}">
            <section class="decoration_element" id = "${loop.index}">
              <img src="${'../'}${n.imgPath}" alt="${n.title}"
                   style="width:60px;height:60px;">
              <header>
                <p><c:out value="${n.title}${' - '}${n.coast}" /></p>
              </header>
              <div class="slider">
                <%--<input type="range" min="0" max="5" value="0" class="slider" id="sugar_slider" onchange = "addDecor(${n.coast}, ${loop.index})">--%>
                <input type="range" min="0" max="5" value="0" class="slider" id="sugar_slider" onchange = "addDecor(${loop.index})">
              </div>
            </section>
          </c:if>

          <c:if test="${n.title != 'sugar'}">
            <%--<section class="decoration_element" id = "${"decor"}${loop.index}" onclick = "addDecor(${n.coast}, ${loop.index})">--%>
            <section class="decoration_element" id = "${"decor"}${loop.index}" onclick = "addDecor(${loop.index})">
            <img src="${'../'}${n.imgPath}" alt="${n.title}"
                 style="width:60px;height:60px;">
            <header>
              <p><c:out value="${n.title}${' - '}${n.coast}" /></p>
            </header>
          </section>
          </c:if>
        </c:forEach>
      </div>
    </div>

    <div class = "size_list">
      <div class="size_el">
        <c:forEach var="n" items="${requestScope.sizes}" varStatus="loop">
          <%--<section class="available_size_element" id = "${"size"}${loop.index}" onclick="setSize(${n.increment}, ${loop.index})">--%>
            <%--<header>--%>
              <%--<p id = "total_coast"><c:out value="${n.volume}${'ml'}" /></p>--%>
            <%--</header>--%>
          <%--</section>--%>
          <c:choose>
            <c:when test="${loop.index == 0}">
              <input type="radio" id = "${"size"}${loop.index}"
                     name="size" value="${n.increment}" checked onclick="setSize(this)">
              <label for="${"size"}${loop.index}">${n.volume}${'ml'}</label>
            </c:when>
            <c:when test="${loop.index != 0}">
              <input type="radio" id = "${"size"}${loop.index}"
                     name="size" value="${n.increment}" onclick="setSize(this)">
              <label for="${"size"}${loop.index}">${n.volume}${'ml'}</label>
            </c:when>
          </c:choose>

        </c:forEach>
      </div>
    </div>

    <div class="total_coast">
      <span id = "coast"><c:out value="${requestScope.chosen.coast}"/></span>
    </div>

    <%--<button type="submit" class="btn"><fmt:message bundle="${loc}" key="local.about"/></button>--%>
    <button type="submit" class="btn">Submit</button>
    <a href="Controller?command=gotoindexpage"><button type="button" class="btn cancel" onclick="closeForm()">Cancel</button></a>
  </form>
</div>
