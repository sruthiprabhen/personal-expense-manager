package PersonalExpenseManager;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExpenseDataRepositoryTest {

    ExpenseDataRepository expenseDataRepository = new ExpenseDataRepository();
    @BeforeClass
    public static void setUpClass(){
        ExpenseDataRepository.createTable();

    }

    //Requirement 1: Data should be saved to the database.

    @Test
    public void shouldAddDataToTheDatabase() {

        Double amount = 150.00;
        LocalDate date= LocalDate.now();
        String dataType="Netflix";

        ExpenseData expenseData = new ExpenseData(dataType,date,amount);
        ExpenseData expenseData1 = expenseDataRepository.create(expenseData);// insert data into database

        assertEquals("Amount should be correct",amount, expenseData1.getAmount());
        assertEquals("Date should be correct",date, expenseData1.getDate());
        assertEquals("DataType should be correct",dataType, expenseData1.getExpenseType());

    }

    // Requirement 2: Should be able to fetch all data from database

    @Test
    public void shouldBeAbleToRetrieveAllData(){

        Double amount = 150.00;
        LocalDate date= LocalDate.now();
        String dataType="Netflix";

        ExpenseData expenseData = new ExpenseData(dataType,date,amount);
        expenseDataRepository.create(expenseData);// insert data into database
        List<ExpenseData> result = expenseDataRepository.getExpenseData(); // Get data from database since it's an array get the first item
    assertTrue("Array size should be greater than Zero",result.size()>0);
    }

}