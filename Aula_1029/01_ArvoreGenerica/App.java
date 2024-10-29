public class App {

    public static void main(String[] args) {
        ArvoreGenerica ag = new ArvoreGenerica();

        if(ag.add(1, null))
            System.out.println("Consegui adicionar a raiz");
        else
            System.out.println("Deu caca para adicionar a raiz");

        if(ag.add(2, 1))
            System.out.println("Consegui adicionar o dois como filho do 1");
        else
            System.out.println("Deu caca para adicionar o dois como filho do 1");
        
        if(ag.add(3, 0))
            System.out.println("Consegui adicionar o tres como filho do 0");
        else
            System.out.println("Deu caca para adicionar o tres como filho do 0");

        if(ag.add(3, 1))
            System.out.println("Consegui adicionar o tres como filho do 1");
        else
            System.out.println("Deu caca para adicionar o tres como filho do 1");

        if(ag.add(4, 1))
            System.out.println("Consegui adicionar o tres como filho do 1");
        else
            System.out.println("Deu caca para adicionar o tres como filho do 1");

        if(ag.add(5, 3))
            System.out.println("Consegui adicionar o tres como filho do 1");
        else
            System.out.println("Deu caca para adicionar o tres como filho do 1");

        if(ag.add(6, 3))
            System.out.println("Consegui adicionar o tres como filho do 1");
        else
            System.out.println("Deu caca para adicionar o tres como filho do 1");

        if(ag.add(7, 5))
            System.out.println("Consegui adicionar o tres como filho do 1");
        else
            System.out.println("Deu caca para adicionar o tres como filho do 1");

        if(ag.add(8, 5))
            System.out.println("Consegui adicionar o tres como filho do 1");
        else
            System.out.println("Deu caca para adicionar o tres como filho do 1");


        System.out.println(ag);

    }
    
}
