package com.sap.tc.moin.repository.spi.jmx;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.JMException;
import javax.management.ListenerNotFoundException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.MBeanRegistration;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.NotCompliantMBeanException;
import javax.management.NotificationBroadcaster;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.StandardMBean;

import com.sap.tc.moin.repository.jmx.Description;
import com.sap.tc.moin.repository.jmx.ParameterName;

/**
 * The {@link SpiJmxHelper} simplifies the usage of JMX in MOIN. It offers a set
 * of static operations for registering and unregistering MBeans at the MBean
 * server.
 * 
 * @author D027299
 */
@SuppressWarnings( "unchecked" )
public final class SpiJmxHelper {

    /**
     * Global variable for JMX activation status.
     * <p>
     * Is <code>true</code> if the system parameter
     * <code>com.sun.management.jmxremote</code> is set or the used JDK is
     * version 1.6.0 or above. Otherwise it is <code>false</code>.
     */
    public static final boolean JMX_ENABLED = ( System.getProperty( "com.sun.management.jmxremote" ) != null || System.getProperty( "java.version" ).indexOf( "1.6.0" ) != -1 ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

    /**
     * The prefix used for JMX object names that identifies MOIN MBeans.
     */
    public static final String MOIN_DOMAIN = "com.sap.tc.moin:"; //$NON-NLS-1$

    private static final Map<String, Class<?>> primitiveClasses = new HashMap<String, Class<?>>( 16 );

    private static Map<Class<?>, Map<MBeanAttributeInfo, Method>> attributeMethods = new HashMap<Class<?>, Map<MBeanAttributeInfo, Method>>( );

    private static Map<Class<?>, Map<MBeanOperationInfo, Method>> operationMethods = new HashMap<Class<?>, Map<MBeanOperationInfo, Method>>( );

    private static MBeanServer mBeanServer;

    static {
        Class<?>[] prims = { byte.class, short.class, int.class, long.class, float.class, double.class, char.class, boolean.class };
        for ( Class<?> c : prims ) {
            primitiveClasses.put( c.getName( ), c );
        }
        mBeanServer = ManagementFactory.getPlatformMBeanServer( );
    }

    // Not instantiable.
    private SpiJmxHelper( ) {

    }

    /**
     * Unregisters the MBean with the given object name.
     * 
     * @param objectName The object name of a registered MBean
     * @throws RuntimeException Thrown if no MBean with the given object name
     * was registered or the MBean could not be unregistered.
     */
    public static void unregisterMBean( ObjectName objectName ) {

        if ( mBeanServer.isRegistered( objectName ) ) {
            try {
                mBeanServer.unregisterMBean( objectName );
            } catch ( InstanceNotFoundException e ) {
                throw new RuntimeException( e );
            } catch ( MBeanRegistrationException e ) {
                throw new RuntimeException( e );
            }
        }
    }

    private static class AnnotatedStandardMBean extends StandardMBean implements MBeanRegistration {

        protected Object mbeanImplementation;

        /**
         * Instance where the MBean interface is implemented by another object.
         * 
         * @param <T> Compiler check that <code>mbeanImplementation</code>
         * implements <code>mbeanInterface</code>
         * @param mbeanImplementation The implementation of the MBean
         * implementing the <code>mbeanInterface</code>
         * @param mbeanInterface The interface of the MBean
         * @throws NotCompliantMBeanException If
         * <code>mbeanImplementation</code> is not a JMX compliant MBean
         */
        public <T> AnnotatedStandardMBean( T mbeanImplementation, Class<T> mbeanInterface ) throws NotCompliantMBeanException {

            super( mbeanImplementation, mbeanInterface );
            this.mbeanImplementation = mbeanImplementation;
        }

        @Override
        protected String getDescription( MBeanOperationInfo op ) {

            String descr = op.getDescription( );
            Method m = methodFor( getMBeanInterface( ), op );
            if ( m != null ) {
                Description d = m.getAnnotation( Description.class );
                if ( d != null ) {
                    descr = d.value( );
                }
            }
            return descr;
        }

        @Override
        protected String getDescription( MBeanAttributeInfo attr ) {

            String descr = attr.getDescription( );
            Method m = methodFor( getMBeanInterface( ), attr );
            if ( m != null ) {
                Description d = m.getAnnotation( Description.class );
                if ( d != null ) {
                    descr = d.value( );
                }
            }
            return descr;
        }

        @Override
        protected String getParameterName( MBeanOperationInfo op, MBeanParameterInfo param, int paramNo ) {

            String name = param.getName( );
            Method m = methodFor( getMBeanInterface( ), op );
            if ( m != null ) {
                ParameterName pname = getParameterAnnotation( m, paramNo, ParameterName.class );
                if ( pname != null ) {
                    name = pname.value( );
                }
            }
            return name;
        }

        public void postDeregister( ) {

            if ( mbeanImplementation instanceof MBeanRegistration ) {
                ( (MBeanRegistration) mbeanImplementation ).postDeregister( );
            }
        }

        public void postRegister( Boolean registrationDone ) {

            if ( mbeanImplementation instanceof MBeanRegistration ) {
                ( (MBeanRegistration) mbeanImplementation ).postRegister( registrationDone );
            }
        }

        public void preDeregister( ) throws Exception {

            if ( mbeanImplementation instanceof MBeanRegistration ) {
                ( (MBeanRegistration) mbeanImplementation ).preDeregister( );
            }
        }

        public ObjectName preRegister( MBeanServer server, ObjectName name ) throws Exception {

            if ( mbeanImplementation instanceof MBeanRegistration ) {
                return ( (MBeanRegistration) mbeanImplementation ).preRegister( server, name );
            }
            return null;
        }
    }

    private static final class AnnotatedBroadcastingStandardMBean extends AnnotatedStandardMBean implements NotificationBroadcaster {

        /**
         * A {@link AnnotatedStandardMBean} that allows event notification
         * broadcasting.
         * 
         * @param <T> Compiler check parameter that
         * <code>mbeanImplementation</code> implements
         * <code>mbeanInterface</code>
         * @param mbeanImplementation The implementation of the MBean
         * @param mbeanInterface The interface of the MBean
         * @throws NotCompliantMBeanException Thrown if
         * <code>mbeanImplementation</code> is not a JMX compliant MBean.
         */
        public <T> AnnotatedBroadcastingStandardMBean( T mbeanImplementation, Class<T> mbeanInterface ) throws NotCompliantMBeanException {

            super( mbeanImplementation, mbeanInterface );
        }

        @Override
        protected synchronized void cacheMBeanInfo( MBeanInfo info ) {

            if ( info != null && info.getNotifications( ).length == 0 ) {
                MBeanNotificationInfo[] notificationInfo = ( (NotificationBroadcaster) mbeanImplementation ).getNotificationInfo( );
                super.cacheMBeanInfo( new MBeanInfo( info.getClassName( ), info.getDescription( ), info.getAttributes( ), info.getConstructors( ), info.getOperations( ), notificationInfo ) );
            } else {
                super.cacheMBeanInfo( info );
            }
        }

        public void addNotificationListener( NotificationListener listener, NotificationFilter filter, Object handback ) throws IllegalArgumentException {

            ( (NotificationBroadcaster) mbeanImplementation ).addNotificationListener( listener, filter, handback );
        }

        public MBeanNotificationInfo[] getNotificationInfo( ) {

            return ( (NotificationBroadcaster) mbeanImplementation ).getNotificationInfo( );
        }

        public void removeNotificationListener( NotificationListener listener ) throws ListenerNotFoundException {

            ( (NotificationBroadcaster) mbeanImplementation ).removeNotificationListener( listener );
        }
    }

    /**
     * Makes a stacktrace printable.
     * 
     * @param stacktrace The stacktrace of an exception
     * @return The formatted stack trace as {@link String}
     * @see Exception#getStackTrace()
     */
    public static final String getStackTraceAsString( StackTraceElement[] stacktrace ) {

        StringBuilder result = new StringBuilder( );
        for ( StackTraceElement stackTraceElement : stacktrace ) {
            result.append( stackTraceElement.toString( ) );
            result.append( "\n" ); //$NON-NLS-1$
        }
        return result.toString( );
    }

    /**
     * Prints the output of {@link Throwable#printStackTrace(PrintWriter)} into
     * a {@link String}.
     * 
     * @param t The exception or error to print
     * @return The printed stacktrace as {@link String}
     */
    public static final String getExceptionAsString( Throwable t ) {

        StringWriter stringWriter = new StringWriter( );
        PrintWriter printWriter = new PrintWriter( stringWriter );
        t.printStackTrace( printWriter );
        String result = stringWriter.toString( );
        try {
            stringWriter.close( );
        } catch ( IOException e ) {
            // $JL-EXC$ ignore
        }
        printWriter.close( );
        return result;
    }

    protected static final Method methodFor( Class<?> mbeanInterface, MBeanOperationInfo op ) {

        Map<MBeanOperationInfo, Method> methods = operationMethods.get( mbeanInterface );
        if ( methods == null ) {
            methods = new HashMap<MBeanOperationInfo, Method>( );
            operationMethods.put( mbeanInterface, methods );
        }
        Method result = methods.get( op );
        if ( result == null ) {
            final MBeanParameterInfo[] params = op.getSignature( );
            final String[] paramTypes = new String[params.length];
            for ( int i = 0; i < params.length; i++ ) {
                paramTypes[i] = params[i].getType( );
            }
            result = findMethod( mbeanInterface, op.getName( ), paramTypes );
            methods.put( op, result );
        }
        return result;
    }

    protected static final Method methodFor( Class<?> mbeanInterface, MBeanAttributeInfo attr ) {

        Map<MBeanAttributeInfo, Method> methods = attributeMethods.get( mbeanInterface );
        if ( methods == null ) {
            methods = new HashMap<MBeanAttributeInfo, Method>( );
            attributeMethods.put( mbeanInterface, methods );
        }
        Method result = methods.get( attr );
        if ( result == null ) {
            String methodWithAnnotation;
            if ( attr.isIs( ) ) {
                methodWithAnnotation = "is" + attr.getName( ); //$NON-NLS-1$
            } else {
                methodWithAnnotation = "get" + attr.getName( ); //$NON-NLS-1$
            }
            // Open issue: is it possible to have a writeble non-readable
            // attribute?
            result = findMethod( mbeanInterface, methodWithAnnotation, new String[0] );
            methods.put( attr, result );
        }
        return result;
    }

    protected static final <A extends Annotation> A getParameterAnnotation( Method m, int paramNo, Class<A> annot ) {

        for ( Annotation a : m.getParameterAnnotations( )[paramNo] ) {
            if ( annot.isInstance( a ) ) {
                return annot.cast( a );
            }
        }
        return null;
    }

    private static final Method findMethod( Class<?> mbeanInterface, String name, String... paramTypes ) {

        try {
            final ClassLoader loader = mbeanInterface.getClassLoader( );
            final Class<?>[] paramClasses = new Class[paramTypes.length];
            for ( int i = 0; i < paramTypes.length; i++ ) {
                paramClasses[i] = classForName( paramTypes[i], loader );
            }
            return mbeanInterface.getMethod( name, paramClasses );
        } catch ( RuntimeException e ) {
            // avoid accidentally catching unexpected runtime exceptions
            throw e;
        } catch ( Exception e ) {
            return null;
        }
    }

    private static Class<?> classForName( String name, ClassLoader loader ) throws ClassNotFoundException {

        Class<?> c = primitiveClasses.get( name );
        if ( c == null ) {
            c = Class.forName( name, false, loader );
        }
        return c;
    }

    /**
     * Registers the <code>mbeanImplementation</code> under the given
     * <code>objectName</code> at the MBean server
     * 
     * @param <T> Compiler check that <code>mbeanImplementation</code>
     * implements <code>mbeanInterface</code>
     * @param mbeanImplementation The MBean implementation implementing
     * <code>mbeanInterface</code>
     * @param mbeanInterface The MBean interface
     * @param objectName The object name that identifies the MBean in the server
     */
    public static final <T> void registerStandardMBean( T mbeanImplementation, Class<T> mbeanInterface, ObjectName objectName ) {

        try {
            AnnotatedStandardMBean mbean = new AnnotatedStandardMBean( mbeanImplementation, mbeanInterface );
            mBeanServer.registerMBean( mbean, objectName );
        } catch ( InstanceAlreadyExistsException e ) {
            throw new RuntimeException( e );
        } catch ( MBeanRegistrationException e ) {
            throw new RuntimeException( e );
        } catch ( NotCompliantMBeanException e ) {
            throw new RuntimeException( e );
        }
    }

    /**
     * Registers the <code>mbeanImplementation</code> under the given
     * <code>objectName</code> at the MBean server.
     * <code>mbeanImplementation</code> is able to process JMX event
     * notifications.
     * 
     * @param <T> Compiler check that <code>mbeanImplementation</code>
     * implements <code>mbeanInterface</code>
     * @param mbeanImplementation The MBean implementation implementing
     * <code>mbeanInterface</code>
     * @param mbeanInterface The MBean interface
     * @param objectName The object name that identifies the MBean in the server
     */
    public static final <T> void registerBroadcastingMBean( T mbeanImplementation, Class<T> mbeanInterface, ObjectName objectName ) {

        try {
            AnnotatedBroadcastingStandardMBean mbean = new AnnotatedBroadcastingStandardMBean( mbeanImplementation, mbeanInterface );
            mBeanServer.registerMBean( mbean, objectName );
        } catch ( InstanceAlreadyExistsException e ) {
            throw new RuntimeException( e );
        } catch ( MBeanRegistrationException e ) {
            throw new RuntimeException( e );
        } catch ( NotCompliantMBeanException e ) {
            throw new RuntimeException( e );
        }
    }

    /**
     * Create an MBean proxy, checking that the target MBean exists and
     * implements the attributes and operations defined by the given interface.
     * 
     * @param <T> Compiler check that the returned object implements the given
     * <code>intfClass</code> interface class.
     * @param mbsc the MBean Server in which the proxied MBean is registered.
     * @param name the ObjectName under which the proxied MBean is registered.
     * @param intfClass the MBean interface that the proxy will implement by
     * forwarding its methods to the proxied MBean.
     * @return The newly-created proxy.
     * @throws IOException if there is a communication problem when connecting
     * to the {@code MBeanServerConnection}.
     * @throws InstanceNotFoundException if there is no MBean registered under
     * the given {@code name}.
     * @throws NotCompliantMBeanException if {@code intfClass} is not a valid
     * MBean interface.
     * @throws NoSuchMethodException if a method in {@code intfClass} does not
     * correspond to an attribute or operation in the proxied MBean.
     */
    public static <T> T newMBeanProxy( MBeanServerConnection mbsc, ObjectName name, Class<T> intfClass ) throws IOException, InstanceNotFoundException, NotCompliantMBeanException, NoSuchMethodException {

        // Get the MBeanInfo, or throw InstanceNotFoundException
        final MBeanInfo mbeanInfo;
        try {
            mbeanInfo = mbsc.getMBeanInfo( name );
        } catch ( InstanceNotFoundException e ) {
            throw e;
        } catch ( JMException e ) {
            // IntrospectionException or ReflectionException:
            // very improbable in practice so just pretend the MBean wasn't there
            // but keep the real exception in the exception chain
            final String msg = "Exception getting MBeanInfo for " + name; //$NON-NLS-1$
            InstanceNotFoundException infe = new InstanceNotFoundException( msg );
            infe.initCause( e );
            throw infe;
        }
        // Construct the MBeanInfo that we would expect from a Standard MBean
        // implementing intfClass.  We need a non-null implementation of intfClass
        // so we create a proxy that will never be invoked.
        final T impl = intfClass.cast( Proxy.newProxyInstance( intfClass.getClassLoader( ), new Class<?>[] { intfClass }, nullInvocationHandler ) );
        final StandardMBean mbean = new StandardMBean( impl, intfClass );
        final MBeanInfo proxyInfo = mbean.getMBeanInfo( );

        checkMBeanInfos( intfClass.getClassLoader( ), proxyInfo, mbeanInfo );
        return intfClass.cast( MBeanServerInvocationHandler.newProxyInstance( mbsc, name, intfClass, false ) );
    }

    private static final InvocationHandler nullInvocationHandler = new InvocationHandler( ) {

        public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {

            return null;
        }
    };

    private static boolean compatibleAttributes( ClassLoader loader, MBeanAttributeInfo proxyAttrInfo, MBeanAttributeInfo mbeanAttrInfo ) {

        if ( !proxyAttrInfo.getName( ).equals( mbeanAttrInfo.getName( ) ) ) {
            return false;
        }
        if ( !proxyAttrInfo.getType( ).equals( mbeanAttrInfo.getType( ) ) ) {
            if ( proxyAttrInfo.isWritable( ) ) {
                return false; // type must be identical
            }
            if ( !isAssignable( loader, proxyAttrInfo.getType( ), mbeanAttrInfo.getType( ) ) ) {
                return false;
            }
        }
        if ( proxyAttrInfo.isReadable( ) && !mbeanAttrInfo.isReadable( ) ) {
            return false;
        }
        if ( proxyAttrInfo.isWritable( ) && !mbeanAttrInfo.isWritable( ) ) {
            return false;
        }
        return true;
    }

    private static boolean isAssignable( ClassLoader loader, String toClassName, String fromClassName ) {

        if ( toClassName.equals( fromClassName ) ) {
            return true;
        }
        try {
            Class<?> toClass = Class.forName( toClassName, false, loader );
            Class<?> fromClass = Class.forName( fromClassName, false, loader );
            return toClass.isAssignableFrom( fromClass );
        } catch ( ClassNotFoundException e ) {
            // Could not load one of the two classes so consider not assignable
            // In real code we might like to log the exception
            return false;
        }
    }

    private static boolean compatibleOperations( ClassLoader loader, MBeanOperationInfo proxyOpInfo, MBeanOperationInfo mbeanOpInfo ) {

        if ( !proxyOpInfo.getName( ).equals( mbeanOpInfo.getName( ) ) || !isAssignable( loader, proxyOpInfo.getReturnType( ), mbeanOpInfo.getReturnType( ) ) ) {
            return false;
        }
        MBeanParameterInfo[] proxyParams = proxyOpInfo.getSignature( );
        MBeanParameterInfo[] mbeanParams = mbeanOpInfo.getSignature( );
        if ( proxyParams.length != mbeanParams.length ) {
            return false;
        }
        for ( int i = 0; i < proxyParams.length; i++ ) {
            if ( !proxyParams[i].getType( ).equals( mbeanParams[i].getType( ) ) ) {
                return false;
            }
        }
        return true;
    }

    private static void checkMBeanInfos( ClassLoader loader, MBeanInfo proxyInfo, MBeanInfo mbeanInfo ) throws NoSuchMethodException {

        // Check that every attribute accessible through the proxy is present in the MBean.
        MBeanAttributeInfo[] mais = mbeanInfo.getAttributes( );
        attrcheck: for ( MBeanAttributeInfo pai : proxyInfo.getAttributes( ) ) {
            for ( MBeanAttributeInfo mai : mais ) {
                if ( compatibleAttributes( loader, pai, mai ) ) {
                    continue attrcheck;
                }
            }
            final String msg = "Accessing attribute " + pai.getName( ) + " would fail"; //$NON-NLS-1$ //$NON-NLS-2$
            throw new NoSuchMethodException( msg );
        }
        // Check that every operation accessible through the proxy is present in the MBean.
        MBeanOperationInfo[] mois = mbeanInfo.getOperations( );
        opcheck: for ( MBeanOperationInfo poi : proxyInfo.getOperations( ) ) {
            for ( MBeanOperationInfo moi : mois ) {
                if ( compatibleOperations( loader, poi, moi ) ) {
                    continue opcheck;
                }
            }
            final String msg = "Accessing operation " + poi.getName( ) + " would fail"; //$NON-NLS-1$ //$NON-NLS-2$
            throw new NoSuchMethodException( msg );
        }
    }
}
