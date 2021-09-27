import java.util.*;

class GuestMap {
    public Map<Person, ArrayList<Person>> guestMap;

    public GuestMap(Person[] groupOne, Person[] groupTwo) {
        Person[] shuffledTwo = shuffleArray(groupTwo);
        int i = 0;
        for (Person person: groupOne) {
            guestMap.put(groupOne[i], new ArrayList<Person>());
        }
        i = 0;
        for (Person person: shuffledTwo) {
            guestMap.get(groupOne[i]).add(person);
            groupOne[i].spouses.add(person);
            if (i < guestMap.size() - 1) i++;
            else i = 0;
        }
    }

    public Person[] shuffleArray(Person[] array) {
        Person[] shuffledArray = new Person[array.length];
        Random random = new Random();
        int index = random.nextInt(array.length);
        for(Person p: array) {
            while (Arrays.asList(shuffledArray).contains(array[index])) {
                index = random.nextInt(array.length);
            }
            if (!Arrays.asList(shuffledArray).contains(array[index])) {
                shuffledArray[shuffledArray.length] = array[index];
            }
        }
        return shuffledArray;
    }
}
