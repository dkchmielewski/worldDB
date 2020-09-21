import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf8&serverTimezone=UTC&ssl=false";
        Connection connection = DriverManager.getConnection(url, "root", "#Prince1970#");

        String sql = "SELECT * FROM city WHERE CountryCode = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        System.out.println("Podaj kod kraju: ");
        Scanner scanner = new Scanner(System.in);
        String countryCode = scanner.nextLine();

        preparedStatement.setString(1, countryCode);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString(2);
            String district = resultSet.getString(4);
            int population = resultSet.getInt("Population");
            System.out.println(name + ", " + district + ", liczba ludnosci: " + population);
        }

        connection.close();

    }
}
