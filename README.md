# RxJava2Bug

```java
FETCH DELAYED WITH PUBLISH
USE CASE  DummyObject{value='1'}
PRESENTER DummyObject{value='1'}
USE CASE  DummyObject{value='2'}
PRESENTER DummyObject{value='2'}

FETCH DELAYED WITH SHARE
USE CASE  DummyObject{value='1'}
USE CASE  DummyObject{value='2'}
PRESENTER DummyObject{value='2'}

FETCH INSTANT WITH SHARE
USE CASE  DummyObject{value='1'}
USE CASE  DummyObject{value='2'}
PRESENTER DummyObject{value='1'}
PRESENTER DummyObject{value='2'}
```
