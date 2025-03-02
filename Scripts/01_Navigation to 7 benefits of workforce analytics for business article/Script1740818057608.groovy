import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

int testLoop = GlobalVariable.testLoop

WebUI.openBrowser('')
// testLoop will determine how many instances the test will repeat
while (testLoop) {
    // Navigate to homepage
    WebUI.navigateToUrl('https://humanforce.com/')
    // Find and click on the Time and Attendance option
    WebUI.click(findTestObject('Object Repository/HF-Website/btnTimeAttendance'))
    // Check if present and close pop-up cookie (test browser doesn't save cache/cookie settings
	if (WebUI.verifyElementPresent(findTestObject('HF-Website/btnAcceptAll'), 1, FailureHandling.OPTIONAL))
	{
		WebUI.click(findTestObject('HF-Website/btnAcceptAll'))
	}
	else
	{
		WebUI.comment('Cookies already accepted!')
	}
	// Find and click 'Learn More' text link
    WebUI.click(findTestObject('HF-Website/textLearnMore'))
	// Find and click 'Learn More' text link
    WebUI.click(findTestObject('HF-Website/btn7Benefits'))
	// Get current URL and confirm if it matches the article's expected URL
    WebUI.verifyMatch(WebUI.getUrl(), 'https://humanforce.com/blog/7-benefits-of-workforce-analytics-for-business/', false)
	// Reduce testLoop by 1
	testLoop--
}
WebUI.closeBrowser()

