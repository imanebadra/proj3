/** Worker class with two constructors and  basic calculations for Sphere and box volume
 * 
 * 
 *@version 1.0
 */
public class Volume
{
	private double radius;
	private double target;
	private double length;
	private double width;
	private double height;
	/** Default constructor  that sets the setters to 0
	 * 
	 */
	public Volume()
    {
		setTarget(0);
		setRadius(0);
		setHeight(0);
		setLength(0);
		setWidth(0);
    }
	/**  Description of second constructor of Volume class 
	 * 
	 * @param target Volume Target 
	 * @param radius Radius of Sphere
	 * @param length Length of Box
	 * @param width Width of Box
	 * @param height Height of Box
	 */
	public Volume(double target, double radius, double length, double width, double height)
	{
		setTarget(target);
		setRadius(radius);
		setHeight(height);
		setLength(length);
		setWidth(width);
	}
	/** Calculate the volume of sphere
	 * 
	 * @return the volume of sphere
	 */
	double getSphereVolume()
	{
		//4/3 pi r^3
		return (4.0 / 3.0) * Math.PI * radius * radius * radius;
	}
	/** Calculate the box volume
	 * 
	 * @return volume of box
	 */
	double getBoxVolume()
	{
		return length * width * height;
	}
	/** Get the difference between target and box volume
	 * 
	 * @return the difference between the target and volume of box
	 */
	
	double getBoxDifference()
	{
		return target - getBoxVolume();
	}
	/** Get the difference between the target and sphere volume
	 * 
	 * @return Difference between sphere volume and target volume
	 */
	double getSphereDifference()
	{
		return target - getSphereVolume();
	}

	/** Get the radius of sphere
	 * 
	 * @return radius of sphere
	 */
	public double getRadius()
	{
		return radius;
	}
/** 
 * 
 * @param radius radius to set 
 */
	public void setRadius(double radius)
	{
		this.radius = radius;
	}
/** Method to get Target Volume
 * 
 * @return target volume
 */
	public double getTarget()
	{
		return target;
	}
/** 
 * 
 * @param target target to set 
 */
	public void setTarget(double target)
	{
		this.target = target;
	}
/** Method to get length of Box
 * 
 * @return length of box
 */
	public double getLength()
	{
		return length;
	}
/** 
 * 
 * @param length length to set for box
 */
	public void setLength(double length)
	{
		this.length = length;
	}
/** method to get width of box
 * 
 * @return width of box
 */
	public double getWidth()
	{
		return width;
	}
/** 
 * 
 * @param width width to set for box
 */
	public void setWidth(double width)
	{
		this.width = width;
	}
/** method to get height of box
 * 
 * @return height of box
 */
	public double getHeight()
	{
		return height;
	}
/** 
 * 
 * @param height height to set for box
 */
	public void setHeight(double height)
	{
		this.height = height;
	}
	
	
}
