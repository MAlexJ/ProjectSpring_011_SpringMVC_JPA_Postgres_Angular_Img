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
