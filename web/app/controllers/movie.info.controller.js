'use strict';

angular.module ('synerApp')
	.controller ('MovieInfoCtrl', function ($rootScope, $scope, $routeParams, MoviesService, ShoppingCartService) {

		$scope.movieInfo = {};

		//Initialize /////////////////////////////////////////////////////////////////////
		$scope.init = function () {
			MoviesService.getMovie ($routeParams.id).success (function (data) {
				$scope.movieInfo = JSON.parse(data.replace('null',''));
			});
		};

		$scope.addToCart = function(){
			var info = {
				title: $scope.movieInfo.title,
				price: '15.99',
				quantity: 1
			};
			ShoppingCartService.addMovie(info);
		};

		$scope.updateQuantity = function(movie){

		};


	});
