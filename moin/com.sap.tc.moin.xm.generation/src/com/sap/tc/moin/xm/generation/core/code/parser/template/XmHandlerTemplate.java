package com.sap.tc.moin.xm.generation.core.code.parser.template;

import java.util.Collection;

/**
 * Template for the generation of the sub-handler inner classes.
 */
public interface XmHandlerTemplate {

    /**
     * Returns the unqualified class name of the sub-handler. For example:
     * "Ts$ECustomer".
     */
    String getClassName( );

    /**
     * Returns the dot separated qualified MOF class name if the complex type
     * treated by this handler is associated with a MOF Class, otherwise
     * <code>null</code> is returned.
     * <p>
     * From this information the method "elementStarted" is generated.
     */
    String getQualifiedJavaClassName( );

    /**
     * Returns the name of the global XML complex type definition or the name of
     * the global XML element declaration (in case of an anonymous complex type
     * definition) which is treated by this handler.
     *<p>
     * For example: "global element declaration "structure
     * (http://sap.com/test)""
     * <p>
     * If the complex type definition is a nested anonymous type definition then
     * the path to this anonymous type definition is returned.
     * 
     * @return entity name, cannot be <code>null</code>
     */
    String getXmlEntityQName( );

    /**
     * Returns a list which contains the prefixes of the child elements and
     * their corresponding handlers.
     * 
     * @return list, cannot be <code>null</code>
     */
    Collection<PrefixToElementHandlers> getChilds( );

    /**
     * Returns <code>true</code> if the method "addSimpleElmentOrAttribute" must
     * be generated.
     * 
     * @return <code>true</code> if the method "addSimpleElmentOrAttribute" must
     * be generated, otherwise <code>false</code>
     */
    boolean isAddSimpleElementOrAttribute( );

    /**
     * Returns the collection which maps the prefix to XML elements and their
     * MOIN attributes.
     * <p>
     * This information is used to generate the method
     * "addSimpleElementOrAttribute".
     * 
     * @return map cannot be <code>null</code>
     */
    Collection<PrefixToSimpleElementOrAttribute> getXmlSimpleElementToMoinAttributeNameMap( );


    /**
     * Returns the collection which maps the prefix to XML attribute names and
     * their MOIN attributes.
     * <p>
     * This information is used to generate the method
     * "addSimpleElementOrAttribute".
     * 
     * @return map cannot be <code>null</code>
     */
    Collection<PrefixToSimpleElementOrAttribute> getXmlAttributeToMoinAttributeNameMap( );

    /**
     * Returns the associations for the children.
     * <p>
     * From this information the method "childClosed" is generated.
     * 
     * @return child associations.
     */
    Collection<PrefixToChildAssociation> getChildAssociations( );


    /**
     * Returns <tt>true</tt> if the complex type definition represented by the
     * handler has simple content, otherwise <tt>false</tt>.
     * 
     * @return <tt>true</tt> for simple content
     */
    boolean isSimpleContent( );

}
