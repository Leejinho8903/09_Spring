package com.greedy.section01.advice.xmlconfig;

public class NormalStudent implements Student {

	@Override
	public AchievementResult study(Passion passion) throws Exception {
		
		if(passion.getScore() <= 0) {
			throw new Exception("열정이 부족합니다! 다시 열정을 가지고 오세요!");
		}
		
		int understandingScore = 0;
		int satisfactionScore = 0;
		double employeementRate = 0.0;
		
		int passionScore = passion.getScore();
		
		int difficulty = 5;
		
		for(int i = 1; i <= 8; i++) {
			System.out.println(i + "교시 수업을 열심히 듣습니다. 오~ 프로그래밍이 뭔지 알 것 같습니다!");
			System.out.println("이해도와 만족도가 열정에 비례하여 자꾸 올라갑니다.");
			understandingScore += difficulty + passionScore;
			satisfactionScore += difficulty + passionScore;
			
			System.out.println("하지만 신기하게 취업률을 오르지 않습니다. 취업난이 심각한가 봅니다.");
			employeementRate += difficulty + passionScore;
			
			if(i == 4) {
				System.out.println("밥을 먹습니다. 오늘 저녁에는 뭘 하고 놀아볼까?ㅎㅎㅎ");
				System.out.println("자바 따윈 잊어버려~~~");
				
				understandingScore /= 2;
				satisfactionScore *= 2;
				employeementRate /= 2;
			}
		}
		
		
		return new AchievementResult(understandingScore, satisfactionScore, employeementRate);
	}

	
	
	
	
	
	
	
	
	
}
