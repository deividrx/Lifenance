package persistencia;

import modelos.entidades.Despesa;
import modelos.entidades.DespesaPorCartao;
import modelos.interfaces.IDespesaPorCartaoDAO;

import java.io.*;
import java.util.ArrayList;

public class DespesaPorCartaoDAO implements IDespesaPorCartaoDAO {
//atributo
    private File arquivo;
//metodos
    public void DespesaPorCartaoDAO(String arquivo) throws Exception {
        this.arquivo = new DataFiles(arquivo).getFile();
        ;
    }


    @Override
    public void incluir(DespesaPorCartao objeto) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))) {
            bw.write(objeto.toString() + "\n");
        }
    }

    @Override
    public void alterar(DespesaPorCartao objeto) throws Exception {
        ArrayList<DespesaPorCartao> arrayDespesasPorCartaos = listagem();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (DespesaPorCartao despesa : arrayDespesasPorCartaos) {
                if (despesa.getId() == objeto.getId()) {
                    bw.write(objeto.toString() + "\n");
                } else {
                    bw.write(despesa.toString() + "\n");
                }
            }
        }
    }

    @Override
    public void apagarPorID(int id) throws Exception {
        ArrayList<DespesaPorCartao> arrayDespesaPorCartaos = listagem();
        FileWriter fw = new FileWriter(arquivo);

        try (BufferedWriter bw = new BufferedWriter(fw)) {
            for (int i = 0; i < arrayDespesaPorCartaos.size(); i++) {
                if (id != arrayDespesaPorCartaos.get(i).getId())
                    bw.write(arrayDespesaPorCartaos.get(i).toString() + "\n");
            }
        }
    }

    @Override
    public Despesa consultarPorID(int id) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            Despesa aux = new Despesa();
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] vetorString = linha.split(";");
                aux.setId(Integer.parseInt(vetorString[0]));
                if (aux.getId() == id) return aux;
            }
            return null;
        }
    }

    @Override
    public ArrayList<DespesaPorCartao> listagem() throws Exception {
        ArrayList<DespesaPorCartao> arrayDespesasPorCartaos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                DespesaPorCartao aux = new DespesaPorCartao();
                arrayDespesasPorCartaos.add(aux);
            }
            return arrayDespesasPorCartaos;
        }
    }
    }

