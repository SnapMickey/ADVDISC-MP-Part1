/*
 * BARRERA, Angelo Gabriel G.
 * RIVERA, Jared S.
 * SECUYA, Alfonso C.
 * ADVDISC S17
 */
import java.util.ArrayList;
import java.util.Arrays;


public class Matrix {
	public Vector[] matrix;
	public ArrayList<Vector> listMatrix;
	public final int rows, cols;
	//Default Constructor (Identity Matrix)
	public Matrix(int dimension){
		this.matrix = new Vector[dimension];
		this.listMatrix = new ArrayList<Vector>();
		this.rows = dimension;
		this.cols = dimension;
		
		for(int i=0; i < dimension; i++){
			this.matrix[i] = new Vector(dimension);
			this.listMatrix.add(new Vector(dimension));
		}
		
		for(int i=0; i < dimension; i++){
			this.matrix[i].vector[i] = 1;
			this.listMatrix.get(i).vector[i] = 1;
		}
		
		/*for(int i=0; i < dimension; i++){
			for(int j=0; j < dimension; j++){
				System.out.print(this.matrix[i].vector[j] + " ");
			}
			System.out.println(" ");
		}*/
		
		for(int i=0; i < dimension; i++){
			for(int j=0; j < dimension; j++){
				System.out.print(this.listMatrix.get(i).vector[j] + " ");
			}
			System.out.println(" ");
		}
	}
	//
	public Matrix(ArrayList<Vector> list, int dimension){
		this.matrix = new Vector[list.size()];
		this.listMatrix = new ArrayList<Vector>();
		this.rows = dimension;
		this.cols = list.get(0).vector.length;
		
		for(int i=0; i < list.size(); i++){
			this.matrix[i] = list.get(i);
			this.listMatrix.add(list.get(i));
		}
	}
	public Matrix times(Matrix other){
		if(this.cols == other.rows){
		ArrayList<Vector> vectors = new ArrayList<Vector>();
		for(int i=0; i < other.cols; i++){
			double[] vectorVal = new double[other.cols];
			Arrays.fill(vectorVal, 0);
			for(int j=0; j < this.rows; j++){
				for(int k=0; k < this.cols; k++){
					//vectorVal[j] += this.matrix[i].vector[k] * other.matrix[k].vector[j];
					vectorVal[j] += this.matrix[k].vector[j] * other.matrix[i].vector[k];
					System.out.println(i + " " + k);
					System.out.println("HERE: " + this.matrix[k].vector[j]);
					System.out.println("HERE: " + other.matrix[i].vector[k]);
					//System.out.println(this.matrix[k].vector[j] * other.matrix[i].vector[k]);
				}
				//System.out.println(vectorVal[0] + " " + vectorVal[1] + " " + vectorVal[2] + " " + vectorVal[3]);
			}
			//System.out.println(vectorVal[0] + " " + vectorVal[1] + " " + vectorVal[2] + " " + vectorVal[3]);
			vectors.add(new Vector(vectorVal, other.cols));
		}
		
		for(int i=0; i < vectors.size(); i++){
			for(int j=0; j < vectors.get(i).vector.length; j++){
				System.out.print(vectors.get(j).vector[i] + " ");
			}
			System.out.println(" ");
		}
		System.out.println(vectors.get(0).vector.length);
		
		return new Matrix(vectors, vectors.size());
		}
		return null;
	}

	public Double det(){
		ArrayList<Double>swapscale = Vector.Gauss_Jordan_Det(listMatrix,listMatrix.get(0).vector.length, new Vector(listMatrix.size()));
		try {
			if(swapscale.get(0) == 0 || swapscale.get(1) == 0)
				return (double) 0;
			return (double)swapscale.get(0)*(1/swapscale.get(1));
		} catch(Exception e) {
			return (Double) null;
		}
	}
	
	public Matrix inverse(){
		ArrayList<Vector> inverse = Vector.Gauss_Jordan_Inverse(listMatrix,listMatrix.get(0).vector.length, new Vector(listMatrix.size()));
		
		if(inverse == null)
			return null;
		else
			return new Matrix(inverse,listMatrix.get(0).vector.length);
	}
	
	public Matrix transpose() {
		ArrayList<Vector> temp = new ArrayList();
		
		for(int i = 0; i < rows; i++) {
			Vector nVec = new Vector(cols);
			
			for(int j = 0; j < cols; j++) 
				nVec.vector[j] = matrix[i].vector[j];

			temp.add(nVec);
		}
		
		return new Matrix(temp, rows);
	}
}
