import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int[] one;
	static int[] two;
	static int[] three;
	static int[] four;
	static int K;
	
	public static void main(String[] args) throws IOException {
		//N극:0 S극:1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String oneString = br.readLine();
		String twoString = br.readLine();
		String threeString = br.readLine();
		String fourString = br.readLine();
		
		one = new int[8];
		two = new int[8];
		three = new int[8];
		four = new int[8];
		
		for(int i=0;i<8;i++) {
			one[i] = oneString.charAt(i)-'0';
			two[i] = twoString.charAt(i)-'0';
			three[i] = threeString.charAt(i)-'0';
			four[i] = fourString.charAt(i)-'0';
		}
		
		K = Integer.parseInt(br.readLine());
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			rotate(num,dir);
		}
		int ans =0;
		if(one[0]==1) {
			ans+=1;
		}
		if(two[0]==1) {
			ans+=2;
		}
		if(three[0]==1) {
			ans+=4;
		}
		if(four[0]==1) {
			ans+=8;
		}
		
		bw.write(ans+"\n");
		bw.flush();
		
	}
	public static void rotate(int num, int direc) {
		//1시계 clock , -1 nonClock 
		//S는 1: N은 0 
		if(num==1) {
			//1의 3시와 2의 9시가 같은 경우
			if(one[2]==two[6]) {
				//1만 바뀜
				if(direc == 1) {
					clockWise(one);
				}else {
					nonClockWise(one);
				}
			}else {
				//2시 3시 같은 경우 
				if(two[2]==three[6]) {
					//1,2 만 돌아감
					if(direc == 1) {
						clockWise(one);
						nonClockWise(two);
					}else {
						nonClockWise(one);
						clockWise(two);
					}
				}else {
					if(three[2]==four[6]) {
						//1,2,3 돌아감
						if(direc == 1) {
							clockWise(one);
							nonClockWise(two);
							clockWise(three);
						}else {
							nonClockWise(one);
							clockWise(two);
							nonClockWise(three);
						}
					}else {
						//1,2,3,4 돌아감
						if(direc == 1) {
							clockWise(one);
							nonClockWise(two);
							clockWise(three);
							nonClockWise(four);
						}else {
							nonClockWise(one);
							clockWise(two);
							nonClockWise(three);
							clockWise(four);
						}
					}
				}
					
			}
		}else if(num==2) {
			if(two[2]==three[6] && one[2] == two[6]) {
				//2번만 돌리기
				if(direc == 1) {
					clockWise(two);
				}else {
					nonClockWise(two);
				}
			}else if(two[2]!=three[6] && one[2] == two[6]) {
				if(three[2]==four[6]) {
					//2,3 돌리기
					if(direc == 1) {
						clockWise(two);
						nonClockWise(three);
					}else {
						nonClockWise(two);
						clockWise(three);
					}
				}else {
					//2,3,4 돌리기
					if(direc == 1) {
						clockWise(two);
						nonClockWise(three);
						clockWise(four);
					}else {
						nonClockWise(two);
						clockWise(three);
						nonClockWise(four);
					}
				}
			}else if(two[2]==three[6] && one[2] != two[6]) {
				//1,2 돌리기
				if(direc == 1) {
					clockWise(two);
					nonClockWise(one);
				}else {
					nonClockWise(two);
					clockWise(one);
				}
			}else {
				if(three[2]==four[6]) {
					//1,2,3 돌리기
					if(direc == 1) {
						clockWise(two);
						nonClockWise(one);
						nonClockWise(three);
					}else {
						nonClockWise(two);
						clockWise(one);
						clockWise(three);
					}
				}else {
					//1,2,3,4
					if(direc == 1) {
						clockWise(two);
						nonClockWise(one);
						nonClockWise(three);
						clockWise(four);
					}else {
						nonClockWise(two);
						clockWise(one);
						clockWise(three);
						nonClockWise(four);
					}
				}
			}
		}else if(num==3) {
			if(three[2]==four[6] && three[6]==two[2]) {
				//3번 만 돌리기
				if(direc == 1) {
					clockWise(three);
				}else {
					nonClockWise(three);
				}
			}else if(three[2]!=four[6] && three[6]==two[2]) {
				//3,4 번 돌리기
				if(direc == 1) {
					clockWise(three);
					nonClockWise(four);
				}else {
					nonClockWise(three);
					clockWise(four);
				}
			}else if(three[2]==four[6] && three[6]!=two[2]) {
				if(two[6]==one[2]) {
					//2,3 돌리기
					if(direc == 1) {
						clockWise(three);
						nonClockWise(two);
					}else {
						nonClockWise(three);
						clockWise(two);
					}
				}else {
					//1,2,3 돌리기
					if(direc == 1) {
						clockWise(three);
						nonClockWise(two);
						clockWise(one);
					}else {
						nonClockWise(three);
						clockWise(two);
						nonClockWise(one);
					}
				}
			}else {
				if(two[6]==one[2]) {
					//2,3,4 돌리기
					if(direc == 1) {
						clockWise(three);
						nonClockWise(two);
						nonClockWise(four);
					}else {
						nonClockWise(three);
						clockWise(two);
						clockWise(four);
					}
				}else {
					//1,2,3,4 돌리기
					if(direc == 1) {
						clockWise(three);
						nonClockWise(two);
						clockWise(one);
						nonClockWise(four);
					}else {
						nonClockWise(three);
						clockWise(two);
						nonClockWise(one);
						clockWise(four);
					}
				}
			}
			
		}else {
			if(four[6]==three[2]) {
				//4번만
				if(direc == 1) {
					clockWise(four);
				}else {
					nonClockWise(four);
				}
			}else {
				if(three[6]==two[2]) {
					//3,4번만
					if(direc == 1) {
						clockWise(four);
						nonClockWise(three);
					}else {
						nonClockWise(four);
						clockWise(three);
					}
				}else {
					if(two[6]==one[2]) {
						//2,3,4번만
						if(direc == 1) {
							clockWise(four);
							nonClockWise(three);
							clockWise(two);
						}else {
							nonClockWise(four);
							clockWise(three);
							nonClockWise(two);
						}
					}else {
						//다
						if(direc == 1) {
							clockWise(four);
							nonClockWise(three);
							clockWise(two);
							nonClockWise(one);
						}else {
							nonClockWise(four);
							clockWise(three);
							nonClockWise(two);
							clockWise(one);
						}
					}
				}
			}
		}
	
	}
	public static void clockWise(int[] arr) {
		int temp = arr[7];
		arr[7] = arr[6];
		arr[6] = arr[5];
		arr[5] = arr[4];
		arr[4] = arr[3];
		arr[3] = arr[2];
		arr[2] = arr[1];
		arr[1] = arr[0];
		arr[0] = temp;
	}
	public static void nonClockWise(int[] arr) {
		int temp = arr[0];
		arr[0] = arr[1];
		arr[1] = arr[2];
		arr[2] = arr[3];
		arr[3] = arr[4];
		arr[4] = arr[5];
		arr[5] = arr[6];
		arr[6] = arr[7];
		arr[7] = temp;
	}
}