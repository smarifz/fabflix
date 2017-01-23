'use strict';

angular.module ('synerApp')
	.controller ('MovieListAdvSearchCtrl', function ($scope,$location, $routeParams, MoviesService) {
		$scope.allMovies = [];
		$scope.moviesPerPage = 10;
		$scope.moviesPerPageList = [10,25,50, 100];
		$scope.attributes = {
			title: '',
			year: '',
			director: '',
			lname: '',
			fname: ''
		};

		//Initialize /////////////////////////////////////////////////////////////////////
		$scope.init = function () {
		};

		//Search /////////////////////////////////////////////////////////////////////
		$scope.search = function () {
			MoviesService.setAttributes($scope.attributes);
			$location.path( '/movies/a/search/advSearch/true/');
		};

		//Clear input fields /////////////////////////////////////////////////////////////////////
		$scope.clearFields = function () {
			$scope.eventName = "";
			$scope.eventLocation = "";
			$scope.eventDate = "";
			$scope.eventTotalAttnds = "";
		};


	});
