import java.util.Random;
import java.util.random.RandomGenerator;

public class MinhaLinkedList {

    private class MeuNodo{
        int valor;
        MeuNodo proximo;
    }

    private int count;
    private MeuNodo head, tail;

    public MinhaLinkedList() {
        count=0;
        head=null;
        tail=null;
    }

    //boolean	add(int e) 
    //  Armazena o valor no final da lista
    public boolean	add(int e){
        //1º crio o nodo e salvo o valor
        MeuNodo aux;
        aux = new MeuNodo();
        aux.valor=e;
        aux.proximo=null;

        //2º descobrir o final da minha lista
        if((count==0)||(head==null))
        //3º adicionar o novo nodo no final da lista
            head=aux;
        else
            //ALTERNATIVA QDO SÓ EXISTE HEAD
            /*
            {
            MeuNodo walker=head;
            while(walker.proximo!=null)
                walker=walker.proximo;
            //3º adicionar o novo nodo no final da lista
            //walker.proximo=aux;
            }
            */
    
            //ALTERNATIVA QDO EXISTE HEAD E TAIL
            tail.proximo=aux;
        
        tail=aux;

        //4º informar que foi adicionado
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
        head=tail=null;        
        count=0;
    }

    //boolean	contains(int valorBuscado)
    //  Retorna verdadeiro se o parametro existe na lista
    public boolean contains(int valorBuscado){        
        return false;
    }

    //int	get(int index)
    //  Retorna o elemento armazenado na posicao indicada
    public int get(int index){
        return 0;
    }

    //int	indexOf(int valorBuscado)
    //  Retorna o indice que contem o valor indicado ou -1 se não existir
    public int indexOf(int valorBuscado){
        return -1;
    }

    //boolean	isEmpty()
    //  Retorna verdadeiro se não houver elementos na lista
    public boolean isEmpty(){
        //return (tail==null);
        //return (head==null);
        return (count==0);
    }

    //int	remove(int index)
    //  Remove item de posição específica, retornando o valor que lá estava armazenado
    public int remove(int index){
        return 0;
    }

    //boolean	remove(int index, int nElementos)
    //  Remove n item a partir de uma dada posição
    public int[] remove(int index, int nElementos){
        return null;
    }

    //int	set(int index, int element)
    //  Altera o conteudo de uma posicao específica
    public boolean set(int index, int element){
        return false;
    }

    //int	size()
    //  Retorna o número de itens na lista
    public int size(){
        return count;
    }

    public String toString(){
        if(count==0) return "A lista está vazia";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        MeuNodo mn;
        // ALTERNATIVA 1 -  USANDO FOR        
        /*
        for(mn=head; mn!=null; mn=mn.proximo){
            sb.append(mn.valor);
            if(mn.proximo!=null) sb.append(", ");
        }
        */

        // ALTERNATIVA 2 -  USANDO WHILE
        mn=head;
        while (mn!=null) {
            sb.append(mn.valor);
            if(mn.proximo!=null) sb.append(", ");
            mn=mn.proximo;
        }


        sb.append("]\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        MinhaLinkedList mll = new MinhaLinkedList();
        Random rg = new Random();
        int nElementos = rg.nextInt(10)+5;
        for(int i=0; i<nElementos; i++){
            int valor=rg.nextInt(5, 20);
            System.out.println("Inserindo o valor: "+valor);
            mll.add(valor);
        }
        System.out.println("Os seguintes valores foram armazenados na lista:");
        System.out.println(mll);
    }
}