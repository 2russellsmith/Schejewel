'use strict';

angular.module('schejewelApp')
    .controller('DashboardCtrl', function($scope) {
        $scope.events = [{
            title: 'Pick up group'
        }, {
            title: 'Go fishing'
        }];
    });
