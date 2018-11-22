package action;

import arvores.ArvoreAVL;
import arvores.ArvoreB;
import arvores.ArvoreSplay;
import arvores.MinhaArvore;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Gasto;
import model.Resultado;
import ordenacao.QuickSort;
import persistence.ArquivoDAO;
import persistence.GastoDAO;

public class GetCenario1Action implements Action { // Implementar Action e é responsável por receber a requisição de exibir o cenário 1

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer identificador = Integer.parseInt(request.getParameter("id")); // Recebe um identificador na requisição, esse identificador possui qual atividade no cenário o usuário deseja realizar. Por exemplo, ordenar por objetos.
        switch (identificador) {
            case 0: { // Deseja ordenar por objetos
                Integer contador = 0;
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance(); // Recebe a quantidade de dados que deverá ser lida
                for (int i = 1; i < quantidadeLeitura.length; i++) { // Executa 6 vezes, pois são 6 números
                    Resultado resultados[] = new Resultado[25];
                    for (int j = 0; j < 5; j++) { // Executa as 5 sementes

                        GastoDAO.shuffle(); // Embaralha o ArrayList
                        Gasto[] analise = new Gasto[quantidadeLeitura[i]]; // Cria um vetor com o tamanho necessário definido no Entrada.txt ou informado pelo usuário
                        for (int k = 0; k < quantidadeLeitura[i]; k++) { // Lê a quantidade desejada do ArrayList
                            analise[k] = GastoDAO.getInstance().get(k); // O vetor recebe do ArrayList os elementos para serem ordenados
                        }
                        ArvoreAVL avl = new ArvoreAVL();
                        resultados[j] = new Resultado();
                        avl.insereGastos(analise, resultados[j]);

                        GastoDAO.shuffle();
                        Gasto[] analise2 = new Gasto[quantidadeLeitura[i]];
                        for (int k = 0; k < quantidadeLeitura[i]; k++) { // Lê a quantidade desejada do ArrayList
                            analise2[k] = GastoDAO.getInstance().get(k); // O vetor recebe do ArrayList os elementos para serem ordenados
                        }
                        resultados[j + 5] = new Resultado();
                        avl.buscaGastos(analise2, resultados[j + 5]);

                        Integer contadorAux = 0;
                        for (int k = (int) (analise.length * 0.7); k < quantidadeLeitura[i]; k++) {
                            analise2[k] = analise2[contadorAux];
                            contadorAux++;
                        }
                        QuickSort quick = new QuickSort();
                        Resultado resultado = new Resultado();
                        quick.ordenaObjeto(analise2, resultado);
                        resultados[j + 10] = new Resultado();
                        avl.buscaGastos(analise2, resultados[j + 10]);

                        ArvoreAVL avl2 = new ArvoreAVL();
                        try {
                            avl2 = avl.clone();
                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(GetCenario1Action.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        resultados[j + 15] = new Resultado();
                        avl2.excluirGastos(analise2, resultados[j + 15]);

                        for (int k = (int) (analise.length * 0.7); k < quantidadeLeitura[i]; k++) {
                            analise[k] = analise[contadorAux];
                            contadorAux++;
                        }
                        quick.ordenaObjeto(analise, resultado);
                        resultados[j + 20] = new Resultado();
                        avl.excluirGastos(analise, resultados[j + 20]);
                        contador++;
                    }
                    for (int k = 0; k < 25; k = k + 5) {
                        Resultado resultad[] = new Resultado[5];
                        resultad[0] = new Resultado();
                        resultad[0] = resultados[k];
                        resultad[1] = new Resultado();
                        resultad[1] = resultados[k + 1];
                        resultad[2] = new Resultado();
                        resultad[2] = resultados[k + 1];
                        resultad[3] = new Resultado();
                        resultad[3] = resultados[k + 1];
                        resultad[4] = new Resultado();
                        resultad[4] = resultados[k + 1];
                        if (k == 0) {
                            ArquivoDAO.escrever(0, (contador - 5) + "Arvore AVL - Inserção", resultad);
                        } else if (k == 5) {
                            ArquivoDAO.escrever(0, (contador - 5) + "Arvore AVL - Busca 1", resultad);
                        } else if (k == 10) {
                            ArquivoDAO.escrever(0, (contador - 5) + "Arvore AVL - Busca 2", resultad);
                        } else if (k == 15) {
                            ArquivoDAO.escrever(0, (contador - 5) + "Arvore AVL - Remoção 1", resultad);
                        } else if (k == 20) {
                            ArquivoDAO.escrever(0, (contador - 5) + "Arvore AVL - Remoção 2", resultad);
                        }
                    }
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultadosOrdenacao.jsp"); // Chama o jsp para mostrar o resultado
                dispatcher.forward(request, response);
                break;
            }
            case 1: { // Deseja ordenar por inteiros
                break;
            }
            case 2: {
                Integer contador = 0;
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance(); // Recebe a quantidade de dados que deverá ser lida
                for (int i = 1; i < quantidadeLeitura.length; i++) { // Executa 6 vezes, pois são 6 números
                    Resultado resultados[] = new Resultado[25];
                    for (int j = 0; j < 5; j++) { // Executa as 5 sementes

                        GastoDAO.shuffle(); // Embaralha o ArrayList
                        Gasto[] analise = new Gasto[quantidadeLeitura[i]]; // Cria um vetor com o tamanho necessário definido no Entrada.txt ou informado pelo usuário
                        for (int k = 0; k < quantidadeLeitura[i]; k++) { // Lê a quantidade desejada do ArrayList
                            analise[k] = GastoDAO.getInstance().get(k); // O vetor recebe do ArrayList os elementos para serem ordenados
                        }
                        ArvoreSplay splay = new ArvoreSplay();
                        resultados[j] = new Resultado();
                        splay.insereGastos(analise, resultados[j]);

                        GastoDAO.shuffle();
                        Gasto[] analise2 = new Gasto[quantidadeLeitura[i]];
                        for (int k = 0; k < quantidadeLeitura[i]; k++) { // Lê a quantidade desejada do ArrayList
                            analise2[k] = GastoDAO.getInstance().get(k); // O vetor recebe do ArrayList os elementos para serem ordenados
                        }
                        resultados[j + 5] = new Resultado();
                        splay.buscaGastos(analise2, resultados[j + 5]);

                        Integer contadorAux = 0;
                        for (int k = (int) (analise.length * 0.7); k < quantidadeLeitura[i]; k++) {
                            analise2[k] = analise2[contadorAux];
                            contadorAux++;
                        }
                        QuickSort quick = new QuickSort();
                        Resultado resultado = new Resultado();
                        quick.ordenaObjeto(analise2, resultado);
                        resultados[j + 10] = new Resultado();
                        splay.buscaGastos(analise2, resultados[j + 10]);

                        ArvoreSplay splay2 = new ArvoreSplay();
                        try {
                            splay2 = splay.clone();
                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(GetCenario1Action.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        resultados[j + 15] = new Resultado();
                        splay2.excluirGastos(analise2, resultados[j + 15]);

                        for (int k = (int) (analise.length * 0.7); k < quantidadeLeitura[i]; k++) {
                            analise[k] = analise[contadorAux];
                            contadorAux++;
                        }
                        quick.ordenaObjeto(analise, resultado);
                        resultados[j + 20] = new Resultado();
                        splay.excluirGastos(analise, resultados[j + 20]);
                        contador++;
                    }
                    for (int k = 0; k < 25; k = k + 5) {
                        Resultado resultad[] = new Resultado[5];
                        resultad[0] = new Resultado();
                        resultad[0] = resultados[k];
                        resultad[1] = new Resultado();
                        resultad[1] = resultados[k + 1];
                        resultad[2] = new Resultado();
                        resultad[2] = resultados[k + 1];
                        resultad[3] = new Resultado();
                        resultad[3] = resultados[k + 1];
                        resultad[4] = new Resultado();
                        resultad[4] = resultados[k + 1];
                        if (k == 0) {
                            ArquivoDAO.escrever(0, (contador - 5) + "Arvore Splay - Inserção", resultad);
                        } else if (k == 5) {
                            ArquivoDAO.escrever(0, (contador - 5) + "Arvore Splay - Busca 1", resultad);
                        } else if (k == 10) {
                            ArquivoDAO.escrever(0, (contador - 5) + "Arvore Splay - Busca 2", resultad);
                        } else if (k == 15) {
                            ArquivoDAO.escrever(0, (contador - 5) + "Arvore Splay - Remoção 1", resultad);
                        } else if (k == 20) {
                            ArquivoDAO.escrever(0, (contador - 5) + "Arvore Splay - Remoção 2", resultad);
                        }
                    }
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultadosOrdenacao.jsp"); // Chama o jsp para mostrar o resultado
                dispatcher.forward(request, response);
                break;
            }
            case 4: {
                Integer contador = 0;
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance(); // Recebe a quantidade de dados que deverá ser lida
                for (int i = 1; i < quantidadeLeitura.length; i++) { // Executa 6 vezes, pois são 6 números
                    Resultado resultados[] = new Resultado[25];
                    for (int j = 0; j < 5; j++) { // Executa as 5 sementes

                        GastoDAO.shuffle(); // Embaralha o ArrayList
                        Gasto[] analise = new Gasto[quantidadeLeitura[i]]; // Cria um vetor com o tamanho necessário definido no Entrada.txt ou informado pelo usuário
                        for (int k = 0; k < quantidadeLeitura[i]; k++) { // Lê a quantidade desejada do ArrayList
                            analise[k] = GastoDAO.getInstance().get(k); // O vetor recebe do ArrayList os elementos para serem ordenados
                        }
                        MinhaArvore ma = new MinhaArvore();
                        resultados[j] = new Resultado();
                        ma.insereGastos(analise, resultados[j]);

                        GastoDAO.shuffle();
                        Gasto[] analise2 = new Gasto[quantidadeLeitura[i]];
                        for (int k = 0; k < quantidadeLeitura[i]; k++) { // Lê a quantidade desejada do ArrayList
                            analise2[k] = GastoDAO.getInstance().get(k); // O vetor recebe do ArrayList os elementos para serem ordenados
                        }
                        resultados[j + 5] = new Resultado();
                        ma.buscaGastos(analise2, resultados[j + 5]);

                        Integer contadorAux = 0;
                        for (int k = (int) (analise.length * 0.7); k < quantidadeLeitura[i]; k++) {
                            analise2[k] = analise2[contadorAux];
                            contadorAux++;
                        }
                        QuickSort quick = new QuickSort();
                        Resultado resultado = new Resultado();
                        quick.ordenaObjeto(analise2, resultado);
                        resultados[j + 10] = new Resultado();
                        ma.buscaGastos(analise2, resultados[j + 10]);

                        MinhaArvore ma2 = new MinhaArvore();
                        try {
                            ma2 = ma.clone();
                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(GetCenario1Action.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        resultados[j + 15] = new Resultado();
                        ma2.excluirGastos(analise2, resultados[j + 15]);

                        for (int k = (int) (analise.length * 0.7); k < quantidadeLeitura[i]; k++) {
                            analise[k] = analise[contadorAux];
                            contadorAux++;
                        }
                        quick.ordenaObjeto(analise, resultado);
                        resultados[j + 20] = new Resultado();
                        ma.excluirGastos(analise, resultados[j + 20]);
                        contador++;
                    }
                    for (int k = 0; k < 25; k = k + 5) {
                        Resultado resultad[] = new Resultado[5];
                        resultad[0] = new Resultado();
                        resultad[0] = resultados[k];
                        resultad[1] = new Resultado();
                        resultad[1] = resultados[k + 1];
                        resultad[2] = new Resultado();
                        resultad[2] = resultados[k + 1];
                        resultad[3] = new Resultado();
                        resultad[3] = resultados[k + 1];
                        resultad[4] = new Resultado();
                        resultad[4] = resultados[k + 1];
                        if (k == 0) {
                            ArquivoDAO.escrever(0, (contador - 5) + "Minha Árvore - Inserção", resultad);
                        } else if (k == 5) {
                            ArquivoDAO.escrever(0, (contador - 5) + "Minha Árvore - Busca 1", resultad);
                        } else if (k == 10) {
                            ArquivoDAO.escrever(0, (contador - 5) + "Minha Árvore - Busca 2", resultad);
                        } else if (k == 15) {
                            ArquivoDAO.escrever(0, (contador - 5) + "Minha Árvore - Remoção 1", resultad);
                        } else if (k == 20) {
                            ArquivoDAO.escrever(0, (contador - 5) + "Minha Árvore - Remoção 2", resultad);
                        }
                    }
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultadosOrdenacao.jsp"); // Chama o jsp para mostrar o resultado
                dispatcher.forward(request, response);
                break;
            }
            case 3: { // Realiza o mesmo processo dos dois citados acima, contudo, a execução é uma seguida da outra, pois essa opção seria de ordenar os dois de uma só vez.
                Integer contador = 0;
                Integer[] quantidadeLeitura = ArquivoDAO.getInstance(); // Recebe a quantidade de dados que deverá ser lida
                for (int i = 1; i < quantidadeLeitura.length; i++) { // Executa 6 vezes, pois são 6 números
                    Resultado resultados[] = new Resultado[25];
                    for (int j = 0; j < 5; j++) { // Executa as 5 sementes

                        GastoDAO.shuffle(); // Embaralha o ArrayList
                        Gasto[] analise = new Gasto[quantidadeLeitura[i]]; // Cria um vetor com o tamanho necessário definido no Entrada.txt ou informado pelo usuário
                        for (int k = 0; k < quantidadeLeitura[i]; k++) { // Lê a quantidade desejada do ArrayList
                            analise[k] = GastoDAO.getInstance().get(k); // O vetor recebe do ArrayList os elementos para serem ordenados
                        }
                        ArvoreB b = new ArvoreB(4);
                        resultados[j] = new Resultado();
                        b.insereAux(analise, resultados[j]);

                        GastoDAO.shuffle();
                        Gasto[] analise2 = new Gasto[quantidadeLeitura[i]];
                        for (int k = 0; k < quantidadeLeitura[i]; k++) { // Lê a quantidade desejada do ArrayList
                            analise2[k] = GastoDAO.getInstance().get(k); // O vetor recebe do ArrayList os elementos para serem ordenados
                        }
                        resultados[j + 5] = new Resultado();
                        b.buscaAux(analise2, resultados[j+5]);
                        
                        Integer contadorAux = 0;
                        for (int k = (int) (analise.length * 0.7); k < quantidadeLeitura[i]; k++) {
                            analise2[k] = analise2[contadorAux];
                            contadorAux++;
                        }
                        
                        QuickSort quick = new QuickSort();
                        Resultado resultado = new Resultado();
                        quick.ordenaObjeto(analise2, resultado);
                        resultados[j + 10] = new Resultado();
                        b.buscaAux(analise2, resultados[j + 10]);

                        ArvoreB b2 = new ArvoreB();
                        try {
                            b2 = b.clone();
                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(GetCenario1Action.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        resultados[j + 15] = new Resultado();
                        //b2.excluirAux(analise2, resultados[j + 15]);

                        for (int k = (int) (analise.length * 0.7); k < quantidadeLeitura[i]; k++) {
                            analise[k] = analise[contadorAux];
                            contadorAux++;
                        }
                        quick.ordenaObjeto(analise, resultado);
                        resultados[j + 20] = new Resultado();
                        //b.excluirAux(analise, resultados[j + 20]);
                        contador++;
                    }
                    for (int k = 0; k < 25; k = k + 5) {
                        Resultado resultad[] = new Resultado[5];
                        resultad[0] = new Resultado();
                        resultad[0] = resultados[k];
                        resultad[1] = new Resultado();
                        resultad[1] = resultados[k + 1];
                        resultad[2] = new Resultado();
                        resultad[2] = resultados[k + 1];
                        resultad[3] = new Resultado();
                        resultad[3] = resultados[k + 1];
                        resultad[4] = new Resultado();
                        resultad[4] = resultados[k + 1];
                        if (k == 0) {
                            ArquivoDAO.escrever(0, (contador - 5) + "Árvore B - Inserção", resultad);
                        } else if (k == 5) {
                            ArquivoDAO.escrever(0, (contador - 5) + "Árvore B - Busca 1", resultad);
                        } else if (k == 10) {
                            ArquivoDAO.escrever(0, (contador - 5) + "Árvore B - Busca 2", resultad);
                        } else if (k == 15) {
                            ArquivoDAO.escrever(0, (contador - 5) + "Árvore B - Remoção 1", resultad);
                        } else if (k == 20) {
                            ArquivoDAO.escrever(0, (contador - 5) + "Árvore B - Remoção 2", resultad);
                        }
                    }
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/resultadosOrdenacao.jsp"); // Chama o jsp para mostrar o resultado
                dispatcher.forward(request, response);
                break;
            }
            default:
                response.sendRedirect("erro.html");
                break;
        }
    }

}
