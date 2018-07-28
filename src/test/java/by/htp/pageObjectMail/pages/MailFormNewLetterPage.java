package by.htp.pageObjectMail.pages;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailFormNewLetterPage extends AbstractPage {
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://e.mail.ru/compose";

	@FindBy(xpath = "//child::textarea[attribute::data-original-name='To']")
	private WebElement txtTo;
	
	@FindBy(xpath = "//child::input[attribute::name='Subject']")
	private WebElement txtSubject;

	@FindBy(xpath = "//child::td/child::iframe")
	private WebElement elementIframe;
	
	@FindBy(xpath = "//child::body[attribute::id='tinymce']")
	private WebElement txtBody;
	
	@FindBy(xpath = "//child::div[attribute::class='b-toolbar']//child::span[attribute::class='b-toolbar__btn__text'][1]")
	private WebElement buttonSent; 
	
	public MailFormNewLetterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("MailFormNewLetterPage opened");
	}

	public void fillTo(String emailTo) {
		txtTo.clear();
		txtTo.sendKeys(emailTo);
		logger.info("Insert email to");
	}
	
	public void fillSubject(String subject) {
		txtSubject.clear();
		txtSubject.sendKeys(subject);
		logger.info("Insert subject");
	}
	
	public void fillLetterBody(String text) {
		driver.switchTo().frame(elementIframe);
		txtBody.sendKeys(text);
		driver.switchTo().parentFrame();
		logger.info("Insert body");
	}
	
	public void submiteEmail() {
		buttonSent.click();
		logger.info("Submite email");
	}
}
