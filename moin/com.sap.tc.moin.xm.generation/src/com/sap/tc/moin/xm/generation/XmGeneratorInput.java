package com.sap.tc.moin.xm.generation;

import org.eclipse.xsd.XSDSchema;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;

/**
 * Input for the XM Generator. See {@link XmGenerator}.
 */
public final class XmGeneratorInput {


    private final XSDSchema schema;

    private final String parserClassName;

    private final String serializerClassName;

    private final String parserPackageName;

    private final String serializerPackageName;

    private final String xmCpsFactoryClassName;

    private final String xmCpsFactoryPackageName;

    private final String cpsSuffix;

    private final Connection connection;

    private final ModelPartition partition;

    XmGeneratorInput( final Connection aConnection, final PRI metamodelPartionPri, final XSDSchema aSchema, final String aParserClassName, final String aParserPackageName, final String aSerializerClassName, final String aSerializerPackageName, final String aXmCpsFactoryClassName,
        final String aXmCpsFactoryPackageName, final String aCpsSuffix ) {

        if ( aConnection == null ) {
            throw new MoinNullPointerException( "aConnection" ); //$NON-NLS-1$
        }
        if ( aSchema == null ) {
            throw new MoinNullPointerException( "aSchema" ); //$NON-NLS-1$
        }
        this.connection = aConnection;
        this.schema = aSchema;
        this.parserClassName = aParserClassName;
        this.parserPackageName = aParserPackageName;
        this.serializerClassName = aSerializerClassName;
        this.serializerPackageName = aSerializerPackageName;
        this.xmCpsFactoryClassName = aXmCpsFactoryClassName;
        this.xmCpsFactoryPackageName = aXmCpsFactoryPackageName;
        this.cpsSuffix = aCpsSuffix;
        if ( this.parserClassName != null && this.parserClassName.length( ) == 0 ) {
            throw new MoinIllegalArgumentException( "parserClassName", "" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        if ( this.parserPackageName != null && this.parserPackageName.length( ) == 0 ) {
            throw new MoinIllegalArgumentException( "parserPackageName", "" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        if ( this.serializerClassName != null && this.serializerClassName.length( ) == 0 ) {
            throw new MoinIllegalArgumentException( "serializerClassName", "" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        if ( this.serializerPackageName != null && this.serializerPackageName.length( ) == 0 ) {
            throw new MoinIllegalArgumentException( "serializerPackageName", "" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        if ( this.xmCpsFactoryClassName != null && this.xmCpsFactoryClassName.length( ) == 0 ) {
            throw new MoinIllegalArgumentException( "xmCpsFactoryClassName", "" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        if ( this.xmCpsFactoryPackageName != null && this.xmCpsFactoryPackageName.length( ) == 0 ) {
            throw new MoinIllegalArgumentException( "xmCpsFactoryPackageName", "" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        if ( this.cpsSuffix != null && this.cpsSuffix.length( ) == 0 ) {
            throw new MoinIllegalArgumentException( "cpsSuffix", "" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        if ( metamodelPartionPri != null ) {
            this.partition = this.connection.getPartition( metamodelPartionPri );
            if ( this.partition == null ) {
                throw new MoinIllegalArgumentException( XmGeneratorMessages.METAMODELPARTITIONNOTEXISTING, metamodelPartionPri );
            }
        } else {
            this.partition = null;
        }
    }

    /**
     * Returns the MOIN connection.
     * 
     * @return MOIN connection, cannot be <code>null</code>
     */
    public Connection getConnection( ) {

        return connection;
    }


    /**
     * Returns the XML schema.
     * 
     * @return schema, cannot be <code>null</code>
     */
    public XSDSchema getSchema( ) {

        return schema;
    }


    /**
     * Returns the parser class name. For example: "MyParser".
     * 
     * @return parser class name, can be <code>null</code>
     */
    public String getParserClassName( ) {

        return parserClassName;
    }


    /**
     * Returns the serializer class name. For example: "MySerializer".
     * 
     * @return serializer class name, can be <code>null</code>
     */
    public String getSerializerClassName( ) {

        return serializerClassName;
    }


    /**
     * Returns the package name of the parser class. For example:
     * "com.sap.test".
     * 
     * @return package name of the parser class, can be <code>null</code>
     */
    public String getParserPackageName( ) {

        return parserPackageName;
    }


    /**
     * Returns the package name of the serializer class. For example:
     * "com.sap.test".
     * 
     * @return package name of the serializer class, can be <code>null</code>
     */
    public String getSerializerPackageName( ) {

        return serializerPackageName;
    }

    /**
     * Returns the meta-model partition.
     * 
     * @return partition, can be <code>null</code>
     */
    public ModelPartition getMetamodelPartition( ) {

        return this.partition;
    }

    /**
     * Returns the class name for the XM CPS factory class .
     * 
     * @return class name, can be <code>null</code>
     */
    public String getXmCpsFactoryClassName( ) {

        return xmCpsFactoryClassName;
    }


    /**
     * Returns the package name for the XM CPS factory class.
     * 
     * @return package name, can be <code>null</code>
     */
    public String getXmCpsFactoryPackageName( ) {

        return xmCpsFactoryPackageName;
    }

    /**
     * Returns the suffix for the model partition in the CPS integration
     * stratety.
     * 
     * @return suffix, can be <code>null</code>
     */
    public String getCpsSuffix( ) {

        return this.cpsSuffix;
    }

    /**
     * Indicator whether a meta-model shall be generated.
     * 
     * @return <tt>true</tt> if the partition is not <code>null</code>;
     * otherwise <code>false</code>
     */
    public boolean generateMetamodel( ) {

        return this.partition != null;
    }

    /**
     * Indicator whether the parser class shall be generated.
     * 
     * @return <tt>true</tt> if the parser class and package name are not
     * <code>null</code>; otherwise <code>false</code>
     */
    public boolean generateParser( ) {

        return this.parserClassName != null || this.parserPackageName != null;
    }

    /**
     * Indicator whether the serializer class shall be generated.
     * 
     * @return <tt>true</tt> if the serializer class and package name are not
     * <code>null</code>; otherwise <code>false</code>
     */
    public boolean generateSerializer( ) {

        return this.serializerClassName != null || this.serializerPackageName != null;
    }

    /**
     * Indicator whether the XM CPS factory class shall be generated.
     * 
     * @return <tt>true</tt> if the XM CPS factory class and package name are
     * not <code>null</code>; otherwise <code>false</code>
     */
    public boolean generateXmCpsFactory( ) {

        return this.xmCpsFactoryClassName != null || this.xmCpsFactoryPackageName != null;
    }


    /**
     * Indicator whether the model-storage XML shall be generated.
     * 
     * @return <tt>true</tt> if the CPS suffix is not <code>null</code>;
     * otherwise <code>false</code>
     */
    public boolean generateModelStorageXml( ) {

        return this.cpsSuffix != null;
    }

}
