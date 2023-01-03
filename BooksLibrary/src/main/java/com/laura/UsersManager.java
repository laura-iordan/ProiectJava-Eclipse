package com.laura;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class UsersManager {
	
	static EntityManagerFactory factory;
	static EntityManager entityManager;

	public static void main(String[] args) {
		begin();
		
		//create();
		//update();
		//find();
		query();
		//remove();
		
		end();

	}
	
	private static void query() {
		String jpql = "Select u from User u where u.username = 'laura'";
		Query query = entityManager.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<User> listUsers = query.getResultList();
		
		for(User user : listUsers) {
			System.out.println(user.getPassword());
		}
	}
	

	
	private static void create() {
		User newUser = new User();
		newUser.setUsername("maria");
		newUser.setPassword("maria");
		newUser.setRole(2);
		
		entityManager.persist(newUser);
	}
	
	private static void find() {
		long primaryKey = 1;
		User user = entityManager.find(User.class, primaryKey);
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getRole());
	}
	
	private static void update() {
		User existUser = new User();
		existUser.setUserId(1);
		existUser.setUsername("laura");
		existUser.setPassword("laura");
		existUser.setRole(1);
		
		entityManager.merge(existUser);
	}
	
	private static void remove() {
		long primaryKey = 2;
		User reference = entityManager.getReference(User.class, primaryKey);
		entityManager.remove(reference);
		
	}

	private static void begin() {
		factory = Persistence.createEntityManagerFactory("LibraryUnit");
		entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
	}

	private static void end() {
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}

}
