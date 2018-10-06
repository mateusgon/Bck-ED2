package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Resultado;
import ordenacao.HeapSort;
import ordenacao.InsertionSort;
import ordenacao.MergeSort;
import ordenacao.QuickSort;
import ordenacao.SelectionSort;
import persistence.ArquivoDAO;
import persistence.GastoDAO;

public class GetCenario3Action implements Action { // Implementa Action e é responsável por receber a requisição de exibir o cenário 3

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // Recebe um identificador na requisição, esse identificador possui qual atividade no cenário o usuário deseja realizar. Por exemplo, ordenar com o SelectionSort.
        Integer identificador = Integer.parseInt(request.getParameter("id"));
        switch (identificador) {
            case 0: { // Deseja somente exibir a tela inicial do cenário 3
                RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/cenario3.jsp");
                dispacher.forward(request, response);
                break;
            }
            case 1: {  // Deseja ordenar pelo caso mais rápido do quickSort, de acordo com a experimentação, o QuickSort + InsertionSort com 100 elementos.
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance(); // Recebe a quantidade de dados que deverá ser lida
                Resultado[] resultados = new Resultado[30]; // Cria os resultados para escrever e imprimir os resultados da execução
                Integer contadorLeitura = 0;
                for (int i = 1; i < quantidadeLeitura.length; i++) { // Executa 6 vezes, pois são 6 números diferentes
                    for (int j = 0; j < 5; j++) { // Executa as 5 sementes
                        GastoDAO.shuffle(); // Embaralha o ArrayList
                        Integer[] analise = new Integer[quantidadeLeitura[i]]; // Cria um vetor com o tamanho necessário definido no Entrada.txt ou informado pelo usuário
                        for (int k = 0; k < quantidadeLeitura[i]; k++) { // Lê a quantidade desejada do ArrayList
                            analise[k] = GastoDAO.getInstance().get(k).getReceipt_value(); // O vetor recebe do ArrayList os elementos para serem ordenados
                        }
                        QuickSort quick = new QuickSort(); // Inicializa o QuickSort
                        Resultado resultado = new Resultado();
                        quick.ordenaInteiroQuickSortInsertion(analise, resultado, 100); // Ordena o vetor 
                        resultados[contadorLeitura] = resultado; // Armazena os dados de execução do vetor
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(0, "QuickSortInsertion100", resultados); // Escreve todos os resultados em um arquivo
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultadosOrdenacao.jsp"); // Chama o jsp para mostrar o resultado
                dispatcher.forward(request, response);
                break;
            }
            case 2: { // >>>> Funcionamento semelhante ao de cima, contudo, na hora de ordenar, ele utiliza o mergeSort <<<<
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance();
                Resultado[] resultados = new Resultado[30];
                Integer contadorLeitura = 0;
                for (int i = 1; i < quantidadeLeitura.length; i++) {
                    for (int j = 0; j < 5; j++) {
                        GastoDAO.shuffle();
                        Integer[] analise = new Integer[quantidadeLeitura[i]];
                        for (int k = 0; k < quantidadeLeitura[i]; k++) {
                            analise[k] = GastoDAO.getInstance().get(k).getReceipt_value();
                        }
                        MergeSort merge = new MergeSort(); // Inicializa mergeSort
                        Resultado resultado = new Resultado();
                        merge.ordena(analise, resultado); // Ordena com o mergeSort
                        System.out.println(contadorLeitura);
                        resultados[contadorLeitura] = resultado;
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(0, "MergeSort", resultados);
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultadosOrdenacao.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case 3: { // >>>> Funcionamento semelhante ao de cima, contudo, na hora de ordenar, ele utiliza o InsertionSort <<<<
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance();
                Resultado[] resultados = new Resultado[30];
                Integer contadorLeitura = 0;
                for (int i = 1; i < quantidadeLeitura.length; i++) {
                    for (int j = 0; j < 5; j++) {
                        GastoDAO.shuffle();
                        Integer[] analise = new Integer[quantidadeLeitura[i]];
                        for (int k = 0; k < quantidadeLeitura[i]; k++) {
                            analise[k] = GastoDAO.getInstance().get(k).getReceipt_value();
                        }
                        InsertionSort insertion = new InsertionSort(); // Inicializa o InsertionSort
                        Resultado resultado = new Resultado();
                        insertion.ordena(analise, resultado); // Ordena com o InsertionSort
                        resultados[contadorLeitura] = resultado;
                        System.out.println(contadorLeitura);
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(0, "InsertionSort", resultados);
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultadosOrdenacao.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case 4: { // >>>> Funcionamento semelhante ao de cima, contudo, na hora de ordenar, ele utiliza o HeapSort <<<<
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance();
                Resultado[] resultados = new Resultado[30];
                Integer contadorLeitura = 0;
                for (int i = 1; i < quantidadeLeitura.length; i++) {
                    for (int j = 0; j < 5; j++) {
                        GastoDAO.shuffle();
                        Integer[] analise = new Integer[quantidadeLeitura[i]];
                        for (int k = 0; k < quantidadeLeitura[i]; k++) {
                            analise[k] = GastoDAO.getInstance().get(k).getReceipt_value();
                        }
                        HeapSort heap = new HeapSort(); // Inicializa o HeapSort
                        Resultado resultado = new Resultado();
                        heap.ordena(analise, analise.length, resultado); // Ordena com o HeapSort
                        resultados[contadorLeitura] = resultado;
                        System.out.println(contadorLeitura);
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(0, "HeapSort", resultados);
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultadosOrdenacao.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case 5: { // >>>> Funcionamento semelhante ao de cima, contudo, na hora de ordenar, ele utiliza o meuSort (no caso, o SelectionSort) <<<<
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance();
                Resultado[] resultados = new Resultado[30];
                Integer contadorLeitura = 0;
                for (int i = 1; i < quantidadeLeitura.length; i++) {
                    for (int j = 0; j < 5; j++) {
                        GastoDAO.shuffle();
                        Integer[] analise = new Integer[quantidadeLeitura[i]];
                        for (int k = 0; k < quantidadeLeitura[i]; k++) {
                            analise[k] = GastoDAO.getInstance().get(k).getReceipt_value();
                        }
                        SelectionSort selection = new SelectionSort(); // Inicializa o SelectionSort
                        Resultado resultado = new Resultado();
                        selection.ordena(analise, resultado); // Ordena com o SelectionSort
                        resultados[contadorLeitura] = resultado;
                        System.out.println(contadorLeitura);
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(0, "SelectionSort", resultados);
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultadosOrdenacao.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case 6: { // Funcionamento semelhante ao caso 1, caso 2, caso 3, caso 4 e caso 5. Contudo, ele executa todos os casos do cenário 3 de uma vez só. Ele é uma junção dos 5 casos anteriores e todas as ordenações que podem ser feitas.
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance();
                Resultado[] resultados1 = new Resultado[30];
                Resultado[] resultados2 = new Resultado[30];
                Resultado[] resultados3 = new Resultado[30];
                Resultado[] resultados4 = new Resultado[30];
                Resultado[] resultados5 = new Resultado[30];
                Integer contadorLeitura = 0;
                for (int i = 1; i < quantidadeLeitura.length; i++) {
                    for (int j = 0; j < 5; j++) {
                        GastoDAO.shuffle();
                        Integer[] analise = new Integer[quantidadeLeitura[i]];
                        Integer[] analise2 = new Integer[quantidadeLeitura[i]];
                        Integer[] analise3 = new Integer[quantidadeLeitura[i]];
                        Integer[] analise4 = new Integer[quantidadeLeitura[i]];
                        Integer[] analise5 = new Integer[quantidadeLeitura[i]];
                        for (int k = 0; k < quantidadeLeitura[i]; k++) {
                            analise[k] = GastoDAO.getInstance().get(k).getReceipt_value();
                            analise2[k] = GastoDAO.getInstance().get(k).getReceipt_value();
                            analise3[k] = GastoDAO.getInstance().get(k).getReceipt_value();
                            analise4[k] = GastoDAO.getInstance().get(k).getReceipt_value();
                            analise5[k] = GastoDAO.getInstance().get(k).getReceipt_value();
                        }
                        QuickSort quick = new QuickSort(); // Inicializa o QuickSort
                        MergeSort merge = new MergeSort(); // Inicializa o MergeSort
                        InsertionSort insertion = new InsertionSort(); // Inicializa o InsertionSort
                        HeapSort heap = new HeapSort(); // Inicializa o HeapSort
                        SelectionSort selection = new SelectionSort(); // Inicializa o SelectionSort
                        Resultado resultado1 = new Resultado();
                        Resultado resultado2 = new Resultado();
                        Resultado resultado3 = new Resultado();
                        Resultado resultado4 = new Resultado();
                        Resultado resultado5 = new Resultado();
                        quick.ordenaInteiroMediana(analise, resultado1, 100); // Ordena com o QuickSort
                        merge.ordena(analise2, resultado2); // Ordena com o MergeSort
                        insertion.ordena(analise3, resultado3); // Ordena com o Insertion
                        heap.ordena(analise4, analise4.length, resultado4); // Ordena com o HeapSort
                        selection.ordena(analise5, resultado5); // Ordena com o SelectionSort
                        resultados1[contadorLeitura] = resultado1;
                        resultados2[contadorLeitura] = resultado2;
                        resultados3[contadorLeitura] = resultado3;
                        resultados4[contadorLeitura] = resultado4;
                        resultados5[contadorLeitura] = resultado5;
                        System.out.println(contadorLeitura);
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(0, "QuickSortInsertion100", resultados1);
                ArquivoDAO.escrever(0, "MergeSort", resultados2);
                ArquivoDAO.escrever(0, "InsertionSort", resultados3);
                ArquivoDAO.escrever(0, "HeapSort", resultados4);
                ArquivoDAO.escrever(0, "SelectionSort", resultados5);
                response.sendRedirect("sucesso.html");
                break;
            }
            default: { // Envia erro caso a solicitação não tenha sido feita da maneira correta
                response.sendRedirect("erro.html");
                break;
            }
        }
    }
}
