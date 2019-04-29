//'use strict';
//pagoApp.service('reservaService', ['$http', function($http) {
//	this.reservar = function (request) {
//		console.log(request);
//		return $http({
//	        method: 'POST',
//	        data: JSON.stringify(request),
//	        url: 'rest/HotelService/reservar',
//	        headers: {
//	            'Content-type': 'application/json'
//	        }
//	    });
//	};
//	this.confirmar = function(quoteDto){
//		return $http({
//			method: 'POST',
//			data: JSON.stringify(request),
//			url: 'rest/HotelService/confirmar',
//			headers: {
//	            'Content-type': 'application/json'
//	        }
//		});
//	};
//}]);