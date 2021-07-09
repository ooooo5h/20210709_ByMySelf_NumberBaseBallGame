package codes;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {

//		숫자야구게임 = 3자리 숫자를 만들거야
		int[] questionNumbers = new int[3];

//		3자리 숫자를 다 구할 때 까지 반복을 돌리자 = 끝이 정해져있으니 for반복문
		for (int i = 0; i < questionNumbers.length; i++) {
			 
//			조건 1 : 1~9 사이의 숫자
//			조건 2 : 숫자가 중복되면 안됨
//			조건1,2 둘다 충족될 때 까지 반복문을 돌려서 3자리 숫자를 만들꺼임
//			어떻게 뽑아? 숫자는 랜덤으로 출제
			while (true) {
				
//				조건 1
				int randomNum = (int)(Math.random()*9+1);
				
//				조건 2 
				boolean isDupOk = true;
				
//				questionNumbers에 담긴 num이 randomNum이랑 일치하면 중복!
				for(int num : questionNumbers) {
					if(num == randomNum) {
						isDupOk = false;
						break;
					}		
				}
				
//				중복검사결과가 true로 유지되면, 그 떄 그 randomNum을 questionNumbers에 담아주자
				if(isDupOk) {
					questionNumbers[i] = randomNum;
					break;
				}
			}
		}
		
//		사용자가 정답을 맞추기 위해서, 스캐너로 3자리 정수를 입력받자
//		입력한 숫자 = 랜덤숫자?를 하기 위해서는, 스캐너로 입력받은 숫자도 배열을 만들어야겠네
//		숫자는 같고 자리는 틀림 = B / 숫자도 같고 자리도 같음 = S
//		3S면 게임 종료 + 몇번만에 맞추셨습니다
//		3S가 아니면 ?S?B입니다 출력
		
		Scanner myScan = new Scanner(System.in);
		
		int tryCount = 0;

//		정답을 언제 맞출지 모르니.. while true
		while(true) {
			
			System.out.print("3자리 숫자를 입력하세요 : ");
			int inputNum = myScan.nextInt();
			
			tryCount++;
			
			int[] inputNumbers = new int[3];
			
			inputNumbers[0] = inputNum / 100;
			inputNumbers[1] = inputNum / 10 % 10;
			inputNumbers[2] = inputNum % 10;
			
			int strikeCount = 0;
			int ballCount = 0;
			
//			랜덤숫자[r1,r2,r3] vs 내가 입력한 숫자 [i1,i2,i3]를 비교하려면
//			i1 == r1? -> i1 == r2? -> i1 == r3? : 바쁜 반복 = j
//			i1 -> i2 -> i3 : 덜 바쁜 반복 = i
			for(int i = 0 ; i < inputNumbers.length; i++) {
				for(int j = 0; j < questionNumbers.length; j++) {
					
//					입력한 숫자와 랜덤숫자가 같다면
//					자리도 같아? => S
//					자리는 안같아? => B
					if(inputNumbers[i] == questionNumbers[j]){
						if(i==j) {
							strikeCount++;
						}
						else {
							ballCount++;
						}
					}
				}
			}
		
			System.out.println(strikeCount + "S" + ballCount + "B입니다.");
//			3S라면 게임종료 축하합니다 메세지 + 몇번만에 맞추셨나요
			if(strikeCount == 3) {
				System.out.println("축하합니다. 정답입니다.");
				System.out.println(tryCount + "번만에 맞추셨습니다.");
				break;
			}
	
		}

	}

}
