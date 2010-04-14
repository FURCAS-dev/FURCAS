/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: EReferenceReorientCommand.java,v 1.5 2009/02/02 08:39:07 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecoretools.diagram.edit.policies.EcoreBaseItemSemanticEditPolicy;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

/**
 * @generated
 */
public class EReferenceReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject oldEnd;

	/**
	 * @generated
	 */
	private final EObject newEnd;

	/**
	 * @generated
	 */
	public EReferenceReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof EReference) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof EClass && newEnd instanceof EClass)) {
			return false;
		}
		EClassifier target = getLink().getEType();
		return EcoreBaseItemSemanticEditPolicy.LinkConstraints.canExistEReference_3002(getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof EClassifier && newEnd instanceof EClassifier)) {
			return false;
		}
		if (!(getLink().eContainer() instanceof EClass)) {
			return false;
		}
		EClass source = (EClass) getLink().eContainer();
		return EcoreBaseItemSemanticEditPolicy.LinkConstraints.canExistEReference_3002(source, getNewTarget());
	}

	/**
	 * Set Eopposite to null before reorienting
	 * 
	 * @generated NOT
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			if (getLink().getEOpposite() != null) {
				getLink().getEOpposite().setEOpposite(null);
			}
			getLink().setEOpposite(null);
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			if (getLink().getEOpposite() != null) {
				getLink().getEOpposite().setEOpposite(null);
			}
			getLink().setEOpposite(null);
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		getOldSource().getEStructuralFeatures().remove(getLink());
		getNewSource().getEStructuralFeatures().add(getLink());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setEType(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected EReference getLink() {
		return (EReference) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected EClass getOldSource() {
		return (EClass) oldEnd;
	}

	/**
	 * @generated
	 */
	protected EClass getNewSource() {
		return (EClass) newEnd;
	}

	/**
	 * @generated
	 */
	protected EClassifier getOldTarget() {
		return (EClassifier) oldEnd;
	}

	/**
	 * @generated
	 */
	protected EClassifier getNewTarget() {
		return (EClassifier) newEnd;
	}
}
