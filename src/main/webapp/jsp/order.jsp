<%@ page language="java" contentType="text/html;
    charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel='stylesheet' href='../css/order_style.css' type='text/css' media='all'/>

<div class="form-popup" id="orderForm">
  <form class="form-container">
    <h1>Order</h1>
    <h2 id = "coffee_title">Some coffee</h2>

    <input type="hidden" id="coffee_id" name="coffee_id">


    <input type="password" placeholder="Enter Password" name="psw" required>

    <button type="submit" class="btn">Submit</button>
    <button type="button" class="btn cancel" onclick="closeForm()">Cancel</button>
  </form>
</div>
