import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public ArrayList<Person> readCSVData(String filePath) throws IOException {
        ArrayList<Person> people = new ArrayList<>();
        Reader reader = new BufferedReader(new FileReader(filePath));
        CsvToBean<Person> csvReader = new CsvToBeanBuilder(reader)
                .withType(Person.class)
                .withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .build();
        List<Person> results = csvReader.parse();
/*
        for (Person person: results) {
            System.out.println(person.name);
            System.out.println(person.Food);
        }
*/
        return (ArrayList<Person>) results;
    }
}

