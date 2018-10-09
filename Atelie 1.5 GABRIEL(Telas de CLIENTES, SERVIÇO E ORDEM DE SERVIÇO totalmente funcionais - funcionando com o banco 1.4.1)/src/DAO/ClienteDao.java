package DAO;

import DOMAIN.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 * 
 * @author Gabriel Torres
 * @since 24/09/2018
 */
public class ClienteDao extends Cliente{
    Connection con = null;
    PreparedStatement ps = null;
    
    public void  incluirCliete(Cliente cliente){
            ConexaoDao conexao = new ConexaoDao();
            con = conexao.obterConexao();
            String sql = "INSERT INTO cliente (nome, CPF, dtNasc, rua, bairro, numero, cidade, estado, cep, telefone, rg, sexo) VALUE(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareCall(sql);
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setDate(3, (java.sql.Date) cliente.getDtNasc());
            ps.setString(4, cliente.getRua());
            ps.setString(5, cliente.getBairro());
            ps.setString(6, cliente.getNumero());
            ps.setString(7, cliente.getCidade());
            ps.setString(8, cliente.getEstado());
            ps.setString(9, cliente.getCep());
            ps.setString(10, cliente.getTelefone());
            ps.setString(11, cliente.getRg());
            ps.setString(12, cliente.getSexo());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente Incluido com Sucesso"); 
        } catch (Exception e) {
        System.out.println("ERRO no incluir-Cliente:" + e.getMessage());//identifica onde esta o ERRO
        }//fim catch
    }//Fim inserirCliente
    
    
    public void alterarCliente (Cliente cliente){
        ConexaoDao conexao = new ConexaoDao();
        con = conexao.obterConexao();
        String sql = "update cliente set  nome=?, CPF=?, dtNasc=?, rua=?, bairro=?, numero=?, cidade=?, estado=?, cep=?, telefone=?, rg=?, sexo=? where idCliente = ?";
        try {
            ps = con.prepareCall(sql);
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setDate(3, (java.sql.Date) cliente.getDtNasc());
            ps.setString(4, cliente.getRua());
            ps.setString(5, cliente.getBairro());
            ps.setString(6, cliente.getNumero());
            ps.setString(7, cliente.getCidade());
            ps.setString(8, cliente.getEstado());
            ps.setString(9, cliente.getCep());
            ps.setString(10, cliente.getTelefone());
            ps.setString(11, cliente.getRg());
            ps.setString(12, cliente.getSexo());
            ps.setInt(13, cliente.getIdCliente());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente Alterado com Sucesso"); 
        } catch (Exception e) {
        System.out.println("ERRO no alterar-Cliente:" + e.getMessage());//identifica onde esta o ERRO
        }//fim catch
        
        
    }//Fim inserirCliente
    
    public ResultSet consultarCliente(){
    ResultSet rs = null;
        try {
            ConexaoDao conexao = new ConexaoDao();
            con = conexao.obterConexao();
            String sql = "select *from cliente";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println("Cliente obtidos com sucesso");
        } catch (Exception e) {
            System.out.println("ERRO AO OBTER CLIENTES!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;
    }//FIM consultarCliente
    
    public ResultSet selecionarCliente(Cliente cliente){
        ResultSet rs = null;
        try {
            ConexaoDao conexao = new ConexaoDao();
            con = conexao.obterConexao();
            String sql = "select *from cliente where idCliente = ? ";
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getIdCliente());
            rs = ps.executeQuery();
            System.out.println("Cliente obtidos com sucesso");
        } catch (Exception e) {
            System.out.println("ERRO AO SELECIONAR CLIENTE!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;
    }
    
    
    public void excluirCliente(Cliente cliente){
        ConexaoDao conexao=new ConexaoDao();
            con = conexao.obterConexao();
            try{
                String sql = "delete from cliente where idCliente=?";
                ps= con.prepareStatement(sql);
                ps.setInt(1, cliente.getIdCliente());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR CLIENTE!");
                System.out.println(e.getMessage());
            }
      
        }//fim do metodo excluir serciço

    public ResultSet pesquisarClientePorNome(String nome){
            ResultSet rs = null;
            ConexaoDao conexao = new ConexaoDao();
            con = conexao.obterConexao();
            try{
                String sql = "Select * from cliente where nome like ?";
                ps = con.prepareCall(sql);
                ps.setString(1, nome + "%");
                rs = ps.executeQuery();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "ERRO AO PESQUISAR!");
                System.out.println(e.getMessage());
            }
            return rs;
        }//fim do método pesquisarClientePorNome
   
    public ResultSet selecionarClienteNome (Cliente cliente){
        ResultSet rs = null;
        try {
            ConexaoDao conexao = new ConexaoDao();
            con = conexao.obterConexao();
            String sql = "select *from cliente where nome = ? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            rs = ps.executeQuery();
            System.out.println("Cliente obtidos com sucesso");
        } catch (Exception e) {
            System.out.println("ERRO AO SELECIONAR CLIENTE!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;
  
    }
    
}//Fim da classe ClienteDao
