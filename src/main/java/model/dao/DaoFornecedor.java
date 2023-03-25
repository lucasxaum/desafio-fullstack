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
    
    public List<Fornecedor> buscarFornecedores(Fornecedor empresa) {
        EntityManager em = super.getEntityManager();
        try {
            String strSQL = "SELECT * FROM empresa ";
            if (empresa.getCNPJ() != null) {
                strSQL += "WHERE e.cnpj='" + empresa.getCNPJ() + "' ";
            } else if (empresa.getNome() != null) {
                strSQL += "WHERE e.nomeFant LIKE '" + empresa.getNome() + "%' ";
            }
            em.getTransaction().begin();

            Query query = em.createNativeQuery(strSQL, Fornecedor.class);
            List<Fornecedor> teste = query.getResultList();
           
            for (Fornecedor casa: teste){
                System.out.println("CNPJ: " + casa.getCNPJ());
                System.out.println("NomeFant.: " + casa.getNome());
            }
            
            return (List<Fornecedor>) query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Fornecedor Vazio");
            return null;
        } finally {
            em.close();
        }
    }
}

