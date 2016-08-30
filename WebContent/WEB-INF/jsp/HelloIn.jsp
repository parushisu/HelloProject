<jsp:include page="/WEB-INF/jsp/Header.jsp" />
<%@ taglib uri="http://jp.co.sample/hello-taglib_1_0" prefix="hello" %>

<style type="text/css">
<!--
//-->
</style>

<jsp:useBean id="HelloBean" class="jp.co.test.bean.HelloBean" scope="request" />

<body onload="onLoad();">
	<%
		String sql = HelloBean.getSql();
//		String sqlMsg = (sql == null) ? objRb.getString("message.not_exec") : sql;
		if (sql == null) sql = "";
	%>
	<form name="f" method="post" action="./TestHelloServlet">
		<div class="mainPanel">
			<div><hello:message key="title.exec_sql" /></div>
			<div style="color: #ff0000;" id="sqlmsg"><hello:message key="message.not_exec" /></div>
			<div>
				<input type="text" name="sql" value="<%=sql %>" size="100" maxlength="100">
				<input type="button" name="next" value="<hello:message key='button.exec_sql' />" onclick="doNext();">
			</div>
			<div style="padding-top:10px;">
				<input type="button" name="back" value="<hello:message key='button.back_menu' />" onclick="doBack();">
			</div>
		</div>

		 <input type="hidden" name="fn" value="">
	</form>

	<script type="text/javascript">
	<!--
		function onLoad() {
			var sqlmsg = document.getElementById("sqlmsg");
//			alert(sqlmsg.innerHTML);
		<% if (sql.length() > 0) { %>
			sqlmsg.innerHTML = '<%=sql %>';
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

</body>
<jsp:include page="/WEB-INF/jsp/Footer.jsp" />
