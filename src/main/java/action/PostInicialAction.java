package action;

import arvores.NoTrie;
import arvores.Trie;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Gasto;
import persistence.GastoDAO;

public class PostInicialAction implements Action { // Responsável por processar a entrada de quantos dados serão exibidos na tela pelo Item 2

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String nome = request.getParameter("quantidadeElementos"); // Recebe a quantidade de elementos
            GastoDAO.getInstance();
            Trie arvore = new Trie();
            for (Gasto sugestao : GastoDAO.getInstance()) {
                arvore.inserir(sugestao);
            }
            Gasto gasto = new Gasto();
            gasto.setReceipt_description("Teste");
            gasto.setReceipt_value(0);
            arvore.inserir(gasto);
            NoTrie noAux = arvore.pesquisar(nome);
            if (noAux != null) {
                System.out.println("Achei");
                response.sendRedirect("erro.html");
                // Achou a palavra
            }
            NoTrie noAux2 = arvore.getLocalizacaoString(nome);
            arvore.autocomplete(noAux2);
            System.out.println(arvore.getSugestoes().size());
            System.out.println("Aqui estão as sugestões\n");
            for (Gasto dado
                    : arvore.getSugestoes()) {
                System.out.println(dado.getReceipt_description());
                System.out.println(dado.getReceipt_value());
            }
        } catch (Exception ex) {
            response.sendRedirect("erro.html");
        }
    }

}
