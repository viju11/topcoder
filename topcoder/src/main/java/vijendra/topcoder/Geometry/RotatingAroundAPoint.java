package vijendra.topcoder.Geometry;




public class RotatingAroundAPoint {
	public class POINT{
		double x,y ;
		
	}
	
	POINT rotate_point(double cx,double cy,double angle,POINT p)
	{
	  double s = Math.sin(angle);
	  double c = Math.cos(angle);

	  // translate point back to origin:
	  p.x -= cx;
	  p.y -= cy;

	  // rotate point
	  double xnew = p.x * c - p.y * s;//x Cos(θ) - y Sin(θ)
	  double ynew = p.x * s + p.y * c;// x Sin(θ) + y Cos(θ). 

	  // translate point back:
	  p.x = xnew + cx;
	  p.y = ynew + cy;
	  return p;
	}
	
	/*
	 *  For simplicity, lets assume that we are rotating about the origin.
	 *   In this case, we can find that 
	 *  x' = x Cos(θ) - y Sin(θ) and y' = x Sin(θ) + y Cos(θ). 
	 *  
	 *  
	 */

}
