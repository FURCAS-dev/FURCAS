package com.sap.tc.moin.xm.generation.core.code.serializer;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateErrorListener;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.StringTemplateGroupLoader;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.xm.generation.core.code.parser.XmParserGenerator;
import com.sap.tc.moin.xm.generation.core.code.serializer.template.XmSerializerTemplate;
import com.sap.tc.moin.xm.generation.core.code.util.CommonClassLoaderGroupLoader;
import com.sap.tc.moin.xm.generation.core.code.util.MoinStringTemplateErrorListener;

/** Code generator for a XM Serializer. */
public final class XmSerializerGenerator {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_GEN, XmParserGenerator.class );

    private static final StringTemplateGroup serializergroup;

    static {
        // instantiate StringTemplateGroupLoader and and register it

        final StringTemplateErrorListener errorListener = new MoinStringTemplateErrorListener( );

        final StringTemplateGroupLoader loader = new CommonClassLoaderGroupLoader( "com/sap/tc/moin/xm/generation/core/code/serializer/template", errorListener, XmSerializerGenerator.class.getClassLoader( ) ); //$NON-NLS-1$
        StringTemplateGroup.registerGroupLoader( loader );

        serializergroup = StringTemplateGroup.loadGroup( "serializer" ); //$NON-NLS-1$
    }


    /**
     * Generates the code for a template.
     * 
     * @param template
     * @return generated code
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    public String createCode( final XmSerializerTemplate template ) {

        if ( template == null ) {
            throw new MoinNullPointerException( "template" ); //$NON-NLS-1$
        }
        LOGGER.trace( MoinSeverity.DEBUG, "Creating code for XM Serializer {0} started", template.getJavaName( ) ); //$NON-NLS-1$
        final StringTemplate st = serializergroup.getInstanceOf( "serializer" ); //$NON-NLS-1$
        st.setAttribute( "template", template ); //$NON-NLS-1$
        return st.toString( );
    }
}
