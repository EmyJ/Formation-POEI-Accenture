/*********************************************************************************/

--A VOUS DE JOUER

--suppression des employes � la retraite (+ de 65 ans)
delete from Employes where 
	dateNaissance != null and DATEDIFF(year,dateNaissance,getdate()) >= 65;
