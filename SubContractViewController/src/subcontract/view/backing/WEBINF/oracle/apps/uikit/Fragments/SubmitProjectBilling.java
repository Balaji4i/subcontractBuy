package subcontract.view.backing.WEBINF.oracle.apps.uikit.Fragments;

import java.io.BufferedReader;

import java.text.SimpleDateFormat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import java.net.URL;

import java.net.URLConnection;

import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SubmitProjectBilling {

    private String pod;
    private String webservice_username;
    private String webservice_password;

    public SubmitProjectBilling(String pod, String webservice_username,
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
                                                      IOException {
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
            new Request.Builder().url("https://" + pod + ".prj.em3.oraclecloud.com/pjbTransactions/ProjectBillingEventService?wsdl").post(body).addHeader("content-type",
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
            outputStringXML = "ERR" + out.toString();

        } else {
            outputStringXML = "OKK";

        }
        System.err.println("===RES====" + outputStringXML);
        return outputStringXML;


        //        String outputStringXML = "";
        //        String wsURL = null;
        //
        //            wsURL =
        //                    "https://" + pod + ".prj.em2.oraclecloud.com/pjbTransactions/ProjectBillingEventService?wsdl";
        //       System.out.println(wsURL);
        //        URL url = new URL(wsURL);
        //        URLConnection connection = url.openConnection();
        //        HttpURLConnection httpConn = (HttpURLConnection)connection;
        //        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        //
        //        String xmlInput = getOrderDataAsXML(xmlData);
        //        System.err.println("===xml 1===="+xmlData);
        //
        //        xmlInput = xmlInput.replaceAll("&", "&amp;");
        //        byte[] buffer;
        //        buffer = new byte[xmlInput.length()];
        //        buffer = xmlInput.getBytes();
        //        bout.write(buffer);
        //        byte[] b = bout.toByteArray();
        //        httpConn.setRequestProperty("Content-Length",
        //                                    String.valueOf(b.length));
        //        httpConn.setRequestProperty("Content-Type",
        //                                    "text/xml;charset=\"utf-8\"");
        //        httpConn.setRequestProperty("Accept", "text/xml");
        //
        //            httpConn.setRequestProperty("SOAPAction",
        //                                        "http://xmlns.oracle.com/apps/projects/billing/transactions/billingEventService/createProjectBillingEvent");
        //
        //        httpConn.setUseCaches(false);
        //        httpConn.setDoOutput(true);
        //        httpConn.setDoInput(true);
        //        OutputStream out = httpConn.getOutputStream();
        //        out.write(b);
        //        out.close();
        //        //InputStream in = httpConn.getInputStream();
        //        InputStreamReader isr =
        //            new InputStreamReader(httpConn.getInputStream());
        //        BufferedReader in = new BufferedReader(isr);
        //        String responseString = "";
        //        while ((responseString = in.readLine()) != null) {
        //            System.out.println("------------" + responseString);
        //            outputStringXML = outputStringXML + responseString;
        //        }
        //        return outputStringXML;
    }

    private String getOrderDataAsXML(String xmlData) {
        String xml = "";
        try {
            Date date = new Date();
            SimpleDateFormat dateFormat =
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"); //Hours:Minutes:Seconds
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

            long t = date.getTime();
            Date expDate = new Date(t + (10 * 60000));

            String createdTS = dateFormat.format(date);
            String expiresTS = dateFormat.format(expDate);

            xml +=
"<soapenv:Envelope xmlns:bil=\"http://xmlns.oracle.com/apps/projects/billing/transactions/billingEventService/\" xmlns:dff=\"http://xmlns.oracle.com/apps/projects/billing/transactions/protectedUiModel/flex/dff/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/projects/billing/transactions/billingEventService/types/\">\n" +
                    "   <soapenv:Header>\n" +
                    "       <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n" +
                    "               <wsu:Timestamp wsu:Id=\"TS-CFD9FF9A3CD60C11E6149815863237113\">\n" +
                    "                       <wsu:Created>" + createdTS +
                    "</wsu:Created>\n" +
                    "                               <wsu:Expires>" +
                    expiresTS + "</wsu:Expires>\n" +
                    "               </wsu:Timestamp>\n" +
                    "         <wsse:UsernameToken wsu:Id=\"UsernameToken-97E633FED4FEF4CB0714958735388613\">\n" +
                    "            <wsse:Username>" + webservice_username +
                    "</wsse:Username>\n" +
                    "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">" +
                    webservice_password + "</wsse:Password>\n" +
                    "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">rOPENZjHh10+BxJ3OJlwyQ==</wsse:Nonce>\n" +
                    "            <wsu:Created>2017-05-27T08:25:38.861Z</wsu:Created>\n" +
                    "         </wsse:UsernameToken>\n" +
                    "      </wsse:Security>\n" +
                    "   </soapenv:Header>" + xmlData + "</soapenv:Envelope>";
        } catch (Exception e) {

        }
        System.err.println("===PAY===" + xml);
        return xml;
    }


}


// */