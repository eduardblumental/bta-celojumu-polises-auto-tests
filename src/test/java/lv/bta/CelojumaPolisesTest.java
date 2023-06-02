package lv.bta;

import org.testng.Assert;
import org.testng.annotations.*;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;


public class CelojumaPolisesTest {
    @BeforeClass
    public void setup() {
//        open("https://www.bta.lv");
        open("https://www.bta.lv/privatpersonam/celojuma-apdrosinasana");
        $(By.xpath("//button[contains(text(), 'Piekrītu')]")).click();
//        $(By.xpath("//h4[contains(text(), '  Ceļojumi  ')]")).shouldBe(visible).click();
    }

    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test(priority = 1)
    public void testDestinationSelection() {
        SelenideElement destinationSelectButton = $("#regionalSelectorRegion-open").shouldBe(visible);

        String defaultDestination = destinationSelectButton.getText();

        destinationSelectButton.click();
        $(By.xpath("//div[contains(text(), 'Izvēlies valstis ')]")).shouldBe(visible).click();
        $("#regionalSelectorCountry-addCountry").shouldBe(visible).click();
        $(By.xpath("//button[@data-value='Indija']")).shouldBe(visible).click();
        $("#regionalSelectorCountry-applyButton").shouldBe(visible).click();

        String selectedDestination = $("#regionalSelectorRegion-open").shouldBe(visible).getText();

        Assert.assertNotEquals(selectedDestination, defaultDestination);
        Assert.assertEquals(selectedDestination, "Indija"); // This assert fails because the actual value is "Visa pasaule". Could be intentional, could be a bug.
    }

    @Test(priority = 2)
    public void testActivitySelection() {
        SelenideElement activitySelectButton = $("#travelActivities-open").shouldBe(visible);
        String defaultActivity = activitySelectButton.getText();

        activitySelectButton.click();
        $("#travelActivities-popup-select-option-3").shouldBe(visible).click();

        String selectedActivity = $("#travelActivities-open").shouldBe(visible).getText();

        Assert.assertNotEquals(selectedActivity, defaultActivity);
        Assert.assertEquals(selectedActivity, "Sports");
    }
}
