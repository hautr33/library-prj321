/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautt.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SE130205
 */
@MultipartConfig
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginController";
    private static final String LOGOUT = "LogoutController";
    private static final String HOME_PAGE = "adminHomePage.jsp";
    private static final String VIEW_BOOK = "BookSearchAllController";
    private static final String ADD_BOOK_PAGE = "bookAddPage.jsp";
    private static final String UPDATE_USER = "UserUpdateController";
    private static final String SEARCH_BOOK = "BookSearchController";
    private static final String ADD_BOOK = "BookAddController";
    private static final String UPLOAD_BOOK_IMG = "BookImageUploadController";
    private static final String UPDATE_BOOK_PAGE = "BookUpdatePageController";
    private static final String UPDATE_BOOK = "BookUpdateController";
    private static final String DELETE_BOOK = "BookDeleteController";

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
        String url = ERROR;
        try {
            String action = request.getParameter("btnAction");
            switch (action) {
                case "Login":
                    url = LOGIN;
                    break;
                case "Logout":
                    url = LOGOUT;
                    break;
                case "HomePage":
                    url = HOME_PAGE;
                    break;
                case "ViewBook":
                    url = VIEW_BOOK;
                    break;
                case "AddBookPage":
                    url = ADD_BOOK_PAGE;
                    break;
                case "UpdateUser":
                    url = UPDATE_USER;
                    break;
                case "SearchBook":
                    url = SEARCH_BOOK;
                    break;
                case "AddBook":
                    url = ADD_BOOK;
                    break;
                case "UploadBookImage":
                    url = UPLOAD_BOOK_IMG;
                    break;
                case "UpdateBookPage":
                    url = UPDATE_BOOK_PAGE;
                    break;
                case "UpdateBook":
                    url = UPDATE_BOOK;
                    break;
                case "DeleteBook":
                    url = DELETE_BOOK;
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            log("Error at MainController: ", e);
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
