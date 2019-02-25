USE GESTION_EMPLOYES;
GO

--EXEMPLES du cours


/*
INSERT
*/
--norme ANSI
--obligation de fournir une valeur � chaque champ de la table
insert into [Services] values ('RESHU', 'Ressources humaines');
insert into [Services] (codeService, libelle) values ('ACHAT', 'Achat');

--obligation de fournir une valeur � chaque champ list�
insert into Employes (nom,prenom,dateEmbauche,salaire,codeService)
			values('Emp 1', 'pr�nom Emp 1', '12/05/1999',2530.23,'RESHU');
			
--utilsation des valeurs par d�faut
insert into Employes (nom,prenom,dateEmbauche,salaire,codeService)
			values('Emp 2', 'pr�nom Emp 2', '12/05/1999',DEFAULT,'RESHU');
			
--dateEmbauche n'�tant pas valoris�e, elle prend sa valeur par defaut
insert into Employes (nom,prenom,salaire,codeService)
			values('Emp 3', 'pr�nom Emp 3', 3682.12,'RESHU');
			
--Le sgbdr garantit la coh�rence des donn�es dans la base
--insertion refus�e (non respect des contraintes)
--attention au comportement de la propri�t� IDENTITY
insert into Employes (nom,prenom,dateEmbauche,salaire,codeService)
			values('Emp 4', NULL, '10/11/2016' ,-10,'XXXXX');
			
--utilisation de fonctions Transact-SQL
insert into Employes (nom,prenom,dateEmbauche,salaire,codeService)
			values(upper('Emp 5'), 'pr�nom Emp 5', GETDATE(),DEFAULT,'ACHAT');
		

		
--insert multiple sp�cifique � SQL Server (hors norme)
--ATTENTION : si l'un tombe en anomalie, c'est l'ensemble qui est annul�
insert into [Services] (codeService,libelle)
	values ('SERV1','Service 1'),('SERV2','Service 2');
	