package com.sap.furcas.runtime.textblocks.shortprettyprint;

import java.util.regex.Matcher;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.ReferenceByPArg;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;
import com.sap.furcas.runtime.tcs.PropertyArgumentUtil;
import com.sap.furcas.utils.StringUtil;

public class PrettyPrinterUtil {
    
    /**
     * Quote the given string value according to the rules defined by associated PrimitiveTemplate.
     */
    public static String escapeUsingSerializer(String value, PrimitiveTemplate template) {
        if (template != null && template.getSerializer() != null && !template.getSerializer().equals("")) {
            String serializer = StringUtil.unescapeString(template.getSerializer());
            String escapedValue = (value).replaceAll("\"", Matcher.quoteReplacement("\\\""));
            return serializer.replaceAll("%value%", Matcher.quoteReplacement(escapedValue));
        } else {
            return value;
        }
    }
    
    public static String invertReferenceByQuery(EObject self, Property property, TCSSpecificOCLEvaluator oclEvaluator) throws ModelAdapterException {
        ReferenceByPArg referenceBy = PropertyArgumentUtil.getReferenceByPArg(property);
        String invertQuery = PropertyArgumentUtil.getReferenceByAsOCL(referenceBy);
        try {
            String value = (String) oclEvaluator.findElementsWithOCLQuery(self, /*keyValue*/null, invertQuery).iterator().next();
            return PropertyArgumentUtil.stripPrefixPostfix(value, PropertyArgumentUtil.getPrefixPArg(property), PropertyArgumentUtil.getPostfixPArg(property));
        } catch (ModelAdapterException e) {
            throw new ModelAdapterException("Unable to serialize referenced model element: " + e.getMessage(), e);
        }
    }

}
