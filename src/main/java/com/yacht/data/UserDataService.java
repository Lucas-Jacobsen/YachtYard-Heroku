package com.yacht.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yacht.model.UserModel;

@Service
public class UserDataService  implements DataAccessInterface<UserModel>{

@Autowired 
	private UserRepository userRepository; 
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

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
        // BC crypt new password 
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String newPass = passwordEncoder.encode(item.getPassword());
        UserModel newUser = new UserModel(item.getId(), item.getUsername(), newPass, item.getRole(), item.getEnabled() );

        
        System.out.printf("newUser: id: %d\nusername: %s\npassword: %s\nrole: %s\nEnables: %d" ,item.getId(), item.getUsername(), item.getPassword(), item.getRole(), item.getEnabled());
        userRepository.create(newUser);
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
