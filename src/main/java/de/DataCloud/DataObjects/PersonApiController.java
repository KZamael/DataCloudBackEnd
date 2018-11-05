package de.DataCloud.DataObjects;

import java.util.*;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import de.DataCloud.DataObjects.ComplexSubObjects.*;

@Controller
public class PersonApiController implements PersonAPI {

	private static TreeMap<Long, Person> data = initialHash();
	
	/* Holds some Dummy Persons for testing.*/
	private static TreeMap<Long, Person> initialHash() {
		TreeMap<Long, Person> data = new TreeMap<>();
		
		data.put(123L, new Person(new Long(123), 
				new Name("FirstName","Bruce","text", new Validation(true, 3, 32)), 
				new Name("LastName","Wayne","text", new Validation(true, 3, 32)), 
				new Birthdate("Birthdate","1975-01-15","birthDate", new Validation(true, 10, 10)),
				new Address(
						new AddressElement("Address", "Address", "text"),
						new AddressElement("addressLocality","Seattle","text"),
						new AddressElement("addressRegion","WA","text"),
						new AddressElement("postalCode","98052","text"),
						new AddressElement("streetAddress","29994 Casa Komori, Gotham City","text"),
						"PostalAddress"
						)));
		data.put(231L, new Person(new Long(231), 
				new Name("FirstName","Joseph","text", new Validation(true, 3, 32)), 
				new Name("LastName","Joestar","text", new Validation(true , 3, 32)), 
				new Birthdate("Birthdate","1920-09-17","birthDate", new Validation(true, 10, 10)),
				new Address(
						new AddressElement("Address", "Address", "text"),
						new AddressElement("addressLocality","Seattle","text"),
						new AddressElement("addressRegion","WA","text"),
						new AddressElement("postalCode","98052","text"),
						new AddressElement("streetAddress","90561 Hartenweg 7, Sonarsbach","text"),
						"PostalAddress"
						)));
		data.put(331L, new Person(new Long(331), 
				new Name("FirstName","Doctor","text", new Validation(true, 3, 32)), 
				new Name("LastName","Gallifrey","text", new Validation(true, 3, 32)), 
				new Birthdate("Birthdate","2012-01-01","birthDate", new Validation(true, 10, 10)),
				new Address(
						new AddressElement("Address", "Address", "text"),
						new AddressElement("addressLocality","Seattle","text"),
						new AddressElement("addressRegion","WA","text"),
						new AddressElement("postalCode","98052","text"),
						new AddressElement("streetAddress","20341 Whitworth Institute 405 N. Whitworth","text"),
						"PostalAddress"
						)));
		
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

	// TODO: Make it searchable for the new Data.
	@Override
	public ResponseEntity<Person> searchPerson(@PathVariable("name") String name) {
		Person p = null;
		for (Map.Entry<Long, Person> entry : data.entrySet()) {
			if (entry.getValue().getFamilyName().toString().toLowerCase().equals(name.toLowerCase())) {
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

	// TODO: Rework the create() Function.
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

	// TODO: Rework the update() Function.
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
