var vue_det = new Vue({
	el : '#chatbot-div',
	data : {
		robotMessages : [ {
			message : 'Welcome to our website how can I help?',
			time : '',
			robotResponse : true
		} ],
		iconMode : true
	},
	methods : {
		init : function(event) {
			var currentdate = new Date();
			var time = currentdate.getHours() + ":" + currentdate.getMinutes();
			this.robotMessages[0].time = time;
		},
		changeMode : function() {
			this.iconMode = !this.iconMode;
		},

		sendMessage : function() {
			var text = document.getElementById("btn-input").value;
			// Not sending an empty message to the backEnd
			if (!text)
				return;
			var currentDate = new Date();
			var currentTime = currentDate.getHours() + ":"
					+ currentDate.getMinutes();
			var messageVar = {
				message : text,
				time : currentTime,
				robotResponse : false
			};
			this.robotMessages.push(messageVar);
			document.getElementById("btn-input").value = '';

			// var obj = '{' + '"name" : "Raj",' + '"age" : 32,'
			// + '"married" : false' + '}';
			// console.log(obj);
			// $.ajax({
			// type : "GET",
			// url : "localhost:9200/articles/_search",
			// contentType : "application/json",
			// data : JSON.parse(obj),
			// success : function(e) {
			// console.log(e);
			// },
			// error : function() {
			//
			// }
			// });

		},

	}
})

vue_det.init() // -> initialising the vue

$(document).on('click', '.panel-heading span.icon_minim', function(e) {
	var $this = $(this);
	if (!$this.hasClass('panel-collapsed')) {
		$this.parents('.panel').find('.panel-body').slideUp();
		$this.addClass('panel-collapsed');
		$this.removeClass('glyphicon-minus').addClass('glyphicon-plus');
	} else {
		$this.parents('.panel').find('.panel-body').slideDown();
		$this.removeClass('panel-collapsed');
		$this.removeClass('glyphicon-plus').addClass('glyphicon-minus');
	}
});
$(document).on(
		'focus',
		'.panel-footer input.chat_input',
		function(e) {
			var $this = $(this);
			if ($('#minim_chat_window').hasClass('panel-collapsed')) {
				$this.parents('.panel').find('.panel-body').slideDown();
				$('#minim_chat_window').removeClass('panel-collapsed');
				$('#minim_chat_window').removeClass('glyphicon-plus').addClass(
						'glyphicon-minus');
			}
		});
$(document).on('click', '#new_chat', function(e) {
	var size = $(".chat-window:last-child").css("margin-left");
	size_total = parseInt(size) + 400;
	alert(size_total);
	var clone = $("#chat_window_1").clone().appendTo(".container");
	clone.css("margin-left", size_total);
});
$(document).on('click', '.icon_close', function(e) {
	// $(this).parent().parent().parent().parent().remove();
	$("#chat_window_1").remove();
});

function createCORSRequest(method, url) {
	var xhr = new XMLHttpRequest();
	if ("withCredentials" in xhr) {

		// Check if the XMLHttpRequest object has a "withCredentials" property.
		// "withCredentials" only exists on XMLHTTPRequest2 objects.
		xhr.open(method, url, true);

	} else if (typeof XDomainRequest != "undefined") {

		// Otherwise, check if XDomainRequest.
		// XDomainRequest only exists in IE, and is IE's way of making CORS
		// requests.
		xhr = new XDomainRequest();
		xhr.open(method, url);

	} else {

		// Otherwise, CORS is not supported by the browser.
		xhr = null;

	}

	return xhr;
}

//var url = 'http://localhost:9200/articles/_search';
//var xhr = createCORSRequest('GET', url);
//xhr.send();
//if (!xhr) {
//	throw new Error('CORS not supported');
//}

// var elasticsearch = 'js/elasticsearch-js/elasticsearch.js';
// require([ elasticsearch ], function(fooModule) {
// var client = new elasticsearch.Client({
// host : 'localhost:9200',
// log : 'trace'
// });
// client.search({
// q : 'chatcot'
// }).then(function(body) {
// var hits = body.hits.hits;
// }, function(error) {
// console.trace(error.message);
// });
// })
