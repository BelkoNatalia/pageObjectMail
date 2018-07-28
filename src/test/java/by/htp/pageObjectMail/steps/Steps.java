package by.htp.pageObjectMail.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.htp.pageObjectMail.driver.DriverSingleton;
import by.htp.pageObjectMail.pages.MailFormNewLetterPage;
import by.htp.pageObjectMail.pages.MailLoginPage;
import by.htp.pageObjectMail.pages.MailMainPage;

public class Steps {
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}
	
	// my method
	public void loginMail(String username, String password) {
		MailLoginPage loginPage = new MailLoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}
	
	// my method
	public void sendNewEmail(String emailTo, String subject, String text) {
		MailMainPage mailMainPage = new MailMainPage(driver);
		mailMainPage.openPage();
		mailMainPage.openWriteNewLetter();
		MailFormNewLetterPage formNewLetterPage = new MailFormNewLetterPage(driver);
		formNewLetterPage.fillTo(emailTo);
		formNewLetterPage.fillSubject(subject);
		formNewLetterPage.fillLetterBody(text);
		formNewLetterPage.submiteEmail();
	}
}
