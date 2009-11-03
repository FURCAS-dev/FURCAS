package com.sap.tc.moin.repository.jmigenerator;

import java.util.List;

import javax.swing.tree.TreeNode;

/**
 * Wraps a ModelElement for JMI generation
 * <p>
 * Each model element may result in several JMI classes; this is the wrapper for
 * generating these
 */
public interface JmiGeneratorModelElementWrapper extends TreeNode {

    /**
     * Generates the JMI class or classes
     * 
     * @param genKindFilter
     * @return the generated code
     */
    public List<JmiGeneratorPathCodePair> createCode( JmiGenerationKind[] genKindFilter );

    /**
     * @return the MofType of the wrapped ModelElement
     */
    public JmiGeneratorMofType getMofType( );

    /**
     * @return the name of the wrapped ModelElement
     */
    public String getModelElementName( );

    /**
     * @return whether we are currently generating the JMI classes for a model
     * element from the MOF metamodel
     */
    public boolean isMofModelElement( );

    /**
     * @param genKind
     * @param qualified
     * @return the name of the generated java class
     */
    public String getJavaClassName( JmiGenerationKind genKind, boolean qualified );

    /**
     * @return the MofId of the wrapped model element
     */
    public String getModelElementMofId( );

    /**
     * @return the qualified name of the wrapped model element
     */
    public String getModelElementQualifiedName( );
}
