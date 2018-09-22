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

    public static void escrever(Integer indicador, Resultado[] resultado) {
        try {
            switch (indicador) {
                case 0: {

                    FileWriter fw = new FileWriter("C:\\Users\\Mateu\\Desktop\\QuickSortObjetos.txt", false);
                    BufferedWriter conexao = new BufferedWriter(fw);
                    conexao.write("Resultado,Tempo gasto,Número de Trocas,Número de comparações");
                    conexao.newLine();
                    for (int i = 0; i < resultado.length; i++) {
                        conexao.write("Resultado " + i+1 + "," + resultado[i].getTempoGasto() + "," + resultado[i].getNumTrocas() + "," + resultado[i].getNumComparacoes());
                        conexao.newLine();
                    }
                    conexao.close();
                    break;
                }
                case 1: {
                    FileWriter fw = new FileWriter("C:\\Users\\Mateu\\Desktop\\QuickSortInteiros.txt", false);
                    BufferedWriter conexao = new BufferedWriter(fw);
                    conexao.write("Resultado,Tempo gasto,Número de Trocas,Número de comparações");
                    conexao.newLine();
                    for (int i = 0; i < resultado.length; i++) {
                        conexao.write("Resultado " + i+1 + "," + resultado[i].getTempoGasto() + "," + resultado[i].getNumTrocas() + "," + resultado[i].getNumComparacoes());
                        conexao.newLine();
                    }
                    conexao.close();
                    break;
                }
                case 2:
                {
                    FileWriter fw = new FileWriter("C:\\Users\\Mateu\\Desktop\\QuickSortMediana3.txt", false);
                    BufferedWriter conexao = new BufferedWriter(fw);
                    conexao.write("Resultado,Tempo gasto,Número de Trocas,Número de comparações");
                    conexao.newLine();
                    for (int i = 0; i < resultado.length; i++) {
                        conexao.write("Resultado " + i+1 + "," + resultado[i].getTempoGasto() + "," + resultado[i].getNumTrocas() + "," + resultado[i].getNumComparacoes());
                        conexao.newLine();
                    }
                    conexao.close();
                    break;
                }
                case 3:
                {
                    FileWriter fw = new FileWriter("C:\\Users\\Mateu\\Desktop\\QuickSortMediana5.txt", false);
                    BufferedWriter conexao = new BufferedWriter(fw);
                    conexao.write("Resultado,Tempo gasto,Número de Trocas,Número de comparações");
                    conexao.newLine();
                    for (int i = 0; i < resultado.length; i++) {
                        conexao.write("Resultado " + i+1 + "," + resultado[i].getTempoGasto() + "," + resultado[i].getNumTrocas() + "," + resultado[i].getNumComparacoes());
                        conexao.newLine();
                    }
                    conexao.close();
                    break;
                }
                case 4:
                {
                    FileWriter fw = new FileWriter("C:\\Users\\Mateu\\Desktop\\QuickSortInsertion10.txt", false);
                    BufferedWriter conexao = new BufferedWriter(fw);
                    conexao.write("Resultado,Tempo gasto,Número de Trocas,Número de comparações");
                    conexao.newLine();
                    for (int i = 0; i < resultado.length; i++) {
                        conexao.write("Resultado " + i+1 + "," + resultado[i].getTempoGasto() + "," + resultado[i].getNumTrocas() + "," + resultado[i].getNumComparacoes());
                        conexao.newLine();
                    }
                    conexao.close();
                    break;
                }
                case 5:
                {
                    FileWriter fw = new FileWriter("C:\\Users\\Mateu\\Desktop\\QuickSortInsertion100.txt", false);
                    BufferedWriter conexao = new BufferedWriter(fw);
                    conexao.write("Resultado,Tempo gasto,Número de Trocas,Número de comparações");
                    conexao.newLine();
                    for (int i = 0; i < resultado.length; i++) {
                        conexao.write("Resultado " + i+1 + "," + resultado[i].getTempoGasto() + "," + resultado[i].getNumTrocas() + "," + resultado[i].getNumComparacoes());
                        conexao.newLine();
                    }
                    conexao.close();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
