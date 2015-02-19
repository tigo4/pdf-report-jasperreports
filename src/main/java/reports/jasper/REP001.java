package reports.jasper;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JsonDataSource;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignField;
import net.sf.jasperreports.engine.design.JRDesignParameter;
import net.sf.jasperreports.engine.design.JRDesignSection;
import net.sf.jasperreports.engine.design.JRDesignStyle;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;

public class REP001 implements LetterA4Mod1 {
    
    private JasperDesign jasperDesign = new JasperDesign();
    
    public void setName(String name) {
        jasperDesign.setName(name);
    }
    
    public void setDimensions(int pageWidth, int pageHeight, int columnWidth,
            int columnSpacing, int leftMargin, int rightMargin, int topMargin, int bottomMargin
        ) {

        jasperDesign.setPageWidth(pageWidth);
        jasperDesign.setPageHeight(pageHeight);
        jasperDesign.setColumnWidth(columnWidth);
        jasperDesign.setColumnSpacing(columnSpacing);
        jasperDesign.setLeftMargin(leftMargin);
        jasperDesign.setRightMargin(rightMargin);
        jasperDesign.setTopMargin(topMargin);
        jasperDesign.setBottomMargin(bottomMargin);
        
    }

    private JRDesignStyle normalStyle;
    public void setNormalStyle(JRDesignStyle normalStyle) throws Exception {
        jasperDesign.addStyle(normalStyle);
        this.normalStyle = normalStyle;
    }

    private JRDesignStyle boldStyle;
    public void setBoldStyle(JRDesignStyle boldStyle) throws Exception {
        jasperDesign.addStyle(boldStyle);
        this.boldStyle = boldStyle;
    }

    public void addParameter(JRDesignParameter parameter) throws Exception {
        jasperDesign.addParameter(parameter);
    }

    public void addField(JRDesignField field) throws Exception {
        jasperDesign.addField(field);
    }

    public void setTitleBand(JRDesignBand band) {
        jasperDesign.setTitle(band);
    }
    
    public JasperDesign getJasperDesign() {
        return jasperDesign;
    }
    
    public void setPageHeader(int height) throws Exception {
        //PageHeader
        JRDesignBand band = new JRDesignBand();
        band.setHeight(height);
        band = PageHeaderLeft.getPageHeaderLeft(band, normalStyle, boldStyle);
        band = PageHeaderRight.getPageHeaderRight(band, normalStyle, boldStyle);
        jasperDesign.setPageHeader(band);
    }

    public void setPageDetail(int height) throws Exception {
        //Detail
        JRDesignBand band = new JRDesignBand();
        band.setHeight(height);
        band = PageBody.getPageBody(band, normalStyle, boldStyle);
        ((JRDesignSection)jasperDesign.getDetailSection()).addBand(band);
    }

    public void setPageFooter(int height) throws Exception {
        //Footer
        JRDesignBand band = new JRDesignBand();
        band.setHeight(150);
        band = PageFooter.getPageFooter(band, normalStyle, boldStyle);
        jasperDesign.setPageFooter(band);
    }
    
    public void compile(String fileName) throws Exception {
        long start = System.currentTimeMillis();
        JasperDesign jasperDesign = getJasperDesign();
        JasperCompileManager.compileReportToFile(jasperDesign, "target/" + fileName + ".jasper");
        System.out.println("Compile time : " + (System.currentTimeMillis() - start));
    }
      
    public void print(String fileName) throws Exception {
        JasperReport jasperReport = (JasperReport)JRLoader.loadObject(new File("target/" + fileName + ".jasper"));
        String body = "Nos  termos  previstos  nas  condições  especiais  do  presente  seguro,  " + 
        "com  vista  a  completar  a  instrução  do  processo acima referenciado, agradecemos que nos " +
        "faculte os seguintes elementos: ";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("body", body);
        File json = new File("report.json");
        JRDataSource ds = new JsonDataSource(json);
        JasperPrint print = JasperFillManager.fillReport(jasperReport, map, ds);
        File pdf = new File("target/" + fileName + ".pdf");
        JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
    }

}

