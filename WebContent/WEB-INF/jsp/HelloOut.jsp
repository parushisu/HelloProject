<jsp:include page="/WEB-INF/jsp/Header.jsp" />
<%@ taglib uri="http://jp.co.sample/hello-taglib_1_0" prefix="hello" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="jp.co.test.bean.HelloData" %>
<%@ page import="jp.co.sample.hello.utils.HelloUtils" %>

<script type="text/javascript" src="/HelloProject/js/jquery.min.js"></script>

<jsp:useBean id="HelloBean" class="jp.co.test.bean.HelloBean" scope="request" />
<jsp:useBean id="errText" class="java.lang.String" scope="request" />

<style type="text/css">
<!--
	.error_msg {
		color:#ff0000;
		background-color:#ffffff;
	}
//-->
</style>
<script type="text/javascript">
<!--
function onLoad() {
	var element = document.getElementById("errmsg");
//	alert(element.innerHTML);
	element.innerHTML = 'AAA' + jQuery.trim('<%=errText %>') + 'BBB';
}
//-->
</script>
	<body onload='onLoad();'>
		<%
//		    String errText = (String)request.getAttribute("errText");
//		    ArrayList<String[]> resultList = (ArrayList<String[]>)request.getAttribute("outText1");
		    ArrayList<HelloData> resultList = HelloBean.getOutText1();
		%>
		<h2>
		<hello:test message="errText">
			<div class="error_msg"><span id='errmsg'></span></div>
		</hello:test>
		</h2>

		<table>
		<hello:forEach var="addr" type="HelloData" items="<%=resultList %>">
			<tr>
				<td><%=addr.getCarKatasiki() %></td>
				<td><%=addr.getCarName() %></td>
			</tr>
		</hello:forEach>
		</table>
	</body>
<jsp:include page="/WEB-INF/jsp/Footer.jsp" />
