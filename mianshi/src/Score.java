public class Score{
        private String stuId;
        private String subjectId;
        private String subjectName;
        private String score;

        public Score() {
        }

        public String getStuId() {
                return stuId;
        }

        public String getSubjectId() {
                return subjectId;
        }

        public String getSubjectName() {
                return subjectName;
        }

        public String getScore() {
                return score;
        }

        @Override
        public String toString() {
                return "Score1{" +
                        "stuId='" + stuId + '\'' +
                        ", subjectId='" + subjectId + '\'' +
                        ", subjectName='" + subjectName + '\'' +
                        ", score='" + score + '\'' +
                        '}';
        }
}