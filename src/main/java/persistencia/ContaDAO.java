/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import modelos.entidades.Conta;
import modelos.entidades.enums.TipoDeConta;
import modelos.interfaces.IContaDAO;

public class ContaDAO implements IContaDAO{
    
    private File arquivo;

    public ContaDAO(String arquivo) throws Exception {
        this.arquivo = new DataFiles(arquivo).getFile();
    }
    
    @Override
    public void incluir(Conta objeto) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))) {
            bw.write(objeto.toString() + "\n");
        }
    }

    @Override
    public void alterar(Conta objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apagarPorID(int id) throws Exception {
        ArrayList<Conta> contas = listagem(); 
        FileWriter fw = new FileWriter(arquivo);
        
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            for (int i = 0; i < contas.size(); i++) {
                if (id != contas.get(i).getId())
                    bw.write(contas.get(i).toString() + "\n");
            }
        }
    }

    @Override
    public Conta consultarPorID(int id) throws Exception {
            ArrayList<Conta> contas = listagem();
            for (Conta conta : contas) {
                if (conta.getId() == id) return conta;
            }
            return null;       
    }

    @Override
    public ArrayList<Conta> listagem() throws Exception {
        ArrayList<Conta> contas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Conta aux = new Conta();
                String vetor[] = linha.split(";");
                aux.setNumero(Integer.parseInt(vetor[0]));
                aux.setAgencia(Integer.parseInt(vetor[1]));
                aux.setTipo(TipoDeConta.valueOf(vetor[2].toUpperCase()));
                aux.setLimite(Float.parseFloat(vetor[3]));
                aux.setSaldo(Float.parseFloat(vetor[4]));
                aux.setIdBanco(Integer.parseInt(vetor[5]));
                aux.setId(Integer.parseInt(vetor[6]));
                contas.add(aux);
            }
        }
        
        return contas;
    }

}
