package backing;

import Utils.DBUtils;

import Utils.JSFUtils;

import Utils.RTFUtils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.math.BigDecimal;

import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;

import java.net.UnknownHostException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java.util.Base64;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.servlet.ServletContext;

import javax.servlet.http.HttpServletResponse;

import javax.sql.DataSource;

import oracle.adf.model.OperationBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.DialogEvent;

import oracle.apps.xdo.template.FOProcessor;
import oracle.apps.xdo.template.RTFProcessor;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ApplicationModuleImpl;

import oracle.jbo.server.ViewObjectImpl;

import oracle.jdbc.OracleTypes;

//import java.util.Base64;
import view.backing.ADFUtils;

//import org.apache.http.client.ClientProtocolException;

import org.json.JSONException;
import org.json.JSONObject;


public class contrSearch {
    private RichInputText it2;
    private RichTable t1;
    private RichPopup p1;
    private RichPopup p2;
    private RichInputText it3;
    private RichInputText appInputText;
    private RichInputText certInputText;
    private RichPopup p3;
    private RichInputText variationInputText;
    private RichTable t4;
    private RichInputText buyAppInputText;
    private RichTable t3;
    private RichTable t2;
    private RichTable resId5;
    private RichInputText it9;
    private RichPopup p5;
    private RichPopup p6;

    public contrSearch() {
    }
    ViewObject conSearchHdrVO =
        ADFUtils.findIterator("contractROVO1Iterator").getViewObject();
    ViewObject conHistoryHdrVO =
        ADFUtils.findIterator("contract_HistoryROVO1Iterator").getViewObject();

    ViewObject variationConHdrVO =
        ADFUtils.findIterator("variationSearchROVO1Iterator").getViewObject();

    ViewObject applicationSearchHdrVO =
        ADFUtils.findIterator("applicationSearchROVO1Iterator").getViewObject();
    ViewObject applicationHistoryHdrVO =
        ADFUtils.findIterator("applicationHistory_ROVO1Iterator").getViewObject();

    ViewObject certificationSearchHdrVO =
        ADFUtils.findIterator("certificationSearchROVO1Iterator").getViewObject();
    ViewObject certificationHistoryHdrVO =
        ADFUtils.findIterator("certificationHistoryROVO1Iterator").getViewObject();

    ViewObject contRetSearchHdrVO =
        ADFUtils.findIterator("searchRetReleaseROVO1Iterator").getViewObject();


