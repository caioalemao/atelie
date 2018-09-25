/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DOMAIN.Peca;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Aluno
 */
public class PecaDao extends Peca{
    Connection x = null;
    PreparedStatement ps = null;
    
    public void incluirPeca(Peca peca){
        String b = peca.getDescricao();
        ConexaoDao con = new ConexaoDao();
        x = con.obterConexao();
        String sql = "INSERT INTO peca (descricao) VALUE(?)";
        try{
        ps=x.prepareCall(sql);
        ps.setString(1, b);
        ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("ERRO AO INCLUIR PEÇA: " + e.getMessage());
        }
    }
    public void alterarPeca(String b, Integer a){
        ConexaoDao con = new ConexaoDao();
        x = con.obterConexao();
        String sql = "UPDATE peca SET descricao=? WHERE idPeca = ?";
        try{
            ps=x.prepareStatement(sql);
            ps.setString(1, b);
            ps.setInt(2, a);
            ps.executeUpdate();
           JOptionPane.showMessageDialog(null,"Atualização feita!"); 
        }catch(HeadlessException | SQLException e){
            System.out.println("ERRO AO ATUALIZAR PEÇA: " + e.getMessage());
        }       
                
    }
    
    public ResultSet consultarPeca(Integer a){
        ResultSet rs = null;
        try {
            ConexaoDao con = new ConexaoDao();
            x = con.obterConexao();
            String sql = "SELECT * FROM peca WHERE idPeca = ?";
            ps = x.prepareStatement(sql);
            ps.setInt(1, a);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Erro ao obterPaciente");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;
    }
    
    public void excluirPeca(Integer a){
        ConexaoDao conexao = new ConexaoDao();
        x = conexao.obterConexao();
        try{
            String sql = "DELETE FROM peca WHERE idpeca = ?";
            ps= x.prepareStatement(sql);
            ps.setInt(1, a);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "PECA EXCUIDA COM SUCESSO!");
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR PECA");
            System.out.println(e.getMessage());
        }
    }
            
    
}
