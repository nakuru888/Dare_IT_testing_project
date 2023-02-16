import components.Footer;
import enums.Attribute;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.WebDriverUtils;

import java.util.ArrayList;
import java.util.List;

public class FooterTest {
    private static final String HOMEPAGE_URL = "https://magento.softwaretestingboard.com/";
    private static final String TESTING_BOARD_URL = "https://softwaretestingboard.com/";
    private final By footerLink = By.cssSelector(".footer.content ul.footer.links a");
    private final By footerName = By.cssSelector(".footer.content ul.footer.links a");
    private static final String WHITE_COLOR = "#ffffff";
    private static final String BLUE_COLOR = "#1979c3";
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
    public void footerNavigation_FirstLevelCategories_CorrectlyDisplayed() {
        //then
        List<String> expectedNamesList = List.of("More websites for practice", "About us", "Customer Service", "Ask a question", "Write for Us",
                "Search Terms", "Privacy and Cookie Policy", "Advanced Search", "Orders and Returns");
        List<String> expectedLinkList = List.of(TESTING_BOARD_URL + "q2a/4516/can-you-recommend-website-to-practice-selenium?show=4517#a4517",
                HOMEPAGE_URL + "about-us", HOMEPAGE_URL + "customer-service", TESTING_BOARD_URL + "q2a/ask", TESTING_BOARD_URL + "write-for-us/",
                HOMEPAGE_URL + "search/term/popular/", HOMEPAGE_URL + "privacy-policy-cookie-restriction-mode/", HOMEPAGE_URL + "catalogsearch/advanced/",
                HOMEPAGE_URL + "sales/guest/form/");
        validateFooterCategoriesNamesAndLinks(footerCategoriesList, expectedNamesList, expectedLinkList);
    }

    @Test
    public void footer_SubscribeToNewsletterField_HasTextAndButtonCorrectlyDisplayed() {
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
                ("Use this site to website to practice selenium.\n" +
                        "This is a demo website for automation testing.\n" +
                        "People also use it as a selenium practice site.\n" +
                        "Searches,\n" +
                        "shopping cart automation selenium");
    }

    public void validateFooterCategoriesNamesAndLinks(List<WebElement> footerCategoriesList, List<String> expectedNamesList,
                                                      List<String> expectedCategoriesLinks) {

        List<String> actualCategoriesNames = new ArrayList<>();
        List<String> actualCategoriesLinks = new ArrayList<>();

        for (WebElement category : footerCategoriesList) {
            WebElement categoryName = category.findElement(footerName);
            Assertions.assertThat(categoryName.isDisplayed()).isTrue();
            actualCategoriesNames.add(categoryName.getText());
            WebElement categoryLink = category.findElement(footerLink);
            Assertions.assertThat(categoryLink.isEnabled()).isTrue();
            actualCategoriesLinks.add(categoryLink.getAttribute(Attribute.HREF.name()));

        }

        Assertions.assertThat(actualCategoriesNames).hasSameElementsAs(expectedNamesList);
        Assertions.assertThat(actualCategoriesLinks).hasSameElementsAs(expectedCategoriesLinks);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
