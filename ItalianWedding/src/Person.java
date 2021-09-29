import java.util.ArrayList;

public class Person implements Comparable<Person>{

    public String name;
    public ArrayList<String> answers = new ArrayList<>();
    public ArrayList<Person> spouses = new ArrayList<Person>();

    public Person(String name, ArrayList<String> answers) {
        this.name = name;
        for (String answer: answers) {
            this.answers.add(answer);
        }
        System.out.println(name + " was added");
    }

    @Override
    public int compareTo(Person person) {
            return this.name.compareToIgnoreCase(person.name);
    }

    public void printList() {
        System.out.println(name);
        for (Person spouse: spouses) {
            System.out.println(spouse.name);
            for (String answer: spouse.answers) {
                System.out.println(answer);
            }
        }
    }
}
