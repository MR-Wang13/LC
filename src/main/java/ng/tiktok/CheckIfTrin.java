package ng.tiktok;

public class CheckIfTrin {
    static boolean isValidTriangle(int a, int b, int c) {
        if(a<=0 || b<=0 || c<=0){
            return false;
        }else{
            return (a+b)>c && (a+c)>b && (b+c)>a;
        }
    }

    public static void main(String[] args) {
        new TestCase(3, 4, 5, true, "testcase01ExpectedPass").ifPass(isValidTriangle(3,4,5));
        new TestCase(1, 1, 3, false,"testcase02ExpectedFailed").ifPass(isValidTriangle(1,1,3));
        new TestCase(1, 3, 1, false,"testcase03ExpectedFailed").ifPass(isValidTriangle(1,3,1));
        new TestCase(3, 1, 1, false,"testcase04ExpectedFailed").ifPass(isValidTriangle(3,1,1));
        new TestCase(0, 4, 5, false,"testcase05ExpectedFailed").ifPass(isValidTriangle(0,4,5));
        new TestCase(3, 0, 5, false,"testcase06ExpectedFailed").ifPass(isValidTriangle(3,0,5));
        new TestCase(3, 4, 0, false,"testcase07ExpectedFailed").ifPass(isValidTriangle(3,4,0));
    }

    static class TestCase{
        private int a;
        private int b;
        private int c;
        private boolean expectedResult;
        private String name;
        public TestCase(int a, int b, int c, boolean expectedResult,String name){
            this.a = a;
            this.b = b;
            this.c = c;
            this.expectedResult = expectedResult;
            this.name = name;
        }
        public void ifPass(boolean result){
            if(isPassed(result)){
                printInfo(" passed");
            }else{
                printInfo(" failed");
            }
        }

        private void printInfo(String passOrNot) {
            System.out.println(name + " with edges:" + getPrintEdgesString() + passOrNot);
        }

        private boolean isPassed(boolean result) {
            return result == expectedResult;
        }

        public String getPrintEdgesString(){
            return a+ " " +b+" "+c;
        }
    }
}
