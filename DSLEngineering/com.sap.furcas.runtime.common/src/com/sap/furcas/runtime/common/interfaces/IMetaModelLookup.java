/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-08-19 17:46:04 +0200 (Mi, 19 Aug 2009) $
 * @version $Revision: 7731 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.runtime.common.interfaces;

import java.util.List;

import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.NameResolutionFailedException;

/**
 * Metamodel independent interface to perform Syntax definition validation.
 * Allows to i.e. validate that a class of a given name exists in a given metamodel.
 * To be implemented per metamodel type (SAP MOIN, EMF Ecore, KM3,...)
 * 
 * @author C5107456
 */
public interface IMetaModelLookup<Type> {

    /**
     * Gets the multiplicity.
     * 
     * @param typename
     *            the typename
     * @param featureName
     *            the feature name
     * 
     * @return a bean that defines the multiplicity of a feature, or null in
     *         case of an error (feature or type does not exist)
     * 
     * @throws MetaModelLookupException
     *             if classname does not resolve to a type in the metamodel, or
     *             other inconsistency
     */
    MultiplicityBean getMultiplicity(ResolvedNameAndReferenceBean<Type> reference, String featureName)
            throws MetaModelLookupException;

    /**
     * returns the classname of the feature.
     * 
     * @param reference the typename
     * @param featureName the feature name
     * 
     * @return the feature class name
     * 
     * @throws MetaModelLookupException if classname does not resolve to a type in the metamodel, or other inconsistency
     */
    ResolvedNameAndReferenceBean<Type> getFeatureClassReference(ResolvedNameAndReferenceBean<Type> reference, String featureName)
            throws MetaModelLookupException;

    /**
     * returns classnames of classes inheriting from the given class.
     * 
     * @param typeName the type name
     * 
     * @return the direct sub types
     * 
     * @throws MetaModelLookupException if classname does not resolve to a type in the metamodel, or other inconsistency
     */
    List<ResolvedNameAndReferenceBean<Type>> getDirectSubTypes(ResolvedNameAndReferenceBean<Type> typeName)
            throws MetaModelLookupException, NameResolutionFailedException;

    boolean isAbstract(ResolvedNameAndReferenceBean<Type> typeName) throws MetaModelLookupException,
            NameResolutionFailedException;

    /**
     * closes connection to metamodel repositories if any.
     */
    void close();

    /**
     * looks up name and returns all qualified names for this type.
     * @param names
     * @return
     * @throws MetaModelLookupException 
     */
    List<ResolvedNameAndReferenceBean<Type>> qualifyName(String typeName) throws MetaModelLookupException;

    /**
     * Returns a list of the literal string values of the given Enumeration. 
     * @param names
     * @return
     * @throws MetaModelLookupException
     */
    List<String> getEnumLiterals(ResolvedNameAndReferenceBean<Type> enumeration) throws MetaModelLookupException;

    /**
     * returns true if both lists are qualifiers for Metamodel Elements, and the first being the same or a subtype of the latter. 
     * @param substitutePropertyType
     * @param realMetaModelTypeOfProperty
     * @throws MetaModelLookupException 
     */
    boolean isSubTypeOf(ResolvedNameAndReferenceBean<Type> subType, ResolvedNameAndReferenceBean<Type> superType)
            throws MetaModelLookupException;

    /**
     * returns a resolved bean or null if none can be found or an Exception if it is ambiguous.
     * @param names
     * @return
     * @throws MetaModelLookupException
     */
    public ResolvedNameAndReferenceBean<Type> resolveReference(List<String> names) throws MetaModelLookupException;

    /**
     * Factory method to create reference beans from references. Cannot fail, except when null is passed in.
     * @param names
     * @return
     * @throws JmiException 
     * @throws MetaModelLookupException 
     */
    public ResolvedNameAndReferenceBean<Type> resolveReferenceName(Type reference) throws MetaModelLookupException;

    /**
     * Checks the given OCL query for errors.
     * @return a list of error messages.
     */
    public List<String> validateOclQuery(Template template, String oclQuery);
    
    /**
     * Checks the given OCL query for errors.
     * @return a list of error messages.
     */
    public List<String> validateOclQuery(Type parsingContext, String oclQuery);

    /**
     * Returns the return type of the given OCL query.
     */
    public Type getOclReturnType(Type parsingContext, String oclQuery) throws MetaModelLookupException;
    
}
