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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelos.entidades.Receita;
import modelos.entidades.enums.TipoReceita;
import modelos.interfaces.IReceitaDAO;

public class ReceitaDAO implements IReceitaDAO {
    
    private File arquivo;
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public ReceitaDAO(String arquivo) throws Exception {
        this.arquivo = new DataFiles(arquivo).getFile();
    }
    
    @Override
    public void incluir(Receita objeto) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))) {
            bw.write(objeto.toString() + "\n");
        }
    }

    @Override
    public void alterar(Receita objeto) throws Exception {
        ArrayList<Receita> arrayDasReceitas = listagem(); 
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (int i = 0; i < arrayDasReceitas.size(); i++) {
                if (arrayDasReceitas.get(i).getId() == objeto.getId()) {
                    bw.write(objeto.toString() + "\n");
                } else {
                    bw.write(arrayDasReceitas.get(i).toString() + "\n");
                }
            }       
        }
    }

    @Override
    public void apagarPorID(int id) throws Exception {
        ArrayList<Receita> arrayDasReceitas = listagem();
        FileWriter fw = new FileWriter(arquivo);
        
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            for (Receita receita : arrayDasReceitas) {
                if (id != receita.getId())
                    bw.write(receita.toString() + "\n");
            }
        }
    }

    @Override
    public Receita consultarPorID(int id) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            Receita aux = new Receita();
            String linha;
            
            while ((linha = br.readLine()) != null) {
                String[] vetorString = linha.split(";");
                aux.setId(Integer.parseInt(vetorString[0]));
                if(aux.getId() == id) return aux;
            }
            return null;
        } 
    }

    @Override
    public ArrayList<Receita> listagem() throws Exception {
         ArrayList<Receita> arrayDasReceitas = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Receita aux = new Receita();
                String[] vetorString = linha.split(";");
                aux.setId(Integer.parseInt(vetorString[0]));
                aux.setNome(vetorString[1]);
                aux.setDescricao(vetorString[2]);
                aux.setValor(Float.parseFloat(vetorString[3]));
                aux.setDataDaReceita(format.parse(vetorString[4]));
                aux.setTipo(TipoReceita.valueOf(vetorString[5]));
                aux.setiDContaCorrente(Integer.parseInt(vetorString[6]));
                arrayDasReceitas.add(aux);
            }
        }
        return arrayDasReceitas;
    }
    
}
