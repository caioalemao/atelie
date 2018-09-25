/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Caio Illich Dias Campos
 * @since 04/09/2018
 * @version 1.0
 */
public class ClienteDaoCaio {
    private Integer idCliente; 
    private String name;
    private String cpf;
    private String rg;
    private String sexo;
    private String telefone;
    private String cep;
    private String rua;
    private String bairro;
    private String numero;
    private String cidade;
    private String estado;
    private Date dtNasc;
    private Date dtCad;
    private String celular;
    Connection x = null;
    PreparedStatement ps = null;
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public ClienteDaoCaio(String name, String cpf, String rg, String sexo, String telefone,String cep, String rua,String bairro, String numero,String cidade, String estado, Date dtNasc,Date dtCad, String celular, Integer idCliente){
        setName(name);
        setCpf(cpf);
        setRg(rg);
        setSexo(sexo);
        setTelefone(telefone);
        setCep(cep);
        setRua(rua);
        setBairro(bairro);
        setNumero(numero);
        setCidade(cidade);
        setEstado(estado);
        setDtNasc(dtNasc);
        setDtCad(dtCad);
        setCelular(celular);
        setIdCliente(idCliente);
        
    }
    
    public void incluirCliente(){
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        String name = getName();
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        String cpf = getCpf();
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        String rg = getRg();
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        String sexo = getSexo();
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        String telefone = getTelefone();
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        String rua = getRua();
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        String bairro = getBairro();
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        String cidade = getCidade();
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        String estado = getEstado();
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        String cep = getCep();
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        String numero = getNumero();
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Date dtNasc = getDtNasc();
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Date dtCad = getDtCad();
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        String celular = getCelular();
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Integer idCliente = getIdCliente();

        ConexaoDao con = new ConexaoDao();
        x = con.obterConexao();

        String sql = "INSERT INTO cliente (idCliente,nome,CPF, dtNasc, rua, bairro, numero, cidade, estado, cep, telefone, rg, sexo, dtcadastro) VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
        ps=x.prepareCall(sql);
        ps.setInt(1, idCliente);
        ps.setString(2,name);
        ps.setString(3, cpf);
        ps.setDate(4, (java.sql.Date) dtNasc);
        ps.setString(5, rua);
        ps.setString(6, bairro);
        ps.setString(7, numero);
        ps.setString(8, cidade);
        ps.setString(9, estado);
        ps.setString(10, cep);
        ps.setString(11, telefone);
        ps.setString(12, rg);
        ps.setString(13, sexo);
        ps.setDate(14, (java.sql.Date) dtCad);
        ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("ERRO AO INCLUIR PEÇA: " + e.getMessage());
        }
      
    }
    
    public void consultarCliente(){
        
    }
    
    public void alterarCliente(){
        
    }
    
    public void excluirCLiente(){
        
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the endereco
     */

    /**
     * @return the dtNasc
     */
    public Date getDtNasc() {
        return dtNasc;
    }

    /**
     * @param dtNasc the dtNasc to set
     */
    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    /**
     * @return the dtCad
     */
    public Date getDtCad() {
        return dtCad;
    }

    /**
     * @param dtCad the dtCad to set
     */
    public void setDtCad(Date dtCad) {
        this.dtCad = dtCad;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }
  
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
