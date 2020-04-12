import model.Employee;
import org.junit.Test;
import service.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class AppTest {

    @Test
    public void shouldReturn5000WhenAddSalary2000and3000(){
        //given
        Service service=new Service();
        Employee a= new Employee(1,"John","Smith","Teacher",new BigDecimal("2000"));
        Employee b= new Employee(2,"Paul","Johnson","Teacher",new BigDecimal("3000"));
        BigDecimal expected=new BigDecimal(5000);
        final List<Employee> list= new ArrayList<>();
        list.add(a);
        list.add(b);

        //when
        Map<String, BigDecimal> sut = service.getSumOfSalaryForEachJob(list);

        //then
        assertEquals(expected,sut.get("Teacher"));
    }
}


