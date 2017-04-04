(function (angular) {

    'use strict';

    var App = angular.module('App');

    App.controller('WeatherController', ['$scope', '$http', '$routeParams', '$rootScope',
        function ($scope, $http, $routeParams, $rootScope) {

            $scope.init = function () {
                $rootScope.city = 'Wroclaw';
                $scope.getWeather($rootScope.city);
            };
            
            $scope.getWeather = function (city) {

                $http.get('/weather', {
                    params: {city: encodeURI(city)}
                }).then(function (response) {
                    $scope.showError = false;
                    $scope.weather = response.data;
                    $scope.weatherAvailable = true;
                }, function (response) {
                    $scope.showError = true;
                })
            };

            $scope.init();

        }]);

})(window.angular);