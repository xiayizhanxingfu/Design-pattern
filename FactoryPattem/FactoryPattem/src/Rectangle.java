import javax.management.Descriptor;

/**
 * 
 * @author 下一张幸福
 * {@link Descriptor} 矩形类
 *
 */
public class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("this is a Rectangle:draw() method.");
	}

}
