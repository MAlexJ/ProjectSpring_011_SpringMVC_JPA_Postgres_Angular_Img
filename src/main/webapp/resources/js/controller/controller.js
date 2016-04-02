'use strict';


myApp.controller('homeController', function () {

});


myApp.controller('articleController', function () {

});

myApp.controller('adminImageController', function ($scope, $http, fileUpload) {

    // GET: list -> request get  
    $http.get('/images').success(function (data) {
        $scope.images = data;
    }).error(function (data, status) {
        console.log("код ответа: " + status);
    });

    // GET: list -> click to button
    $scope.viewImage = function () {
        $http.get('/images').success(function (data) {
            $scope.images = data;
        }).error(function (data, status) {
            console.log("код ответа: " + status);
        });
    };

    // POST: image -> click to button
    $scope.uploadFile = function () {
        var file = $scope.myFile;
        var uploadUrl = "/images";
        fileUpload.uploadFileToUrl(file, uploadUrl);
    };

});

myApp.controller('adminArticleController', function ($scope, $http) {

    $scope.save = function (article, articleForm) {
        if (articleForm.$valid) {
            $http.post('/article', article).success(function () {
                {
                    $scope.article.title = "";
                    $scope.article.desctiption = "";
                }
            });
        }
    }

});