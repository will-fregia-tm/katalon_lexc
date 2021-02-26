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

'these steps will be run for the legacy version of the page'
if (WebUI.verifyMatch(GlobalVariable.legacy, 'yes', false, FailureHandling.OPTIONAL)) {
    WebUI.navigateToUrl(GlobalVariable.SC_Domain)

    WebUI.navigateToUrl(GlobalVariable.SC_Domain_Unauthenticated)

    'if the page renders slowly, it will be refreshed so the test can continue'
    if (WebUI.verifyElementNotPresent(findTestObject('GlobalNav/header/header - Lexus logo'), 3, FailureHandling.OPTIONAL)) {
        WebUI.refresh()
    }
    
    WebUI.waitForElementPresent(findTestObject('HomePage/VehicleSelector/vehicle selector - heading'), 0)

    WebUI.scrollToElement(findTestObject('HomePage/VehicleSelector/vehicle selector - heading'), 0)

    WebUI.click(findTestObject('HomePage/VehicleSelector/categories/Sedans'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementVisible(findTestObject('HomePage/VehicleSelector/models/Sedans - IS'), 0)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/Sedans - IS'))

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - IS starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/Sedans - ES'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - ES starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/Sedans - ESh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - ESh starting at price'), 
        0, FailureHandling.OPTIONAL)

    not_run: WebUI.click(findTestObject('HomePage/VehicleSelector/models/Sedans - GS'))

    not_run: WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - GS starting at price'), 
        0, FailureHandling.OPTIONAL)

    not_run: WebUI.click(findTestObject('HomePage/VehicleSelector/models/Sedans - GS F'))

    not_run: WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - GS F starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/Sedans - LS'))

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - LS starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/Sedans - LSh'), FailureHandling.OPTIONAL)

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - LSh starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/categories/SUVs'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementVisible(findTestObject('HomePage/VehicleSelector/models/SUVs - UX'), 0)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - UX'))

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - UX starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - UXh'))

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - UXh starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - NX'))

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - NX starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - NXh'))

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - NXh starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - RX'))

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - RX starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - RXh'))

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - RXh starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - GX'))

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - GX starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - LX'), FailureHandling.OPTIONAL)

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - LX starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/categories/Coupes'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementVisible(findTestObject('HomePage/VehicleSelector/models/Coupes - RC'), 0)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/Coupes - RC'))

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - RC starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/Coupes - RC F'))

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - RC F starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/Coupes - LC'))

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - LC starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/Coupes - LCh'))

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - LCh starting at price'), 
        0, FailureHandling.OPTIONAL)

    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelector/models/Coupes - LC C'), 0, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelector/models/Coupes - LC C'))

        WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - LC C starting at price'), 
            0, FailureHandling.OPTIONAL)
    }
    
    WebUI.click(findTestObject('HomePage/VehicleSelector/categories/Hybrids'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementVisible(findTestObject('HomePage/VehicleSelector/models/Hybrids - UXh'), 0)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/Hybrids - UXh'))

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - UXh starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/Hybrids - NXh'))

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - NXh starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/Hybrids - RXh'))

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - RXh starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/Hybrids - ESh'), FailureHandling.OPTIONAL)

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - ESh starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/Hybrids - LSh'), FailureHandling.OPTIONAL)

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - LSh starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/Hybrids - LCh'))

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - LCh starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/categories/Performance'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementVisible(findTestObject('HomePage/VehicleSelector/models/Performance - RC F'), 0)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/Performance - RC F'))

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - RC F starting at price'), 
        0, FailureHandling.OPTIONAL)

    not_run: WebUI.click(findTestObject('HomePage/VehicleSelector/models/Performance - GS F'))

    not_run: WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - GS F starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/Performance - LC'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - LC starting at price'), 
        0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('HomePage/VehicleSelector/models/Performance - LCh'))

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - LCh starting at price'), 
        0, FailureHandling.OPTIONAL)

    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelector/models/Performance - LC C'), 0, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelector/models/Performance - LC C'))

        WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - LC C starting at price'), 
            0, FailureHandling.OPTIONAL)
    }
}

'these steps will be run for the non-legacy version of the page'
if (WebUI.verifyMatch(GlobalVariable.legacy, 'no', false, FailureHandling.OPTIONAL)) {
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

        WebUI.delay(3)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'IS', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/ES'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/ES'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(3)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'ES', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/ESh'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/ESh'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(3)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'ES HYBRID', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LS'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LS'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(3)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'LS', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LSh'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LSh'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(3)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'LS HYBRID', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/SUVs'), FailureHandling.STOP_ON_FAILURE)

    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/UX'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/UX'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(3)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'UX', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/UXh'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/UXh'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(4)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'UX HYBRID', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/NX'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/NX'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(4)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'NX', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/NXh'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/NXh'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(5)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'NX HYBRID', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RX'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RX'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(3)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'RX', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RXh'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RXh'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(4)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'RX HYBRID', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/GX'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/GX'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(4)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'GX', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LX'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LX'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(3)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'LX', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Coupes'), FailureHandling.STOP_ON_FAILURE)

    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RC'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RC'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(3)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'RC', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RC F'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RC F'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(3)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'RC F', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(3)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'LC', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(3)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'LC HYBRID', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(3)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'LC CONVERTIBLE', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Hybrids'), FailureHandling.STOP_ON_FAILURE)

    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/UXh'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/UXh'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(3)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'UX HYBRID', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/NXh'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/NXh'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(3)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'NX HYBRID', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RXh'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RXh'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(4)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'RX HYBRID', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/ESh'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/ESh'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(3)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'ES HYBRID', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LSh'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LSh'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(3)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'LS HYBRID', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(3)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'LC HYBRID', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Performance'), FailureHandling.STOP_ON_FAILURE)

    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RC F'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RC F'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(3)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'RC F', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(3)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'LC', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(4)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'LC HYBRID', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(4)

        selectedModel = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, 'LC CONVERTIBLE', false)

        vehicleName = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle name'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(selectedModel, vehicleName, false)

        previousImage = vehicleImage

        vehicleImage = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

        'if vehicle image has updated, its src should not match the previous value'
        WebUI.verifyNotMatch(vehicleImage, previousImage, false, FailureHandling.STOP_ON_FAILURE)
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

