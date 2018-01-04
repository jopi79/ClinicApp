package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.UserDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Doctor;
import model.Person;
import model.UserRole;

/**
 *
 * @author jopi79
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
        Person person = UserDAO.getUser(login, password);
        if (person != null) {
            logged = true;
            if (person instanceof Doctor) {
                userRole = UserRole.DOCTOR;
                return "/doctor/index.xhtml";
            } else {
                return "/patient/patientIndex.xhtml";
            }
        }
        logged = false;
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage("Logowanie nie powiodło się");
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        context.addMessage(null, message);
        return null;
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
