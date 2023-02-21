package components;

import enums.Attribute;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.LoginPage;
import utils.WebDriverUtils;

import java.util.ArrayList;
import java.util.List;

import static colors.ColorsHex.*;
import static page.url.PageUrl.*;

public class PanelHeaderTest {
    private WebDriver driver;
    private PanelHeader panelHeader;
    private List<WebElement> headerPanelList;

    @BeforeClass
    public void setUp() {
        driver = WebDriverUtils.createWebDriver();
        panelHeader = new PanelHeader(driver);
        headerPanelList = panelHeader.getPanelHeaderList();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(HOMEPAGE_URL);
    }

    @Test
    public void panelHeader_SignInLink_NavigatesToLoginPage() {
        //when
        LoginPage loginPage = panelHeader.openLoginPage();

        //then
        Assertions.assertThat(driver.getCurrentUrl()).contains(LOGIN_PAGE_URL);
        Assertions.assertThat(loginPage.getPageTitle()).isEqualTo("Customer Login");
    }

    @Test
    public void panelHeader_CreateAccountLink_NavigatesToLoginPage() {
        //when
        CreateAccountPage createAccountPage = panelHeader.openCreateAccountPage();

        //then
        Assertions.assertThat(driver.getCurrentUrl()).contains(CREATE_AN_ACCOUNT_URL);
        Assertions.assertThat(createAccountPage.getPageTitle()).isEqualTo("Create New Customer Account");
    }

    @Test
    public void panelHeaderThisIsDemoSite_HasTextAndColorsCorrectlyDisplayed() {
        //then
        Assertions.assertThat(panelHeader.isThisIsDemoSiteSectionDisplayed()).isTrue();
        Assertions.assertThat(panelHeader.getThisIsDemoSiteSectionText()).isEqualTo("This is a demo store. No orders will be fulfilled.");
        Assertions.assertThat(panelHeader.getThisIsDemoSiteSectionFontAsHex()).isEqualTo(WHITE_COLOR);
        Assertions.assertThat(panelHeader.getThisIsDemoSiteSectionBackgroundAsHex()).isEqualTo(RED_COLOR);
    }

    @Test
    public void panelHeader_PageWrapperGreyBar_HasColorsAndTextCorrectlyDisplayed() {
        //then
        Assertions.assertThat(panelHeader.isPanelHeaderSectionDisplayed()).isTrue();
        Assertions.assertThat(panelHeader.getPanelHeaderSectionSectionFontAsHex()).isEqualTo(WHITE_COLOR);
        Assertions.assertThat(panelHeader.getPanelHeaderSectionBackgroundAsHex()).isEqualTo(DARK_GREY_COLOR);
        List<String> expectedNamesList = List.of("Sign In", "Create an Account");
        List<String> expectedLinkList = List.of(LOGIN_PAGE_URL, CREATE_AN_ACCOUNT_URL);
        validatePanelHeaderNamesAndLinks(headerPanelList, expectedNamesList, expectedLinkList);
    }

    @Test
    public void panelHeader_LumaLogo_HasLogoAndLinksCorrectlyDisplayed() {
        //then
        Assertions.assertThat(panelHeader.isLumaLogoDisplayed()).isTrue();
        Assertions.assertThat(panelHeader.getLumaLogoLink()).isEqualTo(HOMEPAGE_URL);
        Assertions.assertThat(panelHeader.getLumaLogoImageSource()).isEqualTo
                ("https://magento.softwaretestingboard.com/pub/static/version1666447838/frontend/Magento/luma/en_US/images/logo.svg");
    }

    @Test
    public void panelHeader_SearchAndCart_HasTextAndLinksCorrectlyDisplayed() {
        //then
        Assertions.assertThat(panelHeader.isSearchFieldDisplayed()).isTrue();
        Assertions.assertThat(panelHeader.getSearchFieldPlaceHolderText()).isEqualTo("Search entire store here...");
        Assertions.assertThat(panelHeader.getSearchCartLink()).isEqualTo(SHOPPING_CART_URL);
    }


    public void validatePanelHeaderNamesAndLinks(List<WebElement> headerPanelList, List<String> expectedPanelHeaderNamesList,
                                                 List<String> expectedCategoriesLinks) {

        List<String> actualCategoriesNames = new ArrayList<>();
        List<String> actualCategoriesLinks = new ArrayList<>();

        for (WebElement category : headerPanelList) {
            Assertions.assertThat(category.isDisplayed()).isTrue();
            actualCategoriesNames.add(category.getText());
            Assertions.assertThat(category.isEnabled()).isTrue();
            actualCategoriesLinks.add(category.getAttribute(Attribute.HREF.name()));
        }

        Assertions.assertThat(actualCategoriesNames).hasSameElementsAs(expectedPanelHeaderNamesList);
        Assertions.assertThat(actualCategoriesLinks).hasSameElementsAs(expectedCategoriesLinks);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
