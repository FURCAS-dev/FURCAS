package com.sap.ide.cts.editor.prettyprint;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sap.furcas.textual.tcs.TcsUtil;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

public class MOINImportedModelAdapter {
    
    public static Object get(RefStruct me, String propName) {
        if (me == null || propName == null) {
                return null;
        }

        RefStruct ref = me;

        return ref.refGetValue(propName);
    }
    
    public static boolean getBool(RefStruct me, String propName) {
            return (Boolean) get(me, propName);
    }
    
    public static boolean getBoolUndefinedIsFalse(RefStruct me, String propName) {
            Object result = get(me, propName);
            if (result == null) {
                    return false;
            }
    
            return (Boolean) result;
    }
    
    public static Iterator<?> getCol(RefStruct me, String propName) {
            Collection<?> c = (Collection<?>) get(me, propName);
            return c.iterator();
    }
    
    public static int getInt(RefStruct me, String propName) {
            return (Integer) get(me, propName);
    }
    
    public static RefStruct getME(RefStruct me, String propName) {
            return (RefStruct) get(me, propName);
    }
    
    public static String getName(RefStruct me) {
            return getString(me, "name");
    }
    
    public static String getString(RefStruct me, String propName) {
            try {
                    return (String) get(me, propName);
            } catch (Exception e) {
                    e.printStackTrace();
                    return null;
            }
    }

	public static Object get(RefObject me, String propName) {
		if (me == null || propName == null) {
			return null;
		}

		RefObject ref = me;
		JmiHelper jmiHelper = me.get___Connection().getJmiHelper();
		MofClass c = (MofClass) me.refMetaObject();
		if (jmiHelper
				.getAttributeByName(c, propName, /* includeSupertypes */true) != null
				|| jmiHelper.getReferenceByName(c, propName, /* includeSupertypes */
						true) != null) {
			return ref.refGetValue(propName);
		} else {
			// try unexposed association end
			Set<AssociationEnd> assocEnds = jmiHelper.getAssociationEnds(c, /* includeSupertypes */
					true);
			for (AssociationEnd ae : assocEnds) {
				if (ae.otherEnd().getName().equals(propName)) {
					RefAssociation ra = jmiHelper
							.getRefAssociationForAssociation((Association) ae
									.getContainer());
					return ra.refQuery(ae, me);
				}
			}
			throw new RuntimeException("Property or association end "
					+ propName + " not found on " + me);
		}
	}

	public static boolean getBool(RefObject me, String propName) {
		return (Boolean) get(me, propName);
	}

	public static boolean getBoolUndefinedIsFalse(RefObject me, String propName) {
		Object result = get(me, propName);
		if (result == null) {
			return false;
		}

		return (Boolean) result;
	}

	public static Iterator<?> getCol(RefObject me, String propName) {
		Collection<?> c = (Collection<?>) get(me, propName);
		return c.iterator();
	}

	public static String getEnumLiteralName(RefEnum me) {

		return me.toString();
	}

	public static int getInt(RefObject me, String propName) {
		return (Integer) get(me, propName);
	}

	public static RefObject getME(RefObject me, String propName) {
		return (RefObject) get(me, propName);
	}

	public static Object getMetaobject(RefObject me) {
		if (me != null) {
			RefObject r = me;
			return r.refMetaObject();
		} else {
			return null;
		}
	}

	public static String getName(RefObject me) {
		return getString(me, "name");
	}

	public static String getString(RefObject me, String propName) {
		try {
			return (String) get(me, propName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getTypeName(RefObject me) {
		if (me != null) {
			RefObject r = me;
			if (r.refMetaObject() instanceof MofClass) {
				MofClass c = (MofClass) r.refMetaObject();
				return TcsUtil.joinNameList(c.getQualifiedName());
			}
		}

		return null;

	}

	public static List<String> getQualifiedName(RefObject me) {
		if (me != null) {
			RefObject r = me;
			if (r.refMetaObject() instanceof MofClass) {
				MofClass c = (MofClass) r.refMetaObject();
				return c.getQualifiedName();
			}
		}

		return null;

	}

	public static boolean isPrimitive(Object value) {
		return ((value instanceof String) || (value instanceof Boolean)
				|| (value instanceof Double) || (value instanceof Integer));
	}

	public static String nextString(Iterator<?> i) {
		return (String) i.next();
	}

	public static Object refImmediateComposite(RefObject me) {
		if (me != null) {
			RefObject r = me;
			return r.refImmediateComposite();
		} else {
			return null;
		}
	}

}
