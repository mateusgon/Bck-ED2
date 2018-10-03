package action;

import hash.TabelaHashEncadeamentoCoalescido;
import hash.TabelaHashEncadeamentoSeparado;
import hash.TabelaHashEnderecamento;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Resultado;
import persistence.ArquivoDAO;
import persistence.GastoDAO;

public class GetCenario4Action implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer identificador = Integer.parseInt(request.getParameter("id"));
        switch (identificador) {
            case 0: {
                RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/cenario4.jsp");
                dispacher.forward(request, response);
                break;
            }
            case 1: {
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance();
                Resultado[] resultados = new Resultado[30];
                Integer contadorLeitura = 0;
                for (int i = 1; i < quantidadeLeitura.length; i++) {
                    for (int j = 0; j < 5; j++) {
                        GastoDAO.shuffle();
                        Integer[] analise = new Integer[quantidadeLeitura[i]];
                        for (int k = 0; k < quantidadeLeitura[i]; k++) {
                            analise[k] = GastoDAO.getInstance().get(k).getDeputy_id();
                        }
                        TabelaHashEnderecamento tabela = new TabelaHashEnderecamento();
                        Resultado resultado = new Resultado();
                        tabela.insereSondagemLinear(analise, resultado);
                        resultados[contadorLeitura] = resultado;
                        System.out.println(contadorLeitura);
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(1, "SondagemLinear", resultados);
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultados2.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case 2: {
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance();
                Resultado[] resultados = new Resultado[30];
                Integer contadorLeitura = 0;
                for (int i = 1; i < quantidadeLeitura.length; i++) {
                    for (int j = 0; j < 5; j++) {
                        GastoDAO.shuffle();
                        Integer[] analise = new Integer[quantidadeLeitura[i]];
                        for (int k = 0; k < quantidadeLeitura[i]; k++) {
                            analise[k] = GastoDAO.getInstance().get(k).getDeputy_id();
                        }
                        TabelaHashEnderecamento tabela = new TabelaHashEnderecamento();
                        Resultado resultado = new Resultado();
                        tabela.insereSondagemQuadratica(analise, resultado);
                        resultados[contadorLeitura] = resultado;
                        System.out.println(contadorLeitura);
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(1, "SondagemQuadratica", resultados);
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultados2.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case 3: {
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance();
                Resultado[] resultados = new Resultado[30];
                Integer contadorLeitura = 0;
                for (int i = 1; i < quantidadeLeitura.length; i++) {
                    for (int j = 0; j < 5; j++) {
                        GastoDAO.shuffle();
                        Integer[] analise = new Integer[quantidadeLeitura[i]];
                        for (int k = 0; k < quantidadeLeitura[i]; k++) {
                            analise[k] = GastoDAO.getInstance().get(k).getDeputy_id();
                        }
                        TabelaHashEnderecamento tabela = new TabelaHashEnderecamento();
                        Resultado resultado = new Resultado();
                        tabela.insereDuploHash(analise, resultado);
                        resultados[contadorLeitura] = resultado;
                        System.out.println(contadorLeitura);
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(1, "DuploHash", resultados);
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultados2.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case 4: {
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance();
                Resultado[] resultados = new Resultado[30];
                Integer contadorLeitura = 0;
                for (int i = 1; i < quantidadeLeitura.length; i++) {
                    for (int j = 0; j < 5; j++) {
                        GastoDAO.shuffle();
                        Integer[] analise = new Integer[quantidadeLeitura[i]];
                        for (int k = 0; k < quantidadeLeitura[i]; k++) {
                            analise[k] = GastoDAO.getInstance().get(k).getDeputy_id();
                        }
                        TabelaHashEncadeamentoSeparado tabela = new TabelaHashEncadeamentoSeparado(analise.length);
                        Resultado resultado = new Resultado();
                        tabela.EncadeamentoSeparado(analise, resultado);
                        resultados[contadorLeitura] = resultado;
                        System.out.println(contadorLeitura);
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(1, "EncadeamentoSeparado", resultados);
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultados2.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case 5: {
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance();
                Resultado[] resultados = new Resultado[30];
                Integer contadorLeitura = 0;
                for (int i = 1; i < quantidadeLeitura.length; i++) {
                    for (int j = 0; j < 5; j++) {
                        GastoDAO.shuffle();
                        Integer[] analise = new Integer[quantidadeLeitura[i]];
                        for (int k = 0; k < quantidadeLeitura[i]; k++) {
                            analise[k] = GastoDAO.getInstance().get(k).getDeputy_id();
                        }
                        TabelaHashEncadeamentoCoalescido tabela = new TabelaHashEncadeamentoCoalescido(analise.length);
                        Resultado resultado = new Resultado();
                        tabela.encadeamentoCoalescido(analise, resultado);
                        resultados[contadorLeitura] = resultado;
                        System.out.println(contadorLeitura);
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(1, "EncadeamentoCoalescido", resultados);
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultados2.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case 6: {
                break;
            }
            default: {
                break;
            }
        }
    }

}
