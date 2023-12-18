package backing;


import Utils.ADFApproval;
import Utils.ADFMathUtils;
import Utils.ADFUtils;

import Utils.DBUtils;
import Utils.JSFUtils;

import Utils.MailHtmlBody;
import Utils.MailServices;

import Utils.MailTemplates;

import java.util.ArrayList;

import com.sun.el.parser.ParseException;

import com.sun.faces.taglib.jsf_core.ValidateDoubleRangeTag;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.math.BigDecimal;

import java.net.InetAddress;
import java.net.MalformedURLException;

import java.net.UnknownHostException;

import java.sql.Date;

import java.sql.SQLException;

import java.sql.Timestamp;

import java.text.DateFormat;

import java.text.DecimalFormat;


import java.util.List;
import java.util.Map;

import java.text.SimpleDateFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.OperationBinding;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.faces.bi.component.pivotTable.UIPivotTable;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;

import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandImageLink;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;


//import oracle.adfinternal.view.faces.bi.renderkit.pivotTable.RichPivotTableRenderer;


import oracle.adf.view.rich.event.DialogEvent;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;


import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewObjectImpl;

import oracle.jbo.uicli.binding.JUCtrlHierBinding;

import oracle.jdbc.OracleTypes;

import org.apache.myfaces.trinidad.model.CollectionModel;
import org.apache.myfaces.trinidad.model.UploadedFile;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import subcontract.view.backing.WEBINF.oracle.apps.uikit.Fragments.ContractUnderAmend;
import subcontract.view.backing.WEBINF.oracle.apps.uikit.Fragments.SubmitForApproval;


public class ContractClass {
    private RichInputDate stdate;
    private RichInputDate endate;
    private RichInputDate revdate;
    private RichInputText tocInDays;
    private RichInputText qty;
    private RichInputText price;
    private RichInputText lineAmount;
    private RichInputText revQty;
    private RichInputText revPrice;
    private RichInputText revLineAmount;
    private RichInputText revLineAmount1;
    private RichOutputText contractAmount;
    private RichInputText varPrice;
    private RichInputText varAmount;
    private RichInputText varQty;
    private RichOutputText contVariationAmount;
    private RichOutputText contRevisedAmount;
    private RichOutputText contTotalSum;
    private RichInputText provisionalSum;
    private RichInputListOfValues onChnageSupplierType;
    private RichInputListOfValues vendorName_Trans;
    private RichTable contractLineTable;
    private RichInputFile if1;
    private RichInputText liqAmount;
    private RichInputText matRec;
    private RichInputText mat;
    private RichInputText advRec;
    private RichInputText adv;
    private RichInputText retRel;
    private RichInputText ret;
    private RichInputText pen;
    private RichInputListOfValues reqNumber1Id;
    private RichSelectOneChoice projectNumber;
    private RichPopup contractInfoCancelPopup;
    private RichPopup partyInfoCancelPopup;
    private RichPopup lineInfoCancelPopup;
    private RichPopup payInfoCancelPopup;
    private RichPopup gauInfoCancelPopup;
    private RichInputDate guaStDate;
    private RichInputDate guaEnDate;
    private RichInputText gauDuration;
    private RichInputText guaDayBind;
    private RichInputText liquidated;
    private RichInputText penalty;
    private RichInputText retention;
    private RichInputText retentionRelease;
    private RichInputText advance;
    private RichInputText advanceRec;
    private RichInputText materials;
    private RichInputText materialsRec;
    private RichInputListOfValues currencyCodeId;
    private RichSelectOneChoice conversionRate;
    private RichInputText conversionRateValue;
    private RichInputText dlpPeriodCategory;
    private RichInputDate defectLiabEndDate;
    private RichSelectOneChoice dlpPeriodCategoryType;
    private RichInputFile if2;
    private RichInputFile if3;
    private RichInputText retentionRelease2;
    private UIPivotTable ptt1;
    private RichInputText rejectValue;
    private RichPopup p3;
    private RichPopup p4;
    private RichInputText approValue;
    private RichInputText ecpTotalAmount;
    private RichOutputText ecpTotAmt;
    private RichCommandImageLink cl1;
    private RichCommandButton cb9;
    private RichCommandButton cb8;
    private RichInputText var_amt;
    private RichInputText rev_cont_amt;
    private RichSelectOneChoice guarCategory;
    private RichDialog d4;
    private RichPopup p5;
    private RichInputFile gaunImprt;
    private RichSelectOneChoice gaurTyp;
    private RichSelectBooleanCheckbox checkNoti;
    private RichInputText gauVal;
    private RichInputText gauRefNo;
    private RichOutputText fileNam;
    private RichInputText fileNameAtt;
    private RichSelectOneChoice attriBooleanGau;


    public ContractClass() {
    }

    ViewObject contractVO =
        ADFUtils.findIterator("XxscContractHeadersVO1Iterator").getViewObject();
    ViewObject searchContract =
        ADFUtils.findIterator("contractROVO1Iterator").getViewObject();
    Row contractRow = contractVO.getCurrentRow();
    ViewObject contractLineVO =
        ADFUtils.findIterator("XxscContractLinesVO1Iterator").getViewObject();
    Row contractLineRow = contractLineVO.getCurrentRow();
    ViewObject prVO =
        ADFUtils.findIterator("prLine_ROVO1Iterator").getViewObject();

    ViewObject glCurrencyVO =
        ADFUtils.findIterator("GLCurrencyCodeROVO1Iterator").getViewObject();
    ViewObject contractHrdAttachVO =
        ADFUtils.findIterator("XxscAttachmentVO1Iterator").getViewObject();
    ViewObject contractLnsAttachVO =
        ADFUtils.findIterator("XxscAttachmentVO2Iterator").getViewObject();

   

    /*
    public void onClickSave(ActionEvent actionEvent) {
        if(ADFContext.getCurrent().getSessionScope().get("page").equals("buy")){
                if (ADFContext.getCurrent().getSessionScope().get("addEditContract") !=null &&
                    ADFContext.getCurrent().getSessionScope().get("addEditContract").toString().equals("edit")) {
                    ADFUtils.findOperation("Commit").execute();
                    ADFUtils.refreshTable("ContractNum", searchContract);
                    JSFUtils.addFacesInformationMessage("Buy Contract Information Saved Successfully");

                }else{
                    contractRow.setAttribute("ContractNum", "CONT-"+contractRow.getAttribute("ContHeaderId"));
                    contractRow.setAttribute("Intent", "B");
                    ADFUtils.findOperation("Commit").execute();
                    searchContract.executeQuery();
                    ADFUtils.refreshTable("ContractNum", searchContract);
                    JSFUtils.numberFaceMessage("Buy Contract", contractRow.getAttribute("ContractNum"));
                }
        }else if(ADFContext.getCurrent().getSessionScope().get("page").equals("sell")){
                if (ADFContext.getCurrent().getSessionScope().get("addEditContract") !=null &&
                    ADFContext.getCurrent().getSessionScope().get("addEditContract").toString().equals("edit")) {
                    ADFUtils.findOperation("Commit").execute();
                    ADFUtils.refreshTable("ContractNum", searchContract);
                    JSFUtils.addFacesInformationMessage("Sell Contract Information Saved Successfully");

                }else{
                    contractRow.setAttribute("ContractNum", "CONT-"+contractRow.getAttribute("ContHeaderId"));
                    contractRow.setAttribute("Intent", "S");
                    ADFUtils.findOperation("Commit").execute();
                    ADFUtils.refreshTable("ContractNum", searchContract);
                    JSFUtils.numberFaceMessage("Sell Contract", contractRow.getAttribute("ContractNum"));
                }
         }else{
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Information Saved Successfully");
        }

    }

*/

    public void setStdate(RichInputDate stdate) {
        this.stdate = stdate;
    }

    public RichInputDate getStdate() {
        return stdate;
    }

    public void setEndate(RichInputDate endate) {
        this.endate = endate;
    }

    public RichInputDate getEndate() {
        return endate;
    }

    public void setRevdate(RichInputDate revdate) {
        this.revdate = revdate;
    }

    public RichInputDate getRevdate() {
        return revdate;
    }

    public void setTocInDays(RichInputText tocInDays) {
        this.tocInDays = tocInDays;
    }

    public RichInputText getTocInDays() {
        return tocInDays;
    }

    public void setIf1(RichInputFile if1) {
        this.if1 = if1;
    }

    public RichInputFile getIf1() {
        return if1;
    }

    public static long getDifferenceDaysBetweenTwoDates(oracle.jbo.domain.Date d1,
                                                        oracle.jbo.domain.Date d2) {
        if (d1 != null && d2 != null) {
            //           long diff = d2.getValue().getTime()-d1.getValue().getTime();
            //           //System.err.println("==d2=="+d2.getValue().getTime());
            //           //System.err.println("==d1=="+d1.getValue().getTime());
            //           //System.err.println("==diff=="+diff+"--diff in no  "+ diff/(24*60*60*1000) +"Extra-1--"+((diff/(24*60*60*1000))+1));
            return (((d2.getValue().getTime() - d1.getValue().getTime()) /
                     (24 * 60 * 60 * 1000)) + 1);
        }
        return 0;
    }

    public void endDateTOC(ValueChangeEvent valueChangeEvent) throws Exception {
        if (revdate.getValue() != null) {
            valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            oracle.jbo.domain.Date st =
                (oracle.jbo.domain.Date)stdate.getValue();
            //System.err.println("---JBO S Date" + st);
            oracle.jbo.domain.Date rev =
                (oracle.jbo.domain.Date)revdate.getValue();
            //System.err.println("---JBO Rev Date" + rev);
            long nDays = getDifferenceDaysBetweenTwoDates(st, rev);
            oracle.jbo.domain.Number noDays =
                new oracle.jbo.domain.Number(nDays);
            //System.err.println("======retDate no of Days======" + noDays);
            tocInDays.setValue(noDays);
            AdfFacesContext.getCurrentInstance().addPartialTarget(tocInDays);

        } else {
            valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            oracle.jbo.domain.Date st =
                (oracle.jbo.domain.Date)stdate.getValue();
            //System.err.println("---JBO S Date" + st);
            oracle.jbo.domain.Date en =
                (oracle.jbo.domain.Date)valueChangeEvent.getNewValue();
            //System.err.println("---JBO E Date" + en);
            long nDays = getDifferenceDaysBetweenTwoDates(st, en);
            oracle.jbo.domain.Number noDays =
                new oracle.jbo.domain.Number(nDays);
            //System.err.println("======END no of Days======" + noDays);
            tocInDays.setValue(noDays);
            AdfFacesContext.getCurrentInstance().addPartialTarget(tocInDays);
            if (contractVO.getCurrentRow().getAttribute("DlpPeriodCategory") !=
                null &&
                contractVO.getCurrentRow().getAttribute("DefectLiabPeriod") !=
                null) {
                String dLPEndDate = null;
                String dlpCategoryType =
                    contractVO.getCurrentRow().getAttribute("DlpPeriodCategory") ==
                    null ? "0" :
                    contractVO.getCurrentRow().getAttribute("DlpPeriodCategory").toString();
                long dlpCategorynumber =
                    contractVO.getCurrentRow().getAttribute("DefectLiabPeriod") ==
                    null ? 0 :
                    Long.parseLong(contractVO.getCurrentRow().getAttribute("DefectLiabPeriod").toString());
                String enDate =
                    valueChangeEvent.getNewValue() == null ? "0" : valueChangeEvent.getNewValue().toString();
                DateTimeFormatter dtf =
                    DateTimeFormat.forPattern("YYYY-MM-dd");
                DateTime dtEndDate = dtf.parseDateTime(enDate);
                dLPEndDate =
                        dtf.print(dateExtend(dlpCategoryType, dlpCategorynumber,
                                             dtEndDate));
                // String to Jbo Date
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date = df.parse(dLPEndDate);
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                oracle.jbo.domain.Date jboDate =
                    new oracle.jbo.domain.Date(sqlDate);
                //System.err.println("--Final--" + jboDate);
                contractVO.getCurrentRow().setAttribute("DefectLiabEndDate",
                                                        jboDate);
            }

        }
    }


    public void revDateTOC(ValueChangeEvent valueChangeEvent) throws Exception {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        oracle.jbo.domain.Date st = (oracle.jbo.domain.Date)stdate.getValue();
        //System.err.println("---JBO S Date" + st);
        oracle.jbo.domain.Date rev =
            (oracle.jbo.domain.Date)valueChangeEvent.getNewValue();
        //System.err.println("---JBO Rev Date" + rev);
        long nDays = getDifferenceDaysBetweenTwoDates(st, rev);
        oracle.jbo.domain.Number noDays = new oracle.jbo.domain.Number(nDays);
        //System.err.println("======END no of Days======" + noDays);
        tocInDays.setValue(noDays);
        AdfFacesContext.getCurrentInstance().addPartialTarget(tocInDays);
        if (contractVO.getCurrentRow().getAttribute("DlpPeriodCategory") !=
            null &&
            contractVO.getCurrentRow().getAttribute("DefectLiabPeriod") !=
            null) {
            String dLPEndDate = null;
            String dlpCategoryType =
                contractVO.getCurrentRow().getAttribute("DlpPeriodCategory") ==
                null ? "0" :
                contractVO.getCurrentRow().getAttribute("DlpPeriodCategory").toString();
            long dlpCategorynumber =
                contractVO.getCurrentRow().getAttribute("DefectLiabPeriod") ==
                null ? 0 :
                Long.parseLong(contractVO.getCurrentRow().getAttribute("DefectLiabPeriod").toString());
            String reDate =
                valueChangeEvent.getNewValue() == null ? "0" : valueChangeEvent.getNewValue().toString();
            DateTimeFormatter dtf = DateTimeFormat.forPattern("YYYY-MM-dd");
            DateTime dtEndDate = dtf.parseDateTime(reDate);
            dLPEndDate =
                    dtf.print(dateExtend(dlpCategoryType, dlpCategorynumber,
                                         dtEndDate));
            // String to Jbo Date
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = df.parse(dLPEndDate);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            oracle.jbo.domain.Date jboDate =
                new oracle.jbo.domain.Date(sqlDate);
            //System.err.println("--Final--" + jboDate);
            contractVO.getCurrentRow().setAttribute("DefectLiabEndDate",
                                                    jboDate);
        }
    }

    public void setQty(RichInputText qty) {
        this.qty = qty;
    }

    public RichInputText getQty() {
        return qty;
    }

    public void setPrice(RichInputText price) {
        this.price = price;
    }

    public RichInputText getPrice() {
        return price;
    }

    public void setLineAmount(RichInputText lineAmount) {
        this.lineAmount = lineAmount;
    }

    public RichInputText getLineAmount() {
        return lineAmount;
    }


    /**@@ Original Qty Calculation @@**/

    public void onChangeQTY(ValueChangeEvent valueChangeEvent) {

        if (valueChangeEvent.getNewValue() != null) {

            if (valueChangeEvent.getNewValue() != null &&
                price.getValue() != null) {

                // Table amount=Qty*Prz;
                BigDecimal amount =
                    ADFMathUtils.multiplyVCLAndBinding(valueChangeEvent,
                                                       price);
                contractLineRow.setAttribute("OrigAmount", amount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(ecpTotalAmount);
                contractLineRow.setAttribute("EcpTotalAmount", amount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(lineAmount);
                // set Provisional Sum
                if (provisionalSum.getValue() != null) {
                    // Header TotalContractSum; tcs=contractAmount+provisionalSum;
                    BigDecimal tcs =
                        ADFMathUtils.add2AttributeInDoubleVO(contractVO,
                                                             "ContractAmount",
                                                             "ProvisionalSum");
                    contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                            tcs);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
                } else {
                    double contractAmount =
                        contractVO.getCurrentRow().getAttribute("ContractAmount") ==
                        null ? 0 :
                        Double.parseDouble(contractVO.getCurrentRow().getAttribute("ContractAmount").toString());
                    contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                            new BigDecimal(contractAmount));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
                }

            }
        } else {

            // Table amount=Qty*Prz;
            BigDecimal amount =
                ADFMathUtils.multiplyVCLAndBinding(valueChangeEvent, price);
            if (amount.equals(0)) {
                contractLineRow.setAttribute("EcpTotalAmount", "");
                AdfFacesContext.getCurrentInstance().addPartialTarget(ecpTotalAmount);
                contractLineRow.setAttribute("OrigAmount", "");
                AdfFacesContext.getCurrentInstance().addPartialTarget(lineAmount);
            } else {
                contractLineRow.setAttribute("EcpTotalAmount", amount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(ecpTotalAmount);
                contractLineRow.setAttribute("OrigAmount", amount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(lineAmount);
            }

            // Provisional Sum Calculation
            if (provisionalSum.getValue() != null) {
                // Header TotalContractSum; tcs=contractAmount+provisionalSum;
                BigDecimal tcs =
                    ADFMathUtils.add2AttributeInDoubleVO(contractVO,
                                                         "ContractAmount",
                                                         "ProvisionalSum");
                contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                        tcs);
                AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
            } else {
                double contractAmount =
                    contractVO.getCurrentRow().getAttribute("ContractAmount") ==
                    null ? 0 :
                    Float.parseFloat(contractVO.getCurrentRow().getAttribute("ContractAmount").toString());
                contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                        new BigDecimal(contractAmount));
                AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
            }

        }
    }

    /**@@ Original Price Calculation @@**/

