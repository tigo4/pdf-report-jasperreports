package reports.jasper;

import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JRDesignStyle;
import net.sf.jasperreports.engine.design.JRDesignTextField;

public class Common {

    public static JRDesignStaticText getStaticText(int X, int Y, int width,
            int height, String text, JRDesignStyle style) {

        JRDesignStaticText staticText = new JRDesignStaticText();
                           staticText.setX(X);
                           staticText.setY(Y);
                           staticText.setWidth(width);
                           staticText.setHeight(height);
                           staticText.setText(text);
                           staticText.setStyle(style);
                           //staticText.setHorizontalAlignment(JRAlignment.HORIZONTAL_ALIGN_RIGHT);

        return staticText;

    }

    public static JRDesignTextField getTextField(int X, int Y, int width,
            int height, JRDesignStyle style, float fontSize, String expressionText) {

        JRDesignTextField textField = new JRDesignTextField();
        //textField.setBlankWhenNull(true);
        textField.setX(X);
        textField.setY(Y);
        textField.setWidth(width);
        textField.setHeight(height);
        textField.setStyle(style);
        textField.setFontSize(fontSize);
        //textField.setHorizontalAlignment(HorizontalAlignEnum.CENTER);
        JRDesignExpression expression = new JRDesignExpression();
        expression.setText(expressionText);
        //expression.setValueClass(java.lang.String.class);
        textField.setExpression(expression);
               
        return textField;
    
    }
    
}
