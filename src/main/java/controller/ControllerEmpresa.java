/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.dao.DaoEmpresa;
import model.pojo.Empresa;
import model.pojo.Fornecedor;

/**
 *
 * @author User
 */
public class ControllerEmpresa {
    
    public boolean salvarEmpresa(Empresa empresa) {
        DaoEmpresa dao = new DaoEmpresa();
        return dao.criar(empresa) != 0;
    }
    
    public List<Empresa> listar(String cnpj, String nome){
        Empresa emp = new Empresa();
        emp.setCNPJ(cnpj);
        emp.setNomeFant(nome);
        
        DaoEmpresa banco_empresa = new DaoEmpresa();
        return banco_empresa.buscar(emp);
    }
    
    public List<Fornecedor> obterFornecedores(String cnpj, String nome){
        Empresa emp = new Empresa();
        emp.setCNPJ(cnpj);
        emp.setNomeFant(nome);
        
        DaoEmpresa banco_empresa = new DaoEmpresa();
        return banco_empresa.obterFornecedores(emp);
    }
}
