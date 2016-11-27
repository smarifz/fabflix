'use strict';

angular.module('synerApp')
.controller("MainCtrl",function ($scope, $location, $window, AuthService, MoviesService) {

	console.log(AuthService.currentUser());
	//Local variables
	$scope.allGenres = [];


	//Initialize /////////////////////////////////////////////////////////////////////
	$scope.init = function () {
		$scope.reloadAllGenreTable ();
	};

	$scope.reloadAllGenreTable = function(){
		MoviesService.getGenres()
			.success (function (data, status, headers) {
				$scope.allGenres = data;
			});
	};

	$scope.search = function(title){
		$location.path( '/movies/title/'+title );
	};
});
