<%@ taglib uri="http://jp.co.sample/hello-taglib_1_0" prefix="hello" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="jp.co.test.bean.HelloData" %>
<%@ page import="jp.co.sample.hello.utils.HelloUtils" %>
<jsp:useBean id="HelloBean" class="jp.co.test.bean.HelloBean" scope="request" />
<jsp:useBean id="zerrText" class="java.lang.String" scope="request" />

<jsp:include page="/WEB-INF/jsp/MainLayout.jsp" >
<jsp:param name="title" value="出力" />
<jsp:param name="screenId" value="SCR0003" />
<jsp:param name="content" >
<jsp:attribute name="value" >
<%
	String errText = HelloBean.getErrText();
	if (errText == null) errText = "";

	String sql = HelloBean.getSql();
	if (sql == null) sql = "";

	ArrayList<HelloData> resultList = HelloBean.getOutText1();
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

		<table>
		<hello:forEach var="addr" type="HelloData" items="<%=resultList %>">
			<tr>
				<td><%=addr.getCarKatasiki() %></td>
				<td><%=addr.getCarName() %></td>
			</tr>
		</hello:forEach>
		</table>

		<div style="padding-top:10px;">
			<input type="button" name="back" value="<hello:message key='button.back_menu' />" onclick="doBack();">
		</div>
	</div>

	<script type="text/javascript">
	<!--
		function onLoad() {
//			var element = document.getElementById("errmsg");
//			var str = "AAA";
//			str = str.concat(jQuery.trim('   TEST    '));
//			str = str.concat('BBB');
//			element.innerHTML = str;
		}

		function doBack() {
			doSubmit('back');
		}
	//-->
	</script>
</jsp:attribute>
</jsp:param>
</jsp:include>
