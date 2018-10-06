package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Gasto;
import model.Resultado;
import ordenacao.QuickSort;
import persistence.ArquivoDAO;
import persistence.GastoDAO;

public class GetCenario1Action implements Action { // Implementar Action e é responsável por receber a requisição de exibir o cenário 1

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer identificador = Integer.parseInt(request.getParameter("id")); // Recebe um identificador na requisição, esse identificador possui qual atividade no cenário o usuário deseja realizar. Por exemplo, ordenar por objetos.
        switch (identificador) {
            case 0: // Deseja somente exibir a tela inicial do cenário 1
                RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/cenario1.jsp");
                dispacher.forward(request, response);
                break;
            case 1: { // Deseja ordenar por objetos
                Integer contador = 0; 
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance(); // Recebe a quantidade de dados que deverá ser lida
                Resultado[] resultados = new Resultado[30]; // Cria os resultados para escrever e imprimir os resultados da execução
                for (int i = 1; i < quantidadeLeitura.length; i++) { // Executa 6 vezes, pois são 6 números
                    for (int j = 0; j < 5; j++) { // Executa as 5 sementes
                        GastoDAO.shuffle(); // Embaralha o ArrayList
                        Gasto[] analise = new Gasto[quantidadeLeitura[i]]; // Cria um vetor com o tamanho necessário definido no Entrada.txt ou informado pelo usuário
                        for (int k = 0; k < quantidadeLeitura[i]; k++) { // Lê a quantidade desejada do ArrayList
                            analise[k] = GastoDAO.getInstance().get(k); // O vetor recebe do ArrayList os elementos para serem ordenados
                        }
                        QuickSort quick = new QuickSort(); // Inicializa o QuickSort
                        Resultado resultado = new Resultado();
                        quick.ordenaObjeto(analise, resultado); // Ordena o vetor 
                        resultados[contador] = resultado; // Armazena os dados de execução do vetor
                        contador++;
                    }
                }
                ArquivoDAO.escrever(0, "QuickSortObjetos", resultados); // Escreve todos os resultados em um arquivo
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultadosOrdenacao.jsp"); // Chama o jsp para mostrar o resultado
                dispatcher.forward(request, response);
                break;
            }
            case 2: { // Deseja ordenar por inteiros
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance(); // Recebe a quantidade de dados que deverá ser lida
                Resultado[] resultados = new Resultado[30]; // Cria os resultados para escrever e imprimir os resultados da execução
                Integer contadorLeitura = 0;
                for (int i = 1; i < quantidadeLeitura.length; i++) {
                    for (int j = 0; j < 5; j++) {
                        GastoDAO.shuffle(); // Embaralha o ArrayList
                        Integer[] analise = new Integer[quantidadeLeitura[i]]; // Cria um vetor com o tamanho necessário definido no Entrada.txt ou informado pelo usuário
                        for (int k = 0; k < quantidadeLeitura[i]; k++) { // Lê a quantidade desejada do ArrayList
                            analise[k] = GastoDAO.getInstance().get(k).getReceipt_value(); // O vetor recebe do ArrayList os elementos para serem ordenados
                        }
                        QuickSort quick = new QuickSort(); // Inicializa o QuickSort
                        Resultado resultado = new Resultado();
                        quick.ordenaInteiro(analise, resultado); // Ordena o vetor 
                        resultados[contadorLeitura] = resultado; // Armazena os dados de execução do vetor
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(0, "QuickSortInteiros", resultados); // Escreve todos os resultados em um arquivo
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultadosOrdenacao.jsp"); // Chama o jsp para mostrar o resultado
                dispatcher.forward(request, response);
                break;
            }
            case 3: { // Realiza o mesmo processo dos dois citados acima, contudo, a execução é uma seguida da outra, pois essa opção seria de ordenar os dois de uma só vez.
                Integer contador = 0;
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance();
                Resultado[] resultados = new Resultado[30];
                for (int i = 1; i < quantidadeLeitura.length; i++) {
                    for (int j = 0; j < 5; j++) {
                        GastoDAO.shuffle();
                        Gasto[] analise = new Gasto[quantidadeLeitura[i]];
                        for (int k = 0; k < quantidadeLeitura[i]; k++) {
                            analise[k] = GastoDAO.getInstance().get(k);
                        }
                        QuickSort quick = new QuickSort();
                        Resultado resultado = new Resultado();
                        quick.ordenaObjeto(analise, resultado);
                        resultados[contador] = resultado;
                        contador++;
                    }
                }
                ArquivoDAO.escrever(0, "QuickSortObjetos", resultados);
                quantidadeLeitura = ArquivoDAO.getInstance();
                resultados = new Resultado[30];
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
                        quick.ordenaInteiro(analise, resultado);
                        resultados[contadorLeitura] = resultado;
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(0, "QuickSortInteiros", resultados);
                response.sendRedirect("sucesso.html");
                break;
            }
            default:
                response.sendRedirect("erro.html");
                break;
        }
    }

}
