package backing;

import Utils.ADFUtils;

import Utils.JSFUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;

import java.io.OutputStream;

import java.math.BigDecimal;

import java.util.Date;

import javax.faces.context.FacesContext;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;


public class DownlaodExcel {
    public DownlaodExcel() {
        super();
    }
    ViewObject contractLineVO =
        ADFUtils.findIterator("XxscContractLinesVO1Iterator").getViewObject();

    ViewObject downloadTaskVO =
        ADFUtils.findIterator("excelDownloadProjectTaskROVO1Iterator").getViewObject();
    ViewObject downloadUOMVO =
        ADFUtils.findIterator("excelDownloadUOMROVO1Iterator").getViewObject();

    /*

    public String  downlaodExcel(String cname) throws FileNotFoundException,
                                                     IOException {
       // String filename = "C:/"+cname+".xls" ;

        String path=new File("").getAbsolutePath();
        System.err.println("path======>"+path);
//        String basePath=path+cname+".xls";
        JSFUtils.addFacesErrorMessage("=="+path);
            /* 8.43
            // 4500-16.87
            // 3500-12.96
               1000-3.91*/
    /*
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("ContractLines");
        sheet.setColumnWidth(0, 3500);
        sheet.setColumnWidth(1, 6500);
        sheet.setColumnWidth(2, 3500);
        sheet.setColumnWidth(3, 3700);
        sheet.setColumnWidth(4, 3500);
        sheet.setColumnWidth(5, 3500);
        sheet.setColumnWidth(6, 3500);
        sheet.setColumnWidth(7, 3500);
        sheet.setColumnWidth(8, 3500);

        HSSFRow rowhead = sheet.createRow((short)0);
        //rowhead.createCell(0).setCellValue("S.No");
        rowhead.createCell(0).setCellValue("Requisition Line Number");
        rowhead.createCell(1).setCellValue("Task Name");
        rowhead.createCell(2).setCellValue("Item Code");
        rowhead.createCell(3).setCellValue("Item Description");
        rowhead.createCell(4).setCellValue("Category Code");
        rowhead.createCell(5).setCellValue("Item specification");
        rowhead.createCell(6).setCellValue("UOM");
        rowhead.createCell(7).setCellValue("Quantity");
        rowhead.createCell(8).setCellValue("Unit Price");

        int i=1;
        RowSetIterator rs=contractLineVO.createRowSetIterator(null);
        while(rs.hasNext()){
          Row contractLineRow = rs.next();
          String tid=contractLineRow.getAttribute("TaskId")==null?"":contractLineRow.getAttribute("TaskId").toString();
          String tnum=contractLineRow.getAttribute("TaskNumber")==null?"":contractLineRow.getAttribute("TaskNumber").toString();
          String  reqId=contractLineRow.getAttribute("ReqHdrId")==null?"":contractLineRow.getAttribute("ReqHdrId").toString();
          String  reqNum=contractLineRow.getAttribute("ReqNumber")==null?"":contractLineRow.getAttribute("ReqNumber").toString();
          long  reqLNum=contractLineRow.getAttribute("ReqLineNumber")==null?0:Long.parseLong(contractLineRow.getAttribute("ReqLineNumber").toString());
          String  ItemDesc=contractLineRow.getAttribute("ItemDescription")==null?"":contractLineRow.getAttribute("ItemDescription").toString();
          String  ItemNumber=contractLineRow.getAttribute("ItemNumber")==null?"":contractLineRow.getAttribute("ItemNumber").toString();
          String categoryName=contractLineRow.getAttribute("CategoryName_Tarns")==null?"":contractLineRow.getAttribute("CategoryName_Tarns").toString();
          String  BoQ=contractLineRow.getAttribute("BoqItemDesc")==null?"":contractLineRow.getAttribute("BoqItemDesc").toString();
          String  Uom=contractLineRow.getAttribute("Uom")==null?"":contractLineRow.getAttribute("Uom").toString();
          float  Qty=contractLineRow.getAttribute("OrigQuantity")==null?0:Float.parseFloat(contractLineRow.getAttribute("OrigQuantity").toString());
          float  Prz=contractLineRow.getAttribute("OrigUnitPrice")==null?0:Float.parseFloat(contractLineRow.getAttribute("OrigUnitPrice").toString());
          float  amt=contractLineRow.getAttribute("OrigAmount")==null?0:Float.parseFloat(contractLineRow.getAttribute("OrigAmount").toString());

        System.err.println("--taskID--"+tid+"-tnum-"+tnum+"-reqId-"+reqId+"-reqNum-"+reqNum+"-reqLNum-"+reqLNum+"-ItemDesc-"+ItemDesc+"-ItemNumber-"+"--categoryName--"+categoryName+ItemNumber+"-BoQ-"+BoQ+"-Uom-"+Uom+"-Qty-"+Qty+"-Prz-"+Prz);

         HSSFRow row = sheet.createRow((short)i);
          //row.createCell(0).setCellValue(tname);
            row.createCell(0).setCellValue(reqLNum);
            row.createCell(1).setCellValue(getTaskname(tid, tnum));
            row.createCell(2).setCellValue(ItemNumber);
            row.createCell(3).setCellValue(ItemDesc);
            row.createCell(4).setCellValue(categoryName);
            row.createCell(5).setCellValue(BoQ);
            row.createCell(6).setCellValue(getUOM(Uom));
            row.createCell(7).setCellValue(Qty);
            row.createCell(8).setCellValue(Prz);

           i++;
           System.err.println("I value=="+i);
          }
        FileOutputStream fileOut = new FileOutputStream(new File(cname+".xls"));
        workbook.write(fileOut);
        fileOut.close();
        System.out.println("Your excel file has been generated!"+path);
        String filepath=path+"/"+cname+".xls";
        System.err.println("--filepath--"+filepath);

    return path;
    }



    public String getTaskname(String tid, String tnumber){
        String  taskName=null;
        ViewObjectImpl vo =(ViewObjectImpl)downloadTaskVO;
        ViewCriteria vc =vo.getViewCriteria("excelDownloadProjectTask");
        vo.applyViewCriteria(vc);
        vo.setNamedWhereClauseParam("BV_TID",tid);
        vo.setNamedWhereClauseParam("BV_TASKNUM",tnumber);
        vo.executeQuery();
        System.err.println("COUNT--TASK--" +vo.getEstimatedRowCount());
        if (vo.getEstimatedRowCount() == 1){
            taskName =vo.first().getAttribute("Name") ==null ? null :vo.first().getAttribute("Name").toString();
            System.err.println("==="+taskName);
        }
       return taskName;
    }


    public String getUOM(String Ucode){
        String  UOMDesc=null;
        ViewObjectImpl vo =(ViewObjectImpl)downloadUOMVO;
        ViewCriteria vc =vo.getViewCriteria("excelDownloadUOM");
        vo.applyViewCriteria(vc);
        vo.setNamedWhereClauseParam("BV_CODE",Ucode);
        vo.executeQuery();
        System.err.println("COUNT--UOM--" +vo.getEstimatedRowCount());
        if (vo.getEstimatedRowCount() == 1){
            UOMDesc =vo.first().getAttribute("Description") ==null ? null :vo.first().getAttribute("Description").toString();
            System.err.println("==="+UOMDesc);
        }
       return UOMDesc;
    }


 */


