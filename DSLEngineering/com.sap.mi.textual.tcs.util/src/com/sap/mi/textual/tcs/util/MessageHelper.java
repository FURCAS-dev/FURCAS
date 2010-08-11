/**
 * 
 */
package com.sap.mi.textual.tcs.util;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import com.sap.furcas.metamodel.TCS.QualifiedNamedElement;
import com.sap.mi.textual.common.util.QualifiedNamesHelper;


/**
 *
 */
public class MessageHelper {

    public static String getTemplateName(QualifiedNamedElement template) {
        if (template.getNames() != null && template.getNames().size() > 0) {
            return QualifiedNamesHelper.getQualifiedString(template.getNames());
        } else if (template.getMetaReference() != null) {
            EList<String> nameList = template.getMetaReference().getQualifiedName();
            return QualifiedNamesHelper.getQualifiedString(nameList);
        } else {
            return "<Bug: template without name or reference>";
        }
    }
    
}
