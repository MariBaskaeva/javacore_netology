import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String json = readString("/home/mari/Netology1/javacore_netology/JSONParser/src/main/resources/new_data.json");
        System.out.println(json);
        List<Employee> list = jsonToList(json);
        while(!list.isEmpty()){
            System.out.println(list.remove(0));
        }
    }

    public static String readString(String fileName) throws Exception {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String result = "", line;
        while((line = bufferedReader.readLine()) != null){
            result += line;
        }
        fileReader.close();
        bufferedReader.close();
        return result;
    }

    public static List<Employee> jsonToList(String json) throws Exception{
        JSONParser jsonParser = new JSONParser();
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        JSONArray jsonArray = (JSONArray) jsonParser.parse(json);
        List<Employee> list = new ArrayList<>();
        for(int i = 0; i < jsonArray.size(); i++){
            Employee employee = gson.fromJson(jsonArray.get(0).toString(), Employee.class);
            list.add(employee);
        }
        return list;
    }
}
