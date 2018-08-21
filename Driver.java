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
		
		/*ArrayList<Vector> vectors = new ArrayList<Vector>();
		vectors.add(new Vector(new double[] {1,2,2,3},4));
		vectors.add(new Vector(new double[] {2,4,4,2},4));
		vectors.add(new Vector(new double[] {1,2,2,3},4));
		vectors.add(new Vector(new double[] {1,2,2,3},4));
		
		Vector c = new Vector(new double[] {2,3},2);
		
		Vector.printVectors(vectors, c);
		Vector resultV = Vector.Gauss_Jordan(vectors, 2, c);
		
		
		
		String result = "";
		System.out.println("====RESULT====");
		if(resultV != null) {
			for(double d : resultV.vector) 
				result += d + " ";
			System.out.println(result);
		}
		else
			System.out.println("System is Inconsistent");*/

		
		//Vector constants = new Vector(4);
		//Vector.printVectors(vectors, constants);
		
		//Vector.span(vectors, 3);*/
		ArrayList<Vector> vector1 = new ArrayList<Vector>();
		vector1.add(new Vector(new double[] {5,2,6,1}, 4));			// 5 0 3 1
		vector1.add(new Vector(new double[] {0,6,2,0}, 4));			// 2 6 8 8
		vector1.add(new Vector(new double[] {3,8,1,4}, 4));			// 6 2 1 5
		vector1.add(new Vector(new double[] {1,8,5,6}, 4));			// 1 0 4 6
		Matrix matrix1 = new Matrix(vector1,4);
		
		ArrayList<Vector> vector2 = new ArrayList<Vector>();
		vector2.add(new Vector(new double[] {7,5,8,0}, 4));			// 7 1 9 5
		vector2.add(new Vector(new double[] {1,8,2,6}, 4));			// 5 8 4 3
		vector2.add(new Vector(new double[] {9,4,3,8}, 4));			// 8 2 3 7
		vector2.add(new Vector(new double[] {5,3,7,9}, 4));			// 0 6 8 9
		Matrix matrix2 = new Matrix(vector2,4);
		
		matrix1.times(matrix2);
		//new Matrix(10);
//		ArrayList<Vector> vector1 = new ArrayList<Vector>();
//		vector1.add(new Vector(new double[] {1,3}, 2));
//		vector1.add(new Vector(new double[] {2,7}, 2));
//		vector1.add(new Vector(new double[] {1,2,3}, 3));
//		vector1.add(new Vector(new double[] {0,0,6}, 3));
//		vector1.add(new Vector(new double[] {2,2,3}, 3));
		
//		Matrix matrix1 = new Matrix(vector1,2);
//		
//		Matrix matrixr = matrix1.inverse();
//
//		if(matrixr == null) 
//			 System.out.println("matrix is not invertible");
//		else {
//			for(int i=0; i < matrixr.listMatrix.get(0).vector.length; i++){
//				for(int j=0; j < 2; j++){
//					System.out.print(matrixr.listMatrix.get(i).vector[j] + " ");
//				}
//				System.out.println(" ");
//			}
//		}
//		
	}
}
