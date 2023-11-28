/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestao.modelo.dao;

import gestao.modelo.dao.UsuarioDao;
import gestao.modelo.entidades.PERFIL;
import gestao.modelo.entidades.Usuario;
import java.time.LocalDateTime;
/**
 *
 * @author Nicol
 */
public class UsuarioTest {
    
    public static void main(String[] args) {
        Usuario usuario = new  Usuario(0L, "ninisd", "niniii", "8910", PERFIL.ADMIN, null, null );
        
        UsuarioDao usuarioDao = new UsuarioDao();
        String mensagem = usuarioDao.salvar(usuario);
        System.out.println(mensagem);
    }
}
