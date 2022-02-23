package thread.ThreadDemo.Cthreadlocal_demo;

public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTarget target = new ThreadLocalTarget();

        Thread thread = new Thread(target);

        thread.start();
        thread.join();

        System.out.println(Thread.currentThread().getName() + "更改后的名字：" + ThreadLocalTarget.getBlog().getTitle());
    }

}
class Xttblog {
    private String title;
    private Long id;
    private String text;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Xttblog(String title, Long id, String text) {
        this.title = title;
        this.id = id;
        this.text = text;
    }
}
 class ThreadLocalTarget implements Runnable{
    private static Xttblog blog = new Xttblog("ThreadLocal 会导致内存泄露？",1L,"....");
    public static ThreadLocal<Xttblog> local = new ThreadLocal<Xttblog>();
    public ThreadLocalTarget(){}

    @Override
    public void run() {
        ThreadLocalTarget.local.set(blog);

        ThreadLocalTarget.local.get().setTitle("test");

        System.out.println(Thread.currentThread().getName() + "更改后的名字：" + ThreadLocalTarget.local.get().getTitle());
    }

    public static Xttblog getBlog() {
        return blog;
    }
}
