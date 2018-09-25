/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
/**
 *
 * @author Aluno
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDao {
    public Connection conexao;
    
    public ConexaoDao(){
        carregarDriver();
    }
    public void carregarDriver()
    {
        try{
          Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            System.out.println("Erro ao carregar o driver");
        }
    }
    public Connection obterConexao(){
        try{
            String host = "jdbc:mysql://localhost:3306/atelie";
            String usuario = "root";
            String senha = "";
            conexao = DriverManager.getConnection(host, usuario, senha);
            System.out.println("Conectado ao BD com sucesso");
    }
    catch(SQLException e){
        System.out.println("Erro de conexao com o BD");
        System.out.println(e.getMessage()); 
    }
        return conexao;
}  
    
}
