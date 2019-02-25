USE GESTION_EMPLOYES;
GO

--EXEMPLES du cours

/*
UPDATE
*/
--modification de tous les employ�s
update Employes set nom = UPPER(nom);

--modification des employ�s du service Achat
update Employes set salaire = salaire * 1.1
		where codeService = 'ACHAT';

--utilisation des valeurs par d�faut et nulles
update Employes set nom = UPPER(nom), 
					prenom = ISNULL(prenom, '<non renseign�>'),
					dateEmbauche = DEFAULT,
					dateNaissance = NULL;