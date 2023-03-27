package model.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import model.pojo.Fornecedor;

/*
 * @author User
 */
public class DaoFornecedor extends DaoBase{
    
    public List<Fornecedor> buscar(Fornecedor fornecedor) {
        EntityManager em = super.getEntityManager();
        try {
            String strSQL = "SELECT * FROM fornecedor ";
            if (fornecedor.getCNPJ() != null) {
                strSQL += "WHERE cnpj='" + fornecedor.getCNPJ() + "' ";
            } else if (fornecedor.getNome() != null) {
                strSQL += "WHERE nome LIKE '%" + fornecedor.getNome() + "%' ";
            }
            em.getTransaction().begin();

            Query query = em.createNativeQuery(strSQL, Fornecedor.class);
            List<Fornecedor> teste = query.getResultList();
           
            for (Fornecedor casa: teste){
                System.out.println("CNPJ: " + casa.getCNPJ());
                System.out.println("Nome: " + casa.getNome());
            }
            
            return (List<Fornecedor>) query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Não há a fornecedor ou fornecedores no banco de dados");
            return null;
        } finally {
            em.close();
        }
    }
    
    public int criar(Fornecedor fornecedor) {
        EntityManager em = super.getEntityManager();
        try {
            String strSQL = "INSERT INTO fornecedor (nome, cnpj, cpf, rg, data_nasc, email, cep, uf, cidade, bairro, logradouro) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            em.getTransaction().begin();
            int query = em.createNativeQuery(strSQL)
                    .setParameter(1, fornecedor.getNome())
                    .setParameter(2, fornecedor.getCNPJ())
                    .setParameter(2, fornecedor.getCPF())
                    .setParameter(2, fornecedor.getRG())
                    .setParameter(2, fornecedor.getDataNasc())
                    .setParameter(2, fornecedor.getEmail())
                    .setParameter(3, fornecedor.getCEP())
                    .setParameter(4, fornecedor.getUF())
                    .setParameter(5, fornecedor.getCidade())
                    .setParameter(6, fornecedor.getBairro())
                    .setParameter(7, fornecedor.getLogradouro())
                    .executeUpdate();
            return query;
            
        } catch (PersistenceException e) {
            System.out.println("Não houve inserção no banco de dados");
            return 0;
        } finally {
            em.close();
        }
    }
    
    public int remover(Fornecedor fornecedor) {
        EntityManager em = super.getEntityManager();
        try {
            String strSQL = "DELETE FROM fornecedor ";
            if (fornecedor.getCNPJ() != null) {
                strSQL += "WHERE cnpj='" + fornecedor.getCNPJ() + "' ";
            } else if (fornecedor.getCPF() != null) {
                strSQL += "WHERE cpf='" + fornecedor.getCPF() + "' ";
            } else if (fornecedor.getNome() != null) {
                strSQL += "WHERE nome LIKE '%" + fornecedor.getNome() + "%' ";
            }
            em.getTransaction().begin();
            int query = em.createNativeQuery(strSQL).executeUpdate();
            return query;
            
        } catch (PersistenceException e) {
            System.out.println("Não há a fornecedor ou fornecedors no banco de dados");
            return 0;
        } finally {
            em.close();
        }
    }
    
    public int atualizar(Fornecedor fornecedor){
        EntityManager em = super.getEntityManager();
        try {
            String strSQL = "UPDATE fornecedor SET ";
            strSQL = strSQL + "nome = " + fornecedor.getNome() + ", ";
            strSQL = strSQL + "cnpj = " + fornecedor.getCNPJ() + ", ";
            strSQL = strSQL + "cpf = " + fornecedor.getCPF() + ", ";
            strSQL = strSQL + "rg = " + fornecedor.getRG() + ", ";
            strSQL = strSQL + "data_nasc = " + fornecedor.getDataNasc() + ", ";
            strSQL = strSQL + "email = " + fornecedor.getEmail() + ", ";
            strSQL = strSQL + "cep = " + fornecedor.getCEP() + ", ";
            strSQL = strSQL + "uf = " + fornecedor.getUF() + ", ";
            strSQL = strSQL + "cidade = " + fornecedor.getCidade() + ", ";
            strSQL = strSQL + "bairro = " + fornecedor.getBairro() + ", ";
            strSQL = strSQL + "logradouro = " + fornecedor.getLogradouro();
            strSQL = strSQL + " WHERE idFornecedor = " + fornecedor.getID(); 
            
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
}

