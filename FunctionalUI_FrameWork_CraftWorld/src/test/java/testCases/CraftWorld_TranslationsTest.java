package testCases;

import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class CraftWorld_TranslationsTest extends BaseTest{

    public CraftWorld_TranslationsTest() throws AWTException {
    }

    boolean firstTime = false;
    String user;
    String token;
    int waitTime = 500;

    @BeforeClass
    public void logIn() throws UnirestException, IOException {

    }



    @Test(priority = 20, description = "Validate on Footer Social Links presence")
    @Description("Validate on Footer Social Links presence")
    @Severity(SeverityLevel.NORMAL)
    public void translationTestCore() throws UnirestException, IOException {

        craftWorld_0001_header_1.catchTranslationCore(readConfig.getTranslationLanguage());

    }

    @Test(priority = 21, description = "Validate on Footer Social Links presence")
    @Description("Validate on Footer Social Links presence")
    @Severity(SeverityLevel.NORMAL)
    public void translationTestSport() throws UnirestException, IOException {

        craftWorld_0001_header_1.catchTranslationSport(readConfig.getTranslationLanguage());
    }




}
