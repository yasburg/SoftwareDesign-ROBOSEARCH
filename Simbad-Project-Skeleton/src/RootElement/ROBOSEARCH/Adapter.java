// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package RootElement.ROBOSEARCH;

import javax.vecmath.Vector3d;

/************************************************************/
/**
 * 
 */
public class Adapter implements AdapterInterface {
	/**
	 * 
	 */
	public Coordinate coordinate = new Coordinate(new Vector3d(0,0,0), CoordinateStatus.EMPTY);

	/**
	 * 
	 * @return 
	 * @param coorX 
	 * @param coorY 
	 */
	//This function shall take X and Y coordinate
	//And it will be stored in the map as shown here:
	//				X-axis --->
	//			______________________
	//	Y-axis 	|(0,0)|(1,0)|(2,0)|...
	//	  |		|_____|_____|_____|...
	//	  |		|(0,1)|(1,1)|...
	//	  v		|_____|_____|
	//			|(0,2)|...
	//			|_____|
	//			|...
	//REASON: This adapter is used to help user and coders think about
	//the map as a 2D map although it is 3D map in Simbad simulator.
	//Since there is nothing we need on third dimension(height) in 
	//algorithm or anywhere else this was logical and the Simbad simulator
	//uses X and Z axis for 2D plane which is confusing. And in the Simbad simulator
	//the origin is in the middle which makes harder to deal with coordinates.
	//Also taking (0,0) coordinate to top left shall make easier for coders to
	//save the map in 2D array.(array[0][0] is located on top left)
	
	
	public Vector3d convertCoordinate(double coorX, double coorY) {
        return coordinate.convertXYtoXYZ(coorX, coorY);
    }
};
