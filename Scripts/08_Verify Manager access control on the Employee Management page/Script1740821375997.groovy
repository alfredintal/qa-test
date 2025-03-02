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

while (GlobalVariable.testLoop > 0) {
    WebUI.callTestCase(findTestCase('Reusable/Invoke'), [('url') : GlobalVariable.testUrl], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Reusable/Login'), [('testUser') : GlobalVariable.testUserManager, ('testPassword') : GlobalVariable.testPassword
            , ('helloText') : GlobalVariable.managerName], FailureHandling.STOP_ON_FAILURE)
	
	// Navigate to the Employee Management page
    WebUI.navigateToUrl(GlobalVariable.testUrl + testUrlSlug)
	
	// Select MG01, click on the edit button
    WebUI.click(findTestObject('HF-App/EmployeeManagement/td_MGR01'))
    WebUI.click(findTestObject('HF-App/EmployeeManagement/btn_Edit_EM'))

	// Confirm that a warning/blocker message is shown that the user has no edit permissions
    WebUI.verifyTextPresent(GlobalVariable.noEditPermText, false)

    WebUI.closeBrowser()

    (GlobalVariable.testLoop)--
}

