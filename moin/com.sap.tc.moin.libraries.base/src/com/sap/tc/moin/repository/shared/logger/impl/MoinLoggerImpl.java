package com.sap.tc.moin.repository.shared.logger.impl;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import com.sap.tc.logging.Category;
import com.sap.tc.logging.Location;
import com.sap.tc.logging.LogRecord;
import com.sap.tc.moin.repository.exception.MoinExternalizedString;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.logger.TraceContext;

/**
 * The Logger implementation
 */
public class MoinLoggerImpl implements MoinLogger {

    private static final String LINEBREAK = "\n"; //$NON-NLS-1$

    private final static String ASSERT_NUMPARS = "Number of message parameters doesn't match number of arguments"; //$NON-NLS-1$

    private final static String ASSERT_NOEX = "Exceptions can not be used as message parameter"; //$NON-NLS-1$


    private Category log;

    private Location trace;

    private StringBuffer subLocationName;

    private StringBuffer msgPrefix;

    /**
     * @param category
     * @param location
     * @param subLocation
     */
    public MoinLoggerImpl( Category category, Location location, StringBuffer subLocation ) {

        this.log = category;
        this.trace = location;

        this.subLocationName = subLocation;
        this.msgPrefix = new StringBuffer( "[MOIN: " + this.subLocationName + "]" ); //$NON-NLS-1$//$NON-NLS-2$
    }


    public void logAndTrace( MoinSeverity severity, MoinLocalizedString messageID, Object... args ) {

        if ( this.log.beLogged( severity.severity( ) ) ) {
            logAndTraceInternal( severity, messageID, args, null, null );
        }
    }

    public void logAndTrace( Throwable throwable, MoinSeverity severity, MoinLocalizedString message, Object... args ) {

        if ( this.log.beLogged( severity.severity( ) ) ) {
            logAndTraceInternal( severity, message, args, null, throwable );
        }
    }


    public void logAndTrace( Throwable throwable, TraceContext context, MoinSeverity severity, MoinLocalizedString messageID, Object... args ) {

        if ( this.log.beLogged( severity.severity( ) ) ) {
            logAndTraceInternal( severity, messageID, args, new StringBuffer( context.getMessage( ) ), throwable );
        }
    }

    public void logAndTrace( Throwable throwable, Object context, MoinSeverity severity, MoinLocalizedString message, Object... args ) {

        if ( this.log.beLogged( severity.severity( ) ) ) {
            logAndTraceInternal( severity, message, args, getObjectContext( context ), throwable );
        }
    }

    private void logAndTraceInternal( MoinSeverity severity, MoinLocalizedString messageID, Object[] args, StringBuffer msgContext, Throwable throwable ) {

        LogRecord record = null;

        String pattern = messageID.getLocalizedMessage( Locale.ENGLISH );
        assert ( parameterCountOk( pattern, args ) ) : ASSERT_NUMPARS;
        assert ( parameterNoExceptions( args ) ) : ASSERT_NOEX;

        if ( throwable == null ) {
            if ( msgContext == null ) {
                record = this.log.logT( severity.severity( ), this.trace, this.msgPrefix + pattern, args );
            } else {
                record = this.log.logT( severity.severity( ), this.trace, this.msgPrefix + pattern + LINEBREAK + msgContext, args );
            }
        } else {
            if ( msgContext == null ) {
                record = this.log.logThrowableT( severity.severity( ), this.trace, this.msgPrefix + pattern, args, throwable );
                if ( MoinLoggerFactory.throwRuntimeException ) {
                    if ( throwable instanceof RuntimeException ) {
                        throw (RuntimeException) throwable;
                    }
                    if ( severity == MoinSeverity.FATAL || severity == MoinSeverity.ERROR ) {
                        throw new RuntimeException( this.msgPrefix + pattern, throwable );
                    }
                }
            } else {
                record = this.log.logThrowableT( severity.severity( ), this.trace, this.msgPrefix + pattern + LINEBREAK + msgContext, args, throwable );
                if ( MoinLoggerFactory.throwRuntimeException ) {
                    if ( throwable instanceof RuntimeException ) {
                        throw (RuntimeException) throwable;
                    }
                    if ( severity == MoinSeverity.FATAL || severity == MoinSeverity.ERROR ) {
                        throw new RuntimeException( this.msgPrefix + pattern + LINEBREAK + msgContext, throwable );
                    }
                }
            }
        }
        if ( JMX_ENABLED && MoinLoggerFactory.jmxNotificationsEnabled ) {
            MoinLoggerFactory.logged( record, Thread.currentThread( ).getStackTrace( ) );
        }
    }


