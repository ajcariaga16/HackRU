


public class OneShotLearning {
	
	public static void main(String[] args) {
		/*
		
		float x1, x2, x3, x4, result; 
		
		float[][] databaseMatrix = getYakData();
		
		int count = 0;
		float matrixMen
		
		for(int i = 0; i < databaseMatrix.length; i++) {
			if(databaseMatrix[i][0] == 1) {
				for(int j = 0; j < databaseMatrix[0].length; j++) {
					
				}
			}
		}
		
		*/
		
		
		
		if(x1 == 1) { //CALL ROHIT FOR MEN
		
			float[][] matrixX = null; 
			//CALL ROHIT'S CLASS TO PULL FROM SQL, IDK HOW YET
			//matrix X is matrix of parameters
			
			float[][] matrixY = null;
			//CALL ROHIT'S CLASS AGAIN 
			//matrix Y is column vector of solutions
			
			float[][] matrixW = null;
			//CALL ROHIT'S CLASS LAST TIME
			//matrix w is column vector of weights.
			
			// W = (XT * X)^-1 * XT * Y
		}
		
		else { //CALL ROHIT FOR WOMEN
			
			float[][] matrixX; 
			//CALL ROHIT'S CLASS TO PULL FROM SQL, IDK HOW YET
			//matrix X is matrix of parameters
			
			float[][] matrixY;
			//CALL ROHIT'S CLASS AGAIN 
			//matrix Y is column vector of solutions
			
			float[][] matrixW;
			//CALL ROHIT'S CLASS LAST TIME
			//matrix w is column vector of weights.
			
			// W = (XT * X)^-1 * XT * Y			
		}
	
		 int x1, x2, x3;
		float result = 0;
		x1 = 10;
		x2 = 120;
		x3 = 2;
		
		float[][] matrixX = {
				{1, 5, 130, 4},
				{1, 7, 140, 7},
				{1, 8, 150, 8},
				{1, 5, 160, 10},
				{1, 4, 120, 4},
				{1, 9, 170, 8},
				{1, 1, 175, 4},
				{1, 1, 170, 3},
		};
		
		float[][] matrixY = {
				{9},
				{10},
				{12},
				{15},
				{5},
				{23},
				{8},
				{5}
		}; 
		float[][] matrixW;
		
		float[][] XT = transpose(matrixX);
		//XT is transpose of X
				
		float[][] temp = multiply(XT, matrixX);
		
		temp = inverse(temp);
		
		temp = multiply(temp, XT);
		matrixW = multiply(temp, matrixY);
		
		float w0, w1, w2, w3;
				
		w0 = matrixW[0][0];
		w1 = matrixW[1][0];
		w2 = matrixW[2][0];
		w3 = matrixW[3][0];

		//get parameters from AJ
	
		result = w0 + (w1*x1) + (w2*x2) + (w3*x3);
		
		//send result back to aj
		System.out.println(result);
		
		
	}

	
	
	
	public static float[][] transpose(float[][] mat){
		float[][] ret = new float[mat[0].length][mat.length];
		
		 int m = mat.length;
		 int n = mat[0].length;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				ret[i][j] = mat[j][i];
			}
		}

		
		return ret;
	}

	

	public static float[][] inverse(float[][] matrix) {
		float[][] inverse = new float[matrix.length][matrix.length];

		// minors and cofactors
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++)
				inverse[i][j] = (float) (Math.pow(-1, i + j) * determinant(minor(matrix, i, j)));

		// adjugate and determinant
		float det = (float) (1.0 / determinant(matrix));
		for (int i = 0; i < inverse.length; i++) {
			for (int j = 0; j <= i; j++) {
				double temp = inverse[i][j];
				inverse[i][j] = inverse[j][i] * det;
				inverse[j][i] = (float) (temp * det);
			}
		}

		return inverse;
	}
	
	
	public static float[][] minor(float[][] matrix, int row, int column) {
		float[][] minor = new float[matrix.length - 1][matrix.length - 1];

		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; i != row && j < matrix[i].length; j++)
				if (j != column)
					minor[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
		return minor;
	}
	
	public static float determinant(float[][] matrix) {
		if (matrix.length != matrix[0].length)
			throw new IllegalStateException("invalid dimensions");

		if (matrix.length == 2)
			return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

		float det = 0;
		for (int i = 0; i < matrix[0].length; i++)
			det += Math.pow(-1, i) * matrix[0][i]
					* determinant(minor(matrix, 0, i));
		return det;
	}


	public static float[][] multiply(float[][] mat1, float[][] mat2){
		int row1 = mat1.length;
		int col2 = mat2[0].length;
		int row2 = mat2.length;
		int col1 = mat1[0].length;
		
		float[][] ret = new float[row1][col2];
		
		for(int i = 0; i < row1; i++) {
			for(int j = 0; j < col2; j++) {
				ret[i][j] = 0;
				for(int z = 0; z < row2; z++) {
					float add = mat1[i][z] * mat2[z][j];
					ret[i][j] = ret[i][j] + add;
				}
			}
		}
		
		return ret;
	}



}


