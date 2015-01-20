'use strict';

angular.module('schejewelApp')
    .controller('MainCtrl', function($scope, $http) {
        $scope.awesomeThings = [];

        // get a list of events from the api
        $http.get('/api/events/today').success(function(events) {
            $scope.events = events;
        });

    });
