package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

//RESPONSÁVEL POR ESTABELECER A CONEXÃO COM O BANCO: CONECTA/DESCONECTA
public class conexao {
    
    public conexao()  {} //Possibilita instancias
    
    public static Connection con = null;
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";   //para o mysql-connector-java-8.0.22
    private static final String URL = "jdbc:mysql://localhost:3306/Lista?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "123456";  // não esquecer de colocar a sua senha

    // ANTES de fazer qualquer consulta em SQL, precisa estabelecer uma conexão
    public static void Conectar() {
        System.out.println("Conectando ao Sistemas...");
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectado.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
            Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        } 
    }
    
    // DEPOIS de fazer qualquer consulta em SQL, precisa fechar a conexão
    public static void Desconectar() {
        System.out.println("Desconectando do banco...");
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Desconectado.");
         
    }
}