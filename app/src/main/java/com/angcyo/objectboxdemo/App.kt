package com.angcyo.objectboxdemo

import android.app.Application
import com.angcyo.objectbox.RBox

/**
 *
 * Email:angcyo@126.com
 * @author angcyo
 * @date 2019/04/23
 * Copyright (c) 2019 ShenZhen O&M Cloud Co., Ltd. All rights reserved.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        RBox.init(MyObjectBox::class.java, this, BuildConfig.DEBUG)
    }
}