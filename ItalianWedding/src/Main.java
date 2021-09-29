import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Person> sigs = readInData("C:\\Users\\Colby\\Programming\\Java\\ItalianWedding\\src\\SigmaChis.csv");
        ArrayList<Person> phis = readInData("C:\\Users\\Colby\\Programming\\Java\\ItalianWedding\\src\\AlphaPhis.csv");
        final String[] questions = {"Timestamp", "Email Address", "Full Name", "What is your major?", "What is your favorite food?", "What is your favorite type of movie?", "How many siblings do you have?", "What is your ideal date?", "How tall are you? (feet.inches)", "Are you a part of Sigma Chi or Alpha Phi?", "What is your class standing?"};

        while (phis.size() > 0) {
            for (Person sig: sigs) {
                    Random rand = new Random();
                    int randomIndex = rand.nextInt(phis.size());
                    sig.spouses.add(phis.get(randomIndex));
                    phis.remove(phis.get(randomIndex));
                }
            }
        }

    public static ArrayList<Person> readInData(String filePath) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filePath));
        //sc.setDeliminator(",");
        ArrayList<Person> people = new ArrayList<>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] row = line.split(",");
            ArrayList<String> answers = new ArrayList<String>();
            for (int i = 1; i < row.length; i++){
                answers.add(row[i]);
            }
            Person p = new Person(row[0], answers);
            people.add(p);
        }
        return people;
    }
}
