
public interface Storage {
	int getStorageCapacity();
	
	default int getStorageCapacityInKB()
	{
		return 1048576*this.getStorageCapacity();
	}
	
	default int getStorageCapacityInMB()
	{
		return 1024*this.getStorageCapacity();
	}
	
	default int getStorageCapacityInBytes()
	{
		return 1073741824*this.getStorageCapacity();
	}
}
