package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ArquivoDAO;
import persistence.GastoDAO;

public class GetInicialAction implements Action { // Responsável por averiguar se o usuário escolheu o Entrada.txt ou preferiu entrar com os dados.

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer identificador = Integer.parseInt(request.getParameter("id"));
        if (identificador == 1) {
            GastoDAO.getInstance();
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/inicial.jsp");
            dispatcher.forward(request, response);
        }
        else if (identificador == 2)
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/inicial2.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
            
        }
        /*
        if (identificador == 0) { // Preferiu escolher o Entrada.txt
            ArquivoDAO.getInstance();
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/escolhaItem.jsp"); // Escolhe o Item 1 ou Item 2 do trabalho.
            dispacher.forward(request, response);
        } else if (identificador == 1) { // Preferiu digitar os dados
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/inicial.jsp"); // Informa os dados
            dispacher.forward(request, response);
        } else if (identificador == 2){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/inicial.jsp");
            dispatcher.forward(request, response);
        }*/
    }

}
