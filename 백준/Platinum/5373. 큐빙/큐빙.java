import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static char[][][] cube; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		cube = new char[6][3][3];
		
		
		n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int rotate = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int m=0;m<3;m++) {
				for(int n=0;n<3;n++) {
					cube[0][m][n] = 'w';
					cube[1][m][n] = 'r';
					cube[2][m][n] = 'y';
					cube[3][m][n] = 'o';
					cube[4][m][n] = 'g';
					cube[5][m][n] = 'b';
				}
			}
			for(int j=0;j<rotate;j++) {	
				String method = st.nextToken();
				char square = method.charAt(0);
				char clock = method.charAt(1);
				roll(square,clock);
			}
			printUp();
		}
		//윗면, 앞면, 아랫면, 뒷면, 왼쪽면, 오른쪽면 -> U F D B L R +시계 -반시계
		//윗면 : 흰색 아랫면: 노란색  앞면 : 빨간색  뒷면 오렌지  왼쪽면 초록  오른쪽면 파랑 
		
	}
	public static void roll(char sq, char cl) {
		//윗면, 앞면, 아랫면, 뒷면, 왼쪽면, 오른쪽면 -> U F D B L R +시계 -반시계
		if(sq == 'U') {
			if(cl=='+') {
				char[][] rocube = {{cube[0][2][0],cube[0][1][0],cube[0][0][0]},{cube[0][2][1],cube[0][1][1],cube[0][0][1]},{cube[0][2][2],cube[0][1][2],cube[0][0][2]}}; 
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						cube[0][i][j] = rocube[i][j];
					}
				}
				rollSide('+',new int[] {3,2,0},new int[] {3,2,1},new int[] {3,2,2},new int[] {5,0,2},new int[] {5,0,1},new int[] {5,0,0},new int[] {1,0,2},new int[] {1,0,1},new int[] {1,0,0},new int[] {4,0,2},new int[] {4,0,1},new int[] {4,0,0});
			}else {
				char[][] rocube = {{cube[0][0][2],cube[0][1][2],cube[0][2][2]},{cube[0][0][1],cube[0][1][1],cube[0][2][1]},{cube[0][0][0],cube[0][1][0],cube[0][2][0]}}; 
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						cube[0][i][j] = rocube[i][j];
					}
				}
				rollSide('-',new int[] {3,2,0},new int[] {3,2,1},new int[] {3,2,2},new int[] {5,0,2},new int[] {5,0,1},new int[] {5,0,0},new int[] {1,0,2},new int[] {1,0,1},new int[] {1,0,0},new int[] {4,0,2},new int[] {4,0,1},new int[] {4,0,0});
			}
		}else if(sq == 'F') {
			if(cl=='+') {
				char[][] rocube = {{cube[1][2][0],cube[1][1][0],cube[1][0][0]},{cube[1][2][1],cube[1][1][1],cube[1][0][1]},{cube[1][2][2],cube[1][1][2],cube[1][0][2]}}; 
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						cube[1][i][j] = rocube[i][j];
					}
				}
				rollSide('+',new int[] {0,2,0},new int[] {0,2,1},new int[] {0,2,2},new int[] {5,0,0},new int[] {5,1,0},new int[] {5,2,0},new int[] {2,0,2},new int[] {2,0,1},new int[] {2,0,0},new int[] {4,2,2},new int[] {4,1,2},new int[] {4,0,2});
			}else {
				char[][] rocube = {{cube[1][0][2],cube[1][1][2],cube[1][2][2]},{cube[1][0][1],cube[1][1][1],cube[1][2][1]},{cube[1][0][0],cube[1][1][0],cube[1][2][0]}}; 
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						cube[1][i][j] = rocube[i][j];
					}
				}
				rollSide('-',new int[] {0,2,0},new int[] {0,2,1},new int[] {0,2,2},new int[] {5,0,0},new int[] {5,1,0},new int[] {5,2,0},new int[] {2,0,2},new int[] {2,0,1},new int[] {2,0,0},new int[] {4,2,2},new int[] {4,1,2},new int[] {4,0,2});
			}
		}else if(sq == 'D') {
			if(cl=='+') {
				char[][] rocube = {{cube[2][2][0],cube[2][1][0],cube[2][0][0]},{cube[2][2][1],cube[2][1][1],cube[2][0][1]},{cube[2][2][2],cube[2][1][2],cube[2][0][2]}}; 
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						cube[2][i][j] = rocube[i][j];
					}
				}
				rollSide('+',new int[] {1,2,0},new int[] {1,2,1},new int[] {1,2,2},new int[] {5,2,0},new int[] {5,2,1},new int[] {5,2,2},new int[] {3,0,2},new int[] {3,0,1},new int[] {3,0,0},new int[] {4,2,0},new int[] {4,2,1},new int[] {4,2,2});
				
			}else {
				char[][] rocube = {{cube[2][0][2],cube[2][1][2],cube[2][2][2]},{cube[2][0][1],cube[2][1][1],cube[2][2][1]},{cube[2][0][0],cube[2][1][0],cube[2][2][0]}}; 
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						cube[2][i][j] = rocube[i][j];
					}
				}
				rollSide('-',new int[] {1,2,0},new int[] {1,2,1},new int[] {1,2,2},new int[] {5,2,0},new int[] {5,2,1},new int[] {5,2,2},new int[] {3,0,2},new int[] {3,0,1},new int[] {3,0,0},new int[] {4,2,0},new int[] {4,2,1},new int[] {4,2,2});
			}
		}else if(sq == 'B') {
			if(cl=='+') {
				char[][] rocube = {{cube[3][2][0],cube[3][1][0],cube[3][0][0]},{cube[3][2][1],cube[3][1][1],cube[3][0][1]},{cube[3][2][2],cube[3][1][2],cube[3][0][2]}}; 
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						cube[3][i][j] = rocube[i][j];
					}
				}
				rollSide('+',new int[] {2,2,0},new int[] {2,2,1},new int[] {2,2,2},new int[] {5,2,2},new int[] {5,1,2},new int[] {5,0,2},new int[] {0,0,2},new int[] {0,0,1},new int[] {0,0,0},new int[] {4,0,0},new int[] {4,1,0},new int[] {4,2,0});
			}else {
				char[][] rocube = {{cube[3][0][2],cube[3][1][2],cube[3][2][2]},{cube[3][0][1],cube[3][1][1],cube[3][2][1]},{cube[3][0][0],cube[3][1][0],cube[3][2][0]}}; 
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						cube[3][i][j] = rocube[i][j];
					}
				}
				rollSide('-',new int[] {2,2,0},new int[] {2,2,1},new int[] {2,2,2},new int[] {5,2,2},new int[] {5,1,2},new int[] {5,0,2},new int[] {0,0,2},new int[] {0,0,1},new int[] {0,0,0},new int[] {4,0,0},new int[] {4,1,0},new int[] {4,2,0});
			}
		}else if(sq == 'L') {
			if(cl=='+') {
				char[][] rocube = {{cube[4][2][0],cube[4][1][0],cube[4][0][0]},{cube[4][2][1],cube[4][1][1],cube[4][0][1]},{cube[4][2][2],cube[4][1][2],cube[4][0][2]}}; 
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						cube[4][i][j] = rocube[i][j];
					}
				}
				rollSide('+',new int[] {0,0,0},new int[] {0,1,0},new int[] {0,2,0},new int[] {1,0,0},new int[] {1,1,0},new int[] {1,2,0},new int[] {2,0,0},new int[] {2,1,0},new int[] {2,2,0},new int[] {3,0,0},new int[] {3,1,0},new int[] {3,2,0});
				
			}else {
				char[][] rocube = {{cube[4][0][2],cube[4][1][2],cube[4][2][2]},{cube[4][0][1],cube[4][1][1],cube[4][2][1]},{cube[4][0][0],cube[4][1][0],cube[4][2][0]}}; 
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						cube[4][i][j] = rocube[i][j];
					}
				}
				rollSide('-',new int[] {0,0,0},new int[] {0,1,0},new int[] {0,2,0},new int[] {1,0,0},new int[] {1,1,0},new int[] {1,2,0},new int[] {2,0,0},new int[] {2,1,0},new int[] {2,2,0},new int[] {3,0,0},new int[] {3,1,0},new int[] {3,2,0});
			}
		}else {
			//R
			if(cl=='+') {
				char[][] rocube = {{cube[5][2][0],cube[5][1][0],cube[5][0][0]},{cube[5][2][1],cube[5][1][1],cube[5][0][1]},{cube[5][2][2],cube[5][1][2],cube[5][0][2]}}; 
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						cube[5][i][j] = rocube[i][j];
					}
				}
				rollSide('+',new int[] {0,2,2},new int[] {0,1,2},new int[] {0,0,2},new int[] {3,2,2},new int[] {3,1,2},new int[] {3,0,2},new int[] {2,2,2},new int[] {2,1,2},new int[] {2,0,2},new int[] {1,2,2},new int[] {1,1,2},new int[] {1,0,2});
				
			}else {
				char[][] rocube = {{cube[5][0][2],cube[5][1][2],cube[5][2][2]},{cube[5][0][1],cube[5][1][1],cube[5][2][1]},{cube[5][0][0],cube[5][1][0],cube[5][2][0]}}; 
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						cube[5][i][j] = rocube[i][j];
					}
				}
				rollSide('-',new int[] {0,2,2},new int[] {0,1,2},new int[] {0,0,2},new int[] {3,2,2},new int[] {3,1,2},new int[] {3,0,2},new int[] {2,2,2},new int[] {2,1,2},new int[] {2,0,2},new int[] {1,2,2},new int[] {1,1,2},new int[] {1,0,2});
			}
		}
		
	}
	public static void rollSide(char clo,int[] a,int[] b, int[] c, int[] d, int[] e, int[] f,int[] g,int[] h, int[] i,int[] j, int[] k ,int[] l ) {
		if(clo=='+') {
			char temp = cube[a[0]][a[1]][a[2]];
			cube[a[0]][a[1]][a[2]] = cube[j[0]][j[1]][j[2]];
			cube[j[0]][j[1]][j[2]] = cube[g[0]][g[1]][g[2]];
			cube[g[0]][g[1]][g[2]] = cube[d[0]][d[1]][d[2]];
			cube[d[0]][d[1]][d[2]] = temp;
			temp = cube[b[0]][b[1]][b[2]];
			cube[b[0]][b[1]][b[2]] = cube[k[0]][k[1]][k[2]];
			cube[k[0]][k[1]][k[2]] = cube[h[0]][h[1]][h[2]];
			cube[h[0]][h[1]][h[2]] = cube[e[0]][e[1]][e[2]];
			cube[e[0]][e[1]][e[2]] = temp;
			temp = cube[c[0]][c[1]][c[2]];
			cube[c[0]][c[1]][c[2]] = cube[l[0]][l[1]][l[2]];
			cube[l[0]][l[1]][l[2]] = cube[i[0]][i[1]][i[2]];
			cube[i[0]][i[1]][i[2]] = cube[f[0]][f[1]][f[2]];
			cube[f[0]][f[1]][f[2]] = temp;
		}else {
			char temp = cube[a[0]][a[1]][a[2]];
			cube[a[0]][a[1]][a[2]] = cube[d[0]][d[1]][d[2]];
			cube[d[0]][d[1]][d[2]] = cube[g[0]][g[1]][g[2]];
			cube[g[0]][g[1]][g[2]] = cube[j[0]][j[1]][j[2]];
			cube[j[0]][j[1]][j[2]] = temp;
			temp = cube[b[0]][b[1]][b[2]];
			cube[b[0]][b[1]][b[2]] = cube[e[0]][e[1]][e[2]];
			cube[e[0]][e[1]][e[2]] = cube[h[0]][h[1]][h[2]];
			cube[h[0]][h[1]][h[2]] = cube[k[0]][k[1]][k[2]];
			cube[k[0]][k[1]][k[2]] = temp;
			temp = cube[c[0]][c[1]][c[2]];
			cube[c[0]][c[1]][c[2]] = cube[f[0]][f[1]][f[2]];
			cube[f[0]][f[1]][f[2]] = cube[i[0]][i[1]][i[2]];
			cube[i[0]][i[1]][i[2]] = cube[l[0]][l[1]][l[2]];
			cube[l[0]][l[1]][l[2]] = temp;
			//System.out.println(a+" "+b+" "+c+" "+d+" "+e+" "+f+" "+g+" "+h+" "+i+" "+j+" "+k+" "+l);
		}
				
	}
	public static void printUp() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(cube[0][i][j]);
			}
			System.out.println();
		}
	}
}
