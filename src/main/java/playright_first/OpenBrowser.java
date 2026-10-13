package playright_first;

// Import Playwright classes required for browser automation
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class OpenBrowser {

	public static void main(String[] args) {
		// Initialize Playwright
		Playwright playwright = Playwright.create();

		// Launch Chromium with a visible browser window
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));

		// Create a new browser page
		Page page = browser.newPage();

		// Open the e-commerce website
		page.navigate("https://ecommerce-playground.lambdatest.io/index.php");

		// Locate the My Account menu
		Locator myAccount = page.locator("//a[contains(., 'My account') and @role='button']");

		// Hover over My Account to display its menu
		myAccount.hover();

		// Click the Login link
		page.locator("//a[contains(., 'Login')]").click();

		// Verify the login page title
		assertThat(page).hasTitle("Account Login");

		// Enter email address
		page.getByPlaceholder("E-Mail Address").fill("koushik350@gmail.com");

		// Enter password
		page.getByPlaceholder("Password").fill("Pass123$");

		// Click the Login button
		page.locator("//input[@value='Login']").click();

		// Close browser and release resources
		// browser.close();
		//playwright.close();
	}
}
