/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DOMAIN.OrdemDeServico;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class OrdemDeServicoDao extends OrdemDeServico{
    Connection x = null;
    PreparedStatement ps = null;
    
    public void incluirOrdem(OrdemDeServico ordemdeservico){
        ConexaoDao con = new ConexaoDao();
        x=con.obterConexao();
        String sql = "INSERT INTO ordemdeservico (ceCliente, dtEntrega, situacao, ceOrdem) VALUE (?,?,?,?)";
        try {
            ps=x.prepareStatement(sql);
            ps.setInt(1, ordemdeservico.getCeCliente());
            ps.setDate(2, (Date) ordemdeservico.getDtEntrega());
            ps.setString(3, ordemdeservico.getSituacao());
            ps.setInt(4, ordemdeservico.getCeOrdem());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao incluir: " + e);
        }
        
    }
}
