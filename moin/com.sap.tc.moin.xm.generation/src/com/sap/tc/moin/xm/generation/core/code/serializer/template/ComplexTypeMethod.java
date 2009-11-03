package com.sap.tc.moin.xm.generation.core.code.serializer.template;

import java.util.List;

/**
 * Template for a method which is generated for a complex type definition which
 * is the type of an element declaration.
 */
public interface ComplexTypeMethod {


    /**
     * Returns the name of the method.
     * 
     * @return method name, cannot be <code>null</code>
     */
    String getMethodName( );

    /**
     * Returns the XML attributes of the complex type and its direct and
     * indirect super types. whose values are determined from the attributes of
     * the MOIN class which is passed as parameter in the generated method.
     * 
     * @return XML attributes, cannot be <code>null</code>
     */
    List<SimpleElementOrAttribute> getXmlAttributes( );


    /**
     * Returns the generation information for the child XML elements of the
     * complex type.
     * 
     * @return list of child element generation information, cannot be
     * <code>null</code>
     */
    List<ChildElement> getChilds( );

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
     * @return <tt>true</tt> if the complex type definition has simple content,
     * otherwise <tt>false</tt>
     */
    boolean isSimpleContent( );

    /**
     * Returns the dot separated qualified class name of the MOIN model element
     * from which the simple content value is read.
     * 
     * @return qualified class name
     */
    String getQualifiedClassNameOfParameter( );

}
