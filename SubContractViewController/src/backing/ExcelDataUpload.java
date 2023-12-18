package backing;

import Utils.ADFUtils;

import Utils.JSFUtils;

import java.util.List;

import com.sun.el.parser.ParseException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.IOException;
import java.io.InputStream;

import java.text.DecimalFormat;

import java.util.ArrayList;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.myfaces.trinidad.model.CollectionModel;

import oracle.jbo.uicli.binding.JUCtrlHierBinding;


import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;


public class ExcelDataUpload {
    public ExcelDataUpload() {
        super();
    }

    ViewObject excelTaskVO =
        ADFUtils.findIterator("excelValidation_ProjectTaskROVO1Iterator").getViewObject();
    ViewObject excelPRVO =
        ADFUtils.findIterator("excelValidation_PRLineROVO1Iterator").getViewObject();
    ViewObject excelUOMVO =
        ADFUtils.findIterator("excelValidation_UOMROVO1Iterator").getViewObject();


    //    public String readExcelSellSheet(InputStream xlsx, RichTable t1, Object HrdID){
    //        String excelStatus="N";
    //        org.apache.poi.ss.usermodel.Workbook workbook = null;
    //        List<String> errorRows = new ArrayList<String>();
    //        String rowNum=null;
    //        int errorCount=0;
    //        int sheetIndex = 0;
    //        if(sheetIndex==0){
    //            CollectionModel cModel = (CollectionModel)t1.getValue();
    //            JUCtrlHierBinding tableBinding = (JUCtrlHierBinding)cModel.getWrappedData();
    //            DCIteratorBinding iter = tableBinding.getDCIteratorBinding();
    //            try {
    //                    workbook = WorkbookFactory.create(xlsx);
    //                } catch (Exception e) {
    //                    System.err.println("Exception in Line Workbook : " + e);
    //                }
    //            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(sheetIndex);
    //            Integer skipRw = 1;
    //            Integer skipcnt = 1;
    //            int columnCount = 0;
    //            Integer totalNumberofRows = 0;
    //            System.out.println("---Excel Row Count--"+sheet.getPhysicalNumberOfRows());
    //            //Iterate over excel rows
    //            for (org.apache.poi.ss.usermodel.Row tempRow : sheet){
    //                totalNumberofRows=sheet.getPhysicalNumberOfRows()-1;
    //                System.err.println("--Total Number of Rows in excel sheet"+totalNumberofRows);
    //                if (skipcnt == 1) {
    //                  columnCount = tempRow.getPhysicalNumberOfCells();
    //                  }
    //                if (skipcnt > skipRw) { //skip first row and start from 2 row .
    //                //Create new row in table
    //                ADFUtils.findOperation("CreateInsert").execute();
    //                System.err.println("New Line Row Added");
    //                oracle.jbo.Row linerow =iter.getNavigatableRowIterator().getCurrentRow();
    //
    //                int Index = 0; //Iterate over row's columns
    //                for (int column = 0; column < columnCount; column++) {
    //                    Cell MytempCell = tempRow.getCell(column);
    //                    if (MytempCell != null) {
    //                          Index = MytempCell.getColumnIndex();
    //                     } else {
    //                            //Index++;
    //                       }
    //                    try{
    //                        if(Index==0){
    //                            if(MytempCell!=null){
    //                                System.err.println("Index 0--Relation number");
    //                                    switch(MytempCell.getCellType()){
    //                                    case 1:
    //                                        linerow.setAttribute("ContHeaderId", HrdID);
    //                                        linerow.setAttribute("RelLineNumber", MytempCell.getStringCellValue());
    //                                        break;
    //                                    case 0:
    //                                        linerow.setAttribute("ContHeaderId", HrdID);
    //                                        linerow.setAttribute("RelLineNumber", MytempCell.getNumericCellValue());
    //                                    }
    //                            }else{
    //                                System.err.println("!!!!!!!!!Relation number is blank!!!!!!!!!");
    //                                if(rowNum==null){
    //                                     rowNum="Row: "+skipcnt;
    //                                     errorCount=errorCount+1;
    //                                }else{
    //                                     rowNum=rowNum+", Row: "+skipcnt;
    //                                     errorCount=errorCount+1;
    //                                     }
    //                            }
    //                        }else if(Index==1){
    //                            if(MytempCell!=null){
    //                                System.err.println("Index 1--Line number");
    //                                switch(MytempCell.getCellType()){
    //                                case 1:
    //                                    linerow.setAttribute("ContractLineNumber", MytempCell.getStringCellValue());
    //                                    break;
    //                                case 2:
    //                                    linerow.setAttribute("ContractLineNumber", MytempCell.getNumericCellValue());
    //                                    break;
    //                                }
    //
    //                            }else{
    //                                System.err.println("!!!!!!!!!Line number is blank!!!!!!!!!");
    //                                if(rowNum==null){
    //                                     rowNum="Row: "+skipcnt;
    //                                     errorCount=errorCount+1;
    //                                }else{
    //                                     rowNum=rowNum+", Row: "+skipcnt;
    //                                     errorCount=errorCount+1;
    //                                     }
    //                            }
    //                        }else if(Index==2){
    //                            if(MytempCell!=null){
    //                                System.err.println("Index 2--ProjectNumber");
    //                                switch(MytempCell.getCellType()){
    //                                case 1:
    //                                    linerow.setAttribute("ProjectNumber", MytempCell.getStringCellValue());
    //                                    break;
    //                                case 0:
    //                                    linerow.setAttribute("ProjectNumber", MytempCell.getNumericCellValue());
    //                                    break;
    //                                }
    //                                // Project Id
    //                            }else{
    //                                System.err.println("!!!!!!!!!ProjectNumber is blank!!!!!!!!!");
    //                                if(rowNum==null){
    //                                     rowNum="Row: "+skipcnt;
    //                                     errorCount=errorCount+1;
    //                                }else{
    //                                     rowNum=rowNum+", Row: "+skipcnt;
    //                                     errorCount=errorCount+1;
    //                                 }
    //                            }
    //                        }else if(Index==3){
    //                            if(MytempCell!=null){
    //                                switch(MytempCell.getCellType()){
    //                                case 1:
    //                                    linerow.setAttribute("TaskNumber", MytempCell.getStringCellValue());
    //                                    break;
    //                                case 0:
    //                                    linerow.setAttribute("TaskNumber", MytempCell.getNumericCellValue());
    //                                    break;
    //                                }
    //                                // task Id
    //
    //                            }else{
    //                                System.err.println("!!!!!!!!!Task number is blank!!!!!!!!!");
    //                                if(rowNum==null){
    //                                     rowNum="Row: "+skipcnt;
    //                                     errorCount=errorCount+1;
    //                                }else{
    //                                     rowNum=rowNum+", Row: "+skipcnt;
    //                                     errorCount=errorCount+1;
    //                                 }
    //                            }
    //                        }else if(Index==4){
    //                            if(MytempCell!=null){
    //                                switch(MytempCell.getCellType()){
    //                                case 1:
    //                                    linerow.setAttribute("ItemNumber", MytempCell.getStringCellValue());
    //                                    break;
    //                                case 0:
    //                                    linerow.setAttribute("ItemNumber", MytempCell.getNumericCellValue());
    //                                    break;
    //                                }
    //                                // Item Code
    //                            }else{
    //                                System.err.println("!!!!!!!!!Task number is blank!!!!!!!!!");
    //                                if(rowNum==null){
    //                                     rowNum="Row: "+skipcnt;
    //                                     errorCount=errorCount+1;
    //                                }else{
    //                                     rowNum=rowNum+", Row: "+skipcnt;
    //                                     errorCount=errorCount+1;
    //                                 }
    //                            }
    //                        }else if(Index==5){
    //                            if(MytempCell!=null){
    //                                switch(MytempCell.getCellType()){
    //                                case 1:
    //                                    linerow.setAttribute("ItemDescription", MytempCell.getStringCellValue());
    //                                    break;
    //                                case 0:
    //                                    linerow.setAttribute("ItemDescription", MytempCell.getNumericCellValue());
    //                                    break;
    //                                }
    //                                // Item Description
    //
    //                            }else{
    //                                System.err.println("!!!!!!!!!Item Description is blank!!!!!!!!!");
    //                                if(rowNum==null){
    //                                     rowNum="Row: "+skipcnt;
    //                                     errorCount=errorCount+1;
    //                                }else{
    //                                     rowNum=rowNum+", Row: "+skipcnt;
    //                                     errorCount=errorCount+1;
    //                                 }
    //                            }
    //                        }else if(Index==6){
    //                            if(MytempCell!=null){
    //                                switch(MytempCell.getCellType()){
    //                                case 1:
    //                                    linerow.setAttribute("CategoryId", null);
    //                                    break;
    //                                case 0:
    //                                    linerow.setAttribute("CategoryId", 0);
    //                                    break;
    //                                }
    ////                                category name
    //                            // Category Id need to store
    //
    //                            }else{
    //                                System.err.println("!!!!!!!!!Category Name is blank!!!!!!!!!");
    //                                if(rowNum==null){
    //                                     rowNum="Row: "+skipcnt;
    //                                     errorCount=errorCount+1;
    //                                }else{
    //                                     rowNum=rowNum+", Row: "+skipcnt;
    //                                     errorCount=errorCount+1;
    //                                 }
    //                            }
    //                        }else if(Index==7){
    //                            if(MytempCell!=null){
    //                                switch(MytempCell.getCellType()){
    //                                case 1:
    //                                    linerow.setAttribute("ItemSpec", MytempCell.getStringCellValue());
    //                                    break;
    //                                case 0:
    //                                    linerow.setAttribute("ItemSpec", MytempCell.getNumericCellValue());
    //                                    break;
    //                                }
    //
    //                            }else{
    //                                System.err.println("!!!!!!!!!ItemSpec is blank!!!!!!!!!");
    //                                if(rowNum==null){
    //                                     rowNum="Row: "+skipcnt;
    //                                     errorCount=errorCount+1;
    //                                }else{
    //                                     rowNum=rowNum+", Row: "+skipcnt;
    //                                     errorCount=errorCount+1;
    //                                 }
    //                            }
    //                        }else if(Index==8){
    //                            if(MytempCell!=null){
    ////                                UOM
    //                                switch(MytempCell.getCellType()){
    //                                case 1:
    //                                    linerow.setAttribute("Uom", MytempCell.getStringCellValue());
    //                                    break;
    //                                case 0:
    //                                    linerow.setAttribute("Uom", MytempCell.getNumericCellValue());
    //                                    break;
    //                                }
    //                            }else{
    //                                System.err.println("!!!!!!!!!UOM is blank!!!!!!!!!");
    //                                if(rowNum==null){
    //                                     rowNum="Row: "+skipcnt;
    //                                     errorCount=errorCount+1;
    //                                }else{
    //                                     rowNum=rowNum+", Row: "+skipcnt;
    //                                     errorCount=errorCount+1;
    //                                 }
    //                            }
    //                        }else if(Index==9){
    //                            if(MytempCell!=null){
    ////                            // Qty
    //                                switch(MytempCell.getCellType()){
    //                                case 1:
    //                                    linerow.setAttribute("OrigQuantity", Double.parseDouble(MytempCell.getStringCellValue().toString()));
    //                                    break;
    //
    //                                case 0:
    //                                    linerow.setAttribute("OrigQuantity", MytempCell.getNumericCellValue());
    //                                    break;
    //                                }
    //
    //                            }else{
    //                                System.err.println("!!!!!!!!!Qty is blank!!!!!!!!!");
    //                                if(rowNum==null){
    //                                     rowNum="Row: "+skipcnt;
    //                                     errorCount=errorCount+1;
    //                                }else{
    //                                     rowNum=rowNum+", Row: "+skipcnt;
    //                                     errorCount=errorCount+1;
    //                                 }
    //                            }
    //                        }else if(Index==10){
    //                            if(MytempCell!=null){
    //                                switch(MytempCell.getCellType()){
    //                                case 1:
    //                                    linerow.setAttribute("OrigUnitPrice", Double.parseDouble(MytempCell.getStringCellValue().toString()));
    //                                    break;
    //                                case 0:
    //                                    linerow.setAttribute("OrigUnitPrice", MytempCell.getNumericCellValue());
    //                                    break;
    //                                }
    //                                // Price
    //
    //                                double qty=linerow.getAttribute("OrigQuantity")==null?0:Double.parseDouble(linerow.getAttribute("OrigQuantity").toString());
    //                                double prz=linerow.getAttribute("OrigUnitPrice")==null?0:Double.parseDouble(linerow.getAttribute("OrigUnitPrice").toString());
    //                                double amt=qty*prz;
    //                                linerow.setAttribute("OrigAmount", amt);
    //                            }else{
    //                                System.err.println("!!!!!!!!!Price is blank!!!!!!!!!");
    //                                if(rowNum==null){
    //                                     rowNum="Row: "+skipcnt;
    //                                     errorCount=errorCount+1;
    //                                }else{
    //                                     rowNum=rowNum+", Row: "+skipcnt;
    //                                     errorCount=errorCount+1;
    //                                 }
    //                            }
    //                        }
    //                    }catch (Exception e){
    //                        e.printStackTrace();
    //                    }
    //                }// one row completed
    //            }////skip first n row for labels.
    //
    //            if(totalNumberofRows>=skipcnt){
    //                  skipcnt++;
    //                }
    //            System.err.println("Sheet ROW--"+skipcnt);
    //            }
    //
    //        }
    //
    //        if(errorCount!=0){
    //            JSFUtils.addFacesErrorMessage("Please provide correct values in "+rowNum);
    //        }
    //        AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
    //        JSFUtils.addFacesInformationMessage("Line Added Successfully");
    //        excelStatus="Y";
    //
    //        return excelStatus;
    //    }
    DecimalFormat df = new DecimalFormat("######");
    DecimalFormat dfNum = new DecimalFormat("######.##");
    //*******************************************************************
    //**********BILL NO & PAGE NO & ITEM NO**************************
    //*******************************************************************

