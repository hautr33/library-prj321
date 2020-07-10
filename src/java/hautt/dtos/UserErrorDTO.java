/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautt.dtos;

/**
 *
 * @author hautr33
 */
public class UserErrorDTO {

    private String userIDErr, fullNameErr, passwordErr, rePasswordErr, roleIDErr, wrongUserIDPasswordErr;

    public UserErrorDTO() {
    }

    public String getUserIDErr() {
        return userIDErr;
    }

    public void setUserIDErr(String userIDErr) {
        this.userIDErr = userIDErr;
    }

    public String getFullNameErr() {
        return fullNameErr;
    }

    public void setFullNameErr(String fullNameErr) {
        this.fullNameErr = fullNameErr;
    }

    public String getPasswordErr() {
        return passwordErr;
    }

    public void setPasswordErr(String passwordErr) {
        this.passwordErr = passwordErr;
    }

    public String getRePasswordErr() {
        return rePasswordErr;
    }

    public void setRePasswordErr(String rePasswordErr) {
        this.rePasswordErr = rePasswordErr;
    }

    public String getRoleIDErr() {
        return roleIDErr;
    }

    public void setRoleIDErr(String roleIDErr) {
        this.roleIDErr = roleIDErr;
    }

    public String getWrongUserIDPasswordErr() {
        return wrongUserIDPasswordErr;
    }

    public void setWrongUserIDPasswordErr(String wrongUserIDPasswordErr) {
        this.wrongUserIDPasswordErr = wrongUserIDPasswordErr;
    }

}
