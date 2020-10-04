package src.com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import src.com.gcu.model.Credentials;
import src.com.gcu.model.User;

public class UserDataService {
      /**
     * Default constructor. 
     */
    public UserDataService() {
        // TODO Auto-generated constructor stub
    }
    
    /*
     * Query the database and returns the Credentials model if it finds it. Returns null if a Credentials model is not found.
     */
    public User findBy(Credentials c) throws DatabaseException {
        
        // checks if query of Credentials match user input 
        if(c.getUsername().equals("admin") && c.getPassword().equals("root")) {
            
            // ******hard coded for now
            User user = new User();
            user.setUsername("admin");
            user.setPassword("root");
            // return found Credentials model
            return user;
        }
        else { 
            return null;
        }
    }
    
    /*
     * Query all of the Credential models from the database and return them as a list
     */
    public List<User> findAll() {
        List<User> usersList = new ArrayList<User>();
        User c1 = new User("Noah", "12345");
        User c2 = new User("Austin", "12345");
        User c3 = new User("Jevon", "12345");
        
        usersList.add(c1);
        usersList.add(c2);
        usersList.add(c3);
        
        return usersList;
    }

}