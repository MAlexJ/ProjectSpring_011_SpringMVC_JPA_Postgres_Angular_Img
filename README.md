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


