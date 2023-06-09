/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pojo;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name="fornecedor")
public class Fornecedor implements Serializable{
    
    @Id
    private int idFornecedor;
    private String nome;
    private String cnpj;
    private String cpf;
    private String rg;
    private String data_nasc;
    private String email;
    private String cep;
    private String uf;
    private String cidade;
    private String bairro;
    private String logradouro;
    
    public Fornecedor(){
    }
    
    public Fornecedor(String cnpj, String cpf, String rg, String data_nasc, String nome, String cep, String uf, String cidade, String bairro, String logradouro) {
        this.cnpj       = cnpj;
        this.cpf        = cpf;
        this.rg         = rg;
        this.data_nasc  = data_nasc;
        this.nome       = nome;
        this.cep        = cep;
        this.uf         = uf;
        this.cidade     = cidade;
        this.bairro     = bairro;
        this.logradouro = logradouro;
    }
    
    public Fornecedor(int id, String cnpj, String cpf, String rg, String data_nasc, String nome, String cep, String uf, String cidade, String bairro, String logradouro) {
        this.idFornecedor = id;
        this.cnpj       = cnpj;
        this.cpf        = cpf;
        this.rg         = rg;
        this.data_nasc  = data_nasc;
        this.nome       = nome;
        this.cep        = cep;
        this.uf         = uf;
        this.cidade     = cidade;
        this.bairro     = bairro;
        this.logradouro = logradouro;
    }
       
    // GETTERS ----------
    public int getID(){
        return this.idFornecedor;
    }
    
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
    
    public String getBairro(){
        return this.bairro;
    }
    
    public String getLogradouro(){
        return this.logradouro;
    }
    
    // SETTERS ----------
    public void setID(int id){
        this.idFornecedor = id;
    }
    
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
    
    public void setUF(String uf){
        this.uf = uf;
    }
    
    public void getCidade(String cidade){
        this.cidade = cidade;
    }
    
    public void getBairro(String bairro){
        this.bairro = bairro;
    }
    
    public void getLogradouro(String logradouro){
        this.logradouro = logradouro;
    }
}
