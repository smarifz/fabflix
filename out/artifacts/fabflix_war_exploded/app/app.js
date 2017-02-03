'use strict';

var app = angular.module ('synerApp', [
		'ngCookies',
		'ngResource',
		'ngSanitize',
		'ngRoute',
		'ui.bootstrap',
		'angularUtils.directives.dirPagination',
		'ngStorage'
	])

	.config (function ($routeProvider, $locationProvider) {

		$routeProvider
			.when ('/', {
				templateUrl: 'app/views/main.html',
				controller: 'MainCtrl',
				//resolve: {
				//	auth: ["$q", "AuthService", function ($q, AuthService) {
				//		var isUserLoggedIn = AuthService.isLoggedIn ();
				//		if (isUserLoggedIn) {
				//			console.log ("User Logged in");
				//			return $q.when (isUserLoggedIn);
				//		} else {
				//			console.log ("ERROR - No User Logged in");
				//			return $q.reject ({authenticated: false});
				//		}
				//	}]
				//}
			})


			.when ('/users', {
				templateUrl: 'app/views/users.html',
				controller: 'UserCtrl',
				resolve: {
					auth: ["$q", "AuthService", function ($q, AuthService) {
						var isUserLoggedIn = AuthService.isLoggedIn ();
						if (isUserLoggedIn) {
							console.log ("User Logged in");
							return $q.when (isUserLoggedIn);
						} else {
							console.log ("ERROR - No User Logged in");
							return $q.reject ({authenticated: false});
						}
					}]
				}
			})

			.when ('/cart', {
				templateUrl: 'app/views/shoppingcart.html',
				controller: 'ShoppingCartCtrl',
				//resolve: {
				//	auth: ["$q", "AuthService", function ($q, AuthService) {
				//		var isUserLoggedIn = AuthService.isLoggedIn ();
				//		if (isUserLoggedIn) {
				//			console.log ("User Logged in");
				//			return $q.when (isUserLoggedIn);
				//		} else {
				//			console.log ("ERROR - No User Logged in");
				//			return $q.reject ({authenticated: false});
				//		}
				//	}]
				//}
			})

			//.when('/movies', {
			//  templateUrl: 'app/views/movielist.html',
			//  controller: 'MoviesCtrl',
			//  resolve: {
			//    auth: ["$q", "AuthService", function($q, AuthService) {
			//    var isUserLoggedIn = AuthService.isLoggedIn();
			//    if(isUserLoggedIn){
			//      console.log("User Logged in");
			//      return $q.when(isUserLoggedIn);
			//    }else{
			//      console.log("ERROR - No User Logged in");
			//      return $q.reject({ authenticated: false });
			//    }
			//  }]}
			//})

			.when ('/movies/:type/:attribute', {
				templateUrl: 'app/views/movielist.html',
				controller: 'MovieListCustomCtrl',
				//resolve: {
				//	auth: ["$q", "AuthService", function ($q, AuthService) {
				//		var isUserLoggedIn = AuthService.isLoggedIn ();
				//		if (isUserLoggedIn) {
				//			console.log ("User Logged in");
				//			return $q.when (isUserLoggedIn);
				//		} else {
				//			console.log ("ERROR - No User Logged in");
				//			return $q.reject ({authenticated: false});
				//		}
				//	}]
				//}
			})

			.when ('/movies/a/search/:searchParams/:advSearch', {
				templateUrl: 'app/views/movielist.html',
				controller: 'MovieListSearchCtrl',
				//resolve: {
				//	auth: ["$q", "AuthService", function ($q, AuthService) {
				//		var isUserLoggedIn = AuthService.isLoggedIn ();
				//		if (isUserLoggedIn) {
				//			console.log ("User Logged in");
				//			return $q.when (isUserLoggedIn);
				//		} else {
				//			console.log ("ERROR - No User Logged in");
				//			return $q.reject ({authenticated: false});
				//		}
				//	}]
				//}
			})

			.when ('/movies/advSearch', {
				templateUrl: 'app/views/advSearch.html',
				controller: 'MovieListAdvSearchCtrl',
				//resolve: {
				//	auth: ["$q", "AuthService", function ($q, AuthService) {
				//		var isUserLoggedIn = AuthService.isLoggedIn ();
				//		if (isUserLoggedIn) {
				//			console.log ("User Logged in");
				//			return $q.when (isUserLoggedIn);
				//		} else {
				//			console.log ("ERROR - No User Logged in");
				//			return $q.reject ({authenticated: false});
				//		}
				//	}]
				//}
			})


			.when ('/star/:id', {
				templateUrl: 'app/views/starInfo.html',
				controller: 'StarInfoCtrl',
				//resolve: {
				//	auth: ["$q", "AuthService", function ($q, AuthService) {
				//		var isUserLoggedIn = AuthService.isLoggedIn ();
				//		if (isUserLoggedIn) {
				//			console.log ("User Logged in");
				//			return $q.when (isUserLoggedIn);
				//		} else {
				//			console.log ("ERROR - No User Logged in");
				//			return $q.reject ({authenticated: false});
				//		}
				//	}]
				//}
			})

			.when ('/movie/:id', {
				templateUrl: 'app/views/movieInfo.html',
				controller: 'MovieInfoCtrl',
				//resolve: {
				//	auth: ["$q", "AuthService", function ($q, AuthService) {
				//		var isUserLoggedIn = AuthService.isLoggedIn ();
				//		if (isUserLoggedIn) {
				//			console.log ("User Logged in");
				//			return $q.when (isUserLoggedIn);
				//		} else {
				//			console.log ("ERROR - No User Logged in");
				//			return $q.reject ({authenticated: false});
				//		}
				//	}]
				//}
			})

			.when ('/checkout', {
				templateUrl: 'app/views/checkout.html',
				controller: 'ShoppingCartCtrl',
				resolve: {
					auth: ["$q", "AuthService", function ($q, AuthService) {
						var isUserLoggedIn = AuthService.isLoggedIn ();
						if (isUserLoggedIn) {
							console.log ("User Logged in");
							return $q.when (isUserLoggedIn);
						} else {
							console.log ("ERROR - No User Logged in");
							return $q.reject ({authenticated: false});
						}
					}]
				}
			})

			.when ('/confirmation', {
				templateUrl: 'app/views/confirmation.html',
				controller: 'ShoppingCartCtrl',
				resolve: {
					auth: ["$q", "AuthService", function ($q, AuthService) {
						var isUserLoggedIn = AuthService.isLoggedIn ();
						if (isUserLoggedIn) {
							console.log ("User Logged in");
							return $q.when (isUserLoggedIn);
						} else {
							console.log ("ERROR - No User Logged in");
							return $q.reject ({authenticated: false});
						}
					}]
				}
			})

			.when ('/failed', {
				templateUrl: 'app/views/failed.html',
				controller: 'ShoppingCartCtrl'
			})

			.when ('/register', {
				templateUrl: 'app/views/register.html',
				controller: 'UserCtrl'
			})

			.when ('/login', {
				templateUrl: 'app/views/login.html',
				controller: 'AuthCtrl'

			})


			.when ('/logout', {
				templateUrl: 'app/views/logout.html',
				controller: 'AuthCtrl',
			})

			.otherwise ({
				            redirectTo: '/'
			            });

		$locationProvider.html5Mode (true);
	});

