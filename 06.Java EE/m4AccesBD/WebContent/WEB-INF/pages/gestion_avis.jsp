<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8" />
	<title>Gestion des avis</title>
	<script>
	
	
	function validerFormulaire(){
		
        var listeErreurs = '';
		var erreurs = document.getElementById("erreurs");
		var ret = true;
		var chpDescription = document.forms["formulaire"]["description"].value;;
		if(chpDescription==""){
			ret = false;
			listeErreurs = 'La saisie de la description est obligatoire.<br>';
		}

        var note = document.forms["formulaire"]["note"].value;
        if( isNaN(note) || note < 0 || note > 5){
        	listeErreurs  = listeErreurs + "La valeur du champ note est incorrecte.<br>";
        	ret = false;
        }

		erreurs.innerHTML = listeErreurs;

		return ret;
	}
	
	</script>
</head>
<body>
	<h1>Gestion des avis</h1>
	
	<span id="erreurs" style="color:red"></span>
	<form action="/m4AccesBD/ajouterNote" method="post" onsubmit="return validerFormulaire()" name="formulaire">
	<label for="description">Description : </label><br />
	<input type="text" name="description" id="description" /> *<br />
	<label for="note">Note : </label><br />
	<input type="number" name="note" id="note" /> *<br /><br/>
	<input type="submit"  value="Enregistrer" />
	
	</form>
	
	
</body>
</html>
