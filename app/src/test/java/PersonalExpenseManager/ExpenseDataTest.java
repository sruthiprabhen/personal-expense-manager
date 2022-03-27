package PersonalExpenseManager;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ExpenseDataTest {

    String expenseType = "HBO";
    LocalDate expenseDate = LocalDate.now();
    Double amount = 150.00;

    ExpenseData expenseData = new ExpenseData(expenseType, expenseDate, amount);

    @Test
    public void shouldReturnAmount() {

        assertEquals(amount, expenseData.getAmount());
    }

    @Test
    public void shouldReturnDate() {

        assertEquals(expenseDate, expenseData.getDate());
    }

    @Test
    public void shouldReturnExpenseType() {

        assertEquals(expenseType, expenseData.getExpenseType());
    }

}