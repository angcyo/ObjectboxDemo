package com.angcyo.objectbox;

import android.content.Context;
import androidx.annotation.NonNull;
import io.objectbox.BoxStore;

import java.util.List;

/**
 * Email:angcyo@126.com
 *
 * @author angcyo
 * @date 2019/04/23
 * Copyright (c) 2019 ShenZhen O&M Cloud Co., Ltd. All rights reserved.
 */
public class Lib {
    private static BoxStore build;

    public static void init(@NonNull Context context) {
        if (build == null) {
            build = MyObjectBox.builder().androidContext(context).name("objectbox_lib").build();
        }

        EntityLib lib = new EntityLib();
        lib.id = 1;
        lib.name2 = "new name2";
        EntityLib lib2 = new EntityLib();

        build.boxFor(EntityLib.class).put(lib);
        build.boxFor(EntityLib.class).put(lib2);


        List<EntityLib> all = build.boxFor(EntityLib.class).getAll();
        for (EntityLib b : all) {
            L.i(b.id + " :" + b.name2);
        }
    }
}
