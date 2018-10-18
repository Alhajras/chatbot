<!DOCTYPE html>
<html>
<head>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link type="text/css"
	href="css/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link type="text/css" href="css/fe-login.css" rel="stylesheet" />
<script type="text/javascript" src="js/vue.js"></script>
<script type="text/javascript" src="js/require.js"></script>
<script type="text/javascript"
	src="js/elasticsearch-js/elasticsearch.js"></script>
<script type="text/javascript"
	src="js/elasticsearch-js/elasticsearch.jquery.js"></script>

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>

<!------ Include the above in your HEAD tag ---------->
</head>
<body>
	<!-- this is for a demo only -->
	<!-- 	<iframe src="https://www.haw-hamburg.de/startseite.html" -->
	<!-- 		style="width: 1800px; height: 1500px;"></iframe> -->
	<!-- 		end of the demo -->
	<div id="chatbot-div">
		<div v-if="!iconMode">
			<div class="row chat-window col-xs-5 col-md-3" id="chat_window_1"
				style="margin-left: 10px; position: fixed; bottom: 0; right: 0;">
				<div class="col-xs-12 col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading top-bar">
							<div class="col-md-8 col-xs-8">
								<h3 class="panel-title">
									<span class="glyphicon glyphicon-comment"></span> HAW-Chatbot
								</h3>
							</div>
							<div class="col-md-4 col-xs-4" style="text-align: right;">
								<a href="#"><span id="minim_chat_window"
									class="glyphicon glyphicon-minus icon_minim"></span></a> <a
									href="#"><span v-on:click="changeMode"
									class="glyphicon glyphicon-remove icon_close"
									data-id="chat_window_1"></span></a>
							</div>
						</div>
						<div id = "chat_window" class="panel-body msg_container_base">
							<div v-for="(email, index) in robotMessages">
								<div v-if="!email.robotResponse"
									class="row msg_container base_sent">
									<div class="col-md-10 col-xs-10">
										<div class="messages msg_sent">
											<p>{{email.message}}</p>
											<time datetime="2009-11-13T20:00">{{email.time}}</time>
										</div>
									</div>
									<div class="col-md-2 col-xs-2 avatar">
										<img style="border-radius: 50%;"
											src="css/images/unknown-user.png" class=" img-responsive ">
									</div>
								</div>

								<div id="robotIsWriting"></div>

								<div v-if="email.robotResponse"
									class="row msg_container base_receive">
									<div class="col-md-2 col-xs-2 avatar">
										<img style="border-radius: 50%;"
											src="css/images/chatbot-icon.jpg" class=" img-responsive ">
									</div>
									<div class="col-md-10 col-xs-10">
										<div class="messages msg_receive">
											<a>{{email.message}}</a> <a v-if="email.url != '' "
												v-bind:href="email.url">{{email.url}}</a>
											<time datetime="2009-11-13T20:00">{{email.time}}</time>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="panel-footer">
							<div class="input-group">
								<input v-on:keyup.enter="sendMessage" id="btn-input" type="text"
									class="form-control input-sm chat_input"
									placeholder="Write your message here..." /> <span
									class="input-group-btn">
									<button class="btn btn-primary btn-sm" id="btn-chat"
										v-on:click="sendMessage">Send</button>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

		<div v-if="iconMode" v-on:click="changeMode"
			style="height: 100px; width: 100px; position: fixed; bottom: 0; right: 0;">
			<a href="#"><img src="css/images/chatbot-icon2.jpg"
				alt="Italian Trulli" width="100" height="100"></a>
		</div>
	</div>
</body>
<script type="text/javascript" src="js/fe-js/fe-chatbot.js"></script>
</html>

