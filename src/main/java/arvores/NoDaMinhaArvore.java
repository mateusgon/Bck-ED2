package arvores;

public class NoDaMinhaArvore {

    private Integer altura;
    private Integer idGasto;
    private NoDaMinhaArvore filhoEsquerda;
    private NoDaMinhaArvore filhoDireita;

    public NoDaMinhaArvore(Integer idGasto) {
        this.idGasto = idGasto;
        this.altura = 1;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(Integer idGasto) {
        this.idGasto = idGasto;
    }

    public NoDaMinhaArvore getFilhoEsquerda() {
        return filhoEsquerda;
    }

    public void setFilhoEsquerda(NoDaMinhaArvore filhoEsquerda) {
        this.filhoEsquerda = filhoEsquerda;
    }

    public NoDaMinhaArvore getFilhoDireita() {
        return filhoDireita;
    }

    public void setFilhoDireita(NoDaMinhaArvore filhoDireita) {
        this.filhoDireita = filhoDireita;
    }

    
}
