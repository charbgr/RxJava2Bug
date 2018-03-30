import io.reactivex.observers.DisposableObserver;

public class Presenter {

    public static void main(String[] args) {
        Presenter p = new Presenter();
        p.testRun1();
        System.out.println();
        p.testRun2();
        System.out.println();
        p.testRun3();
    }

    private void testRun1() {
        UseCase useCase = new UseCase(new Repository());
        System.out.println("FETCH DELAYED WITH PUBLISH");
        useCase.fetchDelayedDummyObject()
                .autoConnect()
                .subscribeWith(new DisposableObserver<DummyObject>() {
                    public void onNext(DummyObject dummyObject) {
                        System.out.println("PRESENTER " + dummyObject.toString());
                    }

                    public void onError(Throwable throwable) {

                    }

                    public void onComplete() {

                    }
                });


        waitToFinish();
    }


    private void testRun2() {
        UseCase useCase = new UseCase(new Repository());
        System.out.println("FETCH DELAYED WITH SHARE");
        useCase.fetchDelayedDummyObjectShared()
                .subscribeWith(new DisposableObserver<DummyObject>() {
                    public void onNext(DummyObject dummyObject) {
                        System.out.println("PRESENTER " + dummyObject.toString());
                    }

                    public void onError(Throwable throwable) {

                    }

                    public void onComplete() {

                    }
                });


        waitToFinish();
    }

    private void testRun3() {
        UseCase useCase = new UseCase(new Repository());
        System.out.println("FETCH INSTANT WITH SHARE");
        useCase.fetchInstantDummyObjectShared()
                .subscribeWith(new DisposableObserver<DummyObject>() {
                    public void onNext(DummyObject dummyObject) {
                        System.out.println("PRESENTER " + dummyObject.toString());
                    }

                    public void onError(Throwable throwable) {

                    }

                    public void onComplete() {

                    }
                });


        waitToFinish();
    }


    private void waitToFinish() {

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
