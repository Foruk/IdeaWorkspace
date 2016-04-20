package Dao;

import java.util.ArrayList;

import Entity.User;



public interface UserDao {
	public void save(User user);
	public void delete(User user);
	public void update(User user);
	public ArrayList loginvail(String username,String password);
	public ArrayList getUserByAccount(String account);
	public ArrayList getUserLikeAccount(String account);
	public ArrayList getUserLikeNickName(String nickname);
	public ArrayList getUserById(int userid);
	public ArrayList getAllUser();
}
