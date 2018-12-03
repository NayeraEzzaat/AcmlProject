/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodStarver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class StarverRegistServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private StarverdbManager Starverdb;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       response.setContentType("text/html;charset=UTF-8");
        Starverdb = new StarverdbManager();
        StarverBean newUser = new StarverBean();
        
        newUser.setUsername(request.getParameter("usrname"));
        newUser.setPassword(request.getParameter("password"));
        boolean saveUser = Starverdb.signUp(newUser);
        if(saveUser){
            try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Owlery Mail -Registeration Confirmation</title>");            
            out.println("</head>");
            out.println("<body>");
            out.print("<h1 align=\"center\" style=\"font-family:courier;color: green\">voila a new Starver!</h1>");
            out.println("<fieldset>" +"<legend>Account Information:</legend>"+
                    "Username: "+newUser.getUsername()+"<br>"+
                    "</fieldset>");
            out.println("<center><a href=\"index.html\">Welcome Page</a></center>");
            out.println("</body>");
            out.println("</html>");
        }
        }else{
            try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registeration Failed</title>");            
            out.println("</head>");
            out.println("<body>");
            out.print("<h1 align=\"center\" style=\"font-family:courier;color: gray\"> Form Violation / Internal Error Has been Occured!</h1>");
            out.println("<center><a href=\"index.html\">Log-in Page</a></center>");
            out.println("</body>");
            out.println("</html>");
        }
        
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
