package com.shehabsalah.jokeapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Shehab Salah on 6/22/17.
 *
 */

@RunWith(AndroidJUnit4.class)
public class AsyncTaskSimpleTest {
    @Test
    public void testVerifyAsyncTask_notReturnEmptyString() throws Exception {
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask() {
            @Override
            public void onPreExecute() {

            }

            @Override
            public void onPostExecute(String result) {
                assertNotNull(result);
                result = result.trim();
                assertTrue(!result.isEmpty());

            }
        };
        endpointsAsyncTask.execute();
    }
}
