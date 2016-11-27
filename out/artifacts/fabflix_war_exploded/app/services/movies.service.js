//Service for getting and setting data into MongoDB via API.
angular.module('synerApp')
  .service('MoviesService', ['$http', 'AuthService', function($http, AuthService) {

    //Get all the events 
    var getMoviessRequest = function() {
      		return $http.get('/api/movies');
    	}

    //Get one event using ID
    var getMovieRequest = function(id) {
      		return $http.get('/api/movies/'+id);
    	}


	//All the returned methods for this service.
	return {
      		getMovie: function(id) { return getMovieRequest(id); },
      		getMovies: function() { return getMoviessRequest(); },

		};


  }]);