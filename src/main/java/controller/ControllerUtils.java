package controller;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import org.json.JSONObject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class ControllerUtils {
    
    public JSONObject coletarEndereco(String cep) throws Exception {
        
        String endereco = "http://cep.la/"+cep;
        StringBuilder result = new StringBuilder();
        URL url = new URL(endereco);
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
        return obj;
     }
   
   public int idade(LocalDate aniversario) {
        return Period.between(aniversario, LocalDate.now()).getYears();
    }
    
}
