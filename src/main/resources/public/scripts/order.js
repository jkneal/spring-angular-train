
function newOrder() {
  var orderDetails = [];
  
  return {
	id: Math.random(),
	submitted: false,
	add: function(product, quantity) {
	  quantity = quantity || 1;
	  orderDetails.push({product: product, quantity: quantity});
	},
	updateQuantity: function(product, quantity) {
	  orderDetails.forEach(function (orderDetail) {
		if (orderDetail.product.id === product.id) {
			orderDetail.quantity = quantity;
		}
	  })	
	},
	getTotal: function() {
	  var total = 0;
	  orderDetails.forEach(function (orderDetail) {
		total += orderDetail.product.price * orderDetail.quantity; 
	  })
	  return total;
	},
	complete: function(successCallback) {
	  if (this.submitted) {
		throw Error('Order has already been submitted');  
	  }	
	  $.ajax({url: '/orders',
	    method: 'POST',
		data: {id: this.id, details: JSON.stringify(orderDetails)}, 
	    contentType: 'application/json'}).done(function(response) {
	      successCallback(response);  
	    }).fail(function() {
	      alert('Error in request');
	    });	
	  this.submitted = true;
	}
  }
}
  