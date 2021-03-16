// function openForm(jsonStr) {
function openEditForm(title, itype, stype, quantity, price) {
//    var params = JSON.parse(jsonStr);
    //alert(jsonStr);
    document.getElementById("edit_ingredient_form").style.display = "block";

    // document.getElementById("ingr_title").value = params["title"];
    // document.getElementById("ingr_type").value = params["ingredientType"];
    // document.getElementById("ingr_season_type").value = params["seasonType"];
    // document.getElementById("ingr_price").value = params["price"];
    // document.getElementById("ingr_quantity").value = params["quantity"];

    document.getElementById("ingr_title").value = title;
    document.getElementById("ingr_type").value = itype;
    document.getElementById("ingr_season_type").value = stype;
    document.getElementById("ingr_price").value = price;
    document.getElementById("ingr_quantity").value = quantity;
}

// function checkConfirmation(toDelete) {
//     document.getElementById("confirmation_modal").style.display = "block";
//     document.getElementsByClassName("toDelete").textContent = toDelete;
//     document.getElementById("cancelbtn").formAction = "document.getElementById(\"confirmation_modal\").style.display = \"none\";";
//     document.getElementById("deletebtn").formAction = "deleteIngredient("+toDelete+")";
//     //deleteIngredient(toDelete);
// }

function closeForm() {
    document.getElementById("edit_ingredient_form").style.display = "none";
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

function deleteIngredient(id) {
    // document.getElementById("confirmation_modal").style.display = "none";
    var urlPattern;
    var xmlhttp = getXmlHttp();
    urlPattern = "Controller?command=manageingredients&action=delete&id="+id;

    xmlhttp.open("POST", urlPattern, true);
    xmlhttp.onreadystatechange = function()
    {
        if (xmlhttp.readyState == 4)
        {
            if (xmlhttp.status == 200)
            {
                alert(xmlhttp.responseText);
            }
            else
            {
                alert('Something is wrong !!');
            }
        }
    };

    xmlhttp.send(null);

}

function onIngrdientUpdate() {

    // $("#submit_changes").on('submit',(function(e){
    //     e.preventDefault();
    //     alert("hey");
    //     $.ajax({
            // url: "Servlet Path",
            // type: "POST",
            // data:  new FormData(this),
            // contentType: false,
            // cache: false,
            // processData:false,
            // success: function(data){
            //     alert(data);
            // },
            // error: function(){
            //     alert("error");
            // }
    //     })
    // }));

    // $(document).ready(function() {
    //     $('#submit_changes').click(function(){
    //         alert('#editIngredientForm').serialize();
    //         $.ajax({
    //             type:"POST",
    //             url : "Controller?command=manageingredients&action=update",
    //             data:$('#editIngredientForm').serialize() ,
    //             dataType: 'json',
    //             success : function(data){
    //                 //doing stuff
    //                 //end success
    //             }//,
    //             // always: function() {
    //             //     //submit form !!!
    //             //     $("#formtopost").submit();
    //             // }
    //         });
    //     });
    // });
}