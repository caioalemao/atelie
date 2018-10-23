/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DOMAIN.Peca;
import DOMAIN.Ordem;
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
    Connection con= null;
    PreparedStatement ps = null;
    
    public void incluirPeca(Peca peca){
        String b = peca.getDescricao();
        ConexaoDao conexao = new ConexaoDao();
        con = conexao.obterConexao();
        String sql = "INSERT INTO peca (descricao) VALUE(?)";
        try{
        ps=con.prepareCall(sql);
        ps.setString(1, b);
        ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("ERRO AO INCLUIR PEÇA: " + e.getMessage());
        }
    }
    public void alterarPeca(String b, Integer a){
        ConexaoDao conexao = new ConexaoDao();
        con = conexao.obterConexao();
        String sql = "UPDATE peca SET descricao=? WHERE idPeca = ?";
        try{
            ps=con.prepareStatement(sql);
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
            ConexaoDao conexao = new ConexaoDao();
            con = conexao.obterConexao();
            String sql = "SELECT * FROM peca WHERE idPeca = ?";
            ps = con.prepareStatement(sql);
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
        con = conexao.obterConexao();
        try{
            String sql = "DELETE FROM peca WHERE idpeca = ?";
            ps= con.prepareStatement(sql);
            ps.setInt(1, a);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "PECA EXCUIDA COM SUCESSO!");
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR PECA");
            System.out.println(e.getMessage());
        }
    }
    
    public ResultSet obterPecasPorOrdem (Ordem ordem ){
        
        ResultSet rs = null;
        try {
            ConexaoDao conexao = new ConexaoDao();
            con = conexao.obterConexao();
            String sql = "SELECT idPeca, descricao  FROM ordem , peca  where ordem.cePeca = peca.idPeca and ordem.idOrdem = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, ordem.getId()); 
            rs = ps.executeQuery();
            System.out.println("Peça obtida com sucesso");
        } catch (Exception e) {
            System.out.println("ERRO AO SELECIONAR PEÇA!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;
     
        
    }
    
    public ResultSet selecionarPecaNome (Peca peca){
        ResultSet rs = null;
        try {
            ConexaoDao conexao = new ConexaoDao();
            con = conexao.obterConexao();
            String sql = "select *from peca where descricao = ? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, peca.getDescricao());
            rs = ps.executeQuery();
            System.out.println("Peça obtida com sucesso");
        } catch (Exception e) {
            System.out.println("ERRO AO SELECIONAR PEÇA!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;
        
    }
            
    
}
