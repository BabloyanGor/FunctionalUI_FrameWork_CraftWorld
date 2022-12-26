package pageObjects;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import testCases.BaseTest;
import utilities.ReadConfig;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

public class BasePage {

    static WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    Select select;
    JavascriptExecutor js;
    Robot robot;
    public int i = 1;


    public BasePage(WebDriver driver) throws AWTException {
        this.driver = driver;
        actions = new Actions(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        js = (JavascriptExecutor) driver;
        robot = new Robot();
    }

    public BasePage() throws AWTException {
    }


    ReadConfig readConfig = new ReadConfig();
    public String baseURL = readConfig.getBaseURL();
    public String translationLanguage = readConfig.getTranslationLanguage();


    public HttpResponse<String> menuListAPI() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get(baseURL + "/assets/json/menu.json?=636")
                .asString();
        return response;
    }


    //region <HeaderPanel1Links >
    public static ArrayList<String> HeaderPanel1ID = new ArrayList<>();
    public static ArrayList<String> HeaderPanel1Icon = new ArrayList<>();
    public static ArrayList<String> HeaderPanel1Title = new ArrayList<>();
    public static ArrayList<String> HeaderPanel1Type = new ArrayList<>();
    public static ArrayList<String> HeaderPanel1StyleType = new ArrayList<>();
    public static ArrayList<String> HeaderPanel1Href = new ArrayList<>();
    public static ArrayList<String> HeaderPanel1OpenInRouting = new ArrayList<>();
    public static ArrayList<String> HeaderPanel1Orientation = new ArrayList<>();
    public static ArrayList<String> HeaderPanel1Order = new ArrayList<>();


    public static ArrayList<String> subHeaderPanel1Icon = new ArrayList<>();
    public static ArrayList<String> subHeaderPanel1Title = new ArrayList<>();
    public static ArrayList<String> subHeaderPanel1Type = new ArrayList<>();
    public static ArrayList<String> subHeaderPanel1Href = new ArrayList<>();
    public static ArrayList<String> subHeaderPanel1OpenInRouting = new ArrayList<>();
    public static ArrayList<String> subHeaderPanel1Order = new ArrayList<>();
    public static ArrayList<String> subHeaderPanel1StyleType = new ArrayList<>();

    public void headerPanel1BottomLinks() throws UnirestException, IOException {
        int statusCod;
        JSONObject jsonObjectBody;
        JSONArray MenuListArray;
        JSONArray ItemsArray;
        JSONArray subMenuArray;
        HttpResponse<String> response = menuListAPI();
        Unirest.shutdown();
        statusCod = response.getStatus();
        jsonObjectBody = new JSONObject(response.getBody());

        MenuListArray = jsonObjectBody.getJSONArray("MenuList");
        for (int i = 0; i < MenuListArray.length(); i++) {
            String arrMenuListItems = String.valueOf(MenuListArray.get(i));
            JSONObject arrMenuListItem = new JSONObject(arrMenuListItems);
            String type = arrMenuListItem.get("Type").toString();

            if (type.equals("HeaderPanel1Menu")) {
                ItemsArray = arrMenuListItem.getJSONArray("Items");

                for (int j = 0; j < ItemsArray.length(); j++) {
                    String linkInfo = ItemsArray.get(j).toString();
                    JSONObject linkInfoJson = new JSONObject(linkInfo);

                    String ID = linkInfoJson.get("Id").toString();
                    HeaderPanel1ID.add(ID);

                    String Icon = linkInfoJson.get("Icon").toString();
                    HeaderPanel1Icon.add(Icon);

                    String Title = linkInfoJson.get("Title").toString();
                    HeaderPanel1Title.add(Title);

                    String Type = linkInfoJson.get("Type").toString();
                    HeaderPanel1Type.add(Type);

                    String StyleType = linkInfoJson.get("StyleType").toString();
                    HeaderPanel1StyleType.add(StyleType);

                    String Href = linkInfoJson.get("Href").toString();
                    if (Href.contains("https://")) {
                        HeaderPanel1Href.add(Href);
                    } else {
                        if (Href.startsWith("/")) {
                            HeaderPanel1Href.add(baseURL + Href);
                        } else {
                            HeaderPanel1Href.add(baseURL + "/" + Href);
                        }
                    }

                    String OpenInRouting = linkInfoJson.get("OpenInRouting").toString();
                    HeaderPanel1OpenInRouting.add(OpenInRouting);

                    String Orientation = linkInfoJson.get("Orientation").toString();
                    HeaderPanel1Orientation.add(Orientation);

                    String Order = linkInfoJson.get("Order").toString();
                    HeaderPanel1Order.add(Order);

                    subMenuArray = linkInfoJson.getJSONArray("SubMenu");
                    if (subMenuArray.length() != 0) {
                        for (int k = 0; k < subMenuArray.length(); k++) {
                            String subMenuLinkInfo = subMenuArray.get(k).toString();
                            JSONObject subMenuLinkInfoJson = new JSONObject(subMenuLinkInfo);

                            String subIcon = subMenuLinkInfoJson.get("Icon").toString();
                            subHeaderPanel1Icon.add(subIcon);

                            String subTitle = linkInfoJson.get("Title").toString();
                            subHeaderPanel1Title.add(subTitle);

                            String subType = linkInfoJson.get("Type").toString();
                            subHeaderPanel1Type.add(subType);

                            String subMenuHref = linkInfoJson.get("Href").toString();

                            if (subMenuHref.contains("https://")) {
                                HeaderPanel1Href.add(subMenuHref);
                                subHeaderPanel1Href.add(subMenuHref);
                            } else {
                                if (subMenuHref.startsWith("/")) {

                                    if (Href.contains("https://")) {
                                        HeaderPanel1Href.add(Href + subMenuHref);
                                        subHeaderPanel1Href.add(Href + subMenuHref);
                                    } else {
                                        if (Href.startsWith("/")) {
                                            HeaderPanel1Href.add(baseURL + Href + subMenuHref);
                                            subHeaderPanel1Href.add(baseURL + Href + subMenuHref);

                                        } else {
                                            HeaderPanel1Href.add(baseURL + "/" + Href + subMenuHref);
                                            subHeaderPanel1Href.add(baseURL + "/" + Href + subMenuHref);
                                        }
                                    }

                                } else {

                                    if (Href.contains("https://")) {
                                        HeaderPanel1Href.add(Href + "/" + subMenuHref);
                                    } else {
                                        if (Href.startsWith("/")) {
                                            HeaderPanel1Href.add(baseURL + Href + "/" + subMenuHref);
                                        } else {
                                            HeaderPanel1Href.add(baseURL + "/" + Href + "/" + subMenuHref);
                                        }
                                    }
                                }
                            }

                            String subOpenInRouting = linkInfoJson.get("OpenInRouting").toString();
                            subHeaderPanel1OpenInRouting.add(subOpenInRouting);

                            String subOrder = linkInfoJson.get("Order").toString();
                            subHeaderPanel1Order.add(subOrder);

                            String subStyleType = linkInfoJson.get("StyleType").toString();
                            subHeaderPanel1StyleType.add(subStyleType);


                        }
                    }
                }
                break;
            }
        }
    }


