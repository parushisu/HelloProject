<%@ taglib uri="http://jp.co.sample/hello-taglib_1_0" prefix="hello" %>

<jsp:include page="/WEB-INF/jsp/MainLayout.jsp" >
<jsp:param name="title" value="メニュー" />
<jsp:param name="screenId" value="SCR0001" />
<jsp:param name="content" >
<jsp:attribute name="value" >
	<%
	%>
	<table class="mainTable" border="1">
		<col class="mainTableCol">
		<tr class="mainTableHeader">
			<th>
			   	<hello:message key="app.menu.000" />
			</th>
		</tr>
		<tr>
			<td>
				<a href="javascript:void(0)" onclick="doNext(); return false;"><hello:message key="app.menu.001" /></a>
			</td>
		</tr>
	</table>

	<script type="text/javascript">
	<!--
		function doNext() {
			document.f.action.value = './TestHelloServlet';
			doSubmit('next');
		}
	//-->
	</script>
</jsp:attribute>
</jsp:param>
</jsp:include>
