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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.query.index.internal.IncomingReferenceDescriptor;
import org.eclipse.emf.query.index.internal.maps.SerializationStrategy;
import org.eclipse.emf.query.index.internal.maps.SingleMap;
import org.eclipse.emf.query.index.internal.maps.SerializationStrategy.Channel;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class SerializationStrategyFactory {

	private static final int MAX_SIZE = 262144;

	public static final String ENCODING = "UTF-8"; //$NON-NLS-1$

	private static final int INT_SIZE = Integer.SIZE / 8;

	private static final int SHORT_SIZE = Short.SIZE / 8;

	private static final int LONG_SIZE = Long.SIZE / 8;

	private static final int BYTE_SIZE = Byte.SIZE / 8;

	// Java spec requires for UTF-8 to be available on all supported platforms
	private static final String STRING_ENCODING = "UTF-8"; //$NON-NLS-1$

	protected final static class DumpReadBuffer implements Channel {

		private ByteBuffer buffer;

		private ReadableByteChannel fc;

		private byte[] stringBuffer;

		/**
		 * @param input
		 * @param size
		 *            Size of the channel content
		 * @param bufMaxSize
		 *            maximum buffer size
		 * @throws IOException
		 */
		public DumpReadBuffer(ReadableByteChannel input, int size, int bufMaxSize, boolean direct) throws IOException {

			this(input, (size < bufMaxSize) ? size : bufMaxSize, direct);
		}

		/**
		 * @param input
		 * @param bufSize
		 *            fixed buffer size
		 * @throws IOException
		 */
		public DumpReadBuffer(ReadableByteChannel input, int bufSize, boolean direct) throws IOException {

			this.fc = input;
			if (direct) {
				this.buffer = ByteBuffer.allocateDirect(bufSize);
			} else {
				this.buffer = ByteBuffer.allocate(bufSize);
			}
			this.stringBuffer = new byte[bufSize];
			this.fc.read(this.buffer);
			this.buffer.flip();
		}

		public int getInt() {

			if (this.buffer.limit() - this.buffer.position() < INT_SIZE) {
				this.adjustBuffer();
			}
			return this.buffer.getInt();
		}

		private short getShort() {

			if (this.buffer.limit() - this.buffer.position() < SHORT_SIZE) {
				this.adjustBuffer();
			}
			return this.buffer.getShort();
		}

		public byte getByte() {

			if (this.buffer.limit() - this.buffer.position() < BYTE_SIZE) {
				this.adjustBuffer();
			}
			return this.buffer.get();
		}

		private void getBytes(byte[] buf, int offset, int length) {

			if (this.buffer.limit() - this.buffer.position() < BYTE_SIZE * length) {
				this.adjustBuffer();
			}
			this.buffer.get(buf, offset, length);
		}

		public long getLong() {

			if (this.buffer.limit() - this.buffer.position() < LONG_SIZE) {
				this.adjustBuffer();
			}
			return this.buffer.getLong();
		}

		public String getString() {

			int length = this.getInt();

			if (length == -1) {
				return null;
			}

			if (this.buffer.limit() - this.buffer.position() < length) {
				this.adjustBuffer();
			}
			this.buffer.get(this.stringBuffer, 0, length);
			try {
				return new String(this.stringBuffer, 0, length, ENCODING);
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e); // FIXME exceptino handling
			}
		}

		private void adjustBuffer() {

			this.buffer.compact();
			try {
				this.fc.read(this.buffer);
			} catch (IOException e) {
				throw new RuntimeException(e); // FIXME exception handling
			}
			this.buffer.flip();
		}

		@Override
		public void putByte(byte b) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void putInt(int i) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void putLong(long l) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void putString(String s) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void close() {
		}

		@Override
		public String[] getStringPool() {
			try {
				return getStringPoolImpl();
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}

		private String[] getStringPoolImpl() throws UnsupportedEncodingException {

			int nos = getInt();

			byte[] stringBuffer = new byte[MAX_SIZE];

			String[] ret = new String[nos];

			for (int i = 0; i < nos; i++) {
				short offset = getShort();
				short reset = getShort();

				getBytes(stringBuffer, reset, offset);

				ret[i] = new String(stringBuffer, 0, reset + offset, STRING_ENCODING);
			}

			return ret;
		}

		@Override
		public Map<String, Integer> putStringPool(List<String> strings) {
			throw new UnsupportedOperationException();
		}

	}

	protected final static class DumpWriteBuffer implements Channel {

		private ByteBuffer buffer = null;

		private WritableByteChannel fc = null;

		public DumpWriteBuffer(WritableByteChannel output, int bufMaxSize, boolean direct) {

			this.fc = output;
			if (direct) {
				this.buffer = ByteBuffer.allocateDirect(bufMaxSize);
			} else {
				this.buffer = ByteBuffer.allocate(bufMaxSize);
			}
		}

		public void putInt(int value) {

			if (this.buffer.limit() - this.buffer.position() < INT_SIZE) {
				this.flushBuffer(INT_SIZE);
			}
			this.buffer.putInt(value);
		}

		private void putShort(short value) {
			if (this.buffer.limit() - this.buffer.position() < SHORT_SIZE) {
				this.flushBuffer(SHORT_SIZE);
			}
			this.buffer.putShort(value);
		}

		public void putString(String value) {

			if (value == null) {
				this.putInt(-1);
				return;
			}

			byte[] bytes;
			try {
				bytes = value.getBytes(ENCODING);
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e); // FIXME exception handling
			}

			this.putInt(bytes.length);

			if (this.buffer.limit() - this.buffer.position() < bytes.length) {
				this.flushBuffer(bytes.length);
			}
			this.buffer.put(bytes);
		}

		public void putLong(long value) {

			if (this.buffer.limit() - this.buffer.position() < LONG_SIZE) {
				this.flushBuffer(LONG_SIZE);
			}
			this.buffer.putLong(value);
		}

		public void putByte(byte value) {

			if (this.buffer.limit() - this.buffer.position() < BYTE_SIZE) {
				this.flushBuffer(BYTE_SIZE);
			}
			this.buffer.put(value);
		}

		private void putBytes(byte[] bytes) {
			if (this.buffer.limit() - this.buffer.position() < BYTE_SIZE * bytes.length) {
				this.flushBuffer(BYTE_SIZE);
			}
			this.buffer.put(bytes);

		}

		private void flushBuffer(int nextInputSize) {

			// set limit to position and position to 0
			this.buffer.flip();
			// write buffer content to file channel
			try {
				this.fc.write(this.buffer);
			} catch (IOException e) {
				throw new RuntimeException(e); // FIXME exception handling
			}
			// check if buffer is big enough to handle next input
			if (this.buffer.capacity() < nextInputSize) {
				throw new BufferOverflowException();
			}
			// set limit to capacity and position to 0
			this.buffer.clear();
		}

		public void flushBuffer() throws IOException {

			this.flushBuffer(0);
		}

		@Override
		public byte getByte() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int getInt() {
			throw new UnsupportedOperationException();
		}

		@Override
		public long getLong() {
			throw new UnsupportedOperationException();
		}

		@Override
		public String getString() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void close() {
			try {
				this.flushBuffer();
			} catch (IOException e) {
				throw new RuntimeException(e); // FIXME exception handling
			}
		}

		@Override
		public String[] getStringPool() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Map<String, Integer> putStringPool(List<String> in) {
			try {
				return putStringPoolImpl(in);
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}

		private Map<String, Integer> putStringPoolImpl(List<String> in) throws UnsupportedEncodingException {

			//FIXME byte[] buf = new byte[4];

			//FIXME os.write( toByteArray( buf, in.size( ) ) );

			int inSize = in.size();

			putInt(inSize);

			Map<String, Integer> ret = new HashMap<String, Integer>(inSize);

			// compute offset and reset index
			String prevString = ""; //$NON-NLS-1$
			int longestString = 0;
			for (int i = 0; i < inSize; i++) {
				String s = in.get(i);

				ret.put(s, i);

				// don't need overflow checks, the strings are unique
				int resetIndexChars = commonPrefixAt(prevString, s);

				short resetIndexBytes = (short) s.substring(0, resetIndexChars).getBytes(STRING_ENCODING).length;

				// for now, the offset is just the number of chars after reset. the byte offsets are computed later
				short offsetIndexBytes = (short) (s.getBytes(STRING_ENCODING).length - resetIndexBytes);

				longestString = Math.max(resetIndexBytes + offsetIndexBytes, longestString);

				prevString = s;

				String tail = s.substring(resetIndexBytes, s.length());

				//FIXME os.write( tail.getBytes( STRING_ENCODING ) );
				putShort(offsetIndexBytes);
				putShort(resetIndexBytes);
				putBytes(tail.getBytes(STRING_ENCODING));
			}

			//FIXME os.write( toByteArray( buf, longestString ) );
			//FIXME putInt(longestString);

			return ret;
		}

		private int commonPrefixAt(String s1, String s2) {

			int l1 = s1.length();
			int l2 = s2.length();

			int i = 0;
			for (i = 0; i < l1 && i < l2; i++) {
				if (s1.charAt(i) != s2.charAt(i)) {
					break;
				}
			}

			return i;
		}

	}

	private abstract static class BaseStrategy<K, E> implements SerializationStrategy<K, E> {

		protected Channel channel;

		public BaseStrategy(Channel ch) {
			this.channel = ch;
		}

		@Override
		public Channel getChannel() {
			return this.channel;
		}
	}

	private static class EObjectMapStrategy extends BaseStrategy<String, EObjectDescriptorImpl> {

		private PageableResourceDescriptorImpl resourceDescriptor;

		private EObjectMapStrategy(Channel _channel, PageableResourceDescriptorImpl resDesc) {
			super(_channel);
			this.resourceDescriptor = resDesc;
		}

		@Override
		public EObjectDescriptorImpl readElement(String key) {
			String name = this.channel.getString();
			int size = channel.getInt();
			if (size == -1) {
				return new EObjectDescriptorImpl(null, this.resourceDescriptor, key, name, null);
			} else {
				Map<String, String> userData = new HashMap<String, String>(size);
				for (int i = 0; i < size; i++) {
					userData.put(channel.getString(), channel.getString());
				}
				return new EObjectDescriptorImpl(null, this.resourceDescriptor, key, name, userData);
			}
		}

		@Override
		public String readKey() {
			return channel.getString();
		}

		@Override
		public void writeElement(EObjectDescriptorImpl element) {
			channel.putString(element.getName());
			Map<String, String> userData = element.getUserData();
			if (userData == null) {
				channel.putInt(-1);
			} else {
				channel.putInt(userData.size());
				for (Map.Entry<String, String> entry : userData.entrySet()) {
					channel.putString(entry.getKey());
					channel.putString(entry.getValue());
				}
			}
		}

		@Override
		public void writeKey(String key) {
			channel.putString(key);
		}
	}

	private static class LocalTypeMapStrategy extends BaseStrategy<String, EObjectDescriptorImpl> {

		private SingleMap<String, EObjectDescriptorImpl> eObjectMap;

		private LocalTypeMapStrategy(Channel _channel, SingleMap<String, EObjectDescriptorImpl> eObjMap) {
			super(_channel);
			this.eObjectMap = eObjMap;
		}

		@Override
		public EObjectDescriptorImpl readElement(String key) {
			int pos = channel.getInt();
			EObjectDescriptorImpl objectDescriptor = eObjectMap.get(pos);
			objectDescriptor.setEClass(key);
			return objectDescriptor;
		}

		@Override
		public String readKey() {
			return channel.getString().intern();
		}

		@Override
		public void writeElement(EObjectDescriptorImpl element) {
			channel.putInt(eObjectMap.getPosition(element.getFragment()));
		}

		@Override
		public void writeKey(String key) {
			channel.putString(key);
		}
	}

	private static class OutgoingLinkMapStrategy extends BaseStrategy<String, ReferenceDescriptorImpl> {

		private SingleMap<String, PageableResourceDescriptorImpl> resourceMap;

		private SingleMap<String, EObjectDescriptorImpl> eObjectMap;

		private OutgoingLinkMapStrategy(Channel _channel, SingleMap<String, PageableResourceDescriptorImpl> resDesc,
				SingleMap<String, EObjectDescriptorImpl> eObjMap) {
			super(_channel);
			this.resourceMap = resDesc;
			this.eObjectMap = eObjMap;
		}

		@Override
		public ReferenceDescriptorImpl readElement(String key) {
			String typeURI = channel.getString();
			String tarRes = channel.getString();
			String fragment = channel.getString();

			// FIXME expensive resolving
			tarRes = this.resourceMap.getEqual(tarRes).getURI();
			return new ReferenceDescriptorImpl(eObjectMap.get(key), typeURI, tarRes, fragment);
		}

		@Override
		public String readKey() {
			return eObjectMap.get(channel.getInt()).getFragment();
		}

		@Override
		public void writeElement(ReferenceDescriptorImpl element) {
			// FIXME expensive resolving
			channel.putString(element.getEReferenceURI());
			channel.putString(element.getTargetResourceURI());
			channel.putString(element.getTargetFragment());
		}

		@Override
		public void writeKey(String key) {
			channel.putInt(eObjectMap.getPosition(key));
		}
	}

	private static class IncomingLinkMapStrategy extends BaseStrategy<String, IncomingReferenceDescriptor> {

		private SingleMap<String, PageableResourceDescriptorImpl> resourceMap;

		private SingleMap<String, EObjectDescriptorImpl> eObjectMap;

		private IncomingLinkMapStrategy(Channel _channel, SingleMap<String, PageableResourceDescriptorImpl> resDesc,
				SingleMap<String, EObjectDescriptorImpl> eObjMap) {
			super(_channel);
			this.resourceMap = resDesc;
			this.eObjectMap = eObjMap;
		}

		@Override
		public IncomingReferenceDescriptor readElement(String key) {
			String tarRes = channel.getString();
			String fragment = channel.getString();

			tarRes = this.resourceMap.getEqual(tarRes).getURI();
			return new IncomingReferenceDescriptorImpl(key, tarRes, fragment);
		}

		@Override
		public String readKey() {
			int pos = channel.getInt();
			if (pos == -1) {
				return channel.getString();
			} else {
				return eObjectMap.get(pos).getFragment();
			}
		}

		@Override
		public void writeElement(IncomingReferenceDescriptor element) {
			channel.putString(element.getSourceResourceURI());
			channel.putString(element.getSourceFragment());
		}

		@Override
		public void writeKey(String key) {

			if (eObjectMap == null) {
				channel.putInt(-1);
				channel.putString(key);
			} else {
				int pos = eObjectMap.getPosition(key);
				channel.putInt(pos);
				if (pos == -1) {
					channel.putString(key);
				}
			}

		}
	}

	private static class ResourceMapStrategy extends BaseStrategy<String, PageableResourceDescriptorImpl> {

		private final PagingResourceDescriptorMap<String, PageableResourceDescriptorImpl> resourceMap;

		public ResourceMapStrategy(Channel ch, PagingResourceDescriptorMap<String, PageableResourceDescriptorImpl> resDesc) {
			super(ch);
			this.resourceMap = resDesc;
		}

		@Override
		public PageableResourceDescriptorImpl readElement(String key) {
			long version = channel.getLong();
			return new PageableResourceDescriptorImpl(key, version, null, this.resourceMap, true /* pagedOut */);
		}

		@Override
		public String readKey() {
			return channel.getString();
		}

		@Override
		public void writeElement(PageableResourceDescriptorImpl element) {
			channel.putLong(element.getIndexedVersion());
		}

		@Override
		public void writeKey(String key) {
			channel.putString(key);
		}
		
	}
	
	private static class GlobalTypeMapStrategy extends BaseStrategy<String, String> {

		private final SingleMap<String, PageableResourceDescriptorImpl> resourceMap;

		public GlobalTypeMapStrategy(Channel ch, SingleMap<String, PageableResourceDescriptorImpl> resMap) {
			super(ch);
			this.resourceMap = resMap;
		}

		@Override
		public String readElement(String key) {
			return this.resourceMap.get(channel.getInt()).getURI();
		}

		@Override
		public String readKey() {
			return channel.getString();
		}

		@Override
		public void writeElement(String element) {
			int position = this.resourceMap.getPosition(element);
			channel.putInt(position);
		}

		@Override
		public void writeKey(String key) {
			channel.putString(key);
		}
		
	}
	
	private Channel channel;

	public SerializationStrategyFactory(FileInputStream ch) {
		try {
			this.channel = new DumpReadBuffer(ch.getChannel(), MAX_SIZE, true);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public SerializationStrategyFactory(FileOutputStream ch) {
		this.channel = new DumpWriteBuffer(ch.getChannel(), MAX_SIZE, true);
	}

	public SerializationStrategy<String, EObjectDescriptorImpl> createEObjectMapStrategy(PageableResourceDescriptorImpl resDesc) {
		return new EObjectMapStrategy(this.getChannel(), resDesc);
	}

	public SerializationStrategy<String, EObjectDescriptorImpl> createTypeMapStrategy(SingleMap<String, EObjectDescriptorImpl> eObjectMap) {
		return new LocalTypeMapStrategy(this.getChannel(), eObjectMap);
	}

	public SerializationStrategy<String, ReferenceDescriptorImpl> createOutgoingLinkMapStrategy(
			SingleMap<String, EObjectDescriptorImpl> eObjectMap, SingleMap<String, PageableResourceDescriptorImpl> resourceMap) {
		return new OutgoingLinkMapStrategy(this.getChannel(), resourceMap, eObjectMap);
	}

	public SerializationStrategy<String, IncomingReferenceDescriptor> createIncomingLinkMapStrategy(
			SingleMap<String, EObjectDescriptorImpl> eObjectMap, SingleMap<String, PageableResourceDescriptorImpl> resourceMap) {
		return new IncomingLinkMapStrategy(this.getChannel(), resourceMap, eObjectMap);
	}

	public SerializationStrategy<String, PageableResourceDescriptorImpl> createResourceMapStrategy(PagingResourceDescriptorMap<String, PageableResourceDescriptorImpl> resourceMap) {
		return new ResourceMapStrategy(this.getChannel(), resourceMap);
	}
	
	public SerializationStrategy<String, String> createGlobalTypeMapStrategy(SingleMap<String, PageableResourceDescriptorImpl> underlyingMap) {
		return new GlobalTypeMapStrategy(this.getChannel(), underlyingMap);
	}

	protected Channel getChannel() {
		return this.channel;
	}

	public void finalizePaging() {
		this.getChannel().close();
	}

}
