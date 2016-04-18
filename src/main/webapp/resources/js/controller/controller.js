'use strict';

// ************  Home Page  ******************

myApp.controller('homeController', function ($scope, $http, currentLesson) {

    // GET: list category -> request get
    $http.get('/homeGetListCategory').success(function (data) {
        $scope.categoryLesson = data;
    }).error(function (data, status) {
        console.log("код ответа: " + status);
    });

    // GET: list angular -> request get
    $http.get('/homeListLesson/' + 'ANGULAR').success(function (data) {
        $scope.listLessonAngular = data;
    }).error(function (data, status) {
        console.log("код ответа: " + status);
    });

    // GET: list java -> request get
    $http.get('/homeListLesson/' + 'JAVA').success(function (data) {
        $scope.listLessonJava = data;
    }).error(function (data, status) {
        console.log("код ответа: " + status);
    });

    // GET: list spring -> request get
    $http.get('/homeListLesson/' + 'SPRING').success(function (data) {
        $scope.listLessonSpring = data;
    }).error(function (data, status) {
        console.log("код ответа: " + status);
    });

    // GET: list postgres -> request get
    $http.get('/homeListLesson/' + 'POSTGRES').success(function (data) {
        $scope.listLessonPostgres = data;
    }).error(function (data, status) {
        console.log("код ответа: " + status);
    });

    $scope.homeGetLesson = function (category, id) {
        if (id > 0 && category == 'ANGULAR') {
            currentLesson.setLessonCatId_Angular(category, id);
        }
        if (id > 0 && category == 'JAVA') {
            currentLesson.setLessonCatId_Java(category, id);
        }
        if (id > 0 && category == 'SPRING') {
            currentLesson.setLessonCatId_Spring(category, id);
        }
        if (id > 0 && category == 'POSTGRES') {
            currentLesson.setLessonCatId_Postgres(category, id);
        }
    }
});

// ************ Lesson Page ******************

myApp.controller('angularController', function ($scope, $http, currentLesson) {
    var lessonId = currentLesson.getLessonId_Angular();
    var lessonCat = currentLesson.getLessonCat_Angular();

    if (lessonId > 0 && lessonCat != '') {
        $http.get('/homeLesson/' + lessonCat + '/' + lessonId).success(function (data) {
            $scope.lessonAngular = data;
        }).error(function (data, status) {
            console.log("код ответа: " + status);
        });
    }
});

myApp.controller('javaController', function ($scope, $http, currentLesson) {
    var lessonId = currentLesson.getLessonId_Java();
    var lessonCat = currentLesson.getLessonCat_Java();

    if (lessonId > 0 && lessonCat != '') {
        $http.get('/homeLesson/' + lessonCat + '/' + lessonId).success(function (data) {
            $scope.lessonJava = data;
        }).error(function (data, status) {
            console.log("код ответа: " + status);
        });
    }
});

myApp.controller('springController', function ($scope, $http, currentLesson) {
    var lessonId = currentLesson.getLessonId_Spring();
    var lessonCat = currentLesson.getLessonCat_Spring();

    if (lessonId > 0 && lessonCat != '') {
        $http.get('/homeLesson/' + lessonCat + '/' + lessonId).success(function (data) {
            $scope.lessonSpring = data;
        }).error(function (data, status) {
            console.log("код ответа: " + status);
        });
    }
});

myApp.controller('postgresController', function ($scope, $http, currentLesson) {
    var lessonId = currentLesson.getLessonId_Postgres();
    var lessonCat = currentLesson.getLessonCat_Postgres();

    if (lessonId > 0 && lessonCat != '') {
        $http.get('/homeLesson/' + lessonCat + '/' + lessonId).success(function (data) {
            $scope.lessonPostgres = data;
        }).error(function (data, status) {
            console.log("код ответа: " + status);
        });
    }
});

myApp.controller('infoController', function ($scope, $http, currentLesson) {

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
                Materialize.toast('The image is added to the database', 3000, 'rounded')
                // repeat: get list
                $http.get('/images').success(function (data) {
                    $scope.images = data;
                }).error(function (data, status) {
                    console.log("код ответа: " + status);
                });
            }).error(function () {
                Materialize.toast('The image is not added in the database!!!', 3000, '')
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
    $http.get('/articleImageType/ARTICLE').success(function (data) {
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
                $http.get('/articleImageType/ARTICLE').success(function (data) {
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

myApp.controller('adminBlockController', function ($scope, $http) {

    // GET: list -> request get
    $http.get('/category').success(function (data) {
        $scope.articleData = data;
    }).error(function (data, status) {
        console.log("код ответа: " + status);
    });

    // GET: list -> request get
    $http.get('/articleImageType/BLOCK').success(function (data) {
        $scope.imgData = data;
    }).error(function (data, status) {
        console.log("код ответа: " + status);
    });

    $scope.choices = [];
    $scope.addNewChoice = function () {
        $scope.choices.push({});
    };

    $scope.removeChoice = function() {
        var lastItem = $scope.choices.length-1;
        $scope.choices.splice(lastItem);
    };


});