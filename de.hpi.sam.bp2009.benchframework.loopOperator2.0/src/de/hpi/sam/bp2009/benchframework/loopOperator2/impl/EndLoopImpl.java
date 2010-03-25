/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.loopOperator2.impl;

import java.util.HashMap;
import java.util.Map.Entry;

import de.hpi.sam.bp2009.benchframework.BenchframeworkFactory;
import de.hpi.sam.bp2009.benchframework.EndOperator;
import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.StartOperator;
import de.hpi.sam.bp2009.benchframework.Status;
import de.hpi.sam.bp2009.benchframework.impl.EndOperatorImpl;

import de.hpi.sam.bp2009.benchframework.loopOperator2.EndLoop;
import de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOperator2Package;
import de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOption;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>End Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class EndLoopImpl extends EndOperatorImpl implements EndLoop {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EndLoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LoopOperator2Package.Literals.END_LOOP;
	}

	@Override
	public void execute() {
		// Start with Operator duplication
		Integer rep= ((LoopOption)getOption()).getRepetitions();
		if(rep<=0) {
			setResult(BenchframeworkFactory.eINSTANCE.createResultObject());
			getResult().setStatus(Status.SUCCESSFUL);
			getResult().setMessage("No more repetitions left");
			return;}
		((LoopOption)getOption()).setRepetitions(rep-1);
		EList<Operator> allOperators = getTestRun().getOperators();
		int start	= allOperators.indexOf(getStartOperator());
		int end		= allOperators.indexOf(this);
		HashMap<StartOperator, Integer> offsetMap= new HashMap<StartOperator, Integer>();
		int relativIndex=1;
		for(int index=start;index<=end;index++){
				Operator cur = allOperators.get(index);

				Operator duplicate= (Operator)cur.eClass().getEPackage().getEFactoryInstance().create(cur.eClass());
				if(cur instanceof StartOperator){
					offsetMap.put((StartOperator) duplicate, allOperators.indexOf(((StartOperator) cur).getEndOperator())-index);
				}
				try{
					duplicate.setOption(cur.getOption().clone());
				}catch (Exception e) {
					e.printStackTrace();
					
				}
				if(cur.getName()!=null)
					duplicate.setName(cur.getName()+" rep:"+rep);
				allOperators.add(end+relativIndex++, duplicate);
		}
		for(Entry<StartOperator, Integer> entry:offsetMap.entrySet()){
			Operator assumedEndPoint=allOperators.get(allOperators.indexOf(entry.getKey())+entry.getValue());
			assert(assumedEndPoint instanceof EndOperator);
			((EndOperator)assumedEndPoint).setStartOperator(entry.getKey());
		}
		/*
		 * Delete Repetitions in OptionObject to enable nested Loops
		 */
		((LoopOption)getOption()).setRepetitions(0);
		setResult(BenchframeworkFactory.eINSTANCE.createResultObject());
		getResult().setStatus(Status.SUCCESSFUL);
		getResult().setMessage("Repeated once repetitions left:" + (rep-1));
		
	}

} //EndLoopImpl
