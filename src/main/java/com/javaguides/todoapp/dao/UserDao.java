package com.javaguides.todoapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.javaguides.todoapp.model.User;
import com.javaguides.todoapp.utils.JDBCUtils;

public class UserDao {
	
	public int registerEmployee(User employee) throws ClassNotFoundException {
		String INSERT_MEMBERS_SQL = "INSERT INTO members" + "  (first_name, last_name, username, password) VALUES " +
	        " (?, ?, ?, ?);";
		System.out.println(INSERT_MEMBERS_SQL);
		int result = 0;
        // try-with-resource statement will auto close the connection.
        try (Connection connection = JDBCUtils.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MEMBERS_SQL)) {
        	// Step 2:Create a statement using connection object
        	preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getUsername());
            preparedStatement.setString(4, employee.getPassword());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result =  preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	JDBCUtils.printSQLException(e);
        }
		
		return result;		
	}
	
	

}
