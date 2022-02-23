public class Stu{
    private String id;
    private String name;

        public Stu() {
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

    @Override
    public String toString() {
        return "Stu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}