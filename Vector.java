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
	
	public static int checkIfZeroVector(Vector v) {
		for(int i = 0; i < v.vector.length; i++) 
			if(v.vector[i] != 0)
				return i;
		return -1;
	}

	public static Vector Gauss_Jordan(ArrayList<Vector> vectors, int dimension, Vector constants) {
		Vector returnVector = constants;
		printVectors(vectors,constants);
		
		// Mismatch of vectors size and constants size
		if(vectors.size() != constants.vector.length) 
			return null;
		else if(vectors.size() != dimension) 
			returnVector = null;
		
		for(int i = 0; i < vectors.size(); i++) {
		
			// Mismatch of vectors size and given dimension
			if(vectors.get(i).vector.length != dimension) 
				return null;
			
			int leadIndex = checkIfZeroVector(vectors.get(i));
			int j = i + 1;
			
			while(leadIndex == -1) {
				
				if(j == vectors.size()) {
					returnVector = null;
					break;
				}
				
				leadIndex = checkIfZeroVector(vectors.get(j));
				
				if(leadIndex == -1) {
					returnVector = null;
					j++;
				}
				else if(leadIndex != -1)
					swapRow(vectors, constants, i, j);
				else 
					j++;
			}
			
			if(leadIndex != -1) {
				double leadNum, curNum;
				leadNum = vectors.get(i).vector[leadIndex];
				scaleRow(vectors, constants, 1.0/leadNum, i);
	
				for(j = i + 1; j < vectors.size(); j++) {
					curNum = vectors.get(j).vector[leadIndex];	
					if(curNum != 0) 
						addScaledRowToRow(vectors, constants, -1.0 * curNum, j, i);
				}
			}
			
			printVectors(vectors,constants);
		}
		
		for(int i = 0; i < vectors.size(); i++) 
			if(vectors.get(i).vector[i] != 1) 
				for(int j = i; j < vectors.size(); j++) 
					if(vectors.get(j).vector[i] == 1) {
						swapRow(vectors, constants, i, j);
						break;
					}
		
		for(int i = vectors.size() - 1; i >= 0 ; i--) {
			int leadIndex = checkIfZeroVector(vectors.get(i));
			if(leadIndex != -1) {
				for(int j = i - 1; j >= 0; j--) {
					double curNum = vectors.get(j).vector[leadIndex];	
					if(curNum != 0) 
						addScaledRowToRow(vectors, constants, -1.0 * curNum, j, i);
				}
			}
			
		}
		
		printVectors(vectors,constants);
		
		return returnVector;
	}
	
	public static int span(ArrayList<Vector> vectors, int dimension) {
		Vector constants = new Vector(vectors.size());
		Gauss_Jordan(vectors, dimension, constants);
		ArrayList<Integer> span = new ArrayList<Integer>();
		
		for(int i=0; i < vectors.size(); i++){
			span.add(0);
		}
		
		for(int i=0; i < vectors.size(); i++){
			for(int j=0; j < vectors.get(i).vector.length; j++){
				if(span.get(i) == 0 && vectors.get(i).vector[j] == 1)
					span.set(i, 1);
			}
		}
		
		int spanCount = 0;
		for(int i=0; i < vectors.size(); i++){
			if(span.get(i) == 1)
				spanCount++;
		}
		
		System.out.println("SPAN: " + spanCount);
		return spanCount;
	}
	
	
}
