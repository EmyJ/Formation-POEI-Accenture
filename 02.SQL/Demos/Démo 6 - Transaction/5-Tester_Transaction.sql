USE GESTION_EMPLOYES;
GO

--EXEMPLES du cours

/*
MANIPULER UNE TRANSACTION
*/

--D�finir la nature du verrou pos� par la tansaction
SET TRANSACTION ISOLATION LEVEL READ COMMITTED; --(par defaut)

--D�marrer une transaction
BEGIN TRAN [MAJ_DATA];

	insert into [Services] (codeService,libelle)
		values ('SERV3','Service 3');
	insert into [Services] (codeService,libelle)
		values ('SERV4','Service 4');
	
	--placer un point de contr�le dans la transaction
	SAVE TRAN [BEFORE_DELETE];	
	
	delete from Employes 
		where nom like '%emp _%';

--Select interne � la transaction, on visualise les modifications en cours
--Les donn�es sont v�rrouill�es pour les autres utilisateurs
select * from [Services];
select * from Employes;

--Invalider totalement la transaction et lib�rer les verrous
--ROLLBACK TRAN [MAJ_DATA];
--Invalider la transaction jusqu'au point de contr�le
ROLLBACK TRAN [BEFORE_DELETE];

--Valider la transaction et lib�rer les verrours
COMMIT TRAN [MAJ_DATA];