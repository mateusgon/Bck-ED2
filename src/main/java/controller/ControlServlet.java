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

@WebServlet(urlPatterns = {"/index.html", "/erro.html", "/sucesso.html", "/cenario1.html", "/cenario2.html", "/cenario3.html", "/cenario4.html", "/cenario5.html"})
public class ControlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> rotas = new HashMap<>();
        rotas.put("/index.html", "action.GetIndexAction");
        rotas.put("/cenario1.html", "action.GetCenario1Action");
        rotas.put("/cenario2.html", "action.GetCenario2Action");
        rotas.put("/cenario3.html", "action.GetCenario3Action");
        rotas.put("/cenario4.html", "action.GetCenario4Action");
        rotas.put("/cenario5.html", "action.GetCenario5Action");
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
        Map<String, String> rotas = new HashMap<>();
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
