Links:

1. 
http://stackoverflow.com/questions/26905381/convert-image-to-base64-in-angularjs
<img alt="{{image.name}}" data-ng-src="{{'data:image/png;base64,'+image.img}}" class="photo" />

2.
https://www.npmjs.com/package/ng-file-upload#server example upload Angular + Spring MVC
@ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/images", method = RequestMethod.POST)
    public void post(@RequestParam("file") CommonsMultipartFile file) { ....... }
    

3.
Загрузка файлов в AngularJS 
-> service('fileUpload' ...
-> directive('fileModel', ////
https://jsfiddle.net/JeJenny/ZG9re/

4.
DRY роутинг в AngularJS:  
https://habrahabr.ru/post/190958/


5.
Вроде бы давно не секрет, что нельзя большие картинки из фотошопа сохранять в png24 без последующего пережатия той же pandapng.
Берем https://s3-us-west-2.amazonaws.com/s.cdpn.io/272781/ilu_03.png
Итог: -80%!
Было 1.3 MB стало 256.2 KB. И вроде жить можно.
https://tinypng.com/

6.
http://forundex.ru/yap/gxt-ListView-images-from-DataBase-table-column-type-bytea-25571
Ответ: Обновлю за автора топика. Пока на данный момент IMHO:
-> Читать документацию PostgreSQL.
PostgreSQL тип bytea != Oracle типу BLOB ! Он, скорее, равен Oracle типу RAW (только лимит 1 Gb вместо 4000 байт)
-> Полноценные BLOB'ы в PostgreSQL делаются через одно место, откуда обычно растут ноги. Читать раздел доки
PostgreSQL 9.4.0 Documentation
IV. Client Interfaces
Chapter 32. Large Objects
-> Соответственно, более корректное объявления типа bytea в хибернейте это
@Type(type = "org.hibernate.type.BinaryType")
возможно нужно как-то по другому, но вроде такое съело.
p.s. Как вчера посмотрел поближе на код, документацию, сайт проекта.... понял,
что нужно срочно нажраться. Т.к. "вера в человечество" ( C ) Остап-Сулейман-Берта-Мария-Бендер-бей потеряна окончательно (((

7.
http://docs.spring.io/spring-data/jpa/docs/current/reference/html/
-> 4.4.2. Query creation
The query builder mechanism built into Spring Data repository infrastructure is useful for
building constraining queries over entities of the repository.
The mechanism strips the prefixes find…By, read…By, query…By, count…By, and get…By from the method and starts parsing the rest of it.

 List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);

8.
Getting all names in an enum as a String[]
http://stackoverflow.com/questions/13783295/getting-all-names-in-an-enum-as-a-string

Here`s an elegant solution using Apache commons-lang3:
EnumUtils.getEnumList(State.class)
Although it returns a List, you can convert the list easily with list.toArray()
List<ArticleCategory> enumList = EnumUtils.getEnumList(ArticleCategory.class);
  ->>>> [ANGULAR_JS, JAVA_SE, JAVA_JEE, SPRING, POSTGRES, NONE]

9.
http://ru.stackoverflow.com/questions/456623/%D0%9D%D0%B0%D0%B3%D0%BB%D1%8F%D0%B4%D0%BD%D1%8B%D0%B9-%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D1%80-%D1%80%D0%B0%D0%B7%D0%BB%D0%B8%D1%87%D0%B8%D1%8F-dto-poco-pojo-%D0%B8-value-object
  ->>>>  ValueObject. Единица из парадигмы DDD, которой не нужен id, т.к. она немутируемая,
т.е. не изменяется по ходу. Судя по всему, может иметь логику,
которая не мешает ей быть немутируемой.

10.
http://tutorialzine.com/2013/08/learn-angularjs-5-examples/
-> Navigation Menu

11.
Angular.js: ng-select and ng-options
https://dzone.com/articles/angularjs-ng-select-and-ng-0

12.
http://keenformatics.blogspot.com/2013/08/how-to-solve-json-infinite-recursion.html
http://wiki.fasterxml.com/JacksonFeatureObjectIdentity
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "id_image", unique = true, nullable = false)
    private ImagesEntity image;


13.
http://tutorials.jenkov.com/angularjs/routes.html
AngularJS routes enables you to show different content
depending on what route is chosen.
A route is specified in the URL after the # sign.
Thus, the following URL's all point to the same AngularJS application,
but each point to different routes:

// route1
 when('/route1/:param',
 {    templateUrl: 'angular-route-template-1.jsp',
      controller: 'RouteController'
 }).

// controller
 module.controller("RouteController", function($scope, $routeParams) {
     $scope.param = $routeParams.param;
 })

14.
http://stepansuvorov.com/blog/2014/09/angularjs-data-transfer/
myApp.service('currentLesson', function () {
    var _lesson = {};
    return {
        setLesson: function (lesson) {
            _lesson = lesson;
        },
        getLesson: function () {
            return _lesson;
        }
    }
});

15.
http://stackoverflow.com/questions/9944137/have-jpa-hibernate-to-replicate-the-on-delete-set-null-functionality
Have JPA/Hibernate to replicate the “ON DELETE SET NULL” functionality

16.
http://stackoverflow.com/questions/20295067/angularjs-adding-inputs-that-represent-an-array-model
AngularJS adding inputs that represent an array model

16-1.
http://stackoverflow.com/questions/22103258/angularjs-adding-dynamically-form-fields-in-various-forms

16-2.
http://www.shanidkv.com/blog/angularjs-adding-form-fields-dynamically
http://www.shanidkv.com/blog/angularjs-dynamic-table-addremove-action

16-3
http://plnkr.co/edit/a7E9sT?p=info
