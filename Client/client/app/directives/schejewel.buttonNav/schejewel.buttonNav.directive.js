'use strict';

angular.module('schejewelApp')
	.directive('schejewel.buttonNav', function () {
		return {
			templateUrl: 'app/directives/schejewel.buttonNav/schejewel.buttonNav.html',
			restrict: 'EA',
			scope: {
				visibleDirective: '='
			},
			link: function ($scope) {
				$scope.setVisible = function (directiveName) {
					$scope.visibleDirective = directiveName;
				};
                $("#dialog").dialog({
                    autoOpen: false,
                    appendTo: "#Modal",
                    modal: "true",
                    open: function( event, ui ) {}
                });
                $( "#Modal" ).on("click", function() {
                    $("#dialog").dialog("open");
                });
			}
		};
	});
