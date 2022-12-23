package testCases;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.BasePage;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ServersLoadTest {

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

    BaseTest baseTest = new BaseTest();
    BasePage basePage = new BasePage();
    @Test
    public void test() throws UnirestException, IOException, InterruptedException {

        for (int g = 0; g <130; g++) {

            JSONArray responseArray;
            HttpResponse<String> response = basePage.serverLoad();
            if (response!=null){
                responseArray = new JSONArray(response.getBody());

                try {
                    for (int i = 0; i < responseArray.length(); i++) {
                        String serverPC = responseArray.get(i).toString();
                        JSONObject firstArray = new JSONObject(serverPC);
                        String pcInformations = firstArray.get("pcInformations").toString();
                        JSONObject pcInformationsJson = new JSONObject(pcInformations);
                        String serverName = pcInformationsJson.get("name").toString();
                        String serverServiceText = pcInformationsJson.get("serviceText").toString();
                        String systemMemory = pcInformationsJson.get("systemMemory").toString();
                        String cpu = pcInformationsJson.get("cpu").toString();
                        switch (serverName) {

                            case "Sportsbook Slave": {
                                try {
                                    sportsBookSlave.add("Ram: " + systemMemory + "  Cpu:" + cpu);
                                }
                                catch(Exception a){
                                    System.out.println("Sportsbook Slave Exception: " + pcInformations);
                                }

                                break;
                            }
                            case "Sportsbook Master": {
                                try {
                                    sportsBookMaster.add("Ram: " + systemMemory + "  Cpu:" + cpu);
                                }
                                catch(Exception b){
                                    System.out.println("Sportsbook Master Exception: " + pcInformations);
                                }
                                break;
                            }
                            case "Sportsbook DB": {
                                try {
                                    sportsBookDB.add("Ram: " + systemMemory + "  Cpu:" + cpu);
                                }
                                catch(Exception c){
                                    System.out.println("Sportsbook DB Exception: " + pcInformations);
                                }
                                break;
                            }
                            case "Core Platform Slave": {
                                try {
                                    corePlatformSlave.add("Ram: " + systemMemory + "  Cpu:" + cpu);                                }
                                catch(Exception d){
                                    System.out.println("Core Platform Slave Exception: " + pcInformations);
                                }
                                break;
                            }
                            case "Core Platform Master": {
                                try {
                                    corePlatformMaster.add("Ram: " + systemMemory + "  Cpu:" + cpu);
                                }
                                catch(Exception e){
                                    System.out.println("Core Platform Master Exception: " + pcInformations);
                                    corePlatformMaster.add("serverServiceText: " + serverServiceText);
                                }
                                break;
                            }
                            case "Core Platform DB": {
                                try {
                                    corePlatformDB.add("Ram: " + systemMemory + "  Cpu:" + cpu);                                }
                                catch(Exception f){
                                    System.out.println("Core Platform DB Exception " + pcInformations);
                                }

                                break;
                            }

                            default: {
                                System.out.println("TestCase switch default >>> ServerName: " + serverName + " Error message: " + serverServiceText );

                            }
                        }
                    }
                }
                catch (Exception e){
                    System.out.println("TestCase Exception Main" + e);
                }

                TimeUnit.SECONDS.sleep(2);
            }
        }

        basePage.writeInExelSixArrayList(sportsBookSlave,sportsBookMaster,sportsBookDB,corePlatformSlave,corePlatformMaster,corePlatformDB,
                "/src/test/java/testData/ServerReport.xlsx", "ServerInfo");

    }




}