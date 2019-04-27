/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author sohel
 */
public class LoginAction extends ActionSupport{
    
    String userid, pass;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    public String execute(){
        if(userid.equals(pass))
            return "SUCCESS";
        else
            return "ERROR";
    }
    
}
