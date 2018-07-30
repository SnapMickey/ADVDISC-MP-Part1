import java.util.ArrayList;

public class Driver {
	public static void main(String args[]) {
		
		/*ArrayList<Vector> vectors = new ArrayList<Vector>();
		vectors.add(new Vector(new double[] {0,1,0},3));
		vectors.add(new Vector(new double[] {0,0,0},3));
		vectors.add(new Vector(new double[] {1,0,0},3));
		Vector constants = new Vector(new double[] {1,0,1},1);

		String result = "";
		
		Vector resultV = Vector.Gauss_Jordan(vectors, 3, constants);
		
		System.out.println("====RESULT====");
		if(resultV != null) {
			for(double d : resultV.vector) 
				result += d + " ";
			System.out.println(result);
		}
		System.out.println("System is Inconsistent");*/
		
		ArrayList<Vector> vectors = new ArrayList<Vector>();
		vectors.add(new Vector(new double[] {0,1,0},3));
		vectors.add(new Vector(new double[] {0,0,0},3));
		vectors.add(new Vector(new double[] {1,0,0},3));
		
		Vector constants = new Vector(3);
		Vector.printVectors(vectors, constants);
		
		Vector.span(vectors, 3);
	}
}
