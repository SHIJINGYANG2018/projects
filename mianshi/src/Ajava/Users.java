package Ajava;

public class Users {
    public static class user {
        String name;
        int sex;

        @Override
        public int hashCode() {
            return new user().hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }

    public static void main(String[] args) {
    user user=new user();
    user user1=user;
    user user2=new user();
    System.out.println(user.hashCode());
    System.out.println(user1.hashCode());
    user2=user;
    System.out.println(user2 == user);

    int a=111;
   System.out.println(1+a);
        System.out.println("1"+a);
        System.out.println(a+1);
    }
}

