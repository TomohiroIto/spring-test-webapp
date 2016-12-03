
angular.module("myApp")
	.service('Users', ['$http', '$q', function ($http, $q) {

	this.fetch = function() {
		var defer = $q.defer();

		$http({
			method: 'GET',
			url: '/users'
		}).success(function(data, status) {
			defer.resolve(data);
		}).error(function(data, status) {
			defer.reject(data);
		});

		return defer.promise;
	};

	this.registerPost = function(puserId, puserName) {
		var defer = $q.defer();

		$http({
			method: 'POST',
			url: '/users',
			data: { userId: puserId, userName: puserName }
		}).success(function(data, status) {
			defer.resolve(data);
		}).error(function(data, status) {
			defer.reject(data);
		});

		return defer.promise;
	};
}]);
