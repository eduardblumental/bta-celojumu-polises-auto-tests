package lv.bta;

import org.testng.Assert;
import org.testng.annotations.*;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;


public class CelojumaPolisesTest {
    @BeforeClass
    public void setup() {
        open("http://www.bta.lv");
        $(By.xpath("//button[contains(text(), 'Piekrītu')]")).click();
    }

    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    public void testTravelInsurancePurchaseForm() {
        $(By.xpath("//h4[contains(text(), '  Ceļojumi  ')]")).shouldBe(visible).click();
        $("#regionalSelectorRegion-open").shouldBe(visible).click();
        $(By.xpath("//div[contains(text(), 'Izvēlies valstis ')]")).shouldBe(visible).click();
        $("#regionalSelectorCountry-addCountry").shouldBe(visible).click();
    }
}
