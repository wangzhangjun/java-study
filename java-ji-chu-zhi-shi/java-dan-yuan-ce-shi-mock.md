# java单元测试mock

当我们对一个方法进行单元测试的时候，一般使用的第三方的都需要mock. 注意mock 是mock一个你想要的依赖条件去测试你的代码，但是比如说你Mock 了一个方法，但是在这个方法中还调用了另一个方法，你还是要去mock调用的方法。 例子：

```text
return new FileBasedStateRepository(propertyFileUtil.getFeatureFile(getFeatureProfile()));
```

调用下面的方法：

```text
private String getFeatureProfile() {
        String envFlag = "";
        if (env.getActiveProfiles().length > 0) {
            envFlag = env.getActiveProfiles()[0];
        }
        return  envFlag ;
    }
```

当我mock了这个方法的时候，

```text
when(propertyFileUtil.getFeatureFile(any())).thenReturn( new ClassPathResource("features.properties").getFile());
```

还需要去when另一个方法

```text
when(env.getActiveProfiles()).thenReturn(new String[]{});
```

因为虽然上面when了，但是还是要when下面的方法，因为他还是要实际的去调用的。

