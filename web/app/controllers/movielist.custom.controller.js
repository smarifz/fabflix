'use strict';

angular.module ('synerApp')
	.controller ('MovieListCustomCtrl', function ($scope, $routeParams, MoviesService) {
		$scope.allMovies = [];


		//Initialize /////////////////////////////////////////////////////////////////////
		$scope.init = function () {
			MoviesService.getMovies($routeParams.type, $routeParams.attribute).success (function (data) {
				$scope.allMovies = data;
			});
		};

		//Clear input fields /////////////////////////////////////////////////////////////////////
		$scope.clearFields = function () {
			$scope.eventName = "";
			$scope.eventLocation = "";
			$scope.eventDate = "";
			$scope.eventTotalAttnds = "";
		}


	});
