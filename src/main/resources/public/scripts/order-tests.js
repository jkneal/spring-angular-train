
function runOrderTests() {
  var order = newOrder();
  
  assert('Order Id not created', order.id);
  assertEqual(order.submitted, false);
  assert('Order details exposed', !order.orderDetails);
  assertEqual(order.getTotal(), 0);
  
  var product1 = {id: 1, name: 'Basketball', price: 20}
  order.add(product1);
  assertEqual(order.getTotal(), 20);
  
  var product2 = {id: 2, name: 'Baseball', price: 9}
  order.add(product2, 2);
  assertEqual(order.getTotal(), 38);
  
  var product3 = {id: 3, name: 'Football', price: 15.20}
  order.add(product3);
  assertEqual(order.getTotal(), 53.20);
  
  order.updateQuantity(product1, 2);
  assertEqual(order.getTotal(), 73.20);
  
  order.complete(function(response) {
	alert(response);  
  })
  
  try {
	order.complete();  
	alert('Was able to submit order twice');
  } catch(err) {
    // good	  
  }
}

function assert(msg, value) {
  if (!value) {
	alert(msg); 
	throw Error('Test Failure');
  }	
}

function assertEqual(actual, expected) {
  if (actual !== expected) {
	alert('Actual: ' + actual + ' do not match expected: ' + expected);  
	throw Error('Test Failure');
  }	
}
