USE GESTION_EMPLOYES;
GO

--EXEMPLES du cours

/*
MANIPULER UNE TRANSACTION
*/

--Définir la nature du verrou posé par la tansaction
SET TRANSACTION ISOLATION LEVEL READ COMMITTED; --(par defaut)

--Démarrer une transaction
BEGIN TRAN [MAJ_DATA];

	insert into [Services] (codeService,libelle)
		values ('SERV3','Service 3');
	insert into [Services] (codeService,libelle)
		values ('SERV4','Service 4');
	
	--placer un point de contrôle dans la transaction
	SAVE TRAN [BEFORE_DELETE];	
	
	delete from Employes 
		where nom like '%emp _%';

--Select interne à la transaction, on visualise les modifications en cours
--Les données sont vérrouillées pour les autres utilisateurs
select * from [Services];
select * from Employes;

--Invalider totalement la transaction et libérer les verrous
--ROLLBACK TRAN [MAJ_DATA];
--Invalider la transaction jusqu'au point de contrôle
ROLLBACK TRAN [BEFORE_DELETE];

--Valider la transaction et libérer les verrours
COMMIT TRAN [MAJ_DATA];