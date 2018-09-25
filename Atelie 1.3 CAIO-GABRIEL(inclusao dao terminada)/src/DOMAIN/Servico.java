package DOMAIN;

import java.util.Date;

/**
 * Classe Criada para ...
 * @author Gabriel Torres
 * @since 18/09/2018
 */
public class Servico {
    
    private int id;
    private String nome;
    private Date tempoExec;
    private float preco;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getTempoExec() {
        return tempoExec;
    }

    public void setTempoExec(Date tempoExec) {
        this.tempoExec = tempoExec;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
  
    
}//Fim da classe Servico
