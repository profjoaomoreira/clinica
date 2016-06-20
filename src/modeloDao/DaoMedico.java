/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDao;

import modeloConection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansMedico;

public class DaoMedico {
    ConexaoBD conex = new ConexaoBD();
    BeansMedico mod = new BeansMedico();

public void Salvar(BeansMedico mod){
    conex.conexao();
try{
    PreparedStatement pst = conex.con.prepareStatement("insert into medicos (nome_medico, especialidade_medico,crm_medico) values(?,?,?)");
    pst.setString(1, mod.getNome());
    pst.setString(2, mod.getEspecialidade());
    pst.setInt(3, mod.getCrm());
    pst.execute();
    JOptionPane.showMessageDialog(null,"Dados inseridos com sucesso!!");
}catch(SQLException ex){
    JOptionPane.showMessageDialog(null, "Erro ao inserir dados!\nErro: "+ex);
}
    conex.desconecta();
}   
}

