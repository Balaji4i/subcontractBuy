import Utils.ADFUtils;
import Utils.JSFUtils;
import Utils.RTFUtils;

import java.io.IOException;
import java.io.OutputStream;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.component.rich.nav.RichGoButton;

import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;

public class consolidatedreport {
    
    private RichInputListOfValues buid;
    private RichInputListOfValues supplierid;
    private RichInputListOfValues prjnumber;
    private RichInputListOfValues contnumber;
    String busi_N = "";
    String supN = "";
    String projectNum = "";
    String contractNum = "";

    public consolidatedreport() {
    }
    
    ViewObject businessunitReportVO = ADFUtils.findIterator("businessunitReportROVO1Iterator").getViewObject();
    ViewObject vendorsReportVO = ADFUtils.findIterator("xxstgVendorsVO1Iterator").getViewObject();
    
    public void onclickdownloadexcel(ActionEvent actionEvent) {
        // Add event code here...    
    }


    public String getExcel(){
        String result=null;
        String buId=ADFContext.getCurrent().getSessionScope().get("bu")==null?"0":ADFContext.getCurrent().getSessionScope().get("bu").toString();
        System.err.println("Business Unit===>" + buId);
        String supplId=ADFContext.getCurrent().getSessionScope().get("sup")==null?"0":ADFContext.getCurrent().getSessionScope().get("sup").toString();
        System.err.println("Supplier===>" + supplId);
        result="https://ncltstjcs.naresco.ae/LeaseTempNewReport/webresources/subcont/consolidatedReport?P_BU_NAME="+buId+"&P_SUP_NAME="+supplId+"&P_FILE_TYPE=excel";  
        System.err.println("result===>" + result);
        return result;
    }        
    

    public void onclickdownloadexcel(FacesContext facesContext,
                                     OutputStream outputStream)throws IOException {
        String buId = buid.getValue()==null?"0":buid.getValue().toString();
        System.err.println("Business Unit===>" + buId);
    }
    
    public void reportexceldownloading(FacesContext facesContext,
                                       OutputStream outputStream)throws IOException {
        Object result = null;
        String supplier_N=ADFContext.getCurrent().getPageFlowScope().get("sup_N")==null?"0":ADFContext.getCurrent().getPageFlowScope().get("sup_N").toString();
        String busi_N=ADFContext.getCurrent().getPageFlowScope().get("bu_N")==null?"0":ADFContext.getCurrent().getPageFlowScope().get("bu_N").toString();
        result=ADFContext.getCurrent().getPageFlowScope().put("exceldownload", "https://nclprdjcs.naresco.ae/LeaseTempNewReport/webresources/subcont/consolidatedReport?P_BU_NAME="+busi_N+"&P_SUP_NAME="+supplier_N+"&P_FILE_TYPE=excel").toString();
        System.err.println("Download link===>" + ADFContext.getCurrent().getPageFlowScope().get("exceldownload"));
        outputStream.write((byte[])result);
    }

    public void onClickReset(ActionEvent actionEvent) {
        // Add event code here...
       System.err.println("coming into reset"); 
       buid.resetValue();
       supplierid.resetValue();
    }

    public void setBuid(RichInputListOfValues buid) {
        this.buid = buid;
    }

    public RichInputListOfValues getBuid() {
        return buid;
    }

    public void buName(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if(businessunitReportVO.getEstimatedRowCount() != 0){
            busi_N = businessunitReportVO.getCurrentRow().getAttribute("BuId").toString();
            ADFContext.getCurrent().getPageFlowScope().put("bu_N", busi_N);
            System.err.println("Business Unit===>" + busi_N);  
            System.err.println("Business===>" + ADFContext.getCurrent().getPageFlowScope().get("bu_N"));
            ADFContext.getCurrent().getPageFlowScope().put("exceldownload", "https://nclprdjcs.naresco.ae/LeaseTempNewReport/webresources/subcont/consolidatedReport?P_BU_NAME="+busi_N+"&P_SUP_NAME="+supN+"&P_PROJ_NO="+projectNum+"&P_CON_NO="+contractNum+"&P_FILE_TYPE=excel");
            System.err.println("Download link===>" + ADFContext.getCurrent().getPageFlowScope().get("exceldownload"));
        }
    }

    public void setSupplierid(RichInputListOfValues supplierid) {
        this.supplierid = supplierid;
    }

