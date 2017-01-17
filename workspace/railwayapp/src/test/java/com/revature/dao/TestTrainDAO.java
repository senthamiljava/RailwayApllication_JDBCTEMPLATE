package com.revature.dao;

import java.util.List;

import com.revature.model.Train;

public class TestTrainDAO {

	public static void main(String[] args) {
		Train train=new Train();
		train.setNumber(345);
		train.setFromStation("chennai");
		train.setToStation("thanjavur");
		TrainDAO trainDao=new TrainDAO();
//		trainDao.add(train);
		List<Train> list=trainDao.getByTrainNumber(345);
        for(Train tr:list)
        {
        	System.out.println(tr);
        }
//	}
//		trainDao.remove(345);

}
}
