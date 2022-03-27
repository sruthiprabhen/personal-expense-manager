package PersonalExpenseManager;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ExpenseDataRepositoryTest {

    ExpenseDataRepository expenseDataRepository = new ExpenseDataRepository();
    @BeforeClass
    public static void setUpClass(){
        ExpenseDataRepository.createTable();

    }

    @Test
    public void shouldAddDataToTheDatabase() {

        Double amount = 150.00;
        ExpenseData expenseData = new ExpenseData("Netflix",LocalDate.now(),amount);
        expenseDataRepository.create(expenseData); // insert data into database
        ExpenseData result = expenseDataRepository.getExpenseData().get(0); // Get data from database since its an array get the first item
        Double actualAmount = result.getAmount(); // amount from the

        assertEquals("Amount should be correct",amount, actualAmount);
    }


}