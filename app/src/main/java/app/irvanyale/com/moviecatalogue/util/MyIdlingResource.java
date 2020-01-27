package app.irvanyale.com.moviecatalogue.util;

import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.idling.CountingIdlingResource;

public class MyIdlingResource {

    private static CountingIdlingResource mCountingIdlingResource =
            new CountingIdlingResource("my_idling_resource");

    public static IdlingResource getIdlingResource() {
        return mCountingIdlingResource;
    }

    public static void increment() {
        mCountingIdlingResource.increment();
    }

    public static void decrement() {
        mCountingIdlingResource.decrement();
    }
}
