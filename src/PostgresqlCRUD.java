import java.sql.*;

public class PostgresqlCRUD {

  static String URL = "jdbc:postgresql://localhost:5432/testdb";
  static String USR = "postgres";
  static String PWD = "postgres";
  String tableName = "COMPANY";

  Connection c = null;
  Statement stmt = null;

  public void createTable() {
    try {
      Class.forName("org.postgresql.Driver"); // For older versions
      c = DriverManager.getConnection(URL, USR, PWD);

      stmt = c.createStatement();
      String sql = "CREATE TABLE COMPANY " +
          "(ID INT PRIMARY KEY     NOT NULL," +
          " NAME           TEXT    NOT NULL, " +
          " AGE            INT     NOT NULL, " +
          " ADDRESS        CHAR(50), " +
          " SALARY         REAL)";
      stmt.executeUpdate(sql);

      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
      System.exit(0);
    }
  }

  public void insertInTableCompany(int idUser, String nameUser, int ageUser, String cityUser, float salaryUser) {
    try {
      Class.forName("org.postgresql.Driver"); // For older versions
      c = DriverManager.getConnection(URL, USR, PWD);
      c.setAutoCommit(false);

      stmt = c.createStatement();
      String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
          + "VALUES (" + String.format("%d,\'%s\',%d,\'%s\',%f", idUser, nameUser, ageUser, cityUser, salaryUser) +");";
      stmt.executeUpdate(sql);

      stmt.close();
      c.commit();
      c.close();

    } catch (Exception e) {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
      System.exit(0);
    }
    System.out.println("Records created successfully");
  }

  public void selectInTableCompany() {
    try {
      Class.forName("org.postgresql.Driver"); // For older versions
      c = DriverManager.getConnection(URL, USR, PWD);
      c.setAutoCommit(false);

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
      while ( rs.next() ) {
        int id = rs.getInt("id");
        String  name = rs.getString("name");
        int age  = rs.getInt("age");
        String  address = rs.getString("address");
        float salary = rs.getFloat("salary");
        System.out.println( "ID = " + id );
        System.out.println( "NAME = " + name );
        System.out.println( "AGE = " + age );
        System.out.println( "ADDRESS = " + address );
        System.out.println( "SALARY = " + salary );
        System.out.println();
      }

      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
      System.exit(0);
    }
  }

  public void updateInTable() {
    try {
      Class.forName("org.postgresql.Driver"); // For older versions
      c = DriverManager.getConnection(URL, USR, PWD);
      c.setAutoCommit(false);

      stmt = c.createStatement();
      String sql = "UPDATE COMPANY set SALARY = 25000.00 where ID=1;";
      stmt.executeUpdate(sql);
      c.commit();

      ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
      while ( rs.next() ) {
        int id = rs.getInt("id");
        String  name = rs.getString("name");
        int age  = rs.getInt("age");
        String  address = rs.getString("address");
        float salary = rs.getFloat("salary");
        System.out.println( "ID = " + id );
        System.out.println( "NAME = " + name );
        System.out.println( "AGE = " + age );
        System.out.println( "ADDRESS = " + address );
        System.out.println( "SALARY = " + salary );
        System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
      System.exit(0);
    }
  }

  public void deleteInTable(int idUser) {
    try {
      Class.forName("org.postgresql.Driver"); // For older versions
      c = DriverManager.getConnection(URL, USR, PWD);
      c.setAutoCommit(false);

      stmt = c.createStatement();
      String sql = "DELETE from COMPANY where ID = "+ idUser +";";
      stmt.executeUpdate(sql);
      c.commit();

      ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
      while ( rs.next() ) {
        int id = rs.getInt("id");
        String  name = rs.getString("name");
        int age  = rs.getInt("age");
        String  address = rs.getString("address");
        float salary = rs.getFloat("salary");
        System.out.println( "ID = " + id );
        System.out.println( "NAME = " + name );
        System.out.println( "AGE = " + age );
        System.out.println( "ADDRESS = " + address );
        System.out.println( "SALARY = " + salary );
        System.out.println();
      }

      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
      System.exit(0);
    }
  }
}