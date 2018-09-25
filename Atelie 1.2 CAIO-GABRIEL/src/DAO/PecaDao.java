/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class PecaDao {
    private String desc;
    private Integer idPeca;
    Connection x = null;
    PreparedStatement ps = null;
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public PecaDao(String desc, Integer idPeca){
        setDesc(desc);
        setIdPeca(idPeca);
    }
    public void incluirPeca(){
        String b = getDesc();
        Integer a = getIdPeca();
        ConexaoDao con = new ConexaoDao();
        x = con.obterConexao();
        String sql = "INSERT INTO peca (idPeca,descricao) VALUE(?,?)";
        try{
        ps=x.prepareCall(sql);
        ps.setInt(1, a);
        ps.setString(2,b);
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
            
    
    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the idPeca
     */
    public Integer getIdPeca() {
        return idPeca;
    }

    /**
     * @param idPeca the idPeca to set
     */
    public void setIdPeca(Integer idPeca) {
        this.idPeca = idPeca;
    }
    
}
