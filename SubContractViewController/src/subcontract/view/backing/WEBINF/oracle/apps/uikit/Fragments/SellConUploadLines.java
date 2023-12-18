package subcontract.view.backing.WEBINF.oracle.apps.uikit.Fragments;


import Utils.ADFUtils;
import Utils.JSFUtils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichMenu;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelLabelAndMessage;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandImageLink;
import oracle.adf.view.rich.component.rich.nav.RichGoMenuItem;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;
import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.model.UploadedFile;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.InputSource;

import ws.PublicReportService;
import ws.PublicReportServiceService;

import ws.types.ArrayOfParamNameValue;
import ws.types.ArrayOfString;
import ws.types.ParamNameValue;
import ws.types.ReportRequest;
import ws.types.ReportResponse;
import ws.types.ScheduleRequest;

public class SellConUploadLines {
    private RichPanelBox pb1;
    private RichPanelBox pb2;
    private RichSpacer s1;
    private RichInputText it1;
    private RichCommandButton cb1;
    private RichPanelFormLayout pfl1;
    private RichPanelLabelAndMessage plam1;
    private RichOutputText ot1;
    private RichPanelLabelAndMessage plam2;
    private RichOutputText ot2;
    private RichPanelLabelAndMessage plam3;
    private RichOutputText ot3;
    private RichPanelLabelAndMessage plam4;
    private RichOutputText ot4;
    private RichPanelLabelAndMessage plam5;
    private RichOutputText ot5;
    private RichPanelLabelAndMessage plam6;
    private RichOutputText ot6;
    private RichPanelLabelAndMessage plam7;
    private RichOutputText ot7;
    private RichPanelLabelAndMessage plam8;
    private RichOutputText ot8;
    private RichPanelLabelAndMessage plam9;
    private RichOutputText ot9;
    private RichPanelLabelAndMessage plam10;
    private RichOutputText ot10;
    private RichPanelLabelAndMessage plam11;
    private RichOutputText ot11;
    private RichPanelLabelAndMessage plam12;
    private RichOutputText ot12;
    private RichPanelLabelAndMessage plam13;
    private RichOutputText ot13;
    private RichPanelLabelAndMessage plam14;
    private RichOutputText ot14;
    private RichPanelLabelAndMessage plam15;
    private RichOutputText ot15;
    private RichPanelLabelAndMessage plam16;
    private RichOutputText ot16;
    private RichPanelLabelAndMessage plam17;
    private RichOutputText ot17;
    private RichPanelLabelAndMessage plam18;
    private RichOutputText ot18;
    private RichPanelCollection pc1;
    private RichTable t1;
    private RichToolbar t2;
    private RichCommandButton cb2;
    private RichMenu m1;
    private RichGoMenuItem gmi1;
    private RichPanelBox pb3;
    private RichPanelGroupLayout pgl2;
    private RichSpacer s2;
    private RichSpacer s3;
    private RichCommandButton cb3;
    private RichInputFile if1;
    private RichCommandButton cb4;
    private RichSpacer s4;
    private RichCommandImageLink cil1;
    private RichSpacer s5;
    private RichCommandImageLink cil2;
    private RichSpacer s6;
    private RichCommandButton cb5;
    private RichPanelGroupLayout pgl1;
    private RichSpacer s7;
    private RichSpacer s8;
    private RichInputDate id1;
    private RichInputDate id2;


