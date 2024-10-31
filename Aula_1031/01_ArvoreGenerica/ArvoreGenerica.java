import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ArvoreGenerica {

    private class Nodo{
        public int valor;
        public Nodo pai;
        public List<Nodo> filhos;
        public Nodo(){
            this.filhos=new LinkedList<>();
        }
        public Nodo(Integer e){
            this();
            valor=e;            
        }
        public Nodo(Integer e, Nodo father){
            this(e);
            pai=father;            
        }
    }

    private Nodo raiz;
    private int nElementos;

    public ArvoreGenerica(){
        raiz=null;
        nElementos=0;
    }

    public boolean add(Integer e, Integer father){
        if(e==null)
            throw new IllegalArgumentException("O parâmetro e não pode ser nulo");
        
        if(father==null){
            //querem adicionar uma raiz
            if(raiz!=null){
                raiz.valor=e;
                return false;
            } 
            else{
                System.out.println("Add 1");
                raiz=new Nodo(e);
                nElementos++;
                return true;
            }
        }
        else{
            Nodo aux = findElement(father, raiz);
            if(aux!=null){
                // encontrei o father
                //   posso adicionar o filho e
                aux.filhos.add(new Nodo(e, aux));
                nElementos++;
                return true;
            }
            return false;
        }
        
    }

    // IMPLEMENTACAO POS ORDEM
    private Nodo findElement(int e, Nodo ref){
        if(ref==null)
            return null;
        
        Nodo aux;
        for(Nodo filho : ref.filhos){
            aux=findElement(e, filho);
            if(aux!=null) return aux;
        }
        if(ref.valor==e)
            return ref;
        else
            return null;

    }

    public Integer getRoot(){
        if(raiz!=null)
            return raiz.valor;
        else    
            return null;
    }

    public void setRoot(Integer e){
        if(e==null)
            throw new IllegalArgumentException("O parâmetro e não pode ser nulo");
        if(raiz!=null)
            raiz.valor=e;
    }
    public Integer getParent(Integer e){

        if(e==null)
            throw new IllegalArgumentException("O parâmetro e não pode ser nulo");
        Nodo aux=findElement(e, raiz);

        if(aux!=null){
            if(aux.pai != null)
                return aux.pai.valor;
            else
                return null;            
        }
        else
            throw new RuntimeException("Elemento não existe na árvore");

    }

    //public boolean removeBranch(Integer e);
    public boolean contains(Integer e){
        if(e == null)
            throw new IllegalArgumentException("O argumento não pode ser nulo");

        //return (findElement(e, raiz)!=null);
        if(findElement(e, raiz)!=null) 
            return true;
        else 
            return false;


    }
    public boolean isInternal(Integer e){
        if(e == null)
            throw new IllegalArgumentException("O argumento não pode ser nulo");

        Nodo aux = findElement(e, raiz);

        if(aux!=null)
            return (aux.filhos.size()>0);
        else
            throw new RuntimeException("Elemento não existe na árvore");
    }

    public boolean isExternal(Integer e){
        return !isInternal(e);
    }

    public boolean isRoot(Integer e){
        if((e==null) || (raiz==null))
            throw new RuntimeException("Comparação inválida");
        
        return e==raiz.valor;
        
    }

    public boolean isEmpty(){
        return nElementos==0;
    }

    public int size(){
        return nElementos;
    }
    public void clear(){
        raiz=null;
        nElementos=0;
    }

    private void positionsPre(Nodo ref, List<Integer> lista){
        // ao chegar no nodo "visito" ele
        lista.add(ref.valor);

        // em seguida visito os filhos
        for(Nodo filho : ref.filhos)
            positionsPre(filho, lista);
    }

    private void positionsPos(Nodo ref, List<Integer> lista){

        for(Nodo filho : ref.filhos)
            positionsPos(filho, lista);

        lista.add(ref.valor);
    }

    public List<Integer> positionsPre(){
        if(nElementos==0)
            return null;

        List<Integer> resultado = new ArrayList(nElementos);

        positionsPre(raiz, resultado);

        return resultado;
    }
    
    public List<Integer> positionsPos(){
        if(nElementos==0)
            return null;

        List<Integer> resultado = new ArrayList(nElementos);

        positionsPos(raiz, resultado);

        return resultado;
    }
    
    public List<Integer> positionsWidth(){
        if(nElementos==0)
            return null;

        List<Integer> resultado = new ArrayList<>(nElementos);

        // será explorado como uma estrutura do tipo fila
        // FIFO -> o primeiro a entrar é o primeiro a sair
        LinkedList<Nodo> fila = new LinkedList<>();

        fila.add(raiz);
        while (fila.size()!=0){
            Nodo aux = fila.remove(0);
            resultado.add(aux.valor);

            for(Nodo filho: aux.filhos)
                fila.add(filho);
        }

        return resultado;

    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        Nodo aux=raiz;
        LinkedList<Nodo> q = new LinkedList();
        q.add(aux);

        sb.append("//use o graphviz online para validar\n");
        sb.append("//  Acesse: https://dreampuf.github.io/GraphvizOnline/\n");
        sb.append("Graph G {\n");

        while (!q.isEmpty()){
            aux=q.remove(0);
            for(Nodo filho: aux.filhos){
                sb.append("  "+aux.valor+ " -- "+ filho.valor+";\n");
                q.add(filho);
            }            
        }
        sb.append("}\n");
        return sb.toString();

    }
    
}