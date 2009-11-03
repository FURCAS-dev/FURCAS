package com.sap.tc.moin.repository.runtimehost.deployment;

import java.io.InputStream;

import org.w3c.dom.Node;

import com.sap.tc.moin.repository.runtimehost.MmInfoConst;

/**
 * Registration parser for s2x callbecks
 * <p>
 * Reads the registration xml file "textverticalization.xml" for s2x callbacks.
 * The files are based on the schema "textverticalization_inf.xsd".
 * </p>
 * <p>
 * There can only be one s2x callback per container.
 * </p>
 * 
 * @author d026715
 */
public class TextVerticalizationRegistrationRecord extends RegistrationRecordBase {

    private static final String SCHEMA_ERRORHANDLER_INF_XSD = SCHEMA_LOCATION + "textverticalization_inf.xsd"; //$NON-NLS-1$

    public static String RESOURCE_NAME = MmInfoConst.S2X_CALLBACK_INF_FILE_NAME;

    private static final String[] TV_CALLBACK = new String[] { "TextverticalizationInf", "SerializationCallback" }; //$NON-NLS-1$ //$NON-NLS-2$

    public static final String CLASS_NAME = "className"; //$NON-NLS-1$

    private String tvCallback;

    private String containerId;

    @Override
    protected void initSchema( ) {

        InputStream schemaFile = TextVerticalizationRegistrationRecord.class.getClassLoader( ).getResourceAsStream( SCHEMA_ERRORHANDLER_INF_XSD );
        setSchemaValidation( schemaFile );
    }

    @Override
    protected void initVisitors( ) {

        this.visitors.add( new TvVisitor( ) );

    }

    class TvVisitor implements NodeVisitor {

        public String[][] isInterestedIn( ) {

            return new String[][] { TV_CALLBACK };
        }

        public boolean handleNode( String[] fullPath, Node node ) {

            tvCallback = getAttribute( CLASS_NAME, node );

            return true;
        }
    }

    public String getTvCallbackHandler( ) {

        return this.tvCallback;
    }

    public void setContainerId( String containerId ) {

        this.containerId = containerId;
    }

    public String getContainerId( ) {

        return containerId;
    }

}
