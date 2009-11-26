/*
 * Created on Sep 8, 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.sap.tc.logging.messagedepot;

import com.sap.tc.logging.*;

/**
 * @author I803971
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class MessageID {

	private final String id_;

	public MessageID() {
		id_ = new UID().toString();
	}

	public MessageID(String id) {
		id_ = id;
	}
	
	public int hashCode() {
		if (id_ != null) {
			return id_.hashCode();
		} else {
			return 0;
		}
	}

	public static boolean equals(Object obj1, Object obj2) {
		return (obj1 == obj2) || (obj1 != null) && obj1.equals(obj2);
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj != null && getClass() == obj.getClass()) {
			MessageID other = (MessageID) obj;
			return equals(id_, other.id_);
		}
		return false;
	}
	
	public String toString() {
		return id_;
	}
	public String getID() {
		return id_;
	}
}

