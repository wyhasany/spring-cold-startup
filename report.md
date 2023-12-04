Created wth:
https://github.com/snicoll/cds-log-parser

Requires: `-Xlog:class+load:file=cds.log:tags`

Layertools + CDS:

```
Class Loading Report:
      6376 classes and JDK proxies loaded
      5362 (84.10%) from cache
      1014 (15.90%) from classpath

Categories:
   Lambdas  745 (11.68%): 15.97% from cache
   Proxies   63 ( 0.99%): 73.02% from cache
   Classes 5569 (87.34%): 93.34% from cache

Top 10 locations from classpath:
       213 __JVM_LookupDefineClass__
        69 org.springframework.boot.autoconfigure.web.embedded.TomcatWebServerFactoryCustomizer
        65 jrt:/java.base
        31 org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryCustomizer
        26 jrt:/java.management
        17 __dynamic_proxy__
        16 org.springframework.core.io.support.SpringFactoriesLoader
        16 org.springframework.boot.autoconfigure.web.WebProperties
        15 org.springframework.boot.web.servlet.server.AbstractServletWebServerFactory
        14 BOOT-INF/lib/tomcat-embed-core-10.1.16.jar

Top 10 packages:
      2745 org.springframework (78.18% from cache)
       674 java.lang (65.28% from cache)
       625 java.util (97.92% from cache)
       498 com.fasterxml (95.78% from cache)
       300 org.apache (92.67% from cache)
       258 jdk.internal (98.06% from cache)
       178 ch.qos (100.00% from cache)
        98 java.time (100.00% from cache)
        95 sun.nio (73.68% from cache)
        94 java.nio (91.49% from cache)
--------------------------------------------------------------------------
```

Unpack + cds:
```
Class Loading Report:
      6340 classes and JDK proxies loaded
      5902 (93.09%) from cache
       438 ( 6.91%) from classpath

Categories:
   Lambdas  731 (11.53%): 93.84% from cache
   Proxies   63 ( 0.99%): 7.94% from cache
   Classes 5547 (87.49%): 93.96% from cache

Top 10 locations from classpath:
       222 __JVM_LookupDefineClass__
        63 jrt:/java.base
        58 __dynamic_proxy__
        14 build/unpacked/dependencies/tomcat-embed-core-10.1.16.jar
        12 jrt:/java.desktop
         7 org.springframework.context.support.DefaultLifecycleProcessor
         7 jrt:/jdk.net
         6 build/unpacked/dependencies/spring-boot-3.2.0.jar
         5 jrt:/java.sql
         4 java.util.Comparator

Top 10 packages:
      2721 org.springframework (98.31% from cache)
       683 java.lang (67.35% from cache)
       625 java.util (98.08% from cache)
       498 com.fasterxml (100.00% from cache)
       300 org.apache (94.33% from cache)
       256 jdk.internal (98.05% from cache)
       178 ch.qos (100.00% from cache)
        98 java.time (100.00% from cache)
        93 sun.security (100.00% from cache)
        93 sun.util (100.00% from cache)
--------------------------------------------------------------------------
```
