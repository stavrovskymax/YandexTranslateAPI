import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter text: ");
            String str = in.nextLine();
            if (str.equals("exit")) {
                System.exit(0);
            }
            String translate = YandexTranslate.translate(str);
            System.out.println("Translate: " + translate + "\n");
        }
    }
}
