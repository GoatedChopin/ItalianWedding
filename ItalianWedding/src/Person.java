import java.util.ArrayList;
import java.util.Map;

public class Person implements Comparable<Person>{

    public String name;
    public Map<String,String> QandA;
    public String[] questions;
    public ArrayList<Person> spouses = new ArrayList<Person>();

    public Person(String name, String[] answers) {
        this.name = name;
        for(int i = 0; i < questions.length; i++) {
            QandA.put(questions[i], answers[i]);
        }
        System.out.println(name + " was added");
    }

    @Override
    public int compareTo(Person person) {
            return this.name.compareToIgnoreCase(person.name);
    }
}
