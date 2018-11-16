package arvores;

public class NoArvoreBinariaAVL {

    private Integer altura;
    private Integer idGasto;
    private NoArvoreBinariaAVL filhoEsquerda;
    private NoArvoreBinariaAVL filhoDireita;

    public NoArvoreBinariaAVL(Integer idGasto) {
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

    public NoArvoreBinariaAVL getFilhoEsquerda() {
        return filhoEsquerda;
    }

    public void setFilhoEsquerda(NoArvoreBinariaAVL filhoEsquerda) {
        this.filhoEsquerda = filhoEsquerda;
    }

    public NoArvoreBinariaAVL getFilhoDireita() {
        return filhoDireita;
    }

    public void setFilhoDireita(NoArvoreBinariaAVL filhoDireita) {
        this.filhoDireita = filhoDireita;
    }

    
}