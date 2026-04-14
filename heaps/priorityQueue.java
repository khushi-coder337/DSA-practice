import java.util.*;
public class basic{
    static class Student implements Comparable<Student>{
        String name;
        int marks;
        public Student(String name, int marks){
            this.name = name;
            this.marks = marks;
        }
        @Override
        public int compareTo(Student s2){
            return this.marks - s2.marks;
        }
    }
    public static void main(String args[]){
        PriorityQueue<Student> pq  = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("khushi",99));//log(n)
        pq.add(new Student("khushi saini", 97));
        pq.add(new Student("charu",98));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name+ " -> " +pq.peek().marks);
            pq.remove();
        }
    }
}
