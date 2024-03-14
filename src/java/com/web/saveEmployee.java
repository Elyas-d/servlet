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

public class saveEmployee extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String department = request.getParameter("department");
    Employee employee = new Employee();
        employee.setname(name);
        employee.setemail(email);
        employee.setdepartment(department);
        response.setContentType("text/html");
        PrintWriter pout = response.getWriter();
        
        pout.println("<html><body>");
        pout.println("<h1>Thank you for signing up!</h1>");
        pout.println("<p>Name: " + name + "</p>");
        pout.println("<p>Email: " + email + "</p><br/>");
        pout.println("<p>Employee info</p>");
        pout.println("<p>Employee name : " +employee.getname()+ "</p>");
        pout.println("<p>Employee email : " + employee.getemail() + "</p>");
        pout.println("<p>Employee department : " + employee.getdepartment() + "</p>");
        pout.println("<a href='http://localhost:8080/servlet/listPage'> " + "show list</a>");
        response.getWriter().println("</body></html>");
        
        try{
            DatabaseConnector c = new DatabaseConnector("jdbc:mysql://localhost:3306/web","root", "mysqlpassword");
            c.connect();
            c.insertSignUpInfo(name, email, department);
//            c.insertSignUpInfo("abebe", "ababe@gmail.com", "foodscience");
//            c.deleteUser("elyas");
//            c.updateUserInfo("heven", "heaven");
            c.disconnect();
        }catch(SQLException | java.lang.ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
