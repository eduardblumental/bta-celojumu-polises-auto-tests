package lv.bta;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import org.openqa.selenium.By;


public class TravelInsuranceWeb {
    public void openTravelInsurancePage() {
        open("https://www.bta.lv");
        $(By.xpath("//button[contains(text(), 'Piekrītu')]")).click();
        $(By.xpath("//h4[contains(text(), '  Ceļojumi  ')]")).shouldBe(visible).click();
    }

    public void closeDriver() {
        Selenide.closeWebDriver();
    }

    public SelenideElement getDestinationSelectButton() {
        return $("#regionalSelectorRegion-open").shouldBe(visible);
    }

    public String getDestinationFromDestinationSelectButton(SelenideElement destinationSelectButton) {
        return destinationSelectButton.getText();
    }

    public void selectDestination(SelenideElement destinationSelectButton, String country) {
        destinationSelectButton.click();
        $(By.xpath("//div[contains(text(), 'Izvēlies valstis ')]")).shouldBe(visible).click();
        $("#regionalSelectorCountry-addCountry").shouldBe(visible).click();
        $(By.xpath("//button[@data-value='" + country + "']")).shouldBe(visible).click();
        $("#regionalSelectorCountry-applyButton").shouldBe(visible).click();
    }

    public SelenideElement getActivitySelectButton() {
        return $("#travelActivities-open").shouldBe(visible);
    }

    public String getActivityFromActivitySelectButton(SelenideElement activitySelectButton) {
        return activitySelectButton.getText();
    }

    public void selectActivity(SelenideElement activitySelectButton, String activity) {
        activitySelectButton.click();
        $(By.xpath("//button//span[contains(text(), '" + activity + "')]")).shouldBe(visible).click();
    }

    public void continueToStep2ReceiveOffer() {
        $(By.xpath("//button[contains(text(), '  Saņemt piedāvājumu  ')]")).shouldBe(visible).click();
    }

    public SelenideElement getInsuranceProgramDiv(String insuranceProgramID) {
        return $(By.xpath("//div[@data-type='" + insuranceProgramID + "']")).shouldBe(visible);
    }

    public void openInsuranceProgramDetailsPopupForm(SelenideElement insuranceProgram) {
        insuranceProgram.$(By.xpath(".//span[contains(text(), ' Apskati, kas ir apdrošināts')]")).click();
    }

    public SelenideElement getInsuranceProgramDetailsPopupForm() {
        return $(".covered-popup-travel").shouldBe(visible);
    }

    public void closeInsuranceProgramDetailsPopupForm() {
        $(".popup-close.close").shouldBe(visible).click();
    }

    public void continueToStep3WithSelectedPolicyPlan(String policyPlanID) {
        $(By.xpath("//button[@datatype='" + policyPlanID + "']")).shouldBe(visible).click();
    }

    public ElementsCollection getTravelerFields() {
        $(".traveler-details.flex.margin-top").shouldBe(visible);
        return $$(By.xpath("//input[@type='text']"));
    }
}
