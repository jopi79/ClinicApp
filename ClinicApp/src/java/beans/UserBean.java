package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import model.UserRole;

/**
 *
 * @author Student
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    private String login, password;
    private UserRole userRole;
    private boolean logged = false;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String logIn() {
        if ("jan".equals(login)) {
            userRole = UserRole.PATIENT;
            logged = true;
            return "/index";
        }
        if ("adam".equals(login)) {
            userRole = UserRole.DOCTOR;
            logged = true;
            return "/index";
        }
        if ("ala".equals(login)) {
            userRole = UserRole.RECEPTION;
            logged = true;
            return "/reception/index.xhtml";
        }
        logged = false;
        return "/index";
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        logged = false;
        userRole = null;
        return "/index";
    }

    public boolean isLogged() {
        return logged;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public boolean isPatient() {
        return userRole != null && userRole == UserRole.PATIENT;
    }

    public boolean isDoctor() {
        return userRole != null && userRole == UserRole.DOCTOR;
    }

    public boolean isReceptionist() {
        return userRole != null && userRole == UserRole.RECEPTION;
    }

    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
    }

}
