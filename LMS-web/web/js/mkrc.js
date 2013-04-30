function remove_fav(pubId){
     if (confirm('Are you sure you want to remove from your favorite list?')) {   
         $.ajax({
            type: "GET",
            url: " ./removeFavorite",
            data: { pubId: pubId}
            }).done(function( msg ) {
                    alert("Publication Removed from your favorite list!");
                    location.reload();
            });
     }
    } 
    function delete_publication(pubId){
     if (confirm('Are you sure you want to Delete this publication?')) {   
         $.ajax({
            type: "GET",
            url: " ./deletePublication",    
            data: { pubId: pubId}
            }).done(function( msg ) {
                    alert("Publication Removed !");
                    //location.reload(); /* have to reload the page after removal or call other page*/
            });
     }
    } 
    function cancel_reservation(id){
     if (confirm('Are you sure you want to cancel your reservation?')) {   
         $.ajax({
            type: "GET",
            url: " ./removeReservation",
            data: { id: id}
            }).done(function( msg ) {
                    alert("Reservation cancelled successfully!");
                    location.reload();
            });
     }
    } 
    function make_reservation(pubId){
     if (confirm('Are you sure you want to reserve this publication?')) {   
         $.ajax({
            type: "GET",
            url: " ./ReservePublication",
            data: { pubId: pubId}
            }).done(function( msg ) {
                    alert("Publication Reserved successfully!");
                    //location.reload(); 
            });
     }
    } 
    
    function add_to_favorite(pubId,title,author,pubDate,type,callnumber,status){
     if (confirm('Do you want to your favorite list?')) {   
         $.ajax({
            type: "GET",
            url: " ./addToFavorite",
            data: { pubId: pubId, title: title, author: author, pubDate: pubDate, type: type, callnumber: callnumber, status: status}
            }).done(function( msg ) {
                    alert("Publication added to your favorite list!");
                    
                   //  window.self.     ./job.jsp?id_utente="+ID_UTENTE+"&id_workspace="+ID_WORKSPACE+"\";
            });
     }
    } 