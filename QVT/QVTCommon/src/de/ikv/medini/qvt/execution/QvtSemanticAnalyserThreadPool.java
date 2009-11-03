/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.medini.qvt.execution;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.set.ListOrderedSet;

import de.ikv.medini.qvt.QvtEvaluatorImpl;
import de.ikv.medini.qvt.QvtEvaluatorVisitorImpl;
import de.ikv.medini.qvt.QvtProcessorImpl;
import de.ikv.medini.qvt.model.qvtbase.Rule;
import de.ikv.medini.qvt.model.qvtbase.TypedModel;
import de.ikv.medini.qvt.model.qvtrelation.Relation;
import de.ikv.medini.qvt.model.qvtrelation.RelationalTransformation;
import de.ikv.medini.qvt.util.QvtSemanticTaskDebugInfo;

/**
 * This class manages all {@link QvtSemanticTask} instance. It is responsible to schedule relation executions, but it is not responsible to determine which relation tuples have to
 * be executed. While there is an option to use parallel threads, executing relations in parallel, this is currently turned off and by the way, there are problems using threads
 * with IKVM.
 * 
 * @author Jeff Heaton (http://www.jeffheaton.com)
 * @author Michael Wagner
 * @author Omar Ekine
 * @author Joerg Kiegeland
 * @version 1.0
 */
public class QvtSemanticAnalyserThreadPool {

	/**
	 * Whether tasks can be reactivated by a where relation call, if they already have failed by a deadlock (value <code>true</code>) or whether an exception shall be thrown in
	 * this case (value <code>false</code>)
	 */
	public static final boolean CAN_REACTIVATE_FAILED_TASKS = false;

	/**
	 * The deadlock resolving strategy
	 */
	private static final String DEADLOCK_RESOLVE_STRATEGY = QvtSemanticAnalyserThreadPool.DEADLOCK_RESOLVE_STRATEGY_LOOKAHEAD;

	/**
	 * The default strategy is to let all tasks fail.
	 */
	private static final String DEADLOCK_RESOLVE_STRATEGY_DEFAULT = "DEFAULT";

	/**
	 * This strategy let those tasks fail when the relation of a task is called from a NOT statement at least once
	 */
	private static final String DEADLOCK_RESOLVE_STRATEGY_NOTLOOSES = "NOT";

	/**
	 * This strategy let those task not fail, when they are to be called some waiting task in its where relation call (though it is not known whether the waiting task ever executes
	 * its WHERE clauses). Note that WHERE relation calls nested in an OCL expression are currently not analyzed.
	 */
	private static final String DEADLOCK_RESOLVE_STRATEGY_LOOKAHEAD = "WHERE_LOOKAHEAD";

	private static final boolean useOptimizedTaskList = true;

	private static PrintStream evaluationStream = null;

	private QvtSemanticTask currentComputedTask = null;

	public static PrintStream getLogger() {
		if (QvtSemanticAnalyserThreadPool.evaluationStream != null) {
			return QvtSemanticAnalyserThreadPool.evaluationStream;
		}
		return System.out;
	}

	public static void setLogger(PrintStream stream) {
		QvtSemanticAnalyserThreadPool.evaluationStream = stream;
	}

	/**
	 * Holds all tasks.
	 */
	private Set taskList = new HashSet();

	/**
	 * Maps a QvtSemanticTaskKey instance to a set of QvtSemanticTask instances having the same values for the source domains.
	 */
	private Map taskListMap = new HashMap();

	/**
	 * Holds all tasks where hasWorkToDo() returns true.
	 */
	private ListOrderedSet taskListWithWork = new ListOrderedSet();

	private QvtProcessorImpl processor;

	private List topLevelRelations;

	private Object data;

	private int oldTaskListWithWorkSize;

	/**
	 * Stores how many {@link QvtSemanticTask} instances are randomly generated.
	 */
	private int randomTasks;

