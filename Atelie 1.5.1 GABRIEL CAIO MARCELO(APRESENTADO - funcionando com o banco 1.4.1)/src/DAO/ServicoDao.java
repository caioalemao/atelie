/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DOMAIN.Cliente;
import DOMAIN.Servico;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class ServicoDao extends Servico{
    
  
    Connection con = null;
    PreparedStatement ps = null;
    public void  incluirServico(Servico servico){

        try {
            ConexaoDao conexao = new ConexaoDao();
            con = conexao.obterConexao();
            String sql = "insert into servico (nome, tempo, valor) Value(?,?,?)";
            ps = con.prepareCall(sql);
            ps.setString(1, servico.getNome());
            ps.setTime(2, (Time) servico.getTempoExec());
            ps.setFloat(3, servico.getPreco());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Serviço Incluido com Sucesso"); 
        } catch (HeadlessException | SQLException e) {
        System.out.println("ERRO no incluir-Serviço:" + e.getMessage());//identifica onde esta o ERRO
        }//fim catch
    }//Fim inserirServiço
       
    public void alterarServico(Servico servico){
     
           ConexaoDao conexao = new ConexaoDao();
           con = conexao.obterConexao();
           String sql = "update servico set nome=?, valor=?, tempo=? where idServico=?";
          try{
           ps= con.prepareStatement(sql);
           ps.setString(1, servico.getNome());
           ps.setTime(3, (Time) servico.getTempoExec());
           ps.setFloat(2, servico.getPreco());
           ps.setInt(4, servico.getId());
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null,"Atualização Realizada com Sucesso!");  
          } 
           catch(HeadlessException | SQLException e){
                   JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR SERVIÇO");
                   System.out.println(e.getMessage());
                   } 
            
        //fim metodo atualizar dentista
    }
    
     public void excluirServico(Servico servico){
            ConexaoDao conexao=new ConexaoDao();
            con = conexao.obterConexao();
            try{
                String sql = "delete from servico where idServico=?";
                ps= con.prepareStatement(sql);
                ps.setInt(1, servico.getId());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Serviço excluido com sucesso!");
            }catch (HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR SERVIÇO!");
                System.out.println(e.getMessage());
            }
      
        }//fim do metodo excluir serciço
    
     public ResultSet consultarServico(){
        ResultSet rs = null;
        try {
            ConexaoDao conexao = new ConexaoDao();
            con = conexao.obterConexao();
            String sql = "select *from servico";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println("Serviços obtidos com sucesso");
        } catch (SQLException e) {
            System.out.println("ERRO AO OBTER SERVIÇOS!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;
    }
     
     public ResultSet selecionarServico(Servico servico){
        ResultSet rs = null;
        try {
            ConexaoDao conexao = new ConexaoDao();
            con = conexao.obterConexao();
            String sql = "select *from servico where idServico = ? ";
            ps = con.prepareStatement(sql);
            ps.setInt(1, servico.getId());
            rs = ps.executeQuery();
            System.out.println("Servico obtidos com sucesso");
        } catch (Exception e) {
            System.out.println("ERRO AO SELECIONAR SERVICO!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;
    }
     
    public ResultSet ordenarPorNome(){
            ResultSet rs = null;
            ConexaoDao conexao = new ConexaoDao();
            con = conexao.obterConexao();
            try{
                String sql = "Select * from servico order by nome";
                ps = con.prepareCall(sql);
                rs = ps.executeQuery();
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "ERRO AO PESQUISAR!");
                System.out.println(e.getMessage());
            }
            return rs;
        }
    
    public ResultSet ordenarPorValor(){
            ResultSet rs = null;
            ConexaoDao conexao = new ConexaoDao();
            con = conexao.obterConexao();
            try{
                String sql = "Select * from servico order by valor desc";
                ps = con.prepareCall(sql);
                rs = ps.executeQuery();
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "ERRO AO ORDENAR!");
                System.out.println(e.getMessage());
            }
            return rs;
        }
    
    public ResultSet selecionarServicoNome (Servico servico){
        ResultSet rs = null;
        try {
            ConexaoDao conexao = new ConexaoDao();
            con = conexao.obterConexao();
            String sql = "select *from servico where nome = ? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, servico.getNome());
            rs = ps.executeQuery();
            System.out.println("Servico obtidos com sucesso");
        } catch (Exception e) {
            System.out.println("ERRO AO SELECIONAR SERVICO!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;
  
    }

    
    
    
    }