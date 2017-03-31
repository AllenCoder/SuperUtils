

##  Android工具类库 [![Build Status](https://travis-ci.org/AllenCoder/SuperUtils.svg?branch=master)](https://travis-ci.org/AllenCoder/SuperUtils) [![](https://jitpack.io/v/AllenCoder/SuperUtils.svg)](https://jitpack.io/#AllenCoder/SuperUtils)  [![API](https://img.shields.io/badge/API-14%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=14) [![Gradle Version](https://img.shields.io/badge/gradle-3.4-green.svg)](https://docs.gradle.org/current/release-notes) [![Licence](https://img.shields.io/badge/licence-Apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)
  
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

### 1.Android 基础工具类

```
dependencies {
        compile 'com.github.AllenCoder.SuperUtils:apputils:1.0.2'
}
```
### 2.Android 数据库处理工具类

```
dependencies {
         compile 'com.github.AllenCoder.SuperUtils:dbutils:1.0.2'
}
```

### 3.Android 多媒体处理工具类

```
dependencies {
         compile 'com.github.AllenCoder.SuperUtils:mediautil:1.0.2'
}

```
## License

```

  Copyright  2017 [AllenCoderr]
 
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
