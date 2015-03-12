'use strict';

angular.module('schejewelApp')
    .controller('NavbarCtrl', function ($scope, $rootScope, $location, Auth) {
        $scope.user = Auth.getCurrentUser();
        $rootScope.$on('action.loggedIn', function () {
            $scope.user = Auth.getCurrentUser();
        });
        $scope.menu = [{
            'title': 'Home',
            'link': '/'
        }, {
            'title': 'Dashboard',
            'link': '/dashboard'
        }, {
            'title': 'Admin',
            'link': '/admin'
        }, {
            'title': 'Item 3',
            'link': '/item3'
        }, {
            'title': 'Item 4',
            'link': '/item4'
        }];

        $scope.isCollapsed = true;

        $scope.isActive = function (route) {
            return route === $location.path();
        };

        $scope.logout = function () {
            Auth.logout();

        };
    });
