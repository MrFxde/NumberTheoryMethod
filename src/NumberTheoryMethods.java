public class NumberTheoryMethods {
    //determines if number is prime
    static void isPrime(int a) {
        boolean isPrime = true;
        //one is not prime
        if (a == 1) {
            System.out.println("False");
            isPrime = false;
        }

        for (int i = 2; i < a/2; i++) {
            if(a % i == 0) {
                System.out.println("False");
                isPrime = false;
            }
        }
        if(isPrime) {
            System.out.println("True");
        }
    }

    //Finds all divisors of given number and returns summation of all divisors
    static void tauSigma(int a) {
        int sum = 0;
        int array[] = new int[a/2];
        int index = 0;

        for (int i = 1; i < a+1; i++) {
            if (a % i == 0) {
                array[index] = i;
                index++;
                sum += i;
            }
        }
        System.out.println( a + " has positive divisors: ");
        for (int i = 0; i < index-1; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println(array[index-1]);
        System.out.println("The summation of the divisors is " + sum);
    }

    //Finds gcd of two numbers along with bezout's lemma using the blankenship method
    static void BezoutsLemma(int a, int b) {
        int biggerN;
        int smallerN;
        int [][] array = new int[2][3];
        int [] addArray = new int[3];
        int quotient;
        int remainder;
        //used to alternate between 0 and 1
        int [] arrayIndex = {1,0,1,0,1,0,1,0,1,0};
        int [] arrayIndex2 = {0,1,0,1,0,1,0,1,0,1,0,1};
        int index = 0;
        //makes sure a is larger than b
        if(a>b) {
            biggerN = a;
            smallerN = b;
        }
        else {
            biggerN = b;
            smallerN = a;
        }

        array[0][0] =  biggerN;
        array[1][0] =  smallerN;
        array[0][1] =  1;
        array[0][2] =  0;
        array[1][1] =  0;
        array[1][2] =  1;

        while ((array[1][0] != 0) || (array[1][0] != 0)) {

            remainder = array[arrayIndex2[index]][0] % array[arrayIndex[index]][0];
            quotient = (array[arrayIndex2[index]][0] - remainder) / array[arrayIndex[index]][0] * -1;

            for (int i = 0; i < 3; i++) {
                addArray[i] = array[arrayIndex[index]][i] * quotient;
            }
            for (int i = 0; i < 3; i++) {
                array[arrayIndex2[index]][i] = array[arrayIndex2[index]][i] + addArray[i];
            }
            index++;
        }
        //prints results
        if (array[0][0] == 0) {
            System.out.println("gcd(" + biggerN + "," + smallerN + ") = " + array[1][0] );
            System.out.println("and " + array[1][0] + " = " + array[1][1] + " * " +
                    biggerN + " + " +array[1][2]+ " * " + smallerN);
        }
        else {
            System.out.println("gcd(" + biggerN + "," + smallerN + ") = " + array[0][0] );
            System.out.println("and " + array[0][0] + " = " + array[0][1] + " * " +
                    biggerN + " + " +array[0][2]+ " * " + smallerN);
        }
    }
    //finds gcd using euclidean algorithm and shows steps
    static void gcd(int a, int b){
        int remainder = 1;
        int quotient;
        int biggerN;
        int smallerN;

        //guarantees that the bigger number is set to biggerN
        if(a>b) {
            biggerN = a;
            smallerN = b;
        }
        else {
            biggerN = b;
            smallerN = a;
        }
        while(remainder != 0)
        {
            remainder = biggerN % smallerN;
            quotient = (biggerN - remainder) / smallerN;
            System.out.println(biggerN + " = " + quotient + " * " + smallerN + " + " + remainder);
            biggerN = smallerN;
            smallerN = remainder;
        }
        System.out.println("GCD = " + biggerN);
    }

    public static void main(String[] args) {

        gcd(2367,1834);
        isPrime(317);
    }

}
