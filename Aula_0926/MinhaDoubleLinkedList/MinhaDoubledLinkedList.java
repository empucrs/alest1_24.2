import java.util.Random;
import java.util.random.RandomGenerator;

public class MinhaDoubledLinkedList {

    private class Nodo{
        int valor;
        Nodo prox;
        Nodo prev;
        public Nodo(int valor) {
            this.valor=valor;
            prox=prev=null;
        }
    }

    int count;
    Nodo head, tail;

    public MinhaDoubledLinkedList() {
        clear();
    }

    //boolean	add(int e) 
    //  Armazena o valor no final da lista
    public boolean	add(int e){
        Nodo aux = new Nodo(e);
        if(count==0)
            tail=head=aux;
        else{
            tail.prox=aux;
            aux.prev=tail;
            tail=aux;           
        }
        count++;
        return true;
    }

    private Nodo buscaNodo(int index){
        validateIdx(index);

        //2º percorre a lista procurando o indice        
        Nodo nav = (index<(count/2))?head:tail;
        /*
         if(index<(count/2)) nav=head
         else nav=tail;
        */
        if(nav==head)
            for(int i=0; i<index; i++)
                nav=nav.prox;
        else
            for(int i=count-1; i!=index; i--)
                nav=nav.prev;

        return nav;

    }

    //void	add(int index, int element)
    //  Armazena o valor na posicao indicada
    public void add(int index, int element){
        Nodo nav = buscaNodo(index);
        //2º Cria o novo nodo
        Nodo aux = new Nodo(element);

        //3º vincula com os elementos adequados
        if(nav!=head){
            aux.prox=nav;
            aux.prev=nav.prev;

            nav.prev=aux;
            aux.prev.prox=nav;
        }
        else{
            aux.prox=head;
            head.prev=aux;
            head=aux;
        }
        count++;
    }

    //void	add(int index, int [] element)
    //  Armazena o valor na posicao indicada
    public void add(int index, int [] element){
    }

    //void	clear()
    //  Remove todos elementos da lista
    public void clear(){
        count=0;
        head=tail=null;
    }

    //boolean	contains(int valorAEncontrar)
    //  Retorna verdadeiro se o parametro existe na lista
    public boolean contains(int valorAEncontrar){
        return (indexOf(valorAEncontrar)!=-1);
    }

    private void validateIdx(int idx){
        if ((idx<0)||(idx>=count))
            throw new RuntimeException("O indice informado não é válido");
    }

    //int	get(int index)
    //  Retorna o elemento armazenado na posicao indicada
    public int get(int index){
        Nodo nav = buscaNodo(index);
        return nav.valor;
    }

    //int	indexOf(int valorAEncontrar)
    //  Retorna o indice que contem o valor indicado ou -1 se não existir
    public int indexOf(int valorAEncontrar){
        //1ª percorre até encontrar ou até o fim na lista
        Nodo nav=head;
        for(int i=0; nav!=null; i++){
            // se o valor for encontrado, retorna o indice
            if(nav.valor==valorAEncontrar) return i;
            nav=nav.prox;
        }
        //2º retorna o resultado se não havia valor procurado na lista
        return -1;
    }

    //boolean	isEmpty()
    //  Retorna verdadeiro se não houver elementos na lista
    public boolean isEmpty(){
        return (count==0);
    }

    //int	remove(int index)
    //  Remove item de posição específica, retornando o valor que lá estava armazenado
    public int remove(int index){
        return -1;
    }

    //boolean	remove(int index, int nElementos)
    //  Remove n item a partir de uma dada posição
    public int[] remove(int index, int nElementos){
        return null;
    }

    //int	set(int index, int element)
    //  Altera o conteudo de uma posicao específica
    public boolean set(int index, int element){
        Nodo nav = buscaNodo(index);
        nav.valor=element;
        return true;

    }

    //int	size()
    //  Retorna o número de itens na lista
    public int size(){
        return count;
    }

    public String toString(){
        if(count==0)
            return "Lista vazia";

        StringBuilder sb = new StringBuilder();
        sb.append("A lista contem "+count+" elementos\n");
        sb.append("[");

        for(Nodo aux=tail; aux!=null; aux=aux.prev){
            if(aux.prev!=null) sb.append(aux.valor+", ");
            else sb.append(aux.valor);
        }
        sb.append("]\n");
        
        return sb.toString();
    }

    public static void main(String[] args) {
        MinhaDoubledLinkedList mll = new MinhaDoubledLinkedList();
        Random rg = new Random();
        int nElementos = rg.nextInt(10)+5;
        for(int i=0; i<nElementos; i++){
            //int valor=rg.nextInt(5, 20);
            //System.out.println("Inserindo o valor: "+valor);
            //mll.add(valor);
            mll.add(i);
        }
        System.out.println("Os seguintes valores foram armazenados na lista:");
        System.out.println(mll);
    }
}