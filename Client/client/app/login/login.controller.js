/* global */
'use strict';

angular.module('schejewelApp')
    .controller('LoginCtrl', function($scope, $http, $location, Auth) {
        $scope.validate = function() {
            if ($scope.email && $scope.password) {
                Auth.login();
            }
        };
    });
