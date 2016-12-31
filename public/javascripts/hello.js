if (window.console) {
    console.log("Welcome to your Play application's JavaScript!");
}

var email = document.querySelector("#email");
var saveBtn = document.querySelector("#btn");
saveBtn.onclick = function() {
    var xhr = new XMLHttpRequest();
    if (email.value == '') {
	alert("Поле с email пусто :(");
    } else {
	var body = 'email=' + email.value ;
	xhr.open("PUT", '/add', true)
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
	xhr.send(body);
	alert("Спасибо! А теперь к столу!")
    }
}
