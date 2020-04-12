package service;

import model.Employee;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Service {

    public Map<String, BigDecimal> getJobsFromCSVWithSumOfSalary(String path){
        CSVReader csvReader = new CSVReader();
        List<Employee> listOfEmployeeFromCSV = csvReader.read(path);
        return getSumOfSalaryForEachJob(listOfEmployeeFromCSV);
    }

    public Map<String, BigDecimal> getJobsFromJSONWithSumOfSalary(String path){
        JsonReader jsonReader = new JsonReader();
        List<Employee> listOfEmployeeFromJSON = jsonReader.read(path);
        return getSumOfSalaryForEachJob(listOfEmployeeFromJSON);
    }

    public Map<String, BigDecimal> getSumOfSalaryForEachJob(List<Employee> newList) {
        return newList.stream()
                .collect(Collectors.groupingBy(Employee::getJob,
                        Collectors.mapping(Employee::getSalary, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
    }
}
