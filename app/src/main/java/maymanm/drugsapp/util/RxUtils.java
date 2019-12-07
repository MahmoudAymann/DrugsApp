package maymanm.drugsapp.util;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public abstract class RxUtils {

    public static Disposable repeat(int periodInSeconds, Consumer<Long> consumer) {
        return Observable.interval(0, periodInSeconds, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer);
    }

    public static void repeat(int periodInSeconds, Observer<Long> observer) {
        Observable.interval(0, periodInSeconds, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    public static Disposable delay(int periodInSeconds, Action action){
      return Completable.timer(periodInSeconds, TimeUnit.SECONDS,
                AndroidSchedulers.mainThread()).subscribe(action);
    }

    public static void delay(int periodInSeconds, CompletableObserver observer){
        Completable.timer(5, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
