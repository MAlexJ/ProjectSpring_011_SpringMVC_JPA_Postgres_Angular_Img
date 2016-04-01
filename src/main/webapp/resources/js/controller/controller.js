'use strict';

myApp.controller('articleController', function ($scope, $http) {

    // GET: list
    $http.get('/article').success(function (data) {
        $scope.articles = data;
    }).error(function (data, status) {
        console.log("код ответа: " + status);
        console.log("articles: " + articles);
    });

});


