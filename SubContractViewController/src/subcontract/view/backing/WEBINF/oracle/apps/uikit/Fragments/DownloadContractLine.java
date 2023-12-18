package subcontract.view.backing.WEBINF.oracle.apps.uikit.Fragments;

import Utils.ADFUtils;


import Utils.ADFUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;

import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.RichTextString;


public class DownloadContractLine {
    public DownloadContractLine() {
        super();
    }

    ViewObject contractLineVO =
        ADFUtils.findIterator("XxstgSellContractLines_VO1Iterator").getViewObject();


    public String downlaodExcel(String cname) throws FileNotFoundException,
                                                     IOException,
                                                     ParseException {

        String path = new File("").getAbsolutePath();
        System.err.println("path======>" + path);

        HSSFWorkbook workbook = new HSSFWorkbook();
        // Date code
        CellStyle cellStyle = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();
        // Set the date format of date
        cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy hh:mm:ss"));

        // New Sheet
        HSSFSheet sheet = workbook.createSheet("ContractLines");

        HSSFRow rowhead = sheet.createRow((short)0);
        rowhead.createCell(0).setCellValue("LineNumber");
        rowhead.createCell(1).setCellValue("ItemName");
        rowhead.createCell(2).setCellValue("ItemDescription");
        rowhead.createCell(3).setCellValue("UOM");
        rowhead.createCell(4).setCellValue("Qty");
        rowhead.createCell(5).setCellValue("Rate");
        rowhead.createCell(6).setCellValue("Start Date");
        rowhead.createCell(7).setCellValue("End Date");
        rowhead.createCell(8).setCellValue("Project #");
        rowhead.createCell(9).setCellValue("Task #");
        rowhead.createCell(10).setCellValue("Tax");


        int i = 1;
        RowSetIterator rs = contractLineVO.createRowSetIterator(null);
        while (rs.hasNext()) {
            Row contractLineRow = rs.next();
            String lineNumber =
                contractLineRow.getAttribute("LineNumber") == null ? "" :
                contractLineRow.getAttribute("LineNumber").toString();
            String itemName =
                contractLineRow.getAttribute("ItemName") == null ? "" :
                contractLineRow.getAttribute("ItemName").toString();
            String itemDescription =
                contractLineRow.getAttribute("ItemDescription") == null ? "" :
                contractLineRow.getAttribute("ItemDescription").toString();
            String unitOfMeasure =
                contractLineRow.getAttribute("UnitOfMeasure") == null ? "" :
                contractLineRow.getAttribute("UnitOfMeasure").toString();
            double numOfItem =
                contractLineRow.getAttribute("NumOfItem") == null ? 0 :
                Double.parseDouble(contractLineRow.getAttribute("NumOfItem").toString());
            double priceUnit =
                contractLineRow.getAttribute("PriceUnit") == null ? 0 :
                Double.parseDouble(contractLineRow.getAttribute("PriceUnit").toString());

            String sd =
                contractLineRow.getAttribute("StartDate") == null ? "" :
                contractLineRow.getAttribute("StartDate").toString();
            System.err.println("===sdate==" + sd);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = df.parse(sd);
            String st1 = new SimpleDateFormat("dd-MM-yyyy").format(startDate);
            // String newDateString = df.format(startDate);
            // System.err.println("New date string : "+newDateString);
            java.sql.Date sqlDate = new java.sql.Date(startDate.getTime());
            oracle.jbo.domain.Date domainstartDate =
                new oracle.jbo.domain.Date(sqlDate);
            System.err.println("--sqlDate---" + sqlDate + "==Start Date===" +
                               domainstartDate);

            String ed =
                contractLineRow.getAttribute("EndDate") == null ? "" : contractLineRow.getAttribute("EndDate").toString();
            System.err.println("===edate==" + ed);
            //            DateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
            Date endDate = df.parse(ed);
            String ed1 = new SimpleDateFormat("dd-MM-yyyy").format(endDate);
            System.err.println("start date :" + st1 + "\n end Date :" + ed1);
            // String newDateString = df.format(startDate);
            // System.err.println("New date string : "+newDateString);
            java.sql.Date sqlDate1 = new java.sql.Date(endDate.getTime());
            oracle.jbo.domain.Date domainEndDate =
                new oracle.jbo.domain.Date(sqlDate1);
            System.err.println("--sqlDate1---" + sqlDate1 + "==EndDate==" +
                               domainEndDate);


            String projectNumber =
                contractLineRow.getAttribute("ProjectNumber") == null ? "" :
                contractLineRow.getAttribute("ProjectNumber").toString();
            String taskNumber =
                contractLineRow.getAttribute("TaskNumber") == null ? "" :
                contractLineRow.getAttribute("TaskNumber").toString();
            String outputTaxClassificationCode =
                contractLineRow.getAttribute("OutputTaxClassificationCode") ==
                null ? "" :
                contractLineRow.getAttribute("OutputTaxClassificationCode").toString();

            System.err.println(lineNumber + "--" + itemName + "--" +
                               itemDescription + "--" + unitOfMeasure + "--" +
                               numOfItem + "--" + priceUnit + "--" +
                               domainstartDate + "--" + domainEndDate + "--" +
                               projectNumber + "--" + taskNumber + "--" +
                               outputTaxClassificationCode);

            HSSFRow row = sheet.createRow((short)i);
            //row.createCell(0).setCellValue(tname);
            row.createCell(0).setCellValue(lineNumber);
            row.createCell(1).setCellValue(itemName);
            row.createCell(2).setCellValue(itemDescription);
            row.createCell(3).setCellValue(unitOfMeasure);
            row.createCell(4).setCellValue(numOfItem);
            row.createCell(5).setCellValue(priceUnit);
            //                   row.createCell(6).setCellValue((RichTextString)domainstartDate);
            //                   row.createCell(7).setCellValue((RichTextString)domainEndDate);

            Cell cell = row.createCell(6);
            //   cell.setCellValue(new Date());///////// need to inset date
            cell.setCellValue(st1);
            cell.setCellStyle(cellStyle);

            Cell cell7 = row.createCell(7);
            cell7.setCellValue(ed1); ///////// need to inset date
            cell7.setCellStyle(cellStyle);

            row.createCell(8).setCellValue(projectNumber);
            row.createCell(9).setCellValue(taskNumber);
            row.createCell(10).setCellValue(outputTaxClassificationCode);
            i++;
            System.err.println("I value==" + i);
        }


        /*
        int i = 1;
        RowSetIterator rs = contractLineVO.createRowSetIterator(null);
        while (rs.hasNext()) {
            Row contractLineRow = rs.next();
            long lineNumber =
                contractLineRow.getAttribute("LineNumber") == null ? 0 :
                Long.parseLong(contractLineRow.getAttribute("LineNumber").toString());
            String lineType =
                contractLineRow.getAttribute("LineType") == null ? "" :
                contractLineRow.getAttribute("LineType").toString();
            String itemName =
                contractLineRow.getAttribute("ItemName") == null ? "" :
                contractLineRow.getAttribute("ItemName").toString();
            String itemDescription =
                contractLineRow.getAttribute("ItemDescription") == null ? "" :
                contractLineRow.getAttribute("ItemDescription").toString();
            String unitOfMeasure =
                contractLineRow.getAttribute("UnitOfMeasure") == null ? "" :
                contractLineRow.getAttribute("UnitOfMeasure").toString();
            double numOfItem =
                contractLineRow.getAttribute("NumOfItem") == null ? 0 :
                Double.parseDouble(contractLineRow.getAttribute("NumOfItem").toString());
            double priceUnit =
                contractLineRow.getAttribute("PriceUnit") == null ? 0 :
                Double.parseDouble(contractLineRow.getAttribute("PriceUnit").toString());
            double lineAmount =
                contractLineRow.getAttribute("LineAmount") == null ? 0 :
                Double.parseDouble(contractLineRow.getAttribute("LineAmount").toString());
            String startDate =
                contractLineRow.getAttribute("StartDate") == null ? null :
                contractLineRow.getAttribute("StartDate").toString();
            String endDate =
                contractLineRow.getAttribute("EndDate") == null ? null :
                contractLineRow.getAttribute("EndDate").toString();
            String projectNumber =
                contractLineRow.getAttribute("ProjectNumber") == null ? "" :
                contractLineRow.getAttribute("ProjectNumber").toString();
            String taskNumber =
                contractLineRow.getAttribute("TaskNumber") == null ? "" :
                contractLineRow.getAttribute("TaskNumber").toString();
            double fundingAmount =
                contractLineRow.getAttribute("FundingAmount") == null ? 0 :
                Double.parseDouble(contractLineRow.getAttribute("FundingAmount").toString());
            System.err.println(lineNumber + "--" + lineType + "----" +
                               unitOfMeasure + "--" + numOfItem + "--" +
                               priceUnit + "--" + lineAmount + "---" +
                               itemName + "--" + itemDescription + "--" +
                               startDate + "--" + endDate + "--" +
                               projectNumber + "--" + taskNumber);

            HSSFRow row = sheet.createRow((short)i);
           row.createCell(0).setCellValue(lineNumber);
            row.createCell(1).setCellValue(lineType);
            row.createCell(2).setCellValue(itemName);
            row.createCell(3).setCellValue(itemDescription);
            row.createCell(4).setCellValue(unitOfMeasure);
            if(numOfItem>0)
            {
            row.createCell(5).setCellValue(numOfItem);
            }
            else{
            row.createCell(5).setCellValue("");
            }
            if(priceUnit>0)
            {
            row.createCell(6).setCellValue(priceUnit);
            }
            else{
            row.createCell(6).setCellValue("");
            }
            if(lineAmount>0)
            {
            row.createCell(7).setCellValue(lineAmount);
            }
            else{
            row.createCell(7).setCellValue("");
            }
            row.createCell(8).setCellValue(startDate);
            row.createCell(9).setCellValue(endDate);
            row.createCell(10).setCellValue(projectNumber);
            row.createCell(11).setCellValue(taskNumber);
            if(fundingAmount>0)
            {
            row.createCell(12).setCellValue(fundingAmount);
            }
            else{
            row.createCell(12).setCellValue("");
            }
            i++;
            System.err.println("I value==" + i);
        }

*/
        FileOutputStream fileOut =
            new FileOutputStream(new File(cname + ".xls"));
        workbook.write(fileOut);
        fileOut.close();
        System.out.println("Your excel file has been generated!" + path);
        String filepath = path + "/" + cname + ".xls";
        System.err.println("--filepath--" + filepath);

        return path;


    }


}