    public String downlaodSellExcel(String cname) throws FileNotFoundException,
                                                         IOException {
        // String filename = "C:/"+cname+".xls" ;

        String path = new File("").getAbsolutePath();
        System.err.println("path======>" + path);
        //        String basePath=path+cname+".xls";
        JSFUtils.addFacesErrorMessage("==" + path);
        /* 8.43
            // 4500-16.87
            // 3500-12.96
               1000-3.91*/

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("ContractLines");

        sheet.setColumnWidth(0, 3500);
        sheet.setColumnWidth(1, 6500);
        sheet.setColumnWidth(2, 3500);
        sheet.setColumnWidth(3, 3700);
        sheet.setColumnWidth(4, 3500);
        sheet.setColumnWidth(5, 3500);
        sheet.setColumnWidth(6, 3500);
        sheet.setColumnWidth(7, 3500);


        HSSFRow rowhead = sheet.createRow((short)0);
        //rowhead.createCell(0).setCellValue("S.No");
        rowhead.createCell(0).setCellValue("Rel Line Number");
        rowhead.createCell(1).setCellValue("Contract Line Number");
        //        rowhead.createCell(1).setCellValue("Task Number");
        rowhead.createCell(2).setCellValue("Item Description");
        rowhead.createCell(3).setCellValue("UOM");
        rowhead.createCell(4).setCellValue("Quantity");
        rowhead.createCell(5).setCellValue("Unit Price");
        rowhead.createCell(6).setCellValue("Project Number");
        rowhead.createCell(7).setCellValue("Task Number");


        //        int i=1;
        //        RowSetIterator rs=contractLineVO.createRowSetIterator(null);
        //        while(rs.hasNext()){
        //          Row contractLineRow = rs.next();
        //          String RelLineNumber=null;
        //          String LineNumber=null;
        //          String projectNumber=null;
        //          String taskNumbert=null;
        //          String itemCode=null;
        //          String ItemDescription=null;
        //          String CategoryName=null;
        //          String ItemSpec=null;
        //          String Uom=null;
        //          double Qty=0;
        //          double Prz=0;
        //
        //         HSSFRow row = sheet.createRow((short)i);
        //          //row.createCell(0).setCellValue(tname);
        //              row.createCell(0).setCellValue(RelLineNumber);
        //              row.createCell(1).setCellValue(LineNumber);
        //              row.createCell(2).setCellValue(projectNumber);
        //              row.createCell(3).setCellValue(taskNumbert);
        //              row.createCell(4).setCellValue(itemCode);
        //              row.createCell(5).setCellValue(ItemDescription);
        //              row.createCell(6).setCellValue(CategoryName);
        //              row.createCell(7).setCellValue(ItemSpec);
        //              row.createCell(8).setCellValue(Uom);
        //              row.createCell(9).setCellValue(Qty);
        //              row.createCell(10).setCellValue(Prz);
        //
        //           i++;
        //           System.err.println("I value=="+i);
        //          }

        FileOutputStream fileOut =
            new FileOutputStream(new File(cname + ".xls"));
        workbook.write(fileOut);
        fileOut.close();
        System.out.println("Your excel file has been generated!" + path);
        String filepath = path + "/" + cname + ".xls";
        System.err.println("--filepath--" + filepath);

        return path;
    }
    //*******************************************************************
    //**********BILL NO & PAGE NO & ITEM NO**************************
    //*******************************************************************

