package arvores;

import model.Gasto;

public class PaginaArvoreB {
    private Integer n;
    private Gasto r[];
    private PaginaArvoreB p[];

    public PaginaArvoreB(Integer mm) {
        this.n = 0;
        this.r = new Gasto[mm];
        this.p = new PaginaArvoreB[mm + 1];
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public Gasto[] getR() {
        return r;
    }

    public void setR(Gasto[] r) {
        this.r = r;
    }

    public PaginaArvoreB[] getP() {
        return p;
    }

    public void setP(PaginaArvoreB[] p) {
        this.p = p;
    }
    
    
   
}
