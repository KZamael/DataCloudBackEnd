package de.DataCloud.DataObjects;

import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;

public interface PersonAPI {

	@ApiOperation(value = "Find Person by id",
		    notes = "Returns the requested Person by using a specific id.")
	@RequestMapping(value = "/person/{id}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<Person> getPerson(@PathVariable("id") Long id);

	@ApiOperation(value = "Find  a person by their surname",
		    notes = "Returns the requested Person based on their family name.")
	@RequestMapping(value = "/person/search/{name}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<Person> searchPerson(@PathVariable("name") String name);

	@ApiOperation(value = "List all Persons",
		    notes = "Returns all Persons.")
	@RequestMapping(value = "/persons", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<Person>> getPersons();

	@ApiOperation(value = "Deletes a specific Person via id",
		    notes = "Deletes the specified Person.")
	@RequestMapping(value = "/person/{id}", produces = { "application/json" }, method = RequestMethod.DELETE)
	ResponseEntity<Void> deletePerson(@PathVariable("id") Long id);

	@ApiOperation(value = "Creates a new Person",
		    notes = "Currently, the new Person gets the next higher Integer ID from the Server.")
	@RequestMapping(value = "/persons", produces = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> createPerson(@RequestBody Person person);

	@ApiOperation(value = "Updates a specific Person",
		    notes = "Update happens via id.")
	@RequestMapping(value = "/person/{id}", produces = { "application/json" }, method = RequestMethod.PUT)
	ResponseEntity<Void> updatePerson(@PathVariable("id") Long id, @RequestBody Person person);

}