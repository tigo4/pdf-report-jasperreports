package jasper.test;

import java.awt.Color;

import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignField;
import net.sf.jasperreports.engine.design.JRDesignImage;
import net.sf.jasperreports.engine.design.JRDesignParameter;
import net.sf.jasperreports.engine.design.JRDesignStyle;
import net.sf.jasperreports.engine.type.ModeEnum;

import org.junit.Test;

import reports.jasper.REP001;
import reports.jasper.LetterA4Mod1;


public class REP001Test {

    @Test
    public void test() throws Exception {
        
        LetterA4Mod1 REP001 = new REP001();
        REP001.setName("REP001");
        REP001.setDimensions(595, 841, 512, 0, 43, 40, 40, 0
                );

        //Fonts
        JRDesignStyle normalStyle = new JRDesignStyle();
        normalStyle.setName("Arial_Normal");
        normalStyle.setDefault(true);
        normalStyle.setFontName("Arial");
        normalStyle.setFontSize(8.0f);
        normalStyle.setPdfFontName("Helvetica");
        normalStyle.setPdfEncoding("Cp1252");
        normalStyle.setPdfEmbedded(false);
        //normalStyle.setBorderColor(Color.GREEN);
        normalStyle.setBackcolor(Color.RED);
        normalStyle.setForecolor(Color.BLACK);
        normalStyle.setMode(ModeEnum.TRANSPARENT);
        //normalStyle.setMode(ModeEnum.OPAQUE);
        REP001.setNormalStyle(normalStyle);

        JRDesignStyle boldStyle = new JRDesignStyle();
        boldStyle.setName("Arial_Bold");
        boldStyle.setFontName("Arial");
        boldStyle.setFontSize(8.7f);
        boldStyle.setBold(true);
        boldStyle.setPdfFontName("Helvetica-Bold");
        boldStyle.setPdfEncoding("Cp1252");
        boldStyle.setPdfEmbedded(false);
        boldStyle.setBackcolor(Color.GREEN);
        boldStyle.setForecolor(Color.BLACK);
        boldStyle.setMode(ModeEnum.TRANSPARENT);
        //boldStyle.setMode(ModeEnum.OPAQUE);
        REP001.setBoldStyle(boldStyle);

        //Parameters HashMap
        JRDesignParameter parameter = new JRDesignParameter();
        parameter.setName("body");
        parameter.setValueClass(java.lang.String.class);
        REP001.addParameter(parameter);
        
        //Fields JSON
        JRDesignField field = new JRDesignField();
        field.setName("nrSinistro");
        field.setValueClass(java.lang.String.class);
        REP001.addField(field);
        field = new JRDesignField();
        field.setName("date");
        field.setValueClass(java.lang.String.class);
        REP001.addField(field);
        field = new JRDesignField();
        field.setName("apolice");
        field.setValueClass(java.lang.String.class);
        REP001.addField(field);
        field = new JRDesignField();
        field.setName("name");
        field.setValueClass(java.lang.String.class);
        REP001.addField(field);
        field = new JRDesignField();
        field.setName("name2");
        field.setValueClass(java.lang.String.class);
        REP001.addField(field);
        field = new JRDesignField();
        field.setName("address1");
        field.setValueClass(java.lang.String.class);
        REP001.addField(field);
        field = new JRDesignField();
        field.setName("address2");
        field.setValueClass(java.lang.String.class);
        REP001.addField(field);
        field = new JRDesignField();
        field.setName("address3");
        field.setValueClass(java.lang.String.class);
        REP001.addField(field);
        field = new JRDesignField();
        field.setName("elements");
        field.setValueClass(java.lang.String.class);
        REP001.addField(field);
        field = new JRDesignField();
        field.setName("phone");
        field.setValueClass(java.lang.String.class);
        REP001.addField(field);
        field = new JRDesignField();
        field.setName("wps");
        field.setValueClass(java.lang.String.class);
        REP001.addField(field);

        //Title Image
        JRDesignBand band = new JRDesignBand();
        band.setHeight(55);
        String imgPath = "\"REP001-1_1.png\"";
        JRDesignExpression expression = new JRDesignExpression();
        expression.setText(imgPath);
        //expression.setValueClass(java.lang.String.class);
        JRDesignImage image = new JRDesignImage(REP001.getJasperDesign());
        image.setX(0);
        image.setY(0);
        image.setWidth(217);
        image.setHeight(32);
        //image.setScaleImage(ScaleImageEnum.FILL_FRAME);
        image.setExpression(expression);
        band.addElement(image);
        REP001.setTitleBand(band);

        REP001.setPageHeader(200);

        REP001.setPageDetail(333);

        REP001.setPageFooter(150);

        REP001.compile("test_REP001_report");
        REP001.print("test_REP001_report");

        return;

    }

}
