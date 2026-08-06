package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class SeleniumProject {
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		//Read the title of the website and verify the text

		driver.get("https://hrm.alchemy.hguy.co/");
		System.out.println("Page title: " + driver.getTitle());
		
		
		//Print the url of the header image to the console
			
		WebElement headerimage=driver.findElement(By.xpath("//div[@id='divLogo']/img"));
		String imageurl = headerimage.getAttribute("src");
		System.out.println(imageurl);
		
		
		//Open the site and login with the credentials provided
		
		
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("5Nx#I6BK%r3$8vz0ch");
		driver.findElement(By.id("btnLogin")).click();
		
		System.out.println("Page title: " + driver.getTitle());
		
		
		//Add an employee and their details to the site
		
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("firstName")).sendKeys("Sruthi");
		driver.findElement(By.id("lastName")).sendKeys("Varma");
		driver.findElement(By.id("btnSave")).click();
		
		System.out.println("Page title: " + driver.getTitle());
		
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Sruthi Varma");
		driver.findElement(By.id("searchBtn")).click();
		
		System.out.println("Success");

        //Edit a user’s information
		
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		driver.findElement(By.id("btnSave")).click();
		
		WebElement Firstname = driver.findElement(By.id("personal_txtEmpFirstName"));
		Firstname.clear();
		Firstname.sendKeys("Sruthi");
		
		WebElement Lastname = driver.findElement(By.id("personal_txtEmpLastName"));
		Lastname.clear();
		Lastname.sendKeys("Tirumalaraju");
		
		driver.findElement(By.id("personal_optGender_2")).click();
		driver.findElement(By.id("personal_cmbNation")).click();
		

		WebElement nationalityDropdown = driver.findElement(By.id("personal_cmbNation"));
		Select nationality = new Select(nationalityDropdown);

		nationality.selectByVisibleText("Indian");
		

		WebElement dob = driver.findElement(By.xpath("//input[contains(@id,'DOB')]"));
		dob.clear();
		dob.sendKeys("1996-05-18");
		driver.findElement(By.id("btnSave")).click();
		
		System.out.println("Success");

		//Directory

        WebDriver driver = new EdgeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://hrm.alchemy.hguy.co/");  		
		
		
        driver.findElement(By.id("txtUsername")).sendKeys("orange"); 
        driver.findElement(By.id("txtPassword")).sendKeys("5Nx#I6BK%r3$8vz0ch"); 
        driver.findElement(By.id("btnLogin")).click();
        
        driver.findElement(By.id("menu_directory_viewDirectory")).click();
		System.out.println("Success");
		driver.close()
	
		//Qualification
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://hrm.alchemy.hguy.co/");  		
		
		
        driver.findElement(By.id("txtUsername")).sendKeys("orange"); 
        driver.findElement(By.id("txtPassword")).sendKeys("5Nx#I6BK%r3$8vz0ch"); 
        driver.findElement(By.id("btnLogin")).click();
        
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.xpath("//a[contains(@href,'viewQualifications')]")).click();
        driver.findElement(By.id("addWorkExperience")).click();
        driver.findElement(By.id("experience_employer")).sendKeys("IBM");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Senior Test Specialist");
        driver.findElement(By.id("experience_from_date")).clear();
        driver.findElement(By.id("experience_from_date")).sendKeys("2020-02-10");
        driver.findElement(By.id("btnWorkExpSave")).click();
		System.out.println("Success");
		driver.close()

		// Apply Leave
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://hrm.alchemy.hguy.co/");  		
		
		driver.findElement(By.id("txtUsername")).sendKeys("orange"); 
        driver.findElement(By.id("txtPassword")).sendKeys("5Nx#I6BK%r3$8vz0ch"); 
        driver.findElement(By.id("btnLogin")).click();
                
        driver.findElement(By.xpath("//span[text()='Apply Leave']/parent::a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Select leaveType = new Select(driver.findElement(By.xpath("//select[@id='applyleave_txtLeaveType']")));
        leaveType.selectByVisibleText("Holiday");
        driver.findElement(By.id("applyleave_txtFromDate")).clear();        
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2026-07-25");
        driver.findElement(By.id("applyleave_txtToDate")).clear();
        driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2026-07-25");
        driver.findElement(By.id("applyBtn")).click();
        System.out.println("Success");
		driver.close()

		//Emergency contact

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://hrm.alchemy.hguy.co/"); 
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("5Nx#I6BK%r3$8vz0ch");
        driver.findElement(By.id("btnLogin")).click();
        
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        
        driver.findElement(By.linkText("Emergency Contacts")).click();

        List<WebElement> rows = driver.findElements(
                By.xpath("//table[@id='emgcontact_list']/tbody/tr"));

        System.out.println("===== Emergency Contacts =====");

        for (WebElement row : rows) {

            List<WebElement> cols =
                    row.findElements(By.tagName("td"));

            for (WebElement col : cols) {
                System.out.print(col.getText() + " | ");
            }

            System.out.println();driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("5Nx#I6BK%r3$8vz0ch");
        driver.findElement(By.id("btnLogin")).click();
        
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        
        driver.findElement(By.linkText("Emergency Contacts")).click();

        List<WebElement> rows = driver.findElements(
                By.xpath("//table[@id='emgcontact_list']/tbody/tr"));

        System.out.println("===== Emergency Contacts =====");

        for (WebElement row : rows) {

            List<WebElement> cols =
                    row.findElements(By.tagName("td"));

            for (WebElement col : cols) {
                System.out.print(col.getText() + " | ");
            }

            System.out.println();
			driver.close();
		   
		}
		
	}

}
