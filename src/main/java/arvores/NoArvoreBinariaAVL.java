package arvores;

public class NoArvoreBinariaAVL extends NoArvoreBinaria{
    
    Integer fatorBalanceamento;

    public NoArvoreBinariaAVL(Integer fatorBalanceamento, Integer idGasto, NoArvoreBinaria filhoEsquerda, NoArvoreBinaria filhoDireita) {
        super(idGasto, null, null);
        this.fatorBalanceamento = fatorBalanceamento;
    }
    
}
