USE GESTION_EMPLOYES;
GO

--EXEMPLES du cours

--Si l'int�grit� r�f�rentielle est toujours active, impossible de supprimer
--la table d�tail Employes avant la table maitre Services
--DROP TABLE Employes;
--DROP TABLE [Services];

--seul ordre possible
--DROP TABLE [Services], Employes;


/*********************************************************************************/

--A VOUS DE JOUER

--suppression de l'integrit� r�f�rentielle
ALTER TABLE Employes DROP 
	CONSTRAINT FK_Employes_CodeService,
	CONSTRAINT FK_Employes_CodeChef;
		
ALTER TABLE Conges DROP 
	CONSTRAINT FK_Conges_Employes;

ALTER TABLE Conges_Mens DROP 
	CONSTRAINT FK_Conges_Mens;

--l'ordre de suppression des tables n'a plus d'importance
DROP TABLE [Services], Employes, Conges, Conges_Mens;