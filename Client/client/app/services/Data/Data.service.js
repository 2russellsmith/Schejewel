'use strict';

angular.module('schejewelApp')
    .service('Data', function ($q, $http, Auth) {
        var url =
            'http://Default-Environment-69yjsdh6ez.elasticbeanstalk.com/api/';



        return {
            getResources: function (milliseconds) {
                var token = Auth.getToken();
                var deferred = $q.defer();
                if (milliseconds === undefined) {
                    $http.defaults.headers.common['X-AUTH-TOKEN'] =
                        token;
                    $http.get(url + 'resource').success(function (data,
                        status, headers, config) {
                        deferred.resolve(data);
                    })
                } else {
                    $http.defaults.headers.common['X-AUTH-TOKEN'] =
                        token;
                    console.log(url + 'resource' + '/' + milliseconds.getTime());
                    $http.get(url + 'resources' + '' /*+milliseconds.getTime()*/ )
                        .success(function (data, status, headers,
                            config) {
                            deferred.resolve(data);
                        })
                }

                return deferred.promise
            },
            addTour: function (tourData) {
                var token = Auth.getToken();
                var deferred = $q.defer();
                if (tourData === undefined) {
                    return;
                } else {
                    $http.defaults.headers.common['X-AUTH-TOKEN'] =
                        token;
                    $http.post(url + 'tour/' + tourData).success(
                        function (data, status, headers, config) {
                            deferred.resolve(data);
                        })
                }

                return deferred.promise
            }

        };
    });
