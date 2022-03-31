package PersonalExpenseManager;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;

public class AppTest {

    @Before
    public void setUpClass(){
        ExpenseDataRepository.createTable();

    }
    @Test
    public void shouldBeAbleToSaveExpense() {

        Double amount = 150.00;
        LocalDate date = LocalDate.now();
        String dataType = "Netflix";
        Integer expectedId = 1;

        ExpenseData expenseData = App.enterExpense(dataType,date,amount);
        assertEquals("Should save expensedata",expectedId, expenseData.getId());
    }
    @Test
    public void shouldBeAbleToShowExpense() {

        Double amount = 150.00;
        LocalDate date = LocalDate.now();
        String dataType = "Netflix";


        ExpenseData expenseData = App.enterExpense(dataType,date,amount);
        Double total = App.showExpenses();
        assertEquals("Total amount should be correct",amount,total);
    }
}