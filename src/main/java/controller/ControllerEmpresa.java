/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.dao.DaoEmpresa;
import model.pojo.Empresa;

/**
 *
 * @author User
 */
public class ControllerEmpresa {
    
    public static boolean salvarEmpresa(Empresa empresa) {
        DaoEmpresa dao = new DaoEmpresa();
        if(dao.salvar(empresa) !=null){
            return true;
        }else{
            return false;
        }
    }
    /**
     * 
     * @param cliente Cliente contendo os filtros de busca do cliente 
     * @return Chamada ao metodo buscar cliente no DaoCliente
     */
//    public static List<Cliente> buscarClientes(Cliente cliente) {
//        DaoCliente dao = new DaoCliente();
//        return dao.buscarClientes(cliente);
//    }
    
}
