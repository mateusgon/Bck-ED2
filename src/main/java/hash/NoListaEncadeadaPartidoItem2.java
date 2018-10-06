package hash;

public class NoListaEncadeadaPartidoItem2 {
    private String nome;
    private Integer valor;
    private NoListaEncadeadaPartidoItem2 proximo;

    public NoListaEncadeadaPartidoItem2() {
        String nome = null;
        Integer valor = 0;
        proximo = null;
    }

    public NoListaEncadeadaPartidoItem2(String nome, Integer valor, NoListaEncadeadaPartidoItem2 proximo) {
        this.nome = nome;
        this.valor = valor;
        this.proximo = proximo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public NoListaEncadeadaPartidoItem2 getProximo() {
        return proximo;
    }

    public void setProximo(NoListaEncadeadaPartidoItem2 proximo) {
        this.proximo = proximo;
    }
    
    
}
