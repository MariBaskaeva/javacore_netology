import java.util.*;

class Main{
	public static void main(String[] args){
		int SIZE = 8;
  		int[][] colors = new int[SIZE][SIZE];
  		int[][] rotatedColors = new int[SIZE][SIZE];

  		Random random = new Random();
  		Scanner in = new Scanner(System.in);
  		//заполнение матрицы
  		for (int i = 0; i< SIZE; i++) {
    		for (int j = 0; j< SIZE; j++) {
      			colors[i][j] = random.nextInt(256);
    		}
  		}
  		//вывод исходной матрицы
  		for (int i = 0; i< SIZE; i++) {
    		for (int j = 0; j< SIZE; j++) {
      			System.out.format("%4d", colors[i][j]);
    		}
    		System.out.println();
  		}

  		System.out.println("Enter degrees of the rotation(90n): ");
  		int number = in.nextInt();

  		//вызов метода поворота матрицы на угол 90n
  		rotatedColors = rotateMatrix(colors, number);
  		//вывод результирующей матрицы
  		for (int i = 0; i< SIZE; i++) {
    		for (int j = 0; j< SIZE; j++) {
      			System.out.format("%4d", rotatedColors[i][j]);
    		}
    		System.out.println();
  		}
	}
	static int[][] rotateMatrix(int[][] matrix, int number){
		number = number / 90;
		while(number > 0){
			matrix = rotate(matrix);
			number--;
		}
		return matrix;
	}
	static int[][] rotate(int[][] matrix){
		int[][] result = new int[matrix.length][matrix[0].length];
		int a = 0, b;

		//транспонируем матрицу
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				result[j][i] = matrix[i][j];
			}
		}

		b = matrix.length - 1;
		while(a < b){
			//метод, меняющий столбцы местами
			reflect(result, a, b);
			a++;
			b--;
		}

		return result;
	}
	static void reflect(int[][] matrix, int a, int b){
		for(int i = 0; i < matrix[0].length; i++){
			int step = matrix[i][a];
			matrix[i][a] = matrix[i][b];
			matrix[i][b] = step;
		}
	}
}