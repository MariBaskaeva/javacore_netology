import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        parseCSV(columnMapping, fileName);
    }

    public static void parseCSV(String[] columnMapping, String fileName){
        try (CSVReader csvReader = new CSVReader(new FileReader(fileName))){
            ColumnPositionMappingStrategy<Employee> mappingStrategy =
                    new ColumnPositionMappingStrategy<>();
            mappingStrategy.setType(Employee.class);
            mappingStrategy.setColumnMapping(columnMapping);

            CsvToBean<Employee> csvToBean = new CsvToBeanBuilder<Employee>(csvReader)
                    .withMappingStrategy(mappingStrategy)
                    .build();

            List<Employee> employees = csvToBean.parse();
            String json = listToJson(employees);
            writeString(json);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String listToJson(List<Employee> list){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Type listType = new TypeToken<List<Employee>>() {}.getType();
        String json = gson.toJson(list, listType);
        return json;
    }

    public static void writeString(String json){
        try(FileWriter fileWriter = new FileWriter("data.json")){
            fileWriter.write(json);
            fileWriter.flush();
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}