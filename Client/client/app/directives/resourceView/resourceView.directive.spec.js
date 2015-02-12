'use strict';

describe('Directive: resourceView', function () {

  // load the directive's module and view
  beforeEach(module('schejewelApp'));
  beforeEach(module('app/directives/resourceView/resourceView.html'));

  var element, scope;

  beforeEach(inject(function ($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should make hidden element visible', inject(function ($compile) {
    element = angular.element('<resource-view></resource-view>');
    element = $compile(element)(scope);
    scope.$apply();
    expect(element.text()).toBe('this is the resourceView directive');
  }));
});