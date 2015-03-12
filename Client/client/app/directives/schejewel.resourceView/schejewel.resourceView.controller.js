'use strict';

angular.module('schejewelApp')
    .controller('TableController', ['$scope', function ($scope) {

        $scope.dummyData = ['6:00', '6:30', '7:00', '7:30', '8:00', '8:30', '9:00', '9:30', '10:00', '10:30', '11:00', '11:30', '12:00', '12:30', '1:00', '1:30',
            '2:00', '2:30', '3:00', '3:30', '4:00', '4:30', '5:00', '5:30'
        ];
        $scope.Columns = [{
            'resourceType': 'Bus1',
            'useTimes': [{
                    'startTime': '11:00',
                    'endTime': '11:30'
                },

                {
                    'startTime': '13:00',
                    'endTime': '13:30'
                }
            ]
        }, {
            'resourceType': 'Bus2',
            'useTimes': [{
                    'startTime': '11:00',
                    'endTime': '11:30'
                },

                {
                    'startTime': '13:00',
                    'endTime': '13:30'
                }
            ]
        }];



        $scope.calculateTimeStart = function (start) {
            var a = start.split(':'); // split it at the colons

            var minutes = (+a[0]) * 60 + (+a[1]) - 6 * 60 + 19;
            return minutes;
        };
        $scope.calculateTimeDuration = function (start, end) {
            var a = start.split(':'); // split it at the colons
            var b = end.split(':'); // split it at the colons
            var minutesA = (+a[0]) * 60 + (+a[1]);
            var minutesB = (+b[0]) * 60 + (+b[1]);
            var result = Number(minutesB) - Number(minutesA) - 1;
            return result.toString();
        };

        $scope.getStyle = function (start, end) {
            var response = {
                'top': $scope.calculateTimeStart(start) + 'px',
                'height': $scope.calculateTimeDuration(start, end) + 'px'
            };
            return response;
        };

        $scope.hidden = true;

        $scope.appear = function () {
            $scope.hidden = !$scope.hidden;
            $scope.$apply();
        };

        $scope.$on('handleBroadcast', function (event, data) {
            $scope.hidden = data.message;
        });
    }]);
