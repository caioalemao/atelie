/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DOMAIN.Pagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class PagamentoDao extends Pagamento{
     Connection x = null;
     PreparedStatement ps = null;
     
     public void incluirPagamento(Pagamento pagamento){
         ConexaoDao con = new ConexaoDao();
         x = con.obterConexao();
         String sql = "INSERT INTO Pagamento (valorTotal, statusPag, formaPag,numParcela, valorParcela, ceOrdemServico) VALUE (?,?,?,?,?,?)";
         try{
             ps=x.prepareCall(sql);
             ps.setFloat(1, pagamento.getValorTotal());
             ps.setString(2,pagamento.getSatatusPag());
             ps.setString(3,pagamento.getFormaPag());
             ps.setInt(4, pagamento.getNumParc());
             ps.setFloat(5, pagamento.getValorParc());
             ps.setInt(6, pagamento.getCeOrdemServico());
             ps.executeUpdate();
        }
         catch(SQLException e){
             System.err.println("Erro ao incluir: " + e);
         }
     }
   
    
}
