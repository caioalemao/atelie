/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DOMAIN.OrdemDeServico;
import DOMAIN.Ordem;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class OrdemDeServicoDao extends OrdemDeServico{
    Connection con = null;
    PreparedStatement ps = null;
    
    public void incluirOrdem(OrdemDeServico ordemdeservico){
        ConexaoDao conexao = new ConexaoDao();
        con=conexao.obterConexao();
        String sql = "INSERT INTO ordemdeservico (ceCliente, dtEntrega, situacao, ceOrdem, valorTotal) VALUE (?,?,?,?,?)";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, ordemdeservico.getCeCliente());
            ps.setDate(2, ordemdeservico.getDtEntrega());
            ps.setString(3, ordemdeservico.getSituacao());
            ps.setInt(4, ordemdeservico.getCeOrdem());
            ps.setFloat(5, ordemdeservico.getValortotal());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Severviço incluido com sucesso");
        } catch (SQLException e) {
            System.err.println("Erro ao incluir: " + e);
        }
        
    }
    
    public int contar(){ // metodo para contar o numero de linhas da tabela e retornar esse valor
         ConexaoDao conexao = new ConexaoDao();
        con = conexao.obterConexao();
        ResultSet rs = null;
        String sql = "Select * from ordemdeservico order by idOrdemDeServico";
        try{
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
        }catch(SQLException e){
            System.out.println(e);
        }
       int i=0 ;
        try {
            while(rs.next()){
                 i =    rs.getInt("MAX(idOrdem)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdemDeServicoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    
     public void alterarOrdem(OrdemDeServico ods){
     
        ConexaoDao conexao = new ConexaoDao();
        con = conexao.obterConexao();
        String sql = "UPDATE ordemdeservico set dtEntrega = ?, situacao = ? where idOrdemDeServico=?";
        try{
           ps= con.prepareStatement(sql);
           ps.setDate(1, ods.getDtEntrega());
           ps.setString(2, ods.getSituacao());
           ps.setFloat(3, ods.getId());
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null,"Atualização Realizada com Sucesso!");  
        }catch(HeadlessException | SQLException e){
                   JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR ORDEM DE SERVIÇO");
                   System.out.println(e.getMessage());
        } 
            
        //fim metodo atualizar dentista
    }

    public ResultSet pegarPrecos (OrdemDeServico ordem){
    ResultSet rs = null;
        try {
            ConexaoDao conexao = new ConexaoDao();
            con = conexao.obterConexao();
            String sql = "SELECT  valor FROM ordem , peca, servico  WHERE ordem.cePeca = peca.idPeca AND ordem.ceServico = servico.idServico AND idOrdem = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, ordem.getCeOrdem()); 
            rs = ps.executeQuery();
            
            System.out.println("Valor(es) obtido(s) com sucesso");
        } catch (Exception e) {
            System.out.println("ERRO AO PEGAR VALOR(ES)!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;
    }
    
    
    public ResultSet pegarDadosParaTabela(){
        ResultSet rs = null;
        try {
            ConexaoDao conexao = new ConexaoDao();
            con = conexao.obterConexao();
            String sql = "Select idOrdemDeServico,nome ,dtEntrega, situacao, valorTotal from ordemdeservico , cliente where ordemdeservico.ceCliente = cliente.idCliente ORDER by idOrdemDeServico";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println("Ordens de Serviço obtidas com sucesso");
        } catch (SQLException e) {
            System.out.println("ERRO AO OBTER ORDENS SERVIÇOS!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;
    }
    
    public ResultSet selecionarOrdem(OrdemDeServico ods){
        ResultSet rs = null;
        try {
            ConexaoDao conexao = new ConexaoDao();
            con = conexao.obterConexao();
            String sql = "select *from ordemdeservico where idOrdemDeServico = ? ";
            ps = con.prepareStatement(sql);
            ps.setInt(1, ods.getId());
            rs = ps.executeQuery();
            System.out.println("Ordem de Servico obtida com sucesso");
        } catch (Exception e) {
            System.out.println("ERRO AO SELECIONAR ORDEM DE SERVICO!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;  
    }
    
    
    
    public ResultSet pesquisarODSPorNome(String nome){
        ResultSet rs = null;
        ConexaoDao conexao = new ConexaoDao();
        con = conexao.obterConexao();
        try{
            String sql = "Select idOrdemDeServico,nome ,dtEntrega, situacao, valorTotal from ordemdeservico , cliente where ordemdeservico.ceCliente = cliente.idCliente and cliente.nome like ? order by nome";
            ps = con.prepareCall(sql);
            ps.setString(1, nome + "%");
            rs = ps.executeQuery();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERRO AO PESQUISAR!");
            System.out.println(e.getMessage());
            }
        return rs;
    }
    public void excluirODS (OrdemDeServico ods){
            ConexaoDao conexao=new ConexaoDao();
            con = conexao.obterConexao();
            try{
                String sql = "delete from ordemdeservico where idOrdemDeServico=?";
                ps= con.prepareStatement(sql);
                ps.setInt(1, ods.getId());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Ordem De Serviço excluida com sucesso!");
            }catch (HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR ORDEM DE SERVIÇO!");
                System.out.println(e.getMessage());
            }
      
        }//fim do metodo excluir serciço
}    
    /*
    public void alterarOrdem(OrdemDeServico ods){
     
           ConexaoDao conexao = new ConexaoDao();
           con = conexao.obterConexao();
           String sql = "UPDATE ordemdeservico set nome=?, valor=?, tempo=? where idServico=?";
          try{
           ps= con.prepareStatement(sql);
           ps.setString(1, ods.getNome());
           ps.setTime(3, (Time) ods.getTempoExec());
           ps.setFloat(2, ods.getPreco());
           ps.setInt(4, ods.getId());
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null,"Atualização Realizada com Sucesso!");  
          } 
           catch(HeadlessException | SQLException e){
                   JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR SERVIÇO");
                   System.out.println(e.getMessage());
                   } 
            
        //fim metodo atualizar dentista
    }
    
     public void excluirOrdem(OrdemDeServico ods){
            ConexaoDao conexao=new ConexaoDao();
            con = conexao.obterConexao();
            try{
                String sql = "delete from servico where idServico=?";
                ps= con.prepareStatement(sql);
                ps.setInt(1, ods.getCeCliente());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Serviço excluido com sucesso!");
            }catch (HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR SERVIÇO!");
                System.out.println(e.getMessage());
            }
      
        }//fim do metodo excluir serciço
    
     public ResultSet consultarOrdem(){
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
     
     public ResultSet selecionarOrdem(OrdemDeServico ods){
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
*/

