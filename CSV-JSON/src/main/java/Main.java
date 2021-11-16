import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opencsv.*;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class Main {
    public static void main(String[] args) {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        List<Employee> list = parseCSV(columnMapping, fileName);
        try{
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(listToJson(list));
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    static List<Employee> parseCSV(String[] columnMapping, String fileName){
        try(CSVReader csvReader = new CSVReader(new FileReader(fileName))){
            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            strategy.setType(Employee.class);
            strategy.setColumnMapping(columnMapping);

            CsvToBean<Employee> csvToBean = new CsvToBeanBuilder<Employee>(csvReader)
                    .withMappingStrategy(strategy)
                    .build();
            return csvToBean.parse();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    static String listToJson(List list){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Type listType = new TypeToken<List<String>>() {}.getType();
        String json = gson.toJson(list, listType);
        return json;
    }
}
