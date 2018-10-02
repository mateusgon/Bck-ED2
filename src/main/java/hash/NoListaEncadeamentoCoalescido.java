package hash;

public class NoListaEncadeamentoCoalescido {
    private Integer deputy_id;
    private Integer proximaPosicaoVetor;

    public NoListaEncadeamentoCoalescido() {
        deputy_id = -1;
        proximaPosicaoVetor = -1;
    }

    public NoListaEncadeamentoCoalescido(Integer deputy_id, Integer proximaPosicaoVetor) {
        this.deputy_id = deputy_id;
        this.proximaPosicaoVetor = proximaPosicaoVetor;
    }

    public Integer getProximaPosicaoVetor() {
        return proximaPosicaoVetor;
    }

    public void setProximaPosicaoVetor(Integer proximaPosicaoVetor) {
        this.proximaPosicaoVetor = proximaPosicaoVetor;
    }

    public Integer getDeputy_id() {
        return deputy_id;
    }

    public void setDeputy_id(Integer deputy_id) {
        this.deputy_id = deputy_id;
    }
    
    
}
