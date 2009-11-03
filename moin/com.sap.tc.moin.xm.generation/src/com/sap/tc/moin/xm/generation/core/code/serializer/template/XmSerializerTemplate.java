package com.sap.tc.moin.xm.generation.core.code.serializer.template;

import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.xm.generation.core.code.util.XmParserSerializerTemplate;

/** Template for the XM Serializer code generation. */
public interface XmSerializerTemplate extends XmParserSerializerTemplate {

    /**
     * The qualified XML element names are used to generate the static string
     * constants for the qualified XML element names.
     * 
     * @return local unique element name list, cannot be <code>null</code>
     */
    List<QualifiedName> getElementQNames( );


    /**
     * The qualified XML attribute names are used to generate the static string
     * constants for the XML attribute names.
     * 
     * @return local unique attribute name list, cannot be <code>null</code>
     */
    List<QualifiedName> getAttributeQNames( );

    /**
     * Returns the dot separated qualified class name of the model element from
     * which the root XML element is serialized.
     * 
     * @return qualified class name
     */
    String getQualifiedClassNameOfRootMoinClass( );

    /**
     * Returns the method name which writes the document root complex type to
     * the output stream.
     * 
     * @return method name
     */
    String getMethodNameOfRootComplexType( );


    /**
     * Returns the collection of complex type methods.
     * 
     * @return collection of complex type methods, cannot be <code>null</code>
     */
    Collection<? extends ComplexTypeMethod> getComplexTypeMethods( );

    /**
     * Returns the collection of substitution group methods.
     * 
     * @return list of substitution group methods, cannot be <code>null</code>
     */
    Collection<? extends SubstitutionGroupMethod> getSubstitutionGroupMethods( );

}
