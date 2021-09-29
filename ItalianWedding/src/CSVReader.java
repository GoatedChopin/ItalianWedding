import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class CSVReader {
    public String poop = "Solid Farts";
    // todo - make this read the csv's into their respective Person[] arrays.

/*  The following method uses beans to read the csv in. Our data should have headers, so we'll probably be able to get away with the simpler, map method.

    List<MyBean> beans = new CsvToBeanBuilder(FileReader("yourfile.csv"))
            .withType(Visitors.class).build().parse();

    Writer writer = new FileWriter("yourfile.csv");
    StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
    beanToCsv.write(beans);
    writer.close();*/

    public static ArrayList<Person> readCSVData(String filePath) throws IOException, CsvValidationException {
        Map<String, String> values = new CSVReaderHeaderAware(new FileReader(filePath)).readMap();
        ArrayList<Person> people = new ArrayList<Person>();
        for (String key: values.keySet()) {
            System.out.println(key);
            System.out.println(values.get(key));
            }
        return people;
    }
}

