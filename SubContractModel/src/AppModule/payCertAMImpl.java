package AppModule;

import AppModule.common.payCertAM;

import java.sql.CallableStatement;

import java.sql.SQLException;

import java.sql.Types;

import oracle.adf.share.ADFContext;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Sep 13 16:57:13 IST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class payCertAMImpl extends ApplicationModuleImpl implements payCertAM {
    /**
     * This is the default constructor (do not remove).
     */
    public payCertAMImpl() {
    }

    /**
     * Container's getter for XxscCertificationHeadersVO1.
     * @return XxscCertificationHeadersVO1
     */
    public ViewObjectImpl getXxscCertificationHeadersVO1() {
        return (ViewObjectImpl)findViewObject("XxscCertificationHeadersVO1");
    }

    /**
     * Container's getter for XxscCertificationLinesVO1.
     * @return XxscCertificationLinesVO1
     */
    public ViewObjectImpl getXxscCertificationLinesVO1() {
        return (ViewObjectImpl)findViewObject("XxscCertificationLinesVO1");
    }

    /**
     * Container's getter for XxscRetReleasesVO1.
     * @return XxscRetReleasesVO1
     */
    public ViewObjectImpl getXxscRetReleasesVO1() {
        return (ViewObjectImpl)findViewObject("XxscRetReleasesVO1");
    }


    /**
     * Container's getter for contractROVO1.
     * @return contractROVO1
     */
    public ViewObjectImpl getcontractROVO1() {
        return (ViewObjectImpl)findViewObject("contractROVO1");
    }


    /**
     * Container's getter for CertLineHdrFkLink1.
     * @return CertLineHdrFkLink1
     */
    public ViewLinkImpl getCertLineHdrFkLink1() {
        return (ViewLinkImpl)findViewLink("CertLineHdrFkLink1");
    }

    /**
     * Container's getter for RetRelHdrFkLink1.
     * @return RetRelHdrFkLink1
     */
    public ViewLinkImpl getRetRelHdrFkLink1() {
        return (ViewLinkImpl)findViewLink("RetRelHdrFkLink1");
    }


    /**
     * Container's getter for certHdrContHdrViewVL1.
     * @return certHdrContHdrViewVL1
     */
    public ViewLinkImpl getcertHdrContHdrViewVL1() {
        return (ViewLinkImpl)findViewLink("certHdrContHdrViewVL1");
    }


    public void createNewCertification() {
//        System.err.println("===" +
//                           ADFContext.getCurrent().getSessionScope().get("contHdrID"));
//        System.err.println("===" +
//                           ADFContext.getCurrent().getSessionScope().get("version"));
//        System.err.println("===" +
//                           ADFContext.getCurrent().getSessionScope().get("appID"));
//        System.err.println("===" +
//                           ADFContext.getCurrent().getSessionScope().get("ordID"));
//        System.err.println("===" +
//                           ADFContext.getCurrent().getSessionScope().get("paymentID"));
//        System.err.println("===" +
//                           ADFContext.getCurrent().getSessionScope().get("paymentNum"));
        ViewObject certificaHrdVO = getXxscCertificationHeadersVO1();
        ViewObject certificaLineVO = getXxscCertificationLinesVO1();
        // Certification New Row
        Row certificaHrdRow = certificaHrdVO.createRow();
        certificaHrdRow.setAttribute("ContHeaderId",
                                     ADFContext.getCurrent().getSessionScope().get("contHdrID"));
        certificaHrdRow.setAttribute("Version",
                                     ADFContext.getCurrent().getSessionScope().get("version"));
        certificaHrdRow.setAttribute("OrgId",
                                     ADFContext.getCurrent().getSessionScope().get("ordID"));
        certificaHrdRow.setAttribute("PaymentTermId",
                                     ADFContext.getCurrent().getSessionScope().get("paymentID"));
        certificaHrdRow.setAttribute("PaymentTerm",
                                     ADFContext.getCurrent().getSessionScope().get("paymentNum"));
        certificaHrdRow.setAttribute("ApplHeaderId",
                                     ADFContext.getCurrent().getSessionScope().get("appID"));
        certificaHrdVO.insertRow(certificaHrdRow);
        certificaHrdVO.executeQuery();
//        System.err.println("header id-->  " +
//                           certificaHrdRow.getAttribute("CertHeaderId"));

        ViewObject applLineVO = getXxscPayApplLinesVO1();
        ViewCriteria applLineVC = applLineVO.createViewCriteria();
        ViewCriteriaRow applLineVCR = applLineVC.createViewCriteriaRow();
        applLineVCR.setAttribute("ApplHeaderId",
                                 ADFContext.getCurrent().getSessionScope().get("appID"));
        applLineVCR.setAttribute("ContHeaderId",
                                 ADFContext.getCurrent().getSessionScope().get("contHdrID"));
        applLineVC.addRow(applLineVCR);
        applLineVO.applyViewCriteria(applLineVC);
        applLineVO.executeQuery();
//        System.out.println("App Line Count==" +
//                           applLineVO.getEstimatedRowCount());
        RowSetIterator rs = applLineVO.createRowSet(null);
        while (rs.hasNext()) {
            Row appLineRow = rs.next();
            Row certificaLineRow = certificaLineVO.createRow();
            certificaLineRow.setAttribute("CertHeaderId",
                                          certificaHrdRow.getAttribute("CertHeaderId"));
            certificaLineRow.setAttribute("ContLineId",
                                          appLineRow.getAttribute("ContLineId"));
            certificaLineRow.setAttribute("Version",
                                          appLineRow.getAttribute("Version"));
            certificaLineRow.setAttribute("ApplLineId",
                                          appLineRow.getAttribute("ApplLineId"));
            certificaLineRow.setAttribute("ApplHeaderId",
                                          appLineRow.getAttribute("ApplHeaderId"));
            certificaLineRow.setAttribute("DataSetId",
                                          appLineRow.getAttribute("DataSetId"));
            certificaLineRow.setAttribute("ContractHeaderId",
                                          appLineRow.getAttribute("ContHeaderId"));
            certificaLineRow.setAttribute("OrgId",
                                          appLineRow.getAttribute("OrgId"));

            certificaLineRow.setAttribute("Trans_ConLine_ItemDesc",
                                          appLineRow.getAttribute("Trans_Item"));
            certificaLineRow.setAttribute("Trans_ConLine_UOM",
                                          appLineRow.getAttribute("Trans_Uom"));
            certificaLineRow.setAttribute("Trans_ConLine_QTY",
                                          appLineRow.getAttribute("Trans_Qty"));
            certificaLineRow.setAttribute("Trans_ConLine_Rate",
                                          appLineRow.getAttribute("Trans_Rate"));
            certificaLineRow.setAttribute("Trans_ConLine_Amount",
                                          appLineRow.getAttribute("Trans_Amount"));


            certificaLineRow.setAttribute("PrevPerc",
                                          appLineRow.getAttribute("PrevPerc"));
            certificaLineRow.setAttribute("PrevSupOnlyQty",
                                          appLineRow.getAttribute("PrevSupOnlyQty"));
            certificaLineRow.setAttribute("PrevSupInsQty",
                                          appLineRow.getAttribute("PrevSupInsQty"));
            certificaLineRow.setAttribute("PrevTotQty",
                                          appLineRow.getAttribute("PrevTotQty"));
            certificaLineRow.setAttribute("PrevAmount",
                                          appLineRow.getAttribute("PrevAmount"));

            //            certificaLineRow.setAttribute("CurrPerc", appLineRow.getAttribute(""));
            //            certificaLineRow.setAttribute("CurrSupOnlyQty", appLineRow.getAttribute(""));
            //            certificaLineRow.setAttribute("CurrSupInsQty", appLineRow.getAttribute(""));
            //            certificaLineRow.setAttribute("CurrTotQty", appLineRow.getAttribute(""));
            //            certificaLineRow.setAttribute("CurrAmount", appLineRow.getAttribute(""));

            certificaLineRow.setAttribute("CumPerc",
                                          appLineRow.getAttribute("CumPerc"));
            certificaLineRow.setAttribute("CumSupOnlyQty",
                                          appLineRow.getAttribute("CumSupOnlyQty"));
            certificaLineRow.setAttribute("CumSupInsQty",
                                          appLineRow.getAttribute("CumSupInsQty"));
            certificaLineRow.setAttribute("CumTotQty",
                                          appLineRow.getAttribute("CumTotQty"));
            certificaLineRow.setAttribute("CumAmount",
                                          appLineRow.getAttribute("CumAmount"));

            certificaLineRow.setAttribute("PrevPerc_Trans",
                                          appLineRow.getAttribute("PrevPerc"));
            certificaLineRow.setAttribute("PrevSupOnlyQty_Trans",
                                          appLineRow.getAttribute("PrevSupOnlyQty"));
            certificaLineRow.setAttribute("PrevSupInsQty_Trans",
                                          appLineRow.getAttribute("PrevSupInsQty"));
            certificaLineRow.setAttribute("PrevTotQty_Trans",
                                          appLineRow.getAttribute("PrevTotQty"));
            certificaLineRow.setAttribute("PrevAmount_Trans",
                                          appLineRow.getAttribute("PrevAmount"));

            certificaLineRow.setAttribute("CurrPerc_Trans",
                                          appLineRow.getAttribute("CurrPerc"));
            certificaLineRow.setAttribute("CurrSupOnlyQty_Trans",
                                          appLineRow.getAttribute("CurrSupOnlyQty"));
            certificaLineRow.setAttribute("CurrSupInsQty_Trans",
                                          appLineRow.getAttribute("CurrSupInsQty"));
            certificaLineRow.setAttribute("CurrTotQty_Trans",
                                          appLineRow.getAttribute("CurrTotQty"));
            certificaLineRow.setAttribute("CurrAmount_Trans",
                                          appLineRow.getAttribute("CurrAmount"));

            certificaLineRow.setAttribute("CumPerc_Trans",
                                          appLineRow.getAttribute("CumPerc"));
            certificaLineRow.setAttribute("CumSupOnlyQty_Trans",
                                          appLineRow.getAttribute("CumSupOnlyQty"));
            certificaLineRow.setAttribute("CumSupInsQty_Trans",
                                          appLineRow.getAttribute("CumSupInsQty"));
            certificaLineRow.setAttribute("CumAmount_Trans",
                                          appLineRow.getAttribute("CumTotQty"));
            certificaLineRow.setAttribute("CumTotQty_Trans",
                                          appLineRow.getAttribute("CumAmount"));
            certificaLineVO.insertRow(certificaLineRow);
        }
        certificaLineVO.executeQuery();
//        System.err.println("Previous Certification Line added inserted from Buy Screen===Method");

    }

    /**
     * Container's getter for XxscContractLinesVO2.
     * @return XxscContractLinesVO2
     */
    public ViewObjectImpl getXxscContractLinesVO2() {
        return (ViewObjectImpl)findViewObject("XxscContractLinesVO2");
    }

    /**
     * Container's getter for certificationSearchROVO1.
     * @return certificationSearchROVO1
     */
    public ViewObjectImpl getcertificationSearchROVO1() {
        return (ViewObjectImpl)findViewObject("certificationSearchROVO1");
    }

    public void refreshCertification() {
        System.err.println("=====" +
                           ADFContext.getCurrent().getSessionScope().get("page") +
                           "=====");

        if ("add".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("addEditCert"))) {

            if ("certificationBuy".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page")) ||
                "certificationSell".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("page"))) {
//                System.err.println("==CERT==PAGE ADD BUTTON==" +
//                                   ADFContext.getCurrent().getSessionScope().get("page"));
                ADFContext.getCurrent().getPageFlowScope().put("resultVal",
                                                               "NewButtonCertification");
            } else {
//                System.err.println("==CERT==PAGE ADD METHOD==" +
//                                   ADFContext.getCurrent().getSessionScope().get("page"));
                ADFContext.getCurrent().getPageFlowScope().put("resultVal",
                                                               "NewMethodCertification");
            }

        } else if ("edit".equalsIgnoreCase((String)ADFContext.getCurrent().getSessionScope().get("addEditCert"))) {
//            System.err.println("===Certification Edit===");
            ADFContext.getCurrent().getPageFlowScope().put("resultVal",
                                                           "EditCertification");
        }

