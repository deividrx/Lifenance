package persistencia;

import modelos.entidades.Cartao;
import modelos.interfaces.ICartaoDAO;

import java.io.*;
import java.util.ArrayList;

public class CartaoDAO implements ICartaoDAO {

    private File arquivo;

    public CartaoDAO(String arquivo) throws Exception {
        this.arquivo = new DataFiles(arquivo).getFile();
    }

    @Override
    public void incluir(Cartao objeto) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))) {
            bw.write(objeto.toString() + "\n");
        }
    }

    @Override
    public void alterar(Cartao objeto) throws Exception {
        ArrayList<Cartao> arrayCartao = listagem();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Cartao cartao : arrayCartao) {
                if (cartao.getId() == objeto.getId()) {
                    bw.write(objeto.toString() + "\n");
                } else {
                    bw.write(cartao.toString() + "\n");
                }
            }
        }
    }

    @Override
    public Cartao consultarPorID(int id) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            Cartao aux = new Cartao();
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] vetorString = linha.split(";");
                aux.setId(Integer.parseInt(vetorString[8]));
                if(aux.getId() == id) return aux;
            }
            return null;
        }
    }

    @Override
    public ArrayList<Cartao> listagem() throws Exception {
        ArrayList<Cartao> arrayCartao = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Cartao aux = new Cartao(linha.split(";"));
                arrayCartao.add(aux);
            }
        }

        return arrayCartao;
    }

    @Override
    public void apagarPorId(int id) throws Exception {
        ArrayList<Cartao> arrayCartao = listagem();
        FileWriter fw = new FileWriter(arquivo);

        try (BufferedWriter bw = new BufferedWriter(fw)) {
            for (int i = 0; i < arrayCartao.size(); i++) {
                if (id != arrayCartao.get(i).getId())
                    bw.write(arrayCartao.get(i).toString() + "\n");
            }
        }
    }
}
