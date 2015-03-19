'use strict';

angular.module('schejewelApp')
    .controller('DashboardCtrl', function ($scope, Auth) {
        Auth.getResources();
        $scope.events = [{
            title: 'Pick up group',
            datetime: '1428333624006'
        }, {
            title: 'Go fishing',
            datetime: '1438333624006'
        }, {
            title: 'Eat Dinner',
            datetime: '1438333624006'
        }, {
            title: 'Return to Ships',
            datetime: '1438333624006'
        }, {
            title: 'Pick up next group',
            datetime: '1438333624006'
        }, {
            title: 'Go fishing',
            datetime: '1438333624006'
        }];

        $scope.messages = [{
            from: 'Joe',
            subject: 'Flat tire on bus',
            message: 'Hey, I\'m just following up on the flat tire on the bus.  Any progress for that?',
            datetime: '1428333624006'
        }, {
            from: 'Jim',
            subject: 'Sick',
            message: 'I woke up with a fever today. I won\'t be able to make it in',
            datetime: '1438333624006'
        }, {
            from: 'Jack',
            subject: 'Company party',
            message: 'This is a reminder about the company party.  It is this friday at Jim\'s house.  It starts at 7.  Make sure to bring the food item you were assigned',
            datetime: '1438333624006'
        }];

        $scope.tours = [{
            title: 'Crab Fishing Tour',
            personCount: 58,
            events: [{
                title: 'Event 1',
                startTime: new Date(2015, 3, 3, 6, 0, 0),
                endTime: new Date(2015, 3, 3, 7, 0, 0),
            }, {
                title: 'Event 3',
                startTime: new Date(2015, 3, 3, 7, 0, 0),
                endTime: new Date(2015, 3, 3, 11, 0, 0),
            }, {
                title: 'Event 4',
                startTime: new Date(2015, 3, 3, 11, 0, 0),
                endTime: new Date(2015, 3, 3, 12, 0, 0),
            }]
        }, {

            title: 'Crab Fishing Tour',
            personCount: 58,
            events: [{
                title: 'Event 3',
                startTime: new Date(2015, 3, 3, 9, 0, 0),
                endTime: new Date(2015, 3, 3, 11, 0, 0),
            }, {
                title: 'Event 4',
                startTime: new Date(2015, 3, 3, 11, 0, 0),
                endTime: new Date(2015, 3, 3, 12, 0, 0),
            }, {
                title: 'Event 5',
                startTime: new Date(2015, 3, 3, 12, 0, 0),
                endTime: new Date(2015, 3, 3, 14, 0, 0),
            }]
        }, {

            title: 'Crab Fishing Tour',
            personCount: 58,
            events: [{
                title: 'Event 6',
                startTime: new Date(2015, 3, 3, 14, 0, 0),
                endTime: new Date(2015, 3, 3, 15, 0, 0),
            }, {
                title: 'Event 7',
                startTime: new Date(2015, 3, 3, 15, 0, 0),
                endTime: new Date(2015, 3, 3, 16, 0, 0),
            }, {
                title: 'Event 8',
                startTime: new Date(2015, 3, 3, 16, 0, 0),
                endTime: new Date(2015, 3, 3, 17, 0, 0),
            }, {
                title: 'Go fishing',
                startTime: new Date(2015, 3, 3, 17, 0, 0),
                endTime: new Date(2015, 3, 3, 21, 0, 0),
                resources: [{
                    name: 'Blue bus',
                    id: 34523,
                    contactNumber: '(493)403-4930'
                }]
            }]
        }, {

            title: 'Crab Fishing Tour',
            personCount: 58,
            events: [{
                title: 'Event 4',
                startTime: new Date(2015, 3, 3, 11, 0, 0),
                endTime: new Date(2015, 3, 3, 12, 0, 0),
            }, {
                title: 'Event 5',
                startTime: new Date(2015, 3, 3, 12, 0, 0),
                endTime: new Date(2015, 3, 3, 14, 0, 0),
            }, {
                title: 'Event 6',
                startTime: new Date(2015, 3, 3, 14, 0, 0),
                endTime: new Date(2015, 3, 3, 15, 0, 0),
            }, {
                title: 'Go fishing',
                startTime: new Date(2015, 3, 3, 15, 0, 0),
                endTime: new Date(2015, 3, 3, 17, 0, 0),
                resources: [{
                    name: 'Blue bus',
                    id: 34523,
                    contactNumber: '(493)403-4930'
                }]
            }]
        }, {

            title: 'Crab Fishing Tour',
            personCount: 58,
            events: [{
                title: 'Event 5',
                startTime: new Date(2015, 3, 3, 12, 0, 0),
                endTime: new Date(2015, 3, 3, 14, 0, 0),
            }, {
                title: 'Event 6',
                startTime: new Date(2015, 3, 3, 14, 0, 0),
                endTime: new Date(2015, 3, 3, 15, 0, 0),
            }, {
                title: 'Event 7',
                startTime: new Date(2015, 3, 3, 15, 0, 0),
                endTime: new Date(2015, 3, 3, 16, 0, 0),
            }, {
                title: 'Event 8',
                startTime: new Date(2015, 3, 3, 16, 0, 0),
                endTime: new Date(2015, 3, 3, 17, 0, 0),
            }, {
                title: 'Go fishing',
                startTime: new Date(2015, 3, 3, 17, 0, 0),
                endTime: new Date(2015, 3, 3, 23, 0, 0),
                resources: [{
                    name: 'Blue bus',
                    id: 34523,
                    contactNumber: '(493)403-4930'
                }]
            }]
        }];

        $scope.value = "LOLZERS";

        $scope.visibleDirective = 'calendar';

    });
