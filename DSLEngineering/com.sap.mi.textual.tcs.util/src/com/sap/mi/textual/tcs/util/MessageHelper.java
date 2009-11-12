/**
 * 
 */
package com.sap.mi.textual.tcs.util;

import java.util.List;

import com.sap.mi.textual.common.util.QualifiedNamesHelper;

import tcs.QualifiedNamedElement;


/**
 *
 */
public class MessageHelper {

    public static String getTemplateName(QualifiedNamedElement template) {
        if (template.getNames() != null && template.getNames().size() > 0) {
            return QualifiedNamesHelper.getQualifiedString(template.getNames());
        } else if (template.getMetaReference() != null) {
            List<String> nameList = template.getMetaReference().getQualifiedName();
            return QualifiedNamesHelper.getQualifiedString(nameList);
        } else {
            return "<Bug: template without name or reference>";
        }
    }
    
}
