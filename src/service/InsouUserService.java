package service;


import java.util.HashMap;



import entity.InsouManager;
import entity.InsouUser;

public interface InsouUserService {
	int verifyUser(String username,String password);
	int addUser(InsouUser newUser);
	boolean deleteUser(String username) ;
	boolean findUser(InsouUser user) ;
	int editUser(InsouUser user);
	InsouUser getUser(String username);
	HashMap getUserList();
	HashMap getsearchUserList(String str,String k );
}
