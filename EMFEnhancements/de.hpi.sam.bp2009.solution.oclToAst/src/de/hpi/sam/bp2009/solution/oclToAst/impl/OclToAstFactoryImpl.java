/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclToAst.impl;

import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.oclToAst.OclToAstFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OclToAstFactoryImpl implements OclToAstFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static OclToAstFactory instance=null;
    public static OclToAstFactory init() {
        if(instance ==null)
            instance= new OclToAstFactoryImpl();
        return instance;
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OclToAstFactoryImpl() {
        super();
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAnnotationOCLParser createEAnnotationOCLParser() {
        EAnnotationOCLParserImpl eAnnotationOCLParser = new EAnnotationOCLParserImpl();
        return eAnnotationOCLParser;
    }


} //OclToAstFactoryImpl
