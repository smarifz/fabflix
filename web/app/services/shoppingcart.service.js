'use strict'
//Service for getting and setting data into MongoDB via API.
angular.module ('synerApp')
	.service ('ShoppingCartService', ['$http', '$window', function ($http, $window) {

		var invoice = {
			movies: []
		};

		var sync = function () {
			$window.localStorage['fabflix'] = JSON.stringify (invoice.movies);
			//$window.localStorage.setItem('fabflix',invoice);
		};

		var reverseSync = function () {
			invoice.movies = JSON.parse ($window.localStorage['fabflix']);
		};

		//Get all the movies
		var getMoviesRequest = function () {
			//reverseSync();
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
			}) ();

			if (exists) {
				console.log ('movie exists');
			}
			else {
				invoice.movies.push ({
					                     title: movie.title,
					                     price: 15.99,
					                     quantity: 1
				                     });
				console.log ('movie added', movie);
			}
			sync ();
		};

		var removeMovieRequest = function (index) {
			invoice.movies.splice (index, 1);
			sync ();
		};

		var updateMovieRequest = function (movie) {
			invoice.movies.forEach (function (m) {
				if (movie.title === m.title) {
					m.quantity = movie.quantity;
				}
			});
			sync ();

		};

		var nullifyInvoice = function () {
			invoice = null;
			sync();
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
			},
			reverseSync: function () {
				return reverseSync ();
			},
			sync: function () {
				return sync ();
			},

			nullifyInvoice: function () {
				return nullifyInvoice ();
			}

		}
			;


	}]);