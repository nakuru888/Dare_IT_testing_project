package components;

import components.Footer;
import enums.Attribute;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.WebDriverUtils;

import java.util.ArrayList;
import java.util.List;

import static colors.ColorsHex.BLUE_COLOR;
import static colors.ColorsHex.WHITE_COLOR;
import static page.url.PageUrl.HOMEPAGE_URL;
import static page.url.PageUrl.SOFTWARE_TESTING_BOARD_PAGE_URL;

public class FooterTest {
    private WebDriver driver;
    private Footer footer;
    private List<WebElement> footerCategoriesList;

    @BeforeClass
    public void setUp() {
        driver = WebDriverUtils.createWebDriver();
        driver.get(HOMEPAGE_URL);
        footer = new Footer(driver);
        footerCategoriesList = footer.getFooterCategoriesList();
    }

    @Test
    public void footer_FooterLinks_CorrectlyDisplayed() {
        //then
        List<String> expectedNamesList = List.of("More websites for practice", "About us", "Customer Service", "Ask a question", "Write for Us",
                "Search Terms", "Privacy and Cookie Policy", "Advanced Search", "Orders and Returns");
        List<String> expectedLinkList = List.of(SOFTWARE_TESTING_BOARD_PAGE_URL + "q2a/4516/can-you-recommend-website-to-practice-selenium?show=4517#a4517",
                HOMEPAGE_URL + "about-us", HOMEPAGE_URL + "customer-service", SOFTWARE_TESTING_BOARD_PAGE_URL + "q2a/ask", SOFTWARE_TESTING_BOARD_PAGE_URL + "write-for-us/",
                HOMEPAGE_URL + "search/term/popular/", HOMEPAGE_URL + "privacy-policy-cookie-restriction-mode/", HOMEPAGE_URL + "catalogsearch/advanced/",
                HOMEPAGE_URL + "sales/guest/form/");
        validateFooterCategoriesNamesAndLinks(footerCategoriesList, expectedNamesList, expectedLinkList);
    }

    @Test
    public void footer_SubscribeToNewsletterForm_HasTextAndButtonCorrectlyDisplayed() {
        //then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(footer.isSubscribeFormFieldDisplayed()).isTrue();
        softAssertions.assertThat(footer.isSubscribeButtonEnabled()).isTrue();
        softAssertions.assertThat(footer.getSubscribeButtonText()).isEqualTo("Subscribe");
        softAssertions.assertThat(footer.getEnterYourEmailPlaceHolderText()).isEqualTo("Enter your email address");
        softAssertions.assertThat(footer.getSubscribeButtonFontColorAsHex()).isEqualTo(WHITE_COLOR);
        softAssertions.assertThat(footer.getSubscribeButtonBackgroundColorAsHex()).isEqualTo(BLUE_COLOR);
        softAssertions.assertAll();
    }

    @Test
    public void footer_FooterWebsiteInformation_HasTextCorrectlyDisplayed() {
        Assertions.assertThat(footer.getFooterWebsiteInformationText()).isEqualTo
                ("""
                        Use this site to website to practice selenium.
                        This is a demo website for automation testing.
                        People also use it as a selenium practice site.
                        Searches,
                        shopping cart automation selenium""");
    }

    @Test
    public void footer_FooterCopyrightSection_HasTextCorrectlyDisplayed() {
        Assertions.assertThat(footer.isCopyrightInformationDisplayed()).isTrue();
        Assertions.assertThat(footer.getFooterCopyrightInformationText()).isEqualTo
                ("Copyright © 2013-present Magento, Inc. All rights reserved.");
    }

    public void validateFooterCategoriesNamesAndLinks(List<WebElement> footerCategoriesList, List<String> expectedFooterCategoriesNamesList,
                                                      List<String> expectedCategoriesLinks) {

        List<String> actualCategoriesNames = new ArrayList<>();
        List<String> actualCategoriesLinks = new ArrayList<>();

        for (WebElement category : footerCategoriesList) {
            Assertions.assertThat(category.isDisplayed()).isTrue();
            actualCategoriesNames.add(category.getText());
            Assertions.assertThat(category.isEnabled()).isTrue();
            actualCategoriesLinks.add(category.getAttribute(Attribute.HREF.name()));
        }

        Assertions.assertThat(actualCategoriesNames).hasSameElementsAs(expectedFooterCategoriesNamesList);
        Assertions.assertThat(actualCategoriesLinks).hasSameElementsAs(expectedCategoriesLinks);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
