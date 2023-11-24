package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.BaseDriver;

import java.util.Date;
import java.util.UUID;

public class UsersPage extends BaseDriver {
    WebDriver driver;
    @FindBy(xpath= "//table[@class='smart-table table table-striped']")
    private WebElement tableList;
    @FindBy(xpath= "//button[@type='add']")
    private WebElement addUserBtn;

    @FindBy(xpath= "//input[@name='FirstName']")
    private WebElement firstName;

    @FindBy(xpath= "//input[@name='LastName']")
    private WebElement lastName;

    @FindBy(xpath= "//input[@name='UserName']")
    private WebElement userName;

    @FindBy(xpath= "//input[@name='Password']")
    private WebElement password;

    @FindBy(xpath= "//select[@name='RoleId']")
    private WebElement role;

    @FindBy(xpath= "//input[@name='Email']")
    private WebElement email;

    @FindBy(xpath= "//input[@name='Mobilephone']")
    private WebElement mobilephone;

    @FindBy(xpath= "//button[text()='Save']")
    private WebElement saveBtn;

    public UsersPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }
    public boolean validateUserTableList(){
        return tableList.isDisplayed();
    }
    public void clickAddUsers(){
      addUserBtn.click();
    }
    public void enterUserDetails(String fName,String lName,String userNames,String userPassword,String userEmail,String cellNumber, String userRole){
         String unique= UUID.randomUUID().toString();
         String user = userNames + unique;
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        userName.sendKeys(user);
        password.sendKeys(userPassword);
        email.sendKeys(userEmail);
        mobilephone.sendKeys(cellNumber);
        Select roles = new Select(role);
        roles.selectByVisibleText(userRole);
        saveBtn.click();
        Assert.assertTrue(driver.findElement(By.xpath("//td[text()='" + user + "']")).isDisplayed(),"user not are added to the list");
    }
}