    public String readExcelWithBill(InputStream xlsx, RichTable t1,
                                    Object HrdID) {
        org.apache.poi.ss.usermodel.Workbook workbook = null;
        //        List<String> errorRows = new ArrayList<String>();
        //        String rowNum=null;
        String excelStatus = "N";
        //        int errorCount=0;
        int sheetIndex = 0;
        if (sheetIndex == 0) {
            CollectionModel cModel = (CollectionModel)t1.getValue();
            JUCtrlHierBinding tableBinding =
                (JUCtrlHierBinding)cModel.getWrappedData();
            DCIteratorBinding iter = tableBinding.getDCIteratorBinding();
            try {
                workbook = WorkbookFactory.create(xlsx);
            } catch (Exception e) {
                System.err.println("Exception in Line Workbook : " + e);
            }
            org.apache.poi.ss.usermodel.Sheet sheet =
                workbook.getSheetAt(sheetIndex);
            Integer skipRw = 1;
            Integer skipcnt = 1;
            int columnCount = 0;
            Integer totalNumberofRows = 0;
            System.out.println("Excel Total Number of Column ==>" +
                               sheet.getRow(0).getLastCellNum());
            System.out.println("---Excel Total Row Count ==>" +
                               sheet.getLastRowNum());
            //            System.out.println("---Excel Total Row Count ==>"+sheet.getPhysicalNumberOfRows());
            // Total No .of Rows
            //           totalNumberofRows=sheet.getPhysicalNumberOfRows()-1;
            totalNumberofRows = sheet.getLastRowNum();
            System.out.println("--Total Number of Rows in excel sheet==>>" +
                               totalNumberofRows);
            //Iterate over excel rows
            for (org.apache.poi.ss.usermodel.Row tempRow : sheet) {
                //
                if (skipcnt == 1) {
                    columnCount = tempRow.getPhysicalNumberOfCells();
                    System.err.println("==Column Count==>" + columnCount);
                }
                //skip first row and start from 2 row .3 row.4 row..5 row..?
                if (skipcnt > skipRw) {
                    System.err.println("skipcnt---skipRw" + skipcnt + "---" +
                                       skipRw);
                    //Create new row in table
                    ADFUtils.findOperation("CreateInsert").execute();
                    System.err.println("New Line Adding");
                    oracle.jbo.Row linerow =
                        iter.getNavigatableRowIterator().getCurrentRow();

                    int Index = 0;
                    //Iterate over (1 row's) columns
                    for (int column = 0; column < columnCount; column++) {
                        // Get column and it's cell
                        Cell MytempCell = tempRow.getCell(column);
                        if (MytempCell != null) {
                            Index = MytempCell.getColumnIndex();
                        } else {
                            //Index++;
                        }
                        // checking Index
                        try {
                            if (Index == 0) {
                                if (MytempCell != null) {
                                    //                              System.out.println("getCellType 0===>>"+MytempCell.getCellType());
                                    switch (MytempCell.getCellType()) {
                                    case 1:
                                        //                                            linerow.setAttribute("ContHeaderId", HrdID);
                                        linerow.setAttribute("Variation",
                                                             MytempCell.getStringCellValue());
                                        break;
                                    case 0:
                                        //                                            linerow.setAttribute("ContHeaderId", HrdID);
                                        linerow.setAttribute("Variation",
                                                             MytempCell.getStringCellValue());
                                    }
                                    System.err.println("=variation=0==>" +
                                                       linerow.getAttribute("Variation"));
                                }
                            } else if (Index == 1) {
                                if (MytempCell != null) {
                                    //                              System.out.println("getCellType 0===>>"+MytempCell.getCellType());
                                    switch (MytempCell.getCellType()) {
                                    case 1:
                                        linerow.setAttribute("ContHeaderId",
                                                             HrdID);
                                        linerow.setAttribute("RelLineNumber",
                                                             MytempCell.getStringCellValue());
                                        break;
                                    case 0:
                                        linerow.setAttribute("ContHeaderId",
                                                             HrdID);
                                        linerow.setAttribute("RelLineNumber",
                                                             dfNum.format(MytempCell.getNumericCellValue()));
                                    }
                                    System.err.println("=RelLineNumber=0==>" +
                                                       linerow.getAttribute("RelLineNumber"));
                                }
                            } else if (Index == 2) {
                                if (MytempCell != null) {
                                    //                                      System.out.println("getCellType 1===>>"+MytempCell.getCellType());
                                    switch (MytempCell.getCellType()) {
                                    case 1:
                                        linerow.setAttribute("ContractLineNumber",
                                                             MytempCell.getStringCellValue());
                                        break;
                                    case 0:
                                        linerow.setAttribute("ContractLineNumber",
                                                             dfNum.format(MytempCell.getNumericCellValue()));
                                        break;
                                    }
                                    System.err.println("=ContractLineNumber=1==>" +
                                                       linerow.getAttribute("ContractLineNumber"));
                                }
                            } else if (Index == 3) {
                                if (MytempCell != null) {
                                    //    System.out.println("getCellType 3===>>"+MytempCell.getCellType());
                                    switch (MytempCell.getCellType()) {
                                    case 1:
                                        linerow.setAttribute("ContLineBillDtls",
                                                             MytempCell.getStringCellValue());
                                        break;
                                    case 0:
                                        linerow.setAttribute("ContLineBillDtls",
                                                             dfNum.format(MytempCell.getNumericCellValue()));
                                        break;
                                    }
                                    System.err.println("=ContLineBillDtls=7==>" +
                                                       linerow.getAttribute("ContLineBillDtls"));
                                }
                            } else if (Index == 4) {
                                if (MytempCell != null) {
                                    //    System.out.println("getCellType 3===>>"+MytempCell.getCellType());
                                    switch (MytempCell.getCellType()) {
                                    case 1:
                                        linerow.setAttribute("ContLineItemNo",
                                                             MytempCell.getStringCellValue());
                                        break;
                                    case 0:
                                        linerow.setAttribute("ContLineItemNo",
                                                             dfNum.format(MytempCell.getNumericCellValue()));
                                        break;
                                    }
                                    System.err.println("=ContLineItemNo=7==>" +
                                                       linerow.getAttribute("ContLineItemNo"));
                                }
                            } else if (Index == 5) {
                                if (MytempCell != null) {
                                    //                                      System.out.println("getCellType 2===>>"+MytempCell.getCellType());
                                    switch (MytempCell.getCellType()) {
                                    case 1:
                                        linerow.setAttribute("ItemDescription",
                                                             MytempCell.getStringCellValue());
                                        break;
                                    case 0:
                                        linerow.setAttribute("ItemDescription",
                                                             df.format(MytempCell.getNumericCellValue()));
                                        break;
                                    }
                                    System.err.println("=ItemDescription=2==>" +
                                                       linerow.getAttribute("ItemDescription"));
                                }
                            } else if (Index == 6) {
                                if (MytempCell != null) {
                                    //                                      System.out.println("getCellType 3===>>"+MytempCell.getCellType());
                                    switch (MytempCell.getCellType()) {
                                    case 1:
                                        linerow.setAttribute("Uom",
                                                             MytempCell.getStringCellValue());
                                        break;
                                    case 0:
                                        linerow.setAttribute("Uom",
                                                             df.format(MytempCell.getNumericCellValue()));
                                        break;
                                    }

                                    System.err.println("=Uom=3==>" +
                                                       linerow.getAttribute("Uom"));
                                }
                            } else if (Index == 7) {
                                if (MytempCell != null) {
                                    //        // Qty
                                    //                                    System.out.println("getCellType 9===>>"+MytempCell.getCellType());
                                    switch (MytempCell.getCellType()) {
                                    case 1:
                                        linerow.setAttribute("OrigQuantity",
                                                             Double.parseDouble(MytempCell.getStringCellValue().toString()));
                                        break;
                                    case 0:
                                        linerow.setAttribute("OrigQuantity",
                                                             MytempCell.getNumericCellValue());
                                        break;
                                    }
                                    System.err.println("=OrigQuantity=4==>" +
                                                       linerow.getAttribute("OrigQuantity"));
                                }
                            } else if (Index == 8) {
                                if (MytempCell != null) {
                                    //                                    System.out.println("getCellType 10===>>"+MytempCell.getCellType());
                                    switch (MytempCell.getCellType()) {
                                    case 1:
                                        linerow.setAttribute("OrigUnitPrice",
                                                             Double.parseDouble(MytempCell.getStringCellValue().toString()));
                                        break;
                                    case 0:
                                        linerow.setAttribute("OrigUnitPrice",
                                                             MytempCell.getNumericCellValue());
                                        break;
                                    }
                                    // Price
                                    System.err.println("=OrigUnitPrice=5==>" +
                                                       linerow.getAttribute("OrigUnitPrice"));
                                    double qty =
                                        linerow.getAttribute("OrigQuantity") ==
                                        null ? 0 :
                                        Double.parseDouble(linerow.getAttribute("OrigQuantity").toString());
                                    double prz =
                                        linerow.getAttribute("OrigUnitPrice") ==
                                        null ? 0 :
                                        Double.parseDouble(linerow.getAttribute("OrigUnitPrice").toString());
                                    double amt = qty * prz;
                                    linerow.setAttribute("OrigAmount", amt);
                                    linerow.setAttribute("EcpTotalAmount",
                                                         amt);
                                }
                            } else if (Index == 10) {
                                if (MytempCell != null) {
                                    //    System.out.println("getCellType 3===>>"+MytempCell.getCellType());
                                    switch (MytempCell.getCellType()) {
                                    case 1:
                                        linerow.setAttribute("TaskNumber",
                                                             MytempCell.getStringCellValue());
                                        break;
                                    case 0:
                                        linerow.setAttribute("TaskNumber",
                                                             dfNum.format(MytempCell.getNumericCellValue()));
                                        break;
                                    }
                                }
                            } else if (Index == 11) {
                                if (MytempCell != null) {
                                    //    System.out.println("getCellType 3===>>"+MytempCell.getCellType());
                                    switch (MytempCell.getCellType()) {
                                    case 1:
                                        linerow.setAttribute("LineAmtRemark",
                                                             MytempCell.getStringCellValue());
                                        break;
                                    case 0:
                                        linerow.setAttribute("LineAmtRemark",
                                                             dfNum.format(MytempCell.getNumericCellValue()));
                                        break;
                                    }
                                }
                            } else if (Index == 12) {
                                if (MytempCell != null) {
                                    //    System.out.println("getCellType 3===>>"+MytempCell.getCellType());
                                    switch (MytempCell.getCellType()) {
                                    case 1:
                                        linerow.setAttribute("ContLinePageNo",
                                                             MytempCell.getStringCellValue());
                                        break;
                                    case 0:
                                        linerow.setAttribute("ContLinePageNo",
                                                             dfNum.format(MytempCell.getNumericCellValue()));
                                        break;
                                    }
                                }
                            } else if (Index == 9) {
                                if (MytempCell != null) {
                                    switch (MytempCell.getCellType()) {
                                    case 1:
                                        linerow.setAttribute("ProjectNumber",
                                                             MytempCell.getStringCellValue());
                                        linerow.setAttribute("ProjectId",
                                                             null);
                                        break;
                                    case 0:
                                        linerow.setAttribute("ProjectNumber",
                                                             dfNum.format(MytempCell.getNumericCellValue()));
                                        linerow.setAttribute("ProjectId",
                                                             null);
                                        break;
                                    }
                                    System.err.println("=ProjectNumber=6==>" +
                                                       linerow.getAttribute("ProjectNumber"));
                                }
                            }
                        } catch (Exception e) {
                            System.err.println("Exception Occured at Line & column position is.... " +
                                               Index);
                            e.printStackTrace();
                        }
                        // one row completed
                    }
                    ////skip first n row for labels.
                }
                if (totalNumberofRows >= skipcnt) {
                    skipcnt++;
                }
                System.err.println("Sheet ROW--" + skipcnt);
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
            JSFUtils.addFacesInformationMessage("Line Added Successfully");
            ADFUtils.findOperation("Commit").execute();
            excelStatus = "Y";
        }
        return excelStatus;
    }

    //*******************************************************************
    //******************* NARESCO*********************************
    //*******************************************************************

    public String readExcel(InputStream xlsx, RichTable t1, Object HrdID) {
        org.apache.poi.ss.usermodel.Workbook workbook = null;
        //        List<String> errorRows = new ArrayList<String>();
        //        String rowNum=null;
        String excelStatus = "N";
        //        int errorCount=0;
        int sheetIndex = 0;
        if (sheetIndex == 0) {
            CollectionModel cModel = (CollectionModel)t1.getValue();
            JUCtrlHierBinding tableBinding =
                (JUCtrlHierBinding)cModel.getWrappedData();
            DCIteratorBinding iter = tableBinding.getDCIteratorBinding();
            try {
                workbook = WorkbookFactory.create(xlsx);
            } catch (Exception e) {
                System.err.println("Exception in Line Workbook : " + e);
            }
            org.apache.poi.ss.usermodel.Sheet sheet =
                workbook.getSheetAt(sheetIndex);
            Integer skipRw = 1;
            Integer skipcnt = 1;
            int columnCount = 0;
            Integer totalNumberofRows = 0;
            System.out.println("Excel Total Number of Column ==>" +
                               sheet.getRow(0).getLastCellNum());
            System.out.println("---Excel Total Row Count ==>" +
                               sheet.getLastRowNum());
            //            System.out.println("---Excel Total Row Count ==>"+sheet.getPhysicalNumberOfRows());
            // Total No .of Rows
            //           totalNumberofRows=sheet.getPhysicalNumberOfRows()-1;
            totalNumberofRows = sheet.getLastRowNum();
            System.out.println("--Total Number of Rows in excel sheet==>>" +
                               totalNumberofRows);
            //Iterate over excel rows
            for (org.apache.poi.ss.usermodel.Row tempRow : sheet) {
                //
                if (skipcnt == 1) {
                    columnCount = tempRow.getPhysicalNumberOfCells();
                    System.err.println("==Column Count==>" + columnCount);
                }
                //skip first row and start from 2 row .3 row.4 row..5 row..?
                if (skipcnt > skipRw) {
                    System.err.println("skipcnt---skipRw" + skipcnt + "---" +
                                       skipRw);
                    //Create new row in table
                    ADFUtils.findOperation("CreateInsert").execute();
                    System.err.println("New Line Adding");
                    oracle.jbo.Row linerow =
                        iter.getNavigatableRowIterator().getCurrentRow();

                    int Index = 0;
                    //Iterate over (1 row's) columns
                    for (int column = 0; column < columnCount; column++) {
                        // Get column and it's cell
                        Cell MytempCell = tempRow.getCell(column);
                        if (MytempCell != null) {
                            Index = MytempCell.getColumnIndex();
                        } else {
                            //Index++;
                        }
                        // checking Index
                        try {
                            if (Index == 0) {
                                if (MytempCell != null) {
                                    //                              System.out.println("getCellType 0===>>"+MytempCell.getCellType());
                                    switch (MytempCell.getCellType()) {
                                    case 1:
                                        //                                            linerow.setAttribute("ContHeaderId", HrdID);
                                        linerow.setAttribute("Variation",
                                                             MytempCell.getStringCellValue());
                                        break;
                                    case 0:
                                        //                                            linerow.setAttribute("ContHeaderId", HrdID);
                                        linerow.setAttribute("Variation",
                                                             MytempCell.getStringCellValue());
                                    }
                                    System.err.println("=variation=0==>" +
                                                       linerow.getAttribute("Variation"));
                                } else {
                                    System.err.println("!!!!!!!!!Variation is blank!!!!!!!!!");
                                    //                                  if(rowNum==null){
                                    //                                  rowNum="Row: "+skipcnt;
                                    //                                  errorCount=errorCount+1;
                                    //                                  }else{
                                    //                                  rowNum=rowNum+", Row: "+skipcnt;
                                    //                                  errorCount=errorCount+1;
                                    //                                  }
                                }
                            } else if (Index == 1) {
                                if (MytempCell != null) {
                                    //                              System.out.println("getCellType 0===>>"+MytempCell.getCellType());
                                    switch (MytempCell.getCellType()) {
                                    case 1:
                                        linerow.setAttribute("ContHeaderId",
                                                             HrdID);
                                        linerow.setAttribute("RelLineNumber",
                                                             MytempCell.getStringCellValue());
                                        break;
                                    case 0:
                                        linerow.setAttribute("ContHeaderId",
                                                             HrdID);
                                        linerow.setAttribute("RelLineNumber",
                                                             dfNum.format(MytempCell.getNumericCellValue()));
                                    }
                                    System.err.println("=RelLineNumber=0==>" +
                                                       linerow.getAttribute("RelLineNumber"));
                                } else {
                                    System.err.println("!!!!!!!!!Relation number is blank!!!!!!!!!");
                                    //                                  if(rowNum==null){
                                    //                                  rowNum="Row: "+skipcnt;
                                    //                                  errorCount=errorCount+1;
                                    //                                  }else{
                                    //                                  rowNum=rowNum+", Row: "+skipcnt;
                                    //                                  errorCount=errorCount+1;
                                    //                                  }
                                }
                            } else if (Index == 2) {
                                if (MytempCell != null) {
                                    //                                      System.out.println("getCellType 1===>>"+MytempCell.getCellType());
                                    switch (MytempCell.getCellType()) {
                                    case 1:
                                        linerow.setAttribute("ContractLineNumber",
                                                             MytempCell.getStringCellValue());
                                        break;
                                    case 0:
                                        linerow.setAttribute("ContractLineNumber",
                                                             dfNum.format(MytempCell.getNumericCellValue()));
                                        break;
                                    }
                                    System.err.println("=ContractLineNumber=1==>" +
                                                       linerow.getAttribute("ContractLineNumber"));
                                } else {
                                    System.err.println("!!!!!!!!!Line number is blank!!!!!!!!!");
                                    //                                      if(rowNum==null){
                                    //                                      rowNum="Row: "+skipcnt;
                                    //                                      errorCount=errorCount+1;
                                    //                                      }else{
                                    //                                      rowNum=rowNum+", Row: "+skipcnt;
                                    //                                      errorCount=errorCount+1;
                                    //                                      }
                                }
                            } else if (Index == 3) {
                                if (MytempCell != null) {
                                    //                                      System.out.println("getCellType 2===>>"+MytempCell.getCellType());
                                    switch (MytempCell.getCellType()) {
                                    case 1:
                                        linerow.setAttribute("ItemDescription",
                                                             MytempCell.getStringCellValue());
                                        break;
                                    case 0:
                                        linerow.setAttribute("ItemDescription",
                                                             df.format(MytempCell.getNumericCellValue()));
                                        break;
                                    }
                                    System.err.println("=ItemDescription=2==>" +
                                                       linerow.getAttribute("ItemDescription"));
                                } else {
                                    System.err.println("!!!!!!!!!ProjectNumber is blank!!!!!!!!!");
                                    //                                      if(rowNum==null){
                                    //                                      rowNum="Row: "+skipcnt;
                                    //                                      errorCount=errorCount+1;
                                    //                                      }else{
                                    //                                      rowNum=rowNum+", Row: "+skipcnt;
                                    //                                      errorCount=errorCount+1;
                                    //                                      }
                                }
                            } else if (Index == 4) {
                                if (MytempCell != null) {
                                    //                                      System.out.println("getCellType 3===>>"+MytempCell.getCellType());
                                    switch (MytempCell.getCellType()) {
                                    case 1:
                                        linerow.setAttribute("Uom",
                                                             MytempCell.getStringCellValue());
                                        break;
                                    case 0:
                                        linerow.setAttribute("Uom",
                                                             df.format(MytempCell.getNumericCellValue()));
                                        break;
                                    }

                                    System.err.println("=Uom=3==>" +
                                                       linerow.getAttribute("Uom"));
                                } else {
                                    System.err.println("!!!!!!!!!UOM is blank!!!!!!!!!");
                                    //                                      if(rowNum==null){
                                    //                                      rowNum="Row: "+skipcnt;
                                    //                                      errorCount=errorCount+1;
                                    //                                      }else{
                                    //                                      rowNum=rowNum+", Row: "+skipcnt;
                                    //                                      errorCount=errorCount+1;
                                    //                                      }
                                }
                            } else if (Index == 5) {
                                if (MytempCell != null) {
                                    //        // Qty
                                    //                                    System.out.println("getCellType 9===>>"+MytempCell.getCellType());
                                    switch (MytempCell.getCellType()) {
                                    case 1:
                                        linerow.setAttribute("OrigQuantity",
                                                             Double.parseDouble(MytempCell.getStringCellValue().toString()));
                                        break;
                                    case 0:
                                        linerow.setAttribute("OrigQuantity",
                                                             df.format(MytempCell.getNumericCellValue()));
                                        break;
                                    }
                                    System.err.println("=OrigQuantity=4==>" +
                                                       linerow.getAttribute("OrigQuantity"));
                                } else {
                                    System.err.println("!!!!!!!!!Qty is blank!!!!!!!!!");
                                    //                                    if(rowNum==null){
                                    //                                    rowNum="Row: "+skipcnt;
                                    //                                    errorCount=errorCount+1;
                                    //                                    }else{
                                    //                                    rowNum=rowNum+", Row: "+skipcnt;
                                    //                                    errorCount=errorCount+1;
                                    //                                    }
                                }
                            } else if (Index == 6) {
                                if (MytempCell != null) {
                                    //                                    System.out.println("getCellType 10===>>"+MytempCell.getCellType());
                                    switch (MytempCell.getCellType()) {
                                    case 1:
                                        linerow.setAttribute("OrigUnitPrice",
                                                             Double.parseDouble(MytempCell.getStringCellValue().toString()));
                                        break;
                                    case 0:
                                        linerow.setAttribute("OrigUnitPrice",
                                                             df.format(MytempCell.getNumericCellValue()));
                                        break;
                                    }
                                    // Price
                                    System.err.println("=OrigUnitPrice=5==>" +
                                                       linerow.getAttribute("OrigUnitPrice"));
                                    double qty =
                                        linerow.getAttribute("OrigQuantity") ==
                                        null ? 0 :
                                        Double.parseDouble(linerow.getAttribute("OrigQuantity").toString());
                                    double prz =
                                        linerow.getAttribute("OrigUnitPrice") ==
                                        null ? 0 :
                                        Double.parseDouble(linerow.getAttribute("OrigUnitPrice").toString());
                                    double amt = qty * prz;
                                    linerow.setAttribute("OrigAmount", amt);
                                    linerow.setAttribute("EcpTotalAmount",
                                                         amt);
                                } else {
                                    System.err.println("!!!!!!!!!Price is blank!!!!!!!!!");
                                    //                                      if(rowNum==null){
                                    //                                      rowNum="Row: "+skipcnt;
                                    //                                      errorCount=errorCount+1;
                                    //                                      }else{
                                    //                                      rowNum=rowNum+", Row: "+skipcnt;
                                    //                                      errorCount=errorCount+1;
                                    //                                      }
                                }
                            } else if (Index == 7) {
                                if (MytempCell != null) {
                                    switch (MytempCell.getCellType()) {
                                    case 1:
                                        linerow.setAttribute("ProjectNumber",
                                                             MytempCell.getStringCellValue());
                                        linerow.setAttribute("ProjectId",
                                                             null);
                                        break;
                                    case 0:
                                        linerow.setAttribute("ProjectNumber",
                                                             dfNum.format(MytempCell.getNumericCellValue()));
                                        linerow.setAttribute("ProjectId",
                                                             null);
                                        break;
                                    }
                                    System.err.println("=ProjectNumber=6==>" +
                                                       linerow.getAttribute("ProjectNumber"));
                                } else {
                                    System.err.println("*********Project number is blank*********");
                                    // if(rowNum==null){
                                    // rowNum="Row: "+skipcnt;
                                    // errorCount=errorCount+1;
                                    // }else{
                                    // rowNum=rowNum+", Row: "+skipcnt;
                                    //  errorCount=errorCount+1;
                                    //  }
                                }
                            } else if (Index == 8) {
                                if (MytempCell != null) {
                                    //    System.out.println("getCellType 3===>>"+MytempCell.getCellType());
                                    switch (MytempCell.getCellType()) {
                                    case 1:
                                        linerow.setAttribute("TaskNumber",
                                                             MytempCell.getStringCellValue());
                                        break;
                                    case 0:
                                        linerow.setAttribute("TaskNumber",
                                                             dfNum.format(MytempCell.getNumericCellValue()));
                                        break;
                                    }
                                    System.err.println("=TaskNumber=7==>" +
                                                       linerow.getAttribute("TaskNumber"));
                                } else {
                                    System.err.println("!!!!!!!!!Task number is blank!!!!!!!!!");
                                    //  if(rowNum==null){
                                    //  rowNum="Row: "+skipcnt;
                                    //  errorCount=errorCount+1;
                                    //  }else{
                                    //  rowNum=rowNum+", Row: "+skipcnt;
                                    //  errorCount=errorCount+1;
                                    //  }
                                }
                            }

                        } catch (Exception e) {
                            System.err.println("Exception Occured at Line & column position is.... " +
                                               Index);
                            e.printStackTrace();
                        }
                        // one row completed
                    }
                    ////skip first n row for labels.
                }

                //                String errorStr=ADFContext.getCurrent().getSessionScope().get("error")==null?"":ADFContext.getCurrent().getSessionScope().get("error").toString();
                //                if("error".equalsIgnoreCase(errorStr)){
                //                    errorRows.add(skipcnt+",");
                //                }
                if (totalNumberofRows >= skipcnt) {
                    skipcnt++;
                }
                System.err.println("Sheet ROW--" + skipcnt);
            }
            /*
                    for (String temp : errorRows) {
                        System.out.println("Error ROw---"+temp);
                        JSFUtils.addFacesErrorMessage("Please provide correct values in Row "+temp);
                    }
               */
            //            if(errorCount!=0){
            //                JSFUtils.addFacesErrorMessage("Please provide correct values in "+rowNum);
            //            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
            JSFUtils.addFacesInformationMessage("Line Added Successfully");
            ADFUtils.findOperation("Commit").execute();
            excelStatus = "Y";
        }
        return excelStatus;
    }

    public String readExcelSellSheet(InputStream xlsx, RichTable t1,
                                     Object HrdID) throws IOException,
                                                          InvalidFormatException,
                                                          ParseException {
        String str = "";
        //
        str = readExcelWithBill(xlsx, t1, HrdID);
        // NARESCO
        //        str=readExcel(xlsx,t1,HrdID);
        return str;
    }
}








/*
    public String readExcelSheet(InputStream xlsx, RichTable t1, Object ProjectId, Object prHID, Object prLineNumber) throws IOException,InvalidFormatException,ParseException {
        org.apache.poi.ss.usermodel.Workbook workbook = null;
        List<String> errorRows = new ArrayList<String>();
        String rowNum=null;
        String excelStatus="N";
        int errorCount=0;
        int sheetIndex = 0;  
        if (sheetIndex == 0) {
            CollectionModel cModel = (CollectionModel)t1.getValue();
            JUCtrlHierBinding tableBinding = (JUCtrlHierBinding)cModel.getWrappedData();        
            DCIteratorBinding iter = tableBinding.getDCIteratorBinding();
            try {  
                   workbook = WorkbookFactory.create(xlsx);
                 } catch (Exception e) {
                        System.err.println("Exception in Line Workbook : " + e);
                 }
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(sheetIndex);
            Integer skipRw = 1;
            Integer skipcnt = 1;
            int columnCount = 0;
            Integer totalNumberofRows = 0;
            System.out.println("---Excel Row Count--"+sheet.getPhysicalNumberOfRows());
            //Iterate over excel rows
            for (org.apache.poi.ss.usermodel.Row tempRow : sheet) {
              totalNumberofRows=sheet.getPhysicalNumberOfRows()-1;
                System.err.println("--Total Number of Rows in excel sheet"+totalNumberofRows);
                if (skipcnt == 1) {
                      columnCount = tempRow.getPhysicalNumberOfCells();
                  }
                if (skipcnt > skipRw) { //skip first row and start from 2 row .
                
                //Create new row in table
                    ADFUtils.findOperation("CreateInsert").execute();
                    System.err.println("New Line Row Added");
                    oracle.jbo.Row linerow =iter.getNavigatableRowIterator().getCurrentRow();            
                
                int Index = 0; //Iterate over row's columns
                for (int column = 0; column < columnCount; column++) {
                Cell MytempCell = tempRow.getCell(column);
                    if (MytempCell != null) {
                            Index = MytempCell.getColumnIndex();
                       } else {
                             //Index++;
                             }
                    try {
                        if (Index == 0) {
                                   if (MytempCell != null){
                                          System.err.println("Index 0--PR LINE" + MytempCell.getNumericCellValue());
                                          ViewObjectImpl vo =(ViewObjectImpl)excelPRVO;
                                          ViewCriteria vc =vo.getViewCriteria("prLineValidateExcel");
                                          vo.applyViewCriteria(vc);
                                          vo.setNamedWhereClauseParam("BV_PRHID",prHID);
                                          vo.setNamedWhereClauseParam("BV_LINNUM",MytempCell.getNumericCellValue());
                                          vo.setNamedWhereClauseParam("BV_PROJECT_ID",ProjectId);
                                          vo.executeQuery();
                                          System.out.println("COUNT--PR--" +vo.getEstimatedRowCount());
                                          if (vo.getEstimatedRowCount() == 1){
                                             String requisitionLineId =vo.first().getAttribute("RequisitionLineId") ==null ? "0" :vo.first().getAttribute("RequisitionLineId").toString();
                                             String lineNumber =vo.first().getAttribute("LineNumber") ==null ? "0" :vo.first().getAttribute("LineNumber").toString();
                                             String taskId =vo.first().getAttribute("TaskId") ==null ? "0" :vo.first().getAttribute("TaskId").toString();
                                             String taskNumber =vo.first().getAttribute("TaskNumber") ==null ? "0" :vo.first().getAttribute("TaskNumber").toString();
                                             String itemNumber =vo.first().getAttribute("ItemNumber") ==null ? "0" :vo.first().getAttribute("ItemNumber").toString();
                                             String itemDescription =vo.first().getAttribute("ItemDescription") ==null ? "0" :vo.first().getAttribute("ItemDescription").toString();
                                             String categoryId =vo.first().getAttribute("CategoryId") ==null ? "0" :vo.first().getAttribute("CategoryId").toString();
                                             String uomCode =vo.first().getAttribute("UomCode") ==null ? "0" :vo.first().getAttribute("UomCode").toString();
                                             linerow.setAttribute("ReqLineId", requisitionLineId);
                                             linerow.setAttribute("ReqLineNumber", lineNumber);
                                             linerow.setAttribute("TaskId", taskId);
                                             linerow.setAttribute("TaskNumber", taskNumber);
                                             linerow.setAttribute("ItemNumber", itemNumber);
                                             linerow.setAttribute("ItemDescription", itemDescription);
                                             linerow.setAttribute("CategoryId", categoryId);
                                             linerow.setAttribute("Uom", uomCode);
                                          }else{
    //                                               ADFContext.getCurrent().getSessionScope().put("error", "error");
    //                                             JSFUtils.addFacesErrorMessage("Error in Row:"+skipcnt+", Column: "+(Index+1)+", Value: "+MytempCell.getStringCellValue());
                                                if(rowNum==null){
                                                    errorCount=errorCount+1;
                                                    rowNum="Row: "+skipcnt;
                                                }
                                           }
                                      } else{
                                               System.err.println("!!!!!!!!!Task Name is blank!!!!!!!!!");
                                             }
                           }else if (Index == 5) {
                                    if (MytempCell != null){
                                        System.err.println("Index 5==Item specification==" +MytempCell.getStringCellValue());
                                              linerow.setAttribute("BoqItemDesc",MytempCell.getStringCellValue());
                                     } else {
                                         if(rowNum==null){
                                         rowNum="Row: "+skipcnt;
                                            errorCount=errorCount+1;
                                          }else{
                                            rowNum=rowNum+", Row: "+skipcnt;
                                            errorCount=errorCount+1;
                                         }
                                    }
                           }else if (Index == 7) {
                                          if (MytempCell != null) {
                                                     System.err.println("Index 6--QTY " +MytempCell.getNumericCellValue());
                                                     linerow.setAttribute("OrigQuantity",MytempCell.getNumericCellValue());
                                                        } else {
                                                            System.err.println("!!!!!!!!!QTY is blank!!!!!!!!!");
                                                        }
                            } else if (Index == 8) {
                                        if (MytempCell != null) {
                                                System.err.println("Index 7--PRIZE " +MytempCell.getNumericCellValue());
                                                 linerow.setAttribute("OrigUnitPrice",MytempCell.getNumericCellValue());
                                                 float qty =linerow.getAttribute("OrigQuantity") ==null ? 0 :
                                                                Float.parseFloat(linerow.getAttribute("OrigQuantity").toString());
                                                System.err.println("--qty--" + qty);
                                                 float prz =linerow.getAttribute("OrigUnitPrice") ==null ? 0 :
                                                                Float.parseFloat(linerow.getAttribute("OrigUnitPrice").toString());
                                                  System.err.println("--prz--" + prz);
                                                  float amt = qty * prz;
                                                 System.err.println("--amt--" + amt);
                                                  linerow.setAttribute("OrigAmount", amt);
                                                        } else {
                                                            System.err.println("!!!!!!!!!Prize is blank!!!!!!!!!");
                                                        }
                                                    } 
                    }catch(Exception e){
                        System.err.println("Exception Occured at Line & column position is.... " +Index);
                        e.printStackTrace();
                    }
                            
                } // one row completed 
                
            } ////skip first n row for labels.
                
    //                String errorStr=ADFContext.getCurrent().getSessionScope().get("error")==null?"":ADFContext.getCurrent().getSessionScope().get("error").toString();
    //                if("error".equalsIgnoreCase(errorStr)){
    //                    errorRows.add(skipcnt+",");
    //                }
                if(totalNumberofRows>=skipcnt){
                    skipcnt++;        
                }
            System.err.println("Sheet ROW--"+skipcnt);
          }
                /* 
                for (String temp : errorRows) {
                    System.out.println("Error ROw---"+temp);
                    JSFUtils.addFacesErrorMessage("Please provide correct values in Row "+temp);
                } 
                */
/*  
            if(errorCount!=0){
                JSFUtils.addFacesErrorMessage("Please provide correct values in "+rowNum);   
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(t1);    
            JSFUtils.addFacesInformationMessage("Line Added Successfully");
           excelStatus="Y";  
       }
      return excelStatus;  
    }

*/


