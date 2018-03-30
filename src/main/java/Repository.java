import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

class Repository {

    Observable<DummyObject> fetchDelayed() {
        return Observable
                .just(new DummyObject("1"))
                .concatWith(Observable.just(new DummyObject("2")).delay(1, TimeUnit.SECONDS));

    }

    Observable<DummyObject> fetch() {
        return Observable
                .just(new DummyObject("1"))
                .concatWith(Observable.just(new DummyObject("2")));
    }

}
