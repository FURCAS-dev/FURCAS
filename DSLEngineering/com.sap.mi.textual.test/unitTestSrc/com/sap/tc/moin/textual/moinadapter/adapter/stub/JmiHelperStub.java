/**
 * 
 */
package com.sap.tc.moin.textual.moinadapter.adapter.stub;

import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.mi.textual.parsing.EnumerationTypeStub;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.NameViolation;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.mmi.model.AggregationKind;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

/**
 *
 */
public class JmiHelperStub implements JmiHelper {

    public ModelElement foundModelElement;
    public RefClass refMofClass;
    public Attribute attribute;
    public Reference reference;
    public RefPackage refPackage;

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#checkModelElementName(com.sap.tc.moin.repository.mmi.model.Namespace, com.sap.tc.moin.repository.mmi.model.ModelElement)
     */
    public NameViolation checkModelElementName(Namespace namespace,
            ModelElement modelElement) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#checkModelElementName(com.sap.tc.moin.repository.mmi.model.Namespace, java.lang.String, java.lang.String)
     */
    public NameViolation checkModelElementName(Namespace namespace,
            String modelElementName, String substituteName) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#findElementByQualifiedName(java.util.List, com.sap.tc.moin.repository.mmi.model.MofPackage)
     */
    public ModelElement findElementByQualifiedName(List<String> qnameToSearch,
            MofPackage mofPackage) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#findElementByQualifiedName(java.util.List, com.sap.tc.moin.repository.mmi.reflect.RefPackage)
     */
    public ModelElement findElementByQualifiedName(
            List<String> qualifiedNameToSearch, RefPackage outermostPackage) {
        return foundModelElement;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#findRefPackageByQualifiedName(java.util.List, com.sap.tc.moin.repository.mmi.reflect.RefPackage)
     */
    public RefPackage findRefPackageByQualifiedName(
            List<String> qualifiedNameToSearch, RefPackage outermostPackage) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getAffectedPartitionsForRefDelete(com.sap.tc.moin.repository.mmi.reflect.RefObject)
     */
    public Collection<PRI> getAffectedPartitionsForRefDelete(
            RefObject rootElement) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getAllSubtypes(com.sap.tc.moin.repository.mmi.model.GeneralizableElement)
     */
    public Collection<GeneralizableElement> getAllSubtypes(
            GeneralizableElement generalizableElement) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getAllSupertypes(com.sap.tc.moin.repository.mmi.model.GeneralizableElement)
     */
    public List<GeneralizableElement> getAllSupertypes(
            GeneralizableElement generalizableElement) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getAssociationEnds(com.sap.tc.moin.repository.mmi.model.Association)
     */
    public List<AssociationEnd> getAssociationEnds(Association a) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getAssociationEnds(com.sap.tc.moin.repository.mmi.model.Classifier, boolean)
     */
    public Set<AssociationEnd> getAssociationEnds(Classifier classifier,
            boolean includeSupertypes) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getAttributeByName(com.sap.tc.moin.repository.mmi.model.MofClass, java.lang.String, boolean)
     */
    public Attribute getAttributeByName(MofClass mofClass,
            String attributeName, boolean includeSupertypes) {
        return attribute;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getAttributes(com.sap.tc.moin.repository.mmi.model.MofClass, boolean)
     */
    public List<Attribute> getAttributes(MofClass mofClass,
            boolean includeSupertypes) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getAttributesWithValues(com.sap.tc.moin.repository.mmi.reflect.RefObject, boolean)
     */
    public Map<Attribute, Object> getAttributesWithValues(RefObject refObject,
            boolean includeSupertypes) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getCompositeAssociationEnd(com.sap.tc.moin.repository.mmi.model.Association)
     */
    public AssociationEnd getCompositeAssociationEnd(Association a) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getCompositeAssociations(com.sap.tc.moin.repository.mmi.model.MofClass, com.sap.tc.moin.repository.mmi.model.MofClass)
     */
    public Collection<Association> getCompositeAssociations(
            MofClass parentClass, MofClass childClass) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getCompositeChildren(com.sap.tc.moin.repository.mmi.reflect.RefObject, boolean)
     */
    public Collection<RefObject> getCompositeChildren(RefObject rootElement,
            boolean recursively) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getCompositeChildrenStable(com.sap.tc.moin.repository.mmi.reflect.RefObject, boolean)
     */
    public Collection<RefObject> getCompositeChildrenStable(
            RefObject rootElement, boolean recursively) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getEnumerationConstants(com.sap.tc.moin.repository.mmi.model.EnumerationType)
     */
    public List<RefEnum> getEnumerationConstants(EnumerationType enumerationType) {
        if (enumerationType instanceof EnumerationTypeStub) {
            EnumerationTypeStub new_name = (EnumerationTypeStub) enumerationType;
            return new_name.literals;
        } 
        fail();
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getJavaPrimitiveOrWrapperType(com.sap.tc.moin.repository.mmi.model.StructuralFeature)
     */
    public Class<?> getJavaPrimitiveOrWrapperType(
            StructuralFeature structuralFeature) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getNonAliasType(com.sap.tc.moin.repository.mmi.model.Classifier)
     */
    public Classifier getNonAliasType(Classifier type) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getNonAliasType(com.sap.tc.moin.repository.mmi.model.TypedElement)
     */
    public Classifier getNonAliasType(TypedElement typedElement) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getRefAssociationForAssociation(com.sap.tc.moin.repository.mmi.model.Association)
     */
    public RefAssociation getRefAssociationForAssociation(
            Association association) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getRefClassForMofClass(com.sap.tc.moin.repository.mmi.model.MofClass)
     */
    public RefClass getRefClassForMofClass(MofClass mofClass) {
        return refMofClass;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getRefPackageForMofPackage(com.sap.tc.moin.repository.mmi.model.MofPackage)
     */
    public RefPackage getRefPackageForMofPackage(MofPackage mofPackage) {
        return refPackage;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getReferenceByName(com.sap.tc.moin.repository.mmi.model.MofClass, java.lang.String, boolean)
     */
    public Reference getReferenceByName(MofClass mofClass,
            String referenceName, boolean includeSupertypes) {
        return reference;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getReferences(com.sap.tc.moin.repository.mmi.model.AssociationEnd)
     */
    public Collection<Reference> getReferences(AssociationEnd ae) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getReferences(com.sap.tc.moin.repository.mmi.model.MofClass, com.sap.tc.moin.repository.mmi.model.AggregationKind, boolean)
     */
    public List<Reference> getReferences(MofClass mofClass,
            AggregationKind aggregationKind, boolean includeSupertypes) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#getSubTypes(com.sap.tc.moin.repository.mmi.model.GeneralizableElement)
     */
    public Collection<GeneralizableElement> getSubTypes(
            GeneralizableElement generalizableElement) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#isEndStored(com.sap.tc.moin.repository.mmi.model.AssociationEnd)
     */
    public boolean isEndStored(AssociationEnd ae) {
        fail("not implemented yet");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#isEndStored(int, com.sap.tc.moin.repository.mmi.reflect.RefObject)
     */
    public boolean isEndStored(int endNumber, RefObject metaObject) {
        fail("not implemented yet");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#isEndStored(int, com.sap.tc.moin.repository.mmi.model.Association)
     */
    public boolean isEndStored(int endNumber, Association association) {
        fail("not implemented yet");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#isEndStored(int, com.sap.tc.moin.repository.mmi.model.Attribute)
     */
    public boolean isEndStored(int endNumber, Attribute attribute) {
        fail("not implemented yet");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.JmiHelper#isFirstAssociationEnd(com.sap.tc.moin.repository.mmi.model.Association, com.sap.tc.moin.repository.mmi.model.AssociationEnd)
     */
    public boolean isFirstAssociationEnd(Association a, AssociationEnd ae) {
        fail("not implemented yet");
        return false;
    }

	@Override
	public <T extends RefStruct> T cloneStruct(T structToClone,
			StructureFieldContainer<? extends T> containerForFieldsToSet) {
        fail("not implemented yet");
		return null;
	}

}
