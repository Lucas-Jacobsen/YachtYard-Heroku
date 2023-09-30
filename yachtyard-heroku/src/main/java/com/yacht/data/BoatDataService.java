package com.yacht.data;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.SystemPropertyUtils;

import com.yacht.model.BoatModel;
;

@Service
public class BoatDataService implements DataAccessInterface<BoatModel>
{

	@Autowired 
	private BoatRepository boatRepository;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public BoatDataService(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}
	
	@Override
	public BoatModel getById(int id) {
        
		return boatRepository.getById(id);

	}

	@Override
	public Iterable<BoatModel> getAll() {
        ArrayList<BoatModel> boatModels = new ArrayList<BoatModel>();
        Iterable<BoatModel> boatModel = boatRepository.findAll();
        for (BoatModel boat : boatModel) {
        	boatModels.add(boat);
        }
        return boatModels;

	}

	@Override
	public BoatModel create(BoatModel item) {
		boatRepository.create(item);
        return item;

	}

	@Override
	public BoatModel update(BoatModel item) {
		boatRepository.update(item);
		return item;
	}

	@Override
	public boolean deleteById(int id) {
		boatRepository.deleteById(id);
        return true;

	}
	
}
