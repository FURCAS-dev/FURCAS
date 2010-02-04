/**
 * Refactoring support for FURCAS. 
 * 
 * This project means to provide language independent components. It operates on
 * a minimal, object-oriented metamodel whose interfaces are to be implemented
 * for each language.
 * 
 * Basically a refactoring works as follows:
 * 
 * An {@link Action} is triggered via the UI. The Action is usually a subclass of
 * {@link AbstractRefactoringAction} and starts the refactoring by instantiating
 * a subclass of the common Eclipse {@link Refactoring} class. 
 * The latter dictates the (simplified) live-cycle:
 * 
 * <ol>
 *   <li> {@code checkInitialConditions} runs some basic checks
 *        (e.g. abort if no text selected} </li>
 *   <li> The Wizard UI is started and used to provide the {@link Refactoring}
 *        instance with the required information. </li>
 *   <li> {@code checkFinalConditions} is called and the 
 *       
 * 
 * </ol>
 * 
 * @author D049157
 */
package com.sap.ide.refactoring;

