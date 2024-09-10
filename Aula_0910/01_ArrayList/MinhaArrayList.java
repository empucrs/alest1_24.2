public class MinhaArrayList {

    private int [] lista;
    private int count;

    public MinhaArrayList() {
        this.lista = new int [10];
        this.count=0;
    }

    //boolean	add(int e) 
    //  Armazena o valor no final da lista
    public boolean	add(int e){
        if(count>=lista.length)
            grow();
        lista[count]=e;
        count++;
        return true;
    }

    private void grow(int length){
        // criei o novo vetor
        int [] aux = new int[length*2];
        // transferir os dados do vetor antigo para o novo
        for(int i=0; i<lista.length; i++)
            aux[i]=lista[i];
        // assumo a nova lista
        lista=aux;
    }

    private void grow(){
        grow(lista.length*2);
    }

    //void	add(int index, int element)
    //  Armazena o valor na posicao indicada
    public void add(int index, int element){
        //1ª validar o indice
        if((index<0)||(index>=count))
            throw new RuntimeException("O índice informado é inválido!!!");

        //2ª garantir que tenho espaço no array
        if(count>=lista.length)
            grow();

        //3ª abrir espaço no array
        for(int i=count; i>index; i--)
            lista[i]=lista[i-1];

        //4ª adicionar o valor de fato na lista
        lista[index]=element;
        count++;
    }

    //void	add(int index, int [] element)
    //  Armazena o valor na posicao indicada
    public void add(int index, int [] element){
        //1ª validar o indice
        if((index<0)||(index>=count))
            throw new RuntimeException("O índice informado é inválido!!!");

        //2ª garantir que tenho espaço no array
        if((element.length+count)>=lista.length)
            grow((element.length+count)*2);

        //3ª abrir espaço no array
        for(int i=count+element.length-1; i>=index+element.length; i--)
            lista[i]=lista[i-element.length];

        //4ª adicionar o vetor no array 
        for(int i=0; i<element.length; i++)
            lista[index+i]=element[i];
        count+=element.length;
    }

    //void	clear()
    //  Remove todos elementos da lista
    public void clear(){
        this.count=0;
    }

    //boolean	contains(int valorBuscado)
    //  Retorna verdadeiro se o parametro existe na lista
    public boolean contains(int valorBuscado){        
        return (indexOf(valorBuscado)!=-1);
    }

    //int	get(int index)
    //  Retorna o elemento armazenado na posicao indicada
    public int get(int index){
        if((index<0) || (index>=count))
            throw new RuntimeException("Posição inválida");

        return lista[index];
    }

    //int	indexOf(int valorBuscado)
    //  Retorna o indice que contem o valor indicado ou -1 se não existir
    public int indexOf(int valorBuscado){
        for(int i=0; i<count; i++)
            if(lista[i]==valorBuscado) return i;
        return -1;
    }

    //boolean	isEmpty()
    //  Retorna verdadeiro se não houver elementos na lista
    public boolean isEmpty(){
        return this.count==0;
    }

    //int	remove(int index)
    //  Remove item de posição específica, retornando o valor que lá estava armazenado
    public int remove(int index){
        //1ª validar o indice
        if((index<0) || (index>=count))
            throw new RuntimeException("O indice informado não é válido!!!");

        //2ª salvar o valor a ser retornado
        int resultado=lista[index];

        //3ª ajustar o array
        for(int i=index; i<count; i++)
            lista[i]=lista[i+1];
        count--;

        //4ª retorna o resultado
        return resultado;
    }

    //boolean	remove(int o)
    //  Remove um item específico e informa se removeu, sim ou não
    /*
    public boolean remove(int valorBuscado){
        //1ª descobrir onde o valor existe (se existe)
        int idx = indexOf(valorBuscado);
        if(idx==-1) return false;

        //2ª reutilizar o remove com indice
        remove(idx);
        return true;
    }
    */

    //boolean	remove(int index, int nElementos)
    //  Remove n item a partir de uma dada posição
    public int[] remove(int index, int nElementos){
        // 1ª verificar se o indice é validos
        if((index<0) || (index>=count))
            throw new RuntimeException("O indice informado não é válido!!!");

        // 2ª verificar se o final do intervalo é válido
        if(index+nElementos>=count)
            throw new RuntimeException("O fim do intervalo a ser removido não é válido!!!");

        // 3ª Salvar os valores a serem retornados
        int [] resultado = new int [nElementos];
        for(int i=0; i<nElementos; i++)
            resultado[i]=lista[index+i];

        // 4ª Ajustar o array de fato
        for(int i=index; i<count-nElementos; i++)
            lista[i]=lista[i+nElementos];
        count-=nElementos;// count = count - nElemtos;

        // 5ª retornar os valores extraidos
        return resultado;
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
}