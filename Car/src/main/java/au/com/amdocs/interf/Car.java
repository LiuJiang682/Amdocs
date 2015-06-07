package au.com.amdocs.interf;

import au.com.amdocs.directions.Direction;

/**
 * The car interface. 
 * 
 * @author Jiang Liu
 *
 */
public interface Car {

	// X axis methods
	public int getX();
	public void setX(int x);
	
	// Y axis methods
	public int getY();
	public void setY(int y);
	
	// Facing methods
	public Direction getFacing();
	public void setFacing(Direction facing);
}
