##  Android工具类库

## appUtils (Android 基础工具类)

## dbutils (Android 数据库处理工具类)

## mediautils (Android 多媒体处理工具类)
快速使用： 在工程目录下的 build.gradle 添加如下代码:

```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

在app的build.gradle引入依赖
1.
```
	dependencies {
	        compile 'com.github.AllenCoder.SuperUtils:apputils:1.0.1'
	}
```
2.
```
	dependencies {
	         compile 'com.github.AllenCoder.SuperUtils:dbutils:1.0.1'
	}
```

3.
```
	dependencies {
	         compile 'com.github.AllenCoder.SuperUtils:mediautil:1.0.1'
	}
```

