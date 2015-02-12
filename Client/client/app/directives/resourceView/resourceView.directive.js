'use strict';

angular.module('schejewelApp')
  .directive('resourceView', function () {
    return {
      templateUrl: 'app/directives/resourceView/resourceView.html',
      restrict: 'EA',
      link: function (scope, element, attrs) {
      }
    };
  });