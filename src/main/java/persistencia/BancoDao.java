/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import modelos.interfaces.IBancoDao;
import modelos.entidades.Banco;
import java.util.ArrayList;

//Biblioteca para manipulação de arquivo texto no disco
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author galdi
 */
public class BancoDao implements IBancoDao {
    //Atributo
    private String nomeDoArquivoDadosNodisco = "";
    //Metodos
    public BancoDao(String nomeDoArqquivoDdosNoDisco) {
        this.nomeDoArquivoDadosNodisco = nomeDoArqquivoDdosNoDisco;
    }
    
    
    @Override
    public void incluir(Banco objeto) throws Exception {
        try {
            //Criar o arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoDadosNodisco, true);
            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            //Escreve no arquivo
            bw.write(objeto.toString() + "\n");
            //Fechar o arquivo
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterar(Banco objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apagarPorID(int id) throws Exception {
        try {
            ArrayList<Banco> arrayDosBancos = listagem(); 
            //Criar o arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoDadosNodisco);
            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            //Escreve no arquivo
            for (int i = 0; i < arrayDosBancos.size(); i++) {
                if (id != arrayDosBancos.get(i).getId())
                    bw.write(arrayDosBancos.get(i).toString() + "\n");
                    
            }
            //Fechar o arquivo
            bw.close();
        } catch (Exception e) {
            
        }
 
        
    }

    @Override
    public Banco consultarPorID(int id) throws Exception {
        BufferedReader br = null;
        try {
            //Abrir o arquivo
            FileReader fr = new FileReader(nomeDoArquivoDadosNodisco);
            br = new BufferedReader(fr);
            String linha = "";
            Banco aux = new Banco();
            while ((linha = br.readLine()) != null) {
                String vetorString[] = linha.split(";");
                aux.setId(Integer.parseInt(vetorString[0]));
                aux.setDescricao(vetorString[1]);
                if(aux.getId() == id) return aux;
            }
            aux = null;
            return aux;
            
        } catch (Exception erro) {
            throw erro;
        } finally {
            br.close();
        }
           
    }

    @Override
    public ArrayList<Banco> listagem() throws Exception {
        try {
            ArrayList<Banco> arrayDosBancos = new ArrayList<Banco>();
            //Abrir o arquivo
            FileReader fr = new FileReader(nomeDoArquivoDadosNodisco);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            Banco aux = new Banco();
            while ((linha = br.readLine()) != null) {
                String vetorString[] = linha.split(";");
                aux.setId(Integer.parseInt(vetorString[0]));
                aux.setDescricao(vetorString[1]);
                arrayDosBancos.add(aux);
            }
            br.close();
            return arrayDosBancos;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
