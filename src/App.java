import db.DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

  public static void main(String[] args) {
    System.out.println("=====================================================");

    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    try {
      conn = DB.getConnection();

      st = conn.createStatement();

      rs = st.executeQuery("select * from department");

      while (rs.next()) {
        System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DB.closeResultSet(rs);
      DB.closeStatement(st);
      DB.closeConnection();
      System.out.println("=================================================");
    }
  }
}
