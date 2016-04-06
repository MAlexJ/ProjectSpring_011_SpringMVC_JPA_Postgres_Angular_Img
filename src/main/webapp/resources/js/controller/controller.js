'use strict';


myApp.controller('homeController', function () {

});


myApp.controller('articleController', function () {

});

myApp.controller('adminImageController', function ($scope, $http) {
    

    // GET: list -> request get
    $http.get('/images').success(function (data) {
        $scope.images = data;
    }).error(function (data, status) {
        console.log("код ответа: " + status);
    });    

    // POST: image -> click to button
    $scope.uploadFile = function (imgForm, imgRadio, imgFile) {
        if (imgForm.$valid && imgRadio.name == true) {
            var fd = new FormData();
            fd.append('file', imgFile);
            fd.append('type', imgRadio.radio);
            $http.post("/images", fd, {
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            }).success(function () {

                // repeat: get list
                $http.get('/images').success(function (data) {
                    $scope.images = data;
                }).error(function (data, status) {
                    console.log("код ответа: " + status);
                });
            });
            this.imgRadio.radio = 'NONE';
            this.imgRadio.name = false;
        }
    };
    $scope.imgRadio = {
        radio: 'NONE'
    };

    //DELETE
    $scope.deleteImg = function (selectOptDel) {
        if (selectOptDel > 0) {

            $http.delete('/images/' + selectOptDel).success(function () {

                // repeat: get list
                $http.get('/images').success(function (data) {
                    $scope.images = data;
                }).error(function (data, status) {
                    console.log("код ответа: " + status);
                });
            });
        }
        else {
            console.log('Error');
        }
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