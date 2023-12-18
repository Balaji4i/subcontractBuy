package subcontract.view.backing.WEBINF.oracle.apps.uikit.Fragments;

import Utils.JSFUtils;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import java.net.MalformedURLException;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import okhttp3.Response;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;

import org.w3c.dom.Document;

import org.xml.sax.InputSource;

public class ContractUnderAmend {

    public String pushOrder(String contNum) throws MalformedURLException,
                                                   IOException {
        String retVal = "N";
        try {
            String xmlInput = "";
            String url =
                "https://soacs.nscccloud.com/soa-infra/services/default/SubContract_Ammendment/variation_client_ep?wsdl";
            xmlInput = getOrderDataAsXML(contNum);
            xmlInput = xmlInput.replaceAll("&", "&amp;");
            OkHttpClient client;
            client =
                    new OkHttpClient.Builder().connectTimeout(900, TimeUnit.SECONDS).writeTimeout(600,
                                                                                                  TimeUnit.SECONDS).readTimeout(600,
                                                                                                                                TimeUnit.SECONDS).build();

            MediaType mediaType = MediaType.parse("text/xml");
            RequestBody body = RequestBody.create(mediaType, xmlInput);
            Request request =
                new Request.Builder().url(url).post(body).addHeader("content-type",
                                                                    "text/xml").addHeader("cache-control",
                                                                                          "no-cache").build();
            Response response = client.newCall(request).execute();
            InputStream isr = response.body().byteStream();
            BufferedReader reader =
                new BufferedReader(new InputStreamReader(isr));
            StringBuilder out = new StringBuilder();
            String resultsXml;
            while ((resultsXml = reader.readLine()) != null) {
                out.append(resultsXml);
            }
            // JSFUtils.addFacesErrorMessage("=OUT==" + out.toString());
            if (out.toString() != null) {
                if (out.toString().contains("SUCCESS")) {
                    retVal = "S";
                }
            } else {
                retVal = "E";
            }
        } catch (Exception e) {
            System.err.println("===EXE==INVOKE AMEND=" + e.toString());
            JSFUtils.addFacesErrorMessage("=pushOrder==" + e.toString());
        }
        return retVal;
    }

    private String getOrderDataAsXML(String contNum) {
        String xml = "";

        xml +=
"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:var=\"http://xmlns.oracle.com/NSCCIntTestApp/SubContract_Ammendment/Variations\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <var:Request>\n" +
                "         <var:ContractNumber>";
        xml += contNum;
        xml += "</var:ContractNumber>\n" +
                "      </var:Request>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        return xml;

    }
}


// */