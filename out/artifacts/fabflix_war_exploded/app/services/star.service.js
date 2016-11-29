//Service for getting and setting data into MongoDB via API.
angular.module ('synerApp')
	.service ('StarService', ['$http', 'AuthService', function ($http, AuthService) {

		//Get all the movies
		var getStarInfoRequest = function (id) {
			return $http.get ('/api/star',{
				params: {type: 'single', attribute: id}
			});
		};

		//All the returned methods for this service.
		return {
			getStarInfo: function (id) {
				return getStarInfoRequest(id);
			}

		};


	}]);