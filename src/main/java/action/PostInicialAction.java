package action;

import hash.NoListaEncadeadaDeputadoItem2;
import hash.NoListaEncadeadaPartidoItem2;
import hash.TabelaHashItem2;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.GastoDAO;

public class PostInicialAction implements Action { // Responsável por processar a entrada do usuário que substituirá o Emtrada.txt

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //try {
            Integer numero = Integer.parseInt(request.getParameter("quantidadeElementos")); // Os elementos e os números são recebidos em formato de texto
            TabelaHashItem2 hash = new TabelaHashItem2();
            Integer quantidadeDeputados[] = GastoDAO.getInstanceHash(hash);
            NoListaEncadeadaDeputadoItem2[] gastos = hash.buscarOrdenarDeputados(quantidadeDeputados[0]);
            NoListaEncadeadaPartidoItem2[] gastos2 = hash.buscarOrdenarPartidos(quantidadeDeputados[1]);
            ArrayList<NoListaEncadeadaDeputadoItem2> maisGastaram = new ArrayList<>();
            ArrayList<NoListaEncadeadaPartidoItem2> maisGastaramPartido = new ArrayList<>();
            ArrayList<NoListaEncadeadaDeputadoItem2> menosGastaram = new ArrayList<>();
            ArrayList<NoListaEncadeadaPartidoItem2> menosGastaramPartido = new ArrayList<>();
            for (int i = 0; i < numero; i++) {
                menosGastaram.add(gastos[i]);
                menosGastaramPartido.add(gastos2[i]);
            }
            for (int i = gastos.length - 1; i > gastos.length - 1 - numero; i--) {
                maisGastaram.add(gastos[i]);
            }
            for (int i = gastos2.length - 1; i > gastos2.length - 1 - numero; i--) {
                maisGastaramPartido.add(gastos2[i]);
            }
            request.setAttribute("dMaioresGastos", maisGastaram);
            request.setAttribute("dMenoresGastos", menosGastaram);
            request.setAttribute("pMaioresGastos", maisGastaramPartido);
            request.setAttribute("pMenoresGastos", menosGastaramPartido);
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/resultadoItem2.jsp");
            dispacher.forward(request, response);
        //} catch (Exception ex) {
        //    response.sendRedirect("erro.html");
        //}
    }

}
