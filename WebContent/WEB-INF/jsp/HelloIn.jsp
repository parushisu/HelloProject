<%@ taglib uri="http://jp.co.sample/hello-taglib_1_0" prefix="hello" %>
<jsp:useBean id="HelloBean" class="jp.co.test.bean.HelloBean" scope="request" />

<jsp:include page="/WEB-INF/jsp/MainLayout.jsp" >
<jsp:param name="title" value="入力" />
<jsp:param name="screenId" value="SCR0002" />
<jsp:param name="content" >
<jsp:attribute name="value" >
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
	</div>

	<script type="text/javascript">
	<!--
		function onLoad() {
			var sqlmsg = document.getElementById("sqlmsg");
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
</jsp:attribute>
</jsp:param>
</jsp:include>
