package com.yacht.data;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.yacht.controller.BoatController;
import com.yacht.model.BoatModel;
;

@Service
public class BoatDataService implements DataAccessInterface<BoatModel>
{

	@Autowired 
	private BoatRepository boatRepository;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	Logger logger = LoggerFactory.getLogger((BoatDataService.class));
	{
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}
	
	@Override
	public BoatModel getById(int id) {
        logger.info("Entering BoatDataService.getById");
		return boatRepository.getById(id);

	}

	@Override
	public Iterable<BoatModel> getAll() {
		logger.info("Entering BoatDataService.getAll");

        ArrayList<BoatModel> boatModels = new ArrayList<BoatModel>();
        Iterable<BoatModel> boatModel = boatRepository.findAll();
        for (BoatModel boat : boatModel) {
        	boatModels.add(boat);
        }
        return boatModels;

	}

	@Override
	public BoatModel create(BoatModel item) {
		logger.info("Entering BoatDataService.create");
		boatRepository.create(item);
        return item;

	}

	@Override
	public BoatModel update(BoatModel item) {
		logger.info("Entering BoatDataService.update");
		boatRepository.update(item);
		return item;
	}

	@Override
	public boolean deleteById(int id) {
		logger.info("Entering BoatDataService.deleteById");
		boatRepository.deleteById(id);
        return true;

	}
	
}