//        System.err.println("==CERT==PAGE END==" +
//                           ADFContext.getCurrent().getSessionScope().get("page"));
    }


    /**
     * Container's getter for XxscCertificationLinesVO2.
     * @return XxscCertificationLinesVO2
     */
    public ViewObjectImpl getXxscCertificationLinesVO2() {
        return (ViewObjectImpl)findViewObject("XxscCertificationLinesVO2");
    }

    /**
     * Container's getter for XxscPayApplLinesVO1.
     * @return XxscPayApplLinesVO1
     */
    public ViewObjectImpl getXxscPayApplLinesVO1() {
        return (ViewObjectImpl)findViewObject("XxscPayApplLinesVO1");
    }

    /**
     * Container's getter for XxscCertificationHeadersVO2.
     * @return XxscCertificationHeadersVO2
     */
    public ViewObjectImpl getXxscCertificationHeadersVO2() {
        return (ViewObjectImpl)findViewObject("XxscCertificationHeadersVO2");
    }

    /**
     * Container's getter for XxfndFuncAttachment_VO1.
     * @return XxfndFuncAttachment_VO1
     */
    public ViewObjectImpl getXxfndFuncAttachment_VO1() {
        return (ViewObjectImpl)findViewObject("XxfndFuncAttachment_VO1");
    }

    /**
     * Container's getter for CerhdrId_FuncRefID_attach1.
     * @return CerhdrId_FuncRefID_attach1
     */
    public ViewLinkImpl getCerhdrId_FuncRefID_attach1() {
        return (ViewLinkImpl)findViewLink("CerhdrId_FuncRefID_attach1");
    }

    /**
     * Container's getter for FunctionROVO1.
     * @return FunctionROVO1
     */
    public ViewObjectImpl getFunctionROVO1() {
        return (ViewObjectImpl)findViewObject("FunctionROVO1");
    }

    /**
     * Container's getter for CertInterface_ROVO1.
     * @return CertInterface_ROVO1
     */
    public ViewObjectImpl getCertInterface_ROVO1() {
        return (ViewObjectImpl)findViewObject("CertInterface_ROVO1");
    }

    /**
     * Container's getter for CertInterface_VL1.
     * @return CertInterface_VL1
     */
    public ViewLinkImpl getCertInterface_VL1() {
        return (ViewLinkImpl)findViewLink("CertInterface_VL1");
    }

    /**
     * Container's getter for XxscUserAccess1.
     * @return XxscUserAccess1
     */
    public ViewObjectImpl getXxscUserAccess1() {
        return (ViewObjectImpl)findViewObject("XxscUserAccess1");
    }

    /**
     * Container's getter for XxscHeadDetailROVO1.
     * @return XxscHeadDetailROVO1
     */
    public ViewObjectImpl getXxscHeadDetailROVO1() {
        return (ViewObjectImpl)findViewObject("XxscHeadDetailROVO1");
    }

    /**
     * Container's getter for XxscAttachmentVO1.
     * @return XxscAttachmentVO1
     */
    public ViewObjectImpl getXxscAttachmentVO1() {
        return (ViewObjectImpl)findViewObject("XxscAttachmentVO1");
    }

    /**
     * Container's getter for certHrd_VL_Attach1.
     * @return certHrd_VL_Attach1
     */
    public ViewLinkImpl getcertHrd_VL_Attach1() {
        return (ViewLinkImpl)findViewLink("certHrd_VL_Attach1");
    }

    /**
     * Container's getter for XxscCertificationOthChargesVO1.
     * @return XxscCertificationOthChargesVO1
     */
    public ViewObjectImpl getXxscCertificationOthChargesVO1() {
        return (ViewObjectImpl)findViewObject("XxscCertificationOthChargesVO1");
    }

    /**
     * Container's getter for certHdrCertChargeVL1.
     * @return certHdrCertChargeVL1
     */
    public ViewLinkImpl getcertHdrCertChargeVL1() {
        return (ViewLinkImpl)findViewLink("certHdrCertChargeVL1");
    }

    /**
     * Container's getter for XxscPayApplOthChargesVO1.
     * @return XxscPayApplOthChargesVO1
     */
    public ViewObjectImpl getXxscPayApplOthChargesVO1() {
        return (ViewObjectImpl)findViewObject("XxscPayApplOthChargesVO1");
    }

    /**
     * Container's getter for invoiceStatusROVO1.
     * @return invoiceStatusROVO1
     */
    public ViewObjectImpl getinvoiceStatusROVO1() {
        return (ViewObjectImpl)findViewObject("invoiceStatusROVO1");
    }

    /**
     * Container's getter for XxscCertAdvanceDtlsVO1.
     * @return XxscCertAdvanceDtlsVO1
     */
    public ViewObjectImpl getXxscCertAdvanceDtlsVO1() {
        return (ViewObjectImpl)findViewObject("XxscCertAdvanceDtlsVO1");
    }

    /**
     * Container's getter for CertAdvanceVL1.
     * @return CertAdvanceVL1
     */
    public ViewLinkImpl getCertAdvanceVL1() {
        return (ViewLinkImpl)findViewLink("CertAdvanceVL1");
    }


    /**
     * Container's getter for XxscCertAdvRecDtlsVO2.
     * @return XxscCertAdvRecDtlsVO2
     */
    public ViewObjectImpl getXxscCertAdvRecDtlsVO2() {
        return (ViewObjectImpl)findViewObject("XxscCertAdvRecDtlsVO2");
    }

    /**
     * Container's getter for CertRecVL2.
     * @return CertRecVL2
     */
    public ViewLinkImpl getCertRecVL2() {
        return (ViewLinkImpl)findViewLink("CertRecVL2");
    }

    /**
     * Container's getter for AdvPrevAmt_ROVO1.
     * @return AdvPrevAmt_ROVO1
     */
    public ViewObjectImpl getAdvPrevAmt_ROVO1() {
        return (ViewObjectImpl)findViewObject("AdvPrevAmt_ROVO1");
    }

    /**
     * Container's getter for XxscPayApplHeadersVO1.
     * @return XxscPayApplHeadersVO1
     */
    public ViewObjectImpl getXxscPayApplHeadersVO1() {
        return (ViewObjectImpl)findViewObject("XxscPayApplHeadersVO1");
    }

    /**
     * Container's getter for PreOthChargeCertROVO1.
     * @return PreOthChargeCertROVO1
     */
    public ViewObjectImpl getPreOthChargeCertROVO1() {
        return (ViewObjectImpl)findViewObject("PreOthChargeCertROVO1");
    }

    /**
     * Container's getter for PreviCertOtherChargeVL1.
     * @return PreviCertOtherChargeVL1
     */
    public ViewLinkImpl getPreviCertOtherChargeVL1() {
        return (ViewLinkImpl)findViewLink("PreviCertOtherChargeVL1");
    }

    /**
     * Container's getter for GetOtherChargesAmountROVO1.
     * @return GetOtherChargesAmountROVO1
     */
    public ViewObjectImpl getGetOtherChargesAmountROVO1() {
        return (ViewObjectImpl)findViewObject("GetOtherChargesAmountROVO1");
    }
    public String deletedbcall(String p_cid,String p_type,String P_username,String p_ip)
    {
        String result="";
     try {
        CallableStatement cs=this.getDBTransaction().createCallableStatement("{call delehistory_pkg.deletehistory_proc(?,?,?,?,?)}", 1);
           int a=Integer.parseInt(p_cid);
            cs.setInt(1,a);
            cs.setString(2,p_type);
            cs.setString(3,P_username);
            cs.setString(4,p_ip);
            cs.registerOutParameter(5, Types.VARCHAR);
            cs.executeUpdate();
            result=cs.getString(5);
        } catch (SQLException e) {
        }
       
        return result;
    }

}
