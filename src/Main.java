import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final Random random = new Random();
     StringListImpl stringListm = new StringListImpl();
     IntegerListImpl integerList = new IntegerListImpl();

        System.out.println(stringListm.add(0, "Cat"));
        System.out.println(stringListm.add(1, "Frog"));
        System.out.println(stringListm.get(1));
        for (int i = 0; i < 99999; i++) {
            integerList.add(random.nextInt(100));
        }
        long start = System.currentTimeMillis();
        integerList.sortInsertion();
        System.out.println(System.currentTimeMillis() - start);

        integerList.sortInsertion();
        System.out.println(integerList.contains(1));
        integerList.getAll();

        //  System.out.println(integerList.get(1));
    }
}