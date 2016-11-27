'use strict';

angular.module ('synerApp')
	.controller ('MoviesCtrl', function ($scope, MoviesService, AuthService) {

		//Local variables
		$scope.allMovies = [];
		$scope.sortType     = 'id'; // set the default sort type
		$scope.sortReverse  = false;  // set the default sort order
		$scope.searchFish   = '';     // set the default search/filter term


		//Initialize /////////////////////////////////////////////////////////////////////
		$scope.init = function () {
			$scope.reloadAllMoviesTable ();
			$scope.clearFields ();
		}

		//Initialize /////////////////////////////////////////////////////////////////////
		$scope.reloadAllMoviesTable = function () {
			MoviesService.getMovies()
				.success (function (data, status, headers) {
					$scope.allMovies = data;
				});
		}


		//Get an Event via ID/////////////////////////////////////////////////////////////////////
		$scope.getEvent = function (id) {
			MoviesService.getEvent (id).success (function (data) {
				console.log ("Event retrieved.");
			});

		};

		//Delete an Event /////////////////////////////////////////////////////////////////////
		$scope.deleteEvent = function (event) {

		};

		//Clear input fields /////////////////////////////////////////////////////////////////////
		$scope.clearFields = function () {
			// $scope.eventName = "";
		};
	});
