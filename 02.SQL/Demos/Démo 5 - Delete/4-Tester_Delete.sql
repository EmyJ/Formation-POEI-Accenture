USE GESTION_EMPLOYES;
GO

--EXEMPLES du cours

/*
DELETE
*/
--attention � l'int�grit� r�f�rentielle
--ATTENTION : si l'un tombe en anomalie, c'est l'ensemble qui est annul�
--suppression de tous les services
delete from [Services];

--suppression des employ�s dont le nom contient 'emp _'
--attention � l'int�grit� r�f�rentielle (DELETE CASCADE ici)
delete from Employes 
	where nom like '%emp _%' and codeservice='ACHAT';
	
