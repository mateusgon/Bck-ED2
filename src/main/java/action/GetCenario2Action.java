package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Resultado;
import ordenacao.QuickSort;
import persistence.ArquivoDAO;
import persistence.GastoDAO;

public class GetCenario2Action implements Action { // Implementar Action e é responsável por receber a requisição de exibir o cenário 2

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer identificador = Integer.parseInt(request.getParameter("id")); // Recebe um identificador na requisição, esse identificador possui qual atividade no cenário o usuário deseja realizar. Por exemplo, ordenar de acordo com a mediana100.
        switch (identificador) {
            case 0: // Deseja somente exibir a tela inicial do cenário 2
                RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/cenario2.jsp");
                dispacher.forward(request, response);
                break;
            case 1: { // Deseja ordenar por inteiros
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance();  // Recebe a quantidade de dados que deverá ser lida
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
                        quick.ordenaInteiro(analise, resultado); // Ordena o vetor
                        resultados[contadorLeitura] = resultado; // Armazena o resultado do vetor
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(0, "QuickSortInteiros", resultados); // Escreve o resultado no arquivo txt
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultados.jsp"); // Faz a requisição para um novo servlet
                dispatcher.forward(request, response);
                break;
            }
            case 2: { // >>>> Funcionamento semelhante ao de cima, contudo, na hora de ordenar, ele utiliza a mediana de 3 ou 5 elementos <<<<
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance();
                Integer identificador2 = Integer.parseInt(request.getParameter("k")); // Recebe o valor da mediana
                if (identificador2 == 3) { // Confere se a mediana é 3, senão, vai paara a próxima verificação
                    Resultado[] resultados = new Resultado[30];
                    Integer contadorLeitura = 0;
                    for (int i = 1; i < quantidadeLeitura.length; i++) {
                        for (int j = 0; j < 5; j++) {
                            GastoDAO.shuffle();
                            Integer[] analise = new Integer[quantidadeLeitura[i]];
                            for (int k = 0; k < quantidadeLeitura[i]; k++) {
                                analise[k] = GastoDAO.getInstance().get(k).getReceipt_value();
                            }
                            QuickSort quick = new QuickSort();
                            Resultado resultado = new Resultado();
                            quick.ordenaInteiroMediana(analise, resultado, identificador2);
                            resultados[contadorLeitura] = resultado;
                            contadorLeitura++;
                        }
                    }
                    ArquivoDAO.escrever(0, "QuickSortMediana3", resultados);
                    request.setAttribute("resultadoLeitura", resultados);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultados.jsp");
                    dispatcher.forward(request, response);
                } else if (identificador2 == 5) { // Confere se a mediana é 5, caso não seja, há algum erro na hora de solicitar o cenário 2
                    Resultado[] resultados = new Resultado[30];
                    Integer contadorLeitura = 0;
                    for (int i = 1; i < quantidadeLeitura.length; i++) {
                        for (int j = 0; j < 5; j++) {
                            GastoDAO.shuffle();
                            Integer[] analise = new Integer[quantidadeLeitura[i]];
                            for (int k = 0; k < quantidadeLeitura[i]; k++) {
                                analise[k] = GastoDAO.getInstance().get(k).getReceipt_value();
                            }
                            QuickSort quick = new QuickSort();
                            Resultado resultado = new Resultado();
                            quick.ordenaInteiroMediana(analise, resultado, identificador2);
                            resultados[contadorLeitura] = resultado;
                            contadorLeitura++;
                        }
                    }
                    ArquivoDAO.escrever(0, "QuickSortMediana5", resultados);
                    request.setAttribute("resultadoLeitura", resultados);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultados.jsp");
                    dispatcher.forward(request, response);
                } else { // Chama a página de erro
                    response.sendRedirect("/WEB-INF/erro.jsp");
                }
                break;
            }
            case 3: { // >>>> Funcionamento semelhante ao de cima, contudo, na hora de ordenar, ele utiliza o insertionSort para 10 ou 100 elementos <<<<
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance();
                Integer identificador2 = Integer.parseInt(request.getParameter("m"));
                if (identificador2 == 10) { // Verifica se realmente são 10 elementos
                    Resultado[] resultados = new Resultado[30];
                    Integer contadorLeitura = 0;
                    for (int i = 1; i < quantidadeLeitura.length; i++) {
                        for (int j = 0; j < 5; j++) {
                            GastoDAO.shuffle();
                            Integer[] analise = new Integer[quantidadeLeitura[i]];
                            for (int k = 0; k < quantidadeLeitura[i]; k++) {
                                analise[k] = GastoDAO.getInstance().get(k).getReceipt_value();
                            }
                            QuickSort quick = new QuickSort();
                            Resultado resultado = new Resultado();
                            quick.ordenaInteiroQuickSortInsertion(analise, resultado, identificador2);
                            resultados[contadorLeitura] = resultado;
                            contadorLeitura++;
                        }
                    }
                    ArquivoDAO.escrever(0, "QuickSortInsertion10", resultados);
                    request.setAttribute("resultadoLeitura", resultados);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultados.jsp");
                    dispatcher.forward(request, response);
                } else if (identificador2 == 100) { // Verifica se realmente são 100 elementos. Caso não seja o primeiro e nem esse, há algum erro.
                    Resultado[] resultados = new Resultado[30];
                    Integer contadorLeitura = 0;
                    for (int i = 1; i < quantidadeLeitura.length; i++) {
                        for (int j = 0; j < 5; j++) {
                            GastoDAO.shuffle();
                            Integer[] analise = new Integer[quantidadeLeitura[i]];
                            for (int k = 0; k < quantidadeLeitura[i]; k++) {
                                analise[k] = GastoDAO.getInstance().get(k).getReceipt_value();
                            }
                            QuickSort quick = new QuickSort();
                            Resultado resultado = new Resultado();
                            quick.ordenaInteiroQuickSortInsertion(analise, resultado, identificador2);
                            resultados[contadorLeitura] = resultado;
                            contadorLeitura++;
                        }
                    }
                    ArquivoDAO.escrever(0, "QuickSortInsertion100", resultados);
                    request.setAttribute("resultadoLeitura", resultados);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultados.jsp");
                    dispatcher.forward(request, response);
                } else { // Chama a página de erro
                    response.sendRedirect("/WEB-INF/erro.jsp");
                }
                break;
            }
            case 4: { // Funcionamento semelhante ao caso 1, caso 2 e caso 3. Contudo, ele executa todos os casos do cenário 2 de uma vez só. Ele é uma junção dos 3 casos anteriores e todas as ordenações que podem ser feitas.
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance();
                Resultado[] resultados = new Resultado[30];
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
                        QuickSort quick = new QuickSort();
                        Resultado resultado = new Resultado();
                        Resultado resultado2 = new Resultado();
                        Resultado resultado3 = new Resultado();
                        Resultado resultado4 = new Resultado();
                        Resultado resultado5 = new Resultado();
                        quick.ordenaInteiro(analise, resultado);
                        quick.ordenaInteiroMediana(analise, resultado2, 3);
                        quick.ordenaInteiroMediana(analise, resultado3, 5);
                        quick.ordenaInteiroQuickSortInsertion(analise, resultado4, 10);
                        quick.ordenaInteiroQuickSortInsertion(analise, resultado5, 100);
                        resultados2[contadorLeitura] = resultado2;
                        resultados3[contadorLeitura] = resultado3;
                        resultados4[contadorLeitura] = resultado4;
                        resultados5[contadorLeitura] = resultado5;
                        resultados[contadorLeitura] = resultado;
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(0, "QuickSortInteiros", resultados);
                ArquivoDAO.escrever(0, "QuickSortMediana3", resultados2);
                ArquivoDAO.escrever(0, "QuickSortMediana5", resultados3);
                ArquivoDAO.escrever(0, "QuickSortInsertion10", resultados4);
                ArquivoDAO.escrever(0, "QuickSortInsertion100", resultados5);
                response.sendRedirect("sucesso.html");
                break;
            }
            default:
                response.sendRedirect("erro.html");
                break;
        }
    }

}
