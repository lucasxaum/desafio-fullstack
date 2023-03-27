/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author User
 */

@Entity
@Table(name="oferece", schema="desafio_fullstack_acc")
public class Oferece implements Serializable{
    
    @Id
    private int idoferece;
    private int empresa_id;
    private int fornecedor_id;
    
    public Oferece(){
        
    }
    
    public Oferece(int empresa_id, int fornecedor_id){
        this.empresa_id = empresa_id;
        this.fornecedor_id = fornecedor_id;
    }
    
    public int getEmpresaID(){
        return this.empresa_id;
    }
    
    public int getFornecedorID(){
        return this.fornecedor_id;
    }
}
