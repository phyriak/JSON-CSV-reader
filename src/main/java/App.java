import service.Service;
import java.math.BigDecimal;
import java.util.Map;

public class App {
    public static void main(String[] args)  {
        Service service=new Service();
        Map<String, BigDecimal> jobsFromCSVWithSumOfSalary = service.getJobsFromCSVWithSumOfSalary("C:\\Java\\JSON&CSV-reader\\src\\main\\resources\\employees (2) (2).csv");
        Map<String, BigDecimal> jobsFromJSONWithSumOfSalary = service.getJobsFromJSONWithSumOfSalary("C:\\Java\\JSON&CSV-reader\\src\\main\\resources\\employees (2) (2).json");

        for (Map.Entry<String, BigDecimal> entry : jobsFromCSVWithSumOfSalary.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }

        for (Map.Entry<String, BigDecimal> entry : jobsFromJSONWithSumOfSalary.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
    }
}
