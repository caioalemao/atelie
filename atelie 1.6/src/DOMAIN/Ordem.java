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
public class Ordem {
    private int cePeca;
    private int ceServico;
    private int id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getCePeca() {
        return cePeca;
    }

    public void setCePeca(Integer cePeca) {
        this.cePeca = cePeca;
    }

    public Integer getCeServico() {
        return ceServico;
    }

    public void setCeServico(Integer ceServico) {
        this.ceServico = ceServico;
    }
    
    
    
    
}
