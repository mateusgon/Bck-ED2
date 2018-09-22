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

public class GetCenario2Action implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer identificador = Integer.parseInt(request.getParameter("id"));
        switch (identificador) {
            case 0:
                RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/cenario2.jsp");
                dispacher.forward(request, response);
                break;
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
                Integer identificador2 = Integer.parseInt(request.getParameter("k"));
                if (identificador2 == 3) {
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
                    ArquivoDAO.escrever(2, resultados);
                    request.setAttribute("resultadoLeitura", resultados);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultados.jsp");
                    dispatcher.forward(request, response);
                } else if (identificador2 == 5) {
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
                    ArquivoDAO.escrever(3, resultados);
                    request.setAttribute("resultadoLeitura", resultados);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultados.jsp");
                    dispatcher.forward(request, response);
                } else {
                    response.sendRedirect("/WEB-INF/erro.jsp");
                }
                break;
            }
            case 3: {
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance();
                Integer identificador2 = Integer.parseInt(request.getParameter("m"));
                if (identificador2 == 10) {
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
                    ArquivoDAO.escrever(4, resultados);
                    request.setAttribute("resultadoLeitura", resultados);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultados.jsp");
                    dispatcher.forward(request, response);
                } else if (identificador2 == 100) {
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
                    ArquivoDAO.escrever(5, resultados);
                    request.setAttribute("resultadoLeitura", resultados);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultados.jsp");
                    dispatcher.forward(request, response);
                } else {
                    response.sendRedirect("/WEB-INF/erro.jsp");
                }
                break;
            }
            case 4: {
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
                ArquivoDAO.escrever(1, resultados);
                ArquivoDAO.escrever(2, resultados2);
                ArquivoDAO.escrever(3, resultados3);
                ArquivoDAO.escrever(4, resultados4);
                ArquivoDAO.escrever(5, resultados5);
                response.sendRedirect("sucesso.html");
                break;
            }
            default:
                break;
        }
    }

}
