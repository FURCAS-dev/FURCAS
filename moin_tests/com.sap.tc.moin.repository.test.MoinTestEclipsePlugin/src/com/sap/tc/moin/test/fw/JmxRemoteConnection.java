package com.sap.tc.moin.test.fw;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.ListenerNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MBeanServerConnection;
import javax.management.NotCompliantMBeanException;
import javax.management.Notification;
import javax.management.NotificationFilter;
import javax.management.NotificationFilterSupport;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

import com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper;

@SuppressWarnings( "nls" )
public class JmxRemoteConnection {

    private ObjectName objectName;

    private JMXConnector cc;

    private JMXConnectorServer cs;

    private MBeanServer mbs;

    private MBeanServerConnection mbsc;

    private Map<NotificationListener, NotificationListener> wrapperMap = new HashMap<NotificationListener, NotificationListener>( );

    private final Map<NotificationListener, Object> counterMap = new HashMap<NotificationListener, Object>( );

    private final Map<NotificationListener, List<Throwable>> errorMap = new HashMap<NotificationListener, List<Throwable>>( );

    public JmxRemoteConnection( ObjectName objectName ) {

        this.objectName = objectName;
        this.init( );
        if ( objectName.isPattern( ) ) {
            // If the ObjectName contains wildcards, perform a query and select the first ObjectName in the result.
            try {
                Set<ObjectName> queryNames = mbsc.queryNames( objectName, null );
                this.objectName = queryNames.iterator( ).next( );
            } catch ( IOException e ) {
                throw new RuntimeException( e );
            }
        }
    }

    public ObjectName getObjectName( ) {

        return objectName;
    }

    public void reset( ) {

        this.shutdown( );
        this.init( );
    }

    private void init( ) {

        this.wrapperMap.clear( );
        this.counterMap.clear( );
        this.errorMap.clear( );
        mbs = ManagementFactory.getPlatformMBeanServer( );
        try {
            // Make a connector server...
            JMXServiceURL url = new JMXServiceURL( "service:jmx:rmi://" );
            cs = JMXConnectorServerFactory.newJMXConnectorServer( url, null, mbs );
            cs.start( );
            JMXServiceURL addr = cs.getAddress( );

            // Now make a connector client using the server's address
            cc = JMXConnectorFactory.connect( addr );
            mbsc = cc.getMBeanServerConnection( );
        } catch ( Exception e ) {
            throw new RuntimeException( "Error while initializing remote JMX connection for " + this.objectName, e );
        }
    }

    public void shutdown( ) {

        try {
            if ( cc != null ) {
                cc.close( );
            }
            if ( cs != null ) {
                cs.stop( );
            }
        } catch ( IOException e ) {
            throw new RuntimeException( "Error while closing JMX connection: ", e );
        }
    }

    /**
     * Enables notifications for the MBean. The notification counters are not
     * reset!
     */
    public void enableNotifications( ) {

        try {
            this.mbsc.invoke( this.objectName, "startNotifications", new Object[0], new String[0] );
            // implicitly test the startNotifications method
            Boolean wasStarted = (Boolean) this.mbsc.invoke( this.objectName, "notificationsStarted", new Object[0], new String[0] );
            if ( !wasStarted ) {
                throw new AssertionError( "MBean server connection indicates that notifications were not started." );
            }

        } catch ( Exception e ) {
            throw new RuntimeException( "Error while starting notification in " + this.objectName, e );
        }
    }

    /**
     * Disables notifications for the MBean. The notification counters are not
     * reset!
     */
    public void disableNotifications( ) {

        try {
            this.mbsc.invoke( this.objectName, "stopNotifications", new Object[0], new String[0] );
        } catch ( Exception e ) {
            throw new RuntimeException( "Error while starting notification in " + this.objectName, e );
        }
    }

    /**
     * Returns whether notifications are currently enabled for the MBean.
     */
    public boolean notificationsStarted( ) {

        try {
            return (Boolean) this.mbsc.invoke( this.objectName, "notificationsStarted", new Object[0], new String[0] );
        } catch ( Exception e ) {
            throw new RuntimeException( "Error while starting notification in " + this.objectName, e );
        }
    }

    /**
     * Adds a listener who handles the notifications from the MBean.
     * 
     * @param listener
     * @param filter The name of a notification type
     * @param handback An object that is passed to the listener if notified
     * @throws InstanceNotFoundException
     * @throws IOException
     */
    public void addNotificationListener( final NotificationListener listener, String filter, Object handback ) throws InstanceNotFoundException, IOException {

        NotificationListener listenerWrapper = new NotificationListener( ) {

            public void handleNotification( Notification notification, Object handback ) {

                try {
                    listener.handleNotification( notification, handback );
                    synchronized ( counterMap ) {
                        ( (int[]) counterMap.get( this ) )[0]++;
                    }
                } catch ( Throwable e ) {
                    // catch all non assertion errors from asynchronous thread to transfer it to main thread
                    // swallow AssertionErrors
                    synchronized ( errorMap ) {
                        List<Throwable> errors = errorMap.remove( listener );
                        if ( errors == null ) {
                            errors = new ArrayList<Throwable>( 1 );
                        }
                        errors.add( e );
                        errorMap.put( listener, errors );
                    }
                }
            }

        };

        int[] counter = new int[1];
        this.wrapperMap.put( listener, listenerWrapper );
        this.counterMap.put( listenerWrapper, counter );
        this.mbsc.addNotificationListener( this.objectName, listenerWrapper, this.createNotificationFilter( filter ), handback );
    }

