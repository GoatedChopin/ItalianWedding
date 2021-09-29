import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class GuestMap {

    public Map<Person, ArrayList<Person>> guestMap;

    public GuestMap(Person[] groupOne, Person[] groupTwo) {
        Person[] shuffledTwo = shuffleArray(groupTwo);

        // groupTwo (alpha phis) is larger than groupOne, hence the weird workaround in mapWithHeight
        guestMap = mapWithHeight(groupOne, shuffledTwo);
    }

    public Person[] shuffleArray(Person[] array) {
        Person[] shuffledArray = new Person[array.length];
        Random random = new Random();
        int randInt = random.nextInt(array.length);
        for (int i = 0; i < array.length; i++) {
            while (Arrays.asList(shuffledArray).contains(array[randInt])) {
                randInt = random.nextInt(array.length);
            }
            shuffledArray[i] = array[randInt];
        }
        return shuffledArray;
    }

    public Map<Person, ArrayList<Person>> mapWithHeight(Person[] array1, Person[] array2) {
        Map<Person, ArrayList<Person>> map = null;
        for (int i = 0; i < array1.length; i++) map.put(array1[i], new ArrayList<Person>());
        int i = 0;
        for (Person person : array2) {
            // add height check here
            map.get(array1[i]).add(person);
            array1[i].spouses.add(person);
            if (i < map.size() - 1) i++;
            else i = 0;
        }
        return map;
    }
}