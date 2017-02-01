'use strict'
//Service for getting and setting data into MongoDB via API.
angular.module ('synerApp')
	.service ('ShoppingCartService', ['$http', '$window', '$location', function ($http, $window, $location) {

		var invoice = {
			movies: []
		};

		var sync = function () {
			//if (invoice.movies.length > 0)
				$window.localStorage['fabflix'] = JSON.stringify (invoice.movies);
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
					                     id: movie.id,
					                     title: movie.title,
					                     price: 15.99,
					                     quantity: 1,
					                     salesId: null,

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
			invoice.movies = [];
			sync ();
		};

		//Get all the genres
		var checkoutRequest = function (fname, lname, cc, exp, ids) {
			return $http.get ('/api/checkout', {
				params: {
					fname: fname,
					lname: lname,
					cc: cc,
					exp: exp,
					ids: JSON.stringify (ids)
				}
			}).then (function successCallback (response) {
				// this callback will be called asynchronously
				// when the response is available
				console.log (response)
				if (response.status === 200) {
					var salesId = response.data.split (' ');
					invoice.movies.forEach (function (movie, idx) {
						movie.salesId = salesId[idx];
					});
					sync ();
					$location.url ('/confirmation');
				}

			}, function errorCallback (response) {
				// called asynchronously if an error occurs
				// or server returns response with an error status.
			});
		};

		var getSizeRequest = function(){
			if(invoice.movies)
				return invoice.movies.length;
			else
				return 0;

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
			},

			checkout: function (fname, lname, cc, exp, ids) {
				return checkoutRequest (fname, lname, cc, exp, ids);
			},

			getSize : function(){
				return getSizeRequest();
			}

		}
			;


	}]);