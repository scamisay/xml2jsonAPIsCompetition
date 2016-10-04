package xml2jsonAPIsCompetition.domain;

import org.json.JSONObject;
import org.json.XML;

/**
 * Created by scamisay on 03/10/16.
 */
public class XMLProcessor_orgJson extends XMLProcessor {


    public XMLProcessor_orgJson(XMLConsumer consumer) {
        super(consumer);
    }

    @Override
    protected String getAPIName() {
        return "org.json";
    }

    @Override
    protected void processXML(String xmlFile) {
        JSONObject xmlJSONObj = XML.toJSONObject(xmlFile);
    }
}
