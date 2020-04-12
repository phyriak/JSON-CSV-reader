package service;


import model.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class CSVReader {


    public List<Employee> read(String filePath){
        List<Employee> result=new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            String headerRow = bufferedReader.readLine();
            String[] headers = headerRow.split(";");

            String record;
            while ((record = bufferedReader.readLine()) != null) {
                String[] tokens = record.replaceAll("\"","").split(";");
                Employee employee = createEmployee(headers, tokens);
                result.add(employee);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }return result;
    }

    private Employee createEmployee(String[] headers, String[] tokens) {
            Employee employee=new Employee();
        for (int i = 0; i < headers.length; i++) {

            if ("id".equals(headers[i])) {
                employee.setId(Integer.parseInt(tokens[i].trim()));
            }
            if ("name".equals(headers[i])) {
                employee.setName(tokens[i].trim());
            }
            if ("surname".equals(headers[i])) {
                employee.setSurname(tokens[i].trim());
            }
            if ("job".equals(headers[i])) {
                employee.setJob(tokens[i].trim());
            }

            if ("salary".equals(headers[i])) {
                employee.setSalary(BigDecimal.valueOf(Double.parseDouble(tokens[i].replace(',', '.').trim())));
            }
        }
        return employee;
    }
}
