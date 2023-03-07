/**
 * portfolio.js
 */
console.log('호출');

$.ajax({
	type: 'GET',
	url: '/silhyun/ptgDetail/' + ptgId,
	success: function(data) {
		// Handle successful response from server
		console.log(data);
	},
	error: function(xhr, status, error) {
		// Handle error response from server
		console.log(xhr);
	}
});

