'use strict';

angular.module ('synerApp')
	.controller ('MovieListSearchCtrl', function ($scope, $routeParams, MoviesService) {
		$scope.allMovies = [];
		$scope.moviesPerPage = 10;
		$scope.moviesPerPageList = [10,25,50, 100];

		//Initialize /////////////////////////////////////////////////////////////////////
		$scope.init = function () {
			if($routeParams.advSearch === "true"){
				MoviesService.advSearch (MoviesService.getAttributes()).success (function (data) {
					$scope.allMovies = data;
				});
			}else {
				MoviesService.search ($routeParams.searchParams).success (function (data) {
					$scope.allMovies = data;
				});
			}
		};

		//Clear input fields /////////////////////////////////////////////////////////////////////
		$scope.clearFields = function () {
			$scope.eventName = "";
			$scope.eventLocation = "";
			$scope.eventDate = "";
			$scope.eventTotalAttnds = "";
		};


	});
