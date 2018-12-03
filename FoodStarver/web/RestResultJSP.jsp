

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="FoodStarver.StarverBean"%>
<%@page import="FoodStarver.ResturantBean"%>
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home!</title>
        

    </head>
    <body>
        <%
            // Get Current Active Starver 
           StarverBean activeStarverAcc= (StarverBean) request.getSession().getAttribute("activeStarver");
           ArrayList <ResturantBean> foundRes = (ArrayList<ResturantBean>)request.getSession().getAttribute("restRes");

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
       
       <fieldset>
       
           <legend>Yala Food Result</legend>
           
        <%
       if (!foundRes.isEmpty())
       {
       %>
           <table border="1">
            <tr>
            <th>Restaurant Name</th>
            <th>Restaurant Address</th>	
            <th> Phone Number </th>
           </tr>
       <%
       for (int i=0; i<foundRes.size();++i)
       {
       %>
       <tr>
           <td> <%=foundRes.get(i).getName()%> </td>
           <td> <%=foundRes.get(i).getAddress()%> </td>
           <td> <%=foundRes.get(i).getPhoneNumber()%> </td>

       </tr>
       <%
       }
       %>
           </table>
           <br>
       <%
          }
       else{
           out.println("No Result ... Try Again!");
       }
        %>
        <br>
           
       </fieldset>
    </center>

    </body>
</html>
