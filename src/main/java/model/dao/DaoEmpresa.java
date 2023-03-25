/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import model.pojo.Empresa;

/**
 *
 * @author User
 */
public class DaoEmpresa extends DaoBase{
    
    public List<Empresa> buscarEmpresas(Empresa empresa) {
        EntityManager em = super.getEntityManager();
        try {
            String strSQL = "SELECT * FROM empresa ";
            if (empresa.getCNPJ() != null) {
                strSQL += "WHERE cnpj='" + empresa.getCNPJ() + "' ";
            } else if (empresa.getNomeFant() != null) {
                strSQL += "WHERE nomeFant LIKE '%" + empresa.getNomeFant() + "%' ";
            }
            em.getTransaction().begin();

            Query query = em.createNativeQuery(strSQL, Empresa.class);
            List<Empresa> teste = query.getResultList();
           
            for (Empresa casa: teste){
                System.out.println("CNPJ: " + casa.getCNPJ());
                System.out.println("NomeFant.: " + casa.getNomeFant());
            }
            
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Empresa Vazio");
            return null;
        } finally {
            em.close();
        }
    }
}

