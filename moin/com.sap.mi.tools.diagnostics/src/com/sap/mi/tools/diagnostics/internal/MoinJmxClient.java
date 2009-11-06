package com.sap.mi.tools.diagnostics.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.management.InstanceNotFoundException;
import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.MBeanServerNotification;
import javax.management.MalformedObjectNameException;
import javax.management.Notification;
import javax.management.NotificationListener;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.mbeans.EditorRegistryEntryMBean;
import com.sap.mi.fwk.ui.mbeans.EditorRegistryMBean;
import com.sap.tc.moin.repository.jmx.ConfigurationMBean;
import com.sap.tc.moin.repository.jmx.ConnectionMBean;
import com.sap.tc.moin.repository.jmx.MoinMBean;

/**
 * Client providing JMX-based access to Moin. Currently restricted to localhost
 * instances running on a specified port.
 * 
 * @author d031150 
 * @author d024127
 */
public final class MoinJmxClient {

	/**
	 * Informs about a change in a MBean
	 */
	public interface MBeanChangeListener {
		/**
		 * Informs about a change in the MBean with the given name
		 */
		void mBeanChanged(ObjectName name);
	}

	private static final Logger stracer = Logger.getLogger(MiLocations.MI_DIAGNOSTICS);
	private static final String OBJECT_NAME_TYPE = "type"; //$NON-NLS-1$
	public static final String OBJECT_NAME_NAME = "name"; //$NON-NLS-1$
	public static final String OBJECT_NAME_SESSION = "session"; //$NON-NLS-1$
	public static final String OBJECT_NAME_CONNECTION_ID = "id"; //$NON-NLS-1$
	public static final String OBJECT_NAME_MOIN_ID = "id"; //$NON-NLS-1$
	private static final String OBJECT_NAME_DOMAIN_MOIN = "com.sap.tc.moin"; //$NON-NLS-1$
	private static final String OBJECT_NAME_TYPE_MOINS = OBJECT_NAME_DOMAIN_MOIN + ":type=Moin,*"; //$NON-NLS-1$
	private static final String OBJECT_NAME_TYPE_CFG = OBJECT_NAME_DOMAIN_MOIN + ":type=Configuration"; //$NON-NLS-1$
	private static final String OBJECT_NAME_VALUE_CONNECTION = "Connection"; //$NON-NLS-1$
	private static final String OBJECT_NAME_TYPE_CONNECTIONS = OBJECT_NAME_DOMAIN_MOIN + ":type=Connection,*"; //$NON-NLS-1$
	private static final String OBJECT_NAME_MBEANSERVER = "JMImplementation:type=MBeanServerDelegate"; //$NON-NLS-1$

	private static final String OBJECT_NAME_DOMAIN_MIE = "com.sap.mi.fwk"; //$NON-NLS-1$
	private static final String OBJECT_NAME_TYPE_EDITOR_REGISTRY_ENTRY = OBJECT_NAME_DOMAIN_MIE
			+ ":type=EditorRegistryEntry,*"; //$NON-NLS-1$
	private static final String OBJECT_NAME_TYPE_EDITOR_REGISTRY = OBJECT_NAME_DOMAIN_MIE + ":type=EditorRegistry"; //$NON-NLS-1$

	private final String mPort;
	private final String mHost = "localhost"; //$NON-NLS-1$
	private JMXConnector mConnector;
	private MBeanServerConnection mJmxConnection;
	private MoinNotificationListener mNotificationListener;

    // According to JMX spec this is not necessary, but Moin currently expects it.
	static final String PROPERTY_JMX = "com.sun.management.jmxremote"; //$NON-NLS-1$
	static final String PROPERTY_JMX_PORT = PROPERTY_JMX + ".port"; //$NON-NLS-1$

	public MoinJmxClient(MBeanChangeListener listener) throws IOException {
		String jmxEnabled = System.getProperty(PROPERTY_JMX);
		if (jmxEnabled == null) {
			throw new IOException("No Jmx enabled. Define system property '" + PROPERTY_JMX + "'."); //$NON-NLS-1$ //$NON-NLS-2$
		}

		mPort = System.getProperty(PROPERTY_JMX_PORT);
		if (mPort == null) {
			throw new IOException("No Jmx port sepcified. Define system property '" + PROPERTY_JMX_PORT + "'."); //$NON-NLS-1$ //$NON-NLS-2$
		}

		JMXServiceURL address = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://" + mHost + ":" + mPort + "/jmxrmi"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		if (stracer.isLoggable(Level.FINE)) {
			stracer.log(Level.FINE, "Using JMXServiceURL address: " + address.toString()); //$NON-NLS-1$
		}

