/* global */
'use strict';

angular.module('schejewelApp')
    .controller('LoginCtrl', function($scope, $rootScope, $http, $location, Auth) {
        $scope.email = 'jacob@gmail.com';
        $scope.password = '1234';
        Auth.isLoggedIn().then(function(loggedIn) {
            if (loggedIn) {
                $location.path('/dashboard');
            }
        });
        $scope.validate = function() {
            if ($scope.email && $scope.password) {
                Auth.login($scope.email, $scope.password).then(function(user) {
                    $scope.user = user;
                    $rootScope.$emit('action.loggedIn', {});
                    $location.path('/dashboard')

                });
            }
        };
    });
