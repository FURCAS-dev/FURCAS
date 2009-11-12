package com.sap.tc.moin.xm.generation.core.code.cps;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateErrorListener;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.StringTemplateGroupLoader;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.xm.generation.XmGeneratorInput;
import com.sap.tc.moin.xm.generation.core.code.util.CommonClassLoaderGroupLoader;
import com.sap.tc.moin.xm.generation.core.code.util.MoinStringTemplateErrorListener;

/** Code generator for the CPS parts XM CPS factory code and model-storage xml. */
public final class XmCpsPartsGenerator {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_GEN, XmCpsPartsGenerator.class );

    private static final StringTemplateGroup xmcps;

    private final XmGeneratorInput input;

    private String xmCpsFactoryCode;

    private String modelStorageXml;

    public XmCpsPartsGenerator( final XmGeneratorInput aInput ) {

        if ( aInput == null ) {
            throw new MoinNullPointerException( "aInput" ); //$NON-NLS-1$
        }
        this.input = aInput;
    }

    static {
        // instantiate StringTemplateGroupLoader and and register it

        final StringTemplateErrorListener errorListener = new MoinStringTemplateErrorListener( );

        final StringTemplateGroupLoader loader = new CommonClassLoaderGroupLoader( "com/sap/tc/moin/xm/generation/core/code/cps", errorListener, XmCpsPartsGenerator.class.getClassLoader( ) ); //$NON-NLS-1$
        StringTemplateGroup.registerGroupLoader( loader );

        xmcps = StringTemplateGroup.loadGroup( "xmcps", DefaultTemplateLexer.class, null ); //$NON-NLS-1$
    }


    public void execute( ) {

        if ( input.generateXmCpsFactory( ) ) {
            xmCpsFactoryCode = createCodeForXmCpsFactory( new XmCpsFactoryTemplate( input.getXmCpsFactoryPackageName( ), input.getXmCpsFactoryClassName( ), input.getParserPackageName( ) + "." + input.getParserClassName( ), input.getSerializerPackageName( ) + "." + input.getSerializerClassName( ) ) ); //$NON-NLS-1$ //$NON-NLS-2$
        } else {
            xmCpsFactoryCode = null;
        }
        if ( input.generateModelStorageXml( ) ) {
            final String qualifiedFacotryClassName = input.getXmCpsFactoryPackageName( ) + "." + input.getXmCpsFactoryClassName( ); //$NON-NLS-1$
            modelStorageXml = createModelStorageXml( new XmCpsModelstorageTemplate( qualifiedFacotryClassName, input.getCpsSuffix( ), qualifiedFacotryClassName ) );
        } else {
            modelStorageXml = null;
        }
    }


    /**
     * Returns the java code for the XM CPS factory.
     * 
     * @return java code or <code>null</code> if the generation of the XM CPS
     * factory was not requested or the method {@link #execute()} was not called
     * before
     */
    public String getXmCpsFactoryCode( ) {

        return this.xmCpsFactoryCode;
    }

    /**
     * Returns the model-storage XML.
     * 
     * @return model-storage XML or <code>null</code> if the generation of the
     * model-storage XML was not requested or the method {@link #execute()} was
     * not called before
     */
    public String getModelstorageXml( ) {

        return this.modelStorageXml;
    }

    /**
     * Generates the XM CPS factory java source code.
     * 
     * @param template
     * @return generated code
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    private String createCodeForXmCpsFactory( final XmCpsFactoryTemplate template ) {

        if ( template == null ) {
            throw new MoinNullPointerException( "template" ); //$NON-NLS-1$
        }
        LOGGER.trace( MoinSeverity.INFO, "Creating code for XM CPS Factory {0} started", template.getClassName( ) ); //$NON-NLS-1$
        final StringTemplate st = xmcps.getInstanceOf( "xmcpsfactory" ); //$NON-NLS-1$
        st.setAttribute( "template", template ); //$NON-NLS-1$
        return st.toString( );
    }


    /**
     * Generates the XM CPS model-storage XML.
     * 
     * @param template
     * @return generated model-storage XML
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    private String createModelStorageXml( final XmCpsModelstorageTemplate template ) {

        if ( template == null ) {
            throw new MoinNullPointerException( "template" ); //$NON-NLS-1$
        }
        LOGGER.trace( MoinSeverity.INFO, "Creating model storage XML started" ); //$NON-NLS-1$
        final StringTemplate st = xmcps.getInstanceOf( "xmcpsmodelstorage" ); //$NON-NLS-1$
        st.setAttribute( "template", template ); //$NON-NLS-1$
        return st.toString( );
    }
}
