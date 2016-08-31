<jsp:include page="/WEB-INF/jsp/Header.jsp" />
<%@ taglib uri="http://jp.co.sample/hello-taglib_1_0" prefix="hello" %>

<style type="text/css">
<!--
//-->
</style>

<body onload="onLoad();">
<form name="f" method="post" action="./TestHelloServlet">
${param.content}

	<input type="hidden" name="screenId" value="${param.screenId}">
	<input type="hidden" name="fn" value="">
</form>
</body>

<jsp:include page="/WEB-INF/jsp/Footer.jsp" />
