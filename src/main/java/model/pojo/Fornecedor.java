/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name="fornecedor")
public class Fornecedor implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "idfornecedor", unique = true, nullable = false)
    private int idFornecedor;
    @Column (name = "cnpj")
    private String cnpj;
    @Column (name = "cpf")
    private String cpf;
    @Column (name = "rg")
    private String rg;
    @Column (name = "data_nasc")
    private String data_nasc;
    @Column (name = "nome")
    private String nome;
    @Column (name = "email")
    private String email;
    @Column (name = "cep")
    private String cep;
    @Column (name = "uf")
    private String uf;
    @Column (name = "cidade")
    private String cidade;
    @Column (name = "logradouro")
    private String logradouro;
    
    public Fornecedor(){
    }
    
    public Fornecedor(String cnpj, String cpf, String rg, String data_nasc, String nome, String cep, String uf, String cidade, String logradouro) {
        this.cnpj       = cnpj;
        this.cpf        = cpf;
        this.rg         = rg;
        this.data_nasc  = data_nasc;
        this.nome       = nome;
        this.cep        = cep;
        this.uf         = uf;
        this.cidade     = cidade;
        this.logradouro = logradouro;
    }
       
    // GETTERS ----------
    public String getCNPJ(){
        return this.cnpj;
    }
    
    public String getCPF(){
        return this.cpf;
    }
    
    public String getRG(){
        return this.rg;
    }
    
    public String getDataNasc(){
        return this.data_nasc;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getEmail(){
        return this.email;
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
    
    public void setCPF(String cpf){
        this.cpf = cpf;
    }
    
    public void setRG(String rg){
        this.rg = rg;
    }
    
    public void setDataNasc(String data_nasc){
        this.data_nasc = data_nasc;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setCEP(String cep){
        this.cep = cep;
    }
}