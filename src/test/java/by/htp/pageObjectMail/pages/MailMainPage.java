package by.htp.pageObjectMail.pages;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailMainPage extends AbstractPage {
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://e.mail.ru/messages/inbox";

	@FindBy(xpath = "//child::div[attribute::id='b-toolbar__left']//child::span")
	private WebElement buttonWriteEmail;

	public MailMainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("Main page opened");
	}

	public void openWriteNewLetter() {
		buttonWriteEmail.click();
		logger.info("Open form for new letter");
	}
}
