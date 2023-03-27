/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

/**
 *
 * @author User
 */
public class DaoOferece extends DaoBase {
    
//    public buscarEmpresas(Fornecedor fornecedor){
//        EntityManager em = super.getEntityManager();
//        try {
//            String strSQL = "SELECT * FROM fornecedor ";
//            if (fornecedor.getCNPJ() != null) {
//                strSQL += "WHERE cnpj='" + fornecedor.getCNPJ() + "' ";
//            } else if (fornecedor.getNome() != null) {
//                strSQL += "WHERE nome LIKE '%" + fornecedor.getNome() + "%' ";
//            }
//            em.getTransaction().begin();
//
//            Query query = em.createNativeQuery(strSQL, Fornecedor.class);
//            List<Fornecedor> teste = query.getResultList();
//           
//            for (Fornecedor casa: teste){
//                System.out.println("CNPJ: " + casa.getCNPJ());
//                System.out.println("Nome: " + casa.getNome());
//            }
//            
//            return (List<Fornecedor>) query.getResultList();
//        } catch (PersistenceException e) {
//            System.out.println("Não há a fornecedor ou fornecedores no banco de dados");
//            return null;
//        } finally {
//            em.close();
//        }
//    }
}
