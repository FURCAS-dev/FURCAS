package com.sap.ide.cts.editor.prettyprint;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.tcs.TcsUtil;

public class MOINImportedModelAdapter {

//    public static Object get(RefStruct me, String propName) {
//	if (me == null || propName == null) {
//	    return null;
//	}
//
//	RefStruct ref = me;
//
//	return ref.refGetValue(propName);
//    }
//
//    public static boolean getBool(RefStruct me, String propName) {
//	return (Boolean) get(me, propName);
//    }
//
//    public static boolean getBoolUndefinedIsFalse(RefStruct me, String propName) {
//	Object result = get(me, propName);
//	if (result == null) {
//	    return false;
//	}
//
//	return (Boolean) result;
//    }
//
//    public static Iterator<?> getCol(RefStruct me, String propName) {
//	Collection<?> c = (Collection<?>) get(me, propName);
//	return c.iterator();
//    }
//
//    public static int getInt(RefStruct me, String propName) {
//	return (Integer) get(me, propName);
//    }
//
//    public static RefStruct getME(RefStruct me, String propName) {
//	return (RefStruct) get(me, propName);
//    }
//
//    public static String getName(RefStruct me) {
//	return getString(me, "name");
//    }
//
//    public static String getString(RefStruct me, String propName) {
//	try {
//	    return (String) get(me, propName);
//	} catch (Exception e) {
//	    e.printStackTrace();
//	    return null;
//	}
//    }

    public static Object get(EObject me, String propName) {
	if (me == null || propName == null) {
	    return null;
	}
	return me.eGet(me.eClass().getEStructuralFeature(propName));
//	EObject ref = me;
//	JmiHelper jmiHelper = me.get___Connection().getJmiHelper();
//	EClass c = me.eClass();
//	if (jmiHelper.getAttributeByName(c, propName, /* includeSupertypes */true) != null
//		|| jmiHelper.getReferenceByName(c, propName, /* includeSupertypes */
//		true) != null) {
//	    return ref.refGetValue(propName);
//	} else {
//	    // try unexposed association end
//	    Set<AssociationEnd> assocEnds = jmiHelper.getAssociationEnds(c, /* includeSupertypes */
//	    true);
//	    for (AssociationEnd ae : assocEnds) {
//		if (ae.otherEnd().getName().equals(propName)) {
//		    RefAssociation ra = jmiHelper.getRefAssociationForAssociation((Association) ae.getContainer());
//		    return ra.refQuery(ae, me);
//		}
//	    }
//	    throw new RuntimeException("Property or association end " + propName + " not found on " + me);
//	}
    }

    public static boolean getBool(EObject me, String propName) {
	return (Boolean) get(me, propName);
    }

    public static boolean getBoolUndefinedIsFalse(EObject me, String propName) {
	Object result = get(me, propName);
	if (result == null) {
	    return false;
	}

	return (Boolean) result;
    }

    public static Iterator<?> getCol(EObject me, String propName) {
	Collection<?> c = (Collection<?>) get(me, propName);
	return c.iterator();
    }

    public static String getEnumLiteralName(EEnumLiteral me) {

	return me.toString();
    }

    public static int getInt(EObject me, String propName) {
	return (Integer) get(me, propName);
    }

    public static EObject getME(EObject me, String propName) {
	return (EObject) get(me, propName);
    }

    public static Object getMetaobject(EObject me) {
	if (me != null) {
	    EObject r = me;
	    return r.eClass();
	} else {
	    return null;
	}
    }

    public static String getName(EObject me) {
	return getString(me, "name");
    }

    public static String getString(EObject me, String propName) {
	try {
	    return (String) get(me, propName);
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}
    }

    public static String getTypeName(EObject me) {
	if (me != null) {
	    EObject r = me;
	    if (r.eClass() instanceof EClass) {
		EClass c = r.eClass();
		return TcsUtil.joinNameList(EcoreHelper.getQualifiedName(c));
	    }
	}

	return null;

    }

    public static List<String> getQualifiedName(EObject me) {
	if (me != null) {
	    EObject r = me;
	    if (r.eClass() instanceof EClass) {
		EClass c = r.eClass();
		return EcoreHelper.getQualifiedName(c);
	    }
	}

	return null;

    }

    public static boolean isPrimitive(Object value) {
	return ((value instanceof String) || (value instanceof Boolean) || (value instanceof Double) || (value instanceof Integer));
    }

    public static String nextString(Iterator<?> i) {
	return (String) i.next();
    }

    public static Object refImmediateComposite(EObject me) {
	if (me != null) {
	    EObject r = me;
	    return r.eContainer();
	} else {
	    return null;
	}
    }

}
