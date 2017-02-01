'use strict';

angular.module ('synerApp')
	.controller ('MovieListCustomCtrl', function ($scope, $routeParams, MoviesService, ShoppingCartService) {
		$scope.allMovies = [];
		$scope.sortType     = 'title'; // set the default sort type
		$scope.sortReverse  = false;  // set the default sort order
		$scope.searchModel   = 'title';     // set the default search/filter term
		$scope.moviesPerPage = 10;
		$scope.moviesPerPageList = [10,25,50, 100];


		//Initialize /////////////////////////////////////////////////////////////////////
		$scope.init = function () {
			MoviesService.getMovies($routeParams.type, $routeParams.attribute).success (function (data) {
				$scope.allMovies = data;
			});
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
