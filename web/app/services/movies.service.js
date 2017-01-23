'use strict'
//Service for getting and setting data into MongoDB via API.
angular.module ('synerApp')
	.service ('MoviesService', ['$http', 'AuthService', function ($http, $scope, AuthService) {

		var attributes = {
			searchParams: '',
			title: '',
			year: '',
			director: '',
			lname: '',
			fname: ''
		};

		//Get all the movies
		var getMoviesRequest = function (type, attr) {
			return $http.get ('/api/movies',{
				params: {type: type, attribute: attr}
			});
		};

		//Get one event using ID
		var getMovieRequest = function (id) {
			return $http.get ('/api/movies',{
				params: {type: 'single', attribute: id}
			});
		};

		//Get all the genres
		var getGenresRequest = function () {
			return $http.get ('/api/movies/genres');
		};

		//Search - ADV search off
		var searchRequest = function (searchParams) {
			return $http.get ('/api/search',{
				params: {
					searchParams: searchParams,
					advSearch: false
				}
			});
		};

		//Search - ADV search one
		var advSearchRequest = function (searchParams) {
			return $http.get ('/api/search',{
				params: {
					title: searchParams.title,
					year: searchParams.year,
					director: searchParams.director,
					fname: searchParams.fname,
					lname: searchParams.lname,
					advSearch: true
				}
			});
		};

		var setAttributesRequest = function(data){
			attributes = data;
		};

		var getAttributesRequest = function(){
			return attributes;
		};


		//All the returned methods for this service.
		return {
			getMovie: function (id) {
				return getMovieRequest (id);
			},
			getMovies: function (type, attr) {
				return getMoviesRequest (type, attr);
			},
			getGenres: function () {
				return getGenresRequest ();
			},
			search: function (searchParams) {
				return searchRequest (searchParams);
			},

			advSearch: function (searchParams) {
				return advSearchRequest (searchParams);
			},

			setAttributes: function(data){
				return setAttributesRequest(data);
			},

			getAttributes: function(){
				return getAttributesRequest();
			}

		};


	}]);