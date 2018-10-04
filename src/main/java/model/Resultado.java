package model;

public class Resultado {
    private Long numComparacoes;
    private Long numTrocas;
    private Long tempoGasto;
    private Long memoriaGasto;

    public Resultado(Long numComparacoes, Long numTrocas, Long tempoGasto) {
        this.numComparacoes = numComparacoes;
        this.numTrocas = numTrocas;
        this.tempoGasto = tempoGasto;
    }

    public Resultado (Long numComparacoes, Long tempoGasto, Long memoriaGasto, Long numTrocas)
    {
        this.numComparacoes = numComparacoes;
        this.tempoGasto = tempoGasto;
        this.memoriaGasto = memoriaGasto;
    }
    
    public Resultado() {
        this.numComparacoes = 0L;
        this.numTrocas = 0L;
    }

    public Long getNumComparacoes() {
        return numComparacoes;
    }

    public void setNumComparacoes(Long numComparacoes) {
        this.numComparacoes = numComparacoes;
    }

    public Long getNumTrocas() {
        return numTrocas;
    }

    public void setNumTrocas(Long numTrocas) {
        this.numTrocas = numTrocas;
    }

    public Long getTempoGasto() {
        return tempoGasto;
    }

    public void setTempoGasto(Long tempoGasto) {
        this.tempoGasto = tempoGasto;
    }

    public Long getMemoriaGasto() {
        return memoriaGasto;
    }

    public void setMemoriaGasto(Long memoriaGasto) {
        this.memoriaGasto = memoriaGasto;
    }

}
