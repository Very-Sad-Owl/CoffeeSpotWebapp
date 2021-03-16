<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;
    charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<link href="../css/edit_ingr_popup_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/ingredient_management.js"></script>

<div class="edit_ingredient_popup" id = "edit_ingredient_form">
  <h1>Edit</h1>
    <form name="editIngredientForm" id = "editIngredientForm">
        <%--<input type="hidden" name="command" value="registration" />--%>
        <input id = "ingr_title" type="text" name="title" placeholder="username*"/>
        <input id = "ingr_type" type="text" name="ingr_type" placeholder="ingr_type"/>
		<input id = "ingr_season_type" type="text" name="season_type" placeholder="season_type" />
		<input id = "ingr_price" type="number" step="0.01" name="price" placeholder="price" />
		<input id = "ingr_quantity" type="number" name="quantity" placeholder="quantity" />
        <button type="submit" id = "submit_changes">Submit</button>
        <div class = "error">
            <%--<br><p id = "error">${param.message}</p>--%>
        </div>
    </form>
</div>

<script>
    $("#submit_changes").on('submit',(function(e){
        e.preventDefault();
        $.ajax({
            url: "Controller?command=manageingredients&action=update",
            type: "POST",
            // data:  new FormData(this),
            success: function(data){
                alert(data);
            },
            error: function(){
                alert("error");
            }
        })
    }));
</script>



