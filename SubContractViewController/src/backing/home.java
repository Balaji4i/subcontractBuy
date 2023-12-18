package backing;


import Utils.JSFUtils;

import com.oschrenk.io.Base64;

import java.io.OutputStream;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.fragment.RichRegion;
import oracle.adf.view.rich.component.rich.layout.RichDecorativeBox;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import javax.faces.event.ActionEvent;

import oracle.adf.controller.TaskFlowId;
import oracle.adf.share.ADFContext;

import oracle.jbo.ViewObject;


import java.io.ByteArrayOutputStream;

import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.URL;

import java.net.URLConnection;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.binding.OperationBinding;

import oracle.javatools.status.Issue;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.client.Configuration;

import org.json.JSONException;
import org.json.JSONObject;

public class home {
    private RichCommandButton cb1;
    private RichGridCell gc2;
    private RichGridCell gc1;
    private RichGridRow gr1;
    private RichPanelGridLayout pgl1;
    private RichPanelGroupLayout pgl2;
    private RichRegion r1;
    private RichDecorativeBox db1;
    private RichForm f1;
    private RichDocument d1;
    private RichPanelGroupLayout pgl3;
    private RichOutputText ot1;

    public home() {
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void setGc2(RichGridCell gc2) {
        this.gc2 = gc2;
    }

    public RichGridCell getGc2() {
        return gc2;
    }

    public void setGc1(RichGridCell gc1) {
        this.gc1 = gc1;
    }

    public RichGridCell getGc1() {
        return gc1;
    }

    public void setGr1(RichGridRow gr1) {
        this.gr1 = gr1;
    }

    public RichGridRow getGr1() {
        return gr1;
    }

    public void setPgl1(RichPanelGridLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGridLayout getPgl1() {
        return pgl1;
    }

    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }

    public void setR1(RichRegion r1) {
        this.r1 = r1;
    }

    public RichRegion getR1() {
        return r1;
    }

    public void setDb1(RichDecorativeBox db1) {
        this.db1 = db1;
    }

    public RichDecorativeBox getDb1() {
        return db1;
    }

    public void setF1(RichForm f1) {
        this.f1 = f1;
    }

    public RichForm getF1() {
        return f1;
    }

    public void setD1(RichDocument d1) {
        this.d1 = d1;
    }

    public RichDocument getD1() {
        return d1;
    }
    
    public void setPgl3(RichPanelGroupLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGroupLayout getPgl3() {
        return pgl3;
    }

    public void setOt1(RichOutputText ot1) {
        this.ot1 = ot1;
    }

    public RichOutputText getOt1() {
        return ot1;
    }
    
    public String checkUser() throws JSONException {
       //  For Test
       ///*    

//                  ADFContext.getCurrent().getSessionScope().put("userName","4iapps");
//                    //code to be included here for data restriction.
//                 String  outputString = "validUser";
//                   ADFContext.getCurrent().getPageFlowScope().put("val","validUser");
//              
//               
//               //Naresco
//       //          String Id="300000002169150"; // local
//                  String Id="300000004370222";// cloud
//       //
//       //
//             ADFContext.getCurrent().getSessionScope().put("loginUserID",Id);

//       //For Prod
//                          
//                String inputEncodedText =
//               ADFContext.getCurrent().getPageFlowScope().get("tokens").toString();
//               System.err.println("JWT tokens:=====>>> "+ADFContext.getCurrent().getPageFlowScope().get("tokens").toString());
//                URL url;
//                URLConnection connection;
//                HttpURLConnection httpConn;
//                String outputString = "";
//                String jwt =
//                    ADFContext.getCurrent().getPageFlowScope().get("tokens").toString();
//                System.err.println("JWT---- " + jwt);
//               ADFContext.getCurrent().getPageFlowScope().put("val",jwt);
                           try {    
                   // Sobha
       //             String wsURL ="https://eexr.hcm.em3.oraclecloud.com/hcmPeopleRolesV2/UserDetailsService?WSDL";
                  // Sobha- Test 
       //             String wsURL ="https://eexr-test.hcm.em3.oraclecloud.com/hcmPeopleRolesV2/UserDetailsService?WSDL";
       //             NSCC 
       //          String wsURL ="https://egpt.fa.em2.oraclecloud.com/hcmPeopleRolesV2/UserDetailsService?WSDL";
                    
       //             url = new URL(wsURL);
       //             connection = url.openConnection();
       //             httpConn = (HttpURLConnection)connection;
       //             ByteArrayOutputStream bout = new ByteArrayOutputStream();
       //             String xmlInput =
       ////                 "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/types/\">\n" +
       //                 "   <soapenv:Header/>\n" +
       //                 "   <soapenv:Body>\n" +
       //                 "      <typ:findSelfUserDetails/>\n" +
       //                 "   </soapenv:Body>\n" +
       //                 "</soapenv:Envelope>";
       //
       //             byte[] buffer = new byte[xmlInput.length()];
       //             buffer = xmlInput.getBytes();
       //             bout.write(buffer);
       //             byte[] b = bout.toByteArray();
       //             httpConn.setRequestProperty("Content-Type",
       //                                         "text/xml; charset=utf-8");
       //             httpConn.setRequestProperty("SOAPAction", "");
       //             httpConn.setRequestProperty("Authorization", "Bearer " + inputEncodedText);
       //             httpConn.setRequestMethod("POST");
       //             httpConn.setDoOutput(true);
       //             httpConn.setDoInput(true);
       //             httpConn.setAllowUserInteraction(true);
       //             OutputStream out = httpConn.getOutputStream();
       //             out.write(b);
       //             out.close();
       //             httpConn.connect();
       //             if (httpConn.getResponseCode() == 200) {
                        //outputString = "validUser";
                        ADFContext.getCurrent().getPageFlowScope().put("val","validUser"); 
       //             } else {
       //                 outputString = "Invalid";
       //                 ADFContext.getCurrent().getPageFlowScope().put("val","Invalid");
       //             }
                    
//                   if (outputString.equalsIgnoreCase("validUser")) {
//              
//                        String[] xIn = inputEncodedText.split("\\.");
//                        byte c[] = Base64.decode(xIn[1]);
//                        String tempPass = new String(c);
//                        int chkOccurance = tempPass.lastIndexOf("}");
//                        if (chkOccurance < 1) {
//                          tempPass += "}";
//                        }
//                        JSONObject jo = new JSONObject(tempPass);
//                    
//                        long millis = System.currentTimeMillis();
//                        long iatVal = Long.parseLong(jo.get("iat").toString()) * 1000;
//                        long expVal = Long.parseLong(jo.get("exp").toString()) * 1000;
//                        if (millis >= iatVal && millis <= expVal) {
//              
//
//                          ADFContext.getCurrent().getSessionScope().put("userName", jo.getString("prn"));
//                          //code to be included here for data restriction.
//                            outputString = "validUser";
//                            ADFContext.getCurrent().getPageFlowScope().put("val","validUser"); 
//                 
//                        }
//                          else {
//                                            outputString = "Invalid";
//                                            ADFContext.getCurrent().getPageFlowScope().put("val","Invalid");
//                                        }
//                      }
//                           else {
//                               outputString = "Invalid";
//                               ADFContext.getCurrent().getPageFlowScope().put("val","Invalid");
  //                     }
               
                      }catch (Exception e)
                     {
                   JSFUtils.addFacesInformationMessage("Token Error: "+e.toString());
                }
              ADFContext.getCurrent().getSessionScope().put("userName","4iapps");
                return "validUser";
          }
    
}
