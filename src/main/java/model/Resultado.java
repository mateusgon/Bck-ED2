package model;

public class Resultado {
    private Integer numComparacoes;
    private Integer numTrocas;
    private Long tempoGasto;
    private Long memoriaGasto;

    public Resultado(Integer numComparacoes, Integer numTrocas, Long tempoGasto) {
        this.numComparacoes = numComparacoes;
        this.numTrocas = numTrocas;
        this.tempoGasto = tempoGasto;
    }

    public Resultado (Integer numComparacoes, Long tempoGasto, Long memoriaGasto)
    {
        this.numComparacoes = numComparacoes;
        this.tempoGasto = tempoGasto;
        this.memoriaGasto = memoriaGasto;
    }
    
    public Resultado() {
        this.numComparacoes = 0;
        this.numTrocas = 0;
    }

    public Integer getNumComparacoes() {
        return numComparacoes;
    }

    public void setNumComparacoes(Integer numComparacoes) {
        this.numComparacoes = numComparacoes;
    }

    public Integer getNumTrocas() {
        return numTrocas;
    }

    public void setNumTrocas(Integer numTrocas) {
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
