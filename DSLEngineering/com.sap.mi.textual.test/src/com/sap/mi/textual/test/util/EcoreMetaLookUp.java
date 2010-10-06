package com.sap.mi.textual.test.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import com.sap.furcas.textual.common.exceptions.MetaModelLookupException;
import com.sap.furcas.textual.common.interfaces.IMetaModelLookup;
import com.sap.furcas.textual.common.interfaces.MultiplicityBean;
import com.sap.furcas.textual.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.tc.moin.repository.mmi.model.ModelElement;

public class EcoreMetaLookUp implements IMetaModelLookup<Object> {

    private static final String METAMODELDIR = "scenarioTestResource/metamodels/";
    
    private List<EPackage> rootPackageList = new ArrayList<EPackage>(3);
    private Set<EClassifier> classifierList = new HashSet<EClassifier>();

    
    /**
     * 
     * @param rootEcoreFile
     * @param dataTypeEcoreFile
     * @throws IOException
     */
    public EcoreMetaLookUp(File... fileArr) throws MetaModelLookupException  {
//In this case DataTypes are usually in a separate file, need to load that one as well
        for (int i = 0; i < fileArr.length; i++) {
            File file = fileArr[i];
            java.net.URI uri = file.toURI();
            java.net.URI normUri = uri.normalize();
            
            loadPackagesFromUri(normUri.toString());
        }
    }
    
    /**
     * 
     * @param rootEcoreFile
     * @param dataTypeEcoreFile
     * @throws IOException
     */
    public EcoreMetaLookUp(String... fileArr) throws MetaModelLookupException  {
//In this case DataTypes are usually in a separate file, need to load that one as well
        for (int i = 0; i < fileArr.length; i++) {
            String rootEcoreFile = fileArr[i];
            File file = new File(METAMODELDIR + rootEcoreFile);
            String uri = file.toURI().toString();
           
            loadPackagesFromUri(uri);
        }
        
    }
    



    private void loadPackagesFromUri(String uri) throws MetaModelLookupException {
        Resource resource = new XMIResourceImpl(URI.createURI( uri));
        
        try {
            resource.load(null);
        } catch (IOException e) {
            throw new MetaModelLookupException("Unable to parse ecore xmi for file uri " + uri + " : " + e.getMessage(), e);
        }
        // Load Datatypes
        
        EList<EObject> list = resource.getContents();
        for (Iterator<EObject> iterator = list.iterator(); iterator.hasNext();) {
            EObject object = iterator.next();
            if (object instanceof EPackage) {
                EPackage new_package = (EPackage) object;
                rootPackageList.add(new_package);
                EPackage.Registry.INSTANCE.put(uri, new_package);
                addClassifiersRecursively(new_package);
            }
        }
        
       
    }

