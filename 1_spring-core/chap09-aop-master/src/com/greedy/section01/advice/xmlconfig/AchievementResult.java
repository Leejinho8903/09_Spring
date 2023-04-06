package com.greedy.section01.advice.xmlconfig;

public class AchievementResult {
	
	private int understandingScore;
	private int satisfactionScore;
	private double employeementRate;
	
	public AchievementResult(int understandingScore, int satisfactionScore, double employeementRate) {
		super();
		this.understandingScore = understandingScore;
		this.satisfactionScore = satisfactionScore;
		this.employeementRate = employeementRate;
	}

	public int getUnderstandingScore() {
		return understandingScore;
	}

	public void setUnderstandingScore(int understandingScore) {
		this.understandingScore = understandingScore;
	}

	public int getSatisfactionScore() {
		return satisfactionScore;
	}

	public void setSatisfactionScore(int satisfactionScore) {
		this.satisfactionScore = satisfactionScore;
	}

	public double getEmployeementRate() {
		return employeementRate;
	}

	public void setEmployeementRate(double employeementRate) {
		this.employeementRate = employeementRate;
	}

	@Override
	public String toString() {
		return "AchievementResult [understandingScore=" + understandingScore + ", satisfactionScore="
				+ satisfactionScore + ", employeementRate=" + employeementRate + "]";
	}
	
	

}
