'use strict';

angular.module('schejewelApp')
    .directive('schejewel.resourceView', function() {
        return {
            templateUrl: 'app/directives/schejewel.resourceView/schejewel.resourceView.html',
            restrict: 'EA',
            link: function(scope, element, attrs) {}
        };
    });
