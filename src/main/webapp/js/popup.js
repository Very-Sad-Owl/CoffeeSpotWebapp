function openForm() {
    document.getElementById("orderForm").style.display = "block";
    // document.getElementById("coffee_title").innerHTML = type;
}

function closeForm() {
    document.getElementById("orderForm").style.display = "none";
}

function updateCoast(increment) {
    document.getElementById("total_coast").value += increment;

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

function addDecor(id)
{
    var urlPattern = "Controller?command=gotoindexpage&toOrder=1&addDecor="+id;

    //Creating a new XMLHttpRequest object
    var xmlhttp;
    if (window.XMLHttpRequest){
        xmlhttp = new XMLHttpRequest(); //for IE7+, Firefox, Chrome, Opera, Safari
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); //for IE6, IE5
    }

    //Create a asynchronous GET request
    xmlhttp.open("POST", urlPattern, true);

    //When readyState is 4 then get the server output
    xmlhttp.onreadystatechange = function()
    {
        if (xmlhttp.readyState == 4)
        {
            if (xmlhttp.status == 200)
            {
                // document.getElementById("coast").innerHTML = xmlhttp.responseText;
                alert(urlPattern + xmlhttp.responseText);
            }
            else
            {
                alert('Something is wrong !!');
            }
        }
    };

    xmlhttp.send(null);
}

