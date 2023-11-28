
package gestao.modelo.controller;

import gestao.modelo.dao.AutenticacaoDao;
import gestao.modelo.entidades.Usuario;
import gestao.view.formulario.Dashboard;
import gestao.view.formulario.LoginForm;
import gestao.view.modelo.LoginDto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class AutenticacaoController implements ActionListener{
    
    private final LoginForm loginForm;
    private final AutenticacaoDao autenticacao;

    public AutenticacaoController(LoginForm loginForm) {
        this.loginForm = loginForm;
        autenticacao = new AutenticacaoDao();
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String accao = ae.getActionCommand().toLowerCase();
        
        switch(accao) {
            case "login" -> login();
            case "cancelar" -> cancelar();                                
        }
    }
    

    private void login() {
        String username = loginForm.getTxtLoginUsername().getText();
        String senha = loginForm.getTxtLoginSenha().getText();
        
        if(username.equals("") || senha.equals("")) {
            loginForm.getLabelLoginMensagem().setText("Username e senha devem ser preenchido");
            return;
        }
        
        LoginDto login = new LoginDto(username, senha);
        Usuario usuario = autenticacao.login(login);
        
        if(usuario != null) {
            System.out.println("Sucesso: " + usuario.getUsername());
            Dashboard dashboard = new Dashboard();
            dashboard.setVisible(true);
            dashboard.getLabelBenvindoUsuario().setText(String.format("Bem-vindo %s", usuario.getNome()));
            dashboard.getLabelUsuarioLogadoId().setText(Long.toString(usuario.getId()));
            this.loginForm.setVisible(false);
            limpaTela();
        }else{
            loginForm.getLabelLoginMensagem().setText("Username ou senha incorreta.");
            JOptionPane.showMessageDialog(null, "Username ou senha incorreta.");
        }
    }
    
       private void limpaTela() {
        // Lógica para limpar os campos do formulário
        // Verificação de nulos adicionada aqui para evitar NullPointerException
        
        JLabel labelLoginMensagem = loginForm.getLabelLoginMensagem();
        if (labelLoginMensagem != null) {
            labelLoginMensagem.setText("");
        }

        JTextField txtLoginUsername = loginForm.getTxtLoginUsername();
        if (txtLoginUsername != null) {
            txtLoginUsername.setText("");
        }

        JTextField txtLoginSenha = loginForm.getTxtLoginSenha();
        if (txtLoginSenha != null) {
            txtLoginSenha.setText("");
        }
    }
    
    private void cancelar() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?","Sair do login", JOptionPane.YES_NO_OPTION);
        
        if(confirma == JOptionPane.YES_OPTION) System.exit(0);
    }
    
    /*private void limpaTela() {
        loginForm.getLabelLoginMensagem().setText("");
        loginForm.getTxtLoginUsername().setText("");
        loginForm.getTxtLoginSenha().setText("");
    }*/
    
}
