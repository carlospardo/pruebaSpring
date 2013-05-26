package org.assembly.dao;

import java.util.List;

import org.assembly.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.support.Neo4jTemplate;

public class PersonDAOImpl implements PersonDAO {
	
	@Autowired
	private Neo4jTemplate template;
	
	public void setTemplate(Neo4jTemplate template) {
		this.template = template;
	}

	
	public void save(Person person) {
		this.template.save(person);
	}

	
	public Person get(Long id) {
		return this.template.findOne(id, Person.class);
	}

	
	public Person findByName(String name) {
		GraphRepository<Person> movieRepository =
				template.repositoryFor(Person.class);
		
		return movieRepository.findByPropertyValue("name", name);
	}


}