    public void lineUploadWithBill(FacesContext facesContext,
                                   OutputStream outputStream) {
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Contract Line");

            sheet.setColumnWidth(0, 3500);
            sheet.setColumnWidth(1, 6500);
            sheet.setColumnWidth(2, 3500);
            sheet.setColumnWidth(3, 3700);
            sheet.setColumnWidth(4, 3500);
            sheet.setColumnWidth(5, 3500);
            sheet.setColumnWidth(6, 3500);
            sheet.setColumnWidth(7, 3500);
            sheet.setColumnWidth(8, 3500);
            sheet.setColumnWidth(9, 3500);
            sheet.setColumnWidth(10, 3500);
            sheet.setColumnWidth(11, 3500);
            sheet.setColumnWidth(12, 3500);

            HSSFRow rowhead = sheet.createRow((short)0);

            rowhead.createCell(0).setCellValue("Line Type");
            rowhead.createCell(1).setCellValue("Rel Line Number");
            rowhead.createCell(2).setCellValue("Contract Line Number");
            rowhead.createCell(3).setCellValue("Bill No");
            rowhead.createCell(4).setCellValue("Item No");
            rowhead.createCell(5).setCellValue("Item Description");
            rowhead.createCell(6).setCellValue("UOM");
            rowhead.createCell(7).setCellValue("Quantity");
            rowhead.createCell(8).setCellValue("Unit Price");
            rowhead.createCell(9).setCellValue("Project Number");
            rowhead.createCell(10).setCellValue("Task Number");
            rowhead.createCell(11).setCellValue("Sub-Task Number");
            rowhead.createCell(12).setCellValue("Page NO");
            sheet.createFreezePane(0, 1, 0, 1);

            workbook.write(outputStream);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //*******************************************************************
    //******************* NARESCO*********************************
    //*******************************************************************

    public void lineUpload(FacesContext facesContext,
                           OutputStream outputStream) {
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Contract Line");

            sheet.setColumnWidth(0, 3500);
            sheet.setColumnWidth(1, 6500);
            sheet.setColumnWidth(2, 3500);
            sheet.setColumnWidth(3, 3700);
            sheet.setColumnWidth(4, 3500);
            sheet.setColumnWidth(5, 3500);
            sheet.setColumnWidth(6, 3500);
            sheet.setColumnWidth(7, 3500);
            sheet.setColumnWidth(8, 3500);

            HSSFRow rowhead = sheet.createRow((short)0);

            rowhead.createCell(0).setCellValue("Variation");
            rowhead.createCell(1).setCellValue("Rel Line Number");
            rowhead.createCell(2).setCellValue("Contract Line Number");
            rowhead.createCell(3).setCellValue("Item Description");
            rowhead.createCell(4).setCellValue("UOM");
            rowhead.createCell(5).setCellValue("Quantity");
            rowhead.createCell(6).setCellValue("Unit Price");
            rowhead.createCell(7).setCellValue("Project Number");
            rowhead.createCell(8).setCellValue("Task Number");
            sheet.createFreezePane(0, 1, 0, 1);

            workbook.write(outputStream);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sellContractLineTemplate(FacesContext facesContext,
                                         OutputStream outputStream) {
        //
        lineUploadWithBill(facesContext, outputStream);
        // NARESCO
        //         lineUpload(facesContext,outputStream);
    }
}
