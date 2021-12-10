package persistencia;

import modelos.entidades.Banco;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import modelos.interfaces.IBancoDAO;

public class BancoDAO implements IBancoDAO {
    //Atributo
    private final File arquivo;
    
    //Metodos
    public BancoDAO(String arquivo) throws Exception{
        this.arquivo = new DataFiles(arquivo).getFile();
    }

    @Override
    public void incluir(Banco objeto) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))) {
            bw.write(objeto.toString() + "\n");
        }
    }

    @Override
    public void alterar(Banco objeto) throws Exception {
        ArrayList<Banco> arrayDosBancos = listagem(); 
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Banco banco : arrayDosBancos) {
                if (banco.getId() == objeto.getId()) {
                    bw.write(objeto.toString() + "\n");
                } else {
                    bw.write(banco.toString() + "\n");
                }
            }       
        }
    }

    @Override
    public void apagarPorID(int id) throws Exception {
        ArrayList<Banco> arrayDosBancos = listagem(); 
        FileWriter fw = new FileWriter(arquivo);
        
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            for (int i = 0; i < arrayDosBancos.size(); i++) {
                if (id != arrayDosBancos.get(i).getId())
                    bw.write(arrayDosBancos.get(i).toString() + "\n");
            }
        }
    }

    @Override
    public Banco consultarPorID(int id) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            Banco aux = new Banco();
            String linha;
            
            while ((linha = br.readLine()) != null) {
                String vetorString[] = linha.split(";");
                aux.setId(Integer.parseInt(vetorString[0]));
                aux.setDescricao(vetorString[1]);
                if(aux.getId() == id) return aux;
            }
            
            return null;
        } 
    }

    @Override
    public ArrayList<Banco> listagem() throws Exception {
        ArrayList<Banco> arrayDosBancos = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Banco aux = new Banco();
                String vetorString[] = linha.split(";");
                aux.setId(Integer.parseInt(vetorString[0]));
                aux.setDescricao(vetorString[1]);
                arrayDosBancos.add(aux);
            }
        }
        
        return arrayDosBancos;
    }
    
}
