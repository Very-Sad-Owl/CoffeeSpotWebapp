<%@ page language="java" contentType="text/html;
    charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel='stylesheet' href='../css/order_style.css' type='text/css' media='all'/>

<div class="form-popup" id="orderForm">
  <form class="form-container">
    <h1>Order</h1>
    <h2 id = "coffee_title">${requestScope.chosen.type}</h2>

    <input type="hidden" id="coffee_id" name="coffee_id">

    <div class = "decorator_list">
      <div class="decoration_el">
        <c:forEach var="n" items="${requestScope.decoration}" varStatus="loop">
          <section class="decoration_element" id = "${loop.index}" onclick = "addDecor(${loop.index})">
              <img src="${'../'}${n.imgPath}" alt="${n.title}"
                   style="width:60px;height:60px;">
              <header>
                <p><c:out value="${n.title}${' - '}${n.coast}" /></p>
              </header>
          </section>
        </c:forEach>
      </div>
    </div>

    <div class = "size_list">
      <div class="size_el">
        <c:forEach var="n" items="${requestScope.sizes}" varStatus="loop">
          <section class="available_size_element" id = "${loop.index}">
            <header>
              <p id = "total_coast"><c:out value="${n.volume}${'ml'}" /></p>
            </header>
          </section>
        </c:forEach>
      </div>
    </div>

    <div class="total_coast">
      <span id = "coast"><c:out value="${'Total coast: '}${requestScope.chosen.coast}" /></span>
    </div>

    <button type="submit" class="btn">Submit</button>
    <button type="button" class="btn cancel" onclick="closeForm()">Cancel</button>
  </form>
</div>
