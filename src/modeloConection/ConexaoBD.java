/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloConection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoBD {
    
    public Statement stm;
    public ResultSet rs;
    private String driver = "org.postgresql.Driver";
    private String caminho = "jdbc:postgresql://localhost:5432/projetoclinica";
    private String usuario = "postgres";
    private String senha = "1";
    public Connection con;
    
    public void conexao(){//metodo responsavel por realizar conexao com a base de dados
        
        try {
            System.setProperty("jdbc.Drivers", driver);
            con=DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "Conexao Efeturada com Sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao se concetar com o banco de  dados:\n"+ex.getMessage());
        }
    }
    public void executasql (String sql){
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro executaSQL:\n "+ex.getMessage());
        }
    }
    public void desconecta(){
        try {
            con.close();
            //JOptionPane.showMessageDialog(null,"BD Desconectado com sucesso");
        }catch (SQLException ex) { 
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexao com BD\n"+ex.getMessage());
        
        }
    }
}
    