import java.util.ArrayList;

public class Driver {
	public static void main(String args[]) {
		
		ArrayList<Vector> vectors = new ArrayList<Vector>();
		vectors.add(new Vector(new double[] {0,4,1},3));
		vectors.add(new Vector(new double[] {2,6,-2},3));
		vectors.add(new Vector(new double[] {4,8,-5},3));
		Vector constants = new Vector(new double[] {2,3,4},1);

		String result = "";
		
		Vector resultV = Vector.Gauss_Jordan(vectors, 3, constants);
		
		System.out.println("====RESULT====");
		if(resultV != null) {
			for(double d : resultV.vector) 
				result += d + " ";
			System.out.println(result);
		}
		System.out.println("System is Inconsistent");
	}
}
