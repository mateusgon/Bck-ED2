package controller;

import action.Action;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// Responsável por receber as requisições e distribuir para o action correto. Funcinando no padrão MVC.
@WebServlet(urlPatterns = {"/index.html", "/inicial.html", "/item.html", "/erro.html", "/sucesso.html", "/cenario1.html", "/cenario2.html", "/cenario3.html", "/cenario4.html", "/item2.html"})
public class ControlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> rotas = new HashMap<>(); // Recebe todas as rotas que o sistema web poderá fazer
        rotas.put("/index.html", "action.GetIndexAction");
        rotas.put("/inicial.html", "action.GetInicialAction");
        rotas.put("/item.html", "action.GetEscolhaItemAction");
        rotas.put("/cenario1.html", "action.GetCenario1Action");
        rotas.put("/cenario2.html", "action.GetCenario2Action");
        rotas.put("/cenario3.html", "action.GetCenario3Action");
        rotas.put("/cenario4.html", "action.GetCenario4Action");
        rotas.put("/item2.html", "action.GetItem2Action");
        rotas.put("/sucesso.html", "action.GetSucessoAction");
        rotas.put("/erro.html", "action.GetErroAction");
        String clazzName = rotas.get(request.getServletPath());
        try {
            Action action = (Action) Class.forName(clazzName).newInstance();
            action.execute(request, response);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            response.sendError(500, "Erro: " + ex);
            Logger.getLogger(ControlServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> rotas = new HashMap<>(); // Recebe todas as rotas de processamento do Post
        rotas.put("/inicial.html", "action.PostInicialAction");
        String clazzName = rotas.get(request.getServletPath());
        try {
            Action action = (Action) Class.forName(clazzName).newInstance();
            action.execute(request, response);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            response.sendError(500, "Erro: " + ex);
            Logger.getLogger(ControlServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
