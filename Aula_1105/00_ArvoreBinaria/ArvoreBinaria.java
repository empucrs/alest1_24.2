import java.util.LinkedList;

public class ArvoreBinaria{

    // Estrutura interna da arvore
    //  Não deve ser exposta ao usuario
    private class Nodo {        
        public int valor;
        public Nodo pai;
        public Nodo filhoEsquerda, filhoDireita;
        public Nodo(int valor, Nodo pai){
            this.valor=valor;
            this.pai=pai;
        }        
    }

    private Nodo raiz;
    private int nElementos;

    public ArvoreBinaria(){
        raiz=null;
        nElementos=0;
    }

    public boolean addRoot(Integer e){
        // se já existe uma raiz, então retorna falso
        if(raiz!=null) return false;

        // se não existe uma raiz
        // 1º avalio se o valor passado e diferente de nulo
        if(e==null) throw new IllegalArgumentException("O parametro passado é nulo.");

        // Tudo ok para inserir a raiz
        raiz = new Nodo(e, null);
        nElementos++;
        return true;        

    }
    public Integer getRoot(){
        if(raiz==null) return null;

        return raiz.valor;
    }
    public void setRoot(Integer e){
        // 1º avalia se a raiz existe
        if(raiz==null) throw new RuntimeException("A árvore está vazia");

        // 2º avalia se o parâmetro é valido
        if(e==null) throw new IllegalArgumentException("O parametro passado é nulo.");

        // 3º assume o valor de e na raiz
        raiz.valor=e;

    }
    public boolean isEmpty(){
        return nElementos==0;        
    }
    public void clear(){
        raiz=null;
        nElementos=0;
    }
    public int size(){
        return nElementos;
    }

    private Nodo findElementPre(int valor, Nodo ref){

        if(ref==null) return null;

        // caminhamento pre ordem
        //   Investiga o nodo ref antes dos seus descendentes
        if(ref.valor==valor) return ref;

        Nodo aux = findElementPre(valor, ref.filhoEsquerda);
        if(aux!=null) return aux;

        aux=findElementPre(valor, ref.filhoDireita);
        return aux;

    }

    private Nodo findElementPos(int valor, Nodo ref){

        if(ref==null) return null;

        // caminhamento pos ordem
        //   Investiga o filho da esquerda
        Nodo aux = findElementPos(valor, ref.filhoEsquerda);
        if(aux!=null)        return aux;

        //   Investiga o filho da direita
        aux=findElementPos(valor, ref.filhoDireita);
        if(aux!=null)        return aux;

        //   Investiga o nodo pai
        if(ref.valor==valor) return ref;
        else                 return null;

    }

    private Nodo findElementCentral(int valor, Nodo ref){

        if(ref==null) return null;

        // caminhamento central
        //   Investiga o filho da esquerda
        Nodo aux = findElementCentral(valor, ref.filhoEsquerda);
        if(aux!=null)        return aux;

        //   Investiga o nodo pai
        if(ref.valor==valor) return ref;        

        //   Investiga o filho da direita
        aux=findElementCentral(valor, ref.filhoDireita);
        return aux;
    }

    public boolean addLeft(Integer e, Integer father){
        // 1º garantir que os parametros são válidos
        if((e==null) || (father==null)) 
            throw new IllegalArgumentException("Um ou mais argumentos informados é nulo.");

        // 2º procurar o elemento/nodo pai
        Nodo aux = findElementPre(father, raiz);

        if(aux==null) return false;

        // 3º inserir ou atualizar o filho da esquerda
        if(aux.filhoEsquerda==null){
            aux.filhoEsquerda = new Nodo(e, aux);
            nElementos++;
        }
        else
            aux.filhoEsquerda.valor = e;
        return true;
    }
    public boolean addRight(Integer e, Integer father){
        // 1º garantir que os parametros são válidos
        if((e==null) || (father==null)) 
            throw new IllegalArgumentException("Um ou mais argumentos informados é nulo.");

        // 2º procurar o elemento/nodo pai
        Nodo aux = findElementPre(father, raiz);

        if(aux==null) return false;

        // 3º inserir ou atualizar o filho da direita
        if(aux.filhoDireita==null){
            aux.filhoDireita = new Nodo(e, aux);
            nElementos++;
        }
        else
            aux.filhoDireita.valor = e;
        return true;
    }

    //public boolean hasRight(Integer element){}
    //public boolean hasLeft(Integer element){}
    //public Integer getParent(Integer e){}
    //public boolean isInternal(Integer e){}
    //public boolean isExternal(Integer e){}

    private void removeBranch(Nodo ref){
        if(ref!=null){

            if(ref.filhoEsquerda!=null) removeBranch(ref.filhoEsquerda);
            if(ref.filhoDireita!=null)  removeBranch(ref.filhoDireita);

            if(ref.pai!=null) {
                if(ref.pai.filhoEsquerda==ref) ref.pai.filhoEsquerda=null;
                if(ref.pai.filhoDireita==ref)  ref.pai.filhoDireita =null;
            }
            ref.pai=null;            
            nElementos--;
        }
    }

    public boolean removeBranch(Integer e){
        // valido se o parâmetro é valido
        if(e==null) throw new IllegalArgumentException("O argumento é invalido");
        
        // encontro o elemento
        Nodo aux = findElementCentral(e, raiz);
        if(aux==null) return false;

        // remocao do ramo/branch
        removeBranch(aux);
        return true;
    }

    //public boolean contains(Integer e){}
    //public Integer getLeft(Integer e){}
    //public Integer getRight(Integer e){}

    //public List<Integer> positionsPre(){}
    //public List<Integer> positionsCentral(){}
    //public List<Integer> positionsPos(){}
    //public List<Integer> positionsWidth(){}

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
            if(aux.filhoEsquerda!=null){
                q.add(aux.filhoEsquerda);
                sb.append("  "+aux.valor+ " -- "+ aux.filhoEsquerda.valor +";\n");
            }
            if(aux.filhoDireita!=null){
                q.add(aux.filhoDireita);
                sb.append("  "+aux.valor+ " -- "+ aux.filhoDireita.valor +";\n");
            }
        }
        sb.append("}\n");
        return sb.toString();

    }

    public static void main(String[] args) {
        ArvoreBinaria ab = new ArvoreBinaria();

        ab.addRoot(1);
        ab.addLeft(2, 1);
        ab.addRight(3, 1);
        ab.addLeft(4, 3);
        ab.addRight(5, 3);
        System.out.println(ab);
        System.out.println("Nro de elementos = "+ab.size());

        ab.removeBranch(3);
        System.out.println(ab);
        System.out.println("Nro de elementos = "+ab.size());
    }
}