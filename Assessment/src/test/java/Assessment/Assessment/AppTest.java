package Assessment.Assessment;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;



public class AppTest 
{
    WebDriver driver;
    WebDriverWait wait;
    
    @Test(priority=1)
    public void open_browser() {
    	System.setProperty("webdriver.chrome.driver","G:\\worldline\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
    	driver = new ChromeDriver();
    	wait = new WebDriverWait(driver, 5);
    	driver.manage().window().maximize();
    	driver.get("https://trends.builtwith.com/websitelist/DataTables");
    	System.out.println("Start Browser Executed");
    	Reporter.log("Start Browser Executed");
    }
    
    @Test(priority=2)
    public void print_all_rows() {
    	WebElement table = driver.findElement(By.xpath("(//table[@class='table table-responsive-sm table-sm mt-2 table-hover'])[1]"));
    	List <WebElement> rows = table.findElements(By.tagName("tr"));
    	
    	for(WebElement i : rows) {
    		List<WebElement> cells = i.findElements(By.tagName("td"));
    		for(WebElement j : cells) {
    			String cellData = j.getText();
    			System.out.print(cellData + "\t\t");
    		}
    		System.out.println();
    	}
    	
    }
    
    @Test(priority=3)
    public void print_selected_rows() {
    	System.out.println();
    	WebElement table = driver.findElement(By.xpath("(//table[@class='table table-responsive-sm table-sm mt-2 table-hover'])[1]"));
    	List <WebElement> rows = table.findElements(By.tagName("tr"));
    	int startIndex = 5;
    	int endIndex = 10;
    	
    	for(int i=startIndex;i<=endIndex;i++) {
    		WebElement row = rows.get(i-1);
    		List<WebElement> cells = row.findElements(By.tagName("td"));
    		for(WebElement j : cells) {
    			String cellData = j.getText();
    			System.out.printf("%-20s", cellData);
    		}
    		System.out.println();
    	}
    }
    
    @Test(priority=4)
    public void finding_specific_row() {
    	System.out.println();
    	System.out.println("Specific row");
    	int row_index = 5;
    	WebElement table = driver.findElement(By.xpath("(//table[@class='table table-responsive-sm table-sm mt-2 table-hover'])[1]"));
    	List <WebElement> rows = table.findElements(By.tagName("tr"));
    	WebElement row = rows.get(row_index-1);
		List<WebElement> cells = row.findElements(By.tagName("td"));
		for(WebElement cell : cells) {
			String cellData = cell.getText();
			System.out.printf("%-20s", cellData);
		}
		System.out.println();
    }
    
    @Test(priority=5)
    public void to_check_element_present() {
    	
    	WebElement table = driver.findElement(By.xpath("(//table[@class='table table-responsive-sm table-sm mt-2 table-hover'])[1]"));
    	List<WebElement> rows = table.findElements(By.tagName("tr"));
    	String country = "United States";
    	boolean key = false;
    	for(WebElement i : rows) {
    		List<WebElement> cells = i.findElements(By.tagName("td"));
    		for(WebElement j : cells) {
	    		String Data = j.getText();
	    		if(Data.contains(country)) {
	    			key=true;
	    			break;
	    		}
    		}
    		if(key) {
    			break;
    		}
    	}
    	Assert.assertEquals(key, true, "The table doesn't contain "+country+"\t\t");
    	
    }
    
    @Test(priority=6)
    public void print_row_which_have_element() {
    	System.out.println();
    	WebElement table = driver.findElement(By.xpath("(//table[@class='table table-responsive-sm table-sm mt-2 table-hover'])[1]"));
    	List<WebElement> rows = table.findElements(By.tagName("tr"));
    	
    	String element = "abs.aop.acer.com";
    	
    	for(WebElement i : rows) {
    		List<WebElement> cells = i.findElements(By.tagName("td"));
    		for(WebElement j : cells) {
    			String Data = j.getText();
    			if(Data.contains(element)) {
    				List<WebElement> rowData = i.findElements(By.tagName("td"));
    				for(WebElement k : rowData) {
    					System.out.println(k.getText() + "\t\t");
    				}
    			}
    		}
    		
    	}
    	
    }
}
