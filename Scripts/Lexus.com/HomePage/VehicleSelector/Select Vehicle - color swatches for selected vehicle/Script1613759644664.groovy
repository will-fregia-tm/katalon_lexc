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

WebUI.waitForElementPresent(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Sedans'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/IS'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/IS'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2)

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/ES'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/ES'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/ESh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/ESh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    not_run: WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LS'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LS'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LSh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LSh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    not_run: WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/SUVs'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/UX'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/UX'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/UXh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/UXh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    fifthColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 5'), 'src')

    'creates a partial list of current swatches'
    swatches = ((defaultColor + secondColor) + fifthColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    not_run: WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/NX'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/NX'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    fifthColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 5'), 'src')

    'creates a partial list of current swatches'
    swatches = ((defaultColor + secondColor) + fifthColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/NXh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/NXh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    fifthColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 5'), 'src')

    'creates a partial list of current swatches'
    swatches = ((defaultColor + secondColor) + fifthColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    not_run: WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RX'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RX'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    fifthColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 5'), 'src')

    'creates a partial list of current swatches'
    swatches = ((defaultColor + secondColor) + fifthColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RXh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RXh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    not_run: WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/GX'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/GX'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LX'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LX'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Coupes'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RC'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RC'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    not_run: WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RC F'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RC F'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    not_run: WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    not_run: WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Hybrids'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/UXh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/UXh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/NXh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/NXh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    not_run: WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RXh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RXh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    not_run: WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/ESh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/ESh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LSh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LSh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    not_run: WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    not_run: WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Performance'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RC F'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RC F'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    not_run: WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    previousSwatches = swatches

    selectedSwatch = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'src')

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/current swatch'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    defaultColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src')

    'verifies that the default color selection is selected'
    WebUI.verifyMatch(defaultColor, selectedSwatch, false, FailureHandling.STOP_ON_FAILURE)

    secondColor = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src')

    'creates a partial list of current swatches'
    swatches = (defaultColor + secondColor)

    'verifies that swatches have updated since the previous vehicle (disabled for hybrid and convertible trims which match preceding gas trims)'
    not_run: WebUI.verifyNotMatch(swatches, previousSwatches, false, FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

