package com.yacht.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.yacht.model.BoatModel;
import com.yacht.model.UserModel;

@Service
public class UserRepository implements DataAccessInterface<UserModel> {

    @Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Non-Default constructor for injection
	 */
	public UserRepository(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
    @Override
    public UserModel getById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public Iterable<UserModel> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public UserModel create(UserModel item) {
       String sql = String.format("INSERT INTO users( `username`, `password`, `role`, `enabled`) VALUES ('%s','%s','%s','%d')", item.getUsername(), item.getPassword(), "ROLE_USER", 1);

		UserModel newUser = new UserModel();
		try
		{
			jdbcTemplateObject.execute(sql);
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		
		
		return newUser;
    }

    @Override
    public UserModel update(UserModel item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean deleteById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
    
}