	/**
	 * Stores how many {@link QvtSemanticTask} instances were randomly generated when the last model modification occured.
	 */
	private int randomTasksSinceLastCreation;

	private int randomTasksSinceLastModification;

	/**
	 * Stores how many model modifications happened since the last random {@link QvtSemanticTask} instance was created
	 */
	private int modificationCountSinceLastRandomTaskGeneration;

	private Relation randomRelationOfLastRandomTask;

	/**
	 * This flag can be set to true if no new tasks shall be added when addTask() is called
	 */
	private boolean readOnly = false;

	private HashSet lookedAheadTasks;

	public QvtSemanticAnalyserThreadPool(QvtProcessorImpl processor, int threadCount, RelationalTransformation transformation, Object data) {
		super();

		this.data = data;
		if (processor.isRandomMode()) {
			this.topLevelRelations = new ArrayList();
			for (Iterator iter = transformation.getRule().iterator(); iter.hasNext();) {
				Rule rule = (Rule) iter.next();
				Relation relation = (Relation) rule;
				if (relation.isIsTopLevel()) {
					this.topLevelRelations.add(relation);
				}
			}
		}

		this.processor = processor;
	}

	/**
	 * Adds a task to the task list. If already a task exists which equals (see {@link QvtSemanticTask#equals(Object)}) <code>qvtSemanticTask</code>, this task is returned,
	 * and, if the passed task shall be executed, this task is set to be executed, too.
	 * 
	 * @param qvtSemanticTask
	 * @param promotedToBeExecuted
	 *            this out-parameter is set to true if an existing task is set to be executed during this method call
	 * @return
	 */
	public QvtSemanticTask addTask(QvtSemanticTask qvtSemanticTask, boolean[] promotedToBeExecuted) {
		synchronized (this.taskList) {

			Set candidateSet = this.getTaskSetWithEqualSourceDomains(qvtSemanticTask);

			if (!this.taskList.contains(qvtSemanticTask)) {

				QvtSemanticTask existingTask = null;

				for (Iterator candidateIterator = candidateSet.iterator(); candidateIterator.hasNext();) {

					QvtSemanticTask candidate = (QvtSemanticTask) candidateIterator.next();

					if (!candidate.areTargetDomainValuesUndefined() && !qvtSemanticTask.areTargetDomainValuesUndefined()) {
						/*
						 * If target values differ, but are defined, then do not match this candidate, since then 'qvtSemanticTask' shall be a semantic task one its own
						 */
					} else {
						if (candidate.areTargetDomainValuesUndefined() && !qvtSemanticTask.areTargetDomainValuesUndefined()) {
							/*
							 * We bind target domains not yet bound for the existing task
							 */
							if (!this.readOnly) {
								candidate.getTrace().repopulateArguments(qvtSemanticTask.getTrace().getArguments());
							}
						} else {
							/*
							 * Now, qvtSemanticTask.areTargetDomainValuesUndefined() holds
							 */
							if (existingTask != null && existingTask.isShallBeExecuted()) {
								if (candidate.isShallBeExecuted()) {
									throw new RuntimeException("Found 2 or more relation tuples for relation call to " + qvtSemanticTask.getRelation().getName() + ". This is not allowed!");
								}
								continue;
							}
						}
						existingTask = candidate;
					}
				}

				if (existingTask != null) {
					this.reactivate(qvtSemanticTask, existingTask, promotedToBeExecuted);
					return existingTask;
				}

				if (this.readOnly) {
					return null;
				}

				this.taskList.add(qvtSemanticTask);
				this.addToTaskSetWithEqualSourceDomains(qvtSemanticTask, candidateSet);

				this.checkForWork(qvtSemanticTask, false);
				return qvtSemanticTask;
			}

			for (Iterator iter = candidateSet.iterator(); iter.hasNext();) {
				QvtSemanticTask existingTask = (QvtSemanticTask) iter.next();

				if (existingTask.equals(qvtSemanticTask)) {
					this.reactivate(qvtSemanticTask, existingTask, promotedToBeExecuted);
					return existingTask;
				}
			}

			throw new RuntimeException("not reachable");
		}
	}

