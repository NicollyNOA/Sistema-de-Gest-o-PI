
package gestao.modelo.controller;

import gestao.modelo.dao.UsuarioDao;
import gestao.modelo.util.UsuarioTableModel;
import gestao.modelo.entidades.Usuario;
import gestao.view.formulario.Dashboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public final class DashboardController implements ActionListener{
    
    private Dashboard dashboard;
    private UsuarioDao usuarioDao;
    private UsuarioTableModel usuarioTableModel;

    public DashboardController(Dashboard dashboard) {
        this.dashboard = dashboard;
        this.usuarioDao = new UsuarioDao();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String accao = ae.getActionCommand().toLowerCase();
        
        switch(accao) {
            case "home": panelHome(); break;
            case "clientes": panelClientes(); break;
            case "produtos": panelProdutos(); break;
            case "vendas": panelVendas(); break;
            case "usuarios": panelUsuarios(); break;
            case "sair": sair(); break;            
        }
    }
    
    private void painelComponentes(JPanel panel) {
        this.dashboard.getPanelBody().removeAll();
        this.dashboard.getPanelBody().repaint();
        this.dashboard.getPanelBody().revalidate();
        this.dashboard.getPanelBody().add(panel);
        this.dashboard.getPanelBody().repaint();
        this.dashboard.getPanelBody().revalidate();
    }

    private void panelClientes() {
        painelComponentes(this.dashboard.getPanelCliente());
    }

    private void panelProdutos() {
        painelComponentes(this.dashboard.getPanelProduto());
    }

    private void sair() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tens certeza que deseja sair?","Sair do login", JOptionPane.YES_NO_OPTION);
        
        if(confirma == JOptionPane.YES_OPTION) System.exit(0);
    }

    private void panelUsuarios() {
        painelComponentes(this.dashboard.getPanelUsuario());
    }

    private void panelVendas() {
        painelComponentes(this.dashboard.getPanelVenda());
    }

    private void panelHome() {
        painelComponentes(this.dashboard.getPanelHome());
    }
    
}
