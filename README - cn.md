

##  Android工具类库 [![Build Status](https://travis-ci.org/AllenCoder/SuperUtils.svg?branch=master)](https://travis-ci.org/AllenCoder/SuperUtils) [![](https://jitpack.io/v/AllenCoder/SuperUtils.svg)](https://jitpack.io/#AllenCoder/SuperUtils)  [![API](https://img.shields.io/badge/API-14%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=14) [![Gradle Version](https://img.shields.io/badge/gradle-4.1-green.svg)](https://docs.gradle.org/current/release-notes)[![CircleCI](https://circleci.com/gh/AllenCoder/SuperUtils/tree/master.svg?style=svg)](https://circleci.com/gh/AllenCoder/SuperUtils/tree/master) [![Licence](https://img.shields.io/badge/licence-Apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)
  
>囊括了一大部分Android应用开发过程当中常用的工具类。工具类来源整理自网络和自己编写。(正在不断收集和整理中)



### 快速使用： 在工程目录下的 build.gradle 添加如下代码:


```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

```

在app的build.gradle引入依赖

```
dependencies {
        compile 'com.github.AllenCoder.SuperUtils:apputils:1.0.6'
}
```

### 1.Android 基础工具类

| Android 基础工具类 |                                                                |     |     |
| ------------------ | -------------------------------------------------------------- | --- | --- |
| AppManger          | 应用程序Activity管理工具类，用于Activity的管理和应用程序的退出 |  [AppManger][1]   |     |
| Arith              | 精确计算工具类                                                 |   [Arith][2]   |     |
| BitmapUtil         | Bitmap 处理工具类                                              |   [BitmapUtil][3]   |     |
| BtnClickUtils          |Android 快速点击判断拦截工具类 | [BtnClickUtils][4]     |     |
| CheckViewInRange              | View 区域范围判断工具类                                                 |  [CheckViewInRange][5]    |     |
| DataCleanManager         | Android 应用内数据清除工具类                                              |    [DataCleanManager][6]  |     |
| DataUtil          |数据转换工具类 |   [DataUtil][7]   |     |
| DateTimeUtil              | Android 格式化时间工具类                                                 |  [DateTimeUtil][8]    |     |
| DigestUtils         |MD5加解密工具类                                           |    [DigestUtils][9]  |     |
| MLog          | Android Log打印工具类 支持行号 json打印 统一封装|    [MLog][11]  |     |
| NetUtils              | Android 网络状态判断工具类，检测WiFi ，4G网络状态                                                 |    [NetUtils][12]  |     |
| NumberUtil         |  金额格式化工具类（支持常用的保留指定位数的小数 和自动格式化处理）                                           |   [NumberUtil][13]   |     |
| RegexUtils          |提供验证邮箱、手机号、电话号码、身份证号码、数字等方法|    [RegexUtils][14]  |     |
| ScreenListener              | Android屏幕状态监听工具类（判断 是否处于锁屏，亮屏状态）                                                 |   [ScreenListener][15]   |     |
| ScreenUtil         |  获取屏幕状态信息 （屏幕宽高 等信息）                                        |    [ScreenUtil][16]  |     |
| StatusBarUtils          |状态栏处理工具类 ，支持沉浸式状态栏|    [StatusBarUtils][17]  |     |
| ToolResource              | Android 获取资源工具类                                                 |  [ToolResource][18]    |     |
| TouchEventUtil         |  Android Touch事件打印辅助工具类                                      |    [TouchEventUtil][19]  |     |
| WeakRefHander         | 弱引用 handler 防止内存泄露                                     |    [WeakRefHander][23]  |     |
| SecretUtils         |  3DES 加密/解密                                      |    [SecretUtils][24]  |     |
| ToastUtils         |  Toast工具类（需要Utils.init(context)）                                      |    [ToastUtils][25]  |     |
| IOUtil         |  IOUtil （文件操作工具）                                      |    [IOUtil][26]  |     |
| PaintUtil         |  PaintUtil （测量字体大小和字体高度）                                      |    [PaintUtil][27]  |     |


### 2.Android 数据库处理工具类

| Android 数据库处理工具类 |                          |     |     |
| ------------------------ | ------------------------ | --- | --- |
| Utils                    | Android 数据库导出到SD卡 |  [Utils][20]   |     |


```
dependencies {
         compile 'com.github.AllenCoder.SuperUtils:dbutils:1.0.6'
}
```

### 3.Android 多媒体处理工具类

| Android 多媒体工具类 |                            |     |     |
| -------------------- | -------------------------- | --- | --- |
| ImageTakerHelper     | 从相机或者相册取图片辅助类 |  [ImageTakerHelper][21]   |     |
| Utils                |                            | [Utils][22]    |     |
|                      |                            |     |     |

```
dependencies {
         compile 'com.github.AllenCoder.SuperUtils:mediautil:1.0.6'
}

```
## License

```

  Copyright  2017 [AllenCoder]
 
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
 
      http://www.apache.org/licenses/LICENSE-2.0
 
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
 limitations under the License.

```


  [1]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/AppManger.java
  [2]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/Arith.java
  [3]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/BitmapUtil.java
  [4]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/BtnClickUtils.java
  [5]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/CheckViewInRange.java
  [6]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/DataCleanManager.java
  [7]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/DataUtil.java
  [8]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/DateTimeUtil.java
  [9]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/DigestUtils.java
  [10]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/DataCleanManager.java
  [11]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/MLog.java
  [12]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/NetUtils.java
  [13]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/NumberUtil.java
  [14]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/RegexUtils.java
  [15]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/ScreenListener.java
  [16]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/ScreenUtil.java
  [17]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/StatusBarUtils.java
  [18]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/ToolResource.java
  [19]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/TouchEventUtil.java
  [20]: https://github.com/AllenCoder/SuperUtils/blob/master/dbutils/src/main/java/com/allen/dbutils/Utils.java
  [21]: https://github.com/AllenCoder/SuperUtils/blob/master/mediautil/src/main/java/com/allen/mediautil/ImageTakerHelper.java
  [22]: https://github.com/AllenCoder/SuperUtils/blob/master/mediautil/src/main/java/com/allen/mediautil/Utils.java
  [23]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/WeakRefHander.java
  [24]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/SecretUtils.java
   [25]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/ToastUtils.java
   [26]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/IOUtil.java
   [27]: https://github.com/AllenCoder/SuperUtils/blob/master/apputils/src/main/java/com/allen/apputils/PaintUtil.java
