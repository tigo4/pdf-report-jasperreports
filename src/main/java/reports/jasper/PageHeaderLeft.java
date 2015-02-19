package reports.jasper;

import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignStyle;

public class PageHeaderLeft {

   public static JRDesignBand getPageHeaderLeft(JRDesignBand band, JRDesignStyle normalStyle, JRDesignStyle boldStyle) throws Exception {

       band.addElement(
               Common.getStaticText(18, 10, 65, 15, "N.° issue: ", boldStyle) );
       
       band.addElement(
               Common.getTextField(71, 10, 120, 15, normalStyle, 8.5f, "$F{nrSinistro}") );

       band.addElement(
               Common.getStaticText(18, 28, 100, 15, "Data de ocorrência: ", boldStyle) );

       band.addElement(
               Common.getTextField(103, 28, 120, 15, normalStyle, 9.0f, "$F{date}") );

       band.addElement(
               Common.getStaticText(18, 46, 100, 15, "N.° ref: ", boldStyle) );

       band.addElement(
               Common.getTextField(83, 47, 120, 15, normalStyle, 9.0f, "$F{apolice}") );

       band.addElement(
               Common.getStaticText(18, 64, 100, 15, "Name of: ", boldStyle) );

       band.addElement(
               Common.getTextField(106, 65, 120, 15, normalStyle, 9.0f, "$F{name}") );

       band.addElement(
               Common.getTextField(18, 83, 120, 15, normalStyle, 9.0f, "$F{name2}") );
       
       return band;
                
   }
   
}

