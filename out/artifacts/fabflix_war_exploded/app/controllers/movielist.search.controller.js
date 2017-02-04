'use strict';

angular.module ('synerApp')
	.controller ('MovieListSearchCtrl', function ($scope, $routeParams, MoviesService, ShoppingCartService) {
		$scope.allMovies = [];
		$scope.moviesPerPage = 10;
		$scope.moviesPerPageList = [10,25,50, 100];
		$scope.loading = false;

		//Initialize /////////////////////////////////////////////////////////////////////
		$scope.init = function () {
			$scope.loading = true;
			if($routeParams.advSearch === "true"){
				MoviesService.advSearch (MoviesService.getAttributes()).success (function (data) {
					$scope.allMovies = data;
					$scope.loading = false;
				});
			}else {
				MoviesService.search ($routeParams.searchParams).success (function (data) {
					$scope.allMovies = data;
					$scope.loading = false;
				});
			}
		};

		$scope.addToCart = function (movie) {
			ShoppingCartService.addMovie(movie);
		};

		//Clear input fields /////////////////////////////////////////////////////////////////////
		$scope.clearFields = function () {
			$scope.eventName = "";
			$scope.eventLocation = "";
			$scope.eventDate = "";
			$scope.eventTotalAttnds = "";
		};


	});
