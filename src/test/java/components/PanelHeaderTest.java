package components;

import enums.Attribute;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
        driver.get(HOMEPAGE_URL);
        panelHeader = new PanelHeader(driver);
        headerPanelList = panelHeader.getPanelHeaderList();
    }

    @Test
    public void panelHeader_TopDemoInfoBanner_HasTextAndColorsCorrectlyDisplayed() {
        //then
        Assertions.assertThat(panelHeader.isTopDemoInfoBannerDisplayed()).isTrue();
        Assertions.assertThat(panelHeader.getTopDemoInfoBannerText()).isEqualTo("This is a demo store. No orders will be fulfilled.");
        Assertions.assertThat(panelHeader.getTopDemoInfoBannerFontAsHex()).isEqualTo(WHITE_COLOR);
        Assertions.assertThat(panelHeader.getTopDemoInfoBannerBackgroundAsHex()).isEqualTo(RED_COLOR);
    }

    @Test
    public void panelHeader_PageWrapperGreyBar_HasCorrectImageAndLink() {
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
                (HOMEPAGE_URL + "pub/static/version1666447838/frontend/Magento/luma/en_US/images/logo.svg");
    }

    @Test
    public void panelHeader_SearchField_HasCorrectlyPlaceholderTextAndLink() {
        //then
        Assertions.assertThat(panelHeader.isSearchFieldDisplayed()).isTrue();
        Assertions.assertThat(panelHeader.getSearchFieldPlaceHolderText()).isEqualTo("Search entire store here...");
    }

    @Test
    public void panelHeader_ShoppingCart_HasCorrectIconAndLink() {
        //then
        Assertions.assertThat(panelHeader.isCartLinkDisplayed()).isTrue();
        Assertions.assertThat(panelHeader.getCartLink()).isEqualTo(SHOPPING_CART_URL);
    }


    public void validatePanelHeaderNamesAndLinks(List<WebElement> headerPanelList, List<String> expectedPanelHeaderNamesList,
                                                 List<String> expectedCategoriesLinks) {

        List<String> actualLoginAndCreateAccountNames = new ArrayList<>();
        List<String> actualLoginAndCreateAccountLinks = new ArrayList<>();

        for (WebElement element : headerPanelList) {
            Assertions.assertThat(element.isDisplayed()).isTrue();
            actualLoginAndCreateAccountNames.add(element.getText());
            Assertions.assertThat(element.isEnabled()).isTrue();
            actualLoginAndCreateAccountLinks.add(element.getAttribute(Attribute.HREF.name()));
        }

        Assertions.assertThat(actualLoginAndCreateAccountNames).hasSameElementsAs(expectedPanelHeaderNamesList);
        Assertions.assertThat(actualLoginAndCreateAccountLinks).contains(String.valueOf(expectedCategoriesLinks));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
