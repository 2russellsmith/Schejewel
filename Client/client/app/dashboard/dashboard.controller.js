'use strict';

angular.module('schejewelApp')
    .controller('DashboardCtrl', function($scope) {
        $scope.events = [{
            title: 'Pick up group',
            datetime: '1428333624006'
        }, {
            title: 'Go fishing',
            datetime: '1438333624006'
        }];
    });
