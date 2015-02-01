/* global */
'use strict';

angular.module('schejewelApp')
    .controller('LoginCtrl', function($scope, $http, $location, Auth) {
        Auth.isLoggedIn().then(function(loggedIn) {
            if (loggedIn) {
                $location.path('/dashboard');
            }
        });
        $scope.validate = function() {
            if ($scope.email && $scope.password) {
                Auth.login().then(function() {
                    location.reload();
                });
            }
        };
    });
