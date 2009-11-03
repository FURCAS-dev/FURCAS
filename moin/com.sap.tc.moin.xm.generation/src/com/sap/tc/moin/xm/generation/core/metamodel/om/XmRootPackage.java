package com.sap.tc.moin.xm.generation.core.metamodel.om;

import java.util.ArrayList;

import com.sap.tc.moin.repository.mmi.model.Import;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;
import com.sap.tc.moin.repository.mmi.primitivetypes.PrimitiveTypesPackage;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.xm.generation.XmGeneratorInput;

public final class XmRootPackage extends XmPackage {

    private final String javaPrefix;

    final static String TAG_ID_MM_PREFIX = "org.omg.mof.idl_prefix"; //$NON-NLS-1$

    private final String targetNamespace;

    /**
     * Constructor.
     * 
     * @param input
     * @param name
     * @param aJavaPrefix
     * @param xsdTargetNamespace target namespace from which the root package
     * was calculated, is empty for the no-namespace
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public XmRootPackage( final XmGeneratorInput input, final String name, final String aJavaPrefix, final String xsdTargetNamespace ) {

        super( input, name );
        if ( aJavaPrefix == null ) {
            throw new MoinNullPointerException( "aJavaPrefix" ); //$NON-NLS-1$
        }
        if ( aJavaPrefix == null ) {
            throw new MoinNullPointerException( "xsdTargetNamespace" ); //$NON-NLS-1$
        }
        this.javaPrefix = aJavaPrefix;
        this.targetNamespace = xsdTargetNamespace;
    }

    /**
     * Returns the java prefix.
     * 
     * @return java prefix or empty string if no java prefix is defined; cannot
     * be <code>null</code>
     */
    public String getJavaPrefix( ) {

        return this.javaPrefix;
    }

    /**
     * Returns the XSD target namespace for which the root package was created.
     * 
     * @return target namespace or the empty string for the no-namespace, cannot
     * be <code>null</code>
     */
    public String getTargetNamespace( ) {

        return this.targetNamespace;
    }

    @Override
    public MofPackage createModelElement( ) {

        final MofPackage rootMofPackage = super.createModelElement( );

        if ( rootMofPackage != null ) {
            final Import primitiveTypeImport = (Import) this.createClassInstance( Import.CLASS_DESCRIPTOR, "PrimitiveTypes", this ); //$NON-NLS-1$
            primitiveTypeImport.setName( "PrimitiveTypes" ); //$NON-NLS-1$
            primitiveTypeImport.setAnnotation( "" ); //$NON-NLS-1$
            primitiveTypeImport.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
            primitiveTypeImport.setClustered( false );
            primitiveTypeImport.setContainer( rootMofPackage );
            final Namespace primitiveTypesNamespace = this.getInput( ).getConnection( ).getPackage( PrimitiveTypesPackage.PACKAGE_DESCRIPTOR ).refMetaObject( );
            primitiveTypeImport.setImportedNamespace( primitiveTypesNamespace );
        }

        if ( rootMofPackage != null && this.javaPrefix.length( ) > 0 ) {
            final ArrayList<String> tagValueList = new ArrayList<String>( 1 );
            tagValueList.add( javaPrefix );
            final String tagName = TAG_ID_MM_PREFIX + "=" + javaPrefix;//$NON-NLS-1$
            final Tag tag = (Tag) this.createClassInstance( Tag.CLASS_DESCRIPTOR, tagName, this );
            tag.setName( tagName );
            tag.setAnnotation( "" ); //$NON-NLS-1$
            tag.setTagId( TAG_ID_MM_PREFIX );
            tag.getValues( ).addAll( tagValueList );
            tag.setContainer( rootMofPackage );
            tag.getElements( ).add( rootMofPackage );
        }
        modelElement = rootMofPackage;

        return (MofPackage) modelElement;
    }

    private String text;

    @Override
    public String toString( ) {

        if ( text == null ) {
            text = "Root package \"" + this.getMofName( ) + "\" with java prefix \"" + this.getJavaPrefix( ) + "\""; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }
        return this.text;
    }
}
