<%@ page import="com.aina.spring_mvc.model.District" %>
<%@ page import="java.util.List" %>
<%@ page import="com.aina.spring_mvc.model.*" %><%--
  Created by IntelliJ IDEA.
  User: aina
  Date: 2023-01-11
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    List<Type> districts = (List<Type>) request.getAttribute("type");
    Admin admin=(Admin) request.getAttribute("data");
%>
<body>
<form action="<%= request.getContextPath() %>/save-article-event" method="post">
    <p> titre <input type="text" name="titre"></p>
    <p><input type="file" name="file" id="file"></p>
    <input type="hidden" name="sary" id="sary">
    <p>Type
    <select name="id_type" >
        <%
            for (Type district : districts
            ) { %>
        <option value="<%= district.getId_type() %>"><%= district.getNom() %></option>
        <%   } %>
    </select></p>
    <p> about <input type="text" name="about"></p>
    <p> date1 <input type="date" name="date1"></p>
    <p> date2 <input type="date" name="date2"></p>
    <input type="submit" value="Valider">
</form>
<a href="/spring/get_all_for_admin?limite=0">Listes</a>
<script>
    document.getElementById("file").addEventListener("change",function (){
        console.log("OKAYYYY");
        let f=this.files[0],
            reader=new FileReader();
        reader.readAsDataURL(f);
        reader.onload=function () {
            document.getElementById("sary").value= reader.result;
        }
        console.log("SURRR");
    });
</script>
</body>
</html>
