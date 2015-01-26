/* global alert */
'use strict';

angular.module('schejewelApp')
    .controller('LoginCtrl', function($scope, $http, $location) {
        $scope.validate = function() {
            if ($scope.email && $scope.password) {
                $http.post('http://104.131.170.128:8080/alaska-excursions/api/user/validate', {
                    email: $scope.email,
                    password: $scope.password
                }).success(function(result) {
                    alert(JSON.stringify(result));
                    $location.path('/dashboard');
                }).error(function(data, status) {
                    alert('Error.  Check console: ' + JSON.stringify(status));
                });
            }
        };
    });
