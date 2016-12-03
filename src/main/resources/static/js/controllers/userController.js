/**
 *
 */

angular.module("myApp")
	.controller('userController', ['$scope', '$http', 'Users',
		function($scope, $http, Users) {

	$scope.members = [];
	$scope.userId = '';
	$scope.userName = '';

	$scope.fetch = function() {
		Users.fetch().then(function(data) {
			$scope.members = data;
	    });
	};

	$scope.registerPost = function() {
		Users.registerPost($scope.userId, $scope.userName).then(function(data) {
			$scope.userId = '';
			$scope.userName = '';

			$scope.fetch();
	    });
	};

	$scope.fetch();
}]);
