function openAddForm() {
    document.getElementById("add_ingredient_popup").style.display = "block";
}
function openEditForm(title, itype, stype, quantity, price, img) {
    document.getElementById("edit_ingredient_popup").style.display = "block";

    document.getElementById("original_ingr_title").value = title;
    document.getElementById("ingr_title").value = title;
    document.getElementById("ingr_type").value = itype;
    document.getElementById("ingr_season_type").value = stype;
    document.getElementById("ingr_price").value = price;
    document.getElementById("ingr_quantity").value = quantity;
    document.getElementById("ingr_img").value = img;
}

function closeEditForm() {
    document.getElementById("edit_ingredient_popup").style.display = "none";
}

function closeAddForm() {
    document.getElementById("add_ingredient_popup").style.display = "none";
}

function getXmlHttp(){
    var xmlhttp;
    try {
        xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (e) {
        try {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (E) {
            xmlhttp = false;
        }
    }
    if (!xmlhttp && typeof XMLHttpRequest!='undefined') {
        xmlhttp = new XMLHttpRequest();
    }
    return xmlhttp;
}

function deleteIngredient(title) {
    var urlPattern;
    var xmlhttp = getXmlHttp();
    urlPattern = "Controller?command=manageingredients&action=delete&title="+title;

    xmlhttp.open("POST", urlPattern, true);
    xmlhttp.onreadystatechange = function()
    {
        if (xmlhttp.readyState == 4)
        {
            if (xmlhttp.status == 200)
            {
                alert(xmlhttp.responseText);
                var row = document.getElementById(title);
                row.parentNode.removeChild(row);
            }
            else
            {
                alert('Something is wrong !!');
            }
        }
    };

    xmlhttp.send(null);

}

function onIngrdientUpdate(f) {
    $.ajax({
        url : 'Controller?command=manageingredients&action=update',     // URL - сервлет
        data: $("#edit_ingredient").serialize(),
        success : function(response) {
            alert(response);
            closeForm();
        },
        error: function(response){
            alert('request failed');
        }
    });

    return false;
}

function onAddIngredietnt(f) {
    $.ajax({
        url : 'Controller?command=manageingredients&action=add',
        data: $("#add_ingredient").serialize(),
        success : function(response) {
            alert(response);
            closeForm();
        },
        error: function(response){
            alert('request failed');
        }
    });

    return false;
}

