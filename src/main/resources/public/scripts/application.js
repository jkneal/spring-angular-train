

function testAddProductEndpoint() {
  var product = {
    name: 'Racket', 
    category: '2', 
    price: '25'	  
  }	
  $.ajax({url: '/inventory/add',
	      type: 'PUT',
		  data: JSON.stringify(product), 
          contentType: 'application/json'}).done(function() {
        	alert('Product added successfully');  
          }).fail(function() {
        	alert('Error in request');
          });
          
}

function testDeleteProductEndpoint(id) {	
  $.ajax({url: '/inventory/' + id,
	      type: 'DELETE'}).done(function() {
        	alert('Product deleted successfully');  
          }).fail(function(jqXHR) {
        	alert('Error in request: status code: ' + jqXHR.status);
          });
	          
	}