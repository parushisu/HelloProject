<jsp:include page="/WEB-INF/jsp/Header.jsp" />
<%@ taglib uri="http://jp.co.sample/hello-taglib_1_0" prefix="hello" %>

<style type="text/css">
<!--
//-->
</style>

<body onload="onLoad();">
   	<table class="mainTable" border="1">
   		<col class="mainTableCol">
   		<tr class="mainTableHeader">
   			<th>
		    	<hello:message key="app.menu.000" />
   			</th>
   		</tr>
   		<tr>
   			<td>
		    	<a href="./TestHelloServlet"><hello:message key="app.menu.001" /></a>
   			</td>
   		</tr>
   	</table>

	<script type="text/javascript">
	<!--
		function onLoad() {
		    document.title = "変更後のタイトル";
		}
	//-->
	</script>
</body>

<jsp:include page="/WEB-INF/jsp/Footer.jsp" />
