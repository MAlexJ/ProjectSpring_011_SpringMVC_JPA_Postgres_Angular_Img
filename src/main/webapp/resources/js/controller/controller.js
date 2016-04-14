'use strict';

// ************  Home Page  ******************

myApp.controller('homeController', function ($scope, $http) {
    
    
    // GET: category list
    $http.get('/homeGetListCategory').success(function (data) {
        $scope.categoryLesson = data;       
    }).error(function (data, status) {
        console.log("код ответа: " + status);
    });

    // // GET: list java -> request get
    // $http.get('/homeListLessonJava').success(function (data) {
    //     $scope.listLessonJava = data;
    // }).error(function (data, status) {
    //     console.log("код ответа: " + status);
    // });

    $scope.getArticleView = function (category, id) {
        if(id>0 && category!=''){
            console.log("category: " + category);
            console.log("id: " + id);
            $http.get('/articleView/'+category+'/'+id);

        }
    }
});

// ************ Lesson Page ******************

myApp.controller('angularController', function () {

});

myApp.controller('javaController', function () {

});

myApp.controller('springController', function () {

});

myApp.controller('infoController', function () {

});

myApp.controller('postgresController', function () {

});


// ************  Admin Page ******************

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

    // GET: list -> request get
    $http.get('/article').success(function (data) {
        $scope.imgData = data;
    }).error(function (data, status) {
        console.log("код ответа: " + status);
    });

    // GET: list -> request get
    $http.get('/category').success(function (data) {
        $scope.articleData = data;
    }).error(function (data, status) {
        console.log("код ответа: " + status);
    });

    // GET: Id {id} -> request get
    $scope.getArticle = function (articleFormPreview) {
        if (articleFormPreview.$valid) {
            var id = this.selectArticleData;
            $http.get('/article/' + id).success(function (data) {
                $scope.articleWithImg = data;
            }).error(function (data, status) {
                console.log("код ответа: " + status);
            });
        }
    };

    // POST: article -> click to button
    $scope.save = function (article, eList, imgList, articleForm) {
        if (articleForm.$valid && imgList != '') {
            var articleCreate = {
                title: article.title,
                description: article.description,
                enumType: eList,
                imageName: imgList
            };

            $http.post('/article', articleCreate).success(function () {
                {
                    $scope.article.title = "";
                    $scope.article.description = "";
                }
            }).success(function () {

                // GET: list article -> request get
                $http.get('/article').success(function (data) {
                    $scope.imgData = data;
                }).error(function (data, status) {
                    console.log("код ответа: " + status);
                });

                // GET: list category -> request get
                $http.get('/category').success(function (data) {
                    $scope.articleData = data;
                }).error(function (data, status) {
                    console.log("код ответа: " + status);
                });

            });
        }
    }

});