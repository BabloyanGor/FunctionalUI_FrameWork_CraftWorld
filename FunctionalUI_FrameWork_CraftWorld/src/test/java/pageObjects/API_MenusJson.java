package pageObjects;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class API_MenusJson extends BasePage{

    private final BasePage basePage;

    public API_MenusJson(WebDriver driver) throws AWTException {
        super(driver);
        basePage = new BasePage(driver);
    }


    private String  MenusJsonApi() {
        try{
            int statusCod;
            String menusJsonApiBody;
            HttpResponse<String> responseConfigJson;

            Unirest.setTimeouts(0, 0);
            responseConfigJson = Unirest.get(baseURL+"/assets/json/menu.json?="+versionJSCorePlatform())
                    .header("content-type", "application/json")
                    .asString();


            statusCod = responseConfigJson.getStatus();
            menusJsonApiBody = responseConfigJson.getBody();
            Unirest.shutdown();

            if (statusCod != 200) {
                Unirest.setTimeouts(0, 0);
                responseConfigJson = Unirest.get(baseURL+"/assets/json/menu.json?="+versionJSCorePlatform())
                        .header("content-type", "application/json")
                        .asString();
                menusJsonApiBody = responseConfigJson.getBody();
            }
            return menusJsonApiBody;
        }
        catch(Exception e){
            try{
                int statusCod;
                String menusJsonApiBody;
                HttpResponse<String> responseConfigJson;
                Unirest.setTimeouts(0, 0);
                responseConfigJson = Unirest.get(baseURL+"/assets/json/menu.json?="+versionJSCorePlatform())
                        .header("content-type", "application/json")
                        .asString();
                statusCod = responseConfigJson.getStatus();
                menusJsonApiBody = responseConfigJson.getBody();
                Unirest.shutdown();

                if (statusCod != 200) {
                    Unirest.setTimeouts(0, 0);
                    responseConfigJson = Unirest.get(baseURL+"/assets/json/menu.json?="+versionJSCorePlatform())
                            .header("content-type", "application/json")
                            .asString();
                    menusJsonApiBody = responseConfigJson.getBody();
                }
                return menusJsonApiBody;
            }
            catch(Exception k){
                System.out.println("menusJsonApiBody call has exception: " + k);
                return "APIMenusJsonApi API call has exception: " + k;

            }
        }
    }


    public void headerPanel1Menu(){
        JSONObject jsonObjectBody = new JSONObject(MenusJsonApi());
        JSONArray jsonArrayMenuList = jsonObjectBody.getJSONArray("MenuList");
        for (int i = 0; i<jsonArrayMenuList.length(); i++ ){
            String jsonObjectString = String.valueOf(jsonArrayMenuList.get(i));
            JSONObject jsonObject = new JSONObject(jsonObjectString);
            String Type = String.valueOf(jsonObject.get("Type"));
            if (Type.equals("HeaderPanel1Menu")){
                JSONArray jsonArrayItems = jsonObject.getJSONArray("Items");
                for (int j = 0; j<jsonArrayItems.length(); j++){
                    String HeaderPanel1MenuItemString = String.valueOf(jsonArrayItems.get(j));
                    JSONObject jsonObjectHeaderPanel1MenuItemString = new JSONObject(HeaderPanel1MenuItemString);
                    String Title = String.valueOf(jsonObjectHeaderPanel1MenuItemString.get("Title"));

                    System.out.println("Title: "+ Title);
                    if (Title.equals("Login Button")){
                        Gson gson = new Gson();
                        String HeaderPanel1LoginButtonStyleType = String.valueOf(jsonObjectHeaderPanel1MenuItemString.get("StyleType"));
                        System.out.println("HeaderPanel1LoginButtonStyleType " + HeaderPanel1LoginButtonStyleType);

//                        String jsonObjectHeaderPanel1LoginButtonStyleType = gson.fromJson(HeaderPanel1LoginButtonStyleType);
//                        System.out.println("jsonObjectHeaderPanel1LoginButtonStyleType " + jsonObjectHeaderPanel1LoginButtonStyleType);
//                        JSONObject style = new JSONObject(jsonObjectHeaderPanel1LoginButtonStyleType);
//                        System.out.println("style " + style);
//                        String HeaderPanel1LoginButtonStyleTypeStyle = String.valueOf(jsonObjectHeaderPanel1MenuItemString.get("style"));
//                        System.out.println("HeaderPanel1LoginButtonStyleTypeStyle " + HeaderPanel1LoginButtonStyleTypeStyle);
                    }
                }

            }
        }

    }

    public void headerPanel2Menu(){
        JSONObject jsonObjectBody = new JSONObject(MenusJsonApi());
        JSONArray jsonArrayMenuList = jsonObjectBody.getJSONArray("MenuList");
        for (int i = 0; i<jsonArrayMenuList.length(); i++ ){
            String jsonObjectString = String.valueOf(jsonArrayMenuList.get(i));
            JSONObject jsonObject = new JSONObject(jsonObjectString);
            String Type = String.valueOf(jsonObject.get("Type"));
            if (Type.equals("HeaderPanel2Menu")){
                JSONArray jsonArrayItems = jsonObject.getJSONArray("Items");
                System.out.println(i +"-------->  " +  jsonArrayItems);
            }


        }

    }



    public void headerGroup1Menu(){
        JSONObject jsonObjectBody = new JSONObject(MenusJsonApi());
        JSONArray jsonArrayMenuList = jsonObjectBody.getJSONArray("MenuList");
        for (int i = 0; i<jsonArrayMenuList.length(); i++ ){
            String jsonObjectString = String.valueOf(jsonArrayMenuList.get(i));
            JSONObject jsonObject = new JSONObject(jsonObjectString);
            String Type = String.valueOf(jsonObject.get("Type"));
            if (Type.equals("HeaderGroup1Menu")){
                JSONArray jsonArrayItems = jsonObject.getJSONArray("Items");
                System.out.println(i +"-------->  " +  jsonArrayItems);
            }


        }

    }

    public void registration(){
        JSONObject jsonObjectBody = new JSONObject(MenusJsonApi());
        JSONArray jsonArrayMenuList = jsonObjectBody.getJSONArray("MenuList");
        for (int i = 0; i<jsonArrayMenuList.length(); i++ ){
            String jsonObjectString = String.valueOf(jsonArrayMenuList.get(i));
            JSONObject jsonObject = new JSONObject(jsonObjectString);
            String Type = String.valueOf(jsonObject.get("Type"));
            if (Type.equals("Registration")){
                JSONArray jsonArrayItems = jsonObject.getJSONArray("Items");
                System.out.println(i +"-------->  " +  jsonArrayItems);
            }


        }

    }


    public void footerMenu(){
        JSONObject jsonObjectBody = new JSONObject(MenusJsonApi());
        JSONArray jsonArrayMenuList = jsonObjectBody.getJSONArray("MenuList");
        for (int i = 0; i<jsonArrayMenuList.length(); i++ ){
            String jsonObjectString = String.valueOf(jsonArrayMenuList.get(i));
            JSONObject jsonObject = new JSONObject(jsonObjectString);
            String Type = String.valueOf(jsonObject.get("Type"));
            if (Type.equals("FooterMenu")){
                JSONArray jsonArrayItems = jsonObject.getJSONArray("Items");
                System.out.println(i +"-------->  " +  jsonArrayItems);
            }


        }

    }



    public void casinoMenu(){
        JSONObject jsonObjectBody = new JSONObject(MenusJsonApi());
        JSONArray jsonArrayMenuList = jsonObjectBody.getJSONArray("MenuList");
        for (int i = 0; i<jsonArrayMenuList.length(); i++ ){
            String jsonObjectString = String.valueOf(jsonArrayMenuList.get(i));
            JSONObject jsonObject = new JSONObject(jsonObjectString);
            String Type = String.valueOf(jsonObject.get("Type"));
            if (Type.equals("CasinoMenu")){
                JSONArray jsonArrayItems = jsonObject.getJSONArray("Items");
                System.out.println(i +"-------->  " +  jsonArrayItems);
            }


        }

    }



    public void newsMenu(){
        JSONObject jsonObjectBody = new JSONObject(MenusJsonApi());
        JSONArray jsonArrayMenuList = jsonObjectBody.getJSONArray("MenuList");
        for (int i = 0; i<jsonArrayMenuList.length(); i++ ){
            String jsonObjectString = String.valueOf(jsonArrayMenuList.get(i));
            JSONObject jsonObject = new JSONObject(jsonObjectString);
            String Type = String.valueOf(jsonObject.get("Type"));
            if (Type.equals("NewsMenu")){
                JSONArray jsonArrayItems = jsonObject.getJSONArray("Items");
                System.out.println(i +"-------->  " +  jsonArrayItems);
            }


        }

    }





    public void accountTabsList(){
        JSONObject jsonObjectBody = new JSONObject(MenusJsonApi());
        JSONArray jsonArrayMenuList = jsonObjectBody.getJSONArray("MenuList");
        for (int i = 0; i<jsonArrayMenuList.length(); i++ ){
            String jsonObjectString = String.valueOf(jsonArrayMenuList.get(i));
            JSONObject jsonObject = new JSONObject(jsonObjectString);
            String Type = String.valueOf(jsonObject.get("Type"));
            if (Type.equals("AccountTabsList")){
                JSONArray jsonArrayItems = jsonObject.getJSONArray("Items");
                System.out.println(i +"-------->  " +  jsonArrayItems);
            }


        }

    }



    public void homeMenu(){
        JSONObject jsonObjectBody = new JSONObject(MenusJsonApi());
        JSONArray jsonArrayMenuList = jsonObjectBody.getJSONArray("MenuList");
        for (int i = 0; i<jsonArrayMenuList.length(); i++ ){
            String jsonObjectString = String.valueOf(jsonArrayMenuList.get(i));
            JSONObject jsonObject = new JSONObject(jsonObjectString);
            String Type = String.valueOf(jsonObject.get("Type"));
            if (Type.equals("HomeMenu")){
                JSONArray jsonArrayItems = jsonObject.getJSONArray("Items");
                System.out.println(i +"-------->  " +  jsonArrayItems);
            }


        }

    }


    public void assets(){
        JSONObject jsonObjectBody = new JSONObject(MenusJsonApi());
        JSONArray jsonArrayMenuList = jsonObjectBody.getJSONArray("MenuList");
        for (int i = 0; i<jsonArrayMenuList.length(); i++ ){
            String jsonObjectString = String.valueOf(jsonArrayMenuList.get(i));
            JSONObject jsonObject = new JSONObject(jsonObjectString);
            String Type = String.valueOf(jsonObject.get("Type"));
            if (Type.equals("Assets")){
                JSONArray jsonArrayItems = jsonObject.getJSONArray("Items");
                System.out.println(i +"-------->  " +  jsonArrayItems);
            }


        }

    }


    public void liveCasinoMenu(){
        JSONObject jsonObjectBody = new JSONObject(MenusJsonApi());
        JSONArray jsonArrayMenuList = jsonObjectBody.getJSONArray("MenuList");
        for (int i = 0; i<jsonArrayMenuList.length(); i++ ){
            String jsonObjectString = String.valueOf(jsonArrayMenuList.get(i));
            JSONObject jsonObject = new JSONObject(jsonObjectString);
            String Type = String.valueOf(jsonObject.get("Type"));
            if (Type.equals("LiveCasinoMenu")){
                JSONArray jsonArrayItems = jsonObject.getJSONArray("Items");
                System.out.println(i +"-------->  " +  jsonArrayItems);
            }


        }

    }





    ///////////////////////////////////////////////////////   Mobile_Part   \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    public void mobileRightSidebar(){
        JSONObject jsonObjectBody = new JSONObject(MenusJsonApi());
        JSONArray jsonArrayMenuList = jsonObjectBody.getJSONArray("MenuList");
        for (int i = 0; i<jsonArrayMenuList.length(); i++ ){
            String jsonObjectString = String.valueOf(jsonArrayMenuList.get(i));
            JSONObject jsonObject = new JSONObject(jsonObjectString);
            String Type = String.valueOf(jsonObject.get("Type"));
            if (Type.equals("MobileRightSidebar")){
                JSONArray jsonArrayItems = jsonObject.getJSONArray("Items");
                System.out.println(i +"-------->  " +  jsonArrayItems);
            }


        }

    }

    public void mobileFooterMenu(){
        JSONObject jsonObjectBody = new JSONObject(MenusJsonApi());
        JSONArray jsonArrayMenuList = jsonObjectBody.getJSONArray("MenuList");
        for (int i = 0; i<jsonArrayMenuList.length(); i++ ){
            String jsonObjectString = String.valueOf(jsonArrayMenuList.get(i));
            JSONObject jsonObject = new JSONObject(jsonObjectString);
            String Type = String.valueOf(jsonObject.get("Type"));
            if (Type.equals("MobileFooterMenu")){
                JSONArray jsonArrayItems = jsonObject.getJSONArray("Items");
                System.out.println(i +"-------->  " +  jsonArrayItems);
            }


        }

    }

    public void mobileHomeMenu(){
        JSONObject jsonObjectBody = new JSONObject(MenusJsonApi());
        JSONArray jsonArrayMenuList = jsonObjectBody.getJSONArray("MenuList");
        for (int i = 0; i<jsonArrayMenuList.length(); i++ ){
            String jsonObjectString = String.valueOf(jsonArrayMenuList.get(i));
            JSONObject jsonObject = new JSONObject(jsonObjectString);
            String Type = String.valueOf(jsonObject.get("Type"));
            if (Type.equals("MobileHomeMenu")){
                JSONArray jsonArrayItems = jsonObject.getJSONArray("Items");
                System.out.println(i +"-------->  " +  jsonArrayItems);
            }


        }

    }

    public void mobileHeaderPanel(){
        JSONObject jsonObjectBody = new JSONObject(MenusJsonApi());
        JSONArray jsonArrayMenuList = jsonObjectBody.getJSONArray("MenuList");
        for (int i = 0; i<jsonArrayMenuList.length(); i++ ){
            String jsonObjectString = String.valueOf(jsonArrayMenuList.get(i));
            JSONObject jsonObject = new JSONObject(jsonObjectString);
            String Type = String.valueOf(jsonObject.get("Type"));
            if (Type.equals("MobileHeaderPanel")){
                JSONArray jsonArrayItems = jsonObject.getJSONArray("Items");
                System.out.println(i +"-------->  " +  jsonArrayItems);
            }


        }

    }

    public void mobileCentralMenu(){
        JSONObject jsonObjectBody = new JSONObject(MenusJsonApi());
        JSONArray jsonArrayMenuList = jsonObjectBody.getJSONArray("MenuList");
        for (int i = 0; i<jsonArrayMenuList.length(); i++ ){
            String jsonObjectString = String.valueOf(jsonArrayMenuList.get(i));
            JSONObject jsonObject = new JSONObject(jsonObjectString);
            String Type = String.valueOf(jsonObject.get("Type"));
            if (Type.equals("MobileCentralMenu")){
                JSONArray jsonArrayItems = jsonObject.getJSONArray("Items");
                System.out.println(i +"-------->  " +  jsonArrayItems);
            }


        }

    }

    public void mobileBottomMenu(){
        JSONObject jsonObjectBody = new JSONObject(MenusJsonApi());
        JSONArray jsonArrayMenuList = jsonObjectBody.getJSONArray("MenuList");
        for (int i = 0; i<jsonArrayMenuList.length(); i++ ){
            String jsonObjectString = String.valueOf(jsonArrayMenuList.get(i));
            JSONObject jsonObject = new JSONObject(jsonObjectString);
            String Type = String.valueOf(jsonObject.get("Type"));
            if (Type.equals("MobileBottomMenu")){
                JSONArray jsonArrayItems = jsonObject.getJSONArray("Items");
                System.out.println(i +"-------->  " +  jsonArrayItems);
            }


        }

    }


    public void mobileMenu(){
        JSONObject jsonObjectBody = new JSONObject(MenusJsonApi());
        JSONArray jsonArrayMenuList = jsonObjectBody.getJSONArray("MenuList");
        for (int i = 0; i<jsonArrayMenuList.length(); i++ ){
            String jsonObjectString = String.valueOf(jsonArrayMenuList.get(i));
            JSONObject jsonObject = new JSONObject(jsonObjectString);
            String Type = String.valueOf(jsonObject.get("Type"));
            if (Type.equals("MobileMenu")){
                JSONArray jsonArrayItems = jsonObject.getJSONArray("Items");
                System.out.println(i +"-------->  " +  jsonArrayItems);
            }


        }

    }



}
