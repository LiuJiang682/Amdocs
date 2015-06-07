package au.com.amdocs.interf;

/**
 * The interface for car table.
 * 
 * @author Jiang Liu
 *
 */
public interface CarTable {

	Car getCar();
	void setCar(Car car);
	
	int getMaxX();
	int getMaxY();
}
