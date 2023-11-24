import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UsersPage;
import utilities.BaseDriver;

public class TestCases extends BaseDriver {

    @Test
    public void  AddUsers(){
        WebDriver driver = BaseDriver.GetDriver();
        UsersPage usersPage = PageFactory.initElements(driver, UsersPage.class);
        Assert.assertTrue( usersPage.validateUserTableList(),"user table list not displayed");
        usersPage.clickAddUsers();
        usersPage.enterUserDetails("Yone","Ntloko","yntloko-","testing@321","yn@gmail.com","+271925555","Admin");
    }

}
