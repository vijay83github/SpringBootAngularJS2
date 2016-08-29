package com.tieto.springboot.service;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tieto.springboot.model.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static final String FILE_LOCATION = "src/main/resources/address.ser";

	private static Long counter = new Long(0L);
	
	private static File file;
	
	private static List<User> users = new ArrayList<User>();
	
	static{
		users = readList();
	}

	public List<User> findAllUsers() {
		if(users!=null && users.isEmpty()){
			users = readList();
		}
		return users;
	}
	
	public User findById(long id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public User findByName(String name) {
		if(users!=null){
			for(User user : users){
				if(user.getUsername().equalsIgnoreCase(name)){
					return user;
				}
			}
		}
		return null;
	}
	
	public void saveUser(User user) {
		counter = Long.valueOf(System.currentTimeMillis());
		user.setId(counter);
		users.add(user);
		writeList(users);
	}

	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
		writeList(users);
	}

	public void deleteUserById(long id) {
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
		    User user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
		writeList(users);
	}

	public boolean isUserExist(User user) {
		return findByName(user.getUsername())!=null;
	}
	
	public void deleteAllUsers(){
		users.clear();
		writeList(users);
	}

	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User(counter,"Sam", "NY","01/01/01","9892098921", "sam@abc.com"));
		users.add(new User(counter,"Tomy", "ALBAMA","02/02/02","9892098922", "tomy@abc.com"));
		users.add(new User(counter,"Kelly", "NEBRASKA","03/03/03","9892098923", "kelly@abc.com"));
		return users;
	}
	
	private static List<User> readList(){
		System.out.println("Reading List from File : Start");
		ObjectInputStream objectinputstream = null;
		 List<User> recordList = new ArrayList<User>();;
		try {
			FileInputStream streamIn = new FileInputStream(FILE_LOCATION);
		    objectinputstream = new ObjectInputStream(streamIn);
		    List<User> readObject = (List<User>) objectinputstream.readObject();
			recordList = readObject;
		} catch (EOFException e) {
			recordList = new ArrayList<User>();
		}catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    if(objectinputstream != null){
		        try {
					objectinputstream .close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    } 
		}
		System.out.println("Reading List from File : End : users ="+users.toString());
		return recordList;
	}
	
	private static void writeList(List<User> usersList){
		System.out.println("Writing List to File : Start");
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try{
		     fout = new FileOutputStream(FILE_LOCATION, false);
		     oos = new ObjectOutputStream(fout);
		    oos.writeObject(usersList);
		} catch (Exception ex) {
		    ex.printStackTrace();
		} finally {
		    if(oos  != null){
		        try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    } 
		}
		System.out.println("Writing List to File : End : users ="+users.toString());
	}

}
