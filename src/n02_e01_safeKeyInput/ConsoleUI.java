package n02_e01_safeKeyInput;

public class ConsoleUI {

    public static void showUI() {
        int age = ConsoleReader.readInt("Introdueix la teva edat: ");
        System.out.println("Edat: " + age);

        String name = ConsoleReader.readString("Introdueix el teu nom: ");
        char initial = ConsoleReader.readChar("Introdueix la teva inicial: ");
        double height = ConsoleReader.readDouble("Introdueix la teva alçada: ");
        boolean student = ConsoleReader.readYesNo("Ets estudiant? (s/n): ");

        System.out.println("Nom: " + name);
        System.out.println("Inicial: " + initial);
        System.out.println("Alçada: " + height);
        System.out.println("Estudiant: " + student);
    }
}
