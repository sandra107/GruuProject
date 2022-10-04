package pages;

import Help.Wait.WaitHelper;
import Help.browserConfiguration.configReader.ObjectReader;
import Help.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import testBase.TestBase;

public class Day1 {
    private WebDriver driver;
    private final Logger log = LoggerHelper.getLogger(Day1.class);
    WaitHelper waitHelper;

    @FindBy(css = "h2")
    WebElement title;

    @FindBy(linkText = "MOBILE")
    WebElement mobile;

    @FindBy(css = "select[title=\"Sort By\"]")
    WebElement sortBy;

    /**
     * Hàm tạo (Constructor)
     * Khởi tạo giá trị cho các thuộc tính hoặc thực hiện các hoạt động khởi tạo
     * PageFactory là phần mở rộng của POM, giúp khởi tạo các đôi tượng WE tối ưu và giảm thiếu code
     *
     */
    public  Day1(WebDriver driver){
        this.driver = driver;
        //Khởi tạo phần tử bằng initElements() -> Khởi tạo các phần tử web mà chúng định vị bằng sd @FindBy
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(title, ObjectReader.reader.getExplicitWait());
        TestBase.logExtentReport("Day 1 is comming...");
    }

    public boolean checkTitle(){
        if(title.getAttribute("title").isEmpty()){
            String msg = "THIS IS DEMO SITE FOR   ";
            return true;
        }
        return false;
    }

    public void clickToMobile(){
        log.info("Clicking to mobile");
        TestBase.logExtentReport("Clicking to mobile in testbase");
        mobile.click();
        new Select(sortBy).selectByVisibleText("Name");
    }
}
