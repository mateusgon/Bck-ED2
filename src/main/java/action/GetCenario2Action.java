package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Gasto;
import ordenacao.QuickSort;
import persistence.EntradaDAO;
import persistence.GastoDAO;

public class GetCenario2Action implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer identificador = Integer.parseInt(request.getParameter("id"));
        if (identificador.equals(0)) {
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/cenario2.jsp");
            dispacher.forward(request, response);
        } else if (identificador.equals(1)) {
            Integer [] quantidadeLeitura = EntradaDAO.getInstance();
            Long [] resultadoLeitura = new Long[quantidadeLeitura[0]*5];
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
                   // resultadoLeitura[contadorLeitura] = quick.ordenaInteiro(analise);
                    contadorLeitura++;
                }
            }
            request.setAttribute("resultadoLeitura", resultadoLeitura);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/objetoCenario2.jsp");
            dispatcher.forward(request, response);
        } else if (identificador.equals(2)) {
            
        } else {

        }
    }
    
}
