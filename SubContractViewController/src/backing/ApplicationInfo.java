package backing;

import Utils.ADFApproval;
import Utils.ADFDateUtils;
import Utils.ADFUtils;

import Utils.JSFUtils;

import Utils.MailServices;
import Utils.MailTemplates;

import Utils.RTFUtils;

import java.io.IOException;

import java.io.OutputStream;

import java.math.BigDecimal;

import java.net.InetAddress;
import java.net.MalformedURLException;

import java.net.UnknownHostException;

import java.sql.SQLException;


import java.text.DecimalFormat;

import java.text.ParseException;


import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.OperationBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichColumn;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelLabelAndMessage;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;


import oracle.adf.view.rich.event.DialogEvent;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.Version;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;

import oracle.sql.NUMBER;

import oracle.sqlj.runtime.Oracle;

import subcontract.view.backing.WEBINF.oracle.apps.uikit.Fragments.SubmitForApproval;

public class ApplicationInfo {
    private RichTable t1;
    private RichInputText uom;
    private RichInputText qty;
    private RichInputText rate;
    private RichInputText amt;
    private RichInputText currPer;
    private RichInputText currQty;
    private RichInputText currAmt;
    private RichInputText cumuPer;
    private RichInputText cumuQty;
    private RichInputText cumuAmt;
    private RichInputText prePercen;
    private RichInputText preQty;
    private RichInputText preAmt;
    private RichInputText CurApplication;
    private RichInputText TotalAdvAmount;
    private RichInputText TotalRet;
    private RichInputText CurAdvRec;
    private RichInputText CurRet;
    private RichInputText BalanceAdvRec;
    private RichInputText BalanceRet;
    private RichInputText PrevAdvRec;
    private RichInputText PrevRet;
    private RichInputText prevAppl;
    private RichSelectOneChoice paymentType;
    private RichInputText curPayAmount;
    private RichInputText tans_Adv_rec;
    private RichInputText material_Adv_amt;
    private RichInputText cont_Amt;
    private RichInputText total_mat_adv_amt;
    private RichInputText trans_ret_amt;
    private RichInputText ret_per;
    private RichInputText bal_Cont_Amt;
    private RichInputText cum_Amt;
    private RichInputText cum_adv_rec;
    private RichInputText cum_ret;
    private RichInputText tot_mat_adv_amt;
    private RichInputText cum_mat_adv_rec;
    private RichInputText cur_mat_adv_rec;
    private RichInputText bal_mat_adv_rec;
    private RichInputText material_per;
    private RichInputText adv_rec_per_new;
    private RichInputText mat_adv_rec_per_new;
    private RichInputText prev_mat_adv_rec;
    private RichPopup p1;
    private RichInputDate paymentDueDate;
    private RichInputDate buyPayDate;
    private RichInputText currTaxAmt;
    private RichOutputText curPayTaxAmount;
    private RichOutputText curPayTaxAmount1;
    private RichOutputText taxRateApp;
    private RichOutputText taxRateApp1;
    private RichPanelLabelAndMessage advPer;
    private RichInputText contra_Charges;
    private RichInputText penality_charges;
    private RichInputText curAdvRecPer;
    private RichInputText curMatAdvRecPer;
    private RichPopup p3;
    private RichInputText rejectValue;
    private RichInputText prev_contra;
    private RichInputText prev_penalty;
    private RichInputText prev_Mat_rec;
    private RichInputText cur_mat_onsite;
    private RichPopup p4;
    private RichInputText appValue;
    private RichInputText ecpTotAmt;
    private RichOutputText proId;
    private RichPopup p2;
    private RichOutputText curOthCharge;
    private RichOutputText prevOthCharge;
    private RichOutputText totOthCharge;
    private RichTable t7;
    private RichInputText bal_Adv_AMT;
    private RichCommandButton cb9;
    private RichSelectOneChoice applPayTerm;
    private RichOutputText totCummAmt;
    private RichInputText curRecvryAmt;
    private RichInputText inpCurOthCharge;
    private RichInputText inprevOthCharg;
    private RichInputText inTotOthCharg;
    private RichSelectOneChoice chargeType;
    private RichPopup p5;

    public ApplicationInfo() {
    }

    ViewObject contractLineVO =
        ADFUtils.findIterator("XxscContractLinesVO1Iterator").getViewObject();
    ViewObject applicationHrdVO =
        ADFUtils.findIterator("XxscPayApplHeadersVO1Iterator").getViewObject();
    ViewObject applicationLineVO =
        ADFUtils.findIterator("XxscPayApplLinesVO2Iterator").getViewObject();
    ViewObject certificationamountVO =
        ADFUtils.findIterator("certificationcurAmountROVO1Iterator").getViewObject();
    ViewObject applicationHrdVO2 =
        ADFUtils.findIterator("XxscPayApplHeadersVO2Iterator").getViewObject();
    ViewObject searchApplicationVO =
        ADFUtils.findIterator("applicationSearchROVO1Iterator").getViewObject();
    ViewObject applicationLineVO2 =
        ADFUtils.findIterator("XxscPayApplLinesVO1Iterator").getViewObject();
    ViewObject PrevAdvAndRetCal =
        ADFUtils.findIterator("PrevAdvAndRetCalcROVO1Iterator").getViewObject();
    ViewObject contractHeaderVO =
        ADFUtils.findIterator("XxscContractHeadersVO1Iterator").getViewObject();
    ViewObject functionVO =
        ADFUtils.findIterator("FunctionROVO1Iterator").getViewObject();
    ViewObject previousCalculationVO =
        ADFUtils.findIterator("AppSearchPreviousROVO1Iterator").getViewObject();
    ViewObject penaltybackchargesVO =
        ADFUtils.findIterator("PenaltyBackChargesROVO1Iterator").getViewObject();
    ViewObject RetamountVO =
        ADFUtils.findIterator("Ret_amount1Iterator").getViewObject();
    ViewObject AdvancRecVO2 =
            ADFUtils.findIterator("XxscPayApplAdvRecDtlsVO2Iterator").getViewObject();
    ViewObject AdvancRecVO =
        ADFUtils.findIterator("XxscPayApplAdvRecDtlsVO1Iterator").getViewObject();
    ViewObject AdvanceVO =
        ADFUtils.findIterator("XxscPayApplAdvanceDtlsVO1Iterator").getViewObject();
    ViewObject ExtraAdvVO =
        ADFUtils.findIterator("Extra_Adv_ROVO1Iterator").getViewObject();
    ViewObject mailidVO =
        ADFUtils.findIterator("getMailIdROVO1Iterator").getViewObject();
    ViewObject OtherChargeVO1 =
        ADFUtils.findIterator("GetApplicationOtherChargesAmount1Iterator").getViewObject();
    ViewObject ApplOtherChargeVO =
        ADFUtils.findIterator("XxscPayApplOthChargesVO1Iterator").getViewObject();

    DecimalFormat df = new DecimalFormat(".######");

    public void onChangeContractNumber(ValueChangeEvent valueChangeEvent) {
        System.out.println("Begin - onChangeContractNumber");
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            if (applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate") != null) {
                String contactPayTerm = applicationHrdVO.getCurrentRow().getAttribute("ContactPayTerm") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("ContactPayTerm").toString();
                String num = contactPayTerm.replaceAll("[^0-9]", "");
                int number = Integer.parseInt(num);
                String n = Integer.toString(number);
                oracle.jbo.domain.Date str_date =
                    (oracle.jbo.domain.Date)applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate");
                oracle.jbo.domain.Date paymentDate =
                    ADFDateUtils.addDayToOracleDate(str_date, number);
                applicationHrdVO.getCurrentRow().setAttribute("PaymentDueDate", paymentDate);
                AdfFacesContext.getCurrentInstance().addPartialTarget(paymentDueDate);
                ViewObject paymentDueVO = ADFUtils.findIterator("paymentDueDateROVO1Iterator").getViewObject();
                if (applPayTerm.getValue() != null) {
                    if (applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate") !=
                        null) {
                        String days = applicationHrdVO.getCurrentRow().getAttribute("due_days") ==
                            null ? "0" :
                            applicationHrdVO.getCurrentRow().getAttribute("due_days").toString();
                        //               oracle.jbo.domain.Date appDate = (oracle.jbo.domain.Date)applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate");
                        String stringDate = applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate").toString();
                        paymentDueVO.setNamedWhereClauseParam("curdate",
                                                              stringDate);
                        paymentDueVO.setNamedWhereClauseParam("BV_NAME",
                                                              applPayTerm.getValue());
                        paymentDueVO.executeQuery();
                        if (paymentDueVO.getEstimatedRowCount() == 1) {
//                            //System.err.println("Payment due Date====>" +
//                                               paymentDueVO.first().getAttribute("Paymentduedate"));
                            applicationHrdVO.getCurrentRow().setAttribute("PaymentDueDate",
                                                                          paymentDueVO.first().getAttribute("Paymentduedate"));
                            //                        buyPayDate.setValue(paymentDueVO.first().getAttribute("Paymentduedate"));
                            //                        paymentDueDate.setValue(paymentDueVO.first().getAttribute("Paymentduedate"));
                            AdfFacesContext.getCurrentInstance().addPartialTarget(buyPayDate);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(paymentDueDate);
                        }
                    } else {
                        JSFUtils.addFacesErrorMessage("Please select Application Date");
                    }
                }
            }
        }
     System.err.println("End - onChangeContractNumber");
    }


    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }


    public void setUom(RichInputText uom) {
        this.uom = uom;
    }

    public RichInputText getUom() {
        return uom;
    }

    public void setQty(RichInputText qty) {
        this.qty = qty;
    }

    public RichInputText getQty() {
        return qty;
    }

    public void setRate(RichInputText rate) {
        this.rate = rate;
    }

    public RichInputText getRate() {
        return rate;
    }

    public void setAmt(RichInputText amt) {
        this.amt = amt;
    }

    public RichInputText getAmt() {
        return amt;
    }

    public void setCurrPer(RichInputText currPer) {
        this.currPer = currPer;
    }

    public RichInputText getCurrPer() {
        return currPer;
    }

    public void setCurrQty(RichInputText currQty) {
        this.currQty = currQty;
    }

    public RichInputText getCurrQty() {
        return currQty;
    }

    public void setCurrAmt(RichInputText currAmt) {
        this.currAmt = currAmt;
    }

    public RichInputText getCurrAmt() {
        return currAmt;
    }

    public void setCumuPer(RichInputText cumuPer) {
        this.cumuPer = cumuPer;
    }

    public RichInputText getCumuPer() {
        return cumuPer;
    }

    public void setCumuQty(RichInputText cumuQty) {
        this.cumuQty = cumuQty;
    }

    public RichInputText getCumuQty() {
        return cumuQty;
    }

    public void setCumuAmt(RichInputText cumuAmt) {
        this.cumuAmt = cumuAmt;
    }

    public RichInputText getCumuAmt() {
        return cumuAmt;
    }

    public void setPrePercen(RichInputText prePercen) {
        this.prePercen = prePercen;
    }

    public RichInputText getPrePercen() {
        return prePercen;
    }

    public void setPreQty(RichInputText preQty) {
        this.preQty = preQty;
    }

    public RichInputText getPreQty() {
        return preQty;
    }

    public void setPreAmt(RichInputText preAmt) {
        this.preAmt = preAmt;
    }

    public RichInputText getPreAmt() {
        return preAmt;
    }

    /******CURR PerCentage*******/
    public void currPerVCL(ValueChangeEvent currPerVCL) {
        System.out.println("Begin - currPerVCL");
        currPerVCL.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (currPerVCL.getNewValue() != null) {
            double contLneRate = rate.getValue() == null ? 0 : Double.parseDouble(rate.getValue().toString());
            double contLneAmt = amt.getValue() == null ? 0 : Double.parseDouble(amt.getValue().toString());
            double currentPercen = currPerVCL.getNewValue() == null ? 0 : Double.parseDouble(currPerVCL.getNewValue().toString());
            applicationLineVO.getCurrentRow().setAttribute("CurrPerc", new BigDecimal(currentPercen));
            AdfFacesContext.getCurrentInstance().addPartialTarget(currPer);
            double currentAmount = (currentPercen * contLneAmt) / 100;
            applicationLineVO.getCurrentRow().setAttribute("CurrAmount", currentAmount);
            AdfFacesContext.getCurrentInstance().addPartialTarget(currAmt);
            //set Current Qty
            double currentQty = currentAmount / contLneRate;
            applicationLineVO.getCurrentRow().setAttribute("CurrTotQty", new BigDecimal(currentQty));
            AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
            //set Cumulative
            double previousPer =
                prePercen.getValue() == null ? 0 : Double.parseDouble(prePercen.getValue().toString());
            double previousQty =
                preQty.getValue() == null ? 0 : Double.parseDouble(preQty.getValue().toString());
            double previousAmt =
                preAmt.getValue() == null ? 0 : Double.parseDouble(preAmt.getValue().toString());
            applicationLineVO.getCurrentRow().setAttribute("CumPerc", new BigDecimal(previousPer + currentPercen));
            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuPer);
            //        cumuQty.setValue(new BigDecimal(previousQty+currentQty));
            applicationLineVO.getCurrentRow().setAttribute("CumTotQty",
                                                           new BigDecimal(previousQty + currentQty));
            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuQty);
            //        cumuAmt.setValue(new BigDecimal(previousAmt+currentAmount));
            applicationLineVO.getCurrentRow().setAttribute("CumAmount",
                                                           new BigDecimal(previousAmt + currentAmount));
            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuAmt);
        }
    }

    /*****CURR QTY**********/
    public void currQtyVCL(ValueChangeEvent currQtyVCL) {

        currQtyVCL.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (currQtyVCL.getNewValue() != null) {
            double contLneRate =
                rate.getValue() == null ? 0 : Double.parseDouble(rate.getValue().toString());
            double contLneAmt =
                amt.getValue() == null ? 0 : Double.parseDouble(amt.getValue().toString());
            double currentQty =
                currQtyVCL.getNewValue() == null ? 0 : Double.parseDouble(currQtyVCL.getNewValue().toString());
            // set Current Qty
            applicationLineVO.getCurrentRow().setAttribute("CurrTotQty",
                                                           new BigDecimal(currentQty));
            AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
            // set currenty Amount
            double currentAmt = currentQty * contLneRate;
            applicationLineVO.getCurrentRow().setAttribute("CurrAmount",
                                                           new BigDecimal(currentAmt));
            //        currAmt.setValue(new BigDecimal(currentAmt));
            AdfFacesContext.getCurrentInstance().addPartialTarget(currAmt);
            // set current Percentage
            double currentPer = (100 * currentAmt / contLneAmt);
            //        currPer.setValue(new BigDecimal(currentPer));
            applicationLineVO.getCurrentRow().setAttribute("CurrPerc",
                                                           new BigDecimal(currentPer));
            AdfFacesContext.getCurrentInstance().addPartialTarget(currPer);
            //set cumulative value/
            double previousPer =
                prePercen.getValue() == null ? 0 : Double.parseDouble(prePercen.getValue().toString());
            double previousQty =
                preQty.getValue() == null ? 0 : Double.parseDouble(preQty.getValue().toString());
            double previousAmt =
                preAmt.getValue() == null ? 0 : Double.parseDouble(preAmt.getValue().toString());
            applicationLineVO.getCurrentRow().setAttribute("CumPerc",
                                                           new BigDecimal(previousPer +
                                                                          currentPer));
            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuPer);
            applicationLineVO.getCurrentRow().setAttribute("CumTotQty",
                                                           new BigDecimal(previousQty +
                                                                          currentQty));
            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuQty);
            applicationLineVO.getCurrentRow().setAttribute("CumAmount",
                                                           new BigDecimal(previousAmt + currentAmt));
            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuAmt);
        }
    }

    /*****CURR AMT*******/
    public void currAmtVCL(ValueChangeEvent currAmtVCL) {
        currAmtVCL.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (currAmtVCL.getNewValue() != null) {
            double contLneRate =
                rate.getValue() == null ? 0 : Double.parseDouble(rate.getValue().toString());
            double contLneAmt =
                amt.getValue() == null ? 0 : Double.parseDouble(amt.getValue().toString());
            double currentAmt =
                currAmtVCL.getNewValue() == null ? 0 : Double.parseDouble(currAmtVCL.getNewValue().toString());
            //set Current Amt
            applicationLineVO.getCurrentRow().setAttribute("CurrAmount",
                                                           currentAmt);
            //set Current Qty
            double currentQty = currentAmt / contLneRate;
            //        currQty.setValue(new BigDecimal(currentQty));
            applicationLineVO.getCurrentRow().setAttribute("CurrTotQty",
                                                           new BigDecimal(currentQty));
            AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
            //set Current Percentage
            double currentPercentage = (100 * currentAmt / contLneAmt);
//            //System.err.println(currentPercentage);
            //        currPer.setValue(new BigDecimal(currentPercentage));
            applicationLineVO.getCurrentRow().setAttribute("CurrPerc",
                                                           new BigDecimal(currentPercentage));
            AdfFacesContext.getCurrentInstance().addPartialTarget(currPer);

            double previousPer =
                prePercen.getValue() == null ? 0 : Double.parseDouble(prePercen.getValue().toString());
            double previousQty =
                preQty.getValue() == null ? 0 : Double.parseDouble(preQty.getValue().toString());
            double previousAmt =
                preAmt.getValue() == null ? 0 : Double.parseDouble(preAmt.getValue().toString());
            cumuPer.setValue(new BigDecimal(previousPer + currentPercentage));
            applicationLineVO.getCurrentRow().setAttribute("CumPerc",
                                                           new BigDecimal(previousPer +
                                                                          currentPercentage));
            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuPer);
            cumuQty.setValue(new BigDecimal(previousQty + currentQty));
            applicationLineVO.getCurrentRow().setAttribute("CumTotQty",
                                                           new BigDecimal(previousQty + currentQty));
            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuQty);
            cumuAmt.setValue(new BigDecimal(previousAmt + currentAmt));
            applicationLineVO.getCurrentRow().setAttribute("CumAmount",
                                                           new BigDecimal(previousAmt + currentAmt));
            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuAmt);
        }
    }

    //==============================================================================
    public void onClickPopulateAmount(ActionEvent actionevent) {
    }

    public String onClickCalculateAmount() {
        if (paymentType.getValue().toString().equals("Advance")) {
            TotalAdvanceCalculation();
        } else if (paymentType.getValue().toString().equals("Material Advance")) {
            TotalMaterialAdvanceCalculation();
        } else if (paymentType.getValue().toString().equals("Interim")) {
            CalculateAmount1();
        } else if (paymentType.getValue().toString().equals("Final")) {
            CalculateAmount1();
            revRetRecoveryCalc();
        }
        return null;
    }


    /*****=========Advance Calculation===*****************/

    public void TotalAdvanceCalculation() {
        System.out.println("curPayAmount1: ");
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
            double Adv_amt =
                tans_Adv_rec.getValue() == null ? 0 : Double.parseDouble(tans_Adv_rec.getValue().toString());
            double cur_amt =
                CurApplication.getValue() == null ? 0 : Double.parseDouble(CurApplication.getValue().toString());
            double pre_amt =
                prevAppl.getValue() == null ? 0 : Double.parseDouble(prevAppl.getValue().toString());
            double balance = Adv_amt - (cur_amt + pre_amt);
            applicationHrdVO.getCurrentRow().setAttribute("TotalAdvAmount",
                                                          new BigDecimal(Adv_amt));
            AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);
            applicationHrdVO.getCurrentRow().setAttribute("BalContAmt",
                                                          new BigDecimal(balance));
            AdfFacesContext.getCurrentInstance().addPartialTarget(bal_Cont_Amt);
            applicationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                          new BigDecimal(cur_amt));
            AdfFacesContext.getCurrentInstance().addPartialTarget(TotalAdvAmount);
            // Tax
            applicationHrdVO.getCurrentRow().setAttribute("Taxrate", 5);
            AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateApp);
            double tax_Amt = (5 * cur_amt) / 100;
            applicationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
                                                          new BigDecimal(tax_Amt));
            AdfFacesContext.getCurrentInstance().addPartialTarget(curPayTaxAmount1);
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            System.out.println("curPayAmount2: ");
            RowSetIterator rs = AdvanceVO.createRowSet(null);
            double sum = 0;
            while (rs.hasNext()) {
                Row r = rs.next();
                sum += Double.parseDouble(r.getAttribute("AdvanceAmt").toString());
            }
            String Hid =
                applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
            String ver =
                applicationHrdVO.getCurrentRow().getAttribute("Version") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("Version").toString();
            String apphdrid =
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();

            ViewObject vo =
                ADFUtils.findIterator("AdvPrevAmt_ROVO1Iterator").getViewObject();
            vo.setNamedWhereClauseParam("BV_cont_ID", Hid);
            vo.setNamedWhereClauseParam("BV_app_id", apphdrid);
            vo.setNamedWhereClauseParam("Bv_ver", ver);
            vo.executeQuery();
//            //System.err.println("row count==>" + vo.getEstimatedRowCount());
            double prevamt =
                vo.first().getAttribute("Amount") == null ? 0 : Double.parseDouble(vo.first().getAttribute("Amount").toString());

            applicationHrdVO.getCurrentRow().setAttribute("CurApplication",
                                                          new BigDecimal(sum));
            AdfFacesContext.getCurrentInstance().addPartialTarget(CurApplication);
            applicationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                          new BigDecimal(sum));
            AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);
            applicationHrdVO.getCurrentRow().setAttribute("PrevApplication",
                                                          new BigDecimal(prevamt));
            AdfFacesContext.getCurrentInstance().addPartialTarget(prevAppl);
            // Tax
            //        applicationHrdVO.getCurrentRow().setAttribute("Taxrate", 5);
            //        AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateApp);
            //        double tax_Amt = (5 * cur_amt) / 100;
            //        applicationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
            //                                                      new BigDecimal(((tax_Amt)));
            //        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayTaxAmount1);
        }

    }

    /*****=========Material Advance Calculation===*****************/

    public void TotalMaterialAdvanceCalculation() {
        System.out.println("==Begin - TotalMaterialAdvanceCalculation==");
        double Mat_Adv_amt = 0;
        double cur_amt = 0;
        double pre_amt = 0;
        double balance = 0;
        Mat_Adv_amt =
                material_Adv_amt.getValue() == null ? 0 : Double.parseDouble(material_Adv_amt.getValue().toString());
        cur_amt =
                CurApplication.getValue() == null ? 0 : Double.parseDouble(CurApplication.getValue().toString());
        pre_amt =
                prevAppl.getValue() == null ? 0 : Double.parseDouble(prevAppl.getValue().toString());
        balance = Mat_Adv_amt - (cur_amt + pre_amt);

        //        //System.err.println("===Advance Amount===" + Mat_Adv_amt);
        applicationHrdVO.getCurrentRow().setAttribute("TotalMatAdvAmount",
                                                      new BigDecimal(Mat_Adv_amt));
        AdfFacesContext.getCurrentInstance().addPartialTarget(tot_mat_adv_amt);
        applicationHrdVO.getCurrentRow().setAttribute("BalContAmt",
                                                      new BigDecimal(balance));
        AdfFacesContext.getCurrentInstance().addPartialTarget(bal_Cont_Amt);
        applicationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                      new BigDecimal(cur_amt));
        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);
        // Tax
        applicationHrdVO.getCurrentRow().setAttribute("Taxrate", 5);
        AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateApp);
        double tax_Amt = (5 * cur_amt) / 100;
        applicationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
                                                      new BigDecimal(tax_Amt));
        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayTaxAmount1);
    }


    /*****=========Interim===*****************/

    public void CalculateAmount1() {
        // Previous
        PreviousAppliedAmount();
        CurrentApplicationAmount();
        CurrentAdvanceRecovery();
        CurrentMaterialAdvanceRecovery();
        totalCumulative();
        /****Retention****/
        // TotalRet
        double ret_amt =
            trans_ret_amt.getValue() == null ? 0 : Double.parseDouble(trans_ret_amt.getValue().toString());
        applicationHrdVO.getCurrentRow().setAttribute("TotalRet",
                                                      new BigDecimal(ret_amt));
        AdfFacesContext.getCurrentInstance().addPartialTarget(TotalRet);
        // cur_app
        double cur_app =
            CurApplication.getValue() == null ? 0 : Double.parseDouble(CurApplication.getValue().toString());
        //re_per
        double re_per =
            ret_per.getValue() == null ? 0 : Double.parseDouble(ret_per.getValue().toString());
//        //System.err.println("cur_app==>" + cur_app);
//        //System.err.println("re_per==>" + re_per);
        double cur_ret = (cur_app * re_per) / 100;
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy") ||
            ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
            applicationHrdVO.getCurrentRow().setAttribute("CurRet",
                                                          new BigDecimal(cur_ret));
            AdfFacesContext.getCurrentInstance().addPartialTarget(CurRet);
        }
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            //CurRet
            String Hid =
                applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
            String ver =
                applicationHrdVO.getCurrentRow().getAttribute("Version") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("Version").toString();
            String apphdrid =
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
            RetamountVO.setNamedWhereClauseParam("cont_hdr_id", Hid);
            RetamountVO.setNamedWhereClauseParam("version", ver);
            RetamountVO.setNamedWhereClauseParam("app_hdr_id", apphdrid);
            RetamountVO.setNamedWhereClauseParam("amount", cur_ret);
            RetamountVO.executeQuery();
            double retamt =
                RetamountVO.first().getAttribute("Amount") == null ? 0 :
                Double.parseDouble(RetamountVO.first().getAttribute("Amount").toString());
            /*** VariationCode */
            double retentionvariAmount = 0;
            double retenVarAmtPerc = 0;
            if (ApplOtherChargeVO.getEstimatedRowCount() > 0) {
                RowSetIterator rsI = ApplOtherChargeVO.createRowSetIterator(null);
                double sum = 0;
                double amt = 0;
                while (rsI.hasNext()) {
                    Row ro = rsI.next();
                    if (ro.getAttribute("ChargeType").toString().contains("Variation")) {
//                        //System.err.println("amt==>" + amt);
                        amt = ro.getAttribute("ChargeAmt") == 
                              null ? 0 : Double.parseDouble(ro.getAttribute("ChargeAmt").toString());
                        sum = sum + amt;
                    }
                }
                if (sum == 0) {                                                                         
                    applicationHrdVO.getCurrentRow().setAttribute("CurRet",
                                                                  new BigDecimal(cur_ret));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(CurRet);
                } else {
                    retentionvariAmount = cur_app + sum;
                    retenVarAmtPerc = (retentionvariAmount * re_per) / 100;
                    applicationHrdVO.getCurrentRow().setAttribute("CurRet", new BigDecimal(retenVarAmtPerc));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(CurRet);
                }
            }
            else {
                applicationHrdVO.getCurrentRow().setAttribute("CurRet", new BigDecimal(cur_ret));
                AdfFacesContext.getCurrentInstance().addPartialTarget(CurRet);
            }
        }
        
        double Adv_amt = 0;
        Adv_amt = tans_Adv_rec.getValue() == null ? 0 : Double.parseDouble(tans_Adv_rec.getValue().toString());
