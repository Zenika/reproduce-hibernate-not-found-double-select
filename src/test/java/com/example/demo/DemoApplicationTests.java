package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	ClientGeneralRepository clientGeneralRepository;
	@Autowired
	MotifCreationClientRepository motifCreationClientRepository;

	@Autowired
	QueryCountInterceptor queryCountInterceptor;

	@Test
	void givenInDatabseClientHasForeignKeySpaceValueButNoMotifThenHibernateDoesOnlyOneQuery() {
		clientGeneralRepository.createClientGeneralWithSpaceForeignKey();

		queryCountInterceptor.reset();
		clientGeneralRepository.findById(new ClientGeneralId("SOCIETE", 2L))
				.ifPresentOrElse((entity) -> {
					System.out.println("Found");
					System.out.println(entity.getMotifCreationClient());
					Assertions.assertNull(entity.getMotifCreationClient());
					Assertions.assertEquals(1, queryCountInterceptor.getCount());

				}, Assertions::fail);
	}

	@Test
	void givenClientHasForeignKeySpaceValueButNoMotifThenHibernateDoesOnlyOneQuery() {
		var client = new ClientGeneral();
		client.setCode(1L);
		client.setCodeSociete("SOCIETE");
		client.setCodeCategorie("CATEGORIE");
		client.setCodeMotifCreationClient(" "); // foreign key value does not point to an actual entity
		clientGeneralRepository.save(client);

		queryCountInterceptor.reset();
		clientGeneralRepository.findById(new ClientGeneralId("SOCIETE", 1L))
				.ifPresentOrElse((entity) -> {
					System.out.println("Found");
					System.out.println(entity.getMotifCreationClient());
					Assertions.assertNull(entity.getMotifCreationClient());
					Assertions.assertEquals(1, queryCountInterceptor.getCount());

				}, Assertions::fail);
	}


	@Test
	void givenClientHasNoMotifThenHibernateDoesOnlyOneQuery() {
		var client = new ClientGeneral();
		client.setCode(1L);
		client.setCodeSociete("SOCIETE");
		client.setCodeCategorie("CATEGORIE");
		client.setCodeMotifCreationClient(null); // no foreign key value

		var motifCreationClient = new MotifCreationClient();
		motifCreationClient.setCode("CODE");
		motifCreationClient.setCodeSociete("SOCIETE");
		motifCreationClient.setLibc("LIBC");
		motifCreationClient.setMotifClient(true);
		motifCreationClientRepository.save(motifCreationClient);

		clientGeneralRepository.save(client);
		queryCountInterceptor.reset();
		clientGeneralRepository.findById(new ClientGeneralId("SOCIETE", 1L))
				.ifPresentOrElse((entity) -> {
					System.out.println("Found");
					System.out.println(entity.getMotifCreationClient());
					Assertions.assertNull(entity.getMotifCreationClient());
					Assertions.assertEquals(1, queryCountInterceptor.getCount());

				}, Assertions::fail);
	}


	@Test
	void givenClientHasMotifThenHibernateDoesOnlyOneQuery() {

		var client = new ClientGeneral();
		client.setCode(1L);
		client.setCodeSociete("SOCIETE");
		client.setCodeCategorie("CATEGORIE");
		client.setCodeMotifCreationClient("CODE"); // foreign key value points to an actual entity

		var motifCreationClient = new MotifCreationClient();
		motifCreationClient.setCode("CODE");
		motifCreationClient.setCodeSociete("SOCIETE");
		motifCreationClient.setLibc("LIBC");
		motifCreationClient.setMotifClient(true);
		motifCreationClientRepository.save(motifCreationClient);

		clientGeneralRepository.save(client);
		queryCountInterceptor.reset();
		clientGeneralRepository.findById(new ClientGeneralId("SOCIETE", 1L))
				.ifPresentOrElse((entity) -> {
					System.out.println("Found");
					System.out.println(entity.getMotifCreationClient());
					Assertions.assertNotNull(entity.getMotifCreationClient());
					Assertions.assertEquals(1, queryCountInterceptor.getCount());
				}, Assertions::fail);
	}

}
