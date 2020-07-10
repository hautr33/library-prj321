/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautt.daos;

import hautt.dtos.BookStatusDTO;
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
public class BookStatusDAO {

    public List<BookStatusDTO> getAllStatus() throws SQLException, ClassNotFoundException, NamingException {
        List<BookStatusDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT statusID, statusName FROM tblBookStatus";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    String statusID = rs.getString("statusID");
                    String statusName = rs.getString("statusName");
                    list.add(new BookStatusDTO(statusID, statusName));
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
        return list;
    }
}
