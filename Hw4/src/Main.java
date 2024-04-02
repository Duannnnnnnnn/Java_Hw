import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		double[][] mat = new double[N][N];
		double[] d_mat = new double[N];
		int row = 0;
		while (row < N) {
			for (int i = 0; i < N; i++) {
				mat[row][i] = scanner.nextDouble();
			}
			d_mat[row] = scanner.nextDouble();
			row++;
		}
		scanner.close();

		int solutionType = getSolutionType(mat, d_mat);
		if (solutionType == 1) {
			System.out.println("The system of linear equations has a unique solution.");
		} else if (solutionType == 2) {
			System.out.println("The system of linear equations has infinitely many solutions.");
		} else {
			System.out.println("The system of linear equations has no solution.");
		}
	}

	public static int getSolutionType(double[][] mat, double[] d_mat) {
		int N = mat.length;
		for (int i = 0; i < N; i++) {
			// 寻找主元
			int maxRow = i;
			for (int j = i + 1; j < N; j++) {
				if (Math.abs(mat[j][i]) > Math.abs(mat[maxRow][i])) {
					maxRow = j;
				}
			}
			// 将最大主元所在行交换至当前行
			double[] temp = mat[i];
			mat[i] = mat[maxRow];
			mat[maxRow] = temp;
			double dTemp = d_mat[i];
			d_mat[i] = d_mat[maxRow];
			d_mat[maxRow] = dTemp;

			// 检查主元是否为零
			if (Math.abs(mat[i][i]) < 1e-10) {
				// 检查是否有全零行但常数项不为零的情况
				for (int k = i + 1; k < N; k++) {
					if (Math.abs(d_mat[k]) >= 1e-10) {
						return 0; // 无解
					}
				}
				// 检查主元以下是否存在非零行
				boolean nonZeroRowFound = false;
				for (int k = i + 1; k < N; k++) {
					boolean allZero = true;
					for (int l = i; l < N; l++) {
						if (Math.abs(mat[k][l]) >= 1e-10) {
							allZero = false;
							break;
						}
					}
					if (!allZero) {
						nonZeroRowFound = true;
						break;
					}
				}
				if (nonZeroRowFound) {
					return 2; // 有无穷多解
				} else {
					return 0; // 无解
				}
			}

			// 将主元所在列的其他元素消为零
			for (int j = i + 1; j < N; j++) {
				double ratio = mat[j][i] / mat[i][i];
				for (int k = i; k < N; k++) {
					mat[j][k] -= ratio * mat[i][k];
				}
				d_mat[j] -= ratio * d_mat[i];
			}
		}

		// 检查是否有全零行但常数项不为零的情况
		for (int i = 0; i < N; i++) {
			boolean allZero = true;
			for (int j = 0; j < N; j++) {
				if (Math.abs(mat[i][j]) >= 1e-10) {
					allZero = false;
					break;
				}
			}
			if (allZero && Math.abs(d_mat[i]) >= 1e-10) {
				return 0; // 无解
			}
		}

		return 1; // 唯一解
	}
}
