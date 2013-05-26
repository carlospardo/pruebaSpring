/**
 * 
 */
package org.assembly.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * @author emanuel
 *
 */
@NodeEntity
public class Person {
	
	@GraphId
	private Long id;
	
	@Indexed //nos permite buscar por ejemplo por nombre. 2 personas no deberian llamarse igual
	private String name;
	
	private String lastName;
	
	private Set<Person> friends = new HashSet<Person>();

	public Person() {	}
	
	public Person(String name, String lastName) {
		super();
		this.name = name;
		this.lastName = lastName;
	}

	public Person(String name, String lastName, HashSet<Person> friends) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.friends = friends;
	}

	public void makeAFriend(Person friend) {
		this.getFriends().add(friend);
		friend.getFriends().add(this);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Set<Person> getFriends() {
		return friends;
	}

	public void setFriends(Set<Person> friends) {
		this.friends = friends;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	

}