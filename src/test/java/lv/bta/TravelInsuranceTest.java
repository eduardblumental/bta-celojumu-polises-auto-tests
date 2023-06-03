package lv.bta;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.*;


public class TravelInsuranceTest {
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

    @Test(priority = 3)
    public void testPopupForm() {
        $(By.xpath("//button[contains(text(), '  Saņemt piedāvājumu  ')]")).shouldBe(visible).click();

        SelenideElement optimalProgramDiv = $(By.xpath("//div[@data-type='policyItemOPP']")).shouldBe(visible);
        optimalProgramDiv.$(By.xpath(".//span[contains(text(), ' Apskati, kas ir apdrošināts')]")).click();

        SelenideElement popupForm = $(".covered-popup-travel").shouldBe(visible);
        Assert.assertTrue(popupForm.isDisplayed());

        $(".popup-close.close").shouldBe(visible).click();
    }

    @Test(priority = 4)
    public void testTravelerFields() {
        $(By.xpath("//button[@datatype='selectPolicyPlanOPP']")).shouldBe(visible).click();

        $(".traveler-details.flex.margin-top").shouldBe(visible);
        ElementsCollection elements = $$(By.xpath("//input[@type='text']"));

        for (SelenideElement element : elements) {
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.getValue().isEmpty());
        }
    }
}
