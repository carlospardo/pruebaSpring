package org.assembly.dao;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.assembly.model.Person;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class Prueba {

	@Resource
	private static PersonDAO dao;
	
	public void setDao(PersonDAO dao) {
		this.dao = dao;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		save();
		
		
	}
	
	@Transactional
	public static void save() {
		
		Person person = new Person("Pablo", "Goette");
		
		dao.save(person);
		
		Person personSaved = dao.get(person.getId());
		
		assertEquals(person, personSaved);
	}

}
