package backing;

import Utils.ADFUtils;

import Utils.JSFUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;

import java.math.BigDecimal;

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

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class DeliveryPlanData {
    public DeliveryPlanData() {
        super();
    }

    static ViewObject contractHrdVO =
        ADFUtils.findIterator("XxscContractHeadersVO1Iterator").getViewObject();
    static ViewObject contractLneVO =
        ADFUtils.findIterator("MaxLineROVO1Iterator").getViewObject();
    static ViewObject contractLneQTYVO =
        ADFUtils.findIterator("MaxLineQtyROVO1Iterator").getViewObject();


    public static String downlaodExcel(String cname) throws FileNotFoundException,
                                                            IOException,
                                                            ParseException {

        long contractHrd =
            contractHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
            null ? 0 :
            Long.parseLong(contractHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString());
        long version =
            contractHrdVO.getCurrentRow().getAttribute("Version") == null ? 0 :
            Long.parseLong(contractHrdVO.getCurrentRow().getAttribute("Version").toString());

        String path = new File("").getAbsolutePath();
        System.err.println("path======>" + path);
        //        String basePath=path+cname+".xls";
        // JSFUtils.addFacesErrorMessage("=="+path);
        /* 8.43
            // 4500-16.87
            // 3500-12.96
               1000-3.91*/
        //        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        //        String startDate = "2018-01-09";
        //        String endDate = "2018-05-12";
        String startDate =
            contractHrdVO.getCurrentRow().getAttribute("StartDate").toString();
        String endDate =
            contractHrdVO.getCurrentRow().getAttribute("EndDate").toString();
        System.err.println(startDate);
        System.err.println(endDate);

        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime start = formatter.parseDateTime(startDate);
        DateTime end = formatter.parseDateTime(endDate);
        //        DateTime  = DateTime.parse(startDate, DateTimeFormat.forPattern("yyyy-MM-dd"));
        //        DateTime end = DateTime.parse(endDate, DateTimeFormat.forPattern("yyyy-MM-dd"));
        Period period = new Period(start, end, PeriodType.yearMonthDayTime());
        int months = period.getMonths();
        int days = period.getDays();
        int years = period.getYears();
        System.err.println("months : " + period.getMonths());
        System.err.println("days : " + period.getDays());
        System.err.println("years : " + years);
        long maxnum = 0;
        if (days > 0) {

            months = months + 1;
            maxnum = months + years * 12;

            System.err.println(maxnum);
        } else {
            maxnum = months + years * 12;
            System.err.println(maxnum);
        }
        //        long maxnum = maxLine(contractHrd, version);
        //        long maxnum = 10;

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Contract Delivery Plan");

        HSSFRow rowhead = sheet.createRow((short)0);
        rowhead.createCell(0).setCellValue("Contract Line Number");
        sheet.setColumnWidth(0, 4500);
        rowhead.createCell(1).setCellValue("Item Name");
        sheet.setColumnWidth(1, 4500);
        rowhead.createCell(2).setCellValue("Item Quantity");
        sheet.setColumnWidth(2, 4500);
        for (int j = 3; j <= maxnum + 2; j++) {
            sheet.setColumnWidth(j, 3500);
            int i = j - 2;
            rowhead.createCell(j).setCellValue(i);
        }
        // filter Contract Line
        contractLneVO.setNamedWhereClauseParam("BV_HRD", contractHrd);
        contractLneVO.setNamedWhereClauseParam("BV_VERSION", version);
        contractLneVO.executeQuery();
        if (contractLneVO.getEstimatedRowCount() != 0) {
            RowSetIterator rs = contractLneVO.createRowSetIterator(null);
            int excelRowData = 1;
            while (rs.hasNext()) {
                Row contractLineRow = rs.next();
                long linenumber =
                    contractLineRow.getAttribute("Linenumber") == null ? 0 :
                    Long.parseLong(contractLineRow.getAttribute("Linenumber").toString());
                //                long linenumber=contractLineRow.getAttribute("ContractLineNumber") == null ? 0 :Long.parseLong(contractLineRow.getAttribute("ContractLineNumber").toString());
                String ItemName =
                    contractLineRow.getAttribute("ItemDescription") == null ?
                    null :
                    contractLineRow.getAttribute("ItemDescription").toString();
                long quantity =
                    contractLineRow.getAttribute("OrigQuantity") == null ? 0 :
                    Long.parseLong(contractLineRow.getAttribute("OrigQuantity").toString());
                long lineid =
                    Long.parseLong(contractLineRow.getAttribute("ContLineId").toString());
                System.err.println("line number======" + linenumber +
                                   "=====line id=======" + lineid);
                HSSFRow row = sheet.createRow((short)excelRowData);
                row.createCell(0).setCellValue(linenumber);
                row.createCell(1).setCellValue(ItemName);
                row.createCell(2).setCellValue(quantity);
                // Line Qty
                contractLneQTYVO.setNamedWhereClauseParam("BV_HRD",
                                                          contractHrd);
                contractLneQTYVO.setNamedWhereClauseParam("BV_LNID", lineid);
                contractLneQTYVO.setNamedWhereClauseParam("BV_VERSION",
                                                          version);
                contractLneQTYVO.executeQuery();
                contractLneQTYVO.getEstimatedRowCount();
                System.err.println("Qty Count--" +
                                   contractLneQTYVO.getEstimatedRowCount());
                RowSetIterator qrs =
                    contractLneQTYVO.createRowSetIterator(null);
                int j = 3;
                while (qrs.hasNext()) {
                    Row lineRow = qrs.next();
                    long sno =
                        Long.parseLong(lineRow.getAttribute("Sno").toString());
                    long LineQty =
                        Long.parseLong(lineRow.getAttribute("Quantity").toString());
                    for (int i = 1; i <= maxnum; i++) {
                        if (i == sno) {
                            row.createCell(j).setCellValue(LineQty);
                            j++;
                        }
                    }
                }
                excelRowData++;
            }

            System.err.println("excelRowData======" + excelRowData);
        }


        FileOutputStream fileOut =
            new FileOutputStream(new File(cname + ".xls"));
        workbook.write(fileOut);
        fileOut.close();
        System.out.println("Your excel file has been generated!" + path);
        String filepath = path + "/" + cname + ".xls";
        System.err.println("--filepath--" + filepath);
        return path;

    }


    public static Long maxLine(Long contractHrd, Long version) {
        long lines = 0;
        ViewObject maxLineVO =
            ADFUtils.findIterator("MaxDeliveryLine1Iterator").getViewObject();
        maxLineVO.setNamedWhereClauseParam("BV_HRDID", contractHrd);
        maxLineVO.setNamedWhereClauseParam("BV_VERSION", version);
        maxLineVO.executeQuery();
        System.err.println("Line Count==" + maxLineVO.getEstimatedRowCount());
        if (maxLineVO.getEstimatedRowCount() == 1) {
            lines =
                    maxLineVO.first().getAttribute("Maxnumber") != null ? Long.parseLong(maxLineVO.first().getAttribute("Maxnumber").toString()) :
                    1;
        } else {
            lines = 0;
        }

        return lines;
    }

}
