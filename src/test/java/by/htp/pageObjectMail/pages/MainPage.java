package by.htp.pageObjectMail.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
	private final String BASE_URL = "https://github.com/";

	@FindBy(xpath = "//a[contains(@aria-label, 'Create new')]")
	private WebElement buttonCreateNew;

	@FindBy(xpath = "//a[contains(text(), 'New repository')]")
	private WebElement linkNewRepository;

	// WebElement linkNewRepository =
	// driver.findElement(By.xpath("//a[contains(text(), 'New repository')]"));

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void clickOnCreateNewRepositoryButton() {
		buttonCreateNew.click();
		linkNewRepository.click();
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
}
