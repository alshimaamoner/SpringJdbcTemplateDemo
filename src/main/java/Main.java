
import dao.EmployeeDao;
import entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        EmployeeDao dao= (EmployeeDao) applicationContext.getBean("jdbcEmployeeDaoImpl");
       // dao.findAll().forEach((user)-> System.out.println(user));
       // System.out.println(dao.findById(1));
//        Employee employee=new Employee();
//        employee.setId(6);
//        employee.setFirstName("alshimaa");
//        employee.setLastName("elnady");
//        employee.setEmail("alshimaa@gmail.com");
//        dao.save(employee);
        dao.deleteById(9);

    }
}
