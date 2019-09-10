# RxJavaOperator
RxJava的操作符的整理

## 创建操作符
## 变换操作符
## 组合/合并操作符
## 功能性操作符

*  调度器

|调度器							|作用									|
|--								|--										|
|Schedulers.computation()		|用于使用计算任务，如事件循环和回调处理	|
|Schedulers.immediate()			|当前线程								|
|Schedulers.io()				|用于 IO 密集型任务，如果异步阻塞 IO 操作	|
|Schedulers.newThread()			|创建一个新的线程						|
|AndroidSchedulers.mainThread()	|Android 的 UI 线程						|

## 过滤操作符
## 条件/布尔操作符