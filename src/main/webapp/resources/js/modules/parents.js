angular.module('parentsApp', ['restApp'])
    .factory('parentsService', function () {
        return {
            getLocusCodes: function () {
                var locusCodes = ['just', 'put', 'something', 'here'];
                return locusCodes;
            },
            getPi: function () {
                var pi = null;
                return pi;
            }
        };
    })
    .controller('parentsController', function ($scope, locusRest, kitRest) {
        $scope.locuses = [];
        kitRest.get({}, function (data) {
            $scope.kits = data.kits;
        });

        $scope.selectKit = function () {
            console.log($scope.kit);
            locusRest.get({kit: $scope.kit}, function (data) {
                console.log(data.codes);
                $scope.locusCodes = data.codes;
            });
        };

        $scope.add = function () {
            $scope.locuses.push(
                {
                    code: $scope.code,
                    af1: $scope.af1,
                    af2: $scope.af2,
                    m1: $scope.m1,
                    m2: $scope.m2,
                    c1: $scope.c1,
                    c2: $scope.c2,
                    pi: parentsService.getPi()
                }
            );
        };
    });