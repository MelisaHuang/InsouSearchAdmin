package service;

import java.util.ArrayList;
import java.util.HashMap;

import entity.InsouManager;
import entity.InsouUser;


public interface InsouManagerService{
	int verifyManager(String managername,String password);
	int addManager(InsouManager newManager);
	boolean deleteManager(String managername);
	boolean findManager(InsouManager manager);
	int editManager(InsouManager manager);
	InsouManager getManager(String managername);
	HashMap getManagerList();
	HashMap getsearchManagerList(String str,String k);	
}
