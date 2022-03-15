import driverFactory.driverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.*;
import pageObject.*;

public class AppTest{

    private static AndroidDriver <MobileElement> driver;
    static homePage home;
    amountPage amount = new amountPage(driver);
    accountsPage account = new accountsPage(driver);
    categoryPage category = new categoryPage(driver);
    transferPage transfer = new transferPage(driver);

    @BeforeClass
    public static void setState() throws InterruptedException {
        driver = driverFactory.getDriver();
        home = new homePage(driver);
    }

    @Before
    public void initialState () throws InterruptedException {
       home.skipOnboard();
    }

    @After
    public void resetDriver () throws InterruptedException {
        driver.resetApp();
    }

    @Test
    public void addIncomeWithMoney() throws InterruptedException {
        home.incomeButtonClick();
        amount.inputNote("Income salary");
        amount.numberClick(10);
        amount.chooseCategoryButtonClick();
        amount.salaryButton().click();
        Assert.assertEquals( "Salary: $10.00 added", home.getPopupConfirmation());
    }

    @Test
    public void notAddNegativeIncome() throws InterruptedException {
        home.incomeButtonClick();
        amount.inputNote("Income salary");
        amount.getAmountField();
        amount.numberClick(3);
        amount.minusButtonClick();
        amount.numberClick(5);
        amount.equalsButtonClick();
        amount.chooseCategoryButtonClick();
        Assert.assertEquals( true, amount.noteField().isDisplayed());
    }

    @Test
    public void addIncomeWithCard() throws InterruptedException {
        home.incomeButtonClick();
        amount.inputNote("Description note");
        amount.numberClick(3768);
        amount.chooseCategoryButtonClick();
        amount.currencyIconClick();
        amount.cardIconClick();
        amount.salaryButton().click();
        Assert.assertEquals( "Salary: $3,768.00 added", home.getPopupConfirmation());
    }

    @Test
    public void addExpenseWithMoney() throws InterruptedException {
        home.expenseButtonClick();
        amount.inputNote("Rent");
        amount.numberClick(800);
        amount.chooseCategoryButtonClick();
        amount.billsButtonClick();
        Assert.assertEquals( "Bills: $800.00 added",home.getPopupConfirmation());
    }

    @Test
    public void addNegativeExpense() throws InterruptedException {
        home.expenseButtonClick();
        amount.inputNote("Rent");
        amount.getAmountField();
        amount.numberClick(3);
        amount.minusButtonClick();
        amount.numberClick(5);
        amount.equalsButtonClick();
        amount.chooseCategoryButtonClick();
        Assert.assertEquals( true, amount.noteField().isDisplayed());
    }

    @Test
    public void addExpenseWithCard() throws InterruptedException {
        home.expenseButtonClick();
        amount.inputNote("Description note");
        amount.numberClick(3768);
        amount.currencyIconClick();
        amount.cardIconClick();
        amount.chooseCategoryButtonClick();
        amount.billsButtonClick();
        Assert.assertEquals( "Bills: $3,768.00 added", home.getPopupConfirmation());
        driver.navigate().back();
    }

    @Test
    public void addExpenseByClickingOnCategory() throws InterruptedException {
        amount.sportCategoryClick();
        amount.inputNote("Futebol");
        amount.numberClick(20);
        amount.chooseCategoryButtonClick();
        Assert.assertEquals( "Sports: $20.00 added",home.getPopupConfirmation());
    }

    @Test
    public void addNewAccount() throws InterruptedException {
        home.leftMenuClick();
        home.accountsButtonClick();
        home.addAccountsButtonClick();
        account.accountNameFieldInput("Car Account");
        account.imageIConClick();
        account.saveButton().click();
        Assert.assertEquals( "New account was added",home.getPopupConfirmation());
    }

    @Test
    public void notAddNewAccountWithoutImage() throws InterruptedException {
        home.leftMenuClick();
        home.accountsButtonClick();
        home.addAccountsButtonClick();
        account.accountNameFieldInput("Car Account");
        account.saveButton().click();
        Assert.assertEquals( true,account.saveButton().isDisplayed());
    }

    @Test
    public void changeAccount() throws InterruptedException {
        addNewAccount();
        home.leftMenuClick();
        home.accountsButtonClick();
        account.accountNameClick("Car Account");
        account.accountNameFieldInput("New Account");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Assert.assertEquals( "Account was updated",home.getPopupConfirmation());
    }

    @Test
    public void deleteCategory() throws InterruptedException {
        home.leftMenuClick();
        category.categoryIconClick();
        category.billsIconClick();
        category.deleteButtonClick();
        category.okButtonClick();
        Assert.assertEquals( "Category was deleted",home.getPopupConfirmation());
    }

    @Test
    public void deleteIncome() throws InterruptedException {
        addIncomeWithMoney();
        home.searchButtonClick();
        home.searchFieldInput("Income salary");
        home.searchElementClick();
        amount.deleteButtonClick();
        Assert.assertEquals( "Record was deleted", home.getPopupConfirmation());
    }

    @Test
    public void deleteExpense() throws InterruptedException {
        addExpenseWithMoney();
        home.searchButtonClick();
        home.searchFieldInput("Rent");
        home.searchElementClick();
        amount.deleteButtonClick();
        Assert.assertEquals( "Record was deleted", home.getPopupConfirmation());
    }

    @Test
    public void editIncome() throws InterruptedException {
        addIncomeWithMoney();
        home.searchButtonClick();
        home.searchFieldInput("Income salary");
        home.searchElementClick();
        amount.inputNote("New description");
        amount.numberClick(10);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Assert.assertEquals( "Record was updated", home.getPopupConfirmation());
    }

    @Test
    public void editExpense() throws InterruptedException {
        addExpenseWithMoney();
        home.searchButtonClick();
        home.searchFieldInput("Rent");
        home.searchElementClick();
        amount.inputNote("New description");
        amount.numberClick(10);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Assert.assertEquals( "Record was updated", home.getPopupConfirmation());
    }

    @Test
    public void searchIncomeByDescription() throws InterruptedException {
        addIncomeWithMoney();
        home.searchButtonClick();
        home.searchFieldInput("Income salary");
        home.searchElementClick();
        Assert.assertEquals( "Income salary", amount.getNoteText());
    }

    @Test
    public void searchIncomeByCategory() throws InterruptedException {
        addIncomeWithMoney();
        home.searchButtonClick();
        home.searchFieldInput("Salary");
        home.searchElementClick();
        Assert.assertEquals( "Income salary", amount.getNoteText());
    }

    @Test
    public void transferCashToCard() throws InterruptedException {
        home.transferButtonClick();
        amount.getAmountField();
        amount.numberClick(600);
        transfer.confirmTransferButtonClick();
        Assert.assertEquals( "Transfer was added", home.getPopupConfirmation());
    }

    @Test
    public void transferCardToCash() throws InterruptedException {
        home.transferButtonClick();
        transfer.fromAccountButtonClick();
        transfer.cardOptionClick();
        transfer.toAccountButtonClick();
        transfer.cashOptionClick();
        amount.getAmountField();
        amount.numberClick(600);
        transfer.confirmTransferButtonClick();
        Assert.assertEquals( "Transfer was added", home.getPopupConfirmation());
    }

    @Test
    public void notTransferSameAccount() throws InterruptedException {
        home.transferButtonClick();
        transfer.toAccountButtonClick();
        transfer.cashOptionClick();
        amount.getAmountField();
        Assert.assertEquals( true, amount.noteField().isDisplayed());
    }
}
