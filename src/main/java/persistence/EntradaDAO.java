package persistence;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EntradaDAO {

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
}
