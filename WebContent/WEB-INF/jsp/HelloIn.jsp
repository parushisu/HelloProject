<jsp:include page="/WEB-INF/jsp/Header.jsp" />
    <body>あいうえお
        <%
//        request.setCharacterEncoding("windows-31j");
        String str = request.getParameter("text1");
        str = str == null ? "（未送信）" : str;
        out.println("※あなたが送信した内容<br>");
        out.println("<font color=#FF0000>" + str + "</font>");
        %>
        <form method="post" action="./HelloServlet">
            <input type="text" name="text1" value="<%=str %>">
            <input type="submit">
        </form>
    </body>
</html>
