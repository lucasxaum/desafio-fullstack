/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import model.pojo.Empresa;

/**
 *
 * @author User
 */
public class DaoEmpresa extends DaoBase{
    
    public List<Empresa> buscarEmpresas(Empresa empresa) {
        EntityManager em = super.getEntityManager();
        try {
            String strSQL = "SELECT e FROM empresa e ";
            if (empresa.getCNPJ() != null) {
                strSQL += "WHERE e.cnpj='" + empresa.getCNPJ() + "' ";
            } else if (empresa.getNomeFant() != null) {
                strSQL += "WHERE e.nomeFant LIKE '" + empresa.getNomeFant() + "%' ";
            }
            strSQL += "ORDER BY NOME ASC";
            em.getTransaction().begin();

            Query query = em.createQuery(strSQL);

            return (List<Empresa>) query.getResultList();
        } catch (PersistenceException e) {
            return null;
        } finally {
            em.close();
        }
    }
}

