<jsp:include page="./Header.jsp" >
	<jsp:param name="title" value="出力" />
</jsp:include>

<%@ page import="java.util.ArrayList" %>
<%@ page import="jp.co.test.bean.HelloData" %>

<jsp:useBean id="HelloBean" class="jp.co.test.bean.HelloBean" scope="request" />

<%@ taglib uri="http://jp.co.sample/hello-taglib_1_0" prefix="hello" %>

<style type="text/css">
<!--
.helloDataCol {
	width:200px;
}
//-->
</style>

<body onload="onLoad();">
<form name="f" method="post" action="./TestHelloServlet">
	<input type="hidden" name="screenId" value="SCR0003">
<%
	String errText = HelloBean.getErrText();
	if (errText == null) errText = "";

	String sql = HelloBean.getSql();
	if (sql == null) sql = "";

	ArrayList<HelloData> resultList = HelloBean.getResultList();
%>
	<div class="mainPanel">
		<h2>
		<hello:test message="errText">
			<div class="errorMsg"><span id='errmsg'><%=errText %></span></div>
		</hello:test>
		</h2>

		<div><hello:message key="title.exec_sql" /></div>
		<div style="color: #ff0000;" id="sqlmsg"><%=sql %></div>
		<input type="hidden" name="sql" value="<%=sql %>">

	<% if (resultList.size() > 0) { %>
		<table border="1">
			<col class="helloDataCol"><col class="helloDataCol">
			<tr class="mainTableHeader">
				<th>型式</th>
				<th>車名</th>
			</tr>
		<hello:forEach var="addr" type="HelloData" items="<%=resultList %>">
			<tr>
				<td><%=addr.getCarKatasiki() %></td>
				<td><%=addr.getCarName() %></td>
			</tr>
		</hello:forEach>
		</table>
	<% } %>

		<div style="padding-top:10px;">
			<input type="button" name="back" value="<hello:message key='button.back_input' />" onclick="doBack();">
		</div>
	</div>

	<script type="text/javascript">
	<!--
		function onLoad() {
//			var element = document.getElementById("errmsg");
//			var str = "AAA" + jQuery.trim('<%=errText %>') + 'BBB';
//			element.innerHTML = str;
		}

		function doBack() {
			doSubmit('back');
		}
	//-->
	</script>

	<input type="hidden" name="fn" value="">
</form>
</body>

<jsp:include page="./Footer.jsp" />
