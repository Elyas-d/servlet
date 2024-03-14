/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Elyas
 */
public class listPage extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
            /* TODO output your page here. You may use following sample code. */
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet listPage</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet listPage at " + request.getContextPath() + "</h1>");
            out.println("<p1>here is a list of users : <P1>");
            DatabaseConnector dc = new DatabaseConnector("jdbc:mysql://localhost:3306/web","root", "mysqlpassword");
            java.sql.ResultSet rs = dc.listUsers();
            while(rs.next()){
                 out.println("<p> " + rs.getString(1) +rs.getString(2) +rs.getString(3) + "</p></br>");
            }
//            int i=0;
//            while(i<10){
//                 out.println("<p"+i+">"+i+"</p"+i+"></br>");
//                 i++;
//            }
            dc.disconnect();
            out.println("</body>");
            out.println("</html>");
        }catch(IOException | SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//}
