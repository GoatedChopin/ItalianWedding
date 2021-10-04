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
        ArrayList<Person> afterPhis = new ArrayList<>();

        for (Person phi: phis) phi.updateHeight();
        for (Person sig: sigs) sig.updateHeight();
        Collections.sort(phis);
        Collections.sort(sigs);
        Collections.reverse(sigs);

        
        Map<String,String> predeterminedPairings = new HashMap<>();
        // Add pairings here, sig:phi
        predeterminedPairings.put("Dan Little","Gisselle Fajardo");
        predeterminedPairings.put("Bailey Gray","Brie Wall ");
        
        // Insert loop to pair predetermined matches here, removing the phis from the list just like we would in the normal loop.
        for (Person sig: sigs) {
            for (Person phi: phis) {
                if ((if predeterminedPairings.containsKey(sig.name) && (predeterminedPairings.get(sig.name) == phi.name)) {
                    sig.spouses.add(phi);
                    phi.spouses.add(sig);
                    phis.remove(phi);
                }
            }
        }
        while (phis.size() > 0) {
            for (Person sig: sigs) {
                if (sig.spouses.size() < 2) {
                    Random rand = new Random();
                    int randomIndex = rand.nextInt(phis.size());
                    Person phi = phis.get(randomIndex); // pick a random phi
                    if (containsShorterPeople(sig,phis) > 0) phi = sig.nextShorterPerson(phis); // if there are shorter phis than the sig, replace the random phi with one of them
//                    System.out.println("Adding " + phi.name + " to " + sig.name + "'s spouses " + "(M " + sig.inches + ": F " + phi.inches + ")");
                    sig.spouses.add(phi);
                    phi.spouses.add(sig);
                    afterPhis.add(phi);
                    phis.remove(phi);
                    }
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
        ArrayList<String> labels = new ArrayList<>();
        LabelMaker labelMaker = new LabelMaker();
        for (Person sig: sigs) {
            labels.add(labelMaker.makeLabel(sig));
            for (Person spouse: sig.spouses) {
                labels.add(labelMaker.makeLabel(spouse));
            }
        }
                    
        Collections.sort(labels);
        FileWriter fileWriter = new FileWriter();
        for (String label: labels) {
            fileWriter.writeToFile(label);
        }
    }


        public static int containsShorterPeople(Person sig, ArrayList<Person> list) {
            int shorterPeople = 0;
            for (Person person: list) {
                if (sig.isTaller(person)) shorterPeople++;
            }
            return shorterPeople;
        }
}
