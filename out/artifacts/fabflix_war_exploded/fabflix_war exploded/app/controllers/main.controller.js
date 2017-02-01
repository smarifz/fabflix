'use strict';

angular.module('synerApp')
.controller("MainCtrl",function ($scope, $location, $window, AuthService, MoviesService) {

	//Local variables
	$scope.allGenres = [];
	$scope.title = false;
	$scope.year = false;
	$scope.director = false;


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

	$scope.search = function(searchParams, advSearch){
		$location.path( '/movies/a/search/'+searchParams+'/'+advSearch );
	};
});
