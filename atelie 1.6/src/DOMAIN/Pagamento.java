/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOMAIN;

/**
 *
 * @author Aluno
 */
public class Pagamento {
    private Integer idPagamento;
    private float valorTotal;
    private String satatusPag;
    private String formaPag;
    private Integer ceOrdemServico;
    private int numParc;
    private float valorParc;

    public Integer getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public int getNumParc() {
        return numParc;
    }

    public void setNumParc(int numParc) {
        this.numParc = numParc;
    }

    public float getValorParc() {
        return valorParc;
    }

    public void setValorParc(float valorParc) {
        this.valorParc = valorParc;
    }
    
    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getSatatusPag() {
        return satatusPag;
    }

    public void setSatatusPag(String satatusPag) {
        this.satatusPag = satatusPag;
    }

    public String getFormaPag() {
        return formaPag;
    }

    public void setFormaPag(String formaPag) {
        this.formaPag = formaPag;
    }

    public Integer getCeOrdemServico() {
        return ceOrdemServico;
    }

    public void setCeOrdemServico(Integer ceOrdemServico) {
        this.ceOrdemServico = ceOrdemServico;
    }
    
}
