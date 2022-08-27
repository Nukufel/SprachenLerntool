import javax.sound.midi.Soundbank;
import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Vector;

public class App {
    private Vector<String> germanText = new Vector<>();
    private Vector<String> englishText = new Vector<>();
    private Vector<String> removedWord = new Vector<>();
    private String cach = "";
    private Vector<Integer> result = new Vector<>();
    Scanner sc = new Scanner(System.in);


    public void readFiles() throws IOException {
        BufferedReader readerEL = new BufferedReader(new FileReader(new File("").getAbsolutePath() + "\\Files\\English.txt"));
        BufferedReader readerGL = new BufferedReader(new FileReader(new File("").getAbsolutePath() + "\\Files\\German.txt"));
        BufferedReader readerE = new BufferedReader(new FileReader(new File("").getAbsolutePath() + "\\Files\\English.txt"));
        BufferedReader readerG = new BufferedReader(new FileReader(new File("").getAbsolutePath() + "\\Files\\German.txt"));

        int linesE = (int) readerEL.lines().count();
        int linesG = (int) readerGL.lines().count();

        for (int i = 0; i < linesE; i++) {
            englishText.add(readerE.readLine());
        }
        for (int j = 0; j < linesG; j++) {
            germanText.add(readerG.readLine());
        }
    }

    public void removeWord() {
        removedWord.clear();
        result.clear();
        for (int i = 0; i < englishText.size(); i++) {
            cach = englishText.get(i);
            String[] singleWords = cach.split(" ");
            int randomInt = (int) (Math.random() * singleWords.length);
            result.add(randomInt);
            singleWords[randomInt] = singleWords[randomInt].replaceAll(".", "_");
            removedWord.add(String.join(" ", singleWords));
        }
    }

    public void print() {
        int index = (int) (Math.random() * englishText.size());

        System.out.print(""+germanText.get(index) + ".\n" + removedWord.get(index) + ".\nTyp in the missing word: ");
        for (int i = 2; i >= 0; i--) {
            String personResult = sc.nextLine();

            if (!personResult.equals(englishText.get(index).split(" ")[result.get(index)])) {
                if (i != 0) {
                    System.out.print("Wrong!!!\nYou have " + i + " trys left.\nTyp in the missing word: ");

                }
                if (i == 0){
                    System.out.println("Result: "+englishText.get(index));

                    System.out.println("\n");
                }

            }else{
                System.out.println("Result: "+englishText.get(index));
                System.out.println("Good job!!!\n------------------------------------------------------------------------------");
                break;
            }
        }
    }
}
