package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.GastoDAO;

public class GetIndexAction implements Action{ // Primeira página do sistema web. É utilizada para chamar o index.jsp e fazer com que o usuário escolha se deseja o Entrada.txt ou Informar a entrada

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GastoDAO.getInstance(); // Lê os dados da planilha já no primeiro momento de execução do sistema
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/index.jsp");
        dispacher.forward(request, response);
    }
    
}
