package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ordenacao.QuickSort;
import persistence.ArquivoDAO;
import persistence.GastoDAO;

public class GetCenario3Action implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer identificador = Integer.parseInt(request.getParameter("id"));
        switch(identificador)
        {
            case 0:
            {
                RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/cenario3.jsp");
                dispacher.forward(request, response);
                break;
            }
            case 1:
            {
                break;   
            }
            case 2:
            {
                break;   
            }
            case 3:
            {
                break;   
            }
            case 4:
            {
                break;   
            }
            case 5:
            {
                break;
            }
            case 6:
            {
                break;
            }
            default:
            {
                break;
            }
        }
    }
}
