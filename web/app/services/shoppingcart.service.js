'use strict'
//Service for getting and setting data into MongoDB via API.
angular.module ('synerApp')
	.service ('ShoppingCartService', ['$http', function ($http, $scope) {

		var invoice = {
			movies: []
		};

		//Get all the movies
		var getMoviesRequest = function () {
			return invoice.movies;
		};

		var addMovieRequest = function (movie) {

			var exists = false;

			(function checkExist () {
				if (invoice.movies) {
					invoice.movies.forEach (function (m) {
						if (movie.title === m.title)
							exists = true;
					});

				}
			})();

			if (exists){
				console.log('movie exists');
			}
			else{
				invoice.movies.push ({
					                     title: movie.title,
					                     price: movie.price,
					                     quantity: movie.quantity
				                     });
				console.log ('movie added', movie);
			}
		};

		var removeMovieRequest = function (index) {
			invoice.movies.splice (index, 1);
		};

		var updateMovieRequest = function (movie) {
			invoice.movies.forEach (function (m) {
				if (movie.title === m.title) {
					m.quantity = movie.quantity;
				}
			});

		};


		//All the returned methods for this service.
		return {
			getMovies: function () {
				return getMoviesRequest ();
			},
			addMovie: function (movie) {
				return addMovieRequest (movie);
			},

			updateMovie: function (movie) {
				return updateMovieRequest (movie);
			},
			removeMovie: function (index) {
				return removeMovieRequest (index);
			}

		};


	}]);