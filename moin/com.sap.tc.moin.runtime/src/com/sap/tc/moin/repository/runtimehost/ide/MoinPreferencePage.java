package com.sap.tc.moin.repository.runtimehost.ide;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * The MOIN IDE preference-page of this Plugin used to maintain MOIN preference
 * values.
 */
public class MoinPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

//    public static final String PREFERENCE_DATABASE_TYPE = "database-type";
//
//    public static final String PREFERENCE_DATABASE_SERVER = "database-server";
//
//    public static final String PREFERENCE_DATABASE_PORT = "database-port";
//
//    public static final String PREFERENCE_DATABASE_NAME = "database-name";
//
//    public static final String PREFERENCE_DATABASE_URL = "database-url";
//
//    public static final String PREFERENCE_DATABASE_DRIVER = "database-driver";
//
//    public static final String PREFERENCE_DATABASE_USER = "database-user";
//
//    public static final String PREFERENCE_DATABASE_PASSWORD = "database-password";
//
//    // DEFAULT MSSQL
//    public static final String DATABASE_DRIVER_MSSQL = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//
//    public static final String DATABASE_URL_MSSQL = "jdbc:sqlserver://localhost:1433;DatabaseName=MOINFS";
//
//    // DEFAULT MAXDB
//    public static final String DATABASE_DRIVER_MAXDB = "com.sap.dbtech.jdbc.DriverSapDB";
//
//    public static final String DATABASE_URL_MAXDB = "jdbc:sapdb://localhost:7777/MOINFS";
//
//    public static final String DEFAULT_DATABASE_USER = "SAPMOINFS";
//
//    public static final String DEFAULT_DATABASE_PASSWORD = "abc123";
//
//    public static final String MS_SQL_DATABASE_TYPE = "MsSQL";
//
//    public static final String MAX_DB_DATABASE_TYPE = "MaxDB";
//
//    public static final String DEFAULT_DATABASE_TYPE = MS_SQL_DATABASE_TYPE;
//
//    public static final String DEFAULT_DATABASE_SERVER = "localhost";
//
//    public static final String DEFAULT_DATABASE_PORT = "1433";
//
//    public static final String DEFAULT_DATABASE_NAME = "MOINFS";
//
//    public static final String DEFAULT_DATABASE_URL = DATABASE_URL_MSSQL;
//
//    public static final String DEFAULT_DATABASE_DRIVER = DATABASE_DRIVER_MSSQL;
//
//    private RadioGroupFieldEditor _databaseType;
//
//    private StringFieldEditor _databaseUserEditor;
//
//    private StringFieldEditor _databasePasswordEditor;
//
//    private StringFieldEditor _databaseServer;
//
//    private StringFieldEditor _databasePort;
//
//    private StringFieldEditor _databaseName;

    /**
     * Creates and returns the text editor preference page.
     */
    public MoinPreferencePage( ) {

        super( FLAT );
        setDescription( TextPool.getString( TextPool.PREFERENCES_PAGE_DESCRIPTION ) );
        setPreferenceStore( getStaticPreferenceStore( ) );
    }

    /*
     * @see IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
     */
    public void createControl( Composite parent ) {

        super.createControl( parent );
    }

    /*
     * @see FieldEditorPreferencePage#createFieldEditors()
     */
    public void createFieldEditors( ) {

//        _databaseType = new RadioGroupFieldEditor( PREFERENCE_DATABASE_TYPE, "Database type", 2, new String[][] { { "Microsoft SQL Server", MS_SQL_DATABASE_TYPE }, { "SAP MaxDB", MAX_DB_DATABASE_TYPE } }, getFieldEditorParent( ), true ) {
//
//            protected boolean doCheckState( ) {
//
//                Composite redioButton = _databaseType.getRadioBoxControl( getFieldEditorParent( ) );
//                if ( redioButton == null ) {
//                    setErrorMessage( "Database type must be set" );
//                    return false;
//                }
//                return true;
//            }
//        };
//        addField( _databaseType );
//
//        _databaseServer = new StringFieldEditor( PREFERENCE_DATABASE_SERVER, "Database server name", getFieldEditorParent( ) ) {
//
//            protected boolean doCheckState( ) {
//
//                String url = _databaseServer.getStringValue( );
//                if ( url == null || url.length( ) == 0 ) {
//                    setErrorMessage( "Database server name must be set" );
//                    return false;
//                }
//                return true;
//            }
//        };
//        addField( _databaseServer );
//
//        _databasePort = new StringFieldEditor( PREFERENCE_DATABASE_PORT, "Database port number", getFieldEditorParent( ) ) {
//
//            protected boolean doCheckState( ) {
//
//                String url = _databasePort.getStringValue( );
//                if ( url == null || url.length( ) == 0 ) {
//                    setErrorMessage( "Database port number must be set" );
//                    return false;
//                }
//                return true;
//            }
//        };
//        addField( _databasePort );
//
//        _databaseName = new StringFieldEditor( PREFERENCE_DATABASE_NAME, "Database name       ", getFieldEditorParent( ) ) {
//
//            protected boolean doCheckState( ) {
//
//                String driver = _databaseName.getStringValue( );
//                if ( driver == null || driver.length( ) == 0 ) {
//                    setErrorMessage( "Database name must be set" );
//                    return false;
//                }
//                return true;
//            }
//        };
//        addField( _databaseName );
//
//        _databaseUserEditor = new StringFieldEditor( PREFERENCE_DATABASE_USER, "Database user       ", getFieldEditorParent( ) ) {
//
//            protected boolean doCheckState( ) {
//
//                String user = _databaseUserEditor.getStringValue( );
//                if ( user == null || user.length( ) == 0 ) {
//                    setErrorMessage( "Database user must be set" );
//                    return false;
//                }
//                return true;
//            }
//        };
//        addField( _databaseUserEditor );
//
//        _databasePasswordEditor = new StringFieldEditor( PREFERENCE_DATABASE_PASSWORD, "Database password", getFieldEditorParent( ) ) {
//
//            protected boolean doCheckState( ) {
//
//                String password = _databasePasswordEditor.getStringValue( );
//                if ( password == null || password.length( ) == 0 ) {
//                    setErrorMessage( "Database password must be set" );
//                    return false;
//                }
//                return true;
//            }
//        };
//        addField( _databasePasswordEditor );
    }

    /*
     * @see IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
     */
    public void init( IWorkbench workbench ) {

    }

    // =========================== public access ==============================

    /**
     * Returns the (static) IPreferenceStore, which is used by all instanced of
     * this PreferencePage. This can be used to access the preferences
     * everywhere.
     * 
     * @return The (static) IPreferenceStore.
     */
    public static IPreferenceStore getStaticPreferenceStore( ) {

        IPreferenceStore result = IdeRuntimeHostImpl.getDefault( ).getPreferenceStore( );

        //result.setDefault( PREFERENCE_DATABASE_TYPE, DEFAULT_DATABASE_TYPE );

        //result.setDefault( PREFERENCE_DATABASE_SERVER, DEFAULT_DATABASE_SERVER );
        //result.setDefault( PREFERENCE_DATABASE_PORT, DEFAULT_DATABASE_PORT );
        //result.setDefault( PREFERENCE_DATABASE_NAME, DEFAULT_DATABASE_NAME );

        //result.setDefault( PREFERENCE_DATABASE_USER, DEFAULT_DATABASE_USER );
        //result.setDefault( PREFERENCE_DATABASE_PASSWORD, DEFAULT_DATABASE_PASSWORD );

        return result;
    }
}
