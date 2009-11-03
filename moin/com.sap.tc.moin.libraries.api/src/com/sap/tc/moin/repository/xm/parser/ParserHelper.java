package com.sap.tc.moin.repository.xm.parser;

import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;
import javax.xml.validation.TypeInfoProvider;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.mmi.descriptors.AssociationDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.xm.XmException;



/**
 * The parser helper provides access to the stack which contains the current
 * parsed XML element/attribute path and further convenience methods for mapping
 * an XML document to a MOIN model.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ParserHelper {

    /**
     * Returns the stack instance.
     * 
     * @return stack instance, cannot be <tt>null</tt>
     */
    PathStack getStack( );

    /**
     * Returns an unmodifiable map containing as keys the prefixes and as values
     * the namespaces. These prefixes are used in the {@link XPath} instance.
     * The map is determined from {@link XmParserHandler#getNamespaceToPrefix()}
     * .
     * 
     * @return prefix to namespace map, cannot be <tt>null</tt>
     */
    Map<String, String> getPrefix2NamespaceMap( );

    /**
     * Returns an unmodifiable map containing as keys the namespaces and as
     * values the prefixes defined. The map is determined from
     * {@link XmParserHandler#getNamespaceToPrefix()} .
     * 
     * @return namespace to prefix map, cannot be <tt>null</tt>
     */
    Map<String, String> getNamespace2PrefixMap( );

    /**
     * Returns the PRI of the model partition to which the created MOIN model
     * elements and links are added.
     * 
     * @return PRI
     */
    PRI getPri( );

    /**
     * Returns a handle to a model element whose MOFID is calculated from a
     * given logical key. The model element is created or must be contained in
     * the model partition whose PRI is given by the method {@link #getPri()}.
     * 
     * @param classDescriptor class descriptor for the type of the model element
     * @param logicalKey logical key from which the MOFID of the model element
     * is calculated
     * @return model element handle
     * @throws NullPointerException if a parameter is <tt>null</tt>
     * @throws IllegalArgumentException if the array <tt>logicalKey</tt> is
     * empty
     */
    PModelElementHandle getOrCreateModelElement( ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor, String... logicalKey );


    /**
     * Returns a handle to a model element which is contained in the model
     * partition whose PRI is given by the method {@link #getPri()}. If the
     * model element does not yet exist, it is created in the model partition.
     * For the MOFID calculation the default logical key is used, which consists
     * of
     * <ul>
     * <li>model container name</li>
     * <li>partition name</li>
     * <li>the unique XPATH of the current parsed XML element/attribute (see
     * {@link PathStack#getUniquePath()}</li>
     * </ul>
     * 
     * @param classDescriptor class descriptor of the type of the model element
     * @return model element handle
     * @throws NullPointerException if a parameter is <tt>null</tt>
     */
    PModelElementHandle getOrCreateModelElement( ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor );

    /**
     * Creates a link between an end A model element and end B model element for
     * a given association and end B name. Both model elements must be located
     * in the model partition whose PRI is specified by method {@link #getPri()}
     * (intra partition link).
     * 
     * @param associationDescriptor association descriptor
     * @param endBName name of the end B of the association
     * @param endAmodelElement handle for the model element on the end A side
     * @param endBmodelElement handle for the model element on the end B side
     * @throws IllegalArgumentException is thrown
     * <ul>
     * <li>if the end B name is not correct</li>
     * <li>if <tt>endAmodelElement</tt> or <tt>endBmodelElement</tt> are handles
     * which are not fetched by the method
     * {@link #getOrCreateModelElement(ClassDescriptor, String...)} or by the
     * method {@link #getOrCreateModelElement(ClassDescriptor)}</li>
     * <li>if the model element <tt>endAmodelElement</tt> or
     * <tt>endBmodelElement</tt> does not have the type which is excepted by the
     * corresponding association end</li>
     * </ul>
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    void createLink( AssociationDescriptor<? extends RefAssociation> associationDescriptor, String endBName, PModelElementHandle endAmodelElement, PModelElementHandle endBmodelElement );


    /**
     * Creates a link between an end A model element and an end B model element
     * which is given by its MOF class and logical key. The model element of end
     * A must be located in the model partition specified by the method
     * {@link #getPri()} and the storage of the link must be defined on the end
     * A side in the meta-model. Intra- and inter-partition links are supported.
     * <p>
     * If the end B model element with the given logical key does not exist at
     * the point in time when this method is called, then the creation of the
     * link is retarded: In this case the link is created at the end of the
     * parsing.
     * <p>
     * The exception handling is different for retarded and non-retarded link
     * creation. If the link creation is retarded, then
     * <ul>
     * <li>a {@link TypeMismatchException} will be thrown at the end of the
     * parsing if the type of the end A model element is not correct or if the
     * class descriptor of the end B is not correct and the created link is an
     * intra-partition link. In the CPS integration strategy such an exception
     * is not thrown.</li>
     * <li>a {@link XmException} will be thrown at the end of the parsing, if
     * the end B name is not correct</li>
     * </ul>
     * 
     * @param associationDescriptor association descriptor
     * @param endBName name of the end B of the association
     * @param endAmodelElement handle for the model element on the end A side
     * @param endBClassDescriptor class descriptor of the end B
     * @param endBLogicalKey logical key for the end B model element
     * @throws IllegalArgumentException is thrown
     * <ul>
     * <li>if the end B name is not correct</li> <li> if <tt>endAmodelElement
     * </tt> is a handle which is not fetched by the method
     * {@link #getOrCreateModelElement(ClassDescriptor, String...)} or by the
     * method {@link #getOrCreateModelElement(ClassDescriptor)}</li> <li> if
     * <tt>endBLogicalKey</tt> is empty</li> <li>if the model element <tt>
     * endAmodelElement</tt> does not have the type which is excepted by the
     * association for the end A <li>if the descriptor <tt>endBClassDescriptor
     * </tt> does not denote a type which is expected by the association of the
     * end B</li>
     * </ul>
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    void createLink( AssociationDescriptor<? extends RefAssociation> associationDescriptor, String endBName, PModelElementHandle endAmodelElement, ClassDescriptor<? extends RefClass, ? extends RefObject> endBClassDescriptor, String... endBLogicalKey );


    /**
     * Creates a link between an end A model element and an end B model element
     * which is given by its MOFID. The model element of end A must be located
     * in the model partition whose PRI is given by the method {@link #getPri()}
     * and the storage of the link must be defined on the end A side in the
     * meta-model. Intra- and inter-partition links are supported. Compare with
     * {@link #createLink(AssociationDescriptor, String, PModelElementHandle, ClassDescriptor, String...)}
     * .
     * <p>
     * If the end B model element with the given MOFID does not exist at the
     * point in time when this method is called, then the creation of the link
     * is retarded: In this case the link is created at the end of the parsing.
     * <p>
     * The exception handling is different for retarded and non-retarded link
     * creation. If the link creation is retarded, then
     * <ul>
     * <li>a {@link TypeMismatchException} will be thrown at the end of the
     * parsing if the type of the end A model element is not correct or if the
     * MOF class of end B MOFID does not fit to the end B of the association and
     * the created link is an intra-partition link. In the CPS integration
     * strategy such an exception is not thrown.</li>
     * <li>a {@link XmException} will be thrown at the end of the parsing, if
     * the end B name is not correct</li>
     * </ul>
     * 
     * @param associationDescriptor association descriptor
     * @param endBName name of the end B of the association
     * @param endAmodelElement handle for the model element on the end A side
     * @param endBMofid MOFID of the end B model element in HEX format
     * @throws IllegalArgumentException is thrown
     * <ul>
     * <li>if the end B name is not correct</li> <li> if <tt>endAmodelElement
     * </tt> is a handle which is not fetched by the method
     * {@link #getOrCreateModelElement(ClassDescriptor, String...)} or by the
     * method {@link #getOrCreateModelElement(ClassDescriptor)}</li> <li> if
     * <tt>endBMofid</tt> is empty</li> <li>if the model element <tt>
     * endAmodelElement</tt> does not have the type which is excepted by the
     * association for the end A <li>if the MOF class of the end B MOFID does
     * not fit to the end B of the association</li>
     * </ul>
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    void createLink( AssociationDescriptor<? extends RefAssociation> associationDescriptor, String endBName, PModelElementHandle endAmodelElement, String endBMofid );


    /**
     * Returns the type info provider with which type information can be
     * accessed during the parsing.
     * 
     * @return type info provider, is <code>null</code> if an XML schema has not
     * been provided in the parser configuration {@link XmParserConfiguration}
     */
    TypeInfoProvider getTypeInfoProvider( );

}
