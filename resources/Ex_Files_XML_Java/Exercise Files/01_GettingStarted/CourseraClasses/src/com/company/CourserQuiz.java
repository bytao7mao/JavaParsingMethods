package com.company;
public class CourserQuiz {
        private  int a;
        public  double b;
        public CourserQuiz(int first, double second)
        {
            this.a = first;
            this.b = second;
        }
        public static void incrementBoth(CourserQuiz c1) {
            c1.a = c1.a + 1;
            c1.b = c1.b + 1.0;
        }
        public static void main(String[] args)
        {
            CourserQuiz c1 = new CourserQuiz(10, 20.5);
            CourserQuiz c2 = new CourserQuiz(20, 30.5);
            // different code below
            incrementBoth(c1);
            System.out.println(c1.a + "  " + c1.b);
            incrementBoth(c2);
            System.out.println(c2.a + "  " + c2.b);
        }
    }


