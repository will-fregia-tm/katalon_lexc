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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import org.openqa.selenium.Cookie as Cookie
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.openBrowser(GlobalVariable.SSO_login, FailureHandling.STOP_ON_FAILURE)

cookieValue = findTestData('cookieValues').getValue(2, 1)

Cookie ck = new Cookie('ESTSAUTH', cookieValue)

WebDriver driver = DriverFactory.getWebDriver()

driver.manage().addCookie(ck)

domain = GlobalVariable.domain

'this step is added to handle legacy staging authentication'
if (WebUI.verifyMatch(domain, 'staging', false, FailureHandling.OPTIONAL)) {
    WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.legacyURL)
}

WebUI.navigateToUrl(GlobalVariable.SC_Domain + '/offers?zip=30303', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OffersPage/ZipBar/zip bar - 30303'), 0)

WebUI.click(findTestObject('OffersPage/FilterBar/filter bar'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/FilterBar/model-category - SUVs'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/FilterBar/model-category checkbox - All SUVs'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/FilterBar/apply button'), FailureHandling.STOP_ON_FAILURE)

'tests this offer row if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 02'), 3, FailureHandling.OPTIONAL)) {
    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 02 - Explore'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - Explore'), FailureHandling.STOP_ON_FAILURE)

    WebUI.back(FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip bar - 30303'), 0, FailureHandling.STOP_ON_FAILURE)

    rowModel = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - model name'), FailureHandling.STOP_ON_FAILURE)

    'removes HYBRID because model page title casing may differ'
    rowModel = (rowModel - ' HYBRID')

    absoluteLink = WebUI.getAttribute(findTestObject('OffersPage/OfferRow/row 02 - Explore'), 'href', FailureHandling.STOP_ON_FAILURE)

    'removes domain from URL in order to create a relative link'
    relativeLink = (absoluteLink - GlobalVariable.SC_Domain)

    WebUI.navigateToUrl('https://www.lexus.com' + relativeLink, FailureHandling.STOP_ON_FAILURE)

    modelPageTitle = WebUI.getWindowTitle(FailureHandling.STOP_ON_FAILURE)

    'model name at linked page should match offer row model name'
    textWithoutModel = (modelPageTitle - rowModel)

    WebUI.verifyNotMatch(modelPageTitle, textWithoutModel, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.back(FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip bar - 30303'), 0, FailureHandling.STOP_ON_FAILURE)

    'tests this offer row if it is present'
    if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 03'), 3, FailureHandling.OPTIONAL)) {
        WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 02'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 03 - Explore'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('OffersPage/OfferRow/row 03 - Explore'), FailureHandling.STOP_ON_FAILURE)

        WebUI.back(FailureHandling.STOP_ON_FAILURE)

        WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip bar - 30303'), 0, FailureHandling.STOP_ON_FAILURE)

        rowModel = WebUI.getText(findTestObject('OffersPage/OfferRow/row 03 - model name'), FailureHandling.STOP_ON_FAILURE)

        'removes HYBRID because model page title casing may differ'
        rowModel = (rowModel - ' HYBRID')

        absoluteLink = WebUI.getAttribute(findTestObject('OffersPage/OfferRow/row 03 - Explore'), 'href', FailureHandling.STOP_ON_FAILURE)

        'removes domain from URL in order to create a relative link'
        relativeLink = (absoluteLink - GlobalVariable.SC_Domain)

        WebUI.navigateToUrl('https://www.lexus.com' + relativeLink, FailureHandling.STOP_ON_FAILURE)

        modelPageTitle = WebUI.getWindowTitle(FailureHandling.STOP_ON_FAILURE)

        'model name at linked page should match offer row model name'
        textWithoutModel = (modelPageTitle - rowModel)

        WebUI.verifyNotMatch(modelPageTitle, textWithoutModel, false, FailureHandling.STOP_ON_FAILURE)

        WebUI.back(FailureHandling.STOP_ON_FAILURE)

        WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip bar - 30303'), 0, FailureHandling.STOP_ON_FAILURE)

        'tests this offer row if it is present'
        if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 04'), 3, FailureHandling.OPTIONAL)) {
            WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 03'), 0, FailureHandling.STOP_ON_FAILURE)

            WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 04 - Explore'), 0, FailureHandling.STOP_ON_FAILURE)

            WebUI.click(findTestObject('OffersPage/OfferRow/row 04 - Explore'), FailureHandling.STOP_ON_FAILURE)

            WebUI.back(FailureHandling.STOP_ON_FAILURE)

            WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip bar - 30303'), 0, FailureHandling.STOP_ON_FAILURE)

            rowModel = WebUI.getText(findTestObject('OffersPage/OfferRow/row 04 - model name'), FailureHandling.STOP_ON_FAILURE)

            'removes HYBRID because model page title casing may differ'
            rowModel = (rowModel - ' HYBRID')

            absoluteLink = WebUI.getAttribute(findTestObject('OffersPage/OfferRow/row 04 - Explore'), 'href', FailureHandling.STOP_ON_FAILURE)

            'removes domain from URL in order to create a relative link'
            relativeLink = (absoluteLink - GlobalVariable.SC_Domain)

            WebUI.navigateToUrl('https://www.lexus.com' + relativeLink, FailureHandling.STOP_ON_FAILURE)

            modelPageTitle = WebUI.getWindowTitle(FailureHandling.STOP_ON_FAILURE)

            'model name at linked page should match offer row model name'
            textWithoutModel = (modelPageTitle - rowModel)

            WebUI.verifyNotMatch(modelPageTitle, textWithoutModel, false, FailureHandling.STOP_ON_FAILURE)

            WebUI.back(FailureHandling.STOP_ON_FAILURE)

            WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip bar - 30303'), 0, FailureHandling.STOP_ON_FAILURE)

            'tests this offer row if it is present'
            if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 05'), 3, FailureHandling.OPTIONAL)) {
                WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 04'), 0, FailureHandling.STOP_ON_FAILURE)

                WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 05 - Explore'), 0, FailureHandling.STOP_ON_FAILURE)

                WebUI.click(findTestObject('OffersPage/OfferRow/row 05 - Explore'), FailureHandling.STOP_ON_FAILURE)

                WebUI.back(FailureHandling.STOP_ON_FAILURE)

                WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip bar - 30303'), 0, FailureHandling.STOP_ON_FAILURE)

                rowModel = WebUI.getText(findTestObject('OffersPage/OfferRow/row 05 - model name'), FailureHandling.STOP_ON_FAILURE)

                'removes HYBRID because model page title casing may differ'
                rowModel = (rowModel - ' HYBRID')

                absoluteLink = WebUI.getAttribute(findTestObject('OffersPage/OfferRow/row 05 - Explore'), 'href', FailureHandling.STOP_ON_FAILURE)

                'removes domain from URL in order to create a relative link'
                relativeLink = (absoluteLink - GlobalVariable.SC_Domain)

                WebUI.navigateToUrl('https://www.lexus.com' + relativeLink, FailureHandling.STOP_ON_FAILURE)

                modelPageTitle = WebUI.getWindowTitle(FailureHandling.STOP_ON_FAILURE)

                'model name at linked page should match offer row model name'
                textWithoutModel = (modelPageTitle - rowModel)

                WebUI.verifyNotMatch(modelPageTitle, textWithoutModel, false, FailureHandling.STOP_ON_FAILURE)

                WebUI.back(FailureHandling.STOP_ON_FAILURE)

                WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip bar - 30303'), 0, FailureHandling.STOP_ON_FAILURE)

                'tests this offer row if it is present'
                if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 06'), 3, FailureHandling.OPTIONAL)) {
                    WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 05'), 0, FailureHandling.STOP_ON_FAILURE)

                    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 06 - Explore'), 0, FailureHandling.STOP_ON_FAILURE)

                    WebUI.click(findTestObject('OffersPage/OfferRow/row 06 - Explore'), FailureHandling.STOP_ON_FAILURE)

                    WebUI.back(FailureHandling.STOP_ON_FAILURE)

                    WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip bar - 30303'), 0, FailureHandling.STOP_ON_FAILURE)

                    rowModel = WebUI.getText(findTestObject('OffersPage/OfferRow/row 06 - model name'), FailureHandling.STOP_ON_FAILURE)

                    'removes HYBRID because model page title casing may differ'
                    rowModel = (rowModel - ' HYBRID')

                    absoluteLink = WebUI.getAttribute(findTestObject('OffersPage/OfferRow/row 06 - Explore'), 'href', FailureHandling.STOP_ON_FAILURE)

                    'removes domain from URL in order to create a relative link'
                    relativeLink = (absoluteLink - GlobalVariable.SC_Domain)

                    WebUI.navigateToUrl('https://www.lexus.com' + relativeLink, FailureHandling.STOP_ON_FAILURE)

                    modelPageTitle = WebUI.getWindowTitle(FailureHandling.STOP_ON_FAILURE)

                    'model name at linked page should match offer row model name'
                    textWithoutModel = (modelPageTitle - rowModel)

                    WebUI.verifyNotMatch(modelPageTitle, textWithoutModel, false, FailureHandling.STOP_ON_FAILURE)

                    WebUI.back(FailureHandling.STOP_ON_FAILURE)

                    WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip bar - 30303'), 0, FailureHandling.STOP_ON_FAILURE)

                    'tests this offer row if it is present'
                    if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 07'), 3, FailureHandling.OPTIONAL)) {
                        WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 06'), 0, FailureHandling.STOP_ON_FAILURE)

                        WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 07 - Explore'), 0, FailureHandling.STOP_ON_FAILURE)

                        WebUI.click(findTestObject('OffersPage/OfferRow/row 07 - Explore'), FailureHandling.STOP_ON_FAILURE)

                        WebUI.back(FailureHandling.STOP_ON_FAILURE)

                        WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip bar - 30303'), 0, FailureHandling.STOP_ON_FAILURE)

                        rowModel = WebUI.getText(findTestObject('OffersPage/OfferRow/row 07 - model name'), FailureHandling.STOP_ON_FAILURE)

                        'removes HYBRID because model page title casing may differ'
                        rowModel = (rowModel - ' HYBRID')

                        absoluteLink = WebUI.getAttribute(findTestObject('OffersPage/OfferRow/row 07 - Explore'), 'href', 
                            FailureHandling.STOP_ON_FAILURE)

                        'removes domain from URL in order to create a relative link'
                        relativeLink = (absoluteLink - GlobalVariable.SC_Domain)

                        WebUI.navigateToUrl('https://www.lexus.com' + relativeLink, FailureHandling.STOP_ON_FAILURE)

                        modelPageTitle = WebUI.getWindowTitle(FailureHandling.STOP_ON_FAILURE)

                        'model name at linked page should match offer row model name'
                        textWithoutModel = (modelPageTitle - rowModel)

                        WebUI.verifyNotMatch(modelPageTitle, textWithoutModel, false, FailureHandling.STOP_ON_FAILURE)

                        WebUI.back(FailureHandling.STOP_ON_FAILURE)

                        WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip bar - 30303'), 0, FailureHandling.STOP_ON_FAILURE)

                        'tests this offer row if it is present'
                        if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 08'), 3, FailureHandling.OPTIONAL)) {
                            WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 07'), 0, FailureHandling.STOP_ON_FAILURE)

                            WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 08 - Explore'), 0, FailureHandling.STOP_ON_FAILURE)

                            WebUI.click(findTestObject('OffersPage/OfferRow/row 08 - Explore'), FailureHandling.STOP_ON_FAILURE)

                            WebUI.back(FailureHandling.STOP_ON_FAILURE)

                            WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip bar - 30303'), 0, FailureHandling.STOP_ON_FAILURE)

                            rowModel = WebUI.getText(findTestObject('OffersPage/OfferRow/row 08 - model name'), FailureHandling.STOP_ON_FAILURE)

                            'removes HYBRID because model page title casing may differ'
                            rowModel = (rowModel - ' HYBRID')

                            absoluteLink = WebUI.getAttribute(findTestObject('OffersPage/OfferRow/row 08 - Explore'), 'href', 
                                FailureHandling.STOP_ON_FAILURE)

                            'removes domain from URL in order to create a relative link'
                            relativeLink = (absoluteLink - GlobalVariable.SC_Domain)

                            WebUI.navigateToUrl('https://www.lexus.com' + relativeLink, FailureHandling.STOP_ON_FAILURE)

                            modelPageTitle = WebUI.getWindowTitle(FailureHandling.STOP_ON_FAILURE)

                            'model name at linked page should match offer row model name'
                            textWithoutModel = (modelPageTitle - rowModel)

                            WebUI.verifyNotMatch(modelPageTitle, textWithoutModel, false, FailureHandling.STOP_ON_FAILURE)

                            WebUI.back(FailureHandling.STOP_ON_FAILURE)

                            WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip bar - 30303'), 0, FailureHandling.STOP_ON_FAILURE)
                        }
                    }
                }
            }
        }
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

