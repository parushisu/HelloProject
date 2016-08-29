<jsp:include page="/WEB-INF/jsp/Header.jsp" />
<%@ taglib uri="http://mycompany.com/my-taglib_1_0" prefix="mytaglib" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="jp.co.sample.utils.HelloUtils" %>

	<body>
		<%
	//		String item = "Hello JSP2!";
	//	    request.setCharacterEncoding("windows-31j");
		    String errText = (String)request.getAttribute("errText");
		    ArrayList<String[]> resultList = (ArrayList<String[]>)request.getAttribute("outText1");
		%>
		<h2>
		<%--
			<mytaglib:HelloTag /><br>
			<mytaglib:HelloWorldTag /><br>
		 --%>
			<mytaglib:HelloWorldTag2 message="zaaa">
				Everyone<br>
			</mytaglib:HelloWorldTag2>

			<%
				if (errText != null) {
					out.println(errText);
				}
			%>
			<%
				String outText1 = null;
				if (resultList.size() > 0) {
					StringBuffer result = new StringBuffer();
					for (String[] sl : resultList) {
						int cnt = sl.length;
				    	for (int i = 0; i < cnt; i++) {
					    	result.append(sl[i]);
					    	if (i < (cnt - 1)) {
					    		result.append("\t");
					    	} else {
						    	result.append("\n");
					    	}
				    	}
					}
					outText1 = result.toString();
				} else {
					outText1 = "該当するデータは存在しません。";
				}
			%>
			<%=HelloUtils.getSanitizedString(outText1) %>
		</h2>
	</body>
</html>