    public void setPb1(RichPanelBox pb1) {
        this.pb1 = pb1;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setPlam1(RichPanelLabelAndMessage plam1) {
        this.plam1 = plam1;
    }

    public RichPanelLabelAndMessage getPlam1() {
        return plam1;
    }

    public void setOt1(RichOutputText ot1) {
        this.ot1 = ot1;
    }

    public RichOutputText getOt1() {
        return ot1;
    }

    public void setPlam2(RichPanelLabelAndMessage plam2) {
        this.plam2 = plam2;
    }

    public RichPanelLabelAndMessage getPlam2() {
        return plam2;
    }

    public void setOt2(RichOutputText ot2) {
        this.ot2 = ot2;
    }

    public RichOutputText getOt2() {
        return ot2;
    }

    public void setPlam3(RichPanelLabelAndMessage plam3) {
        this.plam3 = plam3;
    }

    public RichPanelLabelAndMessage getPlam3() {
        return plam3;
    }

    public void setOt3(RichOutputText ot3) {
        this.ot3 = ot3;
    }

    public RichOutputText getOt3() {
        return ot3;
    }

    public void setPlam4(RichPanelLabelAndMessage plam4) {
        this.plam4 = plam4;
    }

    public RichPanelLabelAndMessage getPlam4() {
        return plam4;
    }

    public void setOt4(RichOutputText ot4) {
        this.ot4 = ot4;
    }

    public RichOutputText getOt4() {
        return ot4;
    }

    public void setPlam5(RichPanelLabelAndMessage plam5) {
        this.plam5 = plam5;
    }

    public RichPanelLabelAndMessage getPlam5() {
        return plam5;
    }

    public void setOt5(RichOutputText ot5) {
        this.ot5 = ot5;
    }

    public RichOutputText getOt5() {
        return ot5;
    }

    public void setPlam6(RichPanelLabelAndMessage plam6) {
        this.plam6 = plam6;
    }

    public RichPanelLabelAndMessage getPlam6() {
        return plam6;
    }

    public void setOt6(RichOutputText ot6) {
        this.ot6 = ot6;
    }

    public RichOutputText getOt6() {
        return ot6;
    }

    public void setPlam7(RichPanelLabelAndMessage plam7) {
        this.plam7 = plam7;
    }

    public RichPanelLabelAndMessage getPlam7() {
        return plam7;
    }

    public void setOt7(RichOutputText ot7) {
        this.ot7 = ot7;
    }

    public RichOutputText getOt7() {
        return ot7;
    }

    public void setPlam8(RichPanelLabelAndMessage plam8) {
        this.plam8 = plam8;
    }

    public RichPanelLabelAndMessage getPlam8() {
        return plam8;
    }

    public void setOt8(RichOutputText ot8) {
        this.ot8 = ot8;
    }

    public RichOutputText getOt8() {
        return ot8;
    }

    public void setPlam9(RichPanelLabelAndMessage plam9) {
        this.plam9 = plam9;
    }

    public RichPanelLabelAndMessage getPlam9() {
        return plam9;
    }

    public void setOt9(RichOutputText ot9) {
        this.ot9 = ot9;
    }

    public RichOutputText getOt9() {
        return ot9;
    }

    public void setPlam10(RichPanelLabelAndMessage plam10) {
        this.plam10 = plam10;
    }

    public RichPanelLabelAndMessage getPlam10() {
        return plam10;
    }

    public void setOt10(RichOutputText ot10) {
        this.ot10 = ot10;
    }

    public RichOutputText getOt10() {
        return ot10;
    }

    public void setPlam11(RichPanelLabelAndMessage plam11) {
        this.plam11 = plam11;
    }

    public RichPanelLabelAndMessage getPlam11() {
        return plam11;
    }

    public void setOt11(RichOutputText ot11) {
        this.ot11 = ot11;
    }

    public RichOutputText getOt11() {
        return ot11;
    }

    public void setPlam12(RichPanelLabelAndMessage plam12) {
        this.plam12 = plam12;
    }

    public RichPanelLabelAndMessage getPlam12() {
        return plam12;
    }

    public void setOt12(RichOutputText ot12) {
        this.ot12 = ot12;
    }

    public RichOutputText getOt12() {
        return ot12;
    }

    public void setPlam13(RichPanelLabelAndMessage plam13) {
        this.plam13 = plam13;
    }

    public RichPanelLabelAndMessage getPlam13() {
        return plam13;
    }

    public void setOt13(RichOutputText ot13) {
        this.ot13 = ot13;
    }

    public RichOutputText getOt13() {
        return ot13;
    }

    public void setPlam14(RichPanelLabelAndMessage plam14) {
        this.plam14 = plam14;
    }

    public RichPanelLabelAndMessage getPlam14() {
        return plam14;
    }

    public void setOt14(RichOutputText ot14) {
        this.ot14 = ot14;
    }

    public RichOutputText getOt14() {
        return ot14;
    }

    public void setPlam15(RichPanelLabelAndMessage plam15) {
        this.plam15 = plam15;
    }

    public RichPanelLabelAndMessage getPlam15() {
        return plam15;
    }

    public void setOt15(RichOutputText ot15) {
        this.ot15 = ot15;
    }

    public RichOutputText getOt15() {
        return ot15;
    }

    public void setPlam16(RichPanelLabelAndMessage plam16) {
        this.plam16 = plam16;
    }

    public RichPanelLabelAndMessage getPlam16() {
        return plam16;
    }

    public void setOt16(RichOutputText ot16) {
        this.ot16 = ot16;
    }

    public RichOutputText getOt16() {
        return ot16;
    }

    public void setPlam17(RichPanelLabelAndMessage plam17) {
        this.plam17 = plam17;
    }

    public RichPanelLabelAndMessage getPlam17() {
        return plam17;
    }

    public void setOt17(RichOutputText ot17) {
        this.ot17 = ot17;
    }

    public RichOutputText getOt17() {
        return ot17;
    }

    public void setPlam18(RichPanelLabelAndMessage plam18) {
        this.plam18 = plam18;
    }

    public RichPanelLabelAndMessage getPlam18() {
        return plam18;
    }

    public void setOt18(RichOutputText ot18) {
        this.ot18 = ot18;
    }

    public RichOutputText getOt18() {
        return ot18;
    }

    public void setPc1(RichPanelCollection pc1) {
        this.pc1 = pc1;
    }

    public RichPanelCollection getPc1() {
        return pc1;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }


    public void setT2(RichToolbar t2) {
        this.t2 = t2;
    }

    public RichToolbar getT2() {
        return t2;
    }

    public void setCb2(RichCommandButton cb2) {
        this.cb2 = cb2;
    }

    public RichCommandButton getCb2() {
        return cb2;
    }

    public void OnClickSave(ActionEvent actionEvent) {
        try {
            ADFUtils.findOperation("Commit").execute();
            cb2.setDisabled(false);
        } catch (Exception e) {
            System.err.println("===EXE==COMM==" + e.toString());
        }
    }

    public void onClickContract(ActionEvent actionEvent) {
        try {
            System.err.println("==ST==");
            ViewObject mergeVO =
                ADFUtils.findIterator("SellContractLine_ROVO1Iterator").getViewObject();
            //            mergeVO.setNamedWhereClauseParam("p_flag", "U");
            //            mergeVO.setNamedWhereClauseParam("p_con",
            //                                             AdfFacesContext.getCurrentInstance().getPageFlowScope().get("con_num"));
            //            mergeVO.executeQuery();
            //            System.err.println("==ST==" + mergeVO.getEstimatedRowCount());
            //            if (mergeVO.getEstimatedRowCount() > 0) {
            //                submitUpdateContract();
            //            }
            mergeVO.setNamedWhereClauseParam("p_flag", "A");
            mergeVO.setNamedWhereClauseParam("p_con",
                                             AdfFacesContext.getCurrentInstance().getPageFlowScope().get("con_num"));
            mergeVO.executeQuery();
            System.err.println("==ST==" + mergeVO.getEstimatedRowCount());
            if (mergeVO.getEstimatedRowCount() > 0) {
                submitMergeContract();
                //ValidateContract();
            }
            cb2.setDisabled(true);
        } catch (Exception e) {
            System.err.println("====EXE==" + e.toString());
        }

    }

    public void submitMergeContract() {
        try {
            String response = null;
            SubmitContractLines exp =
                new SubmitContractLines("egpt", "dysa@Naresco.com",
                                        "welcome123");
            String payload = prepareMergeContractPayload();
            payload = payload.replace(".0", "");
            //System.err.println("===PAY==1==" + payload);
            String retrunXML = exp.getAndPushOrder(payload);
            System.err.println("=====RET=====" + retrunXML);
            String sub = retrunXML.substring(0, 3);

            if (!(sub.equals("ERR"))) {
                JSFUtils.addFacesInformationMessage("Contract Lines Added Successfully.");
            } else {
                response = retrunXML.substring(3);
                System.err.println("====ERROR=PAYLOAD==" + response);
            }
        } catch (Exception e) {
            System.err.println("====EXE===MER====" + e.toString());
        }
    }

    public void ValidateContract() {
        try {
            String response = null;
            ValidateContract exp =
                new ValidateContract("egpt", "dysa@Naresco.com",
                                     "welcome123");
            String payload = validatepayload();
            String retrunXML;
            retrunXML = exp.getAndPushOrder(payload);
            System.err.println("=====RET=====" + retrunXML);
            String sub = retrunXML.substring(0, 3);
            if (!(sub.equals("ERR"))) {
                JSFUtils.addFacesInformationMessage("Contract validate succesfully!");
            } else {
                response = retrunXML.substring(3);
                System.err.println("====ERROR=PAYLOAD==Validate==" + response);
            }

        } catch (Exception e) {
        }
    }


    public void submitUpdateContract() {
        try {
            String response = null;
            SubmitUpdateContractLines exp =
                new SubmitUpdateContractLines("egpt",
                                              "dysa@naresco.com",
                                              "welcome123");
            String payload = prepareUpdateContractPayload();
            System.err.println("===PAY==2==" + payload);
            String retrunXML = exp.getAndPushOrder(payload);
            System.err.println("=====RET=====" + retrunXML);
            String sub = retrunXML.substring(0, 3);
            if (!(sub.equals("ERR"))) {
                JSFUtils.addFacesInformationMessage("Contract Lines Updated Successfully.");
            } else {
                response = retrunXML.substring(3);
                System.err.println("====ERROR=PAYLOAD==" + response);
            }
        } catch (Exception e) {
            System.err.println("====EXE===UP====" + e.toString());
        }
    }


    public String prepareUpdateContractPayload() {
        String xml = "";
        //        java.util.Date date = new java.util.Date();
        //        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ViewObject headerVO =
            ADFUtils.findIterator("XxstgSellContractHeaders_VO1Iterator").getViewObject();
        if (headerVO.getCurrentRow() != null) {
            xml += "<soapenv:Body>\n" +
                    "      <typ:updateContract xmlns:con=\"http://xmlns.oracle.com/apps/contracts/coreAuthoring/contractService/types/\">\n" +
                    "         <typ:contractHeader xmlns:con=\"http://xmlns.oracle.com/apps/contracts/coreAuthoring/contractService/\">\n" +
                    "            <con:Id>" +
                    headerVO.getCurrentRow().getAttribute("ContractHeaderId") +
                    "</con:Id>\n" +
                    "            <con:MajorVersion>" +
                    headerVO.getCurrentRow().getAttribute("MajorVersion") +
                    "</con:MajorVersion>\n";
            ViewObject mergeVO =
                ADFUtils.findIterator("SellContractLine_ROVO1Iterator").getViewObject();
            mergeVO.setNamedWhereClauseParam("p_flag", "U");
            mergeVO.setNamedWhereClauseParam("p_con",
                                             AdfFacesContext.getCurrentInstance().getPageFlowScope().get("con_num"));

            mergeVO.executeQuery();
            if (mergeVO.getEstimatedRowCount() > 0) {
                RowSetIterator rs = mergeVO.createRowSetIterator("");
                while (rs.hasNext()) {
                    Row r = rs.next();
                    System.err.println("==1111====");
                    xml += "<con:ContractLine>\n" +
                            "               <con:Id>" +
                            r.getAttribute("ContractLineId") + "</con:Id>\n" +
                            "               <con:LineTypeId>" +
                            r.getAttribute("LineTypeId") +
                            "</con:LineTypeId>\n" +
                            "               <con:ItemNameTxt>";
                    xml +=
r.getAttribute("ItemName") != null ? r.getAttribute("ItemName").toString() :
"";
                    xml += "</con:ItemNameTxt>\n" +
                            "               <con:StartDate>";
                    xml +=
r.getAttribute("StartDate") != null ? r.getAttribute("StartDate") : "";
                    xml += "</con:StartDate>\n" +
                            "               <con:EndDate>";
                    xml +=
r.getAttribute("EndDate") != null ? r.getAttribute("EndDate") : "";
                    xml += "</con:EndDate>\n" +
                            "               <con:LineValueAmount currencyCode=\"";
                    xml += r.getAttribute("CurrencyCode");
                    xml += "\">";
                    xml += getLineAmount(r);

                    xml += "</con:LineValueAmount>\n" +
                            "<con:ContractAllLineDesFlexVA>\n" +
                            "                 <lin:uom>";
                    xml +=
r.getAttribute("UnitOfMeasure") != null ? r.getAttribute("UnitOfMeasure").toString() :
"";
                    xml += "</lin:uom>\n" +
                            "                   <lin:qty>";
                    xml +=
r.getAttribute("NumOfItem") != null ? r.getAttribute("NumOfItem") : "";
                    xml += "</lin:qty>\n" +
                            "                  <lin:rate>";
                    xml +=
r.getAttribute("PriceUnit") != null ? r.getAttribute("PriceUnit") : "";
                    xml += "</lin:rate>\n" +
                            "                   </con:ContractAllLineDesFlexVA>" +
                            "            </con:ContractLine>";
                }
                xml += "         </typ:contractHeader>\n" +
                        "      </typ:updateContract>\n" +
                        "   </soapenv:Body>";
            }
        }
        return xml;
    }

    public double getLineAmount(Row r) {
        double lineAmt = 0;

        lineAmt =
                r.getAttribute("LineAmount") != null ? Double.parseDouble(r.getAttribute("LineAmount").toString()) :
                0;
        if (lineAmt == 0) {
            lineAmt =
                    r.getAttribute("TRANS_Amount") != null ? Double.parseDouble(r.getAttribute("TRANS_Amount").toString()) :
                    0;
        }

        return lineAmt;
    }

    //    public String prepareMergeContractPayload() {
    //        String xml = "";
    //        ViewObject headerVO =
    //            ADFUtils.findIterator("XxstgSellContractHeaders_VO1Iterator").getViewObject();
    //        if (headerVO.getCurrentRow() != null) {
    //            xml +=
    //"<soapenv:Body>" + "      <typ:mergeContractInAllStatus>\n" +
    //                    "         <typ:contractHeader>\n" +
    //                    "            <con:Id>" +
    //                    headerVO.getCurrentRow().getAttribute("ContractHeaderId") +
    //                    "</con:Id>\n" +
    //                    "            <con:MajorVersion>" +
    //                    headerVO.getCurrentRow().getAttribute("MajorVersion") +
    //                    "</con:MajorVersion>\n";
    //       ViewObject mergeVO =
    //                ADFUtils.findIterator("LineNumberROVO1Iterator").getViewObject();
    //            mergeVO.setNamedWhereClauseParam("p_flag", "A");
    //            mergeVO.setNamedWhereClauseParam("BV_CONT_NUM",
    //                                             AdfFacesContext.getCurrentInstance().getPageFlowScope().get("con_num"));
    //
    //            mergeVO.executeQuery();
    //
    //            if (mergeVO.getEstimatedRowCount() > 0) {
    //                RowSetIterator rs1 = mergeVO.createRowSetIterator("");
    //                while (rs1.hasNext()) {
    //                    Row r1 = rs1.next();
    //                    ViewObject projectnum =
    //                        ADFUtils.findIterator("ProjectNumberROVO1Iterator").getViewObject();
    //                    System.err.println("=====Line number====" +
    //                                       r1.getAttribute("LineNumber").toString());
    //                    projectnum.setNamedWhereClauseParam("BV_LINE_NUM",
    //                                                        r1.getAttribute("LineNumber").toString());
    //                    projectnum.setNamedWhereClauseParam("BV_CONT_NUM",
    //                                                        AdfFacesContext.getCurrentInstance().getPageFlowScope().get("con_num"));
    //
    //                    projectnum.executeQuery();
    //                    if (projectnum.getEstimatedRowCount() > 0) {
    //
    //                        if (projectnum.first() != null) {
    //                            Row r = projectnum.first();
    //                            xml += " <con:ContractLine>\n" +
    //                                    "               <con:LineTypeId>" +
    //                                    r.getAttribute("LineTypeId") +
    //                                    "</con:LineTypeId>\n<con:LineNumber>";
    //                            xml +=r.getAttribute("LineNumber") != null ? r.getAttribute("LineNumber").toString() :
    //"";
    //                            xml += "</con:LineNumber><con:ItemNameTxt>";
    //                            xml +=
    //r.getAttribute("ItemName") != null ? r.getAttribute("ItemName").toString() :
    //"";
    //                            xml += "</con:ItemNameTxt>\n<con:ItemDescription>";
    //                            xml +=
    //r.getAttribute("ItemDescription") != null ? r.getAttribute("ItemDescription").toString() :
    //"";
    //                            xml +=
    //"</con:ItemDescription><con:StartDate>";
    //
    //                            xml +=
    //r.getAttribute("StartDate") != null ? r.getAttribute("StartDate") : "";
    //                            xml += "</con:StartDate>\n" +
    //                                    "               <con:EndDate>";
    //                            xml +=
    //r.getAttribute("EndDate") != null ? r.getAttribute("EndDate") : "";
    //                            xml += "</con:EndDate>\n" +
    //                                    "               <con:LineValueAmount currencyCode=\"";
    //
    //
    //                            xml +=
    //r.getAttribute("CurrencyCode") != null ? r.getAttribute("CurrencyCode").toString() :
    //"";
    //                            xml += "\">";
    //
    //                            xml +=
    //r.getAttribute("LineAmount") != null ? r.getAttribute("LineAmount") : "";
    //                            xml += "</con:LineValueAmount>\n";
    //
    //                            xml +=
    //"<con:BillPlanId>" + headerVO.getCurrentRow().getAttribute("BillPlanId") +
    // "</con:BillPlanId>" + "<con:RevenuePlanId>";
    //                            xml +=
    //headerVO.getCurrentRow().getAttribute("RevenuePlanId") != null ?
    //headerVO.getCurrentRow().getAttribute("RevenuePlanId") : "";
    //
    //                            xml += "</con:RevenuePlanId>\n";
    //
    //                            xml +=
    //"               <con:ShipToAccountId>" + headerVO.getCurrentRow().getAttribute("ShipToAcctId") +
    // "</con:ShipToAccountId>\n" +
    //                                    "               <con:BillToAccountId>" +
    //                                    headerVO.getCurrentRow().getAttribute("BillToAcctId") +
    //                                    "</con:BillToAccountId>\n" +
    //                                    "               <con:BillToSiteUseId>" +
    //                                    headerVO.getCurrentRow().getAttribute("BillToSiteUseId") +
    //                                    "</con:BillToSiteUseId>\n" +
    //                                    "               <con:ShipToSiteUseId>" +
    //                                    headerVO.getCurrentRow().getAttribute("ShipToSiteUseId") +
    //                                    "</con:ShipToSiteUseId>\n";
    //
    //                            RowSetIterator rs2 =
    //                                projectnum.createRowSetIterator("");
    //                            while (rs2.hasNext()) {
    //                                Row r2 = rs2.next();
    //                                xml +=
    //"               <con:AssociatedProject>\n";
    //
    //                                xml +=
    //"                  <con1:ProjectNumber>";
    //                                xml +=
    //r2.getAttribute("ProjectNumber") != null ?
    //r2.getAttribute("ProjectNumber").toString() : "";
    //                                xml += "</con1:ProjectNumber>\n" +
    //                                        "                  <con1:TaskNumber>";
    //                                xml +=
    //r2.getAttribute("TaskNumber") != null ? r2.getAttribute("TaskNumber").toString() :
    //"";
    //                                xml += "</con1:TaskNumber>\n" +
    //                                        "                  <con1:FundingAmount currencyCode=\"";
    //
    //                                xml +=
    //r2.getAttribute("CurrencyCode") != null ?
    //r2.getAttribute("CurrencyCode").toString() : "";
    //                                xml += "\">";
    //                                xml +=
    //r2.getAttribute("FundingAmount") != null ?
    //r2.getAttribute("FundingAmount").toString() : "";
    //                                xml += "</con1:FundingAmount>\n" +
    //                                        "               </con:AssociatedProject>\n";
    //
    //                            }
    //
    //                            xml += "<con:ContractAllLineDesFlexVA>\n" +
    //                                    "                 <lin:uom>";
    //
    //                            xml +=
    //r.getAttribute("UnitOfMeasure") != null ? r.getAttribute("UnitOfMeasure").toString() :
    //"";
    //                            xml += "</lin:uom>\n" +
    //                                    "                   <lin:qty>";
    //                            xml +=
    //r.getAttribute("NumOfItem") != null ? r.getAttribute("NumOfItem") : "";
    //                            xml += "</lin:qty>\n" +
    //                                    "                  <lin:rate>";
    //                            xml +=
    //r.getAttribute("PriceUnit") != null ? r.getAttribute("PriceUnit") : "";
    //
    //                            xml += "</lin:rate>\n" +
    //                                    "                   </con:ContractAllLineDesFlexVA><con:OutputTaxClassificationCode>";
    //                            xml+=r.getAttribute("OutputTaxClassificationCode") != null ? r.getAttribute("OutputTaxClassificationCode") :(headerVO.getCurrentRow().getAttribute("OutputTaxClassificationCode") != null ? headerVO.getCurrentRow().getAttribute("OutputTaxClassificationCode"):"");
    //                              xml+="</con:OutputTaxClassificationCode></con:ContractLine>";
    //
    //                        }
    //
    //                    }
    //                }
    //                xml += "</typ:contractHeader>\n" +
    //                        "         <typ:targetStatusCode/>\n" +
    //                        "         <typ:closeDate/>\n" +
    //                        "         <typ:closeReasonCode/>\n" +
    //                        "         <typ:cancelReasonCode/>\n" +
    //                        "         <typ:versionFlag>true</typ:versionFlag>\n" +
    //                        "      </typ:mergeContractInAllStatus>\n" +
    //                        "   </soapenv:Body>\n";
    //
    //            }
    //        }
    //        return xml;
    //    }


    public String validatepayload() {

        String xml = "";
        ViewObject headerVO =
            ADFUtils.findIterator("XxstgSellContractHeaders_VO1Iterator").getViewObject();
        if (headerVO.getCurrentRow() != null) {
            xml += "<soapenv:Body>" + "<typ:updateContractToActive>\n" +
                    "<typ:contractId>";
            xml += headerVO.getCurrentRow().getAttribute("ContractHeaderId");
            xml += "</typ:contractId>\n" +
                    "<typ:runValidationFlag>True</typ:runValidationFlag>\n" +
                    "</typ:updateContractToActive>\n" +
                    "</soapenv:Body>\n";
        }
        return xml;
    }

    public String prepareMergeContractPayload() {
        DecimalFormat df = new DecimalFormat(".##");

        String xml = "";
        ViewObject headerVO =
            ADFUtils.findIterator("XxstgSellContractHeaders_VO1Iterator").getViewObject();
        if (headerVO.getCurrentRow() != null) {
            xml +=
"<soapenv:Body>" + "      <typ:mergeContractInAllStatus>\n" +
                    "         <typ:contractHeader>\n" +
                    "            <con:Id>" +
                    headerVO.getCurrentRow().getAttribute("ContractHeaderId") +
                    "</con:Id>\n" +
                    "            <con:MajorVersion>" +
                    headerVO.getCurrentRow().getAttribute("MajorVersion") +
                    "</con:MajorVersion>\n";
            ViewObject mergeVO =
                ADFUtils.findIterator("LineNumberROVO1Iterator").getViewObject();
            mergeVO.setNamedWhereClauseParam("p_flag", "A");
            mergeVO.setNamedWhereClauseParam("BV_CONT_NUM",
                                             AdfFacesContext.getCurrentInstance().getPageFlowScope().get("con_num"));

            mergeVO.executeQuery();

            if (mergeVO.getEstimatedRowCount() > 0) {
                RowSetIterator rs1 = mergeVO.createRowSetIterator("");
                while (rs1.hasNext()) {
                    Row r1 = rs1.next();
                    ViewObject projectnum =
                        ADFUtils.findIterator("ProjectNumberROVO1Iterator").getViewObject();
                    System.err.println("=====Line number====" +
                                       r1.getAttribute("LineNumber").toString());
                    projectnum.setNamedWhereClauseParam("BV_LINE_NUM",
                                                        r1.getAttribute("LineNumber").toString());
                    projectnum.setNamedWhereClauseParam("BV_CONT_NUM",
                                                        AdfFacesContext.getCurrentInstance().getPageFlowScope().get("con_num"));

                    projectnum.executeQuery();
                    if (projectnum.getEstimatedRowCount() > 0) {

                        if (projectnum.first() != null) {
                            Row r = projectnum.first();
                            xml += " <con:ContractLine>\n" +
                                    "               <con:LineTypeId>" +
                                    r.getAttribute("LineTypeId") +
                                    "</con:LineTypeId>\n<con:LineNumber>";
                            xml +=
r.getAttribute("LineNumber") != null ? r.getAttribute("LineNumber").toString() :
"";
                            xml += "</con:LineNumber><con:ItemNameTxt>";
                            xml +=
r.getAttribute("ItemName") != null ? r.getAttribute("ItemName").toString() :
"";
                            xml += "</con:ItemNameTxt>\n<con:ItemDescription>";
                            xml +=
r.getAttribute("ItemDescription") != null ? r.getAttribute("ItemDescription").toString() :
"";
                            xml += "</con:ItemDescription><con:StartDate>";

                            xml +=
r.getAttribute("StartDate") != null ? r.getAttribute("StartDate") : "";
                            xml += "</con:StartDate>\n" +
                                    "               <con:EndDate>";
                            xml +=
r.getAttribute("EndDate") != null ? r.getAttribute("EndDate") : "";
                            xml += "</con:EndDate>\n" +
                                    "               <con:LineValueAmount currencyCode=\"";


                            xml +=
r.getAttribute("CurrencyCode") != null ? r.getAttribute("CurrencyCode").toString() :
"";
                            xml += "\">";

                            xml +=
r.getAttribute("SumAmt") != null ? df.format(Double.parseDouble(r.getAttribute("SumAmt").toString())) :
"";
                            xml += "</con:LineValueAmount>\n";

                            xml +=
"<con:BillPlanId>" + headerVO.getCurrentRow().getAttribute("BillPlanId") +
 "</con:BillPlanId>" + "<con:RevenuePlanId>";
                            xml +=
headerVO.getCurrentRow().getAttribute("RevenuePlanId") != null ?
headerVO.getCurrentRow().getAttribute("RevenuePlanId") : "";

                            xml += "</con:RevenuePlanId>\n";

                            xml +=
"               <con:ShipToAccountId>" + headerVO.getCurrentRow().getAttribute("ShipToAcctId") +
 "</con:ShipToAccountId>\n" +
                                    "               <con:BillToAccountId>" +
                                    headerVO.getCurrentRow().getAttribute("BillToAcctId") +
                                    "</con:BillToAccountId>\n" +
                                    "               <con:BillToSiteUseId>" +
                                    headerVO.getCurrentRow().getAttribute("BillToSiteUseId") +
                                    "</con:BillToSiteUseId>\n" +
                                    "               <con:ShipToSiteUseId>" +
                                    headerVO.getCurrentRow().getAttribute("ShipToSiteUseId") +
                                    "</con:ShipToSiteUseId>\n";

                            RowSetIterator rs2 =
                                projectnum.createRowSetIterator("");
                            while (rs2.hasNext()) {
                                Row r2 = rs2.next();
                                xml +=
"               <con:AssociatedProject>\n";

                                xml +=
"                  <con1:ProjectNumber>";
                                xml +=
r2.getAttribute("ProjectNumber") != null ?
r2.getAttribute("ProjectNumber").toString() : "";
                                xml += "</con1:ProjectNumber>\n" +
                                        "                  <con1:TaskNumber>";
                                xml +=
r2.getAttribute("TaskNumber") != null ? r2.getAttribute("TaskNumber").toString() :
"";
                                xml += "</con1:TaskNumber>\n" +
                                        "                  <con1:FundingAmount currencyCode=\"";

                                xml +=
r2.getAttribute("CurrencyCode") != null ?
r2.getAttribute("CurrencyCode").toString() : "";
                                xml += "\">";
                                xml +=
r2.getAttribute("LineAmount") != null ? df.format(Double.parseDouble(r2.getAttribute("LineAmount").toString())) :
"";
                                xml += "</con1:FundingAmount>\n" +
                                        "               </con:AssociatedProject>\n";

                            }

                            xml += "<con:ContractAllLineDesFlexVA>\n" +
                                    "                 <lin:uom>";

                            xml +=
r.getAttribute("UnitOfMeasure") != null ? r.getAttribute("UnitOfMeasure").toString() :
"";
                            xml += "</lin:uom>\n" +
                                    "                   <lin:qty>";
                            xml +=
r.getAttribute("NumOfItem") != null ? ((int)Double.parseDouble(r.getAttribute("NumOfItem").toString())) :
"";
                            xml += "</lin:qty>\n" +
                                    "                  <lin:rate>";
                            xml +=
r.getAttribute("PriceUnit") != null ? ((int)Double.parseDouble(r.getAttribute("PriceUnit").toString())) :
"";

                            xml += "</lin:rate>\n" +
                                    "                   </con:ContractAllLineDesFlexVA><con:OutputTaxClassificationCode>";
                            xml +=
r.getAttribute("OutputTaxClassificationCode") != null ?
r.getAttribute("OutputTaxClassificationCode") :
(headerVO.getCurrentRow().getAttribute("OutputTaxClassificationCode") != null ?
 headerVO.getCurrentRow().getAttribute("OutputTaxClassificationCode") : "");
                            xml +=
"</con:OutputTaxClassificationCode></con:ContractLine>";

                        }

                    }
                }
                xml += "</typ:contractHeader>\n" +
                        "         <typ:targetStatusCode/>\n" +
                        "         <typ:closeDate/>\n" +
                        "         <typ:closeReasonCode/>\n" +
                        "         <typ:cancelReasonCode/>\n" +
                        "         <typ:versionFlag>true</typ:versionFlag>\n" +
                        "      </typ:mergeContractInAllStatus>\n" +
                        "   </soapenv:Body>\n";

            }
        }
        return xml;
    }

    public void setM1(RichMenu m1) {
        this.m1 = m1;
    }

    public RichMenu getM1() {
        return m1;
    }

    public void setGmi1(RichGoMenuItem gmi1) {
        this.gmi1 = gmi1;
    }

    public RichGoMenuItem getGmi1() {
        return gmi1;
    }

    public RichPanelBox getPb1() {
        return pb1;
    }

    public void setPb2(RichPanelBox pb2) {
        this.pb2 = pb2;
    }

    public RichPanelBox getPb2() {
        return pb2;
    }

    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichSpacer getS1() {
        return s1;
    }


    public void onClickPopulateDetails(ActionEvent actionEvent) {

    }
    String conNum = "";

    public void setConNum(String conNum) {
        this.conNum = conNum;
    }

    public String getConNum() {
        return conNum;
    }
    String userName = "4iapps";
    String passWord = "Finance@4i";
    //       String dataSource = "apex";
    //       String dataSource = "contract";
    //       String dataSource = "apex";
    String dataSource = "apex";
    private String poNumber;

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void onClickPopulate(ActionEvent actionEvent) {
        System.err.println("===CON===" + conNum);
        if (conNum != null) {
            String retVal1 = synConHeader(conNum);
            if (retVal1.equalsIgnoreCase("Y")) {
                ViewObject headerVO =
                    ADFUtils.findIterator("XxstgSellContractHeaders_VO1Iterator").getViewObject();
                headerVO.setNamedWhereClauseParam("p_con_num", conNum);
                headerVO.executeQuery();
                String retVal2 = synConLines(conNum);
                //                if (retVal2 != null && (!(retVal2.equalsIgnoreCase("N")))) {
                ViewObject lineVO =
                    ADFUtils.findIterator("XxstgSellContractLines_VO1Iterator").getViewObject();
                System.err.println("==ret==line==" + retVal2);
                lineVO.setNamedWhereClauseParam("p_con_num", conNum);
                lineVO.executeQuery();
                System.err.println("===LINE==" +
                                   lineVO.getEstimatedRowCount());
                RichTable t1 = (RichTable)JSFUtils.findComponentInRoot("t1");
                AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
                //                      }
                ADFContext.getCurrent().getPageFlowScope().put("con_num",
                                                               conNum);
            } else {
                JSFUtils.addFacesInformationMessage("Please enter the Valid Contract Number No.Contract Status should be Draft or Under amendment");
            }
        } else {
            JSFUtils.addFacesInformationMessage("Please enter the Contract Number to Fetch");
        }
    }

    public String synConHeader(String conNum) {
        String str, retStr = null;
        Context ctx;
        Connection con = null;
        CallableStatement stmt = null;
        Statement stmt2 = null;
        ResultSet rs = null;
        ScheduleRequest sreq = new ScheduleRequest();
        PublicReportServiceService publicReportServiceService =
            new PublicReportServiceService();
        PublicReportService publicReportService =
            publicReportServiceService.getPublicReportService();
        ReportRequest reportRequest = new ReportRequest();
        reportRequest.setAttributeFormat("xml");
        reportRequest.setAttributeLocale("en-US");
        reportRequest.setAttributeTemplate("Simple");
        reportRequest.setByPassCache(true);
        reportRequest.setSizeOfDataChunkDownload(-1);
        reportRequest.setReportAbsolutePath("/Custom/Sub Contract/SC Stg Sell Contract Headers.xdo");
        ArrayOfParamNameValue pNameValue = new ArrayOfParamNameValue();
        ParamNameValue nameValue1 = new ParamNameValue();
        nameValue1.setName("p_contract_number");
        ArrayOfString aos1 = new ArrayOfString();
        aos1.getItem().add(conNum);
        nameValue1.setValues(aos1);
        pNameValue.getItem().add(nameValue1);
        reportRequest.setParameterNameValues(pNameValue);
        sreq.setReportRequest(reportRequest);
        sreq.setSaveDataOption(true);
        sreq.setScheduleBurstringOption(false);
        sreq.setSchedulePublicOption(true);
        sreq.setUserJobName("TEST");
        ReportResponse response = new ReportResponse();
        try {
            response =
                    publicReportService.runReport(reportRequest, userName, passWord);
            str = response.getReportBytesAsString();
            System.err.println("=====OUT======HEADER=====" + str);
            DocumentBuilder db;
            db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();

            is.setCharacterStream(new StringReader(str));
            Document doc = db.parse(is);
            NodeList nodes = doc.getElementsByTagName("G_1");

            if (nodes.getLength() != 0) {
                Node nNode = nodes.item(0);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element)nNode;
                    String status =
                        (element.getElementsByTagName("STS_CODE").item(0).getTextContent() !=
                         null ?
                         element.getElementsByTagName("STS_CODE").item(0).getTextContent().toString() :
                         null);
                    //   System.err.println("====STT===" + status);
                    if ((("DRAFT".equalsIgnoreCase(status)) ||
                         ("UNDER_AMENDMENT".equalsIgnoreCase(status)))) {
                        try {
                            ctx = new InitialContext();
                            DataSource ds = (DataSource)ctx.lookup(dataSource);
                            con = ds.getConnection();
                            stmt =
con.prepareCall("{call xxsc_contract_pkg.update_stg_sell_cont_headers(?,?,?,?)}");
                            stmt.setString(1, conNum);
                            stmt.setString(2, str);
                            stmt.registerOutParameter(3, Types.VARCHAR);
                            stmt.registerOutParameter(4, Types.VARCHAR);
                            stmt.executeUpdate();
                            retStr = stmt.getString(3);
                            System.err.println("===CON HEADER RES====" +
                                               retStr + "===" +
                                               stmt.getString(4));
                            if (retStr != null &&
                                retStr.equalsIgnoreCase("S")) {
                                JSFUtils.addFacesInformationMessage("Contract Header Synchronized.");
                                retStr = "Y";
                            } else {
                                retStr = "N";
                            }
                        } catch (Exception e) {
                            System.err.println("SQL Exception in Header--> " +
                                               e.toString());
                            retStr = "N";
                        }
                    } else {
                        retStr = status;
                    }
                }
            } else {
                retStr = "Contract Number is not Valid.Please try again.";
            }
        } catch (Exception e) {
            System.err.println("Exception Report H call " + e);
            retStr = "Issues with connection.Please check it.";
        } finally {
            try {
                if (rs != null) {
                    rs.close();

                }
                if (stmt2 != null) {
                    stmt2.close();

                }
                if (stmt != null) {
                    stmt.close();

                }
                if (con != null) {
                    con.close();

                }
            } catch (Exception e) {
                System.err.println("Exception in Finally block " + e);
                retStr = "Issues with connections.Please check.";
            }
        }
        return retStr;
    }

    public String synConLines(String conNum) {
        String str, retStr = null;
        Context ctx;
        Connection con = null;
        CallableStatement stmt = null;
        Statement stmt2 = null;
        ResultSet rs = null;
        ScheduleRequest sreq = new ScheduleRequest();
        PublicReportServiceService publicReportServiceService =
            new PublicReportServiceService();
        PublicReportService publicReportService =
            publicReportServiceService.getPublicReportService();
        ReportRequest reportRequest = new ReportRequest();
        reportRequest.setAttributeFormat("xml");
        reportRequest.setAttributeLocale("en-US");
        reportRequest.setAttributeTemplate("Simple");
        reportRequest.setByPassCache(true);
        reportRequest.setSizeOfDataChunkDownload(-1);
        reportRequest.setReportAbsolutePath("/Custom/Sub Contract/SC Stg Sell Contract Lines.xdo");
        ArrayOfParamNameValue pNameValue = new ArrayOfParamNameValue();
        ParamNameValue nameValue1 = new ParamNameValue();
        nameValue1.setName("p_contract_number");
        ArrayOfString aos1 = new ArrayOfString();
        aos1.getItem().add(conNum);
        nameValue1.setValues(aos1);
        pNameValue.getItem().add(nameValue1);
        reportRequest.setParameterNameValues(pNameValue);
        sreq.setReportRequest(reportRequest);
        sreq.setSaveDataOption(true);
        sreq.setScheduleBurstringOption(false);
        sreq.setSchedulePublicOption(true);
        sreq.setUserJobName("TEST");
        ReportResponse response = new ReportResponse();
        try {
            response =
                    publicReportService.runReport(reportRequest, userName, passWord);
            str = response.getReportBytesAsString();
            System.err.println("=====OUT======LLINES=====" + str);
            DocumentBuilder db;
            db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(str));
            Document doc = db.parse(is);
            NodeList nodes = doc.getElementsByTagName("G_1");
            if (nodes.getLength() != 0) {
                Node nNode = nodes.item(0);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    try {
                        ctx = new InitialContext();
                        DataSource ds = (DataSource)ctx.lookup(dataSource);
                        con = ds.getConnection();
                        stmt =
con.prepareCall("{call xxsc_contract_pkg.update_stg_sell_cont_lines(?,?,?,?)}");
                        stmt.setString(1, conNum);
                        stmt.setString(2, str);
                        stmt.registerOutParameter(3, Types.VARCHAR);
                        stmt.registerOutParameter(4, Types.VARCHAR);
                        stmt.executeUpdate();
                        retStr = stmt.getString(3);
                        System.err.println("===CON LINE RES====" + retStr +
                                           "===" + stmt.getString(4));
                        if (retStr != null && retStr.equalsIgnoreCase("S")) {
                            JSFUtils.addFacesInformationMessage("Contract Lines Synchronized.");
                            retStr = "Y";
                        } else {
                            retStr = "N";
                        }

                    } catch (Exception e) {
                        System.err.println("SQL Exception in line--> " +
                                           e.toString());
                        retStr = "N";
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Exception Report call " + e);
            // retStr = "Issues with connection.Please check it.";
        } finally {
            try {
                if (rs != null) {
                    rs.close();

                }
                if (stmt2 != null) {
                    stmt2.close();

                }
                if (stmt != null) {
                    stmt.close();

                }
                if (con != null) {
                    con.close();

                }
            } catch (Exception e) {
                System.err.println("Exception in Finally block " + e);
                // retStr = "Issues with connections.Please check.";
            }
        }
        return retStr;
    }


    public void setPb3(RichPanelBox pb3) {
        this.pb3 = pb3;
    }

    public RichPanelBox getPb3() {
        return pb3;
    }

    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }

    public void setS2(RichSpacer s2) {
        this.s2 = s2;
    }

    public RichSpacer getS2() {
        return s2;
    }

    public void setS3(RichSpacer s3) {
        this.s3 = s3;
    }

    public RichSpacer getS3() {
        return s3;
    }

    public void setCb3(RichCommandButton cb3) {
        this.cb3 = cb3;
    }

    public RichCommandButton getCb3() {
        return cb3;
    }

    ViewObject contractHrdVO =
        ADFUtils.findIterator("XxstgSellContractHeaders_VO1Iterator").getViewObject();


    DownloadContractLine de = new DownloadContractLine();

    public void contractLineDownload(javax.faces.context.FacesContext facesContext,
                                     OutputStream outputStream) throws FileNotFoundException,
                                                                       IOException,
                                                                       ParseException {
        String cname =
            contractHrdVO.getCurrentRow().getAttribute("ContractName") ==
            null ? "LineDetail" :
            contractHrdVO.getCurrentRow().getAttribute("ContractName").toString();

        File filed = new File(de.downlaodExcel(cname) + "/" + cname + ".xls");
        FileInputStream fis = null;
        byte[] b;
        try {
            fis = new FileInputStream(filed);

            int n;
            while ((n = fis.available()) > 0) {
                b = new byte[n];
                int result = fis.read(b);
                outputStream.write(b, 0, b.length);
                if (result == -1)
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        outputStream.flush();
        outputStream.close();
        fis.close();
        filed.delete();

    }

    public void setIf1(RichInputFile if1) {
        this.if1 = if1;
    }

    public RichInputFile getIf1() {
        return if1;
    }

    uploadContractLine upload = new uploadContractLine();

    public void onChangeUpload(ValueChangeEvent valueChangeEvent) throws IOException {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        UploadedFile file = (UploadedFile)valueChangeEvent.getNewValue();
        if (file.getContentType().equalsIgnoreCase("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") ||
            file.getContentType().equalsIgnoreCase("application/xlsx") ||
            file.getContentType().equalsIgnoreCase("application/kset")) {
            System.err.println("Inside XLSX loop");
            clearLines();
            //                    upload.readExcelSheet(file.getInputStream(), contractLineTable, projectHID, prHID, prLineNumber);
            upload.readExcelSheet(file.getInputStream(), t1);
            if1.setValue(null);
        } else if (file.getContentType().equalsIgnoreCase("application/vnd.ms-excel")) {
            if (file.getFilename().toUpperCase().endsWith(".XLS")) {
                System.err.println("==Calling MS-Excel==");
                clearLines();
                //                          upload.readExcelSheet(file.getInputStream(), contractLineTable, projectHID, prHID, prLineNumber);
                upload.readExcelSheet(file.getInputStream(), t1);
                if1.setValue(null);
            }
        } else {
            System.out.println("Inside else loop");
            JSFUtils.addFacesErrorMessage("File format not supported.-- Upload XLS or XLSX file");
        }


    }

    public void clearLines() {
        ViewObject linesVO =
            ADFUtils.findIterator("DeleteSellContractLines_VO1Iterator").getViewObject();
        ViewObjectImpl vo = (ViewObjectImpl)linesVO;
        vo.setNamedWhereClauseParam("p_con_num",
                                    ADFContext.getCurrent().getPageFlowScope().get("con_num"));
        //        ViewCriteria vc = vo.createViewCriteria();
        //        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        //        vcRow.setAttribute("ContractHeaderId", null);
        //        vc.addRow(vcRow);
        //        vo.applyViewCriteria(vc);
        vo.executeQuery();
        System.err.println("===line to clear==" + vo.getEstimatedRowCount());
        RowSetIterator rs = vo.createRowSetIterator(null);
        while (rs.hasNext()) {
            Row r = rs.next();
            r.remove();
        }
        try {
            ADFUtils.findOperation("Commit").execute();
        } catch (Exception e) {
            System.err.println("===E===" + e.toString());
        }
    }

    public void setCb4(RichCommandButton cb4) {
        this.cb4 = cb4;
    }

    public RichCommandButton getCb4() {
        return cb4;
    }

    public void setS4(RichSpacer s4) {
        this.s4 = s4;
    }

    public RichSpacer getS4() {
        return s4;
    }

    public void setCil1(RichCommandImageLink cil1) {
        this.cil1 = cil1;
    }

    public RichCommandImageLink getCil1() {
        return cil1;
    }

    public void setS5(RichSpacer s5) {
        this.s5 = s5;
    }

    public RichSpacer getS5() {
        return s5;
    }

    public void setCil2(RichCommandImageLink cil2) {
        this.cil2 = cil2;
    }

    public RichCommandImageLink getCil2() {
        return cil2;
    }

    public void setS6(RichSpacer s6) {
        this.s6 = s6;
    }

    public RichSpacer getS6() {
        return s6;
    }

    public void OnClickDelete(ActionEvent actionEvent) {
        ViewObject lines =
            ADFUtils.findIterator("XxstgSellContractLines_VO1Iterator").getViewObject();
        lines.getCurrentRow().remove();
        JSFUtils.addFacesInformationMessage("Lines Removed Successfuly");
    }

    public void OnClickAdd(ActionEvent actionEvent) {
        ViewObject lines =
            ADFUtils.findIterator("XxstgSellContractLines_VO1Iterator").getViewObject();
        Row r = lines.createRow();
        r.setAttribute("ContractNumber",
                       JSFUtils.resolveExpression("#{bindings.ContractNumber.inputValue}"));
        //        r.setAttribute("LineType", "Original");
        //        r.setAttribute("LineTypeId", getLineTypeIds("Original"));
        r.setAttribute("Flag", "A");
        r.setAttribute("LineType", "Free-form, project");
        r.setAttribute("LineTypeId", getLineTypeIds("Free-form, project"));
        lines.insertRow(r);
        lines.executeQuery();
        //        ADFUtils.findOperation("Commit").execute();
    }

    private long getLineTypeIds(String lineType) {
        long retName = 0;
        ViewObject lineTypeVO =
            ADFUtils.findIterator("ContractLineType_ROVO1Iterator").getViewObject();
        ViewObjectImpl vo = (ViewObjectImpl)lineTypeVO;
        ViewCriteria vc = vo.getViewCriteria("findByLineTypeName");
        lineTypeVO.applyViewCriteria(vc);
        lineTypeVO.setNamedWhereClauseParam("p_name", lineType);
        lineTypeVO.executeQuery();
        if (lineTypeVO.getEstimatedRowCount() > 0) {
            retName =
                    Long.parseLong(lineTypeVO.first().getAttribute("LineTypeId").toString());
        }
        return retName;
    }

    public void setCb5(RichCommandButton cb5) {
        this.cb5 = cb5;
    }

    public RichCommandButton getCb5() {
        return cb5;
    }

    public void OnClickCalculate(ValueChangeEvent valueChangeEvent) {
        double Values =
            valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
        ViewObject lines =
            ADFUtils.findIterator("XxstgSellContractLines_VO1Iterator").getViewObject();
        double priceunit =
            lines.getCurrentRow().getAttribute("PriceUnit") == null ? 0 :
            Double.parseDouble(lines.getCurrentRow().getAttribute("PriceUnit").toString());
        double Amount;
        Amount = (Values * priceunit);
        lines.getCurrentRow().setAttribute("LineAmount", Amount);
    }

    public void OnClickAmtCal(ValueChangeEvent vce) {
        double Values =
            vce.getNewValue() == null ? 0 : Double.parseDouble(vce.getNewValue().toString());
        ViewObject lines =
            ADFUtils.findIterator("XxstgSellContractLines_VO1Iterator").getViewObject();
        double priceunit =
            lines.getCurrentRow().getAttribute("NumOfItem") == null ? 0 :
            Double.parseDouble(lines.getCurrentRow().getAttribute("NumOfItem").toString());
        double Amount;
        Amount = (Values * priceunit);
        lines.getCurrentRow().setAttribute("LineAmount", Amount);

    }

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }

    public void setS7(RichSpacer s7) {
        this.s7 = s7;
    }

    public RichSpacer getS7() {
        return s7;
    }

    public void setS8(RichSpacer s8) {
        this.s8 = s8;
    }

    public RichSpacer getS8() {
        return s8;
    }

    public void execute(ActionEvent actionEvent) {
        // Add event code here...
    }

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
    }
}

