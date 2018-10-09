package DOMAIN;

import java.sql.Date;

/**
 *
 * @author Aluno
 */
public class OrdemDeServico {
    private int id;
    private Integer ceCliente;
    private Date dtEntrega;
    private String situacao;
    private Integer ceOrdem;
    private float valortotal;

    
    
    
    public float getValortotal() {
        return valortotal;
    }

    public void setValortotal(float valortotal) {
        this.valortotal = valortotal;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCeCliente() {
        return ceCliente;
    }

    public void setCeCliente(Integer ceCliente) {
        this.ceCliente = ceCliente;
    }

    public Date getDtEntrega() {
        return dtEntrega;
    }

    public void setDtEntrega(Date dtEntrega) {
        this.dtEntrega = dtEntrega;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Integer getCeOrdem() {
        return ceOrdem;
    }

    public void setCeOrdem(Integer ceOrdem) {
        this.ceOrdem = ceOrdem;
    }
}