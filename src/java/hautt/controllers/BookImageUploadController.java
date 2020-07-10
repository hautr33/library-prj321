/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautt.controllers;

import hautt.daos.BookDAO;
import hautt.dtos.BookErrorDTO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author SE130205
 */
public class BookImageUploadController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "BookUpdatePageController";

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
            String bookID = request.getParameter("txtBookID");
            String imageURL = request.getParameter("txtImageURL");
            Part part = request.getPart("image");
            String imageName = part.getSubmittedFileName();
            if (!imageURL.isEmpty()) {
                BookDAO dao = new BookDAO();
                dao.uploadImage(bookID, imageURL);
            } else if (!imageName.isEmpty()) {
                Path path = Paths.get(request.getServletContext().getRealPath(""));
                path = path.getParent().getParent();
                String fullSavePath = path.toString().replace("\\", "/") + "/web/images/books/";
                File fileSaveDir = new File(fullSavePath);
                if (!fileSaveDir.exists()) {
                    Files.createDirectories(Paths.get(fullSavePath));
                }
                String filePath = fullSavePath + imageName;
                part.write(filePath);
                File source = new File(path.toString().replace("\\", "/") + "/web/images/books/" + imageName);
                File dest = new File(path.toString().replace("\\", "/") + "/build/web/images/books/" + imageName);
                Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
                imageURL = "images/books/" + imageName;
                BookDAO dao = new BookDAO();
                dao.uploadImage(bookID, imageURL);
            } else {
                BookErrorDTO err = new BookErrorDTO();
                err.setImageURLErr("Please choose image or enter url!!!");
                request.setAttribute("BOOK_ERROR", err);
            }
            url = SUCCESS;
        } catch (ClassNotFoundException | SQLException | NamingException e) {
            log("Error at Book Image URL Upload Controller: ", e);
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
