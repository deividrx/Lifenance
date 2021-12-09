package persistencia;

import modelos.entidades.Cartao;
import modelos.entidades.Despesa;
import modelos.interfaces.IDespesaDAO;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelos.entidades.enums.TipoDespesa;

public class DespesDAO  implements IDespesaDAO {
    //Atributos
    private final File arquivo;
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyyy");


    public DespesDAO(String arquivo) throws Exception {
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
    public ArrayList<Despesa> listagem() throws Exception {
        ArrayList<Despesa> arrayDespesas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Despesa aux = new Despesa();
                String[] vetor = linha.split(";");
                aux.setId(Integer.parseInt(vetor[0]));
                aux.setNome(vetor[1]);
                aux.setDescricao(vetor[2]);
                aux.setValor(Float.parseFloat(vetor[3]));
                aux.setDataDaReceita(format.parse(vetor[4]));
                aux.setTipo(TipoDespesa.valueOf(vetor[5]));
                aux.setIDContaCorrente(Integer.parseInt(vetor[6]));
                arrayDespesas.add(aux);
            }
            return arrayDespesas;
        }
    }
}