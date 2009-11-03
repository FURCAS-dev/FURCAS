package com.sap.tc.moin.xm.generation.core.code.parser.template;

import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.xm.generation.core.code.util.XmParserSerializerTemplate;


/** Template for the XM Parser code generation. */
public interface XmParserHandlerTemplate extends XmParserSerializerTemplate {


    /**
     * The local element names are used to generate the static string constants
     * for the local element names.
     * 
     * @return list of local unique element names, cannot be <code>null</code>
     */
    List<JavaNameAndName> getLocalElementNames( );


    /**
     * The local attribute names are used to generate the static string
     * constants for the local attribute names.
     * 
     * @return list of local unique attribute names, cannot be <code>null</code>
     */
    List<JavaNameAndName> getLocalAttributeNames( );

    /**
     * Returns the sub-handler list.
     * <p>
     * This information is used to generate the registration of the sub-handlers
     * and to generate the code for the sub-handlers.
     * 
     * @return sub-handler list, cannot be <code>null</code>
     */
    Collection<XmHandlerTemplate> getSubHandlers( );

    /**
     * Returns the dot separated qualified JMI java class name for the root
     * document model element.
     * <p>
     * From this information the method "rootElementStarted" is generated.
     */
    String getQualifiedRootDocumentJmiClassName( );


    /**
     * Returns a list of root XML elements which can be handled by the generated
     * parser handler.
     * 
     * @return list of root XML elements, cannot be <code>null</code>
     */
    Collection<PrefixToElementHandlers> getRootElements( );


    /**
     * Returns the associations between the document root meta-model element and
     * the meta-model elements of the complex types of root elements.
     * <p>
     * From this information the method "rootElementClosed" is generated.
     * 
     * @return child associations.
     */
    Collection<PrefixToChildAssociation> getChildAssociations( );



    /**
     * Returns the collection which maps the prefix to XML elements and their
     * MOIN attributes.
     * <p>
     * This information is used to generate the method "addSimpleRootElement".
     * 
     * @return map cannot be <code>null</code>
     */
    Collection<PrefixToSimpleElementOrAttribute> getXmlSimpleRootElementToMoinAttributeName( );

}
