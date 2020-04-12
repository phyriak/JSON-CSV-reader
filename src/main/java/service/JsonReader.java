package service;

import model.Employee;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {
    List<Employee> resultList=new ArrayList<>();

    public List<Employee> read(String filePath){
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            String content= new String(bytes, "UTF-8");
            JSONObject object=new JSONObject(content);
            JSONArray jsonArray = (JSONArray) object.get("employees");

            for (int i = 0; i <jsonArray.length() ; i++) {
                Employee employee=new Employee();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                employee.setId(jsonObject.getInt("id"));
                employee.setName(jsonObject.getString("name"));
                employee.setSurname(jsonObject.getString("surname"));
                employee.setJob(jsonObject.getString("job"));
                employee.setSalary(BigDecimal.valueOf(Double.parseDouble(jsonObject.getString("salary").replace(',','.'))));
                resultList.add(employee);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
