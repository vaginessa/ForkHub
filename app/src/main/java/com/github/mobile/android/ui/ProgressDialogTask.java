package com.github.mobile.android.ui;

import android.app.ProgressDialog;
import android.content.Context;

import com.github.mobile.android.async.AuthenticatedUserTask;

import java.util.concurrent.Executor;

/**
 * Task that runs with a progress dialog at the foreground
 *
 * @param <E>
 */
public abstract class ProgressDialogTask<E> extends AuthenticatedUserTask<E> {

    /**
     * Progress dialog last displayed
     */
    protected ProgressDialog progress;

    /**
     * @param context
     */
    protected ProgressDialogTask(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param executor
     */
    public ProgressDialogTask(Context context, Executor executor) {
        super(context, executor);
    }

    private void dismissProgress() {
        if (progress != null)
            progress.dismiss();
    }

    /**
     * Sub-classes may override but should always call super to ensure the progress dialog is dismissed
     */
    @Override
    protected void onSuccess(E e) throws Exception {
        dismissProgress();
    }

    /**
     * Sub-classes may override but should always call super to ensure the progress dialog is dismissed
     */
    @Override
    protected void onException(Exception e) throws RuntimeException {
        dismissProgress();
    }
}