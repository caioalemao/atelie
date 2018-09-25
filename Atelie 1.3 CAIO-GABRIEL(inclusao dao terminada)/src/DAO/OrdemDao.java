/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DOMAIN.Ordem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class OrdemDao extends Ordem{
    Connection x = null;
    PreparedStatement ps = null;
    
    public void incluirOrdem(Ordem ordem){
        ConexaoDao con = new ConexaoDao();
        x=con.obterConexao();
        String sql = "INSERT INTO ordem (cePeca, ceServico) VALUE (?,?)";
        try {
            ps=x.prepareStatement(sql);
            ps.setInt(1, ordem.getCePeca());
            ps.setInt(2, ordem.getCeServico());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao incluir: " + e);
        }
        
    }
}
