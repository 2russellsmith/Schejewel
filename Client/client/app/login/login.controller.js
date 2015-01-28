/* global */
'use strict';

angular.module('schejewelApp')
    .controller('LoginCtrl', function($scope, $http, $location) {
        $scope.validate = function() {
            // if ($scope.email && $scope.password) {
                $http.get('http://104.131.170.128:8080/alaska-excursions/api/login', {
                    headers: {
                        'Authorization': 'Basic ZW5jcnlwdEBnbWFpbC5jb206MTIzNA=='
                    }
                }).success(function(result) {
                    console.log(JSON.stringify(result));
                    // $location.path('/dashboard');
                }).error(function(data, status) {
                    console.log('data', data);
                });
            // }

        };
    });
