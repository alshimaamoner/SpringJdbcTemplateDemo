package dao;

import entity.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//@Repository
public class JdbcEmployeeDaoImpl implements EmployeeDao {
    public JdbcTemplate getDataSource() {
        return jdbcTemplate;
    }

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private JdbcTemplate jdbcTemplate;
    //use Constructor Injection
    //new Version of spring no need to inject if one constructor available
   // @Autowired




    @Override
//    @Transactional
    public List<Employee> findAll()  {
        String sql="SELECT * from employee ";
        List<Employee> employees=new ArrayList<>();
        SqlRowSet rs=   jdbcTemplate.queryForRowSet(sql);
        while (rs.next()){
            Employee employee=new Employee();
            employee.setId(rs.getInt(1));
            employee.setFirstName(rs.getString(2));
            employee.setLastName(rs.getString(3));
            employee.setEmail(rs.getString(4));
            employees.add(employee);
        }

        return employees;

    }
    @Override
  //  @Transactional
    public Employee findById(int id) {
        String sql="SELECT * from employee where id =?";
        SqlRowSet rs=   jdbcTemplate.queryForRowSet(sql,new Object[]{id});
        Employee employee=new Employee();
        while (rs.next()){
            employee.setId(rs.getInt(1));
            employee.setFirstName(rs.getString(2));
            employee.setLastName(rs.getString(3));
            employee.setEmail(rs.getString(4));

        }

        return employee;

    }

    @Override
    public void save(Employee employee) {
        String sql="insert into employee values(?,?,?,?) ";
          jdbcTemplate.update(sql,new Object[]{employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getEmail()});
    }

    @Override
    public void deleteById(int id) {
        String sql="delete  from employee where id =?";
         jdbcTemplate.update(sql,new Object[]{id});

    }


}
