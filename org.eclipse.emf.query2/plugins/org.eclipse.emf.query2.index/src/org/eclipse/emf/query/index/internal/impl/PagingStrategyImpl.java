/*******************************************************************************
 * Copyright (c) 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query.index.internal.impl;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import org.eclipse.emf.query.index.Messages;
import org.eclipse.emf.query.index.internal.PageFileProvider;
import org.eclipse.emf.query.index.internal.PageableElement;
import org.eclipse.emf.query.index.internal.PagingStrategy;
import org.eclipse.emf.query.index.internal.maps.MapEntry;
import org.eclipse.emf.query.index.internal.maps.SingleMap;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class PagingStrategyImpl<T extends PageableElement> implements PagingStrategy<T> {

	private static class SizedLRUMap<E extends PageableElement> {

		private static class Entry<E> implements MapEntry {

			E element;
			int size;
			int lockCounter;
			Entry<E> next;
			Entry<E> previous;

			Entry(E e, int s) {
				this.element = e;
				this.size = s;
				this.lockCounter = 0;
			}

			public Object getKeyElement(int keyNr) {
				return element;
			}
		}

		private static final int keyNr = -1;

		private SingleMap<E, Entry<E>> list;
		private Entry<E> first;
		private Entry<E> firstUnlocked;
		private Entry<E> last;

		int totalSize;

		public SizedLRUMap() {
			list = new SingleMap<E, Entry<E>>(keyNr);
		}

		public void add(E e, boolean locked) {
			Entry<E> entry = list.get(e);
			if (entry == null) {
				entry = new Entry<E>(e, e.size());
				if (locked) {
					entry.lockCounter++;
					this.addEntryLocked(entry);
				} else {
					this.addEntryUnlocked(entry);
				}
				list.put(entry);
			} else {
				throw new RuntimeException(Messages.Query2Index_PagingStrategyImpl_AlreadyInQueue);
			}
		}

		public void remove(E e) {
			Entry<E> oldEntry = list.get(e);
			if (oldEntry != null) {
				list.remove(oldEntry);
				removeEntry(oldEntry);
			}
		}

		public boolean lock(E e) {
			Entry<E> entry = list.get(e);
			if (entry != null) {
				entry.lockCounter++;
				moveEntryFirstLocked(entry);
				return true;
			} else {
				return false;
			}
		}

		public void unlock(E e) {
			Entry<E> entry = list.get(e);
			if (entry != null) {
				entry.lockCounter--;
				if (entry.lockCounter == 0) {
					moveEntryFirstUnlocked(entry);
				}
			} else {
				throw new IllegalArgumentException(Messages.Query2Index_PagingStrategyImpl_ElementNotLocked);
			}
		}

		public E pollLast() {
			if (firstUnlocked != null) {
				E ret = last.element;
				list.remove(last);
				removeEntry(last);
				return ret;
			} else {
				return null;
			}
		}

		public int totalSize() {
			return totalSize;
		}

		public boolean hasLockedPages() {
			return firstUnlocked != first || firstUnlocked == null;
		}

		public boolean isEmpty() {
			return first == null;
		}

		private void addEntryUnlocked(Entry<E> entry) {
			if (firstUnlocked == null) {
				firstUnlocked = entry;
				entry.previous = last;
				if (last != null) {
					last.next = entry;
				}
				last = entry;
				entry.next = null;
				if (first == null) {
					first = entry;
				}
			} else {
				if (first == firstUnlocked) {
					first = entry;
				}
				entry.previous = firstUnlocked.previous;
				if (firstUnlocked.previous != null) {
					firstUnlocked.previous.next = entry;
				}
				firstUnlocked.previous = entry;
				entry.next = firstUnlocked;
				firstUnlocked = entry;
			}

			totalSize += entry.size;
		}

		private void addEntryLocked(Entry<E> entry) {
			if (first == null) {
				first = entry;
				last = entry;
			} else {
				first.previous = entry;
				entry.next = first;
				entry.previous = null;
				first = entry;
			}

			totalSize += entry.size;
		}

		private void moveEntryFirstUnlocked(Entry<E> entry) {
			if (entry == firstUnlocked) {
				totalSize -= (entry.size - entry.element.size());
				entry.size = entry.element.size();
			} else {
				removeEntry(entry);
				entry.size = entry.element.size();
				addEntryUnlocked(entry);
			}
		}

		private void moveEntryFirstLocked(Entry<E> entry) {
			if (entry == first) {
				totalSize -= (entry.size - entry.element.size());
				entry.size = entry.element.size();
			} else {
				removeEntry(entry);
				entry.size = entry.element.size();
				addEntryLocked(entry);
			}
		}

		private void removeEntry(Entry<E> entry) {
			if (entry == last) {
				last = entry.previous;
				if (last != null) {
					last.next = null;
				}
			} else {
				entry.next.previous = entry.previous;
			}

			if (entry == first) {
				first = entry.next;
				if (first != null) {
					first.previous = null;
				}
			} else {
				entry.previous.next = entry.next;
			}
			if (entry == firstUnlocked) {
				firstUnlocked = entry.next;
			}

			totalSize -= entry.size;
		}

	}

	private SizedLRUMap<T> lruList;
	private PageFileProvider channelProvider;

	private int maxSize;
	private int tolerance;

	private WriteLock lock = new ReentrantReadWriteLock(true).writeLock();

	public PagingStrategyImpl(PageFileProvider chProv, int normalSize, int additionalTolerance) {
		this.channelProvider = chProv;
		this.maxSize = normalSize + additionalTolerance;
		this.tolerance = additionalTolerance;
		lruList = new SizedLRUMap<T>();
	}

	public void addLocked(T element) {
		// no synchronization necessary since only called in write locked update
		this.addInternal(element, true);
	}

	private void addInternal(T element, boolean locked) {
		int size = element.size();
		if (lruList.totalSize() + size > maxSize) {
			this.adjust(size);
		}
		lruList.add(element, locked);
	}

	public void remove(T element) {
		lock.lock();
		lruList.remove(element);
		lock.unlock();
	}

	private void loadElement(T element) throws FileNotFoundException {
		File inputFile = channelProvider.getInputFile(element.getId());
		assert inputFile.exists();

		FileInputStream fis = new FileInputStream(inputFile);
		element.pageIn(fis);
		this.closeStream(fis);

		inputFile.delete();
	}

	private void closeStream(Closeable stream) {
		try {
			stream.close();
		} catch (IOException e) {
			throw new RuntimeException(e); // FIXME exception handling
		}
	}

	private void adjust(int newSize) {
		int targetSize = this.maxSize - this.tolerance - newSize;
		try {
			while (lruList.totalSize() > targetSize) {
				pageOut();
			}
		} catch (FileNotFoundException fnf) {
			throw new RuntimeException(fnf);
		}
	}

	private void pageOut() throws FileNotFoundException {
		T forPageOut = this.lruList.pollLast();
		File outputFile = channelProvider.getOutputFile(forPageOut.getId());

		FileOutputStream fos = new FileOutputStream(outputFile);
		forPageOut.pageOut(fos);
		this.closeStream(fos);
	}

	public void lock(T element) {
		lock.lock();
		try {
			if (lruList.lock(element)) {
				if (lruList.totalSize() > maxSize) {
					this.adjust(0);
				}
			} else {
				try {
					this.loadElement(element);
					this.addInternal(element, true);
				} catch (FileNotFoundException fnf) {
					throw new RuntimeException(fnf);
				}
			}
		} finally {
			lock.unlock();
		}
	}

	public void unlock(T element) {
		lock.lock();
		lruList.unlock(element);
		lock.unlock();
	}

	public void flush() {
		lock.lock();
		try {
			if (lruList.hasLockedPages()) {
				throw new IllegalStateException(Messages.Query2Index_PagingStrategyImpl_LockedPages);
			} else {
				try {
					while (!lruList.isEmpty()) {
						this.pageOut();
					}
				} catch (FileNotFoundException e) {
					throw new RuntimeException(e); // FIXME exception handling
				}
			}
		} finally {
			lock.unlock();
		}
	}
}
