package testCases;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.annotations.Test;
import pageObjects.GenerateManyUsersAPI;

import java.awt.*;

public class createUsers {

    public createUsers() throws AWTException {
    }


    GenerateManyUsersAPI generateManyUsersAPI = new GenerateManyUsersAPI();
    @Test
    public void createUsers() throws UnirestException, AWTException {
        //region <Create 20000 users >


//        for (int z=0; z<cicle; z++){

            int w = 1;

            String email = "testuser" + w + "@gmail.com";
            String mobileNumber = "+374" + w + "000";
            String userName = "QA_" + w ;

            Gson gson = new Gson();
            Unirest.setTimeouts(0, 0);
            generateManyUsersAPI.setUserName(userName);
            generateManyUsersAPI.setMobileNumber(mobileNumber);
            generateManyUsersAPI.setEmail(email);

            String RegRequest = gson.toJson(generateManyUsersAPI);

            System.out.println(RegRequest);



            HttpResponse<String> response = Unirest.post("https://websitewebapi.craftbetstage.com/1/api/Main/RegisterClient")
                    .header("origin", "https://craftbetstage.com")
                    .header("Content-Type", "application/json")
                    .body(RegRequest)
                    .asString();


//        }

        }

        //endregion



}
