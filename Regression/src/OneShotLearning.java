import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

public class OneShotLearning {
	
	public static void main(String[] args) {
		YAKData.getURL("http://localhost:3306");
		System.out.println(YakSQLAccess.getYakData());


		float x1, x2, x3, x4, result;
		
		
		
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
		
	}

	
	
	
	public static float[][] transpose(float[][] mat){
		float[][] ret = mat;
		for(int i = 0; i < mat[0].length; i++) {
			for(int j = 0; j < mat.length; j++) {
				ret[i][j] = mat[j][i];
			}
		}
		return ret;
	}

	
	public static float[][] inverse(float[][] mat){
		float[][] ret = mat;
		
		return null;
	}

	public static float[][] multiply(float[][] mat1, float[][] mat2){
		int row1 = mat1[0].length;
		int col2 = mat2.length;
		int row2 = mat2[0].length;
		
		float[][] ret = new float[row1][col2];
		
		for(int i = 0; i < row1; i++) {
			for(int j = 0; j < col2; j++) {
				for(int z = 0; z < row2; z++) {
					float add = mat1[i][z] * mat2[z][j];
					ret[i][j] = ret[i][j] + add;
				}
			}
		}
		
		return ret;
	}



}