//        //System.err.println("===Advance Amount===" + Adv_amt);
        applicationHrdVO.getCurrentRow().setAttribute("TotalAdvAmount", new BigDecimal(Adv_amt));
        materialadvanceamount();
        String ContHdrId =
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();

        double contAdvRec =
            applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Rec_Per") ==
            null ? 0 :
            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Rec_Per").toString());
        ExtraAdvVO.setNamedWhereClauseParam("bv_hdr_id", ContHdrId);
        ExtraAdvVO.executeQuery();
        RowSetIterator rs = ExtraAdvVO.createRowSetIterator(null);
        while (rs.hasNext()) {
            Row r = rs.next();
            String name = (String)r.getAttribute("Name");
            //System.err.println("Name------------>" + name);
            RowSetIterator ar = AdvancRecVO.createRowSetIterator(null);
            String aName = null;
            if (AdvancRecVO.first() != null) {
                while (ar.hasNext()) {
                    Row aRow = ar.next();
                    aName = (String)aRow.getAttribute("AdvanceName");
                    if (aName.equalsIgnoreCase(name)) {
                        double curAdv =
                            applicationHrdVO.getCurrentRow().getAttribute("CurApplication") ==
                            null ? 0 :
                            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurApplication").toString());
                        /**
                         *AdvanceRecovery based on enter value calculation
                         */
                        double curAdv1 =
                            AdvancRecVO.getCurrentRow().getAttribute("CurRecAmt") ==
                            null ? 0 :
                            Double.parseDouble(AdvancRecVO.getCurrentRow().getAttribute("CurRecAmt").toString());
                        //System.err.println("curAdv1----->" + curAdv1);
                        double prevamt =
                            r.getAttribute("PrevAmt") == null ? 0 :
                            Double.parseDouble(r.getAttribute("PrevAmt").toString());
                        // double curr = ((contAdvRec * curAdv) / 100);
                        double curr = curAdv1;
                        double totalAdvToRec = r.getAttribute("Amt") == null ? 0 :
                            Double.parseDouble(r.getAttribute("Amt").toString());
                        double balance = totalAdvToRec - ( curAdv1 + prevamt);
                        aRow.setAttribute("AdvanceName", r.getAttribute("Name"));
                        System.out.println("here curRec amount 1:");
                        aRow.setAttribute("CurRecAmt", curr);
                        aRow.setAttribute("AdvanceAmt", r.getAttribute("Amt"));
                        aRow.setAttribute("RecoveredAmt", r.getAttribute("PrevAmt"));
                        aRow.setAttribute("BalanceAmt", balance);
                    } else {
                        Row r1 = AdvancRecVO.createRow();
                        //r1.setAttribute("ApplAdvId", r.getAttribute("ApplAdvId"));
                        double curAdv =
                            applicationHrdVO.getCurrentRow().getAttribute("CurApplication") ==
                            null ? 0 :
                            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurApplication").toString());
                        double prevamt =
                            r.getAttribute("PrevAmt") == null ? 0 :
                            Double.parseDouble(r.getAttribute("PrevAmt").toString());
                        double curr = ((contAdvRec * curAdv) / 100);
                        double totalAdvToRec =
                            r.getAttribute("Amt") == null ? 0 :
                            Double.parseDouble(r.getAttribute("Amt").toString());
                        double balance =
                            totalAdvToRec - ((((contAdvRec * curAdv) / 100) +
                                              prevamt));
                        r1.setAttribute("AdvanceName", r.getAttribute("Name"));
                        System.out.println("here curRec amount 2:");
                        r1.setAttribute("CurRecAmt", curr);
                        r1.setAttribute("AdvanceAmt", r.getAttribute("Amt"));
                        r1.setAttribute("RecoveredAmt",
                                        r.getAttribute("PrevAmt"));
                        r1.setAttribute("BalanceAmt", balance);
                        AdvancRecVO.insertRow(r1);
                    }
                }
            } else {
                Row r1 = AdvancRecVO.createRow();
                //r1.setAttribute("ApplAdvId", r.getAttribute("ApplAdvId"));
                double curAdv =
                    applicationHrdVO.getCurrentRow().getAttribute("CurApplication") ==
                    null ? 0 :
                    Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurApplication").toString());
                double curAdvRecPer =
                    applicationHrdVO.getCurrentRow().getAttribute("Curadvrecper") ==
                    null ? 0 :
                    Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Curadvrecper").toString());
                double prevamt =
                    r.getAttribute("PrevAmt") == null ? 0 : Double.parseDouble(r.getAttribute("PrevAmt").toString());
                double curr = ((curAdvRecPer * curAdv) / 100);
                double totalAdvToRec =
                    r.getAttribute("Amt") == null ? 0 : Double.parseDouble(r.getAttribute("Amt").toString());
                double balance =
                    totalAdvToRec - ((((curAdvRecPer * curAdv) / 100) +
                                      prevamt));
                System.out.println("here curRec amount 3:");
                r1.setAttribute("AdvanceName", r.getAttribute("Name"));
                r1.setAttribute("AdvanceAmt", r.getAttribute("Amt"));
                r1.setAttribute("RecoveredAmt", r.getAttribute("PrevAmt"));
                r1.setAttribute("CurRecAmt", null);
                r1.setAttribute("BalanceAmt", null);
                if(balance >= 0){
                    r1.setAttribute("CurRecAmt", curr);
                    r1.setAttribute("BalanceAmt", balance);
                }
                else{
                    JSFUtils.addFacesInformationMessage("Advance Recovery Amount should not exceed the limit. Please check.");
                }
                AdvancRecVO.insertRow(r1);
            }
        }
        //---Advance reco calc ends

        // Balance for Buys side
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy") ||
            ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
            setTotalAdvRecAmt();
            BalanceAdvanceRecovery();
            BalanceRetention();
            BalanceContractAmt();
            BalanceMaterialAdvanceRecovery();
        } 
        // Net Payment
        double netpayamt = 0;
        double netamount = 0;
        double totalTaxAmt = 0;
        double cur_mat_ret = 0;
        double totalRet =
            applicationHrdVO.getCurrentRow().getAttribute("TotalRet") ==
            null ? 0 :
            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("TotalRet").toString());
        double preRer =
            applicationHrdVO.getCurrentRow().getAttribute("PrevRet") ==
            null ? 0 :
            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("PrevRet").toString());
        
        double cur_appli =
            CurApplication.getValue() == null ? 0 : Double.parseDouble(CurApplication.getValue().toString());
        double cur_adv_rec =
            CurAdvRec.getValue() == null ? 0 : Double.parseDouble(CurAdvRec.getValue().toString());
        double cur_reten =
            CurRet.getValue() == null ? 0 : Double.parseDouble(CurRet.getValue().toString());
        //cur_reten = totalRet - preRer;
        System.out.println("totalRet: "+totalRet+"preRer: "+preRer+"cur_reten: "+cur_reten);
        System.out.println("cur_reten: "+cur_reten);
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy") ||
            ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
            cur_mat_ret =
                    applicationHrdVO.getCurrentRow().getAttribute("CurMatAdvRec") ==
                    null ? 0 :
                    Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurMatAdvRec").toString());
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            cur_mat_ret =
                    applicationHrdVO.getCurrentRow().getAttribute("CurMatOnSiteRec") ==
                    null ? 0 :
                    Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurMatOnSiteRec").toString());
        }
        //            cur_mat_adv_rec.getValue() == null ? 0 : Double.parseDouble(cur_mat_adv_rec.getValue().toString());

        //        double totalOtherCharg =applicationHrdVO.getCurrentRow().getAttribute("TotOthCharge")==null?0:Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("TotOthCharge").toString());
        double totalOtherCharg =
            inpCurOthCharge.getValue() == null ? 0 : Double.parseDouble(inpCurOthCharge.getValue().toString());
        //System.err.println("totalOtherCharg--==>>" + totalOtherCharg);
        System.out.println("cur_adv_rec: "+cur_adv_rec+"cur_reten: "+cur_reten+"cur_mat_ret: "+cur_mat_ret);
        
        if (contra_Charges.getValue() == null && penality_charges.getValue() == null) {
            netamount = cur_appli - (cur_adv_rec + cur_reten + cur_mat_ret);
            netpayamt = netamount + totalOtherCharg;
            System.out.println("netpayamt is 1 " + netpayamt);
        } else {
            netamount = cur_appli - (cur_adv_rec + cur_reten + cur_mat_ret);
            double contra_charge =
                contra_Charges.getValue() == null ? 0 : Double.parseDouble(contra_Charges.getValue().toString());
            double penality_charge =
                penality_charges.getValue() == null ? 0 : Double.parseDouble(penality_charges.getValue().toString());
            double amount = contra_charge + penality_charge;
            netpayamt = netamount - amount + totalOtherCharg;
            System.out.println("netpayamt is 2" + netpayamt);
        }
        // Currrent Pay Amount
        System.out.println("curPayAmount3: ");
        applicationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                      new BigDecimal(netpayamt));
        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);

        // Tax
        RowSetIterator appLnsRS = applicationLineVO.createRowSet(null);
        double taxRate = 0;
        String taxcode = "";
        double curamt = 0;
        //System.err.println("GetEstiRowCountapplicationLineVO==========" +
//                           applicationLineVO.getEstimatedRowCount());
        while (appLnsRS.hasNext()) {
            Row r = appLnsRS.next();

            //            double taxAmt = r.getAttribute("TaxAmount") == null ? 0 : Double.parseDouble(r.getAttribute("TaxAmount").toString());
            //            totalTaxAmt = totalTaxAmt + taxAmt;
            if (r.getAttribute("TaxRate") != null) {
                //System.err.println("r.getAttribute(\"TaxRate\")==========" +
//                                   r.getAttribute("TaxRate"));
                taxRate =
                        r.getAttribute("TaxRate") == null ? 0 : Double.parseDouble(r.getAttribute("TaxRate").toString());
                //System.err.println("taxRate" + r.getAttribute("TaxRate"));
                taxcode =
                        (String)r.getAttribute("TaxCode") == null ? "" : (String)r.getAttribute("TaxCode");
                curamt =
                        r.getAttribute("CurrAmount") == null ? 0 : Double.parseDouble(r.getAttribute("CurrAmount").toString());
                //System.err.println("TaxCode" + r.getAttribute("TaxCode"));
                if (taxcode.equals("NCC_PUR_5") || taxcode.equals("")) {
                    //System.err.println("entered NCC_PUR_5");
                    applicationHrdVO.getCurrentRow().setAttribute("Taxrate",
                                                                  new BigDecimal(taxRate));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateApp);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateApp1);
                    // Net Pay Tax amt
                    totalTaxAmt += (taxRate * curamt) / 100;
                    //System.err.println("totalTaxAmt" + totalTaxAmt);
                    applicationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
                                                                  new BigDecimal(totalTaxAmt));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(curPayTaxAmount);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(curPayTaxAmount1);
                    //                     Cummulative
                    CumulativeAdvanceRecoveryRetention();
                } else {
                    //System.err.println("else tax code");
                }

            }
        }

        // Updating Other charge in Application Header
        String contractHeaderID =
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
        String app_id =
            applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
        OtherChargeVO1.setNamedWhereClauseParam("BV_CONT_ID",
                                                contractHeaderID);
        OtherChargeVO1.setNamedWhereClauseParam("BV_APPL_ID", app_id);
        OtherChargeVO1.executeQuery();
        //System.err.println("OtherChargeVO1 Row count========================" +
//                           OtherChargeVO1.getEstimatedRowCount());
        /**
         * Previous Current Total OtherChargeCode
         */
        double curothcharge = 0;
        ViewObject PreApplOtherChargeVO =
            ADFUtils.findIterator("PreAppOtherChargeROVO1Iterator").getViewObject();
        double cursum = 0.0;
        double prevSum = 0.0;
        //PreAppOtherChargeROVO1Iterator
        if (PreApplOtherChargeVO.getEstimatedRowCount() != 0) {
            RowSetIterator dtlsRS =
                PreApplOtherChargeVO.createRowSetIterator(null);
            // double sum = 0.0;
            while (dtlsRS.hasNext()) {
                Row r = dtlsRS.next();
                String insPct =
                    r.getAttribute("ChargeAmt") == null ? "0.0" : r.getAttribute("ChargeAmt").toString();
                double per = Double.parseDouble(insPct);
                prevSum = prevSum + per;
            }
            //System.err.println("prevOtherChargVO Sum" + prevSum);
            applicationHrdVO.getCurrentRow().setAttribute("PrevOthCharge",
                                                          prevSum);
        }
        ////ApplOtherChargeVO==XxscPayApplOthChargesVO1Iterator
        if (ApplOtherChargeVO.getEstimatedRowCount() != 0) {
            RowSetIterator dtRsss =
                ApplOtherChargeVO.createRowSetIterator(null);
            // double sum = 0.0;
            while (dtRsss.hasNext()) {
                Row r = dtRsss.next();
                String insPct =
                    r.getAttribute("ChargeAmt") == null ? "0.0" : r.getAttribute("ChargeAmt").toString();
                double per = Double.parseDouble(insPct);
                cursum = cursum + per;
            }
            //System.err.println("curOtherChargVO Sum" + cursum);
            applicationHrdVO.getCurrentRow().setAttribute("CurOthCharge",
                                                          cursum);

        }

        applicationHrdVO.getCurrentRow().setAttribute("TotOthCharge",
                                                      cursum + prevSum);
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            penalty_back_charges();
        }
    }

    // Interim material advance amount
    public void materialadvanceamount() {
        double mat_adv_amt = 0;
        mat_adv_amt =
                material_Adv_amt.getValue() == null ? 0 : Double.parseDouble(material_Adv_amt.getValue().toString());
        //        //System.err.println("===mat Advance Amount===" + mat_adv_amt);
        applicationHrdVO.getCurrentRow().setAttribute("TotalMatAdvAmount",
                                                      new BigDecimal(mat_adv_amt));
        AdfFacesContext.getCurrentInstance().addPartialTarget(tot_mat_adv_amt);

    }

    // Interim- Calculating Cummulative
    public void CumulativeAdvanceRecoveryRetention() {
        //System.err.println("=========CurrentScope============");
        double cumAdv = 0;
        double cumret = 0;
        double cummatadv = 0;
        double prevAmount = 0;
        try {
            RowSetIterator Applines =
                applicationLineVO.createRowSetIterator(null);
            double sum = 0;
            double peradvrec =
                applicationHrdVO.getCurrentRow().getAttribute("PrevAdvRec") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("PrevAdvRec").toString());
            double curadvrec =
                applicationHrdVO.getCurrentRow().getAttribute("CurAdvRec") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurAdvRec").toString());
            double preret =
                applicationHrdVO.getCurrentRow().getAttribute("PrevRet") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("PrevRet").toString());
            double curret =
                applicationHrdVO.getCurrentRow().getAttribute("CurRet") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurRet").toString());
            double prematrec =
                applicationHrdVO.getCurrentRow().getAttribute("PrevMatAdvAmt") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("PrevMatAdvAmt").toString());
            double curmatrec =
                applicationHrdVO.getCurrentRow().getAttribute("CurMatAdvRec") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurMatAdvRec").toString());
            while (Applines.hasNext()) {
                Row r = Applines.next();
                prevAmount =
                        r.getAttribute("CumAmount") == null ? 0 : Double.parseDouble(r.getAttribute("CumAmount").toString());

                sum = sum + prevAmount;
            }
            cumAdv = peradvrec + curadvrec;
            cumret = preret + curret;
            cummatadv = prematrec + curmatrec;
            //System.err.println("=====cummulative Applied Amount=====" + sum);
            applicationHrdVO.getCurrentRow().setAttribute("CumApplication",
                                                          new BigDecimal(sum));
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(cum_Amt);
            applicationHrdVO.getCurrentRow().setAttribute("CumAdvRec",
                                                          new BigDecimal(cumAdv));
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(cum_adv_rec);
            applicationHrdVO.getCurrentRow().setAttribute("CumMatAdvRec",
                                                          new BigDecimal(cummatadv));
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(cum_mat_adv_rec);
            applicationHrdVO.getCurrentRow().setAttribute("CumRet",
                                                          new BigDecimal(cumret));
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(cum_ret);
        } catch (Exception e) {
            //System.err.println("====Error====" + e);
        }
        System.err.println("CumulativeAdvanceRecoveryRetention");
    }

    // Interim BalanceContractAmt

    public void BalanceContractAmt() {
        double balanceamt = 0;
        double tot_amt =
            cont_Amt.getValue() == null ? 0 : Double.parseDouble(cont_Amt.getValue().toString());
        double prev_amt =
            prevAppl.getValue() == null ? 0 : Double.parseDouble(prevAppl.getValue().toString());
        double cur_amt =
            CurApplication.getValue() == null ? 0 : Double.parseDouble(CurApplication.getValue().toString());
        balanceamt = tot_amt - prev_amt - cur_amt;
        applicationHrdVO.getCurrentRow().setAttribute("BalContAmt",
                                                      new BigDecimal(balanceamt));
        AdfFacesContext.getCurrentInstance().addPartialTarget(bal_Cont_Amt);

    }

    // ????

    public void netpaymentamt() {
        double netpayamt = 0;
        double cur_app =
            CurApplication.getValue() == null ? 0 : Double.parseDouble(CurApplication.getValue().toString());
        double cur_adv_rec =
            CurAdvRec.getValue() == null ? 0 : Double.parseDouble(CurAdvRec.getValue().toString());
        double cur_ret =
            CurRet.getValue() == null ? 0 : Double.parseDouble(CurRet.getValue().toString());
        double cur_mat_ret =
            applicationHrdVO.getCurrentRow().getAttribute("CurMatAdvRec") ==
            null ? 0 :
            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurMatAdvRec").toString());
        //            cur_mat_adv_rec.getValue() == null ? 0 : Double.parseDouble(cur_mat_adv_rec.getValue().toString());
        netpayamt = cur_app - (cur_adv_rec + cur_ret + cur_mat_ret);
        System.out.println("curpayamount: 5");
        applicationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                      new BigDecimal(netpayamt));
        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);

    }

    // ????

    public void PaymentAmtInt() {
        try {
            double sum = 0;
            double CurAppl =
                CurApplication.getValue() == null ? 0 : Double.parseDouble(CurApplication.getValue().toString());
            double CurAdvrec =
                CurAdvRec.getValue() == null ? 0 : Double.parseDouble(CurAdvRec.getValue().toString());
            double Curret =
                CurRet.getValue() == null ? 0 : Double.parseDouble(CurRet.getValue().toString());
            //System.err.println("====Curret====" + Curret);
            sum = CurAppl - CurAdvrec - Curret;
            //System.err.println("======Payment Amount Interim close======" +
//                               sum);
            
        System.out.println("curpayamount: 6");
            applicationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                          new BigDecimal(sum));
            AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);
        } catch (Exception e) {
            //System.err.println("====Error====" + e);
        }
    }

    // Interim  CurrentApplicationAmount

    public void CurrentApplicationAmount() {
        try {
            RowSetIterator Applines =
                applicationLineVO.createRowSetIterator(null);
            double sum = 0;
            while (Applines.hasNext()) {
                Row r = Applines.next();
                if (r.getAttribute("CurrAmount") != null) {
                    sum = sum + Double.parseDouble(r.getAttribute("CurrAmount").toString());
                }
            }
            System.out.println("=====Current Application=====" + sum);
            applicationHrdVO.getCurrentRow().setAttribute("CurApplication",
                                                          new BigDecimal(sum));
            AdfFacesContext.getCurrentInstance().addPartialTarget(CurApplication);
            
        } catch (Exception e) {
            //System.err.println("====Error====" + e);
        }
        System.err.println("CurrentApplicationAmount");
    }

    // Interim  PreviousAppliedAmount

    public void PreviousAppliedAmount() {
        ViewObject previousVO =
            ADFUtils.findIterator("PreviousAppCalIterator").getViewObject();
        double sum = 0;
        String Hid =
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
        String ver =
            applicationHrdVO.getCurrentRow().getAttribute("Version") == null ?
            "0" :
            applicationHrdVO.getCurrentRow().getAttribute("Version").toString();
        String apphdrid =
            applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
        //System.err.println("Hid--->" + Hid + "apphdrid--->" + apphdrid +
//                           "ver--->" + ver);
        previousVO.setNamedWhereClauseParam("BV_HID", Hid);
        previousVO.setNamedWhereClauseParam("APP_HDR_ID", apphdrid);
        previousVO.setNamedWhereClauseParam("VER", ver);
        previousVO.executeQuery();
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            RowSetIterator rs = AdvancRecVO.createRowSet(null);
            while (rs.hasNext()) {
                Row r = rs.next();
                sum +=
Double.parseDouble(r.getAttribute("RecoveredAmt").toString());
            }
        }
        if (previousVO.getEstimatedRowCount() == 1) {
            // Previous Application
            //System.err.println("Inside=====" +
//                               previousVO.first().getAttribute("Prevamount"));
            applicationHrdVO.getCurrentRow().setAttribute("PrevApplication",
                                                          previousVO.first().getAttribute("Prevamount"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(prevAppl);
            if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                applicationHrdVO.getCurrentRow().setAttribute("PrevAdvRec",
                                                              previousVO.first().getAttribute("Preadvrec"));
            } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {

                applicationHrdVO.getCurrentRow().setAttribute("PrevAdvRec",
                                                              previousVO.first().getAttribute("Preadvrec"));
                AdfFacesContext.getCurrentInstance().addPartialTarget(PrevAdvRec);
            }
            // Previous Adv Reco

            // Previous Adv Reten
            applicationHrdVO.getCurrentRow().setAttribute("PrevRet",
                                                          previousVO.first().getAttribute("Preretrec"));
            //System.err.println("Inside1111=====" +
//                               previousVO.first().getAttribute("Preretrec"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(PrevRet);
            // Previous Material
            applicationHrdVO.getCurrentRow().setAttribute("PrevMatAdvAmt",
                                                          previousVO.first().getAttribute("Prematadvrec"));
            //System.err.println("prev - - > " +
//                               previousVO.first().getAttribute("Prevothchargeamt"));
            applicationHrdVO.getCurrentRow().setAttribute("PrevOthCharge",
                                                          previousVO.first().getAttribute("Prevothchargeamt"));
            //            applicationHrdVO.getCurrentRow().setAttribute("PerRetRel",
            //                                                          previousVO.first().getAttribute("Prevretrel"));
        } else {

        }
        /*
        double cur_bal_adv_rec = 0;
        double prevAdv = 0;
        double prevRet = 0;
        double prevmatadv = 0;
        double prevAmount = 0;

        try {

            RowSetIterator Applines =applicationLineVO.createRowSetIterator(null);
            double sum = 0;
            double advper =applicationHrdVO.getCurrentRow().getAttribute("Curadvrecper") ==null ? 0
                           :Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Curadvrecper").toString());
            double Retper =applicationHrdVO.getCurrentRow().getAttribute("Curretper") ==null ? 0
                            :Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Curretper").toString());
            double matper =applicationHrdVO.getCurrentRow().getAttribute("Curmatadvrecper") ==null ? 0
                           :Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Curmatadvrecper").toString());

            while (Applines.hasNext()) {
                Row r = Applines.next();
                prevAmount = r.getAttribute("PrevAmount") == null ? 0 : Double.parseDouble(r.getAttribute("PrevAmount").toString());
                sum = sum + prevAmount;
            }

            prevAdv = (sum * advper) / 100;
            prevRet = (sum * Retper) / 100;
            prevmatadv = (sum * matper) / 100;

            //            //System.err.println("=====Previous Applied Amount=====" + sum);
            // Previous Application
            applicationHrdVO.getCurrentRow().setAttribute("PrevApplication",new BigDecimal(df.format(sum)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(prevAppl);
            // Previous Adv Reco
            applicationHrdVO.getCurrentRow().setAttribute("PrevAdvRec",new BigDecimal(df.format(prevAdv)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(PrevAdvRec);
            // Previous Adv Reten
            applicationHrdVO.getCurrentRow().setAttribute("PrevRet",new BigDecimal(df.format(prevRet)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(PrevRet);
            // Previous Material
            applicationHrdVO.getCurrentRow().setAttribute("PrevMatAdvAmt",new BigDecimal(df.format(prevmatadv)));

        } catch (Exception e) {
            //System.err.println("====Error====" + e);
        }
*/
        System.err.println("PreviousAppliedAmount");
    }
    // ????

    public void TotalAdvanceAmount() {
        Row r = applicationHrdVO.getCurrentRow();
        //System.err.println("======Row count====" +
//                           applicationHrdVO.getEstimatedRowCount());
        double Totadvamount = 0;
        //System.err.println("====VAL1=====" +
//                           r.getAttribute("Trans_Revis_Cont_Amount") +
//                           "*********" +
//                           r.getAttribute("Trans_Advan_Rec_Per"));
        if (r.getAttribute("Trans_Revis_Cont_Amount") != null &&
            r.getAttribute("Trans_Advan_Rec_Per") != null) {
            Totadvamount =
                    (Double.parseDouble(r.getAttribute("Trans_Revis_Cont_Amount").toString()) *
                     Double.parseDouble(r.getAttribute("Trans_Advan_Rec_Per").toString())) /
                    100;
        }
        System.out.println("======TotalAdvanceAmount======" + Totadvamount);
        if (paymentType.getValue().toString().equalsIgnoreCase("Advance")) {

        } else {
            applicationHrdVO.getCurrentRow().setAttribute("TotalAdvAmount",
                                                          new BigDecimal(Totadvamount));
            AdfFacesContext.getCurrentInstance().addPartialTarget(TotalAdvAmount);
        }


    }

    // ????

    public void TotalRetention() {
        Row r = applicationHrdVO.getCurrentRow();
        //System.err.println("======Row count====" +
//                           applicationHrdVO.getEstimatedRowCount());
        double sum = 0;
        //System.err.println("====VAL1=====" +
//                           r.getAttribute("Trans_Revis_Cont_Amount") +
//                           "*********" +
//                           r.getAttribute("Trans_Retension_Per"));
        if (r.getAttribute("Trans_Revis_Cont_Amount") != null &&
            r.getAttribute("Trans_Retension_Per") != null) {
            sum =
(Double.parseDouble(r.getAttribute("Trans_Revis_Cont_Amount").toString()) *
 Double.parseDouble(r.getAttribute("Trans_Retension_Per").toString())) / 100;
        }
        //System.err.println("======TotalRetention======" + sum);
        applicationHrdVO.getCurrentRow().setAttribute("TotalRet",
                                                      new BigDecimal(sum));
        AdfFacesContext.getCurrentInstance().addPartialTarget(TotalRet);

    }


    /***********Interim==Current Advance Recovery*****************************/
    public void totalCumulative() {
        try {
            RowSetIterator Applines =
                applicationLineVO.createRowSetIterator(null);
            double sum = 0;
            while (Applines.hasNext()) {
                Row r = Applines.next();
                if (r.getAttribute("CumAmount") != null) {
                    sum =
sum + Double.parseDouble(r.getAttribute("CumAmount").toString());
                }
            }
            //System.err.println("=====Current Application=====" + sum);
            applicationHrdVO.getCurrentRow().setAttribute("CummAmt",
                                                          new BigDecimal(sum));
            AdfFacesContext.getCurrentInstance().addPartialTarget(totCummAmt);
        } catch (Exception e) {
            //System.err.println("====Error====" + e);
        }
System.err.println("totalCumulative");
    }

    public void CurrentAdvanceRecovery() {
        System.out.println("CurrentAdvanceRecovery: ");
        /**
         * BuysideAdvanceCal
         */
        /**
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
            Row r = applicationHrdVO.getCurrentRow();
            double sum = 0;
            if (r.getAttribute("CurApplication") != null &&
                r.getAttribute("Curadvrecper") != null) {
                System.err.println(" CurApplication is " +
                                   r.getAttribute("CurApplication"));
                System.err.println(" Curadvrecper is " +
                                   r.getAttribute("Curadvrecper"));

                sum =
(Double.parseDouble(r.getAttribute("CurApplication").toString()) *
 Double.parseDouble(r.getAttribute("Curadvrecper").toString())) / 100;
                //System.err.println(" Sum is " + sum);

                if (Double.isNaN(sum)) {
                    //System.err.println("inside Nan if Sum" + sum);
                    sum = 0.00;
                    //System.err.println("inside Nan After setting Sum" + sum);
                } else {
                }
            }
            applicationHrdVO.getCurrentRow().setAttribute("CurAdvRec",
                                                          new BigDecimal(sum));
            AdfFacesContext.getCurrentInstance().addPartialTarget(CurAdvRec);
        }

        if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
**/
            RowSetIterator rs = AdvancRecVO.createRowSet(null);
            double sum1 = 0;
            while (rs.hasNext()) {
                Row r = rs.next();
                System.out.println("r: "+r);
               //System.out.println("r.getAttribute(\"CurRecAmt\").toString(): "+r.getAttribute("CurRecAmt"));
               if(r.getAttribute("CurRecAmt") != null){
                   sum1 += Double.parseDouble(r.getAttribute("CurRecAmt").toString());
               }
            }
            applicationHrdVO.getCurrentRow().setAttribute("CurAdvRec",
                                                          new BigDecimal(sum1));
            AdfFacesContext.getCurrentInstance().addPartialTarget(CurAdvRec);
    }


    /***********Interim==Current Material Advance Recovery*********************/

    public void CurrentMaterialAdvanceRecovery() {
        Row r = applicationHrdVO.getCurrentRow();
        double sum = 0;
        if (r.getAttribute("CurApplication") != null &&
            r.getAttribute("Curmatadvrecper") != null) {
            sum =
(Double.parseDouble(r.getAttribute("CurApplication").toString()) *
 Double.parseDouble(r.getAttribute("Curmatadvrecper").toString())) / 100;
        }
        //        //System.err.println("======CurrentAdvanceRecovery======" + sum);
        applicationHrdVO.getCurrentRow().setAttribute("CurMatAdvRec",
                                                      new BigDecimal(sum));
        AdfFacesContext.getCurrentInstance().addPartialTarget(cur_mat_adv_rec);
    }

    // ????

    public void CurrentRetention() {
        Row r = applicationHrdVO.getCurrentRow();
        double sum = 0;
        if (r.getAttribute("CurApplication") != null &&
            r.getAttribute("Trans_Retension") != null) {
            sum = (Double.parseDouble(r.getAttribute("CurApplication").toString()) *
                    Double.parseDouble(r.getAttribute("Trans_Retension").toString())) / 100;
        }
        applicationHrdVO.getCurrentRow().setAttribute("CurRet", new BigDecimal(sum));
        AdfFacesContext.getCurrentInstance().addPartialTarget(CurRet);
    }
    // Interim Balance Advance Recovery

    public void BalanceAdvanceRecovery() {
        System.out.println("======Start of BalanceAdvanceRecovery Method======");
        try {
            double sum = 0;
            double TotalAdvAmt =
                applicationHrdVO.getCurrentRow().getAttribute("TotalAdvAmount") == 
                null ? 0 : 
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("TotalAdvAmount").toString());
            double PrevAdvAmt =
                PrevAdvRec.getValue() == null ? 0 : Double.parseDouble(PrevAdvRec.getValue().toString());
            double curAdvRev =
                CurAdvRec.getValue() == null ? 0 : Double.parseDouble(CurAdvRec.getValue().toString());
            sum = TotalAdvAmt - PrevAdvAmt - curAdvRev;
            System.out.println("TotalAdvAmt 111--" + TotalAdvAmt+"PrevAdvAmt: "+PrevAdvAmt
                               +"curAdvRev: "+curAdvRev);
            double TotalAmt =
                applicationHrdVO.getCurrentRow().getAttribute("TotalAdvAmount") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("TotalAdvAmount").toString());
            double preAmt =
                applicationHrdVO.getCurrentRow().getAttribute("PrevAdvRec") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("PrevAdvRec").toString());
            double Amt = TotalAmt - preAmt;
            double curAmt =
                applicationHrdVO.getCurrentRow().getAttribute("CurApplication") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurApplication").toString());

            if (Amt != 0 && curAmt != 0) {
                double checkAdvRecPer1 = (Amt * 100 / curAmt);
                System.out.println("checkAdvRecPer1: "+checkAdvRecPer1);
                double AdvRecPer =
                    applicationHrdVO.getCurrentRow().getAttribute("Curadvrecper") ==
                    null ? 0 :
                    Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Curadvrecper").toString());
                int checkAdvRecPer = (int) Math.round(checkAdvRecPer1);
                System.out.println("checkAdvRecPer:"+checkAdvRecPer);
                if (checkAdvRecPer >= AdvRecPer) {
                    System.out.println("Balance Adv Rec sum 1111:"+sum);
                    applicationHrdVO.getCurrentRow().setAttribute("BalanceAdvRec",
                                                                  new BigDecimal(sum));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(BalanceAdvRec);
                } else {
                    applicationHrdVO.getCurrentRow().setAttribute("Curadvrecper",
                                                                  null);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(curAdvRecPer);
                    applicationHrdVO.getCurrentRow().setAttribute("CurAdvRec",
                                                                  null);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(CurAdvRec);
                    applicationHrdVO.getCurrentRow().setAttribute("BalanceAdvRec",
                                                                  null);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(BalanceAdvRec);
                    JSFUtils.addFacesErrorMessage("Advance Recovery Amount Should not Exit the Limit. Maximum Limited Percentage: " +
                                                  checkAdvRecPer);
                }
            } else if (Amt == 0) {
                //                JSFUtils.addFacesErrorMessage("Please set Advance Recovery %:0");
                applicationHrdVO.getCurrentRow().setAttribute("Curadvrecper",
                                                              Amt);
                AdfFacesContext.getCurrentInstance().addPartialTarget(curAdvRecPer);
                applicationHrdVO.getCurrentRow().setAttribute("CurAdvRec",
                                                              Amt);
                AdfFacesContext.getCurrentInstance().addPartialTarget(CurAdvRec);
                System.out.println("Amt 1 :" +Amt);
                applicationHrdVO.getCurrentRow().setAttribute("BalanceAdvRec",
                                                              Amt);
                AdfFacesContext.getCurrentInstance().addPartialTarget(BalanceAdvRec);
            } else {
                JSFUtils.addFacesErrorMessage("Please check Current Bill Amount");
            }
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        System.out.println("======End of BalanceAdvanceRecovery Method======");
    }
    

    public void BalanceMaterialAdvanceRecovery() {
        System.out.println("======Start of BalanceMaterialAdvanceRecovery Method======");
        try {
            double sum = 0;
            double TotalMatAdvAmt =
                tot_mat_adv_amt.getValue() == null ? 0 : Double.parseDouble(tot_mat_adv_amt.getValue().toString());
            double curmatadv =
                applicationHrdVO.getCurrentRow().getAttribute("CurMatAdvRec") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurMatAdvRec").toString());
            //                cur_mat_adv_rec.getValue() == null ? 0 : Double.parseDouble(cur_mat_adv_rec.getValue().toString());
            double prevmatadv =
                prev_mat_adv_rec.getValue() == null ? 0 : Double.parseDouble(prev_mat_adv_rec.getValue().toString());
            sum = TotalMatAdvAmt - prevmatadv - curmatadv;
            //            //System.err.println("======BalanceMaterialAdvanceRecovery======" +sum);


            double TotalAmt =
                applicationHrdVO.getCurrentRow().getAttribute("TotalMatAdvAmount") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("TotalMatAdvAmount").toString());
            double preAmt =
                applicationHrdVO.getCurrentRow().getAttribute("PrevMatAdvAmt") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("PrevMatAdvAmt").toString());
            double Amt = TotalAmt - preAmt;
            double curAmt =
                applicationHrdVO.getCurrentRow().getAttribute("CurApplication") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurApplication").toString());

            if (Amt != 0) {
                double checkMatAdvRecPer = (Amt * 100 / curAmt);
                double MatAdvRecPer =
                    applicationHrdVO.getCurrentRow().getAttribute("Curmatadvrecper") ==
                    null ? 0 :
                    Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Curmatadvrecper").toString());
                //System.out.println("--%Expected--" + checkMatAdvRecPer +
//                                   "--% Got---" + MatAdvRecPer);
                if (checkMatAdvRecPer >= MatAdvRecPer) {
                    applicationHrdVO.getCurrentRow().setAttribute("BalMatAdvRec",
                                                                  new BigDecimal(sum));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(bal_mat_adv_rec);
                } else {
                    applicationHrdVO.getCurrentRow().setAttribute("CurMatAdvRec",
                                                                  null);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(cur_mat_adv_rec);
                    applicationHrdVO.getCurrentRow().setAttribute("BalMatAdvRec",
                                                                  null);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(bal_mat_adv_rec);
                    applicationHrdVO.getCurrentRow().setAttribute("Curmatadvrecper",
                                                                  null);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(curMatAdvRecPer);
                    JSFUtils.addFacesErrorMessage("Material Advance Recovery Amount Should not Exit the Limit. Maximum Limited Percentage: " +
                                                  checkMatAdvRecPer);
                }
            } else if (Amt == 0) {
                //                JSFUtils.addFacesErrorMessage("Please set Material Advance Recovery %:0");
                applicationHrdVO.getCurrentRow().setAttribute("Curmatadvrecper",
                                                              Amt);
                AdfFacesContext.getCurrentInstance().addPartialTarget(curMatAdvRecPer);
                applicationHrdVO.getCurrentRow().setAttribute("CurMatAdvRec",
                                                              Amt);
                AdfFacesContext.getCurrentInstance().addPartialTarget(cur_mat_adv_rec);
                applicationHrdVO.getCurrentRow().setAttribute("BalMatAdvRec",
                                                              Amt);
                AdfFacesContext.getCurrentInstance().addPartialTarget(bal_mat_adv_rec);
            } else {
                JSFUtils.addFacesErrorMessage("Please check Current Bill Amount");
            }

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        System.out.println("======End of BalanceMaterialAdvanceRecovery Method======");
    }

    public void BalanceRetention() {
        System.out.println("======Start of BalanceRetention Method======");
        try {
            double sum = 0;
            double TotalReten =
                TotalRet.getValue() == null ? 0 : Double.parseDouble(TotalRet.getValue().toString());
            double PrevRe =
                PrevRet.getValue() == null ? 0 : Double.parseDouble(PrevRet.getValue().toString());
            double curRet =
                CurRet.getValue() == null ? 0 : Double.parseDouble(CurRet.getValue().toString());
            sum = TotalReten - PrevRe - curRet;
            System.out.println("======Balance Retention======" + TotalReten+" : "
                               +PrevRe+": "+curRet);
            double TotalAmt =
                applicationHrdVO.getCurrentRow().getAttribute("TotalRet") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("TotalRet").toString());
            double preAmt =
                applicationHrdVO.getCurrentRow().getAttribute("PrevRet") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("PrevRet").toString());
            double Amt = TotalAmt - preAmt;
            double curAmt =
                applicationHrdVO.getCurrentRow().getAttribute("CurApplication") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurApplication").toString());
