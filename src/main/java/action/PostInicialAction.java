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

public class PostInicialAction implements Action { // Responsável por processar a entrada de quantos dados serão exibidos na tela pelo Item 2

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer numero = Integer.parseInt(request.getParameter("quantidadeElementos")); // Recebe a quantidade de elementos
            TabelaHashItem2 hash = new TabelaHashItem2(); // Instancia a tabela hash do item 2
            Integer quantidadeDeputadosEPartidos[] = GastoDAO.getInstanceHash(hash); // Insere na tabela hash os elementos
            NoListaEncadeadaDeputadoItem2[] gastos = hash.buscarOrdenarDeputados(quantidadeDeputadosEPartidos[0]); // Ordena os gastos dos deputados na tabela hash
            NoListaEncadeadaPartidoItem2[] gastos2 = hash.buscarOrdenarPartidos(quantidadeDeputadosEPartidos[1]); // Ordena os gastos dos partidos na tabela hash
            ArrayList<NoListaEncadeadaDeputadoItem2> maisGastaram = new ArrayList<>();
            ArrayList<NoListaEncadeadaPartidoItem2> maisGastaramPartido = new ArrayList<>();
            ArrayList<NoListaEncadeadaDeputadoItem2> menosGastaram = new ArrayList<>();
            ArrayList<NoListaEncadeadaPartidoItem2> menosGastaramPartido = new ArrayList<>();
            for (int i = 0; i < numero; i++) { // Os três "for" são responsáveis por preencherem os deputados e os partidos que mais e menos gastaram
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
        } catch (Exception ex) {
            response.sendRedirect("erro.html");
        }
    }

}
