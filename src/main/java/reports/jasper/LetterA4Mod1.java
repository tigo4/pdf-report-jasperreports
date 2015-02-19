package reports.jasper;

import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignField;
import net.sf.jasperreports.engine.design.JRDesignParameter;
import net.sf.jasperreports.engine.design.JRDesignStyle;
import net.sf.jasperreports.engine.design.JasperDesign;

public interface LetterA4Mod1 {

    public void setName(String name);
    public void setDimensions(int pageWidth, int pageHeight, int columnWidth,
                int columnSpacing, int leftMargin, int rightMargin, int topMargin, int bottomMargin
            );    
    public void setNormalStyle(JRDesignStyle normalStyle) throws Exception;
    public void setBoldStyle(JRDesignStyle boldStyle) throws Exception;
    public void addParameter(JRDesignParameter parameter) throws Exception;
    public void addField(JRDesignField field) throws Exception;
    public void setTitleBand(JRDesignBand band);
    public JasperDesign getJasperDesign();
    public void setPageHeader(int height) throws Exception;
    public void setPageDetail(int height) throws Exception;
    public void setPageFooter(int height) throws Exception;
    public void compile(String fileName) throws Exception;
    public void print(String fileName) throws Exception;

}
