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
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import org.openqa.selenium.Cookie as Cookie
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.openBrowser(GlobalVariable.SSO_login, FailureHandling.OPTIONAL)

'these steps are added to handle lower environment authentication'
if (WebUI.verifyMatch(GlobalVariable.lowerEnvironment, 'yes', false, FailureHandling.OPTIONAL)) {
    cookieValue = findTestData('cookieValues').getValue(2, 1)

    Cookie ck = new Cookie('ESTSAUTH', cookieValue)

    WebDriver driver = DriverFactory.getWebDriver()

    driver.manage().addCookie(ck)

    WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.legacyURL)
}

WebUI.navigateToUrl(GlobalVariable.AEM_Domain)

'if the page renders slowly, it will be refreshed so the test can continue'
if (WebUI.verifyElementNotPresent(findTestObject('GlobalNav/header/header - Lexus logo'), 3, FailureHandling.OPTIONAL)) {
    WebUI.refresh()
}

WebUI.delay(2)

WebUI.waitForElementPresent(findTestObject('Homepage/QuickLinks/Quick Links'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/QuickLinks/Quick Links'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/DividerModule/divider 01'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/DividerModule/divider 02'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector heading'), 0, FailureHandling.OPTIONAL)

'if the vehicle selector renders slowly, page will be refreshed so the test can continue'
if (WebUI.verifyElementNotPresent(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 3, FailureHandling.OPTIONAL)) {
    WebUI.refresh()

    WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 0, FailureHandling.OPTIONAL)

    'if the vehicle selector renders slowly, page will be refreshed so the test can continue'
    if (WebUI.verifyElementNotPresent(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 3, FailureHandling.OPTIONAL)) {
        WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector heading'), 0, FailureHandling.OPTIONAL)
    }
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Sedans'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/IS'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/IS'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2)

    'chooses column with data for test environment'
    column = GlobalVariable.dataColumn

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 16)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'if color-swatch name has a disclaimer then the disclaimer icon will appear'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/price disclaimer'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/price disclaimer'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/GlobalMisc/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.getText(findTestObject('Homepage/GlobalMisc/disclaimer copy'), FailureHandling.STOP_ON_FAILURE)
    }
    
    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 16)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/ES'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/ES'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 9)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 9)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/ESh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/ESh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(3)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 12)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 12)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LS'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LS'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 44)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 44)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LSh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LSh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 48)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 48)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/SUVs'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/UX'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/UX'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 72)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'if color-swatch name has a disclaimer then the disclaimer icon will appear'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/price disclaimer'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/price disclaimer'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/GlobalMisc/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.getText(findTestObject('Homepage/GlobalMisc/disclaimer copy'), FailureHandling.STOP_ON_FAILURE)
    }
    
    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 72)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/UXh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/UXh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 74)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 74)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/NX'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/NX'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 34)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 34)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/NXh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/NXh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 40)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 40)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RX'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RX'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 54)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 54)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RXh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RXh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 60)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 60)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/GX'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/GX'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 28)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 28)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LX'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LX'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 31)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 31)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Coupes'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RC'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RC'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 1)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'if color-swatch name has a disclaimer then the disclaimer icon will appear'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/price disclaimer'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/price disclaimer'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/GlobalMisc/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.getText(findTestObject('Homepage/GlobalMisc/disclaimer copy'), FailureHandling.STOP_ON_FAILURE)
    }
    
    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 1)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RC F'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RC F'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 52)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 52)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 69)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 69)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 70)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 70)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 71)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 71)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Hybrids'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/UXh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/UXh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    'if color-swatch name has a disclaimer then the disclaimer icon will appear'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/price disclaimer'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/price disclaimer'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/GlobalMisc/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.getText(findTestObject('Homepage/GlobalMisc/disclaimer copy'), FailureHandling.STOP_ON_FAILURE)
    }
    
    expectedMSRP = findTestData('MSRP').getValue(column, 74)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 74)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/NXh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/NXh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 40)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 40)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RXh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RXh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 60)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 60)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/ESh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/ESh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 12)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 12)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LSh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LSh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 48)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 48)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 70)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 70)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Performance'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RC F'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RC F'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 52)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'if color-swatch name has a disclaimer then the disclaimer icon will appear'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/price disclaimer'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/price disclaimer'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/GlobalMisc/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.getText(findTestObject('Homepage/GlobalMisc/disclaimer copy'), FailureHandling.STOP_ON_FAILURE)
    }
    
    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 52)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 69)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 69)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 70)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 70)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    vehiclePrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle price'), FailureHandling.STOP_ON_FAILURE)

    expectedMSRP = findTestData('MSRP').getValue(column, 71)

    textWithoutExpectedMSRP = (vehiclePrice - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehiclePrice, false, FailureHandling.STOP_ON_FAILURE)

    'checks vehicle shown pricing if present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), 2, FailureHandling.OPTIONAL)) {
        vehicleShownPrice = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle shown pricing'), FailureHandling.STOP_ON_FAILURE)

        expectedMSRP = findTestData('MSRP').getValue(column + 5, 71)

        textWithoutExpectedMSRP = (vehicleShownPrice - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, vehicleShownPrice, false, FailureHandling.STOP_ON_FAILURE)
    }
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