    public void contrSearchACL(ActionEvent actionEvent) {
        if (it2.getValue() != null) {
            ViewCriteria vc = conSearchHdrVO.createViewCriteria();
            ViewCriteriaRow vcr = vc.createViewCriteriaRow();
            vcr.setAttribute("ContractNum", "like %" + it2.getValue() + "%");
            vc.addRow(vcr);
            conSearchHdrVO.applyViewCriteria(vc);
            conSearchHdrVO.executeQuery();
            //System.err.println("111111111111111");
        } else {
            //ViewObject conHdrVO = ADFUtils.findIterator("contractROVO1Iterator").getViewObject();
            ViewCriteria vc = conSearchHdrVO.createViewCriteria();
            ViewCriteriaRow vcr = vc.createViewCriteriaRow();
            vcr.setAttribute("ContractNum", "");
            vc.addRow(vcr);
            conSearchHdrVO.applyViewCriteria(vc);
            conSearchHdrVO.executeQuery();
            //System.err.println("2222222222222");
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public String onClickVariation() throws SQLException {
        String flag = "E";
        String errorMessage = null;
        String pageRedirect = null;

        if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
            if (conSearchHdrVO.getEstimatedRowCount() != 0) {
                String headerID =
                    (String)conSearchHdrVO.getCurrentRow().getAttribute("ContHeaderId").toString();
                //System.err.println("==headerID==" + headerID);
                String version =
                    (String)conSearchHdrVO.getCurrentRow().getAttribute("Version").toString();
                //System.err.println("==version==" + version);
                flag = onCallVaration(headerID, version);
            }

        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("variation")) {
            if (variationConHdrVO.getEstimatedRowCount() != 0) {
                String headerID =
                    (String)variationConHdrVO.getCurrentRow().getAttribute("ContHeaderId").toString();
                //System.err.println("==headerID==" + headerID);
                String version =
                    (String)variationConHdrVO.getCurrentRow().getAttribute("Version").toString();
                //System.err.println("==version==" + version);
                flag = onCallVaration(headerID, version);
            }
        } else {
            //System.err.println("Variation Not Created--Parameter HId and Version is Empty");
        }

        if (flag.equals("S")) {
            //System.err.println("Package Created");
            //              ADFContext.getCurrent().getSessionScope().get("idd");
            //              ADFContext.getCurrent().getSessionScope().get("versionn");
            ADFContext.getCurrent().getSessionScope().put("id",
                                                          ADFContext.getCurrent().getSessionScope().get("idd"));
            ADFContext.getCurrent().getSessionScope().put("version",
                                                          ADFContext.getCurrent().getSessionScope().get("versionn"));

            if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
                conSearchHdrVO.executeQuery();
                pageRedirect = "edit";
            } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("variation")) {
                variationConHdrVO.executeQuery();
                pageRedirect = "edit";
            } else {
                pageRedirect = "";
            }
        } else {
            //System.err.println("Error: Please check the variation Package");
            JSFUtils.addFacesErrorMessage("Variation not Created. Please select valid Contract Number");
            pageRedirect = "";
        }
        return pageRedirect;
    }

    private Object[][] dobProcArgs = null;

    public String onCallVaration(Object headId,
                                 Object version) throws SQLException {
        
        System.out.println("on call variations...");

        oracle.jbo.domain.Number headerID =
            new oracle.jbo.domain.Number(headId.toString());
        //System.err.println("=---headID----" + headerID);
        oracle.jbo.domain.Number versionID =
            new oracle.jbo.domain.Number(version.toString());
        //System.err.println("=---versionID----" + versionID);
        String flag = "E"; // Error
        String errorMessage = null;
        Object updatedHeader = null;
        Object updatedVersion = null;
        //        oracle.jbo.domain.Number newHeadId=new oracle.jbo.domain.Number(0);

        ApplicationModuleImpl am =
            (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(null);
        dobProcArgs =
                new Object[][] { { "IN", headerID, OracleTypes.NUMBER }, //0
                    { "IN", versionID, OracleTypes.NUMBER }, //1
                    { "OUT", updatedHeader, OracleTypes.NUMBER }, //2
                    { "OUT", updatedVersion, OracleTypes.NUMBER }, //3
                    { "OUT", flag, OracleTypes.VARCHAR }, //4
                    { "OUT", errorMessage, OracleTypes.VARCHAR } }; //5

        try {
            DBUtils.callDBStoredProcedure(am.getDBTransaction(),
                                          "call xxsc_contract_pkg.create_variations(?,?,?,?,?,?)",
                                          dobProcArgs);

        } catch (SQLException e) {
        }

        updatedHeader = dobProcArgs[2][1];
        updatedVersion = dobProcArgs[3][1];
        flag = (String)dobProcArgs[4][1];
        errorMessage = (String)dobProcArgs[5][1];

        //System.err.println("==Duplicate Created====" + errorMessage);
        //System.err.println("==Duplicate Created====" + updatedHeader);
        //System.err.println("==Duplicate Created====" + updatedVersion);
        //System.err.println("==Duplicate Created====" + flag);

        ADFContext.getCurrent().getSessionScope().put("idd", updatedHeader);
        ADFContext.getCurrent().getSessionScope().put("versionn",
                                                      updatedVersion);
        //           JSFUtils.addFacesInformationMessage("Flag"+updatedHeader);
        //           JSFUtils.addFacesInformationMessage("Flag"+updatedVersion);
        //           JSFUtils.addFacesInformationMessage("Flag"+flag);
        //           JSFUtils.addFacesInformationMessage("Flag"+errorMessage);

        //JSFUtils.addFacesInformationMessage("Copy Purchase Order Completed.");

        return flag;
    }


    public void onCallContHistroy(ActionEvent actionEvent) {
        if (ADFContext.getCurrent().getSessionScope().get("page").toString().equalsIgnoreCase("buy") ||
            ADFContext.getCurrent().getSessionScope().get("page").toString().equalsIgnoreCase("sell")) {
            if (conSearchHdrVO.getEstimatedRowCount() != 0) {
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                RichPopup pop = getP1();
                pop.show(hints);
                String headerNum =
                    conSearchHdrVO.getCurrentRow().getAttribute("ContractNum").toString();
                ViewCriteria vc = conHistoryHdrVO.createViewCriteria();
                ViewCriteriaRow vcr = vc.createViewCriteriaRow();
                vcr.setAttribute("ContractNum", headerNum);
                vc.addRow(vcr);
                conHistoryHdrVO.applyViewCriteria(vc);
                conHistoryHdrVO.executeQuery();
                //System.err.println("===CONTREACT HISTORY TABLE FILTER=====");
                BigDecimal totalSum =
                    calculateTotalSum(conHistoryHdrVO, "ContractAmount");
                //System.err.println("==Total Sum==" + totalSum);
                ADFContext.getCurrent().getSessionScope().put("totalSum",
                                                              totalSum);
            }
        } else if (ADFContext.getCurrent().getSessionScope().get("page").toString().equalsIgnoreCase("variation")) {
            if (variationConHdrVO.getEstimatedRowCount() != 0) {
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                RichPopup pop = getP1();
                pop.show(hints);
                String headerNum =
                    variationConHdrVO.getCurrentRow().getAttribute("ContractNum").toString();
                ViewCriteria vc = conHistoryHdrVO.createViewCriteria();
                ViewCriteriaRow vcr = vc.createViewCriteriaRow();
                vcr.setAttribute("ContractNum", headerNum);
                vc.addRow(vcr);
                conHistoryHdrVO.applyViewCriteria(vc);
                conHistoryHdrVO.executeQuery();
                //System.err.println("===CONTREACT HISTORY TABLE FILTER=====");
                BigDecimal totalSum =
                    calculateTotalSum(conHistoryHdrVO, "ContractAmount");
                //System.err.println("==Total Sum==" + totalSum);
                ADFContext.getCurrent().getSessionScope().put("totalSum",
                                                              totalSum);
            }
        }

    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }


    public void setP2(RichPopup p2) {
        this.p2 = p2;
    }

    public RichPopup getP2() {
        return p2;
    }


    public void onCallCertificationHistory(ActionEvent actionEvent) {
        if (ADFContext.getCurrent().getSessionScope().get("page").toString().equalsIgnoreCase("buy") ||
            ADFContext.getCurrent().getSessionScope().get("page").toString().equalsIgnoreCase("sell")) {
            if (conSearchHdrVO.getEstimatedRowCount() != 0) {
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                RichPopup pop = getP2();
                pop.show(hints);
                String contractID =
                    conSearchHdrVO.getCurrentRow().getAttribute("ContHeaderId").toString();
                // Filter in certification History ROVO- contract Id
                ViewCriteria vc =
                    certificationHistoryHdrVO.createViewCriteria();
                ViewCriteriaRow vcr = vc.createViewCriteriaRow();
                vcr.setAttribute("ContHeaderId", contractID);
                vc.addRow(vcr);
                certificationHistoryHdrVO.applyViewCriteria(vc);
                certificationHistoryHdrVO.executeQuery();
                //System.err.println("===CERTIFICATION HISTORY TABLE FILTER=====");
            }
        } else if (ADFContext.getCurrent().getSessionScope().get("page").toString().equalsIgnoreCase("variation")) {
            if (variationConHdrVO.getEstimatedRowCount() != 0) {
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                RichPopup pop = getP2();
                pop.show(hints);
                String contractID =
                    variationConHdrVO.getCurrentRow().getAttribute("ContHeaderId").toString();
                // Filter in certification History ROVO- contract Id
                ViewCriteria vc =
                    certificationHistoryHdrVO.createViewCriteria();
                ViewCriteriaRow vcr = vc.createViewCriteriaRow();
                vcr.setAttribute("ContHeaderId", contractID);
                vc.addRow(vcr);
                certificationHistoryHdrVO.applyViewCriteria(vc);
                certificationHistoryHdrVO.executeQuery();
                //System.err.println("===CERTIFICATION HISTORY TABLE FILTER=====");
            }
        }
    }


    public void onCallApplicationHistory(ActionEvent actionEvent) {
        if (ADFContext.getCurrent().getSessionScope().get("page").toString().equalsIgnoreCase("buy") ||
            ADFContext.getCurrent().getSessionScope().get("page").toString().equalsIgnoreCase("sell")) {
            if (conSearchHdrVO.getEstimatedRowCount() != 0) {
                RichPopup.PopupHints hint = new RichPopup.PopupHints();
                RichPopup pop = getP3();
                pop.show(hint);
                String contractID =
                    conSearchHdrVO.getCurrentRow().getAttribute("ContHeaderId").toString();
                // Filter in certification History ROVO- contract Id
                ViewCriteria vc = applicationHistoryHdrVO.createViewCriteria();
                ViewCriteriaRow vcr = vc.createViewCriteriaRow();
                vcr.setAttribute("ContHeaderId", contractID);
                vc.addRow(vcr);
                applicationHistoryHdrVO.applyViewCriteria(vc);
                applicationHistoryHdrVO.executeQuery();
            }
        } else if (ADFContext.getCurrent().getSessionScope().get("page").toString().equalsIgnoreCase("variation")) {
            if (variationConHdrVO.getEstimatedRowCount() != 0) {
                RichPopup.PopupHints hint = new RichPopup.PopupHints();
                RichPopup pop = getP3();
                pop.show(hint);
                String contractID =
                    variationConHdrVO.getCurrentRow().getAttribute("ContHeaderId").toString();
                // Filter in certification History ROVO- contract Id
                ViewCriteria vc = applicationHistoryHdrVO.createViewCriteria();
                ViewCriteriaRow vcr = vc.createViewCriteriaRow();
                vcr.setAttribute("ContHeaderId", contractID);
                vc.addRow(vcr);
                applicationHistoryHdrVO.applyViewCriteria(vc);
                applicationHistoryHdrVO.executeQuery();
            }
        }
    }


    public void setAppInputText(RichInputText appInputText) {
        this.appInputText = appInputText;
    }

    public RichInputText getAppInputText() {
        return appInputText;
    }

    public void setCertInputText(RichInputText certInputText) {
        this.certInputText = certInputText;
    }

    public RichInputText getCertInputText() {
        return certInputText;
    }

    public void onClickApplicationSearch(ActionEvent actionEvent) {
        if (appInputText.getValue() != null) {
            ViewCriteria vc = applicationSearchHdrVO.createViewCriteria();
            ViewCriteriaRow vcr = vc.createViewCriteriaRow();
            vcr.setAttribute("ApplicationNumber",
                             "like %" + appInputText.getValue() + "%");
            vc.addRow(vcr);
            applicationSearchHdrVO.applyViewCriteria(vc);
            applicationSearchHdrVO.executeQuery();
            //System.err.println("111111===Application====1111111");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        } else {
            ViewCriteria vc = applicationSearchHdrVO.createViewCriteria();
            ViewCriteriaRow vcr = vc.createViewCriteriaRow();
            vcr.setAttribute("ApplicationNumber", "");
            vc.addRow(vcr);
            applicationSearchHdrVO.applyViewCriteria(vc);
            applicationSearchHdrVO.executeQuery();
            //System.err.println("222===Application===NULL=2222222222");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        }
    }

    public void onClickCertificationSearch(ActionEvent actionEvent) {
        if (certInputText.getValue() != null) {
            ViewCriteria vc = certificationSearchHdrVO.createViewCriteria();
            ViewCriteriaRow vcr = vc.createViewCriteriaRow();
            vcr.setAttribute("CertificationNumber",
                             "like %" + certInputText.getValue() + "%");
            vc.addRow(vcr);
            certificationSearchHdrVO.applyViewCriteria(vc);
            certificationSearchHdrVO.executeQuery();
            //System.err.println("111111===Certification====1111111");

        } else {
            ViewCriteria vc = certificationSearchHdrVO.createViewCriteria();
            ViewCriteriaRow vcr = vc.createViewCriteriaRow();
            vcr.setAttribute("CertificationNumber", "");
            vc.addRow(vcr);
            certificationSearchHdrVO.applyViewCriteria(vc);
            certificationSearchHdrVO.executeQuery();
            //System.err.println("222===Certification===NULL=2222222222");
        }
    }


    public void setP3(RichPopup p3) {
        this.p3 = p3;
    }

    public RichPopup getP3() {
        return p3;
    }

    public void setBuyAppInputText(RichInputText buyAppInputText) {
        this.buyAppInputText = buyAppInputText;
    }

    public RichInputText getBuyAppInputText() {
        return buyAppInputText;
    }

    public void setVariationInputText(RichInputText variationInputText) {
        this.variationInputText = variationInputText;
    }

    public RichInputText getVariationInputText() {
        return variationInputText;
    }

    public void setT4(RichTable t4) {
        this.t4 = t4;
    }

    public RichTable getT4() {
        return t4;
    }

    public void onClickContractVariationSearch(ActionEvent actionEvent) {
        if (variationInputText.getValue() != null) {
            ViewCriteria vc = variationConHdrVO.createViewCriteria();
            ViewCriteriaRow vcr = vc.createViewCriteriaRow();
            vcr.setAttribute("ContractNum",
                             "like %" + variationInputText.getValue() + "%");
            vc.addRow(vcr);
            variationConHdrVO.applyViewCriteria(vc);
            variationConHdrVO.executeQuery();
            //System.err.println("1111111===Variation===11111111");
        } else {
            ViewCriteria vc = variationConHdrVO.createViewCriteria();
            ViewCriteriaRow vcr = vc.createViewCriteriaRow();
            vcr.setAttribute("ContractNum", "");
            vc.addRow(vcr);
            variationConHdrVO.applyViewCriteria(vc);
            variationConHdrVO.executeQuery();
            //System.err.println("222222===Variation===2222222");
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(t4);
    }


    public void createPOACL(ActionEvent actionEvent) {
        ViewObject srchVO =
            ADFUtils.findIterator("applicationSearchROVO1Iterator").getViewObject();
        ViewObject contHdrVO =
            ADFUtils.findIterator("XxscContractHeadersVO1Iterator").getViewObject();
        ViewObjectImpl contHdrImpl = (ViewObjectImpl)contHdrVO.getViewObject();
        ViewObject contDtlVO =
            ADFUtils.findIterator("XxscContractLinesVO1Iterator").getViewObject();

        contHdrVO.setNamedWhereClauseParam("BV_ID",
                                           srchVO.getCurrentRow().getAttribute("ContHeaderId"));
        contHdrVO.setNamedWhereClauseParam("BV_VER",
                                           srchVO.getCurrentRow().getAttribute("Version"));
        contHdrVO.applyViewCriteria(contHdrImpl.getViewCriteria("findById"));
        contHdrVO.executeQuery();
        if (contHdrVO.first() != null) {
            RowSetIterator hdrRS = contHdrVO.createRowSetIterator(null);
            while (hdrRS.hasNext()) {
                Row hdrRow = hdrRS.next();
                contHdrVO.setCurrentRow(hdrRow);
                hdrRow.getAttribute("businessUnitTRANS");
                hdrRow.getAttribute("VendorId");
                hdrRow.getAttribute("CurrencyCode");
                //***********Header Values

                RowSetIterator dtlRS = contDtlVO.createRowSetIterator(null);
                while (dtlRS.hasNext()) {
                    Row dtlRow = dtlRS.next();
                    //*********Detail Values
                    dtlRow.getAttribute("ItemDescription");

                }


            }
        }

    }

    public void onClickBuyApplicationSearch(ActionEvent actionEvent) {
        if (buyAppInputText.getValue() != null) {
            ViewCriteria vc = applicationSearchHdrVO.createViewCriteria();
            ViewCriteriaRow vcr = vc.createViewCriteriaRow();
            vcr.setAttribute("ApplicationNumber",
                             "like %" + buyAppInputText.getValue() + "%");
            vc.addRow(vcr);
            applicationSearchHdrVO.applyViewCriteria(vc);
            applicationSearchHdrVO.executeQuery();
            //System.err.println("111111===Buy Application====1111111");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        } else {
            ViewCriteria vc = applicationSearchHdrVO.createViewCriteria();
            ViewCriteriaRow vcr = vc.createViewCriteriaRow();
            vcr.setAttribute("ApplicationNumber", "");
            vc.addRow(vcr);
            applicationSearchHdrVO.applyViewCriteria(vc);
            applicationSearchHdrVO.executeQuery();
            //System.err.println("222===Buy Application===NULL=2222222222");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        }
    }

    public BigDecimal calculateTotalSum(ViewObject vo, String sumColumnName) {
        double total = 0;
        RowSetIterator rs = vo.createRowSetIterator(null);
        while (rs.hasNext()) {
            Row r = rs.next();
            double sum =
                r.getAttribute(sumColumnName) == null ? 0 : Double.parseDouble(r.getAttribute(sumColumnName).toString());
            total = total + sum;
        }
        return new BigDecimal(total);
    }


    public String onClickApplication() {
        String pageRedirect = null;
        try {
            if (ADFContext.getCurrent().getSessionScope().get("contractStatus").toString().equalsIgnoreCase("ACTIVE")) {
                pageRedirect = "Application";
            } else {
                JSFUtils.addFacesErrorMessage("Selected Contract is not Active. Please check");
                pageRedirect = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pageRedirect;
    }

    public void onClickTotal(ActionEvent actionEvent) {
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy") &&
            ADFContext.getCurrent().getSessionScope().get("intent").equals("B")) {
            // Contract- Buy
            filterTable(conSearchHdrVO, "ContractNum", "", "B");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("S")) {
            // Contract- Sell
            filterTable(conSearchHdrVO, "ContractNum", "", "S");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("B")) {
            // Application- Buy
            filterTable(applicationSearchHdrVO, "ApplicationNumber", "", "B");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("S")) {
            // Application- Sell
            filterTable(applicationSearchHdrVO, "ApplicationNumber", "", "S");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("B")) {
            // Certification- Buy
            filterTable(certificationSearchHdrVO, "CertificationNumber", "",
                        "B");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("S")) {
            // Certification- Sell
            filterTable(certificationSearchHdrVO, "CertificationNumber", "",
                        "S");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("retentionBuy") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("B")) {
            //Retention- Buy
            filterTable(contRetSearchHdrVO, "RetRelNumber", "", "B");
            AdfFacesContext.getCurrentInstance().addPartialTarget(resId5);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("retentionSell") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("S")) {
            //Retention- Sell
            filterTable(contRetSearchHdrVO, "RetRelNumber", "", "S");
            AdfFacesContext.getCurrentInstance().addPartialTarget(resId5);
        }
    }

    public void onClickPending(ActionEvent actionEvent) {
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy") &&
            ADFContext.getCurrent().getSessionScope().get("intent").equals("B")) {
            // Contract- Buy
            filterTable(conSearchHdrVO, "ApprovalStatus", "PEN", "B");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("S")) {
            // Contract- Sell
            filterTable(conSearchHdrVO, "ApprovalStatus", "PEN", "S");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("B")) {
            // Application- Buy
            filterTable(applicationSearchHdrVO, "ApprovalStatusAppl", "PEN",
                        "B");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("S")) {
            // Application- Sell
            filterTable(applicationSearchHdrVO, "ApprovalStatusAppl", "PEN",
                        "S");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("B")) {
            // Certification- Buy
            filterTable(certificationSearchHdrVO, "ApprovalStatusCert", "PEN",
                        "B");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("S")) {
            // Certification- Sell
            filterTable(certificationSearchHdrVO, "ApprovalStatusCert", "PEN",
                        "S");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("retentionBuy") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("B")) {
            //Retention- Buy
            filterTable(contRetSearchHdrVO, "ApprovalStatus", "PEN", "B");
            AdfFacesContext.getCurrentInstance().addPartialTarget(resId5);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("retentionSell") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("S")) {
            //Retention- Sell
            filterTable(contRetSearchHdrVO, "ApprovalStatus", "PEN", "S");
            AdfFacesContext.getCurrentInstance().addPartialTarget(resId5);
        }
    }

    public void onClickApproved(ActionEvent actionEvent) {
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy") &&
            ADFContext.getCurrent().getSessionScope().get("intent").equals("B")) {
            // Contract- Buy
            filterTable(conSearchHdrVO, "ApprovalStatus", "APR", "B");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("S")) {
            // Contract- Sell
            filterTable(conSearchHdrVO, "ApprovalStatus", "APR", "S");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("B")) {
            // Application- Buy
            filterTable(applicationSearchHdrVO, "ApprovalStatusAppl", "APR",
                        "B");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("S")) {
            // Application- Sell
            filterTable(applicationSearchHdrVO, "ApprovalStatusAppl", "APR",
                        "S");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("B")) {
            // Certification- Buy
            filterTable(certificationSearchHdrVO, "ApprovalStatusCert", "APR",
                        "B");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("S")) {
            // Certification- Sell
            filterTable(certificationSearchHdrVO, "ApprovalStatusCert", "APR",
                        "S");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("retentionBuy") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("B")) {
            //Retention- Buy
            filterTable(contRetSearchHdrVO, "ApprovalStatus", "APR", "B");
            AdfFacesContext.getCurrentInstance().addPartialTarget(resId5);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("retentionSell") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("S")) {
            //Retention- Sell
            filterTable(contRetSearchHdrVO, "ApprovalStatus", "APR", "S");
            AdfFacesContext.getCurrentInstance().addPartialTarget(resId5);
        }
    }

    public void onClickReject(ActionEvent actionEvent) {
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy") &&
            ADFContext.getCurrent().getSessionScope().get("intent").equals("B")) {
            // Contract- Buy
            filterTable(conSearchHdrVO, "ApprovalStatus", "REJ", "B");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("S")) {
            // Contract- Sell
            filterTable(conSearchHdrVO, "ApprovalStatus", "REJ", "S");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("B")) {
            // Application- Buy
            filterTable(applicationSearchHdrVO, "ApprovalStatusAppl", "REJ",
                        "B");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("S")) {
            // Application- Sell
            filterTable(applicationSearchHdrVO, "ApprovalStatusAppl", "REJ",
                        "S");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("B")) {
            // Certification- Buy
            filterTable(certificationSearchHdrVO, "ApprovalStatusCert", "REJ",
                        "B");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("S")) {
            // Certification- Sell
            filterTable(certificationSearchHdrVO, "ApprovalStatusCert", "REJ",
                        "S");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("retentionBuy") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("B")) {
            //Retention- Buy
            filterTable(contRetSearchHdrVO, "ApprovalStatus", "REJ", "B");
            AdfFacesContext.getCurrentInstance().addPartialTarget(resId5);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("retentionSell") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("S")) {
            //Retention- Sell
            filterTable(contRetSearchHdrVO, "ApprovalStatus", "REJ", "S");
            AdfFacesContext.getCurrentInstance().addPartialTarget(resId5);
        }
    }

    public void onClickActive(ActionEvent actionEvent) {
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy") &&
            ADFContext.getCurrent().getSessionScope().get("intent").equals("B")) {
            // Contract- Buy
            filterTable(conSearchHdrVO, "ContractStatus", "ACTIVE", "B");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("S")) {
            // Contract- Sell
            filterTable(conSearchHdrVO, "ContractStatus", "ACTIVE", "S");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("B")) {
            // Application- Buy
            filterTable(applicationSearchHdrVO, "ApplicationStatus", "ACTIVE",
                        "B");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("S")) {
            // Application- Sell
            filterTable(applicationSearchHdrVO, "ApplicationStatus", "ACTIVE",
                        "S");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("B")) {
            // Certification- Buy
            filterTable(certificationSearchHdrVO, "CertificationStatus",
                        "ACTIVE", "B");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("S")) {
            // Certification- Sell
            filterTable(certificationSearchHdrVO, "CertificationStatus",
                        "ACTIVE", "S");
            AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("retentionBuy") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("B")) {
            //Retention- Buy
            filterTable(contRetSearchHdrVO, "RetRelStatus", "ACTIVE", "B");
            AdfFacesContext.getCurrentInstance().addPartialTarget(resId5);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("retentionSell") &&
                   ADFContext.getCurrent().getSessionScope().get("intent").equals("S")) {
            //Retention- Sell
            filterTable(contRetSearchHdrVO, "RetRelStatus", "ACTIVE", "S");
            AdfFacesContext.getCurrentInstance().addPartialTarget(resId5);
        }
    }


    public void filterTable(ViewObject vo, String columnName, String value,
                            String IntentValue) {
        ViewCriteria vc = vo.createViewCriteria();
        ViewCriteriaRow vcr = vc.createViewCriteriaRow();
        vcr.setAttribute(columnName, value);
        vcr.setAttribute("Intent", IntentValue);
        vc.addRow(vcr);
        vo.applyViewCriteria(vc);
        vo.executeQuery();

    }

    public void setT3(RichTable t3) {
        this.t3 = t3;
    }

    public RichTable getT3() {
        return t3;
    }

    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }

    public void setResId5(RichTable resId5) {
        this.resId5 = resId5;
    }

    public RichTable getResId5() {
        return resId5;
    }

    public void setIt9(RichInputText it9) {
        this.it9 = it9;
    }

    public RichInputText getIt9() {
        return it9;
    }

    public void onClickRetentionSearch(ActionEvent actionEvent) {
        if (it9.getValue() != null) {
            ViewCriteria vc = contRetSearchHdrVO.createViewCriteria();
            ViewCriteriaRow vcr = vc.createViewCriteriaRow();
            vcr.setAttribute("RetRelNumber", "like %" + it9.getValue() + "%");
            vc.addRow(vcr);
            contRetSearchHdrVO.applyViewCriteria(vc);
            contRetSearchHdrVO.executeQuery();
            //System.err.println("111111111111111");
        } else {
            //ViewObject conHdrVO = ADFUtils.findIterator("contractROVO1Iterator").getViewObject();
            ViewCriteria vc = contRetSearchHdrVO.createViewCriteria();
            ViewCriteriaRow vcr = vc.createViewCriteriaRow();
            vcr.setAttribute("RetRelNumber", "");
            vc.addRow(vcr);
            contRetSearchHdrVO.applyViewCriteria(vc);
            contRetSearchHdrVO.executeQuery();
            //System.err.println("2222222222222");
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(resId5);
    }

    public String getXMLData(Number certId) throws Exception {
        String retStr = "";
        Context ctx;
        Connection con = null;
        ctx = new InitialContext();
        //       String dataSource = "apex";
        //       String dataSource = "contract";
        //       String dataSource = "apex";
        String dataSource = "apex";
        DataSource ds = (DataSource)ctx.lookup(dataSource);
        con = ds.getConnection();
        String selectSQL =
            "SELECT XXSC_REPORT_PKG.contract_summary('" + certId +
            "') xml FROM dual";
        PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
        //System.err.println("=====OUT XML==" + selectSQL);
        ResultSet rs1 = preparedStatement.executeQuery(selectSQL);
        while (rs1.next()) {
            retStr = rs1.getString("xml");
        }
        //System.err.println("=====OUT XML==" + retStr);
        con.close();
        return retStr;
    }

    public ServletContext getContext() {
        return (ServletContext)getFacesContext().getExternalContext().getContext();
    }

    public HttpServletResponse getResponse() {
        return (HttpServletResponse)getFacesContext().getExternalContext().getResponse();
    }

    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public byte[] runReport(String templateFile) {
        //  String  templateFile = ;
        byte[] dataBytes = null;

        try {
            ServletContext context = getContext();
            InputStream fs = context.getResourceAsStream(templateFile);
            //Process RTF template to convert to XSL-FO format
            //System.err.println("====1====");
            RTFProcessor rtfp = new RTFProcessor(fs);
            ByteArrayOutputStream xslOutStream = new ByteArrayOutputStream();
            rtfp.setOutput(xslOutStream);
            rtfp.process();
            //System.err.println("====2====");
            //Use XSL Template and Data from the VO to generate report and return the OutputStream of report
            ByteArrayInputStream xslInStream =
                new ByteArrayInputStream(xslOutStream.toByteArray());
            ViewObject vo =
                Utils.ADFUtils.findIterator("contractROVO1Iterator").getViewObject();

            Number cert =
                (Number)vo.getCurrentRow().getAttribute("ContHeaderId");
            FOProcessor processor = new FOProcessor();
            ByteArrayInputStream dataStream =
                //new ByteArrayInputStream((byte[])ADFUtils.findOperation("getXMLData").execute());
                new ByteArrayInputStream((getXMLData(cert).getBytes()));
            processor.setData(dataStream);
            processor.setTemplate(xslInStream);

            ByteArrayOutputStream pdfOutStream = new ByteArrayOutputStream();
            processor.setOutput(pdfOutStream);
            byte outFileTypeByte = FOProcessor.FORMAT_PDF;
            processor.setOutputFormat(outFileTypeByte);
            processor.generate();

            dataBytes = pdfOutStream.toByteArray();

        } catch (IOException e) {
            //System.out.println("IOException when generating pdf===IO" +
//                               e.toString());
        } catch (Exception e) {
            // e.printStackTrace();
            //System.out.println("IOException when generating pdf===EXE" +
//                               e.toString());

        }
        return dataBytes;
    }

    public void onClickPDF(javax.faces.context.FacesContext facesContext,
                           OutputStream outputStream) {
        try {

            ViewObject vo =
                Utils.ADFUtils.findIterator("contractROVO1Iterator").getViewObject();
            Number contID =
                (Number)vo.getCurrentRow().getAttribute("ContHeaderId");
            Object result =
                RTFUtils.runReport(("//reports//Contract Summary.rtf"), contID,
                                   "contract_summary1");
            //                Object result = runReport("//reports//Contract Summary.rtf");
            outputStream.write((byte[])result);
        } catch (IOException e) {
            //System.out.println("Exception " + e);
        }

    }

    public void onClickDelete(ActionEvent actionEvent) throws SQLException {
        ViewObject conSearchHdrVO =
            ADFUtils.findIterator("contractROVO1Iterator").getViewObject();
        Object hid =
            (Object)conSearchHdrVO.getCurrentRow().getAttribute("ContHeaderId").toString();
        String status =
            conSearchHdrVO.getCurrentRow().getAttribute("ApprovalStatus") ==
            null ? "" :
            conSearchHdrVO.getCurrentRow().getAttribute("ApprovalStatus").toString();
        if (status.equalsIgnoreCase("DRA")) {
            hid =
conSearchHdrVO.getCurrentRow().getAttribute("ContHeaderId").toString();
            oracle.jbo.domain.Number headerID =
                new oracle.jbo.domain.Number(hid.toString());
            //System.err.println("=---headID----" + headerID);
            String msg = null;
            ApplicationModuleImpl am =
                (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(null);
            dobProcArgs =
                    new Object[][] { { "IN", headerID, OracleTypes.NUMBER },
                        //0
                        { "OUT", msg, OracleTypes.VARCHAR }, }; //1
            try {

                DBUtils.callDBStoredProcedure(am.getDBTransaction(),
                                              "call xxsc_contract_pkg .purge_Contract(?,?)",
                                              dobProcArgs);

            } catch (SQLException e) {
            }
            msg = (String)dobProcArgs[1][1];
            if (msg.equalsIgnoreCase("S")) {
                JSFUtils.addFacesErrorMessage("Contract Deleted Successfully");
                conSearchHdrVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
            } else {
                conSearchHdrVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
            }

        }
    }

    public void onClickSync(ActionEvent actionEvent) throws 
                                                            IOException,
                                                            JSONException {
        // Add event code here...
        String syncResp = invokeRWServices("BUY_CONTRACT_HEADERS");

        if ("success".equals(syncResp)) {
            String syncLineResp = invokeRWServices("BUY_CONTRACT_LINES");
            if ("success".equals(syncLineResp)) {
                JSFUtils.addFacesInformationMessage("Contract Sync Completed ..");
            }
        }
        else{
                JSFUtils.addFacesInformationMessage("No Contracts for sync ..");
            }
        //        if(1){
        //                String syncResp=invokeRWServices("BUY_CONTRACT_LINES");
        //            }
    }

    public String invokeRWServices(String param) throws 
                                                        IOException,
                                                        JSONException {
        String defaultUserPass = "";
        String result=null;
      //  URL obj =new URL("http://localhost:8080/SyncReport/webresources/sync/BIReport/" +param); //Local
        //URL obj = new URL("https://ncltstjcs.naresco.ae/SyncReport/webresources/sync/BIReport/"+param);//Test
         URL obj = new URL("https://nclprdjcs.naresco.ae/SyncReport/webresources/sync/BIReport/"+param);//PROD

        HttpURLConnection postConnection =
            (HttpURLConnection)obj.openConnection();
        postConnection.setRequestMethod("GET");
        //                    String basicAuth = "Basic " + new String(Base64.getEncoder().encode(defaultUserPass.getBytes()));
        //                    postConnection.setRequestProperty("Authorization", basicAuth);
        postConnection.setRequestProperty("Content-Type", "application/json");
        postConnection.setDoOutput(true);
        int responseCode = postConnection.getResponseCode();
        StringBuffer response = new StringBuffer();
        String resMsg = null;

        //System.out.println("GET Response Code :  " + responseCode);
        //System.out.println("GET Response Message : " +
//                           postConnection.getResponseMessage());
        resMsg = postConnection.getResponseMessage();

       
        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in =
                new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
            StringBuilder out = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                out.append(inputLine);
            }
            in.close();
            // print result
           
            JSONObject jsonObject = new JSONObject(response.toString());
             result = jsonObject.getString("Response");
            //System.out.println(response.toString());
            //System.out.println(result);
        } else {
            //System.out.println("GET NOT WORKED");
        }
        return result;
    }

    public void onClickDeleteCert(ActionEvent actionEvent) {
        RichPopup.PopupHints hints=new RichPopup.PopupHints();
          this.getP5().show(hints);
    }

    public void setP5(RichPopup p5) {
        this.p5 = p5;
    }

    public RichPopup getP5() {
        return p5;
    }

    public void onClickOkDialogue(DialogEvent dialogEvent) {
        if(dialogEvent.getOutcome()==DialogEvent.Outcome.ok){
            String ipaddress="";
                                try {
                                InetAddress IP=InetAddress.getLocalHost();
                                ipaddress=IP.toString();
                                } catch (UnknownHostException e) {
                                }
                                
            String certid=JSFUtils.resolveExpression("#{bindings.CertHeaderId.inputValue}").toString();
            OperationBinding op = (OperationBinding)ADFUtils.findOperation("deletedbcall");
                        op.getParamsMap().put("p_cid",certid);
                        op.getParamsMap().put("p_type","CERTIFICATION");
                        op.getParamsMap().put("P_username",ADFContext.getCurrent().getSessionScope().get("userName").toString());
                        op.getParamsMap().put("p_ip",ipaddress);
                        Object result =op.execute();
                        
                        certificationSearchHdrVO.executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(t2);
                        JSFUtils.addFacesInformationMessage(result.toString()); 
            
        }
    }

    public void onClickDeleteApp(ActionEvent actionEvent) {
        RichPopup.PopupHints hints=new RichPopup.PopupHints();
           this.getP6().show(hints);
    }

    public void onClickDailogueOkApp(DialogEvent dialogEvent) {
        if(dialogEvent.getOutcome()==DialogEvent.Outcome.ok){

                              String ipaddress="";
                                       try {
                                       InetAddress IP=InetAddress.getLocalHost();
                                       ipaddress=IP.toString();
                                       } catch (UnknownHostException e) {
                                       }
                                       
                   String appid=JSFUtils.resolveExpression("#{bindings.ApplHeaderId.inputValue}").toString();
                   OperationBinding op = (OperationBinding)ADFUtils.findOperation("deletedbcall");
                               op.getParamsMap().put("p_cid",appid);
                               op.getParamsMap().put("p_type","APPLICATION");
                               op.getParamsMap().put("P_username",ADFContext.getCurrent().getSessionScope().get("userName").toString());
                               op.getParamsMap().put("p_ip",ipaddress);
                               Object result =op.execute();
                               
                               applicationSearchHdrVO.executeQuery();
                   AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
                               JSFUtils.addFacesInformationMessage(result.toString()); 
               }
    }

    public void setP6(RichPopup p6) {
        this.p6 = p6;
    }

    public RichPopup getP6() {
        return p6;
    }
}
