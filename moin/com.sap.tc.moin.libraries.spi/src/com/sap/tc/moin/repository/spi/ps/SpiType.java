package com.sap.tc.moin.repository.spi.ps;

import java.util.List;

import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiElement;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiLink;

/**
 * The interface {@link SpiType} is the abstraction of either a class or an
 * association in a MOIN metamodel, and thus has the two sub-interfaces
 * {@link SpiClass} and {@link SpiAssociation}.
 * <p>
 * In the parser scenario, instances of {@link SpiClass} and
 * {@link SpiAssociation} need to be passed to those {@link SpiParserCallback}
 * methods that add an element or a link, representing the meta object. They
 * cannot be created by the parser author, but are returned from calls to
 * {@link SpiParserCallback#getClass(String)},
 * {@link SpiParserCallback#getClass(String, String)},
 * {@link SpiParserCallback#getclass(String, String, String)},
 * {@link SpiParserCallback#getAssociation(String)},
 * {@link SpiParserCallback#getAssociation(String, String)} or
 * {@link SpiParserCallback#getAssociation(String, String, String)}.
 * <p>
 * In the serializer scenario, each {@link SpiElement} and each {@link SpiLink}
 * can be asked for its type.
 */
public interface SpiType {

    /**
     * Returns the type's MOF id.
     * 
     * @return the type's MOF id, or <code>null</code> if this information is
     * not available
     */
    public String get___MofId( );

    /**
     * Returns the type's qualified name.
     * 
     * @return the type's qualified name, or <code>null</code> if this
     * information is not available
     */
    public String get___QualifiedName( );

    /**
     * Returns the type's metamodel container name.
     * 
     * @return the type's metamodel container name, or <code>null</code> if
     * this information is not available
     */
    public String get___MetamodelContainer( );

    /**
     * Returns the version of the deployed metamodel (e.g. <code>1.0.0</code>).
     * 
     * @return the version of the deployed metamodel
     */
    public String get___MetamodelVersion( );

    /**
     * Returns a list of all supertypes of this type.
     * 
     * @return a list of all supertypes of this type
     */
    public List<SpiType> get___AllSuperTypes( );
}