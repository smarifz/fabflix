'use strict';

angular.module ('synerApp')
	.controller ('MovieInfoCtrl', function ($rootScope, $scope, $routeParams, MoviesService) {
		$scope.movieInfo = {};

		//Initialize /////////////////////////////////////////////////////////////////////
		$scope.init = function () {
			MoviesService.getMovie ($routeParams.id).success (function (data) {
				$scope.movieInfo = JSON.parse(data.replace('null',''));
			});
		};


	});
