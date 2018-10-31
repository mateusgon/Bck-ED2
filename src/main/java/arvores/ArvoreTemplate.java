package arvores;

public abstract class ArvoreTemplate {
    
    protected NoArvoreBinaria raiz;

    public Boolean pesquisa (Integer idGasto, NoArvoreBinaria no)
    {
        if (no == null)
        {
            return false;
        }
        else
        {
            if (no.getIdGasto() > idGasto)
            {
                pesquisa(idGasto, no.getFilhoEsquerda());
            }
            else if (no.getIdGasto() < idGasto)
            {
                pesquisa(idGasto, no.getFilhoDireita());
            }
            else
            {
                return true;
            }
        }
        return false;
    }
    
    public void insere (Integer idGasto)
    {
        
    }
    
    public void retira (Integer idGasto)
    {
        
    }

    public NoArvoreBinaria getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvoreBinaria raiz) {
        this.raiz = raiz;
    }
    
    
}
