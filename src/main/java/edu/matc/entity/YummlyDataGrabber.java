package edu.matc.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.yummly.recipes.Criteria;
import edu.matc.yummly.recipes.MatchesItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class YummlyDataGrabber {

    private final Logger logger = LogManager.getLogger(this.getClass());
    //Pass in the client.target into the method and save the url in a properties file

    public Criteria getCriteria(String searchTerm) throws Exception {

        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://api.yummly.com/v1/api/recipes" +
                        "?_app_id=f65e0890&_app_key=f73e0521794d8722e37af638cdd2e052&q=" + searchTerm);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Criteria criteria = mapper.readValue(response, Criteria.class);
        MatchesItem matchesItem = new MatchesItem();
        logger.info("$$$$$$$$$$ Criteria Request returned Object: " + criteria);
        logger.info("$$$$$$$$$$ Ingredients: " + criteria.getMatches().get(0).getIngredients().get(0));
        logger.info("$$$$$$$$$$ Matches: " + criteria.getMatches());
        logger.info("$$$$$$$$$$ Attribution: " + criteria.getAttribution());
        logger.info("$$$$$$$$$$ Facet Counts: " + criteria.getFacetCounts());
        logger.info("$$$$$$$$$$ Total Match Count: " + criteria.getTotalMatchCount());
        logger.info("$$$$$$$$$$ Allowed Ingredients: " + criteria.getAllowedIngredient());
        logger.info("$$$$$$$$$$ Excluded Ingredients: " + criteria.getExcludedIngredient());
        logger.info("$$$$$$$$$$ Q: " + criteria.getQ());


        return criteria;
    }
}