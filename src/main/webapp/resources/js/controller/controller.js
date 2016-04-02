'use strict';


myApp.controller('homeController', function () {

});


myApp.controller('articleController', function () {

});

myApp.controller('adminArticleController', function ($scope, $http, fileUpload) {

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