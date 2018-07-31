import java.util.ArrayList;

public class Driver {
	public static void main(String args[]) {
		
		ArrayList<Vector> vectors = new ArrayList<Vector>();
		vectors.add(new Vector(new double[] {0,2,1,-8},4));
		vectors.add(new Vector(new double[] {1,-2,-3,0},4));
		vectors.add(new Vector(new double[] {-1,1,2,3},4));
		
		/*
		Vector resultV = Vector.Gauss_Jordan(vectors, 4, new Vector(3));
		
		String result = "";
		System.out.println("====RESULT====");
		if(resultV != null) {
			for(double d : resultV.vector) 
				result += d + " ";
			System.out.println(result);
		}
		else
			System.out.println("System is Inconsistent");
		*/
		
		Vector constants = new Vector(3);
		Vector.printVectors(vectors, constants);
		
		Vector.span(vectors, 4);
		
	}
}
