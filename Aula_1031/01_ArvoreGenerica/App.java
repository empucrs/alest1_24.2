public class App {

    public static void main(String[] args) {
        ArvoreGenerica ag = new ArvoreGenerica();

        ag.add(1, null);
        ag.add(2, 1);
        ag.add(3, 0);
        ag.add(3, 1);
        ag.add(4, 1);
        ag.add(5, 3);
        ag.add(6, 3);
        ag.add(7, 5);
        ag.add(8, 5);

        System.out.println(ag);

        System.out.println(ag.positionsPre()+"\n");
        System.out.println(ag.positionsPos()+"\n");
        System.out.println(ag.positionsWidth()+"\n");

    }
    
}
