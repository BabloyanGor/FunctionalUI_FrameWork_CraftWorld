package pageObjects;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class API_ConfigJson extends BasePage{

    private final BasePage basePage;

    public API_ConfigJson(WebDriver driver) throws AWTException {
        super(driver);
        basePage = new BasePage(driver);
    }

        //ConfigJsonApi call Vars

    private static int PartnerId=0;
    private static String PartnerName = null;
    private static String WebApiUrl = null;
    private static String DefaultCurrency = null;
    private static String Domain = null;
    private static int AllowedAge=0;
    private static String DefaultLanguage = null;
    private static boolean ShowGameNames = false;
    private static boolean ShowInfoPopup = false;
    private static String ReCaptchaKey = null;
    private static  boolean IsReCaptcha = false;
    private static String HomePageType = null;
    private static String CashierPageUrl = null;
    private static String RedirectUrl = null;
    private static String ShowMobileNavPanel = null;
    private static String EmailAddress = null;
    private static JSONArray LanguagesConfigJson = new JSONArray();
    private static JSONArray Currencies = new JSONArray();
    private static JSONArray ProductsWithTransfer = new JSONArray();
    private static JSONArray MobileCodes = new JSONArray();
    private static JSONArray RegisterType = new JSONArray();
    private static JSONArray QuickRegisterType = new JSONArray();
    private static JSONArray SocialNetworkProviders = new JSONArray();
    private static JSONArray ExternalBalance = new JSONArray();
    private static String LicenseUrl = null;
    private static JSONArray FooterVisibility = new JSONArray();
    private static String HomeBGImage = null;
    private static JSONArray GameLayouts = new JSONArray();
    private static String TimeZone = null;
    private static String SelfExclusionPeriod = null;
    private static String ErrorDisplayTime = null;
    private static String AccountTemplateType = null;
    private static String SportOpenMode = null;
    private static String ShowLogoutInfoPopup = null;
    private static String PassRegEx = null;
    private static String CheckPortrait = null;
    private static JSONArray WebFragments = new JSONArray();
    // MobileFragments
    private static int WinnersWidget=0;
    private static JSONArray RegExProperty = new JSONArray();
    private static String WebSlideMode = null;
    private static  boolean VerificationKeyFormat = false;
    private static String FormValidationType = null;




    private static int registrationTypesCount = 0;
    private static String registrationTypesFirstRegFormName = null;
    private static String registrationTypesSecondRegFormName = null;
    private static boolean registrationTypeFirstIsAutologinOn = false;
    private static boolean registrationTypeSecondIsAutologinOn = false;


    //                 Registration  <Types>  <Order>  <AutoLogin>
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static int getRegistrationTypesCount() {
        return registrationTypesCount;
    }
    public static String getRegistrationTypesFirstRegFormName() {
        return registrationTypesFirstRegFormName;
    }
    public static String getRegistrationTypesSecondRegFormName() {
        return registrationTypesSecondRegFormName;
    }
    public static boolean isRegistrationTypeFirstIsAutologinOn() {
        return registrationTypeFirstIsAutologinOn;
    }
    public static boolean isRegistrationTypeSecondIsAutologinOn() {
        return registrationTypeSecondIsAutologinOn;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





    public int getPartnerId() {
        return PartnerId;
    }

    public String getPartnerName() {
        return PartnerName;
    }

    public String getWebApiUrl() {
        return WebApiUrl;
    }

    public String getDefaultCurrency() {
        return DefaultCurrency;
    }

    public String getDomain() {
        return Domain;
    }

    public int getAllowedAge() {
        return AllowedAge;
    }

    public String getDefaultLanguage() {
        return DefaultLanguage;
    }

    public boolean isShowGameNames() {
        return ShowGameNames;
    }

    public boolean isShowInfoPopup() {
        return ShowInfoPopup;
    }

    public String getReCaptchaKey() {
        return ReCaptchaKey;
    }

    public boolean isReCaptcha() {
        return IsReCaptcha;
    }

    public String getHomePageType() {
        return HomePageType;
    }

    public String getCashierPageUrl() {
        return CashierPageUrl;
    }

    public String getRedirectUrl() {
        return RedirectUrl;
    }

    public String getShowMobileNavPanel() {
        return ShowMobileNavPanel;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }


    public JSONArray getLanguagesConfigJson() {
        return LanguagesConfigJson;
    }

                                            public JSONArray getCurrencies() {
        return Currencies;
    }

    public JSONArray getProductsWithTransfer() {
        return ProductsWithTransfer;
    }

                                            public JSONArray getMobileCodes() {
        return MobileCodes;
    }

                                            public JSONArray getRegisterType() {
        return RegisterType;
    }

    public JSONArray getQuickRegisterType() {
        return QuickRegisterType;
    }

    public JSONArray getSocialNetworkProviders() {
        return SocialNetworkProviders;
    }

    public JSONArray getExternalBalance() {
        return ExternalBalance;
    }

    public String getLicenseUrl() {
        return LicenseUrl;
    }

    public JSONArray getFooterVisibility() {
        return FooterVisibility;
    }

    public String getHomeBGImage() {
        return HomeBGImage;
    }

    public JSONArray getGameLayouts() {
        return GameLayouts;
    }

    public String getTimeZone() {
        return TimeZone;
    }

    public String getSelfExclusionPeriod() {
        return SelfExclusionPeriod;
    }

    public String getErrorDisplayTime() {
        return ErrorDisplayTime;
    }

    public String getAccountTemplateType() {
        return AccountTemplateType;
    }

    public String getSportOpenMode() {
        return SportOpenMode;
    }

    public String getShowLogoutInfoPopup() {
        return ShowLogoutInfoPopup;
    }

                                                                public String getPassRegEx() {
        return PassRegEx;
    }

    public String getCheckPortrait() {
        return CheckPortrait;
    }

    public JSONArray getWebFragments() {
        return WebFragments;
    }

    public int getWinnersWidget() {
        return WinnersWidget;
    }

                                                                public JSONArray getRegExProperty() {
        return RegExProperty;
    }

    public String getWebSlideMode() {
        return WebSlideMode;
    }

    public boolean isVerificationKeyFormat() {
        return VerificationKeyFormat;
    }

    public String getFormValidationType() {
        return FormValidationType;
    }





    private String configJsonApi() {
        try{
            int statusCod;
            String configJsonApiBody;
            HttpResponse<String> responseConfigJson;
            Unirest.setTimeouts(0, 0);
            responseConfigJson = Unirest.get(baseURL+"/assets/json/config.json?="+versionJSCorePlatform())
                    .header("content-type", "application/json")
                    .asString();
            statusCod = responseConfigJson.getStatus();
            configJsonApiBody = responseConfigJson.getBody();
            Unirest.shutdown();
            if (statusCod != 200) {
                Unirest.setTimeouts(0, 0);
                responseConfigJson = Unirest.get(baseURL + "/assets/json/config.json?=" + versionJSCorePlatform())
                        .header("content-type", "application/json")
                        .asString();
                configJsonApiBody = responseConfigJson.getBody();
            }
            return configJsonApiBody;
        }
        catch(Exception e){
            try{
                int statusCod;
                String configJsonApiBody;
                HttpResponse<String> responseConfigJson;
                Unirest.setTimeouts(0, 0);
                responseConfigJson = Unirest.get(baseURL+"/assets/json/config.json?="+versionJSCorePlatform())
                        .header("content-type", "application/json")
                        .asString();
                statusCod = responseConfigJson.getStatus();
                configJsonApiBody = responseConfigJson.getBody();
                Unirest.shutdown();
                if (statusCod != 200) {
                    Unirest.setTimeouts(0, 0);
                    responseConfigJson = Unirest.get(baseURL + "/assets/json/config.json?=" + versionJSCorePlatform())
                            .header("content-type", "application/json")
                            .asString();
                    configJsonApiBody = responseConfigJson.getBody();
                }
                return configJsonApiBody;
            }
            catch(Exception k){
                System.out.println("configJsonApi call has exception: " + k);
                return "APIConfigJson API call has exception: " + k;

            }
        }
    }

    public void configJsonApiJsonParse(){
        JSONObject jsonObjectBody = new JSONObject(configJsonApi());

        try{
            PartnerId = jsonObjectBody.getInt("PartnerId");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> PartnerId has an Exception: " + e);
        }

        try{
            PartnerName = jsonObjectBody.getString("PartnerName");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> PartnerName has an Exception: " + e);
        }

        try{
            WebApiUrl = jsonObjectBody.getString("WebApiUrl");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> WebApiUrl has an Exception: " + e);
        }

        try{
            DefaultCurrency = jsonObjectBody.getString("DefaultCurrency");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> DefaultCurrency has an Exception: " + e);
        }

        try{
            Domain = jsonObjectBody.getString("Domain");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> Domain has an Exception: " + e);
        }

        try{
            AllowedAge = jsonObjectBody.getInt("AllowedAge");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> AllowedAge has an Exception: " + e);
        }

        try{
            DefaultLanguage = jsonObjectBody.getString("DefaultLanguage");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> DefaultLanguage has an Exception: " + e);
        }

        try{
            ShowGameNames = jsonObjectBody.getBoolean("ShowGameNames");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> ShowGameNames has an Exception: " + e);
        }

        try{
            ShowInfoPopup = jsonObjectBody.getBoolean("ShowInfoPopup");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> ShowInfoPopup has an Exception: " + e);
        }

        try{
            ReCaptchaKey = jsonObjectBody.getString("ReCaptchaKey");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> ReCaptchaKey has an Exception: " + e);
        }

        try{
            IsReCaptcha = jsonObjectBody.getBoolean("IsReCaptcha");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> IsReCaptcha has an Exception: " + e);
        }

        try{
            HomePageType = jsonObjectBody.getString("HomePageType");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> HomePageType has an Exception: " + e);
        }

        try{
            CashierPageUrl = jsonObjectBody.getString("CashierPageUrl");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> CashierPageUrl has an Exception: " + e);
        }

        try{
            RedirectUrl = jsonObjectBody.getString("RedirectUrl");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> RedirectUrl has an Exception: " + e);
        }

        try{
            ShowMobileNavPanel = jsonObjectBody.getString("ShowMobileNavPanel");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> ShowMobileNavPanel has an Exception: " + e);
        }

        try{
            EmailAddress = jsonObjectBody.getString("EmailAddress");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> EmailAddress has an Exception: " + e);
        }

        try{
            LanguagesConfigJson = jsonObjectBody.getJSONArray("Languages");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> Languages has an Exception: " + e);
        }

        try{
            Currencies = jsonObjectBody.getJSONArray("Currencies");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> Currencies has an Exception: " + e);
        }

        try{
            ProductsWithTransfer = jsonObjectBody.getJSONArray("ProductsWithTransfer");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> ProductsWithTransfer has an Exception: " + e);
        }

        try{
            MobileCodes = jsonObjectBody.getJSONArray("MobileCodes");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> MobileCodes has an Exception: " + e);
        }

        try{
            RegisterType = jsonObjectBody.getJSONArray("RegisterType");
            registrationTypesCount = RegisterType.length();
            if (registrationTypesCount==2){
                String firstReg = String.valueOf(RegisterType.get(0));
                JSONObject jsonFirstReg = new JSONObject(firstReg);
                registrationTypesFirstRegFormName = String.valueOf(jsonFirstReg.get("Title"));
                String isAutologinOn1 = String.valueOf(jsonFirstReg.get("Settings"));
                if (isAutologinOn1.contains("1")){
                    registrationTypeFirstIsAutologinOn = true;
                }


                String secondReg = String.valueOf(RegisterType.get(1));
                JSONObject jsonSecondReg = new JSONObject(secondReg);
                registrationTypesSecondRegFormName = String.valueOf(jsonSecondReg.get("Title"));
                String isAutologinOn2 = String.valueOf(jsonFirstReg.get("Settings"));
                if (isAutologinOn2.contains("1")){
                    registrationTypeSecondIsAutologinOn = true;
                }

            }
            else{
                String firstReg = String.valueOf(RegisterType.get(0));
                JSONObject jsonFirstReg = new JSONObject(firstReg);
                registrationTypesFirstRegFormName = String.valueOf(jsonFirstReg.get("Title"));
                String isAutologinOn = String.valueOf(jsonFirstReg.get("Settings"));
                if (isAutologinOn.contains("1")){
                    registrationTypeFirstIsAutologinOn = true;
                }

            }







        }
        catch (Exception e){
            System.out.println("APIConfigJson --> RegisterType has an Exception: " + e);
        }

        try{
            QuickRegisterType = jsonObjectBody.getJSONArray("QuickRegisterType");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> QuickRegisterType has an Exception: " + e);
        }

        try{
            SocialNetworkProviders = jsonObjectBody.getJSONArray("SocialNetworkProviders");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> SocialNetworkProviders has an Exception: " + e);
        }

        try{
            ExternalBalance = jsonObjectBody.getJSONArray("ExternalBalance");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> ExternalBalance has an Exception: " + e);
        }

        try{
            LicenseUrl = jsonObjectBody.getString("LicenseUrl");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> LicenseUrl has an Exception: " + e);
        }

        try{
            FooterVisibility = jsonObjectBody.getJSONArray("FooterVisibility");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> FooterVisibility has an Exception: " + e);
        }

        try{
            HomeBGImage = jsonObjectBody.getString("HomeBGImage");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> HomeBGImage has an Exception: " + e);
        }

        try{
            GameLayouts = jsonObjectBody.getJSONArray("GameLayouts");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> GameLayouts has an Exception: " + e);
        }

        try{
            TimeZone = jsonObjectBody.getString("TimeZone");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> TimeZone has an Exception: " + e);
        }

        try{
            SelfExclusionPeriod = jsonObjectBody.getString("SelfExclusionPeriod");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> SelfExclusionPeriod has an Exception: " + e);
        }

        try{
            ErrorDisplayTime = jsonObjectBody.getString("ErrorDisplayTime");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> ErrorDisplayTime has an Exception: " + e);
        }

        try{
            AccountTemplateType = jsonObjectBody.getString("AccountTemplateType");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> AccountTemplateType has an Exception: " + e);
        }


        try{
            SportOpenMode = jsonObjectBody.getString("SportOpenMode");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> SportOpenMode has an Exception: " + e);
        }


        try{
            ShowLogoutInfoPopup = jsonObjectBody.getString("ShowLogoutInfoPopup");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> ShowLogoutInfoPopup has an Exception: " + e);
        }


        try{
            PassRegEx = jsonObjectBody.getString("PassRegEx");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> PassRegEx has an Exception: " + e);
        }

        try{
            CheckPortrait = jsonObjectBody.getString("CheckPortrait");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> CheckPortrait has an Exception: " + e);
        }

        try{
            WebFragments = jsonObjectBody.getJSONArray("WebFragments");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> WebFragments has an Exception: " + e);
        }

//        try{
//            MobileFragments = jsonObjectBody.getString("MobileFragments");
//        }
//        catch (Exception e){
//            System.out.println("APIConfigJson --> MobileFragments has an Exception: " + e);
//        }

        try {
            WinnersWidget = jsonObjectBody.getInt("WinnersWidget");
        } catch (Exception e) {
            System.out.println("APIConfigJson --> WinnersWidget has an Exception: " + e);
        }

        try{
            RegExProperty = jsonObjectBody.getJSONArray("RegExProperty");
        }
        catch (Exception e){
            System.out.println("APIConfigJson --> RegExProperty has an Exception: " + e);
        }

        try {
            WebSlideMode = jsonObjectBody.getString("WebSlideMode");
        } catch (Exception e) {
            System.out.println("APIConfigJson --> WebSlideMode has an Exception: " + e);
        }

        try {
            VerificationKeyFormat = jsonObjectBody.getBoolean("VerificationKeyFormat");
        } catch (Exception e) {
            System.out.println("APIConfigJson --> VerificationKeyFormat has an Exception: " + e);
        }


        try {
            FormValidationType = jsonObjectBody.getString("FormValidationType");
        } catch (Exception e) {
            System.out.println("APIConfigJson --> FormValidationType has an Exception: " + e);
        }




    }




























}
