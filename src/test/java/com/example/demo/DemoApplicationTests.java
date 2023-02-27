package com.example.demo;

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

	@Test
	void testSaveClient() {

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
		// client.setMotifCreationClient(motifCreationClient);
		motifCreationClientRepository.save(motifCreationClient);

		clientGeneralRepository.save(client);
		/* clientGeneralRepository.findById(new ClientGeneralId("SOCIETE", 1L))
				.ifPresentOrElse((entity) -> {
					System.out.println("Found");
					System.out.println(entity.getMotifCreationClient());

				}, () -> System.out.println("Not found"));
*/
		clientGeneralRepository.findByCodeSocieteAndCode("SOCIETE", 1L)
				.ifPresentOrElse((entity) -> {
					System.out.println("Found");
					System.out.println(entity.getMotifCreationClient());

				}, () -> System.out.println("Not found"));


	}

}
