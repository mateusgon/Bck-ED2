package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Gasto;
import model.Resultado;
import ordenacao.MergeSort;
import ordenacao.QuickSort;
import persistence.ArquivoDAO;
import persistence.GastoDAO;

public class GetCenario1Action implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer identificador = Integer.parseInt(request.getParameter("id"));
        switch (identificador) {
            case 0:
                RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/cenario1.jsp");
                dispacher.forward(request, response);
                break;
            case 1:
                {
                    Integer contador=0;
                    Integer [] quantidadeLeitura = ArquivoDAO.getInstance();
                    Resultado [] resultados = new Resultado[30];
                    for (int i = 1; i < quantidadeLeitura.length; i++) {
                        for (int j = 0; j < 5; j++)
                        {
                            GastoDAO.shuffle();
                            Gasto [] analise = new Gasto[quantidadeLeitura[i]];
                            for (int k = 0; k < quantidadeLeitura[i]; k++)
                            {
                                analise[k] = GastoDAO.getInstance().get(k);
                            }
                            QuickSort quick = new QuickSort();
                            Resultado resultado = new Resultado();
                            quick.ordenaObjeto(analise, resultado);
                            resultados[contador] = resultado;
                            contador++;
                        }
                    }       
                    ArquivoDAO.escrever(0, resultados);
                    request.setAttribute("resultadoLeitura", resultados);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultados.jsp");
                    dispatcher.forward(request, response);
                    break;
                }
            case 2:
                {
                    Integer [] quantidadeLeitura = ArquivoDAO.getInstance();
                    Resultado [] resultados = new Resultado[30];
                    Integer contadorLeitura = 0;
                    for (int i = 1; i < quantidadeLeitura.length; i++) {
                        for (int j = 0; j < 5; j++)
                        {
                            GastoDAO.shuffle();
                            Integer [] analise = new Integer[quantidadeLeitura[i]];
                            for (int k = 0; k < quantidadeLeitura[i]; k++)
                            {
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
            case 3:
                {
                    Integer [] quantidadeLeitura = ArquivoDAO.getInstance();
                    Resultado [] resultados = new Resultado[30];
                    Resultado [] resultados2 = new Resultado[30];
                    Integer contadorLeitura = 0;
                    for (int i = 1; i < quantidadeLeitura.length; i++) {
                        for (int j = 0; j < 5; j++)
                        {
                            GastoDAO.shuffle();
                            Integer [] analise = new Integer[quantidadeLeitura[i]];
                            Gasto [] analise2 = new Gasto[quantidadeLeitura[i]];
                            for (int k = 0; k < quantidadeLeitura[i]; k++)
                            {
                                analise[k] = GastoDAO.getInstance().get(k).getReceipt_value();
                                analise2[k] = GastoDAO.getInstance().get(k);
                            }
                            QuickSort quick = new QuickSort();
                            Resultado resultado = new Resultado();
                            Resultado resultado2 = new Resultado();
                            quick.ordenaInteiro(analise, resultado);
                            quick.ordenaObjeto(analise2, resultado2);
                            resultados[contadorLeitura] = resultado;
                            resultados2[contadorLeitura] = resultado2;
                            contadorLeitura++;
                        }
                    }       
                    ArquivoDAO.escrever(1, resultados);
                    ArquivoDAO.escrever(0, resultados2);
                    response.sendRedirect("sucesso.html");
                    break;
                }
            default:
                response.sendRedirect("/WEB-INF/erro.jsp");
                break;
        }
    }

}
