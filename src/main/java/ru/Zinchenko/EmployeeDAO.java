package ru.Zinchenko;

import java.util.List;

public interface EmployeeDAO {


    void addEmployee(Employee employee);

    Employee getById(int id);

    List<Employee> getAllEmployees();

    void updateEmployeeById(int id, String first_name, String last_name, String gender, int age, int city_id);

    void deleteById(int id);
}
