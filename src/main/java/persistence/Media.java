package persistence;

import java.util.ArrayList;
import java.util.List;
import model.Resultado;

public class Media {

    List<Resultado> resultados = new ArrayList<>();

    public List<Resultado> media(Resultado[] resultados) {
        Long mediaTempo;
        Integer mediaComparacoes;
        Integer mediaTrocas;
        for (int i = 0; i < 30; i = i + 5) {
            mediaTempo = 0L;
            mediaComparacoes = 0;
            mediaTrocas = 0;
            mediaTempo = mediaTempo + resultados[i].getTempoGasto();
            mediaTempo = mediaTempo + resultados[i + 1].getTempoGasto();
            mediaTempo = mediaTempo + resultados[i + 2].getTempoGasto();
            mediaTempo = mediaTempo + resultados[i + 3].getTempoGasto();
            mediaTempo = mediaTempo + resultados[i + 4].getTempoGasto();
            mediaComparacoes = mediaComparacoes + resultados[i].getNumComparacoes();
            mediaComparacoes = mediaComparacoes + resultados[i + 1].getNumComparacoes();
            mediaComparacoes = mediaComparacoes + resultados[i + 2].getNumComparacoes();
            mediaComparacoes = mediaComparacoes + resultados[i + 3].getNumComparacoes();
            mediaComparacoes = mediaComparacoes + resultados[i + 4].getNumComparacoes();
            mediaTrocas = mediaTrocas + resultados[i].getNumTrocas();
            mediaTrocas = mediaTrocas + resultados[i + 1].getNumTrocas();
            mediaTrocas = mediaTrocas + resultados[i + 2].getNumTrocas();
            mediaTrocas = mediaTrocas + resultados[i + 3].getNumTrocas();
            mediaTrocas = mediaTrocas + resultados[i + 4].getNumTrocas();
            mediaTempo = mediaTempo / 5;
            mediaComparacoes = mediaComparacoes / 5;
            mediaTrocas = mediaTrocas / 5;
            Resultado resultado = new Resultado(mediaComparacoes, mediaTrocas, mediaTempo);
            this.resultados.add(resultado);
        }
        return this.resultados;
    }

    public List<Resultado> media2(Resultado[] resultados) {
        Long mediaTempo;
        Integer mediaComparacoes;
        Long mediaMemoria;
        for (int i = 0; i < 30; i = i + 5) {
            mediaTempo = 0L;
            mediaComparacoes = 0;
            mediaMemoria = 0L;
            mediaTempo = mediaTempo + resultados[i].getTempoGasto();
            mediaTempo = mediaTempo + resultados[i + 1].getTempoGasto();
            mediaTempo = mediaTempo + resultados[i + 2].getTempoGasto();
            mediaTempo = mediaTempo + resultados[i + 3].getTempoGasto();
            mediaTempo = mediaTempo + resultados[i + 4].getTempoGasto();
            mediaComparacoes = mediaComparacoes + resultados[i].getNumComparacoes();
            mediaComparacoes = mediaComparacoes + resultados[i + 1].getNumComparacoes();
            mediaComparacoes = mediaComparacoes + resultados[i + 2].getNumComparacoes();
            mediaComparacoes = mediaComparacoes + resultados[i + 3].getNumComparacoes();
            mediaComparacoes = mediaComparacoes + resultados[i + 4].getNumComparacoes();
            mediaMemoria = mediaMemoria + resultados[i].getMemoriaGasto();
            mediaMemoria = mediaMemoria + resultados[i + 1].getMemoriaGasto();
            mediaMemoria = mediaMemoria + resultados[i + 2].getMemoriaGasto();
            mediaMemoria = mediaMemoria + resultados[i + 3].getMemoriaGasto();
            mediaMemoria = mediaMemoria + resultados[i + 4].getMemoriaGasto();
            mediaTempo = mediaTempo / 5;
            mediaComparacoes = mediaComparacoes / 5;
            mediaMemoria = mediaMemoria / 5;
            Resultado resultado = new Resultado(mediaComparacoes, mediaTempo, mediaMemoria);
            this.resultados.add(resultado);
        }
        return this.resultados;
    }
}
