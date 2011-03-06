package com.sap.furcas.runtime.textblocks.shortprettyprint;

import java.util.regex.Matcher;

import com.sap.furcas.metamodel.FURCAS.TCS.AsPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.utils.StringUtil;

public class PrettyPrinterUtil {

    public static String printUsingSerializer(String value, PrimitiveTemplate template) {
        if (template != null && template.getSerializer() != null && !template.getSerializer().equals("")) {
            String serializer = StringUtil.unescapeString(template.getSerializer());
            return serializer.replaceAll("%value%", Matcher.quoteReplacement(value));
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
