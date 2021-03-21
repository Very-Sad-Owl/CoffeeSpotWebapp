<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;
    charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<link href="../css/edit_ingr_popup_style.css" rel="stylesheet" type="text/css">
<link rel='stylesheet' href='../css/ingredient_form_style.css' type='text/css' media='all'/>
<%--<script type="text/javascript" src="../js/ingredient_management.js"></script>--%>'
<script src="http://code.jquery.com/jquery-2.2.4.js"
        type="text/javascript"></script>
<script type="text/javascript" src="../js/scripts.js"></script>

<div class="edit_ingredient_popup" id = "edit_ingredient_popup">
  <h1>Edit</h1>
    <form class="edit_ingredient" id="edit_ingredient" onsubmit="return onIngrdientUpdate(this)" method="post">

        <input id = "original_ingr_title" name="orig_title" type="hidden"/>

        <label for="ingr_title">Title</label>
        <input id = "ingr_title" type="text" name="title" placeholder="ingr_title"/>

        <label for="ingr_type">Ingredient type</label>
        <input id = "ingr_type" type="text" name="ingr_type" placeholder="ingr_type"/>

        <label for="ingr_season_type">For season</label>
		<input id = "ingr_season_type" type="text" name="season_type" placeholder="season_type"/>

        <label for="ingr_price">Price</label>
		<input id = "ingr_price" type="number" step="0.01" name="price" placeholder="price" />

        <label for="ingr_quantity">Quantity</label>
		<input id = "ingr_quantity" type="number" name="quantity" placeholder="quantity" />

        <label for="ingr_img">Image source</label>
		<input id = "ingr_img" type="text" name="img" placeholder="image" />

        <button type="submit" id = "submit_changes" class="btn ok">Submit</button>
        <button type="button" id="cancel_changes" class="btn cancel" onclick="closeEditForm()">Cancel</button>
        <div class = "error">
            <%--<br><p id = "error">${param.message}</p>--%>
        </div>
    </form>
</div>




