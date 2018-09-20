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

public class GetCenario2Action implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer identificador = Integer.parseInt(request.getParameter("id"));
        if (identificador.equals(0)) {
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/cenario2.jsp");
            dispacher.forward(request, response);
        } else if (identificador.equals(1)) {
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
            ArquivoDAO.escrever("Resultado Inteiro", resultados);
            request.setAttribute("resultadoLeitura", resultados);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ResultadoCenario1.jsp");
            dispatcher.forward(request, response);
        } else if (identificador.equals(2)) {
            Integer [] quantidadeLeitura = ArquivoDAO.getInstance();
            Integer identificador2 = Integer.parseInt(request.getParameter("k"));
            if(identificador2 == 3)
            {
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
                        quick.ordenaInteiroMediana(analise, resultado, identificador2);
                        resultados[contadorLeitura] = resultado;
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever("Resultado Inteiro", resultados);
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ResultadoCenario1.jsp");
                dispatcher.forward(request, response);
            }
            else if(identificador2 == 5)
            {
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
                        quick.ordenaInteiroMediana(analise, resultado, identificador2);
                        resultados[contadorLeitura] = resultado;
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever("Resultado Inteiro", resultados);
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ResultadoCenario1.jsp");
                dispatcher.forward(request, response);
            }
            else
            {
                
            }
        } else if (identificador.equals(3)){

        }
        else{}
    }
    
}