    private synchronized StringBuffer getObjectContext( Object currObject ) {

        Class<? extends Object> currClass = currObject.getClass( );

        return inspectDeclaredFields( currClass, currObject );
    }

    private StringBuffer inspectDeclaredFields( Class<? extends Object> currClass, Object origObject ) {

        Field[] declaredFields = currClass.getDeclaredFields( );
        StringBuffer msg = new StringBuffer( );

        for ( int i = 0; i < declaredFields.length; i++ ) {
            if ( ( Modifier.STATIC & declaredFields[i].getModifiers( ) ) != 0 ) {
                msg.append( inspectStrings( declaredFields[i], origObject ) );
            }

            if ( declaredFields[i].getName( ).startsWith( "this$" ) ) { //$NON-NLS-1$
                // ignore this pointer for inner classes - check this functionality
                continue;
            }

            if ( !declaredFields[i].getType( ).isPrimitive( ) ) {
                msg.append( inspectStrings( declaredFields[i], origObject ) );
            }
        }
        return msg;
    }

    private StringBuffer inspectStrings( Object currObject, Object origObject ) {

        if ( currObject != null ) {
            Class<? extends Object> currClass = currObject.getClass( );

            if ( currObject instanceof Field ) {
                try {
                    if ( ( (Field) currObject ).isAccessible( ) ) {
                        this.inspectStrings( ( (Field) currObject ).get( origObject ), origObject );
                    } else {
                        // JLin does not allow us to use setAccessible
                    }
                } catch ( Exception e ) {
                    e.printStackTrace( System.out );
                }

            } else if ( currObject instanceof String ) {
                return new StringBuffer( currClass.getName( ) + ": " + currObject.toString( ) + LINEBREAK ); //$NON-NLS-1$
            }
        }
        return null;
    }


    public void trace( MoinSeverity severity, MoinExternalizedString message, Object... args ) {

        this.trace( severity, message.format( ), args );
    }

    public void trace( Throwable exception, MoinSeverity severity, MoinExternalizedString message, Object... args ) {

        this.traceInternal( severity, message.format( ), args, null, exception );
    }

    public void trace( MoinLocalizedBaseException exception, MoinSeverity severity ) {

        this.traceInternal( severity, exception.getMessage( ), null, null, exception );
    }

    public void trace( MoinLocalizedBaseRuntimeException exception, MoinSeverity severity ) {

        this.traceInternal( severity, exception.getMessage( ), null, null, exception );
    }

    public void trace( Throwable throwable, MoinSeverity severity, String message, Object... args ) {

        if ( this.trace.beLogged( severity.severity( ) ) ) {
            traceInternal( severity, message, args, null, throwable );
        }
    }

    public void trace( Throwable throwable, TraceContext context, MoinSeverity severity, MoinExternalizedString message, Object... args ) {

        if ( this.trace.beLogged( severity.severity( ) ) ) {
            traceInternal( severity, message.format( ), args, new StringBuffer( context.getMessage( ) ), throwable );
        }
    }

    public void trace( Throwable throwable, Object context, MoinSeverity severity, MoinExternalizedString message, Object... args ) {

        if ( this.trace.beLogged( severity.severity( ) ) ) {
            traceInternal( severity, message.format( ), args, getObjectContext( context ), throwable );
        }
    }

    public void trace( MoinSeverity severity, String message, Object... args ) {

        if ( this.trace.beLogged( severity.severity( ) ) ) {
            traceInternal( severity, message, args, null, null );
        }
    }

