
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
            Main main = new Main();
            main.run();
    }

    public void run(){
        App app = new App();
        try {
            app.readFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }

        app.removeWord();
        while (true) {

            app.print();
            System.out.println("Want to do another one?\n  [Y]   [N]  ");
            while (true) {
                String goOn = sc.nextLine();
                if (goOn.toUpperCase(Locale.ROOT).equals("N")) {
                    System.exit(1);
                } else if (goOn.toUpperCase(Locale.ROOT).equals("Y")) {
                    app.removeWord();
                    break;
                }else{
                    System.out.println("Only \"Y\" and \"N\" is allowed");
                }
            }
        }
    }
}
