package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import model.Gasto;

public class GastoDAO {

    private static Gasto[] gastos = new Gasto[1000000];
    public static Gasto[] getInstance() {
        if (gastos[0] == null) {
            String diretorioArquivo = "/ice/Downloads/deputies_dataset_tratado.csv";
            BufferedReader leitor = null;
            String delimitador = ";";
            int contador = 0;
            try {
                String linhaDeLeitura = "";
                leitor = new BufferedReader(new FileReader(diretorioArquivo));
                linhaDeLeitura = leitor.readLine();
                while ((linhaDeLeitura = leitor.readLine()) != null && contador < 1000000) {
                    String[] gasto = linhaDeLeitura.split(delimitador);
                    Integer deputadoId = Integer.parseInt(gasto[2]);
                    Integer valor;
                    valor = Integer.parseInt(gasto[9]);
                    gastos[contador] = new Gasto(gasto[0], gasto[1], deputadoId, gasto[3], gasto[4], gasto[5], gasto[6], gasto[7], gasto[8], valor);
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            } finally {
                if (leitor != null) {
                    try {
                        leitor.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return gastos;
    }

}
