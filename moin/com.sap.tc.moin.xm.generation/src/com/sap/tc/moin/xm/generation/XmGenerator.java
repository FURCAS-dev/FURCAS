package com.sap.tc.moin.xm.generation;

import org.eclipse.xsd.XSDSchema;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.exception.MoinBaseRuntimeException;

/**
 * Generator of MOIN meta models and XML parsers/serializers from XML schemas. A
 * MOIN meta model and a XML document parser and serializer is generated from an
 * XML schema. Further, CPS artefacts can be generated for the CPS integrations
 * strategy of XM.
 * <p>
 * The implementation must be thread-safe.
 * 
 * @noimplement This class is not intended to be sub-classed by clients.
 */
public abstract class XmGenerator {

    private static final String className = "com.sap.tc.moin.xm.generation.core.XmGeneratorImpl"; //$NON-NLS-1$

    private static final String error = "The class " + className + " does not exist."; //$NON-NLS-1$ //$NON-NLS-2$


    protected XmGenerator( ) {

    }

    /**
     * Executes the generation.
     * <p>
     * Meta-model elements are created in the partition whose PRI is given in
     * the input object.
     * <p>
     * The caller is responsible to save the meta-model partition via the
     * connection specified during the creation of the input object.
     * <p>
     * The generation is executed in a MOIN command ({@link Command}).
     * 
     * @param input input parameter
     * @return generation result, cannot be <code>null</code>
     * @throws XmGeneratorException if the provided XML schema in the input
     * parameter is not valid, the message contains the detailed validation
     * errors
     * @throws MoinBaseRuntimeException if a MOIN problem occurs, all changes
     * done in the meta-model partition are reverted
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    public abstract XmGeneratorOutput execute( XmGeneratorInput input ) throws XmGeneratorException;


    /**
     * Returns an instance of the meta model generator.
     * 
     * @return instance of the meta model generator
     */
    public static XmGenerator getInstance( ) {

        try {
            return (XmGenerator) Class.forName( className ).newInstance( );
        } catch ( final InstantiationException e ) {
            throw new IllegalStateException( error, e );
        } catch ( final IllegalAccessException e ) {
            throw new IllegalStateException( error, e );
        } catch ( final ClassNotFoundException e ) {
            throw new IllegalStateException( error, e );
        }
    }

    /**
     * Creates an input instance for the generator.
     * <p>
     * By setting some parameters to <code>null</code>, you can decide which XM
     * parts will be generated.
     * 
     * @param connection MOIN connection, must not be <code>null</code>
     * @param metamodelPartitionPri PRI of the meta-model partition in which the
     * meta-model elements are created, updated, or deleted; if
     * <code>null</code> then the MOIN meta-model will not be generated
     * @param schema XML schema, must not be <code>null</code>
     * @param parserClassName java class name of the parser, for example
     * "MyParser"; if <code>null</code> then the parser class will not be
     * generated
     * @param parserPackageName java package name of the parer class, for
     * example "com.sap.test"; if <code>null</code> then the parser class will
     * not be generated
     * @param serializerClassName java class name of the serializer, for example
     * "MySerializer"; if <code>null</code> then the serializer class will not
     * be generated
     * @param serializerPackageName java package name of the serializer class,
     * for example "com.sap.test"; if <code>null</code> then the serializer
     * class will not be generated
     * @param xmCpsFactoryClassName java class name of the XM CPS factory,
     * necessary in the CPS integration strategy, for example "MyXmCpsFactory";
     * if <code>null</code> then the XM CPS factory class will not be generated
     * @param xmCpsFactoryPackageName java package name of the XM CPS factory,
     * for example "com.sap.test" if <code>null</code> then the XM CPS factory
     * class will not be generated
     * @param cpsSuffix suffix for the model partition in the CPS integration
     * strategy, for example "myxml", if <code>null</code> then the
     * model-storage XML will not be generated
     * @return generator input instance
     * @throws NullPointerException if <tt>connection</tt> or <tt>schema</tt> is
     * <code>null</code>
     * @throws IllegalArgumentException if <tt>cpsSuffix</tt>,
     * <tt>xmCpsFactoryClassName>, <tt>xmCpsFactoryPackageName</tt>,
     * <tt>parserClassName>, <tt>serializerClassName</tt>,
     * <tt>parserPackageName</tt> or <tt>serializerPackageName</tt> is the empty
     * string, or if the <tt>metamodelPartitionPri</tt> is not <code>null</code>
     * and a meta-model partition does not exist for the given PRI
     */
    public static XmGeneratorInput createInput( final Connection connection, final PRI metamodelPartitionPri, final XSDSchema schema, final String parserClassName, final String parserPackageName, final String serializerClassName, final String serializerPackageName,
        final String xmCpsFactoryClassName, final String xmCpsFactoryPackageName, final String cpsSuffix ) {

        return new XmGeneratorInput( connection, metamodelPartitionPri, schema, parserClassName, parserPackageName, serializerClassName, serializerPackageName, xmCpsFactoryClassName, xmCpsFactoryPackageName, cpsSuffix );
    }

}
