package dev.estillero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OptionsPage {
	
	public WebDriver driver;
	
	@FindBy(xpath = "/html/body/button[1]/a")
	public WebElement create;
	
	@FindBy(xpath = "/html/body/button[2]/a")
	public WebElement read;
	
	@FindBy(xpath = "/html/body/button[3]/a")
	public WebElement update;
	
	
	public OptionsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
