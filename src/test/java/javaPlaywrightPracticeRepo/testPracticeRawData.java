package javaPlaywrightPracticeRepo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class testPracticeRawData {


	    public static void main(String[] args) {
	        // Initializes the Playwright server wrapper using try-with-resources for reliable cleanup
	        try (Playwright playwright = Playwright.create()) {
	            
	            System.out.println("[INFO] Launching Chromium Browser...");
	            
	            // Launch Options configuration
	            // .setHeadless(false) ensures the browser visually opens on your desktop screen
	            Browser browser = playwright.chromium().launch(
	                new BrowserType.LaunchOptions().setHeadless(false)
	            );
	            
	            // Creates a brand new isolated browser context session
	            BrowserContext context = browser.newContext();
	            
	            // Opens a new tab window inside the active browser context
	            Page page = context.newPage();
	            
	            System.out.println("[INFO] Navigating to Google...");
	            page.navigate("https://google.com");
	            
	            // Output page metadata confirmations to the console
	            System.out.println("================================================");
	            System.out.println("Successfully Connected to URL: " + page.url());
	            System.out.println("Verified Page Title:           " + page.title());
	            System.out.println("================================================");
	            
	            // Safe teardown sequence 
	            page.close();
	            context.close();
	            browser.close();
	            
	            System.out.println("[INFO] Browser closed successfully. Test Execution Pass.");
	            
	        } catch (Exception e) {
	            System.err.println("[ERROR] Execution failed during step run:");
	            e.printStackTrace();
	        }
	    }
	
	    
	    
	    
	    
	    

}
