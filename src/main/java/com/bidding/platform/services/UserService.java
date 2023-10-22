package com.bidding.platform.services;

import com.bidding.platform.models.User;
import com.bidding.platform.objects.UserObject;

import java.util.HashMap;
import java.util.List;

public interface UserService {
     HashMap saveUser(UserObject userObject);
     HashMap loginUser(UserObject userObject);
     List<User> findAllUsers();
     User getSingleUser(long id);

}
