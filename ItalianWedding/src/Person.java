import java.util.ArrayList;

public class Person implements Comparable<Person>{
//    Timestamp,EmailAddress,name,Major,Food,Movie,Siblings,Date,Height,sigphi,Class
    public String Timestamp;
    public String EmailAddress;
    public String name;
    public String Major;
    public String Food;
    public String Movie;
    public int Siblings;
    public String Date;
    public Double Height;
    public int inches;
    public String sigphi;
    public String Class;

    public ArrayList<String> answers = new ArrayList<>();
    public ArrayList<Person> spouses = new ArrayList<Person>();


/*
    @Override
    public int compareTo(Person person) {
            return this.name.compareToIgnoreCase(person.name);
    }
*/

    @Override
    public int compareTo(Person person) {
        if (this.inches > person.inches) return -1;
        else if (this.inches == person.inches) return 0;
        else return 1;
    }


    public void printList() {
        System.out.println(name + ":");
        int i = 1;
        for (Person spouse: spouses) {
            System.out.println(spouse.name + " is spouse #" + i);
            i++;
            for (String answer: spouse.answers) {
                System.out.println(answer);
            }
        }
    }

    public boolean isTaller(Person otherPerson) {
        if (this.inches > otherPerson.inches) return true;
        else return false;
    }

    public Person nextShorterPerson(ArrayList<Person> list) {
        for (Person person: list) if (this.isTaller(person)) return person;
        return null;
    }

    public void updateHeight() {
        String[] bits = String.valueOf(this.Height).split("\\.");
//        System.out.println(bits);
        if (bits.length > 0) this.inches = 12 * Integer.parseInt(bits[0]) + Integer.parseInt(bits[1]);
    }

}
