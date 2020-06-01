package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resource.DriverUtility;

public class LoginPageTest {
	
	public WebDriver driver;
	public XSSFWorkbook workBook;
	public XSSFSheet workSheet;
	
	DriverUtility driverInit = new DriverUtility();
	
	@Test(dataProvider="loginData")
	public void loginTest(String userName, String password) throws IOException 
	{
		/* driver = driverInit.initializeDriver("https://phptravels.org/clientarea.php");
		WebElement capt = driver.findElement(By.cssSelector("[class='recaptcha-checkbox-border']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", capt); */
		
		System.out.println(userName+password);
	}
	
	@DataProvider
	public Object[][] loginData() throws IOException
	{
		Object[][] data = excelData();
		return data;
	}
	
	public Object[][] excelData() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\balaj\\Desktop\\Book1.xlsx");
		String[][] cellIndex;
		workBook = new XSSFWorkbook(fis);
		workSheet = workBook.getSheet("Sheet1");
		int rowCount = workSheet.getLastRowNum() - workSheet.getFirstRowNum()+1;
		System.out.println("first row num "+ workSheet.getFirstRowNum());
		System.out.println("last row num "+ workSheet.getLastRowNum());
		XSSFRow row = workSheet.getRow(0);
		int colCount = row.getLastCellNum();
		System.out.println("col count "+rowCount);
		int ci = 0;
		cellIndex = new String[rowCount][colCount];
		for(int i=0; i<rowCount; i++, ci++ )
		{
			int cj = 0;
			for(int j=0; j<colCount; j++, cj++)
			{
				cellIndex[ci][cj] = getCellData(i,j);
				//System.out.println(cellIndex[ci][cj]);
			}
		}
		return(cellIndex);
		
	}
	
	public String getCellData(int rowNum, int colNum)
	{
		XSSFCell cell = workSheet.getRow(rowNum).getCell(colNum);
		String cellValue = cell.getStringCellValue();
		return cellValue;
	}
	
	
	

}
