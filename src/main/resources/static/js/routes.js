/**
 *
 */
angular.module("myApp")
	.config(function ($routeProvider) {

	$routeProvider
		.when('/', {
			templateUrl: 'views/users.html',
			controller: 'userController'
		})
		.when('/users2', {
			templateUrl: 'views/users2.html',
			controller: 'userController'
		})
		.otherwise({
			redirectTo: '/'
		})
});