System.out.println("AMOUNT: "+Amt);
            if (Amt != 0) {
                double checkRetRecPer = (Amt * 100 / curAmt);
                double MatAdvRecPer =
                    applicationHrdVO.getCurrentRow().getAttribute("Curretper") ==
                    null ? 0 :
                    Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Curretper").toString());
                //System.out.println("--%Expected--" + checkRetRecPer +
//                                   "--% Got---" + MatAdvRecPer);
                if (checkRetRecPer >= MatAdvRecPer) {
                System.out.println("SUM: "+sum);
                    applicationHrdVO.getCurrentRow().setAttribute("BalanceRet",
                                                                  new BigDecimal(sum));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(BalanceRet);
                } else {
                    applicationHrdVO.getCurrentRow().setAttribute("CurRet",
                                                                  null);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(CurRet);
                    applicationHrdVO.getCurrentRow().setAttribute("BalanceRet",
                                                                  null);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(BalanceRet);
                    applicationHrdVO.getCurrentRow().setAttribute("Curretper",
                                                                  null);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(ret_per);
                    JSFUtils.addFacesErrorMessage("Retention Recovery Amount Should not Exit the Limit. Maximum Limited Percentage:" +
                                                  checkRetRecPer);
                }
            } else if (Amt == 0) {
                //                 JSFUtils.addFacesErrorMessage("Please set Retention Recovery %:0");
                applicationHrdVO.getCurrentRow().setAttribute("Curretper",
                                                              Amt);
                AdfFacesContext.getCurrentInstance().addPartialTarget(ret_per);
                applicationHrdVO.getCurrentRow().setAttribute("CurRet", Amt);
                AdfFacesContext.getCurrentInstance().addPartialTarget(CurRet);
                applicationHrdVO.getCurrentRow().setAttribute("BalanceRet",
                                                              Amt);
                AdfFacesContext.getCurrentInstance().addPartialTarget(BalanceRet);
            } else {
                JSFUtils.addFacesErrorMessage("Please check Current Bill Amount");
            }

        } catch (Exception e) {
            
        }
        System.out.println("======End of BalanceRetention Method======");
    }
    // ????

    public void PrevAdvRecoveryRetention() {
        try {
            String AppHdrId =
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
            String ContHdrId =
                applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
            String Version =
                applicationHrdVO.getCurrentRow().getAttribute("Version") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("Version").toString();
            //System.err.println("Headerid===" + AppHdrId + "contid====" +
//                               ContHdrId + "Version====" + Version);
            PrevAdvAndRetCal.setNamedWhereClauseParam("BV_HDR_ID", ContHdrId);
            PrevAdvAndRetCal.setNamedWhereClauseParam("BV_VER", Version);
            PrevAdvAndRetCal.setNamedWhereClauseParam("BV_APP_HDR_ID",
                                                      AppHdrId);
            PrevAdvAndRetCal.executeQuery();
            if (PrevAdvAndRetCal.first() != null) {
                //System.err.println("===============Previous advance recovery===============" +
//                                   PrevAdvAndRetCal.first().getAttribute("PrevAdvRec"));
                applicationHrdVO.getCurrentRow().setAttribute("PrevAdvRec",
                                                              PrevAdvAndRetCal.first().getAttribute("PrevAdvRec"));
                AdfFacesContext.getCurrentInstance().addPartialTarget(PrevAdvRec);
                //System.err.println("===============Previous Retention===============" +
//                                   PrevAdvAndRetCal.first().getAttribute("PrevRet"));
                applicationHrdVO.getCurrentRow().setAttribute("PrevRet",
                                                              PrevAdvAndRetCal.first().getAttribute("PrevRet"));
                AdfFacesContext.getCurrentInstance().addPartialTarget(PrevRet);
            } else {
                applicationHrdVO.getCurrentRow().setAttribute("PrevAdvRec",
                                                              "0");
                AdfFacesContext.getCurrentInstance().addPartialTarget(PrevAdvRec);
                applicationHrdVO.getCurrentRow().setAttribute("PrevRet", "0");
                AdfFacesContext.getCurrentInstance().addPartialTarget(PrevRet);
            }
        } catch (Exception e) {
            //System.err.println("====Error====" + e);
        }
    }

    public void setTotalAdvAmount(RichInputText TotalAdvAmount) {
        this.TotalAdvAmount = TotalAdvAmount;
    }

    public RichInputText getTotalAdvAmount() {
        return TotalAdvAmount;
    }

    public void setPrevAppl(RichInputText prevAppl) {
        this.prevAppl = prevAppl;
    }

    public RichInputText getPrevAppl() {
        return prevAppl;
    }

    public void setCurApplication(RichInputText CurApplication) {
        this.CurApplication = CurApplication;
    }

    public RichInputText getCurApplication() {
        return CurApplication;
    }

    public void setBalanceAdvRec(RichInputText BalanceAdvRec) {
        this.BalanceAdvRec = BalanceAdvRec;
    }

    public RichInputText getBalanceAdvRec() {
        return BalanceAdvRec;
    }

    public void setBalanceRet(RichInputText BalanceRet) {
        this.BalanceRet = BalanceRet;
    }

    public RichInputText getBalanceRet() {
        return BalanceRet;
    }

    public void setPrevAdvRec(RichInputText PrevAdvRec) {
        this.PrevAdvRec = PrevAdvRec;
    }

    public RichInputText getPrevAdvRec() {
        return PrevAdvRec;
    }

    public void setPrevRet(RichInputText PrevRet) {
        this.PrevRet = PrevRet;
    }

    public RichInputText getPrevRet() {
        return PrevRet;
    }

    public void setCurRet(RichInputText CurRet) {
        this.CurRet = CurRet;
    }

    public RichInputText getCurRet() {
        return CurRet;
    }

    public void setCurAdvRec(RichInputText CurAdvRec) {
        this.CurAdvRec = CurAdvRec;
    }

    public RichInputText getCurAdvRec() {
        return CurAdvRec;
    }

    public void setTotalRet(RichInputText TotalRet) {
        this.TotalRet = TotalRet;
    }

    public RichInputText getTotalRet() {
        return TotalRet;
    }

    public void setPaymentType(RichSelectOneChoice paymentType) {
        this.paymentType = paymentType;
    }

    public RichSelectOneChoice getPaymentType() {
        return paymentType;
    }

    public void setCurPayAmount(RichInputText curPayAmount) {
        this.curPayAmount = curPayAmount;
    }

    public RichInputText getCurPayAmount() {
        return curPayAmount;
    }


    public void onChanegeApplicationType(ValueChangeEvent valueChangeEvent) {

        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        //System.err.println("OLD Value" + valueChangeEvent.getOldValue());
        //System.err.println("New Value" + valueChangeEvent.getNewValue());

        if (valueChangeEvent.getNewValue() != null) {
            if (valueChangeEvent.getNewValue().toString().equalsIgnoreCase("Advance")) {
                if (applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Rec_Per") !=
                    null) {
                    String contractHeaderID =
                        applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
                        null ? "0" :
                        applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
                    String versionID =
                        applicationHrdVO.getCurrentRow().getAttribute("Version") ==
                        null ? "" :
                        applicationHrdVO.getCurrentRow().getAttribute("Version").toString();
                    double totalAdvanceAmount =
                        applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Recovery") ==
                        null ? 0 :
                        Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Recovery").toString());
                    // filter Application Header
                    certificationamountVO.setNamedWhereClauseParam("BV_Header_id",
                                                                   contractHeaderID);
                    certificationamountVO.setNamedWhereClauseParam("BV_Payment_type",
                                                                   "Advance");
                    certificationamountVO.executeQuery();
                    //System.err.println("===row count===" +
//                                       certificationamountVO.getEstimatedRowCount());
                    double count =
                        certificationamountVO.first().getAttribute("Amount") ==
                        null ? 0 :
                        Double.parseDouble(certificationamountVO.first().getAttribute("Amount").toString());
                    //System.err.println("==Count==" + count);
                    if (count == 0) {
                        TotalAdvanceAmount1();
                        paymentType.setDisabled(Boolean.TRUE);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);
                    } else {
                        double curr_amt = 0;
                        double balance = 0;
                        double amountTotal =
                            Double.parseDouble(certificationamountVO.getCurrentRow().getAttribute("Amount").toString());
                        curr_amt = totalAdvanceAmount - amountTotal;
                        if (curr_amt == 0) {
                            JSFUtils.addFacesErrorMessage("Advance Cannot be created for this contract");
                            paymentType.setDisabled(Boolean.FALSE);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);
                        } else {
                            applicationHrdVO.getCurrentRow().setAttribute("PrevApplication",
                                                                          amountTotal);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(prevAppl);
                            applicationHrdVO.getCurrentRow().setAttribute("CurApplication",
                                                                          curr_amt);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(CurApplication);
                            balance =
                                    totalAdvanceAmount - (curr_amt + amountTotal);
                            applicationHrdVO.getCurrentRow().setAttribute("BalContAmt",
                                                                          balance);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(bal_Cont_Amt);
                            paymentType.setDisabled(Boolean.TRUE);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);

                        }
                    }
                } else {
                    JSFUtils.addFacesErrorMessage("Please check Advance Percentage value");
                    paymentType.setDisabled(Boolean.FALSE);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);
                }

            } else if (valueChangeEvent.getNewValue().toString().equalsIgnoreCase("Interim")) {

                // Get contract id and version
                String appContID =
                    applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
                String appVersion =
                    applicationHrdVO.getCurrentRow().getAttribute("Version") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("Version").toString();
                //System.err.println("--contID---" + appContID + "-Version--" +
//                                   appVersion);
                //Checking ApplicationHdrId
                String appHdrId =
                    applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();

                // Checking Advance and Material Advance Recovery
                ViewObject checkPaymentTypeVO =
                    ADFUtils.findIterator("checkPaymentType_ROVO1Iterator").getViewObject();
                checkPaymentTypeVO.setNamedWhereClauseParam("BV_HID",
                                                            appContID);
                checkPaymentTypeVO.setNamedWhereClauseParam("BV_TYPE",
                                                            "Advance");
                checkPaymentTypeVO.executeQuery();

                String advanceFlag =
                    checkPaymentTypeVO.first().getAttribute("Status") == null ?
                    "N" :
                    checkPaymentTypeVO.first().getAttribute("Status").toString();
                if (advanceFlag.equalsIgnoreCase("N")) {
                    applicationHrdVO.getCurrentRow().setAttribute("Curadvrecper",
                                                                  0);
                    curAdvRecPer.setDisabled(Boolean.TRUE);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(curAdvRecPer);
                }
                // Checking previous application other charges

                //                prevOthChrg.setNamedWhereClauseParam("BV_CONT_ID", appContID);
                //                prevOthChrg.setNamedWhereClauseParam("BV_APP_ID", appHdrId);
                //                prevOthChrg.executeQuery();
                // Materila Advance Recovery
                checkPaymentTypeVO.setNamedWhereClauseParam("BV_HID",
                                                            appContID);
                checkPaymentTypeVO.setNamedWhereClauseParam("BV_TYPE",
                                                            "Material Advance");
                checkPaymentTypeVO.executeQuery();
                String matSdvanceFlag =
                    checkPaymentTypeVO.first().getAttribute("Status") == null ?
                    "N" :
                    checkPaymentTypeVO.first().getAttribute("Status").toString();
                if (matSdvanceFlag.equalsIgnoreCase("N")) {
                    applicationHrdVO.getCurrentRow().setAttribute("Curmatadvrecper",
                                                                  0);
                    curMatAdvRecPer.setDisabled(Boolean.TRUE);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(curMatAdvRecPer);
                }

                // Filtering contract line VO
                ViewCriteria contractLineVC =
                    contractLineVO.createViewCriteria();
                ViewCriteriaRow contractLineVCRow =
                    contractLineVC.createViewCriteriaRow();
                contractLineVCRow.setAttribute("ContHeaderId", appContID);
                contractLineVCRow.setAttribute("Version", appVersion);
                contractLineVC.addRow(contractLineVCRow);
                contractLineVO.applyViewCriteria(contractLineVC);
                contractLineVO.executeQuery();
                //System.err.println("==COUNT==" +
//                                   contractLineVO.getEstimatedRowCount());

                // Iteration on contract line
                RowSetIterator contractRs =
                    contractLineVO.createRowSetIterator(null);
                while (contractRs.hasNext()) {
                    Row contracrLineRow = contractRs.next();
                    Object hid = contracrLineRow.getAttribute("ContHeaderId");
                    Object lid = contracrLineRow.getAttribute("ContLineId");
                    Object version = contracrLineRow.getAttribute("Version");
                    Object taxCode = contracrLineRow.getAttribute("TaxCode");
                    Object taxRate = contracrLineRow.getAttribute("TaxRate");
                    Object taxAmt = contracrLineRow.getAttribute("TaxAmount");
                    Object ecpPer =
                        contracrLineRow.getAttribute("EcpPercentage");
                    Object ecpAmt =
                        contracrLineRow.getAttribute("EcpTotalAmount");
                    // Filtering Application Line---check contract line=0 or not

                    Object origAmt =
                        contracrLineRow.getAttribute("OrigAmount");
                    double origAmount = origAmt == null ? 0 : Double.parseDouble(origAmt.toString());
                    //Double origAmount = Double.parseDouble(origAmt.toString());
                    System.out.println("origAmt: "+origAmt);
                    Object origQty =
                        contracrLineRow.getAttribute("OrigQuantity");
                    System.out.println("origQty: "+origQty);
                    double origQuantity = origQty == null ? 0 : Double.parseDouble(origQty.toString());
                    //Double origQuantity = Double.parseDouble(origQty.toString());
                    ViewCriteria appVO =
                        applicationLineVO2.createViewCriteria();
                    ViewCriteriaRow appVCR = appVO.createViewCriteriaRow();
                    appVCR.setAttribute("ContLineId", lid);
                    appVO.addRow(appVCR);
                    applicationLineVO2.applyViewCriteria(appVO);
                    applicationLineVO2.executeQuery();
                    //System.err.println("Total applicationLine Count--" +
//                                       applicationLineVO2.getEstimatedRowCount());
                    long TotalRowAppCount =
                        applicationLineVO2.getEstimatedRowCount();
                    //Equal to 0
                    if (applicationLineVO2.getEstimatedRowCount() == 0) {
                        //Application line Row adding
                        Row appLineRow = applicationLineVO.createRow();
                        appLineRow.setAttribute("ContHeaderId", hid);
                        appLineRow.setAttribute("ContLineId", lid);
                        appLineRow.setAttribute("Version", version);
                        appLineRow.setAttribute("ApplHeaderId",
                                                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId"));
                        appLineRow.setAttribute("OrgId",
                                                applicationHrdVO.getCurrentRow().getAttribute("OrgId"));
                        appLineRow.setAttribute("TaxCode", taxCode);
                        appLineRow.setAttribute("TaxRate", taxRate);
                        appLineRow.setAttribute("EcpPercentage", ecpPer);
                        appLineRow.setAttribute("EcpTotalAmount", ecpAmt);
                        applicationLineVO.insertRow(appLineRow);

                    } else {
                        double totalPer = 0;
                        double totalQty = 0;
                        double totalAmt = 0;
                        previousCalculationVO.setNamedWhereClauseParam("BV_CONT_HRDID",
                                                                       hid);
                        previousCalculationVO.setNamedWhereClauseParam("BV_VER",
                                                                       version);
                        previousCalculationVO.setNamedWhereClauseParam("BV_CONT_LNEID",
                                                                       lid);
                        previousCalculationVO.setNamedWhereClauseParam("APP_HRDID",
                                                                       applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId"));
                        previousCalculationVO.executeQuery();
                        //                        previousCalculationVO.getEstimatedRowCount();
                        //System.err.println("Pre Qty, % Amt===COUNT==" +
//                                           previousCalculationVO.getEstimatedRowCount());
                        if (previousCalculationVO.getEstimatedRowCount() ==
                            0) {
                            totalPer = 0;
                            totalQty = 0;
                            totalAmt = 0;
                        } else {
                            totalQty =
                                    previousCalculationVO.first().getAttribute("ApplPrevQty") ==
                                    null ? 0 :
                                    Double.parseDouble(previousCalculationVO.first().getAttribute("ApplPrevQty").toString());
                            totalPer =
                                    previousCalculationVO.first().getAttribute("ApplPrevPerc") ==
                                    null ? 0 :
                                    Double.parseDouble(previousCalculationVO.first().getAttribute("ApplPrevPerc").toString());
                            totalAmt =
                                    previousCalculationVO.first().getAttribute("ApplPrevAmount") ==
                                    null ? 0 :
                                    Double.parseDouble(previousCalculationVO.first().getAttribute("ApplPrevAmount").toString());
                            System.out.println("totalQty---" + totalQty +
                                               "totalPer-----" + totalPer +
                                               "totalAmt---" + totalAmt);
                            if(totalPer != 0 && origAmount != 0){
                                totalPer = (totalAmt/origAmount)*100;
                                totalQty = (totalAmt/origAmount)*origQuantity;
                            }
                            else if(origAmount == 0){
                                totalQty = 0;
                                totalPer = 0;
                                totalAmt = 0;
                            }
                            
                        }
                        //Application line Row adding
                        Row appLineRow = applicationLineVO.createRow();
                        appLineRow.setAttribute("ContHeaderId", hid);
                        appLineRow.setAttribute("ContLineId", lid);
                        appLineRow.setAttribute("Version", version);
                        appLineRow.setAttribute("EcpPercentage", ecpPer);
                        appLineRow.setAttribute("EcpTotalAmount", ecpAmt);
                        appLineRow.setAttribute("ApplHeaderId",
                                                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId"));
                        appLineRow.setAttribute("TaxCode", taxCode);
                        appLineRow.setAttribute("TaxRate", taxRate);
                        appLineRow.setAttribute("PrevPerc", new BigDecimal(totalPer).setScale(2, BigDecimal.ROUND_HALF_EVEN));
                                                System.out.println("inside the totalQty: ");
                        appLineRow.setAttribute("PrevTotQty",
                                                new BigDecimal(totalQty));
                        appLineRow.setAttribute("PrevAmount",
                                                new BigDecimal(totalAmt));
                        appLineRow.setAttribute("OrgId",
                                                applicationHrdVO.getCurrentRow().getAttribute("OrgId"));
                        //                        appLineRow.setAttribute("CumPerc",new BigDecimal(totalPer));
                        //                        appLineRow.setAttribute("CumTotQty",new BigDecimal(totalQty));
                        //                        appLineRow.setAttribute("CumAmount",new BigDecimal(totalAmt));

                        applicationLineVO.insertRow(appLineRow);
                    }
                }
                applicationLineVO.executeQuery();
                // applicationHrdVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
                //System.err.println("Application Line inserted");
                paymentType.setDisabled(Boolean.TRUE);
                AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);
                setTotalAdvRecAmt();
            } else if (valueChangeEvent.getNewValue().toString().equalsIgnoreCase("Material Advance")) {
                if (applicationHrdVO.getCurrentRow().getAttribute("MaterialAdvancePer") !=
                    null) {
                    String contractHeaderID =
                        applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
                        null ? "0" :
                        applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
                    String versionID =
                        applicationHrdVO.getCurrentRow().getAttribute("Version") ==
                        null ? "" :
                        applicationHrdVO.getCurrentRow().getAttribute("Version").toString();
                    double totalAdvanceAmount =
                        applicationHrdVO.getCurrentRow().getAttribute("MaterialAdvanceAmt") ==
                        null ? 0 :
                        Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("MaterialAdvanceAmt").toString());
                    // filter Application Header
                    certificationamountVO.setNamedWhereClauseParam("BV_Header_id",
                                                                   contractHeaderID);
                    certificationamountVO.setNamedWhereClauseParam("BV_Payment_type",
                                                                   "Material Advance");
                    certificationamountVO.executeQuery();
                    //System.err.println("===row count===" +
//                                       certificationamountVO.getEstimatedRowCount());
                    double count =
                        certificationamountVO.first().getAttribute("Amount") ==
                        null ? 0 :
                        Double.parseDouble(certificationamountVO.first().getAttribute("Amount").toString());
                    //System.err.println("==Count==" + count);
                    if (count == 0) {
                        TotalMaterialAdvAmount1();
                        paymentType.setDisabled(Boolean.TRUE);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);
                    } else {
                        double curr_amt = 0;
                        double balance = 0;
                        double amountTotal =
                            Double.parseDouble(certificationamountVO.getCurrentRow().getAttribute("Amount").toString());
                        curr_amt = totalAdvanceAmount - amountTotal;
                        if (curr_amt == 0) {
                            JSFUtils.addFacesErrorMessage("Material Advance Cannot be created for this contract");
                            paymentType.setDisabled(Boolean.FALSE);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);
                        } else {
                            applicationHrdVO.getCurrentRow().setAttribute("PrevApplication",
                                                                          new BigDecimal(amountTotal));
                            AdfFacesContext.getCurrentInstance().addPartialTarget(prevAppl);
                            curr_amt = totalAdvanceAmount - amountTotal;
                            applicationHrdVO.getCurrentRow().setAttribute("CurApplication",
                                                                          new BigDecimal(curr_amt));
                            AdfFacesContext.getCurrentInstance().addPartialTarget(CurApplication);
                            balance =
                                    totalAdvanceAmount - (curr_amt + amountTotal);
                            applicationHrdVO.getCurrentRow().setAttribute("BalContAmt",
                                                                          new BigDecimal(balance));
                            AdfFacesContext.getCurrentInstance().addPartialTarget(bal_Cont_Amt);
                            paymentType.setDisabled(Boolean.TRUE);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);
                        }
                    }

                } else {
                    JSFUtils.addFacesErrorMessage("Please check Material Advance Percentage value");
                    paymentType.setDisabled(Boolean.FALSE);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);
                }
            } else if (valueChangeEvent.getNewValue().toString().equalsIgnoreCase("Final")) {
                RichPopup.PopupHints hint = new RichPopup.PopupHints();
                this.getP2().show(hint);
            }
        }
