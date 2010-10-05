package com.sap.furcas.textual.textblocks.shortprettyprint;

import com.sap.furcas.metamodel.TCS.AsPArg;
import com.sap.furcas.metamodel.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.TCS.Template;

public class PrettyPrinterUtil {

    public static String printUsingSerializer(String value, Template template) {
        if (template != null && template instanceof PrimitiveTemplate) {
            if (((PrimitiveTemplate) template).getSerializer() != null
                    && !((PrimitiveTemplate) template).getSerializer().equals(
                            "")) {
                PrimitiveTemplate primTemplate = (PrimitiveTemplate) template;
                if (primTemplate.getSerializer().contains("%value%")) {
                    return primTemplate.getSerializer()
                            .replaceAll(
                                    "%value%",
                                    java.util.regex.Matcher
                                            .quoteReplacement(( value)
                                                    .replaceAll("\"",
                                                            "\\\\\\\"")));
                }
                else return primTemplate.getSerializer();
            } else {
                return value;
            }
        } else {
            return value;
        }
    }

    public static PrimitiveTemplate getAsTemplate(AsPArg asParg) {
        PrimitiveTemplate primitiveTemplateName = null;

        if (asParg != null) {
            Template asTemplate = asParg.getTemplate();
            if (asTemplate instanceof PrimitiveTemplate) {
                PrimitiveTemplate prim = (PrimitiveTemplate) asTemplate;
                primitiveTemplateName = prim;
            }
        }
        return primitiveTemplateName;
    }

}
