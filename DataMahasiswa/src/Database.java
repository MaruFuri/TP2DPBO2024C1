import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    private Connection connection;
    private Statement statement ; // Untuk SELECT, UPDATE, DELETE

    public Database(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mahasiswa", "root", "");
            statement = connection.createStatement(); // Untuk SELECT, UPDATE, DELETE
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet selectQuery(String sql){
        try{
            statement.executeQuery(sql);
            return statement.getResultSet();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public int insertUpdateDeleteQuery(String sql){
        try{
            return statement.executeUpdate(sql);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Statement getStatement(){
        return statement;
    }
}
