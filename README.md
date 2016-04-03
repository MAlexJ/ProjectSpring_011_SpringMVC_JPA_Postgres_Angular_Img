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