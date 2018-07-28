package by.htp.pageObjectMail;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.pageObjectMail.steps.Steps;

public class MailSendEmailTest {
	private Steps steps;
	private final String USERNAME = "tathtp";
	private final String PASSWORD = "Klopik123";
	
	private String emailTo = "khankevich@inbox.ru";//"sviatlana.zakharenka@gmail.com";
	private String subject = "Test page object";
	private String textLetter = "My first pageObject";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(description = "Login to Mail")
	public void sendNewEmail() {
		steps.loginMail(USERNAME, PASSWORD);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		steps.sendNewEmail(emailTo, subject, textLetter);
		
//		Assert.assertTrue(steps.isLoggedIn(USERNAME));
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}

}