    private void traceInternal( MoinSeverity severity, String message, Object[] args, StringBuffer msgContext, Throwable throwable ) {

        LogRecord record = null;

        assert ( parameterCountOk( message, args ) ) : ASSERT_NUMPARS;
        assert ( parameterNoExceptions( args ) ) : ASSERT_NOEX;


        if ( throwable == null ) {
            if ( msgContext == null ) {
                record = this.trace.logT( severity.severity( ), this.msgPrefix + message, args );
            } else {
                record = this.trace.logT( severity.severity( ), this.msgPrefix + message + LINEBREAK + msgContext, args );
            }
        } else {
            if ( msgContext == null ) {
                record = this.trace.traceThrowableT( severity.severity( ), this.msgPrefix + message, args, throwable );
                if ( MoinLoggerFactory.throwRuntimeException ) {
                    if ( throwable instanceof RuntimeException ) {
                        throw (RuntimeException) throwable;
                    }
                    if ( severity == MoinSeverity.FATAL || severity == MoinSeverity.ERROR ) {
                        throw new RuntimeException( this.msgPrefix + message, throwable );
                    }
                }
            } else {
                record = this.trace.traceThrowableT( severity.severity( ), this.msgPrefix + message + LINEBREAK + msgContext, args, throwable );
                if ( MoinLoggerFactory.throwRuntimeException ) {
                    if ( throwable instanceof RuntimeException ) {
                        throw (RuntimeException) throwable;
                    }
                    if ( severity == MoinSeverity.FATAL || severity == MoinSeverity.ERROR ) {
                        throw new RuntimeException( this.msgPrefix + message + LINEBREAK + msgContext, throwable );
                    }
                }
            }
        }
        if ( JMX_ENABLED && MoinLoggerFactory.jmxNotificationsEnabled ) {
            MoinLoggerFactory.logged( record, Thread.currentThread( ).getStackTrace( ) );
        }
    }

    public boolean isLoggedOrTraced( MoinSeverity severity ) {

        return this.log.beLogged( severity.severity( ) );
    }

    public boolean isTraced( MoinSeverity severity ) {

        return this.trace.beLogged( severity.severity( ) );
    }


    public void traceWithStack( MoinSeverity severity, String message, Object... args ) {

        if ( this.trace.beLogged( severity.severity( ) ) ) {
            StackTraceElement[] actStack = Thread.currentThread( ).getStackTrace( );
            StringBuilder extMsg = new StringBuilder( message );
            extMsg.append( "\nStack Dump of current Thread:" ); //$NON-NLS-1$
            for ( int i = 0; i < actStack.length; i++ ) {
                extMsg.append( "\n\tat " + actStack[i] ); //$NON-NLS-1$
            }
            this.trace( severity, extMsg.toString( ), args );
        }
    }

    public void traceWithStack( MoinSeverity severity, MoinExternalizedString message, Object... args ) {

        traceWithStack( severity, message.toString( ), args );
    }

    private boolean parameterCountOk( String pattern, Object... args ) {

        int count = 0;
        int lastIndex = 0;
        int lastLeftIndex = 0;
        int index = pattern.indexOf( '{', lastLeftIndex );
        int arglength = 0;
        if ( args != null ) {
            arglength = args.length;
        }

        Set<Integer> intSet = new HashSet<Integer>( );
        // there might be {} that are not intended for parameter replacement (do not have an Integer in between)

        while ( index >= 0 ) {
            int rightIndex = pattern.indexOf( '}', index );
            String inbetween;
            try {
                inbetween = pattern.substring( index + 1, rightIndex );
                Integer parIndex = new Integer( inbetween );
                if ( intSet.add( parIndex ) ) {
                    count++;
                }
            } catch ( Exception e ) {
                // $JL-EXC$ we just want to check the inbetween
            }
            lastLeftIndex = index + 1;
            index = pattern.indexOf( '{', lastLeftIndex );
        }

        return count == arglength;
    }

    private boolean parameterNoExceptions( Object... args ) {

        if ( args != null ) {

            for ( Object arg : args ) {
                if ( arg instanceof Throwable ) {
                    return false;
                }
            }
        }
        return true;
    }


    public void trace( MoinSeverity sev, String message, Throwable e ) {

        traceInternal( sev, message, new Object[0], null, e );

    }
}
