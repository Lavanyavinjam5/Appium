package webtesting;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorAppWithNavigationTest {

    public static void main(String[] args) throws InterruptedException {

       // AndroidDriver<AndroidElement> driver;

        // Setup desired capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "realme7 RMX2151");
        caps.setCapability("appPackage", "com.example.mycalculator");
        caps.setCapability("appActivity", "com.example.mycalculator.MainActivity");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        try {
            // Initialize the Appium driver
        	 AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);

            // Perform addition operation
        	 
        	 WebElement num1Field = driver.findElement(By.id("com.example.mycalculator:id/etFirstNumber"));
        	 Thread.sleep(2000);
        	 System.out.println("NumField 1 : "+num1Field);
              num1Field.sendKeys("5");

              WebElement num2Field = driver.findElement(By.id("com.example.mycalculator:id/etSecondNumber"));
              num2Field.sendKeys("3");

              WebElement addButton = driver.findElement(By.id("com.example.mycalculator:id/btnAdd"));
            addButton.click();

            // Navigate to the second screen
            WebElement navigateButton = driver.findElement(By.id("com.example.mycalculator:id/btnNavigate"));
            Thread.sleep(2000);
            navigateButton.click();
         
            WebElement resultView = driver.findElement(By.id("com.example.mycalculator:id/textViewMessage"));
          //  Thread.sleep(2000);
            String resultText = resultView.getText();
            System.out.println(" resultText :: "+resultText);
            if(resultText.equalsIgnoreCase("Welcome to the Second Screen!")) {
                System.out.println("Successfully navigated to SecondActivity!!!");
            } else {
                System.out.println("Not able to navigate!!!.");
            }

            
            System.out.println("Navigation to the second screen was successful!");

            driver.quit();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}