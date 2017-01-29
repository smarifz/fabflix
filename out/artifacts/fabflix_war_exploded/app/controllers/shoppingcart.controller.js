'use strict';

angular.module ('synerApp')
	.controller ('ShoppingCartCtrl', function ($rootScope, $scope, $routeParams, ShoppingCartService) {
		$scope.invoice = {
			movies: []
		};

		$scope.length = 0;

		//Initialize /////////////////////////////////////////////////////////////////////
		$scope.init = function () {
			$scope.reloadCartWithMovies ();
			console.log('Movies'+$scope.invoice.movies);
		};

		////Add Movie /////////////////////////////////////////////////////////////////////
		//$scope.addMovie = function (movie) {
		//	$scope.reloadCartWithMovies();
		//	function exist(){
		//	    if($scope.invoice.movies) {
		//		    $scope.invoice.movies.forEach (function (m) {
		//			    if (movie.title === m.title)
		//				    return true;
		//		    });
		//	    }
		//		return false;
		//	}
		//
		//	if(!exist()) {
		//		ShoppingCartService.addMovie(movie);
		//	}
		//};

		$scope.reloadCartWithMovies = function(){
			$scope.invoice.movies = ShoppingCartService.getMovies();
		};

		$scope.updateMovie = function(movie){
			ShoppingCartService.updateMovie(movie);
		}

		//Remove Movie /////////////////////////////////////////////////////////////////////
		$scope.removeMovie = function(index) {
			ShoppingCartService.removeMovie(index);
		};

		$scope.total = function () {
			$scope.reloadCartWithMovies();
			var total = 0;
			$scope.invoice.movies.forEach (function (movie) {
				total += movie.quantity * movie.price;
			});

			return total;
		};

	});
