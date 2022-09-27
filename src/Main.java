import java.sql.*;

public class Main {
  public static void main(String[] args) {
    PostgresqlCRUD psqlCrud = new PostgresqlCRUD();
//    psqlCrud.insertInTableCompany(3, "Brenno", 20, "Hidrolandia", 400.00f);
//    psqlCrud.deleteInTable(1);
    psqlCrud.selectInTableCompany();

  }
}
