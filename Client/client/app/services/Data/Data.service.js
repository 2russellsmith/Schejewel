'use strict';

angular.module('schejewelApp')
    .service('Data', function($q, $http, Auth) {
        var url = 'http://Default-Environment-69yjsdh6ez.elasticbeanstalk.com/api/';
        var Token = Auth.getToken();

        return {
            getResources: function (dateString) {
                var deferred = $q.defer();
                if(dateString === undefined){
                  $http.defaults.headers.common['X-AUTH-TOKEN'] = Token;
                  $http.get(url + 'resources').success(function (data, status, headers, config) {
                      deferred.resolve(data);
                  })
                }
                else{
                  $http.defaults.headers.common['X-AUTH-TOKEN'] = Token;
                  console.log(url + 'resources/'+ dateString);
                  $http.get(url + 'resources/'+dateString/*+milliseconds.getTime()*/).success(function (data, status, headers, config) {
                      deferred.resolve(data);
                  })
                }

                return deferred.promise
            },
            addTour: function (tourData) {
                var deferred = $q.defer();
                if(tourData === undefined){
                    return;
                }
                else{
                  $http.defaults.headers.common['X-AUTH-TOKEN'] = Token;
                  $http.post(url + 'tour/'+tourData).success(function (data, status, headers, config) {
                      deferred.resolve(data);
                  })
                }

                return deferred.promise
            }

        };
    });
