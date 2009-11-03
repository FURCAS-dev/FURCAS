package qvtjmi;


import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class PartitionHelper {
	public static ModelPartition getPartition(RefObject object) {
		return ((Partitionable)object).get___Partition();
	}
	
	public static void addToPartion(RefObject object) {
	}
}
