package experiment;

import java.util.ArrayList;

import indoor_entitity.Point;

public class Query {

	public Point ps;
	public Point pt;
	public ArrayList<String> q_word;
	public double timeMax;
	public double relThreshold;
	public int k;

	// the last one is one of the following
	public double timeMaxNew;
	public Point psNew = null;
	public Point ptNew = null;

	public Query(String[] tempArr) {
		// TODO Auto-generated constructor stub
		read(tempArr);
	}

	public Query() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "(" + ps.getX() + "," + ps.getY() + "," + ps.getmFloor() //
				+ "), (" + pt.getX() + "," + pt.getY() + "," + pt.getmFloor() //
				+ ") " + q_word + ", timeMax=" + timeMax + ", threshold=" + relThreshold + ""
				+ ", k=" + k + ", timeMaxNew=" + timeMaxNew;
	}

	/**
	 * Output to text file
	 * 
	 * @return format in each row: psx psy psf ptx pty ptf querySize w1 w2 .. w5
	 *         timeMax threshold k
	 * 
	 */
	public String print() {
		// TODO Auto-generated method stub
		String result = "";
		result += ps.getX() + " " + ps.getY() + " " + ps.getmFloor() + " ";
		result += pt.getX() + " " + pt.getY() + " " + pt.getmFloor() + " ";
		result += q_word.size() + " ";
		for (String s : q_word)
			result += s + " ";
		result += timeMax + " ";
		result += relThreshold + " ";
		result += k + " ";

		result += timeMaxNew + " ";

		if (psNew != null)
			result += psNew.getX() + " " + psNew.getY() + " " + psNew.getmFloor() + " ";
		if (ptNew != null)
			result += ptNew.getX() + " " + ptNew.getY() + " " + ptNew.getmFloor() + " ";

		return result;
	}

	public void read(String[] a) {
		int i = 0;
		double psx = Double.parseDouble(a[i++]);
		double psy = Double.parseDouble(a[i++]);
		int psf = Integer.parseInt(a[i++]);
		ps = new Point(psx, psy, psf);

		double ptx = Double.parseDouble(a[i++]);
		double pty = Double.parseDouble(a[i++]);
		int ptf = Integer.parseInt(a[i++]);
		pt = new Point(ptx, pty, ptf);

		int q_size = Integer.parseInt(a[i++]);
		q_word = new ArrayList<>();
		for (int j = 0; j < q_size; j++) {
			q_word.add(a[i++]);
		}

		timeMax = Double.parseDouble(a[i++]);
		relThreshold = Double.parseDouble(a[i++]);
		k = Integer.parseInt(a[i++]);

		// --------
		// the same i has multi-purpose
		if (i <= a.length - 1) {
			timeMaxNew = Double.parseDouble(a[i++]);
			// psNew or ptNew
			if (i <= a.length - 1) {
				double psxNew = Double.parseDouble(a[i++]);
				double psyNew = Double.parseDouble(a[i++]);
				int psfNew = Integer.parseInt(a[i++]);
				psNew = new Point(psxNew, psyNew, psfNew);
				if (i <= a.length - 1) {

					double ptxNew = Double.parseDouble(a[i++]);
					double ptyNew = Double.parseDouble(a[i++]);
					int ptfNew = Integer.parseInt(a[i++]);
					ptNew = new Point(ptxNew, ptyNew, ptfNew);
				}
			}
		}
		// ----------

		System.out.println(print());
	}

}
