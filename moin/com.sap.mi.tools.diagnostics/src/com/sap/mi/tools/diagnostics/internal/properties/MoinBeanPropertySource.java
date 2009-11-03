package com.sap.mi.tools.diagnostics.internal.properties;

import java.io.IOException;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource2;
import org.eclipse.ui.views.properties.PropertyDescriptor;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.tools.diagnostics.internal.MoinJmxClient;
import com.sap.mi.tools.diagnostics.internal.messages.DiagnosticsMessages;
import com.sap.tc.moin.repository.jmx.MoinMBean;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * Source for the "Moin" properties
 * 
 * @author d031150
 */
public final class MoinBeanPropertySource implements IPropertySource2 {

	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_DIAGNOSTICS);

	static final String PROPERTY_STARTEDAT = "startedAt"; //$NON-NLS-1$
	static final String PROPERTY_STARTEDAT_LABEL = DiagnosticsMessages.MoinBeanPropertySource_startedAt_label;
	static final String PROPERTY_UPTIME = "uptime"; //$NON-NLS-1$
	static final String PROPERTY_UPTIME_LABEL = DiagnosticsMessages.MoinBeanPropertySource_uptime_label;
	static final String PROPERTY_HOST = "Host"; //$NON-NLS-1$
	static final String PROPERTY_HOST_LABEL = DiagnosticsMessages.MoinBeanPropertySource_host_label;
	static final String PROPERTY_VERSION = "version"; //$NON-NLS-1$
	static final String PROPERTY_VERSION_LABEL = DiagnosticsMessages.MoinBeanPropertySource_version_label;

	private final MoinMBean mMoin;
	private final MoinJmxClient mClient;

	public MoinBeanPropertySource(MoinMBean moin, MoinJmxClient client) {
		mMoin = moin;
		mClient = client;
	}

	public Object getEditableValue() {
		return this;
	}

	public IPropertyDescriptor[] getPropertyDescriptors() {
		PropertyDescriptor[] descs = new PropertyDescriptor[4];
		descs[0] = new MoinPropertyDescriptor(PROPERTY_STARTEDAT, PROPERTY_STARTEDAT_LABEL);
		descs[1] = new MoinPropertyDescriptor(PROPERTY_UPTIME, PROPERTY_UPTIME_LABEL);
		descs[2] = new MoinPropertyDescriptor(PROPERTY_HOST, PROPERTY_HOST_LABEL);
		descs[3] = new MoinPropertyDescriptor(PROPERTY_VERSION, PROPERTY_VERSION_LABEL);
		return descs;
	}

	public Object getPropertyValue(Object id) {
		try {
			if (PROPERTY_STARTEDAT.equals(id)) {
				String startedAt = mMoin.getStartedAt();
				return startedAt;
			} else if (PROPERTY_UPTIME.equals(id)) {
				String uptime = mMoin.getUptime();
				return uptime;
			} else if (PROPERTY_HOST.equals(id)) {
				String host = mClient.getHost();
				String port = mClient.getPort();
				return host + ":" + port; //$NON-NLS-1$
			} else if (PROPERTY_VERSION.equals(id)) {
				return new MoinVersionPropertySource(mMoin);
			}
		} catch (IOException e) {
			sTracer.error(e.getMessage(), e);
		} catch (RuntimeException e) { // $JL-EXC$
			// bad response
			return null;
		}
		return null;
	}

	public boolean isPropertyResettable(Object id) {
		return false;
	}

	public boolean isPropertySet(Object id) {
		return true;
	}

	public void resetPropertyValue(Object id) {
	}

	public void setPropertyValue(Object id, Object value) {
	}

}
