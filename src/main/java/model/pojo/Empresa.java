
package model.pojo;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.persistence.Inheritance;
//import jakarta.persistence.InheritanceType;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.PostPersist;
//import jakarta.persistence.PostUpdate;
//import jakarta.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name="empresa", schema="desafio_fullstack_acc")
public class Empresa implements Serializable{
    
    @Id
    private int idEmpresa;
    private String cnpj;
    private String nomeFant;
    private String cep;
    private String uf;
    private String cidade;
    private String logradouro;
    
    public Empresa(){
    }
    
    public Empresa(String cnpj, String nomeFant, String cep, String uf, String cidade, String logradouro) {
        this.cnpj       = cnpj;
        this.nomeFant   = nomeFant;
        this.cep        = cep;
        this.uf         = uf;
        this.cidade     = cidade;
        this.logradouro = logradouro;
    }
    
    // GETTERS ----------
    public int getIdEmpresa(){
        return this.idEmpresa;
    }
    
    public String getCNPJ(){
        return this.cnpj;
    }
    
    public String getNomeFant(){
        return this.nomeFant;
    }
    
    public String getCEP(){
        return this.cep;
    }
    
    public String getUF(){
        return this.uf;
    }
    
    public String getCidade(){
        return this.cidade;
    }
    
    public String getLogradouro(){
        return this.logradouro;
    }
    
    // SETTERS ----------
    public void setCNPJ(String cnpj){
        this.cnpj = cnpj;
    }
    
    public void setNomeFant(String nomeFant){
        this.nomeFant = nomeFant;
    }
    
    public void setCEP(String cep){
        this.cep = cep;
    }
    
    public void setUF(String uf){
        this.uf = uf;
    }
    
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    
    public void setLogradouro(String logradouro){
        this.logradouro = logradouro;
    }
}
