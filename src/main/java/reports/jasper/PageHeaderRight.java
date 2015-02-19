package reports.jasper;

import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JRDesignStyle;

public class PageHeaderRight {

    public static JRDesignBand getPageHeaderRight(JRDesignBand band, JRDesignStyle normalStyle, JRDesignStyle boldStyle) throws Exception {

        JRDesignStaticText staticText = Common.getStaticText(257, 43, 165, 13, "Ex.mo(a) Senhor(a)", boldStyle);
        staticText.setFontSize(9.5f);
        band.addElement(staticText);

        band.addElement(
                Common.getTextField(257, 65, 200, 15, normalStyle, 9.0f, "$F{address1}") );

        band.addElement(
                Common.getTextField(257, 78, 200, 15, normalStyle, 9.0f, "$F{address2}") );

        band.addElement(
                Common.getTextField(257, 90, 200, 15, normalStyle, 9.0f, "$F{address3}") );

        staticText = Common.getStaticText(257, 185, 165, 13, "Lisboa, 18 de Junho de 2015", normalStyle);
        staticText.setFontSize(9.0f);
        band.addElement(staticText);

        return band;
        
    }
}