	/**
	 * Reactivates the existing task if necessary
	 * 
	 * @param qvtSemanticTask
	 * @param existingTask
	 * @param promotedToBeExecuted
	 */
	private void reactivate(QvtSemanticTask qvtSemanticTask, QvtSemanticTask existingTask, boolean[] promotedToBeExecuted) {
		if (qvtSemanticTask.isShallBeExecuted() && !existingTask.isShallBeExecuted()) {
			if (!QvtSemanticAnalyserThreadPool.CAN_REACTIVATE_FAILED_TASKS && existingTask.isFailed()) {
				throw new RuntimeException("Already failed task is not allowed to be reactivated: relation " + existingTask.getRelation().getName());
			}
			promotedToBeExecuted[0] = true;
			existingTask.setShallBeExecuted(true);
			this.checkForWork(existingTask, false);
		}
	}

	/**
	 * Returns all tasks having the same values on the source domains as <code>qvtSemanticTask</code>
	 * 
	 * @param qvtSemanticTask
	 * @return
	 */
	private Set getTaskSetWithEqualSourceDomains(QvtSemanticTask qvtSemanticTask) {
		Object result = this.taskListMap.get(new QvtSemanticTaskKey(qvtSemanticTask));
		if (result == null) {
			return new HashSet();
		}
		if (result instanceof Set) {
			return (Set) result;
		}
		if (result instanceof QvtSemanticTask) {
			Set set = new HashSet();
			set.add(result);
			return set;
		}
		throw new RuntimeException("Error in getSet()");
	}

	/**
	 * Adds a task to {@link #taskListMap}
	 * 
	 * @param qvtSemanticTask
	 * @param candidateSet
	 *            should be calculated by {@link #getTaskSetWithEqualSourceDomains(QvtSemanticTask)}
	 * @return
	 */
	private void addToTaskSetWithEqualSourceDomains(QvtSemanticTask qvtSemanticTask, Set candidateSet) {
		if (candidateSet.size() == 0) {
			this.taskListMap.put(new QvtSemanticTaskKey(qvtSemanticTask), qvtSemanticTask);
		} else if (candidateSet.size() == 1) {
			candidateSet.add(qvtSemanticTask);
			this.taskListMap.put(new QvtSemanticTaskKey(qvtSemanticTask), candidateSet);
		} else {
			candidateSet.add(qvtSemanticTask);
		}
	}

	/**
	 * Remove a task from {@link #taskListMap}
	 * 
	 * @param qvtSemanticTask
	 * @param candidateSet
	 *            should be calculated by {@link #getTaskSetWithEqualSourceDomains(QvtSemanticTask)}
	 * @return
	 */
	private void removeFromTaskSetWithEqualSourceDomains(QvtSemanticTask qvtSemanticTask) {
		Set candidateSet = this.getTaskSetWithEqualSourceDomains(qvtSemanticTask);
		if (candidateSet.contains(qvtSemanticTask)) {
			if (candidateSet.size() == 0) {
				// nothing to do
			} else if (candidateSet.size() == 1) {
				this.taskListMap.remove(new QvtSemanticTaskKey(qvtSemanticTask));
			} else {
				candidateSet.remove(candidateSet);
			}
		}
	}

