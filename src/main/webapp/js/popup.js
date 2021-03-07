function openForm(type) {
    document.getElementById("orderForm").style.display = "block";
    document.getElementById("coffee_title").innerHTML = type;
}

function closeForm() {
    document.getElementById("orderForm").style.display = "none";
}