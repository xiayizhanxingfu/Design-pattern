import javax.management.Descriptor;

/**
 * 
 * @author 下一张幸福
 * {@link Descriptor} 获取形状工厂
 * 
 *
 */
public class ShapeFactory {
	public Shape getShape(String shapeType) {
		if(shapeType==null) {
			return null;
		}
		if(shapeType.equalsIgnoreCase("CIRCLE")){
			return new Circle();
		}
		if(shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		}
		if(shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		return null;
	}
}
