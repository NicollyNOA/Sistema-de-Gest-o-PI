/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestao.modelo.controller;
import gestao.view.formulario.LoginForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Nicol
 */
public class LoginController implements ActionListener {

    private final LoginForm Login;

    public LoginController(gestao.view.formulario.LoginForm login) {
        this.Login = login;
    }

    /**
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String accao = ae.getActionCommand().toLowerCase();    //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        switch(accao){
            case "login" -> LoginDto();
             case "cancelar" -> cancelar();
        }
    }

    private void LoginDto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void cancelar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}












