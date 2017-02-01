'use strict';

angular.module ('synerApp')
	.controller ('ShoppingCartCtrl', function ($rootScope, $scope, $routeParams, ShoppingCartService, AuthService) {
		$scope.invoice = {
			movies: []
		};
		$scope.date = new Date();


		//Initialize /////////////////////////////////////////////////////////////////////
		$scope.init = function () {
			$scope.reloadCartWithMovies ();
			console.log ('Movies' + $scope.invoice.movies);
		};

		////Add Movie /////////////////////////////////////////////////////////////////////
		$scope.sync = function () {
			console.log ('sync called');
			ShoppingCartService.sync ();
		};

		$scope.reloadCartWithMovies = function () {
			$scope.invoice.movies = ShoppingCartService.getMovies ();
		};

		$scope.updateMovie = function (movie) {
			ShoppingCartService.updateMovie (movie);
		}

		//Remove Movie /////////////////////////////////////////////////////////////////////
		$scope.removeMovie = function (index) {
			ShoppingCartService.removeMovie (index);
		};

		$scope.total = function () {
			$scope.reloadCartWithMovies ();
			var total = 0;
			$scope.invoice.movies.forEach (function (movie) {
				total += movie.quantity * movie.price;
			});

			return total;
		};

		$scope.isLoggedIn = function () {
			return AuthService.isLoggedIn ();
		};

		$scope.checkout = function (fname, lname, cc, exp) {
			var ids = [];
			var movies = ShoppingCartService.getMovies ();
			movies.forEach (function (movie) {
				ids.push (movie.id);
			});
			ShoppingCartService.checkout (fname, lname, cc, exp, ids);
		};

		$scope.showEmptySign = function(){
			if(ShoppingCartService.getSize() <= 0)
				return true;
			else
				return false;
		};

	});
