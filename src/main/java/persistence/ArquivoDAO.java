package persistence;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import model.Resultado;

public class ArquivoDAO {

    private static Integer[] leituras;

    public static Integer[] getInstance() throws FileNotFoundException {
        if (leituras == null) {
            Scanner input = new Scanner(new FileReader("C:\\Users\\Mateu\\Documents\\NetBeansProjects\\DCC012---Trabalho01\\entrada.txt"));
            try {
                Integer valor;
                int contador = 0;
                while (input.hasNext()) {
                    if (contador == 0) {
                        valor = input.nextInt();
                        leituras = new Integer[valor + 1];
                        leituras[contador] = valor;
                        contador++;
                    } else {
                        leituras[contador] = input.nextInt();
                        contador++;
                    }
                }
            } catch (NoSuchElementException elementException) {
                System.out.println("Todas as leituras feitas.");
            } catch (IllegalStateException stateException) {
                System.err.println("Error reading from file. Terminating.");
            }
            input.close();
        }
        return leituras;
    }

    public static void escrever(String nome, Resultado[] resultado) {
        try {
            if (nome.equals("Resultado Objeto")) {

                FileWriter fw = new FileWriter("C:\\Users\\Mateu\\Desktop\\saida-objeto.txt", false);
                BufferedWriter conexao = new BufferedWriter(fw);
                for (int i = 0; i < resultado.length; i++) {
                    conexao.write("Resultado " + i);
                    conexao.newLine();
                    conexao.write("Tempo gasto: " + resultado[i].getTempoGasto() + " // Número de trocas: " + resultado[i].getNumTrocas() + " // Número de comparações: " + resultado[i].getNumComparacoes());
                    conexao.newLine();

                }
                conexao.close();
            }
            if (nome.equals("Resultado Inteiro")) {
                FileWriter fw = new FileWriter("C:\\Users\\Mateu\\Desktop\\saida-inteiro.txt", false);
                BufferedWriter conexao = new BufferedWriter(fw);
                for (int i = 0; i < resultado.length; i++) {
                    conexao.write("Resultado " + i);
                    conexao.newLine();
                    conexao.write("Tempo gasto: " + resultado[i].getTempoGasto() + " // Número de trocas: " + resultado[i].getNumTrocas() + " // Número de comparações: " + resultado[i].getNumComparacoes());
                    conexao.newLine();

                }
                conexao.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
