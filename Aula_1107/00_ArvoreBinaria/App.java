/**
 * App
 */
public class App {

    public static void main(String[] args) {
        ArvoreBinariaDePesquisa abp = new ArvoreBinariaDePesquisa();
        int [] valores = new int[]{8, 2, 10, 6, 5, 15, 7, 3, 20, 11};

        for(int i : valores)
          abp.add(i);

        System.out.println(abp);

    }
}