package DOMAIN;

import java.util.Date;

/**
 *
 * @author Aluno
 */
public class OrdemDeServico {
    private Integer ceCliente;
    private Date dtEntrega;
    private String situacao;
    private Integer ceOrdem;

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