    private void addClassifiersRecursively(EPackage currentpackage) {
        EList<EClassifier> coll = currentpackage.getEClassifiers();
        for (Iterator<EClassifier> iterator = coll.iterator(); iterator.hasNext();) {
            EClassifier classifier = iterator.next();
         
            classifierList.add(classifier);
        }
        
        
        EList<EPackage> subs = currentpackage.getESubpackages();
        for (EPackage loopPackage : subs) {
            addClassifiersRecursively(loopPackage);
        }
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#getDirectSubTypes(java.lang.String)
     */
    public List<ResolvedNameAndReferenceBean<Object>> getDirectSubTypes(ResolvedNameAndReferenceBean<Object> reference) {
        List<String> typeName = reference.getNames();
        EClassifier typeClass = getEClassifier(typeName);
        if (typeClass == null) { 
            // no need to loop over subtypes if the supertype does not exist anyways
            return null;
        }
        
        
//        EList<EClassifier> classiList = rootPackage.getEClassifiers();
        List<ResolvedNameAndReferenceBean<Object>> list = new ArrayList<ResolvedNameAndReferenceBean<Object>>();
        for (Iterator<EClassifier> iterator = classifierList.iterator(); iterator.hasNext();) {
            EClassifier classi = iterator.next();
            // loop only over classes
            if (classi instanceof EClass) {
                EClass eClass = (EClass) classi;

                // loop over class supertypes to see if the one passed to the method is among them. If so, add it.
                EList<EClass> superList = eClass.getESuperTypes();
                for (Iterator<EClass> iterator2 = superList.iterator(); iterator2.hasNext();) {
                    EClass class1 = iterator2.next();
                    if (getReferenceBean(class1).equals(reference)) {
                        list.add(getReferenceBean(classi));
                        break;
                    }
                }
            }
        }
        return list;
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#getFeatureClassName(java.lang.String, java.lang.String)
     */
    public ResolvedNameAndReferenceBean<Object> getFeatureClassReference(ResolvedNameAndReferenceBean<Object> reference, String featureName)
            throws MetaModelLookupException {

        EClassifier resultType = null;
        if (reference != null) {
            EStructuralFeature feat = getEStructuralFeature(reference.getNames(), featureName);
            if (feat != null) {
                EClassifier eType = feat.getEType();

                if (eType.eIsProxy()) {
                    EClassifier resolved = (EClassifier) EcoreUtil.resolve(eType, feat);
                    if (resolved == eType) {
                        throw new MetaModelLookupException("Could not resolve proxy for classifier: " + eType);
                    }
                    resultType = resolved;
                } else {
                    resultType = eType;
                   
                }
                if (resultType == null) { // Ecore lookup inconsistency
                    throw new MetaModelLookupException("Feature Class name is null for " + reference + "." + featureName);
                }
            } 
        }


        return getReferenceBean(resultType);

    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#getMultiplicity(java.lang.String, java.lang.String)
     */
    public MultiplicityBean getMultiplicity(ResolvedNameAndReferenceBean<Object> reference, String featureName) {
        List<String> typeName = reference.getNames();
        MultiplicityBean multiplicity = null;
        EStructuralFeature feature = getEStructuralFeature(typeName, featureName);
        if (feature != null) {
            multiplicity = new MultiplicityBean();
            int lowerbound = feature.getLowerBound();
            int upperbound = feature.getUpperBound();
            multiplicity.setLowerBound(lowerbound);
          
            multiplicity.setUpperBound(upperbound);
            
        }
       
        return multiplicity;
    }
    

    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#hasFeature(java.lang.String, java.lang.String)
     */
    public boolean hasFeature(ResolvedNameAndReferenceBean<Object> reference, String featureName) {
        List<String> typeName = reference.getNames();
        EStructuralFeature feature = getEStructuralFeature(typeName, featureName);
        if (feature != null) {
            return true;
        } 
        return false;
    }

   
    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#isClassName(java.lang.String)
     */
//    public boolean isClassName(List<String> typeName) {
//        if (typeName != null && getEClassifier(typeName) != null) {
//            return true;
//        } 
//        return false;
//    }

    private EClassifier getEClassifier(List<String> typeNameQ)  {

        if (typeNameQ == null || typeNameQ.size() == 0) {
            return null;
        }
        
        // is name qualified or not qualified?
        if ( typeNameQ.size() == 1) {
//            String typeName = typeNameQ.get(0);
//            
//            // TODO: Search for suitable type in all packages, check if unique
//            EClassifier returnClass =  rootPackage.getEClassifier(typeName);
////            EClassifier returnClass = findClassifier(typeName);
//            if (returnClass instanceof EClass ) {
//          return (EClass) returnClass;

//          } else {
            return null;
//          }
        } else {
            List<String> packageName = getPackageName(typeNameQ);
            String typeName = typeNameQ.get(typeNameQ.size()-1); // last element is type name
            EPackage subPackage = getEPackage(packageName);
            if (subPackage != null) {
                EClassifier returnClass =  subPackage.getEClassifier(typeName);
                if (returnClass != null ) {
                    return returnClass;
                }
            }
            return null;

        }
    }

 
    /**
     * cuts off the last String
     * @param typeNameQ
     * @return
     */
    private static List<String> getPackageName(List<String> typeNameQ) {
        List<String> packageName = new ArrayList<String>();
        for (Iterator<String> iterator = typeNameQ.iterator(); iterator.hasNext();) {
            String string = iterator.next();
            if (iterator.hasNext()) {
                packageName.add(string);
            }
        }
        return packageName;
    }


    private EPackage getEPackage(List<String> packageNameQ)  {

        EPackage indexPackage = null;
        for (Iterator<EPackage> iterator = rootPackageList.iterator(); iterator.hasNext();) {
            EPackage pack = iterator.next();
            if (pack.getName().equals(packageNameQ.get(0))) {
                indexPackage = pack;
            }
        }
        if (indexPackage == null) {
            return null;
        }
        
       
        Iterator<String> iterator = packageNameQ.iterator();
        iterator.next(); // jump root package, checked before
        for (; iterator.hasNext();) {
            String currentNameLevel = iterator.next();
            EList<EPackage> subs = indexPackage.getESubpackages();
            EPackage nextSub = null;
            for (EPackage sub : subs) {
                if (sub.getName().equals(currentNameLevel)) {
                    nextSub = sub;
                    break;
                }
            }
            if (nextSub == null) { // no subpackage fond
                return null;
            } else {
                indexPackage = nextSub;
            }
        }
        // if we make it to here, than for each level of the name there was a package
        return indexPackage;
    }

    private EStructuralFeature getEStructuralFeature(List<String> typeName, String featureName) {
        EStructuralFeature returnFeature = null;
        
        EClassifier typeClass = getEClassifier(typeName);
        if (typeClass != null && typeClass instanceof EClass) {
            returnFeature = ((EClass)typeClass).getEStructuralFeature(featureName);
        }
        return returnFeature ;
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#close()
     */
    public void close() {
    }

    private ResolvedNameAndReferenceBean<Object> getReferenceBean(EClassifier type)  {
        if (type == null) {
            return null;
        }
        
        List<String> returnlist = new ArrayList<String>(); 
        
        EPackage indexpackage = type.getEPackage();
        if (indexpackage == null) {
            throw new NullPointerException("Type with null package: " + type);
        }
        returnlist.add(type.getName());
        returnlist.add(indexpackage.getName());
        while (indexpackage.getESuperPackage() != null ) {
            EPackage superPack = indexpackage.getESuperPackage();
            returnlist.add(superPack.getName());
            indexpackage = superPack;
        }
        Collections.reverse(returnlist);
        return new ResolvedNameAndReferenceBean<Object>(returnlist, type);
    }


    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#qualifyName(java.lang.String)
     */
    public List<ResolvedNameAndReferenceBean<Object>> qualifyName(String typeName) {
        // Looks into root package and if present alternative root (as in many test cases here, dirty hack for TCS compatibility)
        List<ResolvedNameAndReferenceBean<Object>> list = new ArrayList<ResolvedNameAndReferenceBean<Object>>();
        
        for (Iterator<EClassifier> iterator = classifierList.iterator(); iterator.hasNext();) {
            EClassifier typeClass = iterator.next();
            if (typeClass != null && typeClass.getName().equals(typeName) ) {
              list.add( getReferenceBean(typeClass));
          }
            
        }
        
//        // TODO: look in all packages instead?
//        EClassifier typeClass =  rootPackage.getEClassifier(typeName);
//        if (typeClass != null && typeClass instanceof EClassifier ) {
//            list.add( getQualifiedName((EClassifier) typeClass));
//        }
//        
//        if (secondPackage != null) {
//            typeClass = secondPackage.getEClassifier(typeName);
//            //      EClassifier returnClass = findClassifier(typeName);
//            if (typeClass != null && typeClass instanceof EClassifier ) {
//                list.add( getQualifiedName((EClassifier) typeClass));
//            }
//        }
        return list;
    }





	public List<String> getEnumLiterals(ResolvedNameAndReferenceBean<Object> enumeration) {
		List<String> literals = new ArrayList<String>();
        
        EClassifier classifier = getEClassifier(enumeration.getNames());
        if (classifier != null && classifier instanceof EEnum) {
            for (EEnumLiteral literal : ((EEnum)classifier).getELiterals()) {
            	literals.add(literal.getLiteral());
			}
        }
        return literals ;
	}

    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#isSubTypeOf(java.util.List, java.util.List)
     */
    public boolean isSubTypeOf(ResolvedNameAndReferenceBean<Object> subType, ResolvedNameAndReferenceBean<Object> superType) {
        EClassifier supertypeClass = getEClassifier(superType.getNames());
        EClassifier subtypeClass = getEClassifier(subType.getNames());
        
        if (supertypeClass == null || subtypeClass == null) {
            return false;
        }
        if (!  (supertypeClass instanceof EClass) || ! ( subtypeClass instanceof EClass )) {
            return false;
        }
        if (subtypeClass.equals(supertypeClass)) {
            return true;
        }

        EList<EClass> superList = ((EClass)subtypeClass).getEAllSuperTypes();
        for (Iterator<EClass> iterator = superList.iterator(); iterator.hasNext();) {
            EClass generalizableElement = iterator
                    .next();
            if (generalizableElement.equals(supertypeClass)) {
                return true;
            }
            
        }
        
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#resolveReference(java.util.List)
     */
    @Override
    public ResolvedNameAndReferenceBean<Object> resolveReference(
            List<String> names) throws MetaModelLookupException {
        if (names == null || names.size() == 0) {
            return null;
        }
        
        EClassifier classi = getEClassifier(names);
        if (classi == null) {
        
            if (names.size() == 1) {
                List<ResolvedNameAndReferenceBean<Object>> resolvedNames = qualifyName(names.get(0));
                if (resolvedNames.size() == 1) {
                    return resolvedNames.get(0);
                } else {
                   return null;
                }
            } else {
                // workround: map MOIN primitives to Ecore primitives to reduce the hassle
                if ("PrimitiveTypes".equals(names.get(0))) {
                    List<String> copy = new ArrayList<String>();
                    Iterator<String> iterator = names.iterator();
                    // ignore pacakge
                    iterator.next();
                    for (; iterator.hasNext();) {
                        String string = iterator.next();
                        copy.add(string);
                    }
                    return resolveReference(copy);
                } else {
                   return null;
                }                
            }
        } else {
            return getReferenceBean(classi);
        }

    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#resolveReferenceName(java.lang.Object)
     */
    @Override
    public ResolvedNameAndReferenceBean<Object> resolveReferenceName(Object reference) throws MetaModelLookupException {
        if (reference instanceof EClassifier) {
            EClassifier classi = (EClassifier) reference;
            return getReferenceBean(classi);
        } else if (reference instanceof ModelElement) {
            ModelElement classi = (ModelElement) reference;
            return resolveReference(classi.getQualifiedName());
        } else {
            throw new IllegalArgumentException("Expected EClassifier, not " + reference.getClass());
        }
        
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#isAbstract(com.sap.mi.textual.interfaces.ResolvedNameAndReferenceBean)
     */
    @Override
    public boolean isAbstract(ResolvedNameAndReferenceBean<Object> reference) {
        List<String> typeName = reference.getNames();
        EClassifier typeClass = getEClassifier(typeName);
        return typeClass.eClass().isAbstract();
    }

    @Override
    public List<String> validateOclQuery(Object template, String query,
	    Object context) {
	// TODO Implement for EMF
	return Collections.emptyList();
    }

}
