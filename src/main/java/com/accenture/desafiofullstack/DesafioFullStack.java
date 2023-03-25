/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.accenture.desafiofullstack;

/**
 *
 * @author User
 */
//public class DesafioFullStack {
//
//    public static void main(String[] args) {
//        System.out.println("Hello World!");
//    }
//}

import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.time.Period;
import org.json.JSONObject;
import model.dao.DaoEmpresa;
import model.pojo.Empresa;
import java.util.List;


import view.GUIMain;

public class DesafioFullStack {

   public static String getHTML(String urlToRead) throws Exception {
      StringBuilder result = new StringBuilder();
      URL url = new URL(urlToRead);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Accept", "application/json");
      try (BufferedReader reader = new BufferedReader(
                  new InputStreamReader(conn.getInputStream()))) {
          for (String line; (line = reader.readLine()) != null; ) {
              result.append(line);
          }
      }
      JSONObject obj = new JSONObject(result.toString());
      System.out.println("Teste: " + obj.get("logradouro"));
      return result.toString();
   }
   
   public static int idade(LocalDate aniversario) {
        return Period.between(aniversario, LocalDate.now()).getYears();
    }

   public static void main(String[] args) throws Exception
   {
     System.out.println(getHTML("http://cep.la/36301182"));
     LocalDate anos = LocalDate.parse("1991-11-05");
     System.out.print("Idade: " + idade(anos));
     
     Empresa empresa = new Empresa(null, "Empresa", null, null, null, null);
     DaoEmpresa teste = new DaoEmpresa();
     List<Empresa> casa = teste.buscarEmpresas(empresa);
     GUIMain gp = new GUIMain();
     gp.setVisible(true);
   }
}