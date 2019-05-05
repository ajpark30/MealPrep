package edu.matc.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.yummly.recipes.Criteria;
import edu.matc.yummly.recipes.MatchesItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import edu.matc.entity.YummlyDataGrabber;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestYummlyApi {

    private final Logger logger = LogManager.getLogger(this.getClass());
    //Pass in the client.target into the method and save the url in a properties file

    YummlyDataGrabber yummlyDataGrabber = new YummlyDataGrabber();

    @Test
    public void testYummlyApiJSON() throws Exception {

        String searchTerm = "Pad+Thai";
        Criteria criteria = yummlyDataGrabber.getCriteria(searchTerm);

        logger.info("Found Criteria from Q: " + criteria.getMatches().get(0).getRecipeName());


        assertEquals("Classic Pad Thai", criteria.getMatches().get(0).getRecipeName());
    }
}