/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautt.daos;

import hautt.dtos.UserDTO;
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
 * @author hautr33
 */
public class UserDAO {

//    public boolean sample() throws SQLException {
//        boolean result = false;
//        Connection conn = null;
//        PreparedStatement stm = null;
//        ResultSet rs = null;
//        try {
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (stm != null) {
//                stm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//        return result;
//    }
    public UserDTO checkLogin(String userID, String password) throws SQLException, ClassNotFoundException, NamingException {
        UserDTO result = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT fullName, roleID FROM tblUsers WHERE userID=? AND password=? COLLATE  SQL_Latin1_General_CP1_CS_AS AND isActive=1";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    result = new UserDTO(userID, fullName, "", roleID);
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

    public List<UserDTO> getListUser(String search, String adminID) throws SQLException, ClassNotFoundException, NamingException {
        List<UserDTO> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT userID, fullName, roleID, isActive FROM tblUsers WHERE fullName LIKE '%" + search + "%' AND userID <> ? AND isActive = 1";
                stm = conn.prepareStatement(sql);
                stm.setString(1, adminID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String password = "****";
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    result.add(new UserDTO(userID, fullName, password, roleID));
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

    public boolean delele(String userID) throws SQLException, ClassNotFoundException, NamingException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblUsers SET isActive = 0 WHERE userID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
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

    public boolean insert(UserDTO dto) throws SQLException, ClassNotFoundException, NamingException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "INSERT INTO tblUsers(userID,fullName,password,roleID,isActive) VALUES(?,?,?,?,1)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getUserID());
            stm.setString(2, dto.getFullName());
            stm.setString(3, dto.getPassword());
            stm.setString(4, dto.getRoleID());
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

    public boolean update(UserDTO dto) throws SQLException, ClassNotFoundException, NamingException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "UPDATE tblUsers SET fullName=?, roleID=? WHERE userID=?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getFullName());
            stm.setString(2, dto.getRoleID());
            stm.setString(3, dto.getUserID());
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