	/**
	 * Schedules and executes all tasks, printing out debug and profiling information.
	 */
	public void complete() {

		boolean hasThreadsToBeExecuted = true;
		QvtSemanticTaskDebugInfo.setOrAddValueForFeautureCount = 0;
		QvtSemanticTaskDebugInfo.createOclAnyModelElementCount = 0;

		if (this.processor.isDebugMode()) {
			QvtSemanticAnalyserThreadPool.getLogger().println(
			    "(start QVT evaluation in direction '" + this.processor.getDirection() + "')");
		}

		if (this.processor.isRandomMode()) {
			this.randomTasks = 0;
			this.randomTasksSinceLastCreation = 0;
			this.randomTasksSinceLastModification = 0;
		}

		/*
		 * Reads the first requests, among them is usually the "resume" request
		 */
		if (this.processor.getDebugAdapter() != null) {
			this.processor.getDebugAdapter().doDebugWork();
		}

		Date startTimeMeasuring = new Date();
		try {

			while (hasThreadsToBeExecuted) {

				hasThreadsToBeExecuted = false;
				synchronized (this.taskList) {

					if (this.processor.getDebugAdapter() != null) {
						this.processor.getDebugAdapter().beforeComputingNextTask();
					}

					List tmp = QvtSemanticAnalyserThreadPool.useOptimizedTaskList ? /* new ArrayList(taskListWithWork) */this.getArrayFromItem(this.taskListWithWork) : new ArrayList(this.taskList);
					// ArrayList tmp = new ArrayList(tasksWithWork);
					// while (tasksWithWork.size() >= 1) {
					// QvtSemanticTask currentQvtSemanticTask = (QvtSemanticTask) tasksWithWork.iterator().next();
					// if (!currentQvtSemanticTask.hasWorkToDo()) {
					// throw new RuntimeException("currentQvtSemanticTask has no work though in work list!");
					// }
					for (Iterator iter = tmp.iterator(); iter.hasNext();) {
						QvtSemanticTask currentQvtSemanticTask = (QvtSemanticTask) iter.next();
						if (currentQvtSemanticTask.hasWorkToDo()) {
							Date startTupleMeasuring = null;
							int totalCreatedElements = QvtSemanticTaskDebugInfo.createOclAnyModelElementCount;
							int totalModifications = QvtSemanticTaskDebugInfo.getTotalModificationCount();

							if (this.processor.logTasks()) {
								QvtSemanticAnalyserThreadPool.getLogger().print(currentQvtSemanticTask.getRelation().getName());
								startTupleMeasuring = new Date();
							}
							this.currentComputedTask = currentQvtSemanticTask;
							try {
								try {
									currentQvtSemanticTask.run();
								} catch (RuntimeException e) {
									if (this.processor.isDebugMode() && currentQvtSemanticTask.getDebugInfo().failedClause != null) {
										QvtSemanticAnalyserThreadPool.getLogger().println(
										        "(QVT transformation terminated by an exception when executing "
										                + currentQvtSemanticTask.getQvtProcessor().getAnalyser().getMessage("", currentQvtSemanticTask.getDebugInfo().failedClause) + ")");
										e.printStackTrace();
									}
									if (this.processor.getDebugAdapter() != null) {
										this.processor.getDebugAdapter().suspendByException(e);
										this.processor.getDebugAdapter().doDebugWork();
									}
									throw e;
								}
							} finally {
								this.currentComputedTask = null;
							}
							this.checkForWork(currentQvtSemanticTask, true);
							this.checkWaitingTasksForWork(currentQvtSemanticTask, false);

							if (this.processor.isRandomMode()) {
								if (!currentQvtSemanticTask.isComputing() && currentQvtSemanticTask.isExecuted()
								        && this.modificationCountSinceLastRandomTaskGeneration < QvtSemanticTaskDebugInfo.getTotalModificationCount()) {
									Relation relation = currentQvtSemanticTask.getRelation();
									if (!this.processor.isRelationCalled(relation)) {
										// mark as unprocessed
										this.taskList.remove(currentQvtSemanticTask);
										this.removeFromTaskSetWithEqualSourceDomains(currentQvtSemanticTask);
									}
								}

								if (currentQvtSemanticTask.isExecuted()) {
									this.randomRelationOfLastRandomTask = null;
								}

								if (QvtSemanticTaskDebugInfo.createOclAnyModelElementCount > totalCreatedElements) {
									this.randomTasksSinceLastCreation = this.randomTasks;
								}
								if (QvtSemanticTaskDebugInfo.getTotalModificationCount() > totalModifications) {
									this.randomTasksSinceLastModification = this.randomTasks;
								}
							}
							if (this.processor.logTasks()) {
								if (currentQvtSemanticTask.isFailed()) {
									if (currentQvtSemanticTask.getDebugInfo().failedClause != null) {
										QvtSemanticAnalyserThreadPool.getLogger().print(
										        "(failed at " + currentQvtSemanticTask.getQvtProcessor().getAnalyser().getMessage("", currentQvtSemanticTask.getDebugInfo().failedClause) + ")");
									} else {
										QvtSemanticAnalyserThreadPool.getLogger().print("(failed)");
									}
								}
								if (currentQvtSemanticTask.isExecuted()) {
									QvtSemanticAnalyserThreadPool.getLogger().print(
									        "(done successfull bindings:" + currentQvtSemanticTask.getDebugInfo().succussfullBindings + " unsuccessfull bindings:"
									                + currentQvtSemanticTask.getDebugInfo().unsuccussfullBindings + " wordToDo=" + currentQvtSemanticTask.hasWorkToDo() + " isExecutedForWaitingTasks:"
									                + currentQvtSemanticTask.isExecutedForWaitingTasks() + " hasProcessedAllClauses:" + currentQvtSemanticTask.hasProcessedAllClauses() + ")");
								}
								if (currentQvtSemanticTask.getWaitingForTask() != null) {
									QvtSemanticAnalyserThreadPool.getLogger().print("(waiting for " + currentQvtSemanticTask.getWaitingForTask().getRelation().getName() + ")");
								}
								if (currentQvtSemanticTask.hasWorkToDo()) {
									QvtSemanticAnalyserThreadPool.getLogger().print("(hasWorkToDo)");
								}
								long x = new Date().getTime() - startTupleMeasuring.getTime();
								if (x >= 50) {
									QvtSemanticAnalyserThreadPool.getLogger().print("(took " + x + "ms)");
								}
								QvtSemanticAnalyserThreadPool.getLogger().print("(domains: " + currentQvtSemanticTask.getTrace().logDefinedDomainValues() + ")");
								QvtSemanticAnalyserThreadPool.getLogger().println();
							}
							hasThreadsToBeExecuted = true;
						}
					}
					if (!hasThreadsToBeExecuted) {
						if (QvtSemanticAnalyserThreadPool.useOptimizedTaskList) {
							tmp = new ArrayList(this.taskList);
						}

						this.prepareDeadlockResolving();

						/*
						 * Set all tasks to failed which are in "when" modus only. This may resume other tasks waiting for these tasks to fail in e.g. a <code>not</code> clause.
						 */
						for (Iterator iter = tmp.iterator(); iter.hasNext();) {
							QvtSemanticTask currentQvtSemanticTask = (QvtSemanticTask) iter.next();
							if (!currentQvtSemanticTask.isShallBeExecuted() && !currentQvtSemanticTask.isFailed()) {
								if (this.preferFailing(currentQvtSemanticTask)) {
									currentQvtSemanticTask.setFailed(true);
									hasThreadsToBeExecuted = true;
									if (this.processor.logTasks()) {
										QvtSemanticAnalyserThreadPool.getLogger().print(currentQvtSemanticTask.getRelation().getName());
										QvtSemanticAnalyserThreadPool.getLogger().print("(failed by deadlock)");
										QvtSemanticAnalyserThreadPool.getLogger().print("(domains: " + currentQvtSemanticTask.getTrace().logDefinedDomainValues() + ")");
										QvtSemanticAnalyserThreadPool.getLogger().println();
									}
								} else {
									if (this.processor.logTasks()) {
										QvtSemanticAnalyserThreadPool.getLogger().print(currentQvtSemanticTask.getRelation().getName());
										QvtSemanticAnalyserThreadPool.getLogger().print("(preserved from deadlock)");
										QvtSemanticAnalyserThreadPool.getLogger().print("(domains: " + currentQvtSemanticTask.getTrace().logDefinedDomainValues() + ")");
										QvtSemanticAnalyserThreadPool.getLogger().println();
									}
								}
							}
						}

						if (!hasThreadsToBeExecuted) {
							for (Iterator iter = tmp.iterator(); iter.hasNext();) {
								QvtSemanticTask currentQvtSemanticTask = (QvtSemanticTask) iter.next();
								if (!currentQvtSemanticTask.isShallBeExecuted() && !currentQvtSemanticTask.isFailed()) {
									currentQvtSemanticTask.setFailed(true);
									hasThreadsToBeExecuted = true;
									if (this.processor.logTasks()) {
										QvtSemanticAnalyserThreadPool.getLogger().print(currentQvtSemanticTask.getRelation().getName());
										QvtSemanticAnalyserThreadPool.getLogger().print("(failed by deadlock finally)");
										QvtSemanticAnalyserThreadPool.getLogger().print("(domains: " + currentQvtSemanticTask.getTrace().logDefinedDomainValues() + ")");
										QvtSemanticAnalyserThreadPool.getLogger().println();
									}
								}
							}
						}
					}
				}
			}
		} finally {

			if (this.processor.isDebugMode()) {
				QvtSemanticAnalyserThreadPool.getLogger().println(
				        "(QVT evaluation done in " + (new Date().getTime() - startTimeMeasuring.getTime()) + " ms, created " + QvtSemanticTaskDebugInfo.createOclAnyModelElementCount
				                + " new elements, set " + QvtSemanticTaskDebugInfo.setOrAddValueForFeautureCount + " features )");
			}
		}
	}

