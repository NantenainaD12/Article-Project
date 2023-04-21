<%@ page import="com.aina.spring_mvc.model.Commune" %>
<%@ page import="java.util.List" %>
<%@ page import="com.aina.spring_mvc.model.Article_Event" %><%--
  Created by IntelliJ IDEA.
  User: aina
  Date: 2023-01-11
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste commune</title>
</head>
<%
    List<Article_Event> communes = (List<Article_Event>) request.getAttribute("data");
%>
<body>


<table class="custom-table">
    <tr>
        <th>Sary</th>
        <th>Titre</th>
        <th>About</th>
        <th>date 1</th>
        <th>date 2</th>
    </tr>
    <% for (Article_Event commune : communes) { %>
    <tr>
        <td><img src="<%= commune.getSary() %>"> </td>
        <td><%= commune.getTitre() %></td>
        <td><%= commune.getAbout() %></td>
        <td><%= commune.getDate1() %>
        </td><td><%= commune.getDate2() %></td>
    </tr>
    <%  } %>

</table>
</body>
</html>
