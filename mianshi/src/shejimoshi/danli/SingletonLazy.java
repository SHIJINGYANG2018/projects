package shejimoshi.danli;

/**
 * 单例模式特点
 * 只用自己实例化，无法使用new 实例化
 */

public class SingletonLazy {
   private static volatile  SingletonLazy singletonLazy=null;

   private SingletonLazy() {
   }


    public static  SingletonLazy getInstance(){
      if(singletonLazy==null){

         singletonLazy =  new SingletonLazy();
      }
      return singletonLazy;
    }
}
