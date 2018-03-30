import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observers.DisposableObserver;

class UseCase {

    private Repository repository;

    UseCase(Repository repository) {
        this.repository = repository;
    }

    ConnectableObservable<DummyObject> fetchDelayedDummyObject() {
        ConnectableObservable<DummyObject> responseObservable = repository.fetchDelayed().publish();

        responseObservable.subscribeWith(new DisposableObserver<DummyObject>() {
            public void onNext(DummyObject dummyObject) {
                System.out.println("USE CASE  " + dummyObject.toString());
            }

            public void onError(Throwable throwable) {

            }

            public void onComplete() {

            }
        });

        return responseObservable;
    }

    Observable<DummyObject> fetchDelayedDummyObjectShared() {
        Observable<DummyObject> responseObservable = repository.fetchDelayed().share();

        responseObservable.subscribeWith(new DisposableObserver<DummyObject>() {
            public void onNext(DummyObject dummyObject) {
                System.out.println("USE CASE  " + dummyObject.toString());
            }

            public void onError(Throwable throwable) {

            }

            public void onComplete() {

            }
        });

        return responseObservable;
    }

    Observable<DummyObject> fetchInstantDummyObjectShared() {
        Observable<DummyObject> responseObservable = repository.fetch().share();

        responseObservable.subscribeWith(new DisposableObserver<DummyObject>() {
            public void onNext(DummyObject dummyObject) {
                System.out.println("USE CASE  " + dummyObject.toString());
            }

            public void onError(Throwable throwable) {

            }

            public void onComplete() {

            }
        });

        return responseObservable;
    }
}
