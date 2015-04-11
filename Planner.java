/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planner;

import java.util.*;

/**
 *
 * @author parekh21
 */
public class Planner {

    private static int remainingunits;
    private static int termstocompletion;
    private static int modulus;
    private static double tuition;
    private static int plannedunits;
    private static int monthstocompletion;
    private static ArrayList<String> coursename = new ArrayList();
    private static ArrayList<Integer> units = new ArrayList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String entercourses = "Y";
        do {
            System.out.print("\nPlease enter your course name: ");
            Scanner cname = new Scanner(System.in);
            coursename.add(cname.next());
            int eunits;
            do {
                System.out.print("\nPlease enter the amount of CUs for this course: ");
                Scanner enterunits = new Scanner(System.in);
                eunits = enterunits.nextInt();
                if (eunits < 0) {
                    System.out.println("\nYou have entered a negative number. Please enter 0 or a positive number.\n");
                } else {
                    units.add(eunits);
                }
            } while (!(eunits >= 0));
            System.out.print("\nWould you like to enter another course? (Y/N): ");
            Scanner anothercourse = new Scanner(System.in);
            entercourses = anothercourse.next();
        } while (!(entercourses.equalsIgnoreCase("N")));
        int punits;
        do {
            System.out.print("\nPlease enter planned number of units to complete per term: ");
            Scanner pnu = new Scanner(System.in);
            punits = pnu.nextInt();

            if (punits >= 12) {
                plannedunits = punits;
            } else {
                System.out.println("\nUndergraduate students must enroll for a minimum of 12 competency units (CUs) per term. Please enter 12 or more units.\n");
            }
        } while (!(punits >= 12));
        for (Integer i : units) {
            remainingunits = remainingunits + i;
        }
        modulus = remainingunits % plannedunits;
        if (modulus == 0) {
            termstocompletion = remainingunits / plannedunits;
        } else {
            termstocompletion = (remainingunits / plannedunits) + 1;
        }
        System.out.println("\nNumber of terms to completion based on input data: " + termstocompletion);
        tuition = termstocompletion * 2890;
        System.out.println("\nTuition cost based on number of terms to completion: $" + tuition);
        monthstocompletion = termstocompletion * 6;
        System.out.println("\nNumber of months to completion based on input data: " + monthstocompletion);
    }

}
