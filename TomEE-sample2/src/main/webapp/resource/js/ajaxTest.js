let demoTag = document.getElementById("demo");
let showAreaTag = document.getElementById("showArea");
// 字串模板
demoTag.innerHTML = `<h2>This is an ajax demo at ${new Date().toLocaleString()}</h2>`

function doUpdate() {
	var req;
	if(window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	} else if (window.ActiveXObject){
		req = new ActiveXObject("Microsoft.XMLHTTP");
	} else {
		alert("AJAX not supported");
	}
	req.onreadystatechange = function() {
		if(req.readyState == 4 && req.status == 200) {
			showAreaTag.innerHTML = req.responseText;
		}
	}
	
	req.open("GET", "AjaxServlet", true);// open(method, url, async, user, password)
	
	req.send();
	
	
	}
	window.onload = function() {
			timeoutId = setInterval( function() {
				doUpdate();
			}, 1000)
}