	/**
	 * This method is called for each deadlock task. Returns <code>true</code> if this task shall be set to fail, or return <code>false</code> if this task is likely to be
	 * activated by a where relation call.
	 * 
	 * @param currentQvtSemanticTask
	 * @return
	 */
	private boolean preferFailing(QvtSemanticTask currentQvtSemanticTask) {
		if (QvtSemanticAnalyserThreadPool.DEADLOCK_RESOLVE_STRATEGY.equals(QvtSemanticAnalyserThreadPool.DEADLOCK_RESOLVE_STRATEGY_NOTLOOSES)) {
			return this.processor.isRelationCalledByNot(currentQvtSemanticTask.getRelation());
		}
		if (QvtSemanticAnalyserThreadPool.DEADLOCK_RESOLVE_STRATEGY.equals(QvtSemanticAnalyserThreadPool.DEADLOCK_RESOLVE_STRATEGY_LOOKAHEAD)) {
			return !this.lookedAheadTasks.contains(currentQvtSemanticTask);
		}
		return true;
	}

	/**
	 * Before a deadlock situation is handled, this method is called so that the different deadlock resolving strategies can prepare themselves
	 * 
	 */
	private void prepareDeadlockResolving() {
		if (QvtSemanticAnalyserThreadPool.DEADLOCK_RESOLVE_STRATEGY.equals(QvtSemanticAnalyserThreadPool.DEADLOCK_RESOLVE_STRATEGY_LOOKAHEAD)) {
			this.readOnly = true;
			try {
				this.lookedAheadTasks = new HashSet();
				for (Iterator iter = this.taskList.iterator(); iter.hasNext();) {
					QvtSemanticTask currentQvtSemanticTask = (QvtSemanticTask) iter.next();
					if (currentQvtSemanticTask.isComputing() && currentQvtSemanticTask.currentWhenClause() != null) {
						currentQvtSemanticTask.lookAheadWhereRelationCalls(this.lookedAheadTasks);
					}
				}
			} finally {
				this.readOnly = false;
			}
		}
	}

