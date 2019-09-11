import javax.management.Descriptor;

/**
 * 
 * @author 下一张幸福
 * {@link Descriptor} 圆类
 *
 */
public class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("this is a Circle:draw() method.");
	}

}
