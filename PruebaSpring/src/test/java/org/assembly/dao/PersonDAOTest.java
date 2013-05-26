package org.assembly.dao;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.assembly.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonDAOTest {

	@Resource
	private PersonDAO dao;
	
	public void setDao(PersonDAO dao) {
		this.dao = dao;
	}
	
	@Test 
	@Transactional
	public void save() {
		
		Person person = new Person("Pablo", "Goette");
		
		dao.save(person);
		
		Person personSaved = dao.get(person.getId());
		
		assertEquals(person, personSaved);
	}
	
	@Test 
	@Transactional
	public void saveFriendly() {
		Person person = new Person("Pablo", "Goette");
		
		person.getFriends().add(new Person("Mercedez","Benz"));
		person.getFriends().add(new Person("Al","Colico"));
		person.getFriends().add(new Person("Barry","Gota"));
		person.getFriends().add(new Person("Mercedez","Benz"));
		dao.save(person);
		
		Person personSaved = dao.get(person.getId());
		
		assertEquals(person, personSaved);
	}

	@Test 
	@Transactional
	public void findByName() {
		Person person = new Person("Aquiles", "Canto");
		
		dao.save(person);
		
		Person personSaved = dao.findByName("Aquiles");
		
		assertEquals(person, personSaved);
	}
}