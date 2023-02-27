# test-hibernate

Test de hibernate pour conseiller un client.

Ce code est utile dans le cadre de la mission de @patou et @hgwood chez leur client sur le premier semestre 2023.
Ce repo peut être supprimé ou archivé au-delà de cette période.

Ce code essaye d'avoir un cas nominal pour tester un problème que l'on peut avoir avec l'anotation `@NotFound(action = NotFoundAction.IGNORE)@ManyToOne(fetch = FetchType.EAGER)` qui cause une double requete SQL.