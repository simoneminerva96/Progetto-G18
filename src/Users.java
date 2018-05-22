import java.util.Date;
import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class Users {
    private String userName;
    private String password;
    private String nameP;
    private String surname;
    private String sex;
    private int age;

    public Users (String userName, String password, String nameP, String surname, String sex, int age){
        this.userName = userName;
        this.password = password;
        this.nameP = nameP;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
    }

    public Boolean addUsers() throws ClassNotFoundException, SQLException {
        String query = "{ ?=call add-user(?,?,?,?,?,?)}";
        ResultSet res;
        Boolean r = null;
        try {
            String connectionString = "jdbc:mysql://localhost:3306/selection?user=root&password=qazxswedc4321@";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = getConnection(connectionString);
            CallableStatement stmt = con.prepareCall(query);
            stmt.registerOutParameter(1, Types.VARCHAR);
            stmt.setString(2, userName);
            stmt.setString(3, password);
            stmt.setString(4, nameP);
            stmt.setString(5, surname);
            stmt.setString(6, sex);
            stmt.setInt(7, age);

            res = stmt.executeQuery();

            while (res.next()) {
                r = res.getBoolean(1); //Il risultato viene inserito in una stringa
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return r;

    }

}
