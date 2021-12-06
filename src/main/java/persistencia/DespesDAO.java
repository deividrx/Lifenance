package persistencia;

import modelos.entidades.Cartao;
import modelos.entidades.Despesa;
import modelos.interfaces.IDespesaDAO;

import java.io.*;
import java.util.ArrayList;

public class DespesDAO  implements IDespesaDAO {
    //Atributos
    private final File arquivo;


    public DespesDAO(File arquivo) throws Exception {
        this.arquivo = new DataFiles(arquivo).getFile();
        ;
    }

    @Override
    public void incluir(Despesa objeto) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))) {
            bw.write(objeto.toString() + "\n");
        }
    }

    @Override
    public void alterar(Despesa objeto) throws Exception {
        ArrayList<Despesa> arrayDespesas = listagem();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Despesa despesa : arrayDespesas) {
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
        ArrayList<Despesa> arrayDespesas = listagem();
        FileWriter fw = new FileWriter(arquivo);

        try (BufferedWriter bw = new BufferedWriter(fw)) {
            for (int i = 0; i < arrayDespesas.size(); i++) {
                if (id != arrayDespesas.get(i).getId())
                    bw.write(arrayDespesas.get(i).toString() + "\n");
            }
        }
    }

    @Override
    public Cartao consultarPorID(int id) throws Exception {
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
    public ArrayList<Despesa> listagem() throws Exception {


        ArrayList<Despesa> arrayDespesas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Despesa aux = new Cartao(linha.split(";"));
                arrayDespesas.add(aux);
            }


            return arrayDespesas;
        }
    }
}