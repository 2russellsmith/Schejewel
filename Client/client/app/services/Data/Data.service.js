'use strict';

angular.module('schejewelApp')
    .service('Data', function($q) {
        var api_url = 'http://Default-Environment-69yjsdh6ez.elasticbeanstalk.com/api/';

        return {
            getResources: function() {
                var deferred = $q.defer();

                deferred.resolve([{
                    name: 'Ship'
                }, {
                    name: 'Boat'
                }, {
                    name: 'Dinning Room'
                }, {
                    name: 'Airplane'
                }]);

                return deferred.promisae;
            }
        };
    });
