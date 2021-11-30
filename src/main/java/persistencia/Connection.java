/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.File;


public class Connection {
    
    private String caminhoDoArquivo = "";
    
    public Connection(String nomeDoArquivo) {
        
    }
    
    
    
    public void salvar() {
        
    }
    
    public void open() {
          
    }
    
    public static void main(String[] args) {
        File file = new File("./gradle.properties");
        System.out.println(file.getAbsolutePath());
    }
}
