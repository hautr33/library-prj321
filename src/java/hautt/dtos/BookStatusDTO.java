/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautt.dtos;

import java.io.Serializable;

/**
 *
 * @author SE130205
 */
public class BookStatusDTO implements Serializable {

    String statusID, statusName;

    public BookStatusDTO() {
    }

    public BookStatusDTO(String statusID, String statusName) {
        this.statusID = statusID;
        this.statusName = statusName;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

}