    /**
     * If a listener is removed it will not be notified anymore.
     * 
     * @param listener
     * @throws InstanceNotFoundException
     * @throws ListenerNotFoundException
     * @throws IOException
     */
    public void removeNotificationListener( NotificationListener listener ) throws InstanceNotFoundException, ListenerNotFoundException, IOException {

        NotificationListener wrapper = this.wrapperMap.remove( listener );
        this.mbsc.removeNotificationListener( this.objectName, wrapper );
        this.counterMap.remove( wrapper );
    }

    /**
     * Returns the value of an attribute of a MBean. Attributes are all
     * "get"-methods in the JmxAdapter that have a return value but not
     * parameter value.
     * 
     * @param attribute The name of the "get"-method without the "get" (Example:
     * getName() -> "Name")
     * @return
     * @throws AttributeNotFoundException
     * @throws InstanceNotFoundException
     * @throws MBeanException
     * @throws ReflectionException
     * @throws IOException
     */
    public Object getAttribute( String attribute ) throws AttributeNotFoundException, InstanceNotFoundException, MBeanException, ReflectionException, IOException {

        return this.mbsc.getAttribute( this.objectName, attribute );
    }

    /**
     * Invokes a method with parameters of the JmxAdapter.
     * 
     * @param operationName Name of the operation
     * @param params parameter values of the called method
     * @param signature list of types of the method parameters (e.g.
     * java.lang.String)
     * @return
     * @throws InstanceNotFoundException
     * @throws MBeanException
     * @throws ReflectionException
     * @throws IOException
     */
    public Object invoke( String operationName, Object[] params, String[] signature ) throws InstanceNotFoundException, MBeanException, ReflectionException, IOException {

        return this.mbsc.invoke( this.objectName, operationName, params, signature );
    }

    /**
     * Waits for the notifications until expected number of correct
     * notifications have received or time (millis) is up. A correct
     * notification is a notification that throws no AssertionError or
     * Exception.
     * 
     * @param listener
     * @param expected number of notifications expected
     * @param millis maximum time to wait
     * @return Number of notifications that have received when the time is up or
     * expected number is reached
     * @throws ListenerNotFoundException
     */
    public int waitForCorrectNotifications( NotificationListener listener, int expected, long millis ) throws ListenerNotFoundException {

        long time = System.currentTimeMillis( );
        int count = this.getNotificationCount( listener );
        while ( ( System.currentTimeMillis( ) - time < millis ) && ( expected > count ) ) {
            try {
                Thread.sleep( 100 );
            } catch ( InterruptedException e ) {
            }
            checkError( listener );
            count = this.getNotificationCount( listener );
        }
        return count;
    }

    /**
     * Call it to receive all errors and exceptions occurred in the thread
     * handling the notification.
     * 
     * @param listener The notification listener that has thrown the
     * errors/exceptions
     * @return List of Errors and Exception
     */
    public List<Throwable> getAllReceivedErrors( NotificationListener listener ) {

        List<Throwable> result;
        synchronized ( errorMap ) {
            List<Throwable> errors = errorMap.get( listener );
            if ( errors == null ) {
                result = Collections.emptyList( );
            } else {
                result = errors;
            }
        }
        return result;
    }

    /**
     * Creates and returns a typed proxy implementing the given MBean interface
     * class.
     */
    public <T> T newProxy( Class<T> interfaceClass ) {

        try {
            return SpiJmxHelper.newMBeanProxy( mbsc, objectName, interfaceClass );
        } catch ( InstanceNotFoundException e ) {
            throw new RuntimeException( e );
        } catch ( NotCompliantMBeanException e ) {
            throw new RuntimeException( e );
        } catch ( IOException e ) {
            throw new RuntimeException( e );
        } catch ( NoSuchMethodException e ) {
            throw new RuntimeException( e );
        }
    }

    // ###################### PRIVATE ####################

    private NotificationFilter createNotificationFilter( final String notificationType ) {

        if ( notificationType == null ) {
            return null;
        }
        NotificationFilterSupport nfs = new NotificationFilterSupport( );
        nfs.enableType( notificationType );
        return nfs;
    }

    /**
     * Returns the number of how often the notification listener is called. This
     * value is not retrievable any more if the listener is removed with
     * removeNotificationListener().
     * 
     * @return
     */
    private int getNotificationCount( NotificationListener listener ) throws ListenerNotFoundException {

        Object result = null;
        synchronized ( this.counterMap ) {
            result = this.counterMap.get( this.wrapperMap.get( listener ) );
        }
        if ( result == null ) {
            throw new ListenerNotFoundException( );
        } else {
            return ( (int[]) result )[0];
        }
    }

    /**
     * Check if there have been other errors in the NotificationListener than
     * AssertionErrors.
     * 
     * @param listener
     */
    private void checkError( NotificationListener listener ) {

        synchronized ( this.errorMap ) {
            List<Throwable> errors = this.errorMap.get( listener );
            if ( errors != null ) {
                for ( Throwable error : errors ) {
                    if ( !( error instanceof AssertionError ) ) {
                        throw new RuntimeException( "At least one error occurred in JMX notification thread (see cause below): ", error );
                    }
                }
            }
        }
    }
}
