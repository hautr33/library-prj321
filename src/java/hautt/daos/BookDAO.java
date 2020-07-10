/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautt.daos;

import hautt.dtos.BookDTO;
import hautt.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author SE130205
 */
public class BookDAO {

    public List<BookDTO> getListBook(String search) throws SQLException, ClassNotFoundException, NamingException {
        List<BookDTO> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT bookID, title, author, publisher, pageNumber, price, quantity, imageURL, description FROM tblBooks WHERE title LIKE '%" + search + "%' AND status = 1";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    String title = rs.getString("title");
                    String author = rs.getString("author");
                    String publisher = rs.getString("publisher");
                    int pageNumber = rs.getInt("pageNumber");
                    int price = rs.getInt("price");
                    int quantity = rs.getInt("quantity");
                    String imageURL = rs.getString("imageURL");
                    String description = rs.getString("description");
                    result.add(new BookDTO(bookID, title, author, publisher, pageNumber, price, quantity, imageURL, description));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public List<BookDTO> getAllBook() throws SQLException, ClassNotFoundException, NamingException {
        List<BookDTO> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT bookID, title, author, publisher, pageNumber, price, quantity, imageURL, description FROM tblBooks WHERE status = 1";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    String title = rs.getString("title");
                    String author = rs.getString("author");
                    String publisher = rs.getString("publisher");
                    int pageNumber = rs.getInt("pageNumber");
                    int price = rs.getInt("price");
                    int quantity = rs.getInt("quantity");
                    String imageURL = rs.getString("imageURL");
                    String description = rs.getString("description");
                    result.add(new BookDTO(bookID, title, author, publisher, pageNumber, price, quantity, imageURL, description));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public BookDTO getBook(String bookID) throws SQLException, ClassNotFoundException, NamingException {
        BookDTO result = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT bookID, title, author, publisher, pageNumber, price, quantity, imageURL, description FROM tblBooks WHERE bookID = ? AND status = 1";
                stm = conn.prepareStatement(sql);
                stm.setString(1, bookID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String title = rs.getString("title");
                    String author = rs.getString("author");
                    String publisher = rs.getString("publisher");
                    int pageNumber = rs.getInt("pageNumber");
                    int price = rs.getInt("price");
                    int quantity = rs.getInt("quantity");
                    String imageURL = rs.getString("imageURL");
                    String description = rs.getString("description");
                    result = new BookDTO(bookID, title, author, publisher, pageNumber, price, quantity, imageURL, description);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public boolean delele(String bookID) throws SQLException, ClassNotFoundException, NamingException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblBooks SET status = 0 WHERE bookID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, bookID);
                stm.executeUpdate();
                result = true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public boolean insert(BookDTO dto) throws SQLException, ClassNotFoundException, NamingException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "INSERT INTO tblUsers(userID,fullName,password,roleID,isActive) VALUES(?,?,?,?,1)";
            stm = conn.prepareStatement(sql);
            if (stm.executeUpdate() > 0) {
                result = true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public boolean update(BookDTO dto) throws SQLException, ClassNotFoundException, NamingException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "UPDATE tblBooks SET title=?, author=?, publisher=?, pageNumber=?, price=?, quantity=?, description=? WHERE bookID=?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getTitle());
            stm.setString(2, dto.getAuthor());
            stm.setString(3, dto.getPublisher());
            stm.setInt(4, dto.getPageNumber());
            stm.setFloat(5, dto.getPrice());
            stm.setInt(6, dto.getQuantity());
            stm.setString(7, dto.getDescription());
            stm.setString(8, dto.getBookID());
            if (stm.executeUpdate() > 0) {
                result = true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public boolean uploadImage(String bookID, String imageURL) throws SQLException, ClassNotFoundException, NamingException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "UPDATE tblBooks SET imageURL=? WHERE bookID=?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, imageURL);
            stm.setString(2, bookID);
            if (stm.executeUpdate() > 0) {
                result = true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }
}
