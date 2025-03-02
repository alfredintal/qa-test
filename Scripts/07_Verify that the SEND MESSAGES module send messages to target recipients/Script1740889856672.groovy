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
import com.kms.katalon.core.util.KeywordUtil

while (GlobalVariable.testLoop > 0) {
    WebUI.callTestCase(findTestCase('Reusable/Invoke'), [('url') : GlobalVariable.testUrl], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Reusable/Login'), [('testUser') : GlobalVariable.testUserAdmin, ('testPassword') : GlobalVariable.testPassword
            , ('helloText') : GlobalVariable.adminName], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('HF-App/Dashboard/btn_ViewMessages'))

	// On the create message module
	// Select EMP01
	// Set text to testMessage
    WebUI.click(findTestObject('HF-App/Messages/btn_New'))

    WebUI.click(findTestObject('HF-App/Messages/td_EMP01'))

    WebUI.click(findTestObject('HF-App/Messages/btn_Add'))

    WebUI.setText(findTestObject('HF-App/Messages/messageBox'), GlobalVariable.testMessage)

    WebUI.click(findTestObject('HF-App/Messages/btn_Send'))

	
	// Set text for the area to search the recipient's name, set text2 for the area to search for the message sent
	// Validate if text contains the name of the recipient (message list)
	// Validate if text2 contains the message string inputted on the previous modal
	// Send comment if verification passes or fails, if it fails throw an error
    def text = WebUI.getText(findTestObject('HF-App/Messages/firstMessage'))
    def text2 = WebUI.getText(findTestObject('HF-App/Messages/chatBox'))

    if (text.contains(GlobalVariable.employeeName) && text2.contains(GlobalVariable.testMessage)) {
        WebUI.comment('The created message was found!')
    } else {
        KeywordUtil.markFailedAndStop("No message or recipient was found")
    }
    
    WebUI.closeBrowser()

    (GlobalVariable.testLoop)--
}

