package Service;

import java.util.ArrayList;

import Entity.User;



public interface UserService {
	public void save(User user);
	public void delete(User user);
	public void update(User user);
	public User loginvail(String account,String password);
	public User getUserByAccount(String account);
	public ArrayList getUserLikeAccount(String account);
	public User getUserById(String userid);
	public ArrayList getAllUser();
	public ArrayList getUserLikeNickName(String nickname);
}
