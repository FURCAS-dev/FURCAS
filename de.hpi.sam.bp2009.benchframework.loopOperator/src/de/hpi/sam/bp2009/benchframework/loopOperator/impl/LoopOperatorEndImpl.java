/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.loopOperator.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import de.hpi.sam.bp2009.benchframework.BenchframeworkFactory;
import de.hpi.sam.bp2009.benchframework.EndOperator;
import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.StartAndEndOperatorOptionObject;
import de.hpi.sam.bp2009.benchframework.StartOperator;
import de.hpi.sam.bp2009.benchframework.Status;
import de.hpi.sam.bp2009.benchframework.impl.EndOperatorImpl;
import de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorEnd;
import de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorFactory;
import de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorOptionObject;
import de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class LoopOperatorEndImpl extends EndOperatorImpl implements LoopOperatorEnd {
	
	private static final String NAME = "Loop Operator Endpoint";
	private static final String DESCTRIPTION ="Defines the end of a loop.";
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LoopOperatorEndImpl() {
		super();
		setName(NAME);
		setDescription(DESCTRIPTION);
		setOption(LoopOperatorFactory.eINSTANCE.createLoopOperatorOptionObject());
		((LoopOperatorOptionObject)getOption()).setOperator(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LoopOperatorPackage.Literals.LOOP_OPERATOR_END;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Execute the EndOperator. The EndOperator will duplicate the loop body between its corresponding StartOperator and itself.
	 * Links between other Start- and EndOperators will be updated accordingly.
	 * It is assumed that each EndPoint is placed after its corresponding StartPoint and that all Start- and EndPoints are mixed correctly
	 * (Start1 Start2 End1 End2 would be invalid, Start1 Start2 End2 End1 is valid).
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void execute() {
		EList<Operator> operatorList = getTestRun().getOperators();
		int startIndex = operatorList.indexOf(((LoopOperatorOptionObject)option).getOtherEnd());
		int endIndex = operatorList.indexOf(this);

		LoopOperatorOptionObject opt=((LoopOperatorOptionObject)getOption());
		int loops = opt.getLoopCount();
		while (opt.getLoopCount() > 0){
			//prevent Index out of bounds exception when endpoint is last element in list
			if (endIndex == operatorList.size() - 1)
				operatorList.addAll(extractLoopBodyList(operatorList, startIndex, endIndex));
			else
				operatorList.addAll(endIndex+1, extractLoopBodyList(operatorList, startIndex, endIndex));
			opt.setLoopCount(opt.getLoopCount() -1);
		}		
		setResult(BenchframeworkFactory.eINSTANCE.createResultObject());
		getResult().setStatus(Status.SUCCESSFUL);
		getResult().setMessage("additionally registered "+ loops + " * " + (endIndex-1-startIndex) + " operators");

	}

	/**
	 * This method duplicates the given part of the operatorList between startIndex and endIndex - 1 and places it at endIndex + 1.
	 * It is assumed that there is a corresponding Start- or EndPoint for each Start- and EndPoint in the loopBody.
	 * @param operatorList
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	private BasicEList<Operator> extractLoopBodyList(EList<Operator> operatorList, int startIndex, int endIndex) {
		List<Operator> loopBody = operatorList.subList(startIndex + 1, endIndex);
		BasicEList<Operator> siblingList = new BasicEList<Operator>();
		Map<StartOperator, Integer> offsetMap = new HashMap<StartOperator, Integer>();
		for (Operator op : loopBody){
			Operator sibling = (Operator)op.eClass().getEPackage().getEFactoryInstance().create(op.eClass());
			try {
				sibling.setOption((op.getOption()).clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			siblingList.add(sibling);
			//FIXME: handle incorrect start and end operator placements
			//to associate the correct end operators with each start operator, we use the offset in the operator list
			//this assumes that the start and end operators are placed correctly (like correct brackets)
			if (op instanceof StartOperator){
				EndOperator end = (EndOperator) ((StartAndEndOperatorOptionObject)op.getOption()).getOtherEnd();
				int offset = loopBody.indexOf(end) - loopBody.indexOf(op);
				offsetMap.put((StartOperator) sibling, offset);
			}
		}	
		//set the correct links between start and end
		for (StartOperator start : offsetMap.keySet()){
			EndOperator end = (EndOperator) siblingList.get(siblingList.indexOf(start) + offsetMap.get(start));
			((StartAndEndOperatorOptionObject)start.getOption()).setOtherEnd(end);
			((StartAndEndOperatorOptionObject)end.getOption()).setOtherEnd(start);
		}
		return siblingList;
	}

} //LoopOperatorEndImpl
