$("#load").click(function() {
	$("#showArea").load(
		"AjaxQueryServlet", // url 
		{name: "阿丁"},		// parameter
		 function(responseText, textStatus, jqXHR){}	
	)	
})

$("#get").click(function() {
	$.get(
		"AjaxQueryServlet", // url
		{name: "阿花"}, 		// parameter
		function(data) {
			$("#showArea1").text(data.name + ", " + data.courses + ", " + data.price);
		},
		"json"
	)
})

$("#json").click(function() {
	$. getJSON(
		"AjaxQueryServlet", // url
		{name: "阿奇"}, 		// parameter
		function(data) {
			$("#showArea2").text(data.name + ", " + data.courses + ", " + data.price)
		}
	)
})

$("#post").click(function() {
	$.post(
		"AjaxQueryServlet", // url
		{name: "阿呆"}, 		// parameter
		function(data) {
			$("#showArea3").text(data.name + ", " + data.courses + ", " + data.price);
		},
		"json"
	)
})

//----------------------------------------------------------------------------------------
$.ajax({
	type: "POST",
	url: "AjaxQueryServlet",
	data: {name: "Peter Parker"},
	dataType: "json",
	success: function(data) {
		$("#showArea4").text(data.name + ", " + data.courses + ", " + data.price);
	},
	error: function(msg) {
		alert("error: " + msg);
	},
	complete: function(jqXHR) {
		alert("complete: " + jqXHR.status + " / " + jqXHR.statusText + " / " + jqXHR.responseText);
	}
	
})

$(document).ready(function() {
	$(document)
		.ajaxStart(function() { $("#loading").show()})
		.ajaxComplete(function() {$("#loading").hide()})
})