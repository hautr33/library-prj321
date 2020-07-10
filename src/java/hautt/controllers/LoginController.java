/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautt.controllers;

import hautt.daos.UserDAO;
import hautt.dtos.UserDTO;
import hautt.dtos.UserErrorDTO;
import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SE130205
 */
public class LoginController extends HttpServlet {

    private static final String ERROR_PAGE = "login.jsp";
    private static final String ADMIN_PAGE = "adminHomePage.jsp";
    private static final String USER_PAGE = "book.jsp";

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
        String url = ERROR_PAGE;
        try {
            String userID = request.getParameter("txtUserID");
            String password = request.getParameter("txtPassword");

            UserErrorDTO err = new UserErrorDTO();
            boolean isError = false;

            if (userID == null || userID.length() < 1) {
                err.setUserIDErr("User ID can not blank!");
                isError = true;
            }
            if (password == null || password.length() < 1) {
                err.setPasswordErr("Password can not blank!");
                isError = true;
            }

            if (!isError) {
                UserDAO userDAO = new UserDAO();
                UserDTO user = userDAO.checkLogin(userID, password);
                if (user != null) {
                    if (user.getRoleID().equals("AD")) {
                        HttpSession session = request.getSession();
                        session.setAttribute("ADMIN", user);
                        url = ADMIN_PAGE;
                    } else if (user.getRoleID().equals("US")) {
                        HttpSession session = request.getSession();
                        session.setAttribute("USER", user);
                        url = USER_PAGE;
                    }
                } else {
                    err.setWrongUserIDPasswordErr("The user id or password that you've entered is incorrect!!!");
                    request.setAttribute("LOGIN_ERROR", err);
                }
            } else {
                request.setAttribute("LOGIN_ERROR", err);
            }
        } catch (ClassNotFoundException | SQLException | NamingException e) {
            log("Error at LoginController:", e);
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
