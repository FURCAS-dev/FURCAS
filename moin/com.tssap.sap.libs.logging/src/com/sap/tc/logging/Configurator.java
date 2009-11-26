package com.sap.tc.logging;

/**
 * Title:        Logging
 * Description:  Logging API
 * Copyright:    Copyright (c) 2001
 * Company:      SAPMarkets, Inc.
 *               Palo Alto, California, 94303, U.S.A.
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAPMarkets Inc. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAPMarkets.
 * @version      $Id:$
 */

import java.util.*;
import java.text.*;
import java.io.*;

/**
 * Configures the Logging API according to its settings. The configuration is
 * done on demand but it is possible to instruct the configurator to redo it
 * with a specific periodicity.
 */
public abstract class Configurator {

	//================================================ declaration > ====
	private ClassLoader classLoader;

	private int periodicity = 0,
							cnt;

	private Exception lastExc = null;

	private static long MIN_MILLIS = 60 * 1000;
	
	private static HashSet   periodicities = new HashSet();
	private static Timer     timer         = null;
	private static TimerTask watcher       = null;
	
	//==== < declaration ============================ constructors > ====

 	protected Configurator() {
    this(Thread.currentThread().getContextClassLoader());
  }

  protected Configurator(ClassLoader classLoader) {
    if (classLoader != null) {
      this.classLoader = classLoader;
    } else {
      this.classLoader = Thread.currentThread().getContextClassLoader();
    }
  }

	//==== < constructors =============================== abstarct > ====
	
	/**
	  * Configures tracing and logging according to the settings of the
	  * configurator.
	  */
	 public abstract void configure();
	
	//==== < abstract ===================================== public > ====

  /**
   * Gets the class loader that is responsible for loading custom classes in
   * this configurator.
   * @return Class loader used for loading custom classes
   * @see    #setClassLoader(java.lang.ClassLoader)
   */
  public ClassLoader getClassLoader() {
    return classLoader;
  }

  /**
   * Sets the class loader that is responsible for loading custom classes in
   * this configurator. Custom classes are explicit implementations of Logging
   * API interfaces or classes provided in the application. A typical example is
   * a class implementing the interface {@link Filter}.
   * @param  classLoader Class loader used for loading custom classes
   * @see    #getClassLoader()
   */
  public void setClassLoader(ClassLoader classLoader) {
    if (classLoader != null) {
      this.classLoader = classLoader;
    } else {
      this.classLoader = Thread.currentThread().getContextClassLoader();
    }
  }

  /**
   * Gets the periodicity of this configurator in minutes. A periodicity of
   * <code>0</code> means that the configurator is not called automatically.
   * @return Periodicity of configurator in minutes
   */
  public int getPeriodicity() {
    return periodicity;
  }

  /**
   * Sets the periodicity of this configurator in minutes. This means that
   * {@link #configure()} will be automatically called every <code>mins</code>.
   * Setting the periodicity to <code>0</code> turns off that automatic call.
   * @param  mins Periodicity of configurator in minutes
   */
  public synchronized void setPeriodicity(int mins) {
    periodicity = mins;
    synchronized (Configurator.class) {
      if (periodicity > 0) {
        periodicities.add(this);
        cnt = periodicity;
      } else {
        periodicities.remove(this);
      }
      if (periodicities.size() > 0) {
        if (timer == null) {
          timer = new Timer();
          watcher = new TimerTask() {
                      public void run() {
                        synchronized (Configurator.class) {
                          Iterator iter = periodicities.iterator();

                          while (iter.hasNext()) {
                            ((Configurator) iter.next()).minutePassed();
                          }
                        }
                      }
                    };
          timer.schedule(watcher,
                         0,
                         MIN_MILLIS);
        }
      } else {
        if (timer != null) {
          timer.cancel();
          timer = null;
          watcher.cancel();
          watcher = null;
        }
      }
    }
  }

  /**
   * Fetches the last exception thrown
   * @return Last exception thrown
   * @see    #throwException()
   */
  public Exception getException() {
    return lastExc;
  }

  /**
   * Rethrows the last exception thrown.
   * This method is useful if an exception is supposed to be dealt with
   * according to a hierarchy of handlers already declared in a context.
   * @throws Exception Last exception thrown
   * @see    #getException()
   */
  public void throwException()
                            throws Exception {
    if (lastExc != null) {
      throw lastExc;
    }
  }

	//==== < public ==================================== protected > ====

  /**
   * Resets exception.
   */
  protected void resetException() {
    lastExc = null;
  }

  /**
   * Handles exception.
   * @param  exc Exception thrown
   */
  protected void handleException(Exception exc) {
    lastExc = exc;
  }
  
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====

	private synchronized void minutePassed() {
		if (--cnt == 0) {
			configure();
		 	cnt = periodicity;
	  }
	}

	//==== < private ================================== deprecated > ====

}