package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Gasto;
import model.Resultado;
import ordenacao.InsertionSort;
import ordenacao.MergeSort;
import ordenacao.QuickSort;
import ordenacao.SelectionSort;
import persistence.ArquivoDAO;
import persistence.GastoDAO;

public class GetCenario3Action implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer identificador = Integer.parseInt(request.getParameter("id"));
        switch (identificador) {
            case 0: {
                RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/cenario3.jsp");
                dispacher.forward(request, response);
                break;
            }
            case 1: {
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
                        QuickSort quick = new QuickSort();
                        Resultado resultado = new Resultado();
                        quick.ordenaInteiro(analise, resultado);
                        resultados[contadorLeitura] = resultado;
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(1, resultados);
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultados.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case 2: {
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
                        MergeSort merge = new MergeSort();
                        Resultado resultado = new Resultado();
                        merge.ordena(analise, resultado);
                        resultados[contadorLeitura] = resultado;
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(6, resultados);
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultados.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case 3: {
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
                        InsertionSort insertion = new InsertionSort();
                        Resultado resultado = new Resultado();
                        insertion.ordena(analise, resultado);
                        resultados[contadorLeitura] = resultado;
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(7, resultados);
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultados.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case 4: {
                break;
            }
            case 5: {
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
                        SelectionSort selection = new SelectionSort();
                        Resultado resultado = new Resultado();
                        selection.ordena(analise, resultado);
                        resultados[contadorLeitura] = resultado;
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(9, resultados);
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultados.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case 6: {
                break;
            }
            default: {
                break;
            }
        }
    }
}
