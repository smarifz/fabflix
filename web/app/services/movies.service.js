//Service for getting and setting data into MongoDB via API.
angular.module ('synerApp')
	.service ('MoviesService', ['$http', 'AuthService', function ($http, AuthService) {

		//Get all the movies
		var getMoviesRequest = function (type, attr) {
			return $http.get ('/api/movies',{
				params: {type: type, attribute: attr}
			});
		};

		//Get one event using ID
		var getMovieRequest = function (id) {
			return $http.get ('/api/movies/' + id);
		};

		//Get all the genres
		var getGenresRequest = function () {
			return $http.get ('/api/movies/genres');
		};


		//All the returned methods for this service.
		return {
			getMovie: function (id) {
				return getMovieRequest (id);
			},
			getMovies: function (type, attr) {
				return getMoviesRequest (type, attr);
			},
			getGenres: function () {
				return getGenresRequest ();
			},

		};


	}]);