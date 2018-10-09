/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DOMAIN.Ordem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class OrdemDao extends Ordem{
    Connection con = null;
    PreparedStatement ps = null;
    
    public void incluirOrdem(Ordem ordem){
        ConexaoDao conexao = new ConexaoDao();
        con=conexao.obterConexao();
        String sql = "INSERT INTO ordem (idOrdem, cePeca, ceServico) VALUE (?,?,?)";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, ordem.getId());
            ps.setInt(2, ordem.getCePeca());
            ps.setInt(3, ordem.getCeServico());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao incluir: " + e);
        }
        
    }
    
    public ResultSet obterUltimaOrdem (){   
        ResultSet rs = null;
        try {
            ConexaoDao conexao = new ConexaoDao();
            con = conexao.obterConexao();
            String sql = "SELECT MAX(idOrdem) FROM ordem";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println("Ordem obtido com sucesso");
        } catch (Exception e) {
            System.out.println("ERRO AO OBTER ORDEM!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs; 
        
        
        }
    
    
}
