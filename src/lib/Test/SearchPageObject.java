package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject{

    private static final String
    SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Поиск по Википедии')]",
    SEARCH_INPUT = "//*[contains(@text,'Поиск')]",
    SEARCH_RESULT = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']",
    INPUT_ELEMENT = "//*[@resource-id='org.wikipedia:id/text_input']",
    CLICK_INPUT = "//*[contains(@text,'{SUBSTRING}')]",
    ELEMENT_INPUT = "//*[@resource-id='org.wikipedia:id/{ELEMENT}']",

    OVERFLOW_MENU = "//*[@resource-id='org.wikipedia:id/item_overflow_menu']";
    public SearchPageObject(AppiumDriver driver){
        super(driver);
    }
    public void ClickInput(String substring){

        this.waitForElementAndClick(By.xpath(CLICK_INPUT.replace("{SUBSTRING}",substring)),"error",15);
    }
    public void deleteElement(String substring){

        this.waitForElementAndClear(By.xpath(CLICK_INPUT.replace("{SUBSTRING}",substring)),"error",15);
    }

    public void inputElement(String string){
//        String change_element = INPUT_ELEMENT.replace("{SUBSTRING}",substring);

        this.waitForElementAndSendKeys(By.xpath(INPUT_ELEMENT), string,"error",15);
    }
    public void initSearchInput(){
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT),"error",15);

        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT),"error", 5);
    }

    public void ClickAtElement(String element){
        this.waitForElementAndClick(By.xpath(ELEMENT_INPUT.replace("{ELEMENT}",element)),"error",15);
    }

    public void getMoreSettings(){
        this.waitForElementAndClick(By.xpath(OVERFLOW_MENU),"error",15);
    }

    public void typeSearchLine(String search_line){
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT),search_line,"error",15);
    }
    private static String getResultSearchElement(String substring){
        return SEARCH_RESULT.replace("{SUBSTRING}",substring);
    }
    public void waitForSearchResult(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath),"error",15);
    }
    private static String getResultElement(String substring){
        return SEARCH_RESULT.replace("{SUBSTRING}",substring);
    }
    public void waitForLoadPage(String substring){
        this.waitForElementPresent(By.xpath(CLICK_INPUT.replace("{SUBSTRING}",substring)),"error",15);
    }
}
