<jsp:include page="./Header.jsp" >
	<jsp:param name="title" value="入力" />
</jsp:include>

<jsp:useBean id="HelloBean" class="jp.co.test.bean.HelloBean" scope="request" />

<%@ taglib uri="http://jp.co.sample/hello-taglib_1_0" prefix="hello" %>

<link rel="stylesheet" href="/HelloProject/css/jquery-ui.css" >
<style type="text/css">
<!--
//-->
</style>

<script type="text/javascript" src="/HelloProject/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/HelloProject/js/jquery.ui.datepicker-ja.min.js"></script>

<body onload="onLoad();">
<form name="f" method="post" action="./TestHelloServlet">
	<input type="hidden" name="screenId" value="SCR0002">
	<%
		String sql = HelloBean.getSql();
		if (sql == null) sql = "";
	%>
	<div class="mainPanel">
		<div><hello:message key="title.exec_sql" /></div>
		<div style="color: #ff0000;" id="sqlmsg"><hello:message key="message.not_exec" /></div>
		<div>
			<input type="text" name="sql" value="<%=sql %>" size="100" maxlength="200">
			<input type="button" name="next" value="<hello:message key='button.exec_sql' />" onclick="doNext();">
		</div>
		<div style="padding-top:10px;">
			<input type="button" name="back" value="<hello:message key='button.back_menu' />" onclick="doBack();">
		</div>

		<div style="padding-top:10px;">
			カレンダー ： <input type="text" id="datepicker">
		</div>
	</div>

	<script type="text/javascript">
	<!--
		$(function() {
			$("#datepicker").datepicker();
			$("#datepicker").datepicker("option", "showOn", 'button');
			$("#datepicker").datepicker("option", "buttonImageOnly", true);
		    $("#datepicker").datepicker("option", "buttonImage", '/HelloProject/img/calendar-icon.png');
			$("#datepicker").datepicker("option", "dateFormat", 'yy年mm月dd日');
		});

		function onLoad() {
			initCss();

			var sqlmsg = document.getElementById("sqlmsg");
		<% if (sql.length() > 0) { %>
			sqlmsg.innerHTML = "<%=sql %>";
		<% } %>
		}

		function doBack() {
			doSubmit('back');
		}

		function doNext() {
			var sql = document.f.sql.value;
			sql = jQuery.trim(sql);
			if (sql == '') {
				alert("<hello:message key='message.input_sql' />");
				return;
			}

			doSubmit('next');
		}
	//-->
	</script>

	<input type="hidden" name="fn" value="">
</form>
</body>

<jsp:include page="./Footer.jsp" />
