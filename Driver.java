import java.util.ArrayList;

public class Driver {
	public static void main(String args[]) {
		
		
//		ArrayList<Vector> vectors = new ArrayList<Vector>();
//		vectors.add(new Vector(new double[] {1.0,1.0,2.0,0.0},4));
//		vectors.add(new Vector(new double[] {2.0,-1.0,0.0,1.0},4));
//		vectors.add(new Vector(new double[] {1.0,-1.0,-1.0,-2.0},4));
//		vectors.add(new Vector(new double[] {2.0,-1.0,2.0,-1.0},4));
//		
//		Vector c = new Vector(new double[] {1,-2,4,0},4);
//		
//		Vector resultV = Vector.Gauss_Jordan(vectors, 4, c);
		
		
		
//		ArrayList<Vector> vectors = new ArrayList<Vector>();
//		vectors.add(new Vector(new double[] {0,1,1},3));
//		vectors.add(new Vector(new double[] {1,1,0},3));
//		vectors.add(new Vector(new double[] {1,0,0},3));
//		
//		Vector c = new Vector(new double[] {0,0,0},3);
//		
//		Vector resultV = Vector.Gauss_Jordan(vectors, 3, c);
		
		ArrayList<Vector> vectors = new ArrayList<Vector>();
		vectors.add(new Vector(new double[] {1,2,-1,1},4));
		vectors.add(new Vector(new double[] {1,2,3,0},4));
		vectors.add(new Vector(new double[] {1,2,3,-2},4));
		
		Vector c = new Vector(new double[] {1,1,-1},3);
		
		Vector resultV = Vector.Gauss_Jordan(vectors, 4, c);
		
		
		
		String result = "";
		System.out.println("====RESULT====");
		if(resultV != null) {
			for(double d : resultV.vector) 
				result += d + " ";
			System.out.println(result);
		}
		else
			System.out.println("System is Inconsistent");

		
		Vector constants = new Vector(4);
		Vector.printVectors(vectors, constants);
		
		Vector.span(vectors, 3);
	}
}
