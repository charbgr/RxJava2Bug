# RxJava2Bug

Seems that I miss the first emission when concatenating an `Observable.just()` with an Observable that emits values later.

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

------

# Solution

`replay().refCount()`

```java
FETCH DELAYED WITH SHARE
USE CASE  DummyObject{value='1'}
PRESENTER DummyObject{value='1'}
USE CASE  DummyObject{value='2'}
PRESENTER DummyObject{value='2'}
```
