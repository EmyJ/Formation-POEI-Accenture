USE GESTION_EMPLOYES
GO

--EXEMPLES du cours

CREATE NONCLUSTERED INDEX FK_Employes_Services
	ON Employes(CodeService ASC);

CREATE NONCLUSTERED INDEX FK_Employes_Employes
	ON Employes(CodeChef ASC);
	
CREATE NONCLUSTERED INDEX FK_Conges_Employes
	ON Conges(CodeEmp ASC);
	
CREATE NONCLUSTERED INDEX FK_Conges_mens_Conges
	ON Conges_Mens(CodeEmp ASC,Annee ASC);
