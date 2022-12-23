package testCases;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ServersLoadTest extends BaseTest {

    public ServersLoadTest() throws AWTException {
    }

    @BeforeClass
    public void logIn() throws UnirestException, IOException {
    }


    public static ArrayList<String> sportsBookMaster = new ArrayList<>();
    public static ArrayList<String> sportsBookSlave = new ArrayList<>();
    public static ArrayList<String> sportsBookDB = new ArrayList<>();
    public static ArrayList<String> corePlatformMaster = new ArrayList<>();
    public static ArrayList<String> corePlatformSlave = new ArrayList<>();
    public static ArrayList<String> corePlatformDB = new ArrayList<>();

    @Test
    public void test() throws UnirestException, IOException, InterruptedException {

        for (int g = 0; g < 5; g++) {

            JSONArray responseArray;
            HttpResponse<String> response = craftBet_01_header_pageLogInUser.serverLoad();
            if (response!=null){
                responseArray = new JSONArray(response.getBody());
                for (int i = 0; i < responseArray.length(); i++) {
                    String serverPC = responseArray.get(i).toString();
                    JSONObject firstArray = new JSONObject(serverPC);
                    String pcInformations = firstArray.get("pcInformations").toString();
                    JSONObject pcInformationsJson = new JSONObject(pcInformations);
                    String serverName = pcInformationsJson.get("name").toString();
                    String systemMemory = pcInformationsJson.get("systemMemory").toString();
                    String cpu = pcInformationsJson.get("cpu").toString();
                    switch (serverName) {

                        case "Sportsbook Slave": {
                            sportsBookSlave.add("SystemMemory: " + systemMemory + "  Cpu:" + cpu);
                            break;
                        }
                        case "Sportsbook Master": {
                            sportsBookMaster.add("SystemMemory: " + systemMemory + "  Cpu:" + cpu);
                            break;
                        }
                        case "Sportsbook DB": {
                            sportsBookDB.add("SystemMemory: " + systemMemory + "  Cpu:" + cpu);
                            break;
                        }
                        case "Core Platform Slave": {
                            corePlatformSlave.add("Ram: " + systemMemory + "  Cpu:" + cpu);
                            break;
                        }
                        case "Core Platform Master": {
                            corePlatformMaster.add("Ram: " + systemMemory + "  Cpu:" + cpu);
                            break;
                        }
                        case "Core Platform DB": {
                            corePlatformDB.add("Ram: " + systemMemory + "  Cpu:" + cpu);
                            break;
                        }
                        default: {
                        }
                    }
                }
                TimeUnit.SECONDS.sleep(2);
            }
        }

        craftBet_01_header_pageLogInUser.writeInExelSixArrayList(sportsBookSlave,sportsBookMaster,sportsBookDB,corePlatformSlave,corePlatformMaster,corePlatformDB,
                "/src/test/java/testData/ServerReport.xlsx", "ServerInfo");

    }




}