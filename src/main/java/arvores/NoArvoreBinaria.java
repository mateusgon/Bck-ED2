package arvores;

public abstract class NoArvoreBinaria {

    private Integer idGasto;
    private NoArvoreBinaria filhoEsquerda;
    private NoArvoreBinaria filhoDireita;

    public NoArvoreBinaria() {
        idGasto = -1;
        filhoEsquerda = null;
        filhoDireita = null;
    }

    public NoArvoreBinaria(Integer idGasto, NoArvoreBinaria filhoEsquerda, NoArvoreBinaria filhoDireita) {
        this.idGasto = idGasto;
        this.filhoEsquerda = filhoEsquerda;
        this.filhoDireita = filhoDireita;
    }

    public NoArvoreBinaria getFilhoDireita() {
        return filhoDireita;
    }

    public void setFilhoDireita(NoArvoreBinaria filhoDireita) {
        this.filhoDireita = filhoDireita;
    }

    public Integer getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(Integer idGasto) {
        this.idGasto = idGasto;
    }

    public NoArvoreBinaria getFilhoEsquerda() {
        return filhoEsquerda;
    }

    public void setFilhoEsquerda(NoArvoreBinaria filhoEsquerda) {
        this.filhoEsquerda = filhoEsquerda;
    }

    
    
}
