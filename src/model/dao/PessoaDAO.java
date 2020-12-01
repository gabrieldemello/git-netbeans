package model.dao;

import static connection.conexao.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Pessoa;

public class PessoaDAO {
    
    public void create(Pessoa p) {
        
        connection.conexao.Conectar();         // ABRIR conexão ANTES de executar qualquer SQL
        
        PreparedStatement stmt = null;         // É QUEM RECEBE/DECLARA OS COMANDOS DO SQL

        try {
            
            //Pessoa
            stmt = con.prepareStatement("INSERT INTO Pessoa (idPessoa, Ativo) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, p.getIdPessoa());
            stmt.setInt(2, p.getAtivo());
            //stmt.executeUpdate(); 
            // executa, armazena os valores no BD
            stmt.execute();

            // pesquisa os ID
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();

            long idGerado = rs.getLong(1);
            p.setIdPessoa((int) idGerado);
            
            
			
            
            //Pessoa Física
            stmt = con.prepareStatement("INSERT INTO PessoaFisica (Nome, CPF, Pessoa_idPessoa) VALUES (?,?,?)");
            stmt.setString(1, p.getPf().getNome());
            stmt.setString(2, p.getPf().getCpf());
            stmt.setInt(3, p.getIdPessoa());
            stmt.executeUpdate();
            
            //Pessoa Jurídica
            stmt = con.prepareStatement("INSERT INTO PessoaJuridica (RazaoSocial, CNPJ, Pessoa_idPessoa) VALUES (?,?,?)");
            stmt.setString(1, p.getPj().getRazaoSocial());
            stmt.setString(2, p.getPj().getCNPJ());
            stmt.setInt(3, p.getIdPessoa());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            connection.conexao.Desconectar();   // FECHAR conexão DEPOIS de executar qualquer SQL
        }

    }
    
    public Pessoa read(String Nome){
    
        Pessoa p = new Pessoa();
        
        connection.conexao.Conectar();
        
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Pessoa WHERE Nome LIKE ?");
            stmt.setString(1, "%"+Nome+"%");
            
            rs = stmt.executeQuery();
            
            if (rs.next() == true){
            p.setIdPessoa(rs.getInt("idPessoa"));
            p.getPf().setNome(rs.getString("Nome"));
            
            
            JOptionPane.showMessageDialog(null, "Nome encontrado!");
           }
        } catch (SQLException ex){
        Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,"Nome não encontrado, tente outro");
        }finally{
        connection.conexao.Desconectar();
        }
        return p;
    
    }//public Aluno read
    
    public void update (Pessoa a){
    
        connection.conexao.Conectar();
        
        PreparedStatement stmt = null;
        
        try {
        stmt = con.prepareStatement("UPDATE Pessoa SET Nome = ? , idPessoa = ? WHERE idPessoa = ?");
        stmt.setString(1, a.getPf().getNome());
        stmt.setInt(2, a.getIdPessoa());
        
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex){
        JOptionPane.showMessageDialog(null, "Erro ao atualizar" + ex);
        } finally{
         connection.conexao.Desconectar();
        }
       
    }//public update
       public void delete(Pessoa p){
    
        connection.conexao.Conectar();
        
        PreparedStatement stmt = null;
        
        try{
        stmt = con.prepareStatement("DELETE FROM Pessoa WHERE idPessoa = ?");
        stmt.setInt(1, p.getIdPessoa());
        
        stmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex){
        JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally{
            connection.conexao.Desconectar();
        }
    }//public delete
    
}//public class AlunoDAO fim

