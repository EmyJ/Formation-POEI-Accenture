USE GESTION_EMPLOYES;
GO

--EXEMPLES du cours

--modifier une colonne				
ALTER TABLE Employes 
	ALTER COLUMN Prenom VARCHAR(50) not null;
	
--supprimer une colonne
ALTER TABLE Employes 
	DROP COLUMN DateModif;


--ajouter une contrainte sans vérification des données déjà présentes en base
ALTER TABLE Employes 
	WITH NOCHECK ADD CONSTRAINT CK_Employes_Salaire_2 CHECK (Salaire <= 9999);
	
--désactiver une contrainte
ALTER TABLE Employes 
	NOCHECK CONSTRAINT CK_Employes_Salaire_2;

--supprimer une contrainte
ALTER TABLE Employes
	DROP CONSTRAINT CK_Employes_Salaire_2;


/*********************************************************************************/

--A VOUS DE JOUER

--ajouter l'integrité référentielle
ALTER TABLE Employes WITH CHECK ADD 
	CONSTRAINT FK_Employes_CodeService FOREIGN KEY (CodeService) 
		REFERENCES Services(CodeService),
	CONSTRAINT FK_Employes_CodeChef FOREIGN KEY (CodeChef) 
		REFERENCES Employes(CodeEmp);
		
ALTER TABLE Conges WITH CHECK ADD 
	CONSTRAINT FK_Conges_Employes FOREIGN KEY (CodeEmp) 
		REFERENCES Employes(CodeEmp) ON DELETE CASCADE;

ALTER TABLE Conges_Mens WITH CHECK ADD 
	CONSTRAINT FK_Conges_Mens FOREIGN KEY (CodeEmp, Annee) 
		REFERENCES Conges(CodeEmp, Annee) ON DELETE CASCADE;