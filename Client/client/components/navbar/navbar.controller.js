'use strict';

angular.module('schejewelApp')
    .controller('NavbarCtrl', function($scope, $location) {
        $scope.menu = [{
            'title': 'Home',
            'link': '/'
        }, {
            'title': 'Dashboard',
            'link': '/dashboard'
        }, {
            'title': 'Item 2',
            'link': '/item2'
        }, {
            'title': 'Item 3',
            'link': '/item3'
        }, {
            'title': 'Item 4',
            'link': '/item4'
        }];

        $scope.isCollapsed = true;

        $scope.isActive = function(route) {
            return route === $location.path();
        };
    });