System.err.println("onChanegeApplicationType");
    }


    // LOV : Advance Calculation

    public void TotalAdvanceAmount1() {
        //            //System.err.println("======Row count====" +applicationHrdVO.getEstimatedRowCount());
        double Adv_amt = 0;
        Adv_amt =
                tans_Adv_rec.getValue() == null ? 0 : Double.parseDouble(tans_Adv_rec.getValue().toString());
        System.out.println("===Advance Amount===" + Adv_amt);
        applicationHrdVO.getCurrentRow().setAttribute("TotalAdvAmount",
                                                      new BigDecimal(Adv_amt));
        AdfFacesContext.getCurrentInstance().addPartialTarget(TotalAdvAmount);
        applicationHrdVO.getCurrentRow().setAttribute("CurApplication",
                                                      new BigDecimal(Adv_amt));
        AdfFacesContext.getCurrentInstance().addPartialTarget(CurApplication);
        applicationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                      new BigDecimal(Adv_amt));
        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);
        applicationHrdVO.getCurrentRow().setAttribute("PrevApplication", 0);
        AdfFacesContext.getCurrentInstance().addPartialTarget(prevAppl);
    }


    // LOV: Material Advnce Calculation

    public void TotalMaterialAdvAmount1() {
        //System.err.println("======Row count====" +
//                           applicationHrdVO.getEstimatedRowCount());
        double mat_Adv_amt = 0;
        mat_Adv_amt =
                material_Adv_amt.getValue() == null ? 0 : Double.parseDouble(material_Adv_amt.getValue().toString());
        //System.err.println("===Advance Amount===" + mat_Adv_amt);
        applicationHrdVO.getCurrentRow().setAttribute("TotalMaterialAdvAmount",
                                                      new BigDecimal(mat_Adv_amt));
        applicationHrdVO.getCurrentRow().setAttribute("CurApplication",
                                                      new BigDecimal(mat_Adv_amt));
        applicationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                      new BigDecimal(mat_Adv_amt));
        applicationHrdVO.getCurrentRow().setAttribute("PrevApplication", 0);
        AdfFacesContext.getCurrentInstance().addPartialTarget(prevAppl);
        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);
        AdfFacesContext.getCurrentInstance().addPartialTarget(CurApplication);
        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);

    }

    // ???

    public void onChangeAdvanAmount(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        //System.err.println("--old--" + valueChangeEvent.getOldValue());
        //System.err.println("--New--" + valueChangeEvent.getNewValue());
        String contractHeaderID =
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
        double totalAdvanceAmount =
            applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Recovery") ==
            null ? 0 :
            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Recovery").toString());
        // Filter previous count
        ViewCriteria AppVC = applicationHrdVO2.createViewCriteria();
        ViewCriteriaRow AppVCR = AppVC.createViewCriteriaRow();
        AppVCR.setAttribute("ContHeaderId", contractHeaderID);
        AppVCR.setAttribute("PaymentType", "Advance");
        AppVC.addRow(AppVCR);
        applicationHrdVO2.applyViewCriteria(AppVC);
        applicationHrdVO2.executeQuery();
        // check previous count
        if (applicationHrdVO2.getEstimatedRowCount() == 0) {
            if (Double.parseDouble(valueChangeEvent.getNewValue().toString()) <=
                totalAdvanceAmount) {
                double BalanceAmt =
                    totalAdvanceAmount - Double.parseDouble(valueChangeEvent.getNewValue().toString());
                System.out.println("BalanceAmt 111 :" +BalanceAmt);
                applicationHrdVO.getCurrentRow().setAttribute("BalanceAdvRec",
                                                              BalanceAmt);
                AdfFacesContext.getCurrentInstance().addPartialTarget(BalanceAdvRec);
                //                CalculateAmount();
            } else {
                JSFUtils.addFacesErrorMessage("Please check enter Amount is greater than " +
                                              totalAdvanceAmount);
                TotalAdvAmount.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(TotalAdvAmount);
            }

        } else {
            double previousAmtTotal = 0;
            RowSetIterator appHrdRS =
                applicationHrdVO2.createRowSetIterator(null);
            while (appHrdRS.hasNext()) {
                Row appOldRow = appHrdRS.next();
                double preAmt =
                    appOldRow.getAttribute("TotalAdvAmount") == null ? 0 :
                    Double.parseDouble(appOldRow.getAttribute("TotalAdvAmount").toString());
                previousAmtTotal += preAmt;
            }
            //System.err.println("previous Advance Total Amount==" +
//                               previousAmtTotal);
            double previousBalanceAmt =
                totalAdvanceAmount - previousAmtTotal - Double.parseDouble(valueChangeEvent.getNewValue().toString());
            if (Double.parseDouble(valueChangeEvent.getNewValue().toString()) <=
                previousBalanceAmt) {
                if (previousAmtTotal < totalAdvanceAmount) {
                    System.out.println("1111 : "+previousBalanceAmt);
                    applicationHrdVO.getCurrentRow().setAttribute("BalanceAdvRec",
                                                                  previousBalanceAmt);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(BalanceAdvRec);
                    //                    CalculateAmount();

                } else {
                    JSFUtils.addFacesErrorMessage("Advance Cannot be created for this contract");
                    paymentType.setValue(null);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);
                    TotalAdvAmount.setDisabled(true);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(TotalAdvAmount);
                }
            } else {
                JSFUtils.addFacesErrorMessage("Please check enter Amount is greater than " +
                                              valueChangeEvent.getOldValue());
                TotalAdvAmount.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(TotalAdvAmount);
            }

        }


    }
    /*Working Submit copy*/

    public void onClickSubmit(ActionEvent actionEvent) throws SQLException {

        if (ADFContext.getCurrent().getSessionScope().get("addEditApp") !=
            null &&
            ADFContext.getCurrent().getSessionScope().get("addEditApp").toString().equals("edit")) {
            //            applicationHrdVO.getCurrentRow().setAttribute("ApprovalStatus", "APR");
            // Buy Approval process

            String func_id =
                applicationHrdVO.getCurrentRow().getAttribute("FuncId") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("FuncId").toString();
            String ref_id =
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
            String level_no =
                applicationHrdVO.getCurrentRow().getAttribute("FlowLevel") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("FlowLevel").toString();
            String OrgId =
                applicationHrdVO.getCurrentRow().getAttribute("OrgId") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("OrgId").toString();
            String projectId =
                proId.getValue() == null ? "0" : proId.getValue().toString();
            String flag =
                ADFApproval.invokeSubmitPkg(submitPkg, func_id, ref_id,
                                            level_no, tableName,
                                            app_status_column, pk_column,
                                            OrgId, projectId);
            //System.err.println("flag  came" + flag);
            if (flag.equalsIgnoreCase("Success")) {
                applicationHrdVO.getCurrentRow().setAttribute("ApplicationStatus",
                                                              "ACTIVE");
                String netPaymentAmt =
                    applicationHrdVO.getCurrentRow().getAttribute("CurPayAmount") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("CurPayAmount").toString();
                String grossAmt =
                    applicationHrdVO.getCurrentRow().getAttribute("CurApplication") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("CurApplication").toString();
                String totalCumAmt =
                    applicationHrdVO.getCurrentRow().getAttribute("CummAmt") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("CummAmt").toString();
                String supplierName =
                    applicationHrdVO.getCurrentRow().getAttribute("Trans_SupplierName") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("Trans_SupplierName").toString();
                String origConAmt =
                    applicationHrdVO.getCurrentRow().getAttribute("Trans_Contract_Amount") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("Trans_Contract_Amount").toString();
                String conNum =
                    applicationHrdVO.getCurrentRow().getAttribute("Trans_ContractNumber") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("Trans_ContractNumber").toString();
                String projName =
                    applicationHrdVO.getCurrentRow().getAttribute("Trans_ProjectName") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("Trans_ProjectName").toString();
                String projNum =
                    applicationHrdVO.getCurrentRow().getAttribute("Trans_ProjectNumber") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("Trans_ProjectNumber").toString();
                String applDate =
                    applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate").toString();
                String applNumber =
                    applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber").toString();
                String custName =
                    applicationHrdVO.getCurrentRow().getAttribute("Trans_customer_name") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("Trans_customer_name").toString();
                //System.err.println("Input Values for mail notification" +
//                                   netPaymentAmt + "," + grossAmt + "," +
//                                   totalCumAmt + "," + supplierName + "," +
//                                   origConAmt + "," + conNum + "," + projName +
//                                   "," + projNum + "," + applDate + "," + "," +
//                                   applNumber);

                String flowWith =
                    ADFContext.getCurrent().getSessionScope().get("flow_with") ==
                    null ? "0" :
                    ADFContext.getCurrent().getSessionScope().get("flow_with").toString();
                //System.err.println("flowWith==>" + flowWith);
                ViewObject ApproveMailVO =
                    ADFUtils.findIterator("XxscHeadDetailROVO1Iterator").getViewObject();
                ApproveMailVO.setNamedWhereClauseParam("BV_USER_ID", flowWith);
                ApproveMailVO.executeQuery();
                //System.out.println("COUNT--" +
//                                   ApproveMailVO.getEstimatedRowCount());
                if (ApproveMailVO.getEstimatedRowCount() != 0) {
                                      String to =ApproveMailVO.first().getAttribute("Email") == null ?
                                                   "naresco@eim.ae" :
                                                   ApproveMailVO.first().getAttribute("Email").toString();
                    //String to="dineshkumar.p@4iapps.com";
                    //String to = "sudha.y@4iapps.com";
                    ArrayList<String> ar = new ArrayList();
                    ar.add(to);
                    String fromMail = "info@naresco.com"; // i will give mail
                    String LoginUser =
                        ADFContext.getCurrent().getSessionScope().get("userName") ==
                        null ? "0" :
                        ADFContext.getCurrent().getSessionScope().get("userName").toString();
                    /*** Mail Notification Throw java*/
                    String htmlBody =
                        MailTemplates.checkMail("Supplier Name", "Application Number",
                                                "Application Date",
                                                "Application", applNumber,
                                                LoginUser, conNum, projName,
                                                supplierName, applDate,
                                                origConAmt, grossAmt,
                                                netPaymentAmt);
                    String subject =
                        "Application-" + applNumber + " Submitted for Approval";
                    MailServices.sendMailNotification(htmlBody, subject, ar,
                                                      "N", null);

                    if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                        JSFUtils.addFacesInformationMessage("Buy Application Information Saved Successfully and Submitted For Approval");
                        cb9.setDisabled(Boolean.TRUE);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cb9);
                    } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                        JSFUtils.addFacesInformationMessage("Sell Application Information Saved Successfully and Submitted For Approval");
                        cb9.setDisabled(Boolean.TRUE);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cb9);
                    }

                } else {

                }

            } else {
                //System.err.println("Inside else flag error came");
                JSFUtils.addFacesErrorMessage("Error in Submit For Approval. Error Message:" +
                                              flag);
                String pageRedirect = null;
            }

            ADFUtils.findOperation("Commit").execute();
            ADFUtils.refreshTable("ApplicationNumber", searchApplicationVO);
            JSFUtils.addFacesInformationMessage("Application Information Saved Successfully");

        } else {
            String application = onClickSaveApplication();
            if (application.equalsIgnoreCase("save")) {
                String func_id =
                    applicationHrdVO.getCurrentRow().getAttribute("FuncId") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("FuncId").toString();
                String ref_id =
                    applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
                String level_no =
                    applicationHrdVO.getCurrentRow().getAttribute("FlowLevel") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("FlowLevel").toString();
                String OrgId =
                    applicationHrdVO.getCurrentRow().getAttribute("OrgId") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("OrgId").toString();
                String projectId =
                    proId.getValue() == null ? "0" : proId.getValue().toString();
                String flag =
                    ADFApproval.invokeSubmitPkg(submitPkg, func_id, ref_id,
                                                level_no, tableName,
                                                app_status_column, pk_column,
                                                OrgId, projectId);
                //System.err.println("flag  came" + flag);
                if (flag.equalsIgnoreCase("Success")) {
                    applicationHrdVO.getCurrentRow().setAttribute("ApplicationStatus",
                                                                  "ACTIVE");
                    String netPaymentAmt =
                        applicationHrdVO.getCurrentRow().getAttribute("CurPayAmount") ==
                        null ? "0" :
                        applicationHrdVO.getCurrentRow().getAttribute("CurPayAmount").toString();
                    String grossAmt =
                        applicationHrdVO.getCurrentRow().getAttribute("CurApplication") ==
                        null ? "0" :
                        applicationHrdVO.getCurrentRow().getAttribute("CurApplication").toString();
                    String totalCumAmt =
                        applicationHrdVO.getCurrentRow().getAttribute("CummAmt") ==
                        null ? "0" :
                        applicationHrdVO.getCurrentRow().getAttribute("CummAmt").toString();
                    String supplierName =
                        applicationHrdVO.getCurrentRow().getAttribute("Trans_SupplierName") ==
                        null ? "0" :
                        applicationHrdVO.getCurrentRow().getAttribute("Trans_SupplierName").toString();
                    String origConAmt =
                        applicationHrdVO.getCurrentRow().getAttribute("Trans_Contract_Amount") ==
                        null ? "0" :
                        applicationHrdVO.getCurrentRow().getAttribute("Trans_Contract_Amount").toString();
                    String conNum =
                        applicationHrdVO.getCurrentRow().getAttribute("Trans_ContractNumber") ==
                        null ? "0" :
                        applicationHrdVO.getCurrentRow().getAttribute("Trans_ContractNumber").toString();
                    String projName =
                        applicationHrdVO.getCurrentRow().getAttribute("Trans_ProjectName") ==
                        null ? "0" :
                        applicationHrdVO.getCurrentRow().getAttribute("Trans_ProjectName").toString();
                    String projNum =
                        applicationHrdVO.getCurrentRow().getAttribute("Trans_ProjectNumber") ==
                        null ? "0" :
                        applicationHrdVO.getCurrentRow().getAttribute("Trans_ProjectNumber").toString();
                    String applDate =
                        applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate") ==
                        null ? "0" :
                        applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate").toString();
                    String applNumber =
                        applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber") ==
                        null ? "0" :
                        applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber").toString();
                    String custName =
                        applicationHrdVO.getCurrentRow().getAttribute("Trans_customer_name") ==
                        null ? "0" :
                        applicationHrdVO.getCurrentRow().getAttribute("Trans_customer_name").toString();
                    //System.err.println("Input Values for mail notification" +
//                                       netPaymentAmt + "," + grossAmt + "," +
//                                       totalCumAmt + "," + supplierName + "," +
//                                       origConAmt + "," + conNum + "," +
//                                       projName + "," + projNum + "," +
//                                       applDate + "," + "," + applNumber);

                    String flowWith =
                        ADFContext.getCurrent().getSessionScope().get("flow_with") ==
                        null ? "0" :
                        ADFContext.getCurrent().getSessionScope().get("flow_with").toString();
                    //System.err.println("flowWith==>" + flowWith);
                    ViewObject ApproveMailVO =
                        ADFUtils.findIterator("XxscHeadDetailROVO1Iterator").getViewObject();
                    ApproveMailVO.setNamedWhereClauseParam("BV_USER_ID",
                                                           flowWith);
                    ApproveMailVO.executeQuery();
                    //System.out.println("COUNT--" +
//                                       ApproveMailVO.getEstimatedRowCount());
                    if (ApproveMailVO.getEstimatedRowCount() != 0) {
                                          String to =ApproveMailVO.first().getAttribute("Email") == null ?
                                                       "naresco@eim.ae" :
                                                       ApproveMailVO.first().getAttribute("Email").toString();
                       // String to = "sudha.y@4iapps.com";
                        ArrayList<String> ar = new ArrayList();
                        ar.add(to);
                        String fromMail =
                            "info@naresco.com"; // i will give mail
                        String LoginUser =
                            ADFContext.getCurrent().getSessionScope().get("userName") ==
                            null ? "0" :
                            ADFContext.getCurrent().getSessionScope().get("userName").toString();
                        /*** Mail Notification Throw java*/

                        //                        String htmlBody= MailTemplates.checkMail("Supplier Name","Application Number","Application Date","Application",applNumber,LoginUser,conNum,projName,supplierName,applDate,origConAmt,grossAmt,netPaymentAmt);
                        //                        String subject="Application-"+applNumber+" Submitted for Approval";
                        //                        MailServices.sendMailNotification(htmlBody, subject, ar, "N", null);

                        if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                            String htmlBody =
                                MailTemplates.checkMail("Supplier Name",
                                                        "Application Number",
                                                        "Application Date",
                                                        "Application",
                                                        applNumber, LoginUser,
                                                        conNum, projName,
                                                        supplierName, applDate,
                                                        origConAmt, grossAmt,
                                                        netPaymentAmt);
                            String subject =
                                "Application-" + applNumber + " Submitted for Approval";
                            MailServices.sendMailNotification(htmlBody,
                                                              subject, ar, "N",
                                                              null);
                            JSFUtils.addFacesInformationMessage("Buy Application Information Saved Successfully and Submitted For Approval");
                            cb9.setDisabled(Boolean.TRUE);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(cb9);
                        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                            String htmlBody =
                                MailTemplates.checkMail("Customer Name",
                                                        "Application Number",
                                                        "Application Date",
                                                        "Application",
                                                        applNumber, LoginUser,
                                                        conNum, projName,
                                                        custName, applDate,
                                                        origConAmt, grossAmt,
                                                        netPaymentAmt);
                            String subject =
                                "Application-" + applNumber + " Submitted for Approval";
                            MailServices.sendMailNotification(htmlBody,
                                                              subject, ar, "N",
                                                              null);
                            JSFUtils.addFacesInformationMessage("Sell Application Information Saved Successfully and Submitted For Approval");
                            cb9.setDisabled(Boolean.TRUE);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(cb9);
                        }

                    } else {

                    }

                } else {
                    //System.err.println("Inside else flag error came");
                    JSFUtils.addFacesErrorMessage("Error in Submit For Approval. Error Message:" +
                                                  flag);
                    String pageRedirect = null;
                }

                ADFUtils.findOperation("Commit").execute();
                ADFUtils.refreshTable("ApplicationNumber",
                                      searchApplicationVO);
                JSFUtils.addFacesInformationMessage("Application Information Saved Successfully");
            } else {
                // Save Error
            }
        }
    }

    public void onClickSubmitForApproval(ActionEvent actionEvent) {
        try {
            if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                String url =
                    ADFUtils.getFunctionDetails("BUY_PAY_APP", "WfProcessUrl");
                // "http://141.144.50.225/soa-infra/services/default/CertSellApproval/certsellapprovalprocess_client_ep?WSDL";
                SubmitForApproval app = new SubmitForApproval("", "", "");
                String payload = prepareApprovalPayload();
                String type =
                    "Application"; // Certification // Application //Contract
                app.getAndPushOrder(payload, url, type);
            } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                String url =
                    ADFUtils.getFunctionDetails("SELL_PAY_APP", "WfProcessUrl");
                // "http://141.144.50.225/soa-infra/services/default/CertSellApproval/certsellapprovalprocess_client_ep?WSDL";
                SubmitForApproval app = new SubmitForApproval("", "", "");
                String payload = prepareApprovalPayload();
                String type =
                    "Certification"; // Certification // Application //Contract
                app.getAndPushOrder(payload, url, type);
            }
        } catch (Exception e) {
            //System.err.println("====EXE===APP====" + e.toString());
        }
    }

    public String prepareApprovalPayload() {
        String xml = "";
        ViewObject headerVO =
            ADFUtils.findIterator("XxscPayApplHeadersVO1Iterator").getViewObject();
        xml += "   <soapenv:Body>\n" +
                "      <app:application>\n" +
                "         <app:appHeader>\n" +
                "            <app:functionid>";
        xml += headerVO.getCurrentRow().getAttribute("FuncId");
        xml += "</app:functionid>\n" +
                "            <app:app_header_id>";
        xml += headerVO.getCurrentRow().getAttribute("ApplHeaderId");
        xml += "</app:app_header_id>\n" +
                "           </app:appHeader>\n" +
                "         </app:application>\n" +
                "   </soapenv:Body>\n";
        return xml;
    }

    public void setTans_Adv_rec(RichInputText tans_Adv_rec) {
        this.tans_Adv_rec = tans_Adv_rec;
    }

    public RichInputText getTans_Adv_rec() {
        return tans_Adv_rec;
    }

    public void setMaterial_Adv_amt(RichInputText material_Adv_amt) {
        this.material_Adv_amt = material_Adv_amt;
    }

    public RichInputText getMaterial_Adv_amt() {
        return material_Adv_amt;
    }

    public void setTotal_mat_adv_amt(RichInputText total_mat_adv_amt) {
        this.total_mat_adv_amt = total_mat_adv_amt;
    }

    public RichInputText getTotal_mat_adv_amt() {
        return total_mat_adv_amt;
    }

    public void setTrans_ret_amt(RichInputText trans_ret_amt) {
        this.trans_ret_amt = trans_ret_amt;
    }

    public RichInputText getTrans_ret_amt() {
        return trans_ret_amt;
    }

    public void setRet_per(RichInputText ret_per) {
        this.ret_per = ret_per;
    }

    public RichInputText getRet_per() {
        return ret_per;
    }


    public void onChangeCummQty(ValueChangeEvent valueChangeEvent) {
        AdfFacesContext adfFacesContext = null;
        adfFacesContext = AdfFacesContext.getCurrentInstance();
        FacesContext ctx = FacesContext.getCurrentInstance();
        FacesMessage fm = null;
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            double old_value =
                valueChangeEvent.getOldValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getOldValue().toString());
            double new_value =
                valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
              
            if (old_value != new_value) {
                if (valueChangeEvent.getNewValue() != null) {
                    valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
                    double contractLneRate =
                        applicationLineVO.getCurrentRow().getAttribute("Trans_Rate") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Rate").toString());
                    double contractLneAmt =
                        applicationLineVO.getCurrentRow().getAttribute("Trans_Amount") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Amount").toString());
                    double cummulativeQty =
                        valueChangeEvent.getNewValue() == null ? 0 :
                        Double.parseDouble(valueChangeEvent.getNewValue().toString());
                    //System.err.println();
                    double contractLneQty =
                        applicationLineVO.getCurrentRow().getAttribute("Trans_Qty") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Qty").toString());
                    System.out.println("contractLneQty :"+contractLneQty);
                    
                    double taxRate =
                        applicationLineVO.getCurrentRow().getAttribute("TaxRate") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("TaxRate").toString());
                    // setting Current
                    double previousQty =
                        applicationLineVO.getCurrentRow().getAttribute("PrevTotQty") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevTotQty").toString());
                    double previousPer =
                        applicationLineVO.getCurrentRow().getAttribute("PrevPerc") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevPerc").toString());
                    double previousAmt =
                        applicationLineVO.getCurrentRow().getAttribute("PrevAmount") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevAmount").toString());
                    double currentQty = cummulativeQty - previousQty;
                    System.out.println("currentQty: "+currentQty);
                    System.out.println("cummulativeQty: "+cummulativeQty);
                    System.out.println("previousQty: "+previousQty);
                    if(cummulativeQty > contractLneQty){
                        cumuQty.resetValue();
                        cumuQty.setValue("");
                        cumuQty.setValue(null);
                        fm = new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING", "Entered quantity excedds the limit. Please check");
                        ctx.addMessage(null, fm);
                    }else{
                        double cummulativeAmt = cummulativeQty * contractLneRate;
                        BigDecimal val = new BigDecimal(cummulativeAmt);
                        applicationLineVO.getCurrentRow().setAttribute("CumAmount",
                                                                       val.setScale(2,
                                                                                    BigDecimal.ROUND_HALF_EVEN));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cumuAmt);

                        // set Percentage
                        double cummulativePer =
                            (100 * cummulativeAmt / contractLneAmt);
                        val = new BigDecimal(cummulativePer);
                        applicationLineVO.getCurrentRow().setAttribute("CumPerc",
                                                                       val.setScale(2,
                                                                                    BigDecimal.ROUND_HALF_EVEN));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cumuPer);
                        currentQty = cummulativeQty - previousQty;
                        double currentPre = cummulativePer - previousPer;
                        double currentAmt = cummulativeAmt - previousAmt;
                        BigDecimal curqty = new BigDecimal(currentQty);
                        applicationLineVO.getCurrentRow().setAttribute("CurrTotQty",
                                                                       curqty.setScale(2,
                                                                                       BigDecimal.ROUND_HALF_EVEN));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
                        BigDecimal curper = new BigDecimal(currentPre);
                        applicationLineVO.getCurrentRow().setAttribute("CurrPerc",
                                                                       curper.setScale(2,
                                                                                       BigDecimal.ROUND_HALF_EVEN));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(currPer);
                        BigDecimal curamt = new BigDecimal(currentAmt);
                        applicationLineVO.getCurrentRow().setAttribute("CurrAmount",
                                                                       curamt.setScale(2,
                                                                                       BigDecimal.ROUND_HALF_EVEN));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(currAmt);
                        // Set Tax Amount
                        if (taxRate == 0) {
                            applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                           new BigDecimal(0));
                            AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                        } else {
                            double taxAmt = (currentAmt * taxRate) / 100;
                            applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                           new BigDecimal(taxAmt));
                            AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                        }
                    }
                    // set Amount
                    
                }
            }
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
            double old_value =
                valueChangeEvent.getOldValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getOldValue().toString());
            double new_value =
                valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
            applicationLineVO.getCurrentRow().getAttribute("CumTotQty");
         
            if (old_value != new_value) {
                if (valueChangeEvent.getNewValue() != null) {
                    valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
                    double contractLneRate =
                        applicationLineVO.getCurrentRow().getAttribute("Trans_Rate") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Rate").toString());
                    double contractLneAmt =
                        applicationLineVO.getCurrentRow().getAttribute("Trans_Amount") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Amount").toString());
                    double cummulativeQty =
                        valueChangeEvent.getNewValue() == null ? 0 :
                        Double.parseDouble(valueChangeEvent.getNewValue().toString());

                    double taxRate =
                        applicationLineVO.getCurrentRow().getAttribute("TaxRate") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("TaxRate").toString());
                    // set Amount
                    double cummulativeAmt = cummulativeQty * contractLneRate;
                    BigDecimal val = new BigDecimal(cummulativeAmt);
                    applicationLineVO.getCurrentRow().setAttribute("CumAmount",
                                                                   val.setScale(20,
                                                                                BigDecimal.ROUND_HALF_EVEN));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(cumuAmt);

                    // set Percentage
                    double cummulativePer =
                        (100 * cummulativeAmt / contractLneAmt);
                    val = new BigDecimal(cummulativePer);
                    applicationLineVO.getCurrentRow().setAttribute("CumPerc",
                                                                   val.setScale(20,
                                                                                BigDecimal.ROUND_HALF_EVEN));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(cumuPer);

                    // setting Current
                    double previousQty =
                        applicationLineVO.getCurrentRow().getAttribute("PrevTotQty") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevTotQty").toString());
                    double previousPer =
                        applicationLineVO.getCurrentRow().getAttribute("PrevPerc") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevPerc").toString());
                    double previousAmt =
                        applicationLineVO.getCurrentRow().getAttribute("PrevAmount") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevAmount").toString());

                    double currentQty = cummulativeQty - previousQty;
                    double currentPre = cummulativePer - previousPer;
                    double currentAmt = cummulativeAmt - previousAmt;
                    BigDecimal curqty = new BigDecimal(currentQty);
                    applicationLineVO.getCurrentRow().setAttribute("CurrTotQty",
                                                                   curqty.setScale(20,
                                                                                   BigDecimal.ROUND_HALF_EVEN));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
                    BigDecimal curper = new BigDecimal(currentPre);
                    applicationLineVO.getCurrentRow().setAttribute("CurrPerc",
                                                                   curper.setScale(20,
                                                                                   BigDecimal.ROUND_HALF_EVEN));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(currPer);
                    BigDecimal curamt = new BigDecimal(currentAmt);
                    applicationLineVO.getCurrentRow().setAttribute("CurrAmount",
                                                                   curamt.setScale(20,
                                                                                   BigDecimal.ROUND_HALF_EVEN));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(currAmt);
                    // Set Tax Amount
                    if (taxRate == 0) {
                        applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                       new BigDecimal(0));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                    } else {
                        double taxAmt = (currentAmt * taxRate) / 100;
                        applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                       new BigDecimal(taxAmt));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                    }
                }
            }
        }
    }

    public void onChangeCummPer(ValueChangeEvent valueChangeEvent) {
        AdfFacesContext adfFacesContext = null;
        adfFacesContext = AdfFacesContext.getCurrentInstance();
        FacesContext ctx = FacesContext.getCurrentInstance();
        FacesMessage fm = null;
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            //System.out.println("onChangeCummPerapplication");
            double old_value =
                valueChangeEvent.getOldValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getOldValue().toString());
            double new_value =
                valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
            double cummulativePer =
                            valueChangeEvent.getNewValue() == null ? 0 :
                            Double.parseDouble(valueChangeEvent.getNewValue().toString());
            double previousPer =
                applicationLineVO.getCurrentRow().getAttribute("PrevPerc") ==
                null ? 0 :
                Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevPerc").toString());
            double currentPer = cummulativePer - previousPer;
            System.out.println("currentPer: "+currentPer);
            System.out.println("cummulativePer: "+cummulativePer);
            System.out.println("previousPer: "+previousPer);
            if(new_value > 100){
                System.out.println("cummPerc: "+new_value);
                cumuPer.resetValue();
                cumuPer.setValue("");
                cumuPer.setValue(null);/*  */
                
                fm = new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING", "Entered Percentage excedds the limit.");
                ctx.addMessage(null, fm);
               
            }
                        else if (old_value != new_value) {
                if (valueChangeEvent.getNewValue() != null) {
                    valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
                    double contractLneRate =
                        applicationLineVO.getCurrentRow().getAttribute("Trans_Rate") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Rate").toString());
                    double contractLneAmt =
                        applicationLineVO.getCurrentRow().getAttribute("Trans_Amount") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Amount").toString());
                    
                    double taxRate =
                        applicationLineVO.getCurrentRow().getAttribute("TaxRate") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("TaxRate").toString());
                    if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                        // set Amount
                        double cummulativeAmt =
                            (cummulativePer * contractLneAmt) / 100;
                        BigDecimal val = new BigDecimal(cummulativeAmt);
                        applicationLineVO.getCurrentRow().setAttribute("CumAmount",
                                                                       val.setScale(2,
                                                                                    BigDecimal.ROUND_HALF_EVEN));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cumuAmt);

                        // set Qty

                        double cummulativeQty = 0;
                         if(contractLneRate != 0){
                             cummulativeQty = cummulativeAmt / contractLneRate;
                         }
                        val = new BigDecimal(cummulativeQty);
                        applicationLineVO.getCurrentRow().setAttribute("CumTotQty",
                                                                       val.setScale(2,
                                                                                    BigDecimal.ROUND_HALF_EVEN));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cumuQty);


                        // setting Current
                        double previousQty =
                            applicationLineVO.getCurrentRow().getAttribute("PrevTotQty") ==
                            null ? 0 :
                            Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevTotQty").toString());
                        double previousAmt =
                            applicationLineVO.getCurrentRow().getAttribute("PrevAmount") ==
                            null ? 0 :
                            Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevAmount").toString());

                        double currentQty = cummulativeQty - previousQty;
                        double currentPre = cummulativePer - previousPer;
                        double currentAmt = cummulativeAmt - previousAmt;
                        BigDecimal curqty = new BigDecimal(currentQty);
                        applicationLineVO.getCurrentRow().setAttribute("CurrTotQty",
                                                                       curqty.setScale(2,
                                                                                       BigDecimal.ROUND_HALF_EVEN));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
                        BigDecimal curper = new BigDecimal(currentPre);
                        applicationLineVO.getCurrentRow().setAttribute("CurrPerc",
                                                                       curper.setScale(2,
                                                                                       BigDecimal.ROUND_HALF_EVEN));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(currPer);
                        BigDecimal curamt = new BigDecimal(currentAmt);
                        applicationLineVO.getCurrentRow().setAttribute("CurrAmount",
                                                                       curamt.setScale(2,
                                                                                       BigDecimal.ROUND_HALF_EVEN));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(currAmt);

                        // Set Tax Amount
                        if (taxRate == 0) {
                            applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                           new BigDecimal(0));
                            AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                        } else {
                            double taxAmt = (currentAmt * taxRate) / 100;
                            applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                           new BigDecimal(taxAmt));
                            AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                        }
                    }
                }
            }
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
            //System.out.println("onChangeCummPerapplicationBuy");
            double old_value =
                valueChangeEvent.getOldValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getOldValue().toString());
            double new_value =
                valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
            System.out.println("old_value is " + old_value);
            System.out.println("new_value is " + new_value);
