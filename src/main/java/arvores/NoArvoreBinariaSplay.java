package arvores;

public class NoArvoreBinariaSplay {
    
    private Integer idGasto;
    private NoArvoreBinariaSplay filhoEsquerda;
    private NoArvoreBinariaSplay filhoDireita;

    public NoArvoreBinariaSplay(Integer idGasto) {
        this.idGasto = idGasto;
        this.filhoEsquerda = null;
        this.filhoDireita = null;
    }
    
    public Integer getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(Integer idGasto) {
        this.idGasto = idGasto;
    }

    public NoArvoreBinariaSplay getFilhoEsquerda() {
        return filhoEsquerda;
    }

    public void setFilhoEsquerda(NoArvoreBinariaSplay filhoEsquerda) {
        this.filhoEsquerda = filhoEsquerda;
    }

    public NoArvoreBinariaSplay getFilhoDireita() {
        return filhoDireita;
    }

    public void setFilhoDireita(NoArvoreBinariaSplay filhoDireita) {
        this.filhoDireita = filhoDireita;
    }
    
    
}
