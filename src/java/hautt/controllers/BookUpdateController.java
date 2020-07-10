/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautt.controllers;

import hautt.daos.BookDAO;
import hautt.dtos.BookDTO;
import hautt.dtos.BookErrorDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SE130205
 */
public class BookUpdateController extends HttpServlet {

    private static final String SUCCESS = "BookUpdatePageController";
    private static final String ERROR = "error.jsp";

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
            BookErrorDTO err = new BookErrorDTO();
            boolean isError = false;

            String bookID = request.getParameter("txtBookID");

            String title = request.getParameter("txtTitle");
            if (title.isEmpty()) {
                err.setTitleErr("Tittle can not blank!!");
                isError = true;
            }

            String author = request.getParameter("txtAuthor");
            if (author.isEmpty()) {
                err.setAuthorErr("Author can not blank!!");
                isError = true;
            }

            String publisher = request.getParameter("txtPublisher");
            if (publisher.isEmpty()) {
                err.setPublisherErr("Publisher can not blank!!");
                isError = true;
            }

            String pageNumberStr = request.getParameter("txtPageNumber");
            int pageNumber = 0;
            if (pageNumberStr.isEmpty()) {
                err.setPageNumberErr("Page Number can not blank!!");
                isError = true;
            } else {
                pageNumber = Integer.parseInt(pageNumberStr);
            }

            String priceStr = request.getParameter("txtPrice");
            int price = 0;
            if (priceStr.isEmpty()) {
                err.setPriceErr("Price can not blank!!");
                isError = true;
            } else {
                price = Integer.parseInt(priceStr);
            }

            String quantityStr = request.getParameter("txtQuantity");
            int quantity = 0;
            if (quantityStr.isEmpty()) {
                err.setQuantityErr("Quantity can not blank!!");
                isError = true;
            } else {
                quantity = Integer.parseInt(quantityStr);
            }

            String description = request.getParameter("txtDescription");

            if (!isError) {
                BookDAO dao = new BookDAO();
                dao.update(new BookDTO(bookID, title, author, publisher, pageNumber, price, quantity, description));
            } else {
                request.setAttribute("BOOK_ERROR", err);
            }
            url = SUCCESS;
        } catch (Exception e) {
            log("Error at UpdateUserController: ", e);
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
