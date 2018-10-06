package hash;

import model.Gasto;
import ordenacao.QuickSort;

public class TabelaHashItem2 {

    /**
     * *
     * A sua explicação de funcionamento estará no relatório. É composta por um
     * vetor de Lsta Encadeada de gastos dos deputados e outro vetor de Lista Encadeada de gastos dos partidos.
     * Possui também um tamanho. 
     * Utiliza como função hashing para os deputados a divisão por um fator primo já estabalecido
     * No caso de partidos, a função de hashing utilizar o tamanho do nome, divide por dois e pega a essa posição. Em seguida, é dividido pelo tamanho.
     */
    
    ListaEncadeadaDeputadoItem2 gastosDeputados[];
    ListaEncadeadaPartidoItem2 gastosPartidos[];
    Integer tamanho;

    public TabelaHashItem2() {
        gastosDeputados = new ListaEncadeadaDeputadoItem2[9221];
        gastosPartidos = new ListaEncadeadaPartidoItem2[9221];
        this.tamanho = 9221;
        for (int i = 0; i < gastosDeputados.length; i++) {
            gastosDeputados[i] = new ListaEncadeadaDeputadoItem2();
        }
        for (int i = 0; i < gastosPartidos.length; i++) {
            gastosPartidos[i] = new ListaEncadeadaPartidoItem2();
        }
    }

    public int funcaoHashDeputado(Integer idDeputado) {
        int indice = idDeputado % tamanho;
        return idDeputado % tamanho;
    }

    public Integer EncadeamentoSeparadoDeputados(Gasto gasto) {
        Integer indice = funcaoHashDeputado(gasto.getDeputy_id());
        return gastosDeputados[indice].inserirListaEncadeada(gasto);
    }

    public int funcaoHashPartido(String nomePartido) {
        Integer indice = nomePartido.charAt(nomePartido.length() / 2) % tamanho;
        while (indice > tamanho) {
            indice = indice - tamanho;
        }
        return indice;
    }

    public Integer EncadeamentoSeparadoPartidos(Gasto gasto) {
        Integer indice = funcaoHashPartido(gasto.getPolitical_party());
        return gastosPartidos[indice].inserirListaEncadeada(gasto);
    }

    public NoListaEncadeadaDeputadoItem2[] buscarOrdenarDeputados(Integer contadorDeputados) { // Função responsável por ordenar os gastos dos deputados com o QuickSort mais rápido
        Integer contadorAuxiliar = 0;
        NoListaEncadeadaDeputadoItem2[] gastos = new NoListaEncadeadaDeputadoItem2[contadorDeputados];
        for (int i = 0; i < tamanho; i++) {
            if (gastosDeputados[i].getPrimeiro() != null) {
                NoListaEncadeadaDeputadoItem2 noAux = gastosDeputados[i].getPrimeiro();
                while (noAux != null) {
                    gastos[contadorAuxiliar] = noAux;
                    contadorAuxiliar++;
                    noAux = noAux.getProximo();
                }
            }
        }
        QuickSort quick = new QuickSort();
        quick.ordenaInteiroQuickSortInsertionItem2(gastos, 100);
        return gastos;
    }

    public NoListaEncadeadaPartidoItem2[] buscarOrdenarPartidos(Integer contadorPartidos) { // Função responsável por ordenar os gastos dos partidos com o QuickSort mais rápido
        Integer contadorAuxiliar = 0;
        NoListaEncadeadaPartidoItem2[] gastos = new NoListaEncadeadaPartidoItem2[contadorPartidos];
        for (int i = 0; i < tamanho; i++) {
            if (gastosPartidos[i].getPrimeiro() != null) {
                NoListaEncadeadaPartidoItem2 noAux = gastosPartidos[i].getPrimeiro();
                while (noAux != null) {
                    gastos[contadorAuxiliar] = noAux;
                    contadorAuxiliar++;
                    noAux = noAux.getProximo();
                }
            }
        }
        QuickSort quick = new QuickSort();
        quick.ordenaInteiroQuickSortInsertionPartidoItem2(gastos, 100);
        return gastos;
    }
}