		// Create the JMXCconnectorServer
		mConnector = JMXConnectorFactory.connect(address);
		// Obtain a "stub" for the remote MBeanServer
		mJmxConnection = mConnector.getMBeanServerConnection();

		// Note: unfortunately we cannot use MBeanServerNotificationFilter
		// mechanism
		// as this expects exact object names to be registered, i.e. including
		// the connection name,
		// which we don't knwo before. We therefor register without filter and
		// check in our listener.
		if (listener != null) {
			try {
				mNotificationListener = new MoinNotificationListener(listener, mJmxConnection);
				mJmxConnection.addNotificationListener(new ObjectName(OBJECT_NAME_MBEANSERVER), mNotificationListener,
						null, null);
			} catch (InstanceNotFoundException e) {
				stracer.log(Level.SEVERE, e.getMessage(), e);
				throw new IOException(e.getMessage());
			} catch (MalformedObjectNameException e) {
				stracer.log(Level.SEVERE, e.getMessage(), e);
				throw new IOException(e.getMessage());
			}
		}
	}

	public String getHost() {
		return mHost;
	}

	public String getPort() {
		return mPort;
	}

	public void disconnect() {
		if (mConnector != null) {
			try {
				if (mNotificationListener != null) {
					mJmxConnection.removeNotificationListener(new ObjectName(OBJECT_NAME_MBEANSERVER),
							mNotificationListener);
				}
				mConnector.close();
			} catch (Exception e) {
				stracer.log(Level.SEVERE, e.getMessage(), e);
			}
			mConnector = null;
			mJmxConnection = null;
		}
	}

	public EditorRegistryMBean getEditorRegistry() {
		if (mJmxConnection == null)
			return null;
		
		try {
			// The ObjectName of the Moin MBean
			ObjectName beanName = ObjectName.getInstance(OBJECT_NAME_TYPE_EDITOR_REGISTRY);

			// test whether Moin is loaded at all (causes an
			// InstanceNotFoundException if not)
			mJmxConnection.getMBeanInfo(beanName);

			// Obtain proxy for the Moin MBean
			EditorRegistryMBean bean = (EditorRegistryMBean) MBeanServerInvocationHandler.newProxyInstance(
					mJmxConnection, beanName, EditorRegistryMBean.class, false);

			return bean;
		} catch (InstanceNotFoundException e) { // $JL-EXC$
			return null;
		} catch (Exception e) {
			stracer.log(Level.SEVERE, e.getMessage(), e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public Map<ObjectName, MoinMBean> getMoins() {
		if (mJmxConnection == null)
			return null;

		try {
			// The ObjectName of the Moin MBean
			ObjectName moinName = ObjectName.getInstance(OBJECT_NAME_TYPE_MOINS);

			// test whether Moin is loaded at all (causes an
			// InstanceNotFoundException if not)
//			mJmxConnection.getMBeanInfo(moinName);

			// Obtain proxy for the Moin MBean
			Set<ObjectInstance> moinProxies = mJmxConnection.queryMBeans(moinName, null);
			Map<ObjectName, MoinMBean> result = new LinkedHashMap<ObjectName, MoinMBean>(moinProxies.size());
			for (ObjectInstance instance : moinProxies) {
				ObjectName name = instance.getObjectName();
				MoinMBean connProxy = (MoinMBean) MBeanServerInvocationHandler.newProxyInstance(
						mJmxConnection, name, MoinMBean.class, false);
				result.put(name, connProxy);
			}

			return result;
//		} catch (InstanceNotFoundException e) { // $JL-EXC$
//			return Collections.emptyMap();
		} catch (Exception e) {
			stracer.log(Level.SEVERE, e.getMessage(), e);
			return Collections.emptyMap();
		}
	}

	public Map.Entry<ObjectName, ConfigurationMBean> getConfiguration() {
		if (mJmxConnection == null)
			return null;

		try {
			// The ObjectName of the Configuration MBean
			ObjectName moinName = ObjectName.getInstance(OBJECT_NAME_TYPE_CFG);

			// test whether Configuration is loaded at all (causes an
			// InstanceNotFoundException if not)
			mJmxConnection.getMBeanInfo(moinName);

			// Obtain proxy for the Configuration MBean
			ConfigurationMBean cfgProxy = (ConfigurationMBean) MBeanServerInvocationHandler.newProxyInstance(
					mJmxConnection, moinName, ConfigurationMBean.class, false);

			return Collections.singletonMap(moinName, cfgProxy).entrySet().iterator().next();
		} catch (InstanceNotFoundException e) { // $JL-EXC$
			return null;
		} catch (Exception e) {
			stracer.log(Level.SEVERE, e.getMessage(), e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public Map<ObjectName, ConnectionMBean> getConnections() {
		if (mJmxConnection == null)
			return null;

		try {
			Set<ObjectInstance> result = mJmxConnection.queryMBeans(new ObjectName(OBJECT_NAME_TYPE_CONNECTIONS), null);
			Map<ObjectName, ConnectionMBean> connections = new LinkedHashMap<ObjectName, ConnectionMBean>(result.size());
			for (ObjectInstance instance : result) {
				ObjectName name = instance.getObjectName();
				ConnectionMBean connProxy = (ConnectionMBean) MBeanServerInvocationHandler.newProxyInstance(
						mJmxConnection, name, ConnectionMBean.class, false);
				connections.put(name, connProxy);
			}
			return connections;
		} catch (Exception e) {
			stracer.log(Level.SEVERE, e.getMessage(), e);
			return Collections.emptyMap();
		}
	}

	public boolean exists(ObjectName name) {
		if (mJmxConnection == null)
			return false;

		try {
			mJmxConnection.getObjectInstance(name);
			return true;
		} catch (Exception e) { // $JL-EXC$
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public EditorRegistryEntryMBean[] getRegisteredClassBeans() {
		if (mJmxConnection == null)
			return new EditorRegistryEntryMBean[0];

		try {
			ObjectName objName = new ObjectName(OBJECT_NAME_TYPE_EDITOR_REGISTRY_ENTRY);
			Set<ObjectInstance> result = mJmxConnection.queryMBeans(objName, null);
			if (result != null) {
				List<EditorRegistryEntryMBean> beans = new ArrayList<EditorRegistryEntryMBean>(result.size());
				for (ObjectInstance instance : result) {
					EditorRegistryEntryMBean bean = (EditorRegistryEntryMBean) MBeanServerInvocationHandler
							.newProxyInstance(mJmxConnection, instance.getObjectName(), EditorRegistryEntryMBean.class,
									false);
					beans.add(bean);
				}
				return beans.toArray(new EditorRegistryEntryMBean[beans.size()]);
			}
		} catch (Exception e) {
			stracer.log(Level.SEVERE, e.getMessage(), e);
		}
		return new EditorRegistryEntryMBean[0];
	}

	private static final class MoinNotificationListener implements NotificationListener {
		private final MBeanChangeListener mListener;

		MoinNotificationListener(MBeanChangeListener listener, MBeanServerConnection jmxConnection) {
			mListener = listener;
		}

		public void handleNotification(Notification notification, Object handback) {
			stracer.log(Level.FINE, "Received notification: " + notification.toString()); //$NON-NLS-1$
			ObjectName name = ((MBeanServerNotification) notification).getMBeanName();
			if (!MoinJmxClient.isConnectionType(name))
				return;

			// if
			// (notification.getType().equals(MBeanServerNotification.REGISTRATION_NOTIFICATION))
			// {
			// try {
			// mJmxConnection.addNotificationListener(
			// name,
			// new ConnectionCloseNotificationListener(),
			// null,
			// null);
			// } catch (InstanceNotFoundException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// } catch (NullPointerException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// } catch (IOException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// }

			mListener.mBeanChanged(name);
			stracer.log(Level.FINE, "Forwarded notification: " + notification.toString() + " to listener: " //$NON-NLS-1$ //$NON-NLS-2$
					+ mListener.toString());
		}
	}

	// private static final class ConnectionCloseNotificationListener implements
	// NotificationListener {
	// ConnectionCloseNotificationListener() {
	// }
	// public void handleNotification(Notification notification, Object
	// handback) {
	// System.out.println(((ConnectionNotification)
	// notification).getConnectionStackTrace());
	// }
	// }

	private static boolean isConnectionType(ObjectName name) {
		String type = name.getKeyProperty(OBJECT_NAME_TYPE);
		boolean isType = type.startsWith(OBJECT_NAME_VALUE_CONNECTION);
		return isType;
	}

}
