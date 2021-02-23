[![AllenCoder's GitHub stats](https://github-readme-stats.vercel.app/api?username=AllenCoder)](https://github.com/anuraghazra/github-readme-stats)


##  Android tool library [![Build Status](https://travis-ci.org/AllenCoder/SuperUtils.svg?branch=master)](https://travis-ci.org/AllenCoder/SuperUtils) [![](https://jitpack.io/v/AllenCoder/SuperUtils.svg)](https://jitpack.io/#AllenCoder/SuperUtils)  [![CircleCI](https://circleci.com/gh/AllenCoder/SuperUtils/tree/master.svg?style=svg)](https://circleci.com/gh/AllenCoder/SuperUtils/tree/master) [![API](https://img.shields.io/badge/API-14%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=14) [![Gradle Version](https://img.shields.io/badge/gradle-4.1-green.svg)](https://docs.gradle.org/current/release-notes) [![Licence](https://img.shields.io/badge/licence-Apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)
  
> Including a large part of the Android application development process commonly used tools. Tools source from the network and write their own. (Constantly collecting and sorting out)

(中文文档)[https://github.com/AllenCoder/SuperUtils/blob/master/README%20-%20cn.md]

### Quickly use: build.gradle in the project directory to add the following code:


```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

```

### Introduced dependencies in the app's build.gradle

```
dependencies {
        compile 'com.github.AllenCoder.SuperUtils:apputils:1.0.6'
}
```

### 1. .Android foundation tool class

| Android Basic Tools class |                                                                |     |     |
| ------------------ | -------------------------------------------------------------- | --- | --- |
| AppManger          | The application Activity management tool class, for the management of the activity and the exit of the application |  [AppManger][1]   |     |
| Arith              | Precise calculation tool class                                                |   [Arith][2]   |     |
| BitmapUtil         | Bitmap processing tool class                                              |   [BitmapUtil][3]   |     |
| BtnClickUtils          | Android quick click to determine the interceptor class | [BtnClickUtils][4]     |     |
| CheckViewInRange              | View area range judgment tool class                                                 |  [CheckViewInRange][5]    |     |
| DataCleanManager         |  Android in-app data removal tool class                                              |    [DataCleanManager][6]  |     |
| DataUtil          | Data conversion tool class |   [DataUtil][7]   |     |
| DateTimeUtil              | Android formatting time tool class                                                |  [DateTimeUtil][8]    |     |
| DigestUtils         |MD5 encryption and decryption tools category                                   |    [DigestUtils][9]  |     |
| MLog          | Android Log print tool class support line number json print uniform package |    [MLog][11]  |     |
| NetUtils              | Android network state judgment tool class, detection WiFi, 4G network status）                                              |    [NetUtils][12]  |     |
| NumberUtil         |       Amount formatting tool class (supports the usual number of decimal places and automatic formatting)                                      |   [NumberUtil][13]   |     |
| RegexUtils          | Provide authentication mailbox, mobile phone number, telephone number, ID number, number and other methods|    [RegexUtils][14]  |     |
| ScreenListener              | Android screen status monitor tool class (to determine whether the lock screen, bright screen state)                                                 |   [ScreenListener][15]   |     |
| ScreenUtil         |  Get screen status information (screen width and height information)                                        |    [ScreenUtil][16]  |     |
| StatusBarUtils          |Status bar processing tool class, support immersive status bar |    [StatusBarUtils][17]  |     |
| ToolResource              |Android Get Resource Tools class                                         |  [ToolResource][18]    |     |
| TouchEventUtil         |  Android Touch Event Print Assistant                                      |    [TouchEventUtil][19]  |     |
| WeakRefHander         | Weak reference handler to prevent memory leaks                                     |    [WeakRefHander][23]  |     |
| SecretUtils         |  3DES encryption / decryption                                    |    [SecretUtils][24]  |     |
| ToastUtils         |  Toast tool class (requires Utils.init (context))                                      |    [ToastUtils][25]  |     |
| IOUtil         |  IOUtil (File Operations Tool)                                      |    [IOUtil][26]  |     |
| PaintUtil         |  PaintUtil (measure font size and font height)                                     |    [PaintUtil][27]  |     |


### 2.Android database processing tool class

| Android database processing tool class |                          |     |     |
| ------------------------ | ------------------------ | --- | --- |
| Utils                    |The Android database is exported to the SD card |  [Utils][20]   |     |


```
dependencies {
         compile 'com.github.AllenCoder.SuperUtils:dbutils:1.0.6'
}
```

### 3.Antroid multimedia processing tool class

| Android multimedia tools category |                            |     |     |
| -------------------- | -------------------------- | --- | --- |
| ImageTakerHelper     | From the camera or album to take the picture auxiliary class |  [ImageTakerHelper][21]   |     |
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
