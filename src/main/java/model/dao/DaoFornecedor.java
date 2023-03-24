package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import model.pojo.Fornecedor;

/*
 * @author User
 */
public class DaoFornecedor extends DaoBase{
    
    public List<Fornecedor> buscarFornecedores(Fornecedor fornecedor) {
        EntityManager em = super.getEntityManager();
        try {
            String strSQL = "SELECT f FROM fornecedor ";
            if (fornecedor.getCNPJ() != null) {
                strSQL += "WHERE f.cnpj='" + fornecedor.getCNPJ() + "' ";
            } else if (fornecedor.getCPF() != null) {
                strSQL += "WHERE f.cpf='" + fornecedor.getCPF() + "' ";
            } else if (fornecedor.getNome() != null) {
                strSQL += "WHERE c.nome LIKE '" + fornecedor.getNome() + "%' ";
            }
            strSQL += "ORDER BY NOME ASC";
            em.getTransaction().begin();

            Query query = em.createQuery(strSQL);

            return (List<Fornecedor>) query.getResultList();
        } catch (PersistenceException e) {
            return null;
        } finally {
            em.close();
        }
    }
}

