package com.sap.furcas.parsergenerator.util;

import java.util.Iterator;
import java.util.List;

import com.sap.furcas.metamodel.TCS.QualifiedNamedElement;
import com.sap.furcas.metamodel.TCS.SequenceElement;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.constraints.PropertyInstanceOfConstraint;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.constraints.RuleBodyPropertyConstraint;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.NameResolutionFailedException;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.runtime.tcs.MessageHelper;
import com.sap.furcas.runtime.tcs.MetaModelElementResolutionHelper;

public class TcsUtil {

    // /**
    // * Gets the type of the referenced property.
    // * Allows to have a dotted navigation within the properties
    // * reference name. For example: refersTo='subElement.name' will first
    // * resolve the subElement Property and then the property "name" of the
    // type
    // * of this property.
    // *
    // * @param <Type>
    // * @param prop
    // * @param buffer
    // * @param name
    // * @param propertyOwnerTypeTemplate
    // * @param resolutionHelper
    // * @param metaLookup
    // * @return
    // * @throws MetaModelLookupException
    // * @throws SyntaxElementException
    // */
    // public static <Type> ResolvedNameAndReferenceBean<Type>
    // getReferencedTypeWithNavigation(SequenceElement prop,
    // ResolvedNameAndReferenceBean<Type> metaModelTypeOfPropertyReference,
    // String name,
    // MetaModelElementResolutionHelper<Type> resolutionHelper,
    // IMetaModelLookup<Type> metaLookup)
    // throws MetaModelLookupException, SyntaxElementException {
    // if(name.indexOf('.') > 0) {
    // String[] navigation = name.split("\\.");
    // ResolvedNameAndReferenceBean<Type> navigationStep =
    // metaModelTypeOfPropertyReference;
    // for (int i = 0; i < navigation.length-1; i++) {
    // navigationStep = metaLookup.getFeatureClassReference(navigationStep ,
    // navigation[i]);
    // }
    // return navigationStep;
    // } else {
    // return
    // metaLookup.getFeatureClassReference(metaModelTypeOfPropertyReference ,
    // name);
    // }
    //
    // }
    /**
     * util method that looks up the type of a referenced object, and also
     * considers the context of the current template sequence.
     * 
     * @param prop
     * @param buffer
     * @param propertyName
     * @param propertyOwnerTypeTemplate
     * @param resolutionHelper
     * @param metaLookup
     * @return
     * @throws MetaModelLookupException
     * @throws SyntaxElementException
     */
    public static <Type> ResolvedNameAndReferenceBean<Type> getReferencedType(SequenceElement prop, RuleBodyStringBuffer buffer,
	    String propertyName, QualifiedNamedElement propertyOwnerTypeTemplate,
	    MetaModelElementResolutionHelper<Type> resolutionHelper, IMetaModelLookup<Type> metaLookup)
	    throws MetaModelLookupException, SyntaxElementException {

	// check for instanceof constraint context in current buffer
	ResolvedNameAndReferenceBean<Type> substitutePropertyType = null;
	if (buffer != null) {
	    List<RuleBodyPropertyConstraint> constraints = buffer.getCurrentConstraints();

	    for (Iterator<RuleBodyPropertyConstraint> iterator = constraints.iterator(); iterator.hasNext();) {
		RuleBodyPropertyConstraint ruleBodyPropertyConstraint = iterator.next();
		if (ruleBodyPropertyConstraint instanceof PropertyInstanceOfConstraint) {
		    PropertyInstanceOfConstraint instOfConst = (PropertyInstanceOfConstraint) ruleBodyPropertyConstraint;
		    if (instOfConst.getPropertyName().equals(propertyName)) {
			List<String> substitutePropertyTypeName = instOfConst.getTypename();
			substitutePropertyType = resolutionHelper.resolve(substitutePropertyTypeName);
			// the last in the list wins, that's fine, since they
			// can overrule each other.
		    }
		}
	    }
	}

	ResolvedNameAndReferenceBean<Type> metaElementRef;
	try {
	    metaElementRef = resolutionHelper.resolve(propertyOwnerTypeTemplate);
	} catch (NameResolutionFailedException e) {
	    throw new SyntaxElementException(e.getMessage(), prop, e);
	}
	ResolvedNameAndReferenceBean<Type> realMetaModelTypeOfPropertyTemplate = metaLookup.getFeatureClassReference(
		metaElementRef, propertyName);

	// realMetaModelTypeOfPropertyTemplate =
	// syntaxLookup.getTCSTemplate(propertyTypeName);

	if (realMetaModelTypeOfPropertyTemplate == null) {
	    throw new SyntaxElementException("Type " + MessageHelper.getTemplateName(propertyOwnerTypeTemplate)
		    + " has no feature " + propertyName, prop);
	}

	ResolvedNameAndReferenceBean<Type> metaModelTypeOfProperty;
	if (substitutePropertyType != null) {
	    // check in Metamodel that new ownername is subclass of previous
	    // one, else error
	    if (metaLookup.isSubTypeOf(substitutePropertyType, realMetaModelTypeOfPropertyTemplate)) {
		metaModelTypeOfProperty = substitutePropertyType;
	    } else {
		throw new SyntaxElementException("Conditional subtype " + substitutePropertyType + " of feature " + propertyName
			+ " is not a subtype of expected type " + realMetaModelTypeOfPropertyTemplate, prop);
	    }

	} else {
	    metaModelTypeOfProperty = realMetaModelTypeOfPropertyTemplate;
	}

	return metaModelTypeOfProperty;
    }

}
