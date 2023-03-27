package ru.Zinchenko;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "2346";
        final String url = "jdbc:postgresql://localhost:5430/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, password);

             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")) {

            statement.setInt(1, 2);

            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String firsName = "First_name: " + resultSet.getString("first_name");
                String lastName = "Last_name: " + resultSet.getString("last_name");
                String gender = "Gender: " + resultSet.getString("gender");
                String city = "ru.Zinchenko.City: " + resultSet.getString("city_id");
                int age = resultSet.getInt(5);

                System.out.println(firsName);
                System.out.println(lastName);
                System.out.println(gender);
                System.out.println(city);
                System.out.println("Age: " + age);
            }
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);
            City city = new City(1, "Moscow");
            Employee employee = new Employee("Ivan", "Ivanov", "male", 47, 1);

            employeeDAO.addEmployee(employee);

            List<Employee> list = new ArrayList<>(employeeDAO.getAllEmployees());

            for (Employee employee1 : list) {
                System.out.println(employee1);
            }

            employeeDAO.updateEmployeeById(3, "Степан", "Логинов", "male", 49, 2);

            System.out.println(employeeDAO.getById(3));
            employeeDAO.deleteById(4);

        }

        }


}