	/**
	 * Returns an array with one item of the given list
	 * 
	 * @param list
	 * @return
	 */
	private List getArrayFromItem(ListOrderedSet list) {

		if (this.processor.isRandomMode() && list.isEmpty() && this.processor.hasRandomResidual() && this.randomTasks - this.randomTasksSinceLastCreation <= 100) {
			TypedModel targetModel = (TypedModel) ((Map) this.data).get(QvtEvaluatorImpl.QVT_EXECUTION_DIRECTION_PROPERTY_NAME);
			this.oldTaskListWithWorkSize = this.taskListWithWork.size();

			if (this.randomRelationOfLastRandomTask != null) {
				this.processor.getQvtEvaluator().getQvtEvaluatorVisitor().executeToplevelRelation(this.randomRelationOfLastRandomTask, targetModel, this.data);
				if (this.hasCreatedRandomTask()) {
					this.randomTasks++;
					this.modificationCountSinceLastRandomTaskGeneration = QvtSemanticTaskDebugInfo.getTotalModificationCount();

				}

			}

			if (list.isEmpty()) {
				List relations = QvtEvaluatorVisitorImpl.getRandomPermutation(this.topLevelRelations);
				for (Iterator iter = relations.iterator(); iter.hasNext();) {
					Relation relation = (Relation) iter.next();
					this.processor.getQvtEvaluator().getQvtEvaluatorVisitor().executeToplevelRelation(relation, targetModel, this.data);
					if (this.hasCreatedRandomTask()) {
						this.randomTasks++;
						this.modificationCountSinceLastRandomTaskGeneration = QvtSemanticTaskDebugInfo.getTotalModificationCount();
						this.randomRelationOfLastRandomTask = relation;
						break;
					}
				}
			}
		}

		List result = new ArrayList();
		if (!list.isEmpty()) {
			result.add(list.get(0));
		}
		return result;
	}

