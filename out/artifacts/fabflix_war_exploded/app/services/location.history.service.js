'use strict'

angular.module ('synerApp')
	.service ('LocationHistoryService', ['$http', 'AuthService', function ($http, $AuthService) {

		var previousLocation = null;

		var storeRequest = function (location) {
			console.log('storing', location)
			previousLocation = location;
		};

		var getRequest = function () {
			console.log('previous', previousLocation)
			return previousLocation;
		};

		return {
			store: function (location) {
				return storeRequest (location);
			},
			get: function () {
				return getRequest ();
			},
		};


	}]);