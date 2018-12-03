

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="FoodStarver.StarverBean"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        

    </head>
    <body>
        <%
            // Get Current Active Starver 
           StarverBean activeStarverAcc= (StarverBean) request.getSession().getAttribute("activeStarver");
        %>
        <h1 align="center"style="font-family:courier;color: #cf9118">Welcome Starver Home Page</h1>
        <h3 align="left" style="color:blue">
            
           username: <%=activeStarverAcc.getUsername()%>  
        </h3>
        <br>
   <center>
        <form action="StarverRestSearchServlet" method="post">
            <fieldset>
           <legend>Search For Food</legend>
           Search: <input type="text" name="qry" required>
            <input type="submit" value="Yala Food!">
            </fieldset>
        </form>
    </center>

    </body>
</html>
