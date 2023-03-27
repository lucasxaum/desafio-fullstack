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
import model.pojo.Fornecedor;

/**
 *
 * @author User
 */
public class DaoEmpresa extends DaoBase{
    
    public List<Empresa> buscar(Empresa empresa) {
        EntityManager em = super.getEntityManager();
        System.out.print(empresa.getNomeFant());
        try {
            String strSQL = "SELECT * FROM empresa ";
            if ((empresa.getCNPJ() != null) && (!empresa.getCNPJ().equals(""))) {
                strSQL += "WHERE cnpj='" + empresa.getCNPJ() + "' ";
            } else if ((empresa.getNomeFant() != null) && !(empresa.getNomeFant() != null)) {
                strSQL += "WHERE nomeFant LIKE '%" + empresa.getNomeFant() + "%' ";
            }
            em.getTransaction().begin();

            Query query = em.createNativeQuery(strSQL, Empresa.class);
//            List<Empresa> teste = query.getResultList();
//           
//            for (Empresa casa: teste){
//                System.out.println("CNPJ: " + casa.getCNPJ());
//                System.out.println("NomeFant.: " + casa.getNomeFant());
//            }
//            
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Não há a empresa ou empresas no banco de dados");
            return null;
        } finally {
            em.close();
        }
    }
    
    public int criar(Empresa empresa) {
        EntityManager em = super.getEntityManager();
        try {
            String strSQL = "INSERT INTO empresa (cnpj, nomeFant, cep, uf, cidade, bairro, logradouro) VALUES (?,?,?,?,?,?,?)";
            em.getTransaction().begin();
            int query = em.createNativeQuery(strSQL)
                    .setParameter(1, empresa.getCNPJ())
                    .setParameter(2, empresa.getNomeFant())
                    .setParameter(3, empresa.getCEP())
                    .setParameter(4, empresa.getUF())
                    .setParameter(5, empresa.getCidade())
                    .setParameter(6, empresa.getBairro())
                    .setParameter(7, empresa.getLogradouro())
                    .executeUpdate();
            return query;
            
        } catch (PersistenceException e) {
            System.out.println("Não houve inserção no banco de dados");
            return 0;
        } finally {
            em.close();
        }
    }
    
    public int remover(Empresa empresa) {
        EntityManager em = super.getEntityManager();
        try {
            String strSQL = "DELETE FROM empresa ";
            if (empresa.getCNPJ() != null) {
                strSQL += "WHERE cnpj='" + empresa.getCNPJ() + "' ";
            } else if (empresa.getNomeFant() != null) {
                strSQL += "WHERE nomeFant LIKE '%" + empresa.getNomeFant() + "%' ";
            }
            em.getTransaction().begin();
            int query = em.createNativeQuery(strSQL).executeUpdate();
            return query;
            
        } catch (PersistenceException e) {
            System.out.println("Não há a empresa ou empresas no banco de dados");
            return 0;
        } finally {
            em.close();
        }
    }
    
    public int atualizar(Empresa empresa){
        EntityManager em = super.getEntityManager();
        try {
            String strSQL = "UPDATE empresa SET ";
            strSQL = strSQL + "cnpj = " + empresa.getCNPJ() + ", ";
            strSQL = strSQL + "nomeFant = " + empresa.getNomeFant() + ", ";
            strSQL = strSQL + "cep = " + empresa.getCEP() + ", ";
            strSQL = strSQL + "uf = " + empresa.getUF() + ", ";
            strSQL = strSQL + "cidade = " + empresa.getCidade() + ", ";
            strSQL = strSQL + "bairro = " + empresa.getBairro() + ", ";
            strSQL = strSQL + "logradouro = " + empresa.getLogradouro();
            strSQL = strSQL + " WHERE idEmpresa = " + empresa.getID(); 
            
            em.getTransaction().begin();
            int query = em.createNativeQuery(strSQL).executeUpdate();
            return query;
            
        } catch (PersistenceException e) {
            System.out.println("Não houve atualização no banco de dados");
            return 0;
        } finally {
            em.close();
        }
    }
    
    public List<Fornecedor> obterFornecedores(Empresa empresa){
        EntityManager em = super.getEntityManager();
        try {
            String strSQL = "SELECT fornecedor.* "
                    + "FROM ("
                    + "(oferece INNER JOIN empresa ON empresa.idEmpresa = oferece.empresa_id) "
                    + "INNER JOIN fornecedor ON fornecedor.idFornecedor = oferece.fornecedor_id) ";
            if (empresa.getCNPJ() != null) {
                strSQL += "WHERE empresa.cnpj='" + empresa.getCNPJ() + "' ;";
            } else if (empresa.getNomeFant() != null) {
                strSQL += "WHERE empresa.nomeFant LIKE '%" + empresa.getNomeFant() + "%' ;";
            }
            em.getTransaction().begin();
            Query query = em.createNativeQuery(strSQL, Fornecedor.class);
            List<Fornecedor> resultado = query.getResultList();
            return resultado;
            
        } catch (PersistenceException e) {
            //System.out.println("Não há a empresa ou empresas no banco de dados");
            return null;
        } finally {
            em.close();
        }
    }
}
