package Utils;

import java.math.BigDecimal;

import javax.faces.component.UIComponent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

public class ADFMathUtils {


    /***
     *****Double*******
     ** @param ViewObject
     ** @param Qty
     ** @param Price
     ** @return Amount
     ***/

    public static BigDecimal multiply2AttributeInDouble(ViewObject vo,
                                                        String Attribute1,
                                                        String Attribute2) {
        double para1 =
            vo.first().getAttribute(Attribute1) == null ? 0 : Double.parseDouble(vo.first().getAttribute(Attribute1).toString());
//        //System.err.println("--parameter 1--" + para1);
        double para2 =
            vo.first().getAttribute(Attribute2) == null ? 0 : Double.parseDouble(vo.first().getAttribute(Attribute2).toString());
//        //System.err.println("--parameter 2--" + para2);
        double para3 = para1 * para2;
//        //System.err.println("DECIMAI Total Value---------" +
//                           new BigDecimal(para3));
        return new BigDecimal(para3);
    }


    /*****2 paramenter Adding VCL and Attribute**********/

    public static BigDecimal add2AttributeInDoubleVCL(ViewObject vo,
                                                      String Attribute1,
                                                      ValueChangeEvent valueChangeEvent) {
        double p1 =
            vo.first().getAttribute(Attribute1) == null ? 0 : Double.parseDouble(vo.first().getAttribute(Attribute1).toString());
//        //System.err.println("--parameter 1--" + p1);
        double p2 =
            valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
//        //System.err.println("--parameter 2--" + p2);
        double para3 = p1 + p2;
//        //System.err.println("DECIMAI Total Value---------" +
//                           new BigDecimal(para3));
        return new BigDecimal(para3);
    }


    /*****2 paramenter Adding Attribute and Attribute with single VO**********/

    public static BigDecimal add2AttributeInDoubleVO(ViewObject vo,
                                                     String Attribute1,
                                                     String Attribute2) {
        double p1 =
            vo.first().getAttribute(Attribute1) == null ? 0 : Double.parseDouble(vo.first().getAttribute(Attribute1).toString());
        //System.err.println("--parameter 1--" + p1);
        double p2 =
            vo.first().getAttribute(Attribute2) == null ? 0 : Double.parseDouble(vo.first().getAttribute(Attribute2).toString());
        //System.err.println("--parameter 2--" + p2);
        double para3 = p1 + p2;
        //System.err.println("DECIMAI Total Value---------" +
//                           new BigDecimal(para3));
        return new BigDecimal(para3);
    }


    /*****2 paramenter Multiply valueChangeEvent and Binding**********/


    public static BigDecimal multiplyVCLAndBinding(ValueChangeEvent valueChangeEvent,
                                                   RichInputText RichInputTextBinding) {
        double para1 =
            valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
        //System.err.println("--parameter 1--" + para1);
        double para2 =
            RichInputTextBinding.getValue() == null ? 0 : Float.parseFloat(RichInputTextBinding.getValue().toString());
        //System.err.println("--parameter 2--" + para2);
        double para3 = para1 * para2;
        //System.err.println("DECIMAI Total Value---------" +
//                           new BigDecimal(para3));
        return new BigDecimal(para3);
    }


    /*******2 paramenter subtract  InDouble VCL Attribute************/

    public static BigDecimal subtractVCLAndVOAttribute(ValueChangeEvent valueChangeEvent,
                                                       String Attribute1,
                                                       ViewObject vo) {
        double p1 =
            vo.first().getAttribute(Attribute1) == null ? 0 : Double.parseDouble(vo.first().getAttribute(Attribute1).toString());
        //System.err.println("--parameter 1--" + p1);
        double p2 =
            valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
        //System.err.println("--parameter 2--" + p2);
        double para3 = p2 - p1;
        //System.err.println("DECIMAI Total Value---------" +
//                           new BigDecimal(para3));
        return new BigDecimal(para3);
    }


    /*******2 paramenter subtract  Attribute, Binding************/

    public static BigDecimal subtractInputBindingAndVOAttribute(RichInputText RichInputTextBinding,
                                                                String Attribute1,
                                                                ViewObject vo) {
        double para1 =
            vo.first().getAttribute(Attribute1) == null ? 0 : Double.parseDouble(vo.first().getAttribute(Attribute1).toString());
        //System.err.println("--parameter 1--" + para1);
        double para2 =
            RichInputTextBinding.getValue() == null ? 0 : Float.parseFloat(RichInputTextBinding.getValue().toString());
        //System.err.println("--parameter 2--" + para2);
        double para3 = para2 - para1;
        //System.err.println("DECIMAI Total Value---------" +
//                           new BigDecimal(para3));
        return new BigDecimal(para3);
    }


    /*******2 paramenter subtract   Big Decimal and Attribute************/

    public static BigDecimal subtractBigDecimalAttribute(BigDecimal bigDecimalValue,
                                                         String Attribute1,
                                                         ViewObject vo) {

        BigDecimal bigDecimal = bigDecimalValue;
        //System.err.println("--value 1--" + bigDecimal);
        double attrib =
            vo.first().getAttribute(Attribute1) == null ? 0 : Double.parseDouble(vo.first().getAttribute(Attribute1).toString());
        //System.err.println("--value 2--" + attrib);
        double para3 = bigDecimal.doubleValue() - attrib;
        //System.err.println("Big Decimal and Attribute=----Total Value---------" +
//                           new BigDecimal(para3));
        return new BigDecimal(para3);
    }


    /*
    public void matRecVCL(ValueChangeEvent matRecPerc) {
        String val = matRecPerc.getNewValue().toString();
        String tot = "TotalContractSum";
        String setAtt = "MaterialOnSiteRec";
        UIComponent id = matRec;
        calcPerc(val, tot, setAtt, id);
    }

    public void calcPerc(String val,String tot,String setAtt,UIComponent id){
        double liqP = Float.parseFloat(val);
        double totCon = contractVO.getCurrentRow().getAttribute(tot)==null?0:Double.parseDouble(contractVO.getCurrentRow().getAttribute(tot).toString());
        double totAmt = (liqP*totCon)/100;
        contractVO.getCurrentRow().setAttribute(setAtt, new BigDecimal(totAmt));
        AdfFacesContext.getCurrentInstance().addPartialTarget(id);
    }

    */


    /*

    public static BigDecimal TotalAmountIterator(ViewObject vo, String Attribute){
        RowSetIterator rs=vo.createRowSetIterator(null);
        double totalAmount=0;
        while(rs.hasNext()){
            Row row=rs.next();
            //Row row=rs.first();
            double amt=row.getAttribute(Attribute)==null?0:Double.parseDouble(row.getAttribute(Attribute).toString());
            totalAmount+=amt;
            //System.err.println("==totalAmount=="+totalAmount);
        }
        return new BigDecimal(totalAmount);
    }
    */

}
