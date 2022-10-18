<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary - JSP</title>
</head>
<body>
<%!
    Map<String, String> dictionary = new HashMap<>();
%>
<%
    dictionary.put("hello", "xin chao");
    dictionary.put("book", "quyen sach");
    dictionary.put("notebook", "quyen vo");
    dictionary.put("computer", "may tinh");

    String search = request.getParameter("search");

    String result = dictionary.get(search);

    if (result != null) {
        out.println("Word: " + search + "<br/>");
        out.println("Result: " + result);
    } else {
        out.println("Not found");
    }

%>
</body>
</html>