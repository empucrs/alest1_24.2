import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.management.RuntimeErrorException;

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

    private Nodo findElement(int valor, Nodo ref){
        // CRITERIO DE FIM DE EXECUCAO
        if(ref==null)
            return null;
        if(ref.Valor==valor)
            return ref;

        // CAMINHAMENTO/PROGRESSAO NA ARVORE
        if(valor<ref.Valor)
            return findElement(valor, ref.filhoEsquerda);
        else
            return findElement(valor, ref.filhoDireita);
    }

    private void valida(Integer e){
        if(e==null)
          throw new IllegalArgumentException("Elemento informado é inválido. Não pode ser nulo");
    }

    public boolean contains(Integer e){
        valida(e);
        Nodo aux = findElement(e, raiz);
        return aux!=null;
    }
    public int level(Integer e){
        // VALIDO O ARGUMENTO
        valida(e);

        // VEJO SE O ELEMENTO ESTA NA ARVORE
        Nodo aux=findElement(e, raiz);
        if(aux==null)
            throw new RuntimeException("O valor "+ e +" não foi encontrado na arvore");

        // CALCULO O NIVEL
        int nivel=0;
        while(aux.Pai!=null){
            aux=aux.Pai;
            nivel++;
        }
        return nivel;
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

    private int heightLevel(){
        ArrayList<Nodo> fila = new ArrayList<>();
        ArrayList<Nodo> lista = new ArrayList<>();

        fila.add(raiz);
        while(! fila.isEmpty()){
            Nodo aux = fila.removeFirst();
            lista.add(aux);

            if(aux.filhoEsquerda!=null)
                fila.add(aux.filhoEsquerda);
            if(aux.filhoDireita!=null)
                fila.add(aux.filhoDireita);
        }

        return level(lista.getLast().Valor);
    }

    private int heightDepth(int level, Nodo ref){

        int nivel = level;

        // se for um nodo ref for uma folha?
        if((ref.filhoEsquerda== null) && (ref.filhoDireita==null)){
            nivel=level(ref.Valor);
            if(nivel<level)
                nivel=level;
            return nivel;
        }

        // se o nodo ref não for uma folha?
        if(ref.filhoEsquerda!=null){
            int nEsquerda= heightDepth(nivel, ref.filhoEsquerda);
            if(nivel<nEsquerda)
                nivel=nEsquerda;
        }

        if(ref.filhoDireita!=null){
            int nDireita= heightDepth(nivel, ref.filhoDireita);
            if(nivel<nDireita)
                nivel=nDireita;
        }
        return nivel;

    }
    public int height(){
        if(nElementos==0)
            throw new RuntimeException("Altura não pode ser calculada pois a árvore não possui elementos");

        return heightDepth(-1, raiz);
        //return heightLevel();
    }

    private void removeBranch(Nodo ref){

        //RESOLVE O FILHO DA ESQUERDA
        if(ref.filhoEsquerda!=null)
            removeBranch(ref.filhoEsquerda);

        //RESOLVER O FILHO DA DIREITA
        if(ref.filhoDireita!=null)
            removeBranch(ref.filhoDireita);

        // RESOLVE O PROPRIO NODO NO FINAL
        if(ref.Pai!=null){
            if(ref.Pai.filhoEsquerda==ref) ref.Pai.filhoEsquerda=null;
            else ref.Pai.filhoDireita=null;
        }
        ref.Pai=null;
        nElementos--;
    }

    public boolean remove(Integer e){
        //valida argumento
        valida(e);

        //valida se a arvore tem elementos
        if(nElementos==0)
            return false;

        //valida se o elemento está contido da arvore
        Nodo aux = findElement(e, raiz);
        if(aux==null)
            return false;

        //remover
        removeBranch(aux);

        return true;
    }
    
}