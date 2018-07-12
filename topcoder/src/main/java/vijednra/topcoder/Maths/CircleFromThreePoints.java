package vijednra.topcoder.Maths;

public class CircleFromThreePoints {
	
	/*Given 3 points which are not colinear (all on the same line) 
	 * those three points uniquely define a circle. But, how do you 
	 * find the center and radius of that circle? This task turns out 
	 * to be a simple application of line intersection. We want to 
	 * find the perpendicular bisectors of XY and YZ, and then find the 
	 * intersection of those two bisectors. This gives us the center of 
	 * the circle.To find the perpendicular bisector of XY, find the line from X 
	 * to Y, in the form Ax+By=C. A line perpendicular to this line will 
	 * be given by the equation -Bx+Ay=D, for some D. To find D for the 
	 * particular line we are interested in, find the midpoint between 
	 * X and Y by taking the midpoint of the x and y components independently. 
	 * Then, substitute those values into the equation to find D. 
	 * If we do the same thing for Y and Z, we end up with two equations 
	 * for two lines, and we can find their intersections as described above.
	 * 
	 * 
	 * 
	 */

}
