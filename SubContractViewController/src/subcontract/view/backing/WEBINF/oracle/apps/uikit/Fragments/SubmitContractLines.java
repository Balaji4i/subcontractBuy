package subcontract.view.backing.WEBINF.oracle.apps.uikit.Fragments;

import Utils.JSFUtils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.ParserConfigurationException;

import java.io.BufferedReader;

import java.text.SimpleDateFormat;

import org.w3c.dom.Document;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.StringReader;

import java.net.MalformedURLException;

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

//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Element;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;

import org.w3c.dom.Document;

import org.xml.sax.InputSource;

import org.xml.sax.SAXException;

import sun.misc.BASE64Encoder;

public class SubmitContractLines {

    private String pod;
    private String webservice_username;
    private String webservice_password;

    public SubmitContractLines(String pod, String webservice_username,
                               String webservice_password) {
        this.pod = pod;
        this.webservice_username = webservice_username;
        this.webservice_password = webservice_password;
    }

    public String getAndPushOrder(String payloadXML) throws Exception {
        String responseXML;
        responseXML = pushOrder(payloadXML);
        return responseXML;
    }

    protected String pushOrder(String xmlData) throws MalformedURLException,
                                                      IOException,
                                                      SAXException,
                                                      ParserConfigurationException {
        String outputStringXML = "";
        String xmlInput = getOrderDataAsXML(xmlData);
        xmlInput = xmlInput.replaceAll("&", "&amp;");
        System.err.println("======PAYLOAD FOR MERGE=====" + xmlInput);
        OkHttpClient client;
        client =
                new OkHttpClient.Builder().connectTimeout(600, TimeUnit.SECONDS).writeTimeout(600,
                                                                                              TimeUnit.SECONDS).readTimeout(600,
                                                                                                                            TimeUnit.SECONDS).build();

        MediaType mediaType = MediaType.parse("text/xml");
        RequestBody body = RequestBody.create(mediaType, xmlInput);
        Request request =
            new Request.Builder().url("https://" + pod + ".crm.em3.oraclecloud.com/external-contractmanagement-contractsCoreTransactionContracts/ContractService?WSDL").post(body).addHeader("content-type",
                                                                                                                                                                                             "text/xml").addHeader("cache-control",
                                                                                                                                                                                                                   "no-cache").build();

        Response response = client.newCall(request).execute();

        InputStream isr = response.body().byteStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(isr));
        StringBuilder out = new StringBuilder();
        String resultsXml;
        while ((resultsXml = reader.readLine()) != null) {
            out.append(resultsXml);
        }
        int responseCode = response.code();
        System.err.println("===IMP===CODE====" + responseCode);
        if (responseCode > 300) {
            if (out.toString().contains(";TEXT&gt;")) {
                String fault = getFaultString(out.toString());
                //System.err.println("-----==fault==----"+fault);
                StringBuilder builder = new StringBuilder("<html> <body>");
                builder.append("Error Message from ERP :" +
                               " <b style=\"color:#ef0404\">" + fault +
                               "</b></body></html>");
                JSFUtils.addFacesInformationMessage(builder.toString());
                //Submit Button Off
                RichCommandButton submitButton =
                    (RichCommandButton)JSFUtils.findComponentInRoot("cb2");
                submitButton.setDisabled(Boolean.FALSE);
                AdfFacesContext.getCurrentInstance().addPartialTarget(submitButton);
            } else {
                DocumentBuilder builder =
                    DocumentBuilderFactory.newInstance().newDocumentBuilder();
                InputSource src = new InputSource();
                src.setCharacterStream(new StringReader(out.toString()));
                Document doc = builder.parse(src);
                String fault =
                    doc.getElementsByTagName("faultstring").item(0).getTextContent();
                StringBuilder builder1 = new StringBuilder("<html> <body>");
                builder1.append("Error Message from ERP :" +
                                " <b style=\"color:#ef0404\">" + fault +
                                "</b></body></html>");
                JSFUtils.addFacesInformationMessage(builder1.toString());
                //Submit Button Off
                RichCommandButton submitButton =
                    (RichCommandButton)JSFUtils.findComponentInRoot("cb2");
                submitButton.setDisabled(Boolean.FALSE);
                AdfFacesContext.getCurrentInstance().addPartialTarget(submitButton);
            }
        } else {
            outputStringXML = "OKK";

        }
        System.err.println("===RES====" + outputStringXML);
        return outputStringXML;

    }

    private String getOrderDataAsXML(String xmlData) {
        String xml = "";
        Date date = new Date();
        SimpleDateFormat dateFormat =
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"); //Hours:Minutes:Seconds
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        long t = date.getTime();
        Date expDate = new Date(t + (10 * 60000));

        String createdTS = dateFormat.format(date);
        String expiresTS = dateFormat.format(expDate);
        xml +=
"<soapenv:Envelope xmlns:bil=\"http://xmlns.oracle.com/apps/projects/billing/contracts/flex/BilllPlanDff/\" xmlns:con=\"http://xmlns.oracle.com/apps/contracts/coreAuthoring/contractService/\" xmlns:con1=\"http://xmlns.oracle.com/apps/projects/billing/contracts/contractPublicService/\" xmlns:con2=\"http://xmlns.oracle.com/apps/projects/billing/contracts/contractBillingService/\" xmlns:head=\"http://xmlns.oracle.com/apps/contracts/coreAuthoring/header/flex/header/\" xmlns:lin=\"http://xmlns.oracle.com/apps/flex/contracts/coreAuthoring/lines/\" xmlns:par=\"http://xmlns.oracle.com/apps/contracts/coreAuthoring/parties/flex/partyContact/\" xmlns:par1=\"http://xmlns.oracle.com/apps/contracts/coreAuthoring/parties/flex/party/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/contracts/coreAuthoring/contractService/types/\">\n" +
                "   <soapenv:Header>\n" +
                "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                "         <wsu:Timestamp wsu:Id=\"TS-094DFEEA9FEB74CC4B15113385382675\">\n" +
                "            <wsu:Created>" + createdTS + "</wsu:Created>\n" +
                "            <wsu:Expires>" + expiresTS + "</wsu:Expires>\n" +
                "         </wsu:Timestamp>\n" +
                "         <wsse:UsernameToken wsu:Id=\"UsernameToken-094DFEEA9FEB74CC4B15113375315943\">\n" +
                "            <wsse:Username>" + webservice_username +
                "</wsse:Username>\n" +
                "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">" +
                webservice_password + "</wsse:Password>\n" +
                "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">9wZqXD2gEvTVQt9z3j3PIQ==</wsse:Nonce>\n" +
                "            <wsu:Created>2017-12-18T11:18:52.000Z</wsu:Created>\n" +
                "         </wsse:UsernameToken>\n" +
                "      </wsse:Security>\n" +
                "   </soapenv:Header>";
        xml += xmlData + "</soapenv:Envelope>";
        return xml;
        //
    }

    public static String getFaultString(String xml) {
        String faultString = "";
        try {
            System.err.println("===ERRORR=======" + xml);
            int firstFault = xml.indexOf(";TEXT&gt;");
            int firstFault_last = xml.indexOf("&lt;/TEXT&");

            System.err.println("begin fault message===" + firstFault);
            System.err.println("last fault message===" + firstFault_last);
            System.out.println("==RESULT===" +
                               xml.substring(firstFault + 9, firstFault_last));
            faultString = xml.substring(firstFault + 9, firstFault_last);
            System.err.println("---faultString-------" + faultString);

        } catch (Exception e) {

        }
        return faultString;
    }

}


// */