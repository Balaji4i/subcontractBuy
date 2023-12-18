package backing;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichQuery;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.fragment.RichPageTemplate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelDrawer;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;
import oracle.adf.view.rich.component.rich.output.RichSpacer;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import view.backing.ADFUtils;

public class retSearch {
    private RichQuery qryId1;
    private RichPanelBox pb2;
    private RichShowDetailItem dr1;
    private RichPanelDrawer pd1;
    private RichTable resId1;
    private RichPanelCollection pc1;
    private RichSpacer s2;
    private RichCommandButton cb2;
    private RichSpacer s1;
    private RichCommandButton cb1;
    private RichInputText it1;
    private RichToolbar t1;
    private RichPanelGroupLayout pgl1;
    private RichPanelBox pb1;
    private RichPageTemplate pt1;

    public retSearch() {
    }

    public void setQryId1(RichQuery qryId1) {
        this.qryId1 = qryId1;
    }

    public RichQuery getQryId1() {
        return qryId1;
    }

    public void setPb2(RichPanelBox pb2) {
        this.pb2 = pb2;
    }

    public RichPanelBox getPb2() {
        return pb2;
    }

    public void setDr1(RichShowDetailItem dr1) {
        this.dr1 = dr1;
    }

    public RichShowDetailItem getDr1() {
        return dr1;
    }

    public void setPd1(RichPanelDrawer pd1) {
        this.pd1 = pd1;
    }

    public RichPanelDrawer getPd1() {
        return pd1;
    }

    public void setResId1(RichTable resId1) {
        this.resId1 = resId1;
    }

    public RichTable getResId1() {
        return resId1;
    }

    public void setPc1(RichPanelCollection pc1) {
        this.pc1 = pc1;
    }

    public RichPanelCollection getPc1() {
        return pc1;
    }

    public void setS2(RichSpacer s2) {
        this.s2 = s2;
    }

    public RichSpacer getS2() {
        return s2;
    }

    public void setCb2(RichCommandButton cb2) {
        this.cb2 = cb2;
    }

    public RichCommandButton getCb2() {
        return cb2;
    }

    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichSpacer getS1() {
        return s1;
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setT1(RichToolbar t1) {
        this.t1 = t1;
    }

    public RichToolbar getT1() {
        return t1;
    }

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }

    public void setPb1(RichPanelBox pb1) {
        this.pb1 = pb1;
    }

    public RichPanelBox getPb1() {
        return pb1;
    }

    public void setPt1(RichPageTemplate pt1) {
        this.pt1 = pt1;
    }

    public RichPageTemplate getPt1() {
        return pt1;
    }
    ViewObject conSearchHdrVO =
        ADFUtils.findIterator("searchRetReleaseROVO1Iterator").getViewObject();

    public void quickSearch(ActionEvent actionEvent) {

        if (it1.getValue() != null) {
            ViewCriteria vc = conSearchHdrVO.createViewCriteria();
            ViewCriteriaRow vcr = vc.createViewCriteriaRow();
            vcr.setAttribute("RetRelNumber", "like %" + it1.getValue() + "%");
            vc.addRow(vcr);
            conSearchHdrVO.applyViewCriteria(vc);
            conSearchHdrVO.executeQuery();
            System.err.println("111111111111111");
        } else {
            //ViewObject conHdrVO = ADFUtils.findIterator("contractROVO1Iterator").getViewObject();
            ViewCriteria vc = conSearchHdrVO.createViewCriteria();
            ViewCriteriaRow vcr = vc.createViewCriteriaRow();
            vcr.setAttribute("RetRelNumber", "");
            vc.addRow(vcr);
            conSearchHdrVO.applyViewCriteria(vc);
            conSearchHdrVO.executeQuery();
            System.err.println("2222222222222");
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(resId1);

    }
}
