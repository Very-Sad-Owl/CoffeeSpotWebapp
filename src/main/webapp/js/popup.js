function openForm() {
    document.getElementById("orderForm").style.display = "block";
    // document.getElementById("coffee_id").value = chosenId;
}

function closeForm() {
    document.getElementById("orderForm").style.display = "none";
}

// function updateCoast(increment) {
//     document.getElementById("total_coast").value += increment;
//
// }

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

function addDecor(id)
{
    var urlPattern;

    //Creating a new XMLHttpRequest object
    var xmlhttp;
    if (window.XMLHttpRequest){
        xmlhttp = new XMLHttpRequest(); //for IE7+, Firefox, Chrome, Opera, Safari
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); //for IE6, IE5
    }

    var selectedDecor = document.getElementById("decor"+id);

    if(selectedDecor.classList.contains("selected")){
        selectedDecor.classList.remove("selected");
        // urlPattern = "Controller?command=gotoindexpage&toOrder=0&removeDecor="+id;
        urlPattern = "Controller?command=gotoindexpage&toOrder=0&action=removeDecor&id="+id;
    } else {
        selectedDecor.classList.add("selected");
        urlPattern = "Controller?command=gotoindexpage&toOrder=0&action=addDecor&id="+id;
    }

    alert(urlPattern);
    //Create a asynchronous GET request
    xmlhttp.open("POST", urlPattern, true);

    //When readyState is 4 then get the server output
    xmlhttp.onreadystatechange = function()
    {
        if (xmlhttp.readyState == 4)
        {
            if (xmlhttp.status == 200)
            {
                var jsonObj = JSON.stringify(this.responseText).replace(/\\/g, "");
                var jso = JSON.parse(this.responseText);
                alert(urlPattern + jsonObj + jso["coast"]);
                document.getElementById("coast").textContent = jso["coast"];
                //selectedDecor.style.backgroundColor="gray";
            }
            else
            {
                alert('Something is wrong !!');
            }
        }
    };

    xmlhttp.send(null);
}


// function addDecor(coast, id) {
//     var coastField = document.getElementById("coast");
//     var currentCoast = parseFloat(coastField.innerHTML);
//     var selectedDecor = document.getElementById("decor"+id);
//
//     if(selectedDecor.classList.contains("selected")){
//         selectedDecor.classList.remove("selected");
//         currentCoast -= coast;
//     } else {
//         selectedDecor.classList.add("selected");
//         currentCoast += coast;
//     }
//
//     coastField.innerHTML = currentCoast;
// }

var prevValue = 1;
function setSize(myRadio) {
    var coastField = document.getElementById("coast");
    var currentCoast = parseFloat(coastField.innerHTML);

    currentCoast /= (prevValue === undefined ? 1 : prevValue);
    currentCoast *= myRadio.value;

    prevValue = myRadio.value;
    coastField.innerHTML = currentCoast;
}

