### CAS

// var1 要修改的值
// var2 期望的值
// var3 修改的值
compareAndSwap(var var1 ,int  var1 ,int var2)
比较并交换，
cas 是通过CPU实现的，不用的操作系统对应的方法名称不一样

### AQS
AbstractQueuedSynchronizer  


###  ReentrantLock(可重入锁)
### 公平锁
悲观，线程自认为没有资格占用资源，需要先尝试获得锁，
### 非公平锁
乐观，线程自认为有资格占用资源，直接修改数据，失败了排队
