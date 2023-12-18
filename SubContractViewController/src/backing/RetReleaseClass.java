package backing;

import Utils.ADFUtils;

import Utils.JSFUtils;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

public class RetReleaseClass {
    private RichTable t2;
    private RichPopup p1;
    private RichPopup p2;
    private RichTable t4;
    private RichInputText it1;

    public RetReleaseClass() {
    }

    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }

    ViewObject cetInvoiceVO =
        ADFUtils.findIterator("certInvoiceROVO1Iterator").getViewObject();
    ViewObject retRelHrdVO =
        ADFUtils.findIterator("XxscRetReleaseHeadersVO2_1Iterator").getViewObject();
    ViewObject retRelLineVO =
        ADFUtils.findIterator("XxscRetReleaseLinesVO1Iterator").getViewObject();
    ViewObject contractLineVO =
        ADFUtils.findIterator("contractLineROVO1Iterator").getViewObject();
    ViewObject retrel =
        ADFUtils.findIterator("XxscCertInvoices_VO1Iterator").getViewObject();

    public void onChangeContractNum(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
//        System.err.println("OLD==" + valueChangeEvent.getOldValue());
//        System.err.println("NEW==" + valueChangeEvent.getNewValue());
        if (valueChangeEvent.getOldValue() != null) {
            // Delete old value
            RowSetIterator retLineRS = retRelLineVO.createRowSetIterator(null);
            while (retLineRS.hasNext()) {
                Row lineRow = retLineRS.next();
                lineRow.remove();
            }
            String contractNumber = valueChangeEvent.getNewValue().toString();
            cetInvoiceVO.setNamedWhereClauseParam("BV_CONT_NUM",
                                                  contractNumber);
            cetInvoiceVO.executeQuery();
            RichPopup.PopupHints hint = new RichPopup.PopupHints();
            this.p2.show(hint);
            AdfFacesContext.getCurrentInstance().addPartialTarget(t4);

        } else {
            String contractNumber = valueChangeEvent.getNewValue().toString();
            cetInvoiceVO.setNamedWhereClauseParam("BV_CONT_NUM",
                                                  contractNumber);
            cetInvoiceVO.executeQuery();
            RichPopup.PopupHints hint = new RichPopup.PopupHints();
            this.p2.show(hint);
            AdfFacesContext.getCurrentInstance().addPartialTarget(t4);
        }


        /*
       if(valueChangeEvent.getOldValue()!=null){

      }else{

          String contractNumber=valueChangeEvent.getNewValue().toString();
          cetInvoiceVO.setNamedWhereClauseParam("BV_CONT_NUM", contractNumber);
          cetInvoiceVO.executeQuery();
          System.err.println("==CERT COUNT=="+cetInvoiceVO.getEstimatedRowCount());
          RowSetIterator certRS=cetInvoiceVO.createRowSetIterator(null);
          while(certRS.hasNext()){
                  Row certROW=certRS.next();
                  Object certInvoiceId=certROW.getAttribute("CertInvoiceId")==null?0:certROW.getAttribute("CertInvoiceId").toString();
                  Object invoiceNum=certROW.getAttribute("InvoiceNum")==null?0:certROW.getAttribute("InvoiceNum").toString();
                  Object orgId=certROW.getAttribute("OrgId")==null?0:certROW.getAttribute("OrgId").toString();
                  Object invoiceAmount=certROW.getAttribute("InvoiceAmount")==null?0:certROW.getAttribute("InvoiceAmount").toString();
                  Object releasedAmount=certROW.getAttribute("ReleasedAmount")==null?0:certROW.getAttribute("ReleasedAmount").toString();
                  Object balamount=certROW.getAttribute("Balamount")==null?0:certROW.getAttribute("Balamount").toString();
                  Object contractNum=certROW.getAttribute("ContractNum")==null?0:certROW.getAttribute("ContractNum").toString();
//                  Object certHeaderId=certROW.getAttribute("CertHeaderId")==null?0:certROW.getAttribute("CertHeaderId").toString();
//                  Object invoiceDate=certROW.getAttribute("InvoiceDate")==null?0:certROW.getAttribute("InvoiceDate").toString();
//                  Object invoiceFlag=certROW.getAttribute("InvoiceFlag")==null?0:certROW.getAttribute("InvoiceFlag").toString();
//                  Object flag=certROW.getAttribute("Flag")==null?0:certROW.getAttribute("Flag").toString();

                  System.err.println("certInvoiceId=="+certInvoiceId+"======invoiceNum=="+invoiceNum+"=====invoiceAmount=="+invoiceAmount+"=====releasedAmount=="+releasedAmount+"=====orgId=="+orgId+"=====balamount=="+balamount);
                  Row retRelRow =retRelLineVO.createRow();
                    retRelRow.setAttribute("RetRelHeaderId", retRelHrdVO.getCurrentRow().getAttribute("RetRelHeaderId"));
                    retRelRow.setAttribute("CertInvoiceId", certInvoiceId);
                    retRelRow.setAttribute("InvoiceNum", invoiceNum);
                    retRelRow.setAttribute("OrgId", orgId);
                    retRelRow.setAttribute("invoice_amountTrans", invoiceAmount);
                    retRelRow.setAttribute("released_amount_Trans", releasedAmount);
                    retRelRow.setAttribute("balance_amount_Trans", balamount);
                    retRelRow.setAttribute("ContractNumTrans", contractNum);
                   retRelLineVO.insertRow(retRelRow);
          }
          retRelLineVO.executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(t2);

      }
*/
    }


    public void onClickCancel(ActionEvent actionEvent) {
        this.getP1().cancel();
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void onClickSave(ActionEvent actionEvent) {
        if (ADFContext.getCurrent().getSessionScope().get("button") != null &&
            ADFContext.getCurrent().getSessionScope().get("button").toString().equals("edit")) {
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Retention Release Information Saved Successfully");
        } else {
            retRelHrdVO.getCurrentRow().setAttribute("RetRelNumber",
                                                     "Ret-" + retRelHrdVO.getCurrentRow().getAttribute("RetRelHeaderId"));
            retRelHrdVO.executeQuery();
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.numberFaceMessage("Retention Release",
                                       retRelHrdVO.getCurrentRow().getAttribute("RetRelNumber"));
        }
    }

    public void onClickSubmit(ActionEvent actionEvent) {
        if (ADFContext.getCurrent().getSessionScope().get("page").toString().equals("retentionBuy")) {
            retRelHrdVO.getCurrentRow().setAttribute("ApprovalStatus", "APR");
            retRelHrdVO.getCurrentRow().setAttribute("InvRetStatus", "APR");
            retRelHrdVO.executeQuery();
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Retention Release Information Saved and Approved Successfully");
        } else if (ADFContext.getCurrent().getSessionScope().get("page").toString().equals("retentionSell")) {
            //            Row r = retrel.createRow();
            //            r.setAttribute("kajsd", "kjasdf");
            //            r.setAttribute("kajsd", "kjasdf");
            //            r.setAttribute("kajsd", "kjasdf");
            //            r.setAttribute("kajsd", "kjasdf");
            //            r.setAttribute("kajsd", "kjasdf");
            //            retrel.insertRow(r);
            retRelHrdVO.getCurrentRow().setAttribute("ApprovalStatus", "APR");
            retRelHrdVO.getCurrentRow().setAttribute("InvRetStatus",
                                                     "READY_TO_PRO_BILL");
            ADFUtils.findOperation("Commit").execute();
            retRelHrdVO.executeQuery();
            JSFUtils.addFacesInformationMessage("Retention Release Information Saved and Approved Successfully");
        }

    }

    public void setP2(RichPopup p2) {
        this.p2 = p2;
    }

    public RichPopup getP2() {
        return p2;
    }

    public void setT4(RichTable t4) {
        this.t4 = t4;
    }

    public RichTable getT4() {
        return t4;
    }

    public void onCancelInvoice(ActionEvent actionEvent) {
        this.p2.cancel();
    }

    public void onSaveInvoice(ActionEvent actionEvent) {
        ViewObject invoiceVO =
            ADFUtils.findIterator("certInvoiceROVO1Iterator").getViewObject();
        double TotalAmt = 0;
        RowSetIterator invoiceRS = invoiceVO.createRowSetIterator(null);
        RowSetIterator retLineRS = retRelLineVO.createRowSetIterator(null);
                       while (retLineRS.hasNext()) {
                           Row lineRow = retLineRS.next();
               
                           lineRow.remove();
                       }
        while (invoiceRS.hasNext()) {
            Row invoiceRow = invoiceRS.next();
            if (invoiceRow.getAttribute("retReleaseTrans") != null) {
                double relAmt =
                    invoiceRow.getAttribute("retReleaseTrans") == null ? 0 :
                    Double.parseDouble(invoiceRow.getAttribute("retReleaseTrans").toString());
                Object certInvoiceId =
                    invoiceRow.getAttribute("CertInvoiceId") == null ? 0 :
                    invoiceRow.getAttribute("CertInvoiceId").toString();
                Object invoiceNum =
                    invoiceRow.getAttribute("InvoiceNum") == null ? 0 :
                    invoiceRow.getAttribute("InvoiceNum").toString();
                Object orgId =
                    invoiceRow.getAttribute("OrgId") == null ? 0 : invoiceRow.getAttribute("OrgId").toString();
                Object invoiceAmount =
                    invoiceRow.getAttribute("InvoiceAmount") == null ? 0 :
                    invoiceRow.getAttribute("InvoiceAmount").toString();
                Object releasedAmount =
                    invoiceRow.getAttribute("ReleasedAmount") == null ? 0 :
                    invoiceRow.getAttribute("ReleasedAmount").toString();
                Object balamount =
                    invoiceRow.getAttribute("Balamount") == null ? 0 :
                    invoiceRow.getAttribute("Balamount").toString();
                Object contractNum =
                    invoiceRow.getAttribute("ContractNum") == null ? 0 :
                    invoiceRow.getAttribute("ContractNum").toString();
//                System.err.println("certInvoiceId==" + certInvoiceId +
//                                   "======invoiceNum==" + invoiceNum +
//                                   "=====invoiceAmount==" + invoiceAmount +
//                                   "=====releasedAmount==" + releasedAmount +
//                                   "=====orgId==" + orgId +
//                                   "=====balamount==" + balamount);
                Row retRelRow = retRelLineVO.createRow();
                retRelRow.setAttribute("RetRelHeaderId",
                                       retRelHrdVO.getCurrentRow().getAttribute("RetRelHeaderId"));
                retRelRow.setAttribute("ContractNumTrans", contractNum);
                retRelRow.setAttribute("CertInvoiceId", certInvoiceId);
                retRelRow.setAttribute("InvoiceNum", invoiceNum);
                retRelRow.setAttribute("OrgId", orgId);
                retRelRow.setAttribute("invoice_amountTrans", invoiceAmount);
                retRelRow.setAttribute("released_amount_Trans",
                                       releasedAmount);
                retRelRow.setAttribute("balance_amount_Trans", balamount);
                retRelRow.setAttribute("RetRelAmt",
                                       invoiceRow.getAttribute("retReleaseTrans"));
                retRelLineVO.insertRow(retRelRow);
                TotalAmt = TotalAmt + relAmt;
            }
        }
        retRelLineVO.executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(t2);
        retRelHrdVO.getCurrentRow().setAttribute("RetRelAmt", TotalAmt);
        AdfFacesContext.getCurrentInstance().addPartialTarget(it1);
        String contId =
            retRelHrdVO.getCurrentRow().getAttribute("ContHeaderId") == null ?
            "0" :
            retRelHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
        contractLineVO.setNamedWhereClauseParam("BV_CONTID", contId);
        contractLineVO.executeQuery();
        Object tax =
            contractLineVO.first().getAttribute("TaxRate") == null ? 0 :
            contractLineVO.first().getAttribute("TaxRate").toString();
        retRelHrdVO.getCurrentRow().setAttribute("Taxrate", tax);
        this.getP2().cancel();
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }


    public void onClickEditRetRel(ActionEvent actionEvent) {
        RowSetIterator retLineRS = retRelLineVO.createRowSetIterator(null);
               String contractNumber = retRelHrdVO.getCurrentRow().getAttribute("ContractNumTrans").toString();
               cetInvoiceVO.setNamedWhereClauseParam("BV_CONT_NUM",
                                                     contractNumber);
               cetInvoiceVO.executeQuery();
               
               while (retLineRS.hasNext()) {
                   Row lineRow = retLineRS.next();
                   if(lineRow.getAttribute("CertInvoiceId")!=null){
                       int INV_ID =  lineRow.getAttribute("CertInvoiceId")== null? 0 : Integer.parseInt(lineRow.getAttribute("CertInvoiceId").toString());
                        String LINE_AMT =  lineRow.getAttribute("RetRelAmt").toString();
//               System.err.println("Line INV_ID"+INV_ID);
//               System.err.println("Line LINE_AMT"+LINE_AMT); 
               
               RowSetIterator certInvoiceRS = cetInvoiceVO.createRowSetIterator(null);
                       while (certInvoiceRS.hasNext()) {
                           Row certLineRow = certInvoiceRS.next(); 
                           int popUpInvID =  certLineRow.getAttribute("CertInvoiceId")== null? 0 : Integer.parseInt(certLineRow.getAttribute("CertInvoiceId").toString());
                
//               System.err.println("popUpInvID-"+popUpInvID);        
               if(popUpInvID==INV_ID){ 
//                   System.err.println("INSIDE __ IF");
                   certLineRow.setAttribute("retReleaseTrans", LINE_AMT); 
              
               }
               }
               
           }
        }
               RichPopup.PopupHints hint = new RichPopup.PopupHints();
               this.p2.show(hint);
               AdfFacesContext.getCurrentInstance().addPartialTarget(t4);

    }
}
