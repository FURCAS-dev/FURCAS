package com.sap.ide.cts.editor.prettyprint;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
>>>>>>> 339c4f6827f2205a0254bfb911d75ecfc4a51698

public class MOINImportedModelAdapter {
    
    public static Object get(EStructuralFeature me, String propName) {
        if (me == null || propName == null) {
                return null;
        }

        EStructuralFeature ref = me;

        return ref.refGetValue(propName);
    }
    
    public static boolean getBool(EStructuralFeature me, String propName) {
            return (Boolean) get(me, propName);
    }
    
    public static boolean getBoolUndefinedIsFalse(EStructuralFeature me, String propName) {
            Object result = get(me, propName);
            if (result == null) {
                    return false;
            }
    
            return (Boolean) result;
    }
    
    public static Iterator<?> getCol(EStructuralFeature me, String propName) {
            Collection<?> c = (Collection<?>) get(me, propName);
            return c.iterator();
    }
    
    public static int getInt(EStructuralFeature me, String propName) {
            return (Integer) get(me, propName);
    }
    
    public static EStructuralFeature getME(EStructuralFeature me, String propName) {
            return (EStructuralFeature) get(me, propName);
    }
    
    public static String getName(EStructuralFeature me) {
            return getString(me, "name");
    }
    
    public static String getString(EStructuralFeature me, String propName) {
            try {
                    return (String) get(me, propName);
            } catch (Exception e) {
                    e.printStackTrace();
                    return null;
            }
    }

	public static Object get(EObject me, String propName) {
		if (me == null || propName == null) {
			return null;
		}

		EObject ref = me;
		JmiHelper jmiHelper = me.get___Connection().getJmiHelper();
		EClass c = (EClass) me.refMetaObject();
		if (jmiHelper
				.getAttributeByName(c, propName, /* includeSupertypes */true) != null
				|| jmiHelper.getReferenceByName(c, propName, /* includeSupertypes */
						true) != null) {
			return ref.refGetValue(propName);
		} else {
			// try unexposed association end
			Set<EReference> assocEnds = jmiHelper.getAssociationEnds(c, /* includeSupertypes */
					true);
			for (EReference ae : assocEnds) {
				if (ae.getEOpposite().getName().equals(propName)) {
					EReference ra = jmiHelper
							.getRefAssociationForAssociation((EReference) ae
									.eContainer());
					return ra.refQuery(ae, me);
				}
			}
			throw new RuntimeException("Property or association end "
					+ propName + " not found on " + me);
		}
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

	public static String getEnumLiteralName(RefEnum me) {

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
			return r.refMetaObject();
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
			if (r.refMetaObject() instanceof EClass) {
				EClass c = (EClass) r.refMetaObject();
				return TcsUtil.joinNameList(c.getQualifiedName());
			}
		}

		return null;

	}

	public static List<String> getQualifiedName(EObject me) {
		if (me != null) {
			EObject r = me;
			if (r.refMetaObject() instanceof EClass) {
				EClass c = (EClass) r.refMetaObject();
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

	public static Object refImmediateComposite(EObject me) {
		if (me != null) {
			EObject r = me;
			return r.refImmediateComposite();
		} else {
			return null;
		}
	}

}
