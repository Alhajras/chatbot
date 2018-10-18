var vue_det = new Vue({
	el : '#chatbot-div',
	data : {
		robotMessages : [ {
			message : 'Welcome to our website, how can I help?',
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
			var self = this;
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
			$.ajax({
				type : "GET",
				url : "3W6bt8YUBbNmMS0IfnthtAHYt9JuVK/search/" + text,
				contentType : "application/json",
				success : function(e) {
					var currentDate = new Date();
					var currentTime = currentDate.getHours() + ":"
							+ currentDate.getMinutes();
					var robotResponse = {
						message : 'Please, take a look at this link: ',
						time : currentTime,
						robotResponse : true,
						url : e,
					};
					self.robotMessages.push(robotResponse);
				},
				error : function() {

				}
			});

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
