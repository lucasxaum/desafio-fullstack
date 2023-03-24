
package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


//$("#cpfcnpj").keypress(function(){
//    $("#cpfcnpj").unmask();
//    var tamanho = $("#cpfcnpj").val().length;
//
//    if(tamanho == 11){
//        $("#cpfcnpj").mask("999.999.99-99");
//    } else if(tamanho == 14){
//        $("#cpfcnpj").mask("99.999.999/9999-99");
//    }                   
//});

/**
 *
 * @author Lucas J. C. Andrade
 * Classe responsável por salvar objetos no banco de dados e fazer busca por código
 */
public class DaoBase {

    //private static final String PERSISTENCE_UNIT_NAME = "DesafioFullStack";
    private static EntityManagerFactory factory;

    public DaoBase() {
        factory = Persistence.createEntityManagerFactory("DesafioFullStack");
    }
    
    protected EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    /**
     * @author Lucas J. C. Andrade
     * @param obj salva o objeto no banco de dados.
     * @return em caso de sucesso ao salvar, retorna o próprio objeto, null caso contrário.
     * 
     */
    public Object salvar(Object obj) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
            return obj;
        } catch (javax.persistence.PersistenceException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }

    }

    /**
     * @author Lucas J. C. Andrade
     * Faz a busca de um objeto pelo seu código no banco de dados.
     * @param classe classe do objeto a ser buscado
     * @param codigo código do objeto
     * @return objeto referente à busca ou null, caso não haja o objeto no banco.
     * 
     */
    public Object buscarPorCodigo(Class classe, int codigo) {
        Object obj;
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            obj = em.find(classe, codigo);
            em.getTransaction().commit();
            return obj;
        } catch (javax.persistence.PersistenceException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
}
