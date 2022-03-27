package PersonalExpenseManager;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDataRepository {

    private static final String CREATE_TABLE_SQL = "CREATE TABLE EXPENSEDATA( ID BIGINT AUTO_INCREMENT,EXPENSETYPE VARCHAR(255), EXPENSEDATE DATE,AMOUNT DOUBLE PRECISION)";
    private static final String CONNECTION_STRING_IM = "jdbc:h2:mem:";
    private static final String CONNECTION_STRING_FILE = "jdbc:h2:./expesedata_db";

    public static boolean createTable(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(CONNECTION_STRING_FILE);

            var stmt = con.createStatement();
            stmt.execute("DROP TABLE IF EXISTS EXPENSEDATA");
            return stmt.execute(CREATE_TABLE_SQL);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            }catch(Exception ignore){System.err.println(ignore);}
        }
        return false;
    }


    public ExpenseData create(ExpenseData expenseData) {
        Connection con = null; //connecting to Database
        try { // try catch exception handling
            con = DriverManager.getConnection(CONNECTION_STRING_FILE); //Fixing Connection to a database file

            var stmt = con.prepareStatement("INSERT INTO EXPENSEDATA(EXPENSETYPE,EXPENSEDATE, AMOUNT) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, expenseData.getExpenseType());
            stmt.setDate(2, Date.valueOf(expenseData.getDate()));
            stmt.setDouble(3, expenseData.getAmount());

            //
            stmt.execute();
            var rs = stmt.getGeneratedKeys();//get Id which is gernerated in the database
            if(rs.next()){
                int expenseId = rs.getInt(1);
                expenseData.setId(expenseId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            }catch(Exception ignore){}
        }
        return expenseData;
    }

// return a list of expense data objects

    public List<ExpenseData> getExpenseData() {
        Connection con = null;

        // For temporary object creation
        List<ExpenseData> allData = new ArrayList<>();

        try {
            con = DriverManager.getConnection(CONNECTION_STRING_FILE);


            var stmt = con.prepareStatement("SELECT * FROM EXPENSEDATA");


            var rs = stmt.executeQuery();

            while(rs.next()){
                String expenseType = rs.getString(2);
                LocalDate expenseDate = rs.getDate(3).toLocalDate();
                Double amount = rs.getDouble(4);

                allData.add(new ExpenseData(expenseType, expenseDate, amount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            }catch(Exception ignore){}
        }
        return allData;
    }


}
