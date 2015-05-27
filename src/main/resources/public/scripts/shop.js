$(document).ready(function() {
   var storeName = $('#storeName').text();
   alert(storeName);
	
   $('.badge').html('<b>Sorry we are closed</b>');
   
   var sectionCount = $('section').size();
   alert(sectionCount);
   
   var nameCount = $('td[data-attr="name"]').size();
   alert(nameCount);
   
   var basketballPrice = $('td:contains("Basketball")').next().next().next().text();
   alert('Basketballs are ' + basketballPrice + ' today!');
   
   var ownerWrapper = '<div style="border:1px solid red"></div>';
   var owner = $('#storeInformation p:eq(1)').wrap(ownerWrapper);
   
   $('#productLink').click(function() {
	   $('#productTable').toggle();
   })
   
   $('a').not('#productLink').click(function() {
	   alert('Thanks for visiting!');
   })
});
