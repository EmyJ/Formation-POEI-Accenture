USE GESTION_EMPLOYES;
GO

--EXEMPLES du cours

/*
DELETE
*/
--attention à l'intégrité référentielle
--ATTENTION : si l'un tombe en anomalie, c'est l'ensemble qui est annulé
--suppression de tous les services
delete from [Services];

--suppression des employés dont le nom contient 'emp _'
--attention à l'intégrité référentielle (DELETE CASCADE ici)
delete from Employes 
	where nom like '%emp _%' and codeservice='ACHAT';
	
