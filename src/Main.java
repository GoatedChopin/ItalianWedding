import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException, CsvValidationException {

        CSVReader csvReader = new CSVReader();
        ArrayList<Person> sigs = csvReader.readCSVData("C:\\Users\\Colby\\Programming\\Java\\ItalianWedding\\src\\SigmaChis.csv");
        ArrayList<Person> phis = csvReader.readCSVData("C:\\Users\\Colby\\Programming\\Java\\ItalianWedding\\src\\AlphaPhis.csv");

        for (Person phi: phis) phi.updateHeight();
        for (Person sig: sigs) sig.updateHeight();
        Collections.sort(phis);
        Collections.sort(sigs);
        Collections.reverse(sigs);

        final String[] questions = {"Timestamp", "Email Address", "Full Name", "What is your major?", "What is your favorite food?", "What is your favorite type of movie?", "How many siblings do you have?", "What is your ideal date?", "How tall are you? (feet.inches)", "Are you a part of Sigma Chi or Alpha Phi?", "What is your class standing?"};

        while (phis.size() > 0) {
            for (Person sig: sigs) {

                    Random rand = new Random();
                    int randomIndex = rand.nextInt(phis.size());
                    Person phi = phis.get(randomIndex); // pick a random phi
                    if (containsShorterPeople(sig,phis) > 0) phi = sig.nextShorterPerson(phis); // if there are shorter phis than the sig, replace the random phi with one of them
                    System.out.println("Adding " + phi.name + " to " + sig.name + "'s spouses " + "(M " + sig.inches + ": F " + phi.inches + ")");
                    sig.spouses.add(phi);
                    phi.spouses.add(sig);
                    phis.remove(phi);
                }
            }
/*
        People are married to other people
        for (Person sig: sigs) {
            for (Person spouse: sig.spouses) {
                System.out.println(sig.name + " is married to " + spouse.name);
            }
        }
*/
    }


        public static int containsShorterPeople(Person sig, ArrayList<Person> list) {
        int shorterPeople = 0;
            for (Person person: list) {
                if (sig.isTaller(person)) shorterPeople++;
            }
            return shorterPeople;
        }
}
