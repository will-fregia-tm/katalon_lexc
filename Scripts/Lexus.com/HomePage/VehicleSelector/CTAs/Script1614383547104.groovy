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

cookiedZIP = 'no'

'sets ZIP code cookie if possible'
if (WebUI.verifyElementPresent(findTestObject('Homepage/HeroOffers/zip code field'), 5, FailureHandling.OPTIONAL)) {
    WebUI.scrollToPosition(0, 350)

    WebUI.click(findTestObject('Homepage/HeroOffers/zip code field'))

    WebUI.setText(findTestObject('Homepage/HeroOffers/zip code field'), '75218')

    WebUI.click(findTestObject('Homepage/HeroOffers/submit button'))

    cookiedZIP = 'yes'

    WebUI.waitForElementPresent(findTestObject('Homepage/HeroOffers/offer cards row - mobile'), 5, FailureHandling.OPTIONAL)
}

WebUI.waitForElementPresent(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Sedans'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/IS'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/IS'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2)

    String browser = DriverFactory.getWebDriver().getCapabilities().getBrowserName()

    println(browser)

    'checks hover states, with workaround for the firefox driver not being able to mouseOver'
    if (WebUI.verifyNotMatch(browser, 'firefox', false, FailureHandling.OPTIONAL)) {
        noHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'backgroundColor')

        WebUI.mouseOver(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1)

        yesHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'backgroundColor')

        'verifies updated Explore CTA hover state'
        WebUI.verifyNotMatch(noHover, yesHover, false)

        noHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'backgroundColor')

        WebUI.mouseOver(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1)

        yesHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'backgroundColor')

        'verifies updated Build CTA hover state'
        WebUI.verifyNotMatch(noHover, yesHover, false)

        noHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'border-top-color', FailureHandling.STOP_ON_FAILURE)

        WebUI.mouseOver(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

        yesHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'border-top-color', FailureHandling.STOP_ON_FAILURE)

        'verifies updated swatch hover state'
        WebUI.verifyNotMatch(noHover, yesHover, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 16)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 16)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'))

    WebUI.waitForPageLoad(0)

    'checks for cookied ZIP if one was previously set'
    if (WebUI.verifyMatch(cookiedZIP, 'yes', false, FailureHandling.OPTIONAL)) {
        'will only be checked on prod to avoid missing pages'
        if (WebUI.verifyMatch(GlobalVariable.domain, 'prod', false, FailureHandling.OPTIONAL)) {
            WebUI.click(findTestObject('GlobalNav/model offers section link'), FailureHandling.OPTIONAL)

            WebUI.delay(5)

            'if users location is known, cookies should be passed along to model page'
            WebUI.verifyTextPresent('75218', false, FailureHandling.STOP_ON_FAILURE)
        }
    }
    
    not_run: WebUI.back()

    WebUI.navigateToUrl(GlobalVariable.AEM_Domain)

    WebUI.waitForElementPresent(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 0, FailureHandling.OPTIONAL)

    WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'))

    WebUI.waitForPageLoad(0)

    'checks for cookied ZIP if one was previously set'
    if (WebUI.verifyMatch(cookiedZIP, 'yes', false, FailureHandling.OPTIONAL)) {
        'will only be checked on prod to avoid missing pages'
        if (WebUI.verifyMatch(GlobalVariable.domain, 'prod', false, FailureHandling.OPTIONAL)) {
            WebUI.delay(6)

            'if users location is known, cookies should be passed along to model page'
            WebUI.verifyTextPresent('75218', false, FailureHandling.STOP_ON_FAILURE)
        }
    }
    
    not_run: WebUI.back()

    WebUI.navigateToUrl(GlobalVariable.AEM_Domain)

    WebUI.waitForElementPresent(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 0, FailureHandling.OPTIONAL)

    WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 0, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/ES'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/ES'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 9)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 9)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    not_run: buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    not_run: WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/ESh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/ESh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 12)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 12)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LS'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LS'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 44)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 44)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LSh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LSh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 48)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 48)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/SUVs'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/UX'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/UX'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 72)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 72)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/UXh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/UXh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 74)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 74)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/NX'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/NX'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 34)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 34)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/NXh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/NXh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 40)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 40)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RX'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RX'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 54)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 54)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RXh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RXh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 60)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 60)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/GX'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/GX'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 28)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 28)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LX'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LX'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 31)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 31)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Coupes'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RC'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RC'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 1)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 1)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RC F'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RC F'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 52)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 52)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 69)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 69)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 70)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 70)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 71)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 71)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Hybrids'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/UXh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/UXh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 74)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 74)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/NXh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/NXh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 40)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 40)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RXh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RXh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 60)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 60)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/ESh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/ESh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 12)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 12)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LSh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LSh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 48)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 48)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 70)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 70)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Performance'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RC F'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RC F'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 52)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 52)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 69)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 69)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LCh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 70)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 70)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    exploreURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Explore'), 'href')

    vehicleName = findTestData('MSRP').getValue(11, 71)

    exploreURL = ((((exploreURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com' - 'https://aem-author.toyota.com')) - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(exploreURL, '/models/', false, FailureHandling.STOP_ON_FAILURE)

    vehicleName = findTestData('MSRP').getValue(12, 71)

    buildURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/CTA - Build'), 'href')

    buildURL = ((((buildURL - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com') - 'https://aem-author.toyota.com') - vehicleName)

    'verifies that CTA href is correct for this model'
    WebUI.verifyMatch(buildURL, '/build-your-lexus/#!/series/', false, FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

