
package model.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
//import javax.persistence.OneToMany;
//import javax.persistence.PostPersist;
//import javax.persistence.PostUpdate;
//import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name="empresa")
public class Empresa implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "idEmpresa", unique = true, nullable = false)
    private int idEmpresa;
    
    @Column (name = "cnpj")
    private String cnpj;
    
    @Column (name = "nomeFant")
    private String nomeFant;
    
    @Column (name = "cep")
    private String cep;
    
    @Column (name = "uf")
    private String uf;
    
    @Column (name = "cidade")
    private String cidade;
    
    @Column (name = "logradouro")
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
