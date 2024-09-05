public class MinhaFilaCircular {

    private int [] fila;
    private int back;
    private int front;
    private int nElements;

    public MinhaFilaCircular() {
        // capacidade máxima de 10 elementos
        this.fila = new int[10];
        this.back=0;
        this.front=0;
        this.nElements=0;
    }

    //enqueue(e): insere o elemento e no final da fila
    public boolean enqueue(int element){
        // se a qtde de elemento na fila for igual 
        //   a capacidade da fila, então não armazena
        if(this.nElements==fila.length)
            return false;
        this.fila[this.back]=element;        
        this.back++;
        if(this.back>=fila.length)
            this.back=0;
        this.nElements++;
        return true;
    }

    //dequeue(): remove e retorna o elemento e do início da fila, e dá erro se a fila estiver vazia
    public int dequeue(){
        if(this.nElements==0)
            throw new RuntimeException("A fila está vazia");

        int primeiroDafila=fila[this.front];
        this.front++;
        if(this.front>=fila.length)
            this.front=0;
        this.nElements--;
        return primeiroDafila;
    }

    //head(): retorna, mas não remove, o primeiro elemento da fila, e dá erro se a fila estiver vazia
    public int head(){
        if(this.nElements>0)
            return fila[this.front];
        
        throw new RuntimeException("A fila está vazia");
        
    }

    //size(): retorna o número de elementos da fila
    public int size(){
        return this.nElements;
    }

    //isEmpty(): retorna true se a fila estiver vazia, e false caso contrário
    public boolean isEmpty(){        
        return (this.nElements==0);
    }

    //clear(): esvazia a fila
    public void clear(){
        this.back=0;
        this.front=0;
        this.nElements=0;
    }

    
}