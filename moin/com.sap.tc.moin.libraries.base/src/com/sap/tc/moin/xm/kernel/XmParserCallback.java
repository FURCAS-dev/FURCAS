package com.sap.tc.moin.xm.kernel;

import com.sap.tc.moin.repository.mmi.reflect.InvalidNameException;


/**
 * Call-back used by the XM Parser for creating and accessing MOIN model
 * elements and links.
 * <p>
 * Different object types for the MOIN model elements are used depending on the
 * integration strategy (Import or CPS parsing).
 * 
 * @param <TElement> either a RefObject representing a MOF class instance in the
 * Import integration strategy or a SpiElement in the CPS integration strategy
 * @param <TMofClass> either RefClass in the case of Import integration strategy
 * or SpiClass in the case of CPS integration strategy
 * @param <TMofAssociation> either a RefAssociation in the case of Import
 * integration strategy or a SpiAssociation in the case of CPS integration
 * strategy
 */
public interface XmParserCallback<TElement, TMofClass, TMofAssociation> extends XmCallback<TElement, TMofClass, TMofAssociation> {


    /**
     * Creates and returns a new instance of a MOF class.
     * <p>
     * The MOFID of the instance is calculated from the given logical key.
     * <p>
     * Remark: The MOFID calculation of MOIN includes the MOFID of the
     * meta-object (class) of the instance.
     * 
     * @param mofClass type of the model element to create
     * @param logicalKey the logical key which are used in order to calculate
     * the logical key hash for the MOFID
     * @return created instance; cannot be <code>null</code>
     */
    TElement createClassInstance( TMofClass mofClass, String... logicalKey );

    /**
     * Sets or adds an attribute of primitive type to a class instance. The
     * <code>attributeName</code> can denote a single- or multi-valued
     * attribute.
     * <p>
     * If the attribute is of type Boolean then the attribute value is set to
     * <code>true</code> if the string argument is not <code>null</code> and is
     * equal, ignoring case, to the string <code>"true"</code>.
     * <p>
     * Example: <tt>Boolean.valueOf("True")</tt> leads to <tt>true</tt>.<br>
     * Example: <tt>Boolean.valueOf("yes")</tt> leads to <tt>false</tt>.
     * <p>
     * Note that the exception handling is different for the Import/Export and
     * the CP/S integration strategy.
     * 
     * @param classInstance class instance
     * @param attributeName name of the attribute
     * @param value value
     * @throws InvalidNameException if <code>attributeName</code> does not
     * denote a valid attribute name; this exception is only thrown in the
     * Import/Export integration strategy; in the CP/S integration strategy this
     * situation can be handled by the SpiParserErrorHandler
     * @exception NumberFormatException if the attribute is a number primitive
     * type and <tt>value</tt> does not contain a parse-able number; this
     * exception is only thrown in the Import/Export integration strategy; in
     * the CP/S integration strategy this situation can be handled by the
     * SpiParserErrorHandler
     * @throws IllegalArgumentException if <code>value</code> is
     * <code>null</code>
     */
    void setOrAddAttribute( final TElement classInstance, final String attributeName, final String value );


    /**
     * Establishes a link of the specified association between the two given
     * model elements. This method must be used if both elements belong to the
     * partition being parsed, i.e. an inner-partition link should be
     * established.
     * 
     * @param association the MOF association for which a new link should be
     * established
     * @param elementAtEndA the model element at the end A
     * @param elementAtEndB the model element at the end B
     * @param endBName name of the end B (as defined in the meta-model)
     * @param throws NullPointerException if a parameter is <code>null</code>
     * @throws IllegalArgumentException if endBName is not a correct end name of
     * the association or if the instance model elements are not compatible with
     * the association end types
     */
    void addLink( TMofAssociation association, TElement elementAtEndA, TElement elementAtEndB, String endBName );


    /**
     * Establishes a link of the specified association between two model
     * elements, where one is given as an instance and the other through its
     * MOFID. This method must be used if the element at the end A belongs to
     * the partition being parsed, and the element at the end B is external,
     * i.e. a cross-partition link (inter partition link) should be established.
     * 
     * @param association the MOF association for which a new link should be
     * established
     * @param elementAtEndA the model element at the end A, belongs to the
     * partition being parsed
     * @param mofIdOfElementAtEndB the MOFID of the model element at the end B
     * @param endBName name of the end B (as defined in the meta-model)
     * @param throws NullPointerException if a parameter is <code>null</code>
     * @throws IllegalArgumentException is thrown in the following cases
     * <ul>
     * <li>if endBName is not a correct end name of the association,</li>
     * <li>if the model element <tt>elementAtEndA</tt> has a type which is not
     * compatible with the end A of the association,
     * <li>if the model element of the MOFID <tt>mofIdOfElementAtEndB</tt> is
     * existing and does not have the correct type which is compatible to the
     * end B in the Import/Export strategy</li>
     * </ul>
     */
    void addLink( TMofAssociation association, TElement elementAtEndA, String mofIdOfElementAtEndB, String endBName );

//    /**
//     * Returns the type of a certain end of an association.
//     * 
//     * @param association association
//     * @param endName name of the end for which the type is to be determined
//     * @return type
//     * @throws IllegalArgumentException if endBName is not a correct end name,
//     * of the association or <code>null</code>
//     */
//    TMofClass getTypeOfAssociationEnd( TMofAssociation association, String endName );


}