//            double d2= 100;
//              int retval = Double.compare(new_value, d2);
//              if( retval > 0 ){
//                      cumuPer.setValue("0");
//                      applicationLineVO.getCurrentRow().setAttribute("CurrPerc",0);
//                      applicationLineVO.getCurrentRow().setAttribute("CurrAmount",0);                                             
//                      applicationLineVO.getCurrentRow().setAttribute("TaxAmount",0);
//                      applicationLineVO.getCurrentRow().setAttribute("CumTotQty",0);
//                      applicationLineVO.getCurrentRow().setAttribute("CumAmount",0);
//                      applicationLineVO.getCurrentRow().setAttribute("CurrTotQty",0);
//                      AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
//                      AdfFacesContext.getCurrentInstance().addPartialTarget(cumuAmt); 
//                      AdfFacesContext.getCurrentInstance().addPartialTarget(cumuPer); 
//                      AdfFacesContext.getCurrentInstance().addPartialTarget(cumuQty);
//                      AdfFacesContext.getCurrentInstance().addPartialTarget(currPer); 
//                      AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
//                      AdfFacesContext.getCurrentInstance().addPartialTarget(currAmt);     
//                      valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
//                      JSFUtils.addFacesErrorMessage("Percentange should be less than 100"); 
//                  }
           if (old_value != new_value) {
                if (valueChangeEvent.getNewValue() != null) {
                    valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
                    double contractLneRate =
                        applicationLineVO.getCurrentRow().getAttribute("Trans_Rate") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Rate").toString());
                    double contractLneAmt =
                        applicationLineVO.getCurrentRow().getAttribute("Trans_Amount") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Amount").toString());
                    double cummulativePer =
                        valueChangeEvent.getNewValue() == null ? 0 :
                        Double.parseDouble(valueChangeEvent.getNewValue().toString());
                    double taxRate =
                        applicationLineVO.getCurrentRow().getAttribute("TaxRate") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("TaxRate").toString());

                    if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                        // set for cumper 0
                        if (cummulativePer == 0) {
                            // set Amount
                            double cummulativeAmt =
                                (cummulativePer * contractLneAmt) / 100;
                            //System.out.println("cummulativeAmt" +
//                                               cummulativeAmt);
                            BigDecimal val = new BigDecimal(cummulativeAmt);
                            applicationLineVO.getCurrentRow().setAttribute("CumAmount",
                                                                           0);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuAmt);

                            // set Qty
                            double cummulativeQty =
                                cummulativeAmt / contractLneRate;
                            val = new BigDecimal(cummulativeQty);
                            //System.out.println("cummulativeQty" +
//                                               cummulativeQty);

                            applicationLineVO.getCurrentRow().setAttribute("CumTotQty",
                                                                           0);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuQty);
                            // setting Current
                            double previousQty =
                                applicationLineVO.getCurrentRow().getAttribute("PrevTotQty") ==
                                null ? 0 :
                                Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevTotQty").toString());
                            double previousPer =
                                applicationLineVO.getCurrentRow().getAttribute("PrevPerc") ==
                                null ? 0 :
                                Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevPerc").toString());
                            double previousAmt =
                                applicationLineVO.getCurrentRow().getAttribute("PrevAmount") ==
                                null ? 0 :
                                Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevAmount").toString());

                            double currentQty = cummulativeQty - previousQty;
                            double currentPre = cummulativePer - previousPer;
                            double currentAmt = cummulativeAmt - previousAmt;
                            BigDecimal curqty = new BigDecimal(currentQty);
                            applicationLineVO.getCurrentRow().setAttribute("CurrTotQty",
                                                                           0);

                            AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
                            BigDecimal curperc = new BigDecimal(currentPre);
                            applicationLineVO.getCurrentRow().setAttribute("CurrPerc",
                                                                           0);

                            AdfFacesContext.getCurrentInstance().addPartialTarget(currPer);
                            BigDecimal curamt = new BigDecimal(currentAmt);
                            applicationLineVO.getCurrentRow().setAttribute("CurrAmount",
                                                                           0);

                            AdfFacesContext.getCurrentInstance().addPartialTarget(currAmt);

                            // Set Tax Amount
                            if (taxRate == 0) {
                                applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                               new BigDecimal(0));
                                AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                            } else {
                                double taxAmt = (currentAmt * taxRate) / 100;
                                applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                               new BigDecimal(taxAmt));
                                AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                            }
                        } else {
                            // set Amount
                            double cummulativeAmt =
                                (cummulativePer * contractLneAmt) / 100;
                            //System.out.println("cummulativeAmt" +
//                                               cummulativeAmt);
                            BigDecimal val = new BigDecimal(cummulativeAmt);
                            applicationLineVO.getCurrentRow().setAttribute("CumAmount",
                                                                           val.setScale(20,
                                                                                        BigDecimal.ROUND_HALF_EVEN));
                            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuAmt);

                            // set Qty
                            double cummulativeQty =
                                cummulativeAmt / contractLneRate;
                            val = new BigDecimal(cummulativeQty);
                            //System.out.println("cummulativeQty" +
