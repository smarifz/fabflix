'use strict';

angular.module ('synerApp')
	.controller ('StarInfoCtrl', function ($rootScope, $scope, $routeParams, StarService) {
		$scope.starInfo = {};

		//Initialize /////////////////////////////////////////////////////////////////////
		$scope.init = function () {
			StarService.getStarInfo($routeParams.id).success (function (data) {
				$scope.starInfo = data;
			});
		};


	});
