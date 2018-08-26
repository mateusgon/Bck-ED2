package action;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Gasto;
import persistence.GastoDAO;

public class GetCenario1Action implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer identificador = Integer.parseInt(request.getParameter("id"));
        if (identificador.equals(0)) {
            GastoDAO.getInstance();
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/cenario1.jsp");
            dispacher.forward(request, response);
        } else if (identificador.equals(1)) {

        } else if (identificador.equals(2)) {

        } else {

        }
    }

}
