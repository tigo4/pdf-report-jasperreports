package reports.jasper;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JRDesignStyle;
import net.sf.jasperreports.engine.type.RotationEnum;


public class PageFooter {

    public static JRDesignBand getPageFooter(JRDesignBand band, JRDesignStyle normalStyle, JRDesignStyle boldStyle) throws Exception {
        
        JRDesignStaticText staticText = Common.getStaticText(3, -95, 200, 150, "AB20.002             Processado por computador", normalStyle);
        staticText.setFontSize(7.0f);
        staticText.setRotation(RotationEnum.LEFT);
        band.addElement(staticText);   

        staticText = Common.getStaticText(13, 96, 480, 15, "Company name", normalStyle);
        staticText.setFontSize(6.0f);
        band.addElement(staticText);   

        staticText = Common.getStaticText(13, 105, 480, 15, "Address    000-0000 Lisboa PORTUGAL     Tel.: (+351) 00 11 22 33 Fax: (+351) 00 11 22 33    Company     Tel.: 606 24 4 123 (Tecla 6)", normalStyle);
        staticText.setFontSize(6.0f);
        band.addElement(staticText);   

        staticText = Common.getStaticText(13, 113, 480, 15, "Addrss: aaaaaaaaaaaaaaaaaaaaaaaa, 11-11o - 10000-000 Lisboa PORTUGAL - Capital Social € 1 (bbbbb) - N.o 000 111 222, de pessoa colectiva e de matrícula na C.R.C. de", normalStyle);
        staticText.setFontSize(4.5f);
        band.addElement(staticText);   

        staticText = Common.getStaticText(13, 119, 480, 15, "Lisboa", normalStyle);
        staticText.setFontSize(4.5f);
        band.addElement(staticText);   

        staticText = Common.getStaticText(13, 124, 480, 15, "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc", normalStyle);
        staticText.setFontSize(4.5f);
        band.addElement(staticText);   

        band.addElement(
                Common.getTextField(470, 95, 120, 15, normalStyle, 9.0f, "\"Pág.:  \" + $V{PAGE_NUMBER}.toString() + \"/\" + $V{PAGE_NUMBER}.toString()") );

        return band;
    }
}