    public void onChangePrice(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != null) {
            if (valueChangeEvent.getNewValue() != null &&
                qty.getValue() != null) {
                // Table amount=Qty*Prz;
                BigDecimal amount =
                    ADFMathUtils.multiplyVCLAndBinding(valueChangeEvent, qty);

                contractLineRow.setAttribute("EcpTotalAmount", amount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(ecpTotalAmount);
                contractLineRow.setAttribute("OrigAmount", amount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(lineAmount);
                // Provisional Sum Calculation
                if (provisionalSum.getValue() != null) {
                    // Header TotalContractSum; tcs=contractAmount+provisionalSum;
                    BigDecimal tcs =
                        ADFMathUtils.add2AttributeInDoubleVO(contractVO,
                                                             "ContractAmount",
                                                             "ProvisionalSum");
                    contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                            tcs);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
                } else {
                    double contractAmount =
                        contractVO.getCurrentRow().getAttribute("ContractAmount") ==
                        null ? 0 :
                        Float.parseFloat(contractVO.getCurrentRow().getAttribute("ContractAmount").toString());
                    contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                            new BigDecimal(contractAmount));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
                }
            }
        } else {
            // Table amount=Qty*Prz;
            BigDecimal amount =
                ADFMathUtils.multiplyVCLAndBinding(valueChangeEvent, qty);
            if (amount.equals(0)) {
                contractLineRow.setAttribute("EcpTotalAmount", "");
                AdfFacesContext.getCurrentInstance().addPartialTarget(ecpTotalAmount);
                contractLineRow.setAttribute("OrigAmount", "");
                AdfFacesContext.getCurrentInstance().addPartialTarget(lineAmount);
            } else {
                contractLineRow.setAttribute("EcpTotalAmount", amount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(ecpTotalAmount);
                contractLineRow.setAttribute("OrigAmount", amount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(lineAmount);
            }
            // Provisional Sum Calculation
            if (provisionalSum.getValue() != null) {
                // Header TotalContractSum; tcs=contractAmount+provisionalSum;
                BigDecimal tcs =
                    ADFMathUtils.add2AttributeInDoubleVO(contractVO,
                                                         "ContractAmount",
                                                         "ProvisionalSum");
                contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                        tcs);
                AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
            } else {
                double contractAmount =
                    contractVO.getCurrentRow().getAttribute("ContractAmount") ==
                    null ? 0 :
                    Float.parseFloat(contractVO.getCurrentRow().getAttribute("ContractAmount").toString());
                contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                        new BigDecimal(contractAmount));
                AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
            }
        }
    }


    public void setRevQty(RichInputText revQty) {
        this.revQty = revQty;
    }

    public RichInputText getRevQty() {
        return revQty;
    }

    public void setRevPrice(RichInputText revPrice) {
        this.revPrice = revPrice;
    }

    public RichInputText getRevPrice() {
        return revPrice;
    }

    public void setRevLineAmount(RichInputText revLineAmount) {
        this.revLineAmount = revLineAmount;
    }

    public RichInputText getRevLineAmount() {
        return revLineAmount;
    }

    public void setRevLineAmount1(RichInputText revLineAmount1) {
        this.revLineAmount1 = revLineAmount1;
    }

    public RichInputText getRevLineAmount1() {
        return revLineAmount1;
    }

    public void setContractVO(ViewObject contractVO) {
        this.contractVO = contractVO;
    }

    public ViewObject getContractVO() {
        return contractVO;
    }

    public void setContractRow(Row contractRow) {
        this.contractRow = contractRow;
    }

    public Row getContractRow() {
        return contractRow;
    }

    public void setContractLineVO(ViewObject contractLineVO) {
        this.contractLineVO = contractLineVO;
    }

    public ViewObject getContractLineVO() {
        return contractLineVO;
    }

    public void setContractLineRow(Row contractLineRow) {
        this.contractLineRow = contractLineRow;
    }

    public Row getContractLineRow() {
        return contractLineRow;
    }


    public void setVarPrice(RichInputText varPrice) {
        this.varPrice = varPrice;
    }

    public RichInputText getVarPrice() {
        return varPrice;
    }

    public void setVarAmount(RichInputText varAmount) {
        this.varAmount = varAmount;
    }

    public RichInputText getVarAmount() {
        return varAmount;
    }

    public void setVarQty(RichInputText varQty) {
        this.varQty = varQty;
    }

    public RichInputText getVarQty() {
        return varQty;
    }


    /**@@ Revised Qty Calculation @@**/

    public void onChangeRevQty(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != null) {
            if (valueChangeEvent.getNewValue() != null &&
                revPrice.getValue() != null) {
                // Revised Table amount=Qty*Prz;
                BigDecimal revAmount =
                    ADFMathUtils.multiplyVCLAndBinding(valueChangeEvent,
                                                       revPrice);
                contractLineRow.setAttribute("RevAmount", revAmount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(revLineAmount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(revLineAmount1);

                // Setting Contract Line--Varation field
                //varQ=(VCL)revQty-OrgQty
                BigDecimal varQ =
                    ADFMathUtils.subtractVCLAndVOAttribute(valueChangeEvent,
                                                           "OrigQuantity",
                                                           contractLineVO);
                contractLineRow.setAttribute("VarQuantity", varQ);
                AdfFacesContext.getCurrentInstance().addPartialTarget(varQty);
                // varP=(Binding)revPrice-OrgPrz
                BigDecimal varP =
                    ADFMathUtils.subtractInputBindingAndVOAttribute(revPrice,
                                                                    "OrigUnitPrice",
                                                                    contractLineVO);
                contractLineRow.setAttribute("VarUnitPrice", varP);
                AdfFacesContext.getCurrentInstance().addPartialTarget(varPrice);
                // varA=revAmot-Orgamt
                BigDecimal varA =
                    ADFMathUtils.subtractBigDecimalAttribute(revAmount,
                                                             "OrigAmount",
                                                             contractLineVO);
                contractLineRow.setAttribute("VarAmount", varA);
                AdfFacesContext.getCurrentInstance().addPartialTarget(varAmount);

                // Iterator Contract Line--Varation Amount
                RowSetIterator rs = contractLineVO.createRowSetIterator(null);
                double totalVariationLineAmount = 0;
                while (rs.hasNext()) {
                    contractLineRow = rs.next();
                    double varLineAmount =
                        contractLineRow.getAttribute("VarAmount") == null ? 0 :
                        Double.parseDouble(contractLineRow.getAttribute("VarAmount").toString());
                    totalVariationLineAmount += varLineAmount;
                    //System.err.println("-Total Variation Amount-" +
//                                       totalVariationLineAmount);
                }
                // set header Variation Amount
                contractVO.getCurrentRow().setAttribute("VariationAmount",
                                                        new BigDecimal(totalVariationLineAmount));
                AdfFacesContext.getCurrentInstance().addPartialTarget(contVariationAmount);


                // Iterator Contract Line--Revised Amount
                RowSetIterator revRs =
                    contractLineVO.createRowSetIterator(null);
                double totalRevisedLineAmount = 0;
                double totOAmt = 0;
                double totRAmt = 0;
                while (revRs.hasNext()) {
                    contractLineRow = revRs.next();
                    double varRevisedAmount =
                        contractLineRow.getAttribute("RevAmount") == null ? 0 :
                        Double.parseDouble(contractLineRow.getAttribute("RevAmount").toString());
                    if (varRevisedAmount == 0) {
                        double oriAmt =
                            contractLineRow.getAttribute("OrigAmount") ==
                            null ? 0 :
                            Double.parseDouble(contractLineRow.getAttribute("OrigAmount").toString());
                        totOAmt = totOAmt + oriAmt;
                    } else {
                        double revAmt =
                            contractLineRow.getAttribute("RevAmount") == null ?
                            0 :
                            Double.parseDouble(contractLineRow.getAttribute("RevAmount").toString());
                        totRAmt = totRAmt + revAmt;
                    }
                    totalRevisedLineAmount = totOAmt + totRAmt;
                    //System.err.println("-Total Revised Amount-" +
//                                       totalRevisedLineAmount);
                }
                // set header Revised Amount
                contractVO.getCurrentRow().setAttribute("RevisedContractAmount",
                                                        new BigDecimal(totalRevisedLineAmount));
                AdfFacesContext.getCurrentInstance().addPartialTarget(contRevisedAmount);


                // Provisional Sum Calculation--setting Total contract sum
                if (provisionalSum != null) {
                    // Header TotalContractSum; tcs=Revised amount+provisionalSum
                    BigDecimal tcs =
                        ADFMathUtils.add2AttributeInDoubleVO(contractVO,
                                                             "RevisedContractAmount",
                                                             "ProvisionalSum");
                    contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                            tcs);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
                } else {
                    double revisedAmount =
                        contractVO.getCurrentRow().getAttribute("RevisedContractAmount") ==
                        null ? 0 :
                        Double.parseDouble(contractVO.getCurrentRow().getAttribute("RevisedContractAmount").toString());
                    contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                            new BigDecimal(revisedAmount));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
                }
            }
        } else {

            // Calculating Contract Line--Revised Qty , Price and Amount
            // Revised Table amount=Qty*Prz;
            BigDecimal revAmount =
                ADFMathUtils.multiplyVCLAndBinding(valueChangeEvent, revPrice);

            if (revAmount.equals(0)) {
                contractLineRow.setAttribute("RevAmount", "");
                AdfFacesContext.getCurrentInstance().addPartialTarget(revLineAmount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(revLineAmount1);
                contractLineRow.setAttribute("VarQuantity", "");
                AdfFacesContext.getCurrentInstance().addPartialTarget(varQty);
                contractLineRow.setAttribute("VarUnitPrice", "");
                AdfFacesContext.getCurrentInstance().addPartialTarget(varPrice);
                contractLineRow.setAttribute("VarAmount", "");
                AdfFacesContext.getCurrentInstance().addPartialTarget(varAmount);
            } else {
                // Setting Contract Line--Varation field

                //varQ=(VCL)revQty-OrgQty
                BigDecimal varQ =
                    ADFMathUtils.subtractVCLAndVOAttribute(valueChangeEvent,
                                                           "OrigQuantity",
                                                           contractLineVO);
                // varP=(Binding)revPrice-OrgPrz
                BigDecimal varP =
                    ADFMathUtils.subtractInputBindingAndVOAttribute(revPrice,
                                                                    "OrigUnitPrice",
                                                                    contractLineVO);
                // varA=revAmot-Orgamt
                BigDecimal varA =
                    ADFMathUtils.subtractBigDecimalAttribute(revAmount,
                                                             "OrigAmount",
                                                             contractLineVO);
                contractLineRow.setAttribute("RevAmount", revAmount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(revLineAmount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(revLineAmount1);
                contractLineRow.setAttribute("VarQuantity", varQ);
                AdfFacesContext.getCurrentInstance().addPartialTarget(varQty);
                contractLineRow.setAttribute("VarUnitPrice", varP);
                AdfFacesContext.getCurrentInstance().addPartialTarget(varPrice);
                contractLineRow.setAttribute("VarAmount", varA);
                AdfFacesContext.getCurrentInstance().addPartialTarget(varAmount);
            }

            // Iterator Contract Line--Varation Amount
            RowSetIterator rs = contractLineVO.createRowSetIterator(null);
            double totalVariationLineAmount = 0;
            while (rs.hasNext()) {
                contractLineRow = rs.next();
                double varLineAmount =
                    contractLineRow.getAttribute("VarAmount") == null ? 0 :
                    Double.parseDouble(contractLineRow.getAttribute("VarAmount").toString());
                totalVariationLineAmount += varLineAmount;
                //System.err.println("-Total Variation Amount-" +
//                                   totalVariationLineAmount);
            }
            // set header Variation Amount
            contractVO.getCurrentRow().setAttribute("VariationAmount",
                                                    new BigDecimal(totalVariationLineAmount));
            AdfFacesContext.getCurrentInstance().addPartialTarget(contVariationAmount);


            // Iterator Contract Line--Revised Amount
            RowSetIterator revRs = contractLineVO.createRowSetIterator(null);
            double totalRevisedLineAmount = 0;
            double totOAmt = 0;
            double totRAmt = 0;
            while (revRs.hasNext()) {
                contractLineRow = revRs.next();
                double varRevisedAmount =
                    contractLineRow.getAttribute("RevAmount") == null ? 0 :
                    Double.parseDouble(contractLineRow.getAttribute("RevAmount").toString());
                if (varRevisedAmount == 0) {
                    double oriAmt =
                        contractLineRow.getAttribute("OrigAmount") == null ?
                        0 :
                        Double.parseDouble(contractLineRow.getAttribute("OrigAmount").toString());
                    totOAmt = totOAmt + oriAmt;
                } else {
                    double revAmt =
                        contractLineRow.getAttribute("RevAmount") == null ? 0 :
                        Double.parseDouble(contractLineRow.getAttribute("RevAmount").toString());
                    totRAmt = totRAmt + revAmt;
                }
                totalRevisedLineAmount = totOAmt + totRAmt;
                //System.err.println("-Total Revised Amount-" +
//                                   totalRevisedLineAmount);
            }
            // set header Revised Amount
            contractVO.getCurrentRow().setAttribute("RevisedContractAmount",
                                                    new BigDecimal(totalRevisedLineAmount));
            AdfFacesContext.getCurrentInstance().addPartialTarget(contRevisedAmount);


            // Provisional Sum Calculation--setting Total contract sum
            if (provisionalSum != null) {
                // Header TotalContractSum; tcs=Revised amount+provisionalSum
                BigDecimal tcs =
                    ADFMathUtils.add2AttributeInDoubleVO(contractVO,
                                                         "RevisedContractAmount",
                                                         "ProvisionalSum");
                contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                        tcs);
                AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
            } else {
                double revisedAmount =
                    contractVO.getCurrentRow().getAttribute("RevisedContractAmount") ==
                    null ? 0 :
                    Double.parseDouble(contractVO.getCurrentRow().getAttribute("RevisedContractAmount").toString());
                contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                        new BigDecimal(revisedAmount));
                AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
            }

        }
    }

    /**@@ Revised Price Calculation @@**/

    public void onChangeRevPrice(ValueChangeEvent valueChangeEvent) {

        if (valueChangeEvent.getNewValue() != null) {

            if (valueChangeEvent.getNewValue() != null &&
                revQty.getValue() != null) {
                // Calculating Contract Line--Revised Qty , Price and Amount
                // Revised Table amount=Qty*Prz;
                BigDecimal revAmount =
                    ADFMathUtils.multiplyVCLAndBinding(valueChangeEvent,
                                                       revQty);
                contractLineRow.setAttribute("RevAmount", revAmount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(revLineAmount);

                // Setting Contract Line--Varation field
                //varQ=(Binding)revQty-OrgQty
                BigDecimal varQ =
                    ADFMathUtils.subtractInputBindingAndVOAttribute(revQty,
                                                                    "OrigQuantity",
                                                                    contractLineVO);
                contractLineRow.setAttribute("VarQuantity", varQ);
                AdfFacesContext.getCurrentInstance().addPartialTarget(varQty);
                // varP=(VCL)revPrice-OrgPrz
                BigDecimal varP =
                    ADFMathUtils.subtractVCLAndVOAttribute(valueChangeEvent,
                                                           "OrigUnitPrice",
                                                           contractLineVO);
                contractLineRow.setAttribute("VarUnitPrice", varP);
                AdfFacesContext.getCurrentInstance().addPartialTarget(varPrice);
                // varA=revAmot-Orgamt
                BigDecimal varA =
                    ADFMathUtils.subtractBigDecimalAttribute(revAmount,
                                                             "OrigAmount",
                                                             contractLineVO);
                contractLineRow.setAttribute("VarAmount", varA);
                AdfFacesContext.getCurrentInstance().addPartialTarget(varAmount);

                // Iterator Contract Line--Varation Amount
                RowSetIterator rs = contractLineVO.createRowSetIterator(null);
                double totalVariationLineAmount = 0;
                while (rs.hasNext()) {
                    contractLineRow = rs.next();
                    double varLineAmount =
                        contractLineRow.getAttribute("VarAmount") == null ? 0 :
                        Double.parseDouble(contractLineRow.getAttribute("VarAmount").toString());
                    totalVariationLineAmount += varLineAmount;
                    //System.err.println("-Total Variation Amount-" +
//                                       totalVariationLineAmount);
                }
                // set header Variation Amount
                contractVO.getCurrentRow().setAttribute("VariationAmount",
                                                        new BigDecimal(totalVariationLineAmount));
                AdfFacesContext.getCurrentInstance().addPartialTarget(contVariationAmount);

                // Iterator Contract Line--Revised Amount
                RowSetIterator revRs =
                    contractLineVO.createRowSetIterator(null);
                double totalRevisedLineAmount = 0;
                double totOAmt = 0;
                double totRAmt = 0;
                while (revRs.hasNext()) {
                    contractLineRow = revRs.next();
                    double varRevisedAmount =
                        contractLineRow.getAttribute("RevAmount") == null ? 0 :
                        Double.parseDouble(contractLineRow.getAttribute("RevAmount").toString());
                    if (varRevisedAmount == 0) {
                        double oriAmt =
                            contractLineRow.getAttribute("OrigAmount") ==
                            null ? 0 :
                            Double.parseDouble(contractLineRow.getAttribute("OrigAmount").toString());
                        totOAmt = totOAmt + oriAmt;
                    } else {
                        double revAmt =
                            contractLineRow.getAttribute("RevAmount") == null ?
                            0 :
                            Double.parseDouble(contractLineRow.getAttribute("RevAmount").toString());
                        totRAmt = totRAmt + revAmt;
                    }
                    totalRevisedLineAmount = totOAmt + totRAmt;
                    //System.err.println("-Total Revised Amount-" +
//                                       totalRevisedLineAmount);
                }
                // set header Revised Amount
                contractVO.getCurrentRow().setAttribute("RevisedContractAmount",
                                                        new BigDecimal(totalRevisedLineAmount));
                AdfFacesContext.getCurrentInstance().addPartialTarget(contRevisedAmount);


                // Provisional Sum Calculation--setting Total contract sum
                if (provisionalSum != null) {
                    // Header TotalContractSum; tcs=Revised amount+provisionalSum
                    BigDecimal tcs =
                        ADFMathUtils.add2AttributeInDoubleVO(contractVO,
                                                             "RevisedContractAmount",
                                                             "ProvisionalSum");
                    contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                            tcs);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
                }

            }
        } else {
            //Getting Contract Line==Original Qty , Price  and Amount
            // Revised Table amount=Qty*Prz;
            BigDecimal revAmount =
                ADFMathUtils.multiplyVCLAndBinding(valueChangeEvent, revQty);
            if (revAmount.equals(0)) {
                contractLineRow.setAttribute("RevAmount", "");
                AdfFacesContext.getCurrentInstance().addPartialTarget(revLineAmount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(revLineAmount1);
                contractLineRow.setAttribute("VarQuantity", "");
                AdfFacesContext.getCurrentInstance().addPartialTarget(varQty);
                contractLineRow.setAttribute("VarUnitPrice", "");
                AdfFacesContext.getCurrentInstance().addPartialTarget(varPrice);
                contractLineRow.setAttribute("VarAmount", "");
                AdfFacesContext.getCurrentInstance().addPartialTarget(varAmount);
            } else {
                // Setting Contract Line--Varation field
                //varQ=(Binding)revQty-OrgQty
                BigDecimal varQ =
                    ADFMathUtils.subtractInputBindingAndVOAttribute(revQty,
                                                                    "OrigQuantity",
                                                                    contractLineVO);
                // varP=(VCL)revPrice-OrgPrz
                BigDecimal varP =
                    ADFMathUtils.subtractVCLAndVOAttribute(valueChangeEvent,
                                                           "OrigUnitPrice",
                                                           contractLineVO);
                // varA=revAmot-Orgamt
                BigDecimal varA =
                    ADFMathUtils.subtractBigDecimalAttribute(revAmount,
                                                             "OrigAmount",
                                                             contractLineVO);
                contractLineRow.setAttribute("RevAmount", revAmount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(revLineAmount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(revLineAmount1);
                contractLineRow.setAttribute("VarQuantity", varQ);
                AdfFacesContext.getCurrentInstance().addPartialTarget(varQty);
                contractLineRow.setAttribute("VarUnitPrice", varP);
                AdfFacesContext.getCurrentInstance().addPartialTarget(varPrice);
                contractLineRow.setAttribute("VarAmount", varA);
                AdfFacesContext.getCurrentInstance().addPartialTarget(varAmount);
            }


            // Iterator Contract Line--Varation Amount
            RowSetIterator rs = contractLineVO.createRowSetIterator(null);
            double totalVariationLineAmount = 0;
            while (rs.hasNext()) {
                contractLineRow = rs.next();
                double varLineAmount =
                    contractLineRow.getAttribute("VarAmount") == null ? 0 :
                    Double.parseDouble(contractLineRow.getAttribute("VarAmount").toString());
                totalVariationLineAmount += varLineAmount;
                //System.err.println("-Total Variation Amount-" +
//                                   totalVariationLineAmount);
            }
            // set header Variation Amount
            contractVO.getCurrentRow().setAttribute("VariationAmount",
                                                    new BigDecimal(totalVariationLineAmount));
            AdfFacesContext.getCurrentInstance().addPartialTarget(contVariationAmount);

            // Iterator Contract Line--Revised Amount
            RowSetIterator revRs = contractLineVO.createRowSetIterator(null);
            double totalRevisedLineAmount = 0;
            double totOAmt = 0;
            double totRAmt = 0;
            while (revRs.hasNext()) {
                contractLineRow = revRs.next();
                double varRevisedAmount =
                    contractLineRow.getAttribute("RevAmount") == null ? 0 :
                    Double.parseDouble(contractLineRow.getAttribute("RevAmount").toString());
                if (varRevisedAmount == 0) {
                    double oriAmt =
                        contractLineRow.getAttribute("OrigAmount") == null ?
                        0 :
                        Double.parseDouble(contractLineRow.getAttribute("OrigAmount").toString());
                    totOAmt = totOAmt + oriAmt;
                } else {
                    double revAmt =
                        contractLineRow.getAttribute("RevAmount") == null ? 0 :
                        Double.parseDouble(contractLineRow.getAttribute("RevAmount").toString());
                    totRAmt = totRAmt + revAmt;
                }
                totalRevisedLineAmount = totOAmt + totRAmt;
                //System.err.println("-Total Revised Amount-" +
//                                   totalRevisedLineAmount);
            }
            // set header Revised Amount
            contractVO.getCurrentRow().setAttribute("RevisedContractAmount",
                                                    new BigDecimal(totalRevisedLineAmount));
            AdfFacesContext.getCurrentInstance().addPartialTarget(contRevisedAmount);


            // Provisional Sum Calculation--setting Total contract sum
            if (provisionalSum != null) {
                // Header TotalContractSum; tcs=Revised amount+provisionalSum
                BigDecimal tcs =
                    ADFMathUtils.add2AttributeInDoubleVO(contractVO,
                                                         "RevisedContractAmount",
                                                         "ProvisionalSum");
                contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                        tcs);
                AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
            } else {
                double revisedAmount =
                    contractVO.getCurrentRow().getAttribute("RevisedContractAmount") ==
                    null ? 0 :
                    Float.parseFloat(contractVO.getCurrentRow().getAttribute("RevisedContractAmount").toString());
                contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                        new BigDecimal(revisedAmount));
                AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
            }

        }
    }


    public void setProvisionalSum(RichInputText provisionalSum) {
        this.provisionalSum = provisionalSum;
    }

    public RichInputText getProvisionalSum() {
        return provisionalSum;
    }

    public void onChangeProvisionSum(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != null) {
            if (contractAmount.getValue() == null) {
                if (contRevisedAmount.getValue() == null) {
                    contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                            valueChangeEvent.getNewValue());
                    AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
                } else {

                }

            } else if (contractAmount.getValue() != null) {
                if (contRevisedAmount.getValue() == null) {
                    //float contractAmount=contractVO.getCurrentRow().getAttribute("ContractAmount")==null?0:Float.parseFloat(contractVO.getCurrentRow().getAttribute("ContractAmount").toString());
                    //float provisionalSum=Float.parseFloat(valueChangeEvent.getNewValue().toString());
                    //float tcs=contractAmount+provisionalSum;
                    BigDecimal tcs =
                        ADFMathUtils.add2AttributeInDoubleVCL(contractVO,
                                                              "ContractAmount",
                                                              valueChangeEvent);
                    contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                            tcs);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
                } else if (contRevisedAmount.getValue() != null) {
                    //                        float revisedAmount=contractVO.getCurrentRow().getAttribute("RevisedContractAmount")==null?0:Float.parseFloat(contractVO.getCurrentRow().getAttribute("RevisedContractAmount").toString());
                    //                        float provisionalSum=Float.parseFloat(valueChangeEvent.getNewValue().toString());
                    //                        float tcs=revisedAmount+provisionalSum;
                    BigDecimal tcs =
                        ADFMathUtils.add2AttributeInDoubleVCL(contractVO,
                                                              "RevisedContractAmount",
                                                              valueChangeEvent);
                    contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                            tcs);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
                }
            }

        } else {

            if (contractAmount.getValue() == null) {
                if (contRevisedAmount.getValue() == null) {
                    contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                            valueChangeEvent.getNewValue());
                    AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
                } else {

                }

            } else if (contractAmount.getValue() != null) {
                if (contRevisedAmount.getValue() == null) {
                    //                        float contractAmount=contractVO.getCurrentRow().getAttribute("ContractAmount")==null?0:Float.parseFloat(contractVO.getCurrentRow().getAttribute("ContractAmount").toString());
                    //                        float provisionalSum=Float.parseFloat(valueChangeEvent.getNewValue().toString());
                    //                        float tcs=contractAmount+provisionalSum;
                    BigDecimal tcs =
                        ADFMathUtils.add2AttributeInDoubleVCL(contractVO,
                                                              "ContractAmount",
                                                              valueChangeEvent);
                    contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                            tcs);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
                } else if (contRevisedAmount.getValue() != null) {
                    //                        float revisedAmount=contractVO.getCurrentRow().getAttribute("RevisedContractAmount")==null?0:Float.parseFloat(contractVO.getCurrentRow().getAttribute("RevisedContractAmount").toString());
                    //                        float provisionalSum=Float.parseFloat(valueChangeEvent.getNewValue().toString());
                    //                        float tcs=revisedAmount+provisionalSum;
                    BigDecimal tcs =
                        ADFMathUtils.add2AttributeInDoubleVCL(contractVO,
                                                              "RevisedContractAmount",
                                                              valueChangeEvent);
                    contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                            tcs);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
                }
            }


        }
    }

    public void onChangePRNumber(ValueChangeEvent vce) {
        vce.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (vce.getNewValue() != null) {
            RowSetIterator oldcontractLineRs =
                contractLineVO.createRowSetIterator(null);
            while (oldcontractLineRs.hasNext()) {
                Row oldRow = oldcontractLineRs.next();
                oldRow.remove();
                //System.err.println("old Row removed");
            }

            String prHID =
                (String)(contractVO.getCurrentRow().getAttribute("ReqHeaderId") ==
                         null ? "" :
                         contractVO.getCurrentRow().getAttribute("ReqHeaderId").toString());
            String prNumber =
                (String)(contractVO.getCurrentRow().getAttribute("ReqNumber") ==
                         null ? "" :
                         contractVO.getCurrentRow().getAttribute("ReqNumber").toString());
            String proHID =
                (String)(contractVO.getCurrentRow().getAttribute("ProjectId") ==
                         null ? "" :
                         contractVO.getCurrentRow().getAttribute("ProjectId").toString());
            String proNumber =
                (String)(contractVO.getCurrentRow().getAttribute("ProjectNumber") ==
                         null ? "" :
                         contractVO.getCurrentRow().getAttribute("ProjectNumber").toString());
            //System.err.println("=------prHID---====" + prHID +
//                               "---prNumber---" + prNumber +
//                               "------proHID------" + proHID +
//                               "--proNumber-----" + proNumber);
            // filtering PR
            ViewCriteria prVC = prVO.createViewCriteria();
            ViewCriteriaRow prVCRow = prVC.createViewCriteriaRow();
            prVCRow.setAttribute("RequisitionHeaderId", prHID);
            prVC.addRow(prVCRow);
            prVO.applyViewCriteria(prVC);
            prVO.executeQuery();
            //System.err.println("==COUNT==" + prVO.getEstimatedRowCount());
            //insert
            RowSetIterator PRrs = prVO.createRowSetIterator(null);
            while (PRrs.hasNext()) {
                Row prLineRow = PRrs.next();
                Object prID = prLineRow.getAttribute("RequisitionHeaderId");
                Object prLineID = prLineRow.getAttribute("RequisitionLineId");
                Object prLineNumber = prLineRow.getAttribute("LineNumber");
                Object prItemNumber = prLineRow.getAttribute("ItemNumber");
                Object prItemDesc = prLineRow.getAttribute("ItemDescription");
                Object prUOM = prLineRow.getAttribute("UnitOfMeasure");
                Object prQty = prLineRow.getAttribute("Quantity");
                Object prPrz = prLineRow.getAttribute("UnitPrice");
                Object taskID = prLineRow.getAttribute("TaskId");
                Object taskNumber = prLineRow.getAttribute("TaskNumber");
                Object cateID = prLineRow.getAttribute("CategoryId");
                Object noteToBuyer = prLineRow.getAttribute("NoteToBuyer");
                Object noteToSupli = prLineRow.getAttribute("NoteToSupplier");
                Object needBYDate = prLineRow.getAttribute("NeedByDate");
                Object itemID = prLineRow.getAttribute("ItemId");

                //System.err.println("--1--" + prID + "-2-----" + prLineID +
//                                   "-3---" + prLineNumber + "-4-----" +
//                                   prItemNumber + "-5-----" + prItemDesc +
//                                   "-6---" + prUOM + "-7-----" + prQty +
//                                   "-8---" + prPrz + "-9---" + taskID +
//                                   "10---" + taskNumber);
                //System.err.println("-11-" + cateID + "-12-" + noteToBuyer +
//                                   "-13-" + noteToSupli + "--" + needBYDate);
                Row contractLineRow = contractLineVO.createRow();
                contractLineRow.setAttribute("ProjectId", proHID);
                contractLineRow.setAttribute("ProjectNumber", proNumber);
                contractLineRow.setAttribute("TaskId", taskID);
                contractLineRow.setAttribute("TaskNumber", taskNumber);
                contractLineRow.setAttribute("ReqHdrId", prHID);
                contractLineRow.setAttribute("ReqNumber", prNumber);
                contractLineRow.setAttribute("ReqLineId", prLineID);
                contractLineRow.setAttribute("ReqLineNumber", prLineNumber);
                contractLineRow.setAttribute("ItemId", itemID);
                contractLineRow.setAttribute("CategoryId", cateID);
                contractLineRow.setAttribute("NoteToBuyer", noteToBuyer);
                contractLineRow.setAttribute("NoteToSupplier", noteToSupli);
                contractLineRow.setAttribute("NeedByDate", needBYDate);
                contractLineRow.setAttribute("ItemNumber", prItemNumber);
                contractLineRow.setAttribute("ItemDescription", prItemDesc);
                contractLineRow.setAttribute("Uom", prUOM);
                contractLineRow.setAttribute("OrigQuantity", prQty);
                contractLineRow.setAttribute("OrigUnitPrice", prPrz);
                double para1 =
                    prLineRow.getAttribute("Quantity") == null ? 0 : Double.parseDouble(prLineRow.getAttribute("Quantity").toString());
                double para2 =
                    prLineRow.getAttribute("UnitPrice") == null ? 0 :
                    Double.parseDouble(prLineRow.getAttribute("UnitPrice").toString());
                double OAMT = para1 * para2;
                contractLineRow.setAttribute("OrigAmount",
                                             new BigDecimal(OAMT));
                contractLineVO.insertRow(contractLineRow);
                contractLineVO.executeQuery();
                //System.err.println("---Contract Line Inserted--");

                // Iterator Contract Line Amount
                //                RowSetIterator CArs =
                //                    contractLineVO.createRowSetIterator(null);
                //                float totalLineAmount = 0;
                //                double VariationLineAmt = 0;
                //                while (CArs.hasNext()) {
                //                    contractLineRow = CArs.next();
                //                    double orgLineAmount =
                //                        contractLineRow.getAttribute("OrigAmount") == null ?
                //                        0 :
                //                        Double.parseDouble(contractLineRow.getAttribute("OrigAmount").toString());
                //                    double VariationAmt =
                //                        contractLineRow.getAttribute("OrigAmount") == null ?
                //                        0 :
                //                        Double.parseDouble(contractLineRow.getAttribute("OrigAmount").toString());
                //                    String Variation =
                //                        contractLineRow.getAttribute("Variation").toString();
                //                    //System.err.println("Variation==>" + Variation);
                //                    if (Variation.equalsIgnoreCase("VAR_ORG")) {
                //                        totalLineAmount += orgLineAmount;
                //                        //System.err.println("==totalLineAmount==" +
                //                                           totalLineAmount);
                //                    } else if (!(Variation.equalsIgnoreCase("VAR_UNAPP"))) {
                //                        VariationLineAmt += VariationAmt;
                //                        //System.err.println("==VariationLineAmount==" +
                //                                           VariationLineAmt);
                //                    }
                //                }
                //                contractVO.getCurrentRow().setAttribute("ContractAmount",
                //                                                        new BigDecimal(totalLineAmount));
                //                AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
                //
                //                contractVO.getCurrentRow().setAttribute("VariationAmount",
                //                                                        new BigDecimal(VariationLineAmt));
                //                AdfFacesContext.getCurrentInstance().addPartialTarget(var_amt);
                //                contractVO.getCurrentRow().setAttribute("TotalContractSum",
                //                                                        new BigDecimal(totalLineAmount));
                //                 contractVO.executeQuery();

            }
        } else {

        }
    }


    public void setVendorName_Trans(RichInputListOfValues vendorName_Trans) {
        this.vendorName_Trans = vendorName_Trans;
    }

    public RichInputListOfValues getVendorName_Trans() {
        return vendorName_Trans;
    }

    public void onChangeSupplierType(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        vendorName_Trans.setValue(null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(vendorName_Trans);
    }

    ExcelDataUpload upload = new ExcelDataUpload();

    public void onChangeUpload(ValueChangeEvent valueChangeEvent) throws IOException,
                                                                         InvalidFormatException,
                                                                         ParseException {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        //System.err.println("==onChangeUpload==");
        // delete old record
        //deleteOldContractLine();
        UploadedFile file = (UploadedFile)valueChangeEvent.getNewValue();
        Object contractHrdId =
            contractVO.getCurrentRow().getAttribute("ContHeaderId") == null ?
            0 :
            contractVO.getCurrentRow().getAttribute("ContHeaderId").toString();
        String excelStatus = "N";
        if (file.getContentType().equalsIgnoreCase("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") ||
            file.getContentType().equalsIgnoreCase("application/xlsx") ||
            file.getContentType().equalsIgnoreCase("application/kset")) {
            //System.err.println("Inside XLSX loop");
            // Upload Excel
            excelStatus =
                    upload.readExcelSellSheet(file.getInputStream(), contractLineTable,
                                              contractHrdId);
            AdfFacesContext.getCurrentInstance().addPartialTarget(contractLineTable);
            if (excelStatus.equalsIgnoreCase("Y")) {
                if1.setValue(null);
                // Iterating contract Amount
                //                RowSetIterator rs = contractLineVO.createRowSetIterator(null);
                //                double totalLineAmount = 0;
                //                double totalECPAmount = 0;
                //                double VariationLineAmt = 0;
                //                while (rs.hasNext()) {
                //                    contractLineRow = rs.next();
                //                    double orgLineAmount =
                //                        contractLineRow.getAttribute("EcpTotalAmount") ==
                //                        null ? 0 :
                //                        Double.parseDouble(contractLineRow.getAttribute("EcpTotalAmount").toString());
                //                    double VariationAmt =
                //                        contractLineRow.getAttribute("OrigAmount") == null ?
                //                        0 :
                //                        Double.parseDouble(contractLineRow.getAttribute("OrigAmount").toString());
                //                    String Variation =
                //                        contractLineRow.getAttribute("Variation").toString();
                //                    //System.err.println("Variation==>" + Variation);
                //                    if (Variation.equalsIgnoreCase("VAR_ORG")) {
                //                        totalLineAmount += orgLineAmount;
                //                        //System.err.println("==totalLineAmount==" +
                //                                           totalLineAmount);
                //                    } else if (!(Variation.equalsIgnoreCase("VAR_UNAPP"))) {
                //                        VariationLineAmt += VariationAmt;
                //                        //System.err.println("==VariationLineAmount==" +
                //                                           VariationLineAmt);
                //                    }
                //                    double orgEcpAmount =
                //                        contractLineRow.getAttribute("OrigAmount") == null ?
                //                        0 :
                //                        Double.parseDouble(contractLineRow.getAttribute("OrigAmount").toString());
                //                    totalECPAmount += orgEcpAmount;
                //                    //System.err.println("==totalECPAmount set in ContractAmount==" +
                //                                       totalECPAmount);
                //                }
                //                contractVO.getCurrentRow().setAttribute("ContractAmount",
                //                                                        new BigDecimal(totalLineAmount));
                //                AdfFacesContext.getCurrentInstance().addPartialTarget(contractAmount);
                //
                //                contractVO.getCurrentRow().setAttribute("VariationAmount",
                //                                                        new BigDecimal(VariationLineAmt));
                //                AdfFacesContext.getCurrentInstance().addPartialTarget(var_amt);
                //                contractVO.getCurrentRow().setAttribute("EcpTotalAmount",
                //                                                        new BigDecimal(totalECPAmount));
                //                AdfFacesContext.getCurrentInstance().addPartialTarget(ecpTotAmt);
                // Provisional Sum Calculation
                if (provisionalSum.getValue() != null) {
                    BigDecimal tcs =
                        ADFMathUtils.add2AttributeInDoubleVO(contractVO,
                                                             "ContractAmount",
                                                             "ProvisionalSum");
                    contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                            tcs);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
                } else {
                    double contractAmount =
                        contractVO.getCurrentRow().getAttribute("ContractAmount") ==
                        null ? 0 :
                        Float.parseFloat(contractVO.getCurrentRow().getAttribute("ContractAmount").toString());
                    contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                            new BigDecimal(contractAmount));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
                }
            } else {
                JSFUtils.addFacesErrorMessage("Please Check Excel Upload Fail.");
            }

        } else if (file.getContentType().equalsIgnoreCase("application/vnd.ms-excel")) {
            if (file.getFilename().toUpperCase().endsWith(".XLS")) {
                //System.err.println("==Calling MS-Excel==");
                // Upload Excel
                excelStatus =
                        upload.readExcelSellSheet(file.getInputStream(), contractLineTable,
                                                  contractHrdId);
                AdfFacesContext.getCurrentInstance().addPartialTarget(contractLineTable);
                if (excelStatus.equalsIgnoreCase("Y")) {
                    AdfFacesContext.getCurrentInstance().addPartialTarget(contractLineTable);
                    if1.setValue(null);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(if1);
                    // Iterating contract Amount
                    //                    RowSetIterator rs =
                    //                        contractLineVO.createRowSetIterator(null);
                    //                    double totalLineAmount = 0;
                    //                    double totalECPAmount = 0;
                    //                    double VariationLineAmt = 0;
                    //                    while (rs.hasNext()) {
                    //                        contractLineRow = rs.next();
                    //                        double orgLineAmount =
                    //                            contractLineRow.getAttribute("EcpTotalAmount") ==
                    //                            null ? 0 :
                    //                            Double.parseDouble(contractLineRow.getAttribute("EcpTotalAmount").toString());
                    //                        double VariationAmt =
                    //                            contractLineRow.getAttribute("OrigAmount") ==
                    //                            null ? 0 :
                    //                            Double.parseDouble(contractLineRow.getAttribute("OrigAmount").toString());
                    //                        String Variation =
                    //                            contractLineRow.getAttribute("Variation").toString();
                    //                        //System.err.println("Variation==>" + Variation);
                    //                        if (Variation.equalsIgnoreCase("VAR_ORG")) {
                    //                            totalLineAmount += orgLineAmount;
                    //                            //System.err.println("==totalLineAmount==" +
                    //                                               totalLineAmount);
                    //                        } else if (!(Variation.equalsIgnoreCase("VAR_UNAPP"))) {
                    //                            VariationLineAmt += VariationAmt;
                    //                            //System.err.println("==VariationLineAmount==" +
                    //                                               VariationLineAmt);
                    //                        }
                    //                        double orgEcpAmount =
                    //                            contractLineRow.getAttribute("OrigAmount") ==
                    //                            null ? 0 :
                    //                            Double.parseDouble(contractLineRow.getAttribute("OrigAmount").toString());
                    //                        totalECPAmount += orgEcpAmount;
                    //                        //System.err.println("==totalECPAmount set in ContractAmount==" +
                    //                                           totalECPAmount);
                    //                    }
                    //                    contractVO.getCurrentRow().setAttribute("ContractAmount",
                    //                                                            new BigDecimal(totalLineAmount));
                    //                    AdfFacesContext.getCurrentInstance().addPartialTarget(contractAmount);
                    //
                    //                    contractVO.getCurrentRow().setAttribute("VariationAmount",
                    //                                                            new BigDecimal(VariationLineAmt));
                    //                    AdfFacesContext.getCurrentInstance().addPartialTarget(var_amt);
                    //                    contractVO.getCurrentRow().setAttribute("EcpTotalAmount",
                    //                                                            new BigDecimal(totalECPAmount));
                    //                    AdfFacesContext.getCurrentInstance().addPartialTarget(ecpTotAmt);

                    // Provisional Sum Calculation
                    if (provisionalSum.getValue() != null) {
                        BigDecimal tcs =
                            ADFMathUtils.add2AttributeInDoubleVO(contractVO,
                                                                 "ContractAmount",
                                                                 "ProvisionalSum");
                        contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                                tcs);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
                    } else {
                        double contractAmount =
                            contractVO.getCurrentRow().getAttribute("ContractAmount") ==
                            null ? 0 :
                            Float.parseFloat(contractVO.getCurrentRow().getAttribute("ContractAmount").toString());
                        contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                                new BigDecimal(contractAmount));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(contTotalSum);
                    }
                } else {
                    JSFUtils.addFacesErrorMessage("Please Check Excel Upload Fail.");
                }

            }
        } else {
            //System.out.println("Inside else loop");
            JSFUtils.addFacesErrorMessage("File format not supported.-- Upload XLS or XLSX file");
        }
    }

    public void setContractLineTable(RichTable contractLineTable) {
        this.contractLineTable = contractLineTable;
    }

    public RichTable getContractLineTable() {
        return contractLineTable;
    }
    private Object[][] dobProcArgs = null;

    public void deleteOldDeliveryPlan() throws SQLException {
        String flag = "E"; // Error
        String errorMessage = null;
        ApplicationModuleImpl am =
            (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(null);
        oracle.jbo.domain.Number headerID =
            new oracle.jbo.domain.Number(contractVO.getCurrentRow().getAttribute("ContHeaderId").toString());
        oracle.jbo.domain.Number ver =
            new oracle.jbo.domain.Number(contractVO.getCurrentRow().getAttribute("Version").toString());
        dobProcArgs =
                new Object[][] { { "IN", headerID, OracleTypes.NUMBER }, //0
                    { "IN", ver, OracleTypes.NUMBER }, //1
                    { "OUT", flag, OracleTypes.VARCHAR }, //2
                    { "OUT", errorMessage, OracleTypes.VARCHAR } }; //3
        try {
            DBUtils.callDBStoredProcedure(am.getDBTransaction(),
                                          "call xxsc_contract_pkg.delete_delivery_plan(?,?,?,?)",
                                          dobProcArgs);
        } catch (SQLException e) {
            //System.err.println("===EXE in del pack call==" + e.toString());
        }
        flag = (String)dobProcArgs[2][1];
        errorMessage = (String)dobProcArgs[3][1];
    }

    public void createDeliveryPlan(long sno, double qty,
                                   long contLineId) throws SQLException {
        //System.err.println("===INSERT==" + sno + "==" + qty + "==" +
//                           contLineId);
        String flag = "E"; // Error
        String errorMessage = null;
        ApplicationModuleImpl am =
            (ApplicationModuleImpl)view.backing.ADFUtils.getApplicationModuleForDataControl(null);
        oracle.jbo.domain.Number lineID =
            new oracle.jbo.domain.Number(contLineId);
        oracle.jbo.domain.Number ver =
            new oracle.jbo.domain.Number(contractVO.getCurrentRow().getAttribute("Version").toString());
        oracle.jbo.domain.Number hdrId =
            new oracle.jbo.domain.Number(contractVO.getCurrentRow().getAttribute("ContHeaderId").toString());
        oracle.jbo.domain.Number sno_Obj = new oracle.jbo.domain.Number(sno);
        oracle.jbo.domain.Number qty_obj = new oracle.jbo.domain.Number(qty);
        Object p_st_dt = contractVO.getCurrentRow().getAttribute("StartDate");
        //        //System.err.println("===ST==1");
        //        java.sql.Date st_date =
        //            new java.sql.Date((Timestamp)((p_st_dt).getTime()));
        //        //System.err.println("===ST==2");
        Object p_end_dt = contractVO.getCurrentRow().getAttribute("EndDate");
        //        java.sql.Date end_date =
        //            new java.sql.Date(((Timestamp)p_end_dt).getTime());
        dobProcArgs = new Object[][] { { "IN", hdrId, OracleTypes.NUMBER }, //0
                    { "IN", lineID, OracleTypes.NUMBER }, //1
                    { "IN", ver, OracleTypes.NUMBER }, //2
                    { "IN", "C", OracleTypes.VARCHAR }, //3
                    { "IN", null, OracleTypes.NUMBER }, //4
                    { "IN", sno_Obj, OracleTypes.NUMBER }, //5
                    { "IN", qty_obj, OracleTypes.NUMBER }, //6
                    { "IN", null, OracleTypes.VARCHAR }, //7
                    { "IN", p_st_dt, OracleTypes.DATE }, //8
                    { "IN", p_end_dt, OracleTypes.DATE }, //9
                    { "OUT", flag, OracleTypes.VARCHAR }, //10
                    { "OUT", errorMessage, OracleTypes.VARCHAR } }; //11
        try {
            DBUtils.callDBStoredProcedure(am.getDBTransaction(),
                                          "call xxsc_contract_pkg.create_delivery_plan(?,?,?,?,?,?,?,?,?,?,?,?)",
                                          dobProcArgs);
        } catch (SQLException e) {
        }
        flag = (String)dobProcArgs[10][1];
        errorMessage = (String)dobProcArgs[11][1];
        //System.err.println("==del==del==" + flag + "==" + errorMessage);
    }

    public void onChangeUploadDeliveryPlan(ValueChangeEvent valueChangeEvent) throws IOException,
                                                                                     InvalidFormatException,
                                                                                     ParseException {
        org.apache.poi.ss.usermodel.Workbook workbook = null;
        List<Long> no = new ArrayList<Long>();
        List<Long> no1 = new ArrayList<Long>();

        double originalqty = 0;
        //        long lineNumber = 0;
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        //        //System.err.println("==Start Date==" +
        //                           contractVO.getCurrentRow().getAttribute("StartDate"));
        //        //System.err.println("==END Date==" +
        //                           contractVO.getCurrentRow().getAttribute("EndDate"));
        //        //System.err.println("==Contract NUM==" +
        //                           contractVO.getCurrentRow().getAttribute("ContractNum"));

        if (contractVO.getCurrentRow().getAttribute("ContractNum") != null &&
            contractVO.getCurrentRow().getAttribute("StartDate") != null &&
            contractVO.getCurrentRow().getAttribute("EndDate") != null) {

            UploadedFile file1 = (UploadedFile)valueChangeEvent.getNewValue();
            if (file1 != null) {
                int sheetIndex = 0;
                if (sheetIndex == 0) {
                    try {
                        workbook =
                                WorkbookFactory.create(file1.getInputStream());
                    } catch (Exception e) {
                        //System.err.println("Exception in Line Workbook : " +
//                                           e);
                    }
                    org.apache.poi.ss.usermodel.Sheet sheet =
                        workbook.getSheetAt(sheetIndex);
                    Integer skipRw = 1;
                    Integer skipcnt = 1;
                    int columnCount = 0;
                    Integer totalNumberofRows = 0;
                    //Iterate over excel rows
                    for (org.apache.poi.ss.usermodel.Row tempRow : sheet) {
                        double test = 0;
                        long lineNumber = 0;
                        double qty = 0;
                        totalNumberofRows =
                                sheet.getPhysicalNumberOfRows() - 1;
                        if (skipcnt == 1) {
                            columnCount = tempRow.getPhysicalNumberOfCells();
                        }
                        if (skipcnt >
                            skipRw) { //skip first row and start from 2 row .
                            //System.err.println("==val==");
                            //Create new row in table
                            int Index = 0; //Iterate over row's columns
                            for (int column = 0; column < columnCount;
                                 column++) {
                                Cell MytempCell = tempRow.getCell(column);
                                if (MytempCell != null) {
                                    Index = MytempCell.getColumnIndex();

                                } else {
                                    //Index++;
                                }
                                try {
                                    if (Index == 0) {
                                        if (MytempCell != null) {
                                            lineNumber =
                                                    (long)MytempCell.getNumericCellValue();
                                        } else {
                                            //System.err.println("col==" +
//                                                               column +
//                                                               "==is blank");
                                        }
                                    } else if (Index != 1 && Index != 2) {
                                        if (MytempCell != null) {
                                            qty =
(double)MytempCell.getNumericCellValue();
                                        } else {
                                            //System.err.println("col==" +
//                                                               column +
//                                                               "==is blank");
                                        }

                                        test += qty;
                                        // //System.err.println("==qyt===" + test);
                                        //                                        createDeliveryPlan(Index, qty,
                                        //                                                           findContLineId(lineNumber));

                                    }
                                } catch (Exception e) {
                                    //System.err.println("Exception in col " +
//                                                       column);
                                    e.printStackTrace();
                                }
                            } // one row completed
                            ViewObject conLine =
                                ADFUtils.findIterator("getContLineInfo1Iterator").getViewObject();
                            conLine.setNamedWhereClauseParam("cont_line_id",
                                                             lineNumber);
                            conLine.setNamedWhereClauseParam("hdr_id",
                                                             contractVO.getCurrentRow().getAttribute("ContHeaderId"));
                            conLine.setNamedWhereClauseParam("ver",
                                                             contractVO.getCurrentRow().getAttribute("Version"));
                            conLine.executeQuery();
                            //System.err.println("===EStimate row count ==" +
//                                               conLine.getEstimatedRowCount());

                            if (conLine.getEstimatedRowCount() == 0) {
                                no1.add(lineNumber);

                            } else {
                                originalqty =
                                        conLine.first().getAttribute("OrigQuantity") ==
                                        null ? 0 :
                                        Double.parseDouble(conLine.first().getAttribute("OrigQuantity").toString());
                                //System.err.println("===base table quantity===" +
//                                                   originalqty +
//                                                   "===total quantity==" +
//                                                   test);
                                if (test <= originalqty) {
                                    //no.add(lineNumber);
                                    //System.err.println("====Inside if==");
                                } else {
                                    //System.err.println("===test==" + test);
                                    no.add(lineNumber);
                                }
                            }
                        } ////skip first n row for labels.
                        if (totalNumberofRows >= skipcnt) {
                            skipcnt++;
                        }

                    }
                    //                    ViewObject conLine =
                    //                        ADFUtils.findIterator("getContLineInfo1Iterator").getViewObject();
                    //                    conLine.setNamedWhereClauseParam("cont_line_id",
                    //                                                     lineNumber);
                    //                    conLine.setNamedWhereClauseParam("hdr_id",
                    //                                                     contractVO.getCurrentRow().getAttribute("ContHeaderId"));
                    //                    conLine.setNamedWhereClauseParam("ver",
                    //                                                     contractVO.getCurrentRow().getAttribute("Version"));
                    //                    conLine.executeQuery();
                    //                    originalqty =
                    //                            Double.parseDouble(conLine.first().getAttribute("OrigQuantity").toString());
                    //                    //System.err.println("===base table quantity===" +originalqty);
                    //                    //System.err.println("===total quantity==" +test);
                    //                    if (test <= originalqty) {
                    //                        //no.add(lineNumber);
                    //                        //System.err.println("====Inside if==");
                    //                    } else {
                    //                        //System.err.println("===test==" +
                    //                                           test);
                    //                        no.add(lineNumber);
                    //                    }
                }
            }
            //System.err.println("==size==" + no.size());
            //            if (no.size() == 0 && no1.size() == 0) {
            try {
                deleteOldDeliveryPlan();
            } catch (SQLException e) {
                //System.err.println("====EX===in del==" + e.toString());
            }
            UploadedFile file = (UploadedFile)valueChangeEvent.getNewValue();
            if (file.getContentType().equalsIgnoreCase("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") ||
                file.getContentType().equalsIgnoreCase("application/xlsx") ||
                file.getContentType().equalsIgnoreCase("application/kset") ||
                file.getContentType().equalsIgnoreCase("application/vnd.ms-excel")) {
                //System.err.println("Inside XLSX loop");
                int sheetIndex = 0;
                if (sheetIndex == 0) {
                    try {
                        workbook =
                                WorkbookFactory.create(file.getInputStream());
                    } catch (Exception e) {
                        //System.err.println("Exception in Line Workbook : " +
//                                           e);
                    }
                    org.apache.poi.ss.usermodel.Sheet sheet =
                        workbook.getSheetAt(sheetIndex);
                    Integer skipRw = 1;
                    Integer skipcnt = 1;
                    int columnCount = 0;
                    Integer totalNumberofRows = 0;
                    //Iterate over excel rows
                    for (org.apache.poi.ss.usermodel.Row tempRow : sheet) {
                        long lineNumber = 0;
                        double qty = 0;
                        totalNumberofRows =
                                sheet.getPhysicalNumberOfRows() - 1;
                        //System.err.println("--Row for insert--" +
//                                           totalNumberofRows);
                        if (skipcnt == 1) {
                            columnCount = tempRow.getPhysicalNumberOfCells();
                        }
                        if (skipcnt >
                            skipRw) { //skip first row and start from 2 row .

                            //Create new row in table
                            int Index = 0; //Iterate over row's columns
                            for (int column = 0; column < columnCount;
                                 column++) {
                                Cell MytempCell = tempRow.getCell(column);
                                if (MytempCell != null) {
                                    Index = MytempCell.getColumnIndex();
                                } else {
                                    //Index++;
                                }
                                try {
                                    if (Index == 0) {
                                        if (MytempCell != null) {
                                            lineNumber =
                                                    (long)MytempCell.getNumericCellValue();
                                        } else {
                                            //System.err.println("col==" +
//                                                               column +
//                                                               "==is blank");
                                        }
                                    } else if (Index != 1 && Index != 2) {
                                        if (MytempCell != null) {
                                            qty =
(double)MytempCell.getNumericCellValue();
                                            Index = Index - 2;
                                        } else {
                                            //System.err.println("col==" +
//                                                               column +
//                                                               "==is blank");
                                        }
                                        createDeliveryPlan(Index, qty,
                                                           findContLineId(lineNumber));
                                    }
                                } catch (Exception e) {
                                    //System.err.println("Exception in col " +
//                                                       column);
                                    e.printStackTrace();
                                }

                            } // one row completed

                        } ////skip first n row for labels.
                        if (totalNumberofRows >= skipcnt) {
                            skipcnt++;
                        }

                    }
                }
                ADFUtils.findIterator("DeliveryPlanPivot_ROVO1Iterator").executeQuery();
                UIPivotTable p =
                    (UIPivotTable)JSFUtils.findComponentInRoot("pivotTable1");
                AdfFacesContext.getCurrentInstance().addPartialTarget(p);

            }
            //            }
            //            else {
            //                if (no1.size() > 0 && no.size() > 0) {
            //                    JSFUtils.addFacesInformationMessage("Quantity is not maching in the follwoing line number : " +
            //                                                        printList((ArrayList)no));
            //                    JSFUtils.addFacesInformationMessage("Line number is not found : " +
            //                                                        printList((ArrayList)no1));
            //                } else if (no1.size() > 0) {
            //                    JSFUtils.addFacesInformationMessage("Line number is not found : " +
            //                                                        printList((ArrayList)no1));
            //                } else if (no.size() > 0) {
            //                    JSFUtils.addFacesInformationMessage("Quantity is not maching in the follwoing line number : " +
            //                                                        printList((ArrayList)no));
            //                }
        }
        //
        //        } else if (contractVO.getCurrentRow().getAttribute("ContractNum") ==
        //                   null) {
        //            JSFUtils.addFacesInformationMessage("Contract Num is Should not be Null! ");
        //        } else if (contractVO.getCurrentRow().getAttribute("EndDate") ==
        //                   null) {
        //            JSFUtils.addFacesInformationMessage("End Date Should not be Null! ");
        //        } else if (contractVO.getCurrentRow().getAttribute("StartDate") ==
        //                   null) {
        //            JSFUtils.addFacesInformationMessage("Start Date Should not be Null! ");
        //        }

    }

    public String printList(ArrayList<Long> words) {
        String test = "";
        for (int i = 0; i < words.size(); i++) {
            test +=
                    (i == words.size() - 1) ? words.get(i).toString() + "." : words.get(i).toString() +
                    ",";
            //                if(i==words.size()-1)
            //                {
            //                    test+=words.get(i).toString()+".";
            //                }
            //                else{
            //                test+=words.get(i).toString()+",";
            //                }
        }
        return test;
    }

    public long findContLineId(long no) {
        long ret = 0;
        //System.err.println("==sno==" + no);
        ViewObject conLine =
            ADFUtils.findIterator("getContLineInfo1Iterator").getViewObject();
        conLine.setNamedWhereClauseParam("cont_line_id", no);

        conLine.setNamedWhereClauseParam("hdr_id",
                                         contractVO.getCurrentRow().getAttribute("ContHeaderId"));
        conLine.setNamedWhereClauseParam("ver",
                                         contractVO.getCurrentRow().getAttribute("Version"));
        conLine.executeQuery();
        //        //System.err.println("==con line id==" +
        //                           conLine.first().getAttribute("ContLineId"));
        //System.err.println("==con line id==" +
//                           conLine.first().getAttribute("ContLineId"));
        if (conLine.first() != null) {
            //            ret =
            //Long.parseLong(conLine.first().getAttribute("ContLineId").toString());
            ret =
Long.parseLong(conLine.first().getAttribute("ContLineId").toString());
        }
        return ret;
    }

    public String deleteOldContractLine() {
        String result = "N";
        //System.err.println("--Contract Row Count--" +
//                           contractLineVO.getEstimatedRowCount());
        if (contractLineVO.getEstimatedRowCount() != 0) {
            RowSetIterator rs = contractLineVO.createRowSetIterator(null);
            while (rs.hasNext()) {
                Row r = rs.next();
                r.remove();
                //System.err.println("--Line Removed--");
            }
            result = "Y";
        } else {
            result = "N";
        }

        return result;
    }

    DownlaodExcel de = new DownlaodExcel();

    public void fileDownload(FacesContext facesContext,
                             OutputStream outputStream) throws FileNotFoundException,
                                                               IOException {
        String cname =
            contractVO.getCurrentRow().getAttribute("ContractName") == null ?
            "LineDetail" :
            contractVO.getCurrentRow().getAttribute("ContractName").toString();
        File filed =
            new File(de.downlaodSellExcel(cname) + "/" + cname + ".xls");
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


    public void onClickSubmit(ActionEvent actionEvent) {

        if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
            if (ADFContext.getCurrent().getSessionScope().get("addEditContract") !=
                null &&
                ADFContext.getCurrent().getSessionScope().get("addEditContract").toString().equals("edit")) {
                if (contractRow.getAttribute("OrgId") == null) {
                    JSFUtils.addFacesErrorMessage("Please select Business Unit in Contract Information Page");
                } else {
                    if (contractRow.getAttribute("ReqNumber") == null) {
                        JSFUtils.addFacesErrorMessage("Please select Requisition Number in Contract Information Page");
                    } else {
                        if (contractRow.getAttribute("StartDate") == null) {
                            JSFUtils.addFacesErrorMessage("Please select  Start Date in Contract Information Page");
                        } else {
                            if (contractRow.getAttribute("EndDate") == null) {
                                JSFUtils.addFacesErrorMessage("Please select  End Date in Contract Information Page");
                            } else {
                                if (contractRow.getAttribute("BuyerId") ==
                                    null) {
                                    JSFUtils.addFacesErrorMessage("Please select  Buyer Name in Contract Information Page");
                                } else {
                                    if (contractRow.getAttribute("vendorName_Trans") ==
                                        null) {
                                        JSFUtils.addFacesErrorMessage("Please select Supplier Name in Party Information Page");
                                    } else {
                                        if (contractRow.getAttribute("VendorSiteId") ==
                                            null) {
                                            JSFUtils.addFacesErrorMessage("Please select Supplier Site Code in Party Information Page");
                                        } else {
                                            if (contractRow.getAttribute("PaymentTerm") ==
                                                null) {
                                                JSFUtils.addFacesErrorMessage("Please select Payment Term in Line Information Page");
                                            } else {
                                                contractRow.setAttribute("ApprovalStatus",
                                                                         "APR");
                                                ADFUtils.findOperation("Commit").execute();
                                                refreshSearchTable();
                                                JSFUtils.addFacesInformationMessage("Buy Contract Information Saved Successfully and Submit for Approval");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }

        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell")) {
            if (ADFContext.getCurrent().getSessionScope().get("addEditContract") !=
                null &&
                ADFContext.getCurrent().getSessionScope().get("addEditContract").toString().equals("edit")) {
                ADFUtils.findOperation("Commit").execute();
                refreshSearchTable();
                JSFUtils.addFacesInformationMessage("Sell Contract Information Saved Successfully");
            }
        } else {
            //System.err.println("Error need to check Buy or sell type");
        }


        /*
        //        generateMail("CONT-1001");
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
            contractRow.setAttribute("ContractNum", "CONT-" + contractRow.getAttribute("ContHeaderId"));
            contractRow.setAttribute("Intent", "B");
            contractRow.setAttribute("ContractStatus", "ACTIVE");
            contractRow.setAttribute("PoStatus", "READY_TO_PO");
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Buy Contract Information Saved Successfully");
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell")) {
            contractRow.setAttribute("ContractNum","CONT-" + contractRow.getAttribute("ContHeaderId"));
            contractRow.setAttribute("Intent", "S");
            contractRow.setAttribute("PoStatus", "READY_TO_PO");
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Sell Contract Information Saved Successfully");
        }
    */
    }


    public void generateMail(String docnumber) {
        /*
            String to= (String)MailServices.evaluateEL("#{pageFlowScope.pMessageTo}");
            //System.err.println("=====TO====="+to);
            String from = (String)MailServices.evaluateEL("#{pageFlowScope.pMessageFrom}");
            //System.err.println("=====From====="+from);
            String subject = (String)MailServices.evaluateEL("#{pageFlowScope.pMessageSubject}");
            //System.err.println("=====Subject====="+subject);
            //String body = (String)MailServices.evaluateEL("#{pageFlowScope.pMessageBody}");
            ////System.err.println("====body======"+body);
            String  convertHtmlBody= (String)MailServices.evaluateEL("#{pageFlowScope.pMessageBodyhtml}");
            String  htmlbody = MailServices.quotesReplace(convertHtmlBody);
            //System.err.println("====htmlbody======"+htmlbody);
            */
        String from = "dineshkumar.p@4iapps.com";
        String to = "balaji.swamynathan@4iapps.com";
        //String to= "suresh.k@4iapps.com";
        String subject = "Testing SubContract";

        String htmlbody = null;
//            MailTemplates.requestMailContent();

//        if (to != null && from != null) {
//            try {
////                MailServices.sendNotification(to, from, null, htmlbody,
////                                              subject);
//            } catch (MalformedURLException e) {
//            } catch (IOException e) {
//            }
//        }
    }
    DecimalFormat dfNum = new DecimalFormat(".##");

    /****caluclating the percentage**********/
    public void calcPerc(String val, String tot, String setAtt,
                         UIComponent id) {
        double liqP = Double.parseDouble(val);
        double totCon =
            contractVO.getCurrentRow().getAttribute(tot) == null ? 0 :
            Double.parseDouble(contractVO.getCurrentRow().getAttribute(tot).toString());
        double totAmt = (liqP * totCon) / 100;
        contractVO.getCurrentRow().setAttribute(setAtt,
                                                dfNum.format(new BigDecimal(totAmt)));
        AdfFacesContext.getCurrentInstance().addPartialTarget(id);
    }


    /*  public void liqVCL(ValueChangeEvent liqPerc) {
        float liqP = Float.parseFloat(liqPerc.getNewValue().toString());
        float totCon = contractVO.getCurrentRow().getAttribute("TotalContractSum")==null?0:Float.parseFloat(contractVO.getCurrentRow().getAttribute("TotalContractSum").toString());
        float totAmt = (liqP*totCon)/100;
        contractVO.getCurrentRow().setAttribute("LiqDamageAmount", totAmt);
        AdfFacesContext.getCurrentInstance().addPartialTarget(liqAmount);
    }*/


    public void setLiqAmount(RichInputText liqAmount) {
        this.liqAmount = liqAmount;
    }

    public RichInputText getLiqAmount() {
        return liqAmount;
    }

    public void setMatRec(RichInputText matRec) {
        this.matRec = matRec;
    }

    public RichInputText getMatRec() {
        return matRec;
    }

    public void setMat(RichInputText mat) {
        this.mat = mat;
    }

    public RichInputText getMat() {
        return mat;
    }

    public void setAdvRec(RichInputText advRec) {
        this.advRec = advRec;
    }

    public RichInputText getAdvRec() {
        return advRec;
    }

    public void setAdv(RichInputText adv) {
        this.adv = adv;
    }

    public RichInputText getAdv() {
        return adv;
    }

    public void setRetRel(RichInputText retRel) {
        this.retRel = retRel;
    }

    public RichInputText getRetRel() {
        return retRel;
    }

    public void setRet(RichInputText ret) {
        this.ret = ret;
    }

    public RichInputText getRet() {
        return ret;
    }

    public void setPen(RichInputText pen) {
        this.pen = pen;
    }

    public RichInputText getPen() {
        return pen;
    }

    public void onClickSaveContractInfo(ActionEvent actionEvent) {

        if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
            if (ADFContext.getCurrent().getSessionScope().get("addEditContract") !=
                null &&
                ADFContext.getCurrent().getSessionScope().get("addEditContract").toString().equals("edit")) {
                if (contractRow.getAttribute("OrgId") == null) {
                    JSFUtils.addFacesErrorMessage("Please select Business Unit");
                } else {
                    //                       if(contractRow.getAttribute("ReqNumber") == null){
                    //                           JSFUtils.addFacesErrorMessage("Please select Requisition Number");
                    //                       }else{
                    //                    if (contractRow.getAttribute("StartDate") == null) {
                    //                        JSFUtils.addFacesErrorMessage("Please select  Start Date");
                    //                    } else {
                    //                        if (contractRow.getAttribute("EndDate") == null) {
                    //                            JSFUtils.addFacesErrorMessage("Please select  End Date");
                    //                        } else {
                    if (contractRow.getAttribute("BuyerId") == null) {
                        JSFUtils.addFacesErrorMessage("Please select  Buyer Name");
                    } else {
                        contractRow.setAttribute("FuncId", "200001");
                        ADFUtils.findOperation("Commit").execute();
                        JSFUtils.addFacesInformationMessage("Buy Contract Information Saved Successfully");
                    }
                    //                        }
                    //                    }
                    //                       }
                }

            }
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell")) {
            if (ADFContext.getCurrent().getSessionScope().get("addEditContract") !=
                null &&
                ADFContext.getCurrent().getSessionScope().get("addEditContract").toString().equals("edit")) {
                contractRow.setAttribute("FuncId", "200002");
                contractRow.setAttribute("ApprovalStatus", "APR");
                ADFUtils.findOperation("Commit").execute();
                JSFUtils.addFacesInformationMessage("Sell Contract Information Saved Successfully");
            } else if (ADFContext.getCurrent().getSessionScope().get("addEditContract") !=
                       null &&
                       ADFContext.getCurrent().getSessionScope().get("addEditContract").toString().equals("add")) {
                //contractRow.setAttribute("ContractStatus", "ACTIVE");
                contractRow.setAttribute("FuncId", "200002");
                contractRow.setAttribute("ApprovalStatus", "APR");
                contractRow.setAttribute("Intent", "S");
                contractRow.setAttribute("ContractNum",
                                         "CONT-" + contractRow.getAttribute("ContHeaderId"));
                ADFUtils.findOperation("Commit").execute();
                //                    refreshSearchTable();
                //                    pageRedirect = "save";
                JSFUtils.numberFaceMessage("Sell Contract",
                                           contractRow.getAttribute("ContHeaderId"));
            }
        } else {
            //System.err.println("Error need to check Buy or sell type");
        }


    }


    public void onClickSavePartyInfo(ActionEvent actionEvent) {
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
            if (ADFContext.getCurrent().getSessionScope().get("addEditContract") !=
                null &&
                ADFContext.getCurrent().getSessionScope().get("addEditContract").toString().equals("edit")) {
                if (contractRow.getAttribute("OrgId") == null) {
                    JSFUtils.addFacesErrorMessage("Please select Business Unit in Contract Information Page");
                } else {
                    //                               if(contractRow.getAttribute("ReqNumber") == null){
                    //                                   JSFUtils.addFacesErrorMessage("Please select Requisition Number in Contract Information Page");
                    //                               }else{
                    //                    if (contractRow.getAttribute("StartDate") == null) {
                    //                        JSFUtils.addFacesErrorMessage("Please select  Start Date in Contract Information Page");
                    //                    } else {
                    //                        if (contractRow.getAttribute("EndDate") == null) {
                    //                            JSFUtils.addFacesErrorMessage("Please select  End Date in Contract Information Page");
                    //                        } else {
                    if (contractRow.getAttribute("BuyerId") == null) {
                        JSFUtils.addFacesErrorMessage("Please select  Buyer Name in Contract Information Page");
                    } else {
                        if (contractRow.getAttribute("vendorName_Trans") ==
                            null) {
                            JSFUtils.addFacesErrorMessage("Please select Supplier Name");
                        } else {
                            if (contractRow.getAttribute("VendorSiteId") ==
                                null) {
                                JSFUtils.addFacesErrorMessage("Please select Supplier Site Code");
                            } else {
                                contractRow.setAttribute("FuncId", "200001");
                                ADFUtils.findOperation("Commit").execute();
                                JSFUtils.addFacesInformationMessage("Buy Contract Information Saved Successfully");
                            }
                        }
                    }
                    //                        }
                    //                    }
                    //                  }
                }

            }

        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell")) {
            if (ADFContext.getCurrent().getSessionScope().get("addEditContract") !=
                null &&
                ADFContext.getCurrent().getSessionScope().get("addEditContract").toString().equals("edit")) {
                contractRow.setAttribute("FuncId", "200002");
                contractRow.setAttribute("ApprovalStatus", "APR");
                ADFUtils.findOperation("Commit").execute();
                JSFUtils.addFacesInformationMessage("Sell Contract Information Saved Successfully");
            } else if (ADFContext.getCurrent().getSessionScope().get("addEditContract") !=
                       null &&
                       ADFContext.getCurrent().getSessionScope().get("addEditContract").toString().equals("add")) {
                //contractRow.setAttribute("ContractStatus", "ACTIVE");
                contractRow.setAttribute("FuncId", "200002");
                contractRow.setAttribute("ApprovalStatus", "APR");
                contractRow.setAttribute("Intent", "S");
                contractRow.setAttribute("ContractNum",
                                         "CONT-" + contractRow.getAttribute("ContHeaderId"));
                ADFUtils.findOperation("Commit").execute();
                //                    refreshSearchTable();
                //                    pageRedirect = "save";
                JSFUtils.numberFaceMessage("Sell Contract",
                                           contractRow.getAttribute("ContHeaderId"));
            }
        } else {
            //System.err.println("Error need to check Buy or sell type");
        }

    }


    public void onClickSaveLineInfo(ActionEvent actionEvent) {
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
            if (ADFContext.getCurrent().getSessionScope().get("addEditContract") !=
                null &&
                ADFContext.getCurrent().getSessionScope().get("addEditContract").toString().equals("edit")) {
                if (contractRow.getAttribute("OrgId") == null) {
                    JSFUtils.addFacesErrorMessage("Please select Business Unit in Contract Information Page");
                } else {
                    //                                    if(contractRow.getAttribute("ReqNumber") == null){
                    //                                        JSFUtils.addFacesErrorMessage("Please select Requisition Number in Contract Information Page");
                    //                                    }else{
                    //                    if (contractRow.getAttribute("StartDate") == null) {
                    //                        JSFUtils.addFacesErrorMessage("Please select  Start Date in Contract Information Page");
                    //                    } else {
                    //                        if (contractRow.getAttribute("EndDate") == null) {
                    //                            JSFUtils.addFacesErrorMessage("Please select  End Date in Contract Information Page");
                    //                        } else {
                    if (contractRow.getAttribute("BuyerId") == null) {
                        JSFUtils.addFacesErrorMessage("Please select  Buyer Name in Contract Information Page");
                    } else {
                        if (contractRow.getAttribute("vendorName_Trans") ==
                            null) {
                            JSFUtils.addFacesErrorMessage("Please select Supplier Name in Party Information Page");
                        } else {
                            if (contractRow.getAttribute("VendorSiteId") ==
                                null) {
                                JSFUtils.addFacesErrorMessage("Please select Supplier Site Code in Party Information Page");
                            } else {
                                if (contractRow.getAttribute("PaymentTerm") ==
                                    null) {
                                    JSFUtils.addFacesErrorMessage("Please select Payment Term");
                                } else {
                                    contractRow.setAttribute("FuncId",
                                                             "200001");
                                    ADFUtils.findOperation("Commit").execute();
                                    JSFUtils.addFacesInformationMessage("Buy Contract Information Saved Successfully");
                                }
                            }
                        }
                    }
                    //                        }
                    //                    }
                    //                                    }
                }

            }

        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell")) {
            if (ADFContext.getCurrent().getSessionScope().get("addEditContract") !=
                null &&
                ADFContext.getCurrent().getSessionScope().get("addEditContract").toString().equals("edit")) {
                contractRow.setAttribute("FuncId", "200002");
                contractRow.setAttribute("ApprovalStatus", "APR");
                ADFUtils.findOperation("Commit").execute();
                JSFUtils.addFacesInformationMessage("Sell Contract Information Saved Successfully");
            } else if (ADFContext.getCurrent().getSessionScope().get("addEditContract") !=
                       null &&
                       ADFContext.getCurrent().getSessionScope().get("addEditContract").toString().equals("add")) {
                //contractRow.setAttribute("ContractStatus", "ACTIVE");
                contractRow.setAttribute("FuncId", "200002");
                contractRow.setAttribute("ApprovalStatus", "APR");
                contractRow.setAttribute("Intent", "S");
                contractRow.setAttribute("ContractNum",
                                         "CONT-" + contractRow.getAttribute("ContHeaderId"));
                ADFUtils.findOperation("Commit").execute();
                //                    refreshSearchTable();
                //                    pageRedirect = "save";
                JSFUtils.numberFaceMessage("Sell Contract",
                                           contractRow.getAttribute("ContHeaderId"));
            }
        } else {
            //System.err.println("Error need to check Buy or sell type");
        }


    }

    public void onClickSavePaymentInfo(ActionEvent actionEvent) {
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
            if (ADFContext.getCurrent().getSessionScope().get("addEditContract") !=
                null &&
                ADFContext.getCurrent().getSessionScope().get("addEditContract").toString().equals("edit")) {
                if (contractRow.getAttribute("OrgId") == null) {
                    JSFUtils.addFacesErrorMessage("Please select Business Unit in Contract Information Page");
                } else {
                    //                               if(contractRow.getAttribute("ReqNumber") == null){
                    //                                   JSFUtils.addFacesErrorMessage("Please select Requisition Number in Contract Information Page");
                    //                               }else{
                    //                    if (contractRow.getAttribute("StartDate") == null) {
                    //                        JSFUtils.addFacesErrorMessage("Please select  Start Date in Contract Information Page");
                    //                    } else {
                    //                        if (contractRow.getAttribute("EndDate") == null) {
                    //                            JSFUtils.addFacesErrorMessage("Please select  End Date in Contract Information Page");
                    //                        } else {
                    if (contractRow.getAttribute("BuyerId") == null) {
                        JSFUtils.addFacesErrorMessage("Please select  Buyer Name in Contract Information Page");
                    } else {
                        if (contractRow.getAttribute("vendorName_Trans") ==
                            null) {
                            JSFUtils.addFacesErrorMessage("Please select Supplier Name in Party Information Page");
                        } else {
                            if (contractRow.getAttribute("VendorSiteId") ==
                                null) {
                                JSFUtils.addFacesErrorMessage("Please select Supplier Site Code in Party Information Page");
                            } else {
                                if (contractRow.getAttribute("PaymentTerm") ==
                                    null) {
                                    JSFUtils.addFacesErrorMessage("Please select Payment Term in Line Information Page");
                                } else {
                                    contractRow.setAttribute("FuncId",
                                                             "200001");
                                    ADFUtils.findOperation("Commit").execute();
                                    JSFUtils.addFacesInformationMessage("Buy Contract Information Saved Successfully");
                                }
                            }
                        }
                    }
                    //                        }
                    //                    }
                    //                               }
                }

            }

        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell")) {
            if (ADFContext.getCurrent().getSessionScope().get("addEditContract") !=
                null &&
                ADFContext.getCurrent().getSessionScope().get("addEditContract").toString().equals("edit")) {
                contractRow.setAttribute("FuncId", "200002");
                contractRow.setAttribute("ApprovalStatus", "APR");
                ADFUtils.findOperation("Commit").execute();
                JSFUtils.addFacesInformationMessage("Sell Contract Information Saved Successfully");
            } else if (ADFContext.getCurrent().getSessionScope().get("addEditContract") !=
                       null &&
                       ADFContext.getCurrent().getSessionScope().get("addEditContract").toString().equals("add")) {
                // contractRow.setAttribute("ContractStatus", "ACTIVE");
                contractRow.setAttribute("FuncId", "200002");
                contractRow.setAttribute("ApprovalStatus", "APR");
                contractRow.setAttribute("Intent", "S");
                contractRow.setAttribute("ContractNum",
                                         "CONT-" + contractRow.getAttribute("ContHeaderId"));
                ADFUtils.findOperation("Commit").execute();
                //                    refreshSearchTable();
                //                    pageRedirect = "save";
                JSFUtils.numberFaceMessage("Sell Contract",
                                           contractRow.getAttribute("ContHeaderId"));
            }
        } else {
            //System.err.println("Error need to check Buy or sell type");
        }
    }

    public String onClickSaveGaurInfo() {
        String pageRedirect = null;
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
            
            if (ADFContext.getCurrent().getSessionScope().get("addEditContract") !=
                null &&
                ADFContext.getCurrent().getSessionScope().get("addEditContract").toString().equals("edit")) {
                if (contractRow.getAttribute("OrgId") == null) {
                    JSFUtils.addFacesErrorMessage("Please select Business Unit in Contract Information Page");
                } else {
                    //                               if(contractRow.getAttribute("ReqNumber") == null){
                    //                                   JSFUtils.addFacesErrorMessage("Please select Requisition Number in Contract Information Page");
                    //                               }else{
                    //                    if (contractRow.getAttribute("StartDate") == null) {
                    //                        JSFUtils.addFacesErrorMessage("Please select  Start Date in Contract Information Page");
                    //                    } else {
                    //                        if (contractRow.getAttribute("EndDate") == null) {
                    //                            JSFUtils.addFacesErrorMessage("Please select  End Date in Contract Information Page");
                    //                        } else {
                    if (contractRow.getAttribute("BuyerId") == null) {
                        JSFUtils.addFacesErrorMessage("Please select  Buyer Name in Contract Information Page");
                    } else {
                        if (contractRow.getAttribute("vendorName_Trans") ==
                            null) {
                            JSFUtils.addFacesErrorMessage("Please select Supplier Name in Party Information Page");
                        } else {
                            if (contractRow.getAttribute("VendorSiteId") ==
                                null) {
                                JSFUtils.addFacesErrorMessage("Please select Supplier Site Code in Party Information Page");
                            } else {
                                if (contractRow.getAttribute("PaymentTerm") ==
                                    null) {
                                    JSFUtils.addFacesErrorMessage("Please select Payment Term in Line Information Page");
                                    pageRedirect = null;
                                }
                               
                                
                                else {
                                    contractRow.setAttribute("ContractStatus",
                                                             "ACTIVE");
                                    contractRow.setAttribute("FuncId",
                                                             "200001");
                                    contractRow.setAttribute("ApprovalStatus",
                                                             "APR");
                                    ADFUtils.findOperation("Commit").execute();
                                    refreshSearchTable();
                                    pageRedirect = "save";
                                    JSFUtils.addFacesInformationMessage("Buy Contract Information Saved Successfully");
                                }
                            
                        }
                    }
                    }
                    //                        }
                    //                    }
                    //                               }
                }

            }

        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell")) {
            if (ADFContext.getCurrent().getSessionScope().get("addEditContract") !=
                null &&
                ADFContext.getCurrent().getSessionScope().get("addEditContract").toString().equals("edit")) {
                contractRow.setAttribute("FuncId", "200002");
                contractRow.setAttribute("ApprovalStatus", "APR");
                ADFUtils.findOperation("Commit").execute();
                refreshSearchTable();
                pageRedirect = "save";
                JSFUtils.addFacesInformationMessage("Sell Contract Information Saved Successfully");
            } else if (ADFContext.getCurrent().getSessionScope().get("addEditContract") !=
                       null &&
                       ADFContext.getCurrent().getSessionScope().get("addEditContract").toString().equals("add")) {
                //              contractRow.setAttribute("ContractStatus", "TRNS_DRAFT");
                //              contractRow.setAttribute("ApprovalStatus", "PEN");
                //contractRow.setAttribute("ContractStatus", "ACTIVE");
                contractRow.setAttribute("Intent", "S");
                contractRow.setAttribute("FuncId", "200002");
                contractRow.setAttribute("ContractNum",
                                         getContPrefix() + contractRow.getAttribute("ContHeaderId"));
                contractRow.setAttribute("ApprovalStatus", "APR");
                ADFUtils.findOperation("Commit").execute();
                //                    refreshSearchTable();
                pageRedirect = "save";
                JSFUtils.numberFaceMessage("Sell Contract",
                                           contractRow.getAttribute("ContHeaderId"));
            }
        } else {
            pageRedirect = "";
            //System.err.println("Error need to check Buy or sell type");
        }

        return pageRedirect;
    }

    public String getContPrefix() {
        String retVal = "CONT-";
        retVal =
                contractRow.getAttribute("BU_name") != null ? contractRow.getAttribute("BU_name").toString() :
                "CONT-";
        if (!("CONT-".equalsIgnoreCase(retVal))) {
            retVal = retVal.substring(4).trim() + "-";
        }
        return retVal;
    }

    public String onClickSaveRe_Direct() {
        int a = 0;
        int b = 0;
        String page = null;
        ViewObject gaurAttachVO =
            ADFUtils.findIterator("XxscContractGuaranteeVO2Iterator").getViewObject();
        RowSetIterator uopLine = gaurAttachVO.createRowSetIterator(null);
        //uopLine.reset();
        System.err.println(uopLine.getRowCount());        
        while (uopLine.hasNext()) {
            System.err.println("inside while");
            Row r = uopLine.next();
           String Att =r.getAttribute("Attribute1") == null ? "null" :  r.getAttribute("Attribute1").toString();
            String fNam =  r.getAttribute("FileName") == null ? "null" : r.getAttribute("FileName").toString();
                String sDat =  r.getAttribute("StartDate") == null ? "null" : r.getAttribute("StartDate").toString();
                String eDat =  r.getAttribute("EndDate") == null ? "null" : r.getAttribute("EndDate").toString();
                String rNum =  r.getAttribute("RefNumber") == null ? "null" : r.getAttribute("RefNumber").toString();
                String val =  r.getAttribute("Value") == null ? "null" : r.getAttribute("Value").toString();
                String gTyp =  r.getAttribute("GuarType") == null ? "null" : r.getAttribute("GuarType").toString();
            System.err.println(Att);
           if(gTyp.equals("Performance Guarantee") || gTyp.equals("INSU") || gTyp.equals("Advance Guarantee") || gTyp.equals("Retention Guarantee") ){
               
                if(Att.equals("Yes") ){
                        System.err.println("came inside iff yes");
                    if(fNam.equals("null") || sDat.equals("null") || eDat.equals("null") ||
                        rNum.equals("null") || val.equals("null")
                    )
                    {
                    a++;
                            
                        }
                        
                    }
                else{
                        System.err.println("came inside else yes");
                        if(fNam.equals("null") || sDat.equals("null") ||
                        rNum.equals("null") || val.equals("null")
                        )
                        {
                        b++;
                               
                            }
                       
                       
                    }
           }
            }
//            else{
//                     page = onClickSaveGaurInfo();
//                     //System.err.println("Redirect page" + page);
//                     refreshSearchTable();
//                     ADFUtils.refreshTable("ContractNum", searchContract);
//                     return page;
//                 }
        if(a != 0){
                JSFUtils.addFacesErrorMessage("Fill all the columns !!"); 
            }
        else if(b != 0) {
            JSFUtils.addFacesErrorMessage("Fill all the columns ,end date is optional !!"); 
        }
        else{
            page = onClickSaveGaurInfo();
            //System.err.println("Redirect page" + page);
            refreshSearchTable();
            ADFUtils.refreshTable("ContractNum", searchContract);
            return page;
        }
        
        
       return null;
       
    }

    public void setContractInfoCancelPopup(RichPopup contractInfoCancelPopup) {
        this.contractInfoCancelPopup = contractInfoCancelPopup;
    }

    public RichPopup getContractInfoCancelPopup() {
        return contractInfoCancelPopup;
    }

    public void onClickContractInfoPopupCancel(ActionEvent actionEvent) {
        contractInfoCancelPopup.cancel();
    }

    public void setPartyInfoCancelPopup(RichPopup partyInfoCancelPopup) {
        this.partyInfoCancelPopup = partyInfoCancelPopup;
    }

    public RichPopup getPartyInfoCancelPopup() {
        return partyInfoCancelPopup;
    }

    public void onClickPartyInfoPopupCancel(ActionEvent actionEvent) {
        partyInfoCancelPopup.cancel();
    }


    public void setLineInfoCancelPopup(RichPopup lineInfoCancelPopup) {
        this.lineInfoCancelPopup = lineInfoCancelPopup;
    }

    public RichPopup getLineInfoCancelPopup() {
        return lineInfoCancelPopup;
    }

    public void onClickLineInfoPopupCancel(ActionEvent actionEvent) {
        lineInfoCancelPopup.cancel();
    }


    public void setPayInfoCancelPopup(RichPopup payInfoCancelPopup) {
        this.payInfoCancelPopup = payInfoCancelPopup;
    }

    public RichPopup getPayInfoCancelPopup() {
        return payInfoCancelPopup;
    }

    public void onClickpayInfoPopupCancel(ActionEvent actionEvent) {
        payInfoCancelPopup.cancel();
    }

    public void setGauInfoCancelPopup(RichPopup gauInfoCancelPopup) {
        this.gauInfoCancelPopup = gauInfoCancelPopup;
    }

    public RichPopup getGauInfoCancelPopup() {
        return gauInfoCancelPopup;
    }

    public void onClickGauInfoPopupCancel(ActionEvent actionEvent) {
        gauInfoCancelPopup.cancel();
        refreshSearchTable();
    }

    public void onClickCreateLine(ActionEvent actionEvent) {
        if (contractRow.getAttribute("ProjectId") == null) {
            JSFUtils.addFacesErrorMessage("Please Select Project Number in Contract Information Page");
        } else {
            // check variation
            if (!contractRow.getAttribute("Version").toString().equalsIgnoreCase("0")) {
                if (contractRow.getAttribute("RevisedDate") == null) {
                    JSFUtils.addFacesErrorMessage("Please select Revised Date  in Contract Information Page");
                } else {
                    //System.err.println("Line Count---" +
//                                       contractLineVO.getEstimatedRowCount());
                    int count = 0;
                    RowSetIterator rs =
                        contractLineVO.createRowSetIterator(null);
                    while (rs.hasNext()) {
                        Row r = rs.next();
                        if (r.getAttribute("RevQuantity") == null) {
                            JSFUtils.addFacesErrorMessage("Please provide Revised Quantity");
                        } else {
                            if (r.getAttribute("RevUnitPrice") == null) {
                                JSFUtils.addFacesErrorMessage("Please provide Revised Unit Price");
                            } else {
                                count++;
                                if (contractLineVO.getEstimatedRowCount() ==
                                    count) {
                                    ADFUtils.findOperation("CreateInsert").execute();
                                }
                            }
                        }
                        //System.err.println("increase " + count);
                    }

                }
                // check variation  End
                // if-No Variation Begin
            } else {
                if (contractRow.getAttribute("ReqNumber") == null) {
                    JSFUtils.addFacesErrorMessage("Please select Requisition Number in Contract Information Page");
                } else {
                    if (contractRow.getAttribute("ProjectNumber") == null) {
                        JSFUtils.addFacesErrorMessage("Please select Project Number in Contract Information Page");
                    } else {
                        if (contractRow.getAttribute("StartDate") == null) {
                            JSFUtils.addFacesErrorMessage("Please select  Start Date in Contract Information Page");
                        } else {
                            if (contractRow.getAttribute("EndDate") == null) {
                                JSFUtils.addFacesErrorMessage("Please select  End Date in Contract Information Page");
                            } else {
                                if (contractRow.getAttribute("vendorName_Trans") ==
                                    null) {
                                    JSFUtils.addFacesErrorMessage("Please select Supplier Name in Party Information Page");
                                } else {
                                    if (contractRow.getAttribute("ContractNum") ==
                                        null) {

                                        //System.err.println("Line Count---" +
//                                                           contractLineVO.getEstimatedRowCount());
                                        int count = 0;
                                        RowSetIterator rs =
                                            contractLineVO.createRowSetIterator(null);
                                        while (rs.hasNext()) {
                                            Row r = rs.next();
                                            if (r.getAttribute("TaskNumber") ==
                                                null) {
                                                JSFUtils.addFacesErrorMessage("Please select Task Name");
                                            } else {
                                                if (r.getAttribute("OrigQuantity") ==
                                                    null) {
                                                    JSFUtils.addFacesErrorMessage("Please provide Quantity");
                                                } else {
                                                    if (r.getAttribute("OrigUnitPrice") ==
                                                        null) {
                                                        JSFUtils.addFacesErrorMessage("Please provide Unit Price");
                                                    } else {
                                                        count++;
                                                        if (contractLineVO.getEstimatedRowCount() ==
                                                            count) {
                                                            ADFUtils.findOperation("CreateInsert").execute();
                                                        }

                                                    }
                                                }
                                            }
                                            //System.err.println("increase " +
//                                                               count);
                                        }

                                    } else {
                                        //System.err.println("Line Count---" +
//                                                           contractLineVO.getEstimatedRowCount());
                                        int count = 0;
                                        RowSetIterator rs =
                                            contractLineVO.createRowSetIterator(null);
                                        while (rs.hasNext()) {
                                            Row r = rs.next();
                                            if (r.getAttribute("TaskNumber") ==
                                                null) {
                                                JSFUtils.addFacesErrorMessage("Please select Task Name");
                                            } else {
                                                if (r.getAttribute("OrigQuantity") ==
                                                    null) {
                                                    JSFUtils.addFacesErrorMessage("Please provide Quantity");
                                                } else {
                                                    if (r.getAttribute("OrigUnitPrice") ==
                                                        null) {
                                                        JSFUtils.addFacesErrorMessage("Please provide Unit Price");
                                                    } else {
                                                        count++;
                                                        if (contractLineVO.getEstimatedRowCount() ==
                                                            count) {
                                                            ADFUtils.findOperation("CreateInsert").execute();
                                                        }

                                                    }
                                                }
                                            }
                                            //System.err.println("increase " +
//                                                               count);
                                        }


                                    }
                                }
                            }
                        }
                    }
                }
                // if-No Variation  End
            }
        }

    }

    public void setGuaStDate(RichInputDate guaStDate) {
        this.guaStDate = guaStDate;
    }

    public RichInputDate getGuaStDate() {
        return guaStDate;
    }

    public void setGuaEnDate(RichInputDate guaEnDate) {
        this.guaEnDate = guaEnDate;
    }

    public RichInputDate getGuaEnDate() {
        return guaEnDate;
    }

    public void setGauDuration(RichInputText gauDuration) {
        this.gauDuration = gauDuration;
    }

    public RichInputText getGauDuration() {
        return gauDuration;
    }

    public void setGuaDayBind(RichInputText guaDayBind) {
        this.guaDayBind = guaDayBind;
    }

    public RichInputText getGuaDayBind() {
        return guaDayBind;
    }

    public void onChangeGuarEnDate(ValueChangeEvent valueChangeEvent) {
        if (guaStDate.getValue() != null) {
            valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            oracle.jbo.domain.Date st =
                (oracle.jbo.domain.Date)guaStDate.getValue();
            //System.err.println("---JBO S Date" + st);
            oracle.jbo.domain.Date en =
                (oracle.jbo.domain.Date)valueChangeEvent.getNewValue();
            //System.err.println("---JBO E Date" + en);
            long nDays = getDifferenceDaysBetweenTwoDates(st, en);
            oracle.jbo.domain.Number noDays =
                new oracle.jbo.domain.Number(nDays);
            //System.err.println("======no of Days======" + noDays);
            if (noDays.equals(1)) {
                gauDuration.setValue(noDays);
                AdfFacesContext.getCurrentInstance().addPartialTarget(gauDuration);
                guaDayBind.setValue("Day");
                AdfFacesContext.getCurrentInstance().addPartialTarget(guaDayBind);
            } else {
                gauDuration.setValue(noDays);
                AdfFacesContext.getCurrentInstance().addPartialTarget(gauDuration);
                guaDayBind.setValue("Days");
                AdfFacesContext.getCurrentInstance().addPartialTarget(guaDayBind);
            }

        } else {
            JSFUtils.addFacesErrorMessage("Please select Start Date");
            guaEnDate.setValue("");
            AdfFacesContext.getCurrentInstance().addPartialTarget(guaEnDate);

        }
    }


    public void setLiquidated(RichInputText liquidated) {
        this.liquidated = liquidated;
    }

    public RichInputText getLiquidated() {
        return liquidated;
    }

    public void setPenalty(RichInputText penalty) {
        this.penalty = penalty;
    }

    public RichInputText getPenalty() {
        return penalty;
    }

    public void setRetention(RichInputText retention) {
        this.retention = retention;
    }

    public RichInputText getRetention() {
        return retention;
    }

    public void setRetentionRelease(RichInputText retentionRelease) {
        this.retentionRelease = retentionRelease;
    }

    public RichInputText getRetentionRelease() {
        return retentionRelease;
    }

    public void setAdvance(RichInputText advance) {
        this.advance = advance;
    }

    public RichInputText getAdvance() {
        return advance;
    }

    public void setAdvanceRec(RichInputText advanceRec) {
        this.advanceRec = advanceRec;
    }

    public RichInputText getAdvanceRec() {
        return advanceRec;
    }

    public void setMaterials(RichInputText materials) {
        this.materials = materials;
    }

    public RichInputText getMaterials() {
        return materials;
    }

    public void setMaterialsRec(RichInputText materialsRec) {
        this.materialsRec = materialsRec;
    }

    public RichInputText getMaterialsRec() {
        return materialsRec;
    }


    public void liqVCL(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            //            double liqPer=Double.parseDouble(valueChangeEvent.getNewValue().toString());
            //          double penalPer=penalty.getValue()==null?0:Double.parseDouble(penalty.getValue().toString());
            //            double retenPer=retention.getValue()==null?0:Double.parseDouble(retention.getValue().toString());
            //            double advanPer=advance.getValue()==null?0:Double.parseDouble(advance.getValue().toString());
            //            double materailPer=materials.getValue()==null?0:Double.parseDouble(materials.getValue().toString());

            //            double sum=liqPer+penalPer+retenPer+advanPer+materailPer;
            //            if(sum<=100){
            String val =
                valueChangeEvent.getNewValue() == null ? "0" : valueChangeEvent.getNewValue().toString();
            String tot = "TotalContractSum";
            String setAtt = "LiqDamageAmount";
            UIComponent id = liqAmount;
            calcPerc(val, tot, setAtt, id);
            //            }else{
            //                JSFUtils.addFacesErrorMessage("Enter percentage is greater than 100. Please check");
            //                liquidated.setValue("");
            //                AdfFacesContext.getCurrentInstance().addPartialTarget(liquidated);
            //
            //            }

        } else {
            //            double liqPer=valueChangeEvent.getNewValue()==null?0:Double.parseDouble(valueChangeEvent.getNewValue().toString());
            //            double penalPer=penalty.getValue()==null?0:Double.parseDouble(penalty.getValue().toString());
            //            double penalPer=0;
            //            double retenPer=retention.getValue()==null?0:Double.parseDouble(retention.getValue().toString());
            //            double advanPer=advance.getValue()==null?0:Double.parseDouble(advance.getValue().toString());
            //            double materailPer=materials.getValue()==null?0:Double.parseDouble(materials.getValue().toString());
            //
            //            double sum=liqPer+penalPer+retenPer+advanPer+materailPer;
            //            if(sum<=100){
            String val =
                valueChangeEvent.getNewValue() == null ? "0" : valueChangeEvent.getNewValue().toString();
            String tot = "TotalContractSum";
            String setAtt = "LiqDamageAmount";
            UIComponent id = liqAmount;
            calcPerc(val, tot, setAtt, id);
            //            }else{
            //                JSFUtils.addFacesErrorMessage("Enter percentage is greater than 100. Please check");
            //                liquidated.setValue("");
            //                AdfFacesContext.getCurrentInstance().addPartialTarget(liquidated);
            //                contractRow.setAttribute("LiqDamageAmount", "");
            //                AdfFacesContext.getCurrentInstance().addPartialTarget(liqAmount);
            //            }

        }


    }

    public void penaltyVCL(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            double liqPer =
                liquidated.getValue() == null ? 0 : Double.parseDouble(liquidated.getValue().toString());
            //            double penalPer=valueChangeEvent.getNewValue()==null?0:Double.parseDouble(valueChangeEvent.getNewValue().toString());
            double penalPer = 0;
            double retenPer =
                retention.getValue() == null ? 0 : Double.parseDouble(retention.getValue().toString());
            double advanPer =
                advance.getValue() == null ? 0 : Double.parseDouble(advance.getValue().toString());
            double materailPer =
                materials.getValue() == null ? 0 : Double.parseDouble(materials.getValue().toString());
            double sum = liqPer + penalPer + retenPer + advanPer + materailPer;
            if (sum <= 100) {
                String val =
                    valueChangeEvent.getNewValue() == null ? "0" : valueChangeEvent.getNewValue().toString();
                String tot = "TotalContractSum";
                String setAtt = "PenaltyAmount";
                UIComponent id = pen;
                calcPerc(val, tot, setAtt, id);
                AdfFacesContext.getCurrentInstance().addPartialTarget(pen);
            } else {
                JSFUtils.addFacesErrorMessage("Enter percentage is greater than 100. Please check");
                penalty.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(penalty);
                contractRow.setAttribute("PenaltyAmount", "");
                AdfFacesContext.getCurrentInstance().addPartialTarget(pen);
            }

        } else {
            double liqPer =
                liquidated.getValue() == null ? 0 : Double.parseDouble(liquidated.getValue().toString());
            //            double penalPer=valueChangeEvent.getNewValue()==null?0:Double.parseDouble(valueChangeEvent.getNewValue().toString());
            double penalPer = 0;
            double retenPer =
                retention.getValue() == null ? 0 : Double.parseDouble(retention.getValue().toString());
            double advanPer =
                advance.getValue() == null ? 0 : Double.parseDouble(advance.getValue().toString());
            double materailPer =
                materials.getValue() == null ? 0 : Double.parseDouble(materials.getValue().toString());
            double sum = liqPer + penalPer + retenPer + advanPer + materailPer;
            if (sum <= 100) {
                String val =
                    valueChangeEvent.getNewValue() == null ? "0" : valueChangeEvent.getNewValue().toString();
                String tot = "TotalContractSum";
                String setAtt = "PenaltyAmount";
                UIComponent id = pen;
                calcPerc(val, tot, setAtt, id);
                AdfFacesContext.getCurrentInstance().addPartialTarget(pen);
            } else {
                JSFUtils.addFacesErrorMessage("Enter percentage is greater than 100. Please check");
                penalty.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(penalty);
                //                pen.setValue("");
                contractRow.setAttribute("PenaltyAmount", "");
                AdfFacesContext.getCurrentInstance().addPartialTarget(pen);
            }
        }
    }

    /****Retention percentage****/

    //    public void retVCL(ValueChangeEvent valueChangeEvent) {
    //        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
    //        if (valueChangeEvent.getNewValue() != null) {
    //            //          double liqPer=liquidated.getValue()==null?0:Double.parseDouble(liquidated.getValue().toString());
    //            //          double penalPer=penalty.getValue()==null?0:Double.parseDouble(penalty.getValue().toString());
    //            double advanPer =
    //                advance.getValue() == null ? 0 : Double.parseDouble(advance.getValue().toString());
    //            double materailPer =
    //                materials.getValue() == null ? 0 : Double.parseDouble(materials.getValue().toString());
    //            double retenPer =
    //                valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
    //            double sum = advanPer + materailPer + retenPer;
    //
    //            if (sum <= 100) {
    //                String val =
    //                    valueChangeEvent.getNewValue() == null ? "0" : valueChangeEvent.getNewValue().toString();
    //                String tot = "ContractAmount";
    //                String setAtt = "RetenAmount";
    //                UIComponent id = ret;
    //                calcPerc(val, tot, setAtt, id);
    //                AdfFacesContext.getCurrentInstance().addPartialTarget(ret);
    //
    //            } else {
    //                JSFUtils.addFacesErrorMessage("Enter percentage is greater than 100. Please check");
    //                retention.setValue("");
    //                AdfFacesContext.getCurrentInstance().addPartialTarget(retention);
    //                //              ret.setValue("");
    //                contractRow.setAttribute("RetenAmount", "");
    //                AdfFacesContext.getCurrentInstance().addPartialTarget(ret);
    //            }
    //        } else {
    //            //          double liqPer=liquidated.getValue()==null?0:Double.parseDouble(liquidated.getValue().toString());
    //            //          double penalPer=penalty.getValue()==null?0:Double.parseDouble(penalty.getValue().toString());
    //            double advanPer =
    //                advance.getValue() == null ? 0 : Double.parseDouble(advance.getValue().toString());
    //            double materailPer =
    //                materials.getValue() == null ? 0 : Double.parseDouble(materials.getValue().toString());
    //            double retenPer =
    //                valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
    //            double sum = advanPer + materailPer + retenPer;
    //
    //            if (sum <= 100) {
    //                String val =
    //                    valueChangeEvent.getNewValue() == null ? "0" : valueChangeEvent.getNewValue().toString();
    //                String tot = "ContractAmount";
    //                String setAtt = "RetenAmount";
    //                UIComponent id = ret;
    //                calcPerc(val, tot, setAtt, id);
    //                AdfFacesContext.getCurrentInstance().addPartialTarget(ret);
    //            } else {
    //                JSFUtils.addFacesErrorMessage("Enter percentage is greater than 100. Please check");
    //                retention.setValue("");
    //                AdfFacesContext.getCurrentInstance().addPartialTarget(retention);
    //                //              ret.setValue("");
    //                contractRow.setAttribute("RetenAmount", "");
    //                AdfFacesContext.getCurrentInstance().addPartialTarget(ret);
    //            }
    //        }
    //    }

    /***Release Retention***/
    /*
    public void relRetVCL(ValueChangeEvent valueChangeEvent) {
    valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if(valueChangeEvent.getNewValue()!=null){
            double liqPer=liquidated.getValue()==null?0:Double.parseDouble(liquidated.getValue().toString());
//            double penalPer=penalty.getValue()==null?0:Double.parseDouble(penalty.getValue().toString());
            double penalPer=0;
            double retenPer=retention.getValue()==null?0:Double.parseDouble(retention.getValue().toString());
            double advanPer=advance.getValue()==null?0:Double.parseDouble(advance.getValue().toString());
            double materailPer=materials.getValue()==null?0:Double.parseDouble(materials.getValue().toString());

            double sum=liqPer+penalPer+retenPer+advanPer+materailPer;
            if(sum<=100){
                double retenRelPer=valueChangeEvent.getNewValue()==null?0:Double.parseDouble(valueChangeEvent.getNewValue().toString());
                //System.err.println("retenPer--"+retenPer);
                //System.err.println("retenRelPer--"+retenRelPer);
                    if(retenRelPer<=retenPer){
                        String val = valueChangeEvent.getNewValue()==null?"0":valueChangeEvent.getNewValue().toString();
                        String tot = "TotalContractSum";
                        String setAtt = "RelRetenAmount";
                        UIComponent id = retRel;
                        calcPerc(val, tot, setAtt, id);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(retRel);
                        //System.err.println("--RelRetenAmount--"+contractVO.getCurrentRow().getAttribute("RelRetenAmount"));
                    }else{
                        JSFUtils.addFacesErrorMessage("Release Retention should be within Retention Percentage");
                        retentionRelease.setValue("");
                        AdfFacesContext.getCurrentInstance().addPartialTarget(retentionRelease);
//                        retRel.setValue("");
                        contractRow.setAttribute("RelRetenAmount", "");
                        AdfFacesContext.getCurrentInstance().addPartialTarget(retRel);
                    }
                }else{
                    JSFUtils.addFacesErrorMessage("Enter percentage is greater than 100. Please check");
                    retentionRelease.setValue("");
                    AdfFacesContext.getCurrentInstance().addPartialTarget(retentionRelease);
                        contractRow.setAttribute("RelRetenAmount", "");
                    AdfFacesContext.getCurrentInstance().addPartialTarget(retRel);
                    }
        }else{

            double liqPer=liquidated.getValue()==null?0:Double.parseDouble(liquidated.getValue().toString());
//            double penalPer=penalty.getValue()==null?0:Double.parseDouble(penalty.getValue().toString());
            double penalPer=0;
            double retenPer=retention.getValue()==null?0:Double.parseDouble(retention.getValue().toString());
            double advanPer=advance.getValue()==null?0:Double.parseDouble(advance.getValue().toString());
            double materailPer=materials.getValue()==null?0:Double.parseDouble(materials.getValue().toString());

            double sum=liqPer+penalPer+retenPer+advanPer+materailPer;
            if(sum<=100){
                double retenRelPer=valueChangeEvent.getNewValue()==null?0:Double.parseDouble(valueChangeEvent.getNewValue().toString());
                //System.err.println("retenPer--"+retenPer);
                //System.err.println("retenRelPer--"+retenRelPer);
                    if(retenRelPer<=retenPer){
                        String val = valueChangeEvent.getNewValue()==null?"0":valueChangeEvent.getNewValue().toString();
                        String tot = "TotalContractSum";
                        String setAtt = "RelRetenAmount";
                        UIComponent id = retRel;
                        calcPerc(val, tot, setAtt, id);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(retRel);
                    }else{
                        JSFUtils.addFacesErrorMessage("Release Retention should be within Retention Percentage");
                        retentionRelease.setValue("");
                        AdfFacesContext.getCurrentInstance().addPartialTarget(retentionRelease);
//                        retRel.setValue("");
                        contractRow.setAttribute("RelRetenAmount", "");
                        AdfFacesContext.getCurrentInstance().addPartialTarget(retRel);
                    }
                }else{
                    JSFUtils.addFacesErrorMessage("Enter percentage is greater than 100. Please check");
                    retentionRelease.setValue("");
                    AdfFacesContext.getCurrentInstance().addPartialTarget(retentionRelease);
                    contractRow.setAttribute("RelRetenAmount", "");
                    AdfFacesContext.getCurrentInstance().addPartialTarget(retRel);
                    }


        }
}
  */

    /***Advance***/
    /****Advance percentage*****/

    //      public void advVCL(ValueChangeEvent valueChangeEvent) {
    //        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
    //        if (valueChangeEvent.getNewValue() != null) {
    //            advanceRec.setDisabled(Boolean.FALSE);
    //            advanceRec.setRequired(Boolean.TRUE);
    //            AdfFacesContext.getCurrentInstance().addPartialTarget(advanceRec);
    //            //          double liqPer=liquidated.getValue()==null?0:Double.parseDouble(liquidated.getValue().toString());
    //            //          double penalPer=penalty.getValue()==null?0:Double.parseDouble(penalty.getValue().toString());
    //            double advanPer =
    //                valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
    //            double materailPer =
    //                materials.getValue() == null ? 0 : Double.parseDouble(materials.getValue().toString());
    //            double retenPer =
    //                retention.getValue() == null ? 0 : Double.parseDouble(retention.getValue().toString());
    //            double sum = advanPer + materailPer + retenPer;
    //
    //            if (sum <= 100) {
    //                String val =
    //                    valueChangeEvent.getNewValue() == null ? "0" : valueChangeEvent.getNewValue().toString();
    //                String tot = "ContractAmount";
    //                String setAtt = "AdvAmount";
    //                UIComponent id = adv;
    //                calcPerc(val, tot, setAtt, id);
    //                AdfFacesContext.getCurrentInstance().addPartialTarget(adv);
    //            } else {
    //                JSFUtils.addFacesErrorMessage("Enter percentage is greater than 100. Please check");
    //                advance.setValue("");
    //                AdfFacesContext.getCurrentInstance().addPartialTarget(advance);
    //                //                adv.setValue("");
    //                contractRow.setAttribute("AdvAmount", "");
    //                AdfFacesContext.getCurrentInstance().addPartialTarget(adv);
    //            }
    //        } else {
    //            advanceRec.setDisabled(Boolean.TRUE);
    //            advanceRec.setRequired(Boolean.FALSE);
    //            AdfFacesContext.getCurrentInstance().addPartialTarget(advanceRec);
    //            //            double liqPer=liquidated.getValue()==null?0:Double.parseDouble(liquidated.getValue().toString());
    //            //            double penalPer=penalty.getValue()==null?0:Double.parseDouble(penalty.getValue().toString());
    //            double advanPer =
    //                valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
    //            double materailPer =
    //                materials.getValue() == null ? 0 : Double.parseDouble(materials.getValue().toString());
    //            double retenPer =
    //                retention.getValue() == null ? 0 : Double.parseDouble(retention.getValue().toString());
    //            double sum = advanPer + materailPer + retenPer;
    //
    //            if (sum <= 100) {
    //                String val =
    //                    valueChangeEvent.getNewValue() == null ? "0" : valueChangeEvent.getNewValue().toString();
    //                String tot = "ContractAmount";
    //                String setAtt = "AdvAmount";
    //                UIComponent id = adv;
    //                calcPerc(val, tot, setAtt, id);
    //                AdfFacesContext.getCurrentInstance().addPartialTarget(adv);
    //            } else {
    //                JSFUtils.addFacesErrorMessage("Enter percentage is greater than 100. Please check");
    //                advance.setValue("");
    //                AdfFacesContext.getCurrentInstance().addPartialTarget(advance);
    //                //              adv.setValue("");
    //                contractRow.setAttribute("AdvAmount", "");
    //                AdfFacesContext.getCurrentInstance().addPartialTarget(adv);
    //            }
    //
    //        }
    //    }

    /***Advan Recovery***/
    /*
    public void advRecVCL(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if(valueChangeEvent.getNewValue()!=null){
            double liqPer=liquidated.getValue()==null?0:Double.parseDouble(liquidated.getValue().toString());
//            double penalPer=penalty.getValue()==null?0:Double.parseDouble(penalty.getValue().toString());
            double penalPer=0;
            double retenPer=retention.getValue()==null?0:Double.parseDouble(retention.getValue().toString());
            double advanPer=advance.getValue()==null?0:Double.parseDouble(advance.getValue().toString());
            double materailPer=materials.getValue()==null?0:Double.parseDouble(materials.getValue().toString());

            double sum=liqPer+penalPer+retenPer+advanPer+materailPer;
            if(sum<=100){
                double advanceRecPer=valueChangeEvent.getNewValue()==null?0:Double.parseDouble(valueChangeEvent.getNewValue().toString());
                //System.err.println("advanPer--"+advanPer);
                //System.err.println("advanPer Reco--"+advanceRecPer);
//                    if(advanceRecPer<=advanPer){
                        String val = valueChangeEvent.getNewValue()==null?"0":valueChangeEvent.getNewValue().toString();
                        String tot = "TotalContractSum";
                        String setAtt = "AdvRecoveryAmount";
                        UIComponent id = advRec;
                        calcPerc(val, tot, setAtt, id);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(advRec);
//                    }else{
//                        JSFUtils.addFacesErrorMessage("Advance Recovery should be within Advance Percentage");
//                        advanceRec.setValue("");
//                        AdfFacesContext.getCurrentInstance().addPartialTarget(advanceRec);
//                        contractRow.setAttribute("AdvRecoveryAmount", "");
////                        advRec.setValue("");
//                        AdfFacesContext.getCurrentInstance().addPartialTarget(advRec);
//                    }
            }else{
                JSFUtils.addFacesErrorMessage("Enter percentage is greater than 100. Please check");
                advanceRec.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(advanceRec);
                advRec.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(advRec);
            }



        }else{
            double liqPer=liquidated.getValue()==null?0:Double.parseDouble(liquidated.getValue().toString());
//            double penalPer=penalty.getValue()==null?0:Double.parseDouble(penalty.getValue().toString());
            double penalPer=0;
            double retenPer=retention.getValue()==null?0:Double.parseDouble(retention.getValue().toString());
            double advanPer=advance.getValue()==null?0:Double.parseDouble(advance.getValue().toString());
            double materailPer=materials.getValue()==null?0:Double.parseDouble(materials.getValue().toString());

            double sum=liqPer+penalPer+retenPer+advanPer+materailPer;
            if(sum<=100){
                double advanceRecPer=valueChangeEvent.getNewValue()==null?0:Double.parseDouble(valueChangeEvent.getNewValue().toString());
                //System.err.println("advanPer--"+advanPer);
                //System.err.println("advanPer Reco--"+advanceRecPer);
//                    if(advanceRecPer<=advanPer){
                        String val = valueChangeEvent.getNewValue()==null?"0":valueChangeEvent.getNewValue().toString();
                        String tot = "TotalContractSum";
                        String setAtt = "AdvRecoveryAmount";
                        UIComponent id = advRec;
                        calcPerc(val, tot, setAtt, id);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(advRec);
//                    }else{
//                        JSFUtils.addFacesErrorMessage("Advance Recovery should be within Advance Percentage");
//                        advanceRec.setValue("");
//                        AdfFacesContext.getCurrentInstance().addPartialTarget(advanceRec);
//                        contractRow.setAttribute("AdvRecoveryAmount", "");
////                        advRec.setValue("");
//                        AdfFacesContext.getCurrentInstance().addPartialTarget(advRec);
//                    }
            }else{
                JSFUtils.addFacesErrorMessage("Enter percentage is greater than 100. Please check");
                advanceRec.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(advanceRec);
                contractRow.setAttribute("AdvRecoveryAmount", "");
                AdfFacesContext.getCurrentInstance().addPartialTarget(advRec);
            }

        }
    }
 */

    /*******Material percentage*******/

    //    public void matVCL(ValueChangeEvent valueChangeEvent) {
    //        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
    //        if (valueChangeEvent.getNewValue() != null) {
    //            materialsRec.setDisabled(Boolean.FALSE);
    //            materialsRec.setRequired(Boolean.TRUE);
    //            AdfFacesContext.getCurrentInstance().addPartialTarget(materialsRec);
    //            //          double liqPer=liquidated.getValue()==null?0:Double.parseDouble(liquidated.getValue().toString());
    //            //          double penalPer=penalty.getValue()==null?0:Double.parseDouble(penalty.getValue().toString());
    //            double advanPer =
    //                advance.getValue() == null ? 0 : Double.parseDouble(advance.getValue().toString());
    //            double materailPer =
    //                valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
    //            double retenPer =
    //                retention.getValue() == null ? 0 : Double.parseDouble(retention.getValue().toString());
    //            double sum = advanPer + materailPer + retenPer;
    //
    //            if (sum <= 100) {
    //                String val =
    //                    valueChangeEvent.getNewValue() == null ? "0" : valueChangeEvent.getNewValue().toString();
    //                String tot = "ContractAmount";
    //                String setAtt = "MaterialOnSite";
    //                UIComponent id = mat;
    //                calcPerc(val, tot, setAtt, id);
    //                AdfFacesContext.getCurrentInstance().addPartialTarget(mat);
    //            } else {
    //                JSFUtils.addFacesErrorMessage("Enter percentage is greater than 100. Please check");
    //                materials.setValue("");
    //                AdfFacesContext.getCurrentInstance().addPartialTarget(materials);
    //                //                mat.setValue("");
    //                contractRow.setAttribute("MaterialOnSite", "");
    //                AdfFacesContext.getCurrentInstance().addPartialTarget(mat);
    //            }
    //
    //        } else {
    //            //            double liqPer=liquidated.getValue()==null?0:Double.parseDouble(liquidated.getValue().toString());
    //            //            double penalPer=penalty.getValue()==null?0:Double.parseDouble(penalty.getValue().toString());
    //            materialsRec.setDisabled(Boolean.TRUE);
    //            materialsRec.setRequired(Boolean.FALSE);
    //            AdfFacesContext.getCurrentInstance().addPartialTarget(materialsRec);
    //            double advanPer =
    //                advance.getValue() == null ? 0 : Double.parseDouble(advance.getValue().toString());
    //            double materailPer =
    //                valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
    //            double retenPer =
    //                retention.getValue() == null ? 0 : Double.parseDouble(retention.getValue().toString());
    //            double sum = advanPer + materailPer + retenPer;
    //
    //            if (sum <= 100) {
    //                String val =
    //                    valueChangeEvent.getNewValue() == null ? "0" : valueChangeEvent.getNewValue().toString();
    //                String tot = "ContractAmount";
    //                String setAtt = "MaterialOnSite";
    //                UIComponent id = mat;
    //                calcPerc(val, tot, setAtt, id);
    //                AdfFacesContext.getCurrentInstance().addPartialTarget(mat);
    //            } else {
    //                JSFUtils.addFacesErrorMessage("Enter percentage is greater than 100. Please check");
    //                materials.setValue("");
    //                AdfFacesContext.getCurrentInstance().addPartialTarget(materials);
    //                //                mat.setValue("");
    //                contractRow.setAttribute("MaterialOnSite", "");
    //                AdfFacesContext.getCurrentInstance().addPartialTarget(mat);
    //            }
    //
    //
    //        }
    //    }

    /***@material Recovery**/
    /*
    public void matRecVCL(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if(valueChangeEvent.getNewValue()!=null){
            double liqPer=liquidated.getValue()==null?0:Double.parseDouble(liquidated.getValue().toString());
//            double penalPer=penalty.getValue()==null?0:Double.parseDouble(penalty.getValue().toString());
            double penalPer=0;
            double retenPer=retention.getValue()==null?0:Double.parseDouble(retention.getValue().toString());
            double advanPer=advance.getValue()==null?0:Double.parseDouble(advance.getValue().toString());
            double materailPer=materials.getValue()==null?0:Double.parseDouble(materials.getValue().toString());

            double sum=liqPer+penalPer+retenPer+advanPer+materailPer;
            if(sum<=100){
                double materialsRecPer=valueChangeEvent.getNewValue()==null?0:Double.parseDouble(valueChangeEvent.getNewValue().toString());
                //System.err.println("--materailPer--"+materailPer);
                //System.err.println("--materialsRecPer--"+materialsRecPer);
                    if(materialsRecPer<=materailPer){
                        String val = valueChangeEvent.getNewValue()==null?"0":valueChangeEvent.getNewValue().toString();
                        String tot = "TotalContractSum";
                        String setAtt = "MaterialOnSiteRec";
                        UIComponent id = matRec;
                        calcPerc(val, tot, setAtt, id);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(matRec);
                    }else{
                        JSFUtils.addFacesErrorMessage("Materials on site Recovery be within Advance Percentage Materials on site");
                        materialsRec.setValue("");
                        AdfFacesContext.getCurrentInstance().addPartialTarget(materialsRec);
//                        matRec.setValue("");
                        contractRow.setAttribute("MaterialOnSiteRec", "");
                        AdfFacesContext.getCurrentInstance().addPartialTarget(matRec);
                    }
            }else{
                JSFUtils.addFacesErrorMessage("Enter percentage is greater than 100. Please check");
                materialsRec.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(materialsRec);
                contractRow.setAttribute("MaterialOnSiteRec", "");
                AdfFacesContext.getCurrentInstance().addPartialTarget(matRec);
            }

        }else{
            double liqPer=liquidated.getValue()==null?0:Double.parseDouble(liquidated.getValue().toString());
//            double penalPer=penalty.getValue()==null?0:Double.parseDouble(penalty.getValue().toString());
            double penalPer=0;
            double retenPer=retention.getValue()==null?0:Double.parseDouble(retention.getValue().toString());
            double advanPer=advance.getValue()==null?0:Double.parseDouble(advance.getValue().toString());
            double materailPer=materials.getValue()==null?0:Double.parseDouble(materials.getValue().toString());

            double sum=liqPer+penalPer+retenPer+advanPer+materailPer;
            if(sum<=100){
                double materialsRecPer=valueChangeEvent.getNewValue()==null?0:Double.parseDouble(valueChangeEvent.getNewValue().toString());
                //System.err.println("--materailPer--"+materailPer);
                //System.err.println("--materialsRecPer--"+materialsRecPer);
                    if(materialsRecPer<=materailPer){
                    String val = valueChangeEvent.getNewValue()==null?"0":valueChangeEvent.getNewValue().toString();
                        String tot = "TotalContractSum";
                        String setAtt = "MaterialOnSiteRec";
                        UIComponent id = matRec;
                        calcPerc(val, tot, setAtt, id);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(matRec);
                    }else{
                        JSFUtils.addFacesErrorMessage("Materials on site Recovery be within Advance Percentage Materials on site");
                        materialsRec.setValue("");
                        AdfFacesContext.getCurrentInstance().addPartialTarget(materialsRec);
//                        matRec.setValue("");
                        contractRow.setAttribute("MaterialOnSiteRec", "");
                        AdfFacesContext.getCurrentInstance().addPartialTarget(matRec);
                    }
            }else{
                JSFUtils.addFacesErrorMessage("Enter percentage is greater than 100. Please check");
                materialsRec.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(materialsRec);
                contractRow.setAttribute("MaterialOnSiteRec", "");;
                AdfFacesContext.getCurrentInstance().addPartialTarget(matRec);
            }

        }

    }
*/

    public void setCurrencyCodeId(RichInputListOfValues currencyCodeId) {
        this.currencyCodeId = currencyCodeId;
    }

    public RichInputListOfValues getCurrencyCodeId() {
        return currencyCodeId;
    }

    public void setConversionRate(RichSelectOneChoice conversionRate) {
        this.conversionRate = conversionRate;
    }

    public RichSelectOneChoice getConversionRate() {
        return conversionRate;
    }

    public void setConversionRateValue(RichInputText conversionRateValue) {
        this.conversionRateValue = conversionRateValue;
    }

    public RichInputText getConversionRateValue() {
        return conversionRateValue;
    }


    public void onChangeConversionType(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        //System.err.println("--OLD---" + valueChangeEvent.getOldValue());
        //System.err.println("--NEW---" + valueChangeEvent.getNewValue());
        if (valueChangeEvent.getNewValue() != null) {
            if (!(valueChangeEvent.getNewValue().toString().equalsIgnoreCase("User"))) {
                ViewObjectImpl vo = (ViewObjectImpl)glCurrencyVO;
                ViewCriteria vc =
                    vo.getViewCriteria("GLCurrencyCodeCalculation");
                vo.applyViewCriteria(vc);
                vo.setNamedWhereClauseParam("BV_FROM",
                                            contractRow.getAttribute("CurrencyCode"));
                vo.setNamedWhereClauseParam("BV_DATE",
                                            contractRow.getAttribute("ContractDate"));
                vo.setNamedWhereClauseParam("BV_Type",
                                            valueChangeEvent.getNewValue());
                vo.executeQuery();
                if (vo.getEstimatedRowCount() == 1) {
                    vo.first().getAttribute("ConversionRate");
                    //System.err.println("ConversionRate---" +
//                                       vo.first().getAttribute("ConversionRate"));
                    conversionRateValue.setDisabled(true);
                    contractRow.setAttribute("ConversionRate",
                                             vo.first().getAttribute("ConversionRate"));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(conversionRateValue);
                } else {
                    JSFUtils.addFacesErrorMessage("Conversion Rate is not define for Selected Currency");
                    conversionRate.setValue("");
                    AdfFacesContext.getCurrentInstance().addPartialTarget(conversionRate);
                    conversionRateValue.setDisabled(true);
                    conversionRateValue.setValue("");
                    AdfFacesContext.getCurrentInstance().addPartialTarget(conversionRateValue);
                }
            } else {
                conversionRateValue.setDisabled(false);
                conversionRateValue.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(conversionRateValue);
            }
        } else {

        }

    }

    public void onChangeCurrencyCode(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            if (valueChangeEvent.getNewValue().equals("AED")) {
                conversionRate.setDisabled(true);
                conversionRate.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(conversionRate);
                conversionRateValue.setDisabled(true);
                conversionRateValue.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(conversionRateValue);
            } else {
                conversionRate.setDisabled(false);
                conversionRate.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(conversionRate);
                conversionRateValue.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(conversionRateValue);
            }
        }
    }

    public void refreshSearchTable() {
        ViewCriteria vc = searchContract.createViewCriteria();
        ViewCriteriaRow vcr = vc.createViewCriteriaRow();
        vcr.setAttribute("ContractNum", "");
        vc.addRow(vcr);
        searchContract.applyViewCriteria(vc);
        searchContract.executeQuery();
        //System.err.println("---Refresh contract Search Table");
    }


    public void setDlpPeriodCategory(RichInputText dlpPeriodCategory) {
        this.dlpPeriodCategory = dlpPeriodCategory;
    }

    public RichInputText getDlpPeriodCategory() {
        return dlpPeriodCategory;
    }

    public void setDefectLiabEndDate(RichInputDate defectLiabEndDate) {
        this.defectLiabEndDate = defectLiabEndDate;
    }

    public RichInputDate getDefectLiabEndDate() {
        return defectLiabEndDate;
    }


    public void setDlpPeriodCategoryType(RichSelectOneChoice dlpPeriodCategoryType) {
        this.dlpPeriodCategoryType = dlpPeriodCategoryType;
    }

    public RichSelectOneChoice getDlpPeriodCategoryType() {
        return dlpPeriodCategoryType;
    }

    public static DateTime dateExtend(String type, long duration,
                                      DateTime endDate) throws ParseException {
        DateTime d = null;
        if (type.equalsIgnoreCase("Year")) {
            d = endDate.plusYears((int)duration).toDateTime();
            return d;
        } else if (type.equalsIgnoreCase("Month")) {
            d = endDate.plusMonths((int)duration).toDateTime();
            return d;
        } else {
            d = endDate.plusDays((int)duration).toDateTime();
            return d;
        }
    }

    // Type

    public void onChangeDlpPeriodCategory(ValueChangeEvent valueChangeEvent) throws Exception {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        //System.err.println("-OLD--" + valueChangeEvent.getOldValue());
        //System.err.println("-New--" + valueChangeEvent.getNewValue());
        //System.err.println("--DLPNumber---" + dlpPeriodCategory.getValue());
        if (contractVO.getCurrentRow().getAttribute("EndDate") != null ||
            contractVO.getCurrentRow().getAttribute("RevisedDate") != null) {
            if (valueChangeEvent.getNewValue() != "") {
                String dLPEndDate = null;
                String revdate = null;
                String rdate = null;
                String enddate = null;
                DateTimeFormatter dtf =
                    DateTimeFormat.forPattern("YYYY-MM-dd");
                long dlpNum =
                    dlpPeriodCategory.getValue() == null ? 0 : Long.parseLong(dlpPeriodCategory.getValue().toString());
                enddate =
                        contractVO.getCurrentRow().getAttribute("EndDate") == null ?
                        null :
                        contractVO.getCurrentRow().getAttribute("EndDate").toString();
                rdate =
                        contractVO.getCurrentRow().getAttribute("RevisedDate") ==
                        null ? null :
                        contractVO.getCurrentRow().getAttribute("RevisedDate").toString();

                if (contractVO.getCurrentRow().getAttribute("RevisedDate") ==
                    null) {
                    revdate =
                            contractVO.getCurrentRow().getAttribute("EndDate") ==
                            null ? null :
                            contractVO.getCurrentRow().getAttribute("EndDate").toString();
                } else {
                    revdate =
                            contractVO.getCurrentRow().getAttribute("RevisedDate") ==
                            null ? null :
                            contractVO.getCurrentRow().getAttribute("RevisedDate").toString();
                }

                String version =
                    contractVO.getCurrentRow().getAttribute("Version") ==
                    null ? "" :
                    contractVO.getCurrentRow().getAttribute("Version").toString();

                if (version.equals("0")) {
                    DateTime dtEndDate = dtf.parseDateTime(enddate);
                    dLPEndDate =
                            dtf.print(dateExtend((String)valueChangeEvent.getNewValue(),
                                                 dlpNum, dtEndDate));
                } else {
                    DateTime dtRevDate = dtf.parseDateTime(revdate);
                    dLPEndDate =
                            dtf.print(dateExtend((String)valueChangeEvent.getNewValue(),
                                                 dlpNum, dtRevDate));
                }

                //System.err.println("----------dplDate-----------" +
//                                   dLPEndDate);
                // String to Jbo Date
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date = df.parse(dLPEndDate);
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                oracle.jbo.domain.Date jboDate =
                    new oracle.jbo.domain.Date(sqlDate);
                //System.err.println("--Final--" + jboDate);
                defectLiabEndDate.setValue(jboDate);
                AdfFacesContext.getCurrentInstance().addPartialTarget(defectLiabEndDate);

            } else if (valueChangeEvent.getNewValue() == "") {
                defectLiabEndDate.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(defectLiabEndDate);
            }
        } else {
            JSFUtils.addFacesErrorMessage("Please Select Contract End Date/Contract Revised End Date in Contract Information Page");
            dlpPeriodCategory.setValue("");
            AdfFacesContext.getCurrentInstance().addPartialTarget(dlpPeriodCategory);
            dlpPeriodCategoryType.setValue("");
            AdfFacesContext.getCurrentInstance().addPartialTarget(dlpPeriodCategoryType);
        }

    }


    // Number

    public void onChangeDefectLiabPeriod(ValueChangeEvent valueChangeEvent) throws Exception {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        //System.err.println("--OLD--" + valueChangeEvent.getOldValue());
        //System.err.println("--NEW--" + valueChangeEvent.getNewValue());
        //System.err.println("--dlpPeriodCategoryType--" +
//                           dlpPeriodCategoryType.getValue());
        if (contractVO.getCurrentRow().getAttribute("EndDate") != null ||
            contractVO.getCurrentRow().getAttribute("RevisedDate") != null) {
            if (dlpPeriodCategoryType.getValue() != "" &&
                valueChangeEvent.getNewValue() != null) {
                String dLPEndDate = null;
                DateTimeFormatter dtf =
                    DateTimeFormat.forPattern("YYYY-MM-dd");
                String dlpType =
                    dlpPeriodCategoryType.getValue() == null ? "0" :
                    dlpPeriodCategoryType.getValue().toString();
                long dlpNum =
                    Long.parseLong(valueChangeEvent.getNewValue().toString());
                String enddate =
                    contractVO.getCurrentRow().getAttribute("EndDate") ==
                    null ? null :
                    contractVO.getCurrentRow().getAttribute("EndDate").toString();
                String revdate =
                    contractVO.getCurrentRow().getAttribute("RevisedDate") ==
                    null ? null :
                    contractVO.getCurrentRow().getAttribute("RevisedDate").toString();
                String version =
                    contractVO.getCurrentRow().getAttribute("Version") ==
                    null ? "" :
                    contractVO.getCurrentRow().getAttribute("Version").toString();
                if (version.equals("0")) {
                    DateTime dtEndDate = dtf.parseDateTime(enddate);
                    dLPEndDate =
                            dtf.print(dateExtend(dlpType, dlpNum, dtEndDate));
                } else {
                    DateTime dtRevDate = dtf.parseDateTime(revdate);
                    dLPEndDate =
                            dtf.print(dateExtend(dlpType, dlpNum, dtRevDate));
                }
                //System.err.println("----------dplDate-----------" +
//                                   dLPEndDate);
                // String to Jbo Date
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date = df.parse(dLPEndDate);
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                oracle.jbo.domain.Date jboDate =
                    new oracle.jbo.domain.Date(sqlDate);
                //System.err.println("--Final--" + jboDate);
                defectLiabEndDate.setValue(jboDate);
                AdfFacesContext.getCurrentInstance().addPartialTarget(defectLiabEndDate);
            } else if (valueChangeEvent.getNewValue() == null) {
                defectLiabEndDate.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(defectLiabEndDate);
            }
        } else {
            JSFUtils.addFacesErrorMessage("Please Select Contract End Date/Contract Revised End Date in Contract Information Page");
            dlpPeriodCategory.setValue("");
            AdfFacesContext.getCurrentInstance().addPartialTarget(dlpPeriodCategory);
            dlpPeriodCategoryType.setValue("");
            AdfFacesContext.getCurrentInstance().addPartialTarget(dlpPeriodCategoryType);
        }

    }


    public void setIf2(RichInputFile if2) {
        this.if2 = if2;
    }

    public RichInputFile getIf2() {
        return if2;
    }

    public void setIf3(RichInputFile if3) {
        this.if3 = if3;
    }

    public RichInputFile getIf3() {
        return if3;
    }

    public void onClickHrdAttach(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != null) {
            FileAttachment.UploadFileToDB((UploadedFile)valueChangeEvent.getNewValue(),
                                          contractHrdAttachVO);
            if2.setValue("");
            AdfFacesContext.getCurrentInstance().addPartialTarget(if2);
        }
    }

    public void onClickLneAttach(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != null) {
            FileAttachment.UploadFileToDB((UploadedFile)valueChangeEvent.getNewValue(),
                                          contractLnsAttachVO);
            if3.setValue("");
            AdfFacesContext.getCurrentInstance().addPartialTarget(if3);
        }
    }


    public void downloadAttachFile(FacesContext facesContext,
                                   OutputStream outputStream) {
        try {
            FileAttachment.downloadFileListener(facesContext, outputStream,
                                                contractHrdAttachVO);
        } catch (Exception e) {

        }
    }


    public void downloadContractLnsAttachFile(FacesContext facesContext,
                                              OutputStream outputStream) {
        try {
            FileAttachment.downloadFileListener(facesContext, outputStream,
                                                contractLnsAttachVO);
        } catch (Exception e) {

        }
    }


    public void setRetentionRelease2(RichInputText retentionRelease2) {
        this.retentionRelease2 = retentionRelease2;
    }

    public RichInputText getRetentionRelease2() {
        return retentionRelease2;
    }


    public void onChangeRelRet1(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            double ret =
                retention.getValue() == null ? 0 : Double.parseDouble(retention.getValue().toString());
            double ret1 =
                valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
            double ret2 =
                retentionRelease2.getValue() == null ? 0 : Double.parseDouble(retentionRelease2.getValue().toString());
            double sum = ret1 + ret2;
            if (sum <= ret) {

            } else {
                JSFUtils.addFacesErrorMessage("Enter Amount greater than Retention Percentage. Please check");
                retentionRelease.setValue(null);
                AdfFacesContext.getCurrentInstance().addPartialTarget(retentionRelease);

            }
        }
    }

    public void onChangeRelRet2(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            double ret =
                retention.getValue() == null ? 0 : Double.parseDouble(retention.getValue().toString());
            double ret1 =
                retentionRelease.getValue() == null ? 0 : Double.parseDouble(retentionRelease.getValue().toString());
            double ret2 =
                valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
            double sum = ret1 + ret2;
            if (sum <= ret) {

            } else {
                JSFUtils.addFacesErrorMessage("Enter Amount greater than Retention Percentage. Please check");
                retentionRelease2.setValue(null);
                AdfFacesContext.getCurrentInstance().addPartialTarget(retentionRelease2);
            }
        }
    }

    public void onClickSubmitForApproval(ActionEvent actionEvent) {
        try {
            if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
                String url =
                    ADFUtils.getFunctionDetails("BUY_CONTRACT", "WfProcessUrl");
                // "http://141.144.50.225/soa-infra/services/default/CertSellApproval/certsellapprovalprocess_client_ep?WSDL";
                SubmitForApproval app = new SubmitForApproval("", "", "");
                String payload = prepareApprovalPayload();
                String type =
                    "Contract"; // Certification // Application //Contract
                app.getAndPushOrder(payload, url, type);
            } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell")) {
                String url =
                    ADFUtils.getFunctionDetails("SELL_CONTRACT", "WfProcessUrl");
                // "http://141.144.50.225/soa-infra/services/default/CertSellApproval/certsellapprovalprocess_client_ep?WSDL";
                SubmitForApproval app = new SubmitForApproval("", "", "");
                String payload = prepareApprovalPayload();
                String type =
                    "Contract"; // Certification // Application //Contract
                app.getAndPushOrder(payload, url, type);
            }
        } catch (Exception e) {
            //System.err.println("====EXE===APP====" + e.toString());
        }
    }


    public String prepareApprovalPayload() {
        String xml = "";
        ViewObject headerVO =
            ADFUtils.findIterator("XxscContractHeadersVO1Iterator").getViewObject();
        xml += "<soapenv:Body>\n" +
                "      <app:contract>\n" +
                "         <app:contHeader>\n" +
                "            <app:functionid>";
        xml += headerVO.getCurrentRow().getAttribute("FuncId");
        xml += "</app:functionid>\n" +
                "            <app:contractHeaderId>";
        xml += headerVO.getCurrentRow().getAttribute("ContHeaderId");
        xml += "</app:contractHeaderId>\n" +
                "            <app:version>";
        xml += headerVO.getCurrentRow().getAttribute("Version");
        xml += "</app:version>\n" +
                "           </app:contHeader>\n" +
                "         </app:contract>\n" +
                "   </soapenv:Body>";
        return xml;
    }

    public void DeliveryPlanfileDownload(FacesContext facesContext,
                                         OutputStream outputStream) throws FileNotFoundException,
                                                                           IOException,
                                                                           ParseException {

        File filed = null;
        String cname =
            contractVO.getCurrentRow().getAttribute("ContractName") == null ?
            "LineDetail" :
            contractVO.getCurrentRow().getAttribute("ContractName").toString();
        try {

            filed =
                    new File(DeliveryPlanData.downlaodExcel(cname) + "/" + cname +
                             ".xls");
        } catch (Exception e) {
            //System.err.println("Exe==>" + e);
        }
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

    public void onClickDeliveryPlan(ActionEvent actionEvent) {
        ViewObject delPlanVO =
            ADFUtils.findIterator("DeliveryPlanPivot_ROVO1Iterator").getViewObject();
        delPlanVO.setNamedWhereClauseParam("p_con_hdr_id",
                                           contractVO.getCurrentRow().getAttribute("ContHeaderId"));
        delPlanVO.setNamedWhereClauseParam("ver",
                                           contractVO.getCurrentRow().getAttribute("Version"));
        delPlanVO.executeQuery();
        RichPopup p1 = (RichPopup)JSFUtils.findComponentInRoot("p3");
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        p1.show(hints);
        AdfFacesContext.getCurrentInstance().addPartialTarget(p1);
    }

    public void onClickSaveContractLine(ActionEvent actionEvent) {
        try {
            ADFUtils.findOperation("Commit").execute();
        } catch (Exception e) {
            //System.err.println("===" + e.toString());
        }
    }

    public void setPtt1(UIPivotTable ptt1) {
        this.ptt1 = ptt1;
    }

    public UIPivotTable getPtt1() {
        return ptt1;
    }

    public void setContractAmount(RichOutputText contractAmount) {
        this.contractAmount = contractAmount;
    }

    public RichOutputText getContractAmount() {
        return contractAmount;
    }

    public void setContVariationAmount(RichOutputText contVariationAmount) {
        this.contVariationAmount = contVariationAmount;
    }

    public RichOutputText getContVariationAmount() {
        return contVariationAmount;
    }

    public void setContRevisedAmount(RichOutputText contRevisedAmount) {
        this.contRevisedAmount = contRevisedAmount;
    }

    public RichOutputText getContRevisedAmount() {
        return contRevisedAmount;
    }

    public void setContTotalSum(RichOutputText contTotalSum) {
        this.contTotalSum = contTotalSum;
    }

    public RichOutputText getContTotalSum() {
        return contTotalSum;
    }

    public void onChangeCustName(ValueChangeEvent vce) {
        //        vce.getComponent().processUpdates(FacesContext.getCurrentInstance());
        //        if (vce.getNewValue() != null) {
        //            ViewObject hdrVo =
        //                ADFUtils.findIterator("XxscContractHeadersVO1Iterator").getViewObject();
        //            //System.err.println("=====ID===="+hdrVo.getCurrentRow().getAttribute("CustBillToAcctId"));
        //            //System.err.println("=====NAME===="+vce.getNewValue());
        //            hdrVo.getCurrentRow().setAttribute("CustShipToAcctId",
        //                                               hdrVo.getCurrentRow().getAttribute("CustBillToAcctId"));
        //            hdrVo.getCurrentRow().setAttribute("CustomerNameShipto_Trans",vce.getNewValue());
        //
        //        }
    }

    public void onClickSubmitContract(ActionEvent actionEvent) {
        try {
            ViewObject hdrVO =
                ADFUtils.findIterator("XxscContractHeadersVO1Iterator").getViewObject();
            if (hdrVO.getCurrentRow() != null) {
                if (hdrVO.getCurrentRow().getAttribute("ContractStatus") !=
                    null) {
                    if (!("UNDER_AMENDMENT".equals(hdrVO.getCurrentRow().getAttribute("ContractStatus")))) {
                        hdrVO.getCurrentRow().setAttribute("ContractIntStatus",
                                                           "READY_TO_INTERFACE");
                    } else if ("UNDER_AMENDMENT".equals(hdrVO.getCurrentRow().getAttribute("ContractStatus"))) {
                        hdrVO.getCurrentRow().setAttribute("ContractIntStatus",
                                                           "READY_TO_UPDATE");
                    }
                }
            }
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Contract Submitted Successfully.");
        } catch (Exception e) {
            //System.err.println("====EXE==" + e.toString());
        }
    }

    public void onClickSellRefresh(ActionEvent actionEvent) {
        try {
            RowSetIterator rs = contractLineVO.createRowSetIterator(null);
            double totalLineAmount = 0;
            double VariationLineAmt = 0;
            double Ecptotalamt = 0;
            while (rs.hasNext()) {
                contractLineRow = rs.next();
                double orgLineAmount =
                    contractLineRow.getAttribute("EcpTotalAmount") == null ?
                    0 :
                    Double.parseDouble(contractLineRow.getAttribute("EcpTotalAmount").toString());
                double Ecptotal =
                    contractLineRow.getAttribute("EcpTotalAmount") == null ?
                    0 :
                    Double.parseDouble(contractLineRow.getAttribute("EcpTotalAmount").toString());
                double VariationAmt =
                    contractLineRow.getAttribute("OrigAmount") == null ? 0 :
                    Double.parseDouble(contractLineRow.getAttribute("OrigAmount").toString());
                String Variation =
                    contractLineRow.getAttribute("Variation") != null ?
                    contractLineRow.getAttribute("Variation").toString() :
                    "Original";
                //System.err.println("Variation==>" + Variation);
                Ecptotalamt += Ecptotal;
                if (Variation.equalsIgnoreCase("Original")) {
                    totalLineAmount += orgLineAmount;
                    // //System.err.println("==totalLineAmount==" + totalLineAmount);
                    // } else if (!(Variation.equalsIgnoreCase("VAR_UNAPP"))) {
                } else if (!(Variation.startsWith("UAVO"))) {
                    VariationLineAmt += VariationAmt;
                    //                //System.err.println("==VariationLineAmount==" +
                    //                                   VariationLineAmt);
                }
            }
            // set Contract amount
            contractVO.getCurrentRow().setAttribute("ContractAmount",
                                                    new BigDecimal(totalLineAmount));
            AdfFacesContext.getCurrentInstance().addPartialTarget(contractAmount);
            contractVO.getCurrentRow().setAttribute("TotalContractSum",
                                                    new BigDecimal(totalLineAmount));
            contractVO.getCurrentRow().setAttribute("VariationAmount",
                                                    new BigDecimal(VariationLineAmt));
            AdfFacesContext.getCurrentInstance().addPartialTarget(var_amt);
            BigDecimal revAmt =
                new BigDecimal(totalLineAmount + VariationLineAmt);
            contractVO.getCurrentRow().setAttribute("RevisedContractAmount",
                                                    revAmt);

            String val =
                contractVO.getCurrentRow().getAttribute("RetenPercent") ==
                null ? "0" :
                contractVO.getCurrentRow().getAttribute("RetenPercent").toString();
            String tot = "RevisedContractAmount";
            String setAtt = "RetenAmount";
            calcLnePerc(val, tot, setAtt);
            contractVO.getCurrentRow().setAttribute("EcpTotalAmount",
                                                    new BigDecimal(Ecptotalamt));
            AdfFacesContext.getCurrentInstance().addPartialTarget(ecpTotAmt);
            ViewObject lineVO =
                ADFUtils.findIterator("XxscContractLinesVO1Iterator").getViewObject();
            lineVO.executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(contractLineTable);
        } catch (Exception e) {
            JSFUtils.addFacesErrorMessage("Error : " + e.toString());
        }
    }


    public void calcLnePerc(String val, String tot, String setAtt) {
        double liqP = Double.parseDouble(val);
        double totCon =
            contractVO.getCurrentRow().getAttribute(tot) == null ? 0 :
            Double.parseDouble(contractVO.getCurrentRow().getAttribute(tot).toString());
        double totAmt = (liqP * totCon) / 100;
        contractVO.getCurrentRow().setAttribute(setAtt,
                                                dfNum.format(new BigDecimal(totAmt)));
    }


    public void ContractLineTemplate(FacesContext facesContext,
                                     OutputStream outputStream) {
        de.sellContractLineTemplate(facesContext, outputStream);
    }

    //**Approval Process

    String submitPkg = "xxfnd_util_pkg.submit_for_approval";
    String tableName = "XXSC_CONTRACT_HEADERS";
    String app_status_column = "APPROVAL_STATUS";
    String pk_column = "CONT_HEADER_ID";
    String responsePkg = "xxfnd_util_pkg.update_response";
    //    String response="Approved";
    //    String ar_status  ="A";
    String fwd_to = "0";
//    String submitMailPkg = "xxfnd_util_pkg.submit_mail";

    public boolean getApprovalUser() {
        boolean flag = false;
        String flowWith =
            contractRow.getAttribute("FlowWith") == null ? "" : contractRow.getAttribute("FlowWith").toString();
        String LoginUser =
            ADFContext.getCurrent().getSessionScope().get("userName") == null ?
            "0" :
            ADFContext.getCurrent().getSessionScope().get("userName").toString();
        ViewObject userVO =
            ADFUtils.findIterator("XxscUserAccess1Iterator").getViewObject();
        userVO.setNamedWhereClauseParam("BV_USER_NAME", LoginUser);
        userVO.executeQuery();
        if (userVO.getEstimatedRowCount() != 0) {
            String loginID =
                userVO.first().getAttribute("UserId") == null ? "0" :
                userVO.first().getAttribute("UserId").toString();
            //System.err.println("flowWith-->>" + flowWith + "loginID-->" +
//                               loginID);
            if (flowWith.equalsIgnoreCase(loginID)) {
                flag = true;
            } else {
                flag = false;
            }
        } else {
            flag = false;
        }
        //System.err.println("Flag" + flag);
        return flag;
    }

    public String onClickApprove() throws SQLException {
        String pageRedirect = null;
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
            String approveDesc =
                approValue.getValue() == null ? "approved" : approValue.getValue().toString();
            String func_id =
                contractRow.getAttribute("FuncId") == null ? "" : contractRow.getAttribute("FuncId").toString();
            String ref_id =
                contractRow.getAttribute("ContHeaderId") == null ? "" :
                contractRow.getAttribute("ContHeaderId").toString();
            String level_no =
                contractRow.getAttribute("FlowLevel") == null ? "" :
                contractRow.getAttribute("FlowLevel").toString();
            String appr_id =
                contractRow.getAttribute("FlowWith") == null ? "" :
                contractRow.getAttribute("FlowWith").toString();
            String user_grp =
                contractRow.getAttribute("UserGrpId") == null ? "" :
                contractRow.getAttribute("UserGrpId").toString();
            String flag =
                ADFApproval.invokeResponsePkg(responsePkg, func_id, user_grp,
                                              ref_id, level_no, appr_id,
                                              approveDesc, "A", fwd_to,
                                              tableName, app_status_column,
                                              pk_column);
            if (flag.equalsIgnoreCase("Success")) {
                if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
                    JSFUtils.addFacesInformationMessage("Buy Contract Approved Successfully");
                    pageRedirect = "save";
                } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell")) {
                    JSFUtils.addFacesInformationMessage("Sell Contract Approved Successfully");
                    pageRedirect = "save";
                }
            } else {
                JSFUtils.addFacesErrorMessage("Approval Process Failed. Error:" +
                                              flag);
                pageRedirect = null;
            }
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell")) {
            String approveDesc =
                approValue.getValue() == null ? "approved" : approValue.getValue().toString();
            String func_id =
                contractRow.getAttribute("FuncId") == null ? "" : contractRow.getAttribute("FuncId").toString();
            String ref_id =
                contractRow.getAttribute("ContHeaderId") == null ? "" :
                contractRow.getAttribute("ContHeaderId").toString();
            String level_no =
                contractRow.getAttribute("FlowLevel") == null ? "" :
                contractRow.getAttribute("FlowLevel").toString();
            String appr_id =
                contractRow.getAttribute("FlowWith") == null ? "" :
                contractRow.getAttribute("FlowWith").toString();
            String user_grp =
                contractRow.getAttribute("UserGrpId") == null ? "" :
                contractRow.getAttribute("UserGrpId").toString();
            String flag =
                ADFApproval.invokeResponsePkg(responsePkg, func_id, user_grp,
                                              ref_id, level_no, appr_id,
                                              approveDesc, "A", fwd_to,
                                              tableName, app_status_column,
                                              pk_column);
            if (flag.equalsIgnoreCase("Success")) {
                if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
                    JSFUtils.addFacesInformationMessage("Buy Contract Approved Successfully");
                    pageRedirect = "save";
                } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell")) {
                    JSFUtils.addFacesInformationMessage("Sell Contract Approved Successfully");
                    pageRedirect = "save";
                }
            } else {
                JSFUtils.addFacesErrorMessage("Approval Process Failed. Error:" +
                                              flag);
                pageRedirect = null;
            }
        }


        return pageRedirect;
    }

    public String onClickReject() throws SQLException {
        String pageRedirect = null;
        if (rejectValue.getValue() != null) {
            if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
                String func_id =
                    contractRow.getAttribute("FuncId") == null ? "" :
                    contractRow.getAttribute("FuncId").toString();
                String ref_id =
                    contractRow.getAttribute("ContHeaderId") == null ? "" :
                    contractRow.getAttribute("ContHeaderId").toString();
                String level_no =
                    contractRow.getAttribute("FlowLevel") == null ? "" :
                    contractRow.getAttribute("FlowLevel").toString();
                String appr_id =
                    contractRow.getAttribute("FlowWith") == null ? "" :
                    contractRow.getAttribute("FlowWith").toString();
                String user_grp =
                    contractRow.getAttribute("UserGrpId") == null ? "" :
                    contractRow.getAttribute("UserGrpId").toString();
                String flag =
                    ADFApproval.invokeResponsePkg(responsePkg, func_id,
                                                  user_grp, ref_id, level_no,
                                                  appr_id,
                                                  rejectValue.getValue().toString(),
                                                  "R", fwd_to, tableName,
                                                  app_status_column,
                                                  pk_column);
                if (flag.equalsIgnoreCase("Success")) {
                    if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
                        JSFUtils.addFacesErrorMessage("Buy Contract Rejected");
                        pageRedirect = "save";
                    } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell")) {
                        JSFUtils.addFacesErrorMessage("Sell Contract Rejected");
                        pageRedirect = "save";
                    }
                } else {
                    JSFUtils.addFacesErrorMessage("Rejection Process Failed. Error:" +
                                                  flag);
                    pageRedirect = null;
                }
            } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell")) {
                String func_id =
                    contractRow.getAttribute("FuncId") == null ? "" :
                    contractRow.getAttribute("FuncId").toString();
                String ref_id =
                    contractRow.getAttribute("ContHeaderId") == null ? "" :
                    contractRow.getAttribute("ContHeaderId").toString();
                String level_no =
                    contractRow.getAttribute("FlowLevel") == null ? "" :
                    contractRow.getAttribute("FlowLevel").toString();
                String appr_id =
                    contractRow.getAttribute("FlowWith") == null ? "" :
                    contractRow.getAttribute("FlowWith").toString();
                String user_grp =
                    contractRow.getAttribute("UserGrpId") == null ? "" :
                    contractRow.getAttribute("UserGrpId").toString();
                String flag =
                    ADFApproval.invokeResponsePkg(responsePkg, func_id,
                                                  user_grp, ref_id, level_no,
                                                  appr_id,
                                                  rejectValue.getValue().toString(),
                                                  "R", fwd_to, tableName,
                                                  app_status_column,
                                                  pk_column);
                if (flag.equalsIgnoreCase("Success")) {
                    if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
                        JSFUtils.addFacesErrorMessage("Buy Contract Rejected");
                        pageRedirect = "save";
                    } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell")) {
                        JSFUtils.addFacesErrorMessage("Sell Contract Rejected");
                        pageRedirect = "save";
                    }
                } else {
                    JSFUtils.addFacesErrorMessage("Rejection Process Failed. Error:" +
                                                  flag);
                    pageRedirect = null;
                }
            }

        } else {
            JSFUtils.addFacesErrorMessage("Please Enter Rejection Reason");
            pageRedirect = null;
        }

        return pageRedirect;
    }

    public String onSubmit() throws SQLException, MalformedURLException,
                                    IOException {
        String pageRedirect = null;
        String page = onClickSaveGaurInfo();
        if (page.equalsIgnoreCase("save")) {

            if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
                // Buy
                String func_id =
                    contractRow.getAttribute("FuncId") == null ? "0" :
                    contractRow.getAttribute("FuncId").toString();
                String ref_id =
                    contractRow.getAttribute("ContHeaderId") == null ? "0" :
                    contractRow.getAttribute("ContHeaderId").toString();
                String level_no =
                    contractRow.getAttribute("FlowLevel") == null ? "0" :
                    contractRow.getAttribute("FlowLevel").toString();
                String OrgId =
                    contractRow.getAttribute("OrgId") == null ? "0" :
                    contractRow.getAttribute("OrgId").toString();
                String projectId =
                    contractRow.getAttribute("ProjectId") == null ? "0" :
                    contractRow.getAttribute("ProjectId").toString();
                String flag =
                    ADFApproval.invokeSubmitPkg(submitPkg, func_id, ref_id,
                                                level_no, tableName,
                                                app_status_column, pk_column,
                                                OrgId, projectId);
                if (flag.equalsIgnoreCase("Success")) {
                    String flowWith =
                        ADFContext.getCurrent().getSessionScope().get("flow_with") ==
                        null ? "0" :
                        ADFContext.getCurrent().getSessionScope().get("flow_with").toString();
                    ViewObject ApproveMailVO =
                        ADFUtils.findIterator("XxscHeadDetailROVO1Iterator").getViewObject();
                    ApproveMailVO.setNamedWhereClauseParam("BV_USER_ID",
                                                           flowWith);
                    ApproveMailVO.executeQuery();
                    if (ApproveMailVO.getEstimatedRowCount() != 0) {
                        String to =
                            ApproveMailVO.first().getAttribute("UserName") ==
                            null ? "sdl@Naresco.com" :
                            ApproveMailVO.first().getAttribute("UserName").toString();
                        String LoginUser =
                            ADFContext.getCurrent().getSessionScope().get("userName") ==
                            null ? "0" :
                            ADFContext.getCurrent().getSessionScope().get("userName").toString();
                        //                    String htmlBody= MailTemplates.submit("Contract", contractRow.getAttribute("ContractNum").toString(), LoginUser);
                        //                    String subject="Mail Notification";
                        //                    MailServices.sendNotification("dineshkumar.p@4iapps.com,arunachalam.t@4iapps.com,sundarrajan.v@4iapps.com,mahalingam.m@4iapps.com", fromMail, null, htmlBody, subject);
//                        ADFApproval.submitMailPkg(LoginUser, to, "Contract",
//                                                  contractRow.getAttribute("ContractNum").toString(),
//                                                  LoginUser);
                        if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
                            refreshSearchTable();
                            JSFUtils.addFacesInformationMessage("Buy Contract Information Saved Successfully and Submit For Approval");
                            pageRedirect = "save";
                        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell")) {
                            refreshSearchTable();
                            JSFUtils.addFacesInformationMessage("Sell Contract Information Saved Successfully and Submit For Approval");
                            pageRedirect = "save";
                        }
                    } else {
                        JSFUtils.addFacesErrorMessage("Mail Notification Failed");
                    }

                } else {
                    refreshSearchTable();
                    JSFUtils.addFacesErrorMessage("Error in Submit For Approval. Error:" +
                                                  flag);
                    pageRedirect = null;
                }

            } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell")) {
                // Sell
                String func_id =
                    contractRow.getAttribute("FuncId") == null ? "0" :
                    contractRow.getAttribute("FuncId").toString();
                String ref_id =
                    contractRow.getAttribute("ContHeaderId") == null ? "0" :
                    contractRow.getAttribute("ContHeaderId").toString();
                String level_no =
                    contractRow.getAttribute("FlowLevel") == null ? "0" :
                    contractRow.getAttribute("FlowLevel").toString();
                String OrgId =
                    contractRow.getAttribute("OrgId") == null ? "0" :
                    contractRow.getAttribute("OrgId").toString();
                String projectId = null;
                String flag =
                    ADFApproval.invokeSubmitPkg(submitPkg, func_id, ref_id,
                                                level_no, tableName,
                                                app_status_column, pk_column,
                                                OrgId, projectId);
                if (flag.equalsIgnoreCase("Success")) {
                    String flowWith =
                        ADFContext.getCurrent().getSessionScope().get("flow_with") ==
                        null ? "0" :
                        ADFContext.getCurrent().getSessionScope().get("flow_with").toString();
                    ViewObject ApproveMailVO =
                        ADFUtils.findIterator("XxscHeadDetailROVO1Iterator").getViewObject();
                    ApproveMailVO.setNamedWhereClauseParam("BV_USER_ID",
                                                           flowWith);
                    ApproveMailVO.executeQuery();
                    if (ApproveMailVO.getEstimatedRowCount() != 0) {
                        String to =
                            ApproveMailVO.first().getAttribute("UserName") ==
                            null ? "sdl@Naresco.com" :
                            ApproveMailVO.first().getAttribute("UserName").toString();
                        String LoginUser =
                            ADFContext.getCurrent().getSessionScope().get("userName") ==
                            null ? "0" :
                            ADFContext.getCurrent().getSessionScope().get("userName").toString();
                        //                    String htmlBody= MailTemplates.submit("Contract", contractRow.getAttribute("ContractNum").toString(), LoginUser);
                        //                    String subject="Mail Notification";
                        //                    MailServices.sendNotification("dineshkumar.p@4iapps.com,arunachalam.t@4iapps.com,sundarrajan.v@4iapps.com,mahalingam.m@4iapps.com", fromMail, null, htmlBody, subject);
//                        ADFApproval.submitMailPkg(LoginUser, to, "Contract",
//                                                  contractRow.getAttribute("ContractNum").toString(),
//                                                  LoginUser);
                        if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
                            refreshSearchTable();
                            JSFUtils.addFacesInformationMessage("Buy Contract Information Saved Successfully and Submit For Approval");
                            pageRedirect = "save";
                        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell")) {
                            refreshSearchTable();
                            JSFUtils.addFacesInformationMessage("Sell Contract Information Saved Successfully and Submit For Approval");
                            pageRedirect = "save";
                        }
                    } else {
                        JSFUtils.addFacesErrorMessage("Mail Notification Failed");
                    }

                } else {
                    refreshSearchTable();
                    JSFUtils.addFacesErrorMessage("Error in Submit For Approval. Error:" +
                                                  flag);
                    pageRedirect = null;
                }
            }
        }
        return pageRedirect;
    }

    public void setRejectValue(RichInputText rejectValue) {
        this.rejectValue = rejectValue;
    }

    public RichInputText getRejectValue() {
        return rejectValue;
    }

    public void setP3(RichPopup p3) {
        this.p3 = p3;
    }

    public RichPopup getP3() {
        return p3;
    }

    public void onRejectCancel(ActionEvent actionEvent) {
        this.p3.cancel();
    }

    public void setP4(RichPopup p4) {
        this.p4 = p4;
    }

    public RichPopup getP4() {
        return p4;
    }

    public void setApproValue(RichInputText approValue) {
        this.approValue = approValue;
    }

    public RichInputText getApproValue() {
        return approValue;
    }

    public void onClickAppCancel(ActionEvent actionEvent) {
        this.getP4().cancel();
    }

    public void setEcpTotalAmount(RichInputText ecpTotalAmount) {
        this.ecpTotalAmount = ecpTotalAmount;
    }

    public RichInputText getEcpTotalAmount() {
        return ecpTotalAmount;
    }
    DecimalFormat df = new DecimalFormat(".##");

    public void onChangeECPPerce(ValueChangeEvent valueChangeEvent) throws SQLException {
        if (valueChangeEvent.getNewValue() != null) {
            double orgAmt =
                contractLineRow.getAttribute("OrigAmount") == null ? 0 :
                Double.parseDouble(contractLineRow.getAttribute("OrigAmount").toString());
            double perVal =
                valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
            double ecpAmt = (orgAmt * perVal / 100);
            contractLineRow.setAttribute("EcpTotalAmount", df.format(ecpAmt));
            AdfFacesContext.getCurrentInstance().addPartialTarget(ecpTotalAmount);

            // Iterator Contract Line Amount
            //            RowSetIterator rs = contractLineVO.createRowSetIterator(null);
            //            double totalECPAmount = 0;
            //            while (rs.hasNext()) {
            //                contractLineRow = rs.next();
            //                double ecpLineAmount =
            //                    contractLineRow.getAttribute("EcpTotalAmount") == null ?
            //                    0 :
            //                    Double.parseDouble(contractLineRow.getAttribute("EcpTotalAmount").toString());
            //                totalECPAmount += ecpLineAmount;
            //                //System.err.println("==totalECPAmount==" + totalECPAmount);
            //            }
            // set EcpTotalAmount
            //
            //            String epc=Double.toString(totalECPAmount);
            //            oracle.jbo.domain.Number epcAmt = new oracle.jbo.domain.Number(epc.toString());
            //            contractVO.getCurrentRow().setAttribute("EcpTotalAmount",
            //                                                    df.format(totalECPAmount));
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(ecpTotAmt);
        } else {
            double orgAmt =
                contractLineRow.getAttribute("OrigAmount") == null ? 0 :
                Double.parseDouble(contractLineRow.getAttribute("OrigAmount").toString());
            double perVal = 0;
            double ecpAmt = (orgAmt * perVal / 100);
            contractLineRow.setAttribute("EcpTotalAmount", df.format(ecpAmt));
            AdfFacesContext.getCurrentInstance().addPartialTarget(ecpTotalAmount);

            // Iterator Contract Line Amount
            //            RowSetIterator rs = contractLineVO.createRowSetIterator(null);
            //            double totalECPAmount = 0;
            //            while (rs.hasNext()) {
            //                contractLineRow = rs.next();
            //                double ecpLineAmount =
            //                    contractLineRow.getAttribute("EcpTotalAmount") == null ?
            //                    0 :
            //                    Double.parseDouble(contractLineRow.getAttribute("EcpTotalAmount").toString());
            //                totalECPAmount += ecpLineAmount;
            //                //System.err.println("==totalECPAmount==" + totalECPAmount);
            //            }
            // set EcpTotalAmount

            //            contractVO.getCurrentRow().setAttribute("EcpTotalAmount",
            //                                                    df.format(totalECPAmount));
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(ecpTotAmt);
        }
    }

    public void setEcpTotAmt(RichOutputText ecpTotAmt) {
        this.ecpTotAmt = ecpTotAmt;
    }

    public RichOutputText getEcpTotAmt() {
        return ecpTotAmt;
    }

    public void setCl1(RichCommandImageLink cl1) {
        this.cl1 = cl1;
    }

    public RichCommandImageLink getCl1() {
        return cl1;
    }

    public void setCb9(RichCommandButton cb9) {
        this.cb9 = cb9;
    }

    public RichCommandButton getCb9() {
        return cb9;
    }

    public void setCb8(RichCommandButton cb8) {
        this.cb8 = cb8;
    }

    public RichCommandButton getCb8() {
        return cb8;
    }

    public void onClickAmendment(ActionEvent actionEvent) {
        try {
            if ("S".equalsIgnoreCase(invokeAmend())) {
                // Add Button
                cl1.setDisabled(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(cl1);
                // Excel template
                cb9.setDisabled(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(cb9);
                // Upload
                if1.setDisabled(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(if1);
                // save
                cb8.setDisabled(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(cb8);
                contractVO.getCurrentRow().setAttribute("ContractStatus",
                                                        "UNDER_AMENDMENT");
                ADFUtils.findOperation("Commit").execute();
                JSFUtils.addFacesInformationMessage("Contract is Under Amendment now.");
            } else if ("E".equalsIgnoreCase(invokeAmend())) {
                JSFUtils.addFacesErrorMessage("Contract Status should be Active.Please check it.");
            }
        } catch (Exception e) {
            JSFUtils.addFacesErrorMessage(e.toString());
        }
    }


    public String invokeAmend() {
        String retVal = "N";
        try {
            ContractUnderAmend con = new ContractUnderAmend();
            //            String id =
            //                contractVO.getCurrentRow().getAttribute("ExtnContHeaderId") !=
            //                null ?
            //                contractVO.getCurrentRow().getAttribute("ExtnContHeaderId").toString() :
            //                contractVO.getCurrentRow().getAttribute("ContHeaderId").toString();
            String id =
                contractVO.getCurrentRow().getAttribute("ContractNum").toString();
            //                    retVal =con.pushOrder(contractVO.getCurrentRow().getAttribute("ContractNum").toString());
            retVal = con.pushOrder(id);
        } catch (Exception e) {
            JSFUtils.addFacesErrorMessage("=invokeAmend(){===" + e.toString());
        }
        return retVal;
    }

    public void setVar_amt(RichInputText var_amt) {
        this.var_amt = var_amt;
    }

    public RichInputText getVar_amt() {
        return var_amt;
    }

    public void setRev_cont_amt(RichInputText rev_cont_amt) {
        this.rev_cont_amt = rev_cont_amt;
    }

    public RichInputText getRev_cont_amt() {
        return rev_cont_amt;
    }

    public void setGuarCategory(RichSelectOneChoice guarCategory) {
        this.guarCategory = guarCategory;
    }

    public RichSelectOneChoice getGuarCategory() {
        return guarCategory;
    }

    public void GuarTypeVCL(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject guaranteVO =
            ADFUtils.findIterator("XxscContractGuaranteeVO2Iterator").getViewObject();
        //        //System.err.println("OLD-->"+valueChangeEvent.getOldValue()+"NEW--->"+valueChangeEvent.getNewValue());
        if (valueChangeEvent.getNewValue() != null) {
            if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
                //System.err.println("BUY OLD-->" +
//                                   valueChangeEvent.getOldValue() + "NEW--->" +
//                                   valueChangeEvent.getNewValue());
                //System.err.println("GuarType==>");
                String type =
                    guaranteVO.getCurrentRow().getAttribute("GuarType") ==
                    null ? "null" :
                    guaranteVO.getCurrentRow().getAttribute("GuarType").toString();
                if (type.equalsIgnoreCase("INSU")) {
                    guarCategory.setDisabled(true);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(guarCategory);
                    trigger();
                }
                
                else {
                    guarCategory.setDisabled(false);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(guarCategory);
                    trigger();
                }
                trigger();
            } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell")) {
                //System.err.println("SELL OLD-->" +
//                                   valueChangeEvent.getOldValue() + "NEW--->" +
//                                   valueChangeEvent.getNewValue());
                //System.err.println("GuarType==>" +
//                                   guaranteVO.getCurrentRow().getAttribute("GuarType"));
                guarCategory.setDisabled(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(guarCategory);
            }
        }
        
        trigger();

    }
    
    public void trigger(){
        
            AdfFacesContext.getCurrentInstance().addPartialTarget(gauRefNo);
            AdfFacesContext.getCurrentInstance().addPartialTarget(gauVal);
            AdfFacesContext.getCurrentInstance().addPartialTarget(gaunImprt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(gaurTyp);
          
            AdfFacesContext.getCurrentInstance().addPartialTarget(guaStDate);
            AdfFacesContext.getCurrentInstance().addPartialTarget(guaEnDate);
           
        }

    public void advAmount(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            advanceRec.setDisabled(Boolean.FALSE);
            advanceRec.setRequired(Boolean.TRUE);
            AdfFacesContext.getCurrentInstance().addPartialTarget(advanceRec);
            double advAm =
                valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
            double matAm =
                mat.getValue() == null ? 0 : Double.parseDouble(mat.getValue().toString());
            double retAm =
                ret.getValue() == null ? 0 : Double.parseDouble(ret.getValue().toString());
            double sum = advAm + matAm + retAm;
            double totalcon =
                contractVO.getCurrentRow().getAttribute("ContractAmount") ==
                null ? 0 :
                Double.parseDouble(contractVO.getCurrentRow().getAttribute("ContractAmount").toString());
            if (sum <= totalcon) {
                String val =
                    valueChangeEvent.getNewValue() == null ? "0" : valueChangeEvent.getNewValue().toString();
                String tot = "ContractAmount";
                String setAtt = "AdvPercent";
                UIComponent id = advance;
                caluclatePer(val, tot, setAtt, id);
            } else {
                JSFUtils.addFacesErrorMessage("Entered amount is greater than ContractAmount. Please check");
                adv.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(adv);

                contractRow.setAttribute("AdvPercent", "");
                AdfFacesContext.getCurrentInstance().addPartialTarget(advance);
            }


        }
    }


    public void caluclatePer(String val, String tot, String setAtt,
                             UIComponent id) {
        double amount = Double.parseDouble(val);
        double totCon =
            contractVO.getCurrentRow().getAttribute(tot) == null ? 0 :
            Double.parseDouble(contractVO.getCurrentRow().getAttribute(tot).toString());

        double totper = (amount / totCon) * 100;
       // JSFUtils.addFacesErrorMessage("==Percentage==>>>" + totper);
        contractVO.getCurrentRow().setAttribute(setAtt,
                                                new BigDecimal(totper));
        AdfFacesContext.getCurrentInstance().addPartialTarget(id);

    }

    public void materialAm(ValueChangeEvent valueChangeEvent) {

        if (valueChangeEvent.getNewValue() != null) {
            advanceRec.setDisabled(Boolean.FALSE);
            advanceRec.setRequired(Boolean.TRUE);
            AdfFacesContext.getCurrentInstance().addPartialTarget(materialsRec);
            double advAm =
                valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
            double matAm =
                mat.getValue() == null ? 0 : Double.parseDouble(mat.getValue().toString());
            double retAm =
                ret.getValue() == null ? 0 : Double.parseDouble(ret.getValue().toString());
            double sum = advAm + matAm + retAm;
            double totalcon =
                contractVO.getCurrentRow().getAttribute("ContractAmount") ==
                null ? 0 :
                Double.parseDouble(contractVO.getCurrentRow().getAttribute("ContractAmount").toString());
            if (sum <= totalcon) {
                String val =
                    valueChangeEvent.getNewValue() == null ? "0" : valueChangeEvent.getNewValue().toString();
                String tot = "ContractAmount";
                String setAtt = "MatOnsitePercent";
                UIComponent id = materials;
                caluclatePer(val, tot, setAtt, id);
            } else {
                JSFUtils.addFacesErrorMessage("Entered amount is greater than ContractAmount. Please check");
                mat.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(mat);

                contractRow.setAttribute("MatOnsitePercent", "");
                AdfFacesContext.getCurrentInstance().addPartialTarget(materials);
            }


        }

    }

    public void retentionAm(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != null) {

            double advAm =
                valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
            double matAm =
                mat.getValue() == null ? 0 : Double.parseDouble(mat.getValue().toString());
            double retAm =
                ret.getValue() == null ? 0 : Double.parseDouble(ret.getValue().toString());
            double sum = advAm + matAm + retAm;
            double totalcon =
                contractVO.getCurrentRow().getAttribute("ContractAmount") ==
                null ? 0 :
                Double.parseDouble(contractVO.getCurrentRow().getAttribute("ContractAmount").toString());
            if (sum <= totalcon) {
                String val =
                    valueChangeEvent.getNewValue() == null ? "0" : valueChangeEvent.getNewValue().toString();
                String tot = "ContractAmount";
                String setAtt = "RetenPercent";
                UIComponent id = retention;
                caluclatePer(val, tot, setAtt, id);
            } else {
                JSFUtils.addFacesErrorMessage("Entered amount is greater than ContractAmount. Please check");
                ret.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(ret);

                contractRow.setAttribute("RetenPercent", "");
                AdfFacesContext.getCurrentInstance().addPartialTarget(retention);
            }


        }

    }

    public void onClickDeleteContLine(ActionEvent actionEvent) {
        RichPopup.PopupHints hints=new RichPopup.PopupHints();
            this.getP5().show(hints);
    }

    public void onClickDialogueOkContLine(DialogEvent dialogEvent) {
        if(dialogEvent.getOutcome()==DialogEvent.Outcome.ok){

                               String ipaddress="";
                                        try {
                                        InetAddress IP=InetAddress.getLocalHost();
                                        ipaddress=IP.toString();
                                        } catch (UnknownHostException e) {
                                           
                                        }
                    String contid="";
                try {
                    Row r=contractLineVO.first();
                    contid=r.getAttribute("ContHeaderId")==null?"000":r.getAttribute("ContHeaderId").toString();
                    OperationBinding op = (OperationBinding)ADFUtils.findOperation("deletedbcall");
                                op.getParamsMap().put("p_cid",contid);
                                op.getParamsMap().put("p_type","CONTRACT LINE");
                                op.getParamsMap().put("P_username",ADFContext.getCurrent().getSessionScope().get("userName").toString());
                                op.getParamsMap().put("p_ip",ipaddress);
                                Object result =op.execute();
                                
                            contractLineVO.executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(contractLineTable);
                                JSFUtils.addFacesInformationMessage(result.toString()); 
                               
                
            } catch (Exception e) {
               JSFUtils.addFacesErrorMessage("cont_id="+contid+"username="+ADFContext.getCurrent().getSessionScope().get("userName").toString()+"ip="+ipaddress+"ERROR==>"+e.getStackTrace().toString());
                
            }     
                                        
                                    
                }
    }

    public void setD4(RichDialog d4) {
        this.d4 = d4;
    }

    public RichDialog getD4() {
        return d4;
    }

    public void setP5(RichPopup p5) {
        this.p5 = p5;
    }

    public RichPopup getP5() {
        return p5;
    }

    public void onClickGaurAttach(ValueChangeEvent valueChangeEvent) {
        ViewObject gaurAttachVO =
            ADFUtils.findIterator("XxscContractGuaranteeVO2Iterator").getViewObject();
        if (valueChangeEvent.getNewValue() != null) {
           
            FileAttachment.TableFileToDB((UploadedFile)valueChangeEvent.getNewValue(),
            
 gaurAttachVO);
             
//            if(gaurAttachVO.getCurrentRow() == null){
//                System.err.println("came inside if");
//                FileAttachment.UploadFileToDB((UploadedFile)valueChangeEvent.getNewValue(),
//                                                         gaurAttachVO);
//            }
//            else{
//                                              System.err.println("came inside else");
//            FileAttachment.TableFileToDB((UploadedFile)valueChangeEvent.getNewValue(),
//                                          gaurAttachVO);}
            gaunImprt.setValue("");
            AdfFacesContext.getCurrentInstance().addPartialTarget(gaunImprt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(fileNam);
            
        }
    }

    public void setGaunImprt(RichInputFile gaunImprt) {
        this.gaunImprt = gaunImprt;
    }

    public RichInputFile getGaunImprt() {
        return gaunImprt;
    }

    public void dwnlGaurAttach(FacesContext facesContext,
                               OutputStream outputStream) {
        ViewObject gaurAttachVO =
            ADFUtils.findIterator("XxscContractGuaranteeVO2Iterator").getViewObject();
        try {
            FileAttachment.downloadFileListener(facesContext, outputStream,
                                                gaurAttachVO);
        } catch (Exception e) {

        }
    }

    public void notifiCheckBox(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }

    public void setGaurTyp(RichSelectOneChoice gaurTyp) {
        this.gaurTyp = gaurTyp;
    }

    public RichSelectOneChoice getGaurTyp() {
        return gaurTyp;
    }

  

    public void setGauVal(RichInputText gauVal) {
        this.gauVal = gauVal;
    }

    public RichInputText getGauVal() {
        return gauVal;
    }

    public void setGauRefNo(RichInputText gauRefNo) {
        this.gauRefNo = gauRefNo;
    }

    public RichInputText getGauRefNo() {
        return gauRefNo;
    }

    public void onClickGuanAttachCreate(ActionEvent actionEvent) {
        ADFUtils.findOperation("CreateInsertGuan").execute();  
                                                                   
       // ADFUtils.findOperation("CreateInsertGuanAttach").execute();
    }

    public void setFileNam(RichOutputText fileNam) {
        this.fileNam = fileNam;
    }

    public RichOutputText getFileNam() {
        return fileNam;
    }

    public void setFileNameAtt(RichInputText fileNameAtt) {
        this.fileNameAtt = fileNameAtt;
    }

    public RichInputText getFileNameAtt() {
        return fileNameAtt;
    }

    public void setAttriBooleanGau(RichSelectOneChoice attriBooleanGau) {
        this.attriBooleanGau = attriBooleanGau;
    }

    public RichSelectOneChoice getAttriBooleanGau() {
        return attriBooleanGau;
    }
}


