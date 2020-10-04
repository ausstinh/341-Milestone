package src.com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import src.com.gcu.data.DatabaseException;
import src.com.gcu.data.UserDataService;
import src.com.gcu.model.Credentials;
import src.com.gcu.model.User;

public class UsersBusinessService {
      /**
     * Default constructor. 
     */
    public UsersBusinessService() {
    }

    UserDataService dataService = new UserDataService();
    
    /**
     * @throws DatabaseException 
     * @see UsersBusinessInterface#authenticateUser(User)
     */
    public User authenticateUser(Credentials login) throws DatabaseException {
        User loginUser = null;
        // loop to be able to run through the existing users 
        if(dataService.findBy(login) != null) 
        {
            loginUser = dataService.findBy(login);
        }
        return loginUser;
            
    }

    /**
     * going to make sure that two users can't be created with the same username
     * @see UsersBusinessInterface#authenticateRegistration(User)
     */
    public boolean authenticateRegistration(User register) {
        
        // loop to run through existing users
        List<User> userList = new ArrayList<User>();
        
        // Check to see if there is a list in the first place
        if(userList.size() != 0) {
            for (User users : dataService.findAll()) 
            {
                // if there is a user with the same username that someone is trying to create, registration will fail
                if(register.getUsername().equals(users.getUsername()))
                {
                    return false;
                }
            }
        }
        
        // add credentials that did not match with existing user to the list
//        dataService.create(register);
        return true;
    }
}