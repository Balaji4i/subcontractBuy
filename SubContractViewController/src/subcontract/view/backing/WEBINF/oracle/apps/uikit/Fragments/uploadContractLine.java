package subcontract.view.backing.WEBINF.oracle.apps.uikit.Fragments;

import java.text.ParseException;

import Utils.ADFUtils;

import java.io.InputStream;


import Utils.JSFUtils;


import org.apache.poi.ss.usermodel.WorkbookFactory;


import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.myfaces.trinidad.model.CollectionModel;

import oracle.jbo.uicli.binding.JUCtrlHierBinding;


import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaManager;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.poi.ss.usermodel.DateUtil;


public class uploadContractLine {
    public uploadContractLine() {
        super();
    }
    int Index = 0;
    long lineNumber = 0;
    String lineType = null;
    String itemName = null;
    String itemDescription = null;
    String unitOfMeasure = null;
    double numOfItem = 0;
    double priceUnit = 0;
    double lineAmount = 0;
    String startDate = null;
    String endDate = null;
    String projectNumber = null;
    String taskNumber = null;
    double fundingAmount = 0;
    String taxCode = null;

    public void readExcelSheet(InputStream xlsx, RichTable t1) {

        org.apache.poi.ss.usermodel.Workbook workbook = null;
        java.util.Date date = new java.util.Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        //        DataFormatter dateFormat = new DataFormatter();
        int sheetIndex = 0;
        if (sheetIndex == 0) {
            CollectionModel cModel = (CollectionModel)t1.getValue();
            JUCtrlHierBinding tableBinding =
                (JUCtrlHierBinding)cModel.getWrappedData();
            DCIteratorBinding iter = tableBinding.getDCIteratorBinding();
            try {
                workbook = WorkbookFactory.create(xlsx);
            } catch (Exception e) {
                //System.err.println("Exception in Line Workbook : " + e);
            }
            org.apache.poi.ss.usermodel.Sheet sheet =
                workbook.getSheetAt(sheetIndex);
            Integer skipRw = 1;
            Integer skipcnt = 1;
            int columnCount = 0;
            Integer totalNumberofRows = 0;
            for (org.apache.poi.ss.usermodel.Row tempRow : sheet) {
                Index = 0;
                lineNumber = 0;
                lineType = null;
                itemName = null;
                itemDescription = null;
                unitOfMeasure = null;
                numOfItem = 0;
                priceUnit = 0;
                lineAmount = 0;
                startDate = null;
                endDate = null;
                projectNumber = null;
                taskNumber = null;
                fundingAmount = 0;
                taxCode = null;
                totalNumberofRows = sheet.getPhysicalNumberOfRows() - 1;
                //System.err.println("--Total Number of Rows in excel sheet" +
//                                   totalNumberofRows);
                if (skipcnt == 1) {
                    columnCount = tempRow.getPhysicalNumberOfCells();
                    //System.err.println("COLUMN======columnCount=======" +
//                                       columnCount);
                }
                if (skipcnt > skipRw) {
                    //System.err.println("New Line Row Added===========================");

                    for (int column = 0; column < columnCount; column++) {

                        Cell MytempCell = tempRow.getCell(column);
                        if (MytempCell != null) {
                            Index = MytempCell.getColumnIndex();
                        } else {
                            Index++;
                        }
                        //System.err.println("====IND======" + Index);
                        try {
                            if (Index < 12) {
                                if (Index == 0) {
                                    if (MytempCell != null) {
                                        lineNumber =
                                                (long)MytempCell.getNumericCellValue();
                                    }
                                    //System.err.println("====LINE NUM=============" +
//                                                       lineNumber);
                                } else if (Index == 1) {
                                    if (MytempCell != null) {
                                        switch (MytempCell.getCellType()) {
                                        case 1:
                                            itemName =
                                                    MytempCell.getStringCellValue();
                                            break;
                                        case 0:
                                            double proNo =
                                                MytempCell.getNumericCellValue();
                                            itemName =
                                                    Integer.toString((int)proNo);
                                            break;
                                        }
                                    } else {
                                        itemName = null;
                                    }
                                    //System.err.println("===Item Name====" +
//                                                       itemName);
                                } else if (Index == 2) {
                                    if (MytempCell != null) {
                                        switch (MytempCell.getCellType()) {
                                        case 1:
                                            itemDescription =
                                                    MytempCell.getStringCellValue();
                                            break;
                                        case 0:
                                            double proNo =
                                                MytempCell.getNumericCellValue();
                                            itemDescription =
                                                    Integer.toString((int)proNo);
                                            break;
                                        }
                                    } else {
                                        itemDescription = null;
                                    }
                                    //System.err.println("===Item desc====" +
//                                                       itemDescription);
                                } else if (Index == 3) {
                                    if (MytempCell != null) {
                                        unitOfMeasure =
                                                MytempCell.getStringCellValue();
                                    } else {
                                        unitOfMeasure = null;
                                    }
                                    //System.err.println("===UOM====" +
//                                                       unitOfMeasure);

                                } else if (Index == 4) {
                                    if (MytempCell != null) {
                                        switch (MytempCell.getCellType()) {
                                        case 1:
                                            break;
                                        case 0:
                                            numOfItem =
                                                    MytempCell.getNumericCellValue();
                                            break;
                                        }
                                    } else {
                                        numOfItem = 0;
                                    }
                                    //System.err.println("===num of item====" +
//                                                       numOfItem);
                                } else if (Index == 5) {
                                    if (MytempCell != null) {
                                        switch (MytempCell.getCellType()) {
                                        case 1:
                                            break;
                                        case 0:
                                            priceUnit =
                                                    MytempCell.getNumericCellValue();
                                            break;
                                        }
                                    } else {
                                        priceUnit = 0;
                                    }
                                    //System.err.println("===price====" +
//                                                       priceUnit);

                                }
                                //                            else if (Index == 6) {
                                //                                if (MytempCell != null) {
                                //                                    switch (MytempCell.getCellType()) {
                                //                                    case 1:
                                //                                        break;
                                //                                    case 0:
                                //                                        lineAmount =
                                //                                                MytempCell.getNumericCellValue();
                                //                                        break;
                                //                                    }
                                //                                } else {
                                //                                    lineAmount = 0;
                                //                                }
                                //                                //System.err.println("===lineAmt====" +
                                //                                                   lineAmount);
                                //                            }

                                else if (Index == 6) {
                                    if (MytempCell != null) {

                                        if (MytempCell.getDateCellValue() !=
                                            null) {
                                            startDate =
                                                    dateFormat.format(MytempCell.getDateCellValue());
                                        }
                                    } else {
                                        startDate = null;
                                    }
                                    //System.err.println("===st====" +
//                                                       startDate);
                                } else if (Index == 7) {
                                    if (MytempCell != null) {

                                        if (MytempCell.getDateCellValue() !=
                                            null) {
                                            endDate =
                                                    dateFormat.format(MytempCell.getDateCellValue());
                                        }
                                    } else {
                                        endDate = null;
                                    }
                                    //System.err.println("===en====" + endDate);

                                } else if (Index == 8) {
                                    if (MytempCell != null) {
                                        switch (MytempCell.getCellType()) {
                                        case 1:
                                            projectNumber =
                                                    MytempCell.getStringCellValue();
                                            break;
                                        case 0:
                                            double proNo =
                                                MytempCell.getNumericCellValue();
                                            projectNumber =
                                                    Integer.toString((int)proNo);
                                            break;
                                        }

                                    } else {
                                        projectNumber = null;
                                    }
                                    //System.err.println("===pro====" +
//                                                       projectNumber);

                                } else if (Index == 9) {
                                    if (MytempCell != null) {
                                        switch (MytempCell.getCellType()) {
                                        case 1:
                                            taskNumber =
                                                    MytempCell.getStringCellValue();
                                            break;
                                        case 0:
                                            double proNo =
                                                MytempCell.getNumericCellValue();
                                            taskNumber =
                                                    Integer.toString((int)proNo);
                                            break;
                                        }
                                    } else {
                                        taskNumber = null;
                                    }
                                    //System.err.println("===task====" +
//                                                       taskNumber + "==IN==" +
//                                                       Index);
                                }
                                //                            else if (Index == 10) {
                                //                                if (MytempCell != null) {
                                //
                                //                                    fundingAmount =
                                //                                            MytempCell.getNumericCellValue();
                                //                                } else {
                                //                                    fundingAmount = 0;
                                //                                }
                                //                                //System.err.println("===fund====" +
                                //                                                   fundingAmount);
                                //                             }
                                else if (Index == 10) {
                                    if (MytempCell != null) {
                                        switch (MytempCell.getCellType()) {
                                        case 1:
                                            taxCode =
                                                    MytempCell.getStringCellValue();
                                            break;
                                        case 0:
                                            double taxc =
                                                MytempCell.getNumericCellValue();
                                            taxCode =
                                                    Integer.toString((int)taxc);
                                            break;
                                        }
                                    } else {
                                        taxCode = null;
                                    }
                                    //System.err.println("===tax====" + taxCode);
                                    ProcessRow(lineNumber, itemName,
                                               itemDescription, unitOfMeasure,
                                               numOfItem, priceUnit,
                                               lineAmount, startDate, endDate,
                                               projectNumber, taskNumber,
                                               taxCode);
                                    //System.err.println("===================END==================");
                                }
                            }
                        } catch (Exception e) {
                            //System.err.println("Exception Occured at Line & column position is.... " +
//                                               Index);
                            e.printStackTrace();
                        }
                    }
                    try {
                        //System.err.println("==COMM==");
                        ADFUtils.findOperation("Commit").execute();
                        ViewObject lineVO =
                            ADFUtils.findIterator("XxstgSellContractLines_VO1Iterator").getViewObject();
                        ViewCriteriaManager vcm =
                            lineVO.getViewCriteriaManager();
                        vcm.clearViewCriterias();
                        lineVO.setNamedWhereClauseParam("p_con_num",
                                                        ADFContext.getCurrent().getPageFlowScope().get("con_num"));
                        lineVO.executeQuery();
                        //System.err.println("==COMM==1==");
                        RichTable t11 =
                            (RichTable)JSFUtils.findComponentInRoot("t1");
                        AdfFacesContext.getCurrentInstance().addPartialTarget(t11);
                    } catch (Exception e) {
                        //System.err.println("==" + e.toString());
                    }
                }
                if (totalNumberofRows >= skipcnt) {
                    skipcnt++;
                }
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
            JSFUtils.addFacesInformationMessage("Line Added Successfully");

        }

    }


    public void ProcessRow(long lineNumber, String itemName,
                           String itemDescription, String unitOfMeasure,
                           double numOfItem, double priceUnit,
                           double lineAmount, String startDate, String endDate,
                           String projectNumber, String taskNumber,
                           String taxCode) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); //
        ViewObject SellContractHeader =
            ADFUtils.findIterator("XxstgSellContractHeaders_VO1Iterator").getViewObject();
        ViewObject SellContractLines =
            ADFUtils.findIterator("XxstgSellContractLines_VO1Iterator").getViewObject();
        ViewCriteria SellContractLinesVC =
            SellContractLines.createViewCriteria();
        ViewCriteriaRow SellContractLineVCRow =
            SellContractLinesVC.createViewCriteriaRow();
        SellContractLineVCRow.setAttribute("LineNumber", lineNumber);
        SellContractLineVCRow.setAttribute("ContractNumber",
                                           SellContractHeader.getCurrentRow().getAttribute("ContractNumber"));
        SellContractLineVCRow.setAttribute("ProjectNumber", projectNumber);
        SellContractLineVCRow.setAttribute("TaskNumber", taskNumber);
        SellContractLinesVC.addRow(SellContractLineVCRow);
        SellContractLines.applyViewCriteria(SellContractLinesVC);
        SellContractLines.executeQuery();
        //System.err.println("==COUNT App header Id==" +
//                           SellContractLines.getEstimatedRowCount());
        if (SellContractLines.getEstimatedRowCount() == 1) {
            Row currrow = SellContractLines.first();
            if (itemName != null) {
                currrow.setAttribute("ItemName", itemName);
            } else {
                currrow.setAttribute("ItemName", null);
            }
            if (itemDescription != null) {
                currrow.setAttribute("ItemDescription", itemDescription);
            } else {
                currrow.setAttribute("ItemDescription", null);
            }
            if (unitOfMeasure != null) {
                currrow.setAttribute("UnitOfMeasure", unitOfMeasure);
            } else {
                currrow.setAttribute("UnitOfMeasure", null);
            }
            if (numOfItem > 0) {
                currrow.setAttribute("NumOfItem", numOfItem);
            } else {
                currrow.setAttribute("NumOfItem", null);
            }
            if (priceUnit > 0) {
                currrow.setAttribute("PriceUnit", priceUnit);
            } else {
                currrow.setAttribute("PriceUnit", null);
            }
            if (priceUnit > 0 && numOfItem > 0) {
                currrow.setAttribute("LineAmount", numOfItem * priceUnit);
            } else {
                currrow.setAttribute("LineAmount", 0);
            }
            oracle.jbo.domain.Date jboDate = null;
            if (startDate != null) {
                java.util.Date date = formatter.parse(startDate);
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                jboDate = new oracle.jbo.domain.Date(sqlDate);
                currrow.setAttribute("StartDate", jboDate);
            } else {
                currrow.setAttribute("StartDate", null);
            }
            oracle.jbo.domain.Date jboDate1 = null;
            if (endDate != null) {
                java.util.Date date1 = formatter.parse(endDate);
                java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
                jboDate1 = new oracle.jbo.domain.Date(sqlDate1);
                currrow.setAttribute("EndDate", jboDate1);
            } else {
                currrow.setAttribute("EndDate", null);
            }
            if (projectNumber != null) {
                currrow.setAttribute("ProjectNumber", projectNumber);
            } else {
                currrow.setAttribute("ProjectNumber", null);
            }
            if (taskNumber != null) {
                currrow.setAttribute("TaskNumber", taskNumber);
            } else {
                currrow.setAttribute("TaskNumber", null);
            }
            //            if (fundingAmount > 0) {
            //                currrow.setAttribute("FundingAmount", fundingAmount);
            //            } else {
            //                currrow.setAttribute("FundingAmount", null);
            //            }
            if (taxCode != null) {
                currrow.setAttribute("OutputTaxClassificationCode", taxCode);
            } else {
                currrow.setAttribute("OutputTaxClassificationCode", null);
            }
            currrow.setAttribute("Flag", "U");
            SellContractLines.insertRow(currrow);
            SellContractLines.executeQuery();
        } else if (SellContractLines.getEstimatedRowCount() == 0) {
            //System.err.println("=====Inside Else====");
            //            ViewObject SellContractLine =ADFUtils.findIterator("XxstgSellContractLines_VO1Iterator").getViewObject();
            Row r = SellContractLines.createRow();
            r.setAttribute("LineNumber", lineNumber);
            r.setAttribute("LineType", "Free-form, project");
            r.setAttribute("LineTypeId", getLineTypeIds("Free-form, project"));
            r.setAttribute("ContractNumber",
                           SellContractHeader.getCurrentRow().getAttribute("ContractNumber"));
            if (itemName != null) {
                r.setAttribute("ItemName", itemName);
            } else {
                r.setAttribute("ItemName", null);
            }
            if (itemDescription != null) {
                r.setAttribute("ItemDescription", itemDescription);
            } else {
                r.setAttribute("ItemDescription", null);
            }
            if (unitOfMeasure != null) {
                r.setAttribute("UnitOfMeasure", unitOfMeasure);
            } else {
                r.setAttribute("UnitOfMeasure", null);
            }
            if (numOfItem > 0) {
                r.setAttribute("NumOfItem", numOfItem);
            } else {
                r.setAttribute("NumOfItem", null);
            }
            if (priceUnit > 0) {
                r.setAttribute("PriceUnit", priceUnit);
            } else {
                r.setAttribute("PriceUnit", null);
            }
            if (priceUnit > 0 && numOfItem > 0) {
                r.setAttribute("LineAmount", numOfItem * priceUnit);
            } else {
                r.setAttribute("LineAmount", 0);
            }
            oracle.jbo.domain.Date jboDate = null;
            if (startDate != null) {
                java.util.Date date = formatter.parse(startDate);
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                jboDate = new oracle.jbo.domain.Date(sqlDate);
                r.setAttribute("StartDate", jboDate);
            } else {
                r.setAttribute("StartDate", null);
            }
            oracle.jbo.domain.Date jboDate1 = null;
            if (endDate != null) {
                java.util.Date date1 = formatter.parse(endDate);
                java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
                jboDate1 = new oracle.jbo.domain.Date(sqlDate1);
                r.setAttribute("EndDate", jboDate1);
            } else {
                r.setAttribute("EndDate", null);
            }
            if (projectNumber != null) {
                r.setAttribute("ProjectNumber", projectNumber);
            } else {
                r.setAttribute("ProjectNumber", null);
            }
            if (taskNumber != null) {
                r.setAttribute("TaskNumber", taskNumber);
            } else {
                r.setAttribute("TaskNumber", null);
            }
            //            if (fundingAmount > 0) {
            //                r.setAttribute("FundingAmount", fundingAmount);
            //            } else {
            //                r.setAttribute("FundingAmount", null);
            //            }
            if (taxCode != null) {
                r.setAttribute("OutputTaxClassificationCode", taxCode);
            } else {
                r.setAttribute("OutputTaxClassificationCode", null);
            }
            r.setAttribute("Flag", "A");
            SellContractLines.insertRow(r);
        }
    }

    private long getLineTypeIds(String lineType) {
        long retName = 0;
        ViewObject lineTypeVO =
            ADFUtils.findIterator("ContractLineType_ROVO1Iterator").getViewObject();
        ViewObjectImpl vo = (ViewObjectImpl)lineTypeVO;
        ViewCriteria vc = vo.getViewCriteria("findByLineTypeName");
        lineTypeVO.applyViewCriteria(vc);
        lineTypeVO.setNamedWhereClauseParam("p_name", lineType);
        lineTypeVO.executeQuery();
        if (lineTypeVO.getEstimatedRowCount() > 0) {
            retName =
                    Long.parseLong(lineTypeVO.first().getAttribute("LineTypeId").toString());
        }
        return retName;
    }
}
