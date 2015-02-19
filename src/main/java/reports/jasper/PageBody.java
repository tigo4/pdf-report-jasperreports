package reports.jasper;

import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JRDesignStyle;
import net.sf.jasperreports.engine.design.JRDesignTextField;
import net.sf.jasperreports.engine.type.HorizontalAlignEnum;
import net.sf.jasperreports.engine.type.LineSpacingEnum;

public class PageBody {
    
    public static JRDesignBand getPageBody(JRDesignBand band, JRDesignStyle normalStyle, JRDesignStyle boldStyle) throws Exception {
            
        band.addElement(
                Common.getStaticText(18, 31, 100, 15, "ASSUNTO: ", boldStyle) );

        JRDesignStaticText staticText = Common.getStaticText(65, 32, 200, 15, "Pedido de informações ", normalStyle);
        staticText.setFontSize(9.0f);
        band.addElement(staticText);

        staticText = Common.getStaticText(18, 74, 200, 15, "Ex.mo(a) Senhor(a), ", normalStyle);
        staticText.setFontSize(9.0f);
        band.addElement(staticText);   

        JRDesignTextField textField = Common.getTextField(18, 118, 480, 15, normalStyle, 9.0f, "$P{body}");
        textField.setHorizontalAlignment(HorizontalAlignEnum.JUSTIFIED);
        textField.setStretchWithOverflow(true);
        textField.setLineSpacing(LineSpacingEnum.DOUBLE);        
        band.addElement(
                textField
                 );
       
        band.addElement(
                Common.getTextField(18, 147, 250, 15, normalStyle, 9.0f, "$F{elements}") );

        staticText = Common.getStaticText(18, 165, 480, 15, "Para   qualquer   esclarecimento   complementar,   agradecemos   que   nos   contacte   directamente  pelo  telefone  n.°", normalStyle);
        staticText.setFontSize(9.0f);
        band.addElement(staticText);

        band.addElement(
                Common.getTextField(18, 180, 120, 15, normalStyle, 9.0f, "$F{phone}") );

        staticText = Common.getStaticText(63, 180, 480, 15, ".", normalStyle);
        staticText.setFontSize(9.0f);
        band.addElement(staticText);

        staticText = Common.getStaticText(18, 220, 480, 15, "Apresentamos os nossos melhores cumprimentos,", normalStyle);
        staticText.setFontSize(9.0f);
        band.addElement(staticText);

        staticText = Common.getStaticText(192, 262, 480, 15, "Company sig", normalStyle);
        staticText.setFontSize(9.0f);
        band.addElement(staticText);

        band.addElement(
                Common.getTextField(207, 318, 120, 15, normalStyle, 9.0f, "$F{wps}") );

        return band;
        
    }

}
