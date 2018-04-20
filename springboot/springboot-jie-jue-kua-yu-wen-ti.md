# springboot解决跨域问题

当前端js通过ajax向后端发送请求，调用后端的controller接口时，就会产生跨域问题。

springboot使用cros可以解决这种问题，只要一个注解就可以解决

```text
@CrossOrigin(origins = "http://localhost:9000")
@GetMapping("/greeting")
public Greeting greeting(@RequestParam(required=false, defaultValue="World") String name) {
    System.out.println("==== in greeting ====");
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
}
```

也可以将这个注解加在你的controller之上，这样你就可以对所有的controller实现跨域共享

```text
@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class test {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String HelloWorld(){
        return "Hello schedule";
    }
}
```

