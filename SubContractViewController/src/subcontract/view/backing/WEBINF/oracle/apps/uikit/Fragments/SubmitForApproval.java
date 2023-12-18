package subcontract.view.backing.WEBINF.oracle.apps.uikit.Fragments;

import java.io.IOException;

import java.net.MalformedURLException;

import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class SubmitForApproval {

    private String pod;
    private String webservice_username;
    private String webservice_password;

    public SubmitForApproval(String pod, String webservice_username,
                             String webservice_password) {
        this.pod = pod;
        this.webservice_username = webservice_username;
        this.webservice_password = webservice_password;
    }

    public void getAndPushOrder(String payloadXML, String url,
                                String type) throws Exception {
        pushOrder(payloadXML, url, type);
    }

    protected void pushOrder(String xmlData, String url,
                             String type) throws MalformedURLException,
                                                 IOException {
        String xmlInput = "";
        //        String url =
        //            "http://" + pod + "/soa-infra/services/default/SellPaymentProcess/sellpaymentprocess_client_ep?WSDL";
        System.err.println("===URL===" + url);
        if (type.equalsIgnoreCase("Certification")) {
            xmlInput = getOrderDataAsXML(xmlData);
        } else if (type.equalsIgnoreCase("Application")) {
            xmlInput = getAppOrderDataAsXML(xmlData);
        } else if (type.equalsIgnoreCase("Contract")) {
            xmlInput = getContractOrderDataAsXML(xmlData);
        } else {
            xmlInput = "";
        }

        xmlInput = xmlInput.replaceAll("&", "&amp;");
        System.err.println("======PAYLOAD FOR APP=====" + xmlInput);
        OkHttpClient client;
        client =
                new OkHttpClient.Builder().connectTimeout(600, TimeUnit.SECONDS).writeTimeout(600,
                                                                                              TimeUnit.SECONDS).readTimeout(600,
                                                                                                                            TimeUnit.SECONDS).build();

        MediaType mediaType = MediaType.parse("text/xml");
        RequestBody body = RequestBody.create(mediaType, xmlInput);
        Request request =
            new Request.Builder().url(url).post(body).addHeader("content-type",
                                                                "text/xml").addHeader("cache-control",
                                                                                      "no-cache").build();

        client.newCall(request).execute();

    }

    private String getOrderDataAsXML(String xmlData) {
        String xml = "";

        xml +=
"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cer=\"http://www.xmlns.oracle.com/certsell\">\n" +
                "   <soapenv:Header/>";
        xml += xmlData + "</soapenv:Envelope>";
        return xml;

    }


    private static String getAppOrderDataAsXML(String xmlData) {
        String xml = "";

        xml +=
"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" \n" +
                "	xmlns:app=\"http://www.xmlns.oracle.com/approveapp\">\n" +
                "   <soapenv:Header/>";
        xml += xmlData + "</soapenv:Envelope>";
        return xml;
    }

    private static String getContractOrderDataAsXML(String xmlData) {
        String xml = "";

        xml +=
"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" \n" +
                "	xmlns:app=\"http://www.xmlns.oracle.com/approvecontract\">\n" +
                "   <soapenv:Header/>";
        xml += xmlData + "</soapenv:Envelope>";
        return xml;
    }


}


// */