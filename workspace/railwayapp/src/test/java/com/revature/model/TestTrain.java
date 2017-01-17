package com.revature.model;

public class TestTrain {

	public static void main(String[] args) {
		Train train=new Train();
		train.setNumber(123);
		train.setFromStation("thanjavur");
		train.setToStation("chennai");
		System.out.println(train);

	}

}
