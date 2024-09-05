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
    private void grow(){
        // criei o novo vetor
        int [] aux = new int[lista.length*2];
        // transferir os dados do vetor antigo para o novo
        for(int i=0; i<lista.length; i++)
            aux[i]=lista[i];
        // assumo a nova lista
        lista=aux;
    }

    //void	add(int index, int element)
    //  Armazena o valor na posicao indicada
    //void	clear()
    //  Remove todos elementos da lista
    //boolean	contains(int o)
    //  Retorna verdadeiro se o parametro existe na lista
    //int	get(int index)
    //  Retorna o elemento armazenado na posicao indicada
    //int	indexOf(int o)
    //  Retorna o indice que contem o valor indicado ou -1 se não existir
    //boolean	isEmpty()
    //  Retorna verdadeiro se não houver elementos na lista
    //int	remove(int index)
    //  Remove item de posição específica, retornando o valor que lá estava armazenado
    //boolean	remove(int o)
    //  Remove um item específico e informa se removeu, sim ou não
    //int	set(int index, int element)
    //  Altera o conteudo de uma posicao específica
    //int	size()
    //  Retorna o número de itens na lista
    
}