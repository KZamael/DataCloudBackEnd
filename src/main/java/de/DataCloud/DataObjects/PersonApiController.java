package de.DataCloud.DataObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.omg.CORBA.TCKind;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PersonApiController implements PersonAPI {

	private static TreeMap<Long, Person> data = initialHash();

	private static TreeMap<Long, Person> initialHash() {
		TreeMap<Long, Person> data = new TreeMap<>();
		data.put(123L, new Person(new Long(123), "Bruce", "Wayne", "1975-01-15"));
		data.put(231L, new Person(new Long(231), "John", "Doe", "1992-08-30"));
		data.put(312L, new Person(new Long(312), "Doctor", "Gallifrey", "0000-12-31"));
		
		return data;
	}

	@Override
	public ResponseEntity<Person> getPerson(@PathVariable("id") Long id) {
		Person p = null;
		if (data.containsKey(new Long(id))) {
			p = data.get(new Long(id));
		}
		return p == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<Person>(p, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Person> searchPerson(@PathVariable("name") String name) {
		Person p = null;
		for (Map.Entry<Long, Person> entry : data.entrySet()) {
			if (entry.getValue().getFamilyName().toLowerCase().equals(name.toLowerCase())) {
				p = entry.getValue();
			}
		}
		return p == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<Person>(p, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Person>> getPersons() {
		List<Person> l = new ArrayList<>();
		for (Long key : data.keySet()) {
			l.add(data.get(key));
		}
		return new ResponseEntity<List<Person>>(l, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> deletePerson(@PathVariable("id") Long id) {
		Person p = null;
		if (data.containsKey(new Long(id))) {
			p = data.remove(new Long(id));
			System.out.println("####" + p.toString());
		}
		return new ResponseEntity<Void>(p  == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> createPerson(@RequestBody Person p) {
		// Increment the key
		incrementKey(p);
		
		System.out.println(p.toString() + "####");
		if(!data.containsKey(new Long(p.getID()))) {
			data.put(p.getID(), p);
		}
		HttpHeaders h = new HttpHeaders();
		h.add("Location", "/person/" + p.getID());
		return new ResponseEntity<Void>(h, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> updatePerson(@PathVariable("id")Long id, @RequestBody Person p) {
		if(data.containsKey(new Long(id))) {
			data.replace(id, p);
		}else {
			data.put(id, p);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	/**
	 * Increments the Id for every new Person
	 * @param p
	 */
	private void incrementKey(Person p) {
		p.setId(data.lastKey() + 1);
	}
}