app.run (["$rootScope", "$location", 'ShoppingCartService', 'LocationHistoryService', function ($rootScope, $location, ShoppingCartService, LocationHistoryService) {

	//console.log ("routeChangeSuccess ");
	$rootScope.$on ("$routeChangeSuccess", function (userInfo, $location) {
		console.log ("Route changed");
		//LocationHistoryService.store($location.$$route.originalPath);
		ShoppingCartService.reverseSync ();
		//if (LocationHistoryService.get() === '/confirmation') {
		//	ShoppingCartService.nullifyInvoice();
		//}
	});

	$rootScope.$on('$locationChangeStart', function(e, newLocation, oldLocation){
		LocationHistoryService.store(oldLocation);

		if(LocationHistoryService.get().includes("/confirmation")){
			ShoppingCartService.nullifyInvoice();
		}
	});

	$rootScope.$on ("$routeChangeError", function (event, current, previous, eventObj) {
		if (eventObj.authenticated === false) {
			console.log ("Error occured. Now in routeChangeError");
			$location.path ("/");
		}
	});
}]);


//HTTP Interceptor intercepts any HTTP calls made to backend. We use JWT to declare the header with token given to us
// at login.
app.factory ('myHttpResponseInterceptor', ['$q', '$location', '$window', function ($q, $location, $window) {
	return {
		'request': function (config) {
			config.headers = config.headers || {};


			if ($window.localStorage['SECRET']) {
				config.headers.Authorization = 'Bearer ' + $window.localStorage['SECRET'];
			}
			// console.log('httpProvider token: '+$window.localStorage['SECRET']);

			return config;
		},
		'responseError': function (response) {
			if (response.status === 401 || response.status === 403) {
				$location.path ('/login');
			}
			return $q.reject (response);
		}
	};
}]);


//Http Intercpetor to check auth failures for xhr requests
app.config (['$httpProvider', function ($httpProvider) {
	$httpProvider.interceptors.push ('myHttpResponseInterceptor');
}]);


//Filter used to capitalize first letter of a string
app.filter ('capitalize', function () {
	return function (input, scope) {
		if (input == null)
			return;
		if (input != null)
			input = input.toLowerCase ();
		return input.substring (0, 1).toUpperCase () + input.substring (1);
	}
});

