package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertyStepDef {
    WebDriver driver;

    @Given("^User on the welcome page of \"([^\"]*)\"$")
    public void user_on_the_welcome_page_of(String url) throws Throwable {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("^User click on property$")
    public void user_click_on_property() throws Throwable {
        driver.findElement(By.xpath("//div/a[contains(.,'Property')]")).click();
    }

    @Then("^User should navigate to property page$")
    public void user_should_navigate_to_property_page() throws Throwable {
        String actual = driver.findElement(By.xpath("//li[contains(@class,'gtm-hamburger-locale')]/a")).getAttribute("href");
        String expected = "https://ikman.lk/si/ads/sri-lanka/property";
        Assert.assertEquals(expected, actual);
    }

    @When("^User click on houses$")
    public void user_click_on_houses() throws Throwable {
        driver.findElement(By.xpath("//li/a[contains(.,'Houses')]")).click();
    }

    @Then("^User should navigate to houses page$")
    public void user_should_navigate_to_houses_page() throws Throwable {
        String actual = driver.getCurrentUrl();
        String expected = "https://ikman.lk/en/ads/sri-lanka/houses?categoryType=ads&categoryName=Property";
        Assert.assertEquals(expected,actual);
    }

    @When("^User click on colombo$")
    public void user_click_on_colombo() throws Throwable {
        driver.findElement(By.xpath("//li/a[contains(.,'Colombo')]")).click();
    }

    @Then("^User should navigate to colombo houses page$")
    public void user_should_navigate_to_colombo_houses_page() throws Throwable {
        String actual = driver.getCurrentUrl();
        String expected = "https://ikman.lk/en/ads/colombo/houses?categoryType=ads&categoryName=Houses&type=for_sale";
        Assert.assertEquals(expected,actual);
    }

    @When("^User click on prices drop down$")
    public void user_click_on_prices_drop_down() throws Throwable {
        driver.findElement(By.xpath("//a[contains(.,'Price')]")).click();
    }

    @When("^User enter minimum and maximum values$")
    public void user_enter_minimum_and_maximum_values() throws Throwable {
        driver.findElement(By.cssSelector("input[name='filters[0][minimum]']")).sendKeys("5000000");
        driver.findElement(By.cssSelector("input[name='filters[0][maximum]']")).sendKeys("7500000");
    }

    @When("^Click on filter$")
    public void click_on_filter() throws Throwable {
        driver.findElement(By.xpath("//div[contains(@class,'filter-price')]//button[contains(.,'Apply filters')]")).click();
    }

    @When("^User click on beds drop down$")
    public void user_click_on_beds_drop_down() throws Throwable {
        driver.findElement(By.xpath("//a[contains(.,'Beds')]")).click();
    }

    @When("^User click on threeBeds$")
    public void user_click_on_beds() throws Throwable {
        driver.findElement(By.cssSelector("input[id='filters2values-3']")).click();
    }

    @Then("^User should navigate to filtered results page$")
    public void user_should_navigate_to_filtered_results_page() throws Throwable {
        String xPathOfTotalResults = "//div/span[contains(@class,'summary-count')]";
        int total = Integer.parseInt(driver.findElement(By.xpath(xPathOfTotalResults)).getText().split(" ")[3]);
        Assert.assertNotNull(total);
    }

    @Then("^Should close the browser$")
    public void should_close_the_browser() throws Throwable {
        driver.quit();
    }

}