   /* 
    public String readExcelSheet(InputStream xlsx, RichTable t1, Object ProjectId, Object prHID, Object prLineNumber) throws IOException,InvalidFormatException,ParseException {
        org.apache.poi.ss.usermodel.Workbook workbook = null;
        List<String> errorRows = new ArrayList<String>();
        String rowNum=null;
        String excelStatus="N";
        int errorCount=0;
        int sheetIndex = 0;  
        if (sheetIndex == 0) {
            CollectionModel cModel = (CollectionModel)t1.getValue();
            JUCtrlHierBinding tableBinding = (JUCtrlHierBinding)cModel.getWrappedData();        
            DCIteratorBinding iter = tableBinding.getDCIteratorBinding();
            try {  
                   workbook = WorkbookFactory.create(xlsx);
                 } catch (Exception e) {
                        System.err.println("Exception in Line Workbook : " + e);
                 }
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(sheetIndex);
            Integer skipRw = 1;
            Integer skipcnt = 1;
            int columnCount = 0;
            Integer totalNumberofRows = 0;
            System.out.println("---Excel Row Count--"+sheet.getPhysicalNumberOfRows());
            //Iterate over excel rows
            for (org.apache.poi.ss.usermodel.Row tempRow : sheet) {
              totalNumberofRows=sheet.getPhysicalNumberOfRows()-1;
                System.err.println("--Total Number of Rows in excel sheet"+totalNumberofRows);
                if (skipcnt == 1) {
                      columnCount = tempRow.getPhysicalNumberOfCells();
                  }
                if (skipcnt > skipRw) { //skip first row and start from 2 row .
                
                //Create new row in table
                    ADFUtils.findOperation("CreateInsert").execute();
                    System.err.println("New Line Row Added");
                    oracle.jbo.Row linerow =iter.getNavigatableRowIterator().getCurrentRow();            
                
                int Index = 0; //Iterate over row's columns
                for (int column = 0; column < columnCount; column++) {
                Cell MytempCell = tempRow.getCell(column);
                    if (MytempCell != null) {
                            Index = MytempCell.getColumnIndex();
                       } else {
                             //Index++;
                             }
                    try {
                        if (Index == 0) {
                                   if (MytempCell != null){
                                        System.err.println("Index 0--Task_Name" + MytempCell.getStringCellValue());
                                        ViewObjectImpl vo =(ViewObjectImpl)excelTaskVO;
                                        ViewCriteria vc =vo.getViewCriteria("taskNameValidateExcel");
                                        vo.applyViewCriteria(vc);
                                        vo.setNamedWhereClauseParam("BV_TNAME",MytempCell.getStringCellValue());
                                        vo.setNamedWhereClauseParam("BV_PID",ProjectId);
                                        vo.executeQuery();
                                        System.err.println("COUNT--TASK--" + vo.getEstimatedRowCount());
                                            if (vo.getEstimatedRowCount() == 1) 
                                            {
                                                String taskid = vo.first().getAttribute("ProjElementId") ==null ? "0" :
                                                                vo.first().getAttribute("ProjElementId").toString();
                                                String taskNUM =vo.first().getAttribute("ElementNumber") ==null ? "0" :
                                                                vo.first().getAttribute("ElementNumber").toString();
                                                System.err.println("Task ID" + taskid +"=Task Number=" +taskNUM);
                                                linerow.setAttribute("TaskId", taskid);
                                                linerow.setAttribute("TaskNumber",taskNUM);
                                             } 
                                             else{
//                                               ADFContext.getCurrent().getSessionScope().put("error", "error");
//                                             JSFUtils.addFacesErrorMessage("Error in Row:"+skipcnt+", Column: "+(Index+1)+", Value: "+MytempCell.getStringCellValue()); 
                                                if(rowNum==null){
                                                    errorCount=errorCount+1;
                                                    rowNum="Row: "+skipcnt;
                                                }
                                           }
                                      } else{
                                               System.err.println("!!!!!!!!!Task Name is blank!!!!!!!!!");
                                             }
                           }else if (Index == 1) {
                                    if (MytempCell != null){
                                        System.err.println("Index 1==Requisition Number==" +MytempCell.getStringCellValue());
//                                            if (MytempCell.getStringCellValue().equals(prLineNumber)) {
                                                linerow.setAttribute("ReqNumber",prLineNumber);
//                                                } else {
////                                                        JSFUtils.addFacesErrorMessage("Error in Requisition Number. Please check" +MytempCell.getStringCellValue());
//                                                        }
                                                } else {
//                                                   ADFContext.getCurrent().getSessionScope().put("error", "error");
//                                                   JSFUtils.addFacesErrorMessage("Error in Row:"+skipcnt+", Column: "+(Index+1)+", Value: "+MytempCell.getStringCellValue()); 
                                                   if(rowNum==null){
                                                    rowNum="Row: "+skipcnt;
                                                       errorCount=errorCount+1;
                                                   }else{
                                                      rowNum=rowNum+", Row: "+skipcnt;
                                                       errorCount=errorCount+1;
                                                   }

                                                 }
                            }else if (Index == 2) {
                                       if (MytempCell != null) {
                                            System.err.println("Index 2-PR LINE " +MytempCell.getNumericCellValue());
                                            ViewObjectImpl vo =(ViewObjectImpl)excelPRVO;
                                            ViewCriteria vc =vo.getViewCriteria("prLineValidateExcel");
                                            vo.applyViewCriteria(vc);
                                            vo.setNamedWhereClauseParam("BV_PRHID",prHID);
                                            vo.setNamedWhereClauseParam("BV_LINNUM",MytempCell.getNumericCellValue());
                                            vo.executeQuery();
                                            System.err.println("COUNT--PR--" +vo.getEstimatedRowCount());
                                                if (vo.getEstimatedRowCount() == 1) {
                                                  String prLid =vo.first().getAttribute("RequisitionLineId") ==null ? "0" :vo.getCurrentRow().getAttribute("RequisitionLineId").toString();
                                                  String prLNum =vo.first().getAttribute("LineNumber") ==null ? "0" :vo.getCurrentRow().getAttribute("LineNumber").toString();
                                                  System.err.println("RequisitionLineId" +prLid +"=ReqLineNumber=" +prLNum);
                                                                linerow.setAttribute("ReqLineId",prLid);
                                                                linerow.setAttribute("ReqLineNumber",prLNum);
                                                 } else {
//                                                            ADFContext.getCurrent().getSessionScope().put("error", "error");
//                                                        JSFUtils.addFacesErrorMessage("Error in Row:"+skipcnt+", Column: "+(Index+1)+", Value: "+MytempCell.getNumericCellValue()); 
                                                    if(rowNum==null){
                                                    rowNum="Row: "+skipcnt;
                                                       errorCount=errorCount+1;
                                                   }else{
                                                      rowNum=rowNum+", Row: "+skipcnt;
                                                       errorCount=errorCount+1;
                                                   }
                                                        }
                                                 } else {
                                                         System.err.println("!!!!!!!!!ReqLineNumber is blank!!!!!!!!!");
                                                        }
                             } else if (Index == 3) {
                                          if (MytempCell != null) {
                                           System.err.println("Index 3--PR ItemDescription " +MytempCell.getStringCellValue());
                                           ViewObjectImpl vo =(ViewObjectImpl)excelPRVO;
                                           ViewCriteria vc =vo.getViewCriteria("excelValidation_PRLineDesc");
                                           vo.applyViewCriteria(vc);
                                           vo.setNamedWhereClauseParam("BV_PRHID",prHID);
                                           vo.setNamedWhereClauseParam("BV_DESC",MytempCell.getStringCellValue());
                                           vo.executeQuery();
                                           System.err.println("COUNT--PR2--" +vo.getEstimatedRowCount());
                                                 if (vo.getEstimatedRowCount() == 1) {
                                                     String prDescribe =vo.first().getAttribute("ItemDescription") ==null ? "0" :vo.getCurrentRow().getAttribute("ItemDescription").toString();
                                                     System.err.println("==Describtion===" +prDescribe);
                                                     linerow.setAttribute("ItemDescription",prDescribe);
                                                } else {
//                                                         ADFContext.getCurrent().getSessionScope().put("error", "error");
//                                                JSFUtils.addFacesErrorMessage("Error in Row:"+skipcnt+", Column: "+(Index+1)+", Value: "+MytempCell.getStringCellValue()); 
                                                   if(rowNum==null){
                                                    rowNum="Row: "+skipcnt;
                                                       errorCount=errorCount+1;
                                                   }else{
                                                      rowNum=rowNum+", Row:  "+skipcnt;
                                                       errorCount=errorCount+1;
                                                   }
                                                     }
                                                } else {
                                                      System.err.println("!!!!!!!!!Item Descri is blank!!!!!!!!!");
                                                        }
                        }else if(Index==4){
                            if(MytempCell!=null){
                                System.err.println("Index 4--PR Item Number " +MytempCell.getStringCellValue());
                                ViewObjectImpl vo =(ViewObjectImpl)excelPRVO;
                                ViewCriteria vc =vo.getViewCriteria("excelValid_PRLineItemNum");
                                vo.applyViewCriteria(vc);
                                System.err.println("---prHID--"+prHID+"--ProjectId--"+ProjectId+"--ITEM Nuimber--"+MytempCell.getStringCellValue());
                                vo.setNamedWhereClauseParam("BV_PRHID",prHID);
                                vo.setNamedWhereClauseParam("BV_ITEM_NUM",MytempCell.getStringCellValue());
//                                vo.setNamedWhereClauseParam("BV_PROJ_ID",ProjectId);
                                vo.executeQuery();
                                System.err.println("COUNT--PR1--" +vo.getEstimatedRowCount());
                                if (vo.getEstimatedRowCount() == 1) {
                                    String prItemNumber =vo.first().getAttribute("ItemNumber") ==null ? "0" :vo.getCurrentRow().getAttribute("ItemNumber").toString();
                                    System.err.println("==ItemNumber===" +prItemNumber);
                                    linerow.setAttribute("ItemNumber",prItemNumber);
                                }else{
//                                  JSFUtils.addFacesErrorMessage("Error in " +MytempCell.getStringCellValue()); 
//                                    ADFContext.getCurrent().getSessionScope().put("error", "error");
//                                    JSFUtils.addFacesErrorMessage("Error in Row:"+skipcnt+", Column: "+(Index+1)+", Value: "+MytempCell.getStringCellValue()); 
                                        if(rowNum==null){
                                        rowNum="Row: "+skipcnt;
                                        errorCount=errorCount+1;
                                        }else{
                                        rowNum=rowNum+", Row:  "+skipcnt;
                                        errorCount=errorCount+1;
                                        }
                                }
                            }else{
                                System.err.println("!!!!!!!!!Item Number is blank!!!!!!!!!");
                            }
                         }else if (Index == 5) {
                                          if (MytempCell != null) {
                                          System.err.println("Index 4--BOQ Item Description--" +MytempCell.getStringCellValue());
                                           linerow.setAttribute("BoqItemDesc",MytempCell.getStringCellValue());
                                           } else {
                                                     System.err.println("!!!!!!!!!BoqItemDesc is blank!!!!!!!!!");
                                                  }
                          } else if (Index == 6) {
                                         if (MytempCell != null) {
                                         System.err.println("Index 5 " +MytempCell.getStringCellValue());
                                             ViewObjectImpl vo =(ViewObjectImpl)excelUOMVO;
                                             ViewCriteria vc =vo.getViewCriteria("UOMValidateExcel");
                                             vo.applyViewCriteria(vc);
                                             vo.setNamedWhereClauseParam("BV_DES",MytempCell.getStringCellValue());
                                             vo.executeQuery();
                                                if (vo.getEstimatedRowCount() == 1) {
                                                Object uomDESC =vo.first().getAttribute("Description") ==null ? 0 :
                                                                vo.getCurrentRow().getAttribute("Description").toString();
                                                Object uomCODE =vo.first().getAttribute("UomCode") ==null ? 0 :
                                                                vo.getCurrentRow().getAttribute("UomCode").toString();
                                                System.err.println("=Description=" +uomDESC +"=UomCode=" +uomCODE);
                                                linerow.setAttribute("Uom", uomCODE);
                                                } else {
//                                                      ADFContext.getCurrent().getSessionScope().put("error", "error");
//                                                      JSFUtils.addFacesErrorMessage("Error in Row:"+skipcnt+", Column: "+(Index+1)+", Value: "+MytempCell.getStringCellValue()); 
                                                if(rowNum==null){
                                                    rowNum="Row: "+skipcnt;
                                                       errorCount=errorCount+1;
                                                   }else{
                                                      rowNum=rowNum+", Row:  "+skipcnt;
                                                       errorCount=errorCount+1;
                                                   }
                                                  }
                                                        } else {
                                                            System.err.println("!!!!!!!!!UOM is blank!!!!!!!!!");
                                                        }
                                  } else if (Index == 7) {
                                          if (MytempCell != null) {
                                                     System.err.println("Index 6--QTY " +MytempCell.getNumericCellValue());
                                                     linerow.setAttribute("OrigQuantity",MytempCell.getNumericCellValue());
                                                        } else {
                                                            System.err.println("!!!!!!!!!QTY is blank!!!!!!!!!");
                                                        }
                                  } else if (Index == 8) {
                                        if (MytempCell != null) {
                                                System.err.println("Index 7--PRIZE " +MytempCell.getNumericCellValue());
                                                 linerow.setAttribute("OrigUnitPrice",MytempCell.getNumericCellValue());
                                                 float qty =linerow.getAttribute("OrigQuantity") ==null ? 0 :
                                                                Float.parseFloat(linerow.getAttribute("OrigQuantity").toString());
                                                System.err.println("--qty--" + qty);
                                                 float prz =linerow.getAttribute("OrigUnitPrice") ==null ? 0 :
                                                                Float.parseFloat(linerow.getAttribute("OrigUnitPrice").toString());
                                                  System.err.println("--prz--" + prz);
                                                  float amt = qty * prz;
                                                 System.err.println("--amt--" + amt);
                                                  linerow.setAttribute("OrigAmount", amt);
                                                        } else {
                                                            System.err.println("!!!!!!!!!Prize is blank!!!!!!!!!");
                                                        }
                                                    } 
                    }catch(Exception e){
                        System.err.println("Exception Occured at Line & column position is.... " +Index);
                        e.printStackTrace();
                    }
                            
                } // one row completed 
                
            } ////skip first n row for labels.
                
//                String errorStr=ADFContext.getCurrent().getSessionScope().get("error")==null?"":ADFContext.getCurrent().getSessionScope().get("error").toString();   
//                if("error".equalsIgnoreCase(errorStr)){
//                    errorRows.add(skipcnt+",");
//                }
                if(totalNumberofRows>=skipcnt){
                    skipcnt++;        
                }
            System.err.println("Sheet ROW--"+skipcnt);
          }
            
           //     for (String temp : errorRows) {
             //       System.out.println("Error ROw---"+temp);
               //     JSFUtils.addFacesErrorMessage("Please provide correct values in Row "+temp);
               // } 
           
            if(errorCount!=0){
                JSFUtils.addFacesErrorMessage("Please provide correct values in "+rowNum);   
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(t1);    
            JSFUtils.addFacesInformationMessage("Line Added Successfully");
           excelStatus="Y";  
       }
      return excelStatus;  
    }
    
    
    
*/
