import java.util.LinkedList;
import java.util.List;

public class ArvoreBinariaDePesquisa {

    private class Nodo {
        public int Valor;
        public Nodo Pai;
        public Nodo filhoEsquerda;
        public Nodo filhoDireita;
        
        public Nodo(int valor, Nodo pai){
            this.Valor=valor;
            this.Pai=pai;
            filhoDireita=filhoEsquerda=null;
        }        
    }

    Nodo raiz;
    int nElementos;

    public ArvoreBinariaDePesquisa(){
        clear();
    }

    public void clear(){
        this.raiz=null;
        nElementos=0;
    }

    public int size(){
        return nElementos;
    }
    public int getRoot(){
        if(raiz==null)
            throw new RuntimeException("A árvore não possui raíz");

        return raiz.Valor;
    }
    public boolean isEmpty(){
        return nElementos==0;
    }

    public void add(Integer e){
        if(e==null)
            throw new IllegalArgumentException("O parametro não pode ser nulo");

        if(raiz==null){
            raiz = new Nodo(e, null);
            nElementos++;
        }
        else{
            insereNaArvore(e, raiz);
            nElementos++;
        }
    }

    private void insereNaArvore(int valor, Nodo ref){
        if(ref!=null){

            if(valor <= ref.Valor){
                if(ref.filhoEsquerda==null)
                    ref.filhoEsquerda=new Nodo(valor, ref);
                else
                    insereNaArvore(valor, ref.filhoEsquerda);
            }
            else{
                if(ref.filhoDireita==null)
                    ref.filhoDireita=new Nodo(valor, ref);
                else
                    insereNaArvore(valor, ref.filhoDireita);
            }            
        }

    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        Nodo aux=raiz;
        LinkedList<Nodo> q = new LinkedList();
        q.add(aux);

        sb.append("//use o graphviz online para validar\n");
        sb.append("//  Acesse: https://dreampuf.github.io/GraphvizOnline/\n");
        sb.append("Graph G {\n");

        int count=0;
        while (!q.isEmpty()){
            aux=q.remove(0);
            if(aux.filhoEsquerda!=null){
                q.add(aux.filhoEsquerda);
                sb.append("  "+aux.Valor+ " -- "+ aux.filhoEsquerda.Valor +";\n");
            }
            else{
                sb.append("  "+aux.Valor+ " -- null"+ count++ +";\n");
            }
            if(aux.filhoDireita!=null){
                q.add(aux.filhoDireita);
                sb.append("  "+aux.Valor+ " -- "+ aux.filhoDireita.Valor +";\n");
            }
            else
                sb.append("  "+aux.Valor+ " -- null"+ count++ +";\n");

        }
        sb.append("}\n");
        return sb.toString();
    }

    public boolean contains(Integer e){
        return false;
    }
    public int level(Integer e){
        return 0;
    }
    public boolean isInternal(Integer e){
        return false;
    }
    public boolean isExternal(Integer e){
        return false;
    }
    public Integer getLeft(Integer e){
        return null;
    }
    public Integer getRight(Integer e){
        return null;
    }
    public int getParent(Integer e){
        return 0;
    }

    public List<Integer> positionsPre(){
        return null;
    }
    public List<Integer> positionsCentral(){
        return null;
    }
    public List<Integer> positionsPos(){
        return null;
    }
    public List<Integer> positionsWidth(){
        return null;
    }

    public boolean remove(Integer e){
        return false;
    }
    public int height(){
        return 0;
    }



    
}