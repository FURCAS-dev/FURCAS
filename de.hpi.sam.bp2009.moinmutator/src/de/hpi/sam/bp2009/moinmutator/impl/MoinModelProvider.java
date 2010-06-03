package de.hpi.sam.bp2009.moinmutator.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLResultSet;

import de.hpi.sam.bp2009.moinmutator.IMoinModelProvider;

public class MoinModelProvider implements IMoinModelProvider {

    /**
     * An array of readable characters to generate random strings from.
     */
    protected static Character[] readableChars = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9' };

    protected Connection connection;

    /**
     * A list of objects to exclude from selection for mutation.
     */
    protected ArrayList<RefObject> excludedObjects = new ArrayList<RefObject>();

    /**
     * A random number generator that is seeded to enable reproducible model mutations.
     */
    protected final Random random;

    public MoinModelProvider(Connection conn, long randomSeed) {
        connection = conn;
        random = new Random(randomSeed);
    }

    @Override
    public void addToExcludedObjects(Collection<RefObject> instances, boolean excludeChildren) {
        for (RefObject m : instances) {
            addToExcludedObjects(m, excludeChildren);
        }
    }

    @Override
    public void addToExcludedObjects(RefObject instance, boolean excludeChildren) {
        excludedObjects.add(instance);
        if (excludeChildren) {
            excludedObjects.addAll(getChildren(instance));
        }
    }

    @Override
    public Collection<StructuralFeature> getAllStructuralFeatures() {
        ArrayList<StructuralFeature> result = new ArrayList<StructuralFeature>();
        for (RefObject o : getAllInstances()){
            if (o instanceof StructuralFeature){
                result.add((StructuralFeature) o);
            }
        }
        return result;
    }
    
