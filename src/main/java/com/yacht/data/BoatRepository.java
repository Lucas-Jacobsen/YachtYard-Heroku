package com.yacht.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.yacht.model.BoatModel;



@Service
public class BoatRepository implements DataAccessInterface<BoatModel>{
	
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Non-Default constructor for injection
	 */
	public BoatRepository(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	
	public List<BoatModel> findAll() {
		
		String sql = "SELECT * FROM boats";
		List<BoatModel> boats = new ArrayList<BoatModel>();
		try
		{
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next())
			{
				boats.add(new BoatModel(srs.getInt("id"), srs.getString("brand"), srs.getString("model"), srs.getInt("length"), srs.getString("description"), srs.getBigDecimal("price"), srs.getString("img")));

			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return boats;
	}
	 
	public BoatModel getById(int id) {
		
		String sql = "SElECT * FROM boats WHERE id LIKE " + id;
		BoatModel boat = new BoatModel();

		try
		{
			SqlRowSet  srs =jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next())
			{
				boat = (new BoatModel(srs.getInt("id"), srs.getString("brand"), srs.getString("model"), srs.getInt("length"), srs.getString("description"), srs.getBigDecimal("price"), srs.getString("img")));
			} 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return boat;
	}


	@Override
	public BoatModel create(BoatModel boat)
	{
		String sql = String.format("INSERT INTO boats(`brand`, `model`, `length`, `description`, `price`, `img`) VALUES ('%s','%s',%d,'%s',%f, '%s')", boat.getBrand(), boat.getModel(), boat.getLength(), boat.getDescription(), boat.getPrice(), boat.getImg());

		BoatModel newBoat = new BoatModel();
		try
		{
			jdbcTemplateObject.execute(sql);
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		
		
		return newBoat;
	}

	@Override
	public BoatModel update(BoatModel item) {
		
		String sql = String.format("UPDATE boats SET `brand`='%s',`model`='%s',`length` = %d,`description`='%s',`price`=%f , `img`='%s' WHERE `id` = " + item.getId(), item.getBrand(), item.getModel(), item.getLength(), item.getDescription(), item.getPrice(),item.getImg());
		try
		{
			jdbcTemplateObject.execute(sql);
			
		}
		catch(Exception e )
		{
			e.printStackTrace();
			
		}
		return item;
	}

	@Override
	public boolean deleteById(int id) {
		String sql = "Delete FROM `boats` WHERE `id` = " + id;
		try
		{
			jdbcTemplateObject.execute(sql);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}


	@Override
	public Iterable<BoatModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

 

}