//                                               cummulativeQty);

                            applicationLineVO.getCurrentRow().setAttribute("CumTotQty",
                                                                           val.setScale(20,
                                                                                        BigDecimal.ROUND_HALF_EVEN));
                            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuQty);
                            // setting Current
                            double previousQty =
                                applicationLineVO.getCurrentRow().getAttribute("PrevTotQty") ==
                                null ? 0 :
                                Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevTotQty").toString());
                            double previousPer =
                                applicationLineVO.getCurrentRow().getAttribute("PrevPerc") ==
                                null ? 0 :
                                Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevPerc").toString());
                            double previousAmt =
                                applicationLineVO.getCurrentRow().getAttribute("PrevAmount") ==
                                null ? 0 :
                                Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevAmount").toString());

                            double currentQty = cummulativeQty - previousQty;
                            double currentPre = cummulativePer - previousPer;
                            double currentAmt = cummulativeAmt - previousAmt;

                            if (cummulativePer == 100 && previousPer == 100) {
                                BigDecimal curqty = new BigDecimal(currentQty);
                                applicationLineVO.getCurrentRow().setAttribute("CurrTotQty",
                                                                               0);
                                //                    applicationLineVO.getCurrentRow().setAttribute("CurrTotQty",new BigDecimal(currentQty));
                                AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
                                BigDecimal curperc =
                                    new BigDecimal(currentPre);
                                applicationLineVO.getCurrentRow().setAttribute("CurrPerc",
                                                                               0);
                                //                    applicationLineVO.getCurrentRow().setAttribute("CurrPerc",new BigDecimal(currentPre));
                                AdfFacesContext.getCurrentInstance().addPartialTarget(currPer);
                                BigDecimal curamt = new BigDecimal(currentAmt);
                                applicationLineVO.getCurrentRow().setAttribute("CurrAmount",
                                                                               0);
                                //                    applicationLineVO.getCurrentRow().setAttribute("CurrAmount",new BigDecimal(currentAmt));
                                AdfFacesContext.getCurrentInstance().addPartialTarget(currAmt);

                                // Set Tax Amount
                                if (taxRate == 0) {
                                    applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                                   new BigDecimal(0));
                                    AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                                } else {
                                    double taxAmt =
                                        (currentAmt * taxRate) / 100;
                                    applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                                   new BigDecimal(taxAmt));
                                    AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                                }
                            } else if (cummulativePer == previousPer) {
                                applicationLineVO.getCurrentRow().setAttribute("CurrTotQty",
                                                                               0);
                                AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
                                applicationLineVO.getCurrentRow().setAttribute("CurrPerc",
                                                                               0);
                                AdfFacesContext.getCurrentInstance().addPartialTarget(currPer);
                                applicationLineVO.getCurrentRow().setAttribute("CurrAmount",
                                                                               0);
                                AdfFacesContext.getCurrentInstance().addPartialTarget(currAmt);

                                // Set Tax Amount
                                if (taxRate == 0) {
                                    applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                                   new BigDecimal(0));
                                    AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                                } else {
                                    double taxAmt =
                                        (currentAmt * taxRate) / 100;
                                    applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                                   new BigDecimal(taxAmt));
                                    AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                                }
                            } else {
                                BigDecimal curqty = new BigDecimal(currentQty);
                                applicationLineVO.getCurrentRow().setAttribute("CurrTotQty",
                                                                               curqty.setScale(20,
                                                                                               BigDecimal.ROUND_HALF_EVEN));
                                //                    applicationLineVO.getCurrentRow().setAttribute("CurrTotQty",new BigDecimal(currentQty));
                                AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
                                BigDecimal curperc =
                                    new BigDecimal(currentPre);
                                applicationLineVO.getCurrentRow().setAttribute("CurrPerc",
                                                                               curperc.setScale(20,
                                                                                                BigDecimal.ROUND_HALF_EVEN));
                                //                    applicationLineVO.getCurrentRow().setAttribute("CurrPerc",new BigDecimal(currentPre));
                                AdfFacesContext.getCurrentInstance().addPartialTarget(currPer);
                                BigDecimal curamt = new BigDecimal(currentAmt);
                                applicationLineVO.getCurrentRow().setAttribute("CurrAmount",
                                                                               curamt.setScale(20,
                                                                                               BigDecimal.ROUND_HALF_EVEN));
                                //                    applicationLineVO.getCurrentRow().setAttribute("CurrAmount",new BigDecimal(currentAmt));
                                AdfFacesContext.getCurrentInstance().addPartialTarget(currAmt);

                                // Set Tax Amount
                                if (taxRate == 0) {
                                    applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                                   new BigDecimal(0));
                                    AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                                } else {
                                    double taxAmt =
                                        (currentAmt * taxRate) / 100;
                                    applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                                   new BigDecimal(taxAmt));
                                    AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    public void onChangeCummAmt(ValueChangeEvent valueChangeEvent) {
        AdfFacesContext adfFacesContext = null;
        adfFacesContext = AdfFacesContext.getCurrentInstance();
        FacesContext ctx = FacesContext.getCurrentInstance();
        FacesMessage fm = null;
        System.out.println("onChangeCummAmt");
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            double old_value = valueChangeEvent.getOldValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getOldValue().toString());
            double new_value = valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
            System.out.println("new_value: "+new_value);
            if (old_value != new_value) {
                if (valueChangeEvent.getNewValue() != null) {
                    valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
                    double previousQty =
                        applicationLineVO.getCurrentRow().getAttribute("PrevTotQty") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevTotQty").toString());
                    double previousPer =
                        applicationLineVO.getCurrentRow().getAttribute("PrevPerc") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevPerc").toString());
                    double previousAmt =
                        applicationLineVO.getCurrentRow().getAttribute("PrevAmount") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevAmount").toString());

                    
                    double contractLneRate =
                        applicationLineVO.getCurrentRow().getAttribute("Trans_Rate") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Rate").toString());
                    double contractLneAmt =
                        applicationLineVO.getCurrentRow().getAttribute("Trans_Amount") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Amount").toString());
                    double cummulativeAmt =
                        valueChangeEvent.getNewValue() == null ? 0 :
                        Double.parseDouble(valueChangeEvent.getNewValue().toString());
                    double taxRate =
                        applicationLineVO.getCurrentRow().getAttribute("TaxRate") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("TaxRate").toString());
                    // set Qty
                    double currentAmt = cummulativeAmt - previousAmt;
                    System.out.println("currentAmt: "+currentAmt);
                    System.out.println("contractLneAmt: "+contractLneAmt);
                    System.out.println("previousAmt: "+previousAmt);
                    if(cummulativeAmt > contractLneAmt){
                        System.out.println("inside currentAmt < 0 condition: "+currentAmt);
                        cumuAmt.resetValue();
                        cumuAmt.setValue("");
                        cumuAmt.setValue(null);
                        fm = new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING", "Entered Amount exceeds the limit. Please check.");
                        ctx.addMessage(null, fm);
                        
                    }
                    else{
                        double cummulativeQty = 0;
                        if(contractLneRate != 0){
                            cummulativeQty = cummulativeAmt / contractLneRate; 
                        }
                        BigDecimal val = new BigDecimal(cummulativeQty);
                        applicationLineVO.getCurrentRow().setAttribute("CumTotQty",
                                                                       val.setScale(2,
                                                                                    BigDecimal.ROUND_HALF_EVEN));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cumuQty);

                        // set Percentage
                        double cummulativePer =
                            (100 * cummulativeAmt / contractLneAmt);
                        val = new BigDecimal(cummulativePer);
                        //                JSFUtils.addFacesErrorMessage("cummulativePer==>>"+cummulativePer);
                        applicationLineVO.getCurrentRow().setAttribute("CumPerc",
                                                                       val.setScale(2,
                                                                                    BigDecimal.ROUND_HALF_EVEN));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cumuPer);
                        double currentQty = cummulativeQty - previousQty;
                        double currentPre = cummulativePer - previousPer;
                        currentAmt = cummulativeAmt - previousAmt;
                        BigDecimal cuqty = new BigDecimal(currentQty);
                        applicationLineVO.getCurrentRow().setAttribute("CurrTotQty",
                                                                       cuqty.setScale(2,
                                                                                      BigDecimal.ROUND_HALF_EVEN));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
                        BigDecimal cuperc = new BigDecimal(currentPre);
                        applicationLineVO.getCurrentRow().setAttribute("CurrPerc",
                                                                       cuperc.setScale(2,
                                                                                       BigDecimal.ROUND_HALF_EVEN));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(currPer);
                        BigDecimal cuamt = new BigDecimal(currentAmt);
                        applicationLineVO.getCurrentRow().setAttribute("CurrAmount",
                                                                       cuamt.setScale(2,
                                                                                      BigDecimal.ROUND_HALF_EVEN));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(currAmt);
                        // Set Tax Amount
                        if (taxRate == 0) {
                            applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                           new BigDecimal(0));
                            AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                        } else {
                            double taxAmt = (currentAmt * taxRate) / 100;
                            applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                           new BigDecimal(taxAmt));
                            AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                        }
                    }
                    
                }
            }
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
            System.out.println("amtapplicationBuy");
            double old_value =
                valueChangeEvent.getOldValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getOldValue().toString());
            //System.out.println("old_value" + old_value);
            double new_value =
                valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
            
            if (old_value != new_value) {
                if (valueChangeEvent.getNewValue() != null) {
                    valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
                    double contractLneRate =
                        applicationLineVO.getCurrentRow().getAttribute("Trans_Rate") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Rate").toString());
                    double contractLneAmt =
                        applicationLineVO.getCurrentRow().getAttribute("Trans_Amount") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Amount").toString());
                    double cummulativeAmt =
                        valueChangeEvent.getNewValue() == null ? 0 :
                        Double.parseDouble(valueChangeEvent.getNewValue().toString());
                    //System.out.println("cummulativeAmt" + cummulativeAmt);
                    double taxRate =
                        applicationLineVO.getCurrentRow().getAttribute("TaxRate") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("TaxRate").toString());

                    // setting Current
                    double previousQty =
                        applicationLineVO.getCurrentRow().getAttribute("PrevTotQty") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevTotQty").toString());
                    double previousPer =
                        applicationLineVO.getCurrentRow().getAttribute("PrevPerc") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevPerc").toString());
                    double previousAmt =
                        applicationLineVO.getCurrentRow().getAttribute("PrevAmount") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevAmount").toString());
                    double currentAmt = cummulativeAmt - previousAmt;
                    System.out.println("currentAmt: "+currentAmt);
                    System.out.println("contractLneAmt: "+contractLneAmt);
                    System.out.println("previousAmt: "+previousAmt);
                    if(cummulativeAmt > contractLneAmt){
                        System.out.println("inside currentAmt < 0 condition: "+currentAmt);
                        cumuAmt.resetValue();
                        cumuAmt.setValue("");
                        cumuAmt.setValue(null);
                        fm = new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING", "Entered Amount exceeds the limit. Please check.");
                        ctx.addMessage(null, fm);
                        
                    }
                    else{
                        //set for 0
                        if (cummulativeAmt == 0) {
                            // set Qty
                            double cummulativeQty = 0;
                            if(contractLneRate != 0){
                                cummulativeQty = cummulativeAmt / contractLneRate; 
                            }
                            
                            BigDecimal val = new BigDecimal(cummulativeQty);
                            //System.out.println("qtyval" + val);
                            applicationLineVO.getCurrentRow().setAttribute("CumTotQty",
                                                                           0);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuQty);

                            // set Percentage
                            double cummulativePer =
                                (100 * cummulativeAmt / contractLneAmt);
                            //System.out.println("cummulativePer" + cummulativePer);
                            val = new BigDecimal(cummulativePer);
                            //System.out.println("perval" + val);
                            //                JSFUtils.addFacesErrorMessage("cummulativePer==>>"+cummulativePer);
                            applicationLineVO.getCurrentRow().setAttribute("CumPerc",
                                                                           0);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuPer);
                            double currentQty = cummulativeQty - previousQty;
                            double currentPre = cummulativePer - previousPer;
                            currentAmt = cummulativeAmt - previousAmt;
                            BigDecimal cuqty = new BigDecimal(currentQty);
                            applicationLineVO.getCurrentRow().setAttribute("CurrTotQty",
                                                                           0);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
                            BigDecimal cuperc = new BigDecimal(currentPre);
                            applicationLineVO.getCurrentRow().setAttribute("CurrPerc",
                                                                           0);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(currPer);
                            BigDecimal cuamt = new BigDecimal(currentAmt);
                            applicationLineVO.getCurrentRow().setAttribute("CurrAmount",
                                                                           0);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(currAmt);
                            // Set Tax Amount
                            if (taxRate == 0) {
                                applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                               new BigDecimal(0));
                                AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                            } else {
                                double taxAmt = (currentAmt * taxRate) / 100;
                                applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                               new BigDecimal(taxAmt));
                                AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                            }
                        } else {
                            // set Qty
                            double cummulativeQty =
                                cummulativeAmt / contractLneRate;
                            //System.out.println("cummulativeQty" + cummulativeQty);
                            BigDecimal val = new BigDecimal(cummulativeQty);
                            //System.out.println("qtyval" + val);
                            applicationLineVO.getCurrentRow().setAttribute("CumTotQty",
                                                                           val.setScale(20,
                                                                                        BigDecimal.ROUND_HALF_EVEN));
                            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuQty);

                            // set Percentage
                            double cummulativePer =
                                (100 * cummulativeAmt / contractLneAmt);
                            //System.out.println("cummulativePer" + cummulativePer);
                            val = new BigDecimal(cummulativePer);
                            //System.out.println("perval" + val);
                            //                JSFUtils.addFacesErrorMessage("cummulativePer==>>"+cummulativePer);
                            applicationLineVO.getCurrentRow().setAttribute("CumPerc",
                                                                           val.setScale(20,
                                                                                        BigDecimal.ROUND_HALF_EVEN));
                            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuPer);

                            double currentQty = cummulativeQty - previousQty;
                            double currentPre = cummulativePer - previousPer;
                            currentAmt = cummulativeAmt - previousAmt;
                            if (cummulativeAmt == previousAmt) {
                                applicationLineVO.getCurrentRow().setAttribute("CurrTotQty",
                                                                               0);
                                AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
                                applicationLineVO.getCurrentRow().setAttribute("CurrPerc",
                                                                               0);
                                AdfFacesContext.getCurrentInstance().addPartialTarget(currPer);
                                applicationLineVO.getCurrentRow().setAttribute("CurrAmount",
                                                                               0);
                                AdfFacesContext.getCurrentInstance().addPartialTarget(currAmt);
                                // Set Tax Amount
                                if (taxRate == 0) {
                                    applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                                   new BigDecimal(0));
                                    AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                                } else {
                                    double taxAmt = (currentAmt * taxRate) / 100;
                                    applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                                   new BigDecimal(taxAmt));
                                    AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                                }
                            } else {
                                BigDecimal cuqty = new BigDecimal(currentQty);
                                applicationLineVO.getCurrentRow().setAttribute("CurrTotQty",
                                                                               cuqty.setScale(20,
                                                                                              BigDecimal.ROUND_HALF_EVEN));
                                AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
                                BigDecimal cuperc = new BigDecimal(currentPre);
                                applicationLineVO.getCurrentRow().setAttribute("CurrPerc",
                                                                               cuperc.setScale(20,
                                                                                               BigDecimal.ROUND_HALF_EVEN));
                                AdfFacesContext.getCurrentInstance().addPartialTarget(currPer);
                                BigDecimal cuamt = new BigDecimal(currentAmt);
                                applicationLineVO.getCurrentRow().setAttribute("CurrAmount",
                                                                               cuamt.setScale(20,
                                                                                              BigDecimal.ROUND_HALF_EVEN));
                                AdfFacesContext.getCurrentInstance().addPartialTarget(currAmt);
                                // Set Tax Amount
                                if (taxRate == 0) {
                                    applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                                   new BigDecimal(0));
                                    AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                                } else {
                                    double taxAmt = (currentAmt * taxRate) / 100;
                                    applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                                   new BigDecimal(taxAmt));
                                    AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                                }
                            }
                        }    
                    }
                    
                    
                }
            }
        }
    }

    public void setCont_Amt(RichInputText cont_Amt) {
        this.cont_Amt = cont_Amt;
    }

    public RichInputText getCont_Amt() {
        return cont_Amt;
    }

    public void setBal_Cont_Amt(RichInputText bal_Cont_Amt) {
        this.bal_Cont_Amt = bal_Cont_Amt;
    }

    public RichInputText getBal_Cont_Amt() {
        return bal_Cont_Amt;
    }

    public void setCum_Amt(RichInputText cum_Amt) {
        this.cum_Amt = cum_Amt;
    }

    public RichInputText getCum_Amt() {
        return cum_Amt;
    }

    public void setCum_adv_rec(RichInputText cum_adv_rec) {
        this.cum_adv_rec = cum_adv_rec;
    }

    public RichInputText getCum_adv_rec() {
        return cum_adv_rec;
    }

    public void setCum_ret(RichInputText cum_ret) {
        this.cum_ret = cum_ret;
    }

    public RichInputText getCum_ret() {
        return cum_ret;
    }

    public void setTot_mat_adv_amt(RichInputText tot_mat_adv_amt) {
        this.tot_mat_adv_amt = tot_mat_adv_amt;
    }

    public RichInputText getTot_mat_adv_amt() {
        return tot_mat_adv_amt;
    }

    public void setCum_mat_adv_rec(RichInputText cum_mat_adv_rec) {
        this.cum_mat_adv_rec = cum_mat_adv_rec;
    }

    public RichInputText getCum_mat_adv_rec() {
        return cum_mat_adv_rec;
    }

    public void setCur_mat_adv_rec(RichInputText cur_mat_adv_rec) {
        this.cur_mat_adv_rec = cur_mat_adv_rec;
    }

    public RichInputText getCur_mat_adv_rec() {
        return cur_mat_adv_rec;
    }

    public void setBal_mat_adv_rec(RichInputText bal_mat_adv_rec) {
        this.bal_mat_adv_rec = bal_mat_adv_rec;
    }

    public RichInputText getBal_mat_adv_rec() {
        return bal_mat_adv_rec;
    }

    public void setMaterial_per(RichInputText material_per) {
        this.material_per = material_per;
    }

    public RichInputText getMaterial_per() {
        return material_per;
    }

    public void setAdv_rec_per_new(RichInputText adv_rec_per_new) {
        this.adv_rec_per_new = adv_rec_per_new;
    }

    public RichInputText getAdv_rec_per_new() {
        return adv_rec_per_new;
    }

    public void setMat_adv_rec_per_new(RichInputText mat_adv_rec_per_new) {
        this.mat_adv_rec_per_new = mat_adv_rec_per_new;
    }

    public RichInputText getMat_adv_rec_per_new() {
        return mat_adv_rec_per_new;
    }

    public void setPrev_mat_adv_rec(RichInputText prev_mat_adv_rec) {
        this.prev_mat_adv_rec = prev_mat_adv_rec;
    }

    public RichInputText getPrev_mat_adv_rec() {
        return prev_mat_adv_rec;
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void onClickPopupCancel(ActionEvent actionEvent) {
        this.getP1().cancel();
    }


    public void payDueDateVCL(ValueChangeEvent term) throws ParseException {
        ViewObject paymentDueVO =
            ADFUtils.findIterator("paymentDueDateROVO1Iterator").getViewObject();
        // Add event code here...

        if (term.getNewValue() != null) {
            if (applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate") !=
                null) {
                String days =
                    applicationHrdVO.getCurrentRow().getAttribute("due_days") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("due_days").toString();
                //               oracle.jbo.domain.Date appDate = (oracle.jbo.domain.Date)applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate");
                String stringDate =
                    applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate").toString();

                //                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                //                df.parse(stringDate);
                //System.err.println("---domainDate--->>" + stringDate);
                paymentDueVO.setNamedWhereClauseParam("curdate", stringDate);
                paymentDueVO.setNamedWhereClauseParam("BV_NAME",
                                                      term.getNewValue());
                paymentDueVO.executeQuery();
                if (paymentDueVO.getEstimatedRowCount() == 1) {
                    //System.err.println("Payment due Date====>" +
//                                       paymentDueVO.first().getAttribute("Paymentduedate"));
                    applicationHrdVO.getCurrentRow().setAttribute("PaymentDueDate",
                                                                  paymentDueVO.first().getAttribute("Paymentduedate"));
                    //                        buyPayDate.setValue(paymentDueVO.first().getAttribute("Paymentduedate"));
                    //                        paymentDueDate.setValue(paymentDueVO.first().getAttribute("Paymentduedate"));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(buyPayDate);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(paymentDueDate);
                }
            } else {
                JSFUtils.addFacesErrorMessage("Please select Application Date");
            }
        }
    }

    public void setPaymentDueDate(RichInputDate paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public RichInputDate getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setBuyPayDate(RichInputDate buyPayDate) {
        this.buyPayDate = buyPayDate;
    }

    public RichInputDate getBuyPayDate() {
        return buyPayDate;
    }

    public void setCurrTaxAmt(RichInputText currTaxAmt) {
        this.currTaxAmt = currTaxAmt;
    }

    public RichInputText getCurrTaxAmt() {
        return currTaxAmt;
    }

    public void setCurPayTaxAmount(RichOutputText curPayTaxAmount) {
        this.curPayTaxAmount = curPayTaxAmount;
    }

    public RichOutputText getCurPayTaxAmount() {
        return curPayTaxAmount;
    }

    public void setCurPayTaxAmount1(RichOutputText curPayTaxAmount1) {
        this.curPayTaxAmount1 = curPayTaxAmount1;
    }

    public RichOutputText getCurPayTaxAmount1() {
        return curPayTaxAmount1;
    }

    public void setTaxRateApp(RichOutputText taxRateApp) {
        this.taxRateApp = taxRateApp;
    }

    public RichOutputText getTaxRateApp() {
        return taxRateApp;
    }

    public void setTaxRateApp1(RichOutputText taxRateApp1) {
        this.taxRateApp1 = taxRateApp1;
    }

    public RichOutputText getTaxRateApp1() {
        return taxRateApp1;
    }

    public String onClickSave() {
        String page = null;
        page = onClickSaveApplication();
        return page;
    }

    public String onClickSaveApplication() {
        String pageRedirect = null;
        if (ADFContext.getCurrent().getSessionScope().get("addEditApp") !=
            null &&
            ADFContext.getCurrent().getSessionScope().get("addEditApp").toString().equals("edit")) {
//            //System.err.println("ccc-c--c1111 >> " + curOthCharge.getValue());
            applicationHrdVO.getCurrentRow().setAttribute("CurOthCharge",
                                                          inpCurOthCharge.getValue() ==
                                                          null ?
                                                          new BigDecimal(0) :
                                                          inpCurOthCharge.getValue());
            applicationHrdVO.getCurrentRow().setAttribute("PrevOthCharge",
                                                          inprevOthCharg.getValue() ==
                                                          null ?
                                                          new BigDecimal(0) :
                                                          inprevOthCharg.getValue());
            applicationHrdVO.getCurrentRow().setAttribute("TotOthCharge",
                                                          inTotOthCharg.getValue() ==
                                                          null ?
                                                          new BigDecimal(0) :
                                                          inTotOthCharg.getValue());
            //            applicationHrdVO.getCurrentRow().setAttribute("ApprovalStatus",
            //                                                          "APR");
            ADFUtils.findOperation("Commit").execute();
            pageRedirect = "save";
            ADFUtils.refreshTable("ApplicationNumber", searchApplicationVO);
            JSFUtils.addFacesInformationMessage("Application Information Saved Successfully");

        } else {
            if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy") ||
                ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
                if (applicationHrdVO.getCurrentRow().getAttribute("OrgId") ==
                    null) {
                    JSFUtils.addFacesErrorMessage("Please Select Business Unit");
                    pageRedirect = null;
                } else {
                    if (applicationHrdVO.getCurrentRow().getAttribute("Trans_ContractNumber") ==
                        null) {
                        JSFUtils.addFacesErrorMessage("Please Select Contract Number");
                        pageRedirect = null;
                    } else {
                        if (applicationHrdVO.getCurrentRow().getAttribute("Trans_SupplierName") ==
                            null) {
                            JSFUtils.addFacesErrorMessage("Please Select SupplierName");
                            pageRedirect = null;
                        } else {
                            if (applicationHrdVO.getCurrentRow().getAttribute("Trans_SupplierSite") ==
                                null) {
                                JSFUtils.addFacesErrorMessage("Please Select Supplier Site Name");
                                pageRedirect = null;
                            } else {
                                if (applicationHrdVO.getCurrentRow().getAttribute("ApplPayTerm") ==
                                    null) {
                                    //if (Boolean.FALSE) {
                                    JSFUtils.addFacesErrorMessage("Please Select Application Pay Term");
                                    pageRedirect = null;
                                } else {
                                    if (applicationHrdVO.getCurrentRow().getAttribute("PaymentType") ==
                                        null) {
                                        JSFUtils.addFacesErrorMessage("Please Select Payment Type");
                                        pageRedirect = null;
                                    } else {
                                        if (applicationHrdVO.getCurrentRow().getAttribute("SupplierInvoiceDate") ==
                                            null) {
                                            JSFUtils.addFacesErrorMessage("Please Select Supplier Invoice Date");
                                            pageRedirect = null;
                                        } else {
                                            if (applicationHrdVO.getCurrentRow().getAttribute("SupplierInvoiceNum") ==
                                                null) {
                                                JSFUtils.addFacesErrorMessage("Please Select Supplier Invoice Number");
                                                pageRedirect = null;
                                            } else {
                                                onClickCalculateAmount();
                                                applicationHrdVO.getCurrentRow().setAttribute("ApplicationStatus",
                                                                                              "ACTIVE");
                                                applicationHrdVO.getCurrentRow().setAttribute("FuncId",
                                                                                              "200003");
                                                applicationHrdVO.getCurrentRow().setAttribute("ApplicationNumber",
                                                                                              "App-" +
                                                                                              applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId"));
                                                //System.err.println("ccc-c--c>> " +
//                                                                   curOthCharge.getValue());
                                                applicationHrdVO.getCurrentRow().setAttribute("CurOthCharge",
                                                                                              inpCurOthCharge.getValue() ==
                                                                                              null ?
                                                                                              new BigDecimal(0) :
                                                                                              inpCurOthCharge.getValue());
                                                applicationHrdVO.getCurrentRow().setAttribute("PrevOthCharge",
                                                                                              inprevOthCharg.getValue() ==
                                                                                              null ?
                                                                                              new BigDecimal(0) :
                                                                                              inprevOthCharg.getValue());
                                                applicationHrdVO.getCurrentRow().setAttribute("TotOthCharge",
                                                                                              inTotOthCharg.getValue() ==
                                                                                              null ?
                                                                                              new BigDecimal(0) :
                                                                                              inTotOthCharg.getValue());
                                                ADFUtils.findOperation("Commit").execute();
                                                pageRedirect = "save";
                                                JSFUtils.numberFaceMessage("Application",
                                                                           applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber"));
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
            } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                if (applicationHrdVO.getCurrentRow().getAttribute("OrgId") ==
                    null) {
                    JSFUtils.addFacesErrorMessage("Please Select Business Unit");
                    pageRedirect = null;
                } else {
                    if (applicationHrdVO.getCurrentRow().getAttribute("Trans_ContractNumber") ==
                        null) {
                        JSFUtils.addFacesErrorMessage("Please Select Contract Number");
                        pageRedirect = null;
                    } else {
                        // if (applicationHrdVO.getCurrentRow().getAttribute("ApplPayTerm") ==null) {
                        if (Boolean.FALSE) {
                            JSFUtils.addFacesErrorMessage("Please Select Customer Name");
                            pageRedirect = null;
                        } else {
                            // if (applicationHrdVO.getCurrentRow().getAttribute("ApplPayTerm") ==null) {
                            if (Boolean.FALSE) {
                                JSFUtils.addFacesErrorMessage("Please Select Payment Type");
                                pageRedirect = null;
                            } else {
                                // if (applicationHrdVO.getCurrentRow().getAttribute("ApplPayTerm") ==null) {
                                if (Boolean.FALSE) {
                                    JSFUtils.addFacesErrorMessage("Please Select Application Pay Term");
                                    pageRedirect = null;
                                } else {
                                    onClickCalculateAmount();
                                    applicationHrdVO.getCurrentRow().setAttribute("ApplicationStatus",
                                                                                  "ACTIVE");
                                    //                                  applicationHrdVO.getCurrentRow().setAttribute("ApprovalStatus","APR");
                                    applicationHrdVO.getCurrentRow().setAttribute("FuncId",
                                                                                  "200004");
                                    applicationHrdVO.getCurrentRow().setAttribute("ApplicationNumber",
                                                                                  "App-" +
                                                                                  applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId"));
                                    ADFUtils.findOperation("Commit").execute();
                                    pageRedirect = "save";
                                    JSFUtils.numberFaceMessage("Application",
                                                               applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber"));
                                }
                            }
                        }

                    }
                }
            }

        }


        //          double contractAdvanAmount=applicationHrdVO.getCurrentRow().getAttribute("CurApplication")==null?0:Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurApplication").toString());
        //          applicationHrdVO.executeQuery();
        //          double ccc=applicationHrdVO.getCurrentRow().getAttribute("CurApplication")==null?0:Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurApplication").toString());
        //          applicationHrdVO.getCurrentRow().setAttribute("Version", 0);
        /*
            functionVO.setNamedWhereClauseParam("p_code", "SELL_PAY_APP");
            functionVO.executeQuery();
            //System.err.println("==functionVO COUNT==" +
                               functionVO.getEstimatedRowCount());

            if (functionVO.getEstimatedRowCount() == 1) {
                Object funid = functionVO.first().getAttribute("FuncId");
                applicationHrdVO.getCurrentRow().setAttribute("FuncId", funid);
                applicationHrdVO.getCurrentRow().setAttribute("ApplicationStatus",
                                                              "ACTIVE");
                applicationHrdVO.getCurrentRow().setAttribute("ApprovalStatus",
                                                              "APR");
                applicationHrdVO.getCurrentRow().setAttribute("ApplicationNumber",
                                                              "App- " +
                                                              applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId"));
                ADFUtils.findOperation("Commit").execute();
                ADFUtils.refreshTable("ApplicationNumber",
                                      searchApplicationVO);
                JSFUtils.numberFaceMessage("Application",
                                           applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber"));
            } else {
                applicationHrdVO.getCurrentRow().setAttribute("ApplicationStatus",
                                                              "ACTIVE");
                applicationHrdVO.getCurrentRow().setAttribute("ApprovalStatus",
                                                              "APR");
                applicationHrdVO.getCurrentRow().setAttribute("ApplicationNumber",
                                                              "App- " +
                                                              applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId"));
                ADFUtils.findOperation("Commit").execute();
                ADFUtils.refreshTable("ApplicationNumber",
                                      searchApplicationVO);
                JSFUtils.numberFaceMessage("Application",
                                           applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber"));
            }

        */
        return pageRedirect;
    }

    public void setAdvPer(RichPanelLabelAndMessage advPer) {
        this.advPer = advPer;
    }

    public RichPanelLabelAndMessage getAdvPer() {
        return advPer;
    }

    public void setContra_Charges(RichInputText contra_Charges) {
        this.contra_Charges = contra_Charges;
    }

    public RichInputText getContra_Charges() {
        return contra_Charges;
    }

    public void setPenality_charges(RichInputText penality_charges) {
        this.penality_charges = penality_charges;
    }

    public RichInputText getPenality_charges() {
        return penality_charges;
    }

    public void setCurAdvRecPer(RichInputText curAdvRecPer) {
        this.curAdvRecPer = curAdvRecPer;
    }

    public RichInputText getCurAdvRecPer() {
        return curAdvRecPer;
    }

    public void setCurMatAdvRecPer(RichInputText curMatAdvRecPer) {
        this.curMatAdvRecPer = curMatAdvRecPer;
    }

    public RichInputText getCurMatAdvRecPer() {
        return curMatAdvRecPer;
    }

    //**Approval Process
    String submitPkg = "xxfnd_util_pkg.submit_for_approval";
    String responsePkg = "xxfnd_util_pkg.update_response";
    String tableName = "XXSC_PAY_APPL_HEADERS";
    String app_status_column = "APPROVAL_STATUS";
    String pk_column = "APPL_HEADER_ID";
    String fwd_to = "0";
    //  String response="Approved";
    //  String status  ="A";
    //    String submitMailPkg = "xxfnd_util_pkg.submit_mail";

    public boolean getApprovalUser() {
        boolean flag = false;
        String flowWith =
            applicationHrdVO.getCurrentRow().getAttribute("FlowWith") == null ?
            "" :
            applicationHrdVO.getCurrentRow().getAttribute("FlowWith").toString();
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
//            //System.err.println("flowWith-->>" + flowWith + "loginID-->" +
//                               loginID);
            if (flowWith.equalsIgnoreCase(loginID)) {
                flag = true;
            } else {
                flag = false;
            }
        } else {
            flag = false;
        }
//        //System.err.println("Flag" + flag);
        return flag;
    }

    public String onClickSubmit() throws SQLException, MalformedURLException,
                                         IOException {
        String pageRedirect = null;
        String page = onClickSaveApplication();
        ///* Approval Process
        if (page.equalsIgnoreCase("save")) {
            String func_id =
                applicationHrdVO.getCurrentRow().getAttribute("FuncId") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("FuncId").toString();
            String ref_id =
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
            String level_no =
                applicationHrdVO.getCurrentRow().getAttribute("FlowLevel") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("FlowLevel").toString();
            String OrgId =
                applicationHrdVO.getCurrentRow().getAttribute("OrgId") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("OrgId").toString();
            String ProjectId =
                applicationHrdVO.getCurrentRow().getAttribute("TransProjectId") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("TransProjectId").toString();
            /**
             * Approval Throw JavaInputPrameters
             */
            String netPaymentAmt =
                applicationHrdVO.getCurrentRow().getAttribute("CurPayAmount") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("CurPayAmount").toString();
            String grossAmt =
                applicationHrdVO.getCurrentRow().getAttribute("CurApplication") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("CurApplication").toString();
            String totalCumAmt =
                applicationHrdVO.getCurrentRow().getAttribute("CummAmt") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("CummAmt").toString();
            String supplierName =
                applicationHrdVO.getCurrentRow().getAttribute("Trans_SupplierName") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("Trans_SupplierName").toString();
            String origConAmt =
                applicationHrdVO.getCurrentRow().getAttribute("Trans_Contract_Amount") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("Trans_Contract_Amount").toString();
            String conNum =
                applicationHrdVO.getCurrentRow().getAttribute("Trans_ContractNumber") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("Trans_ContractNumber").toString();
            String projName =
                applicationHrdVO.getCurrentRow().getAttribute("Trans_ProjectName") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("Trans_ProjectName").toString();
            String projNum =
                applicationHrdVO.getCurrentRow().getAttribute("Trans_ProjectNumber") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("Trans_ProjectNumber").toString();
            String applDate =
                applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate").toString();
            String applNumber =
                applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber").toString();
//            //System.err.println("Input Values for mail notification" +
//                               netPaymentAmt + "," + grossAmt + "," +
//                               totalCumAmt + "," + supplierName + "," +
//                               origConAmt + "," + conNum + "," + projName +
//                               "," + projNum + "," + applDate + "," + "," +
//                               applNumber);
            String flag =
                ADFApproval.invokeSubmitPkg(submitPkg, func_id, ref_id,
                                            level_no, tableName,
                                            app_status_column, pk_column,
                                            OrgId, ProjectId);
            //                  String flag=ADFApproval.invokeSubmitPkg(submitPkg, func_id, ref_id, level_no, tableName, app_status_column, pk_column);
            if (flag.equalsIgnoreCase("Success")) {
                // flowWith - TX table
                String flowWith =
                    ADFContext.getCurrent().getSessionScope().get("flow_with") ==
                    null ? "0" :
                    ADFContext.getCurrent().getSessionScope().get("flow_with").toString();
                ViewObject ApproveMailVO =
                    ADFUtils.findIterator("XxscHeadDetailROVO1Iterator").getViewObject();
                ApproveMailVO.setNamedWhereClauseParam("BV_USER_ID", flowWith);
                ApproveMailVO.executeQuery();
//                //System.out.println("COUNT--" +
//                                   ApproveMailVO.getEstimatedRowCount());
                if (ApproveMailVO.getEstimatedRowCount() != 0) {
                    String to =
                        ApproveMailVO.first().getAttribute("Email") == null ?
                        "naresco@eim.ae" :
                        ApproveMailVO.first().getAttribute("Email").toString();
                    String fromMail = "info@naresco.com"; // i will give mail

                    String LoginUser =
                        ADFContext.getCurrent().getSessionScope().get("userName") ==
                        null ? "0" :
                        ADFContext.getCurrent().getSessionScope().get("userName").toString();

                    //                                    String htmlBody= MailTemplates.submit("Application", applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber").toString(), LoginUser);
                    //                                    String subject="Mail Notification";
                    //                                    MailServices.sendNotification("dineshkumar.p@4iapps.com", "dineshkumar.p@4iapps.com", "Hai", null, "Hai");
                    //                                    MailServices.sendNotification("dineshkumar.p@4iapps.com,arunachalam.t@4iapps.com,sundarrajan.v@4iapps.com,mahalingam.m@4iapps.com", fromMail, null, htmlBody, subject);
                    //                        ADFApproval.submitMailPkg(fromMail, to, "Application",
                    //                                                  applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber").toString(),
                    //                                                  LoginUser);
                    // String htmlBody= MailTemplates.submit("Payment Plan Change", BookingNumber, LoginUser);--checkMail
                    // String subject="Payment Plan Chnaged for"+BookingNumber;
                    // MailServices.sendMail(htmlBody, subject, MailTemplates.FromAddress, ar, MailTemplates.FromAddressPassword, MailTemplates.smtpPORT, "N", null);
                    /**
                   * Mail Notification Throw java
                   */
                    //String htmlBody= MailTemplates.checkMail("applNumber","LoginUser","conNum","projName","supplierName","applDate","origConAmt","grossAmt","netPaymentAmt");

                    String subject = "Application" + applNumber;
                    //                   MailServices.sendMailNotification( to,subject,htmlBody);

                    if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                        JSFUtils.addFacesInformationMessage("Buy Application Information Saved Successfully and Submitted For Approval" +
                                                            ProjectId +
                                                            func_id);
                        pageRedirect = "save";
                        cb9.setDisabled(Boolean.TRUE);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cb9);
                    } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                        JSFUtils.addFacesInformationMessage("Sell Application Information Saved Successfully and Submitted For Approval");
                        pageRedirect = "save";
                        cb9.setDisabled(Boolean.TRUE);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cb9);
                    }

                } else {
                    //                    JSFUtils.addFacesErrorMessage("Mail Notification Failed");
                }
            } else {
                JSFUtils.addFacesErrorMessage("Error in Submit For Approval. Error:" +
                                              flag);
                pageRedirect = null;
            }
        }
        //        */
        //        if (page.equalsIgnoreCase("save")) {
        //            applicationHrdVO.getCurrentRow().setAttribute("ApplicationStatus",
        //                                                          "ACTIVE");
        //            applicationHrdVO.getCurrentRow().setAttribute("ApprovalStatus",
        //                                                          "APR");
        //            ADFUtils.findOperation("Commit").execute();
        //            JSFUtils.addFacesInformationMessage("Buy Application Information Saved Successfully and Approved");
        //            pageRedirect = "save";
        //        }
        else {
            pageRedirect = null;
        }
        return pageRedirect;
    }

    public String onClickApprove() throws SQLException {
        String pageRedirect = null;
        String netPaymentAmt =
            applicationHrdVO.getCurrentRow().getAttribute("CurPayAmount") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("CurPayAmount").toString();
        String grossAmt =
            applicationHrdVO.getCurrentRow().getAttribute("CurApplication") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("CurApplication").toString();
        String totalCumAmt =
            applicationHrdVO.getCurrentRow().getAttribute("CummAmt") == null ?
            "0" :
            applicationHrdVO.getCurrentRow().getAttribute("CummAmt").toString();
        String supplierName =
            applicationHrdVO.getCurrentRow().getAttribute("Trans_SupplierName") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("Trans_SupplierName").toString();
        String origConAmt =
            applicationHrdVO.getCurrentRow().getAttribute("Trans_Contract_Amount") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("Trans_Contract_Amount").toString();
        String conNum =
            applicationHrdVO.getCurrentRow().getAttribute("Trans_ContractNumber") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("Trans_ContractNumber").toString();
        String projName =
            applicationHrdVO.getCurrentRow().getAttribute("Trans_ProjectName") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("Trans_ProjectName").toString();
        String projNum =
            applicationHrdVO.getCurrentRow().getAttribute("Trans_ProjectNumber") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("Trans_ProjectNumber").toString();
        String applDate =
            applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate").toString();
        String applNumber =
            applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber").toString();
        String custName =
            applicationHrdVO.getCurrentRow().getAttribute("Trans_customer_name") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("Trans_customer_name").toString();

//        //System.err.println("Input Values for mail notification" +
//                           netPaymentAmt + "," + grossAmt + "," + totalCumAmt +
//                           "," + supplierName + "," + origConAmt + "," +
//                           conNum + "," + projName + "," + projNum + "," +
//                           applDate + "," + "," + applNumber + "," + custName);

        if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy") ||
            ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {

            String approDesc =
                appValue.getValue() == null ? "Approved" : appValue.getValue().toString();
            String func_id =
                applicationHrdVO.getCurrentRow().getAttribute("FuncId") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("FuncId").toString();
            String ref_id =
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
            String level_no =
                applicationHrdVO.getCurrentRow().getAttribute("FlowLevel") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("FlowLevel").toString();
            String appr_id =
                applicationHrdVO.getCurrentRow().getAttribute("FlowWith") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("FlowWith").toString();
            String user_grp =
                applicationHrdVO.getCurrentRow().getAttribute("UserGrpId") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("UserGrpId").toString();

            String flag =
                ADFApproval.invokeResponsePkg(responsePkg, func_id, user_grp,
                                              ref_id, level_no, appr_id,
                                              approDesc, "A", fwd_to,
                                              tableName, app_status_column,
                                              pk_column);
            if (flag.equalsIgnoreCase("Success")) {
                if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                    mailidVO.setNamedWhereClauseParam("BV_COLUMN_NAME",
                                                      "FLOW_WITH");
                    mailidVO.setNamedWhereClauseParam("BV_TABLE_NAME",
                                                      "XXSC_PAY_APPL_HEADERS");
                    mailidVO.setNamedWhereClauseParam("BV_WHERE_CONDTION",
                                                      "APPL_HEADER_ID");
                    mailidVO.setNamedWhereClauseParam("BV_VALUE", ref_id);
                    mailidVO.executeQuery();
                                        String to =
                                            mailidVO.first().getAttribute("Mailid") == null ?
                                            "null" :
                                            mailidVO.first().getAttribute("Mailid").toString();
                    //String to = "sudha.y@4iapps.com";

                    if (to != null || to != "-") {
                        String LoginUser =
                            ADFContext.getCurrent().getSessionScope().get("userName") ==
                            null ? "0" :
                            ADFContext.getCurrent().getSessionScope().get("userName").toString();
                        //String to = "sudha.y@4iapps.com";
                        ArrayList<String> ar = new ArrayList();
                        ar.add(to);
                        String fromMail =
                            "info@naresco.com"; // i will give mail

                        String htmlBody =
                            MailTemplates.checkMail("Supplier Name",
                                                    "Application Number",
                                                    "Application Date",
                                                    "Application", applNumber,
                                                    LoginUser, conNum,
                                                    projName, supplierName,
                                                    applDate, origConAmt,
                                                    grossAmt, netPaymentAmt);
                        String subject =
                            "Application-" + applNumber + " Submitted for Approval";
                        MailServices.sendMailNotification(htmlBody, subject,
                                                          ar, "N", null);

                        //                        ADFApproval.submitMailPkg(LoginUser, to, "Application",
                        //                                                  applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber").toString(),
                        //                                                  LoginUser);
                        JSFUtils.addFacesInformationMessage("Buy Application Information Saved Successfully and Submitted For Approval");
                        pageRedirect = "save";
                    } else {
                        JSFUtils.addFacesInformationMessage("Buy Application Approved Successfully");
                        pageRedirect = "save";
                    }

                } else {
                    pageRedirect = null;
                }
            } else {
//                //System.err.println("flag returns fail");
                JSFUtils.addFacesErrorMessage("Approval Process Failed. Error Message:" +
                                              flag);
                pageRedirect = null;
            }
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            String approDesc =
                appValue.getValue() == null ? "Approved" : appValue.getValue().toString();
            String func_id =
                applicationHrdVO.getCurrentRow().getAttribute("FuncId") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("FuncId").toString();
            String ref_id =
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
            String level_no =
                applicationHrdVO.getCurrentRow().getAttribute("FlowLevel") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("FlowLevel").toString();
            String appr_id =
                applicationHrdVO.getCurrentRow().getAttribute("FlowWith") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("FlowWith").toString();
            String user_grp =
                applicationHrdVO.getCurrentRow().getAttribute("UserGrpId") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("UserGrpId").toString();

            String flag =
                ADFApproval.invokeResponsePkg(responsePkg, func_id, user_grp,
                                              ref_id, level_no, appr_id,
                                              approDesc, "A", fwd_to,
                                              tableName, app_status_column,
                                              pk_column);
            if (flag.equalsIgnoreCase("Success")) {
                if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                    mailidVO.setNamedWhereClauseParam("BV_COLUMN_NAME",
                                                      "FLOW_WITH");
                    mailidVO.setNamedWhereClauseParam("BV_TABLE_NAME",
                                                      "XXSC_PAY_APPL_HEADERS");
                    mailidVO.setNamedWhereClauseParam("BV_WHERE_CONDTION",
                                                      "APPL_HEADER_ID");
                    mailidVO.setNamedWhereClauseParam("BV_VALUE", ref_id);
                    mailidVO.executeQuery();
                                        String to =
                                            mailidVO.first().getAttribute("Mailid") == null ?
                                            "null" :
                                            mailidVO.first().getAttribute("Mailid").toString();
               //     String to = "sudha.y@4iapps.com";
                    if (to != "null" || to != "-") {
                        String LoginUser =
                            ADFContext.getCurrent().getSessionScope().get("userName") ==
                            null ? "0" :
                            ADFContext.getCurrent().getSessionScope().get("userName").toString();
                        //  String to = "sudha.y@4iapps.com";
                        ArrayList<String> ar = new ArrayList();
                        ar.add(to);
                        String fromMail =
                            "info@naresco.com"; // i will give mail

                        String htmlBody =
                            MailTemplates.checkMail("Customer Name",
                                                    "Application Number",
                                                    "Application Date",
                                                    "Application", applNumber,
                                                    LoginUser, conNum,
                                                    projName, custName,
                                                    applDate, origConAmt,
                                                    grossAmt, netPaymentAmt);
                        String subject =
                            "Application-" + applNumber + " Submitted for Approval";
                        MailServices.sendMailNotification(htmlBody, subject,
                                                          ar, "N", null);
                        //                        ADFApproval.submitMailPkg(LoginUser, to, "Application",
                        //                                                  applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber").toString(),
                        //                                                  LoginUser);
                        JSFUtils.addFacesInformationMessage("Sell Application Information Saved Successfully and Submitted For Approval");
                        pageRedirect = "save";
                    } else {
                        JSFUtils.addFacesInformationMessage("Sell Application Approved Successfully");
                        pageRedirect = "save";
                    }
                } else {
                    pageRedirect = null;
                }
            } else {
                JSFUtils.addFacesErrorMessage("Approval Process Failed. Error Message:" +
                                              flag);
                pageRedirect = null;
            }
        }


        return pageRedirect;
    }

    public String onClickReject() throws SQLException {
        String pageRedirect = null;
        if (rejectValue.getValue() != null) {

            if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy") ||
                ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
                String func_id =
                    applicationHrdVO.getCurrentRow().getAttribute("FuncId") ==
                    null ? "" :
                    applicationHrdVO.getCurrentRow().getAttribute("FuncId").toString();
                String ref_id =
                    applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
                    null ? "" :
                    applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
                String level_no =
                    applicationHrdVO.getCurrentRow().getAttribute("FlowLevel") ==
                    null ? "" :
                    applicationHrdVO.getCurrentRow().getAttribute("FlowLevel").toString();
                String appr_id =
                    applicationHrdVO.getCurrentRow().getAttribute("FlowWith") ==
                    null ? "" :
                    applicationHrdVO.getCurrentRow().getAttribute("FlowWith").toString();
                String user_grp =
                    applicationHrdVO.getCurrentRow().getAttribute("UserGrpId") ==
                    null ? "" :
                    applicationHrdVO.getCurrentRow().getAttribute("UserGrpId").toString();
                String flag =
                    ADFApproval.invokeResponsePkg(responsePkg, func_id,
                                                  user_grp, ref_id, level_no,
                                                  appr_id,
                                                  rejectValue.getValue().toString(),
                                                  "R", fwd_to, tableName,
                                                  app_status_column,
                                                  pk_column);
                if (flag.equalsIgnoreCase("Success")) {
                    if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                        JSFUtils.addFacesInformationMessage("Buy Contract Rejected");
                        pageRedirect = "save";
                    } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                        JSFUtils.addFacesInformationMessage("Sell Contract Rejected");
                        pageRedirect = "save";
                    }
                } else {
                    JSFUtils.addFacesErrorMessage("Rejection Process Failed. Error:" +
                                                  flag);
                    pageRedirect = null;
                }
            } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                String func_id =
                    applicationHrdVO.getCurrentRow().getAttribute("FuncId") ==
                    null ? "" :
                    applicationHrdVO.getCurrentRow().getAttribute("FuncId").toString();
                String ref_id =
                    applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
                    null ? "" :
                    applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
                String level_no =
                    applicationHrdVO.getCurrentRow().getAttribute("FlowLevel") ==
                    null ? "" :
                    applicationHrdVO.getCurrentRow().getAttribute("FlowLevel").toString();
                String appr_id =
                    applicationHrdVO.getCurrentRow().getAttribute("FlowWith") ==
                    null ? "" :
                    applicationHrdVO.getCurrentRow().getAttribute("FlowWith").toString();
                String user_grp =
                    applicationHrdVO.getCurrentRow().getAttribute("UserGrpId") ==
                    null ? "" :
                    applicationHrdVO.getCurrentRow().getAttribute("UserGrpId").toString();
                String flag =
                    ADFApproval.invokeResponsePkg(responsePkg, func_id,
                                                  user_grp, ref_id, level_no,
                                                  appr_id,
                                                  rejectValue.getValue().toString(),
                                                  "R", fwd_to, tableName,
                                                  app_status_column,
                                                  pk_column);
                if (flag.equalsIgnoreCase("Success")) {
                    if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                        JSFUtils.addFacesInformationMessage("Buy Contract Rejected");
                        pageRedirect = "save";
                    } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                        JSFUtils.addFacesInformationMessage("Sell Contract Rejected");
                        pageRedirect = "save";
                    }
                } else {
                    JSFUtils.addFacesErrorMessage("Rejection Process Failed. Error:" +
                                                  flag);
                    pageRedirect = null;
                }
            }


        } else {
            JSFUtils.addFacesErrorMessage("Please Enter Reject Reason");
        }
        return pageRedirect;
    }


    public void setP3(RichPopup p3) {
        this.p3 = p3;
    }

    public RichPopup getP3() {
        return p3;
    }

    public void setRejectValue(RichInputText rejectValue) {
        this.rejectValue = rejectValue;
    }

    public RichInputText getRejectValue() {
        return rejectValue;
    }

    public void onRejectCancel(ActionEvent actionEvent) {
        this.getP3().cancel();
    }

    public void penalty_back_charges() {
        String Hid =
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
        String ver =
            applicationHrdVO.getCurrentRow().getAttribute("Version") == null ?
            "0" :
            applicationHrdVO.getCurrentRow().getAttribute("Version").toString();
        String apphdrid =
            applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
            null ? "" :
            applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
        double Mat_onsite =
            applicationHrdVO.getCurrentRow().getAttribute("MatOnSite") ==
            null ? 0 :
            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("MatOnSite").toString());
        double Mat_onsite_rec =
            applicationHrdVO.getCurrentRow().getAttribute("MatOnSiteRec") ==
            null ? 0 :
            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("MatOnSiteRec").toString());
        double Cur_mat = Mat_onsite - Mat_onsite_rec;
        applicationHrdVO.getCurrentRow().setAttribute("CurMatOnSiteRec",
                                                      Cur_mat);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cur_mat_onsite);
        penaltybackchargesVO.setNamedWhereClauseParam("BV_CONT_HDR_ID", Hid);
        penaltybackchargesVO.setNamedWhereClauseParam("BV_PAY_TYPE",
                                                      "Interim");
        penaltybackchargesVO.setNamedWhereClauseParam("BV_APP_HDR_ID",
                                                      apphdrid);
        penaltybackchargesVO.setNamedWhereClauseParam("BV_VERSION", ver);
        penaltybackchargesVO.executeQuery();
        if (penaltybackchargesVO.getEstimatedRowCount() > 0) {
            applicationHrdVO.getCurrentRow().setAttribute("PrevContraCharges",
                                                          penaltybackchargesVO.first().getAttribute("BackCharges"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(prev_contra);
            applicationHrdVO.getCurrentRow().setAttribute("PrevPenaltyCharges",
                                                          penaltybackchargesVO.first().getAttribute("PenaltyCharges"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(prev_penalty);
            applicationHrdVO.getCurrentRow().setAttribute("PrevMaterialRec",
                                                          penaltybackchargesVO.first().getAttribute("MaterialRecovery"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(prev_Mat_rec);
        }
    }

    public void setPrev_contra(RichInputText prev_contra) {
        this.prev_contra = prev_contra;
    }

    public RichInputText getPrev_contra() {
        return prev_contra;
    }

    public void setPrev_penalty(RichInputText prev_penalty) {
        this.prev_penalty = prev_penalty;
    }

    public RichInputText getPrev_penalty() {
        return prev_penalty;
    }

    public void setPrev_Mat_rec(RichInputText prev_Mat_rec) {
        this.prev_Mat_rec = prev_Mat_rec;
    }

    public RichInputText getPrev_Mat_rec() {
        return prev_Mat_rec;
    }

    public void setCur_mat_onsite(RichInputText cur_mat_onsite) {
        this.cur_mat_onsite = cur_mat_onsite;
    }

    public RichInputText getCur_mat_onsite() {
        return cur_mat_onsite;
    }

    public void setP4(RichPopup p4) {
        this.p4 = p4;
    }

    public RichPopup getP4() {
        return p4;
    }

    public void setAppValue(RichInputText appValue) {
        this.appValue = appValue;
    }

    public RichInputText getAppValue() {
        return appValue;
    }

    public void onApprovCacel(ActionEvent actionEvent) {
        this.getP4().cancel();
    }

    public void setEcpTotAmt(RichInputText ecpTotAmt) {
        this.ecpTotAmt = ecpTotAmt;
    }

    public RichInputText getEcpTotAmt() {
        return ecpTotAmt;
    }

    public void onChangeEcpPer(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != null) {
            double totalAmt =
                applicationLineVO.getCurrentRow().getAttribute("Trans_Amount") ==
                null ? 0 :
                Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Amount").toString());
            double ecpPer =
                valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
            double ecpAmt = (totalAmt * ecpPer / 100);
            applicationLineVO.getCurrentRow().setAttribute("EcpTotalAmount",
                                                           ecpAmt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(ecpTotAmt);
        } else {
            double totalAmt =
                applicationLineVO.getCurrentRow().getAttribute("Trans_Amount") ==
                null ? 0 :
                Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Amount").toString());
            double ecpPer = 0;
            double ecpAmt = (totalAmt * ecpPer / 100);
            applicationLineVO.getCurrentRow().setAttribute("EcpTotalAmount",
                                                           ecpAmt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(ecpTotAmt);
        }
    }

    public void cleardata(ActionEvent actionEvent) {
        Row r = applicationLineVO.getCurrentRow();
        r.setAttribute("CumTotQty", null);
        r.setAttribute("CumPerc", null);
        r.setAttribute("CumAmount", null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(t1);

    }

    public void setProId(RichOutputText proId) {
        this.proId = proId;
    }

    public RichOutputText getProId() {
        return proId;
    }

    public void setP2(RichPopup p2) {
        this.p2 = p2;
    }

    public RichPopup getP2() {
        return p2;
    }


    public void onClickFinalCancel(ActionEvent actionEvent) {
        this.getP2().cancel();
    }

    public void onClickFinal(ActionEvent actionEvent) {
        String advRecPerFinal = 
            applicationHrdVO.getCurrentRow().getAttribute("Cont_Adv_Recovery") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("Cont_Adv_Recovery").toString();
       System.out.println("advRecPerFinal: "+advRecPerFinal);
        String appContID =
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
        String appVersion =
            applicationHrdVO.getCurrentRow().getAttribute("Version") == null ?
            "0" :
            applicationHrdVO.getCurrentRow().getAttribute("Version").toString();
        String apphdrid =
            applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
        double advAmt =
            tans_Adv_rec.getValue() == null ? 0 : Double.parseDouble(tans_Adv_rec.getValue().toString());
        double matAdvAmt =
            material_Adv_amt.getValue() == null ? 0 : Double.parseDouble(material_Adv_amt.getValue().toString());
        double retAmt =
            trans_ret_amt.getValue() == null ? 0 : Double.parseDouble(trans_ret_amt.getValue().toString());
System.err.println("appContID==>" + appContID);
System.err.println("appVersion==>" + appVersion);
System.err.println("apphdrid==>" + apphdrid);
System.err.println("adv Amt==>" + advAmt);
System.err.println("matAdv Amt==>" + matAdvAmt);
System.err.println("ret Amt==>" + retAmt);
        // check Minimum 1 Interim
        ViewObject checkAppHrdVO =
            ADFUtils.findIterator("checkApplicationROVO1Iterator").getViewObject();
        checkAppHrdVO.setNamedWhereClauseParam("BV_HID", appContID);
        checkAppHrdVO.executeQuery();
        if (checkAppHrdVO.getEstimatedRowCount() > 0) {
            ViewObject getBalAppVO =
                ADFUtils.findIterator("FinalAppCalcROVO1Iterator").getViewObject();
            getBalAppVO.setNamedWhereClauseParam("BV_HID", appContID);
            getBalAppVO.setNamedWhereClauseParam("APP_HDR_ID", apphdrid);
            getBalAppVO.setNamedWhereClauseParam("VER", appVersion);
            getBalAppVO.executeQuery();
            double balAdvRecAmt =
                getBalAppVO.first().getAttribute("Finbaladvrec") == null ? 0 :
                Double.parseDouble(getBalAppVO.first().getAttribute("Finbaladvrec").toString());
            double balMatAdvRecAmt =
                getBalAppVO.first().getAttribute("Finbalmatadvrec") == null ?
                0 :
                Double.parseDouble(getBalAppVO.first().getAttribute("Finbalmatadvrec").toString());
            double balRetRecAmt =
                getBalAppVO.first().getAttribute("Finbalretrec") == null ? 0 :
                Double.parseDouble(getBalAppVO.first().getAttribute("Finbalretrec").toString());
            double balTotalAmt =
                getBalAppVO.first().getAttribute("Finbalamount") == null ? 0 :
                Double.parseDouble(getBalAppVO.first().getAttribute("Finbalamount").toString());
                System.err.println("balAdvRecAmt==>" + balAdvRecAmt);
                System.err.println("balMatAdvRecAmt==>" + balMatAdvRecAmt);
                System.err.println("balRetRecAmt==>" + balRetRecAmt);
                System.err.println("balTotalAmt==>" + balTotalAmt);
            /****get Recovery Percentage****/
            double advRecPer = 0;
            if (balTotalAmt > 0) {
                advRecPer = ((balAdvRecAmt / balTotalAmt) * 100);
            } else {
                advRecPer = 100;
            }
            System.err.println("advRecPer==>" + advRecPer);
            /******************/
            //            //==Double.NaN ? 0.0 : ((balAdvRecAmt / balTotalAmt) * 100);
            //            if (Double.isNaN(advRecPer)) {
            //                advRecPer = 0.00;
            //                //                 contHdrVo.getCurrentRow().getAttribute("ADV_RECOVERY_PERCENT");
            //                //               advRecPer= contHdrVo.first().getAttribute("AdvRecoveryPercent")==null? 0 : Double.parseDouble(contHdrVo.first().getAttribute("AdvRecoveryPercent").toString());
            //                //                  //System.err.println("ADV_RECOVERY_PERCENT inside if===>>>"+contHdrVo.getCurrentRow().getAttribute("ADV_RECOVERY_PERCENT"));
            //                //System.err.println("advRecPer inside if===>>>" + advRecPer);
            //            } else {
            //            }
            /*********get matadvRecPer Percentage*********/
            double matadvRecPer = 0.00;
            if (balTotalAmt > 0) {
                matadvRecPer = ((balMatAdvRecAmt / balTotalAmt) * 100);
            } else {
                matadvRecPer = 100;
            }
//            //System.err.println("matadvRecPer==>" + matadvRecPer);
            //            ==Double.NaN ? 0.0 :((balMatAdvRecAmt / balTotalAmt) * 100);
            //            if (Double.isNaN(matadvRecPer)) {
            //                matadvRecPer = 0.00;
            //                //                matadvRecPer=contHdrVo.getCurrentRow().getAttribute("MatOnsiteRecPercent")==null? 0 : Double.parseDouble(contHdrVo.getCurrentRow().getAttribute("MatOnsiteRecPercent").toString());
            //
            //                //System.err.println("matadvRecPer inside if===>>>" +
            //                                   matadvRecPer);
            //            } else {
            //            }
            /*********get retRecPer Percentage*********/
            double retRecPer = 0.00;
            if (balTotalAmt > 0) {
                retRecPer = ((balRetRecAmt / balTotalAmt) * 100);
            } else {
                retRecPer = 0.00;
            }
//            //System.err.println("retRecPer==>" + retRecPer);

            //            //            ==Double.NaN ? 0.0:((balRetRecAmt / balTotalAmt) * 100);
            //            if (Double.isNaN(retRecPer)) {
            //                retRecPer = 0.00;
            //                //                   retRecPer=contHdrVo.getCurrentRow().getAttribute("RetenPercent")==null? 0 : Double.parseDouble(contHdrVo.getCurrentRow().getAttribute("RetenPercent").toString());
            //                //System.err.println("retRecPer inside if===>>>" + retRecPer);
            //
            //            } else {
            //            }
            /***Setting Recovery Percentage***/

            applicationHrdVO.getCurrentRow().setAttribute("Curadvrecper",
                                                          advRecPerFinal);
            applicationHrdVO.getCurrentRow().setAttribute("Curmatadvrecper",
                                                          matadvRecPer);
            applicationHrdVO.getCurrentRow().setAttribute("Curretper",
                                                          retRecPer);
            // Inserting  Application Line
            // Filtering contract line VO
            ViewCriteria contractLineVC = contractLineVO.createViewCriteria();
            ViewCriteriaRow contractLineVCRow =
                contractLineVC.createViewCriteriaRow();
            contractLineVCRow.setAttribute("ContHeaderId", appContID);
            contractLineVCRow.setAttribute("Version", appVersion);
            contractLineVC.addRow(contractLineVCRow);
            contractLineVO.applyViewCriteria(contractLineVC);
            contractLineVO.executeQuery();
//            //System.err.println("==COUNT==" +
//                               contractLineVO.getEstimatedRowCount());
            // Iteration on contract line
            RowSetIterator contractRs =
                contractLineVO.createRowSetIterator(null);
            while (contractRs.hasNext()) {
                Row contracrLineRow = contractRs.next();
                Object hid = contracrLineRow.getAttribute("ContHeaderId");
                Object lid = contracrLineRow.getAttribute("ContLineId");
                Object version = contracrLineRow.getAttribute("Version");
                Object taxCode = contracrLineRow.getAttribute("TaxCode");
                Object taxRate = contracrLineRow.getAttribute("TaxRate");
                Object taxAmt = contracrLineRow.getAttribute("TaxAmount");
                Object ecpPer = contracrLineRow.getAttribute("EcpPercentage");
                Object ecpAmt = contracrLineRow.getAttribute("EcpTotalAmount");
                // Filtering Application Line---check contract line=0 or not
                Object origAmt =
                    contracrLineRow.getAttribute("OrigAmount");
                double origAmount = origAmt == null ? 0 : Double.parseDouble(origAmt.toString());
                //Double origAmount = Double.parseDouble(origAmt.toString());
                System.out.println("origAmt: "+origAmt);
                Object origQty =
                    contracrLineRow.getAttribute("OrigQuantity");
                System.out.println("origQty: "+origQty);
                double origQuantity = origQty == null ? 0 : Double.parseDouble(origQty.toString());
                //Double origQuantity = Double.parseDouble(origQty.toString());
                ViewCriteria appVO = applicationLineVO2.createViewCriteria();
                ViewCriteriaRow appVCR = appVO.createViewCriteriaRow();
                appVCR.setAttribute("ContLineId", lid);
                appVO.addRow(appVCR);
                applicationLineVO2.applyViewCriteria(appVO);
                applicationLineVO2.executeQuery();
//                //System.err.println("Total applicationLine Count--" +
//                                   applicationLineVO2.getEstimatedRowCount());
                long TotalRowAppCount =
                    applicationLineVO2.getEstimatedRowCount();
                //Equal to 0
                if (applicationLineVO2.getEstimatedRowCount() == 0) {
                    //Application line Row adding
                    Row appLineRow = applicationLineVO.createRow();
                    appLineRow.setAttribute("ContHeaderId", hid);
                    appLineRow.setAttribute("ContLineId", lid);
                    appLineRow.setAttribute("Version", version);
                    appLineRow.setAttribute("ApplHeaderId",
                                            applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId"));
                    appLineRow.setAttribute("OrgId",
                                            applicationHrdVO.getCurrentRow().getAttribute("OrgId"));
                    appLineRow.setAttribute("TaxCode", taxCode);
                    appLineRow.setAttribute("TaxRate", taxRate);
                    appLineRow.setAttribute("EcpPercentage", ecpPer);
                    appLineRow.setAttribute("EcpTotalAmount", ecpAmt);
                    applicationLineVO.insertRow(appLineRow);

                } else {
                    double totalPer = 0;
                    double totalQty = 0;
                    double totalAmt = 0;
                    previousCalculationVO.setNamedWhereClauseParam("BV_CONT_HRDID",
                                                                   hid);
                    previousCalculationVO.setNamedWhereClauseParam("BV_VER",
                                                                   version);
                    previousCalculationVO.setNamedWhereClauseParam("BV_CONT_LNEID",
                                                                   lid);
                    previousCalculationVO.setNamedWhereClauseParam("APP_HRDID",
                                                                   applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId"));
                    previousCalculationVO.executeQuery();
                    //                        previousCalculationVO.getEstimatedRowCount();
//                    //System.err.println("Pre Qty, % Amt===COUNT==" +
//                                       previousCalculationVO.getEstimatedRowCount());
                    if (previousCalculationVO.getEstimatedRowCount() == 0) {
                        totalPer = 0;
                        totalQty = 0;
                        totalAmt = 0;
                    } else {
                        totalQty =
                                previousCalculationVO.first().getAttribute("ApplPrevQty") ==
                                null ? 0 :
                                Double.parseDouble(previousCalculationVO.first().getAttribute("ApplPrevQty").toString());
                        totalPer =
                                previousCalculationVO.first().getAttribute("ApplPrevPerc") ==
                                null ? 0 :
                                Double.parseDouble(previousCalculationVO.first().getAttribute("ApplPrevPerc").toString());
                        totalAmt =
                                previousCalculationVO.first().getAttribute("ApplPrevAmount") ==
                                null ? 0 :
                                Double.parseDouble(previousCalculationVO.first().getAttribute("ApplPrevAmount").toString());
                        //System.out.println("totalQty---" + totalQty +
//                                           "totalPer-----" + totalPer +
//                                           "totalAmt---" + totalAmt);
                        if(totalPer != 0 && origAmount != 0){
                                totalPer = (totalAmt/origAmount)*100;
                                totalQty = (totalAmt/origAmount)*origQuantity;
                            }
                            else if(origAmount == 0){
                                totalQty = 0;
                                totalPer = 0;
                                totalAmt = 0;
                            }  
                    }
                    //Application line Row adding
                    Row appLineRow = applicationLineVO.createRow();
                    appLineRow.setAttribute("ContHeaderId", hid);
                    appLineRow.setAttribute("ContLineId", lid);
                    appLineRow.setAttribute("Version", version);
                    appLineRow.setAttribute("EcpPercentage", ecpPer);
                    appLineRow.setAttribute("EcpTotalAmount", ecpAmt);
                    appLineRow.setAttribute("ApplHeaderId",
                                            applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId"));
                    appLineRow.setAttribute("TaxCode", taxCode);
                    appLineRow.setAttribute("TaxRate", taxRate);
                    //                        appLineRow.setAttribute("TaxAmount", taxAmt);
                    appLineRow.setAttribute("PrevPerc",
                                            new BigDecimal(totalPer).setScale(2, BigDecimal.ROUND_HALF_EVEN));
                    appLineRow.setAttribute("PrevTotQty",
                                            new BigDecimal(totalQty));
                    appLineRow.setAttribute("PrevAmount",
                                            new BigDecimal(totalAmt));
                    appLineRow.setAttribute("OrgId",
                                            applicationHrdVO.getCurrentRow().getAttribute("OrgId"));
                    applicationLineVO.insertRow(appLineRow);
                }
            }
            applicationLineVO.executeQuery();
            //System.err.println("Application Line inserted-final");
//            //System.err.println("final Line Count===>" +
//                               applicationLineVO.getEstimatedRowCount());
            // Setting Cummulative 100
            RowSetIterator rs = applicationLineVO.createRowSetIterator(null);
            while (rs.hasNext()) {
                Row r = rs.next();
                double contractLneRate =
                    r.getAttribute("Trans_Rate") == null ? 0 :
                    Double.parseDouble(r.getAttribute("Trans_Rate").toString());
                double contractLneAmt =
                    r.getAttribute("Trans_Amount") == null ? 0 :
                    Double.parseDouble(r.getAttribute("Trans_Amount").toString());
                double taxRate =
                    r.getAttribute("TaxRate") == null ? 0 : Double.parseDouble(r.getAttribute("TaxRate").toString());
                double cummulativePer = 100;
                double cumPer =
                    r.getAttribute("CumPerc") == null ? 0 : Double.parseDouble(r.getAttribute("CumPerc").toString());
                if (cumPer != 100) {
                    // Set Per
                    r.setAttribute("CumPerc", 100);
                    // set Amount
                    double cummulativeAmt =
                        (cummulativePer * contractLneAmt) / 100;
                    r.setAttribute("CumAmount",
                                   new BigDecimal(cummulativeAmt));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(cumuAmt);

                    // set Qty
                    double cummulativeQty = cummulativeAmt / contractLneRate;
                    if (Double.isNaN(cummulativeQty)) {
                        cummulativeQty = 0.00;
                    } else {
                    }
                    r.setAttribute("CumTotQty",
                                   new BigDecimal(cummulativeQty));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(cumuQty);

                    // setting Current
                    double previousQty =
                        r.getAttribute("PrevTotQty") == null ? 0 :
                        Double.parseDouble(r.getAttribute("PrevTotQty").toString());
                    double previousPer =
                        r.getAttribute("PrevPerc") == null ? 0 :
                        Double.parseDouble(r.getAttribute("PrevPerc").toString());
                    double previousAmt =
                        r.getAttribute("PrevAmount") == null ? 0 :
                        Double.parseDouble(r.getAttribute("PrevAmount").toString());

                    double currentQty = cummulativeQty - previousQty;
                    double currentPre = cummulativePer - previousPer;
                    double currentAmt = cummulativeAmt - previousAmt;
                    r.setAttribute("CurrTotQty", new BigDecimal(currentQty));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
                    r.setAttribute("CurrPerc", new BigDecimal(currentPre));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(currPer);
                    r.setAttribute("CurrAmount", new BigDecimal(currentAmt));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(currAmt);

                    // Set Tax Amount
                    if (taxRate == 0) {
                        r.setAttribute("TaxAmount", new BigDecimal(0));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                    } else {
                        double taxAmt = (currentAmt * taxRate) / 100;
                        r.setAttribute("TaxAmount", new BigDecimal(taxAmt));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                    }
                }
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
            paymentType.setDisabled(Boolean.TRUE);
            AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);
            onClickCalculateAmount();
            revRetRecoveryCalc();
            this.getP2().hide();
        } else {
            JSFUtils.addFacesErrorMessage("Payment Type: Final can't be created for this Contract. Please create a Payment Type: Interim");
        }
        System.out.println("onClickFinal: End");
    }

    public void revRetRecoveryCalc(){
            System.out.println("inside revRetRecoveryCalc");
            double TotalAdvAmount =
                applicationHrdVO.getCurrentRow().getAttribute("TotalAdvAmount") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("TotalAdvAmount").toString());
            double PrevAdvRec =
                applicationHrdVO.getCurrentRow().getAttribute("PrevAdvRec") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("PrevAdvRec").toString());
            System.out.println("PrevAdvRec: "+PrevAdvRec);
            double TotalRet =
                applicationHrdVO.getCurrentRow().getAttribute("TotalRet") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("TotalRet").toString());
            double PrevRet =
                applicationHrdVO.getCurrentRow().getAttribute("PrevRet") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("PrevRet").toString());
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId");
            String contHid = applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
            System.out.println("ContHeaderId: "+applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId"));
            ViewCriteria advancRecVC = AdvancRecVO2.createViewCriteria();
            ViewCriteriaRow advancRecRow = advancRecVC.createViewCriteriaRow();
            advancRecRow.setAttribute("ContHdrId", contHid);
            advancRecVC.addRow(advancRecRow);
            AdvancRecVO2.applyViewCriteria(advancRecVC);
            AdvancRecVO2.executeQuery();
            if(AdvancRecVO2.getEstimatedRowCount() > 1){
                System.out.println("AdvancRecVO2.last().getAttribute(\"BalanceAmt\").toString(): "+AdvancRecVO2.last().getAttribute("BalanceAmt").toString());
                double totalAdvRec =
                    AdvancRecVO2.last().getAttribute("AdvanceAmt") ==
                    null ? 0 :
                    Double.parseDouble(AdvancRecVO2.first().getAttribute("AdvanceAmt").toString());
                double curAdvRec =
                    AdvancRecVO2.first().getAttribute("BalanceAmt") ==
                    null ? 0 :
                    Double.parseDouble(AdvancRecVO2.first().getAttribute("BalanceAmt").toString());
                //BalanceRet
                System.out.println("totalAdvRec: "+totalAdvRec+" :curAdvRec: "+curAdvRec+" :PrevAdvRec: "+PrevAdvRec);
                double curRet = TotalRet - PrevRet;
                applicationHrdVO.getCurrentRow().setAttribute("CurAdvRec", new BigDecimal(AdvancRecVO2.first().getAttribute("BalanceAmt").toString()));    
                applicationHrdVO.getCurrentRow().setAttribute("TotalAdvAmount", new BigDecimal(AdvancRecVO2.last().getAttribute("AdvanceAmt").toString()));
                applicationHrdVO.getCurrentRow().setAttribute("CurRet", new BigDecimal((TotalRet-PrevRet)));
                applicationHrdVO.getCurrentRow().setAttribute("BalanceAdvRec", new BigDecimal(totalAdvRec-(curAdvRec+PrevAdvRec)));
                applicationHrdVO.getCurrentRow().setAttribute("BalanceRet", new BigDecimal((TotalRet-PrevRet-curRet)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(CurRet);
                CurAdvRec.setValue(new BigDecimal(AdvancRecVO2.first().getAttribute("BalanceAmt").toString()));
            }
        }
    
    public void setTotalAdvRecAmt(){
        String contHid = applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
        ViewCriteria advancRecVC = AdvancRecVO2.createViewCriteria();
        ViewCriteriaRow advancRecRow = advancRecVC.createViewCriteriaRow();
        advancRecRow.setAttribute("ContHdrId", contHid);
        advancRecVC.addRow(advancRecRow);
        AdvancRecVO2.applyViewCriteria(advancRecVC);
        AdvancRecVO2.executeQuery();
        if(AdvancRecVO2.getEstimatedRowCount() != 0){
            if(paymentType.getValue().toString().equals("Final")){
                System.out.println("inside Final method");
                applicationHrdVO.getCurrentRow().setAttribute("CurAdvRec", new BigDecimal(AdvancRecVO2.first().getAttribute("BalanceAmt").toString()));    
                AdfFacesContext.getCurrentInstance().addPartialTarget(CurAdvRec);
                CurAdvRec.setValue(new BigDecimal(AdvancRecVO2.first().getAttribute("BalanceAmt").toString()));
            }
            applicationHrdVO.getCurrentRow().setAttribute("TotalAdvAmount", AdvancRecVO2.last().getAttribute("AdvanceAmt"));
        }
    }

    public void setPrevOthCharge(RichOutputText prevOthCharge) {
        this.prevOthCharge = prevOthCharge;
    }

    public RichOutputText getPrevOthCharge() {
        return prevOthCharge;
    }

    public void setTotOthCharge(RichOutputText totOthCharge) {
        this.totOthCharge = totOthCharge;
    }

    public RichOutputText getTotOthCharge() {
        return totOthCharge;
    }


    public void setCurOthCharge(RichOutputText curOthCharge) {
        this.curOthCharge = curOthCharge;
    }

    public RichOutputText getCurOthCharge() {
        return curOthCharge;
    }

    public void onChangeAppDate(ValueChangeEvent valueChangeEvent) {
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            if (valueChangeEvent.getNewValue() != null) {
                String paymentTerm =
                    applicationHrdVO.getCurrentRow().getAttribute("PaymentTerm") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("PaymentTerm").toString();
                String contactPayTerm =
                    applicationHrdVO.getCurrentRow().getAttribute("ContactPayTerm") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("ContactPayTerm").toString();
                String num = contactPayTerm.replaceAll("[^0-9]", "");
                String num1 = paymentTerm.replaceAll("[^0-9]", "");
                int number = Integer.parseInt(num);
                int number1 = Integer.parseInt(num1);
                int days = number + number1;
//                //System.err.println("number of Days: " + number);
                String n = Integer.toString(number);
                oracle.jbo.domain.Date str_date =
                    (oracle.jbo.domain.Date)valueChangeEvent.getNewValue();
                oracle.jbo.domain.Date paymentDate =
                    ADFDateUtils.addDayToOracleDate(str_date, days);
//                //System.err.println("paymentDate-->" + paymentDate);
                applicationHrdVO.getCurrentRow().setAttribute("PaymentDueDate",
                                                              paymentDate);
                AdfFacesContext.getCurrentInstance().addPartialTarget(paymentDueDate);
            }
        }
    }

    public void calculateretrel() {
        double curretper =
            applicationHrdVO.getCurrentRow().getAttribute("CurRetRelPer") ==
            null ? 0 :
            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurRetRelPer").toString());
        double totret =
            applicationHrdVO.getCurrentRow().getAttribute("totRet_TRNS") ==
            null ? 0 :
            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("totRet_TRNS").toString());
        double prevret =
            applicationHrdVO.getCurrentRow().getAttribute("PerRetRel") ==
            null ? 0 :
            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("PerRetRel").toString());
        double retamount = 0;
        double diff = 0;
//        //System.err.println("amount ==> " + curretper + " " + totret);
        retamount = (curretper * totret) / 100;
//        //System.err.println("ret amount ==> " + retamount);
//        //System.err.println("Preve ret ==>" + prevret + " " +
//                           (prevret + retamount));
        diff = totret - (prevret + retamount);
//        //System.err.println("difference ==> " + diff);
        if (diff < 0) {
            JSFUtils.addFacesInformationMessage("Please check the percentage");
        } else {
            applicationHrdVO.getCurrentRow().setAttribute("CurRetRel",
                                                          retamount);
        }
    }

    public void onChangeChargeType(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
//        //System.err.println("New update-->" + valueChangeEvent.getNewValue());
        if (valueChangeEvent.getNewValue().toString() != "0") {
            ViewObject otherChargVO =
                ADFUtils.findIterator("XxscPayApplOthChargesVO1Iterator").getViewObject();
            //System.err.println("/*/--" +
//                               otherChargVO.getCurrentRow().getAttribute("ChargeType").toString());
            int result =
                checkType(otherChargVO.getCurrentRow().getAttribute("ChargeType").toString());
            //System.err.println("--===>" + result);
            if (result > 1) {
                JSFUtils.addFacesErrorMessage("Charge Type is already exits");
                otherChargVO.getCurrentRow().setAttribute("ChargeType", null);
                AdfFacesContext.getCurrentInstance().addPartialTarget(t7);
            }
        }
    }


    public int checkType(String Type) {
        String s2 = Type.toString();
        int count = 0;
        try {
            ViewObject otherChargVO =
                ADFUtils.findIterator("XxscPayApplOthChargesVO1Iterator").getViewObject();
            otherChargVO.executeQuery();
            if (otherChargVO.getEstimatedRowCount() > 1) {
                RowSetIterator rs = otherChargVO.createRowSetIterator(null);
                while (rs.hasNext()) {
                    Row r = rs.next();
                    //System.err.println(Type + "==COMP==" +
//                                       r.getAttribute("ChargeType").toString());
                    if (r.getAttribute("ChargeType") != null) {
                        //    //System.err.println("--charge type"+r.getAttribute("ChargeType").toString());
                        if (r.getAttribute("ChargeType").toString().equalsIgnoreCase(s2)) {
                            //  isDuplicate="Y";
                            count++;
                        }
                    }
                }
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public void setT7(RichTable t7) {
        this.t7 = t7;
    }

    public RichTable getT7() {
        return t7;
    }

    public void onClickAddAdvRec(ActionEvent actionEvent) {
      //System.err.print("Inside onClickAddAdvRec Buyside" );
    
    String ContHdrId =
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();

        double contAdvRec =
            applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Rec_Per") ==
            null ? 0 :
            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Rec_Per").toString());
        ExtraAdvVO.setNamedWhereClauseParam("bv_hdr_id", ContHdrId);
        ExtraAdvVO.executeQuery();
        //System.err.println("Extra ADv==>" + ExtraAdvVO.getEstimatedRowCount());
        RowSetIterator rs = ExtraAdvVO.createRowSetIterator(null);
        while (rs.hasNext()) {
            Row r = rs.next();
            Row r1 = AdvancRecVO.createRow();
            //r1.setAttribute("ApplAdvId", r.getAttribute("ApplAdvId"));
            double curAdv =
                r.getAttribute("Amt") == null ? 0 : Double.parseDouble(r.getAttribute("Amt").toString());
            double prevamt =
                r.getAttribute("PrevAmt") == null ? 0 : Double.parseDouble(r.getAttribute("PrevAmt").toString());
            double curr = ((contAdvRec * curAdv) / 100);
            double balance =
                curAdv - ((((contAdvRec * curAdv) / 100) + prevamt));
//            double balance =
//                curAdv - ( curAdv + prevamt);
            r1.setAttribute("AdvanceName", r.getAttribute("Name"));
            System.out.println("here curRec amount 4:");
            r1.setAttribute("CurRecAmt", curr);
            r1.setAttribute("AdvanceAmt", r.getAttribute("Amt"));
            r1.setAttribute("RecoveredAmt", r.getAttribute("PrevAmt"));
            r1.setAttribute("BalanceAmt", balance);
            AdvancRecVO.insertRow(r1);
            //System.err.println("contAdvRec - - >  " + contAdvRec +
//                               "curAdv - - > " + curAdv + " balance - - > " +
//                               balance + " ttt - - > " + curr);
        }

    }

    public void setBal_Adv_AMT(RichInputText bal_Adv_AMT) {
        this.bal_Adv_AMT = bal_Adv_AMT;
    }

    public RichInputText getBal_Adv_AMT() {
        return bal_Adv_AMT;
    }

    public void onClickBalCal(ValueChangeEvent valueChangeEvent) {
        System.out.println("Begin - onClickBalCal: ");
        double amount =
            valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
        double totamt =
            AdvancRecVO.getCurrentRow().getAttribute("AdvanceAmt") == null ?
            0 : Double.parseDouble(AdvancRecVO.getCurrentRow().getAttribute("AdvanceAmt").toString());
        double prevamt =
            AdvancRecVO.getCurrentRow().getAttribute("RecoveredAmt") == null ?
            0 : Double.parseDouble(AdvancRecVO.getCurrentRow().getAttribute("RecoveredAmt").toString());
        double bal = 0;
        System.out.println("amount: "+amount);
        System.out.println("totamt: "+totamt);
        System.out.println("prevamt: "+prevamt);
        bal = totamt - (prevamt + amount);
        System.out.println("bal: "+bal);
        if(bal < 0){
            JSFUtils.addFacesInformationMessage("Entered amount exceeds the balance amount.Please check.");
            curRecvryAmt.resetValue();
            curRecvryAmt.setValue("");
            curRecvryAmt.setValue(null);
        }
        else{
            AdvancRecVO.getCurrentRow().setAttribute("BalanceAmt", bal);
        }
    }

    public void setCb9(RichCommandButton cb9) {
        this.cb9 = cb9;
    }

    public RichCommandButton getCb9() {
        return cb9;
    }

    public void setApplPayTerm(RichSelectOneChoice applPayTerm) {
        this.applPayTerm = applPayTerm;
    }

    public RichSelectOneChoice getApplPayTerm() {
        return applPayTerm;
    }

    public void setTotCummAmt(RichOutputText totCummAmt) {
        this.totCummAmt = totCummAmt;
    }

    public RichOutputText getTotCummAmt() {
        return totCummAmt;
    }

    public void onClickDraft(ActionEvent actionEvent) {
        applicationHrdVO.getCurrentRow().setAttribute("ApprovalStatus", "TRNS_DRAFT");
        applicationHrdVO.getCurrentRow().setAttribute("AppStatus", "N");
        ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesErrorMessage("Certification is rejected ,application changed to draft");
    }

    public void setCurRecvryAmt(RichInputText curRecvryAmt) {
        this.curRecvryAmt = curRecvryAmt;
    }

    public RichInputText getCurRecvryAmt() {
        return curRecvryAmt;
    }

    public void onClickReports(FacesContext facesContext,
                               OutputStream outputStream) throws IOException {
        try {
            Number appl =
                (Number)applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId");
            //System.err.println("appl===>" + appl);
            Object result = null;
            if (applicationHrdVO.getCurrentRow().getAttribute("PaymentType").toString().equalsIgnoreCase("Interim") ||
                applicationHrdVO.getCurrentRow().getAttribute("PaymentType").toString().equalsIgnoreCase("Final")) {
                if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                    result =
                            RTFUtils.runReport("//reports//Payment_Application_Task_Interim_Buy.rtf",
                                               appl, "Payment_application");
                }
            } else if (applicationHrdVO.getCurrentRow().getAttribute("PaymentType").toString().equalsIgnoreCase("Material Advance") ||
                       applicationHrdVO.getCurrentRow().getAttribute("PaymentType").toString().equalsIgnoreCase("Advance")) {
                if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                    result = RTFUtils.runReport("//reports//Payment_Application_Task_Advance_Buy.rtf",
                                               appl, "Payment_application");
                }
            }
            outputStream.write((byte[])result);
        } catch (IOException e) {
            }
    }


    public void setInpCurOthCharge(RichInputText inpCurOthCharge) {
        this.inpCurOthCharge = inpCurOthCharge;
    }

    public RichInputText getInpCurOthCharge() {
        return inpCurOthCharge;
    }

    public void setInprevOthCharg(RichInputText inprevOthCharg) {
        this.inprevOthCharg = inprevOthCharg;
    }

    public RichInputText getInprevOthCharg() {
        return inprevOthCharg;
    }

    public void setInTotOthCharg(RichInputText inTotOthCharg) {
        this.inTotOthCharg = inTotOthCharg;
    }

    public RichInputText getInTotOthCharg() {
        return inTotOthCharg;
    }

    public void setChargeType(RichSelectOneChoice chargeType) {
        this.chargeType = chargeType;
    }

    public RichSelectOneChoice getChargeType() {
        return chargeType;
    }
    /**
     * AdvanceRecoveryCalculation method not using
     */
    public void advanceRecovery(){
        String ContHdrId = applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
            null ? "0" : applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
        double contAdvRec = applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Rec_Per") ==
            null ? 0 : Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Rec_Per").toString());
        ExtraAdvVO.setNamedWhereClauseParam("bv_hdr_id", ContHdrId);
        ExtraAdvVO.executeQuery();
        RowSetIterator rs = ExtraAdvVO.createRowSetIterator(null);
        while (rs.hasNext()) {
            Row r = rs.next();
            String name = (String)r.getAttribute("Name");
            RowSetIterator ar = AdvancRecVO.createRowSetIterator(null);
            String aName = null;
            if (AdvancRecVO.first() != null) {
                while (ar.hasNext()) {
                    Row aRow = ar.next();
                    aName = (String)aRow.getAttribute("AdvanceName");
                    if (aName.equalsIgnoreCase(name)) {
                        double curAdv = applicationHrdVO.getCurrentRow().getAttribute("CurApplication") == null ? 0 :
                            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurApplication").toString());
                        /**
                         *AdvanceRecovery based on enter value calculation
                         */
                        double curAdv1 = AdvancRecVO.getCurrentRow().getAttribute("CurRecAmt") == null ? 0 :
                            Double.parseDouble(AdvancRecVO.getCurrentRow().getAttribute("CurRecAmt").toString());
                        //System.err.println("curAdv1----->" + curAdv1);
                        double prevamt = r.getAttribute("PrevAmt") == null ? 0 :
                            Double.parseDouble(r.getAttribute("PrevAmt").toString());
                        // double curr = ((contAdvRec * curAdv) / 100);
                        double curr = curAdv1;
                        double totalAdvToRec = r.getAttribute("Amt") == null ? 0 :
                            Double.parseDouble(r.getAttribute("Amt").toString());
                        double balance = totalAdvToRec - ( curAdv1 + prevamt);
                        aRow.setAttribute("AdvanceName", r.getAttribute("Name"));
                        System.out.println("here curRec amount 5:");
                        aRow.setAttribute("CurRecAmt", curr);
                        aRow.setAttribute("AdvanceAmt", r.getAttribute("Amt"));
                        aRow.setAttribute("RecoveredAmt", r.getAttribute("PrevAmt"));
                        aRow.setAttribute("BalanceAmt", balance);
                    } else {
                        //System.err.println("inside first else");
                        Row r1 = AdvancRecVO.createRow();
                        //r1.setAttribute("ApplAdvId", r.getAttribute("ApplAdvId"));
                        double curAdv =
                            applicationHrdVO.getCurrentRow().getAttribute("CurApplication") ==
                            null ? 0 :
                            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurApplication").toString());
                        double prevamt =
                            r.getAttribute("PrevAmt") == null ? 0 :
                            Double.parseDouble(r.getAttribute("PrevAmt").toString());
                        double curr = ((contAdvRec * curAdv) / 100);
                        double totalAdvToRec =
                            r.getAttribute("Amt") == null ? 0 :
                            Double.parseDouble(r.getAttribute("Amt").toString());
                        double balance =
                            totalAdvToRec - ((((contAdvRec * curAdv) / 100) +
                                              prevamt));
                        r1.setAttribute("AdvanceName", r.getAttribute("Name"));
                        System.out.println("here curRec amount 6:");
                        r1.setAttribute("CurRecAmt", curr);
                        r1.setAttribute("AdvanceAmt", r.getAttribute("Amt"));
                        r1.setAttribute("RecoveredAmt", r.getAttribute("PrevAmt"));
                        r1.setAttribute("BalanceAmt", balance);
                        AdvancRecVO.insertRow(r1);
                    }
                }
            } else {
                //System.err.println("inside second else");
                Row r1 = AdvancRecVO.createRow();
                //r1.setAttribute("ApplAdvId", r.getAttribute("ApplAdvId"));
                double curAdv =
                    applicationHrdVO.getCurrentRow().getAttribute("CurApplication") ==
                    null ? 0 :
                    Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurApplication").toString());
                double prevamt =
                    r.getAttribute("PrevAmt") == null ? 0 : Double.parseDouble(r.getAttribute("PrevAmt").toString());
                double curr = ((contAdvRec * curAdv) / 100);
                double totalAdvToRec =
                    r.getAttribute("Amt") == null ? 0 : Double.parseDouble(r.getAttribute("Amt").toString());
                double balance = totalAdvToRec - ((((contAdvRec * curAdv) / 100) + prevamt));
                r1.setAttribute("AdvanceName", r.getAttribute("Name"));
                System.out.println("here curRec amount 7:");
                r1.setAttribute("CurRecAmt", curr);
                r1.setAttribute("AdvanceAmt", r.getAttribute("Amt"));
                r1.setAttribute("RecoveredAmt", r.getAttribute("PrevAmt"));
                r1.setAttribute("BalanceAmt", balance);
                AdvancRecVO.insertRow(r1);
            }
        }
    }
    
    public void Totaladvancecalcu()
    {
            RowSetIterator rs = AdvanceVO.createRowSet(null);
            double sum = 0;
            while (rs.hasNext()) {
                Row r = rs.next();
                sum +=
            Double.parseDouble(r.getAttribute("AdvanceAmt").toString());
            }
            String Hid =
                applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
            String ver =
                applicationHrdVO.getCurrentRow().getAttribute("Version") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("Version").toString();
            String apphdrid =
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();

            ViewObject vo =
                ADFUtils.findIterator("AdvPrevAmt_ROVO1Iterator").getViewObject();
            vo.setNamedWhereClauseParam("BV_cont_ID", Hid);
            vo.setNamedWhereClauseParam("BV_app_id", apphdrid);
            vo.setNamedWhereClauseParam("Bv_ver", ver);
            vo.executeQuery();
            //System.err.println("row count==>" + vo.getEstimatedRowCount());
            double prevamt =
                vo.first().getAttribute("Amount") == null ? 0 : Double.parseDouble(vo.first().getAttribute("Amount").toString());

            applicationHrdVO.getCurrentRow().setAttribute("CurApplication",
                                                          new BigDecimal(sum));
            AdfFacesContext.getCurrentInstance().addPartialTarget(CurApplication);
            applicationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                          new BigDecimal(sum));
            AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);
            applicationHrdVO.getCurrentRow().setAttribute("PrevApplication",
                                                          new BigDecimal(prevamt));
            AdfFacesContext.getCurrentInstance().addPartialTarget(prevAppl);
        }

    public void onClickDelete(ActionEvent actionEvent) {
        RichPopup.PopupHints hints=new RichPopup.PopupHints();
            this.getP5().show(hints);
    }

    public void onClickOkDialogue(DialogEvent dialogEvent) {
        if(dialogEvent.getOutcome()==DialogEvent.Outcome.ok){
            String ipaddress="";
            try {
                InetAddress IP=InetAddress.getLocalHost();
                ipaddress=IP.toString();
            } catch (UnknownHostException e) {
                }
            Row r=applicationHrdVO.getCurrentRow();
            String certid=r.getAttribute("ApplHeaderId").toString();
            OperationBinding op = (OperationBinding)ADFUtils.findOperation("deletedbcall");
            op.getParamsMap().put("p_cid",certid);
            op.getParamsMap().put("p_type","APPLICATION LINE");
            op.getParamsMap().put("P_username",ADFContext.getCurrent().getSessionScope().get("userName").toString());
            op.getParamsMap().put("p_ip",ipaddress);
            Object result =op.execute();
            applicationLineVO.executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
            JSFUtils.addFacesInformationMessage(result.toString()); 
        }
    }

    public void setP5(RichPopup p5) {
        this.p5 = p5;
    }

    public RichPopup getP5() {
        return p5;
    }
}