
package gestao.modelo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoMysql implements Conexao{
    
    private static final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/gestao_estetica";
    private final String user = "root";
    private final String password = "nini";
    private Connection connection;
    
   @Override
public Connection obterConexao() {
    if(connection == null) {
       try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestao_estetica", "root", "nini");
            System.out.println("Conexão estabelecida com sucesso!");
       } catch (SQLException e) {
           if (e.getMessage().contains("No suitable driver")) {
                System.out.println("O driver MySQL Connector/J não foi encontrado.");
           } else {
                System.out.println("Um erro ocorreu ao tentar estabelecer a conexão.");
           }
           e.printStackTrace();
       }
    }
    return connection;
}

    
    @Override
    public void fecharConexao() {
        if(connection != null)
            try {
                connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoMysql.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
          
          
    }

    //public Connection connection() {
   //  return obterConexao();    }

}
