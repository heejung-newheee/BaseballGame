package com.javalec.base;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		Java로 야구게임을 구현해 보겠다. 규칙은 아래와 같다.
//
//		1~9 사이의 중복되지 않는 3개의 정수를 생성한다.
//		사용자는 3개의 숫자를 입력한다.
//		생성된 3개의 숫자를 맞추는데 위치까지 정확히 맞춰야 한다.
//		숫자와 숫자의 위치까지 일치하면 strike 로 판정한다.
//		숫자는 맞지만 위치가 틀렸다면 ball 로 판정한다.
//		숫자3개가 모두 일치하지 않으면 out 으로 판정한다.
//		3 strike 가 되면 게임은 종료된다.
//		시도한 횟수를 표시한다.
//		계속할지 종료할지 여부를 물어보고 다음 진행을 한다.

		// 난수 생성
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		// 게임에서 사용할 변수
		int com1 = 0;
		int com2 = 0;
		int com3 = 0;
		int user1 = 0;
		int user2 = 0;
		int user3 = 0;
		
		int randomCount = 0; // 난수 생성 카운트
		int gameCount = 1; //게임 카운트 int gameCount = 0;
		int strikeCnt = 0;
		int ballCnt = 0;
				
		
		// 사용자 입력값 받기
		// 3개 난수 생성 - 중복값 없이
		while(true) {
			randomCount++;
			com1 = random.nextInt(100) % 9 +1;
			com2 = random.nextInt(100) % 9 +1;
			com3 = random.nextInt(100) % 9 +1;
			if(!(com1==com2 || com2==com3 || com3==com1)) {
				break;
			}
		}		
		
		for(int i=0; i<10; i++) {			
			// 난수 확인
			System.out.println("숫자 3개를 입력하세요.");
			user1 = scanner.nextInt();
			user2 = scanner.nextInt();
			user3 = scanner.nextInt();
			System.out.println((gameCount)+"회 게임 숫자 "+com1+","+com2+","+com3);
			
			// 게임 카운트 1회 증가
			gameCount++;
			
			// 판단 1 : 스트라이크 갯수 확인
			if(com1==user1) strikeCnt++;
			if(com2==user2) strikeCnt++;
			if(com3==user3) strikeCnt++;
			
			// 판단 2 : 볼 갯수 확인
			if(com1==user2 || com1==user3) ballCnt++;
			if(com2==user1 || com2==user3) ballCnt++;
			if(com3==user1 || com3==user2) ballCnt++;
			
			// 최종판단
			if(strikeCnt==3) {
				System.out.println("3 스트라이크 ! 게임종료 !");
				System.out.println("정답 : "+com1+","+com2+","+com3);
				break;
			}else {
				if(strikeCnt==0 && ballCnt==0) {
					System.out.println("3 아웃! 탈락 ");
					System.out.println("정답 : "+com1+","+com2+","+com3);
					break;
				}else {
					System.out.println(strikeCnt+"스트라이크"+ballCnt+"볼");
				}				
				strikeCnt = 0;
				ballCnt = 0;				
			}
			
			
			
		}
		
		
		
		
	}

}
