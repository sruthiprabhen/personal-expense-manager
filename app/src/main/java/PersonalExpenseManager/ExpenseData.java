package PersonalExpenseManager;

import java.time.LocalDate;

public class ExpenseData {


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    Integer id;
    String expenseType;
    LocalDate expenseDate;
    Double amount;

    public ExpenseData(String expenseType, LocalDate date, Double amount) {
        this.amount = amount;
        this.expenseDate = date;
        this.expenseType = expenseType;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public LocalDate getDate() {
        return expenseDate;
    }

    public Double getAmount() {
        return amount;
    }

}
