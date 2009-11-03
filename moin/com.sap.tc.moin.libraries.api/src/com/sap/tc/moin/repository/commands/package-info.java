/**
 * Provides Interfaces for implementing and executing MOIN Commands.
 * <br>MOIN undoable commands are the way for performing model modifications that can be "automatically"
 *  undone / redone, providing transactional behaviour; i.e. a command is either completely
 *  performed, or nothing. MOIN Commands can be used to create a set of reusable operations
 *  related to specific Metamodels, similar to utility libraries. <br><br>
 * <b> Main Features: </b><br>
 * <ul>
 * <li> The command logic can be implemented using plain JMI calls. </li>
 * <li> Undo / Redo functionality is provided by the framework. </li>
 * <li> Transactional behavior provided by framework. </li>
 * <li> Support for exception handling to stop rollback. </li>
 * <li> Commands can be composed (to create new commands) and grouped (to combine them in one undoable element). </li>
 * </ul><br>
 * <b>Example 1:</b> Executing a command
 * <code><pre>
 * ...
 *
 * NewPkgWClass npwc = new NewPkgWClass(moinConnection,"Pkg1","Cls1");
 * CommandHandle ch = moinConnection.getCommandStack().execute(npwc);
 * newPackage = npwc.getNewPackage();
 * ...
 * </pre></code> <br>
 * <b>Example 2:</b> Creating a command
 * <code><pre>
 * public class NewClassInContainer extends ExecutableCommand {
 * ...
 *   public NewClassInContainer(Connection con, Namespace ns, String cn) {
 *     super(con,"New Class "+cn+" in container "+ns.getName());
 *   }
 *
 *   public Collection<PartitionOperation> getAffectedPartitions() {
 *     ArrayListy<PartitionOperation> ret =
 *                     new ArrayListy<PartitionOperation>();
 *     ret.add(new PartitionOperation(EDIT, ns.getMRI()));
 *     return ret;
 *   }
 *
 *   public boolean canExecute() {
 *     return (ns instanceof MofPackage || ns instanceof MofClass);
 *   }
 *
 *   public void doExecute() {
 *     myNewClass = myModel.getMofClass().createMofClass();
 *     newClass.setName(cn);
 *     newClass.setContainer(ns);
 *   }
 * }
 * </pre></code> <br>
 * <br>
 * This API is for SAP-internal use only and subject to change
 */
package com.sap.tc.moin.repository.commands;