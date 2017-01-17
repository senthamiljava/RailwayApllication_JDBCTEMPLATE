package com.revature.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import com.revature.model.Train;
import com.revature.util.ConnectionUtil;

public class TrainDAO {
	
JdbcTemplate jdbcTemplate=ConnectionUtil.getjdbcTemplate();
public void add(Train train)
{
String sql="insert into train(number,from_station,to_station) values(?,?,?)";
Object[] params={train.getNumber(),train.getFromStation(),train.getToStation()};
int row=jdbcTemplate.update(sql,params);
System.out.println("number of row inserted "+row);
}
public void remove(Integer trainNumber)
{
String sql="delete from train where number=?";
int row=jdbcTemplate.update(sql,trainNumber);
System.out.println("number of row deleted "+row);
}
public List<Train> list() {
	String sql = "select number,from_station,to_station from train";
	List<Train> list = jdbcTemplate.query(sql, (rse, rows) -> {
		Train train = convert(rse);
		return train;
	});
	return list;
}

public List<Train> getByTrainNumber(Integer trainNumber)
{
	String sql="select number,from_station,to_station from train where number=?";
	Integer[] params={trainNumber};
	List<Train> list=jdbcTemplate.query(sql,params,(rse,rows)->
	{
		Train train=convert(rse);
		return train;
	});
	return list;
}

private Train convert(ResultSet rse) throws SQLException {

	Train train = new Train();
	train.setNumber(rse.getInt("number"));
	train.setFromStation(rse.getString("from_station"));
	train.setToStation(rse.getString("to_station"));
	return train;
}
}
