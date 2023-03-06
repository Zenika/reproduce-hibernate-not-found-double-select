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
	void testSaveClientWithoutMotif() {

		var client = new ClientGeneral();
		client.setCode(1L);
		client.setCodeSociete("SOCIETE");
		client.setCodeCategorie("CATEGORIE");
		client.setCodeMotifCreationClient(" ");


		var motifCreationClient = new MotifCreationClient();
		motifCreationClient.setCode("CODE");
		motifCreationClient.setCodeSociete("SOCIETE");
		motifCreationClient.setLibc("LIBC");
		motifCreationClient.setMotifClient(true);
		//client.setMotifCreationClient(motifCreationClient);
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

		/*clientGeneralRepository.findByCodeSocieteAndCode("SOCIETE", 1L)
				.ifPresentOrElse((entity) -> {
					System.out.println("Found");
					System.out.println(entity.getMotifCreationClient());

				}, () -> System.out.println("Not found"));
*/

	}

	@Test
	void testSaveClientWithMotif() {

		var client = new ClientGeneral();
		client.setCode(1L);
		client.setCodeSociete("SOCIETE");
		client.setCodeCategorie("CATEGORIE");
		client.setCodeMotifCreationClient("CODE");


		var motifCreationClient = new MotifCreationClient();
		motifCreationClient.setCode("CODE");
		motifCreationClient.setCodeSociete("SOCIETE");
		motifCreationClient.setLibc("LIBC");
		motifCreationClient.setMotifClient(true);
		//client.setMotifCreationClient(motifCreationClient);
		motifCreationClientRepository.save(motifCreationClient);

		clientGeneralRepository.save(client);
		clientGeneralRepository.findById(new ClientGeneralId("SOCIETE", 1L))
				.ifPresentOrElse((entity) -> {
					System.out.println("Found");
					System.out.println(entity.getMotifCreationClient());
					Assertions.assertNotNull(entity.getMotifCreationClient());

				}, Assertions::fail);

		/*clientGeneralRepository.findByCodeSocieteAndCode("SOCIETE", 1L)
				.ifPresentOrElse((entity) -> {
					System.out.println("Found");
					System.out.println(entity.getMotifCreationClient());

				}, () -> System.out.println("Not found"));
*/

	}

}
