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
        count=0;
        head=tail=null;
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

    //void	add(int index, int element)
    //  Armazena o valor na posicao indicada
    public void add(int index, int element){
    }

    //void	add(int index, int [] element)
    //  Armazena o valor na posicao indicada
    public void add(int index, int [] element){
    }

    //void	clear()
    //  Remove todos elementos da lista
    public void clear(){
    }

    //boolean	contains(int valorAEncontrar)
    //  Retorna verdadeiro se o parametro existe na lista
    public boolean contains(int valorAEncontrar){
        return false;
    }

    private void validateIdx(int idx){
        if ((idx<0)||(idx>=count))
            throw new RuntimeException("O indice informado não é válido");
    }

    //int	get(int index)
    //  Retorna o elemento armazenado na posicao indicada
    public int get(int index){
        return 0;
    }

    //int	indexOf(int valorAEncontrar)
    //  Retorna o indice que contem o valor indicado ou -1 se não existir
    public int indexOf(int valorAEncontrar){
        return -1;
    }

    //boolean	isEmpty()
    //  Retorna verdadeiro se não houver elementos na lista
    public boolean isEmpty(){
        return false;
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
        return true;

    }

    //int	size()
    //  Retorna o número de itens na lista
    public int size(){
        return -1;
    }

    public String toString(){
        if(count==0)
            return "Lista vazia";

        StringBuilder sb = new StringBuilder();
        sb.append("A lista contem "+count+" elementos\n");
        sb.append("[");

        Nodo aux=head;
/*
        while(aux!=null){
            aux=aux.prox;
        }
*/
        for(aux=head; aux!=null; aux=aux.prox){
            if(aux.prox!=null) sb.append(aux.valor+", ");
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