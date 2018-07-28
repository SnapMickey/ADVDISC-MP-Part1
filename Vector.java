import java.util.ArrayList;

public class Vector {
	public double[] vector;
	public final int dimension;
	
	public Vector(int dimension) {
		this.dimension = dimension;
		this.vector = new double[dimension];
		
		// initialize as zero vector
		for(int i = 0; i < dimension; i++) 
			vector[i] = 0;

	}
	
	public Vector(double[] array, int dimension) {
		this.vector = array;
		this.dimension = dimension;
	}
	
	public Vector scale(double scalar) {
		for(int i = 0; i < dimension; i++)
			vector[i] *= scalar;
		return this;
	}
	
	public Vector add(Vector addend) {
		if(dimension != addend.dimension) {
			System.out.println("Error: dimensions do not match");
			return this;
		}
		for(int i = 0; i < dimension; i++)
			vector[i] += addend.vector[i];
		
		return this;
	}
	
	// Row Operations
	
	private static void swapRow(ArrayList<Vector> vectors, Vector constants, int i, int j) {
		Vector temp = vectors.get(i);
		vectors.set(i, vectors.get(j));
		vectors.set(j, temp);
		
		double tempc = constants.vector[i];
		constants.vector[i] = constants.vector[j];
		constants.vector[j] = tempc;
	}
	
	private static void scaleRow(ArrayList<Vector> vectors, Vector constants, double scalar, int row) {
		Vector rowVector = vectors.get(row);
		rowVector.scale(scalar);
		constants.vector[row] *= scalar;
	}
	
	private static void addScaledRowToRow(ArrayList<Vector> vectors, Vector constants, 
								   double scalar, int targetRow, int addendRow) {
		Vector targetRowVector = vectors.get(targetRow);
		Vector addendRowVector = vectors.get(addendRow);
		Vector scaledAddendVector = new Vector(addendRowVector.vector.clone(), addendRowVector.dimension);
		scaledAddendVector.scale(scalar);
		targetRowVector.add(scaledAddendVector);
		
		constants.vector[targetRow] += constants.vector[addendRow] * scalar;
	}
	
	public static void printVectors(ArrayList<Vector> vectors, Vector constants) {
		for(int i = 0; i < vectors.size(); i++) {
			String vector = "";
			for(double d : vectors.get(i).vector)
				vector += d + " ";
			
			System.out.println(vector + "|" + constants.vector[i]);
		}
		System.out.println("\n");
	}
	
	public static Vector Gauss_Jordan(ArrayList<Vector> vectors, int dimension, Vector constants) {
		Vector returnVector = constants;
		printVectors(vectors,constants);
		// Mismatch of vectors size and constants size
		if(vectors.size() != constants.vector.length) 
			return null;
		
		for(int i = 0; i < vectors.size(); i++) {
			
			// Mismatch of vectors size and given dimension
			if(vectors.get(i).vector.length != dimension) 
				return null;
			
			int k = i;
			int j = 0;
			while(vectors.get(i).vector[j] == 0) {
				if(k == vectors.size() || i == vectors.size() - 1) {
					returnVector = null;
					return returnVector;
				}
				
				if(j == vectors.get(i).vector.length) {
					swapRow(vectors, constants, i, k);
					returnVector = null;
					k++;
				}
				else {
					j = 0;
					j++;
				}
			}			
			
			double leadNum = vectors.get(i).vector[j];
			scaleRow(vectors, constants, 1/leadNum, i);
			
			for(int h = 0; h < vectors.size(); h++) {
				double curNum = vectors.get(h).vector[j];
				if(h != i && curNum != 0) 
					addScaledRowToRow(vectors, constants, -1 * curNum, h, i);
			}
			
			printVectors(vectors,constants);
		}
		
		for(int i = 0; i < vectors.size(); i++) 
			if(vectors.get(i).vector[i] != 1) 
				for(int j = i; j <  vectors.size(); j++) 
					if(vectors.get(j).vector[i] == 1) 
						swapRow(vectors, constants, i, j);
		
		printVectors(vectors,constants);
		
		return constants;
	}
	
	public static int span(ArrayList<Vector> vectors, int dimension) {
		
		
		return 0;
	}
	
	
}
