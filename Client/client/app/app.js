'use strict';

angular.module('schejewelApp', [
        'ngCookies',
        'ngResource',
        'ngSanitize',
        'ui.router'
    ])
    .config(function($stateProvider, $urlRouterProvider, $locationProvider) {
        $urlRouterProvider
            .otherwise('/');

        $locationProvider.html5Mode(true);
    });
