package com.sap.mi.gfw.pattern.template;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldDescriptor;

/**
 * The Class XPath.
 */
public class XPath {

    /**
     * Calculate path.
     * 
     * @param mainShape
     *            the main shape
     * @param pe
     *            the pe
     * 
     * @return the string
     */
    public static String calculatePath(Shape mainShape, RefObject pe) {
        if (pe == null || pe.equals(mainShape))
            return ""; //$NON-NLS-1$
        else if (mainShape instanceof ContainerShape) {
            ContainerShape cs = (ContainerShape) mainShape;
            List<Shape> l = cs.getChildren();
            for (int i = 0; i < l.size(); i++) {
                Shape subshape = l.get(i);
                String result = calculatePath(subshape, pe);
                if (result != null)
                    return pathcat("children[" + i + "]", result); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
        String result = calculatePathInGA(mainShape.getGraphicsAlgorithm(), pe);
        if (result != null) {
            return pathcat("graphicsAlgorithm", result); //$NON-NLS-1$
        }
        return null;
    }

    /**
     * Calculate path.
     * 
     * @param mainShape
     *            the main shape
     * @param pe
     *            the pe
     * @param propertyName
     *            the property name
     * 
     * @return the string
     */
    public static String calculatePath(Shape mainShape, RefObject pe, String propertyName) {
        String result = calculatePath(mainShape, pe);
        if (propertyName.startsWith("@", 0)) //$NON-NLS-1$
            return pathcat(result, propertyName);
        else
            return pathcat(result, "@" + propertyName); //$NON-NLS-1$
    }

    private static String pathcat(String s1, String s2) {
        if (s2 == null || s2.length() == 0)
            return s1;
        if (s1 == null || s1.length() == 0)
            return s2;
        else
            return s1 + "/" + s2; //$NON-NLS-1$
    }

    private static String calculatePathInGA(GraphicsAlgorithm ga, RefObject pe) {
        if (ga.equals(pe))
            return ""; //$NON-NLS-1$
        else {
            List<GraphicsAlgorithm> l = ga.getGraphicsAlgorithmChildren();
            for (int i = 0; i < l.size(); i++) {
                GraphicsAlgorithm subga = l.get(i);
                String result = calculatePathInGA(subga, pe);
                if (result != null)
                    return pathcat("graphicsAlgorithmChildren[" + i + "]", result); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
        return null;
    }

    /**
     * Gets the value.
     * 
     * @param ro
     *            the ro
     * @param path
     *            the path
     * 
     * @return the value
     */
    public static Object getValue(RefObject ro, String path) {
        path = path.replace("[*]", ""); //$NON-NLS-1$ //$NON-NLS-2$
        path = path.replace("@", ""); //$NON-NLS-1$ //$NON-NLS-2$
        return getValueCore(ro, path);
    }

    /**
     * Gets the single value.
     * 
     * @param ro
     *            the ro
     * @param path
     *            the path
     * 
     * @return the single value
     */
    public static Object getSingleValue(RefObject ro, String path) {
        Object o = getValue(ro, path);
        if (o instanceof Collection) {
            Collection l = (Collection) o;
            if (l.size() > 0)
                return l.iterator().next();
            else
                return null;
        } else
            return o;
    }

    /**
     * Gets the object.
     * 
     * @param ro
     *            the ro
     * @param path
     *            the path
     * @param parentlevel
     *            the parentlevel
     * 
     * @return the object
     */
    public static RefObject getObject(RefObject ro, String path, int parentlevel) {
        int attributeIndex = path.indexOf("/@"); //$NON-NLS-1$
        if (attributeIndex > 0) {
            path = path.substring(0, attributeIndex);
        }
        while (parentlevel > 0) {
            --parentlevel;
            int lastSlash = path.lastIndexOf('/');
            if (lastSlash >= 0)
                path = path.substring(0, lastSlash);
        }
        return (RefObject) getSingleValue(ro, path);
    }

    // foo(cool/@me)/babber/@value
    /*
     * private class Lexan { public String buffer; private char currentTokentype; private String currentVal; private int
     * pos=0; public Lexan(String input) { this.buffer = input; } public void move() { int lastpos = pos; while(pos <
     * buffer.length()) { String foo; char c = buffer.charAt(pos); switch(c) { case '(': case ')': case '[': case ']':
     * case '/': currentTokentype = c; currentVal = Character.toString(c); return; default: currentTokentype = 'a';
     * currentVal = buffer.substring(lastpos, ) } } } public String getCurrent() { } public char getCurrentType(); }
     */

    private static int indexOfNextSpecial(String s) {
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '/')
                return i;
            i++;
        }
        return i;
    }

    private static Object getValueCore(Object o, String path) {
        if (path == null)
            return o;

        if (path.startsWith("/")) //$NON-NLS-1$
            path = path.substring(1);

        if (path == null || path.equals("")) //$NON-NLS-1$
            return o;

        // Lists
        if (o instanceof List) {
            List l = (List) o;

            if (path.startsWith("[")) { //$NON-NLS-1$
                int endPos = path.indexOf(']');
                String indexString = path.substring(1, endPos);
                int index = Integer.parseInt(indexString);
                return getValueCore(l.get(index), path.substring(endPos + 1));
            } else {
                List result = new ArrayList(l.size());
                for (Object element : l) {
                    Object subElement = getValueCore(element, path);
                    if (subElement instanceof Collection) {
                        Collection subList = (Collection) subElement;
                        result.addAll(subList);
                    } else
                        result.add(subElement);
                }
                return result;
            }
        }

        // Functions
        int parantPos = path.indexOf('(');
        if (parantPos >= 0) {
            int closingParantPos = path.indexOf(')', parantPos);
            if (closingParantPos < 0)
                throw new RuntimeException("Bad XPath " + path); //$NON-NLS-1$
            String innerPath = path.substring(parantPos + 1, closingParantPos);
            String functionName = path.substring(0, parantPos);
            Object result = evalFunction(o, functionName, innerPath);
            String restPath = path.substring(closingParantPos + 2);
            return getValueCore(result, restPath);
        }

        int delimiter = indexOfNextSpecial(path);

        if (o instanceof RefObject) {
            RefObject ro = (RefObject) o;
            Object next = ro.refGetValue(path.substring(0, delimiter));
            return getValueCore(next, path.substring(delimiter));
        }
        if (o instanceof RefStruct) {
            RefStruct ro = (RefStruct) o;
            Object next = ro.refGetValue(path.substring(0, delimiter));
            return getValueCore(next, path.substring(delimiter));
        }

        else
            return o;
    }

    private static Object evalFunction(Object o, String function, String argument) {
        return XPath.getValueCore(o, argument);
    }

    /**
     * Sets the value.
     * 
     * @param ro
     *            the ro
     * @param path
     *            the path
     * @param value
     *            the value
     */
    public static void setValue(RefObject ro, String path, Object value) {
        RefObject lastRefObject = ro;
        RefStruct lastRefStruct = null;
        String lastPart = null;
        String[] parts = path.split("/"); //$NON-NLS-1$
        for (String part : parts) {
            if (part.startsWith("@")) { //$NON-NLS-1$
                if (lastRefStruct != null) {
                    RefStruct newStruct = updateStructureField(lastRefStruct, part.substring(1), value, ro.get___Connection());
                    lastRefObject.refSetValue(lastPart, newStruct);
                } else {
                    lastRefObject.refSetValue(part.substring(1), value);
                }
            } else {
                int bracePos = part.indexOf('[');
                if (bracePos >= 0) {
                    int endBracePos = part.indexOf(']');
                    String indexString = part.substring(bracePos + 1, endBracePos);
                    int index = Integer.parseInt(indexString);
                    List l = (List) lastRefObject.refGetValue(part.substring(0, bracePos));
                    Object listValue = l.get(index);
                    if (listValue instanceof RefObject) {
                        lastRefObject = (RefObject) l.get(index);
                    } else if (listValue instanceof RefStruct) {
                        // TODO: Complete soution here
                        l.set(index, value); // THIS IS NOT allways Ok!!!
                    }
                } else {
                    Object o = lastRefObject.refGetValue(part);
                    if (o instanceof RefObject) {
                        lastRefObject = (RefObject) o;
                    } else if (o instanceof RefStruct) {
                        lastRefStruct = (RefStruct) o;
                    }

                }
            }
            lastPart = part;
        }
    }

    /**
     * Sets the value.
     * 
     * @param ro
     *            the ro
     * @param path
     *            the path
     * @param value
     *            the value
     * @param index
     *            the index
     */
    public static void setValue(RefObject ro, String path, Object value, int index) {
        path = path.replace("[*]", "[" + Integer.toString(index) + "]"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }

    /**
     * Clone.
     * 
     * @param ro
     *            the ro
     * 
     * @return the ref object
     */
    public static RefObject clone(RefObject ro) {
        MofClass meta = (MofClass) ro.refMetaObject();
        RefClass factory = ro.refClass();

        RefObject newObject = factory.refCreateInstance();

        List<MofClass> allClases = new ArrayList<MofClass>();
        allClases.add(meta);
        allClases.addAll((List) meta.allSupertypes());
        for (MofClass clazz : allClases) {
            for (Iterator iter = clazz.getContents().iterator(); iter.hasNext();) {
                StructuralFeature feature = (StructuralFeature) iter.next();
                if (feature instanceof Reference) {
                    Reference ref = (Reference) feature;
                    if (ref.getExposedEnd().getAggregation().equals(AggregationKindEnum.COMPOSITE)) {
                        Collection contained = (Collection) ro.refGetValue(feature);
                        Collection containedTarget = (Collection) newObject.refGetValue(feature);
                        for (Iterator iterator = contained.iterator(); iterator.hasNext();) {
                            RefObject element = (RefObject) iterator.next();
                            containedTarget.add(clone(element));
                        }
                    }
                } else {
                    Object value = ro.refGetValue(feature);
                    if (value instanceof RefObject) {
                        RefObject roValue = (RefObject) value;
                        newObject.refSetValue(feature, clone(roValue));
                    } else
                        newObject.refSetValue(feature, value);
                }
            }
        }
        return newObject;
    }

    private static RefStruct updateStructureField(RefStruct structure, String field, Object value, Connection connection) {
        // List<String> fields = structure.refFieldNames();
        // List<Object> values = new ArrayList<Object>(fields.size());
        // for (String f : fields) {
        // if (f.equals(field)) {
        // values.add(value);
        // } else {
        // values.add(structure.refGetValue(f));
        // }
        // }
        //
        // List<String> structQName = structure.refTypeName();
        // String[] structPackageQName = structQName.subList(0, structQName.size() - 1).toArray(new
        // String[structQName.size() - 1]);
        // String structName = structQName.get(structQName.size() - 1);
        // RefPackage structPackage = connection.getPackage(null, structPackageQName);
        // return structPackage.refCreateStruct(structName, values);

        StructureFieldContainer<RefStruct> containerForFieldsToSet = new StructureFieldContainer<RefStruct>();
        StructureFieldDescriptor<StructureField, ? super RefStruct, Object> desc = StructureFieldDescriptor.getDescriptor(structure, field);
        containerForFieldsToSet.put(desc, value);
        return connection.getJmiHelper().cloneStruct(structure, containerForFieldsToSet);

    }
}