    @Override
    public Collection<RefObject> getChildren(RefObject instance) {
        return connection.getJmiHelper().getCompositeChildren(instance, true);
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public int getModelSize() {
        return getAllInstances().size();
    }

    @Override
    public MofPackage getPackage() {
        return getAllInstances().iterator().next().refOutermostPackage().refMetaObject();
    }

    @Override
    public MofClass getRandomConcreteClass() {
        ArrayList<MofClass> metaClasses = new ArrayList<MofClass>();
        for (ModelElement e : getPackage().getContents()){
            if (e instanceof MofClass && !((MofClass)e).isAbstract()){
                metaClasses.add((MofClass) e);
            }
        }
        return metaClasses.get(random.nextInt(metaClasses.size()));
    }

    @Override
    public StructuralFeature getRandomFeature(RefObject instance) {
        List<ModelElement> contents = instance.refClass().refMetaObject().getContents();
        List<StructuralFeature> features = filterStructuralFeatures(contents);
        if (features.size() == 0) {
            return null;
        }
        return features.get(random.nextInt(features.size()));
    }

    @Override
    public StructuralFeature getRandomFeatureHavingType(MofClass type) {
        List<StructuralFeature> list = new ArrayList<StructuralFeature>();
        for (StructuralFeature f : getAllStructuralFeatures()) {
            if (f.getType().equals(type)) {
                list.add(f);
            }
        }
        if (list.size() == 0){
            return null;
        }
        return list.get(random.nextInt(list.size()));
    }

    @Override
    public StructuralFeature getRandomFeatureHavingType(MofClass type, boolean isContainment) {
        List<StructuralFeature> list = new ArrayList<StructuralFeature>();
        for (StructuralFeature f : getAllStructuralFeatures()){
            if (f.getType().equals(type) && f instanceof Reference && isContainment == (((Reference)f).getExposedEnd().getAggregation() == AggregationKindEnum.COMPOSITE)){
                list.add(f);
            }
        }
        if (list.size() == 0){
            return null;
        }
        return list.get(random.nextInt(list.size()));
    }

    @Override
    public RefObject getRandomInstance() {
        //TODO depending on the result of the MQL Query we need to filter the instances of all MofClasses
        List<RefObject> instances = getAllInstances();
        instances.removeAll(excludedObjects);
        return instances.get(random.nextInt(instances.size()));
    }

    @Override
    public RefObject getRandomInstance(MofClass classToLookFor) {
        Collection<RefObject> list = connection.getJmiHelper().getRefClassForMofClass(classToLookFor).refAllOfClass();
        list.removeAll(excludedObjects);
        if (list.size() == 0){
            return null;
        }
        return (RefObject) list.toArray()[random.nextInt(list.size())];
    }

    @Override
    public RefObject getRandomInstanceHavingFeature(StructuralFeature feature) {
        RefObject result = null;
        RefFeatured x = feature.refImmediateComposite();
        if (x instanceof RefClass) {
            Collection<RefObject> c = ((RefClass) x).refAllOfClass();
            result = (RefObject) c.toArray()[c.size()];
        }
        return result;
    }

    @Override
    public RefObject getRandomInstanceNotContainingMoreObjectsThan(int instanceCount) {
        List<RefObject> result = new ArrayList<RefObject>();
        for (RefObject o : getAllInstances()){
            if (getChildren(o).size() <= instanceCount){
                result.add(o);
            }
        }
        if (result.size() == 0){
            return null;
        }
        return result.get(random.nextInt(result.size()));
    }

    @Override
    public StructuralFeature getRandomMultiValuedFeature(RefObject instance) {
        List<ModelElement> contents = instance.refClass().refMetaObject().getContents();
        List<StructuralFeature> result = new ArrayList<StructuralFeature>();
        for (StructuralFeature f : filterStructuralFeatures(contents)){
            if (f.getMultiplicity().getUpper() > 1){
                result.add(f);
            }
        }
        if (result.size() == 0){
            return null;
        }
        return result.get(random.nextInt(result.size()));
    }

    @Override
    public StructuralFeature getRandomSingleValuedFeature(RefObject instance) {
        List<ModelElement> contents = instance.refClass().refMetaObject().getContents();
        List<StructuralFeature> result = new ArrayList<StructuralFeature>();
        for (StructuralFeature f : filterStructuralFeatures(contents)){
            if (f.getMultiplicity().getUpper() == 1){
                result.add(f);
            }
        }
        if (result.size() == 0){
            return null;
        }
        return result.get(random.nextInt(result.size()));
    }

    @Override
    public String getRandomString() {
        int length = random.nextInt(50);
        String result = "";
        for (int i = 0; i < length; i++) {
            result += readableChars[random.nextInt(readableChars.length)];
        }
        return result;
    }

    @Override
    public Object getRandomValue(StructuralFeature feature) {
        try {

            Classifier type = feature.getType();

            if (type instanceof MofClass) {

                return getRandomInstance((MofClass) type);

            } else if (type instanceof EnumerationType) {

                EnumerationType enumeration = (EnumerationType) type;
                return enumeration.getLabels().get(random.nextInt(enumeration.getLabels().size()));

            } else if (type instanceof PrimitiveType) {

                // handle String data types
                if ("java.lang.String".equals(type.getQualifiedName())) { //$NON-NLS-1$
                    return getRandomString();
                } else if ("int".equals(type.getQualifiedName()) //$NON-NLS-1$
                        || "java.lang.Integer".equals(type.getQualifiedName()) //$NON-NLS-1$
                        || "java.math.BigDecimal".equals(type.getQualifiedName()) //$NON-NLS-1$
                        || "java.math.BigInteger".equals(type.getQualifiedName())) { //$NON-NLS-1$
                    return random.nextInt(100);
                } else if ("boolean".equals(type.getQualifiedName()) //$NON-NLS-1$
                        || "java.lang.Boolean".equals(type.getQualifiedName())) { //$NON-NLS-1$
                    return random.nextBoolean();
                } else if ("byte".equals(type.getQualifiedName()) //$NON-NLS-1$
                        || "java.lang.Byte".equals(type.getQualifiedName())) { //$NON-NLS-1$
                    return (byte) random.nextInt(100);
                } else if ("char".equals(type.getQualifiedName()) //$NON-NLS-1$
                        || "java.lang.Character".equals(type.getQualifiedName())) { //$NON-NLS-1$
                    return getRandomString().toCharArray();
                } else if ("java.lang.Date".equals(type.getQualifiedName())) { //$NON-NLS-1$
                    return new Date(random.nextLong());
                } else if ("double".equals(type.getQualifiedName()) //$NON-NLS-1$
                        || "java.lang.Double".equals(type.getQualifiedName())) { //$NON-NLS-1$
                    return random.nextDouble();
                } else if ("float".equals(type.getQualifiedName()) //$NON-NLS-1$
                        || "java.lang.Float".equals(type.getQualifiedName())) { //$NON-NLS-1$
                    return random.nextFloat();
                } else if ("long".equals(type.getQualifiedName()) //$NON-NLS-1$
                        || "java.lang.Long".equals(type.getQualifiedName())) { //$NON-NLS-1$
                    return random.nextLong();
                } else if ("short".equals(type.getQualifiedName()) //$NON-NLS-1$
                        || "java.lang.Short".equals(type.getQualifiedName())) { //$NON-NLS-1$
                    return (short) random.nextInt(100);
                }
            }

            return null;

        } catch (ClassCastException e) {
            return null;
        }
    }

    @Override
    public void setConnection(Connection connectionToSet) {
        connection = connectionToSet;

    }

    private List<StructuralFeature> filterStructuralFeatures(List<ModelElement> contents) {
        List<StructuralFeature> result = new ArrayList<StructuralFeature>();
        for (ModelElement e : contents) {
            if (e instanceof StructuralFeature) {
                result.add((StructuralFeature) e);
            }
        }
        return result;
    }

    protected List<RefObject> getAllInstances(){
        MQLProcessor mql = connection.getMQLProcessor();
        MQLResultSet elements = mql.execute("select o from Element as o", mql.getQueryScopeProvider(false, null, (String[]) null));
        ArrayList<RefObject> result = new ArrayList<RefObject>();
        for (RefObject o : elements.getRefObjects("o")){
            result.add(o);
        }
        return result;
    }
}
