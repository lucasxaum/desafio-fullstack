/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author User
 */
public class ControllerFornecedor {
    
    /*
     * Código extraído de: https://pt.stackoverflow.com/questions/69270/calcular-idade-por-dia-mes-e-ano  
     */
    public int idade(LocalDate aniversario) {
        return Period.between(aniversario, LocalDate.now()).getYears();
    }
    
    public boolean verificaFornecedor(LocalDate data, String cidade){
        
        if ((cidade.compareTo("Paraná") == 0) &&  (idade(data)< 18)) {
            // Apresentar erro e não inserir os dados
            // Retornar false
        } else {
            // Não apresentar erro e inserir os dados
            // Retornar true
            
        }
        return false;
        
    }
}
