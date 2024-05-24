package stepDefs;


import driver.driverManager.CreateDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.util.List;
import java.util.Map;


public class LoginStepDef {

    private WebDriver driver;

    private String username;

    public LoginStepDef() {
        driver = CreateDriver.getInstance().getDriver();
        driver.manage().window().maximize();
        System.out.println("minor change");
    }

    @Given("user has launched url {string}")
    public void launchURL(String url) {
        driver.get(url);
        //ssertTrue(false);


        System.out.println("sample change login feature user1 changes");

    }

    @Given("user has entered credentials")
    public void enterCredentials(DataTable table) {
        List<Map<String, String>> credentials = table.asMaps(String.class, String.class);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(credentials.get(0).get("userName"));
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(credentials.get(0).get("password"));
        driver.findElement(By.id("username")).sendKeys(credentials.get(0).get("username"));
        driver.findElement(By.name("username")).sendKeys(credentials.get(0).get("username"));
        driver.findElement(By.id("password")).sendKeys(credentials.get(0).get("password"));
        driver.findElement(By.cssSelector("input[id='username']")).sendKeys(credentials.get(0).get("username"));
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(credentials.get(0).get("password"));
    }




    @And("user closes the browser")
    public void quitBrowser() {
        driver.quit();
    }

    @And("user has pressed button {int}")
    public void pressButton(int button) {

    }

}
