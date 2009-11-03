package com.sap.tc.moin.repository.runtimehost.deployment;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import org.w3c.dom.Node;

import com.sap.tc.moin.repository.runtimehost.MmInfoConst;

/**
 * Registration parser for error handlers.
 * <p>
 * Reads the registration xml file "errorhandler.xml" for error handlers. The
 * files are based on the schema "errorhandler_inf.xsd".
 * </p>
 * <p>
 * There can be multiple error handlers for different version ranges.
 * </p>
 * 
 * @author d026715
 */
public class ErrorHandlerRegistrationRecord extends RegistrationRecordBase {

    private static final String SCHEMA_ERRORHANDLER_INF_XSD = SCHEMA_LOCATION + "errorhandler_inf.xsd"; //$NON-NLS-1$

    public static String RESOURCE_NAME = MmInfoConst.ERROR_HANDLER_INF_FILE_NAME;

    private static final String[] ERROR_HANDLERS = new String[] { "ErrorhandlerInf", "Errorhandlers", "Metamodel", "Version", "Errorhandler" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

    public static final String CLASS_NAME = "className"; //$NON-NLS-1$

    public static final String VERSION_FROM = "rangeFrom"; //$NON-NLS-1$

    public static final String VERSION_TO = "rangeTo"; //$NON-NLS-1$

    private static final String CONTAINER_ID = "containerId"; //$NON-NLS-1$

    private Set<ErrorHandlerRecord> errorHandlers = new HashSet<ErrorHandlerRecord>( );

    @Override
    protected void initVisitors( ) {

        this.visitors.add( new ErrorHandlersVisitor( ) );

    }

    @Override
    protected void initSchema( ) {

        InputStream schemaFile = ErrorHandlerRegistrationRecord.class.getClassLoader( ).getResourceAsStream( SCHEMA_ERRORHANDLER_INF_XSD );
        setSchemaValidation( schemaFile );
    }

    class ErrorHandlersVisitor implements NodeVisitor {

        public String[][] isInterestedIn( ) {

            return new String[][] { ERROR_HANDLERS };
        }

        public boolean handleNode( String[] fullPath, Node node ) {

            String className = getAttribute( CLASS_NAME, node );
            String versionFrom = getAttribute( VERSION_FROM, node.getParentNode( ) );
            String versionTo = getAttribute( VERSION_TO, node.getParentNode( ) );
            String containerId = getAttribute( CONTAINER_ID, node.getParentNode( ).getParentNode( ) );

            errorHandlers.add( new ErrorHandlerRecord( containerId, className, versionFrom, versionTo ) );

            return true;
        }
    }

    public static class ErrorHandlerRecord {

        private String className;

        private String versionFrom;

        private String versionTo;

        private String containerId;

        public ErrorHandlerRecord( String containerId, String className, String versionFrom, String versionTo ) {

            this.className = className;
            this.versionFrom = versionFrom;
            this.versionTo = versionTo;
            this.containerId = containerId;
        }

        public String getClassName( ) {

            return className;
        }

        public String getVersionFrom( ) {

            return versionFrom;
        }

        public String getVersionTo( ) {

            return versionTo;
        }

        public String getContainerId( ) {

            return containerId;
        }


        @Override
        public String toString( ) {

            StringBuilder result = new StringBuilder( 9 );

            result.append( "[" ); //$NON-NLS-1$
            result.append( this.containerId );
            result.append( ", " ); //$NON-NLS-1$
            result.append( this.className );
            result.append( ", " ); //$NON-NLS-1$
            result.append( this.versionFrom );
            result.append( ", " ); //$NON-NLS-1$
            result.append( this.versionTo );
            result.append( "]" ); //$NON-NLS-1$

            return result.toString( );
        }

        @Override
        public int hashCode( ) {

            final int prime = 31;
            int result = 1;
            result = prime * result + ( ( className == null ) ? 0 : className.hashCode( ) );
            result = prime * result + ( ( containerId == null ) ? 0 : containerId.hashCode( ) );
            result = prime * result + ( ( versionFrom == null ) ? 0 : versionFrom.hashCode( ) );
            result = prime * result + ( ( versionTo == null ) ? 0 : versionTo.hashCode( ) );
            return result;
        }

        @Override
        public boolean equals( Object obj ) {

            if ( this == obj ) {
                return true;
            }
            if ( obj == null ) {
                return false;
            }
            if ( getClass( ) != obj.getClass( ) ) {
                return false;
            }
            final ErrorHandlerRecord other = (ErrorHandlerRecord) obj;
            if ( className == null ) {
                if ( other.className != null ) {
                    return false;
                }
            } else if ( !className.equals( other.className ) ) {
                return false;
            }
            if ( containerId == null ) {
                if ( other.containerId != null ) {
                    return false;
                }
            } else if ( !containerId.equals( other.containerId ) ) {
                return false;
            }
            if ( versionFrom == null ) {
                if ( other.versionFrom != null ) {
                    return false;
                }
            } else if ( !versionFrom.equals( other.versionFrom ) ) {
                return false;
            }
            if ( versionTo == null ) {
                if ( other.versionTo != null ) {
                    return false;
                }
            } else if ( !versionTo.equals( other.versionTo ) ) {
                return false;
            }
            return true;
        }


    }

    public Set<ErrorHandlerRecord> getErrorHandlers( ) {

        return this.errorHandlers;
    }

}
