package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ArquivoDAO;

public class GetEscolhaItemAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer identificador = Integer.parseInt(request.getParameter("id"));
        if (identificador == 0) {
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/item1.jsp");
            dispacher.forward(request, response);
        }
        else if (identificador == 1)
        {
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/item2.jsp");
            dispacher.forward(request, response);
        }
        else
        {
        
        }
    }

}
