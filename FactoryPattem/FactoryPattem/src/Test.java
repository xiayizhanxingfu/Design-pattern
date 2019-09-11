import javax.management.Descriptor;

/**
 * 
 * @author 下一张幸福
 * {@link Descriptor} 测试
 * 
 *
 */
public class Test {

	public static void main(String[] args) {
		//创建工厂
		ShapeFactory shapeFactory=new ShapeFactory();
		
		//获取circle对象
		Shape shape1=shapeFactory.getShape("circle");
		shape1.draw();
		
		//获取Rectangle对象
		Shape shape2=shapeFactory.getShape("Rectangle");
		shape2.draw();
		
		//获取Square对象
		Shape shape3=shapeFactory.getShape("Square");
		shape3.draw();
	}

}
