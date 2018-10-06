package hash;

public class NoListaEncadeadaCenario4 { // Responsável por armazenar as informações da ListaEncadeada do Cenário 4

    // Composta pelo ID do Deputado e um ponteiro para o próximo nó.
    
    private Integer deputy_id;
    private NoListaEncadeadaCenario4 proximo;

    public NoListaEncadeadaCenario4() {
        this.deputy_id = -1;
        this.proximo = null;
    }

    public NoListaEncadeadaCenario4(Integer deputy_id, NoListaEncadeadaCenario4 proximo) {
        this.deputy_id = deputy_id;
        this.proximo = proximo;
    }

    public NoListaEncadeadaCenario4 getProximo() {
        return proximo;
    }

    public void setProximo(NoListaEncadeadaCenario4 proximo) {
        this.proximo = proximo;
    }

    public Integer getDeputy_id() {
        return deputy_id;
    }

    public void setDeputy_id(Integer deputy_id) {
        this.deputy_id = deputy_id;
    }

}