    public RichInputListOfValues getSupplierid() {
        return supplierid;
    }

    public void supplName(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        supN = vendorsReportVO.getCurrentRow().getAttribute("VendorId").toString();
        ADFContext.getCurrent().getPageFlowScope().put("sup_N", supN);
        busi_N = ADFContext.getCurrent().getPageFlowScope().get("bu_N")==null?"0":ADFContext.getCurrent().getPageFlowScope().get("bu_N").toString();
        System.err.println("Supplier Name===>" + supN);
        System.err.println("Supplier===>" + ADFContext.getCurrent().getPageFlowScope().get("sup_N"));
       ADFContext.getCurrent().getPageFlowScope().put("exceldownload", "https://nclprdjcs.naresco.ae/LeaseTempNewReport/webresources/subcont/consolidatedReport?P_BU_NAME="+busi_N+"&P_SUP_NAME="+supN+"&P_PROJ_NO="+projectNum+"&P_CON_NO="+contractNum+"&P_FILE_TYPE=excel");
       System.err.println("Download link===>" + ADFContext.getCurrent().getPageFlowScope().get("exceldownload"));
       }

    public void projectNum(ValueChangeEvent valueChangeEvent) {
        String projectNum= valueChangeEvent.getNewValue()==null?"":valueChangeEvent.getNewValue().toString();
        ADFContext.getCurrent().getPageFlowScope().put("project_Num", projectNum);
        System.err.println("Project Number===>" + projectNum);  
        System.err.println("Project Number===>" + ADFContext.getCurrent().getPageFlowScope().get("project_Num"));
        busi_N = ADFContext.getCurrent().getPageFlowScope().get("bu_N")==null?"0":ADFContext.getCurrent().getPageFlowScope().get("bu_N").toString();
        supN = ADFContext.getCurrent().getPageFlowScope().get("sup_N")==null?"":ADFContext.getCurrent().getPageFlowScope().get("sup_N").toString();
        ADFContext.getCurrent().getPageFlowScope().put("exceldownload", "https://nclprdjcs.naresco.ae/LeaseTempNewReport/webresources/subcont/consolidatedReport?P_BU_NAME="+busi_N+"&P_SUP_NAME="+supN+"&P_PROJ_NO="+projectNum+"&P_CON_NO="+contractNum+"&P_FILE_TYPE=excel");
        System.err.println("Download link===>" + ADFContext.getCurrent().getPageFlowScope().get("exceldownload"));
        
    }

    public void contractNum(ValueChangeEvent valueChangeEvent) {        
        String contractNum= valueChangeEvent.getNewValue()==null?"":valueChangeEvent.getNewValue().toString();
        ADFContext.getCurrent().getPageFlowScope().put("contract_Num", contractNum);
        busi_N = ADFContext.getCurrent().getPageFlowScope().get("bu_N")==null?"0":ADFContext.getCurrent().getPageFlowScope().get("bu_N").toString();
        supN = ADFContext.getCurrent().getPageFlowScope().get("sup_N")==null?"":ADFContext.getCurrent().getPageFlowScope().get("sup_N").toString();
        projectNum = ADFContext.getCurrent().getPageFlowScope().get("project_Num")==null?"":ADFContext.getCurrent().getPageFlowScope().get("project_Num").toString();
        System.err.println("Contract Number===>" + contractNum);  
        System.err.println("Contract Number===>" + ADFContext.getCurrent().getPageFlowScope().get("contract_Num"));
        ADFContext.getCurrent().getPageFlowScope().put("exceldownload", "https://nclprdjcs.naresco.ae/LeaseTempNewReport/webresources/subcont/consolidatedReport?P_BU_NAME="+busi_N+"&P_SUP_NAME="+supN+"&P_PROJ_NO="+projectNum+"&P_CON_NO="+contractNum+"&P_FILE_TYPE=excel");
        System.err.println("Download link===>" + ADFContext.getCurrent().getPageFlowScope().get("exceldownload"));
    }

    public void setPrjnumber(RichInputListOfValues prjnumber) {
        this.prjnumber = prjnumber;
    }

    public RichInputListOfValues getPrjnumber() {
        return prjnumber;
    }

    public void setContnumber(RichInputListOfValues contnumber) {
        this.contnumber = contnumber;
    }

    public RichInputListOfValues getContnumber() {
        return contnumber;
    }
}
