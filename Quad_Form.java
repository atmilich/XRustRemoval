import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

public class Quad_Form {
	
	/**
	 * @author Aly Milich
	 */
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the value for a.");
		double a = scan.nextDouble();

		System.out.println("Enter the value for b.");
		double b = scan.nextDouble();

		System.out.println("Enter the value for c.");
		double c = scan.nextDouble();

		double discrim = b*b - 4*a*c;

		System.out.println("f(x)=" + a + "*x^2 + " + b + "*x + " + c);

		//Real roots
		if (realRoots(discrim) == true)
			System.out.println("1. The quadratic has real roots.");
		else if (realRoots(discrim) == false)
			System.out.println("1. The quadratic does not have real roots.");

		DecimalFormat decimal = new DecimalFormat();
		decimal.setMaximumFractionDigits(2);
		decimal.setMinimumFractionDigits(2);
		decimal.setMinimumIntegerDigits(0);

		double[] quad_roots = null; 
		if (numberOfRoots(discrim) > 0) {
			quad_roots = zeros(a, b, c);
			System.out.println("2. They are x=" + decimal.format(quad_roots[0]) + " and x=" + decimal.format(quad_roots[1]));
		}

		//Axis of symmetry
		axisOfSymmetry(a, b, c);

		//Extreme Value
		extremeValue(a, b, c, axisOfSymmetry(a, b, c));

		//Min or max
		maxOrMin(a);

		//Print 3
		System.out.println("3. The extreme value of the function is a " + maxOrMin(a) + " and is at f(" + 
				decimal.format(axisOfSymmetry(a, b, c)) + ")=" + decimal.format(extremeValue(a, b, c, axisOfSymmetry(a, b, c))));

		//Evaluate at a value
		System.out.println("Enter what you would like the function to be evaluated at.");
		double f = scan.nextDouble();

		System.out.println("f(" + f + ")=" + decimal.format(fOf(a, b, c, f)));
	}

	public static boolean realRoots(double discriminant) {
		return discriminant > 0; 
	}

	public static int numberOfRoots(double discriminant) {
		if (discriminant == 0) {
			return 1;	
		} else if (discriminant > 0) { 
			return 2;
		} 
		return 0;
	}

	public static double[] zeros(double g, double h, double i) {
		double[] roots = new double [2];

		double root1 = ((-h + Math.sqrt(h*h - 4*g*i))/2*g);
		double root2 = ((-h - Math.sqrt(h*h - 4*g*i))/2*g);

		roots[0] = root1;
		roots[1] = root2;

		return roots;		
	}

	public static double axisOfSymmetry(double g, double h, double i) {
		double axis = -h/(2*g);
		return axis;	
	}

	public static double extremeValue(double g, double h, double i, double xval) {
		double extreme = g*xval*xval + h*xval +i;
		return extreme;
	}

	public static String maxOrMin(double g){
		if (g > 0) { 
			return "min";
		} else {
			return "max";
		}
	}

	public static double fOf(double g, double h, double i, double x){
		double answer = g*x*x + h*x + i;
		return answer;
	}
}
