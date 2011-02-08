/**
 * 
 */
package com.sap.furcas.runtime.tcs;

import com.sap.furcas.metamodel.FURCAS.TCS.QualifiedNamedElement;
import com.sap.furcas.runtime.common.util.QualifiedNamesHelper;


/**
 *
 */
public class MessageHelper {

    public static String getTemplateName(QualifiedNamedElement template) {
        if (template.getNames() != null && template.getNames().size() > 0) {
            return QualifiedNamesHelper.getQualifiedString(template.getNames());
        } else if (template.getMetaReference() != null) {
            return QualifiedNamesHelper.getQualifiedString(TcsUtil.getQualifiedName(template.getMetaReference()));
        } else {
            return "<Bug: template without name or reference>";
        }
    }
    
}
