/**
 * Refactoring support for FURCAS. 
 * 
 * This project provide language independent refactoring components. 

 * Basically a refactoring works as follows:
 * 
 * An {@link Action} is triggered via the UI. The Action is usually a subclass of
 * {@link com.sap.ide.refactoring.core.AbstractRefactoringAction} and starts the refactoring by instantiating
 * a subclass of the {@link com.sap.ide.refactoring.core.AbstractModelRefactoring} class. 
 * The latter dictates the (simplified) live-cycle:
 * 
 * <ol>
 *   <li> The Wizard UI is started and used to provide the {@link com.sap.ide.refactoring.core.AbstractModelRefactoring}
 *        instance with the required information. </li>
 *   <li> {@code checkInitialConditions} runs some basic checks
 *        (e.g. abort if no text selected} </li>
 *   <li> The Refactoring class is then asked to create a subclass of {@link com.sap.ide.refactoring.core.AbstractRefactoringCommand}
 *   	  which is used to perform the actual refactoring. </li>         
 * </ol>
 * 
 * @author Stephan Erb (d049157)
 */
package com.sap.ide.refactoring;

