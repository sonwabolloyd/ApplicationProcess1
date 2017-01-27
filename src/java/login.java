/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lloyd
 */
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String Name = request.getParameter("name");
            String IdNumber = request.getParameter("IdNum");
            String middle = request.getParameter("middle");
            String Surname = request.getParameter("surname");
            String DateOfBirth = request.getParameter("bday");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String gender = request.getParameter("gender");
            String Race = request.getParameter("race");
            String Municipality = request.getParameter("municipality");
            
            MyDb Db = new MyDb();
            
            Connection conn = Db.getCon();
            Statement stmt = conn.createStatement();
            String sql = "insert into user values ('"+IdNumber+"',' "+Name+"', '"+middle+"', '"+Surname+"', '"+DateOfBirth+"', '"+email+"', '"+phone+"', '"+gender+"', '"+Race+"', '"+Municipality+"')";
            stmt.executeUpdate(sql);
            response.sendRedirect("qualification.html"); 
            
            
           
            String NameOfQualification = request.getParameter("qual");
            String FieldOfStudy = request.getParameter("field");
            String FieldOfInternship = request.getParameter("internship");
            
            
            String b = "insert into qualification values ('"+ NameOfQualification +"','"+FieldOfStudy+"','"+FieldOfInternship+"', +id+)";
            stmt.executeUpdate(b);
            response.sendRedirect("done.html");
           
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
