package org.assembly.dao;

import org.assembly.model.Person;

public interface PersonDAO {
	
	void save(Person person);

	Person get(Long id);

	Person findByName(String name);
	
}