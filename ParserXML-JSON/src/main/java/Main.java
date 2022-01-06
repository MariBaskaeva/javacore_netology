import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> list = parseXML("data.xml");
        writeString(listToJson(list));
    }

    public static List<Employee> parseXML(String fileName) {
        List<Employee> employees = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(fileName);

            Node node = document.getDocumentElement();
            read(node, employees);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return employees;
    }

    public static void read(Node node, List<Employee> employees) {
        NodeList nodeList = node.getChildNodes();
        Employee employee = new Employee();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node1 = nodeList.item(i);
            if (Node.ELEMENT_NODE == node1.getNodeType()) {
                if(node1.getNodeName().equals("id")){
                    employee.id = Long.parseLong(node1.getTextContent());
                }else if(node1.getNodeName().equals("firstName")){
                    employee.firstName = node1.getTextContent();
                }else if(node1.getNodeName().equals("lastName")){
                    employee.lastName = node1.getTextContent();
                }else if(node1.getNodeName().equals("country")){
                    employee.country = node1.getTextContent();
                }else if(node1.getNodeName().equals("age")){
                    employee.age = Integer.parseInt(node1.getTextContent());
                    employees.add(employee);
                }
                read(node1, employees);
            }
        }
    }

    public static String listToJson(List<Employee> list) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Type listType = new TypeToken<List<Employee>>() {
        }.getType();
        String json = gson.toJson(list, listType);
        return json;
    }

    public static void writeString(String json) {
        try (FileWriter fileWriter = new FileWriter("data.json")) {
            fileWriter.write(json);
            fileWriter.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