    //endregion


    //region <HeaderPanel2BottomLinks >

    public static ArrayList<String> LinkTitleHeaderPanel2 = new ArrayList<>();
    public static ArrayList<String> LinkHrefPathHeaderPanel2 = new ArrayList<>();
    public static ArrayList<String> LinkHrefHeaderPanel2 = new ArrayList<>();
    public static ArrayList<String> LinkStyleTypeHeaderPanel2 = new ArrayList<>();
    public static ArrayList<String> LinkOpenInRoutingHeaderPanel2 = new ArrayList<>();

    public ArrayList<String> SubLinkTitleHeaderPanel2 = new ArrayList<>();
    public ArrayList<String> SubLinkHrefHeaderPanel2 = new ArrayList<>();

    public void headerPanel2BottomLinks() throws UnirestException, IOException {
        int statusCod;
        JSONObject jsonObjectBody;
        JSONArray MenuListArray;
        JSONArray ItemsArray;
        JSONArray subMenuArray;
        HttpResponse<String> response = menuListAPI();
        Unirest.shutdown();
        statusCod = response.getStatus();
        jsonObjectBody = new JSONObject(response.getBody());

        MenuListArray = jsonObjectBody.getJSONArray("MenuList");
        for (int i = 0; i < MenuListArray.length(); i++) {
            String arrMenuListItems = String.valueOf(MenuListArray.get(i));
            JSONObject arrMenuListItem = new JSONObject(arrMenuListItems);
            String type = arrMenuListItem.get("Type").toString();

            if (type.equals("HeaderPanel2Menu")) {
                ItemsArray = arrMenuListItem.getJSONArray("Items");

                for (int j = 0; j < ItemsArray.length(); j++) {
                    String linkInfo = ItemsArray.get(j).toString();
                    JSONObject linkInfoJson = new JSONObject(linkInfo);

                    String Orientation = linkInfoJson.get("Orientation").toString();
//                    BaseTest.logger.info("Orientation >>>>  " + Orientation);
//                    if (Orientation.equals("false")){

                    String StyleType = linkInfoJson.get("StyleType").toString();
                    LinkStyleTypeHeaderPanel2.add(StyleType);

                    String OpenInRouting = linkInfoJson.get("OpenInRouting").toString();
                    LinkOpenInRoutingHeaderPanel2.add(OpenInRouting);
//                        BaseTest.logger.info("OpenInRouting >>>>  " + OpenInRouting);

                    String menuTitle = linkInfoJson.get("Title").toString();
                    LinkTitleHeaderPanel2.add(menuTitle);
//                        LinkXpath.add("//li[contains (@class, 'TEST_HeaderPanel2Menu_" + menuTitle + "')]");
//                        BaseTest.logger.info("menuTitle >>>>  " + menuTitle);

                    String menuLinkHref = linkInfoJson.get("Href").toString();
                    LinkHrefPathHeaderPanel2.add(menuLinkHref);

                    if (menuLinkHref.contains("https://")) {
                        LinkHrefHeaderPanel2.add(menuLinkHref);
                    } else {
                        if (menuLinkHref.startsWith("/")) {
                            LinkHrefHeaderPanel2.add(baseURL + menuLinkHref);
                        } else {
                            LinkHrefHeaderPanel2.add(baseURL + "/" + menuLinkHref);
                        }
                    }

//                        BaseTest.logger.info("menuLinkHref >>>>  " +baseURL + "/" + menuLinkHref);
                    subMenuArray = linkInfoJson.getJSONArray("SubMenu");

                    if (subMenuArray.length() != 0) {
                        for (int k = 0; k < subMenuArray.length(); k++) {
                            String subMenulinkInfo = subMenuArray.get(k).toString();
                            JSONObject subMenulinkInfoJson = new JSONObject(subMenulinkInfo);

                            String subMenuTitle = subMenulinkInfoJson.get("Title").toString();
                            LinkTitleHeaderPanel2.add(subMenuTitle);

                            String subStyleType = linkInfoJson.get("StyleType").toString();
                            LinkStyleTypeHeaderPanel2.add(subStyleType);

//                                BaseTest.logger.info("subMenuTitle >>>>  " + subMenuTitle);
                            String subOpenInRouting = subMenulinkInfoJson.get("OpenInRouting").toString();
                            LinkOpenInRoutingHeaderPanel2.add(subOpenInRouting);

                            String subMenuHref = subMenulinkInfoJson.get("Href").toString();
                            LinkHrefPathHeaderPanel2.add(subMenuHref);

                            if (subMenuHref.contains("https://")) {
                                LinkHrefHeaderPanel2.add(subMenuHref);
                            } else {
                                if (subMenuHref.startsWith("/")) {

                                    if (menuLinkHref.contains("https://")) {
                                        LinkHrefHeaderPanel2.add(menuLinkHref + subMenuHref);
                                    } else {
                                        if (menuLinkHref.startsWith("/")) {
                                            LinkHrefHeaderPanel2.add(baseURL + menuLinkHref + subMenuHref);

                                        } else {
                                            LinkHrefHeaderPanel2.add(baseURL + "/" + menuLinkHref + subMenuHref);
                                        }
                                    }


                                } else {

                                    if (menuLinkHref.contains("https://")) {
                                        LinkHrefHeaderPanel2.add(menuLinkHref + "/" + subMenuHref);
                                    } else {
                                        if (menuLinkHref.startsWith("/")) {
                                            LinkHrefHeaderPanel2.add(baseURL + menuLinkHref + "/" + subMenuHref);
                                        } else {
                                            LinkHrefHeaderPanel2.add(baseURL + "/" + menuLinkHref + "/" + subMenuHref);
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
                break;
            }
        }
    }


    //endregion


    //region <FooterLinks >

    public static ArrayList<String> socialFooterTitle = new ArrayList<>();
    public static ArrayList<String> socialFooterType = new ArrayList<>();
    public static ArrayList<String> socialFooterIcon = new ArrayList<>();
    public static ArrayList<String> socialFooterHref = new ArrayList<>();
    public static ArrayList<String> socialFooterOpenInRouting = new ArrayList<>();


    public static ArrayList<String> menuFooterTitle = new ArrayList<>();
    public static ArrayList<String> menuFooterPath = new ArrayList<>();
    public static ArrayList<String> menuFooterHref = new ArrayList<>();
    public static ArrayList<String> menuFooterOpenInRouting = new ArrayList<>();

    public static ArrayList<String> manuSubFooterTitle = new ArrayList<>();
    public static ArrayList<String> menuSubFooterHref = new ArrayList<>();
    public static ArrayList<String> menuSubFooterPath = new ArrayList<>();
    public static ArrayList<String> menuSubFooterOpenInRouting = new ArrayList<>();

    public void footerMenuLinksAPI() throws UnirestException, IOException {


        int statusCod;
        JSONObject jsonObjectBody;
        JSONArray MenuListArray;
        JSONArray ItemsArray;
        JSONArray subMenuArray;
        HttpResponse<String> response = menuListAPI();
        Unirest.shutdown();
        statusCod = response.getStatus();
        jsonObjectBody = new JSONObject(response.getBody());

        MenuListArray = jsonObjectBody.getJSONArray("MenuList");
        for (int i = 0; i < MenuListArray.length(); i++) {
            String arrMenuListItems = String.valueOf(MenuListArray.get(i));
            JSONObject arrMenuListItem = new JSONObject(arrMenuListItems);
            String type = arrMenuListItem.get("Type").toString();
//            BaseTest.logger.info("type >>>>  " + type);


            if (type.equals("FooterMenu")) {
                ItemsArray = arrMenuListItem.getJSONArray("Items");

                for (int j = 0; j < ItemsArray.length(); j++) {
                    String footerItem = ItemsArray.get(j).toString();
                    JSONObject footerItemJson = new JSONObject(footerItem);

                    String ItemTitle = footerItemJson.get("Title").toString();
                    String ItemType = footerItemJson.get("Type").toString();


                    if (ItemTitle.equals("SocialNetworks") || ItemTitle.equals("Follow us")) {
                        subMenuArray = footerItemJson.getJSONArray("SubMenu");
                        if (subMenuArray.length() != 0) {
                            for (int k = 0; k < subMenuArray.length(); k++) {

                                String subMenuFooterSocial = subMenuArray.get(k).toString();
                                JSONObject subMenuFooterSocialJson = new JSONObject(subMenuFooterSocial);

                                String subMenuType = subMenuFooterSocialJson.get("Type").toString();
                                socialFooterType.add(subMenuType);

                                String subMenuIcon = subMenuFooterSocialJson.get("Icon").toString();
                                socialFooterIcon.add(subMenuIcon);


                                String subMenuTitle = subMenuFooterSocialJson.get("Title").toString();
                                socialFooterTitle.add(subMenuTitle);

                                String subMenuHref = subMenuFooterSocialJson.get("Href").toString();

                                if (subMenuHref.contains("https://")) {
                                    socialFooterHref.add(subMenuHref);
                                } else {
                                    if (subMenuHref.startsWith("/")) {
                                        socialFooterHref.add(baseURL + subMenuHref);
                                    } else {
                                        socialFooterHref.add(baseURL + "/" + subMenuHref);
                                    }
                                }
                                String subMenuOpenInRouting = subMenuFooterSocialJson.get("OpenInRouting").toString();
                                socialFooterOpenInRouting.add(subMenuOpenInRouting);

                            }
                        }
                    }


                    if (ItemType.equals("ft-menu-item")) {

                        String menuTitle = footerItemJson.get("Title").toString();
                        menuFooterTitle.add(menuTitle);
                        String menuHref = footerItemJson.get("Href").toString();
                        menuFooterPath.add(menuHref);
                        String menuOpenInRouting = footerItemJson.get("OpenInRouting").toString();
                        menuFooterOpenInRouting.add(menuOpenInRouting);

                        if (menuHref.contains("https://")) {
                            menuFooterHref.add(menuHref);
                        } else {
                            if (menuHref.startsWith("/")) {
                                menuFooterHref.add(baseURL + menuHref);
                            } else {
                                menuFooterHref.add(baseURL + "/" + menuHref);
                            }
                        }


                        subMenuArray = footerItemJson.getJSONArray("SubMenu");
                        if (subMenuArray.length() != 0) {
                            for (int k = 0; k < subMenuArray.length(); k++) {

                                String subMenuFooterMenu = subMenuArray.get(k).toString();
                                JSONObject subMenuFooterSocialJson = new JSONObject(subMenuFooterMenu);


                                String subMenuTitle = subMenuFooterSocialJson.get("Title").toString();
                                manuSubFooterTitle.add(subMenuTitle);

                                String subMenuHref = subMenuFooterSocialJson.get("Href").toString();
                                menuSubFooterPath.add(subMenuHref);


                                if (subMenuHref.contains("https://")) {
                                    menuSubFooterHref.add(subMenuHref);
                                } else {
                                    if (subMenuHref.startsWith("/")) {
                                        menuSubFooterHref.add(baseURL + subMenuHref);
                                    } else {
                                        menuSubFooterHref.add(baseURL + "/" + subMenuHref);
                                    }
                                }
                                String subMenuOpenInRouting = subMenuFooterSocialJson.get("OpenInRouting").toString();
                                menuSubFooterOpenInRouting.add(subMenuOpenInRouting);

                            }
                        }
                    }
                }
            }
        }
    }

    //endregion







    //region <Check version.js CorePlatform >

    public String generateRandomKeyCorePlatform() {
        String randomKey;
        randomKey = "QaTest" + RandomStringUtils.randomAlphanumeric(15);
        return randomKey;
    }


    public int versionJSCorePlatform() throws UnirestException {
        int version = 0;
        String request = baseURL + "/assets/js/version.js?=" + generateRandomKeyCorePlatform();
        BaseTest.logger.info("Request:  " + request);
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get(request)
                .asString();
        try {
            int statusCod = response.getStatus();
            if (statusCod == 200) {
                String responseBody = response.getBody();
                BaseTest.logger.info("Response: " + responseBody);
                version = Integer.parseInt(responseBody.substring(17, 20));
            }
        } catch (Exception e) {
            BaseTest.logger.info("Exception: " + e);
        }

        return version;
    }


    //endregion
    //region <Check version.js SportsBook >
    public String generateRandomKeySportsBook() {
        String randomKey;
        randomKey = "QaTest" + RandomStringUtils.randomAlphanumeric(15);
        return randomKey;
    }


    public int versionJSSportsBook() throws UnirestException {
        int version = 0;
        String httpPart = baseURL.substring(0, 8);
        String urlPart = baseURL.substring(8);
        try {
            String request = httpPart + "sportsbookwebsite." + urlPart + "/website/assets/js/version.js?=" + generateRandomKeySportsBook();
            BaseTest.logger.info("Request: " + request);
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.get(request)
                    .asString();
            int statusCod = response.getStatus();
            if (statusCod == 200) {
                String responseBody = response.getBody();
                BaseTest.logger.info("Response: " + responseBody);
                version = Integer.parseInt(responseBody.substring(17, 20));
            }
        } catch (Exception e) {
            BaseTest.logger.info("Exception: " + e);
        }

        return version;
    }


    //endregion


    //region <Config.json CorePlatform getLanguages>
    public String generateRandomKeyConfig() {
        String randomKey;
        randomKey = "QaTest" + RandomStringUtils.randomAlphanumeric(15);
        return randomKey;
    }

    public static ArrayList<String> language_key_Array = new ArrayList<>();
    public static ArrayList<String> language_value_Array = new ArrayList<>();

    public void getLanguages() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        String request = baseURL + "/assets/json/config.json?=" + versionJSCorePlatform();
        BaseTest.logger.info("Request: " + request);
        HttpResponse<String> response = Unirest.get(request)
                .asString();
        BaseTest.logger.info("Response: " + response.getBody());
        JSONObject jsonObjectBody;
        JSONArray LanguagesListArray;
        jsonObjectBody = new JSONObject(response.getBody());
        LanguagesListArray = jsonObjectBody.getJSONArray("Languages");

        BaseTest.logger.info("Languages are : " + LanguagesListArray.length());


        for (int i = 0; i < LanguagesListArray.length(); i++) {
            String languages = LanguagesListArray.get(i).toString();
            JSONObject language = new JSONObject(languages);

            String language_key = language.get("key").toString();
            String language_value = language.get("value").toString();
            BaseTest.logger.info(language_value + " _ " + language_key);
            language_key_Array.add(language_key);
            language_value_Array.add(language_value);
        }
    }

    //endregion
    //<Config.json SportsBook>
    //endregion





    //region <en.json CorePlatform>














    public static ArrayList<String> translationMissingLinesCore = new ArrayList<>();

    public void catchTranslationCore(String languageKey) throws UnirestException, IOException {
        SoftAssert softAssert = new SoftAssert();
//        try {


        String requestTranslationLanguage = baseURL + "/assets/json/translations/" + languageKey + ".json?=" + versionJSCorePlatform();
        BaseTest.logger.info("Request: " + requestTranslationLanguage);
        Unirest.setTimeouts(0, 0);
        HttpResponse<JsonNode> responseTranslationLanguage = Unirest.get(requestTranslationLanguage)
                .asJson();
        int statusCodeEnTranslationLanguage = responseTranslationLanguage.getStatus();


        String requestTranslationEn = baseURL + "/assets/json/translations/en.json?=" + versionJSCorePlatform();
        BaseTest.logger.info("Request en.json: " + requestTranslationEn);
        Unirest.setTimeouts(0, 0);
        HttpResponse<JsonNode> responseTranslationEn = Unirest.get(requestTranslationEn)
                .asJson();
        int statusCodeEn = responseTranslationEn.getStatus();

        if (statusCodeEn == 200 && statusCodeEnTranslationLanguage == 200) {

            JsonNode EnBody = responseTranslationEn.getBody();
            Object[] TitleKeysEn = EnBody.getObject().keySet().toArray();

            JsonNode TranslationLanguageBody = responseTranslationLanguage.getBody();
            Object[] TitleKeysTranslationLanguage = TranslationLanguageBody.getObject().keySet().toArray();

            Assert.assertEquals(TitleKeysEn, TitleKeysTranslationLanguage, "Json TitleKeys are not same");   //Compare Json TitleKeys Containing Arrays

            int sumError = 0;
            int sumTranslation = 0;
            for (int m= 0; m<TitleKeysEn.length; m++){

//                BaseTest.logger.info(TitleKey);
                Object TitleKey = TitleKeysEn[m];
                JSONObject titleObjectEn = EnBody.getObject().getJSONObject(TitleKey.toString());   //For English
//                BaseTest.logger.info(titleObjectEn);
                JSONObject titleObjectTranslationLanguage = TranslationLanguageBody.getObject().getJSONObject(TitleKey.toString());   //For TranslationLanguage
//                BaseTest.logger.info(titleObjectTranslationLanguage);

                Object[] keysEn = titleObjectEn.keySet().toArray();
                Object[] keysTranslationLanguage = titleObjectTranslationLanguage.keySet().toArray();
                Assert.assertEquals(keysEn, keysTranslationLanguage, "Json Keys are not same");   //Compare Json Keys Containing Arrays
                BaseTest.logger.info("Translation Keys for " + TitleKey +" are:  " + keysEn.length);
                sumTranslation +=   keysEn.length;
                for (int n= 0; n<keysEn.length;n++){

//                   BaseTest.logger.info(Key);
                    Object Key = keysEn[n];
                    String valueEn = String.valueOf(titleObjectEn.get(Key.toString()));
//                    BaseTest.logger.info(valueEn);
                    String valueTranslationLanguage = String.valueOf(titleObjectTranslationLanguage.get(Key.toString()));
//                    BaseTest.logger.info(valueTranslationLanguage);
                    if (valueTranslationLanguage.equals(valueEn) || valueTranslationLanguage.equals(Key)) {
                        if (!valueEn.isEmpty()){
                            sumError ++;
                            String missingTranslation = n+1 + " Header: " + TitleKey + "  Key: " + Key +  "  " + languageKey + ": " + valueTranslationLanguage;
                            String missingTranslationTitleKey = TitleKey + ": " + Key ;
                            BaseTest.logger.info(missingTranslation);
                            translationMissingLinesCore.add(missingTranslationTitleKey);
                        }
                    }
                }
            }
            String partner = baseURL.substring(8);
            BaseTest.logger.info("Translations are: "+ sumTranslation + "  Not Translated lines are: " + sumError);
            writeInExel(translationMissingLinesCore, "/src/test/java/BrokenData/" + readConfig.getTranslationLanguage() + "_MissingTranslationsCorePlatform_" + partner +".xlsx", "MissingTranslations");

            Assert.assertEquals(sumError,0,"Errors are :" + sumError + " of " + sumTranslation);

//                String BodyEn = responseTranslationEn.getBody();
//                BaseTest.logger.info("BodyEn ---> " + BodyEn);
//                JSONObject jsonObjectBodyEn = new JSONObject(BodyEn);
//                BaseTest.logger.info("BodyEnJson ---> " + jsonObjectBodyEn);
//
//
//
//                Set<String> keys = jsonObjectBodyEn.keySet();
//                Object[] TitleKeysEn = keys.toArray();
////
////                for (String key:keys){
////                    System.out.println("key >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + key);
////                }
//
//                JSONArray ArrBodyEn = jsonObjectBodyEn.toJSONArray(jsonObjectBodyEn.names());
//                BaseTest.logger.info("ArrBodyEn ---> " + ArrBodyEn);
//
//                for (int i = 1; i <= ArrBodyEn.length(); i++) {
////                    BaseTest.logger.info(i + "  " + ArrBodyEn.get(i - 1));
//                    String title = (String) TitleKeysEn[i-1];
//                    System.out.println("Title  " + title);
//
//
//                    String ValuesStringEn = String.valueOf(ArrBodyEn.get(i - 1));
//                    JSONObject ValuesEn = new JSONObject(ValuesStringEn);
//
////                    BaseTest.logger.info(i + "  ValuesEn   ---> " + ValuesEn);
//
//                    JSONArray ArrValuesEn = ValuesEn.toJSONArray(ValuesEn.names());
//                    BaseTest.logger.info(i + "  ArrValuesEn ---> " + ArrValuesEn);
//
//                }
//
//            } else {
//                BaseTest.logger.info("Response status cod " + responseTranslationEn.getStatus());
//            }
//        } catch (Exception e) {
//            BaseTest.logger.info("Exception  !!!!!!!!!!!!!!!!!!!!!!!!!" + e);
//        }


        }
    }
    //endregion


    //region <en.json SportsBook>
    public static ArrayList<String> translationMissingLinesSport = new ArrayList<>();

    public void catchTranslationSport(String languageKey) throws UnirestException, IOException {
        String httpPart = baseURL.substring(0, 8);
        String urlPart = baseURL.substring(8);

        String requestTranslationLanguage = httpPart + "sportsbookwebsite." + urlPart +"/website/assets/json/translations/"+languageKey+".json?=" + versionJSSportsBook();
        BaseTest.logger.info("Request Translation language: " + requestTranslationLanguage);
        Unirest.setTimeouts(0, 0);
        HttpResponse<JsonNode> responseTranslationLanguage = Unirest.get(requestTranslationLanguage)
                .asJson();
        int statusCodeEnTranslationLanguage = responseTranslationLanguage.getStatus();


        String requestTranslationEn = httpPart + "sportsbookwebsite." + urlPart +"/website/assets/json/translations/en.json?=" + versionJSSportsBook();
        BaseTest.logger.info("Request en.json: " + requestTranslationEn);
        Unirest.setTimeouts(0, 0);
        HttpResponse<JsonNode> responseTranslationEn = Unirest.get(requestTranslationEn)
                .asJson();
        int statusCodeEn = responseTranslationEn.getStatus();

        if (statusCodeEn == 200 && statusCodeEnTranslationLanguage == 200) {

            JsonNode EnBody = responseTranslationEn.getBody();
            Object[] KeysEn = EnBody.getObject().keySet().toArray();

            JsonNode TranslationLanguageBody = responseTranslationLanguage.getBody();
            Object[] KeysTranslationLanguage = TranslationLanguageBody.getObject().keySet().toArray();

            Assert.assertEquals(KeysEn, KeysTranslationLanguage, "Json Keys are not same ");   //Compare Json Keys Containing Arrays
            int sumError = 0;
            int sumTranslation = 0;
            for (int i = 0; i<KeysEn.length;i++){
                Object Key = KeysEn[i];

                String valueEn = String.valueOf(EnBody.getObject().get(Key.toString()));
                String valueTranslationLanguage = String.valueOf(TranslationLanguageBody.getObject().get(Key.toString()));
                sumTranslation++;

                BaseTest.logger.info("Key: "+Key+ " English Value: " + valueEn + " Translated Value: " + valueTranslationLanguage);

                if (valueTranslationLanguage.equals(valueEn) || valueTranslationLanguage.equals(Key)) {
                    if (!valueEn.isEmpty()) {
                        sumError++;
                        String missingTranslation = i + 1 + " Title: " + Key +  "  En: " + valueEn + " Translation: " + valueTranslationLanguage;
                        String missingTranslationTitleKey = Key + ": " + valueTranslationLanguage;
                        BaseTest.logger.info(missingTranslation);
                        translationMissingLinesSport.add(missingTranslationTitleKey);
                    }
                }
            }

            String partner = baseURL.substring(8);
            BaseTest.logger.info("Translations are: "+ sumTranslation + "  Not Translated lines are: " + sumError);
            writeInExel(translationMissingLinesSport, "/src/test/java/BrokenData/" + readConfig.getTranslationLanguage() + "_MissingTranslationsSportBook_" + partner +".xlsx", "MissingTranslations");

            Assert.assertEquals(sumError,0,"Errors are :" + sumError + " of " + sumTranslation);

        }
    }














    Date timestamp;
    public static ArrayList<String> timestampArr = new ArrayList<>();

    public HttpResponse<String> serverLoad() throws UnirestException {

        try {
            Unirest.setTimeouts(35000, 25000);
            HttpResponse<String> response = Unirest.get("http://135.181.5.31:8088/api/CallWindowsService/GetAllData")
                    .header("Content-Type", "application/json")
                    .asString();

            timestamp = new Date(System.currentTimeMillis());
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            timestampArr.add(formatter.format(timestamp));

            return response;
        }
        catch (Exception e){
            try {
                Unirest.setTimeouts(35000, 25000);
                HttpResponse<String> response = Unirest.get("http://135.181.5.31:8088/api/CallWindowsService/GetAllData")
                        .header("Content-Type", "application/json")
                        .asString();

                timestamp = new Date(System.currentTimeMillis());
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                timestampArr.add(formatter.format(timestamp));

                return response;
            }
            catch (Exception k){
                System.out.println("Exception ServerLoad method" + k);
                return null;
            }
        }


    }

    //endregion
    public void writeInExelSixArrayList(ArrayList<String> errorSrc1 ,ArrayList<String> errorSrc2 ,ArrayList<String> errorSrc3 ,ArrayList<String> errorSrc4 ,ArrayList<String> errorSrc5 ,ArrayList<String> errorSrc6 , String src, String shitName) throws IOException {
        String target = System.getProperty("user.dir") +src;
        XSSFWorkbook workbook = new XSSFWorkbook();
        FileOutputStream file = new FileOutputStream(target);
        XSSFSheet sheet = workbook.createSheet(shitName);
        sheet.setColumnWidth(0, 9000);
        sheet.setColumnWidth(1, 9000);
        sheet.setColumnWidth(2, 9000);
        sheet.setColumnWidth(3, 9000);
        sheet.setColumnWidth(4, 1400);
        sheet.setColumnWidth(5, 9000);
        sheet.setColumnWidth(6, 9000);

//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        XSSFRow row1 = sheet.createRow(0);
//            try{
        row1.createCell(0).setCellValue("SportsBook Slave");
        row1.createCell(1).setCellValue("SportsBook Master");
        row1.createCell(2).setCellValue("SportsBook DB");
        row1.createCell(3).setCellValue("CorePlatform Slave");
        row1.createCell(4).setCellValue("CorePlatform Master");
        row1.createCell(5).setCellValue("CorePlatform DB");
        row1.createCell(6).setCellValue("Timestamp");
        int l = 2;
        for (int n=0; n<timestampArr.size();n++) {

            row1 = sheet.createRow(l);
            try{
                row1.createCell(0).setCellValue(errorSrc1.get(n));
            }
            catch (Exception a){
                row1.createCell(0).setCellValue("------");
                System.out.println("Exception sell 0");
            }


            try{
                row1.createCell(1).setCellValue(errorSrc2.get(n));
            }
            catch (Exception a){
                row1.createCell(1).setCellValue("------");
                System.out.println("Exception sell 1");
            }


            try{
                row1.createCell(2).setCellValue(errorSrc3.get(n));
            }
            catch (Exception a){
                row1.createCell(2).setCellValue("------");
                System.out.println("Exception sell 2");
            }


            try{
                row1.createCell(3).setCellValue(errorSrc4.get(n));
            }
            catch (Exception a){
                row1.createCell(3).setCellValue("------");
                System.out.println("Exception sell 3");
            }


            try{
                row1.createCell(4).setCellValue(errorSrc5.get(n));
            }
            catch (Exception a){
                row1.createCell(4).setCellValue("------");
                System.out.println("Exception sell 4");
            }


            try{
                row1.createCell(5).setCellValue(errorSrc6.get(n));
            }
            catch (Exception a){
                row1.createCell(5).setCellValue("------");
                System.out.println("Exception sell 5");
            }


            try{
                row1.createCell(6).setCellValue(timestampArr.get(n));
            }
            catch (Exception a){
                System.out.println("Exception sell Timestamp");
            }

//            try{
//            row1.createCell(0).setCellValue(errorSrc1.get(n));
//            row1.createCell(1).setCellValue(errorSrc2.get(n));
//            row1.createCell(2).setCellValue(errorSrc3.get(n));
//            row1.createCell(3).setCellValue(errorSrc4.get(n));
//            row1.createCell(4).setCellValue(errorSrc5.get(n));
//            row1.createCell(5).setCellValue(errorSrc6.get(n));
//            row1.createCell(6).setCellValue(timestampArr.get(n));
//            }
//            catch(Exception e){
//                System.out.println(("Exception write in excel sheet: "+ e));
//            }
            l++;
        }

        workbook.write(file);
        workbook.close();
    }

    public void writeInExel(ArrayList<String> errorSrcXl , String src, String shitName) throws IOException {
        String target = System.getProperty("user.dir") +src;
        XSSFWorkbook workbook = new XSSFWorkbook();
        FileOutputStream file = new FileOutputStream(target);
        XSSFSheet sheet = workbook.createSheet(shitName);
        sheet.setColumnWidth(0, 1000);
        int l = 0;
        for (String err : errorSrcXl) {
            XSSFRow row = sheet.createRow(l);
            row.createCell(0).setCellValue(err);
            l++;
        }
        workbook.write(file);
        workbook.close();
    }

    /* this method will be used for validate webElements visibility */
    public void waitElementToBeVisible(WebElement element) {
        this.webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean waitElementToBeVisibleBoolean(WebElement element) {
        try {
            this.webDriverWait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public void waitFrameToBeAvailable(WebElement element) {
        this.webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    /* this method will be used for validate webElements click ability */
    public void waitElementTobeClickable(WebElement element) {
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /* this method will be used for clicking on element which is visible */
    public void clickOnElementIfVisible(WebElement element) {
        this.waitElementToBeVisible(element);
        element.click();
    }

    /* this method will be used for clicking on element which is Clickable */
    public void clickOnElementIfClickable(WebElement element) {
        this.waitElementTobeClickable(element);
        element.click();
    }

    /* this method will be used for sending keys on element which is visible */
    public void sendKeysIfElementVisible(WebElement element, String keys) {
        this.waitElementToBeVisible(element);
        element.clear();
        element.sendKeys(keys);
    }

    public void sendKeys(WebElement element, String keys) {
        element.sendKeys(keys);
    }

    /* this method will be true if element is enabled */
    public boolean elementIsEnable(WebElement element) {
        return element.isEnabled();

    }

    /* this method will be true if element is Displayed */
    public boolean elementIsDisplayed(WebElement element) {
        return element.isDisplayed();

    }

    /* this method will return true if element is selected */
    public boolean elementIsSelected(WebElement element) {
        return element.isSelected();
    }


    //region <Get>


    /* this method will be return BasePage_s driver */
    public WebDriver getDriver() {
        return this.driver;
    }

    /* this method will get attribute from element */
    public String getTagName(WebElement element) {
        return element.getTagName();
    }

    /* this method will get attribute from element */
    public String getAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    /* this method will get text from element */
    public String getText(WebElement element) {
        waitElementToBeVisible(element);
        return element.getText();
    }

    /* this method will get current URL */
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    /* this method will get current Pages source */
    public String getSource() {
        return driver.getPageSource();
    }

    /* this method will get current Pages Title */
    public String getTitle() {
        return driver.getTitle();
    }


    //endregion

    //region <Select from Dropdown>

    public Select createSelectElement(WebElement element) {
        Select s = new Select(element);
        return s;
    }

    /* this method will be used for selecting element from dropdown using visible text */
    public void selectFromDropDownByVisibleText(WebElement element, String text) {
        select = new Select(element);
        select.selectByVisibleText(text);
    }

    /* this method will be used for selecting element from dropdown using dropdown elements index */
    public void selectFromDropDownByIndex(WebElement element, int index) {
        select = new Select(element);
        select.selectByIndex(index);
    }

    /* this method will be used for selecting element from dropdown using dropdown elements index */
    public void selectFromDropDownByValue(WebElement element, String value) {
        select = new Select(element);
        select.selectByValue(value);
    }

    public String getSelectedItemText(Select element) {
        String text = element.getFirstSelectedOption().getText();
        return text;
    }
    //endregion

    //region <javaScript executor>

    /* this method will be used for scrolling down to particular element */
    public void javaScriptScrollDownToParticularElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    /* this method will be used for scrolling down to particular position */
    public void javaScriptScrollDownToParticularPosition(String position) {
        js.executeScript("window.scrollBy(0," + position + ")", "");
    }

    /* this method will be used for scrolling to bottom of the page */
    public void javaScriptScrollToBottom() {
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    /* this method will scroll the page down */
    public void scrollPageDown() {
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    /* this method will scroll the page up */
    public void scrollPageUp() {
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
    }

    public void scrollToSpecificElementOnCenter(WebElement element) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
    }


    /* this method will zoom the page */
    public void zoomPageByJS(String zoomProcsent) {
        js.executeScript("document.body.style.zoom='" + zoomProcsent + "%'"); //zoom by 100%
    }

    /* this method will be used for clicking on WebElement */
    public void javaScriptClick(WebElement element) {
        waitElementTobeClickable(element);
        js.executeScript("arguments[0].click();", element);
    }

    /* this method will be used for sending text to text box */
    public void javaScriptSendKeys(String text) {
        js.executeScript("document.getElementById('q').value='" + text + "'");
    }

    /* this method will refresh browser */
    public void javaScriptRefreshBrowser() {
        js.executeScript("history.go(0)");
    }

    /* this method will draw border for element */
    public void javaScriptDrawBorder(WebElement element) {
        js.executeScript("arguments[0].style.border = '3px solid red'", element);
    }

    /* this method will return title of the page */
    public String javaScriptGetTitle() {
        String title = js.executeScript("return document.title;").toString();
        return title;
    }

    /* this method will generate the alert window */
    public void javaScriptGenerateAlert(String massage) {
        js.executeScript("alert('" + massage + "')");
    }


    //endregion

    //region <Actions>
    public void waitAction(int waitTime) {
        actions.pause(waitTime).perform();
    }

    public void actionClickToElement(WebElement element) {
        waitElementToBeVisible(element);
        actions.moveToElement(element).build().perform();
    }

    public void actionMoveToElement(WebElement element) {
        actions.moveToElement(element).build().perform();
    }

    public void actionMoveToElementClick(WebElement element) {
        actions.moveToElement(element).click().build().perform();

    }

    public void actionDoubleClick(WebElement element) {
        waitElementToBeVisible(element);
        actions.doubleClick(element).perform();
    }


    public void actionDownArrowXTime(int x) {
        for (int i = 0; i < x; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
    }

    public void actionControlA() {
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.perform();
    }

    public void actionControlCopy() {
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("c");
        actions.keyUp(Keys.CONTROL);
        actions.perform();
    }

    public void actionControlPaste() {
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("v");
        actions.keyUp(Keys.CONTROL);
        actions.perform();
    }

    public void actionTab() {
        actions.sendKeys(Keys.TAB).perform();
    }
    //endregion

    //region <Robot>
    public void robotTab() {
        robot.keyPress(KeyEvent.VK_TAB);
    }

    public void robotEnter() {
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    //endregion

    //region <Take Screenshot>
    /* this method will be take Screenshot whale page*/
    public File captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "\\Extent_Report\\Screenshots\\" + i + tname + ".png");
        FileUtils.copyFile(source, target);
        return target;
    }

    /* this method will be take Screenshot whale page and draw Border any element we mentioned*/
    public void captureScreenDrawBorder(WebDriver driver, WebElement element, String tname) throws IOException {
        js.executeScript("arguments[0].style.border = '3px solid red'", element);
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "\\Extent_Report\\Screenshots\\" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

    /* this method will be take Screenshot mentioned element */
    public void captureFromScreenSpecificElement(WebDriver driver, WebElement element, String tname) throws IOException {

        File source = element.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "\\Extent_Report\\Compare_Screenshots\\" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }


    //endregion

    //region <Generate emails>
    public String generateRandomMobileNumberValid() {
        String generatedNumber = RandomStringUtils.randomNumeric(8);
        return generatedNumber;
    }

    public String generateRandomEmailValid() {
        String randomEmail;
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        randomEmail = generatedString + "@gmail.com";
        return randomEmail;
    }

    //Abc.example.com no @ character
    public String generateRandomEmailInValid1() {
        String randomEmail;
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        randomEmail = generatedString + ".gmail.com";
        return randomEmail;
    }

    //A@b@c@example.com   only one @ is allowed outside quotation marks
    public String generateRandomEmailInValid2() {
        String randomEmail;
        String generatedString1 = RandomStringUtils.randomAlphanumeric(5);
        String generatedString2 = RandomStringUtils.randomAlphanumeric(5);
        randomEmail = generatedString1 + "@" + generatedString2 + "@gmail.com";
        return randomEmail;
    }

    //a"b(c)d,e:f;g<h>i[j\k]l@example.com    ( "  none of the special characters in this local-part are allowed outside quotation marks )
    public String generateRandomEmailInValid3() {
        String randomEmail;
        String generatedString1 = RandomStringUtils.randomAlphanumeric(2);
        String generatedString2 = RandomStringUtils.randomAlphanumeric(2);
        randomEmail = generatedString1 + "\\" + generatedString2 + ".gmail.com";
        return randomEmail;
    }

    // just"not"right@example.com (quoted strings must be dot separated or the only element making up the local-part)
    public String generateRandomEmailInValid4() {
        String randomEmail;
        String generatedString1 = RandomStringUtils.randomAlphanumeric(2);
        String generatedString2 = RandomStringUtils.randomAlphanumeric(2);
        randomEmail = generatedString1 + "\"" + generatedString2 + ".gmail.com";
        return randomEmail;
    }

    //this is"not\allowed@example.com (spaces, quotes, and backslashes may only exist when within quoted strings and preceded by a backslash)
    public String generateRandomEmailInValid5() {
        String randomEmail;
        String generatedString1 = RandomStringUtils.randomAlphanumeric(2);
        String generatedString2 = RandomStringUtils.randomAlphanumeric(2);
        randomEmail = generatedString1 + " " + generatedString2 + ".gmail.com";
        return randomEmail;
    }

    //i_like_underscore@but_its_not_allowed_in_this_part.example.com (Underscore is not allowed in domain part)
    public String generateRandomEmailInValid6() {
        String randomEmail;
        String generatedString1 = RandomStringUtils.randomAlphanumeric(2);
        String generatedString2 = RandomStringUtils.randomAlphanumeric(2);
        randomEmail = generatedString1 + "_" + generatedString2 + ".gmail.com";
        return randomEmail;
    }

    //endregion

    //region <Navigation>
    public void navigateForward() {
        driver.navigate().forward();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateRefresh() {
        driver.navigate().refresh();
    }

    public void navigateToUrl(String url) {
        driver.navigate().to(url);
    }

    //endregion

    //region <Window Handling>
    public void handleWindowsWithArrayList(int index) {
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(index));
//        //switch to new tab
//        driver.switchTo().window(newTb.get(1));
//        //switch to parent window
//        driver.switchTo().window(newTb.get(0));
    }

    public void switchToTab(String name) {
        driver.switchTo().window(name);
    }

    public void switchToNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public void switchToDefaultTab() {
        driver.switchTo().defaultContent();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    //endregion

    //region <Local storage>
    public org.openqa.selenium.html5.LocalStorage getLocalStorage() {
        WebStorage webStorage = (WebStorage) driver;
        return webStorage.getLocalStorage();
    }

    public String getItem(String key) {
        return getLocalStorage().getItem(key);
    }

    public void setItem(String key, String value) {
        getLocalStorage().setItem(key, value);
    }

    //endregion

    /* this method will be return integer number num symbols */
    public static String randomNum(int num) {
        String generatedInt = RandomStringUtils.randomNumeric(num);
        return (generatedInt);
    }

    /* this method will be return True if Response cod is 0-300 */
    public static boolean checkConnectionUrlResponseCod(String url) {
        boolean responseCodOK;

        if (url == null || url.isEmpty()) {
            System.out.println("  Empty link");
            responseCodOK = false;
        } else {
            try {
                URL link = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) link.openConnection();
                connection.connect();
                int cod = connection.getResponseCode();

                if (cod >= 100 && cod < 200) {
//                    System.out.println(url + " Info Message  " + cod);
                    responseCodOK = true;
                } else if (cod >= 200 && cod < 300) {
//                    System.out.println(url + " Response cod is OK  " + cod);
                    responseCodOK = true;
                } else if (cod >= 300 && cod < 400) {
//                    System.out.println(url + " Server Redirection  " + cod);
                    responseCodOK = false;
                } else if (cod >= 400 && cod < 500) {
//                    System.out.println(url + " Client error  " + cod);
                    responseCodOK = false;
                } else if (cod >= 500) {
//                    System.out.println(url + " Server error  " + cod);
                    responseCodOK = false;
                } else {
//                    System.out.println(" Something went wrong  ");
                    responseCodOK = false;
                }

            } catch (Exception e) {
                responseCodOK = false;
//                System.out.println("We have Exception  --> " + e);
            }
        }

        return responseCodOK;
    }

    public ArrayList<String> getBrowserErrors() {
        driver.get("https://pokies2go.io/casino/all-games");
        ArrayList<String> browserErrors = new ArrayList<>();
        LogEntries logEntries = driver.manage().logs().get("browser");
        int i = 1;
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            String errorLogType = entry.getLevel().toString();
            String errorLog = entry.getMessage().toString();
            if (errorLog.contains("400") || errorLog.contains("401") || errorLog.contains("402") || errorLog.contains("403") || errorLog.contains("404") || errorLog.contains("405") || errorLog.contains("Error") || errorLog.contains("ERROR") || errorLog.contains("error") || errorLog.contains("Failed") || errorLog.contains("Unchecked") || errorLog.contains("Uncaught")) {
                browserErrors.add("Error LogType: " + errorLogType + " Error Log message: " + errorLog);
                i++;
            }
        }

        return browserErrors;
    }
}