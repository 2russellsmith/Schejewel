'use strict';

angular.module('schejewelApp')
    .controller('LoginCtrl', function($scope, $http) {
        $scope.validate = function() {
            $http.post('http://104.131.170.128:8080/alaska-excursions/api/user/validate', {
                email: $scope.email,
                password: $scope.password
            }).then(function(result) {
                console.log('result', result);
            });
        };
    });
