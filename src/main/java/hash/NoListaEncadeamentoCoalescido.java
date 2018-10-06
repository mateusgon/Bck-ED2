package hash;

public class NoListaEncadeamentoCoalescido { // Responsável por armazenar as informações do Encadeamento Coalescido do Cenário 4
    
    // É composto do id do deputado e aponta para a próxima posição após ter colisão de duas chaves, para que dessa maneira, possa ser localizado o valor que também deveria estar nessa posição
    
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
