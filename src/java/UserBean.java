/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import java.io.Serializable;
import javax.enterprise.context.Dependent;
//import javax.enterprise.context.SessionScoped;
//import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author mark
 */
@Named(value = "user")
@Dependent
//@SessionScoped
public class UserBean  {

    public String name;
    public String email;
    public String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	//getter and setter methods for name and email
    public String registerAction() {
//        result=" going to check name/email as "+name+"/"+email;
//        System.out.println(""+result);
        return "faces/j2";
    }
}
