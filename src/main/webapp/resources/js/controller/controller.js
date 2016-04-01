'use strict';

myApp.controller('articleController', function ($scope, $http) {

    // GET: list
    $http.get('/images').success(function (data) {
        $scope.images = data;
    }).error(function (data, status) {
        console.log("код ответа: " + status);
    });

    $scope.file = {}; //Модель
    $scope.options = {
        //Вызывается для каждого выбранного файла
        change: function (file) {
            //В file содержится информация о файле
            //Загружаем на сервер
            file.$upload('/images', $scope.file)
        }
    };
});

myApp.controller('myCtrl', ['$scope', 'fileUpload', function ($scope, fileUpload) {

    $scope.uploadFile = function () {
        var file = $scope.myFile;
        var uploadUrl = "/images";
        fileUpload.uploadFileToUrl(file, uploadUrl);
    };

}]);


