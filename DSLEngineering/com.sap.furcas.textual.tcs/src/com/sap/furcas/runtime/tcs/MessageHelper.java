/**
 * 
 */
package com.sap.furcas.runtime.tcs;

import com.sap.furcas.metamodel.TCS.QualifiedNamedElement;
import com.sap.furcas.runtime.common.util.QualifiedNamesHelper;


/**
 *
 */
public class MessageHelper {

    public static String getTemplateName(QualifiedNamedElement template) {
        if (template.getNames() != null && template.getNames().size() > 0) {
            return QualifiedNamesHelper.getQualifiedString(template.getNames());
        } else if (template.getMetaReference() != null) {
            // FIXME unknown method?
//            EList<String> nameList = template.getMetaReference().getQualifiedName();
//            return QualifiedNamesHelper.getQualifiedString(nameList);
            throw new RuntimeException("Migration TODO");
        } else {
            return "<Bug: template without name or reference>";
        }
    }
    
}
