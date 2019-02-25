<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		
<!-- Fenetre modale de confirmation de suppression d'une liste -->
	<div class="modal fade" id="modaleSupprimerListe" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Confirmation de suppression</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        Voulez-vous vraiment supprimer cette liste ?
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Non</button>
	        <form  method="post" action="${pageContext.request.contextPath}/supprimer/liste">
	        <input type="hidden" name="id" value="${param.id}" />
	        <button type="submit" class="btn btn-primary">Oui, supprimer</button>
	        </form>
	      </div>
	    </div>
	  </div>
	</div>