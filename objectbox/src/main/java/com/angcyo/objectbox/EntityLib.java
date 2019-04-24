package com.angcyo.objectbox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Email:angcyo@126.com
 *
 * @author angcyo
 * @date 2019/04/23
 * Copyright (c) 2019 ShenZhen O&M Cloud Co., Ltd. All rights reserved.
 */
@Entity
public class EntityLib {
    @Id
    public long id;

    public String name2 = "d_name";
}
