USE GESTION_EMPLOYES;
GO

--EXEMPLES du cours

/*
UPDATE
*/
--modification de tous les employés
update Employes set nom = UPPER(nom);

--modification des employés du service Achat
update Employes set salaire = salaire * 1.1
		where codeService = 'ACHAT';

--utilisation des valeurs par défaut et nulles
update Employes set nom = UPPER(nom), 
					prenom = ISNULL(prenom, '<non renseigné>'),
					dateEmbauche = DEFAULT,
					dateNaissance = NULL;