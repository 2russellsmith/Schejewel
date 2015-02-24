'use strict';

angular.module('schejewelApp')
    .directive('schejewel.buttonNav', function() {
        return {
            templateUrl: 'app/directives/schejewel.buttonNav/schejewel.buttonNav.html',
            restrict: 'EA',
            link: function(scope, element, attrs) {}
        };
    });
