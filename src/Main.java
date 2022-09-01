public class Main {
    public static void main(String[] args) {
     StringListmImpl stringListm = new StringListmImpl();
        System.out.println(stringListm.add(0, "Cat"));
        System.out.println(stringListm.add(1, "Frog"));
        System.out.println(stringListm.get(1));
    }
}