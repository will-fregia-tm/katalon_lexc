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

'runs these tests on sales event version of page'
if (WebUI.verifyElementPresent(findTestObject('Homepage/HeroOffers/offer cards row'), 5, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Sedans'), FailureHandling.STOP_ON_FAILURE)

    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/IS'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/IS'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2)

        WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/offers/offers module title'), 0, FailureHandling.OPTIONAL)

        String browser = DriverFactory.getWebDriver().getCapabilities().getBrowserName()

        println(browser)

        'checks hover states, with workaround for the firefox driver not being able to mouseOver'
        if (WebUI.verifyNotMatch(browser, 'firefox', false, FailureHandling.OPTIONAL)) {
            noHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'backgroundColor')

            WebUI.mouseOver(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1)

            yesHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'backgroundColor')

            'verifies updated FAD CTA hover state'
            WebUI.verifyNotMatch(noHover, yesHover, false)

            noHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'backgroundColor')

            WebUI.mouseOver(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1)

            yesHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'backgroundColor')

            'verifies updated offers CTA hover state'
            WebUI.verifyNotMatch(noHover, yesHover, false)
        }
        
        vehicleName = findTestData('MSRP').getValue(11, 16)

        dealersTarget = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'target')

        'navigates the user within the same tab'
        WebUI.verifyMatch(dealersTarget, '_self', false, FailureHandling.STOP_ON_FAILURE)

        dealersURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'href')

        dealersURL = (((dealersURL - GlobalVariable.AEM_Domain) - 'https://aem-author.toyota.com') - 'https://stage-aem.author.toyota.com')

        'verifies that CTA href is correct'
        WebUI.verifyMatch(dealersURL, '/dealers', false, FailureHandling.STOP_ON_FAILURE)

        offersTarget = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'target')

        'navigates the user within the same tab'
        WebUI.verifyMatch(offersTarget, '_self', false, FailureHandling.STOP_ON_FAILURE)

        offersURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'href')

        offersURL = ((((offersURL - GlobalVariable.AEM_Domain) - 'https://aem-author.toyota.com') - 'https://stage-aem.author.toyota.com') - 
        vehicleName)

        'verifies that CTA href is correct for this model'
        WebUI.verifyMatch(offersURL, '/models//offers', false, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'))

        WebUI.waitForPageLoad(0)

        'checks for cookied ZIP if one was previously set'
        if (WebUI.verifyMatch(cookiedZIP, 'yes', false, FailureHandling.OPTIONAL)) {
            'will only be checked on prod to avoid missing pages'
            if (WebUI.verifyMatch(GlobalVariable.domain, 'prod', false, FailureHandling.OPTIONAL)) {
                WebUI.delay(5)

                'if users location is known, cookies should be passed along to model page'
                WebUI.verifyTextPresent('SEWELL', false, FailureHandling.STOP_ON_FAILURE)

                'if users location is known, cookies should be passed along to model page'
                WebUI.verifyTextPresent('75209', false, FailureHandling.STOP_ON_FAILURE)
            }
        }
        
        not_run: WebUI.back()

        WebUI.navigateToUrl(GlobalVariable.AEM_Domain)

        WebUI.waitForElementPresent(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2)

        WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2)

        WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/offers/offers module title'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'))

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
    }
    
    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LSh'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LSh'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1)

        WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/offers/offers module title'), 0, FailureHandling.OPTIONAL)

        String browser = DriverFactory.getWebDriver().getCapabilities().getBrowserName()

        println(browser)

        'checks hover states, with workaround for the firefox driver not being able to mouseOver'
        if (WebUI.verifyNotMatch(browser, 'firefox', false, FailureHandling.OPTIONAL)) {
            noHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'backgroundColor')

            WebUI.mouseOver(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1)

            yesHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'backgroundColor')

            'verifies updated FAD CTA hover state'
            WebUI.verifyNotMatch(noHover, yesHover, false)

            noHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'backgroundColor')

            WebUI.mouseOver(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1)

            yesHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'backgroundColor')

            'verifies updated offers CTA hover state'
            WebUI.verifyNotMatch(noHover, yesHover, false)
        }
        
        vehicleName = findTestData('MSRP').getValue(11, 48)

        dealersTarget = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'target')

        'navigates the user within the same tab'
        WebUI.verifyMatch(dealersTarget, '_self', false, FailureHandling.STOP_ON_FAILURE)

        dealersURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'href')

        dealersURL = (((dealersURL - GlobalVariable.AEM_Domain) - 'https://aem-author.toyota.com') - 'https://stage-aem.author.toyota.com')

        'verifies that CTA href is correct'
        WebUI.verifyMatch(dealersURL, '/dealers', false, FailureHandling.STOP_ON_FAILURE)

        offersTarget = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'target')

        'navigates the user within the same tab'
        WebUI.verifyMatch(offersTarget, '_self', false, FailureHandling.STOP_ON_FAILURE)

        offersURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'href')

        offersURL = ((((offersURL - GlobalVariable.AEM_Domain) - 'https://aem-author.toyota.com') - 'https://stage-aem.author.toyota.com') - vehicleName)

        'verifies that CTA href is correct for this model'
        WebUI.verifyMatch(offersURL, '/models//offers', false, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'))

        WebUI.waitForPageLoad(0)

        'checks for cookied ZIP if one was previously set'
        if (WebUI.verifyMatch(cookiedZIP, 'yes', false, FailureHandling.OPTIONAL)) {
            'will only be checked on prod to avoid missing pages'
            if (WebUI.verifyMatch(GlobalVariable.domain, 'prod', false, FailureHandling.OPTIONAL)) {
                WebUI.delay(5)

                'if users location is known, cookies should be passed along to model page'
                WebUI.verifyTextPresent('SEWELL', false, FailureHandling.STOP_ON_FAILURE)

                'if users location is known, cookies should be passed along to model page'
                WebUI.verifyTextPresent('75209', false, FailureHandling.STOP_ON_FAILURE)
            }
        }
        
        WebUI.back()

        WebUI.waitForElementPresent(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/offers/offers module title'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'))

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
    }
    
    WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/SUVs'), FailureHandling.STOP_ON_FAILURE)

    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LX'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LX'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1)

        WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/offers/offers module title'), 0, FailureHandling.OPTIONAL)

        String browser = DriverFactory.getWebDriver().getCapabilities().getBrowserName()

        println(browser)

        'checks hover states, with workaround for the firefox driver not being able to mouseOver'
        if (WebUI.verifyNotMatch(browser, 'firefox', false, FailureHandling.OPTIONAL)) {
            noHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'backgroundColor')

            WebUI.mouseOver(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1)

            yesHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'backgroundColor')

            'verifies updated FAD CTA hover state'
            WebUI.verifyNotMatch(noHover, yesHover, false)

            noHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'backgroundColor')

            WebUI.mouseOver(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1)

            yesHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'backgroundColor')

            'verifies updated offers CTA hover state'
            WebUI.verifyNotMatch(noHover, yesHover, false)
        }
        
        vehicleName = findTestData('MSRP').getValue(11, 31)

        dealersTarget = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'target')

        'navigates the user within the same tab'
        WebUI.verifyMatch(dealersTarget, '_self', false, FailureHandling.STOP_ON_FAILURE)

        dealersURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'href')

        dealersURL = (((dealersURL - GlobalVariable.AEM_Domain) - 'https://aem-author.toyota.com') - 'https://stage-aem.author.toyota.com')

        'verifies that CTA href is correct'
        WebUI.verifyMatch(dealersURL, '/dealers', false, FailureHandling.STOP_ON_FAILURE)

        offersTarget = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'target')

        'navigates the user within the same tab'
        WebUI.verifyMatch(offersTarget, '_self', false, FailureHandling.STOP_ON_FAILURE)

        offersURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'href')

        offersURL = (((((offersURL - GlobalVariable.AEM_Domain) - 'https://aem-author.toyota.com') - 'https://stage-aem.author.toyota.com') - vehicleName) - 'lx')

        'verifies that CTA href is correct for this model'
        WebUI.verifyMatch(offersURL, '/models//offers', false, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'))

        WebUI.waitForPageLoad(0)

        'checks for cookied ZIP if one was previously set'
        if (WebUI.verifyMatch(cookiedZIP, 'yes', false, FailureHandling.OPTIONAL)) {
            'will only be checked on prod to avoid missing pages'
            if (WebUI.verifyMatch(GlobalVariable.domain, 'prod', false, FailureHandling.OPTIONAL)) {
                WebUI.delay(5)

                'if users location is known, cookies should be passed along to model page'
                WebUI.verifyTextPresent('SEWELL', false, FailureHandling.STOP_ON_FAILURE)

                'if users location is known, cookies should be passed along to model page'
                WebUI.verifyTextPresent('75209', false, FailureHandling.STOP_ON_FAILURE)
            }
        }
        
        WebUI.back()

        WebUI.waitForElementPresent(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/offers/offers module title'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'))

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
    }
    
    WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Coupes'), FailureHandling.STOP_ON_FAILURE)

    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1)

        WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/offers/offers module title'), 0, FailureHandling.OPTIONAL)

        String browser = DriverFactory.getWebDriver().getCapabilities().getBrowserName()

        println(browser)

        'checks hover states, with workaround for the firefox driver not being able to mouseOver'
        if (WebUI.verifyNotMatch(browser, 'firefox', false, FailureHandling.OPTIONAL)) {
            noHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'backgroundColor')

            WebUI.mouseOver(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1)

            yesHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'backgroundColor')

            'verifies updated FAD CTA hover state'
            WebUI.verifyNotMatch(noHover, yesHover, false)

            noHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'backgroundColor')

            WebUI.mouseOver(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1)

            yesHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'backgroundColor')

            'verifies updated offers CTA hover state'
            WebUI.verifyNotMatch(noHover, yesHover, false)
        }
        
        vehicleName = findTestData('MSRP').getValue(11, 71)

        dealersTarget = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'target')

        'navigates the user within the same tab'
        WebUI.verifyMatch(dealersTarget, '_self', false, FailureHandling.STOP_ON_FAILURE)

        dealersURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'href')

        dealersURL = (((dealersURL - GlobalVariable.AEM_Domain) - 'https://aem-author.toyota.com') - 'https://stage-aem.author.toyota.com')

        'verifies that CTA href is correct'
        WebUI.verifyMatch(dealersURL, '/dealers', false, FailureHandling.STOP_ON_FAILURE)

        offersTarget = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'target')

        'navigates the user within the same tab'
        WebUI.verifyMatch(offersTarget, '_self', false, FailureHandling.STOP_ON_FAILURE)

        offersURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'href')

        offersURL = ((((((offersURL - GlobalVariable.AEM_Domain) - 'https://aem-author.toyota.com') - 'https://stage-aem.author.toyota.com') - vehicleName) - 'LCC') - 'lc-convertible')

        'verifies that CTA href is correct for this model'
        WebUI.verifyMatch(offersURL, '/models//offers', false, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'))

        WebUI.waitForPageLoad(0)

        'checks for cookied ZIP if one was previously set'
        if (WebUI.verifyMatch(cookiedZIP, 'yes', false, FailureHandling.OPTIONAL)) {
            'will only be checked on prod to avoid missing pages'
            if (WebUI.verifyMatch(GlobalVariable.domain, 'prod', false, FailureHandling.OPTIONAL)) {
                WebUI.delay(5)

                'if users location is known, cookies should be passed along to model page'
                WebUI.verifyTextPresent('SEWELL', false, FailureHandling.STOP_ON_FAILURE)

                'if users location is known, cookies should be passed along to model page'
                WebUI.verifyTextPresent('75209', false, FailureHandling.STOP_ON_FAILURE)
            }
        }
        
        WebUI.back()

        WebUI.waitForElementPresent(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/offers/offers module title'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'))

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
    }
    
    WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Hybrids'), FailureHandling.STOP_ON_FAILURE)

    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/UXh'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/UXh'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1)

        WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/offers/offers module title'), 0, FailureHandling.OPTIONAL)

        String browser = DriverFactory.getWebDriver().getCapabilities().getBrowserName()

        println(browser)

        'checks hover states, with workaround for the firefox driver not being able to mouseOver'
        if (WebUI.verifyNotMatch(browser, 'firefox', false, FailureHandling.OPTIONAL)) {
            noHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'backgroundColor')

            WebUI.mouseOver(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1)

            yesHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'backgroundColor')

            'verifies updated FAD CTA hover state'
            WebUI.verifyNotMatch(noHover, yesHover, false)

            noHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'backgroundColor')

            WebUI.mouseOver(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1)

            yesHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'backgroundColor')

            'verifies updated offers CTA hover state'
            WebUI.verifyNotMatch(noHover, yesHover, false)
        }
        
        vehicleName = findTestData('MSRP').getValue(11, 74)

        dealersTarget = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'target')

        'navigates the user within the same tab'
        WebUI.verifyMatch(dealersTarget, '_self', false, FailureHandling.STOP_ON_FAILURE)

        dealersURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'href')

        dealersURL = (((dealersURL - GlobalVariable.AEM_Domain) - 'https://aem-author.toyota.com') - 'https://stage-aem.author.toyota.com')

        'verifies that CTA href is correct'
        WebUI.verifyMatch(dealersURL, '/dealers', false, FailureHandling.STOP_ON_FAILURE)

        offersTarget = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'target')

        'navigates the user within the same tab'
        WebUI.verifyMatch(offersTarget, '_self', false, FailureHandling.STOP_ON_FAILURE)

        offersURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'href')

        offersURL = (((((offersURL - GlobalVariable.AEM_Domain) - 'https://aem-author.toyota.com') - 'https://stage-aem.author.toyota.com') - vehicleName) - 'UXh')

        'verifies that CTA href is correct for this model'
        WebUI.verifyMatch(offersURL, '/models//offers', false, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'))

        WebUI.waitForPageLoad(0)

        'checks for cookied ZIP if one was previously set'
        if (WebUI.verifyMatch(cookiedZIP, 'yes', false, FailureHandling.OPTIONAL)) {
            'will only be checked on prod to avoid missing pages'
            if (WebUI.verifyMatch(GlobalVariable.domain, 'prod', false, FailureHandling.OPTIONAL)) {
                WebUI.delay(5)

                'if users location is known, cookies should be passed along to model page'
                WebUI.verifyTextPresent('SEWELL', false, FailureHandling.STOP_ON_FAILURE)

                'if users location is known, cookies should be passed along to model page'
                WebUI.verifyTextPresent('75209', false, FailureHandling.STOP_ON_FAILURE)
            }
        }
        
        WebUI.back()

        WebUI.waitForElementPresent(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/offers/offers module title'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'))

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
    }
    
    WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Performance'), FailureHandling.STOP_ON_FAILURE)

    'clicks this model if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RC F'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RC F'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1)

        WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/offers/offers module title'), 0, FailureHandling.OPTIONAL)

        String browser = DriverFactory.getWebDriver().getCapabilities().getBrowserName()

        println(browser)

        'checks hover states, with workaround for the firefox driver not being able to mouseOver'
        if (WebUI.verifyNotMatch(browser, 'firefox', false, FailureHandling.OPTIONAL)) {
            noHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'backgroundColor')

            WebUI.mouseOver(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1)

            yesHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'backgroundColor')

            'verifies updated FAD CTA hover state'
            WebUI.verifyNotMatch(noHover, yesHover, false)

            noHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'backgroundColor')

            WebUI.mouseOver(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1)

            yesHover = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'backgroundColor')

            'verifies updated offers CTA hover state'
            WebUI.verifyNotMatch(noHover, yesHover, false)
        }
        
        vehicleName = findTestData('MSRP').getValue(11, 52)

        dealersTarget = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'target')

        'navigates the user within the same tab'
        WebUI.verifyMatch(dealersTarget, '_self', false, FailureHandling.STOP_ON_FAILURE)

        dealersURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'), 'href')

        dealersURL = (((dealersURL - GlobalVariable.AEM_Domain) - 'https://aem-author.toyota.com') - 'https://stage-aem.author.toyota.com')

        'verifies that CTA href is correct'
        WebUI.verifyMatch(dealersURL, '/dealers', false, FailureHandling.STOP_ON_FAILURE)

        offersTarget = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'target')

        'navigates the user within the same tab'
        WebUI.verifyMatch(offersTarget, '_self', false, FailureHandling.STOP_ON_FAILURE)

        offersURL = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'), 'href')

        offersURL = (((((offersURL - GlobalVariable.AEM_Domain) - 'https://aem-author.toyota.com') - 'https://stage-aem.author.toyota.com') - vehicleName) - 'rcf')

        'verifies that CTA href is correct for this model'
        WebUI.verifyMatch(offersURL, '/models//offers', false, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - FAD'))

        WebUI.waitForPageLoad(0)

        'checks for cookied ZIP if one was previously set'
        if (WebUI.verifyMatch(cookiedZIP, 'yes', false, FailureHandling.OPTIONAL)) {
            'will only be checked on prod to avoid missing pages'
            if (WebUI.verifyMatch(GlobalVariable.domain, 'prod', false, FailureHandling.OPTIONAL)) {
                WebUI.delay(5)

                'if users location is known, cookies should be passed along to model page'
                WebUI.verifyTextPresent('SEWELL', false, FailureHandling.STOP_ON_FAILURE)

                'if users location is known, cookies should be passed along to model page'
                WebUI.verifyTextPresent('75209', false, FailureHandling.STOP_ON_FAILURE)
            }
        }
        
        WebUI.back()

        WebUI.waitForElementPresent(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/offers/offers module title'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/offers/CTA - View Offers'))

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

