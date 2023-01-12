package testCases;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.annotations.Test;
import pageObjects.API_ConfigJson;

import java.awt.*;

public class API_000_JsonConfig_Test extends BaseTest{


    public API_000_JsonConfig_Test() throws AWTException {
    }



    @Test
    public void test() throws UnirestException {
        System.out.println("Types count: "+ API_ConfigJson.getRegistrationTypesCount());
        System.out.println("getRegistrationTypesFirstRegFormName: "+ API_ConfigJson.getRegistrationTypesFirstRegFormName());
        System.out.println("getRegistrationTypesSecondRegFormName: "+ API_ConfigJson.getRegistrationTypesSecondRegFormName());
        System.out.println("isRegistrationTypeSecondIsAutologinOn: "+ API_ConfigJson.isRegistrationTypeSecondIsAutologinOn());
        System.out.println("isRegistrationTypeFirstIsAutologinOn: "+ API_ConfigJson.isRegistrationTypeFirstIsAutologinOn());







    }



}
