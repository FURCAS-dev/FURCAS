package com.sap.mi.gfw.eclipse;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.gfw.util.AbstractTracer;

/**
 * This class inherits from <code>com.sap.mi.gfw.util.AbstractTracer</code>. Use it to add trace output for the plugin
 * <code>com.sap.mi.gfw</code>
 * 
 * @see com.sap.mi.gfw.util.AbstractTracer
 * @see com.tssap.util.trace.TracerI
 */
public class T extends AbstractTracer {

	private static T t = new T(MiLocations.MI_GFW_ECLIPSE);

	/**
	 * instantiate via <code>T.racer()</code>
	 */
	private T(String location) {
		super(location);
	}

	/**
	 * returns an instance of <code>com.sap.mi.gfw.util.AbstractTracer</code>
	 */
	public static T racer() {
		return t;
	}

	@Override
	public boolean info() {
		// useful for testing / code-coverage
		if (com.sap.mi.gfw.util.T.racer().getInfoAlwaysTrue()) {
			return true;
		}
		return super.info();
	}
}