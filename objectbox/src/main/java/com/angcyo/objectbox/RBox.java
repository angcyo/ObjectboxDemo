package com.angcyo.objectbox;

import android.content.Context;
import androidx.annotation.NonNull;
import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.BoxStoreBuilder;
import io.objectbox.DebugFlags;

import java.lang.reflect.Method;

/**
 * Email:angcyo@126.com
 *
 * @author angcyo
 * @date 2019/04/23
 * Copyright (c) 2019 ShenZhen O&M Cloud Co., Ltd. All rights reserved.
 */
public class RBox {

    /**
     * @param myObjectBox 此对象会在 Make Project工程之后, 自动生成
     */
    public static void init(@NonNull Class<?> myObjectBox, @NonNull Context context, boolean debug) {
        try {
            Method builder = myObjectBox.getDeclaredMethod("builder");


            BoxStoreBuilder storeBuilder = (BoxStoreBuilder) builder.invoke(null);
            storeBuilder.androidContext(context);

            if (debug) {
                storeBuilder.debugFlags(DebugFlags.LOG_TRANSACTIONS_READ | DebugFlags.LOG_TRANSACTIONS_WRITE);
                storeBuilder.debugRelations();
            }

            //默认路径:/data/user/0/包名/files/objectbox/objectbox 文件夹下
            storeBuilder.buildDefault();
        } catch (Exception e) {
            e.printStackTrace();

            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 获取BoxStore对象
     */
    public static BoxStore get() {
        return BoxStore.getDefault();
    }

    /**
     * 获取可操作的Box对象
     */
    public static <T> Box<T> box(Class<T> entityClass) {
        return get().boxFor(entityClass);
    }
}
