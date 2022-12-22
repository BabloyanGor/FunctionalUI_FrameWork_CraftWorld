package testCases;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class ServersLoadTest extends BaseTest{

    public ServersLoadTest() throws AWTException {
    }

    @BeforeClass
    public void logIn() throws UnirestException, IOException {}

    @Test
    public void test() throws UnirestException {
       String serversLoadResponse = craftBet_01_header_pageLogInUser.serverLoad();
    }
}
