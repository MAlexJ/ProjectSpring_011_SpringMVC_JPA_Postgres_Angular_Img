myApp.service('currentLesson', function () {
    
    //Angular
    var _idAngular = {};
    var _categoryAngular = {};

    //Java
    var _idJava = {};
    var _categoryJava = {};

    //Spring
    var _idSpring = {};
    var _categorySpring = {};

    //Postgres
    var _idPostgres = {};
    var _categoryPostgres = {};
    

    return {
        // Angular
        setLessonCatId_Angular: function (category, id) {
            _idAngular = id;
            _categoryAngular = category;
        },
        getLessonCat_Angular: function () {
            return _categoryAngular;
        },
        getLessonId_Angular: function () {
            return _idAngular;
        },
        
        // Java
        setLessonCatId_Java: function (category, id) {
            _idJava = id;
            _categoryJava = category;
        },
        getLessonCat_Java: function () {
            return _categoryJava;
        },
        getLessonId_Java: function () {
            return _idJava;
        },
        
        // Spring
        setLessonCatId_Spring: function (category, id) {
            _idSpring = id;
            _categorySpring = category;
        },
        getLessonCat_Spring: function () {
            return _categorySpring;
        },
        getLessonId_Spring: function () {
            return _idSpring;
        },

        // Postgres
        setLessonCatId_Postgres: function (category, id) {
            _idPostgres = id;
            _categoryPostgres = category;
        },
        getLessonCat_Postgres: function () {
            return _categoryPostgres;
        },
        getLessonId_Postgres: function () {
            return _idPostgres;
        }


    } 
});