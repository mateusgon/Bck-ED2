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

public class GetCenario4Action implements Action { // Implementa Action e é responsável por receber a requisição de exibir o cenário 4

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // Recebe um identificador na requisição, esse identificador possui qual atividade no cenário o usuário deseja realizar. Por exemplo,utilizar o Encadeamento separado .
        Integer identificador = Integer.parseInt(request.getParameter("id"));
        switch (identificador) {
            case 0: { // Deseja somente exibir a tela inicial do cenário 3
                RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/cenario4.jsp");
                dispacher.forward(request, response);
                break;
            }
            case 1: { // Deseja utilizar SondagemLinear para o tratamento de colisões.
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance(); // Recebe a quantidade de dados que deverá ser lida
                Resultado[] resultados = new Resultado[30]; // Cria os resultados para escrever e imprimir os resultados da execução
                Integer contadorLeitura = 0; 
                for (int i = 1; i < quantidadeLeitura.length; i++) { // Executa 6 vezes, pois são 6 números diferentes
                    for (int j = 0; j < 5; j++) { // Executa as 5 sementes
                        GastoDAO.shuffle(); // Embaralha o ArrayList
                        Integer[] analise = new Integer[quantidadeLeitura[i]]; // Cria um vetor com o tamanho necessário definido no Entrada.txt ou informado pelo usuário
                        for (int k = 0; k < quantidadeLeitura[i]; k++) { // Lê a quantidade desejada do ArrayList
                            analise[k] = GastoDAO.getInstance().get(k).getDeputy_id(); // O vetor recebe do ArrayList os elementos para serem ordenados
                        }
                        TabelaHashEnderecamento tabela = new TabelaHashEnderecamento(); // Inicializa a tabela de endereçamento
                        Resultado resultado = new Resultado(); 
                        tabela.insereSondagemLinear(analise, resultado); // Utiliza a Sondagem linear para inserir
                        resultados[contadorLeitura] = resultado; // Armazena o resultado no vetor
                        System.out.println(contadorLeitura);
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(1, "SondagemLinear", resultados); // Escreve o resultado em um txt.
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultadosHashing.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case 2: { // >>>> Funcionamento semelhante ao de cima, contudo, na hora do tratamento de colisões, ele utiliza Sondagem Quadrática <<<<
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
                        tabela.insereSondagemQuadratica(analise, resultado); // Utilizando sondagem quadrática
                        resultados[contadorLeitura] = resultado;
                        System.out.println(contadorLeitura);
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(1, "SondagemQuadratica", resultados);
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultadosHashing.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case 3: { // >>>> Funcionamento semelhante ao de cima, contudo, na hora do tratamento de colisões, ele utiliza DuploHash <<<<
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
                        tabela.insereDuploHash(analise, resultado); // DuploHash
                        resultados[contadorLeitura] = resultado;
                        System.out.println(contadorLeitura);
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(1, "DuploHash", resultados);
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultadosHashing.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case 4: { // >>>> Funcionamento semelhante ao de cima, contudo, na hora do tratamento de colisões, ele utiliza o Encadeamento Separado <<<<
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
                        tabela.EncadeamentoSeparado(analise, resultado); // Encadeamento separado
                        resultados[contadorLeitura] = resultado;
                        System.out.println(contadorLeitura);
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(1, "EncadeamentoSeparado", resultados);
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultadosHashing.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case 5: { // >>>> Funcionamento semelhante ao de cima, contudo, na hora do tratamento de colisões, ele utiliza Encadeamento Coalescido <<<<
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
                        tabela.encadeamentoCoalescido(analise, resultado); // EncadeamentoCoalescido
                        resultados[contadorLeitura] = resultado;
                        System.out.println(contadorLeitura);
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(1, "EncadeamentoCoalescido", resultados);
                request.setAttribute("resultadoLeitura", resultados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultadosHashing.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case 6: { // Funcionamento semelhante ao caso 1, caso 2, caso 3, caso 4 e caso 5. Contudo, ele executa todos os casos do cenário 4 de uma vez só. Ele é uma junção dos 5 casos anteriores e todas os tratamentos de colisões que podem ser feitas.
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance();
                Resultado[] resultados1 = new Resultado[30];
                Resultado[] resultados2 = new Resultado[30];
                Resultado[] resultados3 = new Resultado[30];
                Resultado[] resultados4 = new Resultado[30];
                Resultado[] resultados5 = new Resultado[30];
                Integer contadorLeitura = 0;
                for (int i = 1; i < quantidadeLeitura.length; i++) {
                    for (int j = 0; j < 5; j++) {
                        GastoDAO.shuffle();
                        Integer[] analise1 = new Integer[quantidadeLeitura[i]];
                        Integer[] analise2 = new Integer[quantidadeLeitura[i]];
                        Integer[] analise3 = new Integer[quantidadeLeitura[i]];
                        Integer[] analise4 = new Integer[quantidadeLeitura[i]];
                        Integer[] analise5 = new Integer[quantidadeLeitura[i]];
                        for (int k = 0; k < quantidadeLeitura[i]; k++) {
                            analise1[k] = GastoDAO.getInstance().get(k).getDeputy_id();
                            analise2[k] = GastoDAO.getInstance().get(k).getDeputy_id();
                            analise3[k] = GastoDAO.getInstance().get(k).getDeputy_id();
                            analise4[k] = GastoDAO.getInstance().get(k).getDeputy_id();
                            analise5[k] = GastoDAO.getInstance().get(k).getDeputy_id();
                        }
                        TabelaHashEnderecamento tabela = new TabelaHashEnderecamento();
                        TabelaHashEnderecamento tabela2 = new TabelaHashEnderecamento();
                        TabelaHashEnderecamento tabela3 = new TabelaHashEnderecamento();
                        TabelaHashEncadeamentoSeparado tabela4 = new TabelaHashEncadeamentoSeparado(analise4.length);
                        TabelaHashEncadeamentoCoalescido tabela5 = new TabelaHashEncadeamentoCoalescido(analise5.length);
                        Resultado resultado1 = new Resultado();
                        Resultado resultado2 = new Resultado();
                        Resultado resultado3 = new Resultado();
                        Resultado resultado4 = new Resultado();
                        Resultado resultado5 = new Resultado();
                        tabela.insereSondagemLinear(analise1, resultado1); // Sondagem Linear
                        tabela2.insereSondagemQuadratica(analise2, resultado2); // Sondagem Quadrãtica
                        tabela3.insereDuploHash(analise3, resultado3); // DuploHash
                        tabela4.EncadeamentoSeparado(analise4, resultado4); // Encadeamento Separado
                        tabela5.encadeamentoCoalescido(analise5, resultado5); // Encadeamento Coalescido
                        resultados1[contadorLeitura] = resultado1;
                        resultados2[contadorLeitura] = resultado2;
                        resultados3[contadorLeitura] = resultado3;
                        resultados4[contadorLeitura] = resultado4;
                        resultados5[contadorLeitura] = resultado5;
                        contadorLeitura++;
                    }
                }
                ArquivoDAO.escrever(1, "SondagemLinear", resultados1);
                ArquivoDAO.escrever(1, "SondagemQuadrática", resultados2);
                ArquivoDAO.escrever(1, "DuploHash", resultados3);
                ArquivoDAO.escrever(1, "EncadeamentoSeparado", resultados4);
                ArquivoDAO.escrever(1, "EncadeamentoCoalescido", resultados5);
                response.sendRedirect("sucesso.html");
                break;
            }
            default: {
                response.sendRedirect("erro.html");
                break;
            }
        }
    }
}
