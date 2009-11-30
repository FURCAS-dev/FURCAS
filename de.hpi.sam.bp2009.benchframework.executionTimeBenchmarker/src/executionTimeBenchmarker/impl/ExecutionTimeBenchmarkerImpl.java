/**
 * <copyright>
 * Copyright (c) 2004, 2005, 2006, 2007 void.fm
All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice, this list
  of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice, this
  list of conditions and the following disclaimer in the documentation and/or
  other materials provided with the distribution.

* Neither the name void.fm nor the names of its contributors may be
  used to endorse or promote products derived from this software without specific
  prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
OF THE POSSIBILITY OF SUCH DAMAGE.
 * </copyright>
 *
 * $Id$
 */
package executionTimeBenchmarker.impl;

import java.util.ArrayList;

import de.hpi.sam.bp2009.benchframework.ResultObject;
import de.hpi.sam.bp2009.benchframework.impl.BenchMarkerImpl;

import etm.core.configuration.BasicEtmConfigurator;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;
import executionTimeBenchmarker.ExecutionTimeBenchmarker;
import executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Time Benchmarker</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ExecutionTimeBenchmarkerImpl extends BenchMarkerImpl implements ExecutionTimeBenchmarker {
	
	private EtmMonitor monitor;
	private final EtmMonitor etmMonitor = EtmManager.getEtmMonitor();
	private ArrayList<EtmPoint> measurePoints = new ArrayList<EtmPoint>();
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionTimeBenchmarkerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionTimeBenchmarkerPackage.Literals.EXECUTION_TIME_BENCHMARKER;
	}
	
	private void setup() {
		BasicEtmConfigurator.configure();
		monitor = EtmManager.getEtmMonitor();
		monitor.start();
	}
	
	private void teardown() {
		monitor.stop();
	}
	
	@Override
	public ResultObject getResult() {
		// TODO Auto-generated method stub
		return super.getResult();
	}
	
	@Override
	public void start() {
		setup();
		EtmPoint point = etmMonitor.createPoint("Run: " + measurePoints.size()+1);
		measurePoints.add(0, point);
	}
	
	@Override
	public void end() {
		EtmPoint point = measurePoints.get(0);
		point.collect();
		//create ResultObject
		result = new JETMResultObjectImpl(
						point.getStartTime(),
						point.getEndTime(),
						point.getTransactionTime(),
						point.getTicks());
		teardown();
	}
	

} //ExecutionTimeBenchmarkerImpl
