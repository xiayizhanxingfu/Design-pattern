import javax.management.Descriptor;

/**
 * 
 * @author ��һ���Ҹ�
 * {@link Descriptor} ����
 * 
 *
 */
public class Test {

	public static void main(String[] args) {
		//��������
		ShapeFactory shapeFactory=new ShapeFactory();
		
		//��ȡcircle����
		Shape shape1=shapeFactory.getShape("circle");
		shape1.draw();
		
		//��ȡRectangle����
		Shape shape2=shapeFactory.getShape("Rectangle");
		shape2.draw();
		
		//��ȡSquare����
		Shape shape3=shapeFactory.getShape("Square");
		shape3.draw();
	}

}