	/**
	 * Check if the te tasks which wait for <code>task</code> have work to do.
	 * 
	 * @param task
	 */
	public void checkWaitingTasksForWork(QvtSemanticTask task, boolean expectToBeInList) {
		/*
		 * if currentComputedTask == task, then this method will be called after currentComputedTask is reset, so no need to call it here
		 */
		if (this.currentComputedTask != task) {
			for (Iterator it = task.getWaitingTasksIterator(); it.hasNext();) {
				QvtSemanticTask waitingTask = (QvtSemanticTask) it.next();
				this.checkForWork(waitingTask, expectToBeInList);
			}
		}
	}

	/**
	 * If <code>task</code> has work to do, add this task to the list of tasks which have work to do
	 * 
	 * @param task
	 * @param expectToBeInList
	 *            whether task is to be expected in the list or not - currently not used, may be useful in future!
	 */
	public void checkForWork(QvtSemanticTask task, boolean expectToBeInList) {
		boolean isInList = this.taskListWithWork.contains(task);
		if (expectToBeInList != isInList) {
			System.err.println("Task for relation " + task.getRelation().getName() + " was " + (expectToBeInList ? "" : "not ") + "expected to be in the taskListWithWork list!");
		}
		if (task.hasWorkToDo()) {
			if (!isInList) {
				this.taskListWithWork.add(0, task);
			}
		} else {
			if (isInList) {
				this.taskListWithWork.remove(task);
			}
		}
	}

	/**
	 * Brings task <code>task</code> in front of all other tasks waiting to be computed
	 * 
	 * @param task
	 */
	public void bringToFront(QvtSemanticTask task) {
		if (this.taskListWithWork.remove(task)) {
			this.taskListWithWork.add(0, task);
		} else if (task.getWaitingForTask() != null) {
			this.bringToFront(task.getWaitingForTask());
		}
	}

	/**
	 * Retrieves the request which is currently computed
	 * 
	 * @return
	 */
	public QvtSemanticTask getCurrentComputedTask() {
		return this.currentComputedTask;
	}

	public int getTaskCount() {
		return this.taskList.size();
	}

	public boolean hasCreatedRandomTask() {
		return this.taskListWithWork.size() > this.oldTaskListWithWorkSize;
	}

}
