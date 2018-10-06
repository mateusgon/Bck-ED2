package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.GastoDAO;

public class GetItemAction implements Action { // Responsável por redirecionar para as ações de cada item do trabalho. 

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer identificador = Integer.parseInt(request.getParameter("id"));
        if (identificador == 1) { 
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/item1.jsp"); // Envia para o item um, onde os 4 cenários serão exibidos
            dispacher.forward(request, response);
        } else if (identificador == 2) {
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/item2.jsp"); // Envia para o item dois, onde a tabela hash é implementada
            dispacher.forward(request, response);
        } else {

        }
    }